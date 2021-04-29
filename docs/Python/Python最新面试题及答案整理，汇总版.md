# Python最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Python支持多重继承吗？

Python可以支持多重继承。多重继承意味着，一个类可以从多个父类派生。


### 2、如何判断一个对象是否可调用？哪些对象是可调用对象？如何定义一个类，使其对象本身就是可调用对象？

**1、** 使用callable函数判断。

**2、** 可调用对象有7类：

**3、** 用户自定义函数

**4、** 内置函数

**5、** 内置方法

**6、** 方法(定义在类中的函数)

7、类

**8、** 类实例(如果类中定义了**call**方法，那么这个类的实例就是可调用对象)

**9、** 生成器函数

在类中定义**call**方法，实例对象加()是即调用**call**的方法


### 3、列举你所了解的所有Python2和Python3的区别

[python2和python3的区别](https://blog.csdn.net/weixin_41819299/article/details/81259721)

**1、** python2没有nonlocal关键字，要修改临时变量只能将其改成可变数据类型，如数组。b=[a]

**2、** print()函数代替print语句

**3、** Python3加入 Unicode 字符串，用以编码存储字符串。比如用 utf-8可以用来输入中文

**4、** Python3去掉long类型，新增了bytes。

**5、** Python 3整数之间做除法可以得到浮点数的结果，不需要进行数据格式转换1/2=0.5 Python 2整数int间除法结果为把运算结果去尾的整数1/2=0，3/2.0=1.5

**6、** Python3 中 range()，Python2 中 xrange()。

**7、** python2中的不等于号可以是!=或者<>，python3只能是!=

**8、** python2中raw_input()用来输入字符串，而python3中使用input()来输入字符串


### 4、Redis中默认有多少个哈希槽

**1、** 2^14个

**2、** Redis 集群没有使用一致性hash, 而是引入了哈希槽的概念。


### 5、MySQL执行计划的作用和使用方法

**1、** 作用：用来进行查询分析，比如整个查询涉及多少防，使用哪些索引，运行时间等

**2、** 使用方法：使用explain关键字，如explain select xxx from xxx;


### 6、前后端分离的基本原理

前后端分离并非仅仅只是一种开发模式，而是一种架构模式（前后端分离架构）。前端项目与后端项目是两个项目，放在两个不同的服务器，需要独立部署，两个不同的工程，两个不同的代码库，不同的开发人员。前后端工程师需要约定交互接口，实现并行开发，开发结束后需要进行独立部署，前端通过Ajax来调用HTTP请求调用后端的restful api。前端只需要关注页面的样式与动态数据的解析&渲染，而后端专注于具体业务逻辑。


### 7、在Python中是如何管理内存的？

Python有一个私有堆空间来保存所有的对象和数据结构。作为开发者，我们无法访问它，是解释器在管理它。但是有了核心API后，我们可以访问一些工具。Python内存管理器控制内存分配。

另外，内置垃圾回收器会回收使用所有的未使用内存，所以使其适用于堆空间。


### 8、什么是一致性哈希
### 9、怎样声明多个变量并赋值？
### 10、解释一下Python中的//，%和 ** 运算符
### 11、如何修改本地hosts文件
### 12、写出以下代码的输出结果：
### 13、什么是Flask？
### 14、解释一下Python中的继承
### 15、什么是正向代理和反向代理？
### 16、python如何定义函数时如何书写可变参数和关键字参数？
### 17、简述解释型和编译型编程语言
### 18、简述数据库分库分表
### 19、将下面列表中的元素根据位数合并成字典：
### 20、简述数据库的读写分离
### 21、Python中的生成器是什么？
### 22、什么是域名解析
### 23、sys.path.append('xxx')的作用
### 24、python是如何进行内存管理的？python的程序会内存泄漏吗？说说有没有什么方面阻止或者检测内存泄漏？
### 25、如何使用索引来反转Python中的字符串?
### 26、什么是keepalived
### 27、简述多进程开发中join和deamon的区别
### 28、Python是否有main函数？
### 29、super的作用
### 30、编写程序，查找文本文件中最长的单词




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
