# JavaScript最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是`Set`对象，它是如何工作的？

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


### 2、如何改变this指针的指向？

可以使用`apply`、`call`、`bind`方法改变`this`指向(并不会改变函数的作用域)。比较如下：

**1、** 三者第一个参数都是`this`要指向的对象，也就是想指定的上下文，上下文就是指调用函数的那个对象(没有就指向全局window)；

**2、** `bind`和`call`的第二个参数都是数组，`apply`接收多个参数并用逗号隔开；

**3、** `apply`和`call`只对原函数做改动，`bind`会返回新的函数(要生效还得再调用一次)。


### 3、commonjs?requirejs?AMD|CMD|UMD?

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


### 4、什么是事件传播?

当**事件**发生在**DOM**元素上时，该**事件**并不完全发生在那个元素上。在**“冒泡阶段”**中，事件冒泡或向上传播至父级，祖父母，祖父母或父级，直到到达`window`为止；而在**“捕获阶段”**中，事件从`window`开始向下触发元素 事件或`event.target`。

**事件传播有三个阶段：**

**1、** 捕获阶段 事件从 `window` 开始，然后向下到每个元素，直到到达目标元素。

**2、** 目标阶段 事件已达到目标元素。

**3、** 冒泡阶段 事件从目标元素冒泡，然后上升到每个元素，直到到达 `window`。


### 5、你觉得jQuery源码有哪些写的好的地方

**1、** `jquery`源码封装在一个匿名函数的自执行环境中，有助于防止变量的全局污染，然后通过传入`window`对象参数，可以使`window`对象作为局部变量使用，好处是当`jquery`中访问`window`对象的时候，就不用将作用域链退回到顶层作用域了，从而可以更快的访问window对象。同样，传入`undefined`参数，可以缩短查找`undefined`时的作用域链

**2、** `jquery`将一些原型属性和方法封装在了`jquery.prototype`中，为了缩短名称，又赋值给了`jquery.fn`，这是很形象的写法

**3、** 有一些数组或对象的方法经常能使用到，`jQuery`将其保存为局部变量以提高访问速度

**4、** `jquery`实现的链式调用可以节约代码，所返回的都是同一个对象，可以提高代码效率


### 6、同步和异步的区别?

**1、** 同步：浏览器访问服务器请求，用户看得到页面刷新，重新发请求,等请求完，页面刷新，新内容出现，用户看到新内容,进行下一步操作

**2、** 异步：浏览器访问服务器请求，用户正常操作，浏览器后端进行请求。等请求完，页面不刷新，新内容也会出现，用户看到新内容


### 7、== 和 === 有什么区别？

`==`用于一般比较，`===`用于严格比较，`==`在比较的时候可以转换数据类型`，===`严格比较，只要类型不匹配就返回`flase`。

先来看看 `==` 这兄弟：

强制是将值转换为另一种类型的过程。在这种情况下，`==`会执行隐式强制。在比较两个值之前，`==`需要执行一些规则。

假设我们要比较`x == y`的值。

**1、** 如果`x`和`y`的类型相同，则 JS 会换成`===`操作符进行比较。

**2、** 如果`x`为`null`, `y`为`undefined`，则返回`true`。

**3、** 如果`x`为`undefined`且`y`为`null`，则返回`true`。

**4、** 如果`x`的类型是`number`, `y`的类型是`string`，那么返回`x == toNumber(y)`。

**5、** 如果`x`的类型是`string`, `y`的类型是`number`，那么返回`toNumber(x) == y`。

**6、** 如果`x`为类型是`boolean`，则返回`toNumber(x)== y`。

**7、** 如果`y`为类型是`boolean`，则返回`x == toNumber(y)`。

**8、** 如果`x`是`string`、`symbol`或`number`，而`y`是`object`类型，则返回`x == toPrimitive(y)`。

**9、** 如果`x`是`object`，`y`是`string`，`symbol`则返回`toPrimitive(x) == y`。

**10、** 剩下的 返回 `false`


### 8、arguments 的对象是什么？
### 9、什么是原型、原型链？
### 10、call & apply 两者之间的区别###
### 11、事件流?事件捕获？事件冒泡？
### 12、JavaScript 中 `this` 值是什么？
### 13、promise###
### 14、typeof？typeof [ ]返回数据类型是？
### 15、`Function.prototype.call` 方法的用途是什么？
### 16、声明函数作用提升?声明变量和声明函数的提升有什么区别
### 17、什么是类？
### 18、那些操作会造成内存泄漏？
### 19、什么是事件冒泡？
### 20、回调函数?
### 21、如何copy一个dom元素？
### 22、ajax请求方式有几种（8种）？
### 23、&& 运算符能做什么
### 24、有哪些方法可以处理 JS 中的异步代码？
### 25、null，undefined 的区别？
### 26、call和apply 有什么好处？
### 27、强制转换 显式转换 隐式转换?
### 28、事件委托？有什么好处?
### 29、介绍js有哪些内置对象？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
