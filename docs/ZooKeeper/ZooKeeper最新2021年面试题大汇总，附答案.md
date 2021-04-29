# ZooKeeper最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何识别请求的先后顺序？

ZooKeeper会给每个更新请求，分配一个全局唯一的递增编号（zxid)，编号的大小体现事务操作的先后顺序。


### 2、集群支持动态添加机器吗？

其实就是水平扩容了，Zookeeper在这方面不太好。两种方式：

全部重启：关闭所有Zookeeper服务，修改配置之后启动。不影响之前客户端的会话。

逐个重启：在过半存活即可用的原则下，一台机器重启不影响整个集群对外提供服务。这是比较常用的方式。

3.5版本开始支持动态扩容。


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


### 4、Zookeeper 的典型应用场景

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
### 5、Zookeeper文件系统

Zookeeper提供一个多层级的节点命名空间（节点称为znode）。与文件系统不同的是，这些节点都可以设置关联的数据，而文件系统中只有文件节点可以存放数据而目录节点不行。

Zookeeper为了保证高吞吐和低延迟，在内存中维护了这个树状的目录结构，这种特性使得Zookeeper不能用于存放大量的数据，每个节点的存放数据上限为1M。


### 6、集群支持动态添加机器吗？

**1、** 其实就是水平扩容了，Zookeeper 在这方面不太好。两种方式：

**2、** 全部重启：关闭所有 Zookeeper 服务，修改配置之后启动。不影响之前客户端的会话。

**3、** 逐个重启：在过半存活即可用的原则下，一台机器重启不影响整个集群对外提供服务。这是比较常用的方式。

**4、** 3.5 版本开始支持动态扩容。


### 7、客户端回调 Watcher

客户端 SendThread 线程接收事件通知，交由 EventThread 线程回调 Watcher。

客户端的 Watcher 机制同样是一次性的，一旦被触发后，该 Watcher 就失效了。


### 8、zookeeper是如何选取主leader的？
### 9、ZAB 和 Paxos 算法的联系与区别？
### 10、Zookeeper默认端口？
### 11、分布式集群中为什么会有 Master主节点？
### 12、ZooKeeper可以实现哪些功能？
### 13、Zookeeper 下 Server工作状态
### 14、zk的命名服务（文件系统）
### 15、ZAB和Paxos算法的联系与区别？
### 16、Zookeeper有哪几种几种部署模式？
### 17、客户端回调Watcher
### 18、Zookeeper 下 Server工作状态
### 19、zookeeper 负载均衡和 nginx 负载均衡区别
### 20、zookeeper是如何保证事务的顺序一致性的？
### 21、服务器角色
### 22、Zookeeper对节点的watch监听通知是永久的吗？为什么不是永久的?
### 23、zookeeper负载均衡和nginx负载均衡区别
### 24、恢复模式
### 25、服务器的3中角色？
### 26、获取分布式锁的流程
### 27、ACL权限控制机制
### 28、如何创建一个ZNode?
### 29、ACL 权限控制机制
### 30、Zookeeper做了什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
