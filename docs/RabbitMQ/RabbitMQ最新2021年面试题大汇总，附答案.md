# RabbitMQ最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、什么是Queue队列？

Queue 是 RabbitMQ 的内部对象，用于存储消息。多个消费者可以订阅同一队列，这时队列中的消息会被平摊（轮询）给多个消费者进行处理。


### 2、能够在地理上分开的不同数据中心使用 RabbitMQ cluster 么？

不能。第一，你无法控制所创建的 queue 实际分布在 cluster 里的哪个 node 上（一般使用 HAProxy + cluster 模型时都是这样），这可能会导致各种跨地域访问时的常见问题；第二，Erlang 的 OTP 通信框架对延迟的容忍度有限，这可能会触发各种超时，导致业务疲于处理；第三，在广域网上的连接失效问题将导致经典的“脑裂”问题，而RabbitMQ 目前无法处理（该问题主要是说 Mnesia）。


### 3、RabbitMQ消息是如何路由的？

**消息路由必须有三部分：交换器、路由、绑定。**

生产者把消息发布到交换器上，绑定决定了消息如何从路由器路由到特定的队列；消息最终到达队列，并被消费者接收。

1. 消息发布到交换器时，消息将拥有一个 路由键（routing key） ， 在消息创建时设定。
2. 通过队列路由键，可以把队列绑定到交换器上。
3. 消息到达交换器后，RabbitMQ会将消息的路由键与队列的路由键进行匹配（针对不同的交换器有不同的路由规则）。如果能够匹配到队列，则消息会投递到相应队列中；如果不能匹配到任何队列，消息将进入"黑洞"。

**常用的交换器主要分为以下三种：**

1. direct ：如果路由键完全匹配，消息就会被投递到相应的队列；每个AMQP的实现都必须有一个direct交换器，包含一个空白字符串名称的默认交换器。声明一个队列时，会自动绑定到默认交换器，并且以队列名称作为路由键：channel -> basic_public($msg, '', 'queue-name')
2. fanout ： 如果交换器收到消息，将会广播到所有绑定的队列上；
3. topic ：可以使来自不同源头的消息能够到达同一个队列。使用topic交换器时，可以使用通配符，比如："*" 匹配特定位置的任意文本，"." 把路由键分为了几个标识符， "#" 匹配所有规则等。
4. 特别注意：发往topic交换器的消息不能随意的设置选择键（routing_key），必须是有"."隔开的一系列的标识符组成。


### 4、什么是消费者Consumer?

消费消息，也就是接收消息的一方。

消费者连接到RabbitMQ服务器，并订阅到队列上。消费消息时只消费消息体，丢弃标签。


### 5、消费者Consumer?

消费消息，也就是接收消息的一方。

消费者连接到RabbitMQ服务器，并订阅到队列上。消费消息时只消费消息体，丢弃标签。


### 6、集群中的节点类型？

内存节点：ram,将变更写入内存。

磁盘节点：disc,磁盘写入操作。

RabbitMQ要求最少有一个磁盘节点。


### 7、RabbitMQ中消息可能有的几种状态?

**1、** alpha: 消息内容(包括消息体、属性和 headers) 和消息索引都存储在内存中 。

**2、** beta: 消息内容保存在磁盘中，消息索引保存在内存中。

**3、** gamma: 消息内容保存在磁盘中，消息索引在磁盘和内存中都有 。

**4、** delta: 消息内容和索引都在磁盘中 。


### 8、消费者某些原因无法处理当前接受的消息如何来拒绝？

channel .basicNack

channel .basicReject


### 9、消费者接收消息过程？

1.Producer先连接到Broker,建立连接Connection,开启一个信道(Channel)。

2.向Broker请求消费响应的队列中消息，可能会设置响应的回调函数。

3.等待Broker回应并投递相应队列中的消息，接收消息。

4.消费者确认收到的消息,ack。

5.RabbitMq从队列中删除已经确定的消息。

6.关闭信道。

7.关闭连接。


### 10、消息传输保证层级？

**1、** At most once：最多一次。消息可能会丢失，单不会重复传输。

**2、** At least once：最少一次。消息觉不会丢失，但可能会重复传输。

**3、** Exactly once：恰好一次，每条消息肯定仅传输一次。


### 11、RabbitMQ如何实现延时队列?
### 12、消息如何保证幂等性？
### 13、如何保证高可用的？RabbitMQ 的集群
### 14、设计MQ思路
### 15、队列结构？
### 16、使用RabbitMQ有什么好处？
### 17、MQ 有哪些常见问题？如何解决这些问题？
### 18、消息传输保证层级？
### 19、消费者接收消息过程？
### 20、消息队列有什么缺点
### 21、RabbitMQ 上的一个 queue 中存放的 message 是否有数量限制？
### 22、消息怎么路由？
### 23、消息基于什么传输？
### 24、什么是Broker服务节点？
### 25、RabbitMQ work工作模式(资源的竞争)
### 26、向不存在的 exchange 发 publish 消息会发生什么？向不存在的 queue 执行consume 动作会发生什么？
### 27、发送确认机制？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
