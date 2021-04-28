# Linux最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、文件描述符?每个描述符的含义?

```
[root@iz2ze76ybn73dvwmdij06zz xiaoka]# ls -l
总用量 0
-rw-r—r— 1 root root 0 4月  21 13:17 a
-rw-r—r— 1 root root 0 4月  21 13:17 b
-rw-r—r— 1 root root 0 4月  21 13:17 c
-rw-r—r— 1 root root 0 4月  21 13:17 d
-rw-r—r— 1 root root 0 4月  21 13:17 e
```

**文件类型:**

**1、** -代表文件

**2、** d代表目录

**3、** l代表链接

**4、** c代表字符型设备

**5、** b代表块设备

**6、** n代表网络设备

**访问权限符号:**

**1、** r代表对象是可读的

**2、** w代表对象是可写的

**3、** x代表对象是可执行的

若没有某种权限，在该权限位会出现单破折线。

**这3组权限分别对应对象的3个安全级别:**

**1、** 对象的属主

**2、** 对象的属组

**3、** 系统其他用户


### 2、查看整个文件？按照有文本显示行号？无文本显示行号？

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



### 3、当你需要给命令绑定一个宏或者按键的时候，应该怎么做呢？

**答案：**

**1、** 可以使用bind命令，bind可以很方便地在shell中实现宏或按键的绑定。

**2、** 在进行按键绑定的时候，我们需要先获取到绑定按键对应的字符序列。

**3、** 比如获取F12的字符序列获取方法如下：先按下Ctrl+V,然后按下F12 .我们就可以得到F12的字符序列 `^[[24~。`

接着使用bind进行绑定。

```
[root@localhost ~]# bind ‘”\e[24~":"date"'
```

注意：相同的按键在不同的终端或终端模拟器下可能会产生不同的字符序列。

【附】也可以使用showkey -a命令查看按键对应的字符序列。


### 4、查看已有别名?建立属于自己的别名?

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


### 5、统计ip访问情况，要求分析nginx访问日志，找出访问页面数量在前十位的ip

cat access.log | awk '{print $1}' | uniq -c | sort -rn | head -10


### 6、怎么清屏？怎么退出当前命令？怎么执行睡眠？怎么查看当前用户 id？查看指定帮助用什么命令？

**答案：**

**1、** 清屏： clear

**2、** 退出当前命令： ctrl+c 彻底退出

**3、** 执行睡眠 ： ctrl+z 挂起当前进程fg 恢复后台

**4、** 查看当前用户 id： ”id“：查看显示目前登陆账户的 uid 和 gid 及所属分组及用户名

**5、** 查看指定帮助： 如 man adduser 这个很全 而且有例子； adduser --help 这个告诉你一些常用参数； info adduesr；


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


### 8、tail（尾巴） 查看文件命令（看最后多少行）

```
tail -10 ;文件名 看最后10行
```


### 9、什么是中间件？什么是jdk？

中间件介绍：

中间件是一种独立的系统软件或服务程序，分布式应用软件借助这种软件在不同的技术之间共享资源

中间件位于客户机/ 服务器的操作系统之上，管理计算机资源和网络通讯

是连接两个独立应用程序或独立系统的软件。相连接的系统，即使它们具有不同的接口

但通过中间件相互之间仍能交换信息。执行中间件的一个关键途径是信息传递

通过中间件，应用程序可以工作于多平台或OS环境。

jdk：jdk是Java的开发工具包

它是一种用于构建在 Java 平台上发布的应用程序、applet 和组件的开发环境


### 10、如何用sed只打印第5行?删除第一行？替换字符串?

只打印第5行:

```
?  apache sed -n "5p" tomcat
stop
```

删除第一行:

```
[root@xiaoka ~]# cat story
Long ago a lion and a bear saw a kid.
They sprang upon it at the same time.
The lion said to the bear, “I caught this kid first, and so this is mine.”
[root@xiaoka ~]# cat story
They sprang upon it at the same time.
The lion said to the bear, “I caught this kid first, and so this is mine.”
```

替换字符串:

```
?  apache cat story
Long ago a lion and a bear saw a kid.
They sprang upon it at the same time.
The lion said to the bear, “I caught this kid first, and so this is mine.”
?  apache sed 's#this#that#g' story
Long ago a lion and a bear saw a kid.
They sprang upon it at the same time.
The lion said to the bear, “I caught that kid first, and so that is mine.”
```


### 11、哪个文件包含了主机名和ip的映射关系?
### 12、压缩工具有哪些?
### 13、讲述一下Tomcat8005、8009、8080三个端口的含义？
### 14、简述DNS进行域名解析的过程？
### 15、使用tcpdump监听主机为192.168.1.1，tcp端口为80的数据，同时将输出结果保存输出到tcpdump.log
### 16、什么是硬链接和软链接？
### 17、简述raid0 raid1 raid5 三种工作模式的工作原理及特点
### 18、随意写文件命令？怎么向屏幕输出带空格的字符串，比如”hello world”?
### 19、实时监测进程
### 20、ll （ll：list的缩写，查看列表详情）查看当前目录下的所有详细信息和文件夹（ll 结果是详细,有时间,是否可读写等信息）
### 21、简述raid0 raid1 raid5 三种工作模式的工作原理及特点
### 22、如何压缩文件？如何解压文件?
### 23、LVS、Nginx、HAproxy有什么区别？工作中你怎么选择？
### 24、Linux 的目录结构是怎样的？
### 25、打印文件第一行到第三行?
### 26、如何重置MySQL root密码？
### 27、Shell 脚本是什么？
### 28、Linux 使用的进程间通信方式？
### 29、cat （concatenate：显示或把多个文本文件连接起来）查看文件命令（可以快捷查看当前文件的内容）（不能快速定位到最后一页）




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
