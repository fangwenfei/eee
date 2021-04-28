# JavaScript最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、|| 运算符能做什么

`||`也叫或`逻辑或`，在其操作数中找到第一个真值表达式并返回它。这也使用了短路来防止不必要的工作。在支持 ES6 默认函数参数之前，它用于初始化函数中的默认参数值。

```
console.log(null || 1 || undefined); // 1

function logName(name) {
  var n = name || "Mark";
  console.log(n);
}

logName(); // "Mark"
```


### 2、如何解决跨域问题?

`jsonp`、 `iframe`、`window.name`、`window.postMessage`、服务器上设置代理页面


### 3、简述ajax执行流程

```
基本步骤：
var xhr =null;//创建对象 
if(window.XMLHttpRequest){
       xhr = new XMLHttpRequest();
}else{
       xhr = new ActiveXObject("Microsoft.XMLHTTP");
}
xhr.open(“方式”,”地址”,”标志位”);//初始化请求 
   xhr.setRequestHeader(“”,””);//设置http头信息 
xhr.onreadystatechange =function(){}//指定回调函数 
xhr.send();//发送请求
```


### 4、介绍js的基本数据类型

`Undefined`、`Null`、`Boolean`、`Number`、`String`


### 5、闭包

闭包是指有权访问另一个函数作用域中变量的函数，创建闭包的最常见的方式就是在一个函数内创建另一个函数，通过另一个函数访问这个函数的局部变量,利用闭包可以突破作用链域

**闭包的特性：**

**1、** 函数内再嵌套函数

**2、** 内部函数可以引用外层的参数和变量

**3、** 参数和变量不会被垃圾回收机制回收

**说说你对闭包的理解**

使用闭包主要是为了设计私有的方法和变量。闭包的优点是可以避免全局变量的污染，缺点是闭包会常驻内存，会增大内存使用量，使用不当很容易造成内存泄露。在js中，函数即闭包，只有函数才会产生作用域的概念


### 6、强制转换 显式转换 隐式转换?

```
//强制类型转换：
Boolean(0)   // =false - 零
Boolean(new object())   // =true - 对象
Number(undefined)       // =  NaN
Number(null)              // =0
String(null)              // ="null"
parseInt( )
parseFloat( )
JSON.parse( )
JSON.stringify ( )
```

隐式类型转换：

在使用算术运算符时，运算符两边的数据类型可以是任意的，比如，一个字符串可以和数字相加。之所以不同的数据类型之间可以做运算，是因为JavaScript引擎在运算之前会悄悄的把他们进行了隐式类型转换的

```
（例如：x+"" //等价于String(x)  
\+x //等价于Number(x)  
x-0 //同上  
!!x //等价于Boolean(x),是双叹号）
```

**显式转换：**

如果程序要求一定要将某一类型的数据转换为另一种类型，则可以利用强制类型转换运算符进行转换，这种强制转换过程称为显示转换。

显示转换是你定义让这个值类型转换成你要用的值类型，是底到高的转换。例 int 到float就可以直接转，int i=5,想把他转换成char类型，就用显式转换（char）i


### 7、那些操作会造成内存泄漏？

**1、** 内存泄漏指任何对象在您不再拥有或需要它之后仍然存在

**2、** `setTimeout` 的第一个参数使用字符串而非函数的话，会引发内存泄漏

**3、** 闭包、控制台日志、循环（在两个对象彼此引用且彼此保留时，就会产生一个循环）


### 8、readystate 0~4

0：未初始化状态：此时，已经创建了一个XMLHttpRequest对象

1： 准备发送状态：此时，已经调用了XMLHttpRequest对象的open方法，并且XMLHttpRequest对象已经准备好将一个请求发送到服务器端

2：已经发送状态：此时，已经通过send方法把一个请求发送到服务器端，但是还没有收到一个响应

3：正在接收状态：此时，已经接收到HTTP响应头部信息，但是消息体部分还没有完全接收到

4：完成响应状态：此时，已经完成了HTTP响应的接收


### 9、什么是 IIFE，它的用途是什么？

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


### 10、一个页面从输入 URL 到页面加载显示完成，这个过程中都发生了什么？（流程说的越详细越好）

**1、** 查找浏览器缓存

**2、** DNS解析、查找该域名对应的IP地址、重定向（301）、发出第二个GET请求

**3、** 进行HTTP协议会话

**4、** 客户端发送报头(请求报头)

**5、** 服务器回馈报头(响应报头)

**6、** html文档开始下载

**7、** 文档树建立，根据标记请求所需指定MIME类型的文件

**8、** 文件显示

**浏览器这边做的工作大致分为以下几步：**

**1、** 加载：根据请求的URL进行域名解析，向服务器发起请求，接收文件（HTML、JS、CSS、图象等）。

**2、** 解析：对加载到的资源（HTML、JS、CSS等）进行语法解析，建议相应的内部数据结构（比如HTML的DOM树，JS的（对象）属性表，CSS的样式规则等等）


### 11、26.移动端上什么是点击穿透?
### 12、offsetWidth/offsetHeight,clientWidth/clientHeight与scrollWidth/scrollHeight的区别
### 13、JavaScript提供了哪几种“异步模式”？
### 14、event.preventDefault() 和 event.stopPropagation()方法之间有什么区别？
### 15、Jq中如何将一个jq对象转化为dom对象？
### 16、如何对登录的账号密码进行加密?
### 17、隐式和显式转换有什么区别）？
### 18、javascript创建对象的几种方式？
### 19、简述下 this 和定义属性和方法的时候有什么区别?Prototype？
### 20、函数表达式和函数声明之间有什么区别？
### 21、函数fn1 函数fn2 函数fn3，如果想在三个函数都执行完成后执行某一个事件应该如何实现?
### 22、js延迟加载的方式有哪些？
### 23、== 和 === 有什么区别？
### 24、调用函数，可以使用哪些方法？
### 25、几种基本数据类型?复杂数据类型?值类型和引用数据类型?堆栈数据结构
### 26、eval是做什么的？
### 27、&& 运算符能做什么
### 28、什么是 event.target ？
### 29、模块化开发怎么做？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
