# JavaScript最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、数据持久化技术(ajax)?简述ajax流程###

**1、** 客户端产生js的事件

**2、** 创建XMLHttpRequest对象

**3、** 对XMLHttpRequest进行配置

**4、** 通过AJAX引擎发送异步请求

**5、** 服务器端接收请求并且处理请求，返回html或者xml内容

**6、** XML调用一个callback()处理响应回来的内容

**7、** 页面局部刷新


### 2、split() join()?

前者是切割成数组的形式，

后者是将数组转换成字符串


### 3、用过哪些设计模式？

**工厂模式：**

**1、** 工厂模式解决了重复实例化的问题，但还有一个问题,那就是识别问题，因为根本无法

**2、** 主要好处就是可以消除对象间的耦合，通过使用工程方法而不是`new`关键字

**构造函数模式**

**1、** 使用构造函数的方法，即解决了重复实例化的问题，又解决了对象识别的问题，该模式与工厂模式的不同之处在于

**2、** 直接将属性和方法赋值给 `this`对象;


### 4、sessionStorage和localstroage与cookie之间有什么关联, cookie最大存放多少字节

**三者共同点：**

都是保存在浏览器端，且同源的。

区别:

**1、** cookie在浏览器和服务器间来回传递。而sessionStorage和localStorage不会自动把数据发给服务器，仅在本地保存

**2、** 存储大小限制也不同，cookie数据不能超过4k，sessionStorage和localStorage 但比cookie大得多，可以达到5M

**3、** 数据有效期不同，sessionStorage：仅在当前浏览器窗口关闭前有效，自然也就不可能持久保持；localStorage：始终有效，窗口或浏览器关闭也一直保存，因此用作持久数据；cookie只在设置的cookie过期时间之前一直有效，即使窗口或浏览器关闭

**4、** 作用域不同，sessionStorage不在不同的浏览器窗口中共享，即使是同一个页面(即数据不共享)；localStorage 在所有同源窗口中都是共享的；cookie也是在所有同源窗口中都是共享的( 即数据共享 )。


### 5、Jq中有几种选择器?分别是什么?

层叠选择器、基本过滤选择器、内容过滤选择器、可视化过滤选择器、属性过滤选择器、子元素过滤选择器、表单元素选择器、表单元素过滤选择器


### 6、JavaScript有几种类型的值？，你能画一下他们的内存图吗？

**1、** 栈：原始数据类型（`Undefined`，`Null`，`Boolean`，`Numbe`r、`String`）

**2、** 堆：引用数据类型（对象、数组和函数）

**3、** 两种类型的区别是：存储位置不同；

**4、** 原始数据类型直接存储在栈(`stack`)中的简单数据段，占据空间小、大小固定，属于被频繁使用数据，所以放入栈中存储；

**5、** 引用数据类型存储在堆(`heap`)中的对象,占据空间大、大小不固定,如果存储在栈中，将会影响程序运行的性能；引用数据类型在栈中存储了指针，该指针指向堆中该实体的起始地址。当解释器寻找引用值时，会首先检索其

**6、** 在栈中的地址，取得地址后从堆中获得实体

![33_1.png][33_1.png]


### 7、什么是对象解构？

**对象析构**是从对象或数组中获取或提取值的一种新的、更简洁的方法。假设有如下的对象：

```
const employee = {
  firstName: "Marko",
  lastName: "Polo",
  position: "Software Developer",
  yearHired: 2017
};
```

从对象获取属性，早期方法是创建一个与对象属性同名的变量。这种方法很麻烦，因为我们要为每个属性创建一个新变量。假设我们有一个大对象，它有很多属性和方法，用这种方法提取属性会很麻烦。

`var firstName = employee.firstName; var lastName = employee.lastName; var position = employee.position; var yearHired = employee.yearHired;`

使用解构方式语法就变得简洁多了：

`{ firstName, lastName, position, yearHired } = employee;`

我们还可以为属性取别名：

`let { firstName: fName, lastName: lName, position, yearHired } = employee;`

当然如果属性值为 `undefined` 时，我们还可以指定默认值：

`let { firstName = "Mark", lastName: lName, position, yearHired } = employee;`


### 8、模块化开发怎么做？

立即执行函数,不暴露私有成员

```
var module1 = (function(){
　　　　var _count = 0;
　　　　var m1 = function(){
　　　　　　//...
　　　　};
　　　　var m2 = function(){
　　　　　　//...
　　　　};
　　　　return {
　　　　　　m1 : m1,
　　　　　　m2 : m2
　　　　};
　　})();
```


### 9、为什么此代码 `obj.someprop.x` 会引发错误?

```
const obj = {};console.log(obj.someprop.x);
```

显然，由于我们尝试访问`someprop`属性中的`x`属性，而 someprop 并没有在对象中，所以值为 `undefined`。记住对象本身不存在的属性，并且其原型的默认值为`undefined`。因为`undefined`没有属性`x`，所以试图访问将会报错。


### 10、实现异步的方式有哪些？

**1、** 回调函数模式：将需要异步执行的函数作为回调函数执行，其缺点在于处理复杂逻辑异步逻辑时，会造成回调地狱(回调嵌套层数太多，代码结构混乱)；

**2、** 事件监听模式：采用事件驱动的思想，当某一事件发生时触发执行异步函数，其缺点在于整个代码全部得变为事件驱动模式，难以分辨主流程；

**3、** 发布订阅模式：当异步任务执行完成时发布消息给信号中心，其他任务通过在信号中心中订阅消息来确定自己是否开始执行；

**4、** Promise(ES6)：`Promise`对象共有三种状态`pending`(初始化状态)、`fulfilled`(成功状态)、`rejected`(失败状态)。

**5、** async/await(ES7)：基于`Promise`实现的异步函数； （6）利用生成器实现。


### 11、回调函数?
### 12、jquery和zepto有什么区别?
### 13、介绍js有哪些内置对象？
### 14、函数表达式和函数声明之间有什么区别？
### 15、调用函数，可以使用哪些方法？
### 16、与深拷贝有何区别？如何实现？
### 17、`Function.prototype.call` 方法的用途是什么？
### 18、什么是NaN？以及如何检查值是否为NaN？
### 19、一般使用什么版本控制工具?svn如何对文件加锁###
### 20、谈谈你对ES6的理解
### 21、ajax 是什么?
### 22、什么是模板字符串？
### 23、事件流?事件捕获？事件冒泡？
### 24、Gc机制是什么？为什么闭包不会被回收变量和函数？
### 25、JS是如何实现异步的？
### 26、为什么函数被称为一等公民？
### 27、什么是 event.target ？
### 28、如何在 JS 中创建对象？
### 29、web开发中会话跟踪的方法有哪些




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
