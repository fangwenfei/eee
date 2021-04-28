# Nginx最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是动态资源、静态资源分离？

动态资源、静态资源分离，是让动态网站里的动态网页根据一定规则把不变的资源和经常变的资源区分开来，动静资源做好了拆分以后我们就可以根据静态资源的特点将其做缓存操作，这就是网站静态化处理的核心思路。

动态资源、静态资源分离简单的概括是：动态文件与静态文件的分离。

**为什么要做动、静分离？**

在我们的软件开发中，有些请求是需要后台处理的（如：`.jsp`,`.do` 等等），有些请求是不需要经过后台处理的（如：css、html、jpg、js 等等文件），这些不需要经过后台处理的文件称为静态文件，否则动态文件。

因此我们后台处理忽略静态文件。这会有人又说那我后台忽略静态文件不就完了吗？当然这是可以的，但是这样后台的请求次数就明显增多了。在我们对资源的响应速度有要求的时候，我们应该使用这种动静分离的策略去解决动、静分离将网站静态资源（HTML，JavaScript，CSS，img等文件）与后台应用分开部署，提高用户访问静态代码的速度，降低对后台应用访问

这里我们将静态资源放到 Nginx 中，动态资源转发到 Tomcat 服务器中去。

当然，因为现在七牛、阿里云等 CDN 服务已经很成熟，主流的做法，是把静态资源缓存到 CDN 服务中，从而提升访问速度。

**1、** 相比本地的 Nginx 来说，CDN 服务器由于在国内有更多的节点，可以实现用户的就近访问。

**2、** 并且，CDN 服务可以提供更大的带宽，不像我们自己的应用服务，提供的带宽是有限的。

**什么叫 CDN 服务？**

CDN ，即内容分发网络。

其目的是，通过在现有的 Internet中 增加一层新的网络架构，将网站的内容到最接近用户的网络边缘，使用户可就近取得所需的内容，提高用户访问网站的速度。

一般来说，因为现在 CDN 服务比较大众，所以基本所有公司都会使用 CDN 服务。


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


### 3、在Nginx中如何在URL中保留双斜线?

要在URL中保留双斜线，就必须使用merge_slashes_off；语法:merge_slashes [on/off] ； 默认值: merge_slashes on ；环境: http，server


### 4、请解释什么是`C10K`问题?

`C10K`问题是指无法同时处理大量客户端(10,000)的网络套接字。


### 5、为什么Nginx性能这么高？

因为他的事件处理机制：异步非阻塞事件处理机制：运用了epoll模型，提供了一个队列，排队解决


### 6、Nginx 如何实现后端服务的健康检查？

**1、** 利用 nginx 自带模块 ngx_http_proxy_module 和 ngx_http_upstream_module 对后端节点做健康检查。

**2、** 利用 nginx_upstream_check_module 模块对后端节点做健康检查。


### 7、Nginx怎么做的动静分离？

只需要指定路径对应的目录。location/可以使用正则表达式匹配。并指定对应的硬盘中的目录。如下：（操作都是在Linux上）

```
location /image/ {
    root   /usr/local/static/;
    autoindex on;
}
```

**1、** 创建目录

```
mkdir /usr/local/static/image
```

**2、** 进入目录

```
cd  /usr/local/static/image
```

**3、**   放一张照片上去#

```
1.jpg
```

**4、** 重启 nginx

```
sudo nginx -s reload
```

**5、** 打开浏览器 输入 server_name/image/1.jpg 就可以访问该静态图片了


### 8、解释如何在Nginx中获得当前的时间?

要获得Nginx的当前时间，必须使用SSI模块、$$date_gmt和$$date_local的变量。Proxy_set_header THE-TIME $date_gmt;


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


### 10、请解释是否有可能将 Nginx 的错误替换为 502 错误、503?

502 =错误网关

503 =服务器超载

有可能，但是您可以确保 fastcgi_intercept_errors 被设置为 ON，并使用错

误页面指令。

Location / {fastcgi_pass 127.0.01:9001;fastcgi_intercept_errors

on;error_page 502 =503/error_page.html;#…}


### 11、列举Nginx服务器的最佳用途。
### 12、请解释`ngx_http_upstream_module`的作用是什么?
### 13、Nginx如何处理HTTP请求？
### 14、url_hash(第三方插件)
### 15、解释`Nginx`是否支持将请求压缩到上游?
### 16、突发限制访问频率（突发流量）
### 17、请列举 Nginx 服务器的最佳用途。Nginx 服务器的最佳用法是在网络上部署动态 HTTP 内容，使用 SCGI、WSGI 应
### 18、请陈述 stub_status 和 sub_filter 指令的作用是什么?
### 19、什么是C10K问题?
### 20、轮询(默认)
### 21、Nginx服务器上的Master和Worker进程分别是什么?
### 22、location的语法能说出来吗？
### 23、Nginx虚拟主机怎么配置?
### 24、Nginx 常用命令？
### 25、fastcgi 与 cgi 的区别？
### 26、什么是正向代理和反向代理？
### 27、Nginx目录结构有哪些？
### 28、权重 weight
### 29、用 Nginx 服务器解释-s 的目的是什么?
### 30、location的作用是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
