# Linux最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、查看当前谁在使用该主机用什么命令? 查找自己所在的终端信息用什么命令?

**答案：**

查找自己所在的终端信息：who am i

查看当前谁在使用该主机：who


### 2、通过什么命令指定命令提示符?

**答案：**

**1、** \u：显示当前用户账号

**2、** \h：显示当前主机名

**3、** \W：只显示当前路径最后一个目录

**4、** \w：显示当前绝对路径（当前用户目录会以~代替）

**5、** $PWD：显示当前全路径

**6、** $$：显示命令行’$$'或者’#'符号

**7、** #：下达的第几个命令

**8、** \d：代表日期，格式为week day month date，例如："MonAug1"

**9、** \t：显示时间为24小时格式，如：HH：MM：SS

**10、** \T：显示时间为12小时格式

**11、** \A：显示时间为24小时格式：HH：MM

**12、** \v：BASH的版本信息 如export PS1=’[\u@\h\w#]$‘


### 3、说说TCP/IP的七层模型

**应用层 (Application)：**

网络服务与最终用户的一个接口。

协议有：HTTP FTP TFTP SMTP SNMP DNS TELNET HTTPS POP3 DHCP

**表示层（Presentation Layer）：**

数据的表示、安全、压缩。（在五层模型里面已经合并到了应用层）

格式有，JPEG、ASCll、DECOIC、加密格式等

**会话层（Session Layer）：**

建立、管理、终止会话。（在五层模型里面已经合并到了应用层）

对应主机进程，指本地主机与远程主机正在进行的会话

**传输层 (Transport)：**

定义传输数据的协议端口号，以及流控和差错校验。

协议有：TCP UDP，数据包一旦离开网卡即进入网络传输层

**网络层 (Network)：**

进行逻辑地址寻址，实现不同网络之间的路径选择。

协议有：ICMP IGMP IP（IPV4 IPV6） ARP RARP

**数据链路层 (Link)：**

建立逻辑连接、进行硬件地址寻址、差错校验等功能。（由底层网络定义协议）

将比特组合成字节进而组合成帧，用MAC地址访问介质，错误发现但不能纠正

**物理层（Physical Layer）：**

**1、** 是计算机网络OSI模型中最低的一层

**2、** 物理层规定:为传输数据所需要的物理链路创建、维持、拆除

**3、** 而提供具有机械的，电子的，功能的和规范的特性

**4、** 简单的说，物理层确保原始的数据可在各种物理媒体上传输。局域网与广域网皆属第1、2层

**5、** 物理层是OSI的第一层，它虽然处于最底层，却是整个开放系统的基础

**6、** 物理层为设备之间的数据通信提供传输媒体及互连设备，为数据传输提供可靠的环境

**7、** 如果您想要用尽量少的词来记住这个第一层，那就是“信号和介质”


### 4、如果一个linux新手想要知道当前系统支持的所有命令的列表，他需要怎么做？

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


### 5、如何停止一个进程?

kill命令被用来给程序发送信号。如果没有指定信号，默认发送TERM(终止）信号。

语法 : kill [-signal] PID …

![80_4.png][80_4.png]image-20200421141556974


### 6、现在给你三百台服务器，你怎么对他们进行管理？

管理3百台服务器的方式：

**1、** 设定跳板机，使用统一账号登录，便于安全与登录的考量。

**2、** 使用salt、ansiable、puppet进行系统的统一调度与配置的统一管理。

**3、** 建立简单的服务器的系统、配置、应用的cmdb信息管理。便于查阅每台服务器上的各种信息记录。


### 7、ll （ll：list的缩写，查看列表详情）查看当前目录下的所有详细信息和文件夹（ll 结果是详细,有时间,是否可读写等信息）

```
ll -a ;显示所有文件,隐藏文件也显示出来
ll -R ;连同子目录内容一起列出来
ll -h ;友好展示详情信息,可以看大小
ll -al ;即能显示隐藏文件又能显示详细列表。
```


### 8、目录创建用什么命令？创建文件用什么命令？复制文件用什么命令？

**答案：**

**1、** 创建目录： mkdir

**2、** 创建文件：典型的如 touch，vi 也可以创建文件，其实只要向一个不存在的文件输出，都会创建文件

**3、** 复制文件： cp 7、文件权限修改用什么命令？格式是怎么样的？

**4、** 文件权限修改： chmod

**格式如下：**

**1、** chmodu+xfile给file的属主增加执行权限 chmod 751 file 给 file 的属主分配读、写、执行(7)的权限，给 file 的所在组分配读、执行(5)的权限，给其他用户分配执行(1)的权限

**2、** chmodu=rwx,g=rx,o=xfile上例的另一种形式 chmod =r file 为所有用户分配读权限

**3、** chmod444file同上例 chmod a-wx,a+r file同上例

**4、** $ chmod -R u+r directory 递归地给 directory 目录下所有文件和子目录的属主分配读的权限


### 9、查看文件内容有哪些命令可以使用？

**答案：**

**1、** vi 文件名 #编辑方式查看，可修改

**2、** cat 文件名 #显示全部文件内容

**3、** more 文件名 #分页显示文件内容

**4、** less 文件名 #与 more 相似，更好的是可以往前翻页

**5、** tail 文件名 #仅查看尾部，还可以指定行数

**6、** head 文件名 #仅查看头部,还可以指定行数


### 10、简述DNS进行域名解析的过程？

用户要访问www.baidu.com，会先找本机的host文件，再找本地设置的DNS服务器，如果也没有的话，就去网络中找根服务器，根服务器反馈结果，说只能提供一级域名服务器.cn，就去找一级域名服务器，一级域名服务器说只能提供二级域名服务器.com.cn,就去找二级域名服务器，二级域服务器只能提供三级域名服务器.baidu.com.cn，就去找三级域名服务器，三级域名服务器正好有这个网站www.baidu.com，然后发给请求的服务器，保存一份之后，再发给客户端


### 11、查看已有别名?建立属于自己的别名?
### 12、查看组信息？如何创建组？删除组？
### 13、随意写文件命令？怎么向屏幕输出带空格的字符串，比如”hello world”?
### 14、Linux的基本组件是什么？
### 15、LVS、Nginx、HAproxy有什么区别？工作中你怎么选择？
### 16、cd （change directory：英文释义是改变目录）切换目录
### 17、创建文件？创建目录？批量创建?
### 18、bash shell 中的hash 命令有什么作用？
### 19、如何优化 Linux系统（可以不说太具体）？
### 20、Ls 命令执行什么功能？ 可以带哪些参数，有什么区别？
### 21、如何查看目录中的文件？区分哪些是文件哪些是目录?递归查?
### 22、关机linux
### 23、lvs/nginx/haproxy优缺点
### 24、touch （touch：创建文件）创建文件
### 25、查看部分文件
### 26、修改权限?
### 27、哪个文件包含了主机名和ip的映射关系?
### 28、什么是环境变量？
### 29、查看设备还有多少磁盘空间?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
