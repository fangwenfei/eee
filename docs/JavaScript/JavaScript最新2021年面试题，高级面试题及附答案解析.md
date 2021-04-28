# JavaScript最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、为什么在 JS 中比较两个相似的对象时返回 false？

先看下面的例子：

```
let a = { a: 1 };
let b = { a: 1 };
let c = a;
console.log(a === b); // 打印 false，即使它们有相同的属性
console.log(a === c); // true
```

JS 以不同的方式比较对象和基本类型。在基本类型中，JS 通过值对它们进行比较，而在对象中，JS 通过引用或存储变量的内存中的地址对它们进行比较。这就是为什么第一个`console.log`语句返回`false`，而第二个`console.log`语句返回`true`。`a`和`c`有相同的引用地址，而`a`和`b`没有。


### 2、什么是构造函数？与普通函数有什么区别?

构造函数：是一种特殊的方法、主要用来创建对象时初始化对象，总与new运算符一起使用，创建对象的语句中构造函数的函数名必须与类名完全相同。

与普通函数相比只能由new关键字调用，构造函数是类的标示


### 3、AJAX 是什么？

即异步的 **JavaScript 和 XML**，是一种用于创建快速动态网页的技术，传统的网页（不使用 AJAX）如果需要更新内容，必需重载整个网页面。使用**AJAX**则不需要加载更新整个网页，实现部分内容更新

用到AJAX的技术：

**HTML** - 网页结构

**CSS** - 网页的样式

**JavaScript** - 操作网页的行为和更新DOM

**XMLHttpRequest API** - 用于从服务器发送和获取数据

**PHP，Python，Nodejs** - 某些服务器端语言


### 4、new操作符具体干了什么呢?

**1、** 创建一个空对象，并且 `this` 变量引用该对象，同时还继承了该函数的原型

**2、** 属性和方法被加入到 `this` 引用的对象中

**3、** 新创建的对象由 `this` 所引用，并且最后隐式的返回 `this`


### 5、Jq中有几种选择器?分别是什么?

层叠选择器、基本过滤选择器、内容过滤选择器、可视化过滤选择器、属性过滤选择器、子元素过滤选择器、表单元素选择器、表单元素过滤选择器


### 6、JavaScript原型，原型链 ? 有什么特点？

**1、** 每个对象都会在其内部初始化一个属性，就是`prototype`(原型)，当我们访问一个对象的属性时

**2、** 如果这个对象内部不存在这个属性，那么他就会去`prototype`里找这个属性，这`个prototype`又会有自己的`prototype`，于是就这样一直找下去，也就是我们平时所说的原型链的概念

**3、** 关系：`instance.constructor.prototype = instance.__proto__`

**特点：**

**1、** `JavaScript`对象是通过引用来传递的，我们创建的每个新对象实体中并没有一份属于自己的原型副本。当我们修改原型时，与之相关的对象也会继承这一改变

2.当我们需要一个属性的时，`Javascript`引擎会先看当前对象中是否有这个属性， 如果没有的 就会查找他的`Prototype`对象是否有这个属性，如此递推下去，一直检索到 `Object` 内建对象


### 7、attribute和property的区别是什么？

**1、** `attribute`是`dom`元素在文档中作为`html`标签拥有的属性；

**2、** `property`就是`dom`元素在`js`中作为对象拥有的属性。

**3、** 对于`html`的标准属性来说，`attribute`和`property`是同步的，是会自动更新的

**4、** 但是对于自定义的属性来说，他们是不同步的


### 8、简述下 this 和定义属性和方法的时候有什么区别?Prototype？

this表示当前对象，如果在全局作用范围内使用this，则指代当前页面对象window； 如果在函数中使用this，则this指代什么是根据运行时此函数在什么对象上被调用。 我们还可以使用apply和call两个全局方法来改变函数中this的具体指向。

prototype本质上还是一个JavaScript对象。 并且每个函数都有一个默认的prototype属性。

在prototype上定义的属性方法为所有实例共享，所有实例皆引用到同一个对象，单一实例对原型上的属性进行修改，也会影响到所有其他实例。


### 9、函数表达式和函数声明之间有什么区别？

看下面的例子：

```
hoistedFunc();
notHoistedFunc();

function hoistedFunc(){
  console.log("注意：我会被提升");
}

var notHoistedFunc = function(){
  console.log("注意：我没有被提升");
}
```

`notHoistedFunc`调用抛出异常：`Uncaught TypeError: notHoistedFunc is not a function`，而`hoistedFunc`调用不会，因为`hoistedFunc`会被提升到作用域的顶部，而`notHoistedFunc` 不会。


### 10、怎么理解宏任务，微任务？？？

**1、** 宏任务有：`script(整体代码)`、`setTimeout`、`setInterval`、`I/O`、页面渲染；

**2、** 微任务有：`Promise.then`、`Object.observe`、`MutationObserver`。

**3、** 执行顺序大致如下：

**4、** 主线程任务——>宏任务——>微任务——>微任务里的宏任务——>.......——>直到任务全部完成


### 11、Jq中 attr 和 prop 有什么区别###
### 12、如何确保ajax或连接不走缓存路径
### 13、30.Jq中怎么样编写插件?
### 14、什么是回调函数？
### 15、html和xhtml有什么区别?
### 16、offsetWidth/offsetHeight,clientWidth/clientHeight与scrollWidth/scrollHeight的区别
### 17、你有哪些性能优化的方法？
### 18、vue、react、angular
### 19、split() join()?
### 20、闭包
### 21、Promise 是什么？
### 22、那些操作会造成内存泄漏？
### 23、简述下工作流程###
### 24、在jq中 mouseover mouseenter mouseout mouseleave 和 hover有什么关联?
### 25、js的几种继承方式？
### 26、手动实现 `Array.prototype.map 方法`
### 27、有哪些数据类型？
### 28、25.Jq如何判断元素显示隐藏？
### 29、手动实现`Array.prototype.reduce`方法
### 30、如何使用storage 对js文件进行缓存




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
