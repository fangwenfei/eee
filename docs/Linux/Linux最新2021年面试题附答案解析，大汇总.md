# Linux最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、你常用的Nginx模块，用来做什么

**1、** rewrite模块，实现重写功能

**2、** access模块：来源控制

**3、** ssl模块：安全加密

**4、** ngx_http_gzip_module：网络传输压缩模块

**5、** ngx_http_proxy_module 模块实现代理

**6、** ngx_http_upstream_module模块实现定义后端服务器列表

**7、** ngx_cache_purge实现缓存清除功能


### 2、查看某端口是否被占用?

netstat -ntulp|grep 8080

```
[root@iz2ze76ybn73dvwmdij06zz ~]# netstat -ntulp|grep 8080
tcp        0      0 0.0.0.0:8080            0.0.0.0:*               LISTEN      4517/java
```

参数说明:

**1、** -t (tcp) 仅显示tcp相关选项

**2、** -u (udp)仅显示udp相关选项

**3、** -n 拒绝显示别名，能显示数字的全部转化为数字

**4、** -l 仅列出在Listen(监听)的服务状态

**5、** -p 显示建立相关链接的程序名


### 3、用tcpdump嗅探80端口的访问看看谁最高

```
tcpdump -i eth0 -tnn dst port 80 -c 1000 | awk -F"." '{print $1"."$2"."$3"."$4}'| sort | uniq -c | sort -nr |head -20
```


### 4、什么是Linux

Linux是一套免费使用和自由传播的类似Unix操作系统，一般的WEB项目都是部署都是放在Linux操作系统上面。 Linux是一个基于POSIX和Unix的多用户、多任务、支持多线程和多CPU的操作系统。它能运行主要的Unix工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳定的多用户网络操作系统。


### 5、什么是中间件？什么是jdk？

中间件介绍：

中间件是一种独立的系统软件或服务程序，分布式应用软件借助这种软件在不同的技术之间共享资源

中间件位于客户机/ 服务器的操作系统之上，管理计算机资源和网络通讯

是连接两个独立应用程序或独立系统的软件。相连接的系统，即使它们具有不同的接口

但通过中间件相互之间仍能交换信息。执行中间件的一个关键途径是信息传递

通过中间件，应用程序可以工作于多平台或OS环境。

jdk：jdk是Java的开发工具包

它是一种用于构建在 Java 平台上发布的应用程序、applet 和组件的开发环境


### 6、ls （ls：list的缩写，查看列表）查看当前目录下的所有文件夹（ls 只列出文件名或目录名）

```
ls -a ;显示所有文件夹,隐藏文件也显示出来
ls -R ;连同子目录一起列出来
```


### 7、RAID 是什么?

RAID 全称为独立磁盘冗余阵列(Redundant Array of Independent Disks)，基本思想就是把多个相对便宜的硬盘组合起来，成为一个硬盘阵列组，使性能达到甚至超过一个价格昂贵、 容量巨大的硬盘。RAID 通常被用在服务器电脑上，使用完全相同的硬盘组成一个逻辑扇区，因此操作系统只会把它当做一个硬盘。

RAID 分为不同的等级，各个不同的等级均在数据可靠性及读写性能上做了不同的权衡。在实际应用中，可以依据自己的实际需求选择不同的 RAID 方案。

当然，因为很多公司都使用云服务，大家很难接触到 RAID 这个概念，更多的可能是普通云盘、SSD 云盘酱紫的概念。


### 8、怎么清屏？怎么退出当前命令？怎么执行睡眠？怎么查看当前用户 id？查看指定帮助用什么命令？

**答案：**

**1、** 清屏： clear

**2、** 退出当前命令： ctrl+c 彻底退出

**3、** 执行睡眠 ： ctrl+z 挂起当前进程fg 恢复后台

**4、** 查看当前用户 id： ”id“：查看显示目前登陆账户的 uid 和 gid 及所属分组及用户名

**5、** 查看指定帮助： 如 man adduser 这个很全 而且有例子； adduser --help 这个告诉你一些常用参数； info adduesr；


### 9、怎么查看当前进程？怎么执行退出？怎么查看当前路径？

**答案：**

**1、** 查看当前进程： ps

**2、** 执行退出： exit

**3、** 查看当前路径： pwd


### 10、数据字典属于哪一个用户的？

**答案：**

数据字典是属于’SYS’用户的，用户‘SYS’ 和 ’SYSEM’是由系统默认自动创建的


### 11、列出已经安装的包？安装软件？更新软件？卸载?
### 12、awk 详解。
### 13、bash手册
### 14、Linux 下命令有哪几种可使用的通配符？分别代表什么含义?
### 15、复制文件
### 16、什么是运维？什么是游戏运维？
### 17、Linux系统中病毒怎么解决
### 18、Linux 开机启动过程？
### 19、怎么对命令进行取别名？
### 20、一台 Linux 系统初始化环境后需要做一些什么安全工作？
### 21、如何选择 Linux 操作系统版本?
### 22、通过什么命令查找执行命令?
### 23、快速判断某个特定目录是否有超大文件？
### 24、Unix和Linux有什么区别？
### 25、mv（move单词缩写，移动功能，该文件名称功能）
### 26、压缩工具有哪些?
### 27、如何查看命令历史记录?
### 28、终止进程用什么命令? 带什么参数?
### 29、在工作中，运维人员经常需要跟运营人员打交道，请问运营人员是做什么工作的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
