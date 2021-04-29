# MyBatis最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Mybatis动态sql是做什么的？都有哪些动态sql？

**能简述一下动态sql的执行原理吗？**

Mybatis动态sql可以让我们在Xml映射文件内，以标签的形式编写动态sql，完成逻辑判断和动态拼接sql的功能，Mybatis提供了9种动态sql标签trim|where|set|foreach|if|choose|when|otherwise|bind。

其执行原理为，使用OGNL从sql参数对象中计算表达式的值，根据表达式的值动态拼接sql，以此来完成动态sql的功能。


### 2、MyBatis框架的缺点有什么？

**1、** SQL语句的编写工作量较大，尤其当字段多、关联表多时，对开发人员编写SQL语句的功底有一定要求；

**2、** SQL语句依赖于数据库，导致数据库移植性差，不能随意更换数据库。


### 3、如何获取自动生成的(主)键值？

配置文件设置 usegeneratedkeys 为 true


### 4、JDBC编程有哪些不足之处，Mybatis是如何解决这些问题的？

**1、** 数据库连接的创建、释放频繁造成系统资源浪费从而影响了性能，如果使用数据库连接池就可以解决这个问题。当然JDBC同样能够使用数据源。

**2、** 在SQLMapConfig.xml中配置数据连接池，使用数据库连接池管理数据库连接。

**3、** SQL语句在写代码中不容易维护，事件需求中SQL变化的可能性很大，SQL变动需要改变JAVA代码。解决：将SQL语句配置在mapper.xml文件中与java代码分离。

**4、** 向SQL语句传递参数麻烦，因为SQL语句的where条件不一定，可能多，也可能少，占位符需要和参数一一对应。解决：Mybatis自动将java对象映射到sql语句。

**5、** 对结果集解析麻烦，sql变化导致解析代码变化，且解析前需要遍历，如果能将数据库记录封装成pojo对象解析比较方便。解决：Mbatis自动将SQL执行结果映射到java对象。


### 5、Mybatis 是否可以映射 Enum 枚举类？

Mybatis 可以映射枚举类，不单可以映射枚举类，Mybatis 可以映射任何对象到表的一

列上。映射方式为自定义一个 TypeHandler，实现 TypeHandler 的 setParameter()和

getResult()接口方法。TypeHandler 有两个作用，一是完成从 javaType 至 jdbcType 的转换，

二是完成 jdbcType 至 javaType 的转换，体现为 setParameter()和 getResult()两个方法，分别

代表设置 sql 问号占位符参数和获取列查询结果。


### 6、什么是Mybatis？

**1、** Mybatis是一个半ORM（对象关系映射）框架，它内部封装了JDBC，开发时只需要关注SQL语句本身，不需要花费精力去处理加载驱动、创建连接、创建statement等繁杂的过程。程序员直接编写原生态sql，可以严格控制sql执行性能，灵活度高。

**2、** MyBatis 可以使用 XML 或注解来配置和映射原生信息，将 POJO映射成数据库中的记录，避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。

**3、** 通过xml 文件或注解的方式将要执行的各种 statement 配置起来，并通过java对象和 statement中sql的动态参数进行映射生成最终执行的sql语句，最后由mybatis框架执行sql并将结果映射为java对象并返回。（从执行sql到返回result的过程）。


### 7、MyBatis是什么？

Mybatis 是一个半 ORM（对象关系映射）框架，它内部封装了 JDBC，开发时只需要关注 SQL 语句本身，不需要花费精力去处理加载驱动、创建连接、创建statement 等繁杂的过程。程序员直接编写原生态 sql，可以严格控制 sql 执行性能，灵活度高。

MyBatis 可以使用 XML 或注解来配置和映射原生信息，将 POJO 映射成数据库中的记录，避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。


### 8、如何执行批量插入?

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


### 9、模糊查询like语句该怎么写?

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


### 10、Mybatis是如何进行分页的？分页插件的原理是什么？

Mybatis使用RowBounds对象进行分页，它是针对ResultSet结果集执行的内存分页，而非物理分页。可以在sql内直接书写带有物理分页的参数来完成物理分页功能，也可以使用分页插件来完成物理分页。

分页插件的基本原理是使用Mybatis提供的插件接口，实现自定义插件，在插件的拦截方法内拦截待执行的sql，然后重写sql，根据dialect方言，添加对应的物理分页语句和物理分页参数。


### 11、什么是MyBatis的接口绑定？有哪些实现方式？
### 12、MyBatis 的好处是什么？
### 13、Mybatis是如何进行分页的？分页插件的原理是什么？
### 14、Mybatis 都有哪些 Executor 执行器？它们之间的区别是什么？
### 15、如何获取生成的主键
### 16、Mybatis的编程步骤是什么样的？
### 17、Mybatis 是否支持延迟加载？如果支持，它的实现原理是什么？
### 18、Mybatis的Xml映射文件中，不同的Xml映射文件，id是否可以重复？
### 19、MyBatis实现一对一有几种方式?具体怎么操作的？
### 20、Mybatis编程步骤 ？
### 21、Mybatis 映射文件中，如果 A 标签通过 include 引用了 B 标签的内容，请问，B 标签能
### 22、Mybatis的一级、二级缓存:
### 23、Mybatis是如何进行分页的？分页插件的原理是什么？
### 24、Mybatis的Xml映射文件中，不同的Xml映射文件，id是否可以重复？
### 25、Mybatis能执行一对多，一对一的联系查询吗，有哪些实现方法




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
