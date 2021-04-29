# Nginx最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Nginx配置高可用性怎么配置？

当上游服务器(真实访问服务器)，一旦出现故障或者是没有及时相应的话，应该直接轮训到下一台服务器，保证服务器的高可用

Nginx配置代码：

```
server {
    listen 80;
    server_name www.lijie.com;cc  nginx发送给上游服务器(真实访问的服务器)超时时间
        proxy_send_timeout 1s;###
        nginx接受上游服务器(真实访问的服务器)超时时间
        proxy_read_timeout 1s;
        index index.html index.htm;
    }
}
```


### 2、Nginx 常用命令？

**1、** 启动 `nginx` 。

**2、** 停止 `nginx -s stop` 或 `nginx -s quit` 。

**3、** 重载配置 `./sbin/nginx -s reload(平滑重启)` 或 `service nginx reload` 。

**4、** 重载指定配置文件 `.nginx -c /usr/local/nginx/conf/nginx.conf` 。

**5、** 查看 nginx 版本 `nginx -v` 。

**6、** 检查配置文件是否正确 `nginx -t` 。

**7、** 显示帮助信息 `nginx -h` 。


### 3、解释如何在Nginx服务器上添加模块?

在编译过程中，必须选择Nginx模块，因为Nginx不支持模块的运行时间选择。


### 4、使用“反向代理服务器”的优点是什么？

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


### 5、Nginx静态资源?

静态资源访问，就是存放在nginx的html页面，我们可以自己编写


### 6、nginx是如何实现高并发的？

一个主进程，多个工作进程，每个工作进程可以处理多个请求，每进来一个request，会有一个worker进程去处理。但不是全程的处理，处理到可能发生阻塞的地方，比如向上游（后端）服务器转发request，并等待请求返回。那么，这个处理的worker继续处理其他请求，而一旦上游服务器返回了，就会触发这个事件，worker才会来接手，这个request才会接着往下走。由于web server的工作性质决定了每个request的大部份生命都是在网络传输中，实际上花费在server机器上的时间片不多。这是几个进程就解决高并发的秘密所在。即@skoo所说的webserver刚好属于网络io密集型应用，不算是计算密集型。


### 7、请列举Nginx的一些特性？

Nginx服务器的特性包括：反向代理/L7负载均衡器 ；嵌入式Perl解释器 ；动态二进制升级；可用于重新编写URL，具有非常好的PCRE支持。


### 8、在Nginx中如何在URL中保留双斜线?

要在URL中保留双斜线，就必须使用merge_slashes_off；语法:merge_slashes [on/off] ； 默认值: merge_slashes on ；环境: http，server


### 9、url_hash(第三方插件)

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


### 10、location的语法能说出来吗？

注意：~ 代表自己输入的英文字母

| 匹配符 | 匹配规则 | 优先级 |
| --- | --- | --- |
| = | 精确匹配 | 1 |
| ^~ | 以某个字符串开头 | 2 |
| ~ | 区分大小写的正则匹配 | 3 |
| ~ | 不区分大小写的正则匹配 | 4 |
| !~ | 区分大小写不匹配的正则 | 5 |
| !~ | 不区分大小写不匹配的正则 | 6 |
| / | 通用匹配，任何请求都会匹配到 | 7 |



### 11、ngx_http_upstream_module的作用是什么?
### 12、为什么要做动、静分离？
### 13、Nginx服务器上的Master和Worker进程分别是什么?
### 14、为什么 Nginx 不使用多线程？
### 15、Nginx虚拟主机怎么配置?
### 16、怎么限制浏览器访问？
### 17、基于端口的虚拟主机
### 18、用Nginx服务器解释-s的目的是什么?
### 19、解释`Nginx`是否支持将请求压缩到上游?
### 20、Nginx 有哪些负载均衡策略？
### 21、基于虚拟主机配置域名
### 22、为什么要做动静分离？
### 23、Nginx负载均衡的算法怎么实现的?策略有哪些?
### 24、用`Nginx`服务器解释`-s`的目的是什么?
### 25、Nginx应用场景？
### 26、Rewrite全局变量是什么？
### 27、什么是正向代理和反向代理？
### 28、解释 Nginx 是否支持将请求压缩到上游?
### 29、fastcgi 与 cgi 的区别？
### 30、请解释一下什么是 Nginx?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
