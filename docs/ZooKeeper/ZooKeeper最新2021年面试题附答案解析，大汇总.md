# ZooKeeper最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、zookeeper是如何选取主leader的？

当leader崩溃或者leader失去大多数的follower，这时zk进入恢复模式，恢复模式需要重新选举出一个新的leader，让所有的Server都恢复到一个正确的状态。Zk的选举算法有两种：一种是基于basic paxos实现的，另外一种是基于fast paxos算法实现的。系统默认的选举算法为fast paxos。

**Zookeeper选主流程(basic paxos)**

**1、** 选举线程由当前Server发起选举的线程担任，其主要功能是对投票结果进行统计，并选出推荐的Server；

**2、** 选举线程首先向所有Server发起一次询问(包括自己)；

**3、** 选举线程收到回复后，验证是否是自己发起的询问(验证zxid是否一致)，然后获取对方的id(myid)，并存储到当前询问对象列表中，最后获取对方提议的leader相关信息(id,zxid)，并将这些信息存储到当次选举的投票记录表中；

**4、** 收到所有Server回复以后，就计算出zxid最大的那个Server，并将这个Server相关信息设置成下一次要投票的Server；

**5、** 线程将当前zxid最大的Server设置为当前Server要推荐的Leader，如果此时获胜的Server获得n/2 + 1的Server票数，设置当前推荐的leader为获胜的Server，将根据获胜的Server相关信息设置自己的状态，否则，继续这个过程，直到leader被选举出来。 通过流程分析我们可以得出：要使Leader获得多数Server的支持，则Server总数必须是奇数2n+1，且存活的Server的数目不得少于n+1\、每个Server启动后都会重复以上流程。在恢复模式下，如果是刚从崩溃状态恢复的或者刚启动的server还会从磁盘快照中恢复数据和会话信息，zk会记录事务日志并定期进行快照，方便在恢复时进行状态恢复。

![](https://segmentfault.com/img/bV8XeP?w=357&h=791#alt=clipboard.png)

**Zookeeper选主流程(basic paxos)**

fast paxos流程是在选举过程中，某Server首先向所有Server提议自己要成为leader，当其它Server收到提议以后，解决epoch和 zxid的冲突，并接受对方的提议，然后向对方发送接受提议完成的消息，重复这个流程，最后一定能选举出Leader。

![](https://segmentfault.com/img/bV8XeR?w=533&h=451#alt=clipboard.png)


### 2、Zookeeper工作原理

Zookeeper 的核心是原子广播，这个机制保证了各个Server之间的同步。实现这个机制的协议叫做Zab协议。Zab协议有两种模式，它们分别是恢复模式（选主）和广播模式（同步）。当服务启动或者在领导者崩溃后，Zab就进入了恢复模式，当领导者被选举出来，且大多数Server完成了和 leader的状态同步以后，恢复模式就结束了。状态同步保证了leader和Server具有相同的系统状态。


### 3、发布订阅的两种设计模式？

推(Push) :服务端主动推数据给所有定于的客户端。

拉(Pull):客户端主动发请求来获取最新数据。


### 4、zk的命名服务（文件系统）

命名服务是指通过指定的名字来获取资源或者服务的地址，利用zk创建一个全局的路径，即是唯一的路径，这个路径就可以作为一个名字，指向集群中的集群，提供的服务的地址，或者一个远程的对象等等。


### 5、发现?

Follower把自己最后的接受事务的Proposal值(CEPOCH(F.p)发送给Leader。

当收到过半Follower的消息后，Leader生成NEWEPOCH(e')给这些过半的Follower。

tips: e' = Max((CEPOCH(F.p)) + 1

Follower收到消息后，如果自己值小于e',则同步e'的值，同时向Leader发Ack消息。


### 6、ZNode的类型？

**1、** 持久节点：一旦创建，除非主动移除，否则会一直保存在ZooKeeper。

**2、** 临时节点：生命周期和客户端会话绑定，会话失效，相关的临时节点被移除。

**3、** 持久顺序性：同时具备顺序性。

**4、** 临时顺序性：同时具备顺序性。


### 7、四种类型的数据节点 Znode

**1、** PERSISTENT-持久节点

除非手动删除，否则节点一直存在于Zookeeper上

**2、** EPHEMERAL-临时节点

临时节点的生命周期与客户端会话绑定，一旦客户端会话失效（客户端与zookeeper连接断开不一定会话失效），那么这个客户端创建的所有临时节点都会被移除。

**3、** PERSISTENT_SEQUENTIAL-持久顺序节点

基本特性同持久节点，只是增加了顺序属性，节点名后边会追加一个由父节点维护的自增整型数字。

**4、** EPHEMERAL_SEQUENTIAL-临时顺序节点

基本特性同临时节点，增加了顺序属性，节点名后边会追加一个由父节点维护的自增整型数字。


### 8、CAP理论？

**1、** C : Consistency 一致性,数据在多个副本之间似否能够保持一致的特性。

**2、** A: Availability 可用性，系统服务必须一直处于可用状态，对每个请求总是在指定的时间返回结果。

**3、** P:Partition tolerance 分区容错性,遇到分区网络故障时，仍能对外提供一致性和可用性的服务。

不能同时满足3个要求，只能满足其中的两个。


### 9、ZooKeeper定义了几种权限？

**1、** CREATE

**2、** READ

**3、** WRITE

**4、** DELETE

**5、** ADMIN


### 10、zk 节点宕机如何处理？

**1、** Zookeeper 本身也是集群，推荐配置不少于 3 个服务器。Zookeeper 自身也要保证当一个节点宕机时，其他节点会继续提供服务。

**2、** 如果是一个 Follower 宕机，还有 2 台服务器提供访问，因为 Zookeeper 上的数据是有多个副本的，数据并不会丢失；

**3、** 如果是一个 Leader 宕机，Zookeeper 会选举出新的 Leader。

**4、** ZK 集群的机制是只要超过半数的节点正常，集群就能正常提供服务。只有在 ZK节点挂得太多，只剩一半或不到一半节点能工作，集群才失效。

**所以**

3 个节点的 cluster 可以挂掉 1 个节点(leader 可以得到 2 票>1.5)

2 个节点的 cluster 就不能挂掉任何 1 个节点了(leader 可以得到 1 票<=1)


### 11、四种类型的znode
### 12、集群最少要几台机器，集群规则是怎样的?
### 13、chubby 是什么，和 zookeeper 比你怎么看？
### 14、Zookeeper 专门设计的一种支持崩溃恢复的原子广 播协议是?
### 15、什么是会话Session?
### 16、会话管理
### 17、集群角色？
### 18、四种类型的数据节点 Znode
### 19、ZooKeeper可以实现哪些功能？
### 20、服务端处理Watcher实现
### 21、zookeeper是如何保证事务的顺序一致性的？
### 22、ZAB的两种基本模式？
### 23、Zookeeper的java客户端都有哪些？
### 24、删除指定节点？注意？
### 25、Zookeeper同步流程
### 26、什么是ZooKeeper?
### 27、Stat记录了哪些版本相关数据？
### 28、数据同步
### 29、说几个zookeeper常用的命令。
### 30、Watcher 特性总结




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
