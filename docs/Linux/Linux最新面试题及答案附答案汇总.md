# Linux最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是GUI？

图形用户界面（Graphical User Interface，简称 GUI，又称图形用户接口）是指采用图形方式显示的计算机操作用户界面。

图形用户界面是一种人与计算机通信的界面显示格式，允许用户使用鼠标等输入设备操纵屏幕上的图标或菜单选项，以选择命令、调用文件、启动程序或执行其它一些日常任务。与通过键盘输入文本或字符命令来完成例行任务的字符界面相比，图形用户界面有许多优点。


### 2、Windows和Linux的区别

**1、** Windows是微软开发的操作系统，民用操作系统，可用于娱乐、影音、上网。 Windows操作系统具有强大的日志记录系统和强大的桌面应用。好处是它可以帮我们实现非常多绚丽多彩的效果，可以非常方便去进行娱乐、影音、上网。

**2、** Linux的应用相对单纯很多，没有什么绚丽多彩的效果，因此Linux的性能是非常出色的，可以完全针对机器的配置有针对性的优化，

**3、** 简单来说Windows适合普通用户进行娱乐办公使用，Linux适合软件开发部署


### 3、Linux 有哪些系统日志文件？

比较重要的是 `/var/log/messages` 日志文件。

该日志文件是许多进程日志文件的汇总，从该文件可以看出任何入侵企图或成功的入侵。

> 另外，如果胖友的系统里有 ELK 日志集中收集，它也会被收集进去。



### 4、制表符自动补全？

有的时候文件的名字很长，很容易拼出错即使拼写对了也很浪费时间。

```
?  xktest ls java*
javaxiaokaxiu
```

比如操作javaxiaokaxiu这个文件时，输入到java的时候，然后按制表键(tab)就会补全成javaxiaokaxiu,是不是方便多了。


### 5、如果一个linux新手想要知道当前系统支持的所有命令的列表，他需要怎么做？

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


### 6、怎样查看一个linux命令的概要与用法？假设你在/bin目录中偶然看到一个你从没见过的的命令，怎样才能知道它的作用和用法呢？

**答案：**

使用命令whatis 可以先出显示出这个命令的用法简要，比如，你可以使用whatis zcat 去查看‘zcat’的介绍以及使用简要。

```
[root@localhost ~]# whatis zcat
zcat [gzip] (1) – compress or expand files
```


### 7、更改为北京时间命令

```
rm -rf /etc/localtime
ln -s /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
```


### 8、什么是BASH？
### 9、怎样一页一页地查看一个大文件的内容呢？
### 10、vi （VIsual：视觉）文本编辑器 类似win的记事本 （操作类似于地下的vim命令，看底下vim 的操作）
### 11、简单 Linux 文件系统？
### 12、每天晚上 12 点，打包站点目录/var/www/html 备份到/data 目录下（最好每次备份按时间生成不同的备份包）
### 13、Tomcat和Resin有什么区别，工作中你怎么选择？
### 14、搜索文件用什么命令? 格式是怎么样的?
### 15、Linux 开机启动过程？
### 16、Linux 性能调优都有哪几种方法？
### 17、把后台任务调到前台执行使用什么命令?把停下的后台任务在后台执行起来用什么命令?
### 18、你的系统目前有许多正在运行的任务，在不重启机器的条件下，有什么方法可以把所有正在运行的进程移除呢？
### 19、file （可查看文件类型）
### 20、Linux系统中病毒怎么解决
### 21、已知 apache 服务的访问日志按天记录在服务器本地目录/app/logs 下，由于磁盘空间紧张现在要求只能保留最近 7 天的访问日志！请问如何解决？请给出解决办法或配置或处理命令
### 22、使用什么命令查看用过的命令列表?
### 23、如何规划一台 Linux 主机，步骤是怎样？
### 24、cp（copy单词缩写，复制功能）
### 25、哪个命令专门用来查看后台任务?
### 26、top 命令
### 27、Linux的基本组件是什么？
### 28、less （lese：较少的意思）分页查看文件命令（可以快速定位到最后一页）
### 29、awk 详解。




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
