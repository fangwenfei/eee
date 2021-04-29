# Linux最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、cat （concatenate：显示或把多个文本文件连接起来）查看文件命令（可以快捷查看当前文件的内容）（不能快速定位到最后一页）

```
cat lj.log ;快捷查看文件命令 
Ctrl + c ;暂停显示文件
Ctrl + d ;退出查看文件命令
```


### 2、压缩工具有哪些?

![80_1.png][80_1.png]image-20200421122324314


### 3、怎么查看系统支持的所有信号？

**答案：**

kill -l


### 4、什么是交换空间？

交换空间是Linux使用的一定空间，用于临时保存一些并发运行的程序。当RAM没有足够的内存来容纳正在执行的所有程序时，就会发生这种情况。


### 5、如果你的助手想要打印出当前的目录栈，你会建议他怎么做？

**答案：**

使用Linux 命令dirs可以将当前的目录栈打印出来。

```
[root@localhost ~]# dirs
/usr/share/X11
```

【附】：目录栈通过pushd popd 来操作。


### 6、把后台任务调到前台执行使用什么命令?把停下的后台任务在后台执行起来用什么命令?

**答案：**

把后台任务调到前台执行 fg

把停下的后台任务在后台执行起来 bg


### 7、什么是GUI？

图形用户界面（Graphical User Interface，简称 GUI，又称图形用户接口）是指采用图形方式显示的计算机操作用户界面。

图形用户界面是一种人与计算机通信的界面显示格式，允许用户使用鼠标等输入设备操纵屏幕上的图标或菜单选项，以选择命令、调用文件、启动程序或执行其它一些日常任务。与通过键盘输入文本或字符命令来完成例行任务的字符界面相比，图形用户界面有许多优点。


### 8、怎么使一个命令在后台运行?

**答案：**

一般都是使用 & 在命令结尾来让程序自动运行。(命令后可以不追加空格)


### 9、MySQL数据备份工具

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


### 10、如何执行可以执行文件?

```
[root@xiaoka ~]# sh sleep.sh
hello,xiaoka
[root@xiaoka ~]# ./sleep.sh
hello,xiaoka
```


### 11、什么是root帐户
### 12、pwd （print working directory：显示当前工作目录的绝对路径）
### 13、怎么查看当前进程？怎么执行退出？怎么查看当前路径？
### 14、当你需要给命令绑定一个宏或者按键的时候，应该怎么做呢？
### 15、什么是LILO？
### 16、更改为北京时间命令
### 17、在工作中，运维人员经常需要跟运营人员打交道，请问运营人员是做什么工作的？
### 18、什么叫 CC 攻击？什么叫 DDOS 攻击？
### 19、mkdir （mkdir：创建目录） 创建目录
### 20、lvs/nginx/haproxy优缺点
### 21、查看各类环境变量用什么命令?
### 22、利用 ps 怎么显示所有的进程? 怎么利用 ps 查看指定进程的信息？
### 23、复制文件
### 24、bash手册
### 25、RabbitMQ是什么东西？
### 26、说说TCP/IP的七层模型
### 27、启动shell
### 28、Windows和Linux的区别
### 29、Grep 命令有什么用？ 如何忽略大小写？ 如何查找不含该串的行?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
