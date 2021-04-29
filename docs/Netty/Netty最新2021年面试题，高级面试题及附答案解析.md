# Netty最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、TCP 粘包/拆包的原因及解决方法？

TCP是以流的方式来处理数据，一个完整的包可能会被TCP拆分成多个包进行发送，也可能把小的封装成一个大的数据包发送。

TCP粘包/分包的原因：

应用程序写入的字节大小大于套接字发送缓冲区的大小，会发生拆包现象，而应用程序写入数据小于套接字缓冲区大小，网卡将应用多次写入的数据发送到网络上，这将会发生粘包现象；

进行MSS大小的TCP分段，当TCP报文长度-TCP头部长度>MSS的时候将发生拆包

以太网帧的payload（净荷）大于MTU（1500字节）进行ip分片。

解决方法

消息定长：FixedLengthFrameDecoder类

包尾增加特殊字符分割：

行分隔符类：LineBasedFrameDecoder

或自定义分隔符类 ：DelimiterBasedFrameDecoder

将消息分为消息头和消息体：LengthFieldBasedFrameDecoder类。分为有头部的拆包与粘包、长度字段在前且有头部的拆包与粘包、多扩展头部的拆包与粘包。


### 2、Netty 线程模型了解么？

说一下 Netty 线程模型吧！

大部分网络框架都是基于 Reactor 模式设计开发的。

**Reactor 模式基于事件驱动，采用多路复用将事件分发给相应的 Handler 处理，非常适合处理海量 IO 的场景**。

在 Netty 主要靠 NioEventLoopGroup 线程池来实现具体的线程模型的 。

我们实现服务端的时候，一般会初始化两个线程组：

**1、** bossGroup :接收连接。

**2、** workerGroup ：负责具体的处理，交由对应的 Handler 处理。


### 3、BIO 是什么？

**1、** BIO ，全称 Block-IO ，是一种阻塞 + 同步的通信模式。一种比较传统的通信方式，模式简单，使用方便。但并发处理能力低，通信耗时，依赖网速。

**2、** 原理：服务器通过一个 Acceptor 线程，负责监听客户端请求和为每个客户端创建一个新的线程进行链路处理。典型的一请求一应答模式。若客户端数量增多，频繁地创建和销毁线程会给服务器打开很大的压力。后改良为用线程池的方式代替新增线程，被称为伪异步 IO 。


### 4、Netty 的高性能表现在哪些方面？

**心跳，对服务端：**会定时清除闲置会话 inactive(netty5)，对客户端:用来检测会话是否断开，是否重来，检测网络延迟，其中 idleStateHandler 类 用来检测会话状态

**串行无锁化设计，**即消息的处理尽可能在同一个线程内完成，期间不进行线程切换，这样就避免了多线程竞争和同步锁。表面上看，串行化设计似乎 CPU 利用率不高，并发程度不够。但是，通过调整 NIO 线程池的线程参数，可以同时启动多个串行化的线程并行运行，这种局部无锁化的串行线程设计相比一个队列-多个工作线程模型性能更优。

**可靠性，链路有效性检测：**链路空闲检测机制，读/写空闲超时机制；内存保护机制：通过内存池重用 ByteBuf;ByteBuf 的解码保护；优雅停机：不再接收新消息、退出前的预处理操作、资源的释放操作。

**Netty 安全性：**支持的安全协议：SSL V2 和 V3，TLS，SSL 单向认证、双向认证和第三方 CA证。

**高效并发编程的体现：**volatile 的大量、正确使用；CAS 和原子类的广泛使用；线程安全容器的使用；通过读写锁提升并发性能。IO 通信性能三原则：传输（AIO）、协议（Http）、线程（主从多线程）

**流量整型的作用（变压器）：**防止由于上下游网元性能不均衡导致下游网元被压垮，业务流中断；防止由于通信模块接受消息过快，后端业务线程处理不及时导致撑死问题。

**TCP 参数配置：**SO_RCVBUF 和 SO_SNDBUF：通常建议值为 128K 或者 256K；

SO_TCPNODELAY：NAGLE 算法通过将缓冲区内的小封包自动相连，组成较大的封包，阻止大量小封包的发送阻塞网络，从而提高网络应用效率。但是对于时延敏感的应用场景需要关闭该优化算法；


### 5、NIO 是什么？

**1、** NIO ，全称 New IO ，也叫 Non-Block IO ，是一种非阻塞 + 同步的通信模式。Java NIO( New IO 或者 Non Blocking IO ) ，从 Java 1.4 版本开始引入的非阻塞 IO ，用于替换标准( 有些文章也称为传统，或者 Blocking IO 。下文统称为 BIO ) Java IO API 的 IO API 。

**2、** NIO 相对于 BIO 来说一大进步。客户端和服务器之间通过 Channel 通信。NIO 可以在 Channel 进行读写操作。这些 Channel 都会被注册在 Selector 多路复用器上。Selector 通过一个线程不停的轮询这些 Channel 。找出已经准备就绪的 Channel 执行 IO 操作。


### 6、NIO 的组成？

**Buffer：**与 Channel 进行交互，数据是从 Channel 读入缓冲区，从缓冲区写入 Channel 中的

**flip 方法 ：** 反转此缓冲区，将 position 给 limit，然后将 position 置为 0，其实就是切换读写模式

**clear 方法 ：**清除此缓冲区，将 position 置为 0，把 capacity 的值给 limit。

**rewind 方法 ：** 重绕此缓冲区，将 position 置为 0

**DirectByteBuffer** ：可减少一次系统空间到用户空间的拷贝。但 Buffer 创建和销毁的成本更高，不可控，通常会用内存池来提高性能。直接缓冲区主要分配给那些易受基础系统的本机 I/O 操作影响的大型、持久的缓冲区。如果数据量比较小的中小应用情况下，可以考虑使用 heapBuffer，由 JVM 进行管理。

**Channel：**表示 IO 源与目标打开的连接，是双向的，但不能直接访问数据，只能与 Buffer进行交互。通过源码可知，FileChannel 的 read 方法和 write 方法都导致数据复制了两次！

**Selector：**可使一个单独的线程管理多个 Channel，open 方法可创建 Selector，register 方法向多路复用器器注册通道，可以监听的事件类型：读、写、连接、accept。注册事件后会产生一个SelectionKey：它表示 SelectableChannel 和 Selector 之间的注册关系，**wakeup 方法**：使尚未返回的第一个选择操作立即返回，唤醒的原因是：注册了新的 channel 或者事件；channel 关闭，取消注册；优先级更高的事件触发（如定时器事件），希望及时处理。

Selector 在 Linux 的实现类是 EPollSelectorImpl，委托给 EPollArrayWrapper 实现，其中三个native 方法是对 epoll 的封装，而 EPollSelectorImpl、implRegister 方法，通过调用 epoll_ctl向 epoll 实例中注册事件，还将注册的文件描述符(fd)与 SelectionKey 的对应关系添加到fdToKey 中，这个 map 维护了文件描述符与 SelectionKey 的映射。

fdToKey 有时会变得非常大，因为注册到 Selector 上的 Channel 非常多（百万连接）；过期或失效的 Channel 没有及时关闭。fdToKey 总是串行读取的，而读取是在 select 方法中进行的，该方法是非线程安全的。

** Pipe：**两个线程之间的单向数据连接，数据会被写到 sink 通道，从 source 通道读取

**NIO 的服务端建立过程：Selector.open()：**打开一个 Selector；  **ServerSocketChannel.open()：**

创建服务端的 Channel；  ** bind()：**绑定到某个端口上。并配置非阻塞模式； **  register()：**注册Channel 和关注的事件到 Selector 上；  **select()：**轮询拿到已经就绪的事件


### 7、原生的NIO存在Epoll Bug有什么BUG、Netty 是怎么解决的

Java NIO Epoll 会导致 Selector 空轮询，最终导致 CPU 100% 。

Netty对Selector的select 操作周期进行统计，每完成一次空的 select 操作进行一次计数，若在某个周期内连续发生 N 次空轮询，则判断触发了 Epoll 死循环 Bug 。


### 8、EventloopGroup 了解么?和 EventLoop 啥关系?
### 9、Netty 如何实现高性能
### 10、Bootstrap 和 ServerBootstrap 了解么？
### 11、Netty 支持哪些心跳类型设置？
### 12、Netty 是什么？
### 13、Netty 中的零拷贝体现在几个方面：
### 14、Netty为什么要实现内存管理
### 15、Netty 的高性能体现在哪方面
### 16、Netty 核心组件有哪些？分别有什么作用？
### 17、Netty 的零拷贝了解么？
### 18、Netty 的特点是什么？
### 19、Netty 的线程模型？
### 20、什么是 Reactor 模型
### 21、BIO、NIO 和 AIO 的区别？
### 22、为什么要用 Netty？
### 23、Netty如何实现重连
### 24、Netty 和 Tomcat 的区别？
### 25、如何选择序列化协议？
### 26、Netty 发送消息有几种方式？
### 27、Netty 的可扩展如何体现
### 28、Netty的特点是什么（ 为什么选择 Netty ）
### 29、了解哪几种序列化协议？
### 30、详细看说下 Netty 中的线程模型吧！
### 31、Netty的线程模型？
### 32、BIO、NIO和AIO的区别？
### 33、Netty为什么说使用简单
### 34、如何选择序列化协议？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
