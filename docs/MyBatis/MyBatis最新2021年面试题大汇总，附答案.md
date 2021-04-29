# MyBatis最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、MyBatis编程步骤是什么样的？

**1、** 创建SqlSessionFactory

**2、** 通过SqlSessionFactory创建SqlSession

**3、** 通过sqlsession执行数据库操作

**4、** 调用session.commit()提交事务

**5、** 调用session.close()关闭会话


### 2、如何获取生成的主键

**新增标签中添加：keyProperty=" ID " 即可**

```
<insert id="insert" useGeneratedKeys="true" keyProperty="userId" >
    insert into user( 
    user_name, user_password, create_time) 
    values(#{userName},{userPassword} ,{createTime, jdbcType= TIMESTAMP})
</insert>
```

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/041/14/55_4.png#alt=55%5C_4.png)


### 3、Mybatis 分页查询？

Mybatis本身有分页查询，但是并不是正真的分页查询，它是把数据查出来放在内存里面，你想要什么就给你什么。 我们使用Mybatis实现分页查询的时候，是要实现真分页查询，就是要用sql语句来实现分页查询。MySQL和Oracle两种数据库的实现方法是不一样的。 MySQL：select * from table limit N , M; 其中：N表示从第几页开始，M表示每页显示的条数。比如：数据库中有30条数据，要求每页显示10条，显示第2页的所有数据。 SQL语句就可以写成：Limit 10 , 20; Oracle实现分页查询：采用伪列ROWNUM


### 4、使用Mybatis的mapper接口调用时候有哪些要求？

**1、** Mapper接口方法名和Mapper.xml中定义的每个SQL的id相同；

**2、** Mapper接口方法的输入参数类型和mapper.xml中定义的每个sqlparameterType类型相同

**3、** Mapper接口方法的输入输出参数类型和mapper.xml中定义的每个sql的resultType的类型相同

**4、** Mapper.xml文件中的namespace，就是接口的类路径。


### 5、什么是Mybatis？

**1、** Mybatis是一个半ORM（对象关系映射）框架，它内部封装了JDBC，开发时只需要关注SQL语句本身，不需要花费精力去处理加载驱动、创建连接、创建statement等繁杂的过程；

**2、** MyBatis 可以使用 XML 或注解来配置和映射原生信息，将 POJO映射成数据库中的记录，避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集；

**3、** 通过xml 文件或注解的方式将要执行的各种 statement 配置起来，并通过java对象和 statement中[MySQL](https://www.wkcto.com/courses/MySQL.html)的动态参数进行映射生成最终执行的sql语句，最后由mybatis框架执行sql并将结果映射为java对象并返回。


### 6、传统JDBC开发存在什么问题？

**1、** 频繁创建数据库连接对象、释放，容易造成系统资源浪费，影响系统性能。可以使用连接池解决这个问题。但是使用jdbc需要自己实现连接池。

**2、** sql语句定义、参数设置、结果集处理存在硬编码。实际项目中sql语句变化的可能性较大，一旦发生变化，需要修改java代码，系统需要重新编译，重新发布。不好维护。

**3、** 使用preparedStatement向占有位符号传参数存在硬编码，因为sql语句的where条件不一定，可能多也可能少，修改sql还要修改代码，系统不易维护。

**4、** 结果集处理存在重复代码，处理麻烦。如果可以映射成Java对象会比较方便。


### 7、模糊查询 like 语句该怎么写

**1、** 在 java 中拼接通配符，通过#{}赋值

**2、** 在 Sql 语句中拼接通配符 （不安全 会引起 Sql 注入、


### 8、Xml 映射文件中，除了常见的 select|insert|updae|delete 标签之外，还有哪些标签？
### 9、在mapper中如何传递多个参数?
### 10、Mybatis的编程步骤是什么样的？
### 11、resultType resultMap 的区别？
### 12、Mapper 编写有几种方式 ？
### 13、Mybatis 能执行一对一、一对多的关联查询吗？都有哪些实现方式，以及它们之间的区
### 14、Mybatis能执行一对多，一对一的联系查询吗，有哪些实现方法
### 15、通常一个Xml映射文件，都会写一个Dao接口与之对应
### 16、使用MyBatis的mapper接口调用时有哪些要求？
### 17、Mybatis 是如何进行分页的？分页插件的原理是什么？
### 18、模糊查询like语句该怎么写?
### 19、如何执行批量插入?
### 20、请说说MyBatis的工作原理
### 21、MyBatis 实现一对一有几种方式?具体怎么操作的？
### 22、#{}和${}的区别是什么？
### 23、Mybatis的Xml映射文件中，不同的Xml映射文件，id是否可以重复？
### 24、Mybatis优缺点
### 25、MyBatis实现一对一有几种方式?具体怎么操作的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
