# MyBatis最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、简述Mybatis的Xml映射文件和Mybatis内部数据结构之间的映射关系？

Mybatis将所有Xml配置信息都封装到All-In-One重量级对象Configuration内部。在Xml映射文件中，`<parameterMap>`标签会被解析为ParameterMap对象，其每个子元素会被解析为ParameterMapping对象。`<resultMap>`标签会被解析为ResultMap对象，其每个子元素会被解析为ResultMapping对象。每一个`<select>`、`<insert>`、`<update>`、`<delete>`标签均会被解析为MappedStatement对象，标签内的sql会被解析为BoundSql对象。


### 2、什么是 MyBatis 的接口绑定,有什么好处？

接口映射就是在 MyBatis 中任意定义接口,然后把接口里面的方法和 SQL 语句绑定,我们

直接调用接口方法就可以,这样比起原来了 SqlSession 提供的方法我们可以有更加灵活的选

择和设置.


### 3、JDBC编程有哪些不足之处，Mybatis是如何解决这些问题的？

**1、** 数据库连接的创建、释放频繁造成系统资源浪费从而影响了性能，如果使用数据库连接池就可以解决这个问题。当然JDBC同样能够使用数据源。

**2、** 在SQLMapConfig.xml中配置数据连接池，使用数据库连接池管理数据库连接。

**3、** SQL语句在写代码中不容易维护，事件需求中SQL变化的可能性很大，SQL变动需要改变JAVA代码。解决：将SQL语句配置在mapper.xml文件中与java代码分离。

**4、** 向SQL语句传递参数麻烦，因为SQL语句的where条件不一定，可能多，也可能少，占位符需要和参数一一对应。解决：Mybatis自动将java对象映射到sql语句。

**5、** 对结果集解析麻烦，sql变化导致解析代码变化，且解析前需要遍历，如果能将数据库记录封装成pojo对象解析比较方便。解决：Mbatis自动将SQL执行结果映射到java对象。


### 4、MyBatis实现一对一有几种方式?具体怎么操作的？

有联合查询和嵌套查询,联合查询是几个表联合查询,只查询一次, 通过在resultMap里面配置association节点配置一对一的类就可以完成；

嵌套查询是先查一个表，根据这个表里面的结果的 外键id，去再另外一个表里面查询数据,也是通过association配置，但另外一个表的查询通过select属性配置。


### 5、SQLMapConfig.xml中配置有哪些内容？

properties（属性） settings（配置） typeAliases（类型别名） typeHandlers（类型处理器） objectFactory（对象工厂） plugins（插件） environments（环境集合属性对象） environment（环境子属性对象） transactionManager（事务管理） dataSource（数据源） mappers（映射器）


### 6、MyBatis 的好处是什么？

**1、** MyBatis 把 sql 语句从 Java 源程序中独立出来，放在单独的 XML 文件中编写，给程序的

维护带来了很大便利。

**2、** MyBatis 封装了底层 JDBC API 的调用细节，并能自动将结果集转换成 Java Bean 对象，

大大简化了 Java 数据库编程的重复工作。

**3、** 因为 MyBatis 需要程序员自己去编写 sql 语句，程序员可以结合数据库自身的特点灵活

控制 sql 语句，因此能够实现比 Hibernate 等全自动 orm 框架更高的查询效率，能够完成复

杂查询。


### 7、Mybatis 比 IBatis 比较大的几个改进是什么？

**1、** 有接口绑定,包括注解绑定 sql 和 xml 绑定 Sql

**2、** 动态 sql 由原来的节点配置变成 OGNL 表达式 3、 在一对一,一对多的时候引进了

association,在一对多的时候引入了 collection 节点,不过都是在 resultMap 里面配置


### 8、Mybais 常用注解 ？

[@Insert ](/Insert ) ： 插入sql , 和xml insert sql语法完全一样

[@Select ](/Select ) ： 查询sql, 和xml select sql语法完全一样

[@Update ](/Update ) ： 更新sql, 和xml update sql语法完全一样

[@Delete ](/Delete ) ： 删除sql, 和xml delete sql语法完全一样

[@Param ](/Param ) ： 入参

[@Results ](/Results ) ：结果集合

[@Result ](/Result ) ： 结果


### 9、如何获取自动生成的(主)键值?

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


### 10、什么是DBMS

DBMS：数据库管理系统(database management system)是一种操纵和管理数据库的大型软件，用于建立、使用和维护数zd据库，简称dbms。它对数据库进行统一的管理和控制，以保证数据库的安全性和完整性。用户通过dbms访问数据库中的数据，数据库管理员也通过dbms进行数据库的维护工作。它可使多个应用程序和用户用不同的方法在同时版或不同时刻去建立，修改和询问数据库。DBMS提供数据定义语言[DDL](https://www.baidu.com/s?wd=DDL&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)（Data Definition Language）与数据操作语言[DML](https://www.baidu.com/s?wd=DML&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)（Data Manipulation Language），供用户定义数据库的模式结构与权限约束，实现对数据的追加权、删除等操作。


### 11、Mybatis动态sql是做什么的？都有哪些动态sql？
### 12、Mybatis 是否可以映射 Enum 枚举类？
### 13、Xml映射文件中，除了常见的select|insert|updae|delete标签之外，还有哪些标签？
### 14、Mybatis 是如何进行分页的？分页插件的原理是什么？
### 15、如何执行批量插入?
### 16、MyBatis框架的缺点有什么？
### 17、Mybaits的优点：
### 18、MyBatis编程步骤是什么样的？
### 19、为什么需要预编译
### 20、传统JDBC开发存在什么问题？
### 21、Mybatis 中如何执行批处理？
### 22、Mybatis优缺点
### 23、为什么说Mybatis是半自动ORM映射工具？它与全自动的区别在哪里？
### 24、Mybatis的映射文件 ？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
