# ZooKeeper最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Zookeeper对节点的watch监听通知是永久的吗？为什么不是永久的?

不是。官方声明：一个Watch事件是一个一次性的触发器，当被设置了Watch的数据发生了改变的时候，则服务器将这个改变发送给设置了Watch的客户端，以便通知它们。

为什么不是永久的，举个例子，如果服务端变动频繁，而监听的客户端很多情况下，每次变动都要通知到所有的客户端，给网络和服务器造成很大压力。

一般是客户端执行getData(“/节点A”,true)，如果节点A发生了变更或删除，客户端会得到它的watch事件，但是在之后节点A又发生了变更，而客户端又没有设置watch事件，就不再给客户端发送。

在实际应用中，很多情况下，我们的客户端不需要知道服务端的每一次变动，我只要最新的数据即可。


### 2、服务器角色

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


### 3、Zookeeper 的典型应用场景

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
### 4、什么是ZooKeeper?

ZooKeeper是一个开源分布式协同服务系统，Zookeeper的设计目标是将那些复杂容易出错的分布式一致性服务封装起来，构成一个高效可用的原语集，并提供一系列简单接口给用户使用。


### 5、Zookeeper通知机制

client端会对某个znode建立一个watcher事件，当该znode发生变化时，这些client会收到zk的通知，然后client可以根据znode变化来做出业务上的改变等。


### 6、Zookeeper 有哪几种几种部署模式？

**Zookeeper 有三种部署模式**：

**1、** 单机部署：一台集群上运行；

**2、** 集群部署：多台集群运行；

**3、** 伪集群部署：一台集群启动多个 Zookeeper 实例运行。


### 7、说几个 zookeeper 常用的命令。

常用命令：ls get set create delete 等。


### 8、Chroot特性

3.2.0版本后，添加了 Chroot特性，该特性允许每个客户端为自己设置一个命名空间。如果一个客户端设置了Chroot，那么该客户端对服务器的任何操作，都将会被限制在其自己的命名空间下。

通过设置Chroot，能够将一个客户端应用于Zookeeper服务端的一颗子树相对应，在那些多个应用公用一个Zookeeper进群的场景下，对实现不同应用间的相互隔离非常有帮助。


### 9、删除指定节点？注意？

delete path [version]

[zk: localhost:2181(CONNECTED) 8] delete /app

Node not empty: /app

如果没有子节点，就能删除成功。如果有会提示，该节点不为空。


### 10、Zookeeper 专门设计的一种支持崩溃恢复的原子广 播协议是?

ZAB


### 11、zookeeper是如何选取主leader的？
### 12、zookeeper是如何保证事务的顺序一致性的？
### 13、同进程组的两个进程消息网络通信有哪两个特性？
### 14、Zookeeper工作原理
### 15、Watcher 特性总结
### 16、ZAB 和 Paxos 算法的联系与区别？
### 17、四种类型的数据节点 Znode
### 18、zk节点宕机如何处理？
### 19、发现?
### 20、ZooKeeper的数据模型？
### 21、Zookeeper的java客户端都有哪些？
### 22、chubby 是什么，和 zookeeper 比你怎么看？
### 23、zk的命名服务（文件系统）
### 24、zookeeper负载均衡和nginx负载均衡区别
### 25、数据发布/订阅
### 26、ZooKeeper可以保证哪些分布式一致性特性？
### 27、Zookeeper 下 Server工作状态
### 28、如何查看子节点？
### 29、获取分布式锁的流程
### 30、Zookeeper 的 java 客户端都有哪些？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
