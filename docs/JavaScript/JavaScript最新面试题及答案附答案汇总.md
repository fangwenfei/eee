# JavaScript最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、事件流?事件捕获？事件冒泡？

**事件流：**

从页面中接收事件的顺序。也就是说当一个事件产生时，这个事件的传播过程，就是事件流。

IE中的事件流叫事件冒泡；

事件冒泡：

事件开始时由最具体的元素接收，然后逐级向上传播到较为不具体的节点（文档）。对于html来说，就是当一个元素产生了一个事件，它会把这个事件传递给它的父元素，父元素接收到了之后，还要继续传递给它的上一级元素，就这样一直传播到document对象（亲测现在的浏览器到window对象，只有IE8及下不这样

事件捕获是不太具体的元素应该更早接受到事件，而最具体的节点应该最后接收到事件。他们的用意是在事件到达目标之前就捕获它；也就是跟冒泡的过程正好相反，以html的click事件为例，document对象（DOM级规范要求从document开始传播，但是现在的浏览器是从window对象开始的）最先接收到click事件的然后事件沿着DOM树依次向下传播，一直传播到事件的实际目标；


### 2、`in` 运算符和 `Object.hasOwnProperty` 方法有什么区别？

**hasOwnPropert方法**

`hasOwnPropert()`方法返回值是一个布尔值，指示对象自身属性中是否具有指定的属性，因此这个方法会忽略掉那些从原型链上继承到的属性。

看下面的例子：

```
Object.prototype.phone= '15345025546';

let obj = {
  name: 'kyle',
  age: '28'
}
console.log(obj.hasOwnProperty('phone')) // false
console.log(obj.hasOwnProperty('name')) // true
```

可以看到，如果在函数原型上定义一个变量`phone`，`hasOwnProperty`方法会直接忽略掉。

**in 运算符**

如果指定的属性在指定的对象或其原型链中，则`in` 运算符返回`true`。

还是用上面的例子来演示：

`console.log('phone' in obj) // true`

可以看到`in`运算符会检查它或者其原型链是否包含具有指定名称的属性。


### 3、js延迟加载的方式有哪些？

`defer`和`async`、动态创建`DOM`方式（用得最多）、按需异步载入`js`


### 4、几种基本数据类型?复杂数据类型?值类型和引用数据类型?堆栈数据结构

**1、** 基本数据类型：Undefined、Null、Boolean、Number、String

**2、** 值类型：数值、布尔值、null、undefined。

**3、** 引用类型：对象、数组、函数。

**4、** 堆栈数据结构：是一种支持后进先出(LIFO)的集合,即后被插入的数据,先被取出!

**5、** js数组中提供了以下几个方法可以让我们很方便实现堆栈：

**6、** shift:从数组中把第一个元素删除，并返回这个元素的值。

**7、** unshift: 在数组的开头添加一个或更多元素，并返回新的长度

**8、** push:在数组的中末尾添加元素，并返回新的长度

**9、** pop:从数组中把最后一个元素删除，并返回这个元素的值。


### 5、同步异步?

**1、** 进程同步：就是在发出一个功能调用时，在没有得到结果之前，该调用就不返回。也就是必须一件一件事做,等前一件做完了才能做下一件事

**2、** 异步的概念和同步相对。当一个异步过程调用发出后，调用者不能立刻得到结果。实际处理这个调用的部件在完成后，通过状态、通知和回调来通知调用者。


### 6、如何清除一个定时器?

window.clearInterval();

window.clearTimeout();


### 7、eval是做什么的？

**1、** 它的功能是把对应的字符串解析成`JS`代码并运行

**2、** 应该避免使用`eval`，不安全，非常耗性能（`2`次，一次解析成`js`语句，一次执行）

**3、** 由`JSON`字符串转换为JSON对象的时候可以用`eval，var obj =eval('('+ str +')')`


### 8、函数表达式和函数声明之间有什么区别？

看下面的例子：

```
hoistedFunc();
notHoistedFunc();

function hoistedFunc(){
  console.log("注意：我会被提升");
}

var notHoistedFunc = function(){
  console.log("注意：我没有被提升");
}
```

`notHoistedFunc`调用抛出异常：`Uncaught TypeError: notHoistedFunc is not a function`，而`hoistedFunc`调用不会，因为`hoistedFunc`会被提升到作用域的顶部，而`notHoistedFunc` 不会。


### 9、js的几种继承方式？

**1、** 使用对象冒充实现继承

**2、** 采用call、Apply方法改变函数上下文实现继承

**3、** 原型链方式继承


### 10、介绍js的基本数据类型

`Undefined`、`Null`、`Boolean`、`Number`、`String`


### 11、如何判断值是否为数组？
### 12、声明函数作用提升?声明变量和声明函数的提升有什么区别
### 13、回调函数?
### 14、JavaScript原型，原型链 ? 有什么特点？
### 15、那些操作会造成内存泄漏？
### 16、Jq中 attr 和 prop 有什么区别###
### 17、作用域和执行上下文的区别是什么？
### 18、new 关键字有什么作用？
### 19、强制转换 显式转换 隐式转换?
### 20、编写一个 getElementsByClassName 封装函数?
### 21、事件模型
### 22、什么是NaN？以及如何检查值是否为NaN？
### 23、那些操作会造成内存泄漏？
### 24、手动实现缓存方法
### 25、26.移动端上什么是点击穿透?
### 26、DOM 是什么？
### 27、如何在不使用`%`模运算符的情况下检查一个数字是否是偶数？
### 28、压缩合并目的？http请求的优化方式？
### 29、简述下工作流程###




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
