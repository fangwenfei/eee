# MyBatis最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、在mapper中如何传递多个参数?

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


### 2、JDBC编程有哪些不足之处，MyBatis是如何解决这些问题的？

**1、** 数据库链接创建、释放频繁造成系统资源浪费从而影响系统性能，使用数据库链接池可解决此问题。解决：在SqlMapConfig.xml中配置数据链接池，使用连接池管理数据库链接。

**2、** Sql语句写在代码中造成代码不易维护，实际应用sql变化的可能较大，sql变动需要改变java代码。解决：将Sql语句配置在XXXXmapper.xml文件中与java代码分离。

**3、** 向sql语句传参数麻烦，因为sql语句的where条件不一定，可能多也可能少，占位符需要和参数一一对应。解决： Mybatis 自动将 java 对象映射至 sql 语句。

**4、** 对结果集解析麻烦，sql 变化导致解析代码变化，且解析前需要遍历，如果能将数据库记录封装成 pojo对象解析比较方便。解决：Mybatis 自动将 sql 执行结果映射至java对象。


### 3、Mybais 常用注解 ？

[@Insert ](/Insert ) ： 插入sql , 和xml insert sql语法完全一样

[@Select ](/Select ) ： 查询sql, 和xml select sql语法完全一样

[@Update ](/Update ) ： 更新sql, 和xml update sql语法完全一样

[@Delete ](/Delete ) ： 删除sql, 和xml delete sql语法完全一样

[@Param ](/Param ) ： 入参

[@Results ](/Results ) ：结果集合

[@Result ](/Result ) ： 结果


### 4、MyBatis框架适用场合：

**1、** MyBatis专注于SQL本身，是一个足够灵活的DAO层解决方案；

**2、** 对性能的要求很高，或者需求变化较多的项目，如互联网项目，MyBatis将是不错的选择。


### 5、Mybatis如何执行批量操作

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


### 6、{}里面的名称对应的是Map里面的key名称。

这种方法适合传递多个参数，且参数易变能灵活传递的情况。（推荐使用）。

**方法4：Java Bean传参法**

```
public User selectUser(User user);

<select id="selectUser" parameterType="com.jourwon.pojo.User" resultMap="UserResultMap">
select * from user
where user_name ={userName} and dept_id ={deptId}
</select>
```

**1、** #{}里面的名称对应的是User类里面的成员属性。

**2、** 这种方法直观，需要建一个实体类，扩展不容易，需要加属性，但代码可读性强，业务逻辑处理方便，推荐使用。（推荐使用）。


### 7、Mybatis的表关联的映射？

**1、** 一对一关联 Property: 对象属性名称 javaType: 对象属性的类型 column: 所对应的外键字段的名称 select: 使用另一个查询封装的结果

**2、** 一对多关联

**3、** 多对多关联


### 8、Mybatis是否可以映射Enum枚举类？

Mybatis可以映射枚举类，不单可以映射枚举类，Mybatis可以映射任何对象到表的一列上。映射方式为自定义一个TypeHandler，实现TypeHandler的setParameter()和getResult()接口方法。

TypeHandler有两个作用，一是完成从javaType至jdbcType的转换，二是完成jdbcType至javaType的转换，体现为setParameter()和getResult()两个方法，分别代表设置sql问号占位符参数和获取列查询结果。


### 9、为什么说Mybatis是半自动ORM映射工具？它与全自动的区别在哪里？

Hibernate属于全自动ORM映射工具，使用Hibernate查询关联对象或者关联集合对象时，可以根据对象关系模型直接获取，所以它是全自动的。

而Mybatis在查询关联对象或关联集合对象时，需要手动编写sql来完成，所以，称之为半自动ORM映射工具。


### 10、MyBatis实现一对多有几种方式,怎么操作的？

有联合查询和嵌套查询。联合查询是几个表联合查询,只查询一次,通过在resultMap里面的collection节点配置一对多的类就可以完成；嵌套查询是先查一个表,根据这个表里面的 结果的外键id,去再另外一个表里面查询数据,也是通过配置collection,但另外一个表的查询通过select节点配置。


### 11、使用MyBatis的mapper接口调用时有哪些要求？
### 12、Mybatis是如何将sql执行结果封装为目标对象并返回的？都有哪些映射形式？
### 13、什么是 MyBatis？
### 14、MyBatis框架适用场合：
### 15、使用 MyBatis 的 mapper 接口调用时有哪些要求？
### 16、Mybatis 执行批量插入，能返回数据库主键列表吗？
### 17、Mybatis动态sql有什么用？执行原理？有哪些动态sql？
### 18、模糊查询like语句该怎么写
### 19、ORM是什么
### 20、为什么需要预编译
### 21、在mapper中如何传递多个参数
### 22、MyBatis和Hibernate的适用场景?
### 23、#{}和${}的区别是什么？
### 24、一对一、一对多的关联查询 ？
### 25、Mybatis 是如何将 sql 执行结果封装为目标对象并返回的？都有哪些映射形式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
