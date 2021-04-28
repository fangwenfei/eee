# RabbitMQ最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、AMQP模型的几大组件？

**1、** 交换器 (Exchange)：消息代理服务器中用于把消息路由到队列的组件。

**2、** 队列 (Queue)：用来存储消息的数据结构，位于硬盘或内存中。

**3、** 绑定 (Binding)： 一套规则，告知交换器消息应该将消息投递给哪个队列。


### 2、什么是Binding绑定？

通过绑定将交换器和队列关联起来，一般会指定一个BindingKey,这样RabbitMq就知道如何正确路由消息到队列了。


### 3、生产者消息运转？

1.Producer先连接到Broker,建立连接Connection,开启一个信道(Channel)。

2.Producer声明一个交换器并设置好相关属性。

3.Producer声明一个队列并设置好相关属性。

4.Producer通过路由键将交换器和队列绑定起来。

5.Producer发送消息到Broker,其中包含路由键、交换器等信息。

6.相应的交换器根据接收到的路由键查找匹配的队列。

7.如果找到，将消息存入对应的队列，如果没有找到，会根据生产者的配置丢弃或者退回给生产者。

8.关闭信道。

9.管理连接。


### 4、RabbitMQ 包括哪些要素？

1. 生产者 ：消息的创建者，发送到RabbitMQ
2. 消费者 ：连接到RabbitMQ，订阅到队列上，消费消息，持续订阅（basicConsumer）和单条订阅（basicGet）
3. 消息 ：包含有效载荷和标签，有效载荷指要传输的数据，标签描述了有效载荷，并且RabbitMQ用它来决定谁获得消息，消费者只能拿到有效载荷，并不知道生产者是谁。


### 5、如何自动删除长时间没有消费的消息？

```
// 通过队列属性设置消息过期时间
Map<String, Object> argss = new HashMap<String, Object>();
argss.put("x-message-ttl",6000);

// 对每条消息设置过期时间
AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
    .expiration("10000") // TTL
```


### 6、消息基于什么传输?

由于TCP连接的创建和销毁开销较大，且并发数受系统资源限制，会造成性能瓶颈。RabbitMQ使用信道的方式来传输数据。信道是建立在真实的TCP连接内的虚拟连接，且每条TCP连接上的信道数量没有限制。


### 7、事务机制？

RabbitMQ 客户端中与事务机制相关的方法有三个:

channel.txSelect 用于将当前的信道设置成事务模式。

channel 、txCommit 用于提交事务 。

channel 、txRollback 用于事务回滚,如果在事务提交执行之前由于 RabbitMQ 异常崩溃或者其他原因抛出异常,通过txRollback来回滚。


### 8、消息基于什么传输？

由于 TCP 连接的创建和销毁开销较大，且并发数受系统资源限制，会造成性能瓶颈。RabbitMQ 使用信道的方式来传输数据。信道是建立在真实的 TCP 连接内的虚拟连接，且每条 TCP 连接上的信道数量没有限制。


### 9、RabbitMQ有那些基本概念？

**1、** Broker：简单来说就是消息队列服务器实体

**2、** Exchange：消息交换机，它指定消息按什么规则，路由到哪个队列

**3、** Queue：消息队列载体，每个消息都会被投入到一个或多个队列

**4、** Binding：绑定，它的作用就是把exchange和queue按照路由规则绑定起来

**5、** Routing Key：路由关键字，exchange根据这个关键字进行消息投递

**6、** VHost：vhost 可以理解为虚拟 broker ，即 mini-RabbitMQ server。其内部均含有独立的 queue、exchange 和 binding 等，但最最重要的是，其拥有独立的权限系统，可以做到 vhost 范围的用户控制。当然，从 RabbitMQ 的全局角度，vhost 可以作为不同权限隔离的手段（一个典型的例子就是不同的应用可以跑在不同的 vhost 中）。

**7、** Producer：消息生产者，就是投递消息的程序

**8、** Consumer：消息消费者，就是接受消息的程序

**9、** Channel：消息通道，在客户端的每个连接里，可建立多个channel，每个channel代表一个会话任务

由`Exchange`、`Queue`、`RoutingKey`三个才能决定一个从Exchange到Queue的唯一的线路。


### 10、如何保证消息的顺序性?

一个队列只有一个消费者的情况下才能保证顺序，否则只能通过全局ID实现（每条消息都一个msgId，关联的消息拥有一个parentMsgId。可以在消费端实现前一条消息未消费，不处理下一条消息；也可以在生产端实现前一条消息未处理完毕，不下一条消息）


### 11、消费者接收消息过程？
### 12、RabbitMQ 中的 Broker 是指什么？Cluster 又是指什么？
### 13、客户端连接到 cluster 中的任意 node 上是否都能正常工作？
### 14、Queue队列？
### 15、如何确保消息正确地发送至RabbitMQ？ 如何确保消息接收方消费了消息？
### 16、RabbitMQ事务机制？
### 17、如何保证RabbitMQ消息的可靠传输？
### 18、解耦、异步、削峰是什么？。
### 19、如何防止出现 blackholed 问题？
### 20、RabbitMQ 允许发送的 message 最大可达多大？
### 21、vhost 是什么？起什么作用？
### 22、交换器无法根据自身类型和路由键找到符合条件队列时，有哪些处理？
### 23、AMQP协议3层？
### 24、RabbitMQ的工作模式有几种？
### 25、消息怎么路由？
### 26、RAM node 和 disk node 的区别？
### 27、rabbitmq的集群




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
