# Linux最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是Linux

Linux是一套免费使用和自由传播的类似Unix操作系统，一般的WEB项目都是部署都是放在Linux操作系统上面。 Linux是一个基于POSIX和Unix的多用户、多任务、支持多线程和多CPU的操作系统。它能运行主要的Unix工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳定的多用户网络操作系统。


### 2、请执行命令取出 linux 中 eth0 的 IP 地址(请用 cut，有能力者也可分别用 awk,sed 命令答)

```
cut方法1：
# ifconfig eth0|sed -n '2p'|cut -d ":" -f2|cut -d " " -f1
192.168.20.130
awk方法2：
# ifconfig eth0|awk 'NR==2'|awk -F ":" '{print $2}'|awk '{print $1}'
192.168.20.130
awk多分隔符方法3：
# ifconfig eth0|awk 'NR==2'|awk -F "[: ]+" '{print $4}'
192.168.20.130
sed方法4：
# ifconfig eth0|sed -n '/inet addr/p'|sed -r 's#^.*ddr:(.*)Bc.*$##g'
192.168.20.130
```


### 3、如何重置MySQL root密码？

**一、 在已知MYSQL数据库的ROOT用户密码的情况下，修改密码的方法：**

**1、** 在SHELL环境下，使用MySQLadmin命令设置：

MySQLadmin –u root –p password “新密码” ? 回车后要求输入旧密码

**2、** 在MySQL>环境中,使用update命令，直接更新MySQL库user表的数据：

Update ?MySQL.user ?set ?password=password(‘新密码’) ?where ?user=’root’;

flush ? privileges;

注意：MySQL语句要以分号”；”结束

3 在MySQL>环境中，使用grant命令，修改root用户的授权权限。

grant ?all ?on ?_._ ?to ? root@’localhost’ ?identified ?by ?‘新密码’；

**二、 如查忘记了MySQL数据库的ROOT用户的密码，又如何做呢？方法如下：**

**1、** 关闭当前运行的MySQLd服务程序：service ?MySQLd ?stop（要先将MySQLd添加为系统服务）

**2、** 使用MySQLd_safe脚本以安全模式（不加载授权表）启动MySQLd 服务

/usr/local/MySQL/bin/MySQLd_safe ?--skip-grant-table ?&

**3、** 使用空密码的root用户登录数据库，重新设置ROOT用户的密码

＃MySQL ?-u ? root

MySQL> Update ?MySQL.user ?set ?password=password(‘新密码’) ?where ?user=’root’;

MySQL> flush ? privileges;


### 4、简述raid0 raid1 raid5 三种工作模式的工作原理及特点

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


### 5、touch （touch：创建文件）创建文件

```
touch test.txt  ;创建test.txt文件
touch /opt/java/test.java ;在指定目录创建test.java文件
```


### 6、怎样查看一个linux命令的概要与用法？假设你在/bin目录中偶然看到一个你从没见过的的命令，怎样才能知道它的作用和用法呢？

**答案：**

使用命令whatis 可以先出显示出这个命令的用法简要，比如，你可以使用whatis zcat 去查看‘zcat’的介绍以及使用简要。

```
[root@localhost ~]# whatis zcat
zcat [gzip] (1) – compress or expand files
```


### 7、查看已有别名?建立属于自己的别名?

alias -p 查看当前可用别名

```
[root@iz2ze76ybn73dvwmdij06zz ~]# alias -p
alias cp='cp -i'
alias egrep='egrep —color=auto'
alias fgrep='fgrep —color=auto'
alias grep='grep —color=auto'
alias l.='ls -d .* —color=auto'
alias ll='ls -l —color=auto'
```

alias li = 'ls -li' 创建别名


### 8、使用哪一个命令可以查看自己文件系统的磁盘空间配额呢？

**答案：**

使用命令repquota 能够显示出一个文件系统的配额信息

【附】只有root用户才能够查看其它用户的配额。


### 9、如果一个linux新手想要知道当前系统支持的所有命令的列表，他需要怎么做？

**答案：**

使用命令compgen --c，可以打印出所有支持的命令列表。

```
[root@localhost ~]$ compgen -c
l.
ll
ls
which
if
then
else
elif
fi
case
esac
for
select
while
until
do
done
…
```


### 10、什么是GUI？

图形用户界面（Graphical User Interface，简称 GUI，又称图形用户接口）是指采用图形方式显示的计算机操作用户界面。

图形用户界面是一种人与计算机通信的界面显示格式，允许用户使用鼠标等输入设备操纵屏幕上的图标或菜单选项，以选择命令、调用文件、启动程序或执行其它一些日常任务。与通过键盘输入文本或字符命令来完成例行任务的字符界面相比，图形用户界面有许多优点。


### 11、pwd （print working directory：显示当前工作目录的绝对路径）
### 12、ps （process status：进程状态，类似于windows的任务管理器）
### 13、服务器开不了机怎么解决一步步的排查
### 14、如果你的助手想要打印出当前的目录栈，你会建议他怎么做？
### 15、什么叫 CC 攻击？什么叫 DDOS 攻击？
### 16、GNU项目的重要性是什么？
### 17、查看文件类型?字符编码？
### 18、Linux 有哪些系统日志文件？
### 19、使用什么命令查看 ip 地址及接口信息？
### 20、每天晚上 12 点，打包站点目录/var/www/html 备份到/data 目录下（最好每次备份按时间生成不同的备份包）
### 21、如何压缩文件？如何解压文件?
### 22、登陆后你在的位置？
### 23、BASH和DOS之间的基本区别是什么？
### 24、什么是root帐户
### 25、什么叫网站灰度发布？
### 26、如何用sed只打印第5行?删除第一行？替换字符串?
### 27、快速判断某个特定目录是否有超大文件？
### 28、请写出下面 linux SecureCRT 命令行快捷键命令的功能？
### 29、搜索文件用什么命令? 格式是怎么样的?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
