# RabbitMQ最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、消息怎么路由？

从概念上来说，消息路由必须有三部分：交换器、路由、绑定。生产者把消息到交换器上；绑定决定了消息如何从路由器路由到特定的队列；消息最终到达队列，并被消费者接收。

消息到交换器时，消息将拥有一个路由键（routing key），在消息创建时设定。通过队列路由键，可以把队列绑定到交换器上。消息到达交换器后，RabbitMQ会将消息的路由键与队列的路由键进行匹配（针对不同的交换器有不同的路由规则）。如果能够匹配到队列，则消息会投递到相应队列中；如果不能匹配到任何队列，消息将进入 “黑洞”。

**常用的交换器主要分为一下三种：**

**1、** direct：如果路由键完全匹配，消息就被投递到相应的队列

**2、** fanout：如果交换器收到消息，将会广播到所有绑定的队列上

**3、** topic：可以使来自不同源头的消息能够到达同一个队列。使用topic交换器时，可以使用通配符。比如：“*” 匹配特定位置的任意文本， “.” 把路由键分为了几部分，“#” 匹配所有规则等。特别注意：发往topic交换器的消息不能随意的设置选择键（routing_key），必须是由"."隔开的一系列的标识符组成。


### 2、AMQP模型的几大组件？

**1、** 交换器 (Exchange)：消息代理服务器中用于把消息路由到队列的组件。

**2、** 队列 (Queue)：用来存储消息的数据结构，位于硬盘或内存中。

**3、** 绑定 (Binding)：一套规则，告知交换器消息应该将消息投递给哪个队列。


### 3、RabbitMQ 概念里的 channel、exchange 和 queue 这些东东是逻辑概念，还是对应着进程实体？这些东东分别起什么作用？

queue 具有自己的 erlang 进程；exchange 内部实现为保存 binding 关系的查找表；channel 是实际进行路由工作的实体，即负责按照 routing_key 将 message 投递给queue 。由 AMQP 协议描述可知，channel 是真实 TCP 连接之上的虚拟连接，所有AMQP 命令都是通过 channel 发送的，且每一个 channel 有唯一的 ID。

一个 channel 只能被单独一个操作系统线程使用，故投递到特定 channel 上的 message 是有顺序的。但一个操作系统线程上允许使用多个 channel 。channel 号为 0 的 channel 用于处理所有对于当前 connection 全局有效的帧，而 1-65535 号 channel 用于处理和特定 channel 相关的帧。AMQP 协议给出的 channel ，其中每一个 channel 运行在一个独立的线程上，多线程共享同一个 socket。


### 4、向不存在的 exchange 发 publish 消息会发生什么？向不存在的 queue 执行consume 动作会发生什么？

都会收到 Channel.Close 信令告之不存在（内含原因 404 NOT_FOUND）。


### 5、队列结构？

通常由以下两部分组成？

rabbit_amqqueue_process :负责协议相关的消息处理，即接收生产者发布的消息、向消费者交付消息、处理消息的确认(包括生产端的 confirm 和消费端的 ack) 等。

backing_queue:是消息存储的具体形式和引擎，并向 rabbit amqqueue process 提供相关的接口以供调用。


### 6、Broker服务节点？

Broker可以看做RabbitMQ的服务节点。一般请下一个Broker可以看做一个RabbitMQ服务器。


### 7、消息基于什么传输？

由于 TCP 连接的创建和销毁开销较大，且并发数受系统资源限制，会造成性能瓶颈。RabbitMQ 使用信道的方式来传输数据。信道是建立在真实的 TCP 连接内的虚拟连接，且每条 TCP 连接上的信道数量没有限制。


### 8、消费者某些原因无法处理当前接受的消息如何来拒绝？

channel.basicNack

channel.basicReject


### 9、为什么不应该对所有的 message 都使用持久化机制？

**1、** 首先，必然导致性能的下降，因为写磁盘比写 RAM 慢的多，message 的吞吐量可能有 10 倍的差距。

**2、** 其次，message 的持久化机制用在 RabbitMQ 的内置 cluster 方案时会出现“坑爹”问题。矛盾点在于，若 message 设置了 persistent 属性，但 queue 未设置 durable 属性，那么当该 queue 的 owner node 出现异常后，在未重建该 queue 前，发往该 queue 的 message 将被 blackholed ；若 message 设置了 persistent 属性，同时 queue 也设置了 durable 属性，那么当 queue 的 owner node 异常且无法重启的情况下，则该 queue 无法在其他 node 上重建，只能等待其 owner node 重启后，才能恢复该 queue 的使用，而在这段时间内发送给该 queue 的 message 将被 blackholed 。

**3、** 所以，是否要对 message 进行持久化，需要综合考虑性能需要，以及可能遇到的问题。若想达到 100,000 条/秒以上的消息吞吐量（单 RabbitMQ 服务器），则要么使用其他的方式来确保 message 的可靠 delivery ，要么使用非常快速的存储系统以支持全持久化（例如使用 SSD）。另外一种处理原则是：仅对关键消息作持久化处理（根据业务重要程度），且应该保证关键消息的量不会导致性能瓶颈。


### 10、RabbitMQ概念里的channel、exchange 和 queue是逻辑概念，还是对应着进程实体？作用分别是什么？

queue 具有自己的 erlang 进程；

exchange 内部实现为保存 binding 关系的查找表；

channel 是实际进行路由工作的实体，负责按照 routing_key 将 message投递给queue。

由 AMQP 协议描述可知，channel 是真实TCP连接之上的 虚拟连接 ， 所有AMQP 命令都是通过 channel 发送的，且每一个 channel 有 唯一的ID 。一个 channel 只能被单独一个操作系统线程使用，所以投递到特定的 channel 上的 message 是有顺序的。单一个操作系统线程上允许使用多个channel。


### 11、消费者某些原因无法处理当前接受的消息如何来拒绝？
### 12、RabbitMQ publish/subscribe发布订阅(共享资源)
### 13、RabbitMQ事务机制？
### 14、如何确保消息不丢失？
### 15、生产者消息运转？
### 16、如何确保消息正确地发送至RabbitMQ？ 如何确保消息接收方消费了消息？
### 17、优先级队列？
### 18、消息怎么路由？
### 19、如何保证消息的可靠性投递?
### 20、消费者接收消息过程？
### 21、消息基于什么传输？
### 22、客户端连接到 cluster 中的任意 node 上是否都能正常工作？
### 23、消息怎么路由？
### 24、RabbitMQ simple模式（即最简单的收发模式）
### 25、你们公司生产环境用的是什么消息中间件？
### 26、RabbitMQ work工作模式(资源的竞争)
### 27、Basic.Reject 的用法是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
