# MyBatis最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Mybatis是如何进行分页的？分页插件的原理是什么？

Mybatis使用Row Bounds对象进行分页，它是针对Result Set结果集执行的内存分页，而非物理分页。可以在sql内直接书写带有物理分页的参数来完成物理分页功能，也可以使用分页插件来完成物理分页。

分页原理：分页插件的基本原理是使用Mybatis提供的插件接口，实现自定义插件，在插件的拦截方法内拦截待执行的sql，然后重写sql，根据dialect方言，添加对应的物理分页语句和物理分页参数。


### 2、什么是MyBatis的接口绑定？有哪些实现方式？

接口绑定，就是在MyBatis中任意定义接口，然后把接口里面的方法和SQL语句绑定，我们直接调用接口方法就可以，这样比起原来了SqlSession提供的方法我们可以有更加灵活的选择和设置。

**接口绑定有两种实现方式**

**1、** 通过注解绑定，就是在接口的方法上面加上 @Select、@Update等注解，里面包含Sql语句来绑定；

**2、** 通过xml里面写SQL来绑定， 在这种情况下，要指定xml映射文件里面的namespace必须为接口的全路径名。当Sql语句比较简单时候，用注解绑定， 当SQL语句比较复杂时候，用xml绑定，一般用xml绑定的比较多。


### 3、Mybatis是否支持延迟加载？如果支持，它的实现原理是什么？

Mybatis仅支持association关联对象和collection关联集合对象的延迟加载，association指的就是一对一，collection指的就是一对多查询。在Mybatis配置文件中，可以配置是否启用延迟加载lazyLoadingEnabled=true|false。

它的原理是，使用CGLIB创建目标对象的代理对象，当调用目标方法时，进入拦截器方法，比如调用a.getB().getName()，拦截器invoke()方法发现a.getB()是null值，那么就会单独发送事先保存好的查询关联B对象的sql，把B查询上来，然后调用a.setB(b)，于是a的对象b属性就有值了，接着完成a.getB().getName()方法的调用。这就是延迟加载的基本原理。

当然了，不光是Mybatis，几乎所有的包括Hibernate，支持延迟加载的原理都是一样的。


### 4、Mybatis 动态 sql 是做什么的？都有哪些动态 sql？能简述一下动态 sql 的执行原理不？

**1、** Mybatis 动态 sql 可以让我们在 Xml 映射文件内，以标签的形式编写动态 sql，完成逻辑

判断和动态拼接 sql 的功能。

**2、** Mybatis 提供了 9 种动态 sql 标签：

trim|where|set|foreach|if|choose|when|otherwise|bind。

**3、** 其执行原理为，使用 OGNL 从 sql 参数对象中计算表达式的值，根据表达式的值动态拼

接 sql，以此来完成动态 sql 的功能。


### 5、Mybatis 都有哪些 Executor 执行器？它们之间的区别是什么？

Mybatis 有三种基本的 Executor 执行器，SimpleExecutor、ReuseExecutor、

BatchExecutor。1、SimpleExecutor：每执行一次 update 或 select，就开启一个 Statement 对

象，用完立刻关闭 Statement 对象。2、ReuseExecutor：执行 update 或 select，以 sql 作为

key 查找 Statement 对象，存在就使用，不存在就创建，用完后，不关闭 Statement 对象，

而是放置于 Map3、BatchExecutor：完成批处理。


### 6、Mapper编写有哪几种方式？

第一种：接口实现类继承SqlSessionDaoSupport：使用此种方法需要编写mapper接口，mapper接口实现类、mapper.xml文件。

**1、** 在sqlMapConfig.xml中配置mapper.xml的位置

```xml
<mappers>
    <mapper resource="mapper.xml文件的地址" />
    <mapper resource="mapper.xml文件的地址" />
</mappers>
```

**1、** 定义mapper接口

**3、** 实现类集成SqlSessionDaoSupport

mapper方法中可以this.getSqlSession()进行数据增删改查。

**4、** spring 配置

```xml
<bean id=" " class="mapper接口的实现">
    <property name="sqlSessionFactory" ref="sqlSessionFactory"></property>
</bean>
```

第二种：使用`org.mybatis.spring.mapper.MapperFactoryBean`：

**1、** 在sqlMapConfig.xml中配置mapper.xml的位置，如果mapper.xml和mappre接口的名称相同且在同一个目录，这里可以不用配置

```xml
<mappers>
    <mapper resource="mapper.xml文件的地址" />
    <mapper resource="mapper.xml文件的地址" />
</mappers>
```

**2、** 定义mapper接口：

**1、** mapper.xml中的namespace为mapper接口的地址

**2、** mapper接口中的方法名和mapper.xml中的定义的statement的id保持一致

**3、** Spring中定义

```xml
<bean id="" class="org.mybatis.spring.mapper.MapperFactoryBean">
    <property name="mapperInterface"   value="mapper接口地址" />
    <property name="sqlSessionFactory" ref="sqlSessionFactory" />
</bean>
```

第三种：使用mapper扫描器：

**1、** mapper.xml文件编写：

mapper.xml中的namespace为mapper接口的地址；

mapper接口中的方法名和mapper.xml中的定义的statement的id保持一致；

如果将mapper.xml和mapper接口的名称保持一致则不用在sqlMapConfig.xml中进行配置。

**2、** 定义mapper接口：

注意mapper.xml的文件名和mapper的接口名称保持一致，且放在同一个目录

**3、** 配置mapper扫描器：

```xml
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="basePackage" value="mapper接口包地址"></property>
    <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
</bean>
```

**4、** 使用扫描器后从spring容器中获取mapper的实现对象。


### 7、#{}和${}的区别

**1、** #{}是占位符，预编译处理；${}是拼接符，字符串替换，没有预编译处理。

**2、** Mybatis在处理#{}时，#{}传入参数是以字符串传入，会将SQL中的#{}替换为?号，调用PreparedStatement的set方法来赋值。

**3、** #{} 可以有效的防止SQL注入，提高系统安全性；${} 不能防止SQL 注入

**4、** #{} 的变量替换是在DBMS 中；${} 的变量替换是在 DBMS 外


### 8、MyBatis框架适用场合：
### 9、什么是MyBatis的接口绑定？有哪些实现方式？
### 10、Mapper 编写有哪几种方式？
### 11、MyBatis的框架架构设计是怎么样的
### 12、如何获取自动生成的(主)键值?
### 13、什么情况下用注解绑定,什么情况下用 xml 绑定？
### 14、简述Mybatis的插件运行原理，以及如何编写一个插件。
### 15、Mybatis中如何指定使用哪一种Executor执行器？
### 16、IBatis 和 MyBatis 在细节上的不同有哪些？
### 17、在mapper中如何传递多个参数
### 18、ORM是什么
### 19、MyBatis框架的缺点有什么？
### 20、Mybatis与Spring 的整合？
### 21、Mybatis动态SQL？
### 22、Xml映射文件中，除了常见的select|insert|updae|delete标签之外，还有哪些标签？
### 23、Mybatis 中如何执行批处理？
### 24、Mybatis 是如何将 sql 执行结果封装为目标对象并返回的？都有哪些映射形式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
