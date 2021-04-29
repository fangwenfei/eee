# RabbitMQ最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、能够在地理上分开的不同数据中心使用 RabbitMQ cluster 么？

不能。第一，你无法控制所创建的 queue 实际分布在 cluster 里的哪个 node 上（一般使用 HAProxy + cluster 模型时都是这样），这可能会导致各种跨地域访问时的常见问题；第二，Erlang 的 OTP 通信框架对延迟的容忍度有限，这可能会触发各种超时，导致业务疲于处理；第三，在广域网上的连接失效问题将导致经典的“脑裂”问题，而RabbitMQ 目前无法处理（该问题主要是说 Mnesia）。


### 2、消费者Consumer?

消费消息，也就是接收消息的一方。

消费者连接到RabbitMQ服务器，并订阅到队列上。消费消息时只消费消息体，丢弃标签。


### 3、RabbitMQ 什么是信道？

信道：是生产者、消费者与RabbitMQ通信的渠道，生产者publish或是消费者subscribe一个队列都是通过信道来通信的。信道是建立在TCP连接上的虚拟连接。就是说RabbitMQ在一条TCP上建立成百上千个信道来达到多个线程处理，这个TCP被多个线程共享，每个线程对应一个信道，信道在RabbitMQ都有一个唯一的ID，保证了信道私有性，对应上唯一的线程使用。

**疑问：为什么不建立多个TCP连接？**

原因是RabbitMQ需要保证性能，系统为每个线程开辟一个TCP是非常消耗性能的，美妙成百上千的建立销毁TCP会严重消耗系统性能；所以RabbitMQ选择建立多个信道（建立在TCP的虚拟连接）连接到RabbitMQ上


### 4、routing_key 和 binding_key 的最大长度是多少？

255 字节。


### 5、如何自动删除长时间没有消费的消息？

```
// 通过队列属性设置消息过期时间
Map<String, Object> argss = new HashMap<String, Object>();
argss.put("x-message-ttl",6000);

// 对每条消息设置过期时间
AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
    .expiration("10000") // TTL
```


### 6、为什么说保证 message 被可靠持久化的条件是 queue 和 exchange 具有durable 属性，同时 message 具有 persistent 属性才行？

binding 关系可以表示为 exchange – binding – queue 。从文档中我们知道，若要求投递的 message 能够不丢失，要求 message 本身设置 persistent 属性，要求 exchange和 queue 都设置 durable 属性。

其实这问题可以这么想，若 exchange 或 queue 未设置durable 属性，则在其 crash 之后就会无法恢复，那么即使 message 设置了 persistent 属性，仍然存在 message 虽然能恢复但却无处容身的问题；同理，若 message 本身未设置persistent 属性，则 message 的持久化更无从谈起。


### 7、RabbitMQ 中的 broker 是指什么？cluster 又是指什么？

broker 是指一个或多个 erlang node 的逻辑分组，且 node 上运行着 RabbitMQ 应用程序。cluster 是在 broker 的基础之上，增加了 node 之间共享元数据的约束。


### 8、RabbitMQ的工作模式有几种？

**simple模式（即最简单的收发模式）**

**1、** 消息产生消息，将消息放入队列

**2、** 消息的消费者(consumer) 监听 消息队列,如果队列中有消息,就消费掉,消息被拿走后,自动从队列中删除(隐患 消息可能没有被消费者正确处理,已经从队列中消失了,造成消息的丢失，这里可以设置成手动的ack,但如果设置成手动ack，处理完后要及时发送ack消息给队列，否则会造成内存溢出)。

**work工作模式(资源的竞争)**

**1、**  消息产生者将消息放入队列消费者可以有多个,消费者1,消费者2同时监听同一个队列,消息被消费。C1 C2共同争抢当前的消息队列内容,谁先拿到谁负责消费消息(隐患：高并发情况下,默认会产生某一个消息被多个消费者共同使用,可以设置一个开关(syncronize) 保证一条消息只能被一个消费者使用)。

**publish/subscribe订阅(共享资源)**

**1、** 每个消费者监听自己的队列；

**2、** 生产者将消息发给broker，由交换机将消息转发到绑定此交换机的每个队列，每个绑定交换机的队列都将接收到消息。

四、routing路由模式![122_4.png][122_4.png]

**1、** 消息生产者将消息发送给交换机按照路由判断,路由是字符串(info) 当前产生的消息携带路由字符(对象的方法),交换机根据路由的key,只能匹配上路由key对应的消息队列,对应的消费者才能消费消息;

**2、** 根据业务功能定义路由字符串

**3、** 从系统的代码逻辑中获取对应的功能字符串,将消息任务扔到对应的队列中。

**4、** 业务场景:error 通知;EXCEPTION;错误通知的功能;传统意义的错误通知;客户通知;利用key路由,可以将程序中的错误封装成消息传入到消息队列中,开发者可以自定义消费者,实时接收错误;

**topic 主题模式(路由模式的一种)**

**1、** 星号井号代表通配符

**2、** 星号代表多个单词,井号代表一个单词

**3、** 路由功能添加模糊匹配

**4、** 消息产生者产生消息,把消息交给交换机

**5、** 交换机根据key的规则模糊匹配到对应的队列,由队列的监听消费者接收消息消费（在我的理解看来就是routing查询的一种模糊匹配，就类似sql的模糊查询方式）


### 9、交换器4种类型？

主要有以下4种。

fanout:把所有发送到该交换器的消息路由到所有与该交换器绑定的队列中。

direct:把消息路由到BindingKey和RoutingKey完全匹配的队列中。

topic:

匹配规则：

RoutingKey 为一个 点号'.': 分隔的字符串。 比如: java.xiaoka.show

BindingKey和RoutingKey一样也是点号“.“分隔的字符串。

BindingKey可使用 _ 和 # 用于做模糊匹配，_匹配一个单词，#匹配多个或者0个

headers:不依赖路由键匹配规则路由消息。是根据发送消息内容中的headers属性进行匹配。性能差，基本用不到。


### 10、AMQP模型的几大组件？

**1、** 交换器 (Exchange)：消息代理服务器中用于把消息路由到队列的组件。

**2、** 队列 (Queue)：用来存储消息的数据结构，位于硬盘或内存中。

**3、** 绑定 (Binding)： 一套规则，告知交换器消息应该将消息投递给哪个队列。


### 11、RabbitMQ有那些基本概念？
### 12、什么是Binding绑定？
### 13、RabbitMQ队列结构？
### 14、如何避免消息重复投递或重复消费？
### 15、什么是生产者Producer?
### 16、什么是MQ
### 17、RabbitMQ特点?
### 18、如何确保消息正确地发送至RabbitMQ?
### 19、消息如何分发?
### 20、Kafka、ActiveMQ、RabbitMQ、RocketMQ 有什么优缺点？
### 21、如何确保消息正确地发送至 RabbitMQ？ 如何确保消息接收方消费了消息？
### 22、生产者Producer?
### 23、延迟队列？
### 24、如何保证高可用的？RabbitMQ 的集群
### 25、Binding绑定？
### 26、消费者获取消息的方式？
### 27、什么是Queue队列？
### 28、消费者接收消息过程？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
