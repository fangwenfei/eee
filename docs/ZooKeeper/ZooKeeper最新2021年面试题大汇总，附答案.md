# ZooKeeper最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、CAP理论？

**1、** C : Consistency 一致性,数据在多个副本之间似否能够保持一致的特性。

**2、** A: Availability 可用性，系统服务必须一直处于可用状态，对每个请求总是在指定的时间返回结果。

**3、** P:Partition tolerance 分区容错性,遇到分区网络故障时，仍能对外提供一致性和可用性的服务。

不能同时满足3个要求，只能满足其中的两个。


### 2、四种类型的znode

**1、** PERSISTENT-持久化目录节点

客户端与zookeeper断开连接后，该节点依旧存在

**2、** PERSISTENT_SEQUENTIAL-持久化顺序编号目录节点

客户端与zookeeper断开连接后，该节点依旧存在，只是Zookeeper给该节点名称进行顺序编号

**3、** EPHEMERAL-临时目录节点

客户端与zookeeper断开连接后，该节点被删除

**4、** EPHEMERAL_SEQUENTIAL-临时顺序编号目录节点

客户端与zookeeper断开连接后，该节点被删除，只是Zookeeper给该节点名称进行顺序编号

![](https://segmentfault.com/img/bV8Xel?w=371&h=463#alt=clipboard.png)


### 3、ACL权限控制机制

UGO（User/Group/Others）

目前在Linux/Unix文件系统中使用，也是使用最广泛的权限控制方式。是一种粗粒度的文件系统权限控制模式。

ACL（Access Control List）访问控制列表

**包括三个方面：**

**权限模式（Scheme）**

**1、** IP：从IP地址粒度进行权限控制

**2、** Digest：最常用，用类似于 username:password 的权限标识来进行权限配置，便于区分不同应用来进行权限控制

**3、** World：最开放的权限控制方式，是一种特殊的digest模式，只有一个权限标识“world:anyone”

**4、** Super：超级用户

**授权对象**

授权对象指的是权限赋予的用户或一个指定实体，例如IP地址或是机器灯。

**权限 Permission**

**1、** CREATE：数据节点创建权限，允许授权对象在该Znode下创建子节点

**2、** DELETE：子节点删除权限，允许授权对象删除该数据节点的子节点

**3、** READ：数据节点的读取权限，允许授权对象访问该数据节点并读取其数据内容或子节点列表等

**4、** WRITE：数据节点更新权限，允许授权对象对该数据节点进行更新操作

**5、** ADMIN：数据节点管理权限，允许授权对象对该数据节点进行ACL相关设置操作


### 4、ZooKeeper 面试题？

ZooKeeper是一个开放源码的分布式协调服务，它是集群的管理者，监视着集群中各个节点的状态根据节点提交的反馈进行下一步合理操作。最终，将简单易用的接口和性能高效、功能稳定的系统提供给用户。

分布式应用程序可以基于Zookeeper实现诸如数据发布/订阅、负载均衡、命名服务、分布式协调/通知、集群管理、Master选举、分布式锁和分布式队列等功能。

**Zookeeper保证了如下分布式一致性特性：**

**1、** 顺序一致性

**2、** 原子性

**3、** 单一视图

**4、** 可靠性

**5、** 实时性（最终一致性）

客户端的读请求可以被集群中的任意一台机器处理，如果读请求在节点上注册了监听器，这个监听器也是由所连接的zookeeper机器来处理。对于写请求，这些请求会同时发给其他zookeeper机器并且达成一致后，请求才会返回成功。因此，随着zookeeper的集群机器增多，读请求的吞吐会提高但是写请求的吞吐会下降。

有序性是zookeeper中非常重要的一个特性，所有的更新都是全局有序的，每个更新都有一个唯一的时间戳，这个时间戳称为zxid（Zookeeper Transaction Id）。而读请求只会相对于更新有序，也就是读请求的返回结果中会带有这个zookeeper最新的zxid。


### 5、ZNode的类型？

**1、** 持久节点：一旦创建，除非主动移除，否则会一直保存在ZooKeeper。

**2、** 临时节点：生命周期和客户端会话绑定，会话失效，相关的临时节点被移除。

**3、** 持久顺序性：同时具备顺序性。

**4、** 临时顺序性：同时具备顺序性。


### 6、zookeeper 负载均衡和 nginx 负载均衡区别

zk 的负载均衡是可以调控，nginx 只是能调权重，其他需要可控的都需要自己写插件；但是 nginx 的吞吐量比 zk 大很多，应该说按业务选择用哪种方式。


### 7、Zookeeper做了什么？

**1、** 命名服务

**2、** 配置管理

**3、** 集群管理

**4、** 分布式锁

**5、** 队列管理


### 8、Zookeeper 和 Dubbo 的关系？

**Zookeeper的作用：**

zookeeper用来注册服务和进行负载均衡，哪一个服务由哪一个机器来提供必需让调用者知道，简单来说就是ip地址和服务名称的对应关系。当然也可以通过硬编码的方式把这种对应关系在调用方业务代码中实现，但是如果提供服务的机器挂掉调用者无法知晓，如果不更改代码会继续请求挂掉的机器提供服务。zookeeper通过心跳机制可以检测挂掉的机器并将挂掉机器的ip和服务对应关系从列表中删除。至于支持高并发，简单来说就是横向扩展，在不更改代码的情况通过添加机器来提高运算能力。通过添加新的机器向zookeeper注册服务，服务的提供者多了能服务的客户就多了。

**dubbo：**

dubbo是管理中间层的工具，在业务层到数据仓库间有非常多服务的接入和服务提供者需要调度，dubbo提供一个框架解决这个问题。

注意这里的dubbo只是一个框架，至于你架子上放什么是完全取决于你的，就像一个汽车骨架，你需要配你的轮子引擎。这个框架中要完成调度必须要有一个分布式的注册中心，储存所有服务的元数据，你可以用zk，也可以用别的，只是大家都用zk。

**zookeeper和dubbo的关系：**

Dubbo 的将注册中心进行抽象，它可以外接不同的存储媒介给注册中心提供服务，有 ZooKeeper，Memcached，Redis 等。

引入了 ZooKeeper 作为存储媒介，也就把 ZooKeeper 的特性引进来。首先是负载均衡，单注册中心的承载能力是有限的，在流量达到一定程度的时 候就需要分流，负载均衡就是为了分流而存在的，一个 ZooKeeper 群配合相应的 Web 应用就可以很容易达到负载均衡；资源同步，单单有负载均衡还不 够，节点之间的数据和资源需要同步，ZooKeeper 集群就天然具备有这样的功能；命名服务，将树状结构用于维护全局的服务地址列表，服务提供者在启动 的时候，向 ZooKeeper 上的指定节点 /dubbo/${serviceName}/providers 目录下写入自己的 URL 地址，这个操作就完成了服务的发布。 其他特性还有 Mast 选举，分布式锁等。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/052/19/71_2.png#alt=71%5C_2.png)


### 9、获取指定节点信息？

get path [watch]

[zk: localhost:2181(CONNECTED) 1] get /app

123


### 10、zookeeper是如何保证事务的顺序一致性的？

zookeeper采用了全局递增的事务Id来标识，所有的proposal（提议）都在被提出的时候加上了zxid，zxid实际上是一个64位的数字，高32位是epoch（时期; 纪元; 世; 新时代）用来标识leader周期，如果有新的leader产生出来，epoch会自增，低32位用来递增计数。当新产生proposal的时候，会依据数据库的两阶段过程，首先会向其他的server发出事务执行请求，如果超过半数的机器都能执行并且能够成功，那么就会开始执行。


### 11、Zookeeper 对节点的 watch 监听通知是永久的吗？为什么不是永久的?
### 12、集群支持动态添加机器吗？
### 13、Zookeeper同步流程
### 14、ZAB三个阶段？
### 15、同进程组的两个进程消息网络通信有哪两个特性？
### 16、Stat记录了哪些版本相关数据？
### 17、Zookeeper集群管理（文件系统、通知机制）
### 18、ZooKeeper用推/拉模式？
### 19、Zookeeper对节点的watch监听通知是永久的吗？为什么不是永久的?
### 20、数据发布/订阅
### 21、ZooKeeper是什么？
### 22、服务器角色
### 23、Chroot特性
### 24、zk节点宕机如何处理？
### 25、Zookeeper 下 Server工作状态
### 26、ZAB 和 Paxos 算法的联系与区别？
### 27、恢复模式
### 28、chubby是什么，和zookeeper比你怎么看？
### 29、ZooKeeper的数据模型？
### 30、Zookeeper 的 java 客户端都有哪些？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
