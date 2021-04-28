# ZooKeeper最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Zookeeper文件系统

Zookeeper提供一个多层级的节点命名空间（节点称为znode）。与文件系统不同的是，这些节点都可以设置关联的数据，而文件系统中只有文件节点可以存放数据而目录节点不行。

Zookeeper为了保证高吞吐和低延迟，在内存中维护了这个树状的目录结构，这种特性使得Zookeeper不能用于存放大量的数据，每个节点的存放数据上限为1M。


### 2、如何识别请求的先后顺序？

ZooKeeper会给每个更新请求，分配一个全局唯一的递增编号（zxid)，编号的大小体现事务操作的先后顺序。


### 3、Zookeeper的java客户端都有哪些？

java客户端：zk自带的zkclient及Apache开源的Curator。


### 4、获取分布式锁的流程

![](https://segmentfault.com/img/bV8WZ1?w=605&h=483#alt=clipboard.png)

**1、** 在获取分布式锁的时候在locker节点下创建临时顺序节点，释放锁的时候删除该临时节点。客户端调用createNode方法在locker下创建临时顺序节点，

**2、** 然后调用getChildren(“locker”)来获取locker下面的所有子节点，注意此时不用设置任何Watcher。客户端获取到所有的子节点path之后，如果发现自己创建的节点在所有创建的子节点序号最小，那么就认为该客户端获取到了锁。如果发现自己创建的节点并非locker所有子节点中最小的，说明自己还没有获取到锁，此时客户端需要找到比自己小的那个节点，然后对其调用exist()方法，同时对其注册事件监听器。之后，让这个被关注的节点删除，则客户端的Watcher会收到相应通知，此时再次判断自己创建的节点是否是locker子节点中序号最小的，如果是则获取到了锁，如果不是则重复以上步骤继续获取到比自己小的一个节点并注册监听。当前这个过程中还需要许多的逻辑判断。

![](https://segmentfault.com/img/bV8WVn?w=665&h=355#alt=clipboard.png)

代码的实现主要是基于互斥锁，获取分布式锁的重点逻辑在于BaseDistributedLock，实现了基于Zookeeper实现分布式锁的细节。


### 5、zookeeper是如何保证事务的顺序一致性的？

zookeeper采用了递增的事务Id来标识，所有的proposal（提议）都在被提出的时候加上了zxid，zxid实际上是一个64位的数字，高32位是epoch（时期; 纪元; 世; 新时代）用来标识leader是否发生改变，如果有新的leader产生出来，epoch会自增，低32位用来递增计数。当新产生proposal的时候，会依据数据库的两阶段过程，首先会向其他的server发出事务执行请求，如果超过半数的机器都能执行并且能够成功，那么就会开始执行。


### 6、Zookeeper有哪几种几种部署模式？

部署模式：单机模式、伪集群模式、集群模式。


### 7、Zookeeper队列管理（文件系统、通知机制）

**两种类型的队列：**

**1、** 同步队列，当一个队列的成员都聚齐时，这个队列才可用，否则一直等待所有成员到达。

**2、** 队列按照 FIFO 方式进行入队和出队操作。

**1、** 第一类，在约定目录下创建临时目录节点，监听节点数目是否是我们要求的数目。

**2、** 第二类，和分布式锁服务中的控制时序场景基本原理一致，入列有编号，出列按编号。在特定的目录下创建PERSISTENT_SEQUENTIAL节点，创建成功时Watcher通知等待的队列，队列删除序列号最小的节点用以消费。此场景下Zookeeper的znode用于消息存储，znode存储的数据就是消息队列中的消息内容，SEQUENTIAL序列号就是消息的编号，按序取出即可。由于创建的节点是持久化的，所以不必担心队列消息的丢失问题。


### 8、四种类型的数据节点 Znode

**1、** PERSISTENT-持久节点

除非手动删除，否则节点一直存在于Zookeeper上

**2、** EPHEMERAL-临时节点

临时节点的生命周期与客户端会话绑定，一旦客户端会话失效（客户端与zookeeper连接断开不一定会话失效），那么这个客户端创建的所有临时节点都会被移除。

**3、** PERSISTENT_SEQUENTIAL-持久顺序节点

基本特性同持久节点，只是增加了顺序属性，节点名后边会追加一个由父节点维护的自增整型数字。

**4、** EPHEMERAL_SEQUENTIAL-临时顺序节点

基本特性同临时节点，增加了顺序属性，节点名后边会追加一个由父节点维护的自增整型数字。


### 9、服务器角色

**Leader**

**1、** 事务请求的唯一调度和处理者，保证集群事务处理的顺序性

**2、** 集群内部各服务的调度者

**Follower**

**1、** 处理客户端的非事务请求，转发事务请求给 Leader 服务器

**2、** 参与事务请求 Proposal 的投票

**3、** 参与 Leader 选举投票

**Observer**

**1、** 3.0 版本以后引入的一个服务器角色，在不影响集群事务处理能力的基础上提升集群的非事务处理能力

**2、** 处理客户端的非事务请求，转发事务请求给 Leader 服务器

**3、** 不参与任何形式的投票


### 10、说几个 zookeeper 常用的命令。

常用命令：ls get set create delete 等。


### 11、zookeeper 是如何保证事务的顺序一致性的？
### 12、数据发布/订阅？
### 13、Chroot特性
### 14、Zookeeper 都有哪些功能？
### 15、Zookeeper同步流程
### 16、zk 节点宕机如何处理？
### 17、恢复模式
### 18、A是根节点，如何表达A子节点下的B节点？
### 19、CAP理论？
### 20、四种类型的znode
### 21、分布式通知和协调
### 22、ACL 权限控制机制
### 23、ZooKeeper的数据模型？
### 24、分布式集群中为什么会有Master？
### 25、Zookeeper 和 Dubbo 的关系？
### 26、数据同步
### 27、会话管理
### 28、zookeeper是如何选取主leader的？
### 29、删除指定节点？注意？
### 30、Zookeeper做了什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
