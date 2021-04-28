# MyBatis最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、MyBatis 实现一对一有几种方式?具体怎么操作的？

有联合查询和嵌套查询,联合查询是几个表联合查询,只查询一次,通过在 resultMap 里面

配置 association 节点配置一对一的类就可以完成;嵌套查询是先查一个表,根据这个表里面

的结果的外键 id,去再另外一个表里面查询数据,也是通过 association 配置,但另外一个表的

查询通过 select 属性配置。


### 2、{}里面的名称对应的是Map里面的key名称。

这种方法适合传递多个参数，且参数易变能灵活传递的情况。（推荐使用）。

**方法4：Java Bean传参法**

```
public User selectUser(User user);

<select id="selectUser" parameterType="com.jourwon.pojo.User" resultMap="UserResultMap">
select * from user
where user_name ={userName} and dept_id ={deptId}
</select>
```

**1、** #{}里面的名称对应的是User类里面的成员属性。

**2、** 这种方法直观，需要建一个实体类，扩展不容易，需要加属性，但代码可读性强，业务逻辑处理方便，推荐使用。（推荐使用）。


### 3、Mybatis能执行一对多，一对一的联系查询吗，有哪些实现方法

能，不止可以一对多，一对一还可以多对多，一对多

**实现方式：**

**1、** 单独发送一个SQL去查询关联对象，赋给主对象，然后返回主对象

**2、** 使用嵌套查询，似JOIN查询，一部分是A对象的属性值，另一部分是关联对 象 B的属性值，好处是只要发送一个属性值，就可以把主对象和关联对象查出来

**3、** 子查询


### 4、resultType resultMap 的区别？

**1、** 类的名字和数据库相同时，可以直接设置 resultType 参数为 Pojo 类

**2、** 若不同，需要设置 resultMap 将结果名字和 Pojo 名字进行转换


### 5、Mybatis 执行批量插入，能返回数据库主键列表吗？

能，JDBC 都能，Mybatis 当然也能。


### 6、Mybatis 比 IBatis 比较大的几个改进是什么？

**1、** 有接口绑定,包括注解绑定 sql 和 xml 绑定 Sql

**2、** 动态 sql 由原来的节点配置变成 OGNL 表达式 3、 在一对一,一对多的时候引进了

association,在一对多的时候引入了 collection 节点,不过都是在 resultMap 里面配置


### 7、#{}和${}的区别

**1、** #{}是占位符，预编译处理；${}是拼接符，字符串替换，没有预编译处理。

**2、** Mybatis在处理#{}时，#{}传入参数是以字符串传入，会将SQL中的#{}替换为?号，调用PreparedStatement的set方法来赋值。

**3、** #{} 可以有效的防止SQL注入，提高系统安全性；${} 不能防止SQL 注入

**4、** #{} 的变量替换是在DBMS 中；${} 的变量替换是在 DBMS 外


### 8、在mapper中如何传递多个参数?

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


### 9、MyBatis和Hibernate的适用场景?

**1、** MyBatis专注于SQL本身，是一个足够灵活的DAO层解决方案。

**2、** 对性能的要求很高，或者需求变化较多的项目，如互联网项目，MyBatis将是不错的选择。

**开发难易程度和学习成本**

Hibernate 是重量级框架，学习使用门槛高，适合于需求相对稳定，中小型的项目，比如：办公自动化系统

MyBatis 是轻量级框架，学习使用门槛低，适合于需求变化频繁，大型的项目，比如：互联网电子商务系统

**总结**

**1、** MyBatis 是一个小巧、方便、高效、简单、直接、半自动化的持久层框架，

**2、** Hibernate 是一个强大、方便、高效、复杂、间接、全自动化的持久层框架。


### 10、Mybatis 是否可以映射 Enum 枚举类？

Mybatis 可以映射枚举类，不单可以映射枚举类，Mybatis 可以映射任何对象到表的一

列上。映射方式为自定义一个 TypeHandler，实现 TypeHandler 的 setParameter()和

getResult()接口方法。TypeHandler 有两个作用，一是完成从 javaType 至 jdbcType 的转换，

二是完成 jdbcType 至 javaType 的转换，体现为 setParameter()和 getResult()两个方法，分别

代表设置 sql 问号占位符参数和获取列查询结果。


### 11、模糊查询like语句该怎么写
### 12、当实体类中的属性名和表中的字段名不一样 ，怎么办
### 13、SQLMapConfig.xml中配置有哪些内容？
### 14、Mybatis编程步骤 ？
### 15、如何获取生成的主键
### 16、使用MyBatis的mapper接口调用时有哪些要求？
### 17、什么是DBMS
### 18、Mybatis是如何进行分页的？分页插件的原理是什么？
### 19、简述Mybatis的插件运行原理，以及如何编写一个插件。
### 20、Xml映射文件中，除了常见的select|insert|updae|delete标签之外，还有哪些标签？
### 21、#{}和${}的区别是什么？
### 22、Mybatis的一级、二级缓存
### 23、Mybatis动态SQL？
### 24、为什么说 Mybatis 是半自动 ORM 映射工具？它与全自动的区别在哪里？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
