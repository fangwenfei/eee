# JavaScript最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是预编译语音|预编译处理器?

Sass是一种CSS预处理器语言，通过编程方式生成CSS代码。因为可编程，所以操控灵活性自由度高，方便实现一些直接编写CSS代码较困难的代码。

同时，因为Sass是生成CSS的语言，所以写出来的Sass文件是不能直接用的，必须经过编译器编译成CSS文件才能使用。

CSS 预处理器是一种语言用来为 CSS 增加一些编程的的特性，无需考虑浏览器的兼容性问题，例如你可以在 CSS 中使用变量、简单的程序逻辑、函数等等在编程语言中的一些基本技巧，可以让你的 CSS 更见简洁，适应性更强，代码更直观等诸多好处。最常用的css预处理器有sass、less css、stylus。


### 2、手动实现`Array.prototype.reduce`方法

`reduce()` 方法对数组中的每个元素执行一个由您提供的`reducer`函数(升序执行)，将其结果汇总为单个返回值。

```
function reduce(arr, reduceCallback, initialValue) {
  // 首先，检查传递的参数是否正确。
  if (!Array.isArray(arr) || !arr.length || typeof reduceCallback !== 'function') 
  {
    return [];
  } else {
    // 如果没有将initialValue传递给该函数，我们将使用第一个数组项作为initialValue
    let hasInitialValue = initialValue !== undefined;
    let value = hasInitialValue ? initialValue : arr[0];
   、

    // 如果有传递 initialValue，则索引从 1 开始，否则从 0 开始
    for (let i = hasInitialValue ? 0 : 1, len = arr.length; i < len; i++) {
      value = reduceCallback(value, arr[i], i, arr); 
    }
    return value;
  }
}
```


### 3、readystate 0~4

0：未初始化状态：此时，已经创建了一个XMLHttpRequest对象

1： 准备发送状态：此时，已经调用了XMLHttpRequest对象的open方法，并且XMLHttpRequest对象已经准备好将一个请求发送到服务器端

2：已经发送状态：此时，已经通过send方法把一个请求发送到服务器端，但是还没有收到一个响应

3：正在接收状态：此时，已经接收到HTTP响应头部信息，但是消息体部分还没有完全接收到

4：完成响应状态：此时，已经完成了HTTP响应的接收


### 4、null，undefined 的区别？

undefined表示变量声明但未初始化的值，null表示准备用来保存对象，还没有真正保存对象的值。从逻辑角度看，null表示一个空对象指针。


### 5、如何确保ajax或连接不走缓存路径

在Ajax中使用Get请求数据不会有页面缓存的问题，而使用POST请求可是有时候页面会缓存我们提交的信息，导致我们发送的异步请求不能正确的返回我们想要的数据

$.post(url,data ,ranNum:Math.random()} ,function(data){}）

ranNum : 这个是防止缓存的核心，每次发起请求都会用Math.random()方法生成一个随机的数字，这样子就会刷新url缓存


### 6、什么是提升？

**提升**是用来描述变量和函数移动到其(全局或函数)作用域顶部的术语。

为了理解提升，需要来了解一下**执行上下文**。**执行上下文**是当前正在执行的**“代码环境”**。执行上下文有两个阶段:`编译`和`执行`。

**编译**-在此阶段，JS 引荐获取所有**函数声明**并将其**提升**到其作用域的顶部，以便我们稍后可以引用它们并获取所有变量声明（使用`var`关键字进行声明），还会为它们提供默认值：`undefined`。

**执行**——在这个阶段中，它将值赋给之前提升的变量，并执行或调用函数(对象中的方法)。

**注意:** 只有使用`var`声明的变量，或者函数声明才会被提升，相反，函数表达式或箭头函数，`let`和`const`声明的变量，这些都不会被提升。

假设在全局使用域，有如下的代码：

```
console.log(y);
y = 1;
console.log(y);
console.log(greet("Mark"));

function greet(name){
  return 'Hello ' + name + '!';
}

var y;
```

上面分别打印：`undefined`,`1`, `Hello Mark!`。

上面代码在编译阶段其实是这样的：

```
function greet(name) {
  return 'Hello ' + name + '!';
}

var y; // 默认值 undefined

// 等待“编译”阶段完成，然后开始“执行”阶段

/*
console.log(y);
y = 1;
console.log(y);
console.log(greet("Mark"));
*/
```

编译阶段完成后，它将启动执行阶段调用方法，并将值分配给变量。

```
function greet(name) {
  return 'Hello ' + name + '!';
}

var y;

//start "execution" phase

console.log(y);
y = 1;
console.log(y);
console.log(greet("Mark"));
```


### 7、数组的排序方法（sort）？排序？汉字排序？

数组的排序方法：reverse()和sort()。reverse()方法会对反转数组项的顺序。

Eg:var values = [0, 1, 5, 10, 15]; values.sort();//0,1,10,15,5

var values = [1, 2, 3, 4, 5]; values.reverse();//5,4,3,2,1

js中的排序（详情参考： [http://www.tuicool.com/articles/IjInMbU](http://link.zhihu.com/?target=http%3A//www.tuicool.com/articles/IjInMbU)）

利用sort排序, 冒泡排序, 快速排序, 插入排序, 希尔排序, 选择排序

归并排序

localeCompare() 方法用于字符串编码的排序

localeCompare 方法：返回一个值，指出在当前的区域设置中两个字符串是否相同。


### 8、什么是事件冒泡？

当**事件**发生在**DOM**元素上时，该**事件**并不完全发生在那个元素上。在冒泡阶段，事件冒泡，或者事件发生在它的父代，祖父母，祖父母的父代，直到到达`window`为止。

假设有如下的 HTML 结构：

```
<div class="grandparent">
  <div class="parent">
    <div class="child">1</div>
  </div>
</div>
```

对应的 JS 代码:

```
function addEvent(el, event, callback, isCapture = false) {
  if (!el || !event || !callback || typeof callback !== 'function') return;
  if (typeof el === 'string') {
    el = document.querySelector(el);
  };
  el.addEventListener(event, callback, isCapture);
}

addEvent(document, 'DOMContentLoaded', () => {
  const child = document.querySelector('.child');
  const parent = document.querySelector('.parent');
  const grandparent = document.querySelector('.grandparent');

  addEvent(child, 'click', function (e) {
    console.log('child');
  });

  addEvent(parent, 'click', function (e) {
    console.log('parent');
  });

  addEvent(grandparent, 'click', function (e) {
    console.log('grandparent');
  });

  addEvent(document, 'click', function (e) {
    console.log('document');
  });

  addEvent('html', 'click', function (e) {
    console.log('html');
  })

  addEvent(window, 'click', function (e) {
    console.log('window');
  })

});
```

`addEventListener`方法具有第三个可选参数`useCapture`，其默认值为`false`，事件将在冒泡阶段中发生，如果为`true`，则事件将在捕获阶段中发生。如果单击`child`元素，它将分别在控制台上记录`child`，`parent`，`grandparent`，`html`，`document`和`window`，这就是事件冒泡。


### 9、什么是对象解构？

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


### 10、25.Jq如何判断元素显示隐藏？

```
//第一种：使用CSS属性 
var display =$('#id').css('display'); 
if(display == 'none'){    alert("我是隐藏的！"); }
//第二种：使用jquery内置选择器 
<div id="test"<p>仅仅是测试所用</p</div>
if($("#test").is(":hidden")){        $("#test").show();    //如果元素为隐藏,则将它显现 }else{       $("#test").hide();     //如果元素为显现,则将其隐藏 }
//第三种：jQuery判断元素是否显示 是否隐藏
var node=$('#id');
if(node.is(':hidden')){　　//如果node是隐藏的则显示node元素，否则隐藏
　　node.show();　
}else{
　　node.hide();
}
```


### 11、异步编程？
### 12、typeof？typeof [ ]返回数据类型是？
### 13、数据持久化技术(ajax)?简述ajax流程###
### 14、如何copy一个dom元素？
### 15、offsetWidth/offsetHeight,clientWidth/clientHeight与scrollWidth/scrollHeight的区别
### 16、promise###
### 17、判断数据类型
### 18、JSON 的了解？**
### 19、$(function(){})和window.onload 和 $(document).ready(function(){})
### 20、如何改变this指针的指向？
### 21、什么是AJAX？如何实现？
### 22、Function.prototype.apply 和 Function.prototype.call 之间有什么区别？
### 23、什么是模板字符串？
### 24、节点类型?判断当前节点类型?
### 25、什么是缓存及它有什么作用？
### 26、sessionStorage和localstroage与cookie之间有什么关联, cookie最大存放多少字节
### 27、渐进增强和优雅降级
### 28、如何检查对象中是否存在某个属性？
### 29、什么是执行上下文和执行栈？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
