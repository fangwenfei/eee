# Nginx最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、在Nginx中，如何使用未定义的服务器名称来阻止处理请求?

只需将请求删除的服务器就可以定义为：

![](https://www.wkcto.com/static/uploads/index/article/20200610/1591778954@ef97ed18ea668a9954060c09abeb46c4.png#alt=)

这里，服务器名被保留为一个空字符串，它将在没有“主机”头字段的情况下匹配请求，而一个特殊的Nginx的非标准代码444被返回，从而终止连接。


### 2、Nginx负载均衡的算法怎么实现的?策略有哪些?

为了避免服务器崩溃，大家会通过负载均衡的方式来分担服务器压力。将对台服务器组成一个集群，当用户访问时，先访问到一个转发服务器，再由转发服务器将访问分发到压力更小的服务器。

Nginx负载均衡实现的策略有以下五种：


### 3、请陈述 stub_status 和 sub_filter 指令的作用是什么?

Stub_status 指令：该指令用于了解 Nginx 当前状态的当前状态，如当前的活

动连接，接受和处理当前读/写/等待连接的总数

Sub_filter 指令：它用于搜索和替换响应中的内容，并快速修复陈旧的数据


### 4、基于端口的虚拟主机

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


### 5、Nginx怎么做的动静分离？

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


### 6、Nginx虚拟主机怎么配置?

**1、** 基于域名的虚拟主机，通过域名来区分虚拟主机——应用：外部网站

**2、** 基于端口的虚拟主机，通过端口来区分虚拟主机——应用：公司内部网站，外部网站的管理后台

**3、** 基于ip的虚拟主机。


### 7、Nginx的优缺点？

**优点：**

**1、**  占内存小，可实现高并发连接，处理响应快

**2、**  可实现http服务器、虚拟主机、方向代理、负载均衡

**3、**  Nginx配置简单

**4、**  可以不暴露正式的服务器IP地址

**缺点：**

动态处理差，nginx处理静态文件好,耗费内存少，但是处理动态页面则很鸡肋，现在一般前端用nginx作为反向代理抗住压力，


### 8、令牌桶算法#

令牌桶算法是网络流量整形和速率限制中最常使用的一种算法。典型情况下，令牌桶算法用来控制发送到网络上的数据的数目，并允许突发数据的发送。Google开源项目Guava中的RateLimiter使用的就是令牌桶控制算法。**令牌桶算法的机制如下：存在一个大小固定的令牌桶，会以恒定的速率源源不断产生令牌。如果令牌消耗速率小于生产令牌的速度，令牌就会一直产生直至装满整个令牌桶。**

![56_2.png][56_2.png]


### 9、为什么要做动静分离？

**1、** Nginx是当下最热的Web容器，网站优化的重要点在于静态化网站，网站静态化的关键点则是是动静分离，动静分离是让动态网站里的动态网页根据一定规则把不变的资源和经常变的资源区分开来，动静资源做好了拆分以后，我们则根据静态资源的特点将其做缓存操作。

**2、** 让静态的资源只走静态资源服务器，动态的走动态的服务器

**3、** Nginx的静态处理能力很强，但是动态处理能力不足，因此，在企业中常用动静分离技术。

**4、** 对于静态资源比如图片，js，css等文件，我们则在反向代理服务器nginx中进行缓存。这样浏览器在请求一个静态资源时，代理服务器nginx就可以直接处理，无需将请求转发给后端服务器tomcat。

**5、** 若用户请求的动态文件，比如servlet,jsp则转发给Tomcat服务器处理，从而实现动静分离。这也是反向代理服务器的一个重要的作用。


### 10、请解释你如何通过不同于 80 的端口开启 Nginx?

为了通过一个不同的端口开启 Nginx，你必须进入/etc/Nginx/sites

enabled/，如果这是默认文件，那么你必须打开名为“default”的文件。编辑

文件，并放置在你想要的端口：

Like server { listen 81; }


### 11、Rewrite全局变量是什么？
### 12、轮询(默认)
### 13、502错误可能原因
### 14、基于虚拟主机配置域名
### 15、解释`Nginx`是否支持将请求压缩到上游?
### 16、请解释 ngx_http_upstream_module 的作用是什么?
### 17、解释如何在Nginx中获得当前的时间?
### 18、使用“反向代理服务器”的优点是什么？
### 19、在 Nginx 中，解释如何在 URL 中保留双斜线?
### 20、请陈述stub_status和sub_filter指令的作用是什么?
### 21、使用“反向代理服务器”的优点是什么?
### 22、解释如何在 Nginx 服务器上添加模块?
### 23、用Nginx服务器解释-s的目的是什么?
### 24、限制并发连接数
### 25、Nginx静态资源?
### 26、漏桶流算法和令牌桶算法知道，漏桶算法#
### 27、限流怎么做的？
### 28、Nginx 如何实现后端服务的健康检查？
### 29、列举Nginx服务器的最佳用途。
### 30、location的语法能说出来吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
