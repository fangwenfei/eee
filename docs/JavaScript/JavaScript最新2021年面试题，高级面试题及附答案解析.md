# JavaScript最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是缓存及它有什么作用？

缓存是建立一个函数的过程，这个函数能够记住之前计算的结果或值。使用缓存函数是为了避免在最后一次使用相同参数的计算中已经执行的函数的计算。这节省了时间，但也有不利的一面，即我们将消耗更多的内存来保存以前的结果。


### 2、什么是默认参数？

默认参数是在 JS 中定义默认变量的一种新方法，它在ES6或ECMAScript 2015版本中可用。

```
//ES5 Version
function add(a,b){
  a = a || 0;
  b = b || 0;
  return a + b;
}

//ES6 Version
function add(a = 0, b = 0){
  return a + b;
}
add(1); // returns 1
```

我们还可以在默认参数中使用解构。

```
function getFirst([first, ...rest] = [0, 1]) {
  return first;
}

getFirst();  // 0
getFirst([10,20,30]);  // 10

function getArr({ nums } = { nums: [1, 2, 3, 4] }){
    return nums;
}

getArr(); // [1, 2, 3, 4]
getArr({nums:[5,4,3,2,1]}); // [5,4,3,2,1]
```

我们还可以使用先定义的参数再定义它们之后的参数。

```
function doSomethingWithValue(value = "Hello World", callback = () => { console.log(value) }) {
  callback();
}
doSomethingWithValue(); //"Hello World"
```


### 3、什么是 IIFE，它的用途是什么？

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


### 4、简述下 this 和定义属性和方法的时候有什么区别?Prototype？

this表示当前对象，如果在全局作用范围内使用this，则指代当前页面对象window； 如果在函数中使用this，则this指代什么是根据运行时此函数在什么对象上被调用。 我们还可以使用apply和call两个全局方法来改变函数中this的具体指向。

prototype本质上还是一个JavaScript对象。 并且每个函数都有一个默认的prototype属性。

在prototype上定义的属性方法为所有实例共享，所有实例皆引用到同一个对象，单一实例对原型上的属性进行修改，也会影响到所有其他实例。


### 5、eval是做什么的？

**1、** 它的功能是把对应的字符串解析成`JS`代码并运行

**2、** 应该避免使用`eval`，不安全，非常耗性能（`2`次，一次解析成`js`语句，一次执行）

**3、** 由`JSON`字符串转换为JSON对象的时候可以用`eval，var obj =eval('('+ str +')')`


### 6、Jq中 attr 和 prop 有什么区别###

对于HTML元素本身就带有的固有属性，在处理时，使用prop方法。

对于HTML元素我们自己自定义的DOM属性，在处理时，使用attr方法。


### 7、使用 + 或一元加运算符是将字符串转换为数字的最快方法吗？

根据MDN文档，`+`是将字符串转换为数字的最快方法，因为如果值已经是数字，它不会执行任何操作。


### 8、git 和 svn的区别?
### 9、Function.prototype.apply 方法的用途是什么？
### 10、隐式和显式转换有什么区别）？
### 11、`var`,`let`和`const`的区别是什么？
### 12、`require`/`import`之间的区别？
### 13、为什么在调用这个函数时，代码中的`b`会变成一个全局变量?
### 14、手动实现`Array.prototype.reduce`方法
### 15、$(function(){})和window.onload 和 $(document).ready(function(){})
### 16、new操作符具体干了什么呢?
### 17、通过new创建一个对象的时候，函数内部有哪些改变###
### 18、谈谈This对象的理解
### 19、Javascript如何实现继承？
### 20、什么是包装对象（wrapper object）？
### 21、25.Jq如何判断元素显示隐藏？
### 22、JSON 的了解？**
### 23、什么是提升？
### 24、什么是闭包？
### 25、Function.prototype.bind 的用途是什么？
### 26、JSON 的了解？
### 27、自执行函数?用于什么场景？好处?
### 28、Object.seal 和 Object.freeze 方法之间有什么区别？
### 29、变量作用域?
### 30、常见web安全及防护原理




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
