# Nginx最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、在 Nginx 中，如何使用未定义的服务器名称来阻止处理请求?

只需将请求删除的服务器就可以定义为：

Server {listen 80;server_name “ “ ;return 444;

}

这里，服务器名被保留为一个空字符串，它将在没有“主机”头字段的情况下

匹配请求，而一个特殊的 Nginx 的非标准代码 444 被返回，从而终止连接。


### 2、为什么Nginx性能这么高？

因为他的事件处理机制：异步非阻塞事件处理机制：运用了epoll模型，提供了一个队列，排队解决


### 3、什么是正向代理和反向代理？

**1、** 正向代理就是一个人发送一个请求直接就到达了目标的服务器

**2、** 反方代理就是请求统一被Nginx接收，nginx反向代理服务器接收到之后，按照一定的规 则分发给了后端的业务处理服务器进行处理了


### 4、Rewrite全局变量是什么？
| 变量 | 含义 |
| --- | --- |
| $args | 这个变量等于请求行中的参数，同$query_string |
| $content length | 请求头中的Content-length字段。 |
| $content_type | 请求头中的Content-Type字段。 |
| $document_root | 当前请求在root指令中指定的值。 |
| $host | 请求主机头字段，否则为服务器名称。 |
| $http_user_agent | 客户端agent信息 |
| $http_cookie | 客户端cookie信息 |
| $limit_rate | 这个变量可以限制连接速率。 |
| $request_method | 客户端请求的动作，通常为GET或POST。 |
| $remote_addr | 客户端的IP地址。 |
| $remote_port | 客户端的端口。 |
| $remote_user | 已经经过Auth Basic Module验证的用户名。 |
| $request_filename | 当前请求的文件路径，由root或alias指令与URI请求生成。 |
| $scheme | HTTP方法（如http，https）。 |
| $server_protocol | 请求使用的协议，通常是HTTP/1.0或HTTP/1.1。 |
| $server_addr | 服务器地址，在完成一次系统调用后可以确定这个值。 |
| $server_name | 服务器名称。 |
| $server_port | 请求到达服务器的端口号。 |
| $request_uri | 包含请求参数的原始URI，不包含主机名，如”/foo/bar.php?arg=baz”。 |
| $uri | 不带请求参数的当前URI，$uri不包含主机名，如”/foo/bar.html”。 |
| $document_uri | 与$uri相同。 |


### 5、请解释 Nginx 服务器上的 Master 和 Worker 进程分别是什么?

Master 进程：读取及评估配置和维持

Worker 进程：处理请求


### 6、为什么要用Nginx？

**1、** 跨平台、配置简单、方向代理、高并发连接：处理2-3万并发连接数，官方监测能支持5万并发，内存消耗小：开启10个nginx才占150M内存 ，nginx处理静态文件好，耗费内存少，

**2、** 而且Nginx内置的健康检查功能：如果有一个服务器宕机，会做一个健康检查，再发送的请求就不会发送到宕机的服务器了。重新将请求提交到其他的节点上。

使用Nginx的话还能：

**1、** 节省宽带：支持GZIP压缩，可以添加浏览器本地缓存

**2、** 稳定性高：宕机的概率非常小

**3、** 接收用户请求是异步的


### 7、Nginx 有哪些负载均衡策略？

负载均衡，即是代理服务器将接收的请求均衡的分发到各服务器中。

Nginx 默认提供了 3 种负载均衡策略：

**轮询（默认）round_robin**

每个请求按时间顺序逐一分配到不同的后端服务器，如果后端服务器 down 掉，能自动剔除。

**IP 哈希 ip_hash**

每个请求按访问 ip 的 hash 结果分配，这样每个访客固定访问一个后端服务器，可以解决 session 共享的问题。

当然，实际场景下，一般不考虑使用 ip_hash 解决 session 共享。

**最少连接 least_conn**

下一个请求将被分派到活动连接数量最少的服务器

通过 Nginx 插件，我们还可以引入 fair、url_hash 等负载均衡策略。

另外，我们还可以配置每一个后端节点在负载均衡时的其它配置：

```
weight=1; # (weight 默认为1.weight越大，负载的权重就越大)
down; # (down 表示单前的server暂时不参与负载)
backup; # (其它所有的非backup机器down或者忙的时候，请求backup机器)
max_fails=1; # 允许请求失败的次数默认为 1 。当超过最大次数时，返回 proxy_next_upstream 模块定义的错误
fail_timeout=30; # max_fails 次失败后，暂停的时间
```


### 8、Nginx 如何开启压缩？

开启nginx gzip压缩后，网页、css、js等静态资源的大小会大大的减少，从而可以节约大量的带宽，提高传输效率，给用户快的体验。虽然会消耗cpu资源，但是为了给用户更好的体验是值得的。

**开启的配置如下：**

将以上配置放到nginx.conf的http{ … }节点中。保存并重启nginx，刷新页面（为了避免缓存，请强制刷新）就能看到效果了。以谷歌浏览器为例，通过F12看请求的响应头部

gzip压缩前后效果对比：jquery原大小90kb，压缩后只有30kb。

gzip虽然好用，但是一下类型的资源不建议启用。

**图片类型**

原因：图片如jpg、png本身就会有压缩，所以就算开启gzip后，压缩前和压缩后大小没有多大区别，所以开启了反而会白白的浪费资源。（Tips：可以试试将一张jpg图片压缩为zip，观察大小并没有多大的变化。虽然zip和gzip算法不一样，但是可以看出压缩图片的价值并不大）

**大文件**

原因：会消耗大量的cpu资源，且不一定有明显的效果。


### 9、用 Nginx 服务器解释-s 的目的是什么?

用于运行 Nginx -s 参数的可执行文件。


### 10、解释如何在Nginx服务器上添加模块?

在编译过程中，必须选择Nginx模块，因为Nginx不支持模块的运行时间选择。


### 11、Nginx配置高可用性怎么配置？
### 12、location的语法能说出来吗？
### 13、列举Nginx服务器的最佳用途。
### 14、限流怎么做的？
### 15、基于虚拟主机配置域名
### 16、为什么不使用多线程？
### 17、在Nginx中，如何使用未定义的服务器名称来阻止处理请求?
### 18、令牌桶算法#
### 19、请解释 ngx_http_upstream_module 的作用是什么?
### 20、在Nginx中如何在URL中保留双斜线?
### 21、使用“反向代理服务器”的优点是什么？
### 22、为什么要做动、静分离？
### 23、Nginx 常用配置？
### 24、Nginx目录结构有哪些？
### 25、使用“反向代理服务器的优点是什么?
### 26、解释 Nginx 是否支持将请求压缩到上游?
### 27、Nginx是否支持将请求压缩到上游?
### 28、用`Nginx`服务器解释`-s`的目的是什么?
### 29、使用“反向代理服务器”的优点是什么?
### 30、解释如何在 Nginx 服务器上添加模块?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
