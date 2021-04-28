# JavaScript最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、渐进增强和优雅降级

**1、** 渐进增强 ：针对低版本浏览器进行构建页面，保证最基本的功能，然后再针对高级浏览器进行效果、交互等改进和追加功能达到更好的用户体验。

**2、** 优雅降级 ：一开始就构建完整的功能，然后再针对低版本浏览器进行兼容


### 2、JavaScript 中 `this` 值是什么？

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


### 3、节点类型?判断当前节点类型?

**1、** 元素节点

**2、** 属性节点

**3、** 文本节点

**8、** 注释节点

**9、** 文档节点

通过nodeObject.nodeType判断节点类型：其中，nodeObject 为DOM节点（节点对象）。该属性返回以数字表示的节点类型，例如，元素节点返回 1，属性节点返回 2 。


### 4、什么是 `async/await` 及其如何工作？

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


### 5、什么是闭包? 堆栈溢出有什么区别？ 内存泄漏? 那些操作会造成内存泄漏？怎么样防止内存泄漏？

**闭包：**

**1、** 就是能够读取其他函数内部变量的函数。

**2、** 堆栈溢出：就是不顾堆栈中分配的局部数据块大小，向该数据块写入了过多的数据，导致数据越界，结果覆盖了别的数据。经常会在递归中发生。

**3、** 内存泄露是指：用动态存储分配函数内存空间，在使用完毕后未释放，导致一直占据该内存单元。直到程序结束。指任何对象在您不再拥有或需要它之后仍然存在。

**造成内存泄漏：**

setTimeout 的第一个参数使用字符串而非函数的话，会引发内存泄漏。

闭包、控制台日志、循环（在两个对象彼此引用且彼此保留时，就会产生一个循环）

防止内存泄露：

**1、** 不要动态绑定事件；

**2、** 不要在动态添加，或者会被动态移除的dom上绑事件，用事件冒泡在父容器监听事件；

**3、** 如果要违反上面的原则，必须提供destroy方法，保证移除dom后事件也被移除，这点可以参考Backbone的源代码，做的比较好；

**4、** 单例化，少创建dom，少绑事件。


### 6、手动实现`Array.prototype.filter`方法

`filter()` 方法创建一个新数组, 其包含通过所提供函数实现的测试的所有元素。

```
function filter(arr, filterCallback) {
  // 首先，检查传递的参数是否正确。
  if (!Array.isArray(arr) || !arr.length || typeof filterCallback !== 'function') 
  {
    return [];
  } else {
    let result = [];
     // 每次调用此函数时，我们都会创建一个 result 数组
     // 因为我们不想改变原始数组。
    for (let i = 0, len = arr.length; i < len; i++) {
      // 检查 filterCallback 的返回值是否是真值
      if (filterCallback(arr[i], i, arr)) { 
      // 如果条件为真，则将数组元素 push 到 result 中
        result.push(arr[i]);
      }
    }
    return result; // return the result array
  }
}
```


### 7、在jq中 mouseover mouseenter mouseout mouseleave 和 hover有什么关联?

mouseenter与mouseover：

不论鼠标指针穿过被选中元素或其子元素，都会触发mouseover事件。

只有在鼠标指针穿过被选元素时，才会触发mouseentr事件。

mouseout与mouseleave：

不论鼠标离开被选元素还是任何子元素，都会触发mouseout事件。

只有在鼠标指针离开被选元素时，才会触发mouseleave事件。

hover:

hover是一个符合方法，相当于mouseenter+mouseleave。


### 8、JavaScript 中的虚值是什么？

`const falsyValues = ['', 0, null, undefined, NaN, false];`

简单的来说虚值就是是在转换为布尔值时变为 `false` 的值。


### 9、手动实现`Array.prototype.reduce`方法

`reduce()` 方法对数组中的每个元素执行一个由您提供的`reducer`函数(升序执行)，将其结果汇总为单个返回值。

```
function reduce(arr, reduceCallback, initialValue) {
  // 首先，检查传递的参数是否正确。
  if (!Array.isArray(arr) || !arr.length || typeof reduceCallback !== 'function') 
  {
    return [];
  } else {
    // 如果没有将initialValue传递给该函数，我们将使用第一个数组项作为initialValue
    let hasInitialValue = initialValue !== undefined;
    let value = hasInitialValue ? initialValue : arr[0];
   、

    // 如果有传递 initialValue，则索引从 1 开始，否则从 0 开始
    for (let i = hasInitialValue ? 0 : 1, len = arr.length; i < len; i++) {
      value = reduceCallback(value, arr[i], i, arr); 
    }
    return value;
  }
}
```


### 10、常见web安全及防护原理

**`sql`注入原理**

就是通过把`SQL`命令插入到`Web`表单递交或输入域名或页面请求的查询字符串，最终达到欺骗服务器执行恶意的SQL命令

**总的来说有以下几点**

永远不要信任用户的输入，要对用户的输入进行校验，可以通过正则表达式，或限制长度，对单引号和双`"-"`进行转换等

**1、** 永远不要使用动态拼装SQL，可以使用参数化的`SQL`或者直接使用存储过程进行数据查询存取

**2、** 永远不要使用管理员权限的数据库连接，为每个应用使用单独的权限有限的数据库连接

**3、** 不要把机密信息明文存放，请加密或者`hash`掉密码和敏感的信息

**XSS原理及防范**

`Xss(cross-site scripting)`攻击指的是攻击者往`Web`页面里插入恶意`html`标签或者`javascript`代码。

**比如：**

攻击者在论坛中放一个看似安全的链接，骗取用户点击后，窃取`cookie`中的用户私密信息；或者攻击者在论坛中加一个恶意表单，当用户提交表单的时候，却把信息传送到攻击者的服务器中，而不是用户原本以为的信任站点

**XSS防范方法**

首先代码里对用户输入的地方和变量都需要仔细检查长度和对`”<”,”>”,”;”,”’”`等字符做过滤；其次任何内容写到页面之前都必须加以encode，避免不小心把`html tag` 弄出来。这一个层面做好，至少可以堵住超过一半的XSS 攻击

**XSS与CSRF有什么区别吗？**

**1、** `XSS`是获取信息，不需要提前知道其他用户页面的代码和数据包。`CSRF`是代替用户完成指定的动作，需要知道其他用户页面的代码和数据包。要完成一次`CSRF`攻击，受害者必须依次完成两个步骤

**2、** 登录受信任网站`A`，并在本地生成`Cookie`

**3、** 在不登出`A`的情况下，访问危险网站`B`

**CSRF的防御**

服务端的`CSRF`方式方法很多样，但总的思想都是一致的，就是在客户端页面增加伪随机数

通过验证码的方法


### 11、一个页面从输入 URL 到页面加载显示完成，这个过程中都发生了什么？（流程说的越详细越好）
### 12、readystate 0~4
### 13、sass和less有什么区别?
### 14、什么是作用域？
### 15、js延迟加载的方式有哪些？
### 16、&& 运算符能做什么
### 17、|| 运算符能做什么
### 18、**
### 19、为什么在 JS 中比较两个相似的对象时返回 false？
### 20、同步和异步的区别?
### 21、什么是`Set`对象，它是如何工作的？
### 22、new操作符具体干了什么呢?
### 23、如何在 JS 中创建对象？
### 24、jsonp原理？ 缺点?
### 25、javascript有哪些方法定义对象
### 26、简述下 this 和定义属性和方法的时候有什么区别?Prototype？
### 27、什么是NaN？以及如何检查值是否为NaN？
### 28、null，undefined 的区别？
### 29、除了jsonp 还有什么跨域方式###
### 30、什么是缓存及它有什么作用？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
