# RabbitMQ最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、消费者获取消息的方式？

推

拉


### 2、RabbitMQ 中的 broker 是指什么？cluster 又是指什么？

broker 是指一个或多个 erlang node 的逻辑分组，且 node 上运行着 RabbitMQ 应用程序。cluster 是在 broker 的基础之上，增加了 node 之间共享元数据的约束。


### 3、如何保证消息的顺序性?

一个队列只有一个消费者的情况下才能保证顺序，否则只能通过全局ID实现（每条消息都一个msgId，关联的消息拥有一个parentMsgId。可以在消费端实现前一条消息未消费，不处理下一条消息；也可以在生产端实现前一条消息未处理完毕，不下一条消息）


### 4、RabbitMQ 中的 Broker 是指什么？Cluster 又是指什么？

`broker` 是指一个或多个 `erlang node` 的逻辑分组，且 `node` 上运行着 `RabbitMQ` 应用程序。`cluster` 是在 `broker` 的基础之上，增加了 `node` 之间共享元数据的约束。


### 5、什么是RoutingKey路由键？

生产者将消息发送给交换器的时候，会指定一个RoutingKey,用来指定这个消息的路由规则，这个RoutingKey需要与交换器类型和绑定键(BindingKey)联合使用才能最终生效。


### 6、RabbitMQ routing路由模式

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/030/5/35_7.png#alt=35%5C_7.png)

**1、** 消息生产者将消息发送给交换机按照路由判断,路由是字符串(info) 当前产生的消息携带路由字符(对象的方法),交换机根据路由的key,只能匹配上路由key对应的消息队列,对应的消费者才能消费消息;

**2、** 根据业务功能定义路由字符串

**3、** 从系统的代码逻辑中获取对应的功能字符串,将消息任务扔到对应的队列中。

**4、** 业务场景:error 通知;EXCEPTION;错误通知的功能;传统意义的错误通知;客户通知;利用key路由,可以将程序中的错误封装成消息传入到消息队列中,开发者可以自定义消费者,实时接收错误;


### 7、RabbitMQ 允许发送的 message 最大可达多大？

根据 AMQP 协议规定，消息体的大小由 64-bit 的值来指定，所以你就可以知道到底能发多大的数据了。


### 8、消费者接收消息过程？

**1、** Producer 先连接到 Broker,建立连接 Connection,开启一个信道(Channel)。

**2、** 向 Broker 请求消费响应的队列中消息，可能会设置响应的回调函数。

**3、** 等待 Broker 回应并投递相应队列中的消息，接收消息。

**4、** 消费者确认收到的消息,ack。

**5、** RabbitMq 从队列中删除已经确定的消息。

**6、** 关闭信道。

**7、** 关闭连接


### 9、使用rabbitmq的场景

**1、** 服务间异步通信

**2、** 顺序消费

**3、** 定时任务

**4、** 请求削峰


### 10、rabbitmq的集群

**镜像集群模式**

你创建的queue，无论元数据还是queue里的消息都会存在于多个实例上，然后每次你写消息到queue的时候，都会自动把消息到多个实例的queue里进行消息同步。

好处在于，你任何一个机器宕机了，没事儿，别的机器都可以用。坏处在于，第一，这个性能开销也太大了吧，消息同步所有机器，导致网络带宽压力和消耗很重！第二，这么玩儿，就没有扩展性可言了，如果某个queue负载很重，你加机器，新增的机器也包含了这个queue的所有数据，并没有办法线性扩展你的queue


### 11、RabbitMQ有那些基本概念？
### 12、RabbitMQ 包括哪些要素？
### 13、消息如何被优先消费？
### 14、客户端连接到 cluster 中的任意 node 上是否都能正常工作？
### 15、RabbitMQ消息是如何路由的？
### 16、导致的死信的几种原因？
### 17、Binding绑定？
### 18、什么情况下会出现 blackholed 问题？
### 19、无法被路由的消息去了哪里?
### 20、如何保证RabbitMQ消息的可靠传输？
### 21、消息如何分发？
### 22、什么是元数据？元数据分为哪些类型？包括哪些内容？与 cluster 相关的元数据有哪些？元数据是如何保存的？元数据在 cluster 中是如何分布的？
### 23、消息队列有什么缺点
### 24、消息怎么路由？
### 25、为什么要使用rabbitmq
### 26、消费者接收消息过程？
### 27、MQ的优点




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
