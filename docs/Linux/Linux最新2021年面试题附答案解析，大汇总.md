# Linux最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、file （可查看文件类型）

```
file 文件名
```


### 2、什么是BASH？

BASH是Bourne Again SHell的缩写。它由Steve Bourne编写，作为原始Bourne Shell（由/ bin / sh表示）的替代品。它结合了原始版本的Bourne Shell的所有功能，以及其他功能，使其更容易使用。从那以后，它已被改编为运行Linux的大多数系统的默认shell。


### 3、使用什么命令查看用过的命令列表?

**答案：**

history


### 4、如何查找匹配的文件？基于文件属性？

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


### 5、如何写一条规则，拒绝某个ip访问本机8080端口?

```
iptables -I INPUT -s ip -p tcp —dport 8080 -j REJECT
```


### 6、快速判断某个特定目录是否有超大文件？

默认情况，du会显示当前目录的所有文件、目录、子目录的磁盘使用情况。

```
[root@iz2ze76ybn73dvwmdij06zz src]# du
4    ./debug
4    ./kernels
12
```


### 7、free 命令 （显示系统内存）

```
#显示系统内存使用情况，包括物理内存、交互区内存(swap)和内核缓冲区内存。
-b 以Byte显示内存使用情况
-k 以kb为单位显示内存使用情况
-m 以mb为单位显示内存使用情况
-g 以gb为单位显示内存使用情况
-s<间隔秒数> 持续显示内存
-t 显示内存使用总合
```


### 8、more （more：更多的意思）分页查看文件命令（不能快速定位到最后一页）

```
回车：向下n行，需要定义，默认为1行。
空格键：向下滚动一屏或Ctrl+F
B：返回上一层或Ctrl+B
q：退出more
```


### 9、cd （change directory：英文释义是改变目录）切换目录

```
cd ../ ;跳到上级目录
cd /opt ;不管现在到那直接跳到指定的opt文件夹中
cd ~ ;切换当前用户的家目录。root用户的家目录就是root目录。
```


### 10、哪个命令专门用来查看后台任务?

**答案：**

job -l


### 11、Linux 使用的进程间通信方式？
### 12、du 和 df 的定义，以及区别？
### 13、RAID 是什么?
### 14、打印文件第一行到第三行?
### 15、什么叫CDN？
### 16、Linux系统缺省的运行级别？
### 17、find （find：找到的意思）查找指定文件或目录
### 18、什么叫网站灰度发布？
### 19、如何查看当前主机名？如何修改？如何重启后生效？
### 20、Windows和Linux的区别
### 21、你的系统目前有许多正在运行的任务，在不重启机器的条件下，有什么方法可以把所有正在运行的进程移除呢？
### 22、查看当前谁在使用该主机用什么命令? 查找自己所在的终端信息用什么命令?
### 23、简单 Linux 文件系统？
### 24、clear 清屏命令。（强迫症患者使用）
### 25、文件描述符?每个描述符的含义?
### 26、如何查看目录中的文件？区分哪些是文件哪些是目录?递归查?
### 27、awk 详解。
### 28、如何用sed只打印第5行?删除第一行？替换字符串?
### 29、怎样查看一个linux命令的概要与用法？假设你在/bin目录中偶然看到一个你从没见过的的命令，怎样才能知道它的作用和用法呢？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
