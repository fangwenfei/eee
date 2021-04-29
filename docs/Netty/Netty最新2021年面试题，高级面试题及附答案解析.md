# Netty最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Netty 是什么？

Netty是 一个异步事件驱动的网络应用程序框架，用于快速开发可维护的高性能协议服务器和客户端。Netty是基于nio的，它封装了jdk的nio，让我们使用起来更加方法灵活。


### 2、NIO 是什么？

**1、** NIO ，全称 New IO ，也叫 Non-Block IO ，是一种非阻塞 + 同步的通信模式。Java NIO( New IO 或者 Non Blocking IO ) ，从 Java 1.4 版本开始引入的非阻塞 IO ，用于替换标准( 有些文章也称为传统，或者 Blocking IO 。下文统称为 BIO ) Java IO API 的 IO API 。

**2、** NIO 相对于 BIO 来说一大进步。客户端和服务器之间通过 Channel 通信。NIO 可以在 Channel 进行读写操作。这些 Channel 都会被注册在 Selector 多路复用器上。Selector 通过一个线程不停的轮询这些 Channel 。找出已经准备就绪的 Channel 执行 IO 操作。


### 3、EventloopGroup 了解么?和 EventLoop 啥关系?

刚刚你也介绍了 EventLoop。那你再说说 EventloopGroup 吧！和 EventLoop 啥关系?

![](https://p6-tt.byteimg.com/large/pgc-image/4f7f376b3ae14247ac9a0dd910990a4b#alt=)

EventLoopGroup 包含多个 EventLoop（每一个 EventLoop 通常内部包含一个线程），上面我们已经说了 EventLoop 的主要作用实际就是负责监听网络事件并调用事件处理器进行相关 I/O 操作的处理。

并且 EventLoop 处理的 I/O 事件都将在它专有的 Thread 上被处理，即 Thread 和 EventLoop 属于 1 : 1 的关系，从而保证线程安全。

上图是一个服务端对 EventLoopGroup 使用的大致模块图，其中 Boss EventloopGroup 用于接收连接，Worker EventloopGroup 用于具体的处理（消息的读写以及其他逻辑处理）。

从上图可以看出：当客户端通过 connect 方法连接服务端时，bossGroup 处理客户端连接请求。当客户端处理完成后，会将这个连接提交给 workerGroup 来处理，然后 workerGroup 负责处理其 IO 相关操作。


### 4、NioEventLoopGroup 默认的构造函数会起多少线程？

看过 Netty 的源码了么？NioEventLoopGroup 默认的构造函数会起多少线程呢？

嗯嗯！看过部分。

回顾我们在上面写的服务器端的代码：

```
// 1.bossGroup 用于接收连接，workerGroup 用于具体的处理
EventLoopGroup bossGroup = new NioEventLoopGroup(1);
EventLoopGroup workerGroup = new NioEventLoopGroup();
```

为了搞清楚NioEventLoopGroup 默认的构造函数 到底创建了多少个线程，我们来看一下它的源码。

```
    /**
     * 无参构造函数。
     * nThreads:0
     */
    public NioEventLoopGroup() {
        //调用下一个构造方法
        this(0);
    }

    /**
     * Executor：null
     */
    public NioEventLoopGroup(int nThreads) {
        //继续调用下一个构造方法
        this(nThreads, (Executor) null);
    }

    //中间省略部分构造函数

    /**
     * RejectedExecutionHandler（）：RejectedExecutionHandlers.reject()
     */
    public NioEventLoopGroup(int nThreads, Executor executor, final SelectorProvider selectorProvider,final SelectStrategyFactory selectStrategyFactory) {
       //开始调用父类的构造函数
        super(nThreads, executor, selectorProvider, selectStrategyFactory, RejectedExecutionHandlers.reject());
    }
```

一直向下走下去的话，你会发现在 MultithreadEventLoopGroup 类中有相关的指定线程数的代码，如下：

```
    // 从1，系统属性，CPU核心数*2 这三个值中取出一个最大的
    //可以得出 DEFAULT_EVENT_LOOP_THREADS 的值为CPU核心数*2
    private static final int DEFAULT_EVENT_LOOP_THREADS = Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));

    // 被调用的父类构造函数，NioEventLoopGroup 默认的构造函数会起多少线程的秘密所在
    // 当指定的线程数nThreads为0时，使用默认的线程数DEFAULT_EVENT_LOOP_THREADS
    protected MultithreadEventLoopGroup(int nThreads, ThreadFactory threadFactory, Object..、args) {
        super(nThreads == 0 ? DEFAULT_EVENT_LOOP_THREADS : nThreads, threadFactory, args);
    }
```

综上，我们发现 NioEventLoopGroup 默认的构造函数实际会起的线程数为 **CPU核心数_2_。

另外，如果你继续深入下去看构造函数的话，你会发现每个NioEventLoopGroup对象内部都会分配一组NioEventLoop，其大小是 nThreads, 这样就构成了一个线程池， 一个NIOEventLoop 和一个线程相对应，这和我们上面说的 EventloopGroup 和 EventLoop关系这部分内容相对应。


### 5、Netty 长连接、心跳机制了解么？

TCP 长连接和短连接了解么？

我们知道 TCP 在进行读写之前，server 与 client 之间必须提前建立一个连接。建立连接的过程，需要我们常说的三次握手，释放/关闭连接的话需要四次挥手。这个过程是比较消耗网络资源并且有时间延迟的。

所谓，短连接说的就是 server 端 与 client 端建立连接之后，读写完成之后就关闭掉连接，如果下一次再要互相发送消息，就要重新连接。短连接的有点很明显，就是管理和实现都比较简单，缺点也很明显，每一次的读写都要建立连接必然会带来大量网络资源的消耗，并且连接的建立也需要耗费时间。

长连接说的就是 client 向 server 双方建立连接之后，即使 client 与 server 完成一次读写，它们之间的连接并不会主动关闭，后续的读写操作会继续使用这个连接。长连接的可以省去较多的 TCP 建立和关闭的操作，降低对网络资源的依赖，节约时间。对于频繁请求资源的客户来说，非常适用长连接。


### 6、BIO 是什么？

**1、** BIO ，全称 Block-IO ，是一种阻塞 + 同步的通信模式。一种比较传统的通信方式，模式简单，使用方便。但并发处理能力低，通信耗时，依赖网速。

**2、** 原理：服务器通过一个 Acceptor 线程，负责监听客户端请求和为每个客户端创建一个新的线程进行链路处理。典型的一请求一应答模式。若客户端数量增多，频繁地创建和销毁线程会给服务器打开很大的压力。后改良为用线程池的方式代替新增线程，被称为伪异步 IO 。


### 7、Bootstrap 和 ServerBootstrap 了解么？

你再说说自己对 Bootstrap 和 ServerBootstrap 的了解吧！

Bootstrap 是客户端的启动引导类/辅助类，具体使用方法如下：

```
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建客户端启动引导/辅助类：Bootstrap
            Bootstrap b = new Bootstrap();
            //指定线程模型
            b.group(group).
                    ......
            // 尝试建立连接
            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } finally {
            // 优雅关闭相关线程组资源
            group.shutdownGracefully();
        }
```

ServerBootstrap 客户端的启动引导类/辅助类，具体使用方法如下：

```
        // 1.bossGroup 用于接收连接，workerGroup 用于具体的处理
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //2.创建服务端启动引导/辅助类：ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();
            //3.给引导类配置两大线程组,确定了线程模型
            b.group(bossGroup, workerGroup).
                   ......
            // 6.绑定端口
            ChannelFuture f = b.bind(port).sync();
            // 等待连接关闭
            f.channel().closeFuture().sync();
        } finally {
            //7.优雅关闭相关线程组资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
```

**从上面的示例中，我们可以看出：**

**1、**  Bootstrap 通常使用 connet() 方法连接到远程的主机和端口，作为一个 Netty TCP 协议通信中的客户端。另外，Bootstrap 也可以通过 bind() 方法绑定本地的一个端口，作为 UDP 协议通信中的一端。

**2、**  ServerBootstrap通常使用 bind() 方法绑定本地的端口上，然后等待客户端的连接。

**3、**  Bootstrap 只需要配置一个线程组— EventLoopGroup ,而 ServerBootstrap需要配置两个线程组— EventLoopGroup ，一个用于接收连接，一个用于具体的处理。


### 8、Netty 如何实现高性能

**1、** 线程模型 ：更加优雅的 Reactor 模式实现、灵活的线程模型、利用 EventLoop 等创新性的机制，可以非常高效地管理成百上千的 Channel 。

**2、** 内存池设计 ：使用池化的 Direct Buffer 等技术，在提高 IO 性能的同时，减少了对象的创建和销毁。并且，Netty的内部实现是用一颗二叉查找树，更好的管理内存分配情况。

**3、** 内存零拷贝 ：使用 Direct Buffer ，可以使用 Zero-Copy 机制（避免上下分切换频繁）。

**4、** 协议支持 ：提供对 Protobuf 等高性能序列化协议支持。


### 9、TCP 粘包 / 拆包的产生原因，应该这么解决

**1、** TCP 是以流的方式来处理数据，所以会导致粘包 / 拆包。

**2、** 拆包：一个完整的包可能会被 TCP 拆分成多个包进行发送。

**3、** 粘包：也可能把小的封装成一个大的数据包发送。

**4、** Netty中提供了多个 Decoder 解析类 用于解决上述问题：

**5、** FixedLengthFrameDecoder 、LengthFieldBasedFrameDecoder ，固定长度是消息头指定消息长度的一种形式，进行粘包拆包处理的。

**6、** LineBasedFrameDecoder 、DelimiterBasedFrameDecoder ，换行是于指定消息边界方式的一种形式，进行消息粘包拆包处理的。


### 10、Netty如何实现重连

**1、** 客户端，通过 IdleStateHandler 实现定时检测是否空闲

**2、** 如果空闲，则向服务端发起心跳*

**3、** 如果多次心跳失败，则关闭和服务端的连接，然后重新发起连接

**4、** 服务端，通过 IdleStateHandler 实现定时检测客户端是否空闲

**5、** 如果检测到空闲，则关闭客户端

**6、** 如果接收到客户端的心跳请求，要反馈一个心跳响应给客户端。


### 11、Netty 中有哪种重要组件？
### 12、TCP 粘包/拆包的原因及解决方法？
### 13、为什么要用 Netty？
### 14、Netty 服务端和客户端的启动过程了解么？
### 15、BIO、NIO 有什么区别？
### 16、Netty的特点是什么（ 为什么选择 Netty ）
### 17、TCP 粘包/拆包的原因及解决方法？
### 18、Netty为什么要实现内存管理
### 19、Netty自己实现的ByteBuf有什么优点
### 20、Netty 高性能表现在哪些方面？
### 21、为什么需要心跳机制？Netty 中心跳机制了解么？
### 22、Netty 线程模型了解么？
### 23、Netty 的核心组件介绍下
### 24、Netty 的零拷贝了解么？
### 25、什么是Netty
### 26、NIO 的组成？
### 27、Netty 的使用场景
### 28、Netty 空闲检测
### 29、Netty 支持哪些心跳类型设置？
### 30、Netty 的高性能体现在哪方面
### 31、默认情况 Netty 起多少线程？何时启动？
### 32、Netty 是什么？
### 33、了解哪几种序列化协议？
### 34、什么是 Netty 的零拷贝？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
