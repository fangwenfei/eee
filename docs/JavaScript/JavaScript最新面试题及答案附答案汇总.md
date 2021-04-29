# JavaScript最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是 IIFE，它的用途是什么？

**IIFE**或立即调用的函数表达式是在创建或声明后将被调用或执行的函数。创建**IIFE的**语法是，将`function (){}`包裹在在括号`()`内，然后再用另一个括号`()`调用它，如：`(function(){})()`

```
(function(){
  ...
} ());

(function () {
  ...
})();

(function named(params) {
  ...
})();

(() => {

});

(function (global) {
  ...
})(window);

const utility = (function () {
  return {
    ...
  }
})
```

这些示例都是有效的**IIFE**。倒数第二个救命表明我们可以将参数传递给**IIFE**函数。最后一个示例表明，我们可以将`IIFE`的结果保存到变量中，以便稍后使用。

**IIFE**的一个主要作用是避免与全局作用域内的其他变量命名冲突或污染全局命名空间，来个例子。

`<script src="https://cdnurl.com/somelibrary.js"></script>`

假设我们引入了一个`omelibr.js`的链接，它提供了一些我们在代码中使用的全局函数，但是这个库有两个方法我们没有使用：`createGraph`和`drawGraph`，因为这些方法都有`bug`。我们想实现自己的`createGraph`和`drawGraph`方法。

解决此问题的一种方法是直接覆盖：

```
<script src="https://cdnurl.com/somelibrary.js"></script>
<script>
   function createGraph() {
      // createGraph logic here
   }
   function drawGraph() {
      // drawGraph logic here
   }
</script>
```

当我们使用这个解决方案时，我们覆盖了库提供给我们的那两个方法。

另一种方式是我们自己改名称：

```
<script src="https://cdnurl.com/somelibrary.js"></script>
<script>
   function myCreateGraph() {
      // createGraph logic here
   }
   function myDrawGraph() {
      // drawGraph logic here
   }
</script>
```

当我们使用这个解决方案时，我们把那些函数调用更改为新的函数名。

还有一种方法就是使用**IIFE**：

```
<script src="https://cdnurl.com/somelibrary.js"></script>
<script>
   const graphUtility = (function () {
      function createGraph() {
         // createGraph logic here
      }
      function drawGraph() {
         // drawGraph logic here
      }
      return {
         createGraph,
         drawGraph
      }
   })
</script>
```

在此解决方案中，我们要声明了`graphUtility` 变量，用来保存**IIFE**执行的结果，该函数返回一个包含两个方法`createGraph`和`drawGraph`的对象。

**IIFE** 还可以用来解决一个常见的面试题：

```
var li = document.querySelectorAll('.list-group > li');
for (var i = 0, len = li.length; i < len; i++) {
   li[i].addEventListener('click', function (e) {
      console.log(i);
   })
```

假设我们有一个带有`list-group`类的`ul`元素，它有`5`个`li`子元素。当我们单击单个`li`元素时，打印对应的下标值。但在此外上述代码不起作用，这里每次点击 `li` 打印 `i` 的值都是`5`，这是由于闭包的原因。

**闭包**只是函数记住其当前作用域，父函数作用域和全局作用域的变量引用的能力。当我们在全局作用域内使用`var`关键字声明变量时，就创建全局变量`i`。因此，当我们单击`li`元素时，它将打印`5`，因为这是稍后在回调函数中引用它时`i`的值。

使用 **IIFE** 可以解决此问题：

`var li = document.querySelectorAll('.list-group > li'); for (var i = 0, len = li.length; i < len; i++) { (function (currentIndex) { li[currentIndex].addEventListener('click', function (e) { console.log(currentIndex); }) })(i); }`

该解决方案之所以行的通，是因为**IIFE**会为每次迭代创建一个新的作用域，我们捕获`i`的值并将其传递给`currentIndex`参数，因此调用**IIFE**时，每次迭代的`currentIndex`值都是不同的。


### 2、DOM事件模型和事件流？

DOM事件模型包括事件捕获(自上而下触发)与事件冒泡(自下而上触发，ie用的就是冒泡)机制。基于事件冒泡机制可以完成事件代理。

> 事件捕获


![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/b3d7c68a2b2740e7b784f25c2db3d14d~tplv-k3u1fbpfcp-zoom-1.image#alt=%E5%9C%A8%E8%BF%99%E9%87%8C%E6%8F%92%E5%85%A5%E5%9B%BE%E7%89%87%E6%8F%8F%E8%BF%B0)

> 事件冒泡


![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/f354c39ed3e9462b9b735297fd031c0b~tplv-k3u1fbpfcp-zoom-1.image#alt=%E5%9C%A8%E8%BF%99%E9%87%8C%E6%8F%92%E5%85%A5%E5%9B%BE%E7%89%87%E6%8F%8F%E8%BF%B0)

DOM事件流包括三个阶段事件捕获阶段、处于目标阶段、事件冒泡阶段。


### 3、javascript有哪些方法定义对象

**1、** 对象字面量： `var obj = {};`

**2、** 构造函数： `var obj = new Object();`

**3、** Object.create(): `var obj = Object.create(Object.prototype);`


### 4、&& 运算符能做什么

`&&` 也可以叫**逻辑与**，在其操作数中找到第一个虚值表达式并返回它，如果没有找到任何虚值表达式，则返回最后一个真值表达式。它采用短路来防止不必要的工作。

```
console.log(false && 1 && []); // false
console.log(" " && true && 5); // 5
```

**使用`if`语句**

```
const router: Router = Router();
router.get('/endpoint', (req: Request, res: Response) => {
   let conMobile: PoolConnection;
   try {
      //do some db operations
   } catch (e) {
   if (conMobile) {
    conMobile.release();
   }
  }
});
```

**使用`&&`操作符**

```
const router: Router = Router();

router.get('/endpoint', (req: Request, res: Response) => {
  let conMobile: PoolConnection;
  try {
     //do some db operations
  } catch (e) {
    conMobile && conMobile.release()
  }
});
```


### 5、ajax 和 jsonp ？

**ajax和jsonp的区别：**

相同点：都是请求一个url

不同点：ajax的核心是通过xmlHttpRequest获取内容

jsonp的核心则是动态添加



### 6、同步和异步的区别?

javascript同步表示sync，指：代码依次执行 javascript异步表示async，指：代码执行不按顺序，‘跳过’执行，待其他某些代码执行完后再来执行，成为异步。


### 7、ajax请求方式有几种（8种）？

1）$$.get(url,\[data\],\[callback\])  
2）$$.getJSON(url,[data],[callback])

3）$$.post(url,\[data\],\[callback\],\[type\])  
4）$$.ajax(opiton)

5）$.getScript( url, [callback] )

6）jquery对象.load( url, [data], [callback] )

7）serialize() 与 serializeArray()


### 8、JavaScript原型，原型链 ? 有什么特点？

**1、** 每个对象都会在其内部初始化一个属性，就是`prototype`(原型)，当我们访问一个对象的属性时

**2、** 如果这个对象内部不存在这个属性，那么他就会去`prototype`里找这个属性，这`个prototype`又会有自己的`prototype`，于是就这样一直找下去，也就是我们平时所说的原型链的概念

**3、** 关系：`instance.constructor.prototype = instance.__proto__`

**特点：**

**1、** `JavaScript`对象是通过引用来传递的，我们创建的每个新对象实体中并没有一份属于自己的原型副本。当我们修改原型时，与之相关的对象也会继承这一改变

2.当我们需要一个属性的时，`Javascript`引擎会先看当前对象中是否有这个属性， 如果没有的 就会查找他的`Prototype`对象是否有这个属性，如此递推下去，一直检索到 `Object` 内建对象


### 9、26.移动端上什么是点击穿透?

**点击穿透现象有3种：**

**点击穿透问题：**

点击蒙层（mask）上的关闭按钮，蒙层消失后发现触发了按钮下面元素的click事件跨页面点击穿透问题：如果按钮下面恰好是一个有href属性的a标签，那么页面就会发生跳转另一种跨页面点击穿透问题：这次没有mask了，直接点击页内按钮跳转至新页，然后发现新页面中对应位置元素的click事件被触发了

**解决方案：**

**1、** 只用touch

最简单的解决方案，完美解决点击穿透问题

把页面内所有click全部换成touch事件（ touchstart 、’touchend’、’tap’）

**2、** 只用click

下下策，因为会带来300ms延迟，页面内任何一个自定义交互都将增加300毫秒延迟

**3、** tap后延迟350ms再隐藏mask

改动最小，缺点是隐藏mask变慢了，350ms还是能感觉到慢的

**4、** pointer-events

比较麻烦且有缺陷， 不建议使用mask隐藏后，给按钮下面元素添上 pointer-events: none; 样式，让click穿过去，350ms后去掉这个样式，恢复响应缺陷是mask消失后的的350ms内，用户可以看到按钮下面的元素点着没反应，如果用户手速很快的话一定会发现


### 10、请解释什么是事件代理

**1、** 事件代理（`Event Delegation`），又称之为事件委托。是 `JavaScript` 中常用绑定事件的常用技巧。顾名思义，“事件代理”即是把原本需要绑定的事件委托给父元素，让父元素担当事件监听的职务。事件代理的原理是DOM元素的事件冒泡。使用事件代理的好处是可以提高性能

**2、** 可以大量节省内存占用，减少事件注册，比如在`table`上代理所有`td`的`click`事件就非常棒

**3、** 可以实现当新增子对象时无需再次对其绑定


### 11、什么是默认参数？
### 12、什么是移动端的300ms延迟？什么是点击穿透？解决方案?
### 13、["1", "2", "3"].map(parseInt) 答案是多少？
### 14、简述下 this 和定义属性和方法的时候有什么区别?Prototype？
### 15、`in` 运算符和 `Object.hasOwnProperty` 方法有什么区别？
### 16、判断数据类型
### 17、call & apply 两者之间的区别###
### 18、如何解决跨域问题?
### 19、如何检查值是否虚值？
### 20、30.Jq中怎么样编写插件?
### 21、defer和async
### 22、Promise 是什么？
### 23、函数fn1 函数fn2 函数fn3，如果想在三个函数都执行完成后执行某一个事件应该如何实现?
### 24、常见兼容性问题？
### 25、typeof？typeof [ ]返回数据类型是？
### 26、说说你对AMD和Commonjs的理解
### 27、25.Jq如何判断元素显示隐藏？
### 28、何为防抖和节流？如何实现？
### 29、变量作用域?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
