# Nginx最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、nginx状态码

499：服务端处理时间过长，客户端主动关闭了连接。


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


### 4、解释 Nginx 是否支持将请求压缩到上游?

您可以使用 Nginx 模块 gunzip 将请求压缩到上游。gunzip 模块是一个过滤

器，它可以对不支持“gzip”编码方法的客户机或服务器使用“内容编

码:gzip”来解压缩响应。


### 5、请陈述stub_status和sub_filter指令的作用是什么?

（1）Stub_status指令：该指令用于了解Nginx当前状态的当前状态，如当前的活动连接，接受和处理当前读/写/等待连接的总数 ；（2）Sub_filter指令：它用于搜索和替换响应中的内容，并快速修复陈旧的数据


### 6、请列举Nginx的一些特性？

Nginx服务器的特性包括：反向代理/L7负载均衡器 ；嵌入式Perl解释器 ；动态二进制升级；可用于重新编写URL，具有非常好的PCRE支持。


### 7、为什么要做动静分离？

**1、** Nginx是当下最热的Web容器，网站优化的重要点在于静态化网站，网站静态化的关键点则是是动静分离，动静分离是让动态网站里的动态网页根据一定规则把不变的资源和经常变的资源区分开来，动静资源做好了拆分以后，我们则根据静态资源的特点将其做缓存操作。

**2、** 让静态的资源只走静态资源服务器，动态的走动态的服务器

**3、** Nginx的静态处理能力很强，但是动态处理能力不足，因此，在企业中常用动静分离技术。

**4、** 对于静态资源比如图片，js，css等文件，我们则在反向代理服务器nginx中进行缓存。这样浏览器在请求一个静态资源时，代理服务器nginx就可以直接处理，无需将请求转发给后端服务器tomcat。

**5、** 若用户请求的动态文件，比如servlet,jsp则转发给Tomcat服务器处理，从而实现动静分离。这也是反向代理服务器的一个重要的作用。


### 8、Nginx的优缺点？

**优点：**

**1、**  占内存小，可实现高并发连接，处理响应快

**2、**  可实现http服务器、虚拟主机、方向代理、负载均衡

**3、**  Nginx配置简单

**4、**  可以不暴露正式的服务器IP地址

**缺点：**

动态处理差，nginx处理静态文件好,耗费内存少，但是处理动态页面则很鸡肋，现在一般前端用nginx作为反向代理抗住压力，


### 9、Nginx配置文件nginx.conf有哪些属性模块?

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


### 10、Nginx静态资源?

静态资源访问，就是存放在nginx的html页面，我们可以自己编写


### 11、为什么要用Nginx？
### 12、fair(第三方插件)
### 13、如何通过不同于80的端口开启Nginx?
### 14、解释如何在Nginx服务器上添加模块?
### 15、基于虚拟主机配置域名
### 16、在 Nginx 中，解释如何在 URL 中保留双斜线?
### 17、Nginx怎么处理请求的？
### 18、Nginx是否支持将请求压缩到上游?
### 19、请解释 ngx_http_upstream_module 的作用是什么?
### 20、使用“反向代理服务器”的优点是什么？
### 21、解释如何在 Nginx 中获得当前的时间?
### 22、令牌桶算法#
### 23、为什么 Nginx 不使用多线程？
### 24、限流怎么做的？
### 25、怎么限制浏览器访问？
### 26、Nginx配置高可用性怎么配置？
### 27、请解释 Nginx 如何处理 HTTP 请求。
### 28、Nginx 常用配置？
### 29、请解释你如何通过不同于 80 的端口开启 Nginx?
### 30、请解释 Nginx 如何处理 HTTP 请求？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
