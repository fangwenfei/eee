# Netty最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、AIO 是什么？

AIO ，全称 Asynchronous IO ，也叫 NIO2 ，是一种非阻塞 + 异步的通信模式。在 NIO 的基础上，引入了新的异步通道的概念，并提供了异步文件通道和异步套接字通道的实现。AIO 并没有采用 NIO 的多路复用器，而是使用异步通道的概念。其 read，write 方法的返回类型，都是 Future 对象。而 Future 模型是异步的，其核心思想是：去主函数等待时间。


### 2、默认情况 Netty 起多少线程？何时启动？

Netty 默认是 CPU 处理器数的两倍，bind 完之后启动。


### 3、什么是Netty

**1、** Netty 是一款提供异步的、事件驱动的网络应用程序框架和工具，用以快速开发高性能、高可靠性的网络服务器和客户端程序。

**2、** 也就是说，Netty 是一个基于 NIO 的客户、服务器端编程框架。使用 Netty 可以确保你快速和简单地开发出一个网络应用，例如实现了某种协议的客户，服务端应用。Netty 相当简化和流线化了网络应用的编程开发过程，例如，TCP 和 UDP 的 socket 服务开发。


### 4、Netty 支持哪些心跳类型设置？

readerIdleTime：为读超时时间（即测试端一定时间内未接受到被测试端消息）。

writerIdleTime：为写超时时间（即测试端一定时间内向被测试端发送消息）。

allIdleTime：所有类型的超时时间。


### 5、简单解析一下服务端的创建过程具体是怎样的：

首先你创建了两个 NioEventLoopGroup 对象实例：bossGroup 和 workerGroup。

bossGroup : 用于处理客户端的 TCP 连接请求。

workerGroup ：负责每一条连接的具体读写数据的处理逻辑，真正负责 I/O 读写操作，交由对应的 Handler 处理。

举个例子：我们把公司的老板当做 bossGroup，员工当做 workerGroup，bossGroup 在外面接完活之后，扔给 workerGroup 去处理。一般情况下我们会指定 bossGroup 的 线程数为 1（并发连接量不大的时候） ，workGroup 的线程数量为 **CPU 核心数 _2_ 。另外，根据源码来看，使用 NioEventLoopGroup 类的无参构造函数设置线程数量的默认值就是 CPU 核心数 2** 。

接下来 我们创建了一个服务端启动引导/辅助类：ServerBootstrap，这个类将引导我们进行服务端的启动工作。

通过 .group() 方法给引导类 ServerBootstrap 配置两大线程组，确定了线程模型。

通过下面的代码，我们实际配置的是多线程模型，这个在上面提到过。

```
EventLoopGroup bossGroup = new NioEventLoopGroup(1);
EventLoopGroup workerGroup = new NioEventLoopGroup();
```

通过channel()方法给引导类 ServerBootstrap指定了 IO 模型为NIO

**1、** NioServerSocketChannel ：指定服务端的 IO 模型为 NIO，与 BIO 编程模型中的ServerSocket对应

**2、** NioSocketChannel : 指定客户端的 IO 模型为 NIO， 与 BIO 编程模型中的Socket对应5.通过 .childHandler()给引导类创建一个ChannelInitializer ，然后制定了服务端消息的业务处理逻辑 HelloServerHandler 对象6.调用 ServerBootstrap 类的 bind()方法绑定端口


### 6、Netty 的可扩展如何体现

**1、** 提供大量系统参数 ：供用户按需设置，增强系统的场景定制性。

**2、** 提供大量的工厂类 ：通过重载这些工厂类，可以按需创建出用户需要的对象。

**3、** 基于接口的开发 ：关键的类库都提供了接口或抽象类，便于用户自定义实现。

**4、** 责任链模式 ：ChannelPipeline 基于责任链模式开发，便于业务逻辑的拦截、定制和扩展。


### 7、NIO 是什么？

**1、** NIO ，全称 New IO ，也叫 Non-Block IO ，是一种非阻塞 + 同步的通信模式。Java NIO( New IO 或者 Non Blocking IO ) ，从 Java 1.4 版本开始引入的非阻塞 IO ，用于替换标准( 有些文章也称为传统，或者 Blocking IO 。下文统称为 BIO ) Java IO API 的 IO API 。

**2、** NIO 相对于 BIO 来说一大进步。客户端和服务器之间通过 Channel 通信。NIO 可以在 Channel 进行读写操作。这些 Channel 都会被注册在 Selector 多路复用器上。Selector 通过一个线程不停的轮询这些 Channel 。找出已经准备就绪的 Channel 执行 IO 操作。


### 8、Netty 线程模型了解么？

说一下 Netty 线程模型吧！

大部分网络框架都是基于 Reactor 模式设计开发的。

**Reactor 模式基于事件驱动，采用多路复用将事件分发给相应的 Handler 处理，非常适合处理海量 IO 的场景**。

在 Netty 主要靠 NioEventLoopGroup 线程池来实现具体的线程模型的 。

我们实现服务端的时候，一般会初始化两个线程组：

**1、** bossGroup :接收连接。

**2、** workerGroup ：负责具体的处理，交由对应的 Handler 处理。


### 9、NIO 的组成？

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


### 10、Netty的线程模型？

Netty通过Reactor模型基于多路复用器接收并处理用户请求，内部实现了两个线程池，boss线程池和work线程池，其中boss线程池的线程负责处理请求的accept事件，当接收到accept事件的请求时，把对应的socket封装到一个NioSocketChannel中，并交给work线程池，其中work线程池负责请求的read和write事件，由对应的Handler处理。

单线程模型：所有I/O操作都由一个线程完成，即多路复用、事件分发和处理都是在一个Reactor线程上完成的。既要接收客户端的连接请求,向服务端发起连接，又要发送/读取请求或应答/响应消息。一个NIO 线程同时处理成百上千的链路，性能上无法支撑，速度慢，若线程进入死循环，整个程序不可用，对于高负载、大并发的应用场景不合适。

多线程模型：有一个NIO 线程（Acceptor） 只负责监听服务端，接收客户端的TCP 连接请求；NIO 线程池负责网络IO 的操作，即消息的读取、解码、编码和发送；1 个NIO 线程可以同时处理N 条链路，但是1 个链路只对应1 个NIO 线程，这是为了防止发生并发操作问题。但在并发百万客户端连接或需要安全认证时，一个Acceptor 线程可能会存在性能不足问题。

主从多线程模型：Acceptor 线程用于绑定监听端口，接收客户端连接，将SocketChannel 从主线程池的Reactor 线程的多路复用器上移除，重新注册到Sub 线程池的线程上，用于处理I/O 的读写等操作，从而保证mainReactor只负责接入认证、握手等操作；


### 11、原生的NIO存在Epoll Bug有什么BUG、Netty 是怎么解决的
### 12、Netty为什么说使用简单
### 13、TCP 粘包/拆包的原因及解决方法？
### 14、Netty 的特点？
### 15、NIOEventLoopGroup源码？
### 16、NIO的组成？
### 17、Netty自己实现的ByteBuf有什么优点
### 18、了解哪几种序列化协议
### 19、TCP 粘包/拆包的原因及解决方法？
### 20、Netty 的线程模型？
### 21、为什么要用 Netty？
### 22、Netty为什么要实现内存管理
### 23、了解哪几种序列化协议？
### 24、TCP 粘包 / 拆包的产生原因，应该这么解决
### 25、Netty 的核心组件介绍下
### 26、JDK原生NIO程序的问题
### 27、Bootstrap 和 ServerBootstrap 了解么？
### 28、Netty如何实现重连
### 29、Netty 中的零拷贝体现在几个方面：
### 30、如何选择序列化协议？
### 31、BIO 是什么？
### 32、Netty 中有哪种重要组件？
### 33、Netty 和 Tomcat 的区别？
### 34、什么是 Netty 的零拷贝？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
