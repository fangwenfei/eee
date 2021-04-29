# Linux最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、你对现在运维工程师的理解和以及对其工作的认识

运维工程师在公司当中责任重大，需要保证时刻为公司及客户提供最高、最快、最稳定、最安全的服务

运维工程师的一个小小的失误，很有可能会对公司及客户造成重大损失

因此运维工程师的工作需要严谨及富有创新精神


### 2、tar （解压 压缩 命令）

```
常用的组合命令：
-z 是否需要用gzip压缩。
-c 建立一个压缩文件的参数指令(create) –压缩
-x 解开一个压缩文件的参数指令(extract) –解压  
-v 压缩的过程中显示文件(verbose)
-f 使用档名，在f之后要立即接档中(file)
常用解压参数组合：zxvf
常用压缩参数组合：zcvf 

解压命令：
tar -zxvf Redis-3.2.8.tar.gz ；解压到当前文件夹
tar -zxvf Redis-3.2.8.tar.gz -C /opt/java/ ；解压到指定目录

压缩命令：（注意 语法有点反了，我反正每次都搞反）
tar -zcvf Redis-3.2.8.tar.gz  Redis-3.2.8/  ;语法 tar -zcvf  压缩后的名称  要压缩的文件
tar -zcvf 压缩后的文件（可指定目录）  要压缩的文件（可指定目录）
```


### 3、查看http的并发请求数与其TCP连接状态

netstat -n | awk '/^tcp/ {++S[$NF]} END {for(a in S) print a, S[a]}'

还有ulimit -n 查看linux系统打开最大的文件描述符，这里默认1024

不修改这里web服务器修改再大也没用，若要用就修改很几个办法，这里说其中一个：

修改/etc/security/limits.conf

soft nofile 10240

hard nofile 10240

重启后生效


### 4、制表符自动补全？

有的时候文件的名字很长，很容易拼出错即使拼写对了也很浪费时间。

```
?  xktest ls java*
javaxiaokaxiu
```

比如操作javaxiaokaxiu这个文件时，输入到java的时候，然后按制表键(tab)就会补全成javaxiaokaxiu,是不是方便多了。


### 5、发现一个病毒文件你删了他又自动创建怎么解决

公司的内网某台linux服务器流量莫名其妙的剧增,用iftop查看有连接外网的情况

针对这种情况一般重点查看netstat连接的外网ip和端口。

用lsof -p pid可以查看到具体是那些进程，哪些文件

经查勘发现/root下有相关的配置conf.n hhe两个可疑文件，rm -rf后不到一分钟就自动生成了

由此推断是某个母进程产生的这些文件。所以找到母进程就是找到罪魁祸首

查杀病毒最好断掉外网访问，还好是内网服务器，可以通过内网访问

断了内网，病毒就失去外联的能力，杀掉它就容易的多

怎么找到呢，找了半天也没有看到蛛丝马迹，没办法只有ps axu一个个排查

方法是查看可以的用户和和系统相似而又不是的冒牌货，果然，看到了如下进程可疑

看不到图片就是/usr/bin/.sshd

于是我杀掉所有.sshd相关的进程，然后直接删掉.sshd这个可执行文件

然后才删掉了文章开头提到的自动复活的文件

总结一下，遇到这种问题，如果不是太严重，尽量不要重装系统

一般就是先断外网，然后利用iftop,ps,netstat,chattr,lsof,pstree这些工具顺藤摸瓜

一般都能找到元凶。但是如果遇到诸如此类的问题

/boot/efi/EFI/redhat/grub.efi: Heuristics.Broken.Executable FOUND，个人觉得就要重装系统了


### 6、查看文件类型?字符编码？

语法: file destination

```
?  apache file tomcat
tomcat: ASCII text
```

可以看出，file命令可以显示文件的类型text以及字符编码ASCII


### 7、cp（copy单词缩写，复制功能）

```
cp /opt/java/java.log /opt/logs/ ;把java.log 复制到/opt/logs/下
cp /opt/java/java.log /opt/logs/aaa.log ;把java.log 复制到/opt/logs/下并且改名为aaa.log
cp -r /opt/java /opt/logs ;把文件夹及内容复制到logs文件中
```


### 8、如何重置MySQL root密码？

**一、 在已知MYSQL数据库的ROOT用户密码的情况下，修改密码的方法：**

**1、** 在SHELL环境下，使用MySQLadmin命令设置：

MySQLadmin –u root –p password “新密码” ? 回车后要求输入旧密码

**2、** 在MySQL>环境中,使用update命令，直接更新MySQL库user表的数据：

Update ?MySQL.user ?set ?password=password(‘新密码’) ?where ?user=’root’;

flush ? privileges;

注意：MySQL语句要以分号”；”结束

3 在MySQL>环境中，使用grant命令，修改root用户的授权权限。

grant ?all ?on ?_._ ?to ? root@’localhost’ ?identified ?by ?‘新密码’；

**二、 如查忘记了MySQL数据库的ROOT用户的密码，又如何做呢？方法如下：**

**1、** 关闭当前运行的MySQLd服务程序：service ?MySQLd ?stop（要先将MySQLd添加为系统服务）

**2、** 使用MySQLd_safe脚本以安全模式（不加载授权表）启动MySQLd 服务

/usr/local/MySQL/bin/MySQLd_safe ?--skip-grant-table ?&

**3、** 使用空密码的root用户登录数据库，重新设置ROOT用户的密码

＃MySQL ?-u ? root

MySQL> Update ?MySQL.user ?set ?password=password(‘新密码’) ?where ?user=’root’;

MySQL> flush ? privileges;


### 9、通过什么命令指定命令提示符?

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


### 10、keepalive的工作原理和如何做到健康检查

keepalived是以VRRP协议为实现基础的，VRRP全称Virtual Router Redundancy Protocol，即虚拟路由冗余协议。

虚拟路由冗余协议，可以认为是实现路由器高可用的协议，即将N台提供相同功能的路由器组成一个路由器组

这个组里面有一个master和多个backup，master上面有一个对外提供服务的vip（该路由器所在局域网内

其他机器的默认路由为该vip），master会发组播，当backup收不到vrrp包时就认为master宕掉了

这时就需要根据VRRP的优先级来选举一个backup当master。这样就可以保证路由器的高可用了

keepalived主要有三个模块，分别是core、check和vrrp。core模块为keepalived的核心，负责主进程的启动、维护

及全局配置文件的加载和解析。check负责健康检查，包括常见的各种检查方式，vrrp模块是来实现VRRP协议的

Keepalived健康检查方式配置

```
HTTP_GET|SSL_GET
HTTP_GET | SSL_GET
{
url {
path /# HTTP/SSL 检查的url可以是多个
digest <STRING> # HTTP/SSL 检查后的摘要信息用工具genhash生成
status_code 200# HTTP/SSL 检查返回的状态码
}
connect_port 80 # 连接端口
bindto<IPADD>
connect_timeout 3 # 连接超时时间
nb_get_retry 3 # 重连次数
delay_before_retry 2 #连接间隔时间
}
```


### 11、Linux 下命令有哪几种可使用的通配符？分别代表什么含义?
### 12、Linux广泛使用的归档数据方法?
### 13、less （lese：较少的意思）分页查看文件命令（可以快速定位到最后一页）
### 14、8.迷路，我的当前位置在哪？
### 15、vim （VI IMproved：改进版视觉）改进版文本编辑器 （不管是文件查看还是文件编辑 按 Shift + 上或者下可以上下移动查看视角）
### 16、怎样查看一个linux命令的概要与用法？假设你在/bin目录中偶然看到一个你从没见过的的命令，怎样才能知道它的作用和用法呢？
### 17、数据排序?对数字进行排序？对月份排序？
### 18、如何把一个进程放到后台运行？
### 19、简述raid0 raid1 raid5 三种工作模式的工作原理及特点
### 20、如何切换目录？
### 21、验证网络可链接命令是什么？什么原理？
### 22、什么是环境变量？
### 23、如何选择 Linux 操作系统版本?
### 24、写一个脚本，实现判断192.168.1.0/24网络里，当前在线的IP有哪些，能ping通则认为在线
### 25、删除文件用哪个命令？如果需要连目录及目录下文件一块删除呢？删除空文件夹用什么命令？
### 26、哪个命令专门用来查看后台任务?
### 27、Shell 脚本是什么？
### 28、请问当用户反馈网站访问慢，你会如何处理？
### 29、如何写一条规则，拒绝某个ip访问本机8080端口?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
