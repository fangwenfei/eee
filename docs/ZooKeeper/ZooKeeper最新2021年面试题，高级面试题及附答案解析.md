# ZooKeeper最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、CAP理论？

**1、** C : Consistency 一致性,数据在多个副本之间似否能够保持一致的特性。

**2、** A: Availability 可用性，系统服务必须一直处于可用状态，对每个请求总是在指定的时间返回结果。

**3、** P:Partition tolerance 分区容错性,遇到分区网络故障时，仍能对外提供一致性和可用性的服务。

不能同时满足3个要求，只能满足其中的两个。


### 2、zk节点宕机如何处理？

Zookeeper本身也是集群，推荐配置不少于3个服务器。Zookeeper自身也要保证当一个节点宕机时，其他节点会继续提供服务。

如果是一个Follower宕机，还有2台服务器提供访问，因为Zookeeper上的数据是有多个副本的，数据并不会丢失；

如果是一个Leader宕机，Zookeeper会选举出新的Leader。

ZK集群的机制是只要超过半数的节点正常，集群就能正常提供服务。只有在ZK节点挂得太多，只剩一半或不到一半节点能工作，集群才失效。

所以

3个节点的cluster可以挂掉1个节点(leader可以得到2票>1.5)

2个节点的cluster就不能挂掉任何1个节点了(leader可以得到1票<=1)


### 3、Zookeeper 有哪几种几种部署模式？

**Zookeeper 有三种部署模式**：

**1、** 单机部署：一台集群上运行；

**2、** 集群部署：多台集群运行；

**3、** 伪集群部署：一台集群启动多个 Zookeeper 实例运行。


### 4、Zookeeper队列管理（文件系统、通知机制）

**两种类型的队列：**

**1、** 同步队列，当一个队列的成员都聚齐时，这个队列才可用，否则一直等待所有成员到达。

**2、** 队列按照 FIFO 方式进行入队和出队操作。

**1、** 第一类，在约定目录下创建临时目录节点，监听节点数目是否是我们要求的数目。

**2、** 第二类，和分布式锁服务中的控制时序场景基本原理一致，入列有编号，出列按编号。在特定的目录下创建PERSISTENT_SEQUENTIAL节点，创建成功时Watcher通知等待的队列，队列删除序列号最小的节点用以消费。此场景下Zookeeper的znode用于消息存储，znode存储的数据就是消息队列中的消息内容，SEQUENTIAL序列号就是消息的编号，按序取出即可。由于创建的节点是持久化的，所以不必担心队列消息的丢失问题。


### 5、zk 节点宕机如何处理？

**1、** Zookeeper 本身也是集群，推荐配置不少于 3 个服务器。Zookeeper 自身也要保证当一个节点宕机时，其他节点会继续提供服务。

**2、** 如果是一个 Follower 宕机，还有 2 台服务器提供访问，因为 Zookeeper 上的数据是有多个副本的，数据并不会丢失；

**3、** 如果是一个 Leader 宕机，Zookeeper 会选举出新的 Leader。

**4、** ZK 集群的机制是只要超过半数的节点正常，集群就能正常提供服务。只有在 ZK节点挂得太多，只剩一半或不到一半节点能工作，集群才失效。

**所以**

3 个节点的 cluster 可以挂掉 1 个节点(leader 可以得到 2 票>1.5)

2 个节点的 cluster 就不能挂掉任何 1 个节点了(leader 可以得到 1 票<=1)


### 6、Watcher事件监听器？

ZooKeeper允许用户在指定节点上注册Watcher,当触发特定事件时，ZooKeeper服务端会把相应的事件通知到相应的客户端上，属于ZooKeeper一个重要的特性。


### 7、获取指定节点信息？

get path [watch]

[zk: localhost:2181(CONNECTED) 1] get /app

123


### 8、Zookeeper 文件系统
### 9、几种部署方式？
### 10、Zookeeper的java客户端都有哪些？
### 11、客户端如何获取配置信息？
### 12、机器中为什么会有leader？
### 13、四种类型的数据节点 Znode
### 14、集群最少要几台机器，集群规则是怎样的？集群中有 3 台服务器，其中一个节点宕机，这个时候 Zookeeper 还可以使用吗？
### 15、ZNode的类型？
### 16、客户端注册Watcher实现
### 17、四种类型的数据节点 Znode
### 18、Zookeeper 对节点的 watch 监听通知是永久的吗？为什么不是永久的?
### 19、哪些情况会导致ZAB进入恢复模式并选取新的Leader?
### 20、Zookeeper Watcher 机制 -- 数据变更通知
### 21、Zookeeper 专门设计的一种支持崩溃恢复的原子广 播协议是?
### 22、Zookeeper 的 java 客户端都有哪些？
### 23、zookeeper 是如何保证事务的顺序一致性的？
### 24、四种类型的znode
### 25、Chroot 特性
### 26、Zookeeper文件系统
### 27、ZAB三个阶段？
### 28、分布式通知和协调
### 29、ZooKeeper用推/拉模式？
### 30、说几个zookeeper常用的命令。
### 31、发布订阅的两种设计模式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
