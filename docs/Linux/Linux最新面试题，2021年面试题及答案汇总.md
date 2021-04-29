# Linux最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何切换目录？

语法: cd destination

destination : 相对文件路径或绝对文件路径

可以跳到存在的任意目录。


### 2、Linux广泛使用的归档数据方法?

虽然zip命令能压缩和解压单个文件，但是更多的时候广泛使用tar命令来做归档。

语法: tar function [options] obj1 obj2

![80_2.png][80_2.png]image-20200421122932671

```
?  apache tar -cvf service.tar service1 service2 // 创建规定文件service.tar
a service1
a service2
?  apache tar -tf service.tar //查看文件中的目录内容
service1
service2
?  apache tar zxvf service.tar //解压
x service1
x service2
```


### 3、用tcpdump嗅探80端口的访问看看谁最高

```
tcpdump -i eth0 -tnn dst port 80 -c 1000 | awk -F"." '{print $1"."$2"."$3"."$4}'| sort | uniq -c | sort -nr |head -20
```


### 4、如何写一条规则，拒绝某个ip访问本机8080端口?

```
iptables -I INPUT -s ip -p tcp —dport 8080 -j REJECT
```


### 5、find （find：找到的意思）查找指定文件或目录

```
* 表示0~多个任意字符。
find -name 文件名;按照指定名称查找在当前目录下查找文件
find / -name 文件名按照指定名称全局查找文件
find -name '*文件名' ;任意前缀加上文件名在当前目录下查找文件
find / -name '*文件名*' ;全局进行模糊查询带文件名的文件
```


### 6、clear 清屏命令。（强迫症患者使用）

```
kill 命令用来中止一个进程。（要配合ps命令使用，配合pid关闭进程）
（ps类似于打开任务管理器，kill类似于关闭进程）
kill -5 进程的PID ;推荐,和平关闭进程
kill -9 PID ;不推荐,强制杀死进程
```


### 7、MySQL的innodb如何定位锁问题，MySQL如何减少主从复制延迟？

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


### 8、建立软链接(快捷方式)，以及硬链接的命令。
### 9、如何查看目录中的文件？区分哪些是文件哪些是目录?递归查?
### 10、使用哪一个命令可以查看自己文件系统的磁盘空间配额呢？
### 11、查找匹配数据？反向搜？
### 12、查看某端口是否被占用?
### 13、查看文件类型?字符编码？
### 14、如何中断一个进程?
### 15、通过什么命令查找执行命令?
### 16、数据字典属于哪一个用户的？
### 17、8.迷路，我的当前位置在哪？
### 18、查看文件内容有哪些命令可以使用？
### 19、什么是CLI？
### 20、使用什么命令查看磁盘使用空间？ 空闲空间呢?
### 21、ps （process status：进程状态，类似于windows的任务管理器）
### 22、储存用户的文件是?包括哪些信息？
### 23、默认进程信息显示?
### 24、讲一下Keepalived的工作原理？
### 25、怎么查看当前进程？怎么执行退出？怎么查看当前路径？
### 26、BASH和DOS之间的基本区别是什么？
### 27、什么是交换空间？
### 28、Linux 的目录结构是怎样的？
### 29、终端是哪个文件夹下的哪个文件？黑洞文件是哪个文件夹下的哪个命令？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
