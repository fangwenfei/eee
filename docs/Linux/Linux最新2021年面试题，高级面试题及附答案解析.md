# Linux最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何压缩文件？如何解压文件?

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


### 2、什么是网站数据库注入？

**1、** 由于程序员的水平及经验参差不齐，大部分程序员在编写代码的时候，没有对用户输入数据的合法性进行判断。

**2、** 应用程序存在安全隐患。用户可以提交一段数据库查询代码，根据程序返回的结果，获得某些他想得知的数据，这就是所谓的 SQL 注入。

**3、** SQL注入，是从正常的 WWW 端口访问，而且表面看起来跟一般的 Web 页面访问没什么区别，如果管理员没查看日志的习惯，可能被入侵很长时间都不会发觉。

**如何过滤与预防？**

数据库网页端注入这种，可以考虑使用 nginx_waf 做过滤与预防。


### 3、账户默认信息？添加账户？删除用户？

```
[root@iz2ze76ybn73dvwmdij06zz ~]# useradd -D//查看系统默认创建用户信息
GROUP=100
HOME=/home
INACTIVE=-1
EXPIRE=
SHELL=/bin/bash
SKEL=/etc/skel
CREATE_MAIL_SPOOL=yes
[root@iz2ze76ybn73dvwmdij06zz ~]# useradd xiaoka//添加用户
 [root@iz2ze76ybn73dvwmdij06zz /]# userdel xiaoka//删除用户
```


### 4、rm（remove：移除的意思）删除文件，或文件夹

```
-f或--force 强制删除文件或目录。删除文件不包括文件夹的文件
-r或-R或--recursive 递归处理，将指定目录下的所有文件及子目录一并删除。 
-rf 强制删除文件夹及内容

rm 文件名 ;安全删除命令  （yes删除 no取消）
rm -rf 强制删除文件夹及内容
rm -rf* 删除当前目录下的所有内容。
rm -rf /* 删除Linux系统根目录下所有的内容。系统将完蛋。
```


### 5、讲述一下Tomcat8005、8009、8080三个端口的含义？

8005==》 关闭时使用

8009==》 为AJP端口，即容器使用，如Apache能通过AJP协议访问Tomcat的8009端口

8080==》 一般应用使用


### 6、终止进程用什么命令? 带什么参数?

**答案：**

kill [-s <信息名称或编号>][程序] 或 kill [-l <信息编号>]

kill-9 pid


### 7、开源的优势是什么？

开源允许你将软件（包括源代码）免费分发给任何感兴趣的人。然后，人们可以添加功能，甚至可以调试和更正源代码中的错误。它们甚至可以让它运行得更好，然后再次自由地重新分配这些增强的源代码。这最终使社区中的每个人受益。


### 8、删除文件用哪个命令？如果需要连目录及目录下文件一块删除呢？删除空文件夹用什么命令？
### 9、查看当前谁在使用该主机用什么命令? 查找自己所在的终端信息用什么命令?
### 10、查找命令的可执行文件是去哪查找的? 怎么对其进行设置及添加?
### 11、交互方式
### 12、Ls 命令执行什么功能？ 可以带哪些参数，有什么区别？
### 13、ping （用于检测与目标的连通性）语法：ping ip地址
### 14、说说TCP/IP的七层模型
### 15、简述DNS进行域名解析的过程？
### 16、RAID 是什么?
### 17、数据排序?对数字进行排序？对月份排序？
### 18、Unix和Linux有什么区别？
### 19、bash手册
### 20、ifconfig命令
### 21、创建文件？创建目录？批量创建?
### 22、通过什么命令指定命令提示符?
### 23、cd （change directory：英文释义是改变目录）切换目录
### 24、如何查看当前主机名？如何修改？如何重启后生效？
### 25、touch （touch：创建文件）创建文件
### 26、cat （concatenate：显示或把多个文本文件连接起来）查看文件命令（可以快捷查看当前文件的内容）（不能快速定位到最后一页）
### 27、利用 ps 怎么显示所有的进程? 怎么利用 ps 查看指定进程的信息？
### 28、Linux系统缺省的运行级别？
### 29、用什么命令对一个文件的内容进行统计？(行号、单词数、字节数)




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
