# Nginx最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Nginx服务器上的Master和Worker进程分别是什么?

Master进程：读取及评估配置和维持 ；Worker进程：处理请求。


### 2、ip_hash( IP绑定)

每个请求按访问IP的哈希结果分配，使来自同一个IP的访客固定访问一台后端服务器，`并且可以有效解决动态网页存在的session共享问题`

```
upstream backserver {
 ip_hash;
 server 192.168.0.12:88; 
 server 192.168.0.13:80; 
}
```


### 3、Nginx 常用命令？

**1、** 启动 `nginx` 。

**2、** 停止 `nginx -s stop` 或 `nginx -s quit` 。

**3、** 重载配置 `./sbin/nginx -s reload(平滑重启)` 或 `service nginx reload` 。

**4、** 重载指定配置文件 `.nginx -c /usr/local/nginx/conf/nginx.conf` 。

**5、** 查看 nginx 版本 `nginx -v` 。

**6、** 检查配置文件是否正确 `nginx -t` 。

**7、** 显示帮助信息 `nginx -h` 。


### 4、fair(第三方插件)

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


### 5、url_hash(第三方插件)

必须安装Nginx的hash软件包

按访问url的hash结果来分配请求，使每个url定向到同一个后端服务器，可以进一步提高后端缓存服务器的效率。

```
upstream backserver {
 server squid1:3128; 
 server squid2:3128; 
 hash $request_uri; 
 hash_method crc32; 
}
```


### 6、使用“反向代理服务器”的优点是什么?

反向代理服务器可以隐藏源服务器的存在和特征。它充当互联网云和web服务器之间的中间层。这对于安全方面来说是很好的，特别是当您使用web托管服务时。


### 7、怎么限制浏览器访问？

```
## 不允许谷歌浏览器访问 如果是谷歌浏览器返回500
 if ($http_user_agent ~ Chrome) {
    return 500;
}
```


### 8、解释如何在`Nginx`服务器上添加模块?

在编译过程中，必须选择`Nginx`模块，因为`Nginx`不支持模块的运行时间选择。


### 9、Nginx 有哪些优点？

**1、** 跨平台、配置简单。

**2、** 非阻塞、高并发连接

**3、** 处理 2-3 万并发连接数，官方监测能支持 5 万并发。

**4、** 内存消耗小

**5、** 开启 10 个 Nginx 才占 150M 内存。

**6、** 成本低廉，且开源。

**7、** 稳定性高，宕机的概率非常小。


### 10、Nginx 是如何实现高并发的？

如果一个 server 采用一个进程(或者线程)负责一个request的方式，那么进程数就是并发数。那么显而易见的，就是会有很多进程在等待中。等什么？最多的应该是等待网络传输。其缺点胖友应该也感觉到了，此处不述。

**思考下，Java 的 NIO 和 BIO 的对比哟。**

而 Nginx 的异步非阻塞工作方式正是利用了这点等待的时间。在需要等待的时候，这些进程就空闲出来待命了。因此表现为少数几个进程就解决了大量的并发问题。

Nginx是如何利用的呢，简单来说：同样的 4 个进程，如果采用一个进程负责一个 request 的方式，那么，同时进来 4 个 request 之后，每个进程就负责其中一个，直至会话关闭。期间，如果有第 5 个request进来了。就无法及时反应了，因为 4 个进程都没干完活呢，因此，一般有个调度进程，每当新进来了一个 request ，就新开个进程来处理。

**回想下，BIO 是不是存在酱紫的问题？嘻嘻。**

Nginx 不这样，每进来一个 request ，会有一个 worker 进程去处理。但不是全程的处理，处理到什么程度呢？处理到可能发生阻塞的地方，比如向上游（后端）服务器转发 request ，并等待请求返回。那么，这个处理的 worker 不会这么傻等着，他会在发送完请求后，注册一个事件：“如果 upstream 返回了，告诉我一声，我再接着干”。于是他就休息去了。此时，如果再有 request 进来，他就可以很快再按这种方式处理。而一旦上游服务器返回了，就会触发这个事件，worker 才会来接手，这个 request 才会接着往下走。

**这就是为什么说，Nginx 基于事件模型。**

由于 web server 的工作性质决定了每个 request 的大部份生命都是在网络传输中，实际上花费在 server 机器上的时间片不多。这是几个进程就解决高并发的秘密所在。即：

**webserver 刚好属于网络 IO 密集型应用，不算是计算密集型。**

而正如叔度所说的

**异步，非阻塞，使用 epoll ，和大量细节处的优化**

也正是 Nginx 之所以然的技术基石。


### 11、为什么Nginx性能这么高？
### 12、用`Nginx`服务器解释`-s`的目的是什么?
### 13、为什么 Nginx 不使用多线程？
### 14、Nginx 有哪些负载均衡策略？
### 15、什么是动态资源、静态资源分离？
### 16、Nginx配置文件nginx.conf有哪些属性模块?
### 17、解释如何在Nginx服务器上添加模块?
### 18、nginx状态码
### 19、在Nginx中如何在URL中保留双斜线?
### 20、nignx配置
### 21、正常限制访问频率（正常流量）
### 22、如何通过不同于80的端口开启Nginx?
### 23、请解释 Nginx 如何处理 HTTP 请求。
### 24、Nginx如何处理HTTP请求？
### 25、Nginx是否支持将请求压缩到上游?
### 26、Nginx配置高可用性怎么配置？
### 27、Nginx 如何开启压缩？
### 28、请解释`ngx_http_upstream_module`的作用是什么?
### 29、突发限制访问频率（突发流量）
### 30、如何用Nginx解决前端跨域问题？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
