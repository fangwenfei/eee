# Netty最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Netty 的可扩展如何体现

**1、** 提供大量系统参数 ：供用户按需设置，增强系统的场景定制性。

**2、** 提供大量的工厂类 ：通过重载这些工厂类，可以按需创建出用户需要的对象。

**3、** 基于接口的开发 ：关键的类库都提供了接口或抽象类，便于用户自定义实现。

**4、** 责任链模式 ：ChannelPipeline 基于责任链模式开发，便于业务逻辑的拦截、定制和扩展。


### 2、BIO、NIO 和 AIO 的区别？

**BIO：**一个连接一个线程，客户端有连接请求时服务器端就需要启动一个线程进行处理。线程开销大。

**伪异步 IO：**将请求连接放入线程池，一对多，但线程还是很宝贵的资源。

**NIO：**一个请求一个线程，但客户端发送的连接请求都会注册到多路复用器上，多路复用器轮询到连接有 I/O 请求时才启动一个线程进行处理。

**AIO：**一个有效请求一个线程，客户端的 I/O 请求都是由 OS 先完成了再通知服务器应用去启动线程进行处理。

BIO 是面向流的，NIO 是面向缓冲区的；BIO 的各种流是阻塞的。而 NIO 是非阻塞的；BIO的 Stream 是单向的，而 NIO 的 channel 是双向的。

**NIO 的特点：**事件驱动模型、单线程处理多任务、非阻塞 I/O，I/O 读写不再阻塞，而是返回 0、基于 block 的传输比基于流的传输更高效、更高级的 IO 函数 zero-copy、IO 多路复用大大提高了 Java 网络应用的可伸缩性和实用性。基于 Reactor 线程模型。

在 Reactor 模式中，事件分发器等待某个事件或者可应用或个操作的状态发生，事件分发器就把这个事件传给事先注册的事件处理函数或者回调函数，由后者来做实际的读写操作。如在 Reactor 中实现读：注册读就绪事件和相应的事件处理器、事件分发器等待事件、事件到来，激活分发器，分发器调用事件对应的处理器、事件处理器完成实际的读操作，处理读到的数据，注册新的事件，然后返还控制权。


### 3、BIO、NIO和AIO的区别？

BIO：一个连接一个线程，客户端有连接请求时服务器端就需要启动一个线程进行处理。线程开销大。

伪异步IO：将请求连接放入线程池，一对多，但线程还是很宝贵的资源。

NIO：一个请求一个线程，但客户端发送的连接请求都会注册到多路复用器上，多路复用器轮询到连接有I/O请求时才启动一个线程进行处理。

AIO：一个有效请求一个线程，客户端的I/O请求都是由OS先完成了再通知服务器应用去启动线程进行处理，

BIO是面向流的，NIO是面向缓冲区的；BIO的各种流是阻塞的。而NIO是非阻塞的；BIO的Stream是单向的，而NIO的channel是双向的。

NIO的特点：事件驱动模型、单线程处理多任务、非阻塞I/O，I/O读写不再阻塞，而是返回0、基于block的传输比基于流的传输更高效、更高级的IO函数zero-copy、IO多路复用大大提高了Java网络应用的可伸缩性和实用性。基于Reactor线程模型。

在Reactor模式中，事件分发器等待某个事件或者可应用或个操作的状态发生，事件分发器就把这个事件传给事先注册的事件处理函数或者回调函数，由后者来做实际的读写操作。如在Reactor中实现读：注册读就绪事件和相应的事件处理器、事件分发器等待事件、事件到来，激活分发器，分发器调用事件对应的处理器、事件处理器完成实际的读操作，处理读到的数据，注册新的事件，然后返还控制权。


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


### 5、Netty 线程模型了解么？

说一下 Netty 线程模型吧！

大部分网络框架都是基于 Reactor 模式设计开发的。

**Reactor 模式基于事件驱动，采用多路复用将事件分发给相应的 Handler 处理，非常适合处理海量 IO 的场景**。

在 Netty 主要靠 NioEventLoopGroup 线程池来实现具体的线程模型的 。

我们实现服务端的时候，一般会初始化两个线程组：

**1、** bossGroup :接收连接。

**2、** workerGroup ：负责具体的处理，交由对应的 Handler 处理。


### 6、原生的NIO存在Epoll Bug有什么BUG、Netty 是怎么解决的

Java NIO Epoll 会导致 Selector 空轮询，最终导致 CPU 100% 。

Netty对Selector的select 操作周期进行统计，每完成一次空的 select 操作进行一次计数，若在某个周期内连续发生 N 次空轮询，则判断触发了 Epoll 死循环 Bug 。


### 7、Netty 的优势有哪些？

**1、** 使用简单：封装了 NIO 的很多细节，使用更简单。

**2、** 功能强大：预置了多种编解码功能，支持多种主流协议。

**3、** 定制能力强：可以通过 ChannelHandler 对通信框架进行灵活地扩展。

**4、** 性能高：通过与其他业界主流的 NIO 框架对比，Netty 的综合性能最优。

**5、** 稳定：Netty 修复了已经发现的所有 NIO 的 bug，让开发人员可以专注于业务本身。

**6、** 社区活跃：Netty 是活跃的开源项目，版本迭代周期短，bug 修复速度快。


### 8、Netty 核心组件有哪些？分别有什么作用？

Netty 核心组件有哪些？分别有什么作用？

**Channel**

Channel 接口是 Netty 对网络操作抽象类，它除了包括基本的 I/O 操作，如 bind()、connect()、read()、write() 等。

比较常用的Channel接口实现类是NioServerSocketChannel（服务端）和NioSocketChannel（客户端），这两个 Channel 可以和 BIO 编程模型中的ServerSocket以及Socket两个概念对应上。Netty 的 Channel 接口所提供的 API，大大地降低了直接使用 Socket 类的复杂性。

**EventLoop**

这么说吧！EventLoop（事件循环）接口可以说是 Netty 中最核心的概念了！

《Netty 实战》这本书是这样介绍它的：

EventLoop 定义了 Netty 的核心抽象，用于处理连接的生命周期中所发生的事件。

是不是很难理解？说实话，我学习 Netty 的时候看到这句话是没太能理解的。

说白了，**EventLoop 的主要作用实际就是负责监听网络事件并调用事件处理器进行相关 I/O 操作的处理。**

那 Channel 和 EventLoop 直接有啥联系呢？

Channel 为 Netty 网络操作(读写等操作)抽象类，EventLoop 负责处理注册到其上的Channel 处理 I/O 操作，两者配合参与 I/O 操作。

**ChannelFuture**

Netty 是异步非阻塞的，所有的 I/O 操作都为异步的。

因此，我们不能立刻得到操作是否执行成功，但是，你可以通过 ChannelFuture 接口的 addListener() 方法注册一个 ChannelFutureListener，当操作执行成功或者失败时，监听就会自动触发返回结果。

并且，你还可以通过ChannelFuture 的 channel() 方法获取关联的Channel

```
public interface ChannelFuture extends Future<Void> {
    Channel channel();

    ChannelFuture addListener(GenericFutureListener<? extends Future<? super Void>> var1);
     ......

    ChannelFuture sync() throws InterruptedException;
}
```

另外，我们还可以通过 ChannelFuture 接口的 sync()方法让异步的操作变成同步的。

**ChannelHandler 和 ChannelPipeline**

下面这段代码使用过 Netty 的小伙伴应该不会陌生，我们指定了序列化编解码器以及自定义的 ChannelHandler 处理消息。

```
b.group(eventLoopGroup)
        .handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
                ch.pipeline().addLast(new NettyKryoDecoder(kryoSerializer, RpcResponse.class));
                ch.pipeline().addLast(new NettyKryoEncoder(kryoSerializer, RpcRequest.class));
                ch.pipeline().addLast(new KryoClientHandler());
            }
        });
```

ChannelHandler 是消息的具体处理器。他负责处理读写操作、客户端连接等事情。

ChannelPipeline 为 ChannelHandler 的链，提供了一个容器并定义了用于沿着链传播入站和出站事件流的 API 。当 Channel 被创建时，它会被自动地分配到它专属的 ChannelPipeline。

我们可以在 ChannelPipeline 上通过 addLast() 方法添加一个或者多个ChannelHandler ，因为一个数据或者事件可能会被多个 Handler 处理。当一个 ChannelHandler 处理完之后就将数据交给下一个 ChannelHandler 。


### 9、了解哪几种序列化协议？

序列化（编码）是将对象序列化为二进制形式（字节数组），主要用于网络传输、数据持久化等；而反序列化（解码）则是将从网络、磁盘等读取的字节数组还原成原始对象，主要用于网络传输对象的解码，以便完成远程调用。

**影响序列化性能的关键因素：**序列化后的码流大小（网络带宽的占用）、序列化的性能（CPU 资源占用）；是否支持跨语言（异构系统的对接和开发语言切换）。

**Java 默认提供的序列化：**无法跨语言、序列化后的码流太大、序列化的性能差

**XML，优点：**人机可读性好，可指定元素或特性的名称。

**缺点：**序列化数据只包含数据本身以及类的结构，不包括类型标识和程序集信息；只能序列化公共属性和字段；不能序列化方法；文件庞大，文件格式复杂，传输占带宽。

**适用场景：**当做配置文件存储数据，实时数据转换。

**JSON**，是一种轻量级的数据交换格式，

**优点：**兼容性高、数据格式比较简单，易于读写、序列化后数据较小，可扩展性好，兼容性好、与 XML 相比，其协议比较简单，解析速度比较快。

**缺点：**数据的描述性比 XML 差、不适合性能要求为 ms 级别的情况、额外空间开销比较大。

**适用场景（可替代ＸＭＬ）：**跨防火墙访问、可调式性要求高、基于 Webbrowser 的 Ajax 请求、传输数据量相对小，实时性要求相对低（例如秒级别）的服务。

**Fastjson**，采用一种“假定有序快速匹配”的算法。

**优点：**接口简单易用、目前 java 语言中最快的 json 库。

**缺点：**过于注重快，而偏离了“标准”及功能性、代码质量不高，文档不全。

**适用场景：**协议交互、Web 输出、Android 客户端

**Thrift，**不仅是序列化协议，还是一个 RPC 框架。

**优点：**序列化后的体积小, 速度快、支持多种语言和丰富的数据类型、对于数据字段的增删具有较强的兼容性、支持二进制压缩编码。

**缺点：**使用者较少、跨防火墙访问时，不安全、不具有可读性，调试代码时相对困难、不能与其他传输层协议共同使用（例如 HTTP）、无法支持向持久层直接读写数据，即不适合做数据持久化序列化协议。

**适用场景：**分布式系统的 RPC 解决方案

**Avro，**Hadoop 的一个子项目，解决了 JSON 的冗长和没有 IDL 的问题。

**优点：**支持丰富的数据类型、简单的动态语言结合功能、具有自我描述属性、提高了数据解析速度、快速可压缩的二进制数据形式、可以实现远程过程调用 RPC、支持跨编程语言实现。

**缺点：**对于习惯于静态类型语言的用户不直观。

**适用场景：**在 Hadoop 中做 Hive、Pig 和MapReduce的持久化数据格式。

**Protobuf，**将数据结构以.proto 文件进行描述，通过代码生成工具可以生成对应数据结构的POJO 对象和 Protobuf 相关的方法和属性。

**优点：**序列化后码流小，性能高、结构化数据存储格式（XML JSON 等）、通过标识字段的顺序，可以实现协议的前向兼容、结构化的文档更容易管理和维护。

**缺点：**需要依赖于工具生成代码、支持的语言相对较少，官方只支持Java 、C++ 、python。

**适用场景：**对性能要求高的 RPC 调用、具有良好的跨防火墙的访问属性、适合应用层对象的持久化

**其它**

**protostuff** 基于 protobuf 协议，但不需要配置 proto 文件，直接导包即可

**Jboss marshaling** 可以直接序列化 java 类， 无须实 java.io.Serializable 接口

**Message pack** 一个高效的二进制序列化格式

**Hessian** 采用二进制协议的轻量级 remoting onhttp 工具

**kryo**基于 protobuf 协议，只支持 java 语言,需要注册（Registration），然后序列化（Output），反序列化（Input）


### 10、Netty 的高性能体现在哪方面

**1、** 线程模型 ：采用异步非阻塞的 I/O 类库，基于 Reactor 模式实现，解决了传统同步阻塞 I/O 模式下服务端无法平滑处理客户端线性增长的问题。

**2、** 堆外内存 ：TCP 接收和发送缓冲区采用直接内存代替堆内存，避免了内存复制，提升了 I/O 读取和写入性能。

**3、** 内存池设计 ：支持通过内存池的方式循环利用 ByteBuf，避免了频繁创建和销毁 ByteBuf 带来的性能消耗。

**4、** 参数配置 ：可配置的 I/O 线程数目和 TCP 参数等，为不同用户提供定制化的调优参数，满足不同的性能场景。

**5、** 队列优化 ：采用环形数组缓冲区，实现无锁化并发编程，代替传统的线程安全容器或锁。

**6、** 并发能力 ：合理使用线程安全容器、原子类等，提升系统的并发能力。

**7、** 降低锁竞争 ：关键资源的使用采用单线程串行化的方式，避免多线程并发访问带来的锁竞争和额外的 CPU 资源消耗问题。

**8、** 内存泄露检测 ：通过引用计数器及时地释放不再被引用的对象，细粒度的内存管理降低了 GC 的频率，减少频繁 GC 带来的时延增大和 CPU 损耗。


### 11、TCP 粘包/拆包的原因及解决方法？
### 12、EventloopGroup 了解么?和 EventLoop 啥关系?
### 13、Netty的线程模型？
### 14、如何选择序列化协议？
### 15、Netty的特点是什么（ 为什么选择 Netty ）
### 16、JDK原生NIO程序的问题
### 17、Netty 是什么？
### 18、Netty 的特点？
### 19、Netty 的高性能表现在哪些方面？
### 20、Netty 发送消息有几种方式？
### 21、Netty 长连接、心跳机制了解么？
### 22、NIOEventLoopGroup源码？
### 23、Netty自己实现的ByteBuf有什么优点
### 24、NIO的组成？
### 25、Netty 中的零拷贝体现在几个方面：
### 26、默认情况 Netty 起多少线程？何时启动？
### 27、Netty 的核心组件介绍下
### 28、客户端代码
### 29、Netty如何实现重连
### 30、Netty 是什么？
### 31、Netty 的特点是什么？
### 32、Netty怎样实现零拷贝
### 33、什么是 Netty 的零拷贝？
### 34、Netty 的应用场景有哪些？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
