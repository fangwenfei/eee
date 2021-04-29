# RabbitMQ最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、MQ的优点

**简答**

**1、** 异步处理 - 相比于传统的串行、并行方式，提高了系统吞吐量。

**2、** 应用解耦 - 系统间通过消息通信，不用关心其他系统的处理。

**3、** 流量削锋 - 可以通过消息队列长度控制请求量；可以缓解短时间内的高并发请求。

**4、** 日志处理 - 解决大量日志传输。

**5、** 消息通讯 - 消息队列一般都内置了高效的通信机制，因此也可以用在纯的消息通讯。比如实现点对点消息队列，或者聊天室等。


### 2、如何防止出现 blackholed 问题？

没有特别好的办法，只能在具体实践中通过各种方式保证相关 fabric 的存在。另外，如果在执行 Basic.Publish 时设置 mandatory=true ，则在遇到可能出现 blackholed 情况时，服务器会通过返回 Basic.Return 告之当前 message 无法被正确投递（内含原因 312NO_ROUTE）。


### 3、解耦、异步、削峰是什么？。

- MQ 解耦

A 系统发送数据到 BCD 三个系统，通过接口调用发送。如果 E 系统也要这个数据呢？那如果 C 系统现在不需要了呢？A 系统负责人几乎崩溃…A 系统跟其它各种乱七八糟的系统严重耦合，A 系统产生一条比较关键的数据，很多系统都需要 A 系统将这个数据发送过来。如果使用 MQ，A 系统产生一条数据，发送到 MQ 里面去，哪个系统需要数据自己去 MQ 里面消费。如果新系统需要数据，直接从 MQ 里消费即可；如果某个系统不需要这条数据了，就取消对 MQ 消息的消费即可。这样下来，A 系统压根儿不需要去考虑要给谁发送数据，不需要维护这个代码，也不需要考虑人家是否调用成功、失败超时等情况。

就是一个系统或者一个模块，调用了多个系统或者模块，互相之间的调用很复杂，维护起来很麻烦。但是其实这个调用是不需要直接同步调用接口的，如果用 MQ 给它异步化解耦。

- 异步

A 系统接收一个请求，需要在自己本地写库，还需要在 BCD 三个系统写库，自己本地写库要 3ms，BCD 三个系统分别写库要 300ms、450ms、200ms。最终请求总延时是 3 + 300 + 450 + 200 = 953ms，接近 1s，用户感觉搞个什么东西，慢死了慢死了。用户通过浏览器发起请求。如果使用 MQ，那么 A 系统连续发送 3 条消息到 MQ 队列中，假如耗时 5ms，A 系统从接受一个请求到返回响应给用户，总时长是 3 + 5 = 8ms。

- 削峰

减少高峰时期对服务器压力。


### 4、消息基于什么传输？

由于TCP连接的创建和销毁开销较大，且并发数受系统资源限制，会造成性能瓶颈。RabbitMQ使用信道的方式来传输数据。信道是建立在真实的TCP连接内的虚拟连接，且每条TCP连接上的信道数量没有限制。


### 5、RAM node 和 disk node 的区别？

RAM node 仅将 fabric（即 queue、exchange 和 binding 等 RabbitMQ 基础构件）相关元数据保存到内存中，但 disk node 会在内存和磁盘中均进行存储。RAM node 上唯一会存储到磁盘上的元数据是 cluster 中使用的 disk node 的地址。要求在 RabbitMQ cluster中至少存在一个 disk node 。


### 6、Binding绑定？

通过绑定将交换器和队列关联起来，一般会指定一个BindingKey,这样RabbitMq就知道如何正确路由消息到队列了。


### 7、消费者Consumer?

消费消息，也就是接收消息的一方。

消费者连接到RabbitMQ服务器，并订阅到队列上。消费消息时只消费消息体，丢弃标签。


### 8、事务机制？
### 9、什么情况下 producer 不主动创建 queue 是安全的？
### 10、什么是RabbitMQ？
### 11、集群节点类型有几种？
### 12、使用RabbitMQ有什么好处？
### 13、RabbitMQ概念里的channel、exchange 和 queue是逻辑概念，还是对应着进程实体？作用分别是什么？
### 14、如何解决消息队列的延时以及过期失效问题？消息队列满了以后该怎么处理？有几百万消息持续积压几小时，怎么办？
### 15、发送确认机制？
### 16、RabbitMQ中消息可能有的几种状态?
### 17、如何解决RabbitMQ丢数据的问题?
### 18、客户端连接到 cluster 中的任意 node 上是否都能正常工作？
### 19、什么是RoutingKey路由键？
### 20、rabbitmq 的使用场景
### 21、RabbitMQ中消息可能有的几种状态?
### 22、如何保证RabbitMQ不被重复消费？
### 23、为什么 heavy RPC 的使用场景下不建议采用 disk node ？
### 24、消息基于什么传输?
### 25、导致的死信的几种原因？
### 26、vhost?
### 27、消息怎么路由？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
