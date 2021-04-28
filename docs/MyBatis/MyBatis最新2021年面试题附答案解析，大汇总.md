# MyBatis最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、MyBatis的框架架构设计是怎么样的

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/041/14/55_3.png#alt=55%5C_3.png)

这张图从上往下看。MyBatis的初始化，会从mybatis-config.xml配置文件，解析构造成Configuration这个类，就是图中的红框。

**1、** 加载配置：配置来源于两个地方，一处是配置文件，一处是Java代码的注解，将SQL的配置信息加载成为一个个MappedStatement对象（包括了传入参数映射配置、执行的SQL语句、结果映射配置），存储在内存中。

**2、** SQL解析：当API接口层接收到调用请求时，会接收到传入SQL的ID和传入对象（可以是Map、JavaBean或者基本数据类型），Mybatis会根据SQL的ID找到对应的MappedStatement，然后根据传入参数对象对MappedStatement进行解析，解析后可以得到最终要执行的SQL语句和参数。

**3、** SQL执行：将最终得到的SQL和参数拿到数据库进行执行，得到操作数据库的结果。

**4、** 结果映射：将操作数据库的结果按照映射的配置进行转换，可以转换成HashMap、JavaBean或者基本数据类型，并将最终结果返回。


### 2、Mybatis 动态 sql 是做什么的？都有哪些动态 sql？能简述一下动态 sql 的执行原理不？

**1、** Mybatis 动态 sql 可以让我们在 Xml 映射文件内，以标签的形式编写动态 sql，完成逻辑

判断和动态拼接 sql 的功能。

**2、** Mybatis 提供了 9 种动态 sql 标签：

trim|where|set|foreach|if|choose|when|otherwise|bind。

**3、** 其执行原理为，使用 OGNL 从 sql 参数对象中计算表达式的值，根据表达式的值动态拼

接 sql，以此来完成动态 sql 的功能。


### 3、MyBatis 里面的动态 Sql 是怎么设定的?用什么语法?

MyBatis 里面的动态 Sql 一般是通过 if 节点来实现,通过 OGNL 语法来实现,但是如果要

写的完整,必须配合 where,trim 节点,where 节点是判断包含节点有内容就插入 where,否则不

插入,trim 节点是用来判断如果动态语句是以 and 或 or 开始,那么会自动把这个 and 或者 or

取掉。


### 4、Mybatis 是如何进行分页的？分页插件的原理是什么？

**1、** Mybatis 使用 RowBounds 对象进行分页，也可以直接编写 sql 实现分页，也可以使用Mybatis 的分页插件。

**2、** 分页插件的原理：实现 Mybatis 提供的接口，实现自定义插件，在插件的拦截方法内拦

截待执行的 sql，然后重写 sql。

举例：select _ from student，拦截 sql 后重写为：select t._ from （select * from student、t

limit 0，10


### 5、Mybaits的优点有什么？

**1、** 基于SQL语句编程，相当灵活，不会对应用程序或者数据库的现有设计造成任何影响，SQL写在XML里，解除sql与程序代码的耦合，便于统一管理；提供XML标签，支持编写动态SQL语句，并可重用；

**2、** 与JDBC相比，减少了50%以上的代码量，消除了JDBC大量冗余的代码，不需要手动开关连接；

**3、** 很好的与各种数据库兼容；

**4、** 能够与Spring很好的集成；

**5、** 提供映射标签，支持对象与数据库的ORM字段关系映射；提供对象关系映射标签，支持对象关系组件维护。


### 6、什么是MyBatis的接口绑定？有哪些实现方式？

接口绑定，就是在MyBatis中任意定义接口，然后把接口里面的方法和SQL语句绑定，我们直接调用接口方法就可以，这样比起原来了SqlSession提供的方法我们可以有更加灵活的选择和设置。

**接口绑定有两种实现方式**

**1、** 通过注解绑定，就是在接口的方法上面加上 @Select、@Update等注解，里面包含Sql语句来绑定；

**2、** 通过xml里面写SQL来绑定， 在这种情况下，要指定xml映射文件里面的namespace必须为接口的全路径名。当Sql语句比较简单时候，用注解绑定， 当SQL语句比较复杂时候，用xml绑定，一般用xml绑定的比较多。


### 7、Mapper 编写有哪几种方式？

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


### 8、如何获取自动生成的(主)键值?

insert 方法总是返回一个int值 ，这个值代表的是插入的行数。

如果采用自增长策略，自动生成的键值在 insert 方法执行完后可以被设置到传入的参数对象中。

**示例：**

```xml
<insert id=”insertname” usegeneratedkeys=”true” keyproperty=”id”>
        insert into names (name) values (#{name})
        </insert>
        name name = new name();
        name.setname(“fred”);

        int rows = mapper.insertname(name);
        // 完成后,id已经被设置到对象中
        system.out.println(“rows inserted = ” + rows);
        system.out.println(“generated key value = ” + name.getid());
```


### 9、Mybatis是如何进行分页的？分页插件的原理是什么？

Mybatis使用RowBounds对象进行分页，它是针对ResultSet结果集执行的内存分页，而非物理分页，可以在sql内直接书写带有物理分页的参数来完成物理分页功能，也可以使用分页插件来完成物理分页。

分页插件的基本原理是使用Mybatis提供的插件接口，实现自定义插件，在插件的拦截方法内拦截待执行的sql，然后重写sql，根据dialect方言，添加对应的物理分页语句和物理分页参数。

**举例：**

select * from student，拦截sql后重写为：select t.* from (select * from student) t limit 0, 10


### 10、简述 Mybatis 的插件运行原理，以及如何编写一个插件？

**1、** Mybatis 仅可以编写针对 ParameterHandler、ResultSetHandler、StatementHandler、

Executor 这 4 种接口的插件，Mybatis 通过动态代理，为需要拦截的接口生成代理对象以实

现接口方法拦截功能，每当执行这 4 种接口对象的方法时，就会进入拦截方法，具体就是

InvocationHandler 的 invoke()方法，当然，只会拦截那些你指定需要拦截的方法。

**2、** 实现 Mybatis 的 Interceptor 接口并复写 intercept()方法，然后在给插件编写注解，指定

要拦截哪一个接口的哪些方法即可，记住，别忘了在配置文件中配置你编写的插件。


### 11、MyBatis 的好处是什么？
### 12、Mybatis如何执行批量操作
### 13、ORM是什么
### 14、JDBC编程有哪些不足之处，MyBatis是如何解决这些问题的？
### 15、Mybatis 都有哪些 Executor 执行器？它们之间的区别是什么？
### 16、什么是Mybatis？
### 17、Mybatis的一级缓存和二级缓存？
### 18、Mapper编写有哪几种方式？
### 19、MyBatis 与 Hibernate 有哪些不同？
### 20、Mybatis 的 Xml 映射文件中，不同的 Xml 映射文件，id 是否可以重复？
### 21、MyBatis实现一对一有几种方式?具体怎么操作的？
### 22、简述Mybatis的插件运行原理，以及如何编写一个插件。
### 23、#{}和${}的区别是什么？
### 24、MyBatis框架适用场合：
### 25、使用 MyBatis 的 mapper 接口调用时有哪些要求？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
