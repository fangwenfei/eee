# MyBatis最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Mybatis是如何将sql执行结果封装为目标对象并返回的？都有哪些映射形式？

**1、** 第一种是使用标签，逐一定义数据库列名和对象属性名之间的映射关系。

**2、** 第二种是使用sql列的别名功能，将列的别名书写为对象属性名。有了列名与属性名的映射关系后，Mybatis通过反射创建对象，同时使用反射给对象的属性逐一赋值并返回，那些找不到映射关系的属性，是无法完成赋值的。


### 2、一对一、一对多的关联查询 ？

```xml
<mapper namespace="com.lcb.mapping.userMapper">
    <!--association  一对一关联查询 -->
    <select id="getClass" parameterType="int" resultMap="ClassesResultMap">
        select * from class c,teacher t where c.teacher_id=t.t_id and c.c_id=#{id}
    </select>

    <resultMap type="com.lcb.user.Classes" id="ClassesResultMap">
        <!-- 实体类的字段名和数据表的字段名映射 -->
        <id property="id" column="c_id"/>
        <result property="name" column="c_name"/>
        <association property="teacher" javaType="com.lcb.user.Teacher">
            <id property="id" column="t_id"/>
            <result property="name" column="t_name"/>
        </association>
    </resultMap>


    <!--collection  一对多关联查询 -->
    <select id="getClass2" parameterType="int" resultMap="ClassesResultMap2">
        select * from class c,teacher t,student s where c.teacher_id=t.t_id and c.c_id=s.class_id and c.c_id=#{id}
    </select>

    <resultMap type="com.lcb.user.Classes" id="ClassesResultMap2">
        <id property="id" column="c_id"/>
        <result property="name" column="c_name"/>
        <association property="teacher" javaType="com.lcb.user.Teacher">
            <id property="id" column="t_id"/>
            <result property="name" column="t_name"/>
        </association>

        <collection property="student" ofType="com.lcb.user.Student">
            <id property="id" column="s_id"/>
            <result property="name" column="s_name"/>
        </collection>
    </resultMap>
</mapper>
```


### 3、Mybatis优缺点

**优点**

**与传统的数据库访问技术相比，ORM有以下优点：**

**1、** 基于SQL语句编程，相当灵活，不会对应用程序或者数据库的现有设计造成任何影响，SQL写在XML里，解除sql与程序代码的耦合，便于统一管理；提供XML标签，支持编写动态SQL语句，并可重用

**2、** 与JDBC相比，减少了50%以上的代码量，消除了JDBC大量冗余的代码，不需要手动开关连接

**3、** 很好的与各种数据库兼容（因为MyBatis使用JDBC来连接数据库，所以只要JDBC支持的数据库MyBatis都支持）

**4、** 提供映射标签，支持对象与数据库的ORM字段关系映射；提供对象关系映射标签，支持对象关系组件维护

**5、** 能够与Spring很好的集成

**缺点**

SQL语句的编写工作量较大，尤其当字段多、关联表多时，对开发人员编写SQL语句的功底有一定要求

SQL语句依赖于数据库，导致数据库移植性差，不能随意更换数据库


### 4、简述 Mybatis 的 Xml 映射文件和 Mybatis 内部数据结构之间的映射关系？

Mybatis 将所有 Xml 配置信息都封装到 All-In-One 重量级对象 Configuration 内部。在

Xml 映射文件中，标签会被解析为 ParameterMap 对象，其每个子元素会

被解析为 ParameterMapping 对象。标签会被解析为 ResultMap 对象，其每个子

元素会被解析为 ResultMapping 对象。每一个、、、标签

均会被解析为 MappedStatement 对象，标签内的 sql 会被解析为 BoundSql 对象。


### 5、MyBatis的功能架构是怎样的

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/041/14/55_2.png#alt=55%5C_2.png)

**我们把Mybatis的功能架构分为三层：**

**1、** API接口层：提供给外部使用的接口API，开发人员通过这些本地API来操纵数据库。接口层一接收到调用请求就会调用数据处理层来完成具体的数据处理。

**2、** 数据处理层：负责具体的SQL查找、SQL解析、SQL执行和执行结果映射处理等。它主要的目的是根据调用的请求完成一次数据库操作。

**3、** 基础支撑层：负责最基础的功能支撑，包括连接管理、事务管理、配置加载和缓存处理，这些都是共用的东西，将他们抽取出来作为最基础的组件。为上层的数据处理层提供最基础的支撑。


### 6、Mybatis动态sql有什么用？执行原理？有哪些动态sql？

Mybatis动态sql可以在Xml映射文件内，以标签的形式编写动态sql，执行原理是根据表达式的值 完成逻辑判断并动态拼接sql的功能。

Mybatis提供了9种动态sql标签：`trim | where | set | foreach | if | choose | when | otherwise | bind`。


### 7、IBatis 和 MyBatis 在核心处理类分别叫什么？

IBatis 里面的核心处理类交 SqlMapClient,MyBatis 里面的核心处理类叫做 SqlSession。


### 8、Mybatis的映射文件 ？

Mybatis 真正强大的在于它的映射文件，它和JDBC代码进行比较，可以省掉95%的代码，Mybatis就是针对SQL进行构建。

**SQL映射文件中几个顶级的元素：**

**1、** cache – 给定命名空间的缓存配置。

**2、** cache-ref – 其他命名空间缓存配置的引用。

**3、** resultMap – 是最复杂也是最强大的元素，用来描述如何从数据库结果集中来加载对象。

**4、** sql – 可被其他语句引用的可重用语句块

**5、** insert – 映射插入语句

**6、** update – 映射更新语句

**7、** delete – 映射删除语句

**8、** select – 映射查询语句


### 9、Mybatis的一级、二级缓存:

1）一级缓存: 基于 PerpetualCache 的 HashMap 本地缓存，其存储作用域为 Session，当 Session flush 或 close 之后，该 Session 中的所有 Cache 就将清空，默认打开一级缓存。

2）二级缓存与一级缓存其机制相同，默认也是采用 PerpetualCache，HashMap 存储，不同在于其存储作用域为 Mapper(Namespace)，并且可自定义存储源，如 Ehcache。默认不打开二级缓存，要开启二级缓存，使用二级缓存属性类需要实现Serializable序列化接口(可用来保存对象的状态),可在它的映射文件中配置`<cache/>` ；

3）对于缓存数据更新机制，当某一个作用域(一级缓存 Session/二级缓存Namespaces)的进行了C/U/D 操作后，默认该作用域下所有 select 中的缓存将被 clear。


### 10、Mybais 常用注解 ？

[@Insert ](/Insert ) ： 插入sql , 和xml insert sql语法完全一样

[@Select ](/Select ) ： 查询sql, 和xml select sql语法完全一样

[@Update ](/Update ) ： 更新sql, 和xml update sql语法完全一样

[@Delete ](/Delete ) ： 删除sql, 和xml delete sql语法完全一样

[@Param ](/Param ) ： 入参

[@Results ](/Results ) ：结果集合

[@Result ](/Result ) ： 结果


### 11、Mybatis中如何指定使用哪一种Executor执行器？
### 12、通常一个Xml映射文件，都会写一个Dao接口与之对应
### 13、什么是 MyBatis？
### 14、JDBC编程有哪些不足之处，MyBatis是如何解决的？
### 15、Mybatis 是否支持延迟加载？如果支持，它的实现原理是什么？
### 16、Xml 映射文件中，除了常见的 select|insert|updae|delete 标签之外，还有哪些标签？
### 17、Mybatis 是如何将 sql 执行结果封装为目标对象并返回的？都有哪些映射形式？
### 18、MyBatis与Hibernate有哪些不同？
### 19、Mybatis 分页查询？
### 20、为什么需要预编译
### 21、什么是Mybatis？
### 22、如何获取自动生成的(主)键值？
### 23、什么情况下用注解绑定,什么情况下用 xml 绑定？
### 24、MyBatis编程步骤是什么样的？
### 25、请说说MyBatis的工作原理




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
