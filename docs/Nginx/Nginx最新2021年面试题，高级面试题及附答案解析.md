# Nginx最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、请解释`ngx_http_upstream_module`的作用是什么?

`ngx_http_upstream_module`用于定义可通过`fastcgi`传递、`proxy`传递、`uwsgi`传递、`Memcached`传递和scgi传递指令来引用的服务器组。


### 2、nignx配置

```
worker_processes  8;     工作进程个数

worker_connections  65535;  每个工作进程能并发处理（发起）的最大连接数（包含所有连接数）

error_log         /data/logs/nginx/error.log;  错误日志打印地址

access_log      /data/logs/nginx/access.log  进入日志打印地址

log_format  main  'remote_addr"request" ''status upstream_addr "$request_time"'; 进入日志格式

fastcgi_connect_timeout=300; #连接到后端fastcgi超时时间

fastcgi_send_timeout=300; #向fastcgi请求超时时间(这个指定值已经完成两次握手后向fastcgi传送请求的超时时间)

fastcgi_rend_timeout=300; #接收fastcgi应答超时时间，同理也是2次握手后

fastcgi_buffer_size=64k; #读取fastcgi应答第一部分需要多大缓冲区，该值表示使用1个64kb的缓冲区读取应答第一部分(应答头),可以设置为fastcgi_buffers选项缓冲区大小

fastcgi_buffers 4 64k;#指定本地需要多少和多大的缓冲区来缓冲fastcgi应答请求，假设一个php或java脚本所产生页面大小为256kb,那么会为其分配4个64kb的缓冲来缓存

fastcgi_cache TEST;#开启fastcgi缓存并为其指定为TEST名称，降低cpu负载,防止502错误发生

listen       80;                                            监听端口

server_name  rrc.test.jiedaibao.com;       允许域名

root  /data/release/rrc/web;                    项目根目录

index  index.php index.html index.htm;  访问根文件
```


### 3、请解释 Nginx 服务器上的 Master 和 Worker 进程分别是什么?

Master 进程：读取及评估配置和维持

Worker 进程：处理请求


### 4、在 Nginx 中，如何使用未定义的服务器名称来阻止处理请求?

只需将请求删除的服务器就可以定义为：

Server {listen 80;server_name “ “ ;return 444;

}

这里，服务器名被保留为一个空字符串，它将在没有“主机”头字段的情况下

匹配请求，而一个特殊的 Nginx 的非标准代码 444 被返回，从而终止连接。


### 5、请解释你如何通过不同于 80 的端口开启 Nginx?

为了通过一个不同的端口开启 Nginx，你必须进入/etc/Nginx/sites

enabled/，如果这是默认文件，那么你必须打开名为“default”的文件。编辑

文件，并放置在你想要的端口：

Like server { listen 81; }


### 6、Nginx配置文件nginx.conf有哪些属性模块?

```
worker_processes 1；# worker进程的数量
events {#事件区块开始
    worker_connections 1024；#每个 worker进程支持的最大连接数
}

#事件区块结束

http {#
    HTTP区块开始
    include mime.types；# Nginx支持的媒体类型库文件
    default_type application / octet - stream；#默认的媒体类型
    sendfile on；#开启高效传输模式
    keepalive_timeout 65；#连接超时
    server {

        #第一个
        Server区块开始，表示一个独立的虚拟主机站点
        listen 80；#提供服务的端口，默认 80
        server_name localhost；#提供服务的域名主机名
        location / {
             #第一个
            location区块开始
            root html；#站点的根目录，相当于 Nginx的安装目录
            index index.html index.htm；#默认的首页文件，多个用空格分开
        }

        #第一个
        location区块结果
        error_page 500502503504 / 50x.html；#出现对应的 http状态码时，使用 50x.html回应客户
        location = /50x.html {
              # location区块开始，访问50x.html
            root   html；                                  # 指定对应的站点目录为html
        }
    }
......
```


### 7、使用“反向代理服务器的优点是什么?

反向代理服务器可以隐藏源服务器的存在和特征。它充当互联网云和web服务器之间的中间层。这对于安全方面来说是很好的，特别是当您使用web托管服务时。


### 8、请陈述 stub_status 和 sub_filter 指令的作用是什么?

Stub_status 指令：该指令用于了解 Nginx 当前状态的当前状态，如当前的活

动连接，接受和处理当前读/写/等待连接的总数

Sub_filter 指令：它用于搜索和替换响应中的内容，并快速修复陈旧的数据


### 9、请解释是否有可能将 Nginx 的错误替换为 502 错误、503?

502 =错误网关

503 =服务器超载

有可能，但是您可以确保 fastcgi_intercept_errors 被设置为 ON，并使用错

误页面指令。

Location / {fastcgi_pass 127.0.01:9001;fastcgi_intercept_errors

on;error_page 502 =503/error_page.html;#…}


### 10、正常限制访问频率（正常流量）

**1、** 限制一个用户发送的请求，我Nginx多久接收一个请求。

**2、** Nginx中使用ngx_http_limit_req_module模块来限制的访问频率，限制的原理实质是基于漏桶算法原理来实现的。在nginx.conf配置文件中可以使用limit_req_zone命令及limit_req命令限制单个IP的请求处理频率。

```
#定义限流维度，一个用户一分钟一个请求进来，多余的全部漏掉
limit_req_zone $binary_remote_addr zone = one: 10m rate = 1r / m;#绑定限流维度
server {
    location / seckill.html {
        limit_req zone = zone;
        proxy_pass http: //lj_seckill;
    }
}
```

1r/s代表1秒一个请求，1r/m一分钟接收一个请求， 如果Nginx这时还有别人的请求没有处理完，Nginx就会拒绝处理该用户请求。


### 11、轮询(默认)
### 12、在 Nginx 中，解释如何在 URL 中保留双斜线?
### 13、Nginx 是如何实现高并发的？
### 14、fair(第三方插件)
### 15、请陈述stub_status和sub_filter指令的作用是什么?
### 16、令牌桶算法#
### 17、Nginx目录结构有哪些？
### 18、什么是C10K问题?
### 19、Nginx 有哪些优点？
### 20、限制并发连接数
### 21、nginx状态码
### 22、nginx和apache的区别？
### 23、502错误可能原因
### 24、location的作用是什么？
### 25、什么是动态资源、静态资源分离？
### 26、在Nginx中，如何使用未定义的服务器名称来阻止处理请求?
### 27、列举Nginx服务器的最佳用途。
### 28、解释如何在 Nginx 中获得当前的时间?
### 29、ip_hash( IP绑定)
### 30、为什么不使用多线程？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
