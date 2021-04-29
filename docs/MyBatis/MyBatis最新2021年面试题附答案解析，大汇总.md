# MyBatis最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、简述 Mybatis 的插件运行原理，以及如何编写一个插件？

**1、** Mybatis 仅可以编写针对 ParameterHandler、ResultSetHandler、StatementHandler、

Executor 这 4 种接口的插件，Mybatis 通过动态代理，为需要拦截的接口生成代理对象以实

现接口方法拦截功能，每当执行这 4 种接口对象的方法时，就会进入拦截方法，具体就是

InvocationHandler 的 invoke()方法，当然，只会拦截那些你指定需要拦截的方法。

**2、** 实现 Mybatis 的 Interceptor 接口并复写 intercept()方法，然后在给插件编写注解，指定

要拦截哪一个接口的哪些方法即可，记住，别忘了在配置文件中配置你编写的插件。


### 2、Mybatis 是否支持延迟加载？如果支持，它的实现原理是什么？

**1、** Mybatis 仅支持 association 关联对象和 collection 关联集合对象的延迟加载，association

指的就是一对一，collection 指的就是一对多查询。在 Mybatis 配置文件中，可以配置是否

启用延迟加载 lazyLoadingEnabled=true|false。

**2、** 它的原理是，使用 CGLIB 创建目标对象的代理对象，当调用目标方法时，进入拦截器方

法，比如调用 a.getB().getName()，拦截器 invoke()方法发现 a.getB()是 null 值，那么就会单

独发送事先保存好的查询关联 B 对象的 sql，把 B 查询上来，然后调用 a.setB(b)，于是 a 的

对象 b 属性就有值了，接着完成 a.getB().getName()方法的调用。这就是延迟加载的基本原

理。


### 3、JDBC编程有哪些不足之处，MyBatis是如何解决这些问题的？

**1、** 数据库链接创建、释放频繁造成系统资源浪费从而影响系统性能，使用数据库链接池可解决此问题。解决：在SqlMapConfig.xml中配置数据链接池，使用连接池管理数据库链接。

**2、** Sql语句写在代码中造成代码不易维护，实际应用sql变化的可能较大，sql变动需要改变java代码。解决：将Sql语句配置在XXXXmapper.xml文件中与java代码分离。

**3、** 向sql语句传参数麻烦，因为sql语句的where条件不一定，可能多也可能少，占位符需要和参数一一对应。解决： Mybatis 自动将 java 对象映射至 sql 语句。

**4、** 对结果集解析麻烦，sql 变化导致解析代码变化，且解析前需要遍历，如果能将数据库记录封装成 pojo对象解析比较方便。解决：Mybatis 自动将 sql 执行结果映射至java对象。


### 4、Mybatis是如何将sql执行结果封装为目标对象并返回的？都有哪些映射形式？

第一种是使用`<resultMap>`标签，逐一定义数据库列名和对象属性名之间的映射关系。

第二种是使用sql列的别名功能，将列的别名书写为对象属性名。

有了列名与属性名的映射关系后，Mybatis通过反射创建对象，同时使用反射给对象的属性逐一赋值并返回，那些找不到映射关系的属性，是无法完成赋值的。


### 5、Mybatis 比 IBatis 比较大的几个改进是什么？

**1、** 有接口绑定,包括注解绑定 sql 和 xml 绑定 Sql

**2、** 动态 sql 由原来的节点配置变成 OGNL 表达式 3、 在一对一,一对多的时候引进了

association,在一对多的时候引入了 collection 节点,不过都是在 resultMap 里面配置


### 6、Mybaits的优点：

**1、** 基于SQL语句编程，相当灵活，不会对应用程序或者数据库的现有设计造成任何影响，SQL写在XML里，解除sql与程序代码的耦合，便于统一管理；提供XML标签，支持编写动态SQL语句，并可重用。

**2、** 与JDBC相比，减少了50%以上的代码量，消除了JDBC大量冗余的代码，不需要手动开关连接；

**3、** 很好的与各种数据库兼容（因为MyBatis使用JDBC来连接数据库，所以只要JDBC支持的数据库MyBatis都支持）。

**4、** 能够与Spring很好的集成；

**5、** 提供映射标签，支持对象与数据库的ORM字段关系映射；提供对象关系映射标签，支持对象关系组件维护。


### 7、{}里面的名称对应的是Map里面的key名称。

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


### 8、MyBatis实现一对多有几种方式,怎么操作的？
### 9、什么是DBMS
### 10、使用 MyBatis 的 mapper 接口调用时有哪些要求？
### 11、使用MyBatis的mapper接口调用时有哪些要求？
### 12、一对一、一对多的关联查询 ？
### 13、Mybatis都有哪些Executor执行器？它们之间的区别是什么？
### 14、为什么说Mybatis是半自动ORM映射工具？它与全自动的区别在哪里？
### 15、讲下 MyBatis 的缓存
### 16、Mybatis的表关联的映射？
### 17、Mybatis的一级缓存和二级缓存？
### 18、SQLMapConfig.xml中配置有哪些内容？
### 19、为什么说 Mybatis 是半自动 ORM 映射工具？它与全自动的区别在哪里？
### 20、Mybatis如何执行批量操作
### 21、当实体类中的属性名和表中的字段名不一样 ，怎么办
### 22、MyBatis框架的缺点：
### 23、Mybatis映射文件中，如果A标签通过include引用了B标签的内容
### 24、#{}和${}的区别是什么？
### 25、Mybatis 执行批量插入，能返回数据库主键列表吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
