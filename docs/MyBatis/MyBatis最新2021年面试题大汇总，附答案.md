# MyBatis最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、JDBC编程有哪些不足之处，MyBatis是如何解决这些问题的？

**1、** 数据库链接创建、释放频繁造成系统资源浪费从而影响系统性能，使用数据库链接池可解决此问题。解决：在SqlMapConfig.xml中配置数据链接池，使用连接池管理数据库链接。

**2、** Sql语句写在代码中造成代码不易维护，实际应用sql变化的可能较大，sql变动需要改变java代码。解决：将Sql语句配置在XXXXmapper.xml文件中与java代码分离。

**3、** 向sql语句传参数麻烦，因为sql语句的where条件不一定，可能多也可能少，占位符需要和参数一一对应。解决： Mybatis 自动将 java 对象映射至 sql 语句。

**4、** 对结果集解析麻烦，sql 变化导致解析代码变化，且解析前需要遍历，如果能将数据库记录封装成 pojo对象解析比较方便。解决：Mybatis 自动将 sql 执行结果映射至java对象。


### 2、Mybatis映射文件中，如果A标签通过include引用了B标签的内容

**请问，B标签能否定义在A标签的后面，还是说必须定义在A标签的前面？**

虽然Mybatis解析Xml映射文件是按照顺序解析的，但是，被引用的B标签依然可以定义在任何地方，Mybatis都可以正确识别。

原理是，Mybatis解析A标签，发现A标签引用了B标签，但是B标签尚未解析到，尚不存在，此时，Mybatis会将A标签标记为未解析状态，然后继续解析余下的标签，包含B标签，待所有标签解析完毕，Mybatis会重新解析那些被标记为未解析的标签，此时再解析A标签时，B标签已经存在，A标签也就可以正常解析完成了。


### 3、IBatis 和 MyBatis 在细节上的不同有哪些？

**1、** 在 sql 里面变量命名有原来的#变量# 变成了#{变量}

**2、** 原来的$$变量$$变成了${变量}

**3、** 原来在 sql 节点里面的 class 都换名字交 type

**4、** 原来的 queryForObject queryForList 变成了 selectOne selectList5、原来的别名设置在映


### 4、MyBatis框架的缺点有什么？

**1、** SQL语句的编写工作量较大，尤其当字段多、关联表多时，对开发人员编写SQL语句的功底有一定要求；

**2、** SQL语句依赖于数据库，导致数据库移植性差，不能随意更换数据库。


### 5、Mybaits的优点：

**1、** 基于SQL语句编程，相当灵活，不会对应用程序或者数据库的现有设计造成任何影响，SQL写在XML里，解除sql与程序代码的耦合，便于统一管理；提供XML标签，支持编写动态SQL语句，并可重用。

**2、** 与JDBC相比，减少了50%以上的代码量，消除了JDBC大量冗余的代码，不需要手动开关连接；

**3、** 很好的与各种数据库兼容（因为MyBatis使用JDBC来连接数据库，所以只要JDBC支持的数据库MyBatis都支持）。

**4、** 能够与Spring很好的集成；

**5、** 提供映射标签，支持对象与数据库的ORM字段关系映射；提供对象关系映射标签，支持对象关系组件维护。


### 6、MyBatis与Hibernate有哪些不同？

**1、** Mybatis和hibernate不同，它不完全是一个ORM框架，因为MyBatis需要程序员自己编写Sql语句；

**2、** Mybatis直接编写原生态sql，可以严格控制sql执行性能，灵活度高，非常适合对关系数据模型要求不高的软件开发，因为这类软件需求变化频繁，一但需求变化要求迅速输出成果。但是灵活的前提是mybatis无法做到数据库无关性，如果需要实现支持多种数据库的软件，则需要自定义多套sql映射文件，工作量大；

**3、** Hibernate对象/关系映射能力强，数据库无关性好，对于关系模型要求高的软件，如果用hibernate开发可以节省很多代码，提高效率。


### 7、什么是Mybatis？

**1、** Mybatis是一个半ORM（对象关系映射）框架，它内部封装了JDBC，开发时只需要关注SQL语句本身，不需要花费精力去处理加载驱动、创建连接、创建statement等繁杂的过程。程序员直接编写原生态sql，可以严格控制sql执行性能，灵活度高。

**2、** MyBatis 可以使用 XML 或注解来配置和映射原生信息，将 POJO映射成数据库中的记录，避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。

**3、** 通过xml 文件或注解的方式将要执行的各种 statement 配置起来，并通过java对象和 statement中sql的动态参数进行映射生成最终执行的sql语句，最后由mybatis框架执行sql并将结果映射为java对象并返回。（从执行sql到返回result的过程）。


### 8、什么是 MyBatis 的接口绑定,有什么好处？

接口映射就是在 MyBatis 中任意定义接口,然后把接口里面的方法和 SQL 语句绑定,我们

直接调用接口方法就可以,这样比起原来了 SqlSession 提供的方法我们可以有更加灵活的选

择和设置.


### 9、SQLMapConfig.xml中配置有哪些内容？

properties（属性） settings（配置） typeAliases（类型别名） typeHandlers（类型处理器） objectFactory（对象工厂） plugins（插件） environments（环境集合属性对象） environment（环境子属性对象） transactionManager（事务管理） dataSource（数据源） mappers（映射器）


### 10、什么是DBMS

DBMS：数据库管理系统(database management system)是一种操纵和管理数据库的大型软件，用于建立、使用和维护数zd据库，简称dbms。它对数据库进行统一的管理和控制，以保证数据库的安全性和完整性。用户通过dbms访问数据库中的数据，数据库管理员也通过dbms进行数据库的维护工作。它可使多个应用程序和用户用不同的方法在同时版或不同时刻去建立，修改和询问数据库。DBMS提供数据定义语言[DDL](https://www.baidu.com/s?wd=DDL&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)（Data Definition Language）与数据操作语言[DML](https://www.baidu.com/s?wd=DML&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)（Data Manipulation Language），供用户定义数据库的模式结构与权限约束，实现对数据的追加权、删除等操作。


### 11、Mybatis的映射文件 ？
### 12、一对一、一对多的关联查询 ？
### 13、MyBatis 与 Hibernate 有哪些不同？
### 14、Mybatis的表关联的映射？
### 15、什么是 MyBatis？
### 16、如何执行批量插入?
### 17、使用 MyBatis 的 mapper 接口调用时有哪些要求？
### 18、Mapper编写有哪几种方式？
### 19、MyBatis 实现一对一有几种方式?具体怎么操作的？
### 20、Mybatis的编程步骤是什么样的？
### 21、如何获取生成的主键
### 22、在 mapper 中如何传递多个参数？
### 23、{}里面的名称对应的是Map里面的key名称。
### 24、Xml映射文件中，除了常见的select|insert|updae|delete标签之外，还有哪些标签？
### 25、什么情况下用注解绑定,什么情况下用 xml 绑定？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
