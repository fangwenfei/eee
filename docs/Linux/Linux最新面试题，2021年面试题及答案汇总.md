# Linux最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何查找匹配的文件？基于文件属性？

find 程序能基于各种各样的属性，搜索一个给 定目录(以及它的子目录)，来查找文件。

find 命令的最简单使用是，搜索一个或多个目录。

普通查找，按照name查找:

```
[root@iz2ze76ybn73dvwmdij06zz ~]# find -name xiaoka
./xiaoka
```

文件类型查找:

比如,输出我们的家目录文件数量

```
[root@iz2ze76ybn73dvwmdij06zz ~]# find ~|wc -l
17130
```

根据文件类型查:

```
[root@iz2ze76ybn73dvwmdij06zz ~]#  find ~ -type d | wc -l
7340
```

find支持的类型: b 块设备文件、 c 字符设备文件、d 目录、f 普通文件、l 符号链接


### 2、终端是哪个文件夹下的哪个文件？黑洞文件是哪个文件夹下的哪个命令？

**答案：**

终端 ?/dev/tty

黑洞文件 ?/dev/null


### 3、快速判断某个特定目录是否有超大文件？

默认情况，du会显示当前目录的所有文件、目录、子目录的磁盘使用情况。

```
[root@iz2ze76ybn73dvwmdij06zz src]# du
4    ./debug
4    ./kernels
12
```


### 4、vim （VI IMproved：改进版视觉）改进版文本编辑器 （不管是文件查看还是文件编辑 按 Shift + 上或者下可以上下移动查看视角）

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


### 5、如何用sed只打印第5行?删除第一行？替换字符串?

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


### 6、RabbitMQ是什么东西？

RabbitMQ也就是消息队列中间件，消息中间件是在消息的传息过程中保存消息的容器

消息中间件再将消息从它的源中到它的目标中标时充当中间人的作用

队列的主要目的是提供路由并保证消息的传递；如果发送消息时接收者不可用

消息队列不会保留消息，直到可以成功地传递为止，当然，消息队列保存消息也是有期限地


### 7、请列出你了解的web服务器负载架构

Nginx

Haproxy

Keepalived

LVS


### 8、一台 Linux 系统初始化环境后需要做一些什么安全工作？

添加普通用户登陆，禁止 root 用户登陆，更改 SSH 端口号。

> 修改 SSH 端口不一定绝对哈。当然，如果要暴露在外网，建议改下。


**1、** 服务器使用密钥登陆，禁止密码登陆。

**2、** 开启防火墙，关闭 SElinux ，根据业务需求设置相应的防火墙规则。

**3、** 装 fail2ban 这种防止 SSH 暴力破击的软件。

**4、** 设置只允许公司办公网出口 IP 能登陆服务器(看公司实际需要)

> 也可以安装 VPN 等软件，只允许连接 VPN 到服务器上。


**1、** 修改历史命令记录的条数为 10 条。

**2、** 只允许有需要的服务器可以访问外网，其它全部禁止。

**3、** 做好软件层面的防护。

**4、** 设置 nginx_waf 模块防止 SQL 注入。

**5、** 把 Web 服务使用 www 用户启动，更改网站目录的所有者和所属组为 www


### 9、启动shell

GNU bash shell能提供对linux 系统的交互式访问。作为普通程序运行，通常在用户登陆终端时启动。登录时系统启动的shell依赖与用户账户的配置。


### 10、文件描述符?每个描述符的含义?

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


### 11、如何规划一台 Linux 主机，步骤是怎样？
### 12、如何选择 Linux 操作系统版本?
### 13、查看整个文件？按照有文本显示行号？无文本显示行号？
### 14、如何重置MySQL root密码？
### 15、怎样查看一个linux命令的概要与用法？假设你在/bin目录中偶然看到一个你从没见过的的命令，怎样才能知道它的作用和用法呢？
### 16、touch （touch：创建文件）创建文件
### 17、使用什么命令查看用过的命令列表?
### 18、哪一个bash内置命令能够进行数学运算。
### 19、LVS、Nginx、HAproxy有什么区别？工作中你怎么选择？
### 20、创建文件？创建目录？批量创建?
### 21、数据排序?对数字进行排序？对月份排序？
### 22、修改权限?
### 23、Linux系统安装多个桌面环境有帮助吗？
### 24、什么是交换空间？
### 25、统计ip访问情况，要求分析nginx访问日志，找出访问页面数量在前十位的ip
### 26、什么是LILO？
### 27、开源的优势是什么？
### 28、查看某端口是否被占用?
### 29、默认进程信息显示?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
