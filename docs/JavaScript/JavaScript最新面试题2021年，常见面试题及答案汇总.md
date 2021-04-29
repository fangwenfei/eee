# JavaScript最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何创建一个没有 prototype(原型)的对象？

我们可以使用`Object.create`方法创建没有原型的对象。

```
const o1 = {};
console.log(o1.toString()); // [object Object]

const o2 = Object.create(null);
console.log(o2.toString());
// throws an error o2.toString is not a function
```


### 2、JavaScript原型，原型链 ? 有什么特点？

**1、** 每个对象都会在其内部初始化一个属性，就是`prototype`(原型)，当我们访问一个对象的属性时

**2、** 如果这个对象内部不存在这个属性，那么他就会去`prototype`里找这个属性，这`个prototype`又会有自己的`prototype`，于是就这样一直找下去，也就是我们平时所说的原型链的概念

**3、** 关系：`instance.constructor.prototype = instance.__proto__`

**特点：**

**1、** `JavaScript`对象是通过引用来传递的，我们创建的每个新对象实体中并没有一份属于自己的原型副本。当我们修改原型时，与之相关的对象也会继承这一改变

2.当我们需要一个属性的时，`Javascript`引擎会先看当前对象中是否有这个属性， 如果没有的 就会查找他的`Prototype`对象是否有这个属性，如此递推下去，一直检索到 `Object` 内建对象


### 3、什么是 ES6 模块？

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


### 4、实现异步的方式有哪些？

**1、** 回调函数模式：将需要异步执行的函数作为回调函数执行，其缺点在于处理复杂逻辑异步逻辑时，会造成回调地狱(回调嵌套层数太多，代码结构混乱)；

**2、** 事件监听模式：采用事件驱动的思想，当某一事件发生时触发执行异步函数，其缺点在于整个代码全部得变为事件驱动模式，难以分辨主流程；

**3、** 发布订阅模式：当异步任务执行完成时发布消息给信号中心，其他任务通过在信号中心中订阅消息来确定自己是否开始执行；

**4、** Promise(ES6)：`Promise`对象共有三种状态`pending`(初始化状态)、`fulfilled`(成功状态)、`rejected`(失败状态)。

**5、** async/await(ES7)：基于`Promise`实现的异步函数； （6）利用生成器实现。


### 5、上一个项目是什么？主要负责哪些？购物车流程?支付功能?

**主要负责哪些就讲主要做哪些功能模块：**

1）商品模块:

**1、** 商品列表：商品排序 商品筛选 商品过滤 商品查询 商品推荐

**2、** 商品详情:类型推荐 商品简介 商品详情 商品评价 售后维护

2)购物车模块：商品编号、数量、价格、总额、运费、运输选项、运费总计、从购物车删除选项、更新数量、结账、继续购物、商品描述、库存信息


### 6、异步编程？

**方法1：**

**1、** 回调函数，优点是简单、容易理解和部署，缺点是不利于代码的阅读和维护，各个部分之间高度耦合（Coupling），流程会很混乱，而且每个任务只能指定一个回调函数。

**方法2：**

**1、** 时间监听，可以绑定多个事件，每个事件可以指定多个回调函数，而且可以“去耦合”（Decoupling），有利于实现模块化。缺点是整个程序都要变成事件驱动型，运行流程会变得很不清晰。

**方法3：**

发布/订阅，性质与“事件监听”类似，但是明显优于后者。

**方法4：**

**1、** Promises对象，是CommonJS工作组提出的一种规范，目的是为异步编程提供统一接口。

**2、** 简单说，它的思想是，每一个异步任务返回一个Promise对象，该对象有一个then方法，允许指定回调函数。


### 7、为什么typeof null 返回 object？如何检查一个值是否为 null？

`typeof null == 'object'`总是返回`true`，因为这是自 JS 诞生以来`null`的实现。曾经有人提出将`typeof null == 'object'`修改为`typeof null == 'null'`，但是被拒绝了，因为这将导致更多的**bug**。

我们可以使用严格相等运算符`===`来检查值是否为`null`。

```
function isNull(value){
  return value === null;
}
```


### 8、如何通过原生js 判断一个元素当前是显示还是隐藏状态?
### 9、javascript创建对象的几种方式？
### 10、Ajax原理
### 11、什么是 event.target ？
### 12、谁是c的构造函数?
### 13、数组的排序方法（sort）？排序？汉字排序？
### 14、手动实现 `Array.prototype.map 方法`
### 15、判断数据类型的方法有哪些？
### 16、slice() splice()?
### 17、DOM 是什么？
### 18、数据持久化技术(ajax)?简述ajax流程###
### 19、Jq中如何将一个jq对象转化为dom对象？
### 20、javascript 代码中的"use strict";是什么意思 ? 使用它区别是什么？
### 21、Jq中如何实现多库并存?
### 22、ES6或ECMAScript 2015有哪些新特性？
### 23、如何清除一个定时器?
### 24、event.preventDefault() 和 event.stopPropagation()方法之间有什么区别？
### 25、如何解决跨域问题?
### 26、谈谈你对ES6的理解
### 27、介绍js的基本数据类型
### 28、web开发中会话跟踪的方法有哪些
### 29、什么是移动端的300ms延迟？什么是点击穿透？解决方案?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
