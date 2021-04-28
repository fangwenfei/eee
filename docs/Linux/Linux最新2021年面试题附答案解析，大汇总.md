# Linux最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、现在给你三百台服务器，你怎么对他们进行管理？

管理3百台服务器的方式：

**1、** 设定跳板机，使用统一账号登录，便于安全与登录的考量。

**2、** 使用salt、ansiable、puppet进行系统的统一调度与配置的统一管理。

**3、** 建立简单的服务器的系统、配置、应用的cmdb信息管理。便于查阅每台服务器上的各种信息记录。


### 2、制表符自动补全？

有的时候文件的名字很长，很容易拼出错即使拼写对了也很浪费时间。

```
?  xktest ls java*
javaxiaokaxiu
```

比如操作javaxiaokaxiu这个文件时，输入到java的时候，然后按制表键(tab)就会补全成javaxiaokaxiu,是不是方便多了。


### 3、删除文件?强制删除？递归删除?

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


### 4、复制文件

语法: cp source target

如果target不存在则直接创建，如果存在，默认不会提醒你是否需要覆盖，需要加-i就会询问你是否覆盖,n否y是。

```
?  xktest cp a c
?  xktest cp -i a c
overwrite c? (y/n [n]) y
?  xktest ls
a c
```


### 5、怎样一页一页地查看一个大文件的内容呢？

**答案：**

通过管道将命令”cat file_name.txt” 和 ’more’ 连接在一起可以实现这个需要.

```
[root@localhost ~]# cat file_name.txt | more
```


### 6、账户默认信息？添加账户？删除用户？

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


### 7、Squid、Varinsh和Nginx有什么区别，工作中你怎么选择？

Squid、Varinsh和Nginx都是代理服务器

什么是代理服务器：

能当替用户去访问公网，并且能把访问到的数据缓存到服务器本地，等用户下次再访问相同的资

源的时候，代理服务器直接从本地回应给用户，当本地没有的时候，我代替你去访问公网，我接

收你的请求，我先在我自已的本地缓存找，如果我本地缓存有，我直接从我本地的缓存里回复你

如果我在我本地没有找到你要访问的缓存的数据，那么代理服务器就会代替你去访问公网

区别：

1）Nginx本来是反向代理/web服务器，用了插件可以做做这个副业

但是本身不支持特性挺多，只能缓存静态文件

2）从这些功能上。varnish和squid是专业的cache服务，而nginx这些是第三方模块完成

3）varnish本身的技术上优势要高于squid，它采用了可视化页面缓存技术

在内存的利用上，Varnish比Squid具有优势，性能要比Squid高。

还有强大的通过Varnish管理端口，可以使用正则表达式快速、批量地清除部分缓存

它是内存缓存，速度一流，但是内存缓存也限制了其容量，缓存页面和图片一般是挺好的

4）squid的优势在于完整的庞大的cache技术资料，和很多的应用生产环境

工作中选择：

要做cache服务的话，我们肯定是要选择专业的cache服务，优先选择squid或者varnish。


### 8、Linux 中进程有哪几种状态？在 ps 显示出来的信息中，分别用什么符号表示的？

**答案：**

**1、** 不可中断状态：进程处于睡眠状态，但是此刻进程是不可中断的。不可中断， 指进程不响应异步信号。

**2、** 暂停状态/跟踪状态：向进程发送一个 SIGSTOP 信号，它就会因响应该信号 而进入 TASK_STOPPED 状态;当进程正在被跟踪时，它处于 TASK_TRACED 这个特殊的状态。

正被跟踪”指的是进程暂停下来，等待跟踪它的进程对它进行操作。

**3、** 就绪状态：在 run_queue 队列里的状态

**4、** 运行状态：在 run_queue 队列里的状态

**5、** 可中断睡眠状态：处于这个状态的进程因为等待某某事件的发生（比如等待 socket 连接、等待信号量），而被挂起

**6、** zombie 状态（僵尸）：父亲没有通过 wait 系列的系统调用会顺便将子进程的尸体（task_struct）也释放掉

**7、** 退出状态

> D 不可中断 Uninterruptible（usually IO）

R 正在运行，或在队列中的进程

S 处于休眠状态

T 停止或被追踪

Z 僵尸进程

W 进入内存交换（从内核 2.6 开始无效）

X 死掉的进程



### 9、查看http的并发请求数与其TCP连接状态

netstat -n | awk '/^tcp/ {++S[$NF]} END {for(a in S) print a, S[a]}'

还有ulimit -n 查看linux系统打开最大的文件描述符，这里默认1024

不修改这里web服务器修改再大也没用，若要用就修改很几个办法，这里说其中一个：

修改/etc/security/limits.conf

soft nofile 10240

hard nofile 10240

重启后生效


### 10、如果你的助手想要打印出当前的目录栈，你会建议他怎么做？

**答案：**

使用Linux 命令dirs可以将当前的目录栈打印出来。

```
[root@localhost ~]# dirs
/usr/share/X11
```

【附】：目录栈通过pushd popd 来操作。


### 11、如何用awk查看第2行倒数第3个字段?
### 12、怎么使一个命令在后台运行?
### 13、你的系统目前有许多正在运行的任务，在不重启机器的条件下，有什么方法可以把所有正在运行的进程移除呢？
### 14、搜索文件用什么命令? 格式是怎么样的?
### 15、绝对文件路径?相对文件路径？快捷方式？
### 16、更改为北京时间命令
### 17、启动shell
### 18、查看组信息？如何创建组？删除组？
### 19、什么叫 CC 攻击？什么叫 DDOS 攻击？
### 20、bash手册
### 21、使用什么命令查看网络是否连通?
### 22、你对现在运维工程师的理解和以及对其工作的认识
### 23、du 和 df 的定义，以及区别？
### 24、Linux 开机启动过程？
### 25、如何执行可以执行文件?
### 26、把后台任务调到前台执行使用什么命令?把停下的后台任务在后台执行起来用什么命令?
### 27、什么是root帐户
### 28、Tomcat和Resin有什么区别，工作中你怎么选择？
### 29、快速判断某个特定目录是否有超大文件？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
