# JavaScript最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、如何copy一个dom元素？

原生Js方法：var div = document.getElementsByTagName('div')[0];

var clone = div.cloneNode();

Jquery方法：$('div').clone();

在默认情况下，.clone()方法不会复制匹配的元素或其后代元素中绑定的事件。不过，可以为这个方法传递一个布尔值参数，将这个参数设置为true, 就可以连同事件一起复制，即.clone(true)。


### 2、sessionStorage和localstroage与cookie之间有什么关联, cookie最大存放多少字节

**三者共同点：**

都是保存在浏览器端，且同源的。

区别:

**1、** cookie在浏览器和服务器间来回传递。而sessionStorage和localStorage不会自动把数据发给服务器，仅在本地保存

**2、** 存储大小限制也不同，cookie数据不能超过4k，sessionStorage和localStorage 但比cookie大得多，可以达到5M

**3、** 数据有效期不同，sessionStorage：仅在当前浏览器窗口关闭前有效，自然也就不可能持久保持；localStorage：始终有效，窗口或浏览器关闭也一直保存，因此用作持久数据；cookie只在设置的cookie过期时间之前一直有效，即使窗口或浏览器关闭

**4、** 作用域不同，sessionStorage不在不同的浏览器窗口中共享，即使是同一个页面(即数据不共享)；localStorage 在所有同源窗口中都是共享的；cookie也是在所有同源窗口中都是共享的( 即数据共享 )。


### 3、实现异步的方式有哪些？

**1、** 回调函数模式：将需要异步执行的函数作为回调函数执行，其缺点在于处理复杂逻辑异步逻辑时，会造成回调地狱(回调嵌套层数太多，代码结构混乱)；

**2、** 事件监听模式：采用事件驱动的思想，当某一事件发生时触发执行异步函数，其缺点在于整个代码全部得变为事件驱动模式，难以分辨主流程；

**3、** 发布订阅模式：当异步任务执行完成时发布消息给信号中心，其他任务通过在信号中心中订阅消息来确定自己是否开始执行；

**4、** Promise(ES6)：`Promise`对象共有三种状态`pending`(初始化状态)、`fulfilled`(成功状态)、`rejected`(失败状态)。

**5、** async/await(ES7)：基于`Promise`实现的异步函数； （6）利用生成器实现。


### 4、数据持久化技术(ajax)?简述ajax流程###

**1、** 客户端产生js的事件

**2、** 创建XMLHttpRequest对象

**3、** 对XMLHttpRequest进行配置

**4、** 通过AJAX引擎发送异步请求

**5、** 服务器端接收请求并且处理请求，返回html或者xml内容

**6、** XML调用一个callback()处理响应回来的内容

**7、** 页面局部刷新


### 5、什么是对象解构？

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


### 6、通过new创建一个对象的时候，函数内部有哪些改变###

```
function Person(){}
Person.prototype.friend = [];
Person.prototype.name = '';
// var a = new Person();
// a.friend[0] = '王琦';
// a.name = '程娇';
// var b = new Person();
// b.friend？
// b.name?
```

**1、** 创建一个空对象，并且 this 变量引用该对象，同时还继承了该函数的原型。

**2、** 属性和方法被加入到 this 引用的对象中。

**3、** 新创建的对象由 this 所引用，并且最后隐式的返回 this 。


### 7、同步异步?

**1、** 进程同步：就是在发出一个功能调用时，在没有得到结果之前，该调用就不返回。也就是必须一件一件事做,等前一件做完了才能做下一件事

**2、** 异步的概念和同步相对。当一个异步过程调用发出后，调用者不能立刻得到结果。实际处理这个调用的部件在完成后，通过状态、通知和回调来通知调用者。


### 8、JavaScript 中 `this` 值是什么？

基本上，`this`指的是当前正在执行或调用该函数的对象的值。`this`值的变化取决于我们使用它的上下文和我们在哪里使用它。

```
const carDetails = {
  name: "Ford Mustang",
  yearBought: 2005,
  getName(){
    return this.name;
  },
  isRegistered: true
};

console.log(carDetails.getName()); // Ford Mustang
```

这通常是我们期望结果的，因为在`getName`方法中我们返回`this.name`，在此上下文中，`this`指向的是`carDetails`对象，该对象当前是执行函数的“所有者”对象。

接下我们做些奇怪的事情：

```
var name = "Ford Ranger";
var getCarName = carDetails.getName;

console.log(getCarName()); // Ford Ranger
```

上面打印`Ford Ranger`，这很奇怪，因为在第一个`console.log`语句中打印的是`Ford Mustang`。这样做的原因是`getCarName`方法有一个不同的“所有者”对象，即`window`对象。在全局作用域中使用`var`关键字声明变量会在`window`对象中附加与变量名称相同的属性。请记住，当没有使用`“use strict”`时，在全局作用域中`this`指的是`window`对象。

`console.log(getCarName === window.getCarName); // true console.log(getCarName === this.getCarName); // true`

本例中的`this`和`window`引用同一个对象。

解决这个问题的一种方法是在函数中使用`apply`和`call`方法。

`console.log(getCarName.apply(carDetails)); // Ford Mustang console.log(getCarName.call(carDetails)); // Ford Mustang`

`apply`和`call`方法期望第一个参数是一个对象，该对象是函数内部`this`的值。

`IIFE`或**立即执行的函数表达式**，在全局作用域内声明的函数，对象内部方法中的匿名函数和内部函数的`this`具有默认值，该值指向`window`对象。

```
(function (){
 console.log(this);
})(); // 打印 "window" 对象

function iHateThis(){
  console.log(this);
}

iHateThis(); // 打印 "window" 对象

const myFavoriteObj = {
 guessThis(){
    function getName(){
      console.log(this.name);
    }
    getName();
 },
 name: 'Marko Polo',
 thisIsAnnoying(callback){
   callback();
 }
};

myFavoriteObj.guessThis(); // 打印 "window" 对象
myFavoriteObj.thisIsAnnoying(function (){
 console.log(this); // 打印 "window" 对象
});
```

如果我们要获取`myFavoriteObj`对象中的`name`属性（即**Marko Polo**）的值，则有两种方法可以解决此问题。

一种是将 `this` 值保存在变量中。

```
const myFavoriteObj = {
 guessThis(){
  const self = this; // 把 this 值保存在 self 变量中
  function getName(){
    console.log(self.name);
  }
  getName();
 },
 name: 'Marko Polo',
 thisIsAnnoying(callback){
   callback();
  }
};
```

第二种方式是使用箭头函数

```
const myFavoriteObj = {
  guessThis(){
     const getName = () => { 
       console.log(this.name);
     }
     getName();
  },
  name: 'Marko Polo',
  thisIsAnnoying(callback){
   callback();
  }
};
```

箭头函数没有自己的 `this`。它复制了这个封闭的词法作用域中`this`值，在这个例子中，`this`值在`getName`内部函数之外，也就是`myFavoriteObj`对象。


### 9、disabled readyonly?

readonly只针对input(text / password)和textarea有效，而disabled对于所有的表单元素都有效，当表单元素在使用了disabled后，当我们将表单以POST或GET的方式提交的话，这个元素的值不会被传递出去，而readonly会将该值传递出去。


### 10、什么是构造函数？与普通函数有什么区别?

构造函数：是一种特殊的方法、主要用来创建对象时初始化对象，总与new运算符一起使用，创建对象的语句中构造函数的函数名必须与类名完全相同。

与普通函数相比只能由new关键字调用，构造函数是类的标示


### 11、jquery和zepto有什么区别?
### 12、说几条写JavaScript的基本规范？
### 13、slice() splice()?
### 14、节点类型?判断当前节点类型?
### 15、上一个项目是什么？主要负责哪些？购物车流程?支付功能?
### 16、什么是事件冒泡？
### 17、开发时如何对项目进行管理?gulp?
### 18、30.Jq中怎么样编写插件?
### 19、什么是函数式编程? JavaScript 的哪些特性使其成为函数式语言的候选语言？
### 20、web开发中会话跟踪的方法有哪些
### 21、defer和async
### 22、sass和less有什么区别?
### 23、bootstrap好处？
### 24、Function.prototype.apply 和 Function.prototype.call 之间有什么区别？
### 25、arguments 的对象是什么？
### 26、说说你对作用域链的理解
### 27、JavaScript原型，原型链 ? 有什么特点？
### 28、JavaScript有几种类型的值？，你能画一下他们的内存图吗？
### 29、数组的排序方法（sort）？排序？汉字排序？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
