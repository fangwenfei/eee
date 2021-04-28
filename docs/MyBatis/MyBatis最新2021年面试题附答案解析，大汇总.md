# MyBatis最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、MyBatis框架适用场合：

**1、** MyBatis专注于SQL本身，是一个足够灵活的DAO层解决方案；

**2、** 对性能的要求很高，或者需求变化较多的项目，如互联网项目，MyBatis将是不错的选择。


### 2、接口绑定有几种实现方式,分别是怎么实现的?

接口绑定有两种实现方式,一种是通过注解绑定,就是在接口的方法上面加上

@Select[@Update ](/Update ) 等注解里面包含 Sql 语句来绑定,另外一种就是通过 xml 里面写 SQL 来绑

定,在这种情况下,要指定 xml 映射文件里面的 namespace 必须为接口的全路径名.


### 3、Mybatis都有哪些Executor执行器？它们之间的区别是什么？

Mybatis有三种基本的Executor执行器，SimpleExecutor、ReuseExecutor、BatchExecutor。

**SimpleExecutor**：

每执行一次update或select，就开启一个Statement对象，用完立刻关闭Statement对象。

**ReuseExecutor**：

执行update或select，以sql作为key查找Statement对象，存在就使用，不存在就创建，用完后，不关闭Statement对象，而是放置于Map<String, Statement>内，供下一次使用。简言之，就是重复使用Statement对象。

**BatchExecutor**：

执行update（没有select，JDBC批处理不支持select），将所有sql都添加到批处理中（addBatch()），等待统一执行（executeBatch()），它缓存了多个Statement对象，每个Statement对象都是addBatch()完毕后，等待逐一执行executeBatch()批处理。与JDBC批处理相同。

作用范围：Executor的这些特点，都严格限制在SqlSession生命周期范围内。


### 4、#{}和${}的区别是什么？

`#{}`是预编译处理，${}是字符串替换。

Mybatis在处理#{}时，会将sql中的#{}替换为?号，调用PreparedStatement的set方法来赋值；

Mybatis在处理$${}时，就是把$${}替换成变量的值。

使用#{}可以有效的防止SQL注入，提高系统安全性。


### 5、这个Dao接口的工作原理是什么？Dao接口里的方法，参数不同时，方法能重载吗

Dao接口的工作原理是JDK动态代理，Mybatis运行时会使用JDK动态代理为Dao接口生成代理proxy对象，代理对象proxy会拦截接口方法，转而执行MappedStatement所代表的sql，然后将sql执行结果返回。

Dao接口里的方法，是不能重载的，因为是全限名+方法名的保存和寻找策略。


### 6、什么是Mybatis？

**1、** Mybatis是一个半ORM（对象关系映射）框架，它内部封装了JDBC，开发时只需要关注SQL语句本身，不需要花费精力去处理加载驱动、创建连接、创建statement等繁杂的过程；

**2、** MyBatis 可以使用 XML 或注解来配置和映射原生信息，将 POJO映射成数据库中的记录，避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集；

**3、** 通过xml 文件或注解的方式将要执行的各种 statement 配置起来，并通过java对象和 statement中[MySQL](https://www.wkcto.com/courses/MySQL.html)的动态参数进行映射生成最终执行的sql语句，最后由mybatis框架执行sql并将结果映射为java对象并返回。


### 7、如何获取自动生成的(主)键值?

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


### 8、Mybatis是如何进行分页的？分页插件的原理是什么？

Mybatis使用Row Bounds对象进行分页，它是针对Result Set结果集执行的内存分页，而非物理分页。可以在sql内直接书写带有物理分页的参数来完成物理分页功能，也可以使用分页插件来完成物理分页。

分页原理：分页插件的基本原理是使用Mybatis提供的插件接口，实现自定义插件，在插件的拦截方法内拦截待执行的sql，然后重写sql，根据dialect方言，添加对应的物理分页语句和物理分页参数。


### 9、JDBC编程有哪些不足之处，Mybatis是如何解决这些问题的？

**1、** 数据库连接的创建、释放频繁造成系统资源浪费从而影响了性能，如果使用数据库连接池就可以解决这个问题。当然JDBC同样能够使用数据源。

**2、** 在SQLMapConfig.xml中配置数据连接池，使用数据库连接池管理数据库连接。

**3、** SQL语句在写代码中不容易维护，事件需求中SQL变化的可能性很大，SQL变动需要改变JAVA代码。解决：将SQL语句配置在mapper.xml文件中与java代码分离。

**4、** 向SQL语句传递参数麻烦，因为SQL语句的where条件不一定，可能多，也可能少，占位符需要和参数一一对应。解决：Mybatis自动将java对象映射到sql语句。

**5、** 对结果集解析麻烦，sql变化导致解析代码变化，且解析前需要遍历，如果能将数据库记录封装成pojo对象解析比较方便。解决：Mbatis自动将SQL执行结果映射到java对象。


### 10、IBatis 和 MyBatis 在细节上的不同有哪些？

**1、** 在 sql 里面变量命名有原来的#变量# 变成了#{变量}

**2、** 原来的$$变量$$变成了${变量}

**3、** 原来在 sql 节点里面的 class 都换名字交 type

**4、** 原来的 queryForObject queryForList 变成了 selectOne selectList5、原来的别名设置在映


### 11、什么是Mybatis？
### 12、当实体类中的属性名和表中的字段名不一样 ，怎么办
### 13、模糊查询 like 语句该怎么写
### 14、MyBatis的功能架构是怎样的
### 15、模糊查询like语句该怎么写?
### 16、MyBatis 的好处是什么？
### 17、Mybatis的编程步骤是什么样的？
### 18、MyBatis与Hibernate有哪些不同？
### 19、Mybatis 能执行一对一、一对多的关联查询吗？都有哪些实现方式，以及它们之间的区
### 20、JDBC编程有哪些不足之处，MyBatis是如何解决这些问题的？
### 21、Mybatis 分页查询？
### 22、Mybatis 执行批量插入，能返回数据库主键列表吗？
### 23、使用 MyBatis 的 mapper 接口调用时有哪些要求？
### 24、Mybatis与Spring 的整合？
### 25、Mybatis 中如何执行批处理？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
