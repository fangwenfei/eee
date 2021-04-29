# Linux最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、通过什么命令查找执行命令?

**答案：**

**1、** which 只能查可执行文件

**2、** whereis 只能查二进制文件、说明文档，源文件等


### 2、使用哪一个命令可以查看自己文件系统的磁盘空间配额呢？

**答案：**

使用命令repquota 能够显示出一个文件系统的配额信息

【附】只有root用户才能够查看其它用户的配额。


### 3、bash shell 中的hash 命令有什么作用？

**答案：**

linux命令’hash’管理着一个内置的哈希表，记录了已执行过的命令的完整路径, 用该命令可以打印出你所使用过的命令以及执行的次数。

```
[root@localhost ~]# hash

hits command

2 /bin/ls

2 /bin/su
```


### 4、ls （ls：list的缩写，查看列表）查看当前目录下的所有文件夹（ls 只列出文件名或目录名）

```
ls -a ;显示所有文件夹,隐藏文件也显示出来
ls -R ;连同子目录一起列出来
```


### 5、每天晚上 12 点，打包站点目录/var/www/html 备份到/data 目录下（最好每次备份按时间生成不同的备份包）

```
# cat a.sh 
#/bin/bash
cd /var/www/ && /bin/tar zcf /data/html-`date +%m-%d%H`.tar.gz html/
# crontab –e
00 00 * * * /bin/sh /root/a.sh
```



### 6、快速判断某个特定目录是否有超大文件？

默认情况，du会显示当前目录的所有文件、目录、子目录的磁盘使用情况。

```
[root@iz2ze76ybn73dvwmdij06zz src]# du
4    ./debug
4    ./kernels
12
```


### 7、如何中断一个进程?

在一个终端中， Ctrl + c

通过这个命令许多（不是全部）命令行程序都可以被中断。


### 8、如何将本地80 端口的请求转发到8080 端口，当前主机IP 为192.168.2.1

iptables -A PREROUTING -d 192.168.2.1 -p tcp -m tcp -dport 80 -j DNAT-to-destination 192.168.2.1:8080


### 9、列出已经安装的包？安装软件？更新软件？卸载?

列出已经安装的包: yum list installed

安装软件: yum install package_name

更新软件: yum update package_name

卸载软件:yum remove package_name //只删除软件包保留数据文件和配置文件

如果不希望保留数据文件和配置文件

可以执行:yum erase package_name


### 10、yum install -y lrzsz 命令（实现win到Linux文件互相简单上传文件）

```
#（实际上就是在Linux系统中下载了一个插件）下了了此安装包后就可以实现win系统到linux之间拉文件拉文件
#等待下载完了就可以输入：

rz  从win系统中选择文件上传到Linux系统中

sz  文件名 选择Linux系统的文件复制到win系统中
```


### 11、什么是链接文件？
### 12、绝对文件路径?相对文件路径？快捷方式？
### 13、查看整个文件？按照有文本显示行号？无文本显示行号？
### 14、使用tcpdump监听主机为192.168.1.1，tcp端口为80的数据，同时将输出结果保存输出到tcpdump.log
### 15、什么是中间件？什么是jdk？
### 16、top 命令
### 17、awk 详解。
### 18、怎么清屏？怎么退出当前命令？怎么执行睡眠？怎么查看当前用户 id？查看指定帮助用什么命令？
### 19、tail（尾巴） 查看文件命令（看最后多少行）
### 20、Linux 的体系结构
### 21、Ls 命令执行什么功能？ 可以带哪些参数，有什么区别？
### 22、如何查找匹配的文件？基于文件属性？
### 23、如何用sed只打印第5行?删除第一行？替换字符串?
### 24、登陆后你在的位置？
### 25、Linux 性能调优都有哪几种方法？
### 26、你常用的Nginx模块，用来做什么
### 27、已知 apache 服务的访问日志按天记录在服务器本地目录/app/logs 下，由于磁盘空间紧张现在要求只能保留最近 7 天的访问日志！请问如何解决？请给出解决办法或配置或处理命令
### 28、实时抓取并显示当前系统中tcp 80端口的网络数据信息，请写出完整操作命令
### 29、什么是网站数据库注入？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
