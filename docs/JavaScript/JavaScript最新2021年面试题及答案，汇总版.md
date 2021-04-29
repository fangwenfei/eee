# JavaScript最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、手动实现缓存方法

```
function memoize(fn) {
  const cache = {};
  return function (param) {
    if (cache[param]) {
      console.log('cached');
      return cache[param];
    } else {
      let result = fn(param);
      cache[param] = result;
      console.log(`not cached`);
      return result;
    }
  }
}

const toUpper = (str ="")=> str.toUpperCase();

const toUpperMemoized = memoize(toUpper);

toUpperMemoized("abcdef");
toUpperMemoized("abcdef");
```

这个缓存函数适用于接受一个参数。我们需要改变下，让它接受多个参数。

```
const slice = Array.prototype.slice;
function memoize(fn) {
  const cache = {};
  return (...args) => {
    const params = slice.call(args);
    console.log(params);
    if (cache[params]) {
      console.log('cached');
      return cache[params];
    } else {
      let result = fn(...args);
      cache[params] = result;
      console.log(`not cached`);
      return result;
    }
  }
}
const makeFullName = (fName, lName) => `${fName} ${lName}`;
const reduceAdd = (numbers, startingValue = 0) => numbers.reduce((total, cur) => total + cur, startingValue);

const memoizedMakeFullName = memoize(makeFullName);
const memoizedReduceAdd = memoize(reduceAdd);

memoizedMakeFullName("Marko", "Polo");
memoizedMakeFullName("Marko", "Polo");

memoizedReduceAdd([1, 2, 3, 4, 5], 5);
memoizedReduceAdd([1, 2, 3, 4, 5], 5);
```


### 2、javascript有哪些方法定义对象

**1、** 对象字面量： `var obj = {};`

**2、** 构造函数： `var obj = new Object();`

**3、** Object.create(): `var obj = Object.create(Object.prototype);`


### 3、什么是 `async/await` 及其如何工作？

`async/await`是 JS 中编写异步或非阻塞代码的新方法。它建立在**Promises**之上，让异步代码的可读性和简洁度都更高。

`async/await`是 JS 中编写异步或非阻塞代码的新方法。它建立在`Promises`之上，相对于 Promise 和回调，它的可读性和简洁度都更高。但是，在使用此功能之前，我们必须先学习`Promises`的基础知识，因为正如我之前所说，它是基于`Promise`构建的，这意味着幕后使用仍然是**Promise**。

**使用 Promise**

```
function callApi() {
  return fetch("url/to/api/endpoint")
    .then(resp => resp.json())
    .then(data => {
      //do something with "data"
    }).catch(err => {
      //do something with "err"
    });
}
```

**使用async/await**

在`async/await`，我们使用 tru/catch 语法来捕获异常。

```
async function callApi() {
 try {
   const resp = await fetch("url/to/api/endpoint");
   const data = await resp.json();
   //do something with "data"
 } catch (e) {
   //do something with "err"
 }
}
```

**注意**:使用 `async`关键声明函数会隐式返回一个**Promise**。

```
const giveMeOne = async () => 1;
giveMeOne()
  .then((num) => {
    console.log(num); // logs 1
  });
```

**注意:**`await`关键字只能在`async function`中使用。在任何非**async function**的函数中使用`await`关键字都会抛出错误。`await`关键字在执行下一行代码之前等待右侧表达式(可能是一个**Promise**)返回。

```
const giveMeOne = async () => 1;

function getOne() {
  try {
    const num = await giveMeOne();
    console.log(num);
  } catch (e) {
    console.log(e);
  }
}

// Uncaught SyntaxError: await is only valid in async function

async function getTwo() {
  try {
    const num1 = await giveMeOne(); // 这行会等待右侧表达式执行完成
    const num2 = await giveMeOne(); 
    return num1 + num2;
  } catch (e) {
    console.log(e);
  }
}

await getTwo(); // 2
```


### 4、javascript 代码中的"use strict";是什么意思 ? 使用它区别是什么？

`use strict`是一种`ECMAscript 5` 添加的（严格）运行模式,这种模式使得 Javascript 在更严格的条件下运行,使`JS`编码更加规范化的模式,消除`Javascript`语法的一些不合理、不严谨之处，减少一些怪异行为


### 5、简述下你理解的面向对象？

万物皆对象，把一个对象抽象成类,具体上就是把一个对象的静态特征和动态特征抽象成属性和方法,也就是把一类事物的算法和数据结构封装在一个类之中,程序就是多个对象和互相之间的通信组成的、

面向对象具有封装性,继承性,多态性。

封装:隐蔽了对象内部不需要暴露的细节,使得内部细节的变动跟外界脱离,只依靠接口进行通信.封装性降低了编程的复杂性、通过继承,使得新建一个类变得容易,一个类从派生类那里获得其非私有的方法和公用属性的繁琐工作交给了编译器、而继承和实现接口和运行时的类型绑定机制 所产生的多态,使得不同的类所产生的对象能够对相同的消息作出不同的反应,极大地提高了代码的通用性、

总之,面向对象的特性提高了大型程序的重用性和可维护性.


### 6、一般使用什么版本控制工具?svn如何对文件加锁###

svn加锁目的：为了避免多个人同一时间对同一个文件改动的相互覆盖，版本控制系统就必须有一套冲突处理机制。

svn加锁两种策略：乐观加锁：所有签出的文件都是可读写的，对文件的修改不必获得文件的锁，当你修改完文件签入时，会首先要求你更新本地文件，版本控制系统不会覆盖你的本地修改，而是会让你自己合并冲突后签入。

严格加锁：所有签出的文件都是只读的，任何对文件的修改必须要获得文件的锁，如果其他人没有拥有该文件的锁，那么版本控制系统就会授权给你文件的锁，并将文件设置为可编辑的。

svn两种加锁步骤：乐观加锁：选择你想要获取锁定的文件，然后右键菜单点击TortoiseSVN 选取获取锁定。

严格加锁：在想要采取严格加锁的文件或目录上点击右键，使用TortoiseSVN 属性菜单，点击新建属性，选择需要锁定。


### 7、如何添加一个dom对象到body中?innerHTML和innerText区别?

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


### 8、jquery和zepto有什么区别?

**1、** 针对移动端程序，Zepto有一些基本的触摸事件可以用来做触摸屏交互（tap事件、swipe事件），Zepto是不支持IE浏览器的，这不是Zepto的开发者Thomas Fucks在跨浏览器问题上犯了迷糊，而是经过了认真考虑后为了降低文件尺寸而做出的决定，就像jQuery的团队在2.0版中不再支持旧版的IE（6 7 8）一样。因为Zepto使用jQuery句法，所以它在文档中建议把jQuery作为IE上的后备库。那样程序仍能在IE中，而其他浏览器则能享受到Zepto在文件大小上的优势，然而它们两个的API不是完全兼容的，所以使用这种方法时一定要小心，并要做充分的测试。

**2、** Dom操作的区别：添加id时jQuery不会生效而Zepto会生效。

**3、** zepto主要用在移动设备上，只支持较新的浏览器，好处是代码量比较小，性能也较好。

jquery主要是兼容性好，可以跑在各种pc，移动上，好处是兼容各种浏览器，缺点是代码量大，同时考虑兼容，性能也不够好。


### 9、什么是类？

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


### 10、事件委托？有什么好处?

利用冒泡的原理，把事件加到父级上，触发执行效果

好处：新添加的元素还会有之前的事件；提高性能。


### 11、为什么要有同源限制？
### 12、30.Jq中怎么样编写插件?
### 13、什么是移动端的300ms延迟？什么是点击穿透？解决方案?
### 14、自执行函数?用于什么场景？好处?
### 15、同步异步?
### 16、怎么理解宏任务，微任务？？？
### 17、JS是如何实现异步的？
### 18、Jq中 attr 和 prop 有什么区别###
### 19、JSON 的了解？**
### 20、说说严格模式的限制
### 21、你觉得jQuery源码有哪些写的好的地方
### 22、Jq绑定事件的几种方式？on bind ?
### 23、同步和异步的区别?
### 24、ajax中 get 和 post 有什么区别?
### 25、强制转换 显式转换 隐式转换?
### 26、简述下 this 和定义属性和方法的时候有什么区别?Prototype？
### 27、split() join()?
### 28、渐进增强和优雅降级
### 29、event.preventDefault() 和 event.stopPropagation()方法之间有什么区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
