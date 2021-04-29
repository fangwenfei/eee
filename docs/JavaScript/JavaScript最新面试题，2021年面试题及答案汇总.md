# JavaScript最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、基本数据类型和引用数据类型有什么区别？

**两者作为函数的参数进行传递时：**

**1、** 基本数据类型传入的是数据的副本，原数据的更改不会影响传入后的数据。

**2、** 引用数据类型传入的是数据的引用地址，原数据的更改会影响传入后的数据。

**两者在内存中的存储位置：**

**1、** 基本数据类型存储在栈中。

**2、** 引用数据类型在栈中存储了指针，该指针指向的数据实体存储在堆中。


### 2、arguments 的对象是什么？

`arguments`对象是函数中传递的参数值的集合。它是一个类似数组的对象，因为它有一个length属性，我们可以使用数组索引表示法`arguments[1]`来访问单个值，但它没有数组中的内置方法，如：`forEach`、`reduce`、`filter`和`map`。

我们可以使用`Array.prototype.slice`将`arguments`对象转换成一个数组。

```
function one() {
  return Array.prototype.slice.call(arguments);
}
```

**注意:箭头函数中没有`arguments`对象。**

```
function one() {
  return arguments;
}
const two = function () {
  return arguments;
}
const three = function three() {
  return arguments;
}

const four = () => arguments;

four(); // Throws an error  - arguments is not defined
```

当我们调用函数`four`时，它会抛出一个`ReferenceError: arguments is not defined error`。使用`rest`语法，可以解决这个问题。

`const four = (...args) => args;`

这会自动将所有参数值放入数组中。


### 3、$(function(){})和window.onload 和 $(document).ready(function(){})

window.onload:用于当页面的所有元素，包括外部引用文件，图片等都加载完毕时运行函数内的函数。load方法只能执行一次，如果在js文件里写了多个，只能执行最后一个。

$$(document).ready(function()\{\})和$$(function(){})都是用于当页面的标准DOM元素被解析成DOM树后就执行内部函数。这个函数是可以在js文件里多次编写的，对于多人共同编写的js就有很大的优势，因为所有行为函数都会执行到。而且$(document).ready()函数在HMTL结构加载完后就可以执行，不需要等大型文件加载或者不存在的连接等耗时工作完成才执行，效率高。


### 4、为什么typeof null 返回 object？如何检查一个值是否为 null？

`typeof null == 'object'`总是返回`true`，因为这是自 JS 诞生以来`null`的实现。曾经有人提出将`typeof null == 'object'`修改为`typeof null == 'null'`，但是被拒绝了，因为这将导致更多的**bug**。

我们可以使用严格相等运算符`===`来检查值是否为`null`。

```
function isNull(value){
  return value === null;
}
```


### 5、变量作用域?

```
//变量作用域：一个变量的作用域是程序源代码中定义这个变量的区域。全局变量拥有全局作用域，
//在js代码中任何地方都是有定义的。在函数内声明的变量只在函数体内有定义，它们是局部变量，
//作用域是局部性的。函数参数也是局部变量，它们只在函数体内有定义。
var a = "";
window.b=''”;
function(e) {
       var c= "";
       d="";
       e="";
}
function go() {
       console.info(this);//window
       return function() {
               console.info(this); // window
               return {
                b:function(){
                       console.info(this); //b的父对象
                   }
            }
       }
}
go()().b();
```


### 6、html和xhtml有什么区别?

HTML是一种基本的WEB网页设计语言，XHTML是一个基于XML的标记语言。

**1、** XHTML 元素必须被正确地嵌套。

**2、** XHTML 元素必须被关闭。

**3、** 标签名必须用小写字母。

**4、** 空标签也必须被关闭。

**5、** XHTML 文档必须拥有根元素。


### 7、JavaScript 中的虚值是什么？

`const falsyValues = ['', 0, null, undefined, NaN, false];`

简单的来说虚值就是是在转换为布尔值时变为 `false` 的值。


### 8、函数表达式和函数声明之间有什么区别？

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


### 9、如何copy一个dom元素？

原生Js方法：var div = document.getElementsByTagName('div')[0];

var clone = div.cloneNode();

Jquery方法：$('div').clone();

在默认情况下，.clone()方法不会复制匹配的元素或其后代元素中绑定的事件。不过，可以为这个方法传递一个布尔值参数，将这个参数设置为true, 就可以连同事件一起复制，即.clone(true)。


### 10、Function.prototype.apply 和 Function.prototype.call 之间有什么区别？

`apply()`方法可以在使用一个指定的 `this` 值和一个参数数组（或类数组对象）的前提下调用某个函数或方法。`call()`方法类似于`apply()`，不同之处仅仅是`call()`接受的参数是参数列表。

```
const obj1 = {
result:0
};

const obj2 = {
result:0
};

function reduceAdd(){
  let result = 0;
  for(let i = 0, len = arguments.length; i < len; i++){
    result += arguments[i];
  }
  this.result = result;
}

reduceAdd.apply(obj1, [1, 2, 3, 4, 5]); // 15
reduceAdd.call(obj2, 1, 2, 3, 4, 5); // 15
```


### 11、commonjs?requirejs?AMD|CMD|UMD?
### 12、js延迟加载的方式有哪些？
### 13、数据持久化技术(ajax)?简述ajax流程###
### 14、什么是`Set`对象，它是如何工作的？
### 15、什么是 ES6 模块？
### 16、Function.prototype.apply 方法的用途是什么？
### 17、说说你对AMD和Commonjs的理解
### 18、回调函数?
### 19、如何在一行中计算多个表达式的值？
### 20、什么是事件传播?
### 21、什么是 IIFE，它的用途是什么？
### 22、同步和异步的区别?
### 23、谈谈This对象的理解
### 24、sessionStorage和localstroage与cookie之间有什么关联, cookie最大存放多少字节
### 25、defer和async
### 26、如何在不使用`%`模运算符的情况下检查一个数字是否是偶数？
### 27、如何通过原生js 判断一个元素当前是显示还是隐藏状态?
### 28、jQuery与jQuery UI 有啥区别？
### 29、说几条写JavaScript的基本规范？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
