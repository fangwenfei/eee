# Linux最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何优化 Linux系统（可以不说太具体）？

**1、** 不用root，添加普通用户，通过sudo授权管理

**2、** 更改默认的远程连接SSH服务端口及禁止root用户远程连接

**3、** 定时自动更新服务器时间

**4、** 配置国内yum源

**5、** 关闭selinux及iptables（iptables工作场景如果有外网IP一定要打开，高并发除外）

**6、** 调整文件描述符的数量

**7、** 精简开机启动服务（crond rsyslog network sshd）

**8、** 内核参数优化（/etc/sysctl.conf）

**9、** 更改字符集，支持中文，但建议还是用英文字符集，防止乱码

**10、** 锁定关键系统文件

**11、** 清空/etc/issue，去除系统及内核版本登录前的屏幕显示


### 2、ls （ls：list的缩写，查看列表）查看当前目录下的所有文件夹（ls 只列出文件名或目录名）

```
ls -a ;显示所有文件夹,隐藏文件也显示出来
ls -R ;连同子目录一起列出来
```


### 3、Grep 命令有什么用？ 如何忽略大小写？ 如何查找不含该串的行?

**答案：**

是一种强大的文本搜索工具，它能使用正则表达式搜索文本，并把匹 配的行打印出来。

grep [stringSTRING] filename grep [^string] filename


### 4、查看各类环境变量用什么命令?

**答案：**

**1、** 查看所有 env

**2、** 查看某个，如 home： env $HOME


### 5、Linux系统安装多个桌面环境有帮助吗？

通常，一个桌面环境，如KDE或Gnome，足以在没有问题的情况下运行。尽管系统允许从一个环境切换到另一个环境，但这对用户来说都是优先考虑的问题。有些程序在一个环境中工作而在另一个环境中无法工作，因此它也可以被视为选择使用哪个环境的一个因素。


### 6、简述raid0 raid1 raid5 三种工作模式的工作原理及特点

RAID，可以把硬盘整合成一个大磁盘，还可以在大磁盘上再分区，放数据

还有一个大功能，多块盘放在一起可以有冗余（备份）

RAID整合方式有很多，常用的：0 1 5 10

RAID 0，可以是一块盘和N个盘组合

其优点读写快，是RAID中最好的

缺点：没有冗余，一块坏了数据就全没有了

RAID 1，只能2块盘，盘的大小可以不一样，以小的为准

10G+10G只有10G，另一个做备份。它有100%的冗余，缺点：浪费资源，成本高

RAID 5 ，3块盘，容量计算10*（n-1）,损失一块盘

特点，读写性能一般，读还好一点，写不好

冗余从好到坏：RAID1 RAID10 RAID 5 RAID0

性能从好到坏：RAID0 RAID10 RAID5 RAID1

成本从低到高：RAID0 RAID5 RAID1 RAID10

单台服务器：很重要盘不多，系统盘，RAID1

数据库服务器：主库：RAID10 从库 RAID5RAID0（为了维护成本，RAID10）

WEB服务器，如果没有太多的数据的话，RAID5,RAID0（单盘）

有多台，监控、应用服务器，RAID0 RAID5

我们会根据数据的存储和访问的需求，去匹配对应的RAID级别


### 7、哪个文件包含了主机名和ip的映射关系?

/etc/hosts


### 8、复制文件
### 9、Shell 脚本是什么？
### 10、修改权限?
### 11、more （more：更多的意思）分页查看文件命令（不能快速定位到最后一页）
### 12、什么是 inode ？
### 13、发现一个病毒文件你删了他又自动创建怎么解决
### 14、移动文件用哪个命令？改名用哪个命令？
### 15、LVS、Nginx、HAproxy有什么区别？工作中你怎么选择？
### 16、随意写文件命令？怎么向屏幕输出带空格的字符串，比如”hello world”?
### 17、GNU项目的重要性是什么？
### 18、如何执行可以执行文件?
### 19、什么是LILO？
### 20、vim （VI IMproved：改进版视觉）改进版文本编辑器 （不管是文件查看还是文件编辑 按 Shift + 上或者下可以上下移动查看视角）
### 21、请写出下面 linux SecureCRT 命令行快捷键命令的功能？
### 22、如何停止一个进程?
### 23、tail（尾巴） 查看文件命令（看最后多少行）
### 24、启动shell
### 25、vim编辑器几种操作模式？基本操作?
### 26、列出已经安装的包？安装软件？更新软件？卸载?
### 27、mv（move单词缩写，移动功能，该文件名称功能）
### 28、什么是中间件？什么是jdk？
### 29、查看已有别名?建立属于自己的别名?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
