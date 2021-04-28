# Linux最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、绝对路径用什么符号表示？当前目录、上层目录用什么表示？主目录用什么表示? 切换目录用什么命令？

**答案：**

**1、** 绝对路径： 如/etc/init.d

**2、** 当前目录和上层目录： ./ ?../

**3、** 主目录： ~/

**4、** 切换目录： cd


### 2、统计ip访问情况，要求分析nginx访问日志，找出访问页面数量在前十位的ip

cat access.log | awk '{print $1}' | uniq -c | sort -rn | head -10


### 3、MySQL数据备份工具

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


### 4、free 命令 （显示系统内存）

```
#显示系统内存使用情况，包括物理内存、交互区内存(swap)和内核缓冲区内存。
-b 以Byte显示内存使用情况
-k 以kb为单位显示内存使用情况
-m 以mb为单位显示内存使用情况
-g 以gb为单位显示内存使用情况
-s<间隔秒数> 持续显示内存
-t 显示内存使用总合
```


### 5、如何写一条规则，拒绝某个ip访问本机8080端口?

```
iptables -I INPUT -s ip -p tcp —dport 8080 -j REJECT
```


### 6、怎么查看系统支持的所有信号？

**答案：**

kill -l


### 7、请列出你了解的web服务器负载架构

Nginx

Haproxy

Keepalived

LVS


### 8、如何查看当前主机名？如何修改？如何重启后生效？

```
[root@iz2ze76ybn73dvwmdij06zz ~]# hostname//查看当前主机名
iz2ze76ybn73dvwmdij06zz
[root@iz2ze76ybn73dvwmdij06zz ~]# hostname xiaoka//修改当前主机名
[root@iz2ze76ybn73dvwmdij06zz ~]# hostname
xiaoka
```

大家知道一般来讲命令重启就会失效，目前基本上用的centos7的比较多，两种方式可以支持重启生效。

一、命令

```
[root@iz2ze76ybn73dvwmdij06zz ~]# hostnamectl set-hostname xiaoka
[root@iz2ze76ybn73dvwmdij06zz ~]# hostname
xiaoka
[root@xiaoka ~]#
```

二、修改配置文件:/etc/hostname

```
[root@xiaoka ~]# vim /etc/hostname
```


### 9、MySQL的innodb如何定位锁问题，MySQL如何减少主从复制延迟？

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


### 10、用什么命令对一个文件的内容进行统计？(行号、单词数、字节数)

**答案：**

wc 命令 - c 统计字节数 - l 统计行数 - w 统计字数。


### 11、clear 清屏命令。（强迫症患者使用）
### 12、简单 Linux 文件系统？
### 13、什么是Linux？
### 14、哪个命令专门用来查看后台任务?
### 15、find （find：找到的意思）查找指定文件或目录
### 16、vim （VI IMproved：改进版视觉）改进版文本编辑器 （不管是文件查看还是文件编辑 按 Shift + 上或者下可以上下移动查看视角）
### 17、更改为北京时间命令
### 18、cat （concatenate：显示或把多个文本文件连接起来）查看文件命令（可以快捷查看当前文件的内容）（不能快速定位到最后一页）
### 19、Squid、Varinsh和Nginx有什么区别，工作中你怎么选择？
### 20、源码安装通常的路子?
### 21、Tomcat和Resin有什么区别，工作中你怎么选择？
### 22、什么叫 CC 攻击？什么叫 DDOS 攻击？
### 23、查看各类环境变量用什么命令?
### 24、使用什么命令查看用过的命令列表?
### 25、Linux 使用的进程间通信方式？
### 26、如何用awk查看第2行倒数第3个字段?
### 27、什么是硬链接和软链接？
### 28、怎样查看一个linux命令的概要与用法？假设你在/bin目录中偶然看到一个你从没见过的的命令，怎样才能知道它的作用和用法呢？
### 29、交互方式




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
