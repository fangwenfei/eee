# Netty最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Netty 中有哪种重要组件？

**1、** Channel：Netty 网络操作抽象类，它除了包括基本的 I/O 操作，如 bind、connect、read、write 等。

**2、** EventLoop：主要是配合 Channel 处理 I/O 操作，用来处理连接的生命周期中所发生的事情。

**3、** ChannelFuture：Netty 框架中所有的 I/O 操作都为异步的，因此我们需要 ChannelFuture 的 addListener()注册一个 ChannelFutureListener 监听事件，当操作执行成功或者失败时，监听就会自动触发返回结果。

**4、** ChannelHandler：充当了所有处理入站和出站数据的逻辑容器。ChannelHandler 主要用来处理各种事件，这里的事件很广泛，比如可以是连接、数据接收、异常、数据转换等。

**5、** ChannelPipeline：为 ChannelHandler 链提供了容器，当 channel 创建时，就会被自动分配到它专属的 ChannelPipeline，这个关联是永久性的。


### 2、BIO、NIO 有什么区别？

线程模型不同

**1、** BIO：一个连接一个线程，客户端有连接请求时服务器端就需要启动一个线程进行处理。所以，线程开销大。可改良为用线程池的方式代替新创建线程，被称为伪异步 IO 。

**2、** NIO：一个请求一个线程，但客户端发送的连接请求都会注册到多路复用器上，多路复用器轮询到连接有新的 I/O 请求时，才启动一个线程进行处理。可改良为一个线程处理多个请求，基于 多 Reactor 模型。

**3、** BIO 是面向流( Stream )的，而 NIO 是面向缓冲区( Buffer )的。

**4、** BIO 的各种操作是阻塞的，而 NIO 的各种操作是非阻塞的。

**5、** BIO 的 Socket 是单向的，而 NIO 的 Channel 是双向的。


### 3、Netty的高可靠体现在哪几方面

**1、** 链路有效性检测：由于长连接不需要每次发送消息都创建链路，也不需要在消息完成交互时关闭链路，因此相对于短连接性能更高。

**2、** 内存保护机制，Netty 提供多种机制对内存进行保护。通过对象引用计数器对 ByteBuf 进行细粒度的内存申请和释放，对非法的对象引用进行检测和保护。可设置的内存容量上限，包括 ByteBuf、线程池线程数等，避免异常请求耗光内存。

**3、** 优雅停机：优雅停机功能指的是当系统推出时，JVM 通过注册的 Shutdown Hook 拦截到退出信号量，然后执行推出操作，释放相关模块的资源占用，将缓冲区的消息处理完成或清空，将待刷新的数据持久化到磁盘和数据库中，等到资源回收和缓冲区消息处理完成之后，再退出。


### 4、简单解析一下服务端的创建过程具体是怎样的：

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


### 5、为什么需要心跳机制？Netty 中心跳机制了解么？

在 TCP 保持长连接的过程中，可能会出现断网等网络异常出现，异常发生的时候， client 与 server 之间如果没有交互的话，它们是无法发现对方已经掉线的。为了解决这个问题, 我们就需要引入 **心跳机制** 。

心跳机制的工作原理是: 在 client 与 server 之间在一定时间内没有数据交互时, 即处于 idle 状态时, 客户端或服务器就会发送一个特殊的数据包给对方, 当接收方收到这个数据报文后, 也立即发送一个特殊的数据报文, 回应发送方, 此即一个 PING-PONG 交互。所以, 当某一端收到心跳消息后, 就知道了对方仍然在线, 这就确保 TCP 连接的有效性.

TCP 实际上自带的就有长连接选项，本身是也有心跳包机制，也就是 TCP 的选项：SO_KEEPALIVE。但是，TCP 协议层面的长连接灵活性不够。所以，一般情况下我们都是在应用层协议上实现自定义心跳机制的，也就是在 Netty 层面通过编码实现。通过 Netty 实现心跳机制的话，核心类是 IdleStateHandler 。


### 6、TCP 粘包 / 拆包的产生原因，应该这么解决

**1、** TCP 是以流的方式来处理数据，所以会导致粘包 / 拆包。

**2、** 拆包：一个完整的包可能会被 TCP 拆分成多个包进行发送。

**3、** 粘包：也可能把小的封装成一个大的数据包发送。

**4、** Netty中提供了多个 Decoder 解析类 用于解决上述问题：

**5、** FixedLengthFrameDecoder 、LengthFieldBasedFrameDecoder ，固定长度是消息头指定消息长度的一种形式，进行粘包拆包处理的。

**6、** LineBasedFrameDecoder 、DelimiterBasedFrameDecoder ，换行是于指定消息边界方式的一种形式，进行消息粘包拆包处理的。


### 7、Netty 应用场景了解么？

能不能通俗地说一下使用 Netty 可以做什么事情？

**1、**  作为 RPC 框架的网络通信工具 ：我们在分布式系统中，不同服务节点之间经常需要相互调用，这个时候就需要 RPC 框架了。不同服务节点之间的通信是如何做的呢？可以使用 Netty 来做。比如我调用另外一个节点的方法的话，至少是要让对方知道我调用的是哪个类中的哪个方法以及相关参数吧！

**2、**  实现一个自己的 HTTP 服务器 ：通过 Netty 我们可以自己实现一个简单的 HTTP 服务器，这个大家应该不陌生。说到 HTTP 服务器的话，作为 Java 后端开发，我们一般使用 Tomcat 比较多。一个最基本的 HTTP 服务器可要以处理常见的 HTTP Method 的请求，比如 POST 请求、GET 请求等等。

**3、**  实现一个即时通讯系统 ：使用 Netty 我们可以实现一个可以聊天类似微信的即时通讯系统，这方面的开源项目还蛮多的，可以自行去 Github 找一找。

**4、**  实现消息推送系统 ：市面上有很多消息推送系统都是基于 Netty 来做的。

**5、**  ......


### 8、Netty 长连接、心跳机制了解么？
### 9、Netty 的核心组件介绍下
### 10、NIOEventLoopGroup 源码？
### 11、什么是 TCP 粘包/拆包?有什么解决办法呢？
### 12、客户端代码
### 13、JDK原生NIO程序的问题
### 14、了解哪几种序列化协议？
### 15、AIO 是什么？
### 16、NioEventLoopGroup 默认的构造函数会起多少线程？
### 17、什么是 Netty 的零拷贝？
### 18、Netty 是什么？
### 19、Netty 的使用场景
### 20、Netty自己实现的ByteBuf有什么优点
### 21、Netty 的特点？
### 22、了解哪几种序列化协议
### 23、Netty 服务端和客户端的启动过程了解么？
### 24、Netty怎样实现零拷贝
### 25、Netty 空闲检测
### 26、Netty 高性能表现在哪些方面？
### 27、NIOEventLoopGroup源码？
### 28、Netty 的优势有哪些？
### 29、什么是Netty
### 30、默认情况 Netty 起多少线程？何时启动？
### 31、TCP 粘包/拆包的原因及解决方法？
### 32、Netty 的应用场景有哪些？
### 33、Netty 的零拷贝实现？
### 34、NIO的组成？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
