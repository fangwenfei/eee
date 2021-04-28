# Linux最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、rm（remove：移除的意思）删除文件，或文件夹

```
-f或--force 强制删除文件或目录。删除文件不包括文件夹的文件
-r或-R或--recursive 递归处理，将指定目录下的所有文件及子目录一并删除。 
-rf 强制删除文件夹及内容

rm 文件名 ;安全删除命令  （yes删除 no取消）
rm -rf 强制删除文件夹及内容
rm -rf* 删除当前目录下的所有内容。
rm -rf /* 删除Linux系统根目录下所有的内容。系统将完蛋。
```


### 2、Linux的基本组件是什么？

就像任何其他典型的操作系统一样，Linux拥有所有这些组件：内核，shell和GUI，系统实用程序和应用程序。Linux比其他操作系统更具优势的是每个方面都附带其他功能，所有代码都可以免费下载。


### 3、创建文件？创建目录？批量创建?

创建文件:touch 文件名

批量创建文件: touch 文件名 文件名 …

```
?  test touch a
?  test ls
a
?  test touch b c
?  test ls
a b c
```

创建目录：mkdir 目录名

批量创建目录: mkdir 目录名 目录名 …

```
?  test mkdir aa
?  test mkdir bb cc
?  test ls
a  aa b  bb c  cc
?  test ls -F
a   aa/ b   bb/ c   cc/
```


### 4、如何把一个进程放到后台运行？

```
[root@iz2ze76ybn73dvwmdij06zz ~]# ./sleep.sh &
```

此时，进程并不能被Ctrl + c 中断。


### 5、Windows和Linux的区别

**1、** Windows是微软开发的操作系统，民用操作系统，可用于娱乐、影音、上网。 Windows操作系统具有强大的日志记录系统和强大的桌面应用。好处是它可以帮我们实现非常多绚丽多彩的效果，可以非常方便去进行娱乐、影音、上网。

**2、** Linux的应用相对单纯很多，没有什么绚丽多彩的效果，因此Linux的性能是非常出色的，可以完全针对机器的配置有针对性的优化，

**3、** 简单来说Windows适合普通用户进行娱乐办公使用，Linux适合软件开发部署


### 6、开源的优势是什么？

开源允许你将软件（包括源代码）免费分发给任何感兴趣的人。然后，人们可以添加功能，甚至可以调试和更正源代码中的错误。它们甚至可以让它运行得更好，然后再次自由地重新分配这些增强的源代码。这最终使社区中的每个人受益。


### 7、默认进程信息显示?

ps它能输出运行在系统上的所有程序的许多信息。

默认情况下ps值显示运行在当前控制台下的当前用户的进程。

```
[root@iz2ze76ybn73dvwmdij06zz ~]# ps
  PID TTY          TIME CMD
10102 pts/0    00:00:00 bash
10131 pts/0    00:00:00 ps
```


### 8、查看时间命令：

```
date
```


### 9、pwd （print working directory：显示当前工作目录的绝对路径）

```
pwd 
显示当前的绝对路劲
```


### 10、什么叫CDN？

即内容分发网络

其目的是通过在现有的Internet中增加一层新的网络架构，将网站的内容发布到

最接近用户的网络边缘，使用户可就近取得所需的内容，提高用户访问网站的速度


### 11、什么是BASH？
### 12、源码安装通常的路子?
### 13、请写出下面 linux SecureCRT 命令行快捷键命令的功能？
### 14、什么是CLI？
### 15、登陆后你在的位置？
### 16、什么是 Linux 内核？
### 17、Linux系统中病毒怎么解决
### 18、用tcpdump嗅探80端口的访问看看谁最高
### 19、find （find：找到的意思）查找指定文件或目录
### 20、touch （touch：创建文件）创建文件
### 21、服务器开不了机怎么解决一步步的排查
### 22、bash shell 中的hash 命令有什么作用？
### 23、MySQL数据备份工具
### 24、Unix和Linux有什么区别？
### 25、yum install -y lrzsz 命令（实现win到Linux文件互相简单上传文件）
### 26、讲述一下LVS三种模式的工作过程？
### 27、使用哪一个命令可以查看自己文件系统的磁盘空间配额呢？
### 28、查看部分文件
### 29、验证网络可链接命令是什么？什么原理？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
