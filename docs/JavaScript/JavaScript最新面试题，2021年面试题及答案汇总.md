# JavaScript最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、怎么理解Promise对象？

**`Promise`对象有如下两个特点：**

**1、** 对象的状态不受外界影响。`Promise`对象共有三种状态`pending`、`fulfilled`、`rejected`。状态值只会被异步结果决定，其他任何操作无法改变。

**2、** 状态一旦成型，就不会再变，且任何时候都可得到这个结果。状态值会由`pending`变为`fulfilled`或`rejected`，这时即为`resolved`。

**Promise的缺点有如下三个缺点：**

**1、** `Promise`一旦执行便无法被取消；

**2、** 不可设置回调函数，其内部发生的错误无法捕获；

**3、** 当处于`pending`状态时，无法得知其具体发展到了哪个阶段。

**`Pomise`中常用的方法有：**

**1、** `Promise.prototype.then()`：`Promise`实例的状态发生改变时，会调用`then`内部的回调函数。`then`方法接受两个参数（第一个为`resolved`状态时时执行的回调，第一个为`rejected`状态时时执行的回调）

**2、** `Promise.prototype.catch()`：`.then(null, rejection)`或`.then(undefined, rejection)`的别名，用于指定发生错误时的回调函数。


### 2、什么是 event.currentTarget？？

`event.currentTarget`是我们在其上显式附加事件处理程序的元素。

假设有如下的 HTML 结构：

```
<div onclick="clickFunc(event)" style="text-align: center;margin:15px;
border:1px solid red;border-radius:3px;">
  <div style="margin: 25px; border:1px solid royalblue;border-radius:3px;">
      <div style="margin:25px;border:1px solid skyblue;border-radius:3px;">
        <button style="margin:10px">
           Button
        </button>
      </div>
  </div>
</div>
```

JS 代码如下：

```
function clickFunc(event) {
  console.log(event.currentTarget);
}
```

如果单击 `button`，即使我们单击该 `button`，它也会打印最外面的`div`标签。在此示例中，我们可以得出结论，`event.currentTarget`是附加事件处理程序的元素。


### 3、`require`/`import`之间的区别？

**1、** `require`是CommonJS语法，`import`是ES6语法；

**2、** `require`只在后端服务器支持，`import`在高版本浏览器及Node中都可以支持；

**3、** `require`引入的是原始导出值的复制，`import`则是导出值的引用；

**4、** `require`时运行时动态加载，`import`是静态编译；

**5、** `require`调用时默认不是严格模式，`import`则默认调用严格模式.

### 4、this指向的各种情况都有什么？

this的指向只有在调用时才能被确定，因为`this`是执行上下文的一部分。

**全局作用域中的函数：其内部`this`指向`window`：**

```
var a = 1;
function fn(){
console.log(this.a)
}
fn() //输出1
```

**对象内部的函数：其内部`this`指向对象本身：**

```
var a = 1;
var obj = {
a:2,
fn:function(){
console.log(this.a)
}
}

obj.fn() //输出2
```

**构造函数：其内部`this`指向生成的实例：**

```
function createP(name,age){
this.name = name //this.name指向P
this.age = age //this.age指向P
}
var p = new createP("老李",46)
```

**由`apply`、`call`、`bind`改造的函数：其`this`指向第一个参数：**

```
function add(c,d){
return this.a + this.b + c + d
}
var o = {a:1,b:2)
add.call(o,5,7) //输出15
```

箭头函数：箭头函数没有自己的`this`，看其外层的是否有函数，如果有，外层函数的`this`就是内部箭头函数的`this`，如果没有，则`this`是`window`。


### 5、JS是如何实现异步的？

JS引擎是单线程的，但又能实现异步的原因在于事件循环和任务队列体系。

**事件循环：**

**1、** JS 会创建一个类似于 `while (true)` 的循环，每执行一次循环体的过程称之为 `Tick`。每次 `Tick` 的过程就是查看是否有待处理事件，如果有则取出相关事件及回调函数放入执行栈中由主线程执行。待处理的事件会存储在一个任务队列中，也就是每次 `Tick` 会查看任务队列中是否有需要执行的任务。

**任务队列：**

**1、** 异步操作会将相关回调添加到任务队列中。而不同的异步操作添加到任务队列的时机也不同，如 `onclick`, `setTimeout`, `ajax` 处理的方式都不同，这些异步操作是由浏览器内核的 `webcore` 来执行的，浏览器内核包含3种 webAPI，分别是 `DOM Binding`、`network`、`timer`模块。

**2、** `onclick` 由 `DOM Binding` 模块来处理，当事件触发的时候，回调函数会立即添加到任务队列中。 `setTimeout` 由 `timer` 模块来进行延时处理，当时间到达的时候，才会将回调函数添加到任务队列中。 `ajax` 由`network` 模块来处理，在网络请求完成返回之后，才将回调添加到任务队列中。

**主线程：**

**1、** JS 只有一个线程，称之为主线程。而事件循环是主线程中执行栈里的代码执行完毕之后，才开始执行的。所以，主线程中要执行的代码时间过长，会阻塞事件循环的执行，也就会阻塞异步操作的执行。

**2、** 只有当主线程中执行栈为空的时候（即同步代码执行完后），才会进行事件循环来观察要执行的事件回调，当事件循环检测到任务队列中有事件就取出相关回调放入执行栈中由主线程执行。


### 6、new操作符具体干了什么呢?

**1、** 创建一个空对象，并且 `this` 变量引用该对象，同时还继承了该函数的原型

**2、** 属性和方法被加入到 `this` 引用的对象中

**3、** 新创建的对象由 `this` 所引用，并且最后隐式的返回 `this`


### 7、typeof？typeof [ ]返回数据类型是？

```
//判断基本数据类型；var a=[];typeof a输出object；
//本来判断一个对象类型用typeof是最好的，不过对于Array类型是不适用的，
//可以使用 instanceof操作符：
       var arrayStr=new Array("1","2","3","4","5");    
       alert(arrayStr instanceof Array); 
//当然以上在一个简单的页面布局里面是没有问题的，如果是复杂页面情况，
//入获取的是frame内部的Array对象，可以用这个函数判断：
       function isArray(obj) {      
          return Object.prototype.toString.call(obj) === '[object Array]';       
       }
```


### 8、Gc机制是什么？为什么闭包不会被回收变量和函数？

**1、** Gc垃圾回收机制;

**2、** 外部变量没释放，所以指向的大函数内的小函数也释放不了


### 9、'use strict' 是干嘛用的？

`"use strict"` 是 **ES5** 特性，它使我们的代码在函数或整个脚本中处于**严格模式**。**严格模式**帮助我们在代码的早期避免 bug，并为其添加限制。

**严格模式**的一些限制：

**1、** 变量必须声明后再使用

**2、** 函数的参数不能有同名属性，否则报错

**3、** 不能使用`with`语句

**4、** 不能对只读属性赋值，否则报错

**5、** 不能使用前缀 0 表示八进制数，否则报错

**6、** 不能删除不可删除的属性，否则报错

**7、** 不能删除变量`delete prop`，会报错，只能删除属性`delete global[prop]`

**8、** `eval`不能在它的外层作用域引入变量

**9、** `eval`和`arguments`不能被重新赋值

**10、** `arguments`不会自动反映函数参数的变化

**11、** 不能使用`arguments.callee`

**12、** 不能使用`arguments.caller`

**13、** 禁止`this`指向全局对象

**14、** 不能使用`fn.caller`和`fn.arguments`获取函数调用的堆栈

**15、** 增加了保留字（比如`protected`、`static`和`interface`）

设立”严格模式”的目的，主要有以下几个：

**1、** 消除Javascript语法的一些不合理、不严谨之处，减少一些怪异行为;

**2、** 消除代码运行的一些不安全之处，保证代码运行的安全；

**3、** 提高编译器效率，增加运行速度；

**4、** 为未来新版本的Javascript做好铺垫。


### 10、window.onload ==? DOMContentLoaded ?

一般情况下，DOMContentLoaded事件要在window.onload之前执行，当DOM树构建完成的时候就会执行DOMContentLoaded事件，而window.onload是在页面载入完成的时候，才执行，这其中包括图片等元素。大多数时候我们只是想在DOM树构建完成后，绑定事件到元素，我们并不需要图片元素，加上有时候加载外域图片的速度非常缓慢。


### 11、手动实现 `Array.prototype.map 方法`
### 12、如何创建一个没有 prototype(原型)的对象？
### 13、如何确保ajax或连接不走缓存路径
### 14、Ajax原理
### 15、什么是NaN？以及如何检查值是否为NaN？
### 16、Jq绑定事件的几种方式？on bind ?
### 17、jsonp原理？ 缺点?
### 18、回调函数?
### 19、什么是类？
### 20、如何添加一个dom对象到body中?innerHTML和innerText区别?
### 21、异步编程？
### 22、什么是高阶函数？
### 23、`in` 运算符和 `Object.hasOwnProperty` 方法有什么区别？
### 24、split() join()?
### 25、$$('div+.ab')和$$('.ab+div') 哪个效率高？
### 26、什么是闭包？
### 27、ES6或ECMAScript 2015有哪些新特性？
### 28、异步加载JS的方式有哪些？
### 29、什么是执行上下文和执行栈？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
