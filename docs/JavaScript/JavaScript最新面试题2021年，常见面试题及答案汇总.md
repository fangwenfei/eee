# JavaScript最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是对象解构？

**对象析构**是从对象或数组中获取或提取值的一种新的、更简洁的方法。假设有如下的对象：

```
const employee = {
  firstName: "Marko",
  lastName: "Polo",
  position: "Software Developer",
  yearHired: 2017
};
```

从对象获取属性，早期方法是创建一个与对象属性同名的变量。这种方法很麻烦，因为我们要为每个属性创建一个新变量。假设我们有一个大对象，它有很多属性和方法，用这种方法提取属性会很麻烦。

`var firstName = employee.firstName; var lastName = employee.lastName; var position = employee.position; var yearHired = employee.yearHired;`

使用解构方式语法就变得简洁多了：

`{ firstName, lastName, position, yearHired } = employee;`

我们还可以为属性取别名：

`let { firstName: fName, lastName: lName, position, yearHired } = employee;`

当然如果属性值为 `undefined` 时，我们还可以指定默认值：

`let { firstName = "Mark", lastName: lName, position, yearHired } = employee;`


### 2、数据持久化技术(ajax)?简述ajax流程###

**1、** 客户端产生js的事件

**2、** 创建XMLHttpRequest对象

**3、** 对XMLHttpRequest进行配置

**4、** 通过AJAX引擎发送异步请求

**5、** 服务器端接收请求并且处理请求，返回html或者xml内容

**6、** XML调用一个callback()处理响应回来的内容

**7、** 页面局部刷新


### 3、如何copy一个dom元素？

原生Js方法：var div = document.getElementsByTagName('div')[0];

var clone = div.cloneNode();

Jquery方法：$('div').clone();

在默认情况下，.clone()方法不会复制匹配的元素或其后代元素中绑定的事件。不过，可以为这个方法传递一个布尔值参数，将这个参数设置为true, 就可以连同事件一起复制，即.clone(true)。


### 4、javascript 代码中的"use strict";是什么意思 ? 使用它区别是什么？

`use strict`是一种`ECMAscript 5` 添加的（严格）运行模式,这种模式使得 Javascript 在更严格的条件下运行,使`JS`编码更加规范化的模式,消除`Javascript`语法的一些不合理、不严谨之处，减少一些怪异行为


### 5、谈谈你对webpack的看法

**1、** `WebPack` 是一个模块打包工具，你可以使用`WebPack`管理你的模块依赖，并编绎输出模块们所需的静态文件。它能够很好地管理、打包`Web`开发中所用到的`HTML`、`Javascript`、`CSS`以及各种静态文件（图片、字体等），让开发过程更加高效。对于不同类型的资源，`webpack`有对应的模块加载器。`webpack`模块打包器会分析模块间的依赖关系，最后 生成了优化且合并后的静态资源


### 6、typeof？typeof [ ]返回数据类型是？

```
//判断基本数据类型；var a=[];typeof a输出object；
//本来判断一个对象类型用typeof是最好的，不过对于Array类型是不适用的，
//可以使用 instanceof操作符：
       var arrayStr=new Array("1","2","3","4","5");    
       alert(arrayStr instanceof Array); 
//当然以上在一个简单的页面布局里面是没有问题的，如果是复杂页面情况，
//入获取的是frame内部的Array对象，可以用这个函数判断：
       function isArray(obj) {      
          return Object.prototype.toString.call(obj) === '[object Array]';       
       }
```


### 7、除了jsonp 还有什么跨域方式###

javascript跨域有两种情况：

**1、** 基于同一父域的子域之间，如： [http://a.c.com](http://link.zhihu.com/?target=http%3A//a.c.com)和 [http://b.c.com](http://link.zhihu.com/?target=http%3A//b.c.com)

**2、** 基于不同的父域之间，如： [http://www.a.com](http://link.zhihu.com/?target=http%3A//www.a.com)和 [http://www.b.com](http://link.zhihu.com/?target=http%3A//www.b.com)

**3、** 端口的不同，如： [http://www.a.com:8080](http://link.zhihu.com/?target=http%3A//www.a.com%3A8080)和 [http://www.a.com:8088](http://link.zhihu.com/?target=http%3A//www.a.com%3A8088)

**4、** 协议不同，如： [http://www.a.com](http://link.zhihu.com/?target=http%3A//www.a.com)和 [https://www.a.com](http://link.zhihu.com/?target=https%3A//www.a.com)

**对于情况3和4，需要通过后台proxy来解决，具体方式如下：**

a、在发起方的域下创建proxy程序

b、发起方的js调用本域下的proxy程序

c、proxy将请求发送给接收方并获取相应数据

d、proxy将获得的数据返回给发起方的js

代码和ajax调用一致，其实这种方式就是通过ajax进行调用的

而情况1和2除了通过后台proxy这种方式外，还可以有多种办法来解决：

**1、** document.domain+iframe（只能解决情况1）：

a、在发起方页面和接收方页面设置document.domain，并将值设为父域的主域名(window.location.hostname)

b、在发起方页面创建一个隐藏的iframe，iframe的源是接收方页面

c、根据浏览器的不同，通过iframe.contentDocument || iframe.contentWindow.document来获得接收方页面的内容

d、通过获得的接收方页面的内容来与接收方进行交互

这种方法有个缺点，就是当一个域被攻击时，另一个域会有安全漏洞出现。


### 8、JavaScript 中的虚值是什么？

`const falsyValues = ['', 0, null, undefined, NaN, false];`

简单的来说虚值就是是在转换为布尔值时变为 `false` 的值。


### 9、`var`,`let`和`const`的区别是什么？

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


### 10、请解释什么是事件代理

**1、** 事件代理（`Event Delegation`），又称之为事件委托。是 `JavaScript` 中常用绑定事件的常用技巧。顾名思义，“事件代理”即是把原本需要绑定的事件委托给父元素，让父元素担当事件监听的职务。事件代理的原理是DOM元素的事件冒泡。使用事件代理的好处是可以提高性能

**2、** 可以大量节省内存占用，减少事件注册，比如在`table`上代理所有`td`的`click`事件就非常棒

**3、** 可以实现当新增子对象时无需再次对其绑定


### 11、如何创建一个对象？
### 12、说几条写JavaScript的基本规范？
### 13、那些操作会造成内存泄漏？
### 14、手动实现缓存方法
### 15、什么是作用域和作用域链？
### 16、'use strict' 是干嘛用的？
### 17、如何解决跨域问题?
### 18、js延迟加载的方式有哪些？
### 19、说说你对作用域链的理解
### 20、!! 运算符能做什么？
### 21、隐式和显式转换有什么区别）？
### 22、同步异步?
### 23、强制转换 显式转换 隐式转换?
### 24、节点类型?判断当前节点类型?
### 25、ajax的缺点
### 26、什么是缓存及它有什么作用？
### 27、一个页面从输入 URL 到页面加载显示完成，这个过程中都发生了什么？（流程说的越详细越好）
### 28、如何检查对象中是否存在某个属性？
### 29、自执行函数?用于什么场景？好处?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
