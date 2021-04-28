# Python最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、编写程序，检查数字是否为Armstrong

将每个数字依次分离，并累加其立方(位数)。

最后，如果发现总和等于原始数，则称为阿姆斯特朗数(Armstrong)。

```
num = int(input("Enter the number:\n"))
order = len(str(num))

sum = 0
temp = num

while temp > 0:
   digit = temp % 10
   sum += digit ** order
   temp //= 10

if num == sum:
   print(num,"is an Armstrong number")
else:
   print(num,"is not an Armstrong number")
```


### 2、写一个函数，计算出以下字母所代表的数字，每个字母值不一样

```python
for A in range(1,10):
for B in range(10):
if A==B:
continue
for C in range(1,10):
if C in [A,B]:
    continue
for D in range(10):
    if D in [A,B,C]:
        continue
    for E in range(1,10):
        if E in [A,B,C,D]:
            continue
        for F in range(10):
            if F in [A,B,C,D,E]:
                continue
            for G in range(1,10):
                if G in [A,B,C,D,E,F]:
                    continue
                for H in range(10):
                    if H in [A,B,C,D,E,F,G]:
                        continue
                    for P in range(1,10):
                        if P in [A,B,C,D,E,F,G,H]:
                            continue
                        if (A*10+B)-(C*10+D)==(E*10+F) and (E*10+F)+(G*10+H)==(P*100+P*10+P):
                        print(A,B,C,D,E,F,G,H,P)
```


### 3、什么是闭包

在函数中可以（嵌套）定义另一个函数时，如果内部的函数引用了外部的函数的变量，则可能产生闭包。闭包可以用来在一个函数与一组“私有”变量之间创建关联关系。在给定函数被多次调用的过程中，这些私有变量能够保持其持久性。

```python
# 内部函数使用了外部函数的变量，就相当于闭包
def func1():
a=1
def inner():
return a
return inner
print(func1()())
```


### 4、使用python将数据库的student表中的数据写入db.txt

```python
import pyMySQL
connect=pyMySQL.Connect(
host='',
port=,
user='',
passwd='',
db='',
charset='',
)

cursor=connect.cursor()
sql='select from student'
cursor.execute(sql)
students=cursor.fetchall()

with open('db.txt','w') as f:
for student in students:
f.write(student)

cursor.close()
connect.close()
```


### 5、描述以下字典的items()方法和iteritems()方法有啥不同？

**1、** 字典的items方法作用：是可以将字典中的所有项，以列表方式返回。因为字典是无序的，所以用items方法返回字典的所有项，也是没有顺序的。

**2、** 字典的iteritems方法作用：与items方法相比作用大致相同，只是它的返回值不是列表，而是一个迭代器


### 6、MySQL如何创建索引

**1、** ALTER TABLE

**2、** ALTER TABLE用来创建普通索引、UNIQUE索引或PRIMARY KEY索引。

**3、** ALTER TABLE table_name ADD INDEX index_name (column_list)

**4、** ALTER TABLE table_name ADD UNIQUE (column_list)

**5、** ALTER TABLE table_name ADD PRIMARY KEY (column_list)

**6、** CREATE INDEX

**7、** CREATE INDEX可对表增加普通索引或UNIQUE索引。

**8、** CREATE INDEX index_name ON table_name (column_list)

**9、** CREATE UNIQUE INDEX index_name ON table_name (column_list)


### 7、解释一下Python中的继承？

继承(inheritance)允许一个类获取另一个类的所有成员和属性。继承提供代码可重用性，可以更轻松地创建和维护应用程序。

被继承的类称为超类，而继承的类称为派生类/子类。


### 8、py2项目如何迁移成py3

**1、** 先备份原文件，然后使用python3自带工具2to3.py将py2文件转换位py3文件

**2、** 手动将不兼容的代码改写成兼容py3的代码


### 9、什么是正向代理和反向代理？

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


### 10、生成器与函数的区别？

生成器和函数的主要区别在于函数 return a value，生成器 yield a value同时标记或记忆point of the yield 以便于在下次调用时从标记点恢复执行。 yield 使函数转换成生成器，而生成器反过来又返回迭代器。

```python
# 简单实现生成器
def dec():
n=0
for i in range(10):
yield n
n+=i

for i in dec():
print(i)
```


### 11、vue中的路由拦截器的作用
### 12、在Python中有多少种运算符？解释一下算数运算符。
### 13、如何基于Redis实现发布和订阅
### 14、python解释器种类以及特点
### 15、简述python的深浅拷贝
### 16、什么是codis
### 17、什么是负索引？
### 18、如何实现"1.2.3"变成['1','2','3']?
### 19、索引再什么情况下遵循最左前缀的规则？
### 20、解释Python中的Filter？
### 21、什么是防火墙？防火墙的作用是什么？
### 22、什么是正则的贪婪匹配？贪婪模式和非贪婪模式的区别？
### 23、有如下链表类，请实现单链表逆置。
### 24、讲讲Python中的位运算符
### 25、区分Python中的remove，del和pop？
### 26、请列举你所知道的python代码检测工具以及他们之间的区别
### 27、query作为sql模板，args为将要传入的参数
### 28、python中如何使用进程池和线程池
### 29、a = dict(zip(('a','b','c','d','e'),(1,2,3,4,5))) 请问a是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
