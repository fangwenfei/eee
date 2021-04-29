# Nginx最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Nginx负载均衡的算法怎么实现的?策略有哪些?

为了避免服务器崩溃，大家会通过负载均衡的方式来分担服务器压力。将对台服务器组成一个集群，当用户访问时，先访问到一个转发服务器，再由转发服务器将访问分发到压力更小的服务器。

Nginx负载均衡实现的策略有以下五种：


### 2、Nginx 如何实现后端服务的健康检查？

**1、** 利用 nginx 自带模块 ngx_http_proxy_module 和 ngx_http_upstream_module 对后端节点做健康检查。

**2、** 利用 nginx_upstream_check_module 模块对后端节点做健康检查。


### 3、为什么要用Nginx？

**1、** 跨平台、配置简单、方向代理、高并发连接：处理2-3万并发连接数，官方监测能支持5万并发，内存消耗小：开启10个nginx才占150M内存 ，nginx处理静态文件好，耗费内存少，

**2、** 而且Nginx内置的健康检查功能：如果有一个服务器宕机，会做一个健康检查，再发送的请求就不会发送到宕机的服务器了。重新将请求提交到其他的节点上。

使用Nginx的话还能：

**1、** 节省宽带：支持GZIP压缩，可以添加浏览器本地缓存

**2、** 稳定性高：宕机的概率非常小

**3、** 接收用户请求是异步的


### 4、在 Nginx 中，如何使用未定义的服务器名称来阻止处理请求?

只需将请求删除的服务器就可以定义为：

Server {listen 80;server_name “ “ ;return 444;

}

这里，服务器名被保留为一个空字符串，它将在没有“主机”头字段的情况下

匹配请求，而一个特殊的 Nginx 的非标准代码 444 被返回，从而终止连接。


### 5、什么是C10K问题?

C10K问题是指无法同时处理大量客户端(10,000)的网络套接字。


### 6、Nginx怎么处理请求的？

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


### 7、正常限制访问频率（正常流量）

**1、** 限制一个用户发送的请求，我Nginx多久接收一个请求。

**2、** Nginx中使用ngx_http_limit_req_module模块来限制的访问频率，限制的原理实质是基于漏桶算法原理来实现的。在nginx.conf配置文件中可以使用limit_req_zone命令及limit_req命令限制单个IP的请求处理频率。

```
#定义限流维度，一个用户一分钟一个请求进来，多余的全部漏掉
limit_req_zone $binary_remote_addr zone = one: 10m rate = 1r / m;#绑定限流维度
server {
    location / seckill.html {
        limit_req zone = zone;
        proxy_pass http: //lj_seckill;
    }
}
```

1r/s代表1秒一个请求，1r/m一分钟接收一个请求， 如果Nginx这时还有别人的请求没有处理完，Nginx就会拒绝处理该用户请求。


### 8、ngx_http_upstream_module的作用是什么?

ngx_http_upstream_module用于定义可通过fastcgi传递、proxy传递、uwsgi传递、Memcached传递和scgi传递指令来引用的服务器组。


### 9、为什么不使用多线程？

Nginx:采用单线程来异步非阻塞处理请求（管理员可以配置Nginx主进程的工作进程的数量），不会为每个请求分配cpu和内存资源，节省了大量资源，同时也减少了大量的CPU的上下文切换，所以才使得Nginx支持更高的并发。


### 10、使用“反向代理服务器”的优点是什么？

反向代理服务器可以隐藏源服务器的存在和特征。它充当互联网云和 Web 服务器之间的中间层。这对于安全方面来说是很好的，特别是当我们使用 Web 托管服务时。

**这里，先不考虑负载均衡。**

**什么是正向代理？**

一个位于客户端和原始服务器(origin server)之间的服务器，为了从原始服务器取得内容，客户端向代理发送一个请求并指定目标(原始服务器)，然后代理向原始服务器转交请求并将获得的内容返回给客户端。

**1、** 客户端才能使用正向代理。

**2、** 正向代理总结就一句话：代理端代理的是客户端。例如说：? 我们使用的翻墙软件，OpenVPN 等等。

**什么是反向代理？**

反向代理（Reverse Proxy）方式，是指以代理服务器来接受 Internet上的连接请求，然后将请求，发给内部网络上的服务器并将从服务器上得到的结果返回给 Internet 上请求连接的客户端，此时代理服务器对外就表现为一个反向代理服务器。

**反向代理总结就一句话：代理端代理的是服务端。**

**请列举 Nginx 和 Apache 之间的不同点？**

**1、** 轻量级，同样起 web 服务，Nginx 比 Apache 占用更少的内存及资源。

**2、** 抗并发，Nginx 处理请求是异步非阻塞的，而 Apache 则是阻塞型的，在高并发下 Nginx 能保持低资源低消耗高性能。

**3、** 最核心的区别在于 Apache 是同步多进程模型，一个连接对应一个进程；Nginx 是异步的，多个连接（万级别）可以对应一个进程。

**4、** Nginx 高度模块化的设计，编写模块相对简单。

**LVS、Nginx、HAproxy 有什么区别？**

**1、** LVS ：是基于四层的转发。

**2、** HAproxy ： 是基于四层和七层的转发，是专业的代理服务器。

**3、** Nginx ：是 WEB 服务器，缓存服务器，又是反向代理服务器，可以做七层的转发。

Nginx 引入 [TCP 插件][TCP]之后，也可以支持四层的转发。

**区别**

LVS 由于是基于四层的转发所以只能做端口的转发，而基于 URL 的、基于目录的这种转发 LVS 就做不了。

**工作选择：**

HAproxy 和 Nginx 由于可以做七层的转发，所以 URL 和目录的转发都可以做，在很大并发量的时候我们就要选择 LVS ，像中小型公司的话并发量没那么大选择 HAproxy 或者 Nginx 足已。

由于 HAproxy 由是专业的代理服务器配置简单，所以中小型企业推荐使用HAproxy 。

**1、** 有些使用，使用 HAproxy 还是 Nginx ，也和公司运维对哪个技术栈的掌控程度。掌控 OK ，选择 Nginx 会更加不错。

**2、** 另外，LVS + Nginx 和 LVS + HAProxy 也是比较常见的选型组合。

**Squid、Varinsh、Nginx 有什么区别？**

三者都实现缓存服务器的作用。所以，本问题所有的视角，都是在作为缓存服务器下来聊。

**1、** Nginx本来是反向代理/web服务器，用了插件可以做做这个副业(缓存服务器)。

**2、** 但是本身不支持特性挺多，只能缓存静态文件。

**3、** 从这些功能上，Varinsh 和 Squid 是专业的 Cache 服务，而Nginx 这些是第三方模块完成。

**4、** Varnish 本身的技术上优势要高于 Squid ，它采用了可视化页面缓存技术。

**5、** 在内存的利用上，Varnis h比 Squid 具有优势，性能要比 Squid 高。

**6、** 还有强大的通过 Varnish 管理端口，可以使用正则表达式快速、批量地清除部分缓存

**7、** Varnish 是内存缓存，速度一流，但是内存缓存也限制了其容量，缓存页面和图片一般是挺好的。

**8、** Squid 的优势在于完整的庞大的 cache 技术资料，和很多的应用生产环境。

**工作选择：**

要做 cache 服务的话，我们肯定是要选择专业的 cache 服务，优先选择Squid 或者 Varnish 。


### 11、Nginx怎么做的动静分离？
### 12、什么是动态资源、静态资源分离？
### 13、什么是正向代理和反向代理？
### 14、为什么 Nginx 不使用多线程？
### 15、Nginx 是如何实现高并发的？
### 16、Nginx的优缺点？
### 17、列举Nginx服务器的最佳用途。
### 18、Rewrite全局变量是什么？
### 19、解释如何在Nginx服务器上添加模块?
### 20、限制并发连接数
### 21、location的作用是什么？
### 22、为什么Nginx性能这么高？
### 23、轮询(默认)
### 24、请解释 Nginx 服务器上的 Master 和 Worker 进程分别是什么?
### 25、请列举 Nginx 服务器的最佳用途。Nginx 服务器的最佳用法是在网络上部署动态 HTTP 内容，使用 SCGI、WSGI 应
### 26、请解释`ngx_http_upstream_module`的作用是什么?
### 27、Nginx配置文件nginx.conf有哪些属性模块?
### 28、解释如何在`Nginx`服务器上添加模块?
### 29、在Nginx中如何在URL中保留双斜线?
### 30、fastcgi 与 cgi 的区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
