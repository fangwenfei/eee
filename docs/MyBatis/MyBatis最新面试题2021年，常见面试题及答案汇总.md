# MyBatis最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是 MyBatis？

MyBatis 是一个可以自定义 SQL、存储过程和高级映射的持久层框架。


### 2、什么是 MyBatis 的接口绑定,有什么好处？

接口映射就是在 MyBatis 中任意定义接口,然后把接口里面的方法和 SQL 语句绑定,我们

直接调用接口方法就可以,这样比起原来了 SqlSession 提供的方法我们可以有更加灵活的选

择和设置.


### 3、Mybatis是如何将sql执行结果封装为目标对象并返回的？都有哪些映射形式？

第一种是使用`<resultMap>`标签，逐一定义数据库列名和对象属性名之间的映射关系。

第二种是使用sql列的别名功能，将列的别名书写为对象属性名。

有了列名与属性名的映射关系后，Mybatis通过反射创建对象，同时使用反射给对象的属性逐一赋值并返回，那些找不到映射关系的属性，是无法完成赋值的。


### 4、MyBatis框架的缺点：

**1、** SQL语句的编写工作量较大，尤其当字段多、关联表多时，对开发人员编写SQL语句的功底有一定要求。

**2、** SQL语句依赖于数据库，导致数据库移植性差，不能随意更换数据库。


### 5、Mybais 常用注解 ？

[@Insert ](/Insert ) ： 插入sql , 和xml insert sql语法完全一样

[@Select ](/Select ) ： 查询sql, 和xml select sql语法完全一样

[@Update ](/Update ) ： 更新sql, 和xml update sql语法完全一样

[@Delete ](/Delete ) ： 删除sql, 和xml delete sql语法完全一样

[@Param ](/Param ) ： 入参

[@Results ](/Results ) ：结果集合

[@Result ](/Result ) ： 结果


### 6、Mybatis 能执行一对一、一对多的关联查询吗？都有哪些实现方式，以及它们之间的区

别？

能，Mybatis 不仅可以执行一对一、一对多的关联查询，还可以执行多对一，多对多的

关联查询，多对一查询，其实就是一对一查询，只需要把 selectOne()修改为 selectList()即

可；多对多查询，其实就是一对多查询，只需要把 selectOne()修改为 selectList()即可。

关联对象查询，有两种实现方式，一种是单独发送一个 sql 去查询关联对象，赋给主对

象，然后返回主对象。另一种是使用嵌套查询，嵌套查询的含义为使用 join 查询，一部分

列是 A 对象的属性值，另外一部分列是关联对象 B 的属性值，好处是只发一个 sql 查询，

就可以把主对象和其关联对象查出来。


### 7、简述 Mybatis 的 Xml 映射文件和 Mybatis 内部数据结构之间的映射关系？

Mybatis 将所有 Xml 配置信息都封装到 All-In-One 重量级对象 Configuration 内部。在

Xml 映射文件中，标签会被解析为 ParameterMap 对象，其每个子元素会

被解析为 ParameterMapping 对象。标签会被解析为 ResultMap 对象，其每个子

元素会被解析为 ResultMapping 对象。每一个、、、标签

均会被解析为 MappedStatement 对象，标签内的 sql 会被解析为 BoundSql 对象。


### 8、Mybatis 中如何指定使用哪一种 Executor 执行器？

在 Mybatis 配置文件中，可以指定默认的 ExecutorType 执行器类型，也可以手动给

DefaultSqlSessionFactory 的创建 SqlSession 的方法传递 ExecutorType 类型参数。


### 9、Mapper 编写有哪几种方式？

**第一种：接口实现类继承 SqlSessionDaoSupport：使用此种方法需要编写mapper 接口，mapper 接口实现类、mapper.xml 文件**

**1、** 在 sqlMapConfig.xml 中配置 mapper.xml 的位置

```
<mappers>
    <mapper resource="mapper.xml 文件的地址" />
    <mapper resource="mapper.xml 文件的地址" />
</mappers>
```

**2、** 定义 mapper 接口

**3、** 实现类集成 SqlSessionDaoSupport

mapper 方法中可以 this.getSqlSession()进行数据增删改查。

**4、** spring 配置

```
<bean id=" " class="mapper 接口的实现">
    <property name="sqlSessionFactory"
    ref="sqlSessionFactory"></property>
</bean>
```

**第二种：使用 org.mybatis.spring.mapper.MapperFactoryBean：**

**1、** 在 sqlMapConfig.xml 中配置 mapper.xml 的位置，如果 mapper.xml 和mappre 接口的名称相同且在同一个目录，这里可以不用配置

**2、** 定义 mapper 接口：

```
<mappers>
    <mapper resource="mapper.xml 文件的地址" />
    <mapper resource="mapper.xml 文件的地址" />
</mappers>
```

**3、** mapper.xml 中的 namespace 为 mapper 接口的地址

**4、** mapper 接口中的方法名和 mapper.xml 中的定义的 statement 的 id 保持一致

**5、** Spring 中定义

```
<bean id="" class="org.mybatis.spring.mapper.MapperFactoryBean">
    <property name="mapperInterface" value="mapper 接口地址" />
    <property name="sqlSessionFactory" ref="sqlSessionFactory" />
</bean>
```

**第三种：使用 mapper 扫描器：**

**1、** mapper.xml 文件编写：

mapper.xml 中的 namespace 为 mapper 接口的地址；

mapper 接口中的方法名和 mapper.xml 中的定义的 statement 的 id 保持一致；

如果将 mapper.xml 和 mapper 接口的名称保持一致则不用在 sqlMapConfig.xml中进行配置。

**2、** 定义 mapper 接口：

注意 mapper.xml 的文件名和 mapper 的接口名称保持一致，且放在同一个目录

**3、** 配置 mapper 扫描器：

```
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="basePackage" value="mapper 接口包地址
    "></property>
    <property name="sqlSessionFactoryBeanName"
    value="sqlSessionFactory"/>
</bean>
```

**4、** 使用扫描器后从 spring 容器中获取 mapper 的实现对象。


### 10、MyBatis 实现一对一有几种方式?具体怎么操作的？

有联合查询和嵌套查询,联合查询是几个表联合查询,只查询一次,通过在 resultMap 里面

配置 association 节点配置一对一的类就可以完成;嵌套查询是先查一个表,根据这个表里面

的结果的外键 id,去再另外一个表里面查询数据,也是通过 association 配置,但另外一个表的

查询通过 select 属性配置。


### 11、#{}和${}的区别是什么？
### 12、MyBatis与Hibernate有哪些不同？
### 13、resultType resultMap 的区别？
### 14、Mybatis如何执行批量操作
### 15、Mybaits的优点有什么？
### 16、Xml映射文件中，除了常见的select|insert|updae|delete标签之外，还有哪些标签？
### 17、如何获取自动生成的(主)键值?
### 18、MyBatis 的好处是什么？
### 19、简述Mybatis的Xml映射文件和Mybatis内部数据结构之间的映射关系？
### 20、MyBatis和Hibernate的适用场景?
### 21、如何执行批量插入?
### 22、模糊查询like语句该怎么写?
### 23、Mybaits的优点：
### 24、Mybatis动态sql是做什么的？都有哪些动态sql？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
