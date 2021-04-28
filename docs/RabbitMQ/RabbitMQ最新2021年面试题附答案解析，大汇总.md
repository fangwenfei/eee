# RabbitMQ最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、多个消费者监听一个队列时，消息如何分发?

轮询: 默认的策略，消费者轮流，平均地接收消息

公平分发: 根据消费者的能力来分发消息，给空闲的消费者发送更多消息

**当消费者有x条消息没有响应ACK时，不再给这个消费者发送消息**

```
channel.basicQos(int x)
```


### 2、RabbitMQ 什么是信道？

信道：是生产者、消费者与RabbitMQ通信的渠道，生产者publish或是消费者subscribe一个队列都是通过信道来通信的。信道是建立在TCP连接上的虚拟连接。就是说RabbitMQ在一条TCP上建立成百上千个信道来达到多个线程处理，这个TCP被多个线程共享，每个线程对应一个信道，信道在RabbitMQ都有一个唯一的ID，保证了信道私有性，对应上唯一的线程使用。

**疑问：为什么不建立多个TCP连接？**

原因是RabbitMQ需要保证性能，系统为每个线程开辟一个TCP是非常消耗性能的，美妙成百上千的建立销毁TCP会严重消耗系统性能；所以RabbitMQ选择建立多个信道（建立在TCP的虚拟连接）连接到RabbitMQ上


### 3、RabbitMQ中消息可能有的几种状态?

alpha: 消息内容(包括消息体、属性和 headers) 和消息索引都存储在内存中 。

beta: 消息内容保存在磁盘中，消息索引保存在内存中。

gamma: 消息内容保存在磁盘中，消息索引在磁盘和内存中都有 。

delta: 消息内容和索引都在磁盘中 。



### 4、消息如何分发?

若该队列至少有一个消费者订阅，消息将以循环（round-robin）的方式发送给消费者。每条消息只会分发给一个订阅的消费者（前提是消费者能够正常处理消息并进行确认）。


### 5、AMQP模型的几大组件？

**1、** 交换器 (Exchange)：消息代理服务器中用于把消息路由到队列的组件。

**2、** 队列 (Queue)：用来存储消息的数据结构，位于硬盘或内存中。

**3、** 绑定 (Binding)： 一套规则，告知交换器消息应该将消息投递给哪个队列。


### 6、生产者消息如何运转？

**1、** Producer先连接到Broker,建立连接Connection,开启一个信道(Channel)。

**2、** Producer声明一个交换器并设置好相关属性。

**3、** Producer声明一个队列并设置好相关属性。

**4、** Producer通过路由键将交换器和队列绑定起来。

**5、** Producer发送消息到Broker,其中包含路由键、交换器等信息。

**6、** 相应的交换器根据接收到的路由键查找匹配的队列。

**7、** 如果找到，将消息存入对应的队列，如果没有找到，会根据生产者的配置丢弃或者退回给生产者。

**8、** 关闭信道。

**9、** 管理连接。


### 7、客户端连接到 cluster 中的任意 node 上是否都能正常工作？

是的。客户端感觉不到有何不同。

问题九：若 cluster 中拥有某个 queue 的 owner node 失效了，且该 queue 被声明具有durable 属性，是否能够成功从其他 node 上重新声明该 queue ？

不能，在这种情况下，将得到 404 NOT_FOUND 错误。只能等 queue 所属的 node恢复后才能使用该 queue 。但若该 queue 本身不具有 durable 属性，则可在其他 node上重新声明。


### 8、RabbitMQ中消息可能有的几种状态?

**1、** alpha: 消息内容(包括消息体、属性和 headers) 和消息索引都存储在内存中 。

**2、** beta: 消息内容保存在磁盘中，消息索引保存在内存中。

**3、** gamma: 消息内容保存在磁盘中，消息索引在磁盘和内存中都有 。

**4、** delta: 消息内容和索引都在磁盘中 。


### 9、为什么 heavy RPC 的使用场景下不建议采用 disk node ？

heavy RPC 是指在业务逻辑中高频调用 RabbitMQ 提供的 RPC 机制，导致不断创建、销毁 reply queue ，进而造成 disk node 的性能问题（因为会针对元数据不断写盘）。所以在使用 RPC 机制时需要考虑自身的业务场景。


### 10、Queue队列？

Queue:RabbitMQ的内部对象，用于存储消息。多个消费者可以订阅同一队列，这时队列中的消息会被平摊（轮询）给多个消费者进行处理。


### 11、MQ 有哪些常见问题？如何解决这些问题？
### 12、routing_key 和 binding_key 的最大长度是多少？
### 13、队列结构？
### 14、如何确保消息不丢失？
### 15、Exchange交换器？
### 16、优先级队列？
### 17、如何保证RabbitMQ不被重复消费？
### 18、如何确保消息正确地发送至 RabbitMQ？ 如何确保消息接收方消费了消息？
### 19、什么是生产者Producer?
### 20、如何确保消息正确地发送至RabbitMQ？ 如何确保消息接收方消费了消息？
### 21、死信队列和延迟队列的使用?
### 22、RabbitMQ消息是如何路由的？
### 23、RabbitMQ 概念里的 channel、exchange 和 queue 这些东东是逻辑概念，还是对应着进程实体？这些东东分别起什么作用？
### 24、RabbitMQ 上的一个 queue 中存放的 message 是否有数量限制？
### 25、RabbitMQ publish/subscribe发布订阅(共享资源)
### 26、RabbitMQ是什么？
### 27、vhost 是什么？起什么作用？
### 28、消息如何分发？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
