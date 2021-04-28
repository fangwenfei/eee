# ZooKeeper最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、BASE理论？

**1、** Basically Available(基本可用)、Soft state(软状态) 和 Eventuanlly consistent （最终一致性）3个短语的简写。

**2、** 基本可用：系统出现不可预知的故障时，允许损失部分可用性。

**3、** 弱（软）状态：数据的中间状态，并认为改状态存在不会一项系统整体可用性，允许不同节点数据副本数据同步过程中的延时。

**4、** 最终一致性：系统中所有数据副本，在一段时间的同步后，最终数据能够到一致性的状态。


### 2、服务端处理 Watcher 实现

**1、** 服务端接收 Watcher 并存储 接收到客户端请求，处理请求判断是否需要注册 Watcher，需要的话将数据节点的节点路径和 ServerCnxn（ServerCnxn 代表一个客户端和服务端的连接，实现了 Watcher 的 process 接口，此时可以看成一个 Watcher 对象）存储在WatcherManager 的 WatchTable 和 watch2Paths 中去。

**2、** Watcher 触发 以服务端接收到 setData() 事务请求触发 NodeDataChanged 事件为例：

2.1 封装 WatchedEvent 将通知状态（SyncConnected）、事件类型（NodeDataChanged）以及节点路径封装成一个 WatchedEvent 对象

2.2 查询 Watcher 从 WatchTable 中根据节点路径查找 Watcher

2.3 没找到；说明没有客户端在该数据节点上注册过 Watcher

2.4 找到；提取并从 WatchTable 和 Watch2Paths 中删除对应 Watcher（从这里可以看出 Watcher 在服务端是一次性的，触发一次就失效了）

**3、**  调用 process 方法来触发 Watcher 这里 process 主要就是通过 ServerCnxn 对应的 TCP 连接发送 Watcher 事件通知。


### 3、CAP理论？

**1、** C : Consistency 一致性,数据在多个副本之间似否能够保持一致的特性。

**2、** A: Availability 可用性，系统服务必须一直处于可用状态，对每个请求总是在指定的时间返回结果。

**3、** P:Partition tolerance 分区容错性,遇到分区网络故障时，仍能对外提供一致性和可用性的服务。

不能同时满足3个要求，只能满足其中的两个。


### 4、Zookeeper 下 Server 工作状态

服务器具有四种状态，分别是 LOOKING、FOLLOWING、LEADING、OBSERVING。

**1、** LOOKING：寻 找 Leader 状态。当服务器处于该状态时，它会认为当前集群中没有 Leader，因此需要进入 Leader 选举状态。

**2、** FOLLOWING：跟随者状态。表明当前服务器角色是 Follower。

**3、** LEADING：领导者状态。表明当前服务器角色是 Leader。

**4、** OBSERVING：观察者状态。表明当前服务器角色是 Observer。


### 5、chubby是什么，和zookeeper比你怎么看？

chubby是google的，完全实现paxos算法，不开源。zookeeper是chubby的开源实现，使用zab协议，paxos算法的变种。


### 6、ZooKeeper是什么？

**1、** ZooKeeper是一个分布式的，开放源码的分布式应用程序协调服务，是Google的Chubby一个开源的实现，它是集群的管理者，监视着集群中各个节点的状态根据节点提交的反馈进行下一步合理操作。最终，将简单易用的接口和性能高效、功能稳定的系统提供给用户。

**2、** 客户端的读请求可以被集群中的任意一台机器处理，如果读请求在节点上注册了监听器，这个监听器也是由所连接的zookeeper机器来处理。对于写请求，这些请求会同时发给其他zookeeper机器并且达成一致后，请求才会返回成功。因此，随着zookeeper的集群机器增多，读请求的吞吐会提高但是写请求的吞吐会下降。

**3、** 有序性是zookeeper中非常重要的一个特性，所有的更新都是全局有序的，每个更新都有一个唯一的时间戳，这个时间戳称为zxid（Zookeeper Transaction Id）。而读请求只会相对于更新有序，也就是读请求的返回结果中会带有这个zookeeper最新的zxid。


### 7、集群支持动态添加机器吗？

**1、** 其实就是水平扩容了，Zookeeper 在这方面不太好。两种方式：

**2、** 全部重启：关闭所有 Zookeeper 服务，修改配置之后启动。不影响之前客户端的会话。

**3、** 逐个重启：在过半存活即可用的原则下，一台机器重启不影响整个集群对外提供服务。这是比较常用的方式。

**4、** 3.5 版本开始支持动态扩容。


### 8、Zookeeper 对节点的 watch 监听通知是永久的吗？为什么不是永久的?

**1、** 不是。官方声明：一个 Watch 事件是一个一次性的触发器，当被设置了 Watch的数据发生了改变的时候，则服务器将这个改变发送给设置了 Watch 的客户端，以便通知它们。

**2、** 为什么不是永久的，举个例子，如果服务端变动频繁，而监听的客户端很多情况下，每次变动都要通知到所有的客户端，给网络和服务器造成很大压力。

**3、** 一般是客户端执行 getData(“/节点 A”,true)，如果节点 A 发生了变更或删除，客户端会得到它的 watch 事件，但是在之后节点 A 又发生了变更，而客户端又没有设置 watch 事件，就不再给客户端发送。

**4、** 在实际应用中，很多情况下，我们的客户端不需要知道服务端的每一次变动，我只要最新的数据即可。


### 9、客户端注册 Watcher 实现

**1、** 调用 getData()/getChildren()/exist()三个 API，传入 Watcher 对象

**2、** 标记请求 request，封装 Watcher 到 WatchRegistration

**3、** 封装成 Packet 对象，发服务端发送 request

**4、** 收到服务端响应后，将 Watcher 注册到 ZKWatcherManager 中进行管理

**5、** 请求返回，完成注册。


### 10、ZAB三个阶段？

**1、** 发现 (Discovery)

**2、** 同步 (Synchronization)

**3、** 广播 (Broadcast)


### 11、分布式集群中为什么会有 Master主节点？
### 12、客户端如何获取配置信息？
### 13、Zookeeper 下 Server工作状态
### 14、ACL权限控制机制
### 15、Watcher事件监听器？
### 16、集群最少要几台机器，集群规则是怎样的？集群中有 3 台服务器，其中一个节点宕机，这个时候 Zookeeper 还可以使用吗？
### 17、zookeeper 负载均衡和 nginx 负载均衡区别
### 18、zk 节点宕机如何处理？
### 19、zookeeper 是如何保证事务的顺序一致性的？
### 20、ZooKeeper定义了几种权限？
### 21、ZAB协议？
### 22、客户端注册Watcher实现
### 23、获取指定节点信息？
### 24、哪些情况会导致ZAB进入恢复模式并选取新的Leader?
### 25、Zookeeper文件系统
### 26、更新指定节点信息？
### 27、ZNode的类型？
### 28、Zookeeper同步流程
### 29、客户端回调 Watcher
### 30、Zookeeper 都有哪些功能？
### 31、数据发布/订阅？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
