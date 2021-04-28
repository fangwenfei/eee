# ZooKeeper最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、为什么叫ZooKeeper?

哈哈，这个面试不一定问，不过知道以后可能会觉得更亲切。ZooKeeper最早起源于雅虎研究院的一个研究小组，在立项初期，发现很多项目都是用动物的名字来起的，当时首席科学家觉得不能再继续起动物的名字了，把它起名叫动物园管理员，正好它分布式协同服务的特性很相符，所以ZooKeeper诞生了。


### 2、Zookeeper 对节点的 watch 监听通知是永久的吗？为什么不是永久的?

**1、** 不是。官方声明：一个 Watch 事件是一个一次性的触发器，当被设置了 Watch的数据发生了改变的时候，则服务器将这个改变发送给设置了 Watch 的客户端，以便通知它们。

**2、** 为什么不是永久的，举个例子，如果服务端变动频繁，而监听的客户端很多情况下，每次变动都要通知到所有的客户端，给网络和服务器造成很大压力。

**3、** 一般是客户端执行 getData(“/节点 A”,true)，如果节点 A 发生了变更或删除，客户端会得到它的 watch 事件，但是在之后节点 A 又发生了变更，而客户端又没有设置 watch 事件，就不再给客户端发送。

**4、** 在实际应用中，很多情况下，我们的客户端不需要知道服务端的每一次变动，我只要最新的数据即可。


### 3、ZAB的两种基本模式？

崩溃恢复：在正常情况下运行非常良好，一旦Leader出现崩溃或者由于网络原因导致Leader服务器失去了与过半Follower的联系，那么就会进入崩溃恢复模式。为了程序的正确运行，整个恢复过程后需要选举出一个新的Leader,因此需要一个高效可靠的选举方法快速选举出一个Leader。

消息广播：类似一个两阶段提交过程，针对客户端的事务请求， Leader服务器会为其生成对应的事务Proposal,并将其发送给集群中的其余所有机器，再分别收集各自的选票，最后进行事务提交。


### 4、同进程组的两个进程消息网络通信有哪两个特性？

完整性： 如果进程a收到进程b的消息msg,那么b一定发送了消息msg。

前置性：如果msg1是msg2的前置消息，那么当前进程务必先接收到msg1,在接受msg2。


### 5、四种类型的znode

**1、** PERSISTENT-持久化目录节点

客户端与zookeeper断开连接后，该节点依旧存在

**2、** PERSISTENT_SEQUENTIAL-持久化顺序编号目录节点

客户端与zookeeper断开连接后，该节点依旧存在，只是Zookeeper给该节点名称进行顺序编号

**3、** EPHEMERAL-临时目录节点

客户端与zookeeper断开连接后，该节点被删除

**4、** EPHEMERAL_SEQUENTIAL-临时顺序编号目录节点

客户端与zookeeper断开连接后，该节点被删除，只是Zookeeper给该节点名称进行顺序编号

![](https://segmentfault.com/img/bV8Xel?w=371&h=463#alt=clipboard.png)


### 6、服务器的3中角色？

**1、** Leader角色：

**2、** Follower角色：

**3、** Observer角色：


### 7、ZooKeeper可以实现哪些功能？

**1、** 数据发布/订阅

**2、** 负载均衡

**3、** 命名服务

**4、** 分布式协调/通知

**5、** 集群管理

**6、** Master 选举

**7、** 分布式锁

**8、** 分布式队列


### 8、Zookeeper 的典型应用场景

Zookeeper 是一个典型的发布/订阅模式的分布式数据管理与协调框架，开发人员可以使用它来进行分布式数据的发布和订阅。

通过对 Zookeeper 中丰富的数据节点进行交叉使用，配合 Watcher 事件通知机制，可以非常方便的构建一系列分布式应用中年都会涉及的核心功能，如：

**1、** 数据发布/订阅

**2、** 负载均衡

**3、** 命名服务

**4、** 分布式协调/通知

**5、** 集群管理

**6、** Master 选举

**7、** 分布式锁

**8、** 分布式队列

#
### 9、zookeeper是如何选取主leader的？

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


### 10、Zookeeper做了什么？

**1、** 命名服务

**2、** 配置管理

**3、** 集群管理

**4、** 分布式锁

**5、** 队列管理


### 11、Quorum?
### 12、zk节点宕机如何处理？
### 13、Watcher 特性总结
### 14、客户端回调 Watcher
### 15、ZooKeeper的数据模型？
### 16、ZooKeeper是什么？
### 17、四种类型的数据节点 Znode
### 18、zk 节点宕机如何处理？
### 19、如何创建一个ZNode?
### 20、集群角色？
### 21、ACL 权限控制机制
### 22、ZooKeeper 是什么？
### 23、ZooKeeper提供了什么？
### 24、会话管理
### 25、chubby 是什么，和 zookeeper 比你怎么看？
### 26、ZooKeeper可以保证哪些分布式一致性特性？
### 27、删除指定节点？注意？
### 28、分布式集群中为什么会有 Master主节点？
### 29、如何查看子节点？
### 30、客户端回调Watcher




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
