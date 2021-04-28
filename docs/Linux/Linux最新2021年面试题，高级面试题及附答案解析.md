# Linux最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、awk 详解。

**答案：**

```
awk '{pattern + action}' {filenames}
#cat /etc/passwd |awk -F ':' '{print 1"\t"7}' //-F 的意思是以':'分隔 root /bin/bash
daemon /bin/sh 搜索/etc/passwd 有 root 关键字的所有行

#awk -F: '/root/' /etc/passwd root:x:0:0:root:/root:/bin/bash
```


### 2、cd （change directory：英文释义是改变目录）切换目录

```
cd ../ ;跳到上级目录
cd /opt ;不管现在到那直接跳到指定的opt文件夹中
cd ~ ;切换当前用户的家目录。root用户的家目录就是root目录。
```


### 3、lvs/nginx/haproxy优缺点

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


### 4、目录创建用什么命令？创建文件用什么命令？复制文件用什么命令？

**答案：**

**1、** 创建目录： mkdir

**2、** 创建文件：典型的如 touch，vi 也可以创建文件，其实只要向一个不存在的文件输出，都会创建文件

**3、** 复制文件： cp 7、文件权限修改用什么命令？格式是怎么样的？

**4、** 文件权限修改： chmod

**格式如下：**

**1、** chmodu+xfile给file的属主增加执行权限 chmod 751 file 给 file 的属主分配读、写、执行(7)的权限，给 file 的所在组分配读、执行(5)的权限，给其他用户分配执行(1)的权限

**2、** chmodu=rwx,g=rx,o=xfile上例的另一种形式 chmod =r file 为所有用户分配读权限

**3、** chmod444file同上例 chmod a-wx,a+r file同上例

**4、** $ chmod -R u+r directory 递归地给 directory 目录下所有文件和子目录的属主分配读的权限


### 5、mv（move单词缩写，移动功能，该文件名称功能）

```
mv /opt/java/java.log /opt/MySQL/ ;移动文件到MySQL目录下
mv java.log MySQL.log ;把java.log改名为MySQL.log
```


### 6、mkdir （mkdir：创建目录） 创建目录

```
mkdir 文件夹名称 ;在此目录创建文件夹
mkdir /opt/java/jdk ;在指定目录创建文件夹
```


### 7、Ls 命令执行什么功能？ 可以带哪些参数，有什么区别？

**答案：**

**1、** ls 执行的功能： 列出指定目录中的目录，以及文件

**2、** 哪些参数以及区别： a 所有文件l 详细信息，包括大小字节数，可读可写可执行的权限等


### 8、修改权限?

chmod options mode file

比如给文件附加可以执行权限:

```
[root@xiaoka ~]# chmod +x filename
```


### 9、Linux 有哪些系统日志文件？

比较重要的是 `/var/log/messages` 日志文件。

该日志文件是许多进程日志文件的汇总，从该文件可以看出任何入侵企图或成功的入侵。

> 另外，如果胖友的系统里有 ELK 日志集中收集，它也会被收集进去。



### 10、file （可查看文件类型）

```
file 文件名
```


### 11、more （more：更多的意思）分页查看文件命令（不能快速定位到最后一页）
### 12、如何规划一台 Linux 主机，步骤是怎样？
### 13、free 命令 （显示系统内存）
### 14、如果一个linux新手想要知道当前系统支持的所有命令的列表，他需要怎么做？
### 15、ps （process status：进程状态，类似于windows的任务管理器）
### 16、终止进程用什么命令? 带什么参数?
### 17、你常用的Nginx模块，用来做什么
### 18、查找命令的可执行文件是去哪查找的? 怎么对其进行设置及添加?
### 19、如何查看当前主机名？如何修改？如何重启后生效？
### 20、简单 Linux 文件系统？
### 21、怎么对命令进行取别名？
### 22、BASH和DOS之间的基本区别是什么？
### 23、查看文件内容有哪些命令可以使用？
### 24、查找匹配数据？反向搜？
### 25、列出已经安装的包？安装软件？更新软件？卸载?
### 26、Linux 的体系结构
### 27、重启linux
### 28、请列出你了解的web服务器负载架构
### 29、实时抓取并显示当前系统中tcp 80端口的网络数据信息，请写出完整操作命令




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
