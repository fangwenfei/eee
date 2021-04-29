# Linux最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是网站数据库注入？

**1、** 由于程序员的水平及经验参差不齐，大部分程序员在编写代码的时候，没有对用户输入数据的合法性进行判断。

**2、** 应用程序存在安全隐患。用户可以提交一段数据库查询代码，根据程序返回的结果，获得某些他想得知的数据，这就是所谓的 SQL 注入。

**3、** SQL注入，是从正常的 WWW 端口访问，而且表面看起来跟一般的 Web 页面访问没什么区别，如果管理员没查看日志的习惯，可能被入侵很长时间都不会发觉。

**如何过滤与预防？**

数据库网页端注入这种，可以考虑使用 nginx_waf 做过滤与预防。


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


### 3、什么是Linux？

是一套免费使用和自由传播的类UNIX操作系统，其内核由林纳斯·本纳第克特·托瓦兹于1991年第一次释出，它主要受到Minix和Unix思想的启发，是一个基于POSIX和Unix的多用户、多任务、支持多线程和多CPU的操作系统。它能运行主要的Unix工具软件、应用程序和网络协议。它支持32位和64位硬件。


### 4、ping （用于检测与目标的连通性）语法：ping ip地址

```
测试：
**1、** 在Windows操作系统中?cmd?ipconfig，查看本机IP地址：

**2、** 再到LInux系统中输入 ping ip地址

（公司电脑，我就不暴露Ip了,没图片  自己去试）
按Ctrl + C 可以停止测试。
```


### 5、Linux 的体系结构

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


### 6、写一个脚本，实现判断192.168.1.0/24网络里，当前在线的IP有哪些，能ping通则认为在线

```
#!/bin/bash
for ip in `seq 1 255`
do
{
ping -c 1 192.168.1.$ip > /dev/null 2>&1
if [ $? -eq 0 ]; then
echo 192.168.1.$ip UP
else
echo 192.168.1.$ip DOWN
fi
}&
done
wait
```


### 7、MySQL数据备份工具

**MySQLdump工具**

MySQLdump是MySQL自带的备份工具，目录在bin目录下面：/usr/local/MySQL/bin/MySQLdump

支持基于innodb的热备份，但是由于是逻辑备份，所以速度不是很快，适合备份数据比较小的场景

MySQLdump完全备份+二进制日志可以实现基于时间点的恢复。

**基于LVM快照备份**

在物理备份中，有基于文件系统的物理备份（LVM的快照），也可以直接用tar之类的命令对整个数据库目录

进行打包备份，但是这些只能进行泠备份，不同的存储引擎备份的也不一样，myisam自动备份到表级别

而innodb不开启独立表空间的话只能备份整个数据库。

**tar包备份**

percona提供的xtrabackup工具

支持innodb的物理热备份，支持完全备份，增量备份，而且速度非常快，支持innodb存储引起的数据在不同

数据库之间迁移，支持复制模式下的从机备份恢复备份恢复，为了让xtrabackup支持更多的功能扩展

可以设立独立表空间，打开 innodb_file_per_table功能，启用之后可以支持单独的表备份


### 8、什么是运维？什么是游戏运维？

**运维是指大型组织已经建立好的网络软硬件的维护，就是要保证业务的上线与运作的正常，**

**1、** 在他运转的过程中，对他进行维护，他集合了网络、系统、数据库、开发、安全、监控于一身的技术

**2、** 运维又包括很多种，有DBA运维、网站运维、虚拟化运维、监控运维、游戏运维等等

**游戏运维又有分工，分为开发运维、应用运维（业务运维）和系统运维**

**1、** 开发运维：是给应用运维开发运维工具和运维平台的

**2、** 应用运维：是给业务上线、维护和做故障排除的，用开发运维开发出来的工具给业务上线、维护、做故障排查

**3、** 系统运维：是给应用运维提供业务上的基础设施，比如：系统、网络、监控、硬件等等

总结：开发运维和系统运维给应用运维提供了“工具”和“基础设施”上的支撑

开发运维、应用运维和系统运维他们的工作是环环相扣的


### 9、终止进程用什么命令? 带什么参数?

**答案：**

kill [-s <信息名称或编号>][程序] 或 kill [-l <信息编号>]

kill-9 pid


### 10、统计ip访问情况，要求分析nginx访问日志，找出访问页面数量在前十位的ip

cat access.log | awk '{print $1}' | uniq -c | sort -rn | head -10


### 11、如何执行可以执行文件?
### 12、文件描述符?每个描述符的含义?
### 13、如何切换目录？
### 14、Linux 中进程有哪几种状态？在 ps 显示出来的信息中，分别用什么符号表示的？
### 15、bash手册
### 16、cp（copy单词缩写，复制功能）
### 17、find （find：找到的意思）查找指定文件或目录
### 18、Ls 命令执行什么功能？ 可以带哪些参数，有什么区别？
### 19、讲述一下Tomcat8005、8009、8080三个端口的含义？
### 20、keepalive的工作原理和如何做到健康检查
### 21、什么叫CDN？
### 22、Linux内核主要负责哪些功能
### 23、Linux 使用的进程间通信方式？
### 24、lvs/nginx/haproxy优缺点
### 25、查看部分文件
### 26、数据字典属于哪一个用户的？
### 27、怎么使一个命令在后台运行?
### 28、查看文件内容有哪些命令可以使用？
### 29、Linux 下命令有哪几种可使用的通配符？分别代表什么含义?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
