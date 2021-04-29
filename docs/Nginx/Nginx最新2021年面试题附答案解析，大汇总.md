# Nginx最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、nginx是如何实现高并发的？

一个主进程，多个工作进程，每个工作进程可以处理多个请求，每进来一个request，会有一个worker进程去处理。但不是全程的处理，处理到可能发生阻塞的地方，比如向上游（后端）服务器转发request，并等待请求返回。那么，这个处理的worker继续处理其他请求，而一旦上游服务器返回了，就会触发这个事件，worker才会来接手，这个request才会接着往下走。由于web server的工作性质决定了每个request的大部份生命都是在网络传输中，实际上花费在server机器上的时间片不多。这是几个进程就解决高并发的秘密所在。即@skoo所说的webserver刚好属于网络io密集型应用，不算是计算密集型。


### 2、nignx配置

```
worker_processes  8;     工作进程个数

worker_connections  65535;  每个工作进程能并发处理（发起）的最大连接数（包含所有连接数）

error_log         /data/logs/nginx/error.log;  错误日志打印地址

access_log      /data/logs/nginx/access.log  进入日志打印地址

log_format  main  'remote_addr"request" ''status upstream_addr "$request_time"'; 进入日志格式

fastcgi_connect_timeout=300; #连接到后端fastcgi超时时间

fastcgi_send_timeout=300; #向fastcgi请求超时时间(这个指定值已经完成两次握手后向fastcgi传送请求的超时时间)

fastcgi_rend_timeout=300; #接收fastcgi应答超时时间，同理也是2次握手后

fastcgi_buffer_size=64k; #读取fastcgi应答第一部分需要多大缓冲区，该值表示使用1个64kb的缓冲区读取应答第一部分(应答头),可以设置为fastcgi_buffers选项缓冲区大小

fastcgi_buffers 4 64k;#指定本地需要多少和多大的缓冲区来缓冲fastcgi应答请求，假设一个php或java脚本所产生页面大小为256kb,那么会为其分配4个64kb的缓冲来缓存

fastcgi_cache TEST;#开启fastcgi缓存并为其指定为TEST名称，降低cpu负载,防止502错误发生

listen       80;                                            监听端口

server_name  rrc.test.jiedaibao.com;       允许域名

root  /data/release/rrc/web;                    项目根目录

index  index.php index.html index.htm;  访问根文件
```


### 3、请解释 Nginx 如何处理 HTTP 请求。

Nginx 使用反应器模式。主事件循环等待操作系统发出准备事件的信号，这样数据就可以从套接字读取，在该实例中读取到缓冲区并进行处理。单个线程可以提供数万个并发连接。


### 4、Nginx静态资源?

静态资源访问，就是存放在nginx的html页面，我们可以自己编写


### 5、解释`Nginx`是否支持将请求压缩到上游?

您可以使用`Nginx`模块`gunzip`将请求压缩到上游。`gunzip`模块是一个过滤器，它可以对不支持“gzip”编码方法的客户机或服务器使用“内容编码:gzip”来解压缩响应。

解释如何在`Nginx`中获得当前的时间?

要获得Nginx的当前时间，必须使用`SSI`模块、`$date_gmt`和`$date_local`的变量。

`Proxy_set_header` `THE-TIME $date_gmt`;


### 6、fair(第三方插件)

必须安装upstream_fair模块。

对比 weight、ip_hash更加智能的负载均衡算法，fair算法可以根据页面大小和加载时间长短智能地进行负载均衡，响应时间短的优先分配。

```
upstream backserver {
 server server1; 
 server server2; 
 fair; 
}
```

哪个服务器的响应速度快，就将请求分配到那个服务器上。


### 7、解释如何在Nginx中获得当前的时间?

要获得Nginx的当前时间，必须使用SSI模块、$$date_gmt和$$date_local的变量。Proxy_set_header THE-TIME $date_gmt;


### 8、使用“反向代理服务器”的优点是什么?

反向代理服务器可以隐藏源服务器的存在和特征。它充当互联网云和web服务器之间的中间层。这对于安全方面来说是很好的，特别是当您使用web托管服务时。


### 9、请解释什么是`C10K`问题?

`C10K`问题是指无法同时处理大量客户端(10,000)的网络套接字。


### 10、解释如何在 Nginx 中获得当前的时间?

要获得 Nginx 的当前时间，必须使用 SSI 模块、$$date_gmt 和$$date_local 的变

量。

Proxy_set_header THE-TIME $date_gmt;


### 11、Location正则案例
### 12、如何通过不同于80的端口开启Nginx?
### 13、在Nginx中，如何使用未定义的服务器名称来阻止处理请求?
### 14、Nginx 如何开启压缩？
### 15、请陈述stub_status和sub_filter指令的作用是什么?
### 16、请列举 Nginx 的一些特性。
### 17、如何用Nginx解决前端跨域问题？
### 18、基于虚拟主机配置域名
### 19、Nginx配置高可用性怎么配置？
### 20、用`Nginx`服务器解释`-s`的目的是什么?
### 21、Nginx 有哪些优点？
### 22、用 Nginx 服务器解释-s 的目的是什么?
### 23、Nginx 常用配置？
### 24、限流怎么做的？
### 25、location的语法能说出来吗？
### 26、为什么要做动、静分离？
### 27、请解释 Nginx 如何处理 HTTP 请求？
### 28、突发限制访问频率（突发流量）
### 29、Nginx目录结构有哪些？
### 30、在 Nginx 中，解释如何在 URL 中保留双斜线?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
