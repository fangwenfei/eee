# ZooKeeper最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、客户端注册Watcher实现

**1、** 调用getData()/getChildren()/exist()三个API，传入Watcher对象

**2、** 标记请求request，封装Watcher到WatchRegistration

**3、** 封装成Packet对象，发服务端发送request

**4、** 收到服务端响应后，将Watcher注册到ZKWatcherManager中进行管理

**5、** 请求返回，完成注册。


### 2、集群最少要几台机器，集群规则是怎样的?

集群规则为2N+1台，N>0，即3台。


### 3、zookeeper负载均衡和nginx负载均衡区别

zk的负载均衡是可以调控，nginx只是能调权重，其他需要可控的都需要自己写插件；但是nginx的吞吐量比zk大很多，应该说按业务选择用哪种方式。


### 4、机器中为什么会有leader？

在分布式环境中，有些业务逻辑只需要集群中的某一台机器进行执行，其他的机器可以共享这个结果，这样可以大大减少重复计算，提高性能，于是就需要进行leader选举。


### 5、A是根节点，如何表达A子节点下的B节点？

/A/B


### 6、Zookeeper分布式锁（文件系统、通知机制）

**1、** 有了zookeeper的一致性文件系统，锁的问题变得容易。锁服务可以分为两类，一个是保持独占，另一个是控制时序。

**2、** 对于第一类，我们将zookeeper上的一个znode看作是一把锁，通过createznode的方式来实现。所有客户端都去创建 /distribute_lock 节点，最终成功创建的那个客户端也即拥有了这把锁。用完删除掉自己创建的distribute_lock 节点就释放出锁。

**3、** 对于第二类， /distribute_lock 已经预先存在，所有客户端在它下面创建临时顺序编号目录节点，和选master一样，编号最小的获得锁，用完删除，依次方便。


### 7、发现?

Follower把自己最后的接受事务的Proposal值(CEPOCH(F.p)发送给Leader。

当收到过半Follower的消息后，Leader生成NEWEPOCH(e')给这些过半的Follower。

tips: e' = Max((CEPOCH(F.p)) + 1

Follower收到消息后，如果自己值小于e',则同步e'的值，同时向Leader发Ack消息。


### 8、Watcher事件监听器？

ZooKeeper允许用户在指定节点上注册Watcher,当触发特定事件时，ZooKeeper服务端会把相应的事件通知到相应的客户端上，属于ZooKeeper一个重要的特性。


### 9、zookeeper watch机制

Watch机制官方声明：一个Watch事件是一个一次性的触发器，当被设置了Watch的数据发生了改变的时候，则服务器将这个改变发送给设置了Watch的客户端，以便通知它们。

**Zookeeper机制的特点：**

**1、** 一次性触发数据发生改变时，一个watcher event会被发送到client，但是client只会收到一次这样的信息。

**2、** watcher event异步发送watcher的通知事件从server发送到client是异步的，这就存在一个问题，不同的客户端和服务器之间通过socket进行通信，由于网络延迟或其他因素导致客户端在不通的时刻监听到事件，由于Zookeeper本身提供了ordering guarantee，即客户端监听事件后，才会感知它所监视znode发生了变化。所以我们使用Zookeeper不能期望能够监控到节点每次的变化。Zookeeper只能保证最终的一致性，而无法保证强一致性。

**3、** 数据监视Zookeeper有数据监视和子数据监视getdata() and exists()设置数据监视，getchildren()设置了子节点监视。

**4、** 注册watcher getData、exists、getChildren

**5、** 触发watcher create、delete、setData

**6、** setData()会触发znode上设置的data watch（如果set成功的话）。一个成功的create() 操作会触发被创建的znode上的数据watch，以及其父节点上的child watch。而一个成功的delete()操作将会同时触发一个znode的data watch和child watch（因为这样就没有子节点了），同时也会触发其父节点的child watch。

**7、** 当一个客户端连接到一个新的服务器上时，watch将会被以任意会话事件触发。当与一个服务器失去连接的时候，是无法接收到watch的。而当client重新连接时，如果需要的话，所有先前注册过的watch，都会被重新注册。通常这是完全透明的。只有在一个特殊情况下，watch可能会丢失：对于一个未创建的znode的exist watch，如果在客户端断开连接期间被创建了，并且随后在客户端连接上之前又删除了，这种情况下，这个watch事件可能会被丢失。

**8、** Watch是轻量级的，其实就是本地JVM的Callback，服务器端只是存了是否有设置了Watcher的布尔类型


### 10、Zookeeper队列管理（文件系统、通知机制）

**两种类型的队列：**

**1、** 同步队列，当一个队列的成员都聚齐时，这个队列才可用，否则一直等待所有成员到达。

**2、** 队列按照 FIFO 方式进行入队和出队操作。

**1、** 第一类，在约定目录下创建临时目录节点，监听节点数目是否是我们要求的数目。

**2、** 第二类，和分布式锁服务中的控制时序场景基本原理一致，入列有编号，出列按编号。在特定的目录下创建PERSISTENT_SEQUENTIAL节点，创建成功时Watcher通知等待的队列，队列删除序列号最小的节点用以消费。此场景下Zookeeper的znode用于消息存储，znode存储的数据就是消息队列中的消息内容，SEQUENTIAL序列号就是消息的编号，按序取出即可。由于创建的节点是持久化的，所以不必担心队列消息的丢失问题。


### 11、Watcher 特性总结
### 12、Zookeeper工作原理
### 13、客户端注册 Watcher 实现
### 14、chubby 是什么，和 zookeeper 比你怎么看？
### 15、服务器的3中角色？
### 16、哪些情况会导致ZAB进入恢复模式并选取新的Leader?
### 17、Zookeeper有哪几种几种部署模式？
### 18、Zookeeper默认端口？
### 19、更新指定节点信息？
### 20、Zookeeper 都有哪些功能？
### 21、集群支持动态添加机器吗？
### 22、什么是ZooKeeper?
### 23、zk节点宕机如何处理？
### 24、数据发布/订阅？
### 25、数据同步
### 26、Zookeeper 文件系统
### 27、Chroot 特性
### 28、Zookeeper 下 Server 工作状态
### 29、四种类型的数据节点 Znode
### 30、客户端如何获取配置信息？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
