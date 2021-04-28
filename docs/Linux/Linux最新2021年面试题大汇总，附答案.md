# Linux最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、数据排序?对数字进行排序？对月份排序？

默认情况下，文件的数据展示是按照原顺序展示的。sort命令可以对文本文件中的数据进行排序。sort默认会把数据当成字符处理。

语法: sort destination

sort -n 所以排序数字时需要用-n，它的含义是说当前排序是的数字。

sort -M 比如月份Jan、Feb、Mar，如果希望它按照月份排序，加入-M就会按照月份的大小来排序。


### 2、开源的优势是什么？

开源允许你将软件（包括源代码）免费分发给任何感兴趣的人。然后，人们可以添加功能，甚至可以调试和更正源代码中的错误。它们甚至可以让它运行得更好，然后再次自由地重新分配这些增强的源代码。这最终使社区中的每个人受益。


### 3、怎样一页一页地查看一个大文件的内容呢？

**答案：**

通过管道将命令”cat file_name.txt” 和 ’more’ 连接在一起可以实现这个需要.

```
[root@localhost ~]# cat file_name.txt | more
```


### 4、删除文件?强制删除？递归删除?

语法: rm destination

-i 询问是否删除,-r 递归删除，-f 强制删除。

rm不能删除有文件的目录,需要递归删除。

```
?  xktest rm jdk
rm: jdk: is a directory
?  xktest rm -r jdk
?  xktest ls
```

rm -i 询问删除,建议大家平时删除多用 -i，确定一下再删除。

```
?  xktest touch tomcat
?  xktest rm -i tomcat
remove tomcat? n
```

rm -rf 会直接删除，没有警告信息，使用必须谨慎**。


### 5、rm（remove：移除的意思）删除文件，或文件夹

```
-f或--force 强制删除文件或目录。删除文件不包括文件夹的文件
-r或-R或--recursive 递归处理，将指定目录下的所有文件及子目录一并删除。 
-rf 强制删除文件夹及内容

rm 文件名 ;安全删除命令  （yes删除 no取消）
rm -rf 强制删除文件夹及内容
rm -rf* 删除当前目录下的所有内容。
rm -rf /* 删除Linux系统根目录下所有的内容。系统将完蛋。
```


### 6、查看整个文件？按照有文本显示行号？无文本显示行号？

语法 : cat destination

-n 显示行号，-b 有文本的显示行号。 （默认是不显示行号的)

```
?  apache cat -n tomcat
     1    text
     2    text
     3
     4    start
     5    stop
     6    restart
     7    end
?  apache cat -b tomcat
     1    text
     2    text
```

3 ? ?start

4 ? ?stop

5 ? ?restart

6 ? ?end



### 7、哪一个bash内置命令能够进行数学运算。

**答案：**

bash shell 的内置命令let 可以进行整型数的数学运算。

```
#! /bin/bash
…
…
let c=a+b
…
…
```


### 8、MySQL数据备份工具

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


### 9、使用哪一个命令可以查看自己文件系统的磁盘空间配额呢？

**答案：**

使用命令repquota 能够显示出一个文件系统的配额信息

【附】只有root用户才能够查看其它用户的配额。


### 10、实时抓取并显示当前系统中tcp 80端口的网络数据信息，请写出完整操作命令

tcpdump -nn tcp port 80


### 11、查找匹配数据？反向搜？
### 12、简述DNS进行域名解析的过程？
### 13、查看某端口是否被占用?
### 14、如何优化 Linux系统（可以不说太具体）？
### 15、查看组信息？如何创建组？删除组？
### 16、建立软链接(快捷方式)，以及硬链接的命令。
### 17、Linux系统安装多个桌面环境有帮助吗？
### 18、Linux 有哪些系统日志文件？
### 19、如何选择 Linux 操作系统版本?
### 20、bash手册
### 21、搜索文件用什么命令? 格式是怎么样的?
### 22、如果一个linux新手想要知道当前系统支持的所有命令的列表，他需要怎么做？
### 23、netstat 命令
### 24、yum install -y lrzsz 命令（实现win到Linux文件互相简单上传文件）
### 25、mv（move单词缩写，移动功能，该文件名称功能）
### 26、怎么对命令进行取别名？
### 27、Linux 的体系结构
### 28、绝对文件路径?相对文件路径？快捷方式？
### 29、随意写文件命令？怎么向屏幕输出带空格的字符串，比如”hello world”?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
