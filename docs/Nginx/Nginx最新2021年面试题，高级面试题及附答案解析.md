# Nginx最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、在 Nginx 中，解释如何在 URL 中保留双斜线?

要在 URL 中保留双斜线，就必须使用 merge_slashes_off;

语法:merge_slashes [on/off]

默认值: merge_slashes on

环境: http，server


### 2、Location正则案例

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


### 3、Nginx 有哪些负载均衡策略？

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


### 4、ngx_http_upstream_module的作用是什么?

ngx_http_upstream_module用于定义可通过fastcgi传递、proxy传递、uwsgi传递、Memcached传递和scgi传递指令来引用的服务器组。


### 5、如何通过不同于80的端口开启Nginx?

为了通过一个不同的端口开启Nginx，你必须进/etc/Nginx/sites-enabled/，如果这是默认文件，那么必须打开名为“default”的文件。编辑文件，并放置在你想要的端口：

![](https://www.wkcto.com/static/uploads/index/article/20200610/1591779001@f3c2283e33bd1f26deab4c50144691af.png#alt=)


### 6、解释如何在 Nginx 服务器上添加模块?

在编译过程中，必须选择 Nginx 模块，因为 Nginx 不支持模块的运行时间选

择。



### 7、nginx和apache的区别？

 轻量级，同样起web 服务，比apache 占用更少的内存及资源；抗并发，nginx处理请求是异步非阻塞的，而apache 则是阻塞型的，在高并发下nginx 能保持低资源低消耗高性能；高度模块化的设计，编写模块相对简单；最核心的区别在于apache是同步多进程模型，一个连接对应一个进程；nginx是异步的，多个连接（万级别）可以对应一个进程。


### 8、为什么不使用多线程？

Nginx:采用单线程来异步非阻塞处理请求（管理员可以配置Nginx主进程的工作进程的数量），不会为每个请求分配cpu和内存资源，节省了大量资源，同时也减少了大量的CPU的上下文切换，所以才使得Nginx支持更高的并发。


### 9、Nginx静态资源?

静态资源访问，就是存放在nginx的html页面，我们可以自己编写


### 10、请解释什么是`C10K`问题?

`C10K`问题是指无法同时处理大量客户端(10,000)的网络套接字。


### 11、nignx配置
### 12、使用“反向代理服务器”的优点是什么?
### 13、解释如何在Nginx中获得当前的时间?
### 14、解释 Nginx 是否支持将请求压缩到上游?
### 15、Nginx 如何实现后端服务的健康检查？
### 16、location的作用是什么？
### 17、在Nginx中，如何使用未定义的服务器名称来阻止处理请求?
### 18、解释如何在 Nginx 中获得当前的时间?
### 19、Nginx是否支持将请求压缩到上游?
### 20、怎么限制浏览器访问？
### 21、fastcgi 与 cgi 的区别？
### 22、url_hash(第三方插件)
### 23、Rewrite全局变量是什么？
### 24、在Nginx中如何在URL中保留双斜线?
### 25、Nginx 常用配置？
### 26、使用“反向代理服务器”的优点是什么?
### 27、请陈述stub_status和sub_filter指令的作用是什么?
### 28、请解释是否有可能将 Nginx 的错误替换为 502 错误、503?
### 29、令牌桶算法#
### 30、ip_hash( IP绑定)




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
