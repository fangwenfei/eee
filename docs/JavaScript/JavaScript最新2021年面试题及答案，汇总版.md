# JavaScript最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、声明函数作用提升?声明变量和声明函数的提升有什么区别

**变量声明提升：**

**1、** 变量申明在进入执行上下文就完成了。

**2、** 只要变量在代码中进行了声明，无论它在哪个位置上进行声明， js引擎都会将它的声明放在范围作用域的顶部；

**函数声明提升
### 2、["1", "2", "3"].map(parseInt) 答案是多少？

`[1, NaN, NaN]`因为 `parseInt` 需要两个参数 `(val, radix)`，其中`radix` 表示解析时用的基数。

`map`传了 `3`个`(element, index, array)`，对应的 `radix` 不合法导致解析失败。


### 3、!! 运算符能做什么？

`!!`运算符可以将右侧的值强制转换为布尔值，这也是将值转换为布尔值的一种简单方法。

```
console.log(!!null); // false
console.log(!!undefined); // false
console.log(!!''); // false
console.log(!!0); // false
console.log(!!NaN); // false
console.log(!!' '); // true
console.log(!!{}); // true
console.log(!![]); // true
console.log(!!1); // true
console.log(!![].length); // false
```


### 4、vue、react、angular

**`Vue.js`**

一个用于创建 `web` 交互界面的库，是一个精简的 `MVVM`。它通过双向数据绑定把 `View` 层和 `Model` 层连接了起来。实际的 `DOM` 封装和输出格式都被抽象为了`Directives` 和 `Filters`

**`AngularJS`**

是一个比较完善的前端`MVVM`框架，包含模板，数据双向绑定，路由，模块化，服务，依赖注入等所有功能，模板功能强大丰富，自带了丰富的 `Angular`指令

**`react`**

`React` 仅仅是 `VIEW` 层是`facebook`公司。推出的一个用于构建`UI`的一个库，能够实现服务器端的渲染。用了`virtual dom`，所以性能很好。


### 5、什么是AJAX？如何实现？

`ajax`是一种能够实现局部网页刷新的技术，可以使网页异步刷新。

`ajax`的实现主要包括四个步骤：

**1、** 创建核心对象`XMLhttpRequest`；

**2、** 利用`open`方法打开与服务器的连接；

**3、** 利用`send`方法发送请求；（"POST"请求时，还需额外设置请求头）

**4、** 监听服务器响应，接收返回值。

```
//1-创建核心对象
//该对象有兼容问题，低版本浏览器应使用ActiveXObject
const xthhp = new XMLHttpRequest();
//2-连接服务器
//open(method,url,async)
xhttp.open("POST", "http://localhost:3000", true)
//设置请求头
xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")；
//3-发送请求
//send方法发送请求参数，如为GET方法，则在open中url后拼接
xhttp.send({
    _id: 123
})
//4-接收服务器响应
//onreadystatechange事件，会在xhttp的状态发生变化时自动调用
xhttp.onreadystatechange = function() {
    //状态码共5种：0-未open  1-已open  2-已send  3-读取响应  4-响应读取结束
    if (xhttp.readyState == 4 && xhttp.status == 200) {
        alert("ajax请求已完成")
    }
}
```


### 6、$(function(){})和window.onload 和 $(document).ready(function(){})

window.onload:用于当页面的所有元素，包括外部引用文件，图片等都加载完毕时运行函数内的函数。load方法只能执行一次，如果在js文件里写了多个，只能执行最后一个。

$$(document).ready(function()\{\})和$$(function(){})都是用于当页面的标准DOM元素被解析成DOM树后就执行内部函数。这个函数是可以在js文件里多次编写的，对于多人共同编写的js就有很大的优势，因为所有行为函数都会执行到。而且$(document).ready()函数在HMTL结构加载完后就可以执行，不需要等大型文件加载或者不存在的连接等耗时工作完成才执行，效率高。


### 7、为什么typeof null 返回 object？如何检查一个值是否为 null？

`typeof null == 'object'`总是返回`true`，因为这是自 JS 诞生以来`null`的实现。曾经有人提出将`typeof null == 'object'`修改为`typeof null == 'null'`，但是被拒绝了，因为这将导致更多的**bug**。

我们可以使用严格相等运算符`===`来检查值是否为`null`。

```
function isNull(value){
  return value === null;
}
```


### 8、`var`,`let`和`const`的区别是什么？

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


### 9、谈谈你对webpack的看法

**1、** `WebPack` 是一个模块打包工具，你可以使用`WebPack`管理你的模块依赖，并编绎输出模块们所需的静态文件。它能够很好地管理、打包`Web`开发中所用到的`HTML`、`Javascript`、`CSS`以及各种静态文件（图片、字体等），让开发过程更加高效。对于不同类型的资源，`webpack`有对应的模块加载器。`webpack`模块打包器会分析模块间的依赖关系，最后 生成了优化且合并后的静态资源


### 10、为什么在 JS 中比较两个相似的对象时返回 false？

先看下面的例子：

```
let a = { a: 1 };
let b = { a: 1 };
let c = a;
console.log(a === b); // 打印 false，即使它们有相同的属性
console.log(a === c); // true
```

JS 以不同的方式比较对象和基本类型。在基本类型中，JS 通过值对它们进行比较，而在对象中，JS 通过引用或存储变量的内存中的地址对它们进行比较。这就是为什么第一个`console.log`语句返回`false`，而第二个`console.log`语句返回`true`。`a`和`c`有相同的引用地址，而`a`和`b`没有。


### 11、同步和异步的区别?
### 12、attribute和property的区别是什么？
### 13、如何判断值是否为数组？
### 14、什么是闭包? 堆栈溢出有什么区别？ 内存泄漏? 那些操作会造成内存泄漏？怎么样防止内存泄漏？
### 15、异步加载的方式有哪些？
### 16、什么是作用域？
### 17、commonjs?requirejs?AMD|CMD|UMD?
### 18、call & apply 两者之间的区别###
### 19、如何在不使用`%`模运算符的情况下检查一个数字是否是偶数？
### 20、JavaScript原型，原型链 ? 有什么特点？
### 21、Jq中 attr 和 prop 有什么区别###
### 22、常见web安全及防护原理
### 23、this是什么 在不同场景中分别代表什么###
### 24、Function.prototype.bind 的用途是什么？
### 25、null，undefined 的区别？
### 26、如何检查对象中是否存在某个属性？
### 27、说说你对promise的了解
### 28、ajax的缺点
### 29、平时工作中怎么样进行数据交互?如果后台没有提供数据怎么样进行开发?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
