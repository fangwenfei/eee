# MyBatis最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、MyBatis 与 Hibernate 有哪些不同？

**1、** Mybatis 和 hibernate 不同，它不完全是一个 ORM 框架，因为 MyBatis 需要程序员自己

编写 Sql 语句，不过 mybatis 可以通过 XML 或注解方式灵活配置要运行的 sql 语句，并将

java 对象和 sql 语句映射生成最终执行的 sql，最后将 sql 执行的结果再映射生成 java 对

象。

**2、** Mybatis 学习门槛低，简单易学，程序员直接编写原生态 sql，可严格控制 sql 执行性

能，灵活度高，非常适合对关系数据模型要求不高的软件开发，例如互联网软件、企业运

营类软件等，因为这类软件需求变化频繁，一但需求变化要求成果输出迅速。但是灵活的

前提是 mybatis 无法做到数据库无关性，如果需要实现支持多种数据库的软件则需要自定

义多套 sql 映射文件，工作量大。

**3、** Hibernate 对象/关系映射能力强，数据库无关性好，对于关系模型要求高的软件（例如

需求固定的定制化软件、如果用 hibernate 开发可以节省很多代码，提高效率。但是

Hibernate 的缺点是学习门槛高，要精通门槛更高，而且怎么设计 O/R 映射，在性能和对象

模型之间如何权衡，以及怎样用好 Hibernate 需要具有很强的经验和能力才行。

总之，按照用户的需求在有限的资源环境下只要能做出维护性、扩展性良好的软件架构都

是好架构，所以框架只有适合才是最好。


### 2、使用Mybatis的mapper接口调用时候有哪些要求？

**1、** Mapper接口方法名和Mapper.xml中定义的每个SQL的id相同；

**2、** Mapper接口方法的输入参数类型和mapper.xml中定义的每个sqlparameterType类型相同

**3、** Mapper接口方法的输入输出参数类型和mapper.xml中定义的每个sql的resultType的类型相同

**4、** Mapper.xml文件中的namespace，就是接口的类路径。


### 3、Mybatis 的 Xml 映射文件中，不同的 Xml 映射文件，id 是否可以重复？

不同的 Xml 映射文件，如果配置了 namespace，那么 id 可以重复；如果没有配置

namespace，那么 id 不能重复；毕竟 namespace 不是必须的，只是最佳实践而已。原因就

是 namespace+id 是作为 Map<String, MappedStatement>的 key 使用的，如果没有

namespace，就剩下 id，那么，id 重复会导致数据互相覆盖。有了 namespace，自然 id 就

可以重复，namespace 不同，namespace+id 自然也就不同。


### 4、JDBC编程有哪些不足之处，MyBatis是如何解决这些问题的？

**1、** 数据库链接创建、释放频繁造成系统资源浪费从而影响系统性能，使用数据库链接池可解决此问题。解决：在SqlMapConfig.xml中配置数据链接池，使用连接池管理数据库链接。

**2、** Sql语句写在代码中造成代码不易维护，实际应用sql变化的可能较大，sql变动需要改变java代码。解决：将Sql语句配置在XXXXmapper.xml文件中与java代码分离。

**3、** 向sql语句传参数麻烦，因为sql语句的where条件不一定，可能多也可能少，占位符需要和参数一一对应。解决： Mybatis 自动将 java 对象映射至 sql 语句。

**4、** 对结果集解析麻烦，sql 变化导致解析代码变化，且解析前需要遍历，如果能将数据库记录封装成 pojo对象解析比较方便。解决：Mybatis 自动将 sql 执行结果映射至java对象。


### 5、Xml 映射文件中，除了常见的 select|insert|updae|delete 标签之外，还有哪些标签？

还有很多其他的标签，、、、、

，加上动态 sql 的 9 个标签，

trim|where|set|foreach|if|choose|when|otherwise|bind 等，其中为 sql 片段标签，通

过标签引入 sql 片段，为不支持自增的主键生成策略标签。

**1、** 通过在查询的 sql 语句中定义字段名的别名。

**2、** 通过来映射字段名和实体类属性名的一一对应的关系。


### 6、Mybatis 中如何指定使用哪一种 Executor 执行器？

在 Mybatis 配置文件中，可以指定默认的 ExecutorType 执行器类型，也可以手动给

DefaultSqlSessionFactory 的创建 SqlSession 的方法传递 ExecutorType 类型参数。


### 7、Mybatis 是否支持延迟加载？如果支持，它的实现原理是什么？

**1、** Mybatis 仅支持 association 关联对象和 collection 关联集合对象的延迟加载，association

指的就是一对一，collection 指的就是一对多查询。在 Mybatis 配置文件中，可以配置是否

启用延迟加载 lazyLoadingEnabled=true|false。

**2、** 它的原理是，使用 CGLIB 创建目标对象的代理对象，当调用目标方法时，进入拦截器方

法，比如调用 a.getB().getName()，拦截器 invoke()方法发现 a.getB()是 null 值，那么就会单

独发送事先保存好的查询关联 B 对象的 sql，把 B 查询上来，然后调用 a.setB(b)，于是 a 的

对象 b 属性就有值了，接着完成 a.getB().getName()方法的调用。这就是延迟加载的基本原

理。


### 8、Mapper 编写有哪几种方式？

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


### 9、什么是 MyBatis？

MyBatis 是一个可以自定义 SQL、存储过程和高级映射的持久层框架。


### 10、什么是MyBatis的接口绑定？有哪些实现方式？

接口绑定，就是在MyBatis中任意定义接口,然后把接口里面的方法和SQL语句绑定, 我们直接调用接口方法就可以,这样比起原来了SqlSession提供的方法我们可以有更加灵活的选择和设置。

接口绑定有两种实现方式,一种是通过注解绑定，就是在接口的方法上面加上 @Select、@Update等注解，里面包含Sql语句来绑定；另外一种就是通过xml里面写SQL来绑定, 在这种情况下,要指定xml映射文件里面的namespace必须为接口的全路径名。当Sql语句比较简单时候,用注解绑定, 当SQL语句比较复杂时候,用xml绑定,一般用xml绑定的比较多。


### 11、ORM是什么
### 12、使用 MyBatis 的 mapper 接口调用时有哪些要求？
### 13、#{}和${}的区别
### 14、为什么说Mybatis是半自动ORM映射工具？它与全自动的区别在哪里？
### 15、Mybatis动态SQL？
### 16、Mybatis是如何将sql执行结果封装为目标对象并返回的？都有哪些映射形式？
### 17、Mybatis的Xml映射文件中，不同的Xml映射文件，id是否可以重复？
### 18、Mybatis是如何将sql执行结果封装为目标对象并返回的？都有哪些映射形式？
### 19、Mybatis 执行批量插入，能返回数据库主键列表吗？
### 20、Mybatis与Spring 的整合？
### 21、Mybatis的表关联的映射？
### 22、Hibernate 和 MyBatis 的区别
### 23、Mybatis都有哪些Executor执行器？它们之间的区别是什么？
### 24、Mybatis的Xml映射文件中，不同的Xml映射文件，id是否可以重复？
### 25、当实体类中的属性名和表中的字段名不一样 ，怎么办 ？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
