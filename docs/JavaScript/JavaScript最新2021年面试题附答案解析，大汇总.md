# JavaScript最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、几种基本数据类型?复杂数据类型?值类型和引用数据类型?堆栈数据结构

**1、** 基本数据类型：Undefined、Null、Boolean、Number、String

**2、** 值类型：数值、布尔值、null、undefined。

**3、** 引用类型：对象、数组、函数。

**4、** 堆栈数据结构：是一种支持后进先出(LIFO)的集合,即后被插入的数据,先被取出!

**5、** js数组中提供了以下几个方法可以让我们很方便实现堆栈：

**6、** shift:从数组中把第一个元素删除，并返回这个元素的值。

**7、** unshift: 在数组的开头添加一个或更多元素，并返回新的长度

**8、** push:在数组的中末尾添加元素，并返回新的长度

**9、** pop:从数组中把最后一个元素删除，并返回这个元素的值。


### 2、ECMAScript 是什么？

ECMAScript 是编写脚本语言的标准，这意味着JavaScript遵循ECMAScript标准中的规范变化，因为它是JavaScript的蓝图。

ECMAScript 和 Javascript，本质上都跟一门语言有关，一个是语言本身的名字，一个是语言的约束条件 只不过发明JavaScript的那个人（Netscape公司），把东西交给了ECMA（European Computer Manufacturers Association），这个人规定一下他的标准，因为当时有java语言了，又想强调这个东西是让ECMA这个人定的规则，所以就这样一个神奇的东西诞生了，这个东西的名称就叫做ECMAScript。

javaScript = ECMAScript + DOM + BOM（自认为是一种广义的JavaScript）

ECMAScript说什么JavaScript就得做什么！

JavaScript（狭义的JavaScript）做什么都要问问ECMAScript我能不能这样干！如果不能我就错了！能我就是对的！

——突然感觉JavaScript好没有尊严，为啥要搞个人出来约束自己，

那个人被创造出来也好委屈，自己被创造出来完全是因为要约束JavaScript。


### 3、函数fn1 函数fn2 函数fn3，如果想在三个函数都执行完成后执行某一个事件应该如何实现?

```
//1、设置事件监听。
//2、回调函数：
function fn1(){
       console.log("执行fn1");
       fn2();
}
function fn2(){
       console.log("执行fn2");
       fn3();
}
function fn3(){
       console.log("执行fn3");
       mou();
}
function mou(){
       console.log("执行某个函数");
}
fn1();
```


### 4、如何添加一个dom对象到body中?innerHTML和innerText区别?

body.appendChild(dom元素)；

innerHTML:从对象的起始位置到终止位置的全部内容,包括Html标签。

innerText:从起始位置到终止位置的内容, 但它去除Html标签

分别简述五个window对象、属性

**成员对象**

**1、** window.event window.document window.history

**2、** window.screen window.navigator window.external

**3、** Window对象的属性如下：

**4、** window //窗户自身

**5、** window.self [//引用本窗户window=window.self](//%E5%BC%95%E7%94%A8%E6%9C%AC%E7%AA%97%E6%88%B7window=window.self)

**6、** window.name //为窗户命名

**7、** window.defaultStatus //设定窗户状态栏信息

**8、** window.location //URL地址,配备布置这个属性可以打开新的页面


### 5、介绍js的基本数据类型

`Undefined`、`Null`、`Boolean`、`Number`、`String`


### 6、javascript有哪些方法定义对象

**1、** 对象字面量： `var obj = {};`

**2、** 构造函数： `var obj = new Object();`

**3、** Object.create(): `var obj = Object.create(Object.prototype);`


### 7、JavaScript提供了哪几种“异步模式”？

**1、** 回调函数（callbacks）

**2、** 事件监听

**3、** Promise对象


### 8、slice() splice()?

slice() 方法可从已有的数组中返回选定的元素。

splice() 方法向/从数组中添加/删除项目，然后返回被删除的项目。


### 9、Node的应用场景

**特点：**

**1、** 它是一个`Javascript`运行环境

**2、** 依赖于`Chrome V8`引擎进行代码解释

**3、** 事件驱动

**4、** 非阻塞`I/O`

**5、** 单进程，单线程

**优点：**

**1、** 高并发（最重要的优点）

**缺点：**

**1、** 只支持单`核CPU`，不能充分利用`CPU`

**2、** 可靠性低，一旦代码某个环节崩溃，整个系统都崩溃


### 10、何为防抖和节流？如何实现？

**1、** 防抖和节流都是防止短时间内高频触发事件的方案。

**2、** 防抖的原理是：如果一定时间内多次执行了某事件，则只执行其中的最后一次。

**3、** 节流的原理是：要执行的事件每隔一段时间会被冷却，无法执行。

**4、** 应用场景有：搜索框实时搜索，滚动改变相关的事件。

```
//@fn: 要执行的函数
//@delay: 设定的时限
//防抖函数
function debunce(fn, delay) {
    let flag = null;
    return function() {
        if (flag) clearTimeout(flag)
        //利用apply改变函数指向，使得封装后的函数可以接收event本身
        flag = setTimeout(() = > fn.apply(this, arguments), delay)
    }
}
//节流函数
function throttle(fn, delay) {
    let flag = true;
    return function() {
        if (!flag) return false;
        flag = false;
        setTimeout(() = > {
            fn.apply(this, arguments)
            flag = true
        }, delay)
    }
}
```


### 11、怎么理解Promise对象？
### 12、Javascript如何实现继承？
### 13、事件模型
### 14、call和apply 有什么好处？
### 15、基本数据类型和引用数据类型有什么区别？
### 16、this指向的各种情况都有什么？
### 17、谁是c的构造函数?
### 18、readystate 0~4
### 19、== 和 === 有什么区别？
### 20、使用 + 或一元加运算符是将字符串转换为数字的最快方法吗？
### 21、ajax中 get 和 post 有什么区别?
### 22、谈谈This对象的理解
### 23、JavaScript有几种类型的值？，你能画一下他们的内存图吗？
### 24、同步和异步的区别?
### 25、作用域和执行上下文的区别是什么？
### 26、js延迟加载的方式有哪些？
### 27、什么是事件捕获？
### 28、同步和异步的区别?
### 29、什么是NaN？以及如何检查值是否为NaN？
### 30、什么是跨域？怎么解决跨域问题？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
