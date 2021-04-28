# Linux最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是LILO？

LILO是Linux的引导加载程序。它主要用于将Linux操作系统加载到主内存中，以便它可以开始运行。


### 2、移动文件用哪个命令？改名用哪个命令？

**答案：**

mv mv


### 3、什么是Linux

Linux是一套免费使用和自由传播的类似Unix操作系统，一般的WEB项目都是部署都是放在Linux操作系统上面。 Linux是一个基于POSIX和Unix的多用户、多任务、支持多线程和多CPU的操作系统。它能运行主要的Unix工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳定的多用户网络操作系统。


### 4、如何重置MySQL root密码？

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


### 5、vim编辑器几种操作模式？基本操作?

操作模式:

**1、** 普通模式

**2、** 插入模式

基础操作:

**1、** h:左移一个字符。

**2、** j:下移一行(文本中的下一行)。

**3、** k:上移一行(文本中的上一行)。

**4、** l:右移一个字符。

vim提供了一些能够提高移动速度的命令:

**1、** PageDown(或Ctrl+F):下翻一屏

**2、** PageUp(或Ctrl+B):上翻一屏。

**3、** G:移到缓冲区的最后一行。

**4、** num G:移动到缓冲区中的第num行。

**5、** gg:移到缓冲区的第一行。

退出vim:

**1、** q:如果未修改缓冲区数据，退出。

**2、** q!:取消所有对缓冲区数据的修改并退出。

**3、** w filename:将文件保存到另一个文件中。

**4、** wq:将缓冲区数据保存到文件中并退出。


### 6、tail（尾巴） 查看文件命令（看最后多少行）

```
tail -10 ;文件名 看最后10行
```


### 7、怎么清屏？怎么退出当前命令？怎么执行睡眠？怎么查看当前用户 id？查看指定帮助用什么命令？

**答案：**

**1、** 清屏： clear

**2、** 退出当前命令： ctrl+c 彻底退出

**3、** 执行睡眠 ： ctrl+z 挂起当前进程fg 恢复后台

**4、** 查看当前用户 id： ”id“：查看显示目前登陆账户的 uid 和 gid 及所属分组及用户名

**5、** 查看指定帮助： 如 man adduser 这个很全 而且有例子； adduser --help 这个告诉你一些常用参数； info adduesr；


### 8、如何执行可以执行文件?

```
[root@xiaoka ~]# sh sleep.sh
hello,xiaoka
[root@xiaoka ~]# ./sleep.sh
hello,xiaoka
```


### 9、Linux 下命令有哪几种可使用的通配符？分别代表什么含义?

**答案：**

“？”可替代单个字符。

“*”可替代任意多个字符。

方括号“[charset]”可替代 charset 集中的任何单个字符，如[a-z]，[abABC]


### 10、Linux内核主要负责哪些功能

**1、** 系统内存管理

**2、** 软件程序管理

**3、** 硬件设备管理

**4、** 文件系统管理


### 11、Ls 命令执行什么功能？ 可以带哪些参数，有什么区别？
### 12、简述raid0 raid1 raid5 三种工作模式的工作原理及特点
### 13、查看文件内容有哪些命令可以使用？
### 14、统计ip访问情况，要求分析nginx访问日志，找出访问页面数量在前十位的ip
### 15、如何将本地80 端口的请求转发到8080 端口，当前主机IP 为192.168.2.1
### 16、什么是GUI？
### 17、keepalive的工作原理和如何做到健康检查
### 18、列出已经安装的包？安装软件？更新软件？卸载?
### 19、登陆后你在的位置？
### 20、Linux 开机启动过程？
### 21、什么是交换空间？
### 22、请写出下面 linux SecureCRT 命令行快捷键命令的功能？
### 23、mkdir （mkdir：创建目录） 创建目录
### 24、什么是硬链接和软链接？
### 25、什么叫 CC 攻击？什么叫 DDOS 攻击？
### 26、Linux 性能调优都有哪几种方法？
### 27、已知 apache 服务的访问日志按天记录在服务器本地目录/app/logs 下，由于磁盘空间紧张现在要求只能保留最近 7 天的访问日志！请问如何解决？请给出解决办法或配置或处理命令
### 28、关机linux
### 29、使用什么命令查看磁盘使用空间？ 空闲空间呢?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
