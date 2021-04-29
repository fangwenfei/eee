# MyBatis最新2021年面试题，高级面试题及附答案解析

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


### 2、IBatis 和 MyBatis 在核心处理类分别叫什么？

IBatis 里面的核心处理类交 SqlMapClient,MyBatis 里面的核心处理类叫做 SqlSession。


### 3、Mybatis的一级、二级缓存

**1、** 一级缓存: 基于 PerpetualCache 的 HashMap 本地缓存，其存储作用域为 Session，当 Session flush 或 close 之后，该 Session 中的所有 Cache 就将清空，默认打开一级缓存。

**2、** 二级缓存与一级缓存其机制相同，默认也是采用 PerpetualCache，HashMap 存储，不同在于其存储作用域为 Mapper(Namespace)，并且可自定义存储源，如 Ehcache。默认不打开二级缓存，要开启二级缓存，使用二级缓存属性类需要实现Serializable序列化接口(可用来保存对象的状态),可在它的映射文件中配置`<cache/>`

**3、** 对于缓存数据更新机制，当某一个作用域(一级缓存 Session/二级缓存Namespaces)的进行了C/U/D 操作后，默认该作用域下所有 select 中的缓存将被 clear。


### 4、Mybatis 的 Xml 映射文件中，不同的 Xml 映射文件，id 是否可以重复？

不同的 Xml 映射文件，如果配置了 namespace，那么 id 可以重复；如果没有配置

namespace，那么 id 不能重复；毕竟 namespace 不是必须的，只是最佳实践而已。原因就

是 namespace+id 是作为 Map<String, MappedStatement>的 key 使用的，如果没有

namespace，就剩下 id，那么，id 重复会导致数据互相覆盖。有了 namespace，自然 id 就

可以重复，namespace 不同，namespace+id 自然也就不同。


### 5、Mybatis 中如何指定使用哪一种 Executor 执行器？

在 Mybatis 配置文件中，可以指定默认的 ExecutorType 执行器类型，也可以手动给

DefaultSqlSessionFactory 的创建 SqlSession 的方法传递 ExecutorType 类型参数。


### 6、Mybatis是如何进行分页的？分页插件的原理是什么？

Mybatis使用RowBounds对象进行分页，它是针对ResultSet结果集执行的内存分页，而非物理分页。可以在sql内直接书写带有物理分页的参数来完成物理分页功能，也可以使用分页插件来完成物理分页。

分页插件的基本原理是使用Mybatis提供的插件接口，实现自定义插件，在插件的拦截方法内拦截待执行的sql，然后重写sql，根据dialect方言，添加对应的物理分页语句和物理分页参数。


### 7、Mybatis 是否可以映射 Enum 枚举类？

Mybatis 可以映射枚举类，不单可以映射枚举类，Mybatis 可以映射任何对象到表的一

列上。映射方式为自定义一个 TypeHandler，实现 TypeHandler 的 setParameter()和

getResult()接口方法。TypeHandler 有两个作用，一是完成从 javaType 至 jdbcType 的转换，

二是完成 jdbcType 至 javaType 的转换，体现为 setParameter()和 getResult()两个方法，分别

代表设置 sql 问号占位符参数和获取列查询结果。


### 8、MyBatis与Hibernate有哪些不同？
### 9、Mybatis动态sql是做什么的？都有哪些动态sql？
### 10、MyBatis与Hibernate有哪些不同？
### 11、简述 Mybatis 的 Xml 映射文件和 Mybatis 内部数据结构之间的映射关系？
### 12、MyBatis 的好处是什么？
### 13、当实体类中的属性名和表中的字段名不一样 ，怎么办 ？
### 14、什么是Mybatis？
### 15、Mybais 常用注解 ？
### 16、这个Dao接口的工作原理是什么？Dao接口里的方法，参数不同时，方法能重载吗
### 17、MyBatis框架适用场合：
### 18、为什么需要预编译
### 19、在 mapper 中如何传递多个参数？
### 20、Mybatis的一级、二级缓存:
### 21、Mybatis动态sql有什么用？执行原理？有哪些动态sql？
### 22、Mybatis 映射文件中，如果 A 标签通过 include 引用了 B 标签的内容，请问，B 标签能
### 23、通常一个 Xml 映射文件，都会写一个 Dao 接口与之对应, Dao 的工作原理，是否可以重
### 24、如何获取自动生成的(主)键值？
### 25、什么是 MyBatis？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
