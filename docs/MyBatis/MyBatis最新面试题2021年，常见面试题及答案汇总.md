# MyBatis最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Hibernate 和 MyBatis 的区别

**相同点**

都是对jdbc的封装，都是持久层的框架，都用于dao层的开发。

**不同点**

映射关系

MyBatis 是一个半自动映射的框架，配置Java对象与sql语句执行结果的对应关系，多表关联关系配置简单

Hibernate 是一个全表映射的框架，配置Java对象与数据库表的对应关系，多表关联关系配置复杂

**SQL优化和移植性**

Hibernate 对SQL语句封装，提供了日志、缓存、级联（级联比 MyBatis 强大）等特性，此外还提供 HQL（Hibernate Query Language）操作数据库，数据库无关性支持好，但会多消耗性能。如果项目需要支持多种数据库，代码开发量少，但SQL语句优化困难。

MyBatis 需要手动编写 SQL，支持动态 SQL、处理列表、动态生成表名、支持存储过程。开发工作量相对大些。直接使用SQL语句操作数据库，不支持数据库无关性，但sql语句优化容易。


### 2、Mapper 编写有几种方式 ？

**1、** 接口实现类集成`SQLSessionDaoSupport`** 此方法需要编写`mapper`接口，`mapper`接口的实现类,`mapper.xml`文件。

**2、** 使用`org.mybatis.spring.mapper.MapperFactoryBean`** 此方法需要在`SqlMapConfig.xml`中配置`mapper.xml`的位置，还需定义`mapper`接口。

**3、** 使用`mapper`扫描器** 需要编写`mapper.xml`文件，需要`mapper`接口，配置`mapper`扫描器，使用扫描器从`spring`容器中获取`mapper`的实现对象。


### 3、Mybatis的一级缓存和二级缓存？

**1、** 一级缓存 Mybatis的一级缓存是指SQLSession，一级缓存的作用域是SQlSession, Mabits默认开启一级缓存。 在同一个SqlSession中，执行相同的SQL查询时；第一次会去查询数据库，并写在缓存中，第二次会直接从缓存中取。 当执行SQL时候两次查询中间发生了增删改的操作，则SQLSession的缓存会被清空。 每次查询会先去缓存中找，如果找不到，再去数据库查询，然后把结果写到缓存中。 Mybatis的内部缓存使用一个HashMap，key为hashcode+statementId+sql语句。Value为查询出来的结果集映射成的java对象。 SqlSession执行insert、update、delete等操作commit后会清空该SQLSession缓存。

**2、** 二级缓存 二级缓存是mapper级别的，Mybatis默认是没有开启二级缓存的。 第一次调用mapper下的SQL去查询用户的信息，查询到的信息会存放代该mapper对应的二级缓存区域。 第二次调用namespace下的mapper映射文件中，相同的sql去查询用户信息，会去对应的二级缓存内取结果。 如果调用相同namespace下的mapepr映射文件中增删改sql，并执行了commit操作，此时会情况该


### 4、JDBC编程有哪些不足之处，MyBatis是如何解决的？

**1、** 数据库链接创建、释放频繁造成系统资源浪费从而影响系统性能，如果使用数据库连接池可解决此问题。

**解决：在mybatis-config.xml中配置数据链接池，使用连接池管理数据库连接。**

**2、** Sql语句写在代码中造成代码不易维护，实际应用sql变化的可能较大，sql变动需要改变java代码。-

**解决：将Sql语句配置在XXXXmapper.xml文件中与java代码分离。**

**3、** 向sql语句传参数麻烦，因为sql语句的where条件不一定，可能多也可能少，占位符需要和参数一一对应。

**解决： Mybatis自动将java对象映射至sql语句。**

**4、** 对结果集解析麻烦，sql变化导致解析代码变化，且解析前需要遍历，如果能将数据库记录封装成pojo对象解析比较方便。

**解决：Mybatis自动将sql执行结果映射至java对象。**


### 5、通常一个 Xml 映射文件，都会写一个 Dao 接口与之对应, Dao 的工作原理，是否可以重

载？

不能重载，因为通过 Dao 寻找 Xml 对应的 sql 的时候全限名+方法名的保存和寻找策

略。接口工作原理为 jdk 动态代理原理，运行时会为 dao 生成 proxy，代理对象会拦截接口

方法，去执行对应的 sql 返回数据。


### 6、MyBatis的功能架构是怎样的

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/041/14/55_2.png#alt=55%5C_2.png)

**我们把Mybatis的功能架构分为三层：**

**1、** API接口层：提供给外部使用的接口API，开发人员通过这些本地API来操纵数据库。接口层一接收到调用请求就会调用数据处理层来完成具体的数据处理。

**2、** 数据处理层：负责具体的SQL查找、SQL解析、SQL执行和执行结果映射处理等。它主要的目的是根据调用的请求完成一次数据库操作。

**3、** 基础支撑层：负责最基础的功能支撑，包括连接管理、事务管理、配置加载和缓存处理，这些都是共用的东西，将他们抽取出来作为最基础的组件。为上层的数据处理层提供最基础的支撑。


### 7、简述Mybatis的插件运行原理，以及如何编写一个插件。

Mybatis仅可以编写针对ParameterHandler、ResultSetHandler、StatementHandler、Executor这4种接口的插件，Mybatis使用JDK的动态代理，为需要拦截的接口生成代理对象以实现接口方法拦截功能，每当执行这4种接口对象的方法时，就会进入拦截方法，具体就是InvocationHandler的invoke()方法，当然，只会拦截那些你指定需要拦截的方法。

编写插件：实现Mybatis的Interceptor接口并复写intercept()方法，然后在给插件编写注解，指定要拦截哪一个接口的哪些方法即可，记住，别忘了在配置文件中配置你编写的插件。



### 8、Mybatis 是如何进行分页的？分页插件的原理是什么？

**1、** Mybatis 使用 RowBounds 对象进行分页，也可以直接编写 sql 实现分页，也可以使用Mybatis 的分页插件。

**2、** 分页插件的原理：实现 Mybatis 提供的接口，实现自定义插件，在插件的拦截方法内拦

截待执行的 sql，然后重写 sql。

举例：select _ from student，拦截 sql 后重写为：select t._ from （select * from student、t

limit 0，10


### 9、Xml 映射文件中，除了常见的 select|insert|updae|delete 标签之外，还有哪些标签？

还有很多其他的标签，、、、、

，加上动态 sql 的 9 个标签，

trim|where|set|foreach|if|choose|when|otherwise|bind 等，其中为 sql 片段标签，通

过标签引入 sql 片段，为不支持自增的主键生成策略标签。

**1、** 通过在查询的 sql 语句中定义字段名的别名。

**2、** 通过来映射字段名和实体类属性名的一一对应的关系。


### 10、#{}和${}的区别是什么？

`#{}`是预编译处理，${}是字符串替换。

Mybatis在处理#{}时，会将sql中的#{}替换为?号，调用PreparedStatement的set方法来赋值；

Mybatis在处理$${}时，就是把$${}替换成变量的值。

使用#{}可以有效的防止SQL注入，提高系统安全性。


### 11、使用Mybatis的mapper接口调用时候有哪些要求？
### 12、#{}和${}的区别是什么？
### 13、什么是MyBatis的接口绑定？有哪些实现方式？
### 14、MyBatis与hibernate有哪些不同？
### 15、SQLMapConfig.xml中配置有哪些内容？
### 16、什么是DBMS
### 17、讲下 MyBatis 的缓存
### 18、IBatis 和 MyBatis 在核心处理类分别叫什么？
### 19、Mybaits的优点有什么？
### 20、MyBatis与Hibernate有哪些不同？
### 21、模糊查询 like 语句该怎么写
### 22、MyBatis 实现一对一有几种方式?具体怎么操作的？
### 23、Mybatis 分页查询？
### 24、Xml映射文件中，除了常见的select|insert|updae|delete标签之外，还有哪些标签？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
