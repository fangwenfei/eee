# Linux最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、mkdir （mkdir：创建目录） 创建目录

```
mkdir 文件夹名称 ;在此目录创建文件夹
mkdir /opt/java/jdk ;在指定目录创建文件夹
```


### 2、建立软链接(快捷方式)，以及硬链接的命令。

**答案：**

**1、** 软链接： ln -s slink source

**2、** 硬链接： ln link source


### 3、删除文件?强制删除？递归删除?

语法: rm destination

-i 询问是否删除,-r 递归删除，-f 强制删除。

rm不能删除有文件的目录,需要递归删除。

```
?  xktest rm jdk
rm: jdk: is a directory
?  xktest rm -r jdk
?  xktest ls
```

rm -i 询问删除,建议大家平时删除多用 -i，确定一下再删除。

```
?  xktest touch tomcat
?  xktest rm -i tomcat
remove tomcat? n
```

rm -rf 会直接删除，没有警告信息，使用必须谨慎**。


### 4、什么是 Linux 内核？

Linux 系统的核心是内核。内核控制着计算机系统上的所有硬件和软件，在必要时分配硬件，并根据需要执行软件。

**1、** 系统内存管理

**2、** 应用程序管理

**3、** 硬件设备管理

**4、** 文件系统管理


### 5、同步时间命令

```
ntpdate ntp1.aliyun.com
```


### 6、每天晚上 12 点，打包站点目录/var/www/html 备份到/data 目录下（最好每次备份按时间生成不同的备份包）

```
# cat a.sh 
#/bin/bash
cd /var/www/ && /bin/tar zcf /data/html-`date +%m-%d%H`.tar.gz html/
# crontab –e
00 00 * * * /bin/sh /root/a.sh
```



### 7、验证网络可链接命令是什么？什么原理？

ping。这个 ping 命令发送一个特殊的网络数据包(叫做 IMCP ECHO REQUEST)到一台指定的主机。大多数接收这个包的网络设备将会回复它，来允许网络连接验证。

![80_5.png][80_5.png]image-20200421142307602

一旦启动，ping会持续在特定时间（默认1秒）发送数据包。


### 8、什么是BASH？

BASH是Bourne Again SHell的缩写。它由Steve Bourne编写，作为原始Bourne Shell（由/ bin / sh表示）的替代品。它结合了原始版本的Bourne Shell的所有功能，以及其他功能，使其更容易使用。从那以后，它已被改编为运行Linux的大多数系统的默认shell。


### 9、重新命名文件？移动文件？

语法 ： mv soucre target

重命名:

```
?  xktest ls
?  xktest touch java
?  xktest ls
java
?  xktest mv java java1.8
?  xktest ls
java1.8
```

移动文件:

新建jdk目录把java1.8文件移动到jdk目录下。

```
?  xktest ls
java1.8
?  xktest mkdir jdk
?  xktest mv java1.8 jdk
?  xktest ls -R
jdk
 ./jdk:
java1.8
```


### 10、cp（copy单词缩写，复制功能）

```
cp /opt/java/java.log /opt/logs/ ;把java.log 复制到/opt/logs/下
cp /opt/java/java.log /opt/logs/aaa.log ;把java.log 复制到/opt/logs/下并且改名为aaa.log
cp -r /opt/java /opt/logs ;把文件夹及内容复制到logs文件中
```


### 11、发现一个病毒文件你删了他又自动创建怎么解决
### 12、Linux系统缺省的运行级别？
### 13、如何切换目录？
### 14、移动文件用哪个命令？改名用哪个命令？
### 15、keepalive的工作原理和如何做到健康检查
### 16、Windows和Linux的区别
### 17、| 管道命令（把多个命令组合起来使用）
### 18、Grep 命令有什么用？ 如何忽略大小写？ 如何查找不含该串的行?
### 19、开源的优势是什么？
### 20、Linux 中进程有哪几种状态？在 ps 显示出来的信息中，分别用什么符号表示的？
### 21、服务器开不了机怎么解决一步步的排查
### 22、你的系统目前有许多正在运行的任务，在不重启机器的条件下，有什么方法可以把所有正在运行的进程移除呢？
### 23、什么叫网站灰度发布？
### 24、Linux 性能调优都有哪几种方法？
### 25、写一个脚本，实现判断192.168.1.0/24网络里，当前在线的IP有哪些，能ping通则认为在线
### 26、Linux 的目录结构是怎样的？
### 27、GNU项目的重要性是什么？
### 28、如何执行可以执行文件?
### 29、Linux广泛使用的归档数据方法?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
