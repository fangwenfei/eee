# ZooKeeper最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、会话管理

分桶策略：将类似的会话放在同一区块中进行管理，以便于Zookeeper对会话进行不同区块的隔离处理以及同一区块的统一处理。

分配原则：每个会话的“下次超时时间点”（ExpirationTime）

**计算公式：**

```
ExpirationTime_ = currentTime + sessionTimeout
ExpirationTime = (ExpirationTime_ / ExpirationInrerval + 1) * ExpirationInterval , ExpirationInterval 是指 Zookeeper 会话超时检查时间间隔，默认 tickTime
```


### 2、Zookeeper 都有哪些功能？

**1、** 集群管理：监控节点存活状态、运行请求等；

**2、** 主节点选举：主节点挂掉了之后可以从备用的节点开始新一轮选主，主节点选举说的就是这个选举的过程，使用 Zookeeper 可以协助完成这个过程；

**3、** 分布式锁：Zookeeper 提供两种锁：独占锁、共享锁。独占锁即一次只能有一个线程使用资源，共享锁是读锁共享，读写互斥，即可以有多线线程同时读同一个资源，如果要使用写锁也只能有一个线程使用。Zookeeper 可以对分布式锁进行控制。

**4、** 命名服务：在分布式系统中，通过使用命名服务，客户端应用能够根据指定名字来获取资源或服务的地址，提供者等信息。


### 3、数据同步

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


### 4、Zookeeper对节点的watch监听通知是永久的吗？为什么不是永久的?

不是。官方声明：一个Watch事件是一个一次性的触发器，当被设置了Watch的数据发生了改变的时候，则服务器将这个改变发送给设置了Watch的客户端，以便通知它们。

为什么不是永久的，举个例子，如果服务端变动频繁，而监听的客户端很多情况下，每次变动都要通知到所有的客户端，给网络和服务器造成很大压力。

一般是客户端执行getData(“/节点A”,true)，如果节点A发生了变更或删除，客户端会得到它的watch事件，但是在之后节点A又发生了变更，而客户端又没有设置watch事件，就不再给客户端发送。

在实际应用中，很多情况下，我们的客户端不需要知道服务端的每一次变动，我只要最新的数据即可。


### 5、四种类型的数据节点 Znode

**1、** PERSISTENT-持久节点 除非手动删除，否则节点一直存在于 Zookeeper 上

**2、** EPHEMERAL-临时节点 临时节点的生命周期与客户端会话绑定，一旦客户端会话失效（客户端与zookeeper 连接断开不一定会话失效），那么这个客户端创建的所有临时节点都会被移除。

**3、** PERSISTENT_SEQUENTIAL-持久顺序节点 基本特性同持久节点，只是增加了顺序属性，节点名后边会追加一个由父节点维护的自增整型数字。

**4、** EPHEMERAL_SEQUENTIAL-临时顺序节点 基本特性同临时节点，增加了顺序属性，节点名后边会追加一个由父节点维护的自增整型数字。


### 6、chubby 是什么，和 zookeeper 比你怎么看？

chubby 是 google 的，完全实现 paxos 算法，不开源。zookeeper 是 chubby的开源实现，使用 zab 协议，paxos 算法的变种。


### 7、数据发布/订阅？

发布者将数据发布到ZooKeeper上一个或多个节点上，订阅者从中订阅数据，从而动态获取数据的目的，实现配置信息的集中式管理和数据动态更新。


### 8、Zookeeper集群管理（文件系统、通知机制）

**1、** 所谓集群管理无在乎两点：是否有机器退出和加入、选举master。

**2、** 对于第一点，所有机器约定在父目录下创建临时目录节点，然后监听父目录节点的子节点变化消息。一旦有机器挂掉，该机器与 zookeeper的连接断开，其所创建的临时目录节点被删除，所有其他机器都收到通知：某个兄弟目录被删除，于是，所有人都知道：它上船了。

**3、** 新机器加入也是类似，所有机器收到通知：新兄弟目录加入，highcount又有了，对于第二点，我们稍微改变一下，所有机器创建临时顺序编号目录节点，每次选取编号最小的机器作为master就好。


### 9、Quorum?

当集群中过半UP状态的进程组成了进程子集后，就可以正常的消息传播了，这样的一个子集我们称为Quorum。


### 10、服务器角色

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


### 11、Zookeeper分布式锁（文件系统、通知机制）
### 12、集群最少要几台机器，集群规则是怎样的?
### 13、zookeeper 负载均衡和 nginx 负载均衡区别
### 14、说一下 Zookeeper 的通知机制？
### 15、CAP理论？
### 16、Zookeeper有哪几种几种部署模式？
### 17、ZAB和Paxos算法的联系与区别？
### 18、服务器的3中角色？
### 19、zk的命名服务（文件系统）
### 20、Stat记录了哪些版本相关数据？
### 21、什么是ZooKeeper?
### 22、Zookeeper的典型应用场景
### 23、四种类型的znode
### 24、Zookeeper 文件系统
### 25、集群支持动态添加机器吗？
### 26、获取指定节点信息？
### 27、ZAB协议？
### 28、ZooKeeper定义了几种权限？
### 29、广播模式
### 30、ZooKeeper可以实现哪些功能？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
