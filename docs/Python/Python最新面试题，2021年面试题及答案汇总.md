# Python最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、a = dict(zip(('a','b','c','d','e'),(1,2,3,4,5))) 请问a是什么？

**{'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5}**


### 2、常用字符串格式化有哪几种？

**1、** 使用百分号

```python
print('hello %s and %s'%('friend','another friend'))
```

**2、** 使用format

```python
print('hello {first} and {second}'.format(first='friend',second='another friend'))
```


### 3、有如下代码：

```python
import copy
a=[1,2,3,[4,5],6]
b=a
c=copy.copy(a)
d=copy.deepcopy(a)
b.append(10)
c[3].append(11)
d[3].append(12)
```

求a，b，c，d

**答案：**

> a：[1, 2, 3, [4, 5, 11], 6, 10]

b：[1, 2, 3, [4, 5, 11], 6, 10]

c：[1, 2, 3, [4, 5, 11], 6]

d：[1, 2, 3, [4, 5, 12], 6]



### 4、在什么情况下y!=x-(x-y)会成立？

x，y是两个不相等的非空集合


### 5、Python有哪些特点和优点？

作为一门编程入门语言，Python主要有以下特点和优点：

**1、** 可解释

**2、** 具有动态特性

**3、** 面向对象

**4、** 简明简单

5、开源

**6、** 具有强大的社区支持

当然，实际上Python的优点远不止如此，


### 6、py2项目如何迁移成py3

**1、** 先备份原文件，然后使用python3自带工具2to3.py将py2文件转换位py3文件

**2、** 手动将不兼容的代码改写成兼容py3的代码


### 7、索引再什么情况下遵循最左前缀的规则？

在多字段进行索引的时候，会遵循以上原则


### 8、DNS域名解析过程
### 9、实例变量和类变量的区别
### 10、有一个多层嵌套的列表A=[1,2,3,[4,1,['j1',1,[1,2,3,'aa']]]],请写一段代码将A中的元素全部打印出来
### 11、元组的解封装是什么？
### 12、文件操作时，xreadlines和readlines的区别
### 13、实现99乘法表（使用两种方法）
### 14、python3和python2中int和long的区别
### 15、Python中的pass语句是什么？
### 16、python中如何使用进程池和线程池
### 17、路由器和交换机的区别
### 18、Python中的单引号和双引号有什么区别？
### 19、有如下链表类，请实现单链表逆置。
### 20、Redis如何实现事务
### 21、b、B、kB、MB、GB的关系
### 22、用一行Python代码，从给定列表中取出所有的偶数和奇数
### 23、python递归的最大层数？
### 24、有一个列表lis=['This','is','a','Man','B','!']，对它进行大小写无关的排序
### 25、如何实现['1','2','3']变成[1,2,3]
### 26、列表推导式[i for i in range(10)]和生成式表达式(i for i in range(10))的区别
### 27、列举创建索引但是无法命中索引的情况
### 28、实现一个装饰器，通过一次调用，使函数重复执行5次
### 29、使用yield实现一个协程
### 30、简述SQL注入原理，以及如何在代码层面房子sql注入




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
