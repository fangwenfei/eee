# Linux最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、一台 Linux 系统初始化环境后需要做一些什么安全工作？

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


### 2、Linux 使用的进程间通信方式？

> 了解即可，不需要太深入。


**1、** 管道(pipe)、流管道(s_pipe)、有名管道(FIFO)。

**2、** 信号(signal) 。

**3、** 消息队列。

**4、** 共享内存。

**5、** 信号量。

**6、** 套接字(socket) 。


### 3、RabbitMQ是什么东西？

RabbitMQ也就是消息队列中间件，消息中间件是在消息的传息过程中保存消息的容器

消息中间件再将消息从它的源中到它的目标中标时充当中间人的作用

队列的主要目的是提供路由并保证消息的传递；如果发送消息时接收者不可用

消息队列不会保留消息，直到可以成功地传递为止，当然，消息队列保存消息也是有期限地


### 4、如果你的助手想要打印出当前的目录栈，你会建议他怎么做？

**答案：**

使用Linux 命令dirs可以将当前的目录栈打印出来。

```
[root@localhost ~]# dirs
/usr/share/X11
```

【附】：目录栈通过pushd popd 来操作。


### 5、怎么查看系统支持的所有信号？

**答案：**

kill -l


### 6、查看部分文件

语法 : tail destination

默认情况会展示文件的末尾10行。 -n 行数，显示最后n行。

```
?  apache tail -n 2 tomcat
restart
end
```

语法: head destination

默认情况会展示文件的开头10行。 -n 行数，显示开头n行。

```
?  apache head -n 2 tomcat
text
text
```


### 7、查看组信息？如何创建组？删除组？

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


### 8、写一个脚本，实现判断192.168.1.0/24网络里，当前在线的IP有哪些，能ping通则认为在线
### 9、快速判断某个特定目录是否有超大文件？
### 10、使用tcpdump监听主机为192.168.1.1，tcp端口为80的数据，同时将输出结果保存输出到tcpdump.log
### 11、如何查找匹配的文件？基于文件属性？
### 12、使用什么命令查看 ip 地址及接口信息？
### 13、当你需要给命令绑定一个宏或者按键的时候，应该怎么做呢？
### 14、keepalive的工作原理和如何做到健康检查
### 15、Linux 中进程有哪几种状态？在 ps 显示出来的信息中，分别用什么符号表示的？
### 16、打印文件第一行到第三行?
### 17、yum install -y lrzsz 命令（实现win到Linux文件互相简单上传文件）
### 18、你对现在运维工程师的理解和以及对其工作的认识
### 19、压缩工具有哪些?
### 20、如何用awk查看第2行倒数第3个字段?
### 21、如何选择 Linux 操作系统版本?
### 22、文件描述符?每个描述符的含义?
### 23、Squid、Varinsh和Nginx有什么区别，工作中你怎么选择？
### 24、重新命名文件？移动文件？
### 25、实时监测进程
### 26、请执行命令取出 linux 中 eth0 的 IP 地址(请用 cut，有能力者也可分别用 awk,sed 命令答)
### 27、讲述一下LVS三种模式的工作过程？
### 28、ll （ll：list的缩写，查看列表详情）查看当前目录下的所有详细信息和文件夹（ll 结果是详细,有时间,是否可读写等信息）
### 29、| 管道命令（把多个命令组合起来使用）




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
