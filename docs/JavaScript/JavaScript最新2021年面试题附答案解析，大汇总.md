# JavaScript最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、|| 运算符能做什么

`||`也叫或`逻辑或`，在其操作数中找到第一个真值表达式并返回它。这也使用了短路来防止不必要的工作。在支持 ES6 默认函数参数之前，它用于初始化函数中的默认参数值。

```
console.log(null || 1 || undefined); // 1

function logName(name) {
  var n = name || "Mark";
  console.log(n);
}

logName(); // "Mark"
```


### 2、ajax的缺点

**1、** ajax不支持浏览器back按钮。

**2、** 安全问题 AJAX暴露了与服务器交互的细节。

**3、** 对搜索引擎的支持比较弱。

**4、** 破坏了程序的异常机制。

**5、** 不容易调试



### 3、如何判断值是否为数组？

我们可以使用`Array.isArray`方法来检查值是否为**数组**。当传递给它的参数是数组时，它返回`true`，否则返回`false`。

```
console.log(Array.isArray(5));  // false
console.log(Array.isArray("")); // false
console.log(Array.isArray()); // false
console.log(Array.isArray(null)); // false
console.log(Array.isArray({ length: 5 })); // false

console.log(Array.isArray([])); // true
```

如果环境不支持此方法，则可以使用`polyfill`实现。

`function isArray(value){ return Object.prototype.toString.call(value) === "[object Array]" }`

当然还可以使用传统的方法：

`let a = [] if (a instanceof Array) { console.log('是数组') } else { console.log('非数组') }`


### 4、`var`,`let`和`const`的区别是什么？

**`var`声明的变量会挂载在`window`上，而`let`和`const`声明的变量不会：**

```
var a = 100;
console.log(a,window.a);    // 100 100

let b = 10;
console.log(b,window.b);    // 10 undefined

const c = 1;
console.log(c,window.c);    // 1 undefined
```

**`var`声明变量存在变量提升，`let`和`const`不存在变量提升:**

`console.log(a); // undefined  ===>  a已声明还没赋值，默认得到undefined值

var a = 100;

console.log(b); // 报错：b is not defined  ===> 找不到b这个变量

let b = 10;

console.log(c); // 报错：c is not defined  ===> 找不到c这个变量

const c = 10;

`

**`let`和`const`声明形成块作用域**

```
if(1){
  var a = 100;
  let b = 10;
}

console.log(a); // 100
console.log(b)  // 报错：b is not defined  ===> 找不到b这个变量

-------------------------------------------------------------

if(1){
  var a = 100;
  const c = 1;
}
console.log(a); // 100
console.log(c)  // 报错：c is not defined  ===> 找不到c这个变量
```

**同一作用域下`let`和`const`不能声明同名变量，而`var`可以**

```
var a = 100;
console.log(a); // 100

var a = 10;
console.log(a); // 10
-------------------------------------
let a = 100;
let a = 10;
    //  控制台报错：Identifier 'a' has already been declared  ===> 标识符a已经被声明了。
```

**暂存死区**

```
var a = 100;

if(1){
    a = 10;
    //在当前块作用域中存在a使用let/const声明的情况下，给a赋值10时，只会在当前作用域找变量a，
    // 而这时，还未到声明时候，所以控制台Error:a is not defined
    let a = 1;
}
```

**const**

```
/*
*   1、一旦声明必须赋值,不能使用null占位。
*
*   2、声明后不能再修改
*
*   3、如果声明的是复合类型数据，可以修改其属性
*
* */

const a = 100; 

const list = [];
list[0] = 10;
console.log(list);  // [10]

const obj = {a:100};
obj.name = 'apple';
obj.a = 10000;
console.log(obj);  // {a:10000,name:'apple'}
```


### 5、在jq中 mouseover mouseenter mouseout mouseleave 和 hover有什么关联?

mouseenter与mouseover：

不论鼠标指针穿过被选中元素或其子元素，都会触发mouseover事件。

只有在鼠标指针穿过被选元素时，才会触发mouseentr事件。

mouseout与mouseleave：

不论鼠标离开被选元素还是任何子元素，都会触发mouseout事件。

只有在鼠标指针离开被选元素时，才会触发mouseleave事件。

hover:

hover是一个符合方法，相当于mouseenter+mouseleave。


### 6、**

**1、** 执行代码之前会先读取函数声明，意味着可以把函数申明放在调用它的语句后面。

**2、** 只要函数在代码中进行了声明，无论它在哪个位置上进行声明， js引擎都会将它的声明放在范围作用域的顶部；

**变量or函数声明：**

**1、** 函数声明会覆盖变量声明，但不会覆盖变量赋值。

**2、** 同一个名称标识a，即有变量声明var a，又有函数声明function a() {}，不管二者声明的顺序，函数声明会覆盖变量声明，也就是说，此时a的值是声明的函数function a() {}。注意：如果在变量声明的同时初始化a，或是之后对a进行赋值，此时a的值变量的值。eg: var a; var c = 1; a = 1; function a() { return true; } console.log(a);


### 7、如何解决跨域问题?

`jsonp`、 `iframe`、`window.name`、`window.postMessage`、服务器上设置代理页面


### 8、同步和异步的区别?

**1、** 同步：浏览器访问服务器请求，用户看得到页面刷新，重新发请求,等请求完，页面刷新，新内容出现，用户看到新内容,进行下一步操作

**2、** 异步：浏览器访问服务器请求，用户正常操作，浏览器后端进行请求。等请求完，页面不刷新，新内容也会出现，用户看到新内容


### 9、什么是 ES6 模块？

**模块**使我们能够将代码基础分割成多个文件，以获得更高的可维护性，并且避免将所有代码放在一个大文件中。在 ES6 支持模块之前，有两个流行的模块。

-
**CommonJS-Node.js**

-
AMD（异步模块定义）-**浏览器**


基本上，使用模块的方式很简单，`import`用于从另一个文件中获取功能或几个功能或值，同时`export`用于从文件中公开功能或几个功能或值。

**导出**

使用 ES5 (CommonJS)

```
// 使用 ES5 CommonJS - helpers.js
exports.isNull = function (val) {
  return val === null;
}

exports.isUndefined = function (val) {
  return val === undefined;
}

exports.isNullOrUndefined = function (val) {
  return exports.isNull(val) || exports.isUndefined(val);
}
```

使用 ES6 模块

```
使用 ES6 Modules - helpers.js
export function isNull(val){
  return val === null;
}

export function isUndefined(val) {
  return val === undefined;
}

export function isNullOrUndefined(val) {
  return isNull(val) || isUndefined(val);
}
```

在另一个文件中导入函数

```
// 使用 ES5 (CommonJS) - index.js
const helpers = require('./helpers.js'); // helpers is an object
const isNull = helpers.isNull;
const isUndefined = helpers.isUndefined;
const isNullOrUndefined = helpers.isNullOrUndefined;

// or if your environment supports Destructuring
const { isNull, isUndefined, isNullOrUndefined } = require('./helpers.js');
-------------------------------------------------------

// ES6 Modules - index.js
import * as helpers from './helpers.js'; // helpers is an object

// or 

import { isNull, isUndefined, isNullOrUndefined as isValid } from './helpers.js';

// using "as" for renaming named exports
```

**在文件中导出单个功能或默认导出**

使用 ES5 (CommonJS)

```
// 使用 ES5 (CommonJS) - index.js
class Helpers {
  static isNull(val) {
    return val === null;
  }

  static isUndefined(val) {
    return val === undefined;
  }

  static isNullOrUndefined(val) {
    return this.isNull(val) || this.isUndefined(val);
  }
}

module.exports = Helpers;
```

使用ES6 Modules

```
// 使用 ES6 Modules - helpers.js
class Helpers {
  static isNull(val) {
    return val === null;
  }

  static isUndefined(val) {
    return val === undefined;
  }

  static isNullOrUndefined(val) {
    return this.isNull(val) || this.isUndefined(val);
  }
}

export default Helpers
```

从另一个文件导入单个功能

使用ES5 (CommonJS)

`// 使用 ES5 (CommonJS) - index.js const Helpers = require('./helpers.js'); console.log(Helpers.isNull(null));`

使用 ES6 Modules

`import Helpers from '.helpers.js' console.log(Helpers.isNull(null));`


### 10、怎么理解宏任务，微任务？？？

**1、** 宏任务有：`script(整体代码)`、`setTimeout`、`setInterval`、`I/O`、页面渲染；

**2、** 微任务有：`Promise.then`、`Object.observe`、`MutationObserver`。

**3、** 执行顺序大致如下：

**4、** 主线程任务——>宏任务——>微任务——>微任务里的宏任务——>.......——>直到任务全部完成


### 11、那些操作会造成内存泄漏？
### 12、什么是AJAX？如何实现？
### 13、commonjs?requirejs?AMD|CMD|UMD?
### 14、什么是闭包？
### 15、开发时如何对项目进行管理?gulp?
### 16、事件委托？有什么好处?
### 17、什么是`Set`对象，它是如何工作的？
### 18、什么是高阶函数？
### 19、js的几种继承方式？
### 20、readystate 0~4
### 21、声明函数作用提升?声明变量和声明函数的提升有什么区别
### 22、你对数据校验是怎么样处理的？jquery.validate？
### 23、html和xhtml有什么区别?
### 24、节点类型?判断当前节点类型?
### 25、new 关键字有什么作用？
### 26、undefined 和 null 有什么区别？
### 27、JavaScript 中 `this` 值是什么？
### 28、手动实现`Array.prototype.filter`方法
### 29、为什么在 JS 中比较两个相似的对象时返回 false？
### 30、promise###




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
