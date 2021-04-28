# JavaScript最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是闭包？

闭包就是引用了其他函数作用域中变量的函数，这种模式通常在函数嵌套结构中实现。里面的函数可以访问外面函数的变量，外面的变量的是这个内部函数的一部分。闭包有如下作用：

**1、** 加强封装，模拟实现私有变量；

**2、** 实现常驻内存的变量。

> 闭包不能滥用，否则会导致内存泄露，影响网页的性能。闭包使用完了后，要立即释放资源，将引用变量指向null。



### 2、commonjs?requirejs?AMD|CMD|UMD?

**1、** CommonJS就是为JS的表现来制定规范，NodeJS是这种规范的实现，webpack 也是以CommonJS的形式来书写。因为js没有模块的功能，所以CommonJS应运而生。但它不能在浏览器中运行。 CommonJS定义的模块分为:{模块引用(require)} {模块定义(exports)} {模块标识(module)}

**2、** RequireJS 是一个JavaScript模块加载器。 RequireJS有两个主要方法(method): define()和require()。这两个方法基本上拥有相同的定义(declaration) 并且它们都知道如何加载的依赖关系，然后执行一个回调函数(callback function)。与require()不同的是， define()用来存储代码作为一个已命名的模块。 因此define()的回调函数需要有一个返回值作为这个模块定义。这些类似被定义的模块叫作AMD (Asynchronous Module Definition，异步模块定义)。

**3、** AMD 是 RequireJS 在推广过程中对模块定义的规范化产出 AMD异步加载模块。它的模块支持对象 函数 构造器 字符串 JSON等各种类型的模块。 适用AMD规范适用define方法定义模块。

**4、** CMD是SeaJS 在推广过程中对模块定义的规范化产出

AMD与CDM的区别：

（1）对于于依赖的模块，AMD 是提前执行(好像现在也可以延迟执行了)，CMD 是延迟执行。

（2）AMD 推崇依赖前置，CMD 推崇依赖就近。

（3）AMD 推崇复用接口，CMD 推崇单用接口。

（4）书写规范的差异。

**5、** umd是AMD和CommonJS的糅合。

AMD 浏览器第一的原则发展 异步加载模块。

CommonJS模块以服务器第一原则发展，选择同步加载，它的模块无需包装(unwrapped modules)。这迫使人们又想出另一个更通用的模式UMD ( Universal Module Definition ), 希望解决跨平台的解决方案。UMD先判断是否支持Node.js的模块( exports )是否存在，存在则使用Node.js模块模式。


### 3、JS是如何实现异步的？

JS引擎是单线程的，但又能实现异步的原因在于事件循环和任务队列体系。

**事件循环：**

**1、** JS 会创建一个类似于 `while (true)` 的循环，每执行一次循环体的过程称之为 `Tick`。每次 `Tick` 的过程就是查看是否有待处理事件，如果有则取出相关事件及回调函数放入执行栈中由主线程执行。待处理的事件会存储在一个任务队列中，也就是每次 `Tick` 会查看任务队列中是否有需要执行的任务。

**任务队列：**

**1、** 异步操作会将相关回调添加到任务队列中。而不同的异步操作添加到任务队列的时机也不同，如 `onclick`, `setTimeout`, `ajax` 处理的方式都不同，这些异步操作是由浏览器内核的 `webcore` 来执行的，浏览器内核包含3种 webAPI，分别是 `DOM Binding`、`network`、`timer`模块。

**2、** `onclick` 由 `DOM Binding` 模块来处理，当事件触发的时候，回调函数会立即添加到任务队列中。 `setTimeout` 由 `timer` 模块来进行延时处理，当时间到达的时候，才会将回调函数添加到任务队列中。 `ajax` 由`network` 模块来处理，在网络请求完成返回之后，才将回调添加到任务队列中。

**主线程：**

**1、** JS 只有一个线程，称之为主线程。而事件循环是主线程中执行栈里的代码执行完毕之后，才开始执行的。所以，主线程中要执行的代码时间过长，会阻塞事件循环的执行，也就会阻塞异步操作的执行。

**2、** 只有当主线程中执行栈为空的时候（即同步代码执行完后），才会进行事件循环来观察要执行的事件回调，当事件循环检测到任务队列中有事件就取出相关回调放入执行栈中由主线程执行。


### 4、undefined 和 null 有什么区别？

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


### 5、eval是做什么的？

它的功能是把对应的字符串解析成JS代码并运行； 应该避免使用eval，不安全，非常耗性能（2次，一次解析成js语句，一次执行）。


### 6、Jq中get和eq有什么区别？

get() :取得其中一个匹配的元素。num表示取得第几个匹配的元素，get多针对集合元素，返回的是DOM对象组成的数组 eq():获取第N个元素，下标都是从0开始，返回的是一个JQuery对象


### 7、`Function.prototype.call` 方法的用途是什么？

`call()` 方法使用一个指定的 `this` 值和单独给出的一个或多个参数来调用一个函数。

`const details = {

message: 'Hello World!'

};

function getMessage(){

return this.message;

}

getMessage.call(details); // 'Hello World!'

`

注意：该方法的语法和作用与 `apply()` 方法类似，只有一个区别，就是 `call()` 方法接受的是一个参数列表，而 `apply()` 方法接受的是一个包含多个参数的数组。

```
const person = {
  name: "Marko Polo"
};

function greeting(greetingMessage) {
  return `${greetingMessage} ${this.name}`;
}

greeting.call(person, 'Hello'); // "Hello Marko Polo!"
```


### 8、什么是 event.target ？

简单来说，`event.target`是发生事件的元素或触发事件的元素。

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
  console.log(event.target);
}
```

如果单击 `button`，即使我们将事件附加在最外面的`div`上，它也将打印 `button` 标签，因此我们可以得出结论`event.target`是触发事件的元素。


### 9、什么是模板字符串？

模板字符串是在 JS 中创建字符串的一种新方法。我们可以通过使用反引号使模板字符串化。

```
//ES5 Version
var greet = 'Hi I\'m Mark';

//ES6 Version
let greet = `Hi I'm Mark`;
```

在 ES5 中我们需要使用一些转义字符来达到多行的效果，在模板字符串不需要这么麻烦：

```
//ES5 Version
var lastWords = '\n'
  + '   I  \n'
  + '   Am  \n'
  + 'Iron Man \n';

//ES6 Version
let lastWords = `
    I
    Am
  Iron Man   
`;
```

在ES5版本中，我们需要添加`\n`以在字符串中添加新行。在模板字符串中，我们不需要这样做。

```
//ES5 Version
function greet(name) {
  return 'Hello ' + name + '!';
}

//ES6 Version
function greet(name) {
  return `Hello ${name} !`;
}
```

在 ES5 版本中，如果需要在字符串中添加表达式或值，则需要使用`+`运算符。在模板字符串s中，我们可以使用`${expr}`嵌入一个表达式，这使其比 ES5 版本更整洁。


### 10、jquery和zepto有什么区别?

**1、** 针对移动端程序，Zepto有一些基本的触摸事件可以用来做触摸屏交互（tap事件、swipe事件），Zepto是不支持IE浏览器的，这不是Zepto的开发者Thomas Fucks在跨浏览器问题上犯了迷糊，而是经过了认真考虑后为了降低文件尺寸而做出的决定，就像jQuery的团队在2.0版中不再支持旧版的IE（6 7 8）一样。因为Zepto使用jQuery句法，所以它在文档中建议把jQuery作为IE上的后备库。那样程序仍能在IE中，而其他浏览器则能享受到Zepto在文件大小上的优势，然而它们两个的API不是完全兼容的，所以使用这种方法时一定要小心，并要做充分的测试。

**2、** Dom操作的区别：添加id时jQuery不会生效而Zepto会生效。

**3、** zepto主要用在移动设备上，只支持较新的浏览器，好处是代码量比较小，性能也较好。

jquery主要是兼容性好，可以跑在各种pc，移动上，好处是兼容各种浏览器，缺点是代码量大，同时考虑兼容，性能也不够好。


### 11、什么是函数式编程? JavaScript 的哪些特性使其成为函数式语言的候选语言？
### 12、什么是 event.currentTarget？？
### 13、如何在一行中计算多个表达式的值？
### 14、Jq绑定事件的几种方式？on bind ?
### 15、call & apply 两者之间的区别###
### 16、null，undefined 的区别？
### 17、与深拷贝有何区别？如何实现？
### 18、压缩合并目的？http请求的优化方式？
### 19、什么是箭头函数？
### 20、Jq中如何实现多库并存?
### 21、变量作用域?
### 22、简述ajax执行流程
### 23、说说严格模式的限制
### 24、git 和 svn的区别?
### 25、什么是提升？
### 26、ES6或ECMAScript 2015有哪些新特性？
### 27、为什么此代码 `obj.someprop.x` 会引发错误?
### 28、如何理解同步和异步？
### 29、事件委托？有什么好处?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
