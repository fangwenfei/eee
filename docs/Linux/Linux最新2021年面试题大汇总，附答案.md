# Linux最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、简单 Linux 文件系统？

**在 Linux 操作系统中，所有被操作系统管理的资源，例如网络接口卡、磁盘驱动器、打印机、输入输出设备、普通文件或是目录都被看作是一个文件。**

也就是说在 Linux 系统中有一个重要的概念：

一切都是文件。其实这是 Unix 哲学的一个体现，而 Linux 是重写 Unix 而来，所以这个概念也就传承了下来。

在 Unix 系统中，把一切资源都看作是文件，包括硬件设备。UNIX系统把每个硬件都看成是一个文件，通常称为设备文件，这样用户就可以用读写文件的方式实现对硬件的访问。

Linux 支持 5 种文件类型，如下图所示：

![55_3.png][55_3.png]


### 2、如何查看目录中的文件？区分哪些是文件哪些是目录?递归查?

ls 命令会用最基本的形式显示当前目录下的文件和目录：

```
?  local ls
Caskroom   Frameworks bin        go         lib        sbin       var
Cellar     Homebrew   etc        include    opt        share
```

可以看出默认是按照字母序展示的

一般来说，ls命令回显示不同的颜色区分不同的文件类型,如果没有安装颜色插件可以用ls -F来区分哪些是目录（目录带/)，哪些是文件（文件不带/)

ls -R 递归展示出目录下以及子目录的文件，目录越多输出越多


### 3、Linux 的体系结构

从大的方面讲，Linux 体系结构可以分为两块：

![55_2.png][55_2.png]

**用户空间(User Space) ：**用户空间又包括用户的应用程序(User Applications)、C 库(C Library) 。

**内核空间(Kernel Space) ：**内核空间又包括系统调用接口(System Call Interface)、内核(Kernel)、平台架构相关的代码(Architecture-Dependent Kernel Code) 。

**为什么 Linux 体系结构要分为用户空间和内核空间的原因？**

**1、** 现代 CPU 实现了不同的工作模式，不同模式下 CPU 可以执行的指令和访问的寄存器不同。

**2、** Linux 从 CPU 的角度出发，为了保护内核的安全，把系统分成了两部分。

用户空间和内核空间是程序执行的**两种不同的状态**，我们可以通过两种方式完成用户空间到内核空间的转移：

**1、** 系统调用

**2、** 硬件中断


### 4、重启linux

```
Linux centos 重启命令：reboot
```


### 5、lvs/nginx/haproxy优缺点

**Nginx的优点是：**

**1、** 工作在网络的7层之上，可以针对http应用做一些分流的策略，比如针对域名、目录结构

它的正则规则比HAProxy更为强大和灵活，这也是它目前广泛流行的主要原因之一

Nginx单凭这点可利用的场合就远多于LVS了。

**2、** Nginx对网络稳定性的依赖非常小，理论上能ping通就就能进行负载功能，这个也是它的优势之一

相反LVS对网络稳定性依赖比较大，这点本人深有体会；

**3、** Nginx安装和配置比较简单，测试起来比较方便，它基本能把错误用日志打印出来

LVS的配置、测试就要花比较长的时间了，LVS对网络依赖比较大。

**4、** 可以承担高负载压力且稳定，在硬件不差的情况下一般能支撑几万次的并发量，负载度比LVS相对小些。

**5、** Nginx可以通过端口检测到服务器内部的故障，比如根据服务器处理网页返回的状态码、超时等等，并且会把返回错误的请求重新提交到另一个节点，不过其中缺点就是不支持url来检测。比如用户正在上传一个文件，而处理该上传的节点刚好在上传过程中出现故障，Nginx会把上传切到另一台服务器重新处理，而LVS就直接断掉了

如果是上传一个很大的文件或者很重要的文件的话，用户可能会因此而不满。

**6、** Nginx不仅仅是一款优秀的负载均衡器/反向代理软件，它同时也是功能强大的Web应用服务器

LNMP也是近几年非常流行的web架构，在高流量的环境中稳定性也很好。

**7、** Nginx现在作为Web反向加速缓存越来越成熟了，速度比传统的Squid服务器更快，可考虑用其作为反向代理加速器

**8、** Nginx可作为中层反向代理使用，这一层面Nginx基本上无对手，唯一可以对比Nginx的就只有lighttpd了

不过lighttpd目前还没有做到Nginx完全的功能，配置也不那么清晰易读，社区资料也远远没Nginx活跃

**9、** Nginx也可作为静态网页和图片服务器，这方面的性能也无对手。还有Nginx社区非常活跃，第三方模块也很多

**Nginx的缺点是：**

**1、** Nginx仅能支持http、https和Email协议，这样就在适用范围上面小些，这个是它的缺点

**2、** 对后端服务器的健康检查，只支持通过端口来检测，不支持通过url来检测

不支持Session的直接保持，但能通过ip_hash来解决

LVS：使用Linux内核集群实现一个高性能、高可用的负载均衡服务器

它具有很好的可伸缩性（Scalability)、可靠性（Reliability)和可管理性（Manageability)

LVS的优点是：

**1、** 抗负载能力强、是工作在网络4层之上仅作分发之用，没有流量的产生

这个特点也决定了它在负载均衡软件里的性能最强的，对内存和cpu资源消耗比较低

**2、** 配置性比较低，这是一个缺点也是一个优点，因为没有可太多配置的东西

所以并不需要太多接触，大大减少了人为出错的几率

**3、** 工作稳定，因为其本身抗负载能力很强，自身有完整的双机热备方案

如LVS+Keepalived，不过我们在项目实施中用得最多的还是LVS/DR+Keepalived

**4、** 无流量，LVS只分发请求，而流量并不从它本身出去，这点保证了均衡器IO的性能不会收到大流量的影响。

**5、** 应用范围较广，因为LVS工作在4层，所以它几乎可对所有应用做负载均衡，包括http、数据库、在线聊天室等

LVS的缺点是：

**1、** 软件本身不支持正则表达式处理，不能做动静分离

而现在许多网站在这方面都有较强的需求，这个是Nginx/HAProxy+Keepalived的优势所在

**2、** 如果是网站应用比较庞大的话，LVS/DR+Keepalived实施起来就比较复杂了

特别后面有Windows Server的机器的话，如果实施及配置还有维护过程就比较复杂了相对而言，Nginx/HAProxy+Keepalived就简单多了。

**HAProxy的特点是：**

**1、** HAProxy也是支持虚拟主机的。

**2、** HAProxy的优点能够补充Nginx的一些缺点，比如支持Session的保持，Cookie的引导同时支持通过获取指定的url来检测后端服务器的状态

**3、** HAProxy跟LVS类似，本身就只是一款负载均衡软件单纯从效率上来讲HAProxy会比Nginx有更出色的负载均衡速度，在并发处理上也是优于Nginx的

**4、** HAProxy支持TCP协议的负载均衡转发，可以对MySQL读进行负载均衡对后端的MySQL节点进行检测和负载均衡，大家可以用LVS+Keepalived对MySQL主从做负载均衡

**5、** HAProxy负载均衡策略非常多，HAProxy的负载均衡算法现在具体有如下8种：

**1、** roundrobin，表示简单的轮询，这个不多说，这个是负载均衡基本都具备的；

**2、** ?static-rr，表示根据权重，建议关注；

**3、** leastconn，表示最少连接者先处理，建议关注；

**4、** source，表示根据请求源IP，这个跟Nginx的IP_hash机制类似

**5、** 们用其作为解决session问题的一种方法，建议关注；

**6、** ri，表示根据请求的URI；

**7、** rl_param，表示根据请求的URl参数’balance url_param’ requires an URL parameter name；

**8、** hdr(name)，表示根据HTTP请求头来锁定每一次HTTP请求；

**9、** rdp-cookie(name)，表示根据据cookie(name)来锁定并哈希每一次TCP请求。


### 6、打印文件第一行到第三行?

文件tomcat中内容:

```
?  apache cat tomcat
text21
text22
text23
start
stop
restart
end
```

```
? apache head -3 tomcat
text21
text22
text23
? apache sed -n '1,3p' tomcat
text21
text22
text23
? apache awk 'NR>=1&&NR<=3' tomcat
text21
text22
text23
```


### 7、你常用的Nginx模块，用来做什么

**1、** rewrite模块，实现重写功能

**2、** access模块：来源控制

**3、** ssl模块：安全加密

**4、** ngx_http_gzip_module：网络传输压缩模块

**5、** ngx_http_proxy_module 模块实现代理

**6、** ngx_http_upstream_module模块实现定义后端服务器列表

**7、** ngx_cache_purge实现缓存清除功能


### 8、MySQL的innodb如何定位锁问题，MySQL如何减少主从复制延迟？

MySQL的innodb如何定位锁问题:

在使用 show engine innodb status检查引擎状态时，发现了死锁问题

在5.5中，information_schema 库中增加了三个关于锁的表（MEMORY引擎）

innodb_trx ? ? ? ? ## 当前运行的所有事务

innodb_locks ? ? ## 当前出现的锁

innodb_lock_waits ?## 锁等待的对应关系

MySQL如何减少主从复制延迟:

**如果延迟比较大，就先确认以下几个因素：**

**1、** 从库硬件比主库差，导致复制延迟

**2、** 主从复制单线程，如果主库写并发太大，来不及传送到从库就会导致延迟。更高版本的MySQL可以支持多线程复制

**3、** 慢SQL语句过多

**4、** 网络延迟

**5、** master负载

主库读写压力大，导致复制延迟，架构的前端要加buffer及缓存层

**6、** slave负载

一般的做法是，使用多台slave来分摊读请求，再从这些slave中取一台专用的服务器

只作为备份用，不进行其他任何操作.另外， 2个可以减少延迟的参数:

–slave-net-timeout=seconds 单位为秒 默认设置为 3600秒

参数含义：当slave从主数据库读取log数据失败后，等待多久重新建立连接并获取数据

–master-connect-retry=seconds 单位为秒 默认设置为 60秒

参数含义：当重新建立主从连接时，如果连接建立失败，间隔多久后重试

通常配置以上2个参数可以减少网络问题导致的主从数据同步延迟

MySQL数据库主从同步延迟解决方案

最简单的减少slave同步延时的方案就是在架构上做优化，尽量让主库的DDL快速执行

还有就是主库是写，对数据安全性较高，比如sync_binlog=1，innodb_flush_log_at_trx_commit

= 1 之类的设置，而slave则不需要这么高的数据安全，完全可以讲sync_binlog设置为0或者关闭binlog

innodb_flushlog也可以设置为0来提高sql的执行效率。另外就是使用比主库更好的硬件设备作为slave


### 9、mv（move单词缩写，移动功能，该文件名称功能）

```
mv /opt/java/java.log /opt/MySQL/ ;移动文件到MySQL目录下
mv java.log MySQL.log ;把java.log改名为MySQL.log
```


### 10、查看文件内容有哪些命令可以使用？

**答案：**

**1、** vi 文件名 #编辑方式查看，可修改

**2、** cat 文件名 #显示全部文件内容

**3、** more 文件名 #分页显示文件内容

**4、** less 文件名 #与 more 相似，更好的是可以往前翻页

**5、** tail 文件名 #仅查看尾部，还可以指定行数

**6、** head 文件名 #仅查看头部,还可以指定行数


### 11、简述raid0 raid1 raid5 三种工作模式的工作原理及特点
### 12、在工作中，运维人员经常需要跟运营人员打交道，请问运营人员是做什么工作的？
### 13、find （find：找到的意思）查找指定文件或目录
### 14、file （可查看文件类型）
### 15、什么是链接文件？
### 16、实时监测进程
### 17、查看已有别名?建立属于自己的别名?
### 18、讲述一下LVS三种模式的工作过程？
### 19、什么是GUI？
### 20、如果一个linux新手想要知道当前系统支持的所有命令的列表，他需要怎么做？
### 21、压缩工具有哪些?
### 22、列出已经安装的包？安装软件？更新软件？卸载?
### 23、终止进程用什么命令? 带什么参数?
### 24、查看http的并发请求数与其TCP连接状态
### 25、如何写一条规则，拒绝某个ip访问本机8080端口?
### 26、如何压缩文件？如何解压文件?
### 27、查看设备还有多少磁盘空间?
### 28、查看组信息？如何创建组？删除组？
### 29、每天晚上 12 点，打包站点目录/var/www/html 备份到/data 目录下（最好每次备份按时间生成不同的备份包）




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
