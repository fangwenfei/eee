# RabbitMQ最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、能够在地理上分开的不同数据中心使用 RabbitMQ cluster 么？

不能。第一，你无法控制所创建的 queue 实际分布在 cluster 里的哪个 node 上（一般使用 HAProxy + cluster 模型时都是这样），这可能会导致各种跨地域访问时的常见问题；第二，Erlang 的 OTP 通信框架对延迟的容忍度有限，这可能会触发各种超时，导致业务疲于处理；第三，在广域网上的连接失效问题将导致经典的“脑裂”问题，而RabbitMQ 目前无法处理（该问题主要是说 Mnesia）。


### 2、RabbitMQ topic 主题模式(路由模式的一种)

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/030/5/35_8.png#alt=35%5C_8.png)

**1、** 星号井号代表通配符

**2、** 星号代表多个单词,井号代表一个单词

**3、** 路由功能添加模糊匹配

**4、** 消息产生者产生消息,把消息交给交换机

**5、** 交换机根据key的规则模糊匹配到对应的队列,由队列的监听消费者接收消息消费

在我的理解看来就是routing查询的一种模糊匹配，就类似sql的模糊查询方式


### 3、如何确保消息不丢失？

**1、** 消息持久化，当然前提是队列必须持久化

**2、** RabbitMQ确保持久性消息能从服务器重启中恢复的方式是，将它们写入磁盘上的一个持久化日志文件，当发布一条持久性消息到持久交换器上时，Rabbit会在消息提交到日志文件后才发送响应。

**3、** 一旦消费者从持久队列中消费了一条持久化消息，RabbitMQ会在持久化日志中把这条消息标记为等待垃圾收集。如果持久化消息在被消费之前RabbitMQ重启，那么Rabbit会自动重建交换器和队列（以及绑定），并重新发布持久化日志文件中的消息到合适的队列。


### 4、什么是Queue队列？

Queue 是 RabbitMQ 的内部对象，用于存储消息。多个消费者可以订阅同一队列，这时队列中的消息会被平摊（轮询）给多个消费者进行处理。


### 5、交换器4种类型？

主要有以下4种。

fanout:把所有发送到该交换器的消息路由到所有与该交换器绑定的队列中。

direct:把消息路由到BindingKey和RoutingKey完全匹配的队列中。

topic:

匹配规则：

RoutingKey 为一个 点号'.': 分隔的字符串。 比如: java.xiaoka.show

BindingKey和RoutingKey一样也是点号“.“分隔的字符串。

BindingKey可使用 _ 和 # 用于做模糊匹配，_匹配一个单词，#匹配多个或者0个

headers:不依赖路由键匹配规则路由消息。是根据发送消息内容中的headers属性进行匹配。性能差，基本用不到。


### 6、消息如何保证幂等性？

生产者方面：可以对每条消息生成一个msgID，以控制消息重复投递

```
AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
porperties.messageId(String.valueOF(UUID.randomUUID()))
```

消费者方面：消息体中必须携带一个业务ID，如银行流水号，消费者可以根据业务ID去重，避免重复消费


### 7、消息在什么时候会变成死信?

**1、** 消息拒绝并且没有设置重新入队

**2、** 消息过期

**3、** 消息堆积，并且队列达到最大长度，先入队的消息会变成DL


### 8、RabbitMQ基本概念

**1、** Broker： 简单来说就是消息队列服务器实体

**2、** Exchange： 消息交换机，它指定消息按什么规则，路由到哪个队列

**3、** Queue： 消息队列载体，每个消息都会被投入到一个或多个队列

**4、** Binding： 绑定，它的作用就是把exchange和queue按照路由规则绑定起来

**5、** Routing Key： 路由关键字，exchange根据这个关键字进行消息投递

**6、** VHost： vhost 可以理解为虚拟 broker ，即 mini-RabbitMQ server。其内部均含有独立的 queue、exchange 和 binding 等，但最最重要的是，其拥有独立的权限系统，可以做到 vhost 范围的用户控制。当然，从 RabbitMQ 的全局角度，vhost 可以作为不同权限隔离的手段（一个典型的例子就是不同的应用可以跑在不同的 vhost 中）。

**7、** Producer： 消息生产者，就是投递消息的程序

**8、** Consumer： 消息消费者，就是接受消息的程序

**9、** Channel： 消息通道，在客户端的每个连接里，可建立多个channel，每个channel代表一个会话任务

由Exchange、Queue、RoutingKey三个才能决定一个从Exchange到Queue的唯一的线路。


### 9、集群节点类型有几种？

内存节点：保存状态到内存，但持久化的队列和消息还是会保存到磁盘；

磁盘节点：保存状态到内存和磁盘，一个集群中至少需要一个磁盘节点


### 10、消费者某些原因无法处理当前接受的消息如何来拒绝？

channel .basicNack

channel .basicReject


### 11、事务机制？
### 12、如何确保消息接收方消费了消息?
### 13、向不存在的 exchange 发 publish 消息会发生什么？向不存在的 queue 执行consume 动作会发生什么？
### 14、Consumer Cancellation Notification 机制用于什么场景？
### 15、死信队列和延迟队列的使用?
### 16、RabbitMQ消息确认过程？
### 17、什么是RabbitMQ？
### 18、RabbitMQ simple模式（即最简单的收发模式）
### 19、RabbitMQ中消息可能有的几种状态?
### 20、为什么 heavy RPC 的使用场景下不建议采用 disk node ？
### 21、如何确保消息正确地发送至RabbitMQ?
### 22、消息怎么路由？
### 23、RabbitMQ特点?
### 24、设计MQ思路
### 25、AMQP协议3层？
### 26、如何解决RabbitMQ丢数据的问题?
### 27、如何保证RabbitMQ消息的可靠传输？
### 28、Exchange交换器？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
