# JavaScript最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、说出几个http协议状态码?

200, 201, 302, 304, 400, 404, 500

**1、** 200：请求成功

**2、** 201：请求成功并且服务器创建了新的资源

**3、** 302：服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来响应以后的请求。

**4、** 304：自从上次请求后，请求的网页未修改过。服务器返回此响应时，不会返回网页内容。

**5、** 400：服务器不理解请求的语法。

**6、** 404：请求的资源（网页等）不存在

**7、** 500： 内部服务器错误


### 2、event.preventDefault() 和 event.stopPropagation()方法之间有什么区别？

`event.preventDefault()` 方法可防止元素的默认行为。如果在表单元素中使用，它将阻止其提交。如果在锚元素中使用，它将阻止其导航。如果在上下文菜单中使用，它将阻止其显示或显示。`event.stopPropagation()`方法用于阻止捕获和冒泡阶段中当前事件的进一步传播。


### 3、什么是AJAX？如何实现？

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


### 4、$(function(){})和window.onload 和 $(document).ready(function(){})

window.onload:用于当页面的所有元素，包括外部引用文件，图片等都加载完毕时运行函数内的函数。load方法只能执行一次，如果在js文件里写了多个，只能执行最后一个。

$$(document).ready(function()\{\})和$$(function(){})都是用于当页面的标准DOM元素被解析成DOM树后就执行内部函数。这个函数是可以在js文件里多次编写的，对于多人共同编写的js就有很大的优势，因为所有行为函数都会执行到。而且$(document).ready()函数在HMTL结构加载完后就可以执行，不需要等大型文件加载或者不存在的连接等耗时工作完成才执行，效率高。


### 5、ajax 是什么?

异步javascript和XML，是指一种创建交互式网页应用的网页开发技术。通过后台与服务器进行少量数据交换，AJAX可以使网页实现异步更新。这意味着可以在不重新加载整个网页的情况下，对网页的某部分进行更新。


### 6、什么是回调函数？

**回调函数**是一段可执行的代码段，它作为一个参数传递给其他的代码，其作用是在需要的时候方便调用这段（回调函数）代码。

在JavaScript中函数也是对象的一种，同样对象可以作为参数传递给函数，因此函数也可以作为参数传递给另外一个函数，这个作为参数的函数就是回调函数。

```
const btnAdd = document.getElementById('btnAdd');

btnAdd.addEventListener('click', function clickCallback(e) {
    // do something useless
});
```

在本例中，我们等待`id`为`btnAdd`的元素中的`click`事件，如果它被单击，则执行`clickCallback`函数。回调函数向某些数据或事件添加一些功能。

数组中的`reduce`、`filter`和`map`方法需要一个回调作为参数。回调的一个很好的类比是，当你打电话给某人，如果他们不接，你留下一条消息，你期待他们回调。调用某人或留下消息的行为是事件或数据，回调是你希望稍后发生的操作。


### 7、什么是原型、原型链？

原型：JS声明构造函数(用来实例化对象的函数)时，会在内存中创建一个对应的对象，这个对象就是原函数的原型。构造函数默认有一个prototype属性，`prototype`的值指向函数的原型。同时原型中也有一个`constructor`属性，`constructor`的值指向原函数。

通过构造函数实例化出来的对象，并不具有`prototype`属性，其默认有一个`__proto__`属性，`__proto__`的值指向构造函数的原型对象。在原型对象上添加或修改的属性，在所有实例化出的对象上都可共享。

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/49bad3cc378b4232a4b768bfe0ea67d7~tplv-k3u1fbpfcp-zoom-1.image#alt=%E5%9C%A8%E8%BF%99%E9%87%8C%E6%8F%92%E5%85%A5%E5%9B%BE%E7%89%87%E6%8F%8F%E8%BF%B0)

当在实例化的对象中访问一个属性时，首先会在该对象内部寻找，如找不到，则会向其`__proto__`指向的原型中寻找，如仍找不到，则继续向原型中`__proto__`指向的上级原型中寻找，直至找到或`Object.prototype`为止，这种链状过程即为原型链。


### 8、如何解决跨域问题?

`jsonp`、 `iframe`、`window.name`、`window.postMessage`、服务器上设置代理页面


### 9、arguments 的对象是什么？

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


### 10、几种基本数据类型?复杂数据类型?值类型和引用数据类型?堆栈数据结构

**1、** 基本数据类型：Undefined、Null、Boolean、Number、String

**2、** 值类型：数值、布尔值、null、undefined。

**3、** 引用类型：对象、数组、函数。

**4、** 堆栈数据结构：是一种支持后进先出(LIFO)的集合,即后被插入的数据,先被取出!

**5、** js数组中提供了以下几个方法可以让我们很方便实现堆栈：

**6、** shift:从数组中把第一个元素删除，并返回这个元素的值。

**7、** unshift: 在数组的开头添加一个或更多元素，并返回新的长度

**8、** push:在数组的中末尾添加元素，并返回新的长度

**9、** pop:从数组中把最后一个元素删除，并返回这个元素的值。


### 11、为什么typeof null 返回 object？如何检查一个值是否为 null？
### 12、如何在不使用`%`模运算符的情况下检查一个数字是否是偶数？
### 13、JavaScript原型，原型链 ? 有什么特点？
### 14、disabled readyonly?
### 15、web开发中会话跟踪的方法有哪些
### 16、什么是包装对象（wrapper object）？
### 17、异步加载JS的方式有哪些？
### 18、什么是提升？
### 19、事件流?事件捕获？事件冒泡？
### 20、Jq中get和eq有什么区别？
### 21、null，undefined 的区别？
### 22、隐式和显式转换有什么区别）？
### 23、什么是闭包？
### 24、this指向的各种情况都有什么？
### 25、DOM事件模型和事件流？
### 26、如何检查值是否虚值？
### 27、展开(spread )运算符和 剩余(Rest) 运算符有什么区别？
### 28、typeof？typeof [ ]返回数据类型是？
### 29、什么是事件传播?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
