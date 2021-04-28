# JavaScript最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、如何检查值是否虚值？

使用 `Boolean` 函数或者 `!!` 运算符。


### 2、有哪些数据类型？

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


### 3、如何理解同步和异步？

同步：按照代码书写顺序一一执行处理指令的一种模式，上一段代码执行完才能执行下一段代码。

异步：可以理解为一种并行处理的方式，不必等待一个程序执行完，可以执行其它的任务。

JS之所以需要异步的原因在于JS是单线程运行的。常用的异步场景有：定时器、ajax请求、事件绑定。


### 4、请解释什么是事件代理

**1、** 事件代理（`Event Delegation`），又称之为事件委托。是 `JavaScript` 中常用绑定事件的常用技巧。顾名思义，“事件代理”即是把原本需要绑定的事件委托给父元素，让父元素担当事件监听的职务。事件代理的原理是DOM元素的事件冒泡。使用事件代理的好处是可以提高性能

**2、** 可以大量节省内存占用，减少事件注册，比如在`table`上代理所有`td`的`click`事件就非常棒

**3、** 可以实现当新增子对象时无需再次对其绑定


### 5、什么是`Set`对象，它是如何工作的？

**Set** 对象允许你存储任何类型的唯一值，无论是原始值或者是对象引用。

我们可以使用`Set`构造函数创建`Set`实例。

`const set1 = new Set(); const set2 = new Set(["a","b","c","d","d","e"]);`

我们可以使用`add`方法向`Set`实例中添加一个新值，因为`add`方法返回`Set`对象，所以我们可以以链式的方式再次使用`add`。如果一个值已经存在于`Set`对象中，那么它将不再被添加。

`set2.add("f"); set2.add("g").add("h").add("i").add("j").add("k").add("k"); // 后一个『k』不会被添加到set对象中，因为它已经存在了`

我们可以使用`has`方法检查`Set`实例中是否存在特定的值。

`set2.has("a") // true set2.has("z") // true`

我们可以使用`size`属性获得`Set`实例的长度。

`set2.size // returns 10`

可以使用`clear`方法删除 `Set` 中的数据。

`set2.clear();`

我们可以使用`Set`对象来删除数组中重复的元素。

`const numbers = [1, 2, 3, 4, 5, 6, 6, 7, 8, 8, 5]; const uniqueNums = [...new Set(numbers)]; // [1,2,3,4,5,6,7,8]`


### 6、undefined 和 null 有什么区别？

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


### 7、你有哪些性能优化的方法？

**1、** 减少http请求次数：CSS Sprites, JS、CSS源码压缩、图片大小控制合适；网页Gzip， CDN托管，data缓存 ，图片服务器。

**2、** 前端模板 JS+数据，减少由于HTML标签导致的带宽浪费，前端用变量保存AJAX请求结果，每次操作本地变量，不用请求，减少请求次数

**3、** 用innerHTML代替DOM操作，减少DOM操作次数，优化javascript性能。

**4、** 当需要设置的样式很多时设置className而不是直接操作style。

**5、** 少用全局变量、缓存DOM节点查找的结果。减少IO读取操作。

**6、** 避免使用CSS Expression（css表达式)又称Dynamic properties(动态属性)。

**7、** 图片预加载，将样式表放在顶部，将脚本放在底部 加上时间戳。

**8、** 避免在页面的主体布局中使用table，table要等其中的内容完全下载之后才会显示出来，显示比div+css布局慢。


### 8、如何改变this指针的指向？

可以使用`apply`、`call`、`bind`方法改变`this`指向(并不会改变函数的作用域)。比较如下：

**1、** 三者第一个参数都是`this`要指向的对象，也就是想指定的上下文，上下文就是指调用函数的那个对象(没有就指向全局window)；

**2、** `bind`和`call`的第二个参数都是数组，`apply`接收多个参数并用逗号隔开；

**3、** `apply`和`call`只对原函数做改动，`bind`会返回新的函数(要生效还得再调用一次)。


### 9、如何解决跨域问题?

Jsonp、iframe、window.name、window.postMessage、服务器上设置代理页面


### 10、什么是包装对象（wrapper object）？

我们现在复习一下JS的数据类型，JS数据类型被分为两大类，**基本类型**和**引用类型**。

基本类型：`Undefined`,`Null`,`Boolean`,`Number`,`String`,`Symbol`,`BigInt`

引用类型：`Object`,`Array`,`Date`,`RegExp`等，说白了就是对象。

其中引用类型有方法和属性，但是基本类型是没有的，但我们经常会看到下面的代码：

```
let name = "marko";

console.log(typeof name); // "string"
console.log(name.toUpperCase()); // "MARKO"
```

`name`类型是 `string`，属于基本类型，所以它没有属性和方法，但是在这个例子中，我们调用了一个`toUpperCase()`方法，它不会抛出错误，还返回了对象的变量值。

原因是基本类型的值被临时转换或强制转换为**对象**，因此`name`变量的行为类似于**对象**。除`null`和`undefined`之外的每个基本类型都有自己**包装对象**。也就是：`String`，`Number`，`Boolean`，`Symbol`和`BigInt`。在这种情况下，`name.toUpperCase()`在幕后看起来如下：

`console.log(new String(name).toUpperCase()); // "MARKO"`

在完成访问属性或调用方法之后，新创建的对象将立即被丢弃。


### 11、对象的 prototype(原型) 是什么？
### 12、js延迟加载的方式有哪些？
### 13、简述下你理解的面向对象？
### 14、事件流?事件捕获？事件冒泡？
### 15、谈谈你对ES6的理解
### 16、使用 + 或一元加运算符是将字符串转换为数字的最快方法吗？
### 17、常见兼容性问题？
### 18、判断数据类型的方法有哪些？
### 19、什么是事件传播?
### 20、html和xhtml有什么区别?
### 21、如何知道是否在元素中使用了`event.preventDefault()`方法？
### 22、怎么理解宏任务，微任务？？？
### 23、谈谈This对象的理解
### 24、javascript有哪些方法定义对象
### 25、ajax中 get 和 post 有什么区别?
### 26、Jq中如何实现多库并存?
### 27、JSON 的了解？
### 28、AJAX 是什么？
### 29、实现继承的方法有哪些？？？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
