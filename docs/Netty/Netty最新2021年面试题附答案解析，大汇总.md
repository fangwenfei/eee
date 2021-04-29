# Netty最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、AIO 是什么？

AIO ，全称 Asynchronous IO ，也叫 NIO2 ，是一种非阻塞 + 异步的通信模式。在 NIO 的基础上，引入了新的异步通道的概念，并提供了异步文件通道和异步套接字通道的实现。AIO 并没有采用 NIO 的多路复用器，而是使用异步通道的概念。其 read，write 方法的返回类型，都是 Future 对象。而 Future 模型是异步的，其核心思想是：去主函数等待时间。


### 2、Netty 高性能表现在哪些方面？

**1、** IO 线程模型：同步非阻塞，用最少的资源做更多的事。

**2、** 内存零拷贝：尽量减少不必要的内存拷贝，实现了更高效率的传输。

**3、** 内存池设计：申请的内存可以重用，主要指直接内存。内部实现是用一颗二叉查找树管理内存分配情况。

**4、** 串形化处理读写：避免使用锁带来的性能开销。

**5、** 高性能序列化协议：支持 protobuf 等高性能序列化协议。


### 3、Netty 如何实现高性能

**1、** 线程模型 ：更加优雅的 Reactor 模式实现、灵活的线程模型、利用 EventLoop 等创新性的机制，可以非常高效地管理成百上千的 Channel 。

**2、** 内存池设计 ：使用池化的 Direct Buffer 等技术，在提高 IO 性能的同时，减少了对象的创建和销毁。并且，Netty的内部实现是用一颗二叉查找树，更好的管理内存分配情况。

**3、** 内存零拷贝 ：使用 Direct Buffer ，可以使用 Zero-Copy 机制（避免上下分切换频繁）。

**4、** 协议支持 ：提供对 Protobuf 等高性能序列化协议支持。


### 4、默认情况 Netty 起多少线程？何时启动？

Netty 默认是 CPU 处理器数的两倍，bind 完之后启动。


### 5、TCP 粘包 / 拆包的产生原因，应该这么解决

**1、** TCP 是以流的方式来处理数据，所以会导致粘包 / 拆包。

**2、** 拆包：一个完整的包可能会被 TCP 拆分成多个包进行发送。

**3、** 粘包：也可能把小的封装成一个大的数据包发送。

**4、** Netty中提供了多个 Decoder 解析类 用于解决上述问题：

**5、** FixedLengthFrameDecoder 、LengthFieldBasedFrameDecoder ，固定长度是消息头指定消息长度的一种形式，进行粘包拆包处理的。

**6、** LineBasedFrameDecoder 、DelimiterBasedFrameDecoder ，换行是于指定消息边界方式的一种形式，进行消息粘包拆包处理的。


### 6、Netty怎样实现零拷贝

**1、** Netty 的接收和发送 ByteBuffer 采用堆外直接内存 Direct Buffer

**2、** 使用堆外直接内存进行 Socket 读写，不需要进行字节缓冲区的二次拷贝；使用堆内内存会多了一次内存拷贝，JVM 会将堆内存 Buffer 拷贝一份到直接内存中，然后才写入 Socket 中。Netty 创建的 ByteBuffer 类型，由 ChannelConfig 配置。而 ChannelConfig 配置的 ByteBufAllocator 默认创建 Direct Buffer 类型。

**3、** CompositeByteBuf 类，可以将多个 ByteBuf 合并为一个逻辑上的 ByteBuf ，避免了传统通过内存拷贝的方式将几个小 Buffer 合并成一个大的 Buffer 。

**4、** 通过 FileRegion 包装的 FileChannel 。

**5、** 通过 wrap 方法, 我们可以将 byte[] 数组、ByteBuf、ByteBuffer 等包装成一个 Netty ByteBuf 对象, 进而避免了拷贝操作。


### 7、什么是 TCP 粘包/拆包?有什么解决办法呢？

什么是 TCP 粘包/拆包?

TCP 粘包/拆包 就是你基于 TCP 发送数据的时候，出现了多个字符串“粘”在了一起或者一个字符串被“拆”开的问题。比如你多次发送：“你好,你真帅啊！哥哥！”，但是客户端接收到的可能是下面这样的：

![](https://p29-tt.byteimg.com/large/pgc-image/4320f906f0e54b989ab19fde5f823a16#alt=)

那有什么解决办法呢?

**使用 Netty 自带的解码器**

LineBasedFrameDecoder : 发送端发送数据包的时候，每个数据包之间以换行符作为分隔，LineBasedFrameDecoder 的工作原理是它依次遍历 ByteBuf 中的可读字节，判断是否有换行符，然后进行相应的截取。

DelimiterBasedFrameDecoder : 可以自定义分隔符解码器，**LineBasedFrameDecoder** 实际上是一种特殊的 DelimiterBasedFrameDecoder 解码器。

FixedLengthFrameDecoder: 固定长度解码器，它能够按照指定的长度对消息进行相应的拆包。

LengthFieldBasedFrameDecoder：

**自定义序列化编解码器**

在 Java 中自带的有实现 Serializable 接口来实现序列化，但由于它性能、安全性等原因一般情况下是不会被使用到的。

通常情况下，我们使用 Protostuff、Hessian2、json 序列方式比较多，另外还有一些序列化性能非常好的序列化方式也是很好的选择：

专门针对 Java 语言的：Kryo，FST 等等

跨语言的：Protostuff（基于 protobuf 发展而来），ProtoBuf，Thrift，Avro，MsgPack 等等


### 8、Netty 线程模型了解么？

说一下 Netty 线程模型吧！

大部分网络框架都是基于 Reactor 模式设计开发的。

**Reactor 模式基于事件驱动，采用多路复用将事件分发给相应的 Handler 处理，非常适合处理海量 IO 的场景**。

在 Netty 主要靠 NioEventLoopGroup 线程池来实现具体的线程模型的 。

我们实现服务端的时候，一般会初始化两个线程组：

**1、** bossGroup :接收连接。

**2、** workerGroup ：负责具体的处理，交由对应的 Handler 处理。


### 9、Netty 的应用场景有哪些？

典型的应用有：阿里分布式服务框架 Dubbo，默认使用 Netty 作为基础通信组件，还有 RocketMQ 也是使用 Netty 作为通讯的基础。


### 10、Netty自己实现的ByteBuf有什么优点

**1、** 它可以被用户自定义的缓冲区类型扩展

**2、** 通过内置的符合缓冲区类型实现了透明的零拷贝

**3、** 读和写使用了不同的索引

**4、** 支持方法的链式调用

**5、** 支持池化


### 11、NIO的组成？
### 12、Netty 和 Tomcat 的区别？
### 13、原生的NIO存在Epoll Bug有什么BUG、Netty 是怎么解决的
### 14、如何选择序列化协议？
### 15、Netty 应用场景了解么？
### 16、Bootstrap 和 ServerBootstrap 了解么？
### 17、Netty 的可扩展如何体现
### 18、什么是 Reactor 模型
### 19、EventloopGroup 了解么?和 EventLoop 啥关系?
### 20、Netty 是什么？
### 21、什么是 Netty 的零拷贝？
### 22、Netty为什么说使用简单
### 23、Netty 的核心组件介绍下
### 24、Netty为什么要实现内存管理
### 25、BIO、NIO 有什么区别？
### 26、BIO、NIO和AIO的区别？
### 27、简单解析一下服务端的创建过程具体是怎样的：
### 28、Netty 的特点是什么？
### 29、BIO 是什么？
### 30、Netty 的优势有哪些？
### 31、JDK原生NIO程序的问题
### 32、NIO 是什么？
### 33、Netty 中的零拷贝体现在几个方面：
### 34、Netty 是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
