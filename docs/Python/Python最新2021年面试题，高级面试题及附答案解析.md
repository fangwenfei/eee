# Python最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是asyncio

asyncio是并发的一种方式，是一个协程相关的库。也叫异步IO


### 2、python中enumerate的意思是什么？

枚举的意思，同时得到可迭代对象，如列表和元组的索引和值，以元组形式返回


### 3、python哪些类型的数据才能作为字典的key？

可哈希的类型


### 4、JavaScript(或者jQuery)如何选择一个id为main的容器

**1、** jquery：$('#id')

**2、** JavaScript：document.getElementById("id"))


### 5、Python有哪些应用？

**1、**  Web开发

**2、**  桌面GUI开发

**3、**  人工智能和机器学习

**4、**  软件开发

**5、**  业务应用程序开发

**6、**  基于控制台的应用程序

**7、**  软件测试

**8、**  Web自动化

**9、**  基于音频或视频的应用程序

**10、**  图像处理应用程序


### 6、手写一个队列

```python
class Queue(object):
def __init__(self,size):
self.queue=[]
self.size=size
def is_empty(self):
return not bool(len(self.queue))
def is_full(self):
return len(self.queue)==self.size
def enqueue(self,val):
if not self.is_full():
self.queue.insert(0,val)
return True
return False
def dequeue(self):
if not self.is_empty():
return self.queue.pop()
return None
s=Queue(2)
print(s.is_empty)
s.enqueue(1)
s.enqueue(2)
print(s.is_full())
print(s.dequeue())
print(s.dequeue())
print(s.is_empty())
```


### 7、如何修改本地hosts文件

进入c:\windows\system32\drivers\etc进行修改


### 8、什么是正向代理和反向代理？

**正向代理**

**1、** 正向代理类似一个跳板机，代理访问外部资源。

**2、** 正向代理 是一个位于客户端和原始服务器(origin server)之间的服务器，为了从原始服务器取得内容，客户端向代理发送一个请求并指定目标(原始服务器)，然后代理向原始服务器转交请求并将获得的内容返回给客户端。客户端必须要进行一些特别的设置才能使用正向代理。

**正向代理作用：**

**1、** 访问原来无法访问的资源，如google

**2、** 可以做缓存，加速访问资源

**3、** 对客户端访问授权，上网进行认证

**4、** 代理可以记录用户访问记录（上网行为管理），对外隐藏用户信息

**反向代理**

**1、** 反向代理（Reverse Proxy）实际运行方式是指以代理服务器来接受internet上的连接请求，然后将请求转发给内部网络上的服务器，并将从服务器上得到的结果返回给internet上请求连接的客户端，此时代理服务器对外就表现为一个服务器

**反向代理的作用：**

**1、** 保证内网的安全，可以使用反向代理提供WAF功能，阻止web攻击

**2、** 负载均衡，通过反向代理服务器来优化网站的负载


### 9、找出两个列表中相同的元素和不同的元素

```python
list1=[1,2,3,5,8,7,11,10]
list2=[5,15,25,10]
sim=[i for i in list1 if i in list2]
diff=[i for i in list1+list2 if i not in sim]
print(sim)
print(diff)
```


### 10、什么是一致性哈希

[参考链接](https://www.jianshu.com/p/49e3fbf41b9b)

一致性哈希简称DHT,是麻省理工学院提出的一种算法，目前主要应用于分布式缓存当中。一致性哈希可以有效地解决分布式存储结构下动态增加和删除节点所带来的问题。


### 11、python中如何使用进程池和线程池
### 12、请列举你所知道的python代码检测工具以及他们之间的区别
### 13、使用yield实现一个协程
### 14、Python中的闭包是什么？
### 15、列举你所了解的所有Python2和Python3的区别
### 16、简述生成器，迭代器，装饰器以及应用场景
### 17、编写程序，输出给定序列中的所有质数
### 18、列表推导式[i for i in range(10)]和生成式表达式(i for i in range(10))的区别
### 19、Redis和Memcached的区别
### 20、Python中注释代码的方法有哪些？
### 21、什么是覆盖索引
### 22、re的match和search的区别
### 23、MySQL的半同步复制原理
### 24、你对Python类中的self有什么了解？
### 25、什么是pickling和unpickling？
### 26、什么是闭包
### 27、实现一个装饰器，通过一次调用，使函数重复执行5次
### 28、发生粘包现象如何处理？
### 29、什么是断言(assert)?应用场景？
### 30、Redis如何实现主从复制？以及数据同步机制？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
