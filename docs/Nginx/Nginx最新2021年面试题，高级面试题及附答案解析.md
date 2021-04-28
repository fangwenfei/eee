# Nginx最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Nginx 有哪些优点？

**1、** 跨平台、配置简单。

**2、** 非阻塞、高并发连接

**3、** 处理 2-3 万并发连接数，官方监测能支持 5 万并发。

**4、** 内存消耗小

**5、** 开启 10 个 Nginx 才占 150M 内存。

**6、** 成本低廉，且开源。

**7、** 稳定性高，宕机的概率非常小。


### 2、Rewrite全局变量是什么？
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


### 3、解释如何在`Nginx`服务器上添加模块?

在编译过程中，必须选择`Nginx`模块，因为`Nginx`不支持模块的运行时间选择。


### 4、Nginx负载均衡的算法怎么实现的?策略有哪些?

为了避免服务器崩溃，大家会通过负载均衡的方式来分担服务器压力。将对台服务器组成一个集群，当用户访问时，先访问到一个转发服务器，再由转发服务器将访问分发到压力更小的服务器。

Nginx负载均衡实现的策略有以下五种：


### 5、用`Nginx`服务器解释`-s`的目的是什么?

用于运行`Nginx -s`参数的可执行文件。


### 6、请解释一下什么是 Nginx?

Nginx 是一个 web 服务器和反向代理服务器，用于 HTTP、HTTPS、SMTP、POP3

和 IMAP 协议。


### 7、在Nginx中，如何使用未定义的服务器名称来阻止处理请求?

只需将请求删除的服务器就可以定义为：

![](https://www.wkcto.com/static/uploads/index/article/20200610/1591778954@ef97ed18ea668a9954060c09abeb46c4.png#alt=)

这里，服务器名被保留为一个空字符串，它将在没有“主机”头字段的情况下匹配请求，而一个特殊的Nginx的非标准代码444被返回，从而终止连接。


### 8、如何用Nginx解决前端跨域问题？

使用Nginx转发请求。把跨域的接口写成调本域的接口，然后将这些接口转发到真正的请求地址。


### 9、ip_hash( IP绑定)

每个请求按访问IP的哈希结果分配，使来自同一个IP的访客固定访问一台后端服务器，`并且可以有效解决动态网页存在的session共享问题`

```
upstream backserver {
 ip_hash;
 server 192.168.0.12:88; 
 server 192.168.0.13:80; 
}
```


### 10、Location正则案例

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


### 11、Nginx 如何开启压缩？
### 12、为什么不使用多线程？
### 13、Nginx 有哪些负载均衡策略？
### 14、漏桶流算法和令牌桶算法知道，漏桶算法#
### 15、正常限制访问频率（正常流量）
### 16、解释如何在 Nginx 服务器上添加模块?
### 17、Nginx应用场景？
### 18、nginx和apache的区别？
### 19、ngx_http_upstream_module的作用是什么?
### 20、使用“反向代理服务器的优点是什么?
### 21、使用“反向代理服务器”的优点是什么?
### 22、Nginx怎么判断别IP不可访问？
### 23、nginx是如何实现高并发的？
### 24、用Nginx服务器解释-s的目的是什么?
### 25、使用“反向代理服务器”的优点是什么?
### 26、为什么要做动、静分离？
### 27、Nginx 是如何实现高并发的？
### 28、在 Nginx 中，如何使用未定义的服务器名称来阻止处理请求?
### 29、请列举 Nginx 的一些特性。
### 30、限制并发连接数




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
