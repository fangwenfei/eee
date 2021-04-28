# Linux最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、什么是root帐户

root帐户就像一个系统管理员帐户，允许你完全控制系统。你可以在此处创建和维护用户帐户，为每个帐户分配不同的权限。每次安装Linux时都是默认帐户。


### 2、已知 apache 服务的访问日志按天记录在服务器本地目录/app/logs 下，由于磁盘空间紧张现在要求只能保留最近 7 天的访问日志！请问如何解决？请给出解决办法或配置或处理命令

创建文件脚本：

#!/bin/bash

for n in `seq 14`

do

date -s "11/0$n/14"

touch access_www_`(date +%F)`.log

done

解决方法：

```
# pwd/application/logs
# ll
-rw-r--r--、1 root root 0 Jan  1 00:00 access_www_2015-01-01.log
-rw-r--r--、1 root root 0 Jan  2 00:00 access_www_2015-01-02.log
-rw-r--r--、1 root root 0 Jan  3 00:00 access_www_2015-01-03.log
-rw-r--r--、1 root root 0 Jan  4 00:00 access_www_2015-01-04.log
-rw-r--r--、1 root root 0 Jan  5 00:00 access_www_2015-01-05.log
-rw-r--r--、1 root root 0 Jan  6 00:00 access_www_2015-01-06.log
-rw-r--r--、1 root root 0 Jan  7 00:00 access_www_2015-01-07.log
-rw-r--r--、1 root root 0 Jan  8 00:00 access_www_2015-01-08.log
-rw-r--r--、1 root root 0 Jan  9 00:00 access_www_2015-01-09.log
-rw-r--r--、1 root root 0 Jan 10 00:00 access_www_2015-01-10.log
-rw-r--r--、1 root root 0 Jan 11 00:00 access_www_2015-01-11.log
-rw-r--r--、1 root root 0 Jan 12 00:00 access_www_2015-01-12.log
-rw-r--r--、1 root root 0 Jan 13 00:00 access_www_2015-01-13.log
-rw-r--r--、1 root root 0 Jan 14 00:00 access_www_2015-01-14.log
# find /application/logs/ -type f -mtime +7 -name "*.log"|xargs rm –f  
##也可以使用-exec rm -f {} ;进行删除
# ll
-rw-r--r--、1 root root 0 Jan  7 00:00 access_www_2015-01-07.log
-rw-r--r--、1 root root 0 Jan  8 00:00 access_www_2015-01-08.log
-rw-r--r--、1 root root 0 Jan  9 00:00 access_www_2015-01-09.log
-rw-r--r--、1 root root 0 Jan 10 00:00 access_www_2015-01-10.log
-rw-r--r--、1 root root 0 Jan 11 00:00 access_www_2015-01-11.log
-rw-r--r--、1 root root 0 Jan 12 00:00 access_www_2015-01-12.log
-rw-r--r--、1 root root 0 Jan 13 00:00 access_www_2015-01-13.log
-rw-r--r--、1 root root 0 Jan 14 00:00 access_www_2015-01-14.log
```


### 3、BASH和DOS之间的基本区别是什么？

**BASH和DOS控制台之间的主要区别在于3个方面：**

**1、** BASH命令区分大小写，而DOS命令则不区分;

**2、** 在BASH下，/ character是目录分隔符，\作为转义字符。在DOS下，/用作命令参数分隔符，\是目录分隔符

**3、** DOS遵循命名文件中的约定，即8个字符的文件名后跟一个点，扩展名为3个字符。BASH没有遵循这样的惯例。


### 4、终端是哪个文件夹下的哪个文件？黑洞文件是哪个文件夹下的哪个命令？

**答案：**

终端 ?/dev/tty

黑洞文件 ?/dev/null


### 5、启动shell

GNU bash shell能提供对linux 系统的交互式访问。作为普通程序运行，通常在用户登陆终端时启动。登录时系统启动的shell依赖与用户账户的配置。


### 6、绝对文件路径?相对文件路径？快捷方式？

绝对文件路径：描述了在虚拟目录结构中该目录的确切位置，以虚拟目录跟目录开始，相当于目录全名。

以正斜线(/)开始，比如 /usr/local。

相对文件路径：允许用户执行一个基于当前位置的目标文件路径。

比如:当前在/usr/local

```
?  local ls
Caskroom   Frameworks bin        go         lib        sbin       var
Cellar     Homebrew   etc        include    opt        share
?  local cd go
```

快捷方式(在相对路径中使用):

单点符(.) : 表示当前目录; 双点符(..) : 表示当前目录的父目录。


### 7、8.迷路，我的当前位置在哪？

pwd 显示当前目录

```
[root@iz2ze76ybn73dvwmdij06zz local]# pwd
/usr/local
```


### 8、如何规划一台 Linux 主机，步骤是怎样？

确定机器是做什么用的，比如是做 WEB 、DB、还是游戏服务器。

> 不同的用途，机器的配置会有所不同。


**1、** 确定好之后，就要定系统需要怎么安装，默认安装哪些系统、分区怎么做。

**2、** 需要优化系统的哪些参数，需要创建哪些用户等等的。


### 9、什么是网站数据库注入？

**1、** 由于程序员的水平及经验参差不齐，大部分程序员在编写代码的时候，没有对用户输入数据的合法性进行判断。

**2、** 应用程序存在安全隐患。用户可以提交一段数据库查询代码，根据程序返回的结果，获得某些他想得知的数据，这就是所谓的 SQL 注入。

**3、** SQL注入，是从正常的 WWW 端口访问，而且表面看起来跟一般的 Web 页面访问没什么区别，如果管理员没查看日志的习惯，可能被入侵很长时间都不会发觉。

**如何过滤与预防？**

数据库网页端注入这种，可以考虑使用 nginx_waf 做过滤与预防。


### 10、储存用户的文件是?包括哪些信息？

/etc/passwd存储来一些用户有关的信息。

```
[root@iz2ze76ybn73dvwmdij06zz ~]# cat /etc/passwd
root:x:0:0:root:/root:/bin/bash
bin:x:1:1:bin:/bin:/sbin/nologin
```

文件信息包括如下内容。

**1、** 登录用户名

**2、** 用户密码

**3、** 用户账户的UID(数字形式)

**4、** 用户账户的组ID(GID)(数字形式)

**5、** 用户账户的文本描述(称为备注字段)

**6、** 用户HOME目录的位置

**7、** 用户的默认shell


### 11、rm（remove：移除的意思）删除文件，或文件夹
### 12、什么是CLI？
### 13、ps （process status：进程状态，类似于windows的任务管理器）
### 14、如何用sed只打印第5行?删除第一行？替换字符串?
### 15、利用 ps 怎么显示所有的进程? 怎么利用 ps 查看指定进程的信息？
### 16、使用什么命令查看 ip 地址及接口信息？
### 17、请问当用户反馈网站访问慢，你会如何处理？
### 18、使用tcpdump监听主机为192.168.1.1，tcp端口为80的数据，同时将输出结果保存输出到tcpdump.log
### 19、如何压缩文件？如何解压文件?
### 20、请执行命令取出 linux 中 eth0 的 IP 地址(请用 cut，有能力者也可分别用 awk,sed 命令答)
### 21、怎么使一个命令在后台运行?
### 22、less （lese：较少的意思）分页查看文件命令（可以快速定位到最后一页）
### 23、当你需要给命令绑定一个宏或者按键的时候，应该怎么做呢？
### 24、搜索文件用什么命令? 格式是怎么样的?
### 25、数据排序?对数字进行排序？对月份排序？
### 26、你对现在运维工程师的理解和以及对其工作的认识
### 27、账户默认信息？添加账户？删除用户？
### 28、vi （VIsual：视觉）文本编辑器 类似win的记事本 （操作类似于地下的vim命令，看底下vim 的操作）
### 29、查看时间命令：




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
