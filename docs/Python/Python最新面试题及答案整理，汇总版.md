# Python最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、简述OSI七层协议

为了实现计算机系统的互连，OSI参考模型把整个网络的通信功能划分为7个层次，同时也定义了层次之间的相互关系以及各层所包括的服务及每层的功能。OSI的七层由低到高依次为：物理层、数据链路层、网络层、传输层、会话层、表示层、应用层，下三层（物理层、数据链路层、网络层）面向数据通信，而上三层（会话层、表示层、应用层）则面向资源子网，而传输层则是七层中最为重要的一层。它位于上层和下层中间，起承上启下的作用。


### 2、有一个列表lis=['This','is','a','Man','B','!']，对它进行大小写无关的排序

```python
lis=['This','is','a','Man','B','!']
lis=sorted(lis,key=str.lower)
print(lis)
```


### 3、如何使用索引来反转Python中的字符串?

```
string = 'hello'

string[::-1]
>'olleh'
```


### 4、解释//、％、* *运算符？

//(Floor Division)-这是一个除法运算符，它返回除法的整数部分。

例如：5 // 2 = 2

％(模数)-返回除法的余数。

例如：5 ％ 2 = 1

**(幂)-它对运算符执行指数计算。a ** b表示a的b次方。

例如：5 ** 2 = 25、5 ** 3 = 125


### 5、你对Python类中的self有什么了解？

self表示类的实例。

通过使用self关键字，我们可以在Python中访问类的属性和方法。

注意，在类的函数当中，必须使用self，因为类中没有用于声明变量的显式语法。


### 6、为什么数据很大的时候使用limit offset分页时，越往后翻速度越慢，如何优化？

使用limit分页时，比如limit 10000，20的意思是扫描满足条件的10020行，扔掉前面的10000行，最后返回20行，问题就出在这，当数据量大的时候，大量时间花在了扫描上面了。

**优化方法：**

**1、** 当一个数据库表过于庞大，LIMIT offset, length中的offset值过大，则SQL查询语句会非常缓慢，你需增加order by，并且order by字段需要建立索引。

**2、** 如果使用子查询去优化LIMIT的话，则子查询必须是连续的，某种意义来讲，子查询不应该有where条件，where会过滤数据，使数据失去连续性


### 7、编写程序，打印斐波那契数列的前十项

```
fibo = [0,1]
[fibo.append(fibo[-2]+fibo[-1]) for i in range(8)]

fibo
> [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
```


### 8、JavaScript(或者jQuery)如何选择一个id为main的容器

**1、** jquery：$('#id')

**2、** JavaScript：document.getElementById("id"))


### 9、公司线上和开发环境使用的什么系统

线上用的centos和Ubuntu系统

开发环境用的windows，mac，还有Ubuntu。


### 10、Python中的标识符长度能有多长？

在Python中，标识符可以是任意长度。此外，我们在命名标识符时还必须遵守以下规则：

**1、**   只能以下划线或者 A-Z/a-z 中的字母开头

**2、**   其余部分可以使用 A-Z/a-z/0-9

**3、**   区分大小写

**4、**   关键字不能作为标识符，Python中共有如下关键字：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/200/33/53_3.png#alt=53%5C_3.png)


### 11、什么是socket？简述基于tcp协议的socket通信流程？
### 12、实例变量和类变量的区别
### 13、python中进制转换
### 14、什么是鸭子模型？
### 15、解释Python中的help()和dir()函数
### 16、使用async语法实现一个协程
### 17、发生粘包现象如何处理？
### 18、什么是Python？为什么它会如此流行？
### 19、下面代码的执行结果是
### 20、什么是ajax请求？手写一个ajax请求
### 21、解释一下Python中的三元运算子
### 22、举例说明Python中的range函数?
### 23、给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。例如：'ababab',返回True，'ababa'，返回False
### 24、如何保证api调用时数据的安全性
### 25、请解释使用*args和**kwargs的含义
### 26、数据库锁的作用
### 27、Redis中sentinel的作用
### 28、如何判断一个值是方法还是函数？
### 29、MySQL的增删改查
### 30、什么是断言(assert)?应用场景？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
