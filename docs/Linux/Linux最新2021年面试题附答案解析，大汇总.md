# Linux最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、free 命令 （显示系统内存）

```
#显示系统内存使用情况，包括物理内存、交互区内存(swap)和内核缓冲区内存。
-b 以Byte显示内存使用情况
-k 以kb为单位显示内存使用情况
-m 以mb为单位显示内存使用情况
-g 以gb为单位显示内存使用情况
-s<间隔秒数> 持续显示内存
-t 显示内存使用总合
```


### 2、Grep 命令有什么用？ 如何忽略大小写？ 如何查找不含该串的行?

**答案：**

是一种强大的文本搜索工具，它能使用正则表达式搜索文本，并把匹 配的行打印出来。

grep [stringSTRING] filename grep [^string] filename


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


### 4、如何把一个进程放到后台运行？

```
[root@iz2ze76ybn73dvwmdij06zz ~]# ./sleep.sh &
```

此时，进程并不能被Ctrl + c 中断。


### 5、Linux的基本组件是什么？

就像任何其他典型的操作系统一样，Linux拥有所有这些组件：内核，shell和GUI，系统实用程序和应用程序。Linux比其他操作系统更具优势的是每个方面都附带其他功能，所有代码都可以免费下载。


### 6、复制文件

语法: cp source target

如果target不存在则直接创建，如果存在，默认不会提醒你是否需要覆盖，需要加-i就会询问你是否覆盖,n否y是。

```
?  xktest cp a c
?  xktest cp -i a c
overwrite c? (y/n [n]) y
?  xktest ls
a c
```


### 7、如何用awk查看第2行倒数第3个字段?

```
?  apache awk 'NR==3{print $(NF-2)}' story
this
?  apache cat story
Long ago a lion and a bear saw a kid.
They sprang upon it at the same time.
The lion said to the bear, “I caught this kid first, and so this is mine.”
```

### 8、查看某端口是否被占用?

netstat -ntulp|grep 8080

```
[root@iz2ze76ybn73dvwmdij06zz ~]# netstat -ntulp|grep 8080
tcp        0      0 0.0.0.0:8080            0.0.0.0:*               LISTEN      4517/java
```

参数说明:

**1、** -t (tcp) 仅显示tcp相关选项

**2、** -u (udp)仅显示udp相关选项

**3、** -n 拒绝显示别名，能显示数字的全部转化为数字

**4、** -l 仅列出在Listen(监听)的服务状态

**5、** -p 显示建立相关链接的程序名


### 9、什么是硬链接和软链接？

**硬链接**：

由于 Linux 下的文件是通过索引节点(inode)来识别文件，硬链接可以认为是一个指针，指向文件索引节点的指针，系统并不为它重新分配 inode 。每添加一个一个硬链接，文件的链接数就加 1 。

**不足：**

**1、** 不可以在不同文件系统的文件间建立链接；

**2、** 只有超级用户才可以为目录创建硬链接。

**软链接**：

软链接克服了硬链接的不足，没有任何文件系统的限制，任何用户可以创建指向目录的符号链接。因而现在更为广泛使用，它具有更大的灵活性，甚至可以跨越不同机器、不同网络对文件进行链接。

**不足：**

因为链接文件包含有原文件的路径信息，所以当原文件从一个目录下移到其他目录中，再访问链接文件，系统就找不到了，而硬链接就没有这个缺陷，你想怎么移就怎么移；还有它要系统分配额外的空间用于建立新的索引节点和保存原文件的路径。

**实际场景下，基本是使用软链接**。

总结区别如下：

**1、** 硬链接不可以跨分区，软件链可以跨分区。

**2、** 硬链接指向一个 inode 节点，而软链接则是创建一个新的 inode 节点。

**3、** 删除硬链接文件，不会删除原文件，删除软链接文件，会把原文件删除。


### 10、查找匹配数据？反向搜？

语法: grep [options] pattern [file]

该命令会查找匹配执行模式的字符串的行，并输出。

```
?  apache grep start tomcat
start
restart
```

-v 反向搜

```
?  apache grep -v start tomcat
text
text
 stop
end
```

-n 显示行号

-c 显示匹配的行数


### 11、Shell 脚本是什么？
### 12、请问当用户反馈网站访问慢，你会如何处理？
### 13、复制文件用哪个命令？如果需要连同文件夹一块复制呢？如果需要有提示功能呢？
### 14、什么是中间件？什么是jdk？
### 15、如何写一条规则，拒绝某个ip访问本机8080端口?
### 16、开源的优势是什么？
### 17、bash shell 中的hash 命令有什么作用？
### 18、less （lese：较少的意思）分页查看文件命令（可以快速定位到最后一页）
### 19、du 和 df 的定义，以及区别？
### 20、Linux系统安装多个桌面环境有帮助吗？
### 21、请列出你了解的web服务器负载架构
### 22、Tomcat和Resin有什么区别，工作中你怎么选择？
### 23、mkdir （mkdir：创建目录） 创建目录
### 24、哪个文件包含了主机名和ip的映射关系?
### 25、如何将本地80 端口的请求转发到8080 端口，当前主机IP 为192.168.2.1
### 26、简单 Linux 文件系统？
### 27、什么是交换空间？
### 28、创建文件？创建目录？批量创建?
### 29、tail（尾巴） 查看文件命令（看最后多少行）




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
