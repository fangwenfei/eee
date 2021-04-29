# MyBatis最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、#{}和${}的区别是什么？

Mybatis在处理#{}时，会将sql中的#{}替换为?号，调用Prepared Statement的set方法来赋值；Mybatis在处理$${}时，就是把$${}替换成变量的值；使用#{}可以有效的防止SQL注入，提高系统安全性。


### 2、在mapper中如何传递多个参数?

**1、** 第一种：

**DAO层的函数**

```java
public UserselectUser(String name,String area);
        对应的xml,#{0}代表接收的是dao层中的第一个参数，#{1}代表dao层中第二参数，更多参数一致往后加即可。
```

```xml
<select id="selectUser"resultMap="BaseResultMap">
    select *  fromuser_user_t   whereuser_name = #{0} anduser_area=#{1}
</select>
```

**2、** 第二种： 使用 [@param ](/param ) 注解:

```java
public interface usermapper {
    user selectuser(@param(“username”) string username,@param(“hashedpassword”) string hashedpassword);
}
```

然后,就可以在xml像下面这样使用(推荐封装为一个map,作为单个参数传递给mapper):

```xml
<select id=”selectuser” resulttype=”user”>
        select id, username, hashedpassword
        from some_table
        where username = #{username}
        and hashedpassword = #{hashedpassword}
        </select>
```

**3、** 第三种：多个参数封装成map

```java
try {
        //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        //由于我们的参数超过了两个，而方法中只有一个Object参数收集，因此我们使用Map集合来装载我们的参数
        Map < String, Object > map = new HashMap();
        map.put("start", start);
        map.put("end", end);
        return sqlSession.selectList("StudentID.pagination", map);
        } catch (Exception e) {
        e.printStackTrace();
        sqlSession.rollback();
        throw e;
        } finally {
        MybatisUtil.closeSqlSession();
        }
```


### 3、Mybatis的一级、二级缓存:

1）一级缓存: 基于 PerpetualCache 的 HashMap 本地缓存，其存储作用域为 Session，当 Session flush 或 close 之后，该 Session 中的所有 Cache 就将清空，默认打开一级缓存。

2）二级缓存与一级缓存其机制相同，默认也是采用 PerpetualCache，HashMap 存储，不同在于其存储作用域为 Mapper(Namespace)，并且可自定义存储源，如 Ehcache。默认不打开二级缓存，要开启二级缓存，使用二级缓存属性类需要实现Serializable序列化接口(可用来保存对象的状态),可在它的映射文件中配置`<cache/>` ；

3）对于缓存数据更新机制，当某一个作用域(一级缓存 Session/二级缓存Namespaces)的进行了C/U/D 操作后，默认该作用域下所有 select 中的缓存将被 clear。


### 4、Mybatis如何执行批量操作

**使用foreach标签**

foreach的主要用在构建in条件中，它可以在SQL语句中进行迭代一个集合。foreach标签的属性主要有item，index，collection，open，separator，close。

**1、** item   表示集合中每一个元素进行迭代时的别名，随便起的变量名；

**2、** index   指定一个名字，用于表示在迭代过程中，每次迭代到的位置，不常用；

**3、** open   表示该语句以什么开始，常用“(”；

**4、** separator 表示在每次进行迭代之间以什么符号作为分隔符，常用“,”；

**5、** close   表示以什么结束，常用“)”。

在使用foreach的时候最关键的也是最容易出错的就是collection属性，该属性是必须指定的，但是在不同情况下，该属性的值是不一样的，主要有一下3种情况：

**1、** 如果传入的是单参数且参数类型是一个List的时候，collection属性值为list

**2、** 如果传入的是单参数且参数类型是一个array数组的时候，collection的属性值为array

**3、** 如果传入的参数是多个的时候，我们就需要把它们封装成一个Map了，当然单参数也可以封装成map，实际上如果你在传入参数的时候，在MyBatis里面也是会把它封装成一个Map的，

map的key就是参数名，所以这个时候collection属性值就是传入的List或array对象在自己封装的map里面的key

**具体用法如下：**

```
<!-- 批量保存(foreach插入多条数据两种方法)
   int addEmpsBatch(@Param("emps") List<Employee> emps); -->
<!-- MySQL下批量保存，可以foreach遍历 MySQL支持values(),(),()语法 --> //推荐使用

<insert id="addEmpsBatch">
INSERT INTO emp(ename,gender,email,did)
VALUES
<foreach collection="emps" item="emp" separator=",">
    (#{emp.eName},#{emp.gender},#{emp.email},#{emp.dept.id})
</foreach>
</insert>
```

```
<!-- 这种方式需要数据库连接属性allowMutiQueries=true的支持
如jdbc.url=jdbc:MySQL://localhost:3306/mybatis?allowMultiQueries=true -->  

<insert id="addEmpsBatch">
<foreach collection="emps" item="emp" separator=";">                                 
    INSERT INTO emp(ename,gender,email,did)
    VALUES(#{emp.eName},#{emp.gender},#{emp.email},#{emp.dept.id})
</foreach>
</insert>
```

**使用ExecutorType.BATCH**

Mybatis内置的ExecutorType有3种，默认为simple,该模式下它为每个语句的执行创建一个新的预处理语句，单条提交sql；而batch模式重复使用已经预处理的语句，并且批量执行所有更新语句，显然batch性能将更优； 但batch模式也有自己的问题，比如在Insert操作时，在事务没有提交之前，是没有办法获取到自增的id，这在某型情形下是不符合业务要求的

**具体用法如下：**

```
//批量保存方法测试
@Test  
public void testBatch() throws IOException{
    SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    //可以执行批量操作的sqlSession
    SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);

    //批量保存执行前时间
    long start = System.currentTimeMillis();
    try {
        EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            mapper.addEmp(new Employee(UUID.randomUUID().toString().substring(0, 5), "b", "1"));
        }

        openSession.commit();
        long end = System.currentTimeMillis();
        //批量保存执行后的时间
        System.out.println("执行时长" + (end - start));
        //批量 预编译sql一次==》设置参数==》10000次==》执行1次   677
        //非批量  （预编译=设置参数=执行 ）==》10000次   1121

    } finally {
        openSession.close();
    }
}
```

**mapper和mapper.xml如下**

```
    public interface EmployeeMapper {   
        //批量保存员工
        Long addEmp(Employee employee);
    }
```

```
    <mapper namespace="com.jourwon.mapper.EmployeeMapper"
         <!--批量保存员工 -->
        <insert id="addEmp">
            insert into employee(lastName,email,gender)
            values(#{lastName},#{email},#{gender})
        </insert>
    </mapper>
```


### 5、MyBatis的功能架构是怎样的

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/041/14/55_2.png#alt=55%5C_2.png)

**我们把Mybatis的功能架构分为三层：**

**1、** API接口层：提供给外部使用的接口API，开发人员通过这些本地API来操纵数据库。接口层一接收到调用请求就会调用数据处理层来完成具体的数据处理。

**2、** 数据处理层：负责具体的SQL查找、SQL解析、SQL执行和执行结果映射处理等。它主要的目的是根据调用的请求完成一次数据库操作。

**3、** 基础支撑层：负责最基础的功能支撑，包括连接管理、事务管理、配置加载和缓存处理，这些都是共用的东西，将他们抽取出来作为最基础的组件。为上层的数据处理层提供最基础的支撑。


### 6、请说说MyBatis的工作原理

在学习 MyBatis 程序之前，需要了解一下 MyBatis 工作原理，以便于理解程序。MyBatis 的工作原理如下图 ![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/041/14/55_1.png#alt=55%5C_1.png)

**1、** 读取 MyBatis 配置文件：mybatis-config.xml 为 MyBatis 的全局配置文件，配置了 MyBatis 的运行环境等信息，例如数据库连接信息。

**2、** 加载映射文件。映射文件即 SQL 映射文件，该文件中配置了操作数据库的 SQL 语句，需要在 MyBatis 配置文件 mybatis-config.xml 中加载。mybatis-config.xml 文件可以加载多个映射文件，每个文件对应数据库中的一张表。

**3、** 构造会话工厂：通过 MyBatis 的环境等配置信息构建会话工厂 SqlSessionFactory。

**4、** 创建会话对象：由会话工厂创建 SqlSession 对象，该对象中包含了执行 SQL 语句的所有方法。

**5、** Executor 执行器：MyBatis 底层定义了一个 Executor 接口来操作数据库，它将根据 SqlSession 传递的参数动态地生成需要执行的 SQL 语句，同时负责查询缓存的维护。

**6、** MappedStatement 对象：在 Executor 接口的执行方法中有一个 MappedStatement 类型的参数，该参数是对映射信息的封装，用于存储要映射的 SQL 语句的 id、参数等信息。

**7、** 输入参数映射：输入参数类型可以是 Map、List 等集合类型，也可以是基本数据类型和 POJO 类型。输入参数映射过程类似于 JDBC 对 preparedStatement 对象设置参数的过程。

**8、** 输出结果映射：输出结果类型可以是 Map、 List 等集合类型，也可以是基本数据类型和 POJO 类型。输出结果映射过程类似于 JDBC 对结果集的解析过程。


### 7、当实体类中的属性名和表中的字段名不一样 ，怎么办

第1种： 通过在查询的SQL语句中定义字段名的别名，让字段名的别名和实体类的属性名一致。

```
<select id="getOrder" parameterType="int" resultType="com.jourwon.pojo.Order">
       select order_id id, order_no orderno ,order_price price form orders where order_id=#{id};
</select>
```

第2种： 通过`<resultMap>`来映射字段名和实体类属性名的一一对应的关系。

```
<select id="getOrder" parameterType="int" resultMap="orderResultMap">
    select * from orders where order_id=#{id}
</select>
    
<resultMap type="com.jourwon.pojo.Order" id="orderResultMap">
    <!–用id属性来映射主键字段–>
    <id property="id" column="order_id">
    
    <!–用result属性来映射非主键字段，property为实体类属性名，column为数据库表中的属性–>
    <result property ="orderno" column ="order_no"/>
    <result property="price" column="order_price" />
</reslutMap>
```


### 8、Xml映射文件中，除了常见的select|insert|updae|delete标签之外，还有哪些标签？

还有很多其他的标签，`<resultMap>`、`<parameterMap>`、`<sql>`、`<include>`、`<selectKey>`，加上动态sql的9个标签，trim|where|set|foreach|if|choose|when|otherwise|bind等，其中`<sql>`为sql片段标签，通过`<include>`标签引入sql片段，`<selectKey>`为不支持自增的主键生成策略标签。


### 9、Mybatis中如何指定使用哪一种Executor执行器？

在Mybatis配置文件中，在设置（settings）可以指定默认的ExecutorType执行器类型，也可以手动给DefaultSqlSessionFactory的创建SqlSession的方法传递ExecutorType类型参数，如SqlSession openSession(ExecutorType execType)。

配置默认的执行器。SIMPLE 就是普通的执行器；REUSE 执行器会重用预处理语句（prepared statements）； BATCH 执行器将重用语句并执行批量更新。


### 10、如何获取自动生成的(主)键值？

配置文件设置 usegeneratedkeys 为 true


### 11、MyBatis与Hibernate有哪些不同？
### 12、Mybatis映射文件中，如果A标签通过include引用了B标签的内容
### 13、通常一个 Xml 映射文件，都会写一个 Dao 接口与之对应, Dao 的工作原理，是否可以重
### 14、Mybatis的一级、二级缓存
### 15、IBatis 和 MyBatis 在核心处理类分别叫什么？
### 16、Mybatis编程步骤 ？
### 17、模糊查询like语句该怎么写
### 18、什么是Mybatis？
### 19、Mybatis是否支持延迟加载？如果支持，它的实现原理是什么？
### 20、Mapper 编写有几种方式 ？
### 21、MyBatis和Hibernate的适用场景?
### 22、MyBatis 里面的动态 Sql 是怎么设定的?用什么语法?
### 23、Mybatis能执行一对多，一对一的联系查询吗，有哪些实现方法
### 24、什么情况下用注解绑定,什么情况下用 xml 绑定？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
