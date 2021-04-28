# Python最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、简述数据库的读写分离

读写分离就是在主服务器上修改，数据会同步到从服务器，从服务器只能提供读取数据，不能写入，实现备份的同时也实现了数据库性能的优化，以及提升了服务器安全。


### 2、什么是ajax请求？手写一个ajax请求

ajax（异步JavaScript和XML）是指一种创建交付式网页应用的网页开发技术。可以在不重新加载整个网页的情况下，对网页的某部分进行更新。

```javascript
// 不使用第三方
var xhr = new XMLHttpRequest();
xhr.open("GET", url, false);
xhr.onreadtstatechange = function() {
    if (xhr.readystate == 4) {
        //响应内容解析完成，可以在客户端调用了
        if (xhr.status == 200) {
            //客户端的请求成功了
            alert(xhr.responseText);
        }
    }
}
xhr.send(null);
// 使用ajax
$.ajax({
    type: "GET",
    url: "",
    dataType: "json",
    success: function(data) {},
    error: function(jqXHR) {}
});
```


### 3、什么是并发和并行

**1、** 并发:指应用能够交替执行不同的任务,其实并发有点类似于多线程的原理,多线程并非是同时执行多个任务,如果你开两个线程执行,就是在你几乎不可能察觉到的速度不断去切换这两个任务,已达到"同时执行效果",其实并不是的,只是计算机的速度太快,我们无法察觉到而已.

**2、** 并行:指应用能够同时执行不同的任务,

**3、** 并发是多个事件在同一时间段执行，并行是多个事件在统一时间点执行。


### 4、解释一下Python中的关系运算符

关系运算符用于比较两个值。

**1、** 小于号（<），如果左边的值较小，则返回True。

```
>>> 'hi'<'Hi'
False
```

**2、** 大于号（>），如果左边的值较大，则返回True。

```
>>> 1.1+2.2>3.3
True
```

**3、** 小于等于号（<=），如果左边的值小于或等于右边的值，则返回Ture。

```
>>> 3.0<=3
True
```

**4、** 大于等于号（>=），如果左边的值大于或等于右边的值，则返回True。

```
>>> True>=False
True
```

**1、**   等于号（==），如果符号两边的值相等，则返回True。

```
>>> {1,3,2,2}=={1,2,3}
True
```

**1、**   不等于号（!=），如果符号两边的值不相等，则返回True。

```
>>> True!=0.1
True
>>> False!=0.1
True
```


### 5、为什么Python执行速度慢，我们如何改进它？

Python代码执行缓慢的原因，是因为它是一种解释型语言。它的代码在运行时进行解释，而不是编译为本地语言。

为了提高Python代码的速度，我们可以使用CPython、Numba，或者我们也可以对代码进行一些修改。

**1、**  减少内存占用。

**2、**  使用内置函数和库。

**3、**  将计算移到循环外。

**4、**  保持小的代码库。

**5、**  避免不必要的循环


### 6、threading.local的作用

为每个线程创建一个独立的空间，使得线程对自己的空间中的数据进行操作(数据隔离)。


### 7、字节码和机器码的区别

**1、** 机器码是电脑CPU直接读取运行的机器指令，运行速度最快，但是非常晦涩难懂，也比较难编写，一般从业人员接触不到。

**2、** 字节码是一种中间状态（中间码）的二进制代码（文件）。需要直译器转译后才能成为机器码。


### 8、什么是Python中的猴子补丁？

猴子补丁(monkey patching)，是指在运行时动态修改类或模块。

```
from SomeOtherProduct.SomeModule import SomeClass

def speak(self):
    return "Hello!"

SomeClass.speak = speak
```


### 9、写个函数接收一个文件夹名称作为参数，显示文件夹中文件的路径，以及其中包含的文件夹中文件的如今

```python
# 方法一
import os
def Test1(rootDir):
list_dirs = os.walk(rootDir)
for root, dirs, files in list_dirs:
for d in dirs:
print(os.path.join(root, d))
for f in files:
print(os.path.join(root, f))
Test1(r'C:\Users\felix\Desktop\aaa')
print('#############')
# 方法二
import os
def Test2(rootDir):
paths=os.listdir(rootDir)
for lis in paths:
path=os.path.join(rootDir,lis)
print(path)
if os.path.isdir(path):
 Test2(path)
Test2(r'C:\Users\felix\Desktop\aaa')
```


### 10、求出以下代码的输出结果

```python
mydict={'a':1,'b':2}
def func(d):
d['a']=0
return d

func(mydict)
mydict['c']=2
print(mydict)
```

结果

> {'a': 0, 'b': 2, 'c': 2}



### 11、re的match和search的区别
### 12、有两个字符串列表a和b，每个字符串是由逗号隔开的一些字符
### 13、lambda表达式格式以及应用场景？
### 14、写出以下代码的输出结果：
### 15、Redis是单进程单线程的吗？
### 16、请解释使用*args和**kwargs的含义
### 17、什么是gevent
### 18、有一个列表lis=['This','is','a','Man','B','!']，对它进行大小写无关的排序
### 19、Python中的闭包是什么？
### 20、MySQL索引种类
### 21、实例变量和类变量的区别
### 22、*arg和**kwargs的作用
### 23、你对Python类中的self有什么了解？
### 24、python递归的最大层数？
### 25、如何在函数中设置一个全局变量？
### 26、简述数据库分库分表
### 27、是否使用过functools中的函数？他的作用是什么？
### 28、简述left join和right join的区别
### 29、现有mydict和变量onekey，请写出从mydict中取出onekey的值的方法
### 30、break、continue、pass是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
