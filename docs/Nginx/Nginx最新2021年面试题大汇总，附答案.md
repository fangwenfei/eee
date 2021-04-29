# Nginx最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Nginx服务器上的Master和Worker进程分别是什么?

Master进程：读取及评估配置和维持 ；Worker进程：处理请求。


### 2、为什么要做动、静分离？

在我们的软件开发中，有些请求是需要后台处理的（如：.jsp,.do等等），有些请求是不需要经过后台处理的（如：css、html、jpg、js等等），这些不需要经过后台处理的文件称为静态文件，否则动态文件。因此我们后台处理忽略静态文件，但是如果直接忽略静态文件的话，后台的请求次数就明显增多了。在我们对资源的响应速度有要求的时候，应该使用这种动静分离的策略去解决动、静分离将网站静态资源（HTML，JavaScript，CSS等）与后台应用分开部署，提高用户访问静态代码的速度，降低对后台应用访问。这里将静态资源放到nginx中，动态资源转发到[tomcat](https://www.wkcto.com/courses/tomcat.html)服务器中,毕竟Tomcat的优势是处理动态请求。



### 3、请解释`ngx_http_upstream_module`的作用是什么?

`ngx_http_upstream_module`用于定义可通过`fastcgi`传递、`proxy`传递、`uwsgi`传递、`Memcached`传递和scgi传递指令来引用的服务器组。


### 4、如何用Nginx解决前端跨域问题？

使用Nginx转发请求。把跨域的接口写成调本域的接口，然后将这些接口转发到真正的请求地址。


### 5、请列举 Nginx 的一些特性。

Nginx 服务器的特性包括：

**1、** 反向代理/L7 负载均衡器

**2、** 嵌入式 Perl 解释器

**3、** 动态二进制升级

**4、** 可用于重新编写 URL，具有非常好的 PCRE 支持


### 6、解释如何在Nginx服务器上添加模块?

在编译过程中，必须选择Nginx模块，因为Nginx不支持模块的运行时间选择。


### 7、令牌桶算法#

令牌桶算法是网络流量整形和速率限制中最常使用的一种算法。典型情况下，令牌桶算法用来控制发送到网络上的数据的数目，并允许突发数据的发送。Google开源项目Guava中的RateLimiter使用的就是令牌桶控制算法。**令牌桶算法的机制如下：存在一个大小固定的令牌桶，会以恒定的速率源源不断产生令牌。如果令牌消耗速率小于生产令牌的速度，令牌就会一直产生直至装满整个令牌桶。**

![56_2.png][56_2.png]


### 8、Nginx 如何实现后端服务的健康检查？
### 9、在 Nginx 中，如何使用未定义的服务器名称来阻止处理请求?
### 10、解释如何在 Nginx 中获得当前的时间?
### 11、Nginx 常用配置？
### 12、Nginx配置高可用性怎么配置？
### 13、在Nginx中如何在URL中保留双斜线?
### 14、基于端口的虚拟主机
### 15、解释如何在`Nginx`服务器上添加模块?
### 16、nignx配置
### 17、Nginx配置文件nginx.conf有哪些属性模块?
### 18、Nginx应用场景？
### 19、nginx状态码
### 20、请解释 Nginx 如何处理 HTTP 请求。
### 21、什么是动态资源、静态资源分离？
### 22、为什么要做动静分离？
### 23、使用“反向代理服务器”的优点是什么？
### 24、Nginx怎么判断别IP不可访问？
### 25、为什么 Nginx 不使用多线程？
### 26、502错误可能原因
### 27、基于虚拟主机配置域名
### 28、Nginx 常用命令？
### 29、限制并发连接数
### 30、请解释什么是`C10K`问题?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
