# JavaScript最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、$$('div+.ab')和$$('.ab+div') 哪个效率高？

$('div+.ab')效率高


### 2、几种基本数据类型?复杂数据类型?值类型和引用数据类型?堆栈数据结构

**1、** 基本数据类型：Undefined、Null、Boolean、Number、String

**2、** 值类型：数值、布尔值、null、undefined。

**3、** 引用类型：对象、数组、函数。

**4、** 堆栈数据结构：是一种支持后进先出(LIFO)的集合,即后被插入的数据,先被取出!

**5、** js数组中提供了以下几个方法可以让我们很方便实现堆栈：

**6、** shift:从数组中把第一个元素删除，并返回这个元素的值。

**7、** unshift: 在数组的开头添加一个或更多元素，并返回新的长度

**8、** push:在数组的中末尾添加元素，并返回新的长度

**9、** pop:从数组中把最后一个元素删除，并返回这个元素的值。


### 3、模块化开发怎么做？

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


### 4、什么是高阶函数？

**高阶函数只是将函数作为参数或返回值的函数。**

`function higherOrderFunction(param,callback){ return callback(param); }`


### 5、JavaScript提供了哪几种“异步模式”？

**1、** 回调函数（callbacks）

**2、** 事件监听

**3、** Promise对象


### 6、JavaScript原型，原型链 ? 有什么特点？

在JavaScript中,一共有两种类型的值,原始值和对象值.每个对象都有一个内部属性[[prototype]],我们通常称之为原型.原型的值可以是一个对象,也可以是null.如果它的值是一个对象,则这个对象也一定有自己的原型.这样就形成了一条线性的链,我们称之为原型链、

访问一个对象的原型可以使用ES5中的Object.getPrototypeOf方法,或者ES6中的__proto__属性、原型链的作用是用来实现继承,比如我们新建一个数组,数组的方法就是从数组的原型上继承而来的。


### 7、undefined 和 null 有什么区别？

在理解 `undefined` 和 `null` 的差异之前，我们先来看看它们的相似点。

**它们都属于 JavaScript 的 7 种基本类型。**

```
let primitiveTypes = ['string','number','null','undefined','boolean','symbol', 'bigint'];
```

它们是属于 falsy 值类型，可以使用 `Boolean(value)` 或 `!!value` 将其转换为布尔值时，值为`false`。

```
console.log(!!null); // false
console.log(!!undefined); // false

console.log(Boolean(null)); // false
console.log(Boolean(undefined)); // false
```

接着来看看它们的区别。

`undefined` 是未指定特定值的变量的默认值，或者没有显式返回值的函数，如：`console.log(1)`，还包括对象中不存在的属性，这些 JS 引擎都会为其分配 `undefined` 值。

```
let _thisIsUndefined;
const doNothing = () => {};
const someObj = {
  a : "ay",
  b : "bee",
  c : "si"
};

console.log(_thisIsUndefined); // undefined
console.log(doNothing()); // undefined
console.log(someObj["d"]); // undefined
```

`null` 是『不代表任何值的值』。`null`是已明确定义给变量的值。在此示例中，当`fs.readFile`方法未引发错误时，我们将获得`null`值。

```
fs.readFile('path/to/file', (e,data) => {
   console.log(e); // 当没有错误发生时，打印 null
   if(e){
     console.log(e);
   }
   console.log(data);
 });
```

在比较`null`和`undefined`时，我们使用`==`时得到`true`，使用`===`时得到`false`:

```
console.log(null == undefined); // true
console.log(null === undefined); // false
```


### 8、window.onload ==? DOMContentLoaded ?
### 9、什么是事件捕获？
### 10、什么是AJAX？如何实现？
### 11、如何使用storage 对js文件进行缓存
### 12、split() join()?
### 13、sessionStorage和localstroage与cookie之间有什么关联, cookie最大存放多少字节
### 14、eval是做什么的？
### 15、readystate 0~4
### 16、你对数据校验是怎么样处理的？jquery.validate？
### 17、函数表达式和函数声明之间有什么区别？
### 18、谈谈你对webpack的看法
### 19、实现继承的方法有哪些？？？
### 20、`in` 运算符和 `Object.hasOwnProperty` 方法有什么区别？
### 21、什么是函数式编程? JavaScript 的哪些特性使其成为函数式语言的候选语言？
### 22、手动实现`Array.prototype.filter`方法
### 23、$$.map和$$.each有什么区别###
### 24、请解释什么是事件代理
### 25、对象的 prototype(原型) 是什么？
### 26、vue、react、angular
### 27、30.Jq中怎么样编写插件?
### 28、html和xhtml有什么区别?
### 29、怎么理解Promise对象？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
