# MyBatis最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Mybatis与Spring 的整合？

**1、** Spring Spring是一个轻量级控制反转(IOC)和面向切面(AOP)的容器框架；AOP和IOC是Spring框架重要的两个模块；控制反转就是改变对象的创建方式，将对象的创建和维护有开发人员创建改为由容器帮我们完成创建和维护。

**2、** Mybatis是支持SQL查询，存储过程和高级映射的优秀持久成框架。Mybatis几乎是消除了使用JDBC存在的重复创建和关闭连接，以及结果集查询的问题。它使用简单的xml或者注解用于配置和映射，将java的POjOs映射成数据库中的记录。

**3、** 整合，涉及的常用包： ![](https://atts.w3cschool.cn/attachments/image/20171124/1511515685952292.png#alt=)


### 2、当实体类中的属性名和表中的字段名不一样 ，怎么办 ？

第1种： 通过在查询的sql语句中定义字段名的别名，让字段名的别名和实体类的属性名一致。

```
<select id=”selectorder” parametertype=”int” resultetype=”me.gacl.domain.order”>
       select order_id id, order_no orderno ,order_price price form orders where order_id=#{id};
</select>
```

第2种： 通过`<resultMap>`来映射字段名和实体类属性名的一一对应的关系。

```
<select id="getOrder" parameterType="int" resultMap="orderresultmap">
select * from orders where order_id=#{id}
</select>

<resultMap type=”me.gacl.domain.order” id=”orderresultmap”>
    <!–用id属性来映射主键字段–>
    <id property=”id” column=”order_id”>

    <!–用result属性来映射非主键字段，property为实体类属性名，column为数据表中的属性–>
    <result property = “orderno” column =”order_no”/>
    <result property=”price” column=”order_price” />
</reslutMap>
```


### 3、Mybatis的编程步骤是什么样的？

首先创建Sql Session Factory；第二通过Sql Session Factory创建Sql Session；第三通过sqlsession执行数据库操作；其次调用session.commit()提交事务最后；调用session.close()关闭会话。


### 4、MyBatis框架的缺点有什么？

**1、** SQL语句的编写工作量较大，尤其当字段多、关联表多时，对开发人员编写SQL语句的功底有一定要求；

**2、** SQL语句依赖于数据库，导致数据库移植性差，不能随意更换数据库。


### 5、Mybatis 能执行一对一、一对多的关联查询吗？都有哪些实现方式，以及它们之间的区

别？

能，Mybatis 不仅可以执行一对一、一对多的关联查询，还可以执行多对一，多对多的

关联查询，多对一查询，其实就是一对一查询，只需要把 selectOne()修改为 selectList()即

可；多对多查询，其实就是一对多查询，只需要把 selectOne()修改为 selectList()即可。

关联对象查询，有两种实现方式，一种是单独发送一个 sql 去查询关联对象，赋给主对

象，然后返回主对象。另一种是使用嵌套查询，嵌套查询的含义为使用 join 查询，一部分

列是 A 对象的属性值，另外一部分列是关联对象 B 的属性值，好处是只发一个 sql 查询，

就可以把主对象和其关联对象查出来。


### 6、模糊查询 like 语句该怎么写

**1、** 在 java 中拼接通配符，通过#{}赋值

**2、** 在 Sql 语句中拼接通配符 （不安全 会引起 Sql 注入、


### 7、Mybatis是如何将sql执行结果封装为目标对象并返回的？都有哪些映射形式？

第一种是使用`<resultMap>`标签，逐一定义列名和对象属性名之间的映射关系。

第二种是使用sql列的别名功能，将列别名书写为对象属性名，比如T_NAME AS NAME，对象属性名一般是name，小写，但是列名不区分大小写，Mybatis会忽略列名大小写，智能找到与之对应对象属性名，你甚至可以写成T_NAME AS NaMe，Mybatis一样可以正常工作。

`有了列名与属性名的映射关系后，Mybatis通过反射创建对象，同时使用反射给对象的属性逐一赋值并返回，那些找不到映射关系的属性，是无法完成赋值的。`


### 8、Mapper 编写有几种方式 ？

**1、** 接口实现类集成`SQLSessionDaoSupport`** 此方法需要编写`mapper`接口，`mapper`接口的实现类,`mapper.xml`文件。

**2、** 使用`org.mybatis.spring.mapper.MapperFactoryBean`** 此方法需要在`SqlMapConfig.xml`中配置`mapper.xml`的位置，还需定义`mapper`接口。

**3、** 使用`mapper`扫描器** 需要编写`mapper.xml`文件，需要`mapper`接口，配置`mapper`扫描器，使用扫描器从`spring`容器中获取`mapper`的实现对象。


### 9、在mapper中如何传递多个参数

**方法1：顺序传参法**

```
public User selectUser(String name, int deptId);

<select id="selectUser" resultMap="UserResultMap">
select * from user
where user_name ={0} and dept_id ={1}
</select>
```

**1、** #{}里面的数字代表传入参数的顺序。

**2、** 这种方法不建议使用，sql层表达不直观，且一旦顺序调整容易出错。

**方法2：@Param注解传参法**

```
public User selectUser(@Param("userName") String name, int @Param("deptId") deptId);

<select id="selectUser" resultMap="UserResultMap">
select * from user
where user_name ={userName} and dept_id ={deptId}
</select>
```

**1、** #{}里面的名称对应的是注解@Param括号里面修饰的名称。

**2、** 这种方法在参数不多的情况还是比较直观的，（推荐使用）

**方法3：Map传参法**

```
public User selectUser(Map<String, Object> params);

<select id="selectUser" parameterType="java.util.Map" resultMap="UserResultMap">
select * from user
where user_name ={userName} and dept_id ={deptId}
</select>
```


### 10、IBatis 和 MyBatis 在细节上的不同有哪些？

**1、** 在 sql 里面变量命名有原来的#变量# 变成了#{变量}

**2、** 原来的$$变量$$变成了${变量}

**3、** 原来在 sql 节点里面的 class 都换名字交 type

**4、** 原来的 queryForObject queryForList 变成了 selectOne selectList5、原来的别名设置在映


### 11、传统JDBC开发存在什么问题？
### 12、如何执行批量插入?
### 13、为什么说Mybatis是半自动ORM映射工具？它与全自动的区别在哪里？
### 14、MyBatis与hibernate有哪些不同？
### 15、通常一个 Xml 映射文件，都会写一个 Dao 接口与之对应, Dao 的工作原理，是否可以重
### 16、MyBatis框架的缺点：
### 17、讲下 MyBatis 的缓存
### 18、模糊查询like语句该怎么写?
### 19、接口绑定有几种实现方式,分别是怎么实现的?
### 20、Mybatis 中如何指定使用哪一种 Executor 执行器？
### 21、MyBatis与Hibernate有哪些不同？
### 22、Mybatis是否可以映射Enum枚举类？
### 23、使用MyBatis的mapper接口调用时有哪些要求？
### 24、Mybatis是如何将sql执行结果封装为目标对象并返回的？都有哪些映射形式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
