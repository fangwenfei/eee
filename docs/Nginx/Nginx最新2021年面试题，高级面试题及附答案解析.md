# Nginx最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Nginx应用场景？

**1、** http服务器。Nginx是一个http服务可以独立提供http服务。可以做网页静态服务器。

**2、** 虚拟主机。可以实现在一台服务器虚拟出多个网站，例如个人网站使用的虚拟机。

**3、** 反向代理，负载均衡。当网站的访问量达到一定程度后，单台服务器不能满足用户的请求时，需要用多台服务器集群可以使用nginx做反向代理。并且多台服务器可以平均分担负载，不会应为某台服务器负载高宕机而某台服务器闲置的情况。

**4、** nginz 中也可以配置安全管理、比如可以使用Nginx搭建API接口网关,对每个接口服务进行拦截。


### 2、什么是正向代理和反向代理？

**1、** 正向代理就是一个人发送一个请求直接就到达了目标的服务器

**2、** 反方代理就是请求统一被Nginx接收，nginx反向代理服务器接收到之后，按照一定的规 则分发给了后端的业务处理服务器进行处理了


### 3、ngx_http_upstream_module的作用是什么?

ngx_http_upstream_module用于定义可通过fastcgi传递、proxy传递、uwsgi传递、Memcached传递和scgi传递指令来引用的服务器组。


### 4、Location正则案例

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


### 5、Nginx怎么判断别IP不可访问？

```
# 如果访问的ip地址为192.168.9.115,则返回403
if  ($remote_addr = 192.168.9.115) {
     return 403;
}
```


### 6、请列举 Nginx 的一些特性。

Nginx 服务器的特性包括：

**1、** 反向代理/L7 负载均衡器

**2、** 嵌入式 Perl 解释器

**3、** 动态二进制升级

**4、** 可用于重新编写 URL，具有非常好的 PCRE 支持


### 7、Nginx目录结构有哪些？

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


### 8、权重 weight

weight的值越大分配

到的访问概率越高，主要用于后端每台服务器性能不均衡的情况下。其次是为在主从的情况下设置不同的权值，达到合理有效的地利用主机资源。

```
upstream backserver {
 server 192.168.0.12 weight=2;
 server 192.168.0.13 weight=8;
}
```

权重越高，在被访问的概率越大，如上例，分别是20%，80%。


### 9、请列举Nginx的一些特性？

Nginx服务器的特性包括：反向代理/L7负载均衡器 ；嵌入式Perl解释器 ；动态二进制升级；可用于重新编写URL，具有非常好的PCRE支持。


### 10、请解释一下什么是 Nginx?

Nginx 是一个 web 服务器和反向代理服务器，用于 HTTP、HTTPS、SMTP、POP3

和 IMAP 协议。


### 11、Nginx怎么处理请求的？
### 12、用 Nginx 服务器解释-s 的目的是什么?
### 13、请列举 Nginx 服务器的最佳用途。Nginx 服务器的最佳用法是在网络上部署动态 HTTP 内容，使用 SCGI、WSGI 应
### 14、请解释什么是`C10K`问题?
### 15、请解释是否有可能将 Nginx 的错误替换为 502 错误、503?
### 16、fastcgi 与 cgi 的区别？
### 17、nginx是如何实现高并发的？
### 18、Nginx 常用配置？
### 19、为什么要用Nginx？
### 20、nginx和apache的区别？
### 21、解释 Nginx 是否支持将请求压缩到上游?
### 22、解释如何在 Nginx 中获得当前的时间?
### 23、使用“反向代理服务器的优点是什么?
### 24、为什么要做动、静分离？
### 25、请解释 Nginx 服务器上的 Master 和 Worker 进程分别是什么?
### 26、什么是C10K问题?
### 27、请解释 Nginx 如何处理 HTTP 请求？
### 28、在 Nginx 中，如何使用未定义的服务器名称来阻止处理请求?
### 29、为什么不使用多线程？
### 30、location的作用是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
