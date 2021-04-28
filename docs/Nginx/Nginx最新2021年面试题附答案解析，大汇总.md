# Nginx最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、502错误可能原因

**1、** FastCGI进程是否已经启动

**2、** FastCGI worker进程数是否不够

**3、** FastCGI执行时间过长

**1、** fastcgi_connect_timeout 300;

**2、** fastcgi_send_timeout 300;

**3、** fastcgi_read_timeout 300;

**FastCGI Buffer不够**

**1、** nginx和apache一样，有前端缓冲限制，可以调整缓冲参数

**2、** fastcgi_buffer_size 32k;

**3、** fastcgi_buffers 8 32k;

**Proxy Buffer不够**

**1、** 如果你用了Proxying，调整

**2、** proxy_buffer_size 16k;

**3、** proxy_buffers 4 16k;

**php脚本执行时间过长**

将php-fpm.conf的0s的0s改成一个时间


### 2、Nginx目录结构有哪些？

```
[root@localhost ~]# tree /usr/local/nginx
/usr/local/nginx
├── client_body_temp
├── conf                             # Nginx所有配置文件的目录
│   ├── fastcgi.conf                 # fastcgi相关参数的配置文件
│   ├── fastcgi.conf.default         # fastcgi.conf的原始备份文件
│   ├── fastcgi_params               # fastcgi的参数文件
│   ├── fastcgi_params.default       
│   ├── koi-utf
│   ├── koi-win
│   ├── mime.types                   # 媒体类型
│   ├── mime.types.default
│   ├── nginx.conf                   # Nginx主配置文件
│   ├── nginx.conf.default
│   ├── scgi_params                  # scgi相关参数文件
│   ├── scgi_params.default  
│   ├── uwsgi_params                 # uwsgi相关参数文件
│   ├── uwsgi_params.default
│   └── win-utf
├── fastcgi_temp                     # fastcgi临时数据目录
├── html                             # Nginx默认站点目录
│   ├── 50x.html                     # 错误页面优雅替代显示文件，例如当出现502错误时会调用此页面
│   └── index.html                   # 默认的首页文件
├── logs                             # Nginx日志目录
│   ├── access.log                   # 访问日志文件
│   ├── error.log                    # 错误日志文件
│   └── nginx.pid                    # pid文件，Nginx进程启动后，会把所有进程的ID号写到此文件
├── proxy_temp                       # 临时目录
├── sbin                             # Nginx命令目录
│   └── nginx                        # Nginx的启动命令
├── scgi_temp                        # 临时目录
└── uwsgi_temp                       # 临时目录
```


### 3、漏桶流算法和令牌桶算法知道，漏桶算法#

漏桶算法是网络世界中流量整形或速率限制时经常使用的一种算法，它的主要目的是控制数据注入到网络的速率，平滑网络上的突发流量。漏桶算法提供了一种机制，通过它，突发流量可以被整形以便为网络提供一个稳定的流量。也就是我们刚才所讲的情况。漏桶算法提供的机制实际上就是刚才的案例：**突发流量会进入到一个漏桶，漏桶会按照我们定义的速率依次处理请求，如果水流过大也就是突发流量过大就会直接溢出，则多余的请求会被拒绝。所以漏桶算法能控制数据的传输速率。**

![56_1.png][56_1.png]


### 4、Nginx应用场景？

**1、** http服务器。Nginx是一个http服务可以独立提供http服务。可以做网页静态服务器。

**2、** 虚拟主机。可以实现在一台服务器虚拟出多个网站，例如个人网站使用的虚拟机。

**3、** 反向代理，负载均衡。当网站的访问量达到一定程度后，单台服务器不能满足用户的请求时，需要用多台服务器集群可以使用nginx做反向代理。并且多台服务器可以平均分担负载，不会应为某台服务器负载高宕机而某台服务器闲置的情况。

**4、** nginz 中也可以配置安全管理、比如可以使用Nginx搭建API接口网关,对每个接口服务进行拦截。


### 5、请解释`ngx_http_upstream_module`的作用是什么?

`ngx_http_upstream_module`用于定义可通过`fastcgi`传递、`proxy`传递、`uwsgi`传递、`Memcached`传递和scgi传递指令来引用的服务器组。


### 6、为什么 Nginx 不使用多线程？

Apache: 创建多个进程或线程，而每个进程或线程都会为其分配 cpu 和内存（线程要比进程小的多，所以 worker 支持比 perfork 高的并发），并发过大会榨干服务器资源。

Nginx: 采用单线程来异步非阻塞处理请求（管理员可以配置 Nginx 主进程的工作进程的数量）(epoll)，不会为每个请求分配 cpu 和内存资源，节省了大量资源，同时也减少了大量的 CPU 的上下文切换。所以才使得 Nginx 支持更高的并发。

**Netty、Redis 基本采用相同思路**


### 7、Nginx虚拟主机怎么配置?

**1、** 基于域名的虚拟主机，通过域名来区分虚拟主机——应用：外部网站

**2、** 基于端口的虚拟主机，通过端口来区分虚拟主机——应用：公司内部网站，外部网站的管理后台

**3、** 基于ip的虚拟主机。


### 8、Nginx如何处理HTTP请求？

Nginx使用反应器模式。主事件循环等待操作系统发出准备事件的信号，这样数据就可以从套接字读取，在该实例中读取到缓冲区并进行处理。单个线程可以提供数万个并发连接。


### 9、为什么Nginx性能这么高？

因为他的事件处理机制：异步非阻塞事件处理机制：运用了epoll模型，提供了一个队列，排队解决


### 10、Nginx怎么处理请求的？

nginx接收一个请求后，首先由listen和server_name指令匹配server模块，再匹配server模块里的location，location就是实际地址

```
server {#第一个
    Server区块开始，表示一个独立的虚拟主机站点
    listen 80；#提供服务的端口，默认 80
    server_name localhost；#提供服务的域名主机名
    location / {#第一个
        location区块开始
        root html；#站点的根目录，相当于 Nginx的安装目录
        index index.html index.htm；#默认的首页文件，多个用空格分开
    }#第一个
location区块结果
```


### 11、请列举 Nginx 的一些特性。
### 12、为什么要做动静分离？
### 13、解释如何在Nginx服务器上添加模块?
### 14、解释`Nginx`是否支持将请求压缩到上游?
### 15、Nginx 如何开启压缩？
### 16、Nginx配置文件nginx.conf有哪些属性模块?
### 17、nginx状态码
### 18、请解释你如何通过不同于 80 的端口开启 Nginx?
### 19、请解释 ngx_http_upstream_module 的作用是什么?
### 20、使用“反向代理服务器的优点是什么?
### 21、请解释 Nginx 如何处理 HTTP 请求。
### 22、Nginx怎么判断别IP不可访问？
### 23、用 Nginx 服务器解释-s 的目的是什么?
### 24、列举Nginx服务器的最佳用途。
### 25、在 Nginx 中，如何使用未定义的服务器名称来阻止处理请求?
### 26、请列举Nginx的一些特性？
### 27、如何用Nginx解决前端跨域问题？
### 28、Nginx的优缺点？
### 29、请陈述 stub_status 和 sub_filter 指令的作用是什么?
### 30、权重 weight




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
