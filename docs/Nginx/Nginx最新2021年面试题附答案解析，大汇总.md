# Nginx最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、请陈述stub_status和sub_filter指令的作用是什么?

（1）Stub_status指令：该指令用于了解Nginx当前状态的当前状态，如当前的活动连接，接受和处理当前读/写/等待连接的总数 ；（2）Sub_filter指令：它用于搜索和替换响应中的内容，并快速修复陈旧的数据


### 2、location的作用是什么？

location指令的作用是根据用户请求的URI来执行不同的应用，也就是根据用户请求的网站URL进行匹配，匹配成功即进行相关的操作。


### 3、Location正则案例

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


### 4、在 Nginx 中，解释如何在 URL 中保留双斜线?

要在 URL 中保留双斜线，就必须使用 merge_slashes_off;

语法:merge_slashes [on/off]

默认值: merge_slashes on

环境: http，server


### 5、请解释 Nginx 如何处理 HTTP 请求？

**1、** 首先，Nginx 在启动时，会解析配置文件，得到需要监听的端口与 IP 地址，然后在 Nginx 的 Master 进程里面先初始化好这个监控的Socket(创建 S ocket，设置 addr、reuse 等选项，绑定到指定的 ip 地址端口，再 listen 监听)。

**2、** 然后，再 fork(一个现有进程可以调用 fork 函数创建一个新进程。由 fork 创建的新进程被称为子进程 )出多个子进程出来。

**3、** 之后，子进程会竞争 accept 新的连接。此时，客户端就可以向 nginx 发起连接了。当客户端与nginx进行三次握手，与 nginx 建立好一个连接后。此时，某一个子进程会 accept 成功，得到这个建立好的连接的 Socket ，然后创建 nginx 对连接的封装，即 ngx_connection_t 结构体。

**4、** 接着，设置读写事件处理函数，并添加读写事件来与客户端进行数据的交换。


### 6、ngx_http_upstream_module的作用是什么?

ngx_http_upstream_module用于定义可通过fastcgi传递、proxy传递、uwsgi传递、Memcached传递和scgi传递指令来引用的服务器组。


### 7、Nginx虚拟主机怎么配置?

**1、** 基于域名的虚拟主机，通过域名来区分虚拟主机——应用：外部网站

**2、** 基于端口的虚拟主机，通过端口来区分虚拟主机——应用：公司内部网站，外部网站的管理后台

**3、** 基于ip的虚拟主机。


### 8、解释`Nginx`是否支持将请求压缩到上游?
### 9、列举Nginx服务器的最佳用途。
### 10、请陈述 stub_status 和 sub_filter 指令的作用是什么?
### 11、使用“反向代理服务器”的优点是什么?
### 12、使用“反向代理服务器的优点是什么?
### 13、Nginx 有哪些优点？
### 14、请解释是否有可能将 Nginx 的错误替换为 502 错误、503?
### 15、Nginx的优缺点？
### 16、突发限制访问频率（突发流量）
### 17、轮询(默认)
### 18、用Nginx服务器解释-s的目的是什么?
### 19、请解释一下什么是 Nginx?
### 20、fair(第三方插件)
### 21、请解释 Nginx 服务器上的 Master 和 Worker 进程分别是什么?
### 22、请解释 ngx_http_upstream_module 的作用是什么?
### 23、请列举 Nginx 服务器的最佳用途。Nginx 服务器的最佳用法是在网络上部署动态 HTTP 内容，使用 SCGI、WSGI 应
### 24、请解释你如何通过不同于 80 的端口开启 Nginx?
### 25、权重 weight
### 26、Nginx怎么做的动静分离？
### 27、解释 Nginx 是否支持将请求压缩到上游?
### 28、location的语法能说出来吗？
### 29、怎么限制浏览器访问？
### 30、用 Nginx 服务器解释-s 的目的是什么?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
