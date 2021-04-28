# Linux最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、如何把一个进程放到后台运行？

```
[root@iz2ze76ybn73dvwmdij06zz ~]# ./sleep.sh &
```

此时，进程并不能被Ctrl + c 中断。


### 2、怎样一页一页地查看一个大文件的内容呢？

**答案：**

通过管道将命令”cat file_name.txt” 和 ’more’ 连接在一起可以实现这个需要.

```
[root@localhost ~]# cat file_name.txt | more
```


### 3、使用哪一个命令可以查看自己文件系统的磁盘空间配额呢？

**答案：**

使用命令repquota 能够显示出一个文件系统的配额信息

【附】只有root用户才能够查看其它用户的配额。


### 4、制表符自动补全？

有的时候文件的名字很长，很容易拼出错即使拼写对了也很浪费时间。

```
?  xktest ls java*
javaxiaokaxiu
```

比如操作javaxiaokaxiu这个文件时，输入到java的时候，然后按制表键(tab)就会补全成javaxiaokaxiu,是不是方便多了。


### 5、查看http的并发请求数与其TCP连接状态

netstat -n | awk '/^tcp/ {++S[$NF]} END {for(a in S) print a, S[a]}'

还有ulimit -n 查看linux系统打开最大的文件描述符，这里默认1024

不修改这里web服务器修改再大也没用，若要用就修改很几个办法，这里说其中一个：

修改/etc/security/limits.conf

soft nofile 10240

hard nofile 10240

重启后生效


### 6、查找命令的可执行文件是去哪查找的? 怎么对其进行设置及添加?

**答案：**

whereis [-bfmsu][-B <目录>...][-M <目录>...][-S <目录>...][文件...]

补充说明：whereis 指令会在特定目录中查找符合条件的文件。这些文件的烈性应属于原始代码，二进制文件，或是帮助文件。

**1、** -b ? ?只查找二进制文件。

**2、** -B <目录> 只在设置的目录下查找二进制文件。 -f 不显示文件名前的路径名称。

**3、** -m ? ?只查找说明文件。

**4、** -M <目录> 只在设置的目录下查找说明文件。 -s 只查找原始代码文件。

**5、** -S <目录> 只在设置的目录下查找原始代码文件。 -u 查找不包含指定类型的文件。

**6、** -h ich 指令会在 PATH 变量指定的路径中，搜索某个系统命令的位置，并且返回第一个搜索结果。

**7、** -n ?指定文件名长度，指定的长度必须大于或等于所有文件中最长的文件名。

**8、** -p ?与-n 参数相同，但此处的包括了文件的路径。 -w 指定输出时栏位的宽度。

**9、** -V ? ?显示版本信息


### 7、netstat 命令

```
#Linux netstat命令用于显示网络状态。
#利用netstat指令可让你得知整个Linux系统的网络情况。
#语法：
netstat [-acCeFghilMnNoprstuvVwx][-A<网络类型>][--ip]
```


### 8、vim编辑器几种操作模式？基本操作?

操作模式:

**1、** 普通模式

**2、** 插入模式

基础操作:

**1、** h:左移一个字符。

**2、** j:下移一行(文本中的下一行)。

**3、** k:上移一行(文本中的上一行)。

**4、** l:右移一个字符。

vim提供了一些能够提高移动速度的命令:

**1、** PageDown(或Ctrl+F):下翻一屏

**2、** PageUp(或Ctrl+B):上翻一屏。

**3、** G:移到缓冲区的最后一行。

**4、** num G:移动到缓冲区中的第num行。

**5、** gg:移到缓冲区的第一行。

退出vim:

**1、** q:如果未修改缓冲区数据，退出。

**2、** q!:取消所有对缓冲区数据的修改并退出。

**3、** w filename:将文件保存到另一个文件中。

**4、** wq:将缓冲区数据保存到文件中并退出。


### 9、如何中断一个进程?

在一个终端中， Ctrl + c

通过这个命令许多（不是全部）命令行程序都可以被中断。


### 10、哪一个bash内置命令能够进行数学运算。

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


### 11、more （more：更多的意思）分页查看文件命令（不能快速定位到最后一页）
### 12、简述raid0 raid1 raid5 三种工作模式的工作原理及特点
### 13、如何查找匹配的文件？基于文件属性？
### 14、Linux内核主要负责哪些功能
### 15、grep （grep ：正则表达式）正则表达式，用于字符串的搜索工作(模糊查询)。不懂可以先过
### 16、默认进程信息显示?
### 17、把后台任务调到前台执行使用什么命令?把停下的后台任务在后台执行起来用什么命令?
### 18、tail（尾巴） 查看文件命令（看最后多少行）
### 19、file （可查看文件类型）
### 20、查看整个文件？按照有文本显示行号？无文本显示行号？
### 21、实时监测进程
### 22、复制文件用哪个命令？如果需要连同文件夹一块复制呢？如果需要有提示功能呢？
### 23、重启linux
### 24、如何重置MySQL root密码？
### 25、讲述一下Tomcat8005、8009、8080三个端口的含义？
### 26、Linux 的体系结构
### 27、讲一下Keepalived的工作原理？
### 28、du 和 df 的定义，以及区别？
### 29、top 命令




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
