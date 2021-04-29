# Nginx最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、nginx状态码

499：服务端处理时间过长，客户端主动关闭了连接。


### 2、基于端口的虚拟主机

使用端口来区分，浏览器使用域名或ip地址:端口号 访问

```
#当客户端访问
www.lijie.com, 监听端口号为8080, 直接跳转到data / www目录下文件
server {
    listen 8080;
    server_name 8080.lijie.com;
    location / {
        root data / www;
        index index.html index.htm;
    }
}#当客户端访问
www.lijie.com, 监听端口号为80直接跳转到真实 ip服务器地址 127.0.0.1: 8080
server {
    listen 80;
    server_name www.lijie.com;
    location / {
        proxy_pass http: //127.0.0.1:8080;
        index index.html index.htm;
    }
}
```


### 3、解释 Nginx 是否支持将请求压缩到上游?

您可以使用 Nginx 模块 gunzip 将请求压缩到上游。gunzip 模块是一个过滤

器，它可以对不支持“gzip”编码方法的客户机或服务器使用“内容编

码:gzip”来解压缩响应。


### 4、请解释一下什么是 Nginx?

Nginx 是一个 web 服务器和反向代理服务器，用于 HTTP、HTTPS、SMTP、POP3

和 IMAP 协议。


### 5、使用“反向代理服务器”的优点是什么?

反向代理服务器可以隐藏源服务器的存在和特征。它充当互联网云和 web 服务

器之间的中间层。这对于安全方面来说是很好的，特别是当您使用 web 托管服

务时。


### 6、url_hash(第三方插件)

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


### 7、nginx和apache的区别？

 轻量级，同样起web 服务，比apache 占用更少的内存及资源；抗并发，nginx处理请求是异步非阻塞的，而apache 则是阻塞型的，在高并发下nginx 能保持低资源低消耗高性能；高度模块化的设计，编写模块相对简单；最核心的区别在于apache是同步多进程模型，一个连接对应一个进程；nginx是异步的，多个连接（万级别）可以对应一个进程。


### 8、为什么要做动静分离？

**1、** Nginx是当下最热的Web容器，网站优化的重要点在于静态化网站，网站静态化的关键点则是是动静分离，动静分离是让动态网站里的动态网页根据一定规则把不变的资源和经常变的资源区分开来，动静资源做好了拆分以后，我们则根据静态资源的特点将其做缓存操作。

**2、** 让静态的资源只走静态资源服务器，动态的走动态的服务器

**3、** Nginx的静态处理能力很强，但是动态处理能力不足，因此，在企业中常用动静分离技术。

**4、** 对于静态资源比如图片，js，css等文件，我们则在反向代理服务器nginx中进行缓存。这样浏览器在请求一个静态资源时，代理服务器nginx就可以直接处理，无需将请求转发给后端服务器tomcat。

**5、** 若用户请求的动态文件，比如servlet,jsp则转发给Tomcat服务器处理，从而实现动静分离。这也是反向代理服务器的一个重要的作用。


### 9、502错误可能原因

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


### 10、解释如何在 Nginx 服务器上添加模块?

在编译过程中，必须选择 Nginx 模块，因为 Nginx 不支持模块的运行时间选

择。



### 11、Nginx虚拟主机怎么配置?
### 12、使用“反向代理服务器的优点是什么?
### 13、请解释你如何通过不同于 80 的端口开启 Nginx?
### 14、Nginx怎么判断别IP不可访问？
### 15、请解释 ngx_http_upstream_module 的作用是什么?
### 16、Nginx如何处理HTTP请求？
### 17、Nginx 有哪些负载均衡策略？
### 18、用Nginx服务器解释-s的目的是什么?
### 19、请陈述 stub_status 和 sub_filter 指令的作用是什么?
### 20、令牌桶算法#
### 21、漏桶流算法和令牌桶算法知道，漏桶算法#
### 22、Nginx服务器上的Master和Worker进程分别是什么?
### 23、Nginx 常用命令？
### 24、怎么限制浏览器访问？
### 25、ip_hash( IP绑定)
### 26、Nginx是否支持将请求压缩到上游?
### 27、权重 weight
### 28、Nginx应用场景？
### 29、请解释是否有可能将 Nginx 的错误替换为 502 错误、503?
### 30、请列举Nginx的一些特性？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
