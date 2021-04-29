# MyBatis最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、MyBatis框架适用场合：

**1、** MyBatis专注于SQL本身，是一个足够灵活的DAO层解决方案；

**2、** 对性能的要求很高，或者需求变化较多的项目，如互联网项目，MyBatis将是不错的选择。


### 2、MyBatis框架的缺点：

**1、** SQL语句的编写工作量较大，尤其当字段多、关联表多时，对开发人员编写SQL语句的功底有一定要求。

**2、** SQL语句依赖于数据库，导致数据库移植性差，不能随意更换数据库。


### 3、Mybatis的一级缓存和二级缓存？

**1、** 一级缓存 Mybatis的一级缓存是指SQLSession，一级缓存的作用域是SQlSession, Mabits默认开启一级缓存。 在同一个SqlSession中，执行相同的SQL查询时；第一次会去查询数据库，并写在缓存中，第二次会直接从缓存中取。 当执行SQL时候两次查询中间发生了增删改的操作，则SQLSession的缓存会被清空。 每次查询会先去缓存中找，如果找不到，再去数据库查询，然后把结果写到缓存中。 Mybatis的内部缓存使用一个HashMap，key为hashcode+statementId+sql语句。Value为查询出来的结果集映射成的java对象。 SqlSession执行insert、update、delete等操作commit后会清空该SQLSession缓存。

**2、** 二级缓存 二级缓存是mapper级别的，Mybatis默认是没有开启二级缓存的。 第一次调用mapper下的SQL去查询用户的信息，查询到的信息会存放代该mapper对应的二级缓存区域。 第二次调用namespace下的mapper映射文件中，相同的sql去查询用户信息，会去对应的二级缓存内取结果。 如果调用相同namespace下的mapepr映射文件中增删改sql，并执行了commit操作，此时会情况该


### 4、IBatis 和 MyBatis 在细节上的不同有哪些？

**1、** 在 sql 里面变量命名有原来的#变量# 变成了#{变量}

**2、** 原来的$$变量$$变成了${变量}

**3、** 原来在 sql 节点里面的 class 都换名字交 type

**4、** 原来的 queryForObject queryForList 变成了 selectOne selectList5、原来的别名设置在映


### 5、Mybatis的编程步骤是什么样的？

首先创建Sql Session Factory；第二通过Sql Session Factory创建Sql Session；第三通过sqlsession执行数据库操作；其次调用session.commit()提交事务最后；调用session.close()关闭会话。


### 6、Mybatis 分页查询？

Mybatis本身有分页查询，但是并不是正真的分页查询，它是把数据查出来放在内存里面，你想要什么就给你什么。 我们使用Mybatis实现分页查询的时候，是要实现真分页查询，就是要用sql语句来实现分页查询。MySQL和Oracle两种数据库的实现方法是不一样的。 MySQL：select * from table limit N , M; 其中：N表示从第几页开始，M表示每页显示的条数。比如：数据库中有30条数据，要求每页显示10条，显示第2页的所有数据。 SQL语句就可以写成：Limit 10 , 20; Oracle实现分页查询：采用伪列ROWNUM


### 7、如何获取生成的主键

**新增标签中添加：keyProperty=" ID " 即可**

```
<insert id="insert" useGeneratedKeys="true" keyProperty="userId" >
    insert into user( 
    user_name, user_password, create_time) 
    values(#{userName},{userPassword} ,{createTime, jdbcType= TIMESTAMP})
</insert>
```

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/041/14/55_4.png#alt=55%5C_4.png)


### 8、#{}和${}的区别是什么？

**1、** #{}是预编译处理，${}是字符串替换。

**2、** Mybatis 在处理#{}时，会将 sql 中的#{}替换为?号，调用 PreparedStatement 的 set 方法

来赋值；

**3、** Mybatis 在处理$${}时，就是把$${}替换成变量的值。

**4、** 使用#{}可以有效的防止 SQL 注入，提高系统安全性。


### 9、Mybatis 是如何将 sql 执行结果封装为目标对象并返回的？都有哪些映射形式？

第一种是使用标签，逐一定义列名和对象属性名之间的映射关系。

第二种是使用 sql 列的别名功能，将列别名书写为对象属性名，比如 T_NAME AS NAME，对

象属性名一般是 name，小写，但是列名不区分大小写，Mybatis 会忽略列名大小写，智能

找到与之对应对象属性名，你甚至可以写成 T_NAME AS NaMe，Mybatis 一样可以正常工

作。

有了列名与属性名的映射关系后，Mybatis 通过反射创建对象，同时使用反射给对象的属性

逐一赋值并返回，那些找不到映射关系的属性，是无法完成赋值的。


### 10、MyBatis框架适用场合：

**1、** MyBatis专注于SQL本身，是一个足够灵活的DAO层解决方案。

**2、** 对性能的要求很高，或者需求变化较多的项目，如互联网项目，MyBatis将是不错的选择。


### 11、MyBatis与Hibernate有哪些不同？
### 12、MyBatis 实现一对一有几种方式?具体怎么操作的？
### 13、Mybaits的优点有什么？
### 14、Mybatis是否可以映射Enum枚举类？
### 15、Mybatis是如何进行分页的？分页插件的原理是什么？
### 16、使用MyBatis的mapper接口调用时有哪些要求？
### 17、Mybatis 能执行一对一、一对多的关联查询吗？都有哪些实现方式，以及它们之间的区
### 18、{}里面的名称对应的是Map里面的key名称。
### 19、MyBatis是什么？
### 20、在mapper中如何传递多个参数
### 21、什么是Mybatis？
### 22、Mybatis是如何将sql执行结果封装为目标对象并返回的？都有哪些映射形式？
### 23、模糊查询 like 语句该怎么写
### 24、Mapper编写有哪几种方式？
### 25、Mybatis 都有哪些 Executor 执行器？它们之间的区别是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
