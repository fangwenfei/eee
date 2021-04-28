# Netty最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Netty如何实现重连

**1、** 客户端，通过 IdleStateHandler 实现定时检测是否空闲

**2、** 如果空闲，则向服务端发起心跳*

**3、** 如果多次心跳失败，则关闭和服务端的连接，然后重新发起连接

**4、** 服务端，通过 IdleStateHandler 实现定时检测客户端是否空闲

**5、** 如果检测到空闲，则关闭客户端

**6、** 如果接收到客户端的心跳请求，要反馈一个心跳响应给客户端。


### 2、Netty 的可扩展如何体现

**1、** 提供大量系统参数 ：供用户按需设置，增强系统的场景定制性。

**2、** 提供大量的工厂类 ：通过重载这些工厂类，可以按需创建出用户需要的对象。

**3、** 基于接口的开发 ：关键的类库都提供了接口或抽象类，便于用户自定义实现。

**4、** 责任链模式 ：ChannelPipeline 基于责任链模式开发，便于业务逻辑的拦截、定制和扩展。


### 3、什么是Netty

**1、** Netty 是一款提供异步的、事件驱动的网络应用程序框架和工具，用以快速开发高性能、高可靠性的网络服务器和客户端程序。

**2、** 也就是说，Netty 是一个基于 NIO 的客户、服务器端编程框架。使用 Netty 可以确保你快速和简单地开发出一个网络应用，例如实现了某种协议的客户，服务端应用。Netty 相当简化和流线化了网络应用的编程开发过程，例如，TCP 和 UDP 的 socket 服务开发。


### 4、BIO、NIO 有什么区别？

线程模型不同

**1、** BIO：一个连接一个线程，客户端有连接请求时服务器端就需要启动一个线程进行处理。所以，线程开销大。可改良为用线程池的方式代替新创建线程，被称为伪异步 IO 。

**2、** NIO：一个请求一个线程，但客户端发送的连接请求都会注册到多路复用器上，多路复用器轮询到连接有新的 I/O 请求时，才启动一个线程进行处理。可改良为一个线程处理多个请求，基于 多 Reactor 模型。

**3、** BIO 是面向流( Stream )的，而 NIO 是面向缓冲区( Buffer )的。

**4、** BIO 的各种操作是阻塞的，而 NIO 的各种操作是非阻塞的。

**5、** BIO 的 Socket 是单向的，而 NIO 的 Channel 是双向的。


### 5、Netty的高可靠体现在哪几方面

**1、** 链路有效性检测：由于长连接不需要每次发送消息都创建链路，也不需要在消息完成交互时关闭链路，因此相对于短连接性能更高。

**2、** 内存保护机制，Netty 提供多种机制对内存进行保护。通过对象引用计数器对 ByteBuf 进行细粒度的内存申请和释放，对非法的对象引用进行检测和保护。可设置的内存容量上限，包括 ByteBuf、线程池线程数等，避免异常请求耗光内存。

**3、** 优雅停机：优雅停机功能指的是当系统推出时，JVM 通过注册的 Shutdown Hook 拦截到退出信号量，然后执行推出操作，释放相关模块的资源占用，将缓冲区的消息处理完成或清空，将待刷新的数据持久化到磁盘和数据库中，等到资源回收和缓冲区消息处理完成之后，再退出。


### 6、Netty 的零拷贝实现？

Netty 的接收和发送 ByteBuffer 采用 DIRECT BUFFERS，使用堆外直接内存进行 Socket 读写，不需要进行字节缓冲区的二次拷贝。堆内存多了一次内存拷贝，JVM 会将堆内存Buffer 拷贝一份到直接内存中，然后才写入 Socket 中。ByteBuffer 由 ChannelConfig 分配，而 ChannelConfig 创建 ByteBufAllocator 默认使用 Direct Buffer

CompositeByteBuf 类可以将多个 ByteBuf 合并为一个逻辑上的 ByteBuf, 避免了传统通过内存拷贝的方式将几个小 Buffer 合并成一个大的 Buffer。addComponents 方法将header与 body 合并为一个逻辑上的 ByteBuf, 这两个 ByteBuf 在 CompositeByteBuf 内部都是单独存在的, CompositeByteBuf 只是逻辑上是一个整体。

通过 FileRegion 包装的 FileChannel.tranferTo 方法 实现文件传输, 可以直接将文件缓冲区的数据发送到目标 Channel，避免了传统通过循环 write 方式导致的内存拷贝问题。

通过 wrap 方法, 我们可以将 byte[] 数组、ByteBuf、ByteBuffer 等包装成一个 NettyByteBuf 对象, 进而避免了拷贝操作。

Selector  BUG：若 Selector 的轮询结果为空，也没有 wakeup 或新消息处理，则发生空轮询，CPU 使用率 100%，

Netty 的解决办法：对 Selector 的 select 操作周期进行统计，每完成一次空的 select 操作进行一次计数，若在某个周期内连续发生 N 次空轮询，则触发了 epoll 死循环 bug。重建Selector，判断是否是其他线程发起的重建请求，若不是则将原 SocketChannel 从旧的Selector 上去除注册，重新注册到新的 Selector 上，并将原来的 Selector 关闭。


### 7、NIOEventLoopGroup 源码？

NioEventLoopGroup(其实是 MultithreadEventExecutorGroup)内部维护一个类型为EventExecutor children [], 默认大小是处理器核数 * 2, 这样就构成了一个线程池，初始化EventExecutor 时 NioEventLoopGroup 重载 newChild 方法，所以 children 元素的实际类型为NioEventLoop。

线程启动时调用 SingleThreadEventExecutor 的构造方法，执行 NioEventLoop 类的 run 方法，首先会调用 hasTasks()方法判断当前 taskQueue 是否有元素。如果 taskQueue 中有元素，执行selectNow() 方法，最终执行 selector.selectNow()，该方法会立即返回。如果taskQueue 没有元素，执行 select(oldWakenUp) 方法

select ( oldWakenUp) 方法解决了 Nio 中的 bug，selectCnt 用来记录 selector.select 方法的执行次数和标识是否执行过 selector.selectNow()，若触发了 epoll 的空轮询 bug，则会反复执行 selector.select(timeoutMillis)，变量 selectCnt 会逐渐变大，当 selectCnt 达到阈值（默认 512），则执行 rebuildSelector 方法，进行 selector 重建，解决 cpu 占用 100%的 bug。

rebuildSelector 方法先通过 openSelector 方法创建一个新的 selector。然后将 old selector 的selectionKey 执行 cancel。最后将 old selector 的 channel 重新注册到新的 selector 中。rebuild 后，需要重新执行方法 selectNow，检查是否有已 ready 的 selectionKey。

接下来调用 processSelectedKeys 方法（处理 I/O 任务），当 selectedKeys != null 时，调用processSelectedKeysOptimized 方法，迭代 selectedKeys 获取就绪的 IO 事件的 selectkey 存

放在数组 selectedKeys 中,然后为每个事件都调用processSelectedKey来处理它，processSelectedKey 中分别处理 OP_READ；OP_WRITE；OP_CONNECT 事件。

最后调用 runAllTasks 方法（非 IO 任务），该方法首先会调用 fetchFromScheduledTaskQueue方法，把 scheduledTaskQueue 中已经超过延迟执行时间的任务移到 taskQueue 中等待被执行，然后依次从 taskQueue 中取任务执行，每执行 64 个任务，进行耗时检查，如果已执行时间超过预先设定的执行时间，则停止执行非 IO 任务，避免非 IO 任务太多，影响 IO 任务的执行。

每个 NioEventLoop 对应一个线程和一个 Selector，NioServerSocketChannel 会主动注册到某一个 NioEventLoop 的 Selector 上，NioEventLoop 负责事件轮询。

Outbound 事件都是请求事件, 发起者是 Channel，处理者是 unsafe，通过 Outbound 事件进行通知，传播方向是 tail 到 head。Inbound 事件发起者是 unsafe，事件的处理者是Channel, 是通知事件，传播方向是从头到尾。

内存管理机制，首先会预申请一大块内存 Arena，Arena 由许多 Chunk 组成，而每个 Chunk默认由 2048 个 page 组成。Chunk 通过 AVL 树的形式组织 Page，每个叶子节点表示一个Page，而中间节点表示内存区域，节点自己记录它在整个 Arena 中的偏移地址。当区域被分配出去后，中间节点上的标记位会被标记，这样就表示这个中间节点以下的所有节点都已被分配了。大于 8k 的内存分配在 poolChunkList 中，而 PoolSubpage 用于分配小于 8k 的内存，它会把一个 page 分割成多段，进行内存分配。

ByteBuf 的特点：支持自动扩容（4M），保证 put 方法不会抛出异常、通过内置的复合缓冲类型，实现零拷贝（zero-copy）；不需要调用 flip()来切换读/写模式，读取和写入索引分开；方法链；引用计数基于 AtomicIntegerFieldUpdater 用于内存回收；PooledByteBuf 采用二叉树来实现一个内存池，集中管理内存的分配和释放，不用每次使用都新建一个缓冲区对象。UnpooledHeapByteBuf 每次都会新建一个缓冲区对象。


### 8、EventloopGroup 了解么?和 EventLoop 啥关系?

刚刚你也介绍了 EventLoop。那你再说说 EventloopGroup 吧！和 EventLoop 啥关系?

![](https://p6-tt.byteimg.com/large/pgc-image/4f7f376b3ae14247ac9a0dd910990a4b#alt=)

EventLoopGroup 包含多个 EventLoop（每一个 EventLoop 通常内部包含一个线程），上面我们已经说了 EventLoop 的主要作用实际就是负责监听网络事件并调用事件处理器进行相关 I/O 操作的处理。

并且 EventLoop 处理的 I/O 事件都将在它专有的 Thread 上被处理，即 Thread 和 EventLoop 属于 1 : 1 的关系，从而保证线程安全。

上图是一个服务端对 EventLoopGroup 使用的大致模块图，其中 Boss EventloopGroup 用于接收连接，Worker EventloopGroup 用于具体的处理（消息的读写以及其他逻辑处理）。

从上图可以看出：当客户端通过 connect 方法连接服务端时，bossGroup 处理客户端连接请求。当客户端处理完成后，会将这个连接提交给 workerGroup 来处理，然后 workerGroup 负责处理其 IO 相关操作。


### 9、Netty为什么说使用简单

**1、** 无需关心 OP_ACCEPT、OP_READ、OP_WRITE 等等 IO 操作，Netty 已经封装，对我们在使用是透明无感的。

**2、** 使用 boss 和 worker EventLoopGroup ，Netty 直接提供多 Reactor 多线程模型。

**3、** 在 Netty 中，我们看到有使用一个解码器 FixedLengthFrameDecoder，可以用于处理定长消息的问题，能够解决 TCP 粘包拆包问题，十分方便。如果使用 Java NIO ，需要我们自行实现解码器。


### 10、为什么要用 Netty？

为什么要用 Netty 呢？能不能说一下自己的看法。

因为 Netty 具有下面这些优点，并且相比于直接使用 JDK 自带的 NIO 相关的 API 来说更加易用。

**1、** 统一的 API，支持多种传输类型，阻塞和非阻塞的。

**2、** 简单而强大的线程模型。

**3、** 自带编解码器解决 TCP 粘包/拆包问题。

**4、** 自带各种协议栈。

**5、** 真正的无连接数据包套接字支持。

**6、** 比直接使用 Java 核心 API 有更高的吞吐量、更低的延迟、更低的资源消耗和更少的内存复制。

**7、** 安全性不错，有完整的 SSL/TLS 以及 StartTLS 支持。

**8、** 社区活跃

**9、** 成熟稳定，经历了大型项目的使用和考验，而且很多开源项目都使用到了 Netty， 比如我们经常接触的 Dubbo、RocketMQ 等等。

**10、** ......


### 11、默认情况 Netty 起多少线程？何时启动？
### 12、详细看说下 Netty 中的线程模型吧！
### 13、简单解析一下服务端的创建过程具体是怎样的：
### 14、了解哪几种序列化协议
### 15、BIO、NIO 和 AIO 的区别？
### 16、了解哪几种序列化协议？
### 17、客户端代码
### 18、NIO的组成？
### 19、Netty 的应用场景有哪些？
### 20、为什么需要心跳机制？Netty 中心跳机制了解么？
### 21、Netty 的高性能体现在哪方面
### 22、Netty 和 Tomcat 的区别？
### 23、原生的NIO存在Epoll Bug有什么BUG、Netty 是怎么解决的
### 24、Netty 的线程模型？
### 25、NIO 是什么？
### 26、Netty 服务端和客户端的启动过程了解么？
### 27、Netty怎样实现零拷贝
### 28、BIO 是什么？
### 29、Netty为什么要实现内存管理
### 30、Netty 如何实现高性能
### 31、BIO、NIO和AIO的区别？
### 32、Netty的特点是什么（ 为什么选择 Netty ）
### 33、Netty 支持哪些心跳类型设置？
### 34、Netty 是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
