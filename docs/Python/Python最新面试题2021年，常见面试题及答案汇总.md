# Python最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、输入一个字符串，输出该字符串的字符的所有组合。如输入'abc',输出a,b,c,ab,ac,bc,abc.

```python
def getC(s):
if not s:
return
len_s=len(s)
ss=[]
for i in range(len_s):
combination(s,0,i,ss)
aaa=[]
def combination(s,index,num,ss):
global aaa
if num==-1:
return
if index==len(s):
return
ss.append(s[index])
aaa.append(''.join(ss))
combination(s,index+1,num-1,ss)
ss.pop()
combination(s,index+1,num,ss)

getC('123')
print(aaa)
print(sorted(set(aaa),key=lambda x:len(str(x))))
```


### 2、使用python将数据库的student表中的数据写入db.txt

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


### 3、如何在函数中设置一个全局变量？

在函数中使用global关键字定义变量


### 4、Python中的闭包是什么？

当一个嵌套函数在其外部区域引用了一个值时，该嵌套函数就是一个闭包。其意义就是会记录这个值。

```
>>> def A(x):
    def B():
        print(x)
    return B
>>> A(7)()
```

结果：

```
7
```

更多关于闭包的知识，请参看这里：

[戳这里](https://data-flair.training/blogs/python-closure/)


### 5、如何用一行代码生成[1,4,9,16,25,36,49,64,81,100]?

```python
lis=[i**2 for i in range(1,11)]
```


### 6、前后端分离的基本原理

前后端分离并非仅仅只是一种开发模式，而是一种架构模式（前后端分离架构）。前端项目与后端项目是两个项目，放在两个不同的服务器，需要独立部署，两个不同的工程，两个不同的代码库，不同的开发人员。前后端工程师需要约定交互接口，实现并行开发，开发结束后需要进行独立部署，前端通过Ajax来调用HTTP请求调用后端的restful api。前端只需要关注页面的样式与动态数据的解析&渲染，而后端专注于具体业务逻辑。


### 7、解释Python中reduce函数的用法？

reduce()函数接受一个函数和一个序列，并在计算后返回数值。

```
from functools import reduce

a = lambda x,y:x+y
print(reduce(a,[1,2,3,4]))

> 10
```


### 8、写一个函数，计算出以下字母所代表的数字，每个字母值不一样

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


### 9、解释一下Python中的赋值运算符

这在Python面试中是个重要的面试问题。

我们将所有的算术运算符和赋值符号放在一起展示：

```
>>> a=7
>>> a+=1
>>> a
8
 
>>> a-=1
>>> a
7
 
>>> a*=2
>>> a
14
 
>>> a/=2
>>> a
7.0 
 
>>> a**=2
>>> a
49
 
>>> a//=3
>>> a
16.0
 
>>> a%=4
>>> a
0.0
```


### 10、简述面向对象的三大特性？

继承，封装和多态

**继承：**

继承就是继承的类直接拥有被继承类的属性而不需要在自己的类体中重新再写一遍，其中被继承的类叫做父类、基类，继承的类叫做派生类、子类。

**封装：**

封装就是把类中的属性和方法定义为私有的，方法就是在属性名或方法名前加双下划线，而一旦这样定义了属性或方法名后，python会自动将其转换为_类名**属性名（方法名）的格式，在类的内部调用还是用双下划线加属性名或方法名，在类的外部调用就要用**类名_属性名（方法名）。父类的私有属性和方法，子类无法对其进行修改。

**多态：**

多态就是不同的对象可以调用相同的方法然后得到不同的结果，有点类似接口类的感觉，在python中处处体现着多态，比如不管你是列表还是字符串还是数字都可以使用+和*。


### 11、python解释器种类以及特点
### 12、Python中的单引号和双引号有什么区别？
### 13、求以下代码的输出结果
### 14、简述OSI七层协议
### 15、简述事务及其特性
### 16、输入某年某月某日，判断这是这一年的第几天？
### 17、请列举布尔值位False的常见值
### 18、Python代码是如何执行的？
### 19、什么是LVS
### 20、css如何隐藏一个元素
### 21、简述left join和right join的区别
### 22、什么是覆盖索引
### 23、如何实现Redis集群
### 24、进程之间如何进行通信？
### 25、使用async语法实现一个协程
### 26、如果Redis中的某个列表中的数据量非常大，如何实现循环显示每一个值？
### 27、判断dict中有没有某个key。
### 28、or 和 and
### 29、手写一个栈
### 30、什么是socket？简述基于tcp协议的socket通信流程？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
