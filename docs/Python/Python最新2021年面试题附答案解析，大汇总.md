# Python最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、曾经使用过哪些前端框架

react，vue，bootstrap，elementUI，Echarts


### 2、什么是封装？

封装(Encapsulation)意味着将数据和成员函数包装在一起成为一个单元。

它还实现了数据隐藏的概念。


### 3、什么是codis

Codis 是一个分布式 Redis 解决方案, 对于上层的应用来说, 连接到 Codis Proxy 和连接原生的 Redis Server 没有明显的区别 (有一些命令不支持), 上层应用可以像使用单机的 Redis 一样使用, Codis 底层会处理请求的转发, 不停机的数据迁移等工作, 所有后边的一切事情, 对于前面的客户端来说是透明的, 可以简单的认为后边连接的是一个内存无限大的 Redis 服务，当然，前段时间Redis官方的3.0出了稳定版，3.0支持集群功能，codis的实现原理和3.0的集群功能差不多。


### 4、为什么基于tcp协议的通信比基于udp协议的通信更可靠

TCP是面向连接的传输协议，每次都需要建立一个可以相互信任的连接，中间有个三次握手过程。而UDP是面向无连接的传输协议，不需要建立安全的连接，


### 5、解释Python中reduce函数的用法？

reduce()函数接受一个函数和一个序列，并在计算后返回数值。

```
from functools import reduce

a = lambda x,y:x+y
print(reduce(a,[1,2,3,4]))

> 10
```


### 6、如果Redis中的某个列表中的数据量非常大，如何实现循环显示每一个值？

使用生成器一个一个取


### 7、什么是覆盖索引

**覆盖索引又可以称为索引覆盖。**

**1、** 解释一： 就是select的数据列只用从索引中就能够取得，不必从数据表中读取，换句话说查询列要被所使用的索引覆盖。

**2、** 解释二： 索引是高效找到行的一个方法，当能通过检索索引就可以读取想要的数据，那就不需要再到数据表中读取行了。如果一个索引包含了（或覆盖了）满足查询语句中字段与条件的数据就叫做覆盖索引。

**3、** 解释三： 是非聚集组合索引的一种形式，它包括在查询里的Select、Join和Where子句用到的所有列（即建立索引的字段正好是覆盖查询语句[select子句]与查询条件[Where子句]中所涉及的字段，也即，索引包含了查询正在查找的所有数据）。


### 8、traceroute使用哪种网络协议
### 9、使用with语句的好处是什么
### 10、1<(22)和1<22的结果分别是什么？
### 11、Redis是单进程单线程的吗？
### 12、求出以下代码的输出结果
### 13、Python中的Map Function是什么？
### 14、数据库锁的作用
### 15、什么是asyncio
### 16、什么是防火墙？防火墙的作用是什么？
### 17、什么是粘包？出现粘包的原因？
### 18、如何打乱一个排好序的列表
### 19、列举字符串、列表、元组、字典每个常用的5个方法
### 20、简述进程，线程，协程的区别以及应用场景？
### 21、MySQL慢日志
### 22、解释一下Python中的成员运算符
### 23、a=range(10),则a[::-3]的值是？
### 24、数据库的导入与导出命令
### 25、了解过Hbase，DB2，SQLServer，Access吗
### 26、有两个字符串列表a和b，每个字符串是由逗号隔开的一些字符
### 27、mro是什么？
### 28、简述生成器，迭代器，装饰器以及应用场景
### 29、解释Python的内置数据结构？
### 30、关于Python程序的运行方面，有什么手段能提升性能？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
