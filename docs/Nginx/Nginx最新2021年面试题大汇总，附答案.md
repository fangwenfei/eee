# Nginx最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、请解释 ngx_http_upstream_module 的作用是什么?

ngx_http_upstream_module 用于定义可通过 fastcgi 传递、proxy 传递、uwsgi

传递、Memcached 传递和 scgi 传递指令来引用的服务器组。


### 2、请列举 Nginx 的一些特性。

Nginx 服务器的特性包括：

**1、** 反向代理/L7 负载均衡器

**2、** 嵌入式 Perl 解释器

**3、** 动态二进制升级

**4、** 可用于重新编写 URL，具有非常好的 PCRE 支持


### 3、请解释 Nginx 如何处理 HTTP 请求？

**1、** 首先，Nginx 在启动时，会解析配置文件，得到需要监听的端口与 IP 地址，然后在 Nginx 的 Master 进程里面先初始化好这个监控的Socket(创建 S ocket，设置 addr、reuse 等选项，绑定到指定的 ip 地址端口，再 listen 监听)。

**2、** 然后，再 fork(一个现有进程可以调用 fork 函数创建一个新进程。由 fork 创建的新进程被称为子进程 )出多个子进程出来。

**3、** 之后，子进程会竞争 accept 新的连接。此时，客户端就可以向 nginx 发起连接了。当客户端与nginx进行三次握手，与 nginx 建立好一个连接后。此时，某一个子进程会 accept 成功，得到这个建立好的连接的 Socket ，然后创建 nginx 对连接的封装，即 ngx_connection_t 结构体。

**4、** 接着，设置读写事件处理函数，并添加读写事件来与客户端进行数据的交换。


### 4、请解释 Nginx 如何处理 HTTP 请求。

Nginx 使用反应器模式。主事件循环等待操作系统发出准备事件的信号，这样数据就可以从套接字读取，在该实例中读取到缓冲区并进行处理。单个线程可以提供数万个并发连接。


### 5、使用“反向代理服务器”的优点是什么?

反向代理服务器可以隐藏源服务器的存在和特征。它充当互联网云和 web 服务

器之间的中间层。这对于安全方面来说是很好的，特别是当您使用 web 托管服

务时。


### 6、为什么Nginx性能这么高？

因为他的事件处理机制：异步非阻塞事件处理机制：运用了epoll模型，提供了一个队列，排队解决


### 7、Location正则案例

**示例：**

```
#优先级

精确匹配，根路径
location = / {
   return 400;
}

#优先级2,以某个字符串开头,以av开头的，优先匹配这里，区分大小写
location ^~ /av {
    root / data / av / ;
}

#优先级
3，区分大小写的正则匹配，匹配 / media * * * * * 路径location~ / media {
    alias / data / static / ;
}

#优先级
4，不区分大小写的正则匹配，所有的 * * * * .jpg | gif | png都走这里
location~ * .*\.(jpg | gif | png | js | css) $ {
    root / data / av / ;
}

#优先
7，通用匹配
location / {
    return 403;
}
```


### 8、Nginx如何处理HTTP请求？

Nginx使用反应器模式。主事件循环等待操作系统发出准备事件的信号，这样数据就可以从套接字读取，在该实例中读取到缓冲区并进行处理。单个线程可以提供数万个并发连接。


### 9、解释如何在`Nginx`服务器上添加模块?

在编译过程中，必须选择`Nginx`模块，因为`Nginx`不支持模块的运行时间选择。


### 10、突发限制访问频率（突发流量）

**1、** 限制一个用户发送的请求，我Nginx多久接收一个。

**2、** 上面的配置一定程度可以限制访问频率，但是也存在着一个问题：如果突发流量超出请求被拒绝处理，无法处理活动时候的突发流量，这时候应该如何进一步处理呢？Nginx提供burst参数结合nodelay参数可以解决流量突发的问题，可以设置能处理的超过设置的请求数外能额外处理的请求数。我们可以将之前的例子添加burst参数以及nodelay参数：

```
#定义限流维度，一个用户一分钟一个请求进来，多余的全部漏掉
limit_req_zone $binary_remote_addr zone=one:10m rate=1r/m;

#绑定限流维度
server{

    location/seckill.html{
        limit_req zone=zone burst=5 nodelay;
        proxy_pass http://lj_seckill;
    }
}
```

为什么就多了一个 burst=5 nodelay; 呢，多了这个可以代表Nginx对于一个用户的请求会立即处理前五个，多余的就慢慢来落，没有其他用户的请求我就处理你的，有其他的请求的话我Nginx就漏掉不接受你的请求


### 11、Nginx 如何开启压缩？
### 12、使用“反向代理服务器”的优点是什么?
### 13、解释如何在 Nginx 服务器上添加模块?
### 14、漏桶流算法和令牌桶算法知道，漏桶算法#
### 15、权重 weight
### 16、请列举 Nginx 服务器的最佳用途。Nginx 服务器的最佳用法是在网络上部署动态 HTTP 内容，使用 SCGI、WSGI 应
### 17、Nginx怎么处理请求的？
### 18、如何通过不同于80的端口开启Nginx?
### 19、Nginx怎么判断别IP不可访问？
### 20、为什么要用Nginx？
### 21、解释如何在Nginx中获得当前的时间?
### 22、如何用Nginx解决前端跨域问题？
### 23、Nginx怎么做的动静分离？
### 24、Nginx 常用配置？
### 25、用 Nginx 服务器解释-s 的目的是什么?
### 26、限流怎么做的？
### 27、请解释什么是`C10K`问题?
### 28、Nginx 如何实现后端服务的健康检查？
### 29、Nginx是否支持将请求压缩到上游?
### 30、Nginx的优缺点？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
