# ZooKeeper最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、服务端处理 Watcher 实现

**1、** 服务端接收 Watcher 并存储 接收到客户端请求，处理请求判断是否需要注册 Watcher，需要的话将数据节点的节点路径和 ServerCnxn（ServerCnxn 代表一个客户端和服务端的连接，实现了 Watcher 的 process 接口，此时可以看成一个 Watcher 对象）存储在WatcherManager 的 WatchTable 和 watch2Paths 中去。

**2、** Watcher 触发 以服务端接收到 setData() 事务请求触发 NodeDataChanged 事件为例：

2.1 封装 WatchedEvent 将通知状态（SyncConnected）、事件类型（NodeDataChanged）以及节点路径封装成一个 WatchedEvent 对象

2.2 查询 Watcher 从 WatchTable 中根据节点路径查找 Watcher

2.3 没找到；说明没有客户端在该数据节点上注册过 Watcher

2.4 找到；提取并从 WatchTable 和 Watch2Paths 中删除对应 Watcher（从这里可以看出 Watcher 在服务端是一次性的，触发一次就失效了）

**3、**  调用 process 方法来触发 Watcher 这里 process 主要就是通过 ServerCnxn 对应的 TCP 连接发送 Watcher 事件通知。


### 2、集群支持动态添加机器吗？

**1、** 其实就是水平扩容了，Zookeeper 在这方面不太好。两种方式：

**2、** 全部重启：关闭所有 Zookeeper 服务，修改配置之后启动。不影响之前客户端的会话。

**3、** 逐个重启：在过半存活即可用的原则下，一台机器重启不影响整个集群对外提供服务。这是比较常用的方式。

**4、** 3.5 版本开始支持动态扩容。


### 3、哪些情况会导致ZAB进入恢复模式并选取新的Leader?

启动过程或Leader出现网络中断、崩溃退出与重启等异常情况时。

当选举出新的Leader后，同时集群中已有过半的机器与该Leader服务器完成了状态同步之后,ZAB就会退出恢复模式。


### 4、集群支持动态添加机器吗？

其实就是水平扩容了，Zookeeper在这方面不太好。两种方式：

全部重启：关闭所有Zookeeper服务，修改配置之后启动。不影响之前客户端的会话。

逐个重启：在过半存活即可用的原则下，一台机器重启不影响整个集群对外提供服务。这是比较常用的方式。

3.5版本开始支持动态扩容。


### 5、在sessionTimeout之内的会话，因服务器压力大、网络故障或客户端主动断开情况下，之前的会话还有效吗？

有效。


### 6、权限控制?

Access Control Lists ,ACL。类似于UNIX文件系统的权限控制。


### 7、Zookeeper工作原理

Zookeeper 的核心是原子广播，这个机制保证了各个Server之间的同步。实现这个机制的协议叫做Zab协议。Zab协议有两种模式，它们分别是恢复模式（选主）和广播模式（同步）。当服务启动或者在领导者崩溃后，Zab就进入了恢复模式，当领导者被选举出来，且大多数Server完成了和 leader的状态同步以后，恢复模式就结束了。状态同步保证了leader和Server具有相同的系统状态。


### 8、Zookeeper通知机制

client端会对某个znode建立一个watcher事件，当该znode发生变化时，这些client会收到zk的通知，然后client可以根据znode变化来做出业务上的改变等。


### 9、ZAB和Paxos算法的联系与区别？

**相同点：**

**1、** 两者都存在一个类似于Leader进程的角色，由其负责协调多个Follower进程的运行

**2、** Leader进程都会等待超过半数的Follower做出正确的反馈后，才会将一个提案进行提交

**3、** ZAB协议中，每个Proposal中都包含一个 epoch 值来代表当前的Leader周期，Paxos中名字为Ballot

**不同点：**

ZAB用来构建高可用的分布式数据主备系统（Zookeeper），Paxos是用来构建分布式一致性状态机系统。


### 10、数据同步

整个集群完成 Leader 选举之后，Learner（Follower 和 Observer 的统称）回向Leader 服务器进行注册。当 Learner 服务器想 Leader 服务器完成注册后，进入数据同步环节。

**数据同步流程：**（均以消息传递的方式进行）

**1、** Learner 向 Learder 注册

**2、** 数据同步

**3、** 同步确认

**Zookeeper 的数据同步通常分为四类：**

**1、** 直接差异化同步（DIFF 同步）

**2、** 先回滚再差异化同步（TRUNC+DIFF 同步）

**3、** 仅回滚同步（TRUNC 同步）

**4、** 全量同步（SNAP 同步）

**在进行数据同步前，Leader服务器会完成数据同步初始化：**

**1、** peerLastZxid：从learner服务器注册时发送的ACKEPOCH消息中提取lastZxid（该Learner服务器最后处理的ZXID）

**2、** minCommittedLog：Leader服务器Proposal缓存队列committedLog中最小ZXID

**3、** maxCommittedLog：Leader服务器Proposal缓存队列committedLog中最大ZXID

**4、** 直接差异化同步（DIFF同步） 场景：peerLastZxid介于minCommittedLog和maxCommittedLog之间

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/052/19/71_1.png#alt=71%5C_1.png)

**先回滚再差异化同步（TRUNC+DIFF同步）**

场景：当新的Leader服务器发现某个Learner服务器包含了一条自己没有的事务记录，那么就需要让该Learner服务器进行事务回滚--回滚到Leader服务器上存在的，同时也是最接近于peerLastZxid的ZXID

**仅回滚同步（TRUNC同步）**

场景：peerLastZxid 大于 maxCommittedLog

**全量同步（SNAP同步）**

场景一：peerLastZxid 小于 minCommittedLog

场景二：Leader服务器上没有Proposal缓存队列且peerLastZxid不等于lastProcessZxid


### 11、机器中为什么会有leader？
### 12、ZooKeeper用推/拉模式？
### 13、Zookeeper文件系统
### 14、Zookeeper 都有哪些功能？
### 15、数据发布/订阅
### 16、客户端注册 Watcher 实现
### 17、什么是ZooKeeper?
### 18、CAP理论？
### 19、ZAB三个阶段？
### 20、Watcher事件监听器？
### 21、zookeeper watch机制
### 22、Zookeeper对节点的watch监听通知是永久的吗？为什么不是永久的?
### 23、Zookeeper Watcher 机制 -- 数据变更通知
### 24、分布式集群中为什么会有Master？
### 25、服务端处理Watcher实现
### 26、ACL权限控制机制
### 27、发布订阅的两种设计模式？
### 28、负载均衡
### 29、发现?
### 30、集群最少要几台机器，集群规则是怎样的？集群中有 3 台服务器，其中一个节点宕机，这个时候 Zookeeper 还可以使用吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
