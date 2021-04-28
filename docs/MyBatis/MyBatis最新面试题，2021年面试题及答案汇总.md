# MyBatis最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Mybatis的Xml映射文件中，不同的Xml映射文件，id是否可以重复？

不同的Xml映射文件，如果配置了namespace，那么id可以重复；如果没有配置namespace，那么id不能重复；毕竟namespace不是必须的，只是最佳实践而已。

原因就是namespace+id是作为Map<String, MappedStatement>的key使用的，如果没有namespace，就剩下id，那么，id重复会导致数据互相覆盖。有了namespace，自然id就可以重复，namespace不同，namespace+id自然也就不同。


### 2、模糊查询 like 语句该怎么写

**1、** 在 java 中拼接通配符，通过#{}赋值

**2、** 在 Sql 语句中拼接通配符 （不安全 会引起 Sql 注入、


### 3、传统JDBC开发存在什么问题？

**1、** 频繁创建数据库连接对象、释放，容易造成系统资源浪费，影响系统性能。可以使用连接池解决这个问题。但是使用jdbc需要自己实现连接池。

**2、** sql语句定义、参数设置、结果集处理存在硬编码。实际项目中sql语句变化的可能性较大，一旦发生变化，需要修改java代码，系统需要重新编译，重新发布。不好维护。

**3、** 使用preparedStatement向占有位符号传参数存在硬编码，因为sql语句的where条件不一定，可能多也可能少，修改sql还要修改代码，系统不易维护。

**4、** 结果集处理存在重复代码，处理麻烦。如果可以映射成Java对象会比较方便。


### 4、一对一、一对多的关联查询 ？

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


### 5、什么情况下用注解绑定,什么情况下用 xml 绑定？

当 Sql 语句比较简单时候,用注解绑定；当 SQL 语句比较复杂时候,用 xml 绑定,一般用

xml 绑定的比较多


### 6、JDBC编程有哪些不足之处，MyBatis是如何解决这些问题的？

**1、** 数据库链接创建、释放频繁造成系统资源浪费从而影响系统性能，使用数据库链接池可解决此问题。解决：在SqlMapConfig.xml中配置数据链接池，使用连接池管理数据库链接。

**2、** Sql语句写在代码中造成代码不易维护，实际应用sql变化的可能较大，sql变动需要改变java代码。解决：将Sql语句配置在XXXXmapper.xml文件中与java代码分离。

**3、** 向sql语句传参数麻烦，因为sql语句的where条件不一定，可能多也可能少，占位符需要和参数一一对应。解决： Mybatis 自动将 java 对象映射至 sql 语句。

**4、** 对结果集解析麻烦，sql 变化导致解析代码变化，且解析前需要遍历，如果能将数据库记录封装成 pojo对象解析比较方便。解决：Mybatis 自动将 sql 执行结果映射至java对象。


### 7、Mybatis与Spring 的整合？

**1、** Spring Spring是一个轻量级控制反转(IOC)和面向切面(AOP)的容器框架；AOP和IOC是Spring框架重要的两个模块；控制反转就是改变对象的创建方式，将对象的创建和维护有开发人员创建改为由容器帮我们完成创建和维护。

**2、** Mybatis是支持SQL查询，存储过程和高级映射的优秀持久成框架。Mybatis几乎是消除了使用JDBC存在的重复创建和关闭连接，以及结果集查询的问题。它使用简单的xml或者注解用于配置和映射，将java的POjOs映射成数据库中的记录。

**3、** 整合，涉及的常用包： ![](https://atts.w3cschool.cn/attachments/image/20171124/1511515685952292.png#alt=)


### 8、模糊查询like语句该怎么写

- 1 ’%${question}%’ 可能引起SQL注入，不推荐
- 2 "%"#{question}"%" 注意：因为#{…}解析成sql语句时候，会在变量外侧自动加单引号’ '，所以这里 % 需要使用双引号" "，不能使用单引号 ’ '，不然会查不到任何结果。
- 3 CONCAT(’%’,#{question},’%’) 使用CONCAT()函数，（推荐）
- 4 使用bind标签（不推荐）

```
<select id="listUserLikeUsername" resultType="com.jourwon.pojo.User">
  <bind name="pattern" value="'%' + username + '%'" />
  select id,sex,age,username,password from person where username LIKE{pattern}
</select>
```


### 9、在mapper中如何传递多个参数?

**1、** 第一种：

**DAO层的函数**

```java
public UserselectUser(String name,String area);
        对应的xml,#{0}代表接收的是dao层中的第一个参数，#{1}代表dao层中第二参数，更多参数一致往后加即可。
```

```xml
<select id="selectUser"resultMap="BaseResultMap">
    select *  fromuser_user_t   whereuser_name = #{0} anduser_area=#{1}
</select>
```

**2、** 第二种： 使用 [@param ](/param ) 注解:

```java
public interface usermapper {
    user selectuser(@param(“username”) string username,@param(“hashedpassword”) string hashedpassword);
}
```

然后,就可以在xml像下面这样使用(推荐封装为一个map,作为单个参数传递给mapper):

```xml
<select id=”selectuser” resulttype=”user”>
        select id, username, hashedpassword
        from some_table
        where username = #{username}
        and hashedpassword = #{hashedpassword}
        </select>
```

**3、** 第三种：多个参数封装成map

```java
try {
        //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        //由于我们的参数超过了两个，而方法中只有一个Object参数收集，因此我们使用Map集合来装载我们的参数
        Map < String, Object > map = new HashMap();
        map.put("start", start);
        map.put("end", end);
        return sqlSession.selectList("StudentID.pagination", map);
        } catch (Exception e) {
        e.printStackTrace();
        sqlSession.rollback();
        throw e;
        } finally {
        MybatisUtil.closeSqlSession();
        }
```


### 10、Mybatis的编程步骤是什么样的？

首先创建Sql Session Factory；第二通过Sql Session Factory创建Sql Session；第三通过sqlsession执行数据库操作；其次调用session.commit()提交事务最后；调用session.close()关闭会话。


### 11、使用 MyBatis 的 mapper 接口调用时有哪些要求？
### 12、Mybatis 执行批量插入，能返回数据库主键列表吗？
### 13、MyBatis编程步骤是什么样的？
### 14、Mybatis都有哪些Executor执行器？它们之间的区别是什么？
### 15、Mapper编写有哪几种方式？
### 16、Mybatis是如何进行分页的？分页插件的原理是什么？
### 17、#{}和${}的区别是什么？
### 18、什么是DBMS
### 19、MyBatis是什么？
### 20、在mapper中如何传递多个参数
### 21、MyBatis框架的缺点有什么？
### 22、Mybatis是如何将sql执行结果封装为目标对象并返回的？都有哪些映射形式？
### 23、简述 Mybatis 的插件运行原理，以及如何编写一个插件？
### 24、Mybatis是否可以映射Enum枚举类？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
