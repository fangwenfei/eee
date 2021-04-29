# Linux最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、查看组信息？如何创建组？删除组？

```
[root@iz2ze76ybn73dvwmdij06zz ~]# cat /etc/group
root:x:0:
bin:x:1:
daemon:x:2:
sys:x:3:
adm:x:4:
tty:x:5:
disk:x:6:
[root@iz2ze76ybn73dvwmdij06zz ~]# groupadd java //创建组
[root@iz2ze76ybn73dvwmdij06zz ~]# groupdel java //创建组
```


### 2、什么是 Linux 内核？

Linux 系统的核心是内核。内核控制着计算机系统上的所有硬件和软件，在必要时分配硬件，并根据需要执行软件。

**1、** 系统内存管理

**2、** 应用程序管理

**3、** 硬件设备管理

**4、** 文件系统管理


### 3、随意写文件命令？怎么向屏幕输出带空格的字符串，比如”hello world”?

**答案：**

写文件命令：vi

向屏幕输出带空格的字符串:echo hello world


### 4、验证网络可链接命令是什么？什么原理？

ping。这个 ping 命令发送一个特殊的网络数据包(叫做 IMCP ECHO REQUEST)到一台指定的主机。大多数接收这个包的网络设备将会回复它，来允许网络连接验证。

![80_5.png][80_5.png]image-20200421142307602

一旦启动，ping会持续在特定时间（默认1秒）发送数据包。


### 5、如何规划一台 Linux 主机，步骤是怎样？

确定机器是做什么用的，比如是做 WEB 、DB、还是游戏服务器。

> 不同的用途，机器的配置会有所不同。


**1、** 确定好之后，就要定系统需要怎么安装，默认安装哪些系统、分区怎么做。

**2、** 需要优化系统的哪些参数，需要创建哪些用户等等的。


### 6、cat （concatenate：显示或把多个文本文件连接起来）查看文件命令（可以快捷查看当前文件的内容）（不能快速定位到最后一页）

```
cat lj.log ;快捷查看文件命令 
Ctrl + c ;暂停显示文件
Ctrl + d ;退出查看文件命令
```


### 7、vim （VI IMproved：改进版视觉）改进版文本编辑器 （不管是文件查看还是文件编辑 按 Shift + 上或者下可以上下移动查看视角）

输入”vim 文件名” 打开文件，刚刚时是”一般模式”。

**1、** ?一般模式：可以浏览文件内容，可以进行文本快捷操作。如单行复制，多行复制，单行删除，多行删除，（退出）等。

**2、** ?插入模式：可以编辑文件内容。

**3、** ?底行模式：可以进行强制退出操作,不保存 ? :q!

可以进行保存并退出操作 ? :wq

按下”i”或”a”或”o”键，从”一般模式”，进入”插入模式（编辑模式）”。

在编辑模式下按”Esc” 即可到一般模式

在一般模式下按”:”，冒号进入底行模式。

在一般模式下的快捷键

```
dd ;删除一整行
X ;向前删除  等同于windowns系统中的删除键
x ;向后删除和大写x相反方向
Ctrl + f ;向后看一页
Ctrl + b ;向前看一页
u ;撤销上一步操作
/word ;向下查找word关键字  输入:n查找下一个,N查找上一个（不管是哪个查找都是全局查找 只不过n的方向相反）
?log ;向上查找log关键字  输入:n查找上一个,N查找下一个
:1,90s/Redis/Redis/g ;把1-90行的Redis替换为Redis。语法n1,n2s/原关键字/新关键字/g，n1代表其实行,n2代表结尾行,g是必须要的
:0 ;光标移动到第一行
:$ ;光标移动到最后一行
:300 ;光标移动到300行,输入多少数字移动到多少行
:w  ;保存
:w! ;强制保存
:q  ;退出
:q! ;强制退出
5dd ;删除后面5行,打一个参数为自己填写
5x ;删除此光标后面5个字符
d1G ;删除此光标之前的所有
d0 ;从光标当前位置删除到此行的第一个位置
yy ;复制
p ;在光标的下面进行粘贴
P ;在光标的上门进行粘贴
```


### 8、如何查看命令历史记录?

history 命令可以展示你用的命令的历史记录。

```
 4463  touch service1 service2
 4464  ls
 4465  tar -cvf service.tar service1 service2
 4466  tar -tf service.tar
 4467  tar zxvf service
 4468  tar zxvf service.t
 4469  tar zxvf service.tar
 4470  ls
 4471  tar -zxvf  service.tar
 4472  ls
```


### 9、什么是BASH？

BASH是Bourne Again SHell的缩写。它由Steve Bourne编写，作为原始Bourne Shell（由/ bin / sh表示）的替代品。它结合了原始版本的Bourne Shell的所有功能，以及其他功能，使其更容易使用。从那以后，它已被改编为运行Linux的大多数系统的默认shell。


### 10、clear 清屏命令。（强迫症患者使用）

```
kill 命令用来中止一个进程。（要配合ps命令使用，配合pid关闭进程）
（ps类似于打开任务管理器，kill类似于关闭进程）
kill -5 进程的PID ;推荐,和平关闭进程
kill -9 PID ;不推荐,强制杀死进程
```


### 11、制表符自动补全？
### 12、netstat 命令
### 13、删除文件?强制删除？递归删除?
### 14、什么是链接文件？
### 15、重新命名文件？移动文件？
### 16、使用什么命令查看用过的命令列表?
### 17、讲一下Keepalived的工作原理？
### 18、把后台任务调到前台执行使用什么命令?把停下的后台任务在后台执行起来用什么命令?
### 19、实时抓取并显示当前系统中tcp 80端口的网络数据信息，请写出完整操作命令
### 20、Linux系统缺省的运行级别？
### 21、通过什么命令指定命令提示符?
### 22、用tcpdump嗅探80端口的访问看看谁最高
### 23、more （more：更多的意思）分页查看文件命令（不能快速定位到最后一页）
### 24、怎么清屏？怎么退出当前命令？怎么执行睡眠？怎么查看当前用户 id？查看指定帮助用什么命令？
### 25、grep （grep ：正则表达式）正则表达式，用于字符串的搜索工作(模糊查询)。不懂可以先过
### 26、什么是CLI？
### 27、8.迷路，我的当前位置在哪？
### 28、列出已经安装的包？安装软件？更新软件？卸载?
### 29、你的系统目前有许多正在运行的任务，在不重启机器的条件下，有什么方法可以把所有正在运行的进程移除呢？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
