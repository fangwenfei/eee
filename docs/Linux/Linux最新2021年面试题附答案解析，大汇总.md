# Linux最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、查找匹配数据？反向搜？

语法: grep [options] pattern [file]

该命令会查找匹配执行模式的字符串的行，并输出。

```
?  apache grep start tomcat
start
restart
```

-v 反向搜

```
?  apache grep -v start tomcat
text
text
 stop
end
```

-n 显示行号

-c 显示匹配的行数


### 2、如何规划一台 Linux 主机，步骤是怎样？

确定机器是做什么用的，比如是做 WEB 、DB、还是游戏服务器。

> 不同的用途，机器的配置会有所不同。


**1、** 确定好之后，就要定系统需要怎么安装，默认安装哪些系统、分区怎么做。

**2、** 需要优化系统的哪些参数，需要创建哪些用户等等的。


### 3、什么是CLI？

**命令行界面**（英语：command-line interface，缩写]：CLI）是在图形用户界面得到普及之前使用最为广泛的用户界面，它通常不支持鼠标，用户通过键盘输入指令，计算机接收到指令后，予以执行。也有人称之为**字符用户界面**（CUI）。

通常认为，命令行界面（CLI）没有图形用户界面（GUI）那么方便用户操作。因为，命令行界面的软件通常需要用户记忆操作的命令，但是，由于其本身的特点，命令行界面要较图形用户界面节约计算机系统的资源。在熟记命令的前提下，使用命令行界面往往要较使用图形用户界面的操作速度要快。所以，图形用户界面的操作系统中，都保留着可选的命令行界面。


### 4、如何压缩文件？如何解压文件?

比如以.gz的格式举例。

压缩语法: gzip destination

```
?  apache gzip tomcat
?  apache ls
tomcat.gz
```

解压语法: gunzip destination

```
?  apache gunzip tomcat.gz
?  apache ls
tomcat
```


### 5、netstat 命令

```
#Linux netstat命令用于显示网络状态。
#利用netstat指令可让你得知整个Linux系统的网络情况。
#语法：
netstat [-acCeFghilMnNoprstuvVwx][-A<网络类型>][--ip]
```


### 6、clear 清屏命令。（强迫症患者使用）

```
kill 命令用来中止一个进程。（要配合ps命令使用，配合pid关闭进程）
（ps类似于打开任务管理器，kill类似于关闭进程）
kill -5 进程的PID ;推荐,和平关闭进程
kill -9 PID ;不推荐,强制杀死进程
```


### 7、查看当前谁在使用该主机用什么命令? 查找自己所在的终端信息用什么命令?

**答案：**

查找自己所在的终端信息：who am i

查看当前谁在使用该主机：who


### 8、什么是Linux？

是一套免费使用和自由传播的类UNIX操作系统，其内核由林纳斯·本纳第克特·托瓦兹于1991年第一次释出，它主要受到Minix和Unix思想的启发，是一个基于POSIX和Unix的多用户、多任务、支持多线程和多CPU的操作系统。它能运行主要的Unix工具软件、应用程序和网络协议。它支持32位和64位硬件。


### 9、cd （change directory：英文释义是改变目录）切换目录

```
cd ../ ;跳到上级目录
cd /opt ;不管现在到那直接跳到指定的opt文件夹中
cd ~ ;切换当前用户的家目录。root用户的家目录就是root目录。
```


### 10、什么叫CDN？

即内容分发网络

其目的是通过在现有的Internet中增加一层新的网络架构，将网站的内容发布到

最接近用户的网络边缘，使用户可就近取得所需的内容，提高用户访问网站的速度


### 11、默认进程信息显示?
### 12、请列出你了解的web服务器负载架构
### 13、同步时间命令
### 14、终端是哪个文件夹下的哪个文件？黑洞文件是哪个文件夹下的哪个命令？
### 15、Linux系统安装多个桌面环境有帮助吗？
### 16、用什么命令对一个文件的内容进行统计？(行号、单词数、字节数)
### 17、移动文件用哪个命令？改名用哪个命令？
### 18、讲述一下Tomcat8005、8009、8080三个端口的含义？
### 19、怎么对命令进行取别名？
### 20、简述raid0 raid1 raid5 三种工作模式的工作原理及特点
### 21、如果一个linux新手想要知道当前系统支持的所有命令的列表，他需要怎么做？
### 22、什么是硬链接和软链接？
### 23、源码安装通常的路子?
### 24、如何查看命令历史记录?
### 25、grep （grep ：正则表达式）正则表达式，用于字符串的搜索工作(模糊查询)。不懂可以先过
### 26、ifconfig命令
### 27、什么是Linux
### 28、查看已有别名?建立属于自己的别名?
### 29、如何用awk查看第2行倒数第3个字段?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
