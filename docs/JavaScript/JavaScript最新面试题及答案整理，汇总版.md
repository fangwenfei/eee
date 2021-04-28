# JavaScript最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是类？

`类(class)`是在 JS 中编写构造函数的新方法。它是使用构造函数的语法糖，在底层中使用仍然是原型和基于原型的继承。

```
//ES5 Version
 function Person(firstName, lastName, age, address){
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.address = address;
 }

 Person.self = function(){
   return this;
 }

 Person.prototype.toString = function(){
   return "[object Person]";
 }

 Person.prototype.getFullName = function (){
   return this.firstName + " " + this.lastName;
 }  

 //ES6 Version
 class Person {
    constructor(firstName, lastName, age, address){
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.address = address;
    }

    static self() {
       return this;
    }

    toString(){
       return "[object Person]";
    }

    getFullName(){
       return `${this.firstName} ${this.lastName}`;
    }
 }
```

重写方法并从另一个类继承。

```
//ES5 Version
Employee.prototype = Object.create(Person.prototype);

function Employee(firstName, lastName, age, address, jobTitle, yearStarted) {
  Person.call(this, firstName, lastName, age, address);
  this.jobTitle = jobTitle;
  this.yearStarted = yearStarted;
}

Employee.prototype.describe = function () {
  return `I am ${this.getFullName()} and I have a position of ${this.jobTitle} and I started at ${this.yearStarted}`;
}

Employee.prototype.toString = function () {
  return "[object Employee]";
}

//ES6 Version
class Employee extends Person { //Inherits from "Person" class
  constructor(firstName, lastName, age, address, jobTitle, yearStarted) {
    super(firstName, lastName, age, address);
    this.jobTitle = jobTitle;
    this.yearStarted = yearStarted;
  }

  describe() {
    return `I am ${this.getFullName()} and I have a position of ${this.jobTitle} and I started at ${this.yearStarted}`;
  }

  toString() { // Overriding the "toString" method of "Person"
    return "[object Employee]";
  }
}
```

**所以我们要怎么知道它在内部使用原型？**

```
class Something {

}

function AnotherSomething(){

}
const as = new AnotherSomething();
const s = new Something();

console.log(typeof Something); // "function"
console.log(typeof AnotherSomething); // "function"
console.log(as.toString()); // "[object Object]"
console.log(as.toString()); // "[object Object]"
console.log(as.toString === Object.prototype.toString); // true
console.log(s.toString === Object.prototype.toString); // true
```


### 2、说说你对AMD和Commonjs的理解

**1、** `CommonJS`是服务器端模块的规范，`Node.js`采用了这个规范。`CommonJS`规范加载模块是同步的，也就是说，只有加载完成，才能执行后面的操作。`AMD`规范则是非同步加载模块，允许指定回调函数

**2、** `AMD`推荐的风格通过返回一个对象做为模块对象，`CommonJS`的风格通过对`module.exports`或`exports`的属性赋值来达到暴露模块对象的目的


### 3、除了jsonp 还有什么跨域方式###

javascript跨域有两种情况：

**1、** 基于同一父域的子域之间，如： [http://a.c.com](http://link.zhihu.com/?target=http%3A//a.c.com)和 [http://b.c.com](http://link.zhihu.com/?target=http%3A//b.c.com)

**2、** 基于不同的父域之间，如： [http://www.a.com](http://link.zhihu.com/?target=http%3A//www.a.com)和 [http://www.b.com](http://link.zhihu.com/?target=http%3A//www.b.com)

**3、** 端口的不同，如： [http://www.a.com:8080](http://link.zhihu.com/?target=http%3A//www.a.com%3A8080)和 [http://www.a.com:8088](http://link.zhihu.com/?target=http%3A//www.a.com%3A8088)

**4、** 协议不同，如： [http://www.a.com](http://link.zhihu.com/?target=http%3A//www.a.com)和 [https://www.a.com](http://link.zhihu.com/?target=https%3A//www.a.com)

**对于情况3和4，需要通过后台proxy来解决，具体方式如下：**

a、在发起方的域下创建proxy程序

b、发起方的js调用本域下的proxy程序

c、proxy将请求发送给接收方并获取相应数据

d、proxy将获得的数据返回给发起方的js

代码和ajax调用一致，其实这种方式就是通过ajax进行调用的

而情况1和2除了通过后台proxy这种方式外，还可以有多种办法来解决：

**1、** document.domain+iframe（只能解决情况1）：

a、在发起方页面和接收方页面设置document.domain，并将值设为父域的主域名(window.location.hostname)

b、在发起方页面创建一个隐藏的iframe，iframe的源是接收方页面

c、根据浏览器的不同，通过iframe.contentDocument || iframe.contentWindow.document来获得接收方页面的内容

d、通过获得的接收方页面的内容来与接收方进行交互

这种方法有个缺点，就是当一个域被攻击时，另一个域会有安全漏洞出现。


### 4、上一个项目是什么？主要负责哪些？购物车流程?支付功能?

**主要负责哪些就讲主要做哪些功能模块：**

1）商品模块:

**1、** 商品列表：商品排序 商品筛选 商品过滤 商品查询 商品推荐

**2、** 商品详情:类型推荐 商品简介 商品详情 商品评价 售后维护

2)购物车模块：商品编号、数量、价格、总额、运费、运输选项、运费总计、从购物车删除选项、更新数量、结账、继续购物、商品描述、库存信息


### 5、Jq中有几种选择器?分别是什么?

层叠选择器、基本过滤选择器、内容过滤选择器、可视化过滤选择器、属性过滤选择器、子元素过滤选择器、表单元素选择器、表单元素过滤选择器


### 6、JavaScript提供了哪几种“异步模式”？

**1、** 回调函数（callbacks）

**2、** 事件监听

**3、** Promise对象


### 7、什么是闭包？

这可能是所有问题中最难的一个问题，因为闭包是一个有争议的话题，这里从个人角度来谈谈，如果不妥，多多海涵。

**闭包**就是一个函数在声明时能够记住当前作用域、父函数作用域、及父函数作用域上的变量和参数的引用，直至通过作用域链上全局作用域，基本上闭包是在声明函数时创建的作用域。

看看小例子：

```
// 全局作用域
 var globalVar = "abc";

 function a(){
   console.log(globalVar);
 }

 a(); // "abc"
```

在此示例中，当我们声明`a`函数时，全局作用域是`a`闭包的一部分。

变量`globalVar`在图中没有值的原因是该变量的值可以根据调用函数`a`的位置和时间而改变。但是在上面的示例中，`globalVar`变量的值为`abc`。

来看一个更复杂的例子：

```
var globalVar = "global";
var outerVar = "outer"

function outerFunc(outerParam) {
  function innerFunc(innerParam) {
    console.log(globalVar, outerParam, innerParam);
  }
  return innerFunc;
}

const x = outerFunc(outerVar);
outerVar = "outer-2";
globalVar = "guess"
x("inner");
```

上面打印结果是  `guess outer inner`。

当我们调用`outerFunc`函数并将返回值`innerFunc`函数分配给变量`x`时，即使我们为`outerVar`变量分配了新值`outer-2`，`outerParam`也继续保留`outer`值，因为重新分配是在调用`outerFunc`之后发生的，并且当我们调用`outerFunc`函数时，它会在作用域链中查找`outerVar`的值，此时的`outerVar`的值将为 `"outer"`。

现在，当我们调用引用了`innerFunc`的`x`变量时，`innerParam`将具有一个`inner`值，因为这是我们在调用中传递的值，而`globalVar`变量值为`guess`，因为在调用`x`变量之前，我们将一个新值分配给`globalVar`。

下面这个示例演示没有理解好闭包所犯的错误：

```
const arrFuncs = [];
for(var i = 0; i < 5; i++){
  arrFuncs.push(function (){
    return i;
  });
}
console.log(i); // i is 5

for (let i = 0; i < arrFuncs.length; i++) {
  console.log(arrFuncs[i]()); // 都打印 5
}
```

由于闭包，此代码无法正常运行。`var`关键字创建一个全局变量，当我们 push 一个函数时，这里返回的全局变量`i`。因此，当我们在循环后在该数组中调用其中一个函数时，它会打印`5`，因为我们得到`i`的当前值为`5`，我们可以访问它，因为它是全局变量。

因为闭包在创建变量时会保留该变量的引用而不是其值。我们可以使用**IIFES**或使用 `let` 来代替 `var` 的声明。


### 8、Function.prototype.apply 方法的用途是什么？

`apply()` 方法调用一个具有给定this值的函数，以及作为一个数组（或类似数组对象）提供的参数。

```
const details = {
  message: 'Hello World!'
};

function getMessage(){
  return this.message;
}

getMessage.apply(details); // 'Hello World!'
```

> `call()`方法的作用和 `apply()` 方法类似，区别就是`call()`方法接受的是参数列表，而`apply()`方法接受的是一个参数数组。


```
const person = {
  name: "Marko Polo"
};

function greeting(greetingMessage) {
  return `${greetingMessage} ${this.name}`;
}

greeting.apply(person, ['Hello']); // "Hello Marko Polo!"
```


### 9、ajax 是什么?

异步javascript和XML，是指一种创建交互式网页应用的网页开发技术。通过后台与服务器进行少量数据交换，AJAX可以使网页实现异步更新。这意味着可以在不重新加载整个网页的情况下，对网页的某部分进行更新。


### 10、如何使用storage 对js文件进行缓存

由于sessionStorage - 针对一个 session 的数据存储，所以我们一般利用localStorage储存js文件，只有在第一次访问该页面的时候加载js文件，以后在访问的时候加载本地localStorage执行


### 11、与深拷贝有何区别？如何实现？
### 12、什么是事件传播?
### 13、模块化开发怎么做？
### 14、你觉得jQuery源码有哪些写的好的地方
### 15、为什么typeof null 返回 object？如何检查一个值是否为 null？
### 16、为什么此代码 `obj.someprop.x` 会引发错误?
### 17、JS是如何实现异步的？
### 18、什么是作用域？
### 19、js延迟加载的方式有哪些？
### 20、什么是回调函数？
### 21、隐式和显式转换有什么区别）？
### 22、通过new创建一个对象的时候，函数内部有哪些改变###
### 23、$$('div+.ab')和$$('.ab+div') 哪个效率高？
### 24、`var`,`let`和`const`的区别是什么？
### 25、如何创建一个对象？
### 26、变量作用域?
### 27、在jq中 mouseover mouseenter mouseout mouseleave 和 hover有什么关联?
### 28、bootstrap好处？
### 29、什么是事件捕获？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
