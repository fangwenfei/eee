# JavaScript最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、为什么函数被称为一等公民？

在JavaScript中，函数不仅拥有一切传统函数的使用方式（声明和调用），而且可以做到像简单值一样赋值`（var func = function(){}）`、传参`(function func(x,callback){callback();})`、返回`(function(){return function(){}})`，这样的函数也称之为**第一级函数（First-class Function）**。不仅如此，JavaScript中的函数还充当了类的构造函数的作用，同时又是一个`Function`类的实例(instance)。这样的多重身份让JavaScript的函数变得非常重要。


### 2、什么是 `async/await` 及其如何工作？

`async/await`是 JS 中编写异步或非阻塞代码的新方法。它建立在**Promises**之上，让异步代码的可读性和简洁度都更高。

`async/await`是 JS 中编写异步或非阻塞代码的新方法。它建立在`Promises`之上，相对于 Promise 和回调，它的可读性和简洁度都更高。但是，在使用此功能之前，我们必须先学习`Promises`的基础知识，因为正如我之前所说，它是基于`Promise`构建的，这意味着幕后使用仍然是**Promise**。

**使用 Promise**

```
function callApi() {
  return fetch("url/to/api/endpoint")
    .then(resp => resp.json())
    .then(data => {
      //do something with "data"
    }).catch(err => {
      //do something with "err"
    });
}
```

**使用async/await**

在`async/await`，我们使用 tru/catch 语法来捕获异常。

```
async function callApi() {
 try {
   const resp = await fetch("url/to/api/endpoint");
   const data = await resp.json();
   //do something with "data"
 } catch (e) {
   //do something with "err"
 }
}
```

**注意**:使用 `async`关键声明函数会隐式返回一个**Promise**。

```
const giveMeOne = async () => 1;
giveMeOne()
  .then((num) => {
    console.log(num); // logs 1
  });
```

**注意:**`await`关键字只能在`async function`中使用。在任何非**async function**的函数中使用`await`关键字都会抛出错误。`await`关键字在执行下一行代码之前等待右侧表达式(可能是一个**Promise**)返回。

```
const giveMeOne = async () => 1;

function getOne() {
  try {
    const num = await giveMeOne();
    console.log(num);
  } catch (e) {
    console.log(e);
  }
}

// Uncaught SyntaxError: await is only valid in async function

async function getTwo() {
  try {
    const num1 = await giveMeOne(); // 这行会等待右侧表达式执行完成
    const num2 = await giveMeOne(); 
    return num1 + num2;
  } catch (e) {
    console.log(e);
  }
}

await getTwo(); // 2
```


### 3、什么是构造函数？与普通函数有什么区别?

构造函数：是一种特殊的方法、主要用来创建对象时初始化对象，总与new运算符一起使用，创建对象的语句中构造函数的函数名必须与类名完全相同。

与普通函数相比只能由new关键字调用，构造函数是类的标示


### 4、JSON 的了解？

JSON(JavaScript Object Notation) 是一种轻量级的数据交换格式。 它是基于JavaScript的一个子集。数据格式简单, 易于读写, 占用带宽小。


### 5、**

**1、** 执行代码之前会先读取函数声明，意味着可以把函数申明放在调用它的语句后面。

**2、** 只要函数在代码中进行了声明，无论它在哪个位置上进行声明， js引擎都会将它的声明放在范围作用域的顶部；

**变量or函数声明：**

**1、** 函数声明会覆盖变量声明，但不会覆盖变量赋值。

**2、** 同一个名称标识a，即有变量声明var a，又有函数声明function a() {}，不管二者声明的顺序，函数声明会覆盖变量声明，也就是说，此时a的值是声明的函数function a() {}。注意：如果在变量声明的同时初始化a，或是之后对a进行赋值，此时a的值变量的值。eg: var a; var c = 1; a = 1; function a() { return true; } console.log(a);


### 6、谈谈你对AMD、CMD的理解

**1、** `CommonJS`是服务器端模块的规范，`Node.js`采用了这个规范。`CommonJS`规范加载模块是同步的，也就是说，只有加载完成，才能执行后面的操作。`AMD`规范则是非同步加载模块，允许指定回调函数

**2、** `AMD`推荐的风格通过返回一个对象做为模块对象，`CommonJS`的风格通过对`module.exports`或`exports`的属性赋值来达到暴露模块对象的目的


### 7、请解释什么是事件代理

**1、** 事件代理（`Event Delegation`），又称之为事件委托。是 `JavaScript` 中常用绑定事件的常用技巧。顾名思义，“事件代理”即是把原本需要绑定的事件委托给父元素，让父元素担当事件监听的职务。事件代理的原理是DOM元素的事件冒泡。使用事件代理的好处是可以提高性能

**2、** 可以大量节省内存占用，减少事件注册，比如在`table`上代理所有`td`的`click`事件就非常棒

**3、** 可以实现当新增子对象时无需再次对其绑定


### 8、Ajax原理

**1、** `Ajax`的原理简单来说是在用户和服务器之间加了—个中间层(`AJAX`引擎)，通过`XmlHttpRequest`对象来向服务器发异步请求，从服务器获得数据，然后用`javascrip`t来操作`DOM`而更新页面。使用户操作与服务器响应异步化。这其中最关键的一步就是从服务器获得请求数据

**2、** `Ajax`的过程只涉及`JavaScript`、`XMLHttpRequest`和`DOM`。`XMLHttpRequest`是`aja`x的核心机制

```
 // 1、创建连接
    var xhr = null;
    xhr = new XMLHttpRequest()
    // 2、连接服务器
    xhr.open('get', url, true)
    // 3、发送请求
    xhr.send(null);
    // 4、接受请求
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                success(xhr.responseText);
            } else { // fail
                fail && fail(xhr.status);
            }
        }
    }
```


### 9、用过哪些设计模式？

**工厂模式：**

**1、** 工厂模式解决了重复实例化的问题，但还有一个问题,那就是识别问题，因为根本无法

**2、** 主要好处就是可以消除对象间的耦合，通过使用工程方法而不是`new`关键字

**构造函数模式**

**1、** 使用构造函数的方法，即解决了重复实例化的问题，又解决了对象识别的问题，该模式与工厂模式的不同之处在于

**2、** 直接将属性和方法赋值给 `this`对象;


### 10、Gc机制是什么？为什么闭包不会被回收变量和函数？

**1、** Gc垃圾回收机制;

**2、** 外部变量没释放，所以指向的大函数内的小函数也释放不了


### 11、说出几个http协议状态码?
### 12、!! 运算符能做什么？
### 13、为什么在调用这个函数时，代码中的`b`会变成一个全局变量?
### 14、什么是包装对象（wrapper object）？
### 15、`Function.prototype.call` 方法的用途是什么？
### 16、eval是做什么的？
### 17、XML和JSON的区别？
### 18、如何在 JS 中创建对象？
### 19、同步和异步的区别?
### 20、Object.seal 和 Object.freeze 方法之间有什么区别？
### 21、AJAX 是什么？
### 22、一个页面从输入 URL 到页面加载显示完成，这个过程中都发生了什么？（流程说的越详细越好）
### 23、DOM事件模型和事件流？
### 24、闭包
### 25、为什么在 JS 中比较两个相似的对象时返回 false？
### 26、`require`/`import`之间的区别？
### 27、什么是函数式编程? JavaScript 的哪些特性使其成为函数式语言的候选语言？
### 28、如何添加一个dom对象到body中?innerHTML和innerText区别?
### 29、JavaScript 中的虚值是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
