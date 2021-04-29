# Linux最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何用sed只打印第5行?删除第一行？替换字符串?

只打印第5行:

```
?  apache sed -n "5p" tomcat
stop
```

删除第一行:

```
[root@xiaoka ~]# cat story
Long ago a lion and a bear saw a kid.
They sprang upon it at the same time.
The lion said to the bear, “I caught this kid first, and so this is mine.”
[root@xiaoka ~]# cat story
They sprang upon it at the same time.
The lion said to the bear, “I caught this kid first, and so this is mine.”
```

替换字符串:

```
?  apache cat story
Long ago a lion and a bear saw a kid.
They sprang upon it at the same time.
The lion said to the bear, “I caught this kid first, and so this is mine.”
?  apache sed 's#this#that#g' story
Long ago a lion and a bear saw a kid.
They sprang upon it at the same time.
The lion said to the bear, “I caught that kid first, and so that is mine.”
```


### 2、简述raid0 raid1 raid5 三种工作模式的工作原理及特点

RAID 0：带区卷，连续以位或字节为单位分割数据，并行读/写于多个磁盘上，因此具有很高的数据传输率

但它没有数据冗余，RAID 0 只是单纯地提高性能，并没有为数据的可靠性提供保证

而且其中的一个磁盘失效将影响到所有数据。因此，RAID 0 不能应用于数据安全性要求高的场合

RAID 1：镜像卷，它是通过磁盘数据镜像实现数据冗余，在成对的独立磁盘上产生互为备份的数据

不能提升写数据效率。当原始数据繁忙时，可直接从镜像拷贝中读取数据，因此RAID1 可以提高读取性能

RAID 1 是磁盘阵列中单位成本最高的，镜像卷可用容量为总容量的1/2，但提供了很高的数据安全性和可用性

当一个磁盘失效时，系统可以自动切换到镜像磁盘上读写，而不需要重组失效的数据

RAID5：至少由3块硬盘组成，分布式奇偶校验的独立磁盘结构，它的奇偶校验码存在于所有磁盘上

任何一个硬盘损坏，都可以根据其它硬盘上的校验位来重建损坏的数据（最多允许1块硬盘损坏）

所以raid5可以实现数据冗余，确保数据的安全性，同时raid5也可以提升数据的读写性能


### 3、什么叫网站灰度发布？

灰度发布是指在黑与白之间，能够平滑过渡的一种发布方式

AB test就是一种灰度发布方式，让一部用户继续用A，一部分用户开始用B

如果用户对B没有什么反对意见，那么逐步扩大范围，把所有用户都迁移到B上面 来

灰度发布可以保证整体系统的稳定，在初始灰度的时候就可以发现、调整问题，以保证其影响度


### 4、登陆后你在的位置？

一般登陆后，你的位置位于自己的主目录中。


### 5、查看设备还有多少磁盘空间?

df 可以查看所有已挂在磁盘的使用情况。

-m 用兆字节，G代替g字节

```
[root@iz2ze76ybn73dvwmdij06zz ~]# df
文件系统          1K-块    已用     可用 已用% 挂载点
devtmpfs        1931568       0  1931568    0% /dev
tmpfs           1940960       0  1940960    0% /dev/shm
tmpfs           1940960     720  1940240    1% /run
tmpfs           1940960       0  1940960    0% /sys/fs/cgroup
/dev/vda1      41152812 9068544 30180560   24% /
tmpfs            388192       0   388192    0% /run/user/0
```


### 6、同步时间命令

```
ntpdate ntp1.aliyun.com
```


### 7、什么是Linux

Linux是一套免费使用和自由传播的类似Unix操作系统，一般的WEB项目都是部署都是放在Linux操作系统上面。 Linux是一个基于POSIX和Unix的多用户、多任务、支持多线程和多CPU的操作系统。它能运行主要的Unix工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳定的多用户网络操作系统。


### 8、请问当用户反馈网站访问慢，你会如何处理？
### 9、统计ip访问情况，要求分析nginx访问日志，找出访问页面数量在前十位的ip
### 10、请列出你了解的web服务器负载架构
### 11、什么是硬链接和软链接？
### 12、free 命令 （显示系统内存）
### 13、pwd （print working directory：显示当前工作目录的绝对路径）
### 14、你常用的Nginx模块，用来做什么
### 15、tar （解压 压缩 命令）
### 16、绝对文件路径?相对文件路径？快捷方式？
### 17、查看整个文件？按照有文本显示行号？无文本显示行号？
### 18、如何把一个进程放到后台运行？
### 19、什么叫CDN？
### 20、du 和 df 的定义，以及区别？
### 21、绝对路径用什么符号表示？当前目录、上层目录用什么表示？主目录用什么表示? 切换目录用什么命令？
### 22、怎么对命令进行取别名？
### 23、netstat 命令
### 24、怎么清屏？怎么退出当前命令？怎么执行睡眠？怎么查看当前用户 id？查看指定帮助用什么命令？
### 25、在工作中，运维人员经常需要跟运营人员打交道，请问运营人员是做什么工作的？
### 26、怎么使一个命令在后台运行?
### 27、查看时间命令：
### 28、如何查看命令历史记录?
### 29、什么是Linux？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
