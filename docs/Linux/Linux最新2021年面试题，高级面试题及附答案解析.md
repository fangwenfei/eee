# Linux最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、在工作中，运维人员经常需要跟运营人员打交道，请问运营人员是做什么工作的？

游戏运营要做的一个事情除了协调工作以外

还需要与各平台沟通，做好开服的时间、开服数、用户导量、活动等计划


### 2、重启linux

```
Linux centos 重启命令：reboot
```


### 3、mv（move单词缩写，移动功能，该文件名称功能）

```
mv /opt/java/java.log /opt/MySQL/ ;移动文件到MySQL目录下
mv java.log MySQL.log ;把java.log改名为MySQL.log
```


### 4、默认进程信息显示?

ps它能输出运行在系统上的所有程序的许多信息。

默认情况下ps值显示运行在当前控制台下的当前用户的进程。

```
[root@iz2ze76ybn73dvwmdij06zz ~]# ps
  PID TTY          TIME CMD
10102 pts/0    00:00:00 bash
10131 pts/0    00:00:00 ps
```


### 5、说说TCP/IP的七层模型

**应用层 (Application)：**

网络服务与最终用户的一个接口。

协议有：HTTP FTP TFTP SMTP SNMP DNS TELNET HTTPS POP3 DHCP

**表示层（Presentation Layer）：**

数据的表示、安全、压缩。（在五层模型里面已经合并到了应用层）

格式有，JPEG、ASCll、DECOIC、加密格式等

**会话层（Session Layer）：**

建立、管理、终止会话。（在五层模型里面已经合并到了应用层）

对应主机进程，指本地主机与远程主机正在进行的会话

**传输层 (Transport)：**

定义传输数据的协议端口号，以及流控和差错校验。

协议有：TCP UDP，数据包一旦离开网卡即进入网络传输层

**网络层 (Network)：**

进行逻辑地址寻址，实现不同网络之间的路径选择。

协议有：ICMP IGMP IP（IPV4 IPV6） ARP RARP

**数据链路层 (Link)：**

建立逻辑连接、进行硬件地址寻址、差错校验等功能。（由底层网络定义协议）

将比特组合成字节进而组合成帧，用MAC地址访问介质，错误发现但不能纠正

**物理层（Physical Layer）：**

**1、** 是计算机网络OSI模型中最低的一层

**2、** 物理层规定:为传输数据所需要的物理链路创建、维持、拆除

**3、** 而提供具有机械的，电子的，功能的和规范的特性

**4、** 简单的说，物理层确保原始的数据可在各种物理媒体上传输。局域网与广域网皆属第1、2层

**5、** 物理层是OSI的第一层，它虽然处于最底层，却是整个开放系统的基础

**6、** 物理层为设备之间的数据通信提供传输媒体及互连设备，为数据传输提供可靠的环境

**7、** 如果您想要用尽量少的词来记住这个第一层，那就是“信号和介质”


### 6、如何查看目录中的文件？区分哪些是文件哪些是目录?递归查?

ls 命令会用最基本的形式显示当前目录下的文件和目录：

```
?  local ls
Caskroom   Frameworks bin        go         lib        sbin       var
Cellar     Homebrew   etc        include    opt        share
```

可以看出默认是按照字母序展示的

一般来说，ls命令回显示不同的颜色区分不同的文件类型,如果没有安装颜色插件可以用ls -F来区分哪些是目录（目录带/)，哪些是文件（文件不带/)

ls -R 递归展示出目录下以及子目录的文件，目录越多输出越多


### 7、源码安装通常的路子?

```
 tar -zxvf xx.gz //解包
 cd xx
 ./configure
 make
 make install
```


### 8、RabbitMQ是什么东西？

RabbitMQ也就是消息队列中间件，消息中间件是在消息的传息过程中保存消息的容器

消息中间件再将消息从它的源中到它的目标中标时充当中间人的作用

队列的主要目的是提供路由并保证消息的传递；如果发送消息时接收者不可用

消息队列不会保留消息，直到可以成功地传递为止，当然，消息队列保存消息也是有期限地


### 9、怎么对命令进行取别名？

**答案：**

```
alias la='ls -a'
```


### 10、打印文件第一行到第三行?

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


### 11、vim编辑器几种操作模式？基本操作?
### 12、查找命令的可执行文件是去哪查找的? 怎么对其进行设置及添加?
### 13、使用tcpdump监听主机为192.168.1.1，tcp端口为80的数据，同时将输出结果保存输出到tcpdump.log
### 14、什么是LILO？
### 15、什么是 inode ？
### 16、查看设备还有多少磁盘空间?
### 17、修改权限?
### 18、你常用的Nginx模块，用来做什么
### 19、Linux 开机启动过程？
### 20、Linux 的目录结构是怎样的？
### 21、file （可查看文件类型）
### 22、MySQL的innodb如何定位锁问题，MySQL如何减少主从复制延迟？
### 23、Linux广泛使用的归档数据方法?
### 24、使用什么命令查看网络是否连通?
### 25、RAID 是什么?
### 26、vi （VIsual：视觉）文本编辑器 类似win的记事本 （操作类似于地下的vim命令，看底下vim 的操作）
### 27、发现一个病毒文件你删了他又自动创建怎么解决
### 28、| 管道命令（把多个命令组合起来使用）
### 29、Linux系统中病毒怎么解决




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
