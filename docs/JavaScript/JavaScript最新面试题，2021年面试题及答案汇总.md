# JavaScript最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、一个页面从输入 URL 到页面加载显示完成，这个过程中都发生了什么？（流程说的越详细越好）

**1、** 查找浏览器缓存

**2、** DNS解析、查找该域名对应的IP地址、重定向（301）、发出第二个GET请求

**3、** 进行HTTP协议会话

**4、** 客户端发送报头(请求报头)

**5、** 服务器回馈报头(响应报头)

**6、** html文档开始下载

**7、** 文档树建立，根据标记请求所需指定MIME类型的文件

**8、** 文件显示

**浏览器这边做的工作大致分为以下几步：**

**1、** 加载：根据请求的URL进行域名解析，向服务器发起请求，接收文件（HTML、JS、CSS、图象等）。

**2、** 解析：对加载到的资源（HTML、JS、CSS等）进行语法解析，建议相应的内部数据结构（比如HTML的DOM树，JS的（对象）属性表，CSS的样式规则等等）


### 2、JSON 的了解？

JSON(JavaScript Object Notation) 是一种轻量级的数据交换格式。 它是基于JavaScript的一个子集。数据格式简单, 易于读写, 占用带宽小。


### 3、有哪些数据类型？

根据 JavaScript 中的变量类型传递方式，分为基本数据类型和引用数据类型两大类七种。

基本数据类型包括Undefined、Null、Boolean、Number、String、Symbol (ES6新增)六种。 引用数据类型只有Object一种，主要包括对象、数组和函数。

**判断数据类型采用`typeof`操作符，有两种语法：**

```
typeof 123;//语法一

const FG = 123;
typeof FG;//语法二

typeof(null) //返回 object;
null == undefined //返回true，因为undefined派生自null;
null === undefined //返回false。
```


### 4、什么是闭包？

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


### 5、手动实现缓存方法

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


### 6、如何理解同步和异步？

同步：按照代码书写顺序一一执行处理指令的一种模式，上一段代码执行完才能执行下一段代码。

异步：可以理解为一种并行处理的方式，不必等待一个程序执行完，可以执行其它的任务。

JS之所以需要异步的原因在于JS是单线程运行的。常用的异步场景有：定时器、ajax请求、事件绑定。


### 7、异步编程？

**方法1：**

**1、** 回调函数，优点是简单、容易理解和部署，缺点是不利于代码的阅读和维护，各个部分之间高度耦合（Coupling），流程会很混乱，而且每个任务只能指定一个回调函数。

**方法2：**

**1、** 时间监听，可以绑定多个事件，每个事件可以指定多个回调函数，而且可以“去耦合”（Decoupling），有利于实现模块化。缺点是整个程序都要变成事件驱动型，运行流程会变得很不清晰。

**方法3：**

发布/订阅，性质与“事件监听”类似，但是明显优于后者。

**方法4：**

**1、** Promises对象，是CommonJS工作组提出的一种规范，目的是为异步编程提供统一接口。

**2、** 简单说，它的思想是，每一个异步任务返回一个Promise对象，该对象有一个then方法，允许指定回调函数。


### 8、强制转换 显式转换 隐式转换?

```
//强制类型转换：
Boolean(0)   // =false - 零
Boolean(new object())   // =true - 对象
Number(undefined)       // =  NaN
Number(null)              // =0
String(null)              // ="null"
parseInt( )
parseFloat( )
JSON.parse( )
JSON.stringify ( )
```

隐式类型转换：

在使用算术运算符时，运算符两边的数据类型可以是任意的，比如，一个字符串可以和数字相加。之所以不同的数据类型之间可以做运算，是因为JavaScript引擎在运算之前会悄悄的把他们进行了隐式类型转换的

```
（例如：x+"" //等价于String(x)  
\+x //等价于Number(x)  
x-0 //同上  
!!x //等价于Boolean(x),是双叹号）
```

**显式转换：**

如果程序要求一定要将某一类型的数据转换为另一种类型，则可以利用强制类型转换运算符进行转换，这种强制转换过程称为显示转换。

显示转换是你定义让这个值类型转换成你要用的值类型，是底到高的转换。例 int 到float就可以直接转，int i=5,想把他转换成char类型，就用显式转换（char）i


### 9、Jq中 attr 和 prop 有什么区别###

对于HTML元素本身就带有的固有属性，在处理时，使用prop方法。

对于HTML元素我们自己自定义的DOM属性，在处理时，使用attr方法。


### 10、你有哪些性能优化的方法？

**1、** 减少http请求次数：CSS Sprites, JS、CSS源码压缩、图片大小控制合适；网页Gzip， CDN托管，data缓存 ，图片服务器。

**2、** 前端模板 JS+数据，减少由于HTML标签导致的带宽浪费，前端用变量保存AJAX请求结果，每次操作本地变量，不用请求，减少请求次数

**3、** 用innerHTML代替DOM操作，减少DOM操作次数，优化javascript性能。

**4、** 当需要设置的样式很多时设置className而不是直接操作style。

**5、** 少用全局变量、缓存DOM节点查找的结果。减少IO读取操作。

**6、** 避免使用CSS Expression（css表达式)又称Dynamic properties(动态属性)。

**7、** 图片预加载，将样式表放在顶部，将脚本放在底部 加上时间戳。

**8、** 避免在页面的主体布局中使用table，table要等其中的内容完全下载之后才会显示出来，显示比div+css布局慢。


### 11、vue、react、angular
### 12、作用域和执行上下文的区别是什么？
### 13、同步异步?
### 14、什么是函数式编程? JavaScript 的哪些特性使其成为函数式语言的候选语言？
### 15、'use strict' 是干嘛用的？
### 16、Object.seal 和 Object.freeze 方法之间有什么区别？
### 17、bootstrap好处？
### 18、闭包
### 19、js延迟加载的方式有哪些？
### 20、Jq中如何实现多库并存?
### 21、什么是回调函数？
### 22、如何创建一个对象？
### 23、事件模型
### 24、编写一个 getElementsByClassName 封装函数?
### 25、什么是 `async/await` 及其如何工作？
### 26、说说你对作用域链的理解
### 27、null，undefined 的区别？
### 28、如何对登录的账号密码进行加密?
### 29、Jq绑定事件的几种方式？on bind ?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
