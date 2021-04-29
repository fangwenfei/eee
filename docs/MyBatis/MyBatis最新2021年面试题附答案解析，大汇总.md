# MyBatis最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、#{}和${}的区别是什么？

`#{}`是预编译处理，${}是字符串替换。

Mybatis在处理#{}时，会将sql中的#{}替换为?号，调用PreparedStatement的set方法来赋值；

Mybatis在处理$${}时，就是把$${}替换成变量的值。

使用#{}可以有效的防止SQL注入，提高系统安全性。


### 2、什么是MyBatis的接口绑定？有哪些实现方式？

接口绑定，就是在MyBatis中任意定义接口，然后把接口里面的方法和SQL语句绑定，我们直接调用接口方法就可以，这样比起原来了SqlSession提供的方法我们可以有更加灵活的选择和设置。

**接口绑定有两种实现方式**

**1、** 通过注解绑定，就是在接口的方法上面加上 @Select、@Update等注解，里面包含Sql语句来绑定；

**2、** 通过xml里面写SQL来绑定， 在这种情况下，要指定xml映射文件里面的namespace必须为接口的全路径名。当Sql语句比较简单时候，用注解绑定， 当SQL语句比较复杂时候，用xml绑定，一般用xml绑定的比较多。


### 3、MyBatis的框架架构设计是怎么样的

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/041/14/55_3.png#alt=55%5C_3.png)

这张图从上往下看。MyBatis的初始化，会从mybatis-config.xml配置文件，解析构造成Configuration这个类，就是图中的红框。

**1、** 加载配置：配置来源于两个地方，一处是配置文件，一处是Java代码的注解，将SQL的配置信息加载成为一个个MappedStatement对象（包括了传入参数映射配置、执行的SQL语句、结果映射配置），存储在内存中。

**2、** SQL解析：当API接口层接收到调用请求时，会接收到传入SQL的ID和传入对象（可以是Map、JavaBean或者基本数据类型），Mybatis会根据SQL的ID找到对应的MappedStatement，然后根据传入参数对象对MappedStatement进行解析，解析后可以得到最终要执行的SQL语句和参数。

**3、** SQL执行：将最终得到的SQL和参数拿到数据库进行执行，得到操作数据库的结果。

**4、** 结果映射：将操作数据库的结果按照映射的配置进行转换，可以转换成HashMap、JavaBean或者基本数据类型，并将最终结果返回。


### 4、为什么说 Mybatis 是半自动 ORM 映射工具？它与全自动的区别在哪里？

Hibernate 属于全自动 ORM 映射工具，使用 Hibernate 查询关联对象或者关联集合对象

时，可以根据对象关系模型直接获取，所以它是全自动的。而 Mybatis 在查询关联对象或

关联集合对象时，需要手动编写 sql 来完成，所以，称之为半自动 ORM 映射工具。


### 5、通常一个Xml映射文件，都会写一个Dao接口与之对应

**请问，这个Dao接口的工作原理是什么？Dao接口里的方法，参数不同时，方法能重载吗？**

Dao接口即Mapper接口。接口的全限名，就是映射文件中的namespace的值；接口的方法名，就是映射文件中Mapper的Statement的id值；接口方法内的参数，就是传递给sql的参数。

Mapper接口是没有实现类的，当调用接口方法时，接口全限名+方法名拼接字符串作为key值，可唯一定位一个MapperStatement。在Mybatis中，每一个`<select>、<insert>、<update>、<delete>`标签，都会被解析为一个MapperStatement对象。

**举例：**

`com.mybatis3.mappers.StudentDao.findStudentById`，可以唯一找到namespace为`com.mybatis3.mappers.StudentDao`下面 id 为 findStudentById 的 MapperStatement。

Mapper接口里的方法，是不能重载的，因为是使用 全限名+方法名 的保存和寻找策略。Mapper 接口的工作原理是JDK动态代理，Mybatis运行时会使用JDK动态代理为Mapper接口生成代理对象proxy，代理对象会拦截接口方法，转而执行MapperStatement所代表的sql，然后将sql执行结果返回。


### 6、简述 Mybatis 的 Xml 映射文件和 Mybatis 内部数据结构之间的映射关系？

Mybatis 将所有 Xml 配置信息都封装到 All-In-One 重量级对象 Configuration 内部。在

Xml 映射文件中，标签会被解析为 ParameterMap 对象，其每个子元素会

被解析为 ParameterMapping 对象。标签会被解析为 ResultMap 对象，其每个子

元素会被解析为 ResultMapping 对象。每一个、、、标签

均会被解析为 MappedStatement 对象，标签内的 sql 会被解析为 BoundSql 对象。


### 7、Mybatis是如何进行分页的？分页插件的原理是什么？

Mybatis使用RowBounds对象进行分页，它是针对ResultSet结果集执行的内存分页，而非物理分页。可以在sql内直接书写带有物理分页的参数来完成物理分页功能，也可以使用分页插件来完成物理分页。

分页插件的基本原理是使用Mybatis提供的插件接口，实现自定义插件，在插件的拦截方法内拦截待执行的sql，然后重写sql，根据dialect方言，添加对应的物理分页语句和物理分页参数。


### 8、模糊查询like语句该怎么写?

第1种：在Java代码中添加sql通配符。

```xml
string wildcardname = “%smi%”;
        list<name> names = mapper.selectlike(wildcardname);

    <select id=”selectlike”>
    select * from foo where bar like #{value}
</select>
```

第2种：在sql语句中拼接通配符，会引起sql注入

```xml
string wildcardname = “smi”;
        list<name> names = mapper.selectlike(wildcardname);


    <select id=”selectlike”>
    select * from foo where bar like "%"#{value}"%"
</select>
```


### 9、在 mapper 中如何传递多个参数？

**1、** 直接在方法中传递参数，xml 文件用#{0} #{1}来获取

**2、** 使用 [@param ](/param ) 注解:这样可以直接在 xml 文件中通过#{name}来获取


### 10、接口绑定有几种实现方式,分别是怎么实现的?

接口绑定有两种实现方式,一种是通过注解绑定,就是在接口的方法上面加上

@Select[@Update ](/Update ) 等注解里面包含 Sql 语句来绑定,另外一种就是通过 xml 里面写 SQL 来绑

定,在这种情况下,要指定 xml 映射文件里面的 namespace 必须为接口的全路径名.


### 11、Mybatis 映射文件中，如果 A 标签通过 include 引用了 B 标签的内容，请问，B 标签能
### 12、MyBatis与hibernate有哪些不同？
### 13、Mybatis 动态 sql 是做什么的？都有哪些动态 sql？能简述一下动态 sql 的执行原理不？
### 14、Mybatis动态sql有什么用？执行原理？有哪些动态sql？
### 15、这个Dao接口的工作原理是什么？Dao接口里的方法，参数不同时，方法能重载吗
### 16、讲下 MyBatis 的缓存
### 17、JDBC编程有哪些不足之处，MyBatis是如何解决的？
### 18、Mybatis是如何进行分页的？分页插件的原理是什么？
### 19、resultType resultMap 的区别？
### 20、使用MyBatis的mapper接口调用时有哪些要求？
### 21、简述Mybatis的插件运行原理，以及如何编写一个插件。
### 22、MyBatis实现一对多有几种方式,怎么操作的？
### 23、简述 Mybatis 的插件运行原理，以及如何编写一个插件？
### 24、一对一、一对多的关联查询 ？
### 25、简述Mybatis的插件运行原理，以及如何编写一个插件。




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
