# MyBatis最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、使用MyBatis的mapper接口调用时有哪些要求？

**1、** Mapper接口方法名和mapper.xml中定义的每个sql的id相同。

**2、** Mapper接口方法的输入参数类型和mapper.xml中定义的每个sql 的parameterType的类型相同。

**3、** Mapper接口方法的输出参数类型和mapper.xml中定义的每个sql的resultType的类型相同。

**4、** Mapper.xml文件中的namespace即是mapper接口的类路径。


### 2、如何执行批量插入?

首先,创建一个简单的insert语句:

```xml
<insert id=”insertname”>
        insert into names (name) values (#{value})
        </insert>
```

然后在java代码中像下面这样执行批处理插入:

```
list < string > names = new arraylist();
names.add(“fred”);
names.add(“barney”);
names.add(“betty”);
names.add(“wilma”);
// 注意这里 executortype.batch
sqlsession sqlsession = sqlsessionfactory.opensession(executortype.batch);
try {
    namemapper mapper = sqlsession.getmapper(namemapper.class);
    for (string name: names) {
        mapper.insertname(name);
    }
    sqlsession.commit();
} catch (Exception e) {
    e.printStackTrace();
    sqlSession.rollback();
    throw e;    
}    
finally {    
    sqlsession.close();
}
```


### 3、MyBatis是什么？

Mybatis 是一个半 ORM（对象关系映射）框架，它内部封装了 JDBC，开发时只需要关注 SQL 语句本身，不需要花费精力去处理加载驱动、创建连接、创建statement 等繁杂的过程。程序员直接编写原生态 sql，可以严格控制 sql 执行性能，灵活度高。

MyBatis 可以使用 XML 或注解来配置和映射原生信息，将 POJO 映射成数据库中的记录，避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。


### 4、Mybatis动态sql有什么用？执行原理？有哪些动态sql？

Mybatis动态sql可以在Xml映射文件内，以标签的形式编写动态sql，执行原理是根据表达式的值 完成逻辑判断并动态拼接sql的功能。

Mybatis提供了9种动态sql标签：`trim | where | set | foreach | if | choose | when | otherwise | bind`。


### 5、什么情况下用注解绑定,什么情况下用 xml 绑定？

当 Sql 语句比较简单时候,用注解绑定；当 SQL 语句比较复杂时候,用 xml 绑定,一般用

xml 绑定的比较多


### 6、通常一个 Xml 映射文件，都会写一个 Dao 接口与之对应, Dao 的工作原理，是否可以重

载？

不能重载，因为通过 Dao 寻找 Xml 对应的 sql 的时候全限名+方法名的保存和寻找策

略。接口工作原理为 jdk 动态代理原理，运行时会为 dao 生成 proxy，代理对象会拦截接口

方法，去执行对应的 sql 返回数据。


### 7、Mybatis 是如何进行分页的？分页插件的原理是什么？

**1、** Mybatis 使用 RowBounds 对象进行分页，也可以直接编写 sql 实现分页，也可以使用Mybatis 的分页插件。

**2、** 分页插件的原理：实现 Mybatis 提供的接口，实现自定义插件，在插件的拦截方法内拦

截待执行的 sql，然后重写 sql。

举例：select _ from student，拦截 sql 后重写为：select t._ from （select * from student、t

limit 0，10


### 8、Mybatis的Xml映射文件中，不同的Xml映射文件，id是否可以重复？

不同的Xml映射文件，如果配置了namespace，那么id可以重复；如果没有配置namespace，那么id不能重复；

原因就是namespace+id是作为Map`<String, MapperStatement>`的key使用的，如果没有namespace，就剩下id，那么，id重复会导致数据互相覆盖。有了namespace，自然id就可以重复，namespace不同，namespace+id自然也就不同。


### 9、MyBatis框架的缺点：

**1、** SQL语句的编写工作量较大，尤其当字段多、关联表多时，对开发人员编写SQL语句的功底有一定要求。

**2、** SQL语句依赖于数据库，导致数据库移植性差，不能随意更换数据库。


### 10、MyBatis的框架架构设计是怎么样的

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/041/14/55_3.png#alt=55%5C_3.png)

这张图从上往下看。MyBatis的初始化，会从mybatis-config.xml配置文件，解析构造成Configuration这个类，就是图中的红框。

**1、** 加载配置：配置来源于两个地方，一处是配置文件，一处是Java代码的注解，将SQL的配置信息加载成为一个个MappedStatement对象（包括了传入参数映射配置、执行的SQL语句、结果映射配置），存储在内存中。

**2、** SQL解析：当API接口层接收到调用请求时，会接收到传入SQL的ID和传入对象（可以是Map、JavaBean或者基本数据类型），Mybatis会根据SQL的ID找到对应的MappedStatement，然后根据传入参数对象对MappedStatement进行解析，解析后可以得到最终要执行的SQL语句和参数。

**3、** SQL执行：将最终得到的SQL和参数拿到数据库进行执行，得到操作数据库的结果。

**4、** 结果映射：将操作数据库的结果按照映射的配置进行转换，可以转换成HashMap、JavaBean或者基本数据类型，并将最终结果返回。


### 11、简述Mybatis的插件运行原理，以及如何编写一个插件。
### 12、当实体类中的属性名和表中的字段名不一样 ，怎么办 ？
### 13、如何获取生成的主键
### 14、Mybatis 是如何将 sql 执行结果封装为目标对象并返回的？都有哪些映射形式？
### 15、在 mapper 中如何传递多个参数？
### 16、Mybatis是否支持延迟加载？如果支持，它的实现原理是什么？
### 17、Mybatis是如何将sql执行结果封装为目标对象并返回的？都有哪些映射形式？
### 18、什么是MyBatis的接口绑定？有哪些实现方式？
### 19、简述 Mybatis 的插件运行原理，以及如何编写一个插件？
### 20、Mybatis能执行一对多，一对一的联系查询吗，有哪些实现方法
### 21、MyBatis和Hibernate的适用场景?
### 22、Xml映射文件中，除了常见的select|insert|updae|delete标签之外，还有哪些标签？
### 23、Mybaits的优点有什么？
### 24、如何获取自动生成的(主)键值？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
