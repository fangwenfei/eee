# ZooKeeper最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Stat记录了哪些版本相关数据？

version:当前ZNode版本

cversion:当前ZNode子节点版本

aversion:当前ZNode的ACL版本


### 2、Zookeeper工作原理

Zookeeper 的核心是原子广播，这个机制保证了各个Server之间的同步。实现这个机制的协议叫做Zab协议。Zab协议有两种模式，它们分别是恢复模式（选主）和广播模式（同步）。当服务启动或者在领导者崩溃后，Zab就进入了恢复模式，当领导者被选举出来，且大多数Server完成了和 leader的状态同步以后，恢复模式就结束了。状态同步保证了leader和Server具有相同的系统状态。


### 3、说几个 zookeeper 常用的命令。

常用命令：ls get set create delete 等。


### 4、服务端处理Watcher实现

**1、** 服务端接收Watcher并存储

接收到客户端请求，处理请求判断是否需要注册Watcher，需要的话将数据节点的节点路径和ServerCnxn（ServerCnxn代表一个客户端和服务端的连接，实现了Watcher的process接口，此时可以看成一个Watcher对象）存储在WatcherManager的WatchTable和watch2Paths中去。

**2、** Watcher触发

以服务端接收到 setData() 事务请求触发NodeDataChanged事件为例：

2.1 封装WatchedEvent

将通知状态（SyncConnected）、事件类型（NodeDataChanged）以及节点路径封装成一个WatchedEvent对象

2.2 查询Watcher

从WatchTable中根据节点路径查找Watcher

2.3 没找到；说明没有客户端在该数据节点上注册过Watcher

2.4 找到；提取并从WatchTable和Watch2Paths中删除对应Watcher（从这里可以看出Watcher在服务端是一次性的，触发一次就失效了）

**3、** 调用process方法来触发Watcher

这里process主要就是通过ServerCnxn对应的TCP连接发送Watcher事件通知。


### 5、客户端注册 Watcher 实现

**1、** 调用 getData()/getChildren()/exist()三个 API，传入 Watcher 对象

**2、** 标记请求 request，封装 Watcher 到 WatchRegistration

**3、** 封装成 Packet 对象，发服务端发送 request

**4、** 收到服务端响应后，将 Watcher 注册到 ZKWatcherManager 中进行管理

**5、** 请求返回，完成注册。


### 6、删除指定节点？注意？

delete path [version]

[zk: localhost:2181(CONNECTED) 8] delete /app

Node not empty: /app

如果没有子节点，就能删除成功。如果有会提示，该节点不为空。


### 7、Zookeeper通知机制

client端会对某个znode建立一个watcher事件，当该znode发生变化时，这些client会收到zk的通知，然后client可以根据znode变化来做出业务上的改变等。


### 8、广播模式
### 9、BASE理论？
### 10、Zookeeper 怎么保证主从节点的状态同步？
### 11、集群角色？
### 12、会话管理
### 13、Watcher 特性总结
### 14、什么是ZooKeeper?
### 15、ZooKeeper定义了几种权限？
### 16、ZooKeeper的数据模型？
### 17、A是根节点，如何表达A子节点下的B节点？
### 18、分布式集群中为什么会有Master？
### 19、ZooKeeper提供了什么？
### 20、Zookeeper同步流程
### 21、Zookeeper 和 Dubbo 的关系？
### 22、为什么叫ZooKeeper?
### 23、chubby 是什么，和 zookeeper 比你怎么看？
### 24、chubby是什么，和zookeeper比你怎么看？
### 25、Zookeeper 都有哪些功能？
### 26、Zookeeper Watcher 机制 – 数据变更通知
### 27、集群最少要几台机器，集群规则是怎样的?
### 28、Zookeeper分布式锁（文件系统、通知机制）
### 29、发现?
### 30、如何查看子节点？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
