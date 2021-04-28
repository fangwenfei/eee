# JavaScript最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、判断数据类型的方法有哪些？

**1、** 利用`typeof`可以判断数据的类型；

**2、** `A instanceof` B可以用来判断A是否为B的实例，但它不能检测 null 和 undefined；

**3、** `B.constructor == A`可以判断A是否为B的原型，但constructor检测 Object与instanceof不一样，还可以处理基本数据类型的检测。

不过函数的 constructor 是不稳定的，这个主要体现在把类的原型进行重写，在重写的过程中很有可能出现把之前的constructor给覆盖了，这样检测出来的结果就是不准确的。

**4、** `Object.prototype.toString.call()`

`Object.prototype.toString.call()` 是最准确最常用的方式。


### 2、window.onload ==? DOMContentLoaded ?

一般情况下，DOMContentLoaded事件要在window.onload之前执行，当DOM树构建完成的时候就会执行DOMContentLoaded事件，而window.onload是在页面载入完成的时候，才执行，这其中包括图片等元素。大多数时候我们只是想在DOM树构建完成后，绑定事件到元素，我们并不需要图片元素，加上有时候加载外域图片的速度非常缓慢。


### 3、ajax 和 jsonp ？

**ajax和jsonp的区别：**

相同点：都是请求一个url

不同点：ajax的核心是通过xmlHttpRequest获取内容

jsonp的核心则是动态添加



### 4、什么是原型、原型链？

原型：JS声明构造函数(用来实例化对象的函数)时，会在内存中创建一个对应的对象，这个对象就是原函数的原型。构造函数默认有一个prototype属性，`prototype`的值指向函数的原型。同时原型中也有一个`constructor`属性，`constructor`的值指向原函数。

通过构造函数实例化出来的对象，并不具有`prototype`属性，其默认有一个`__proto__`属性，`__proto__`的值指向构造函数的原型对象。在原型对象上添加或修改的属性，在所有实例化出的对象上都可共享。

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/49bad3cc378b4232a4b768bfe0ea67d7~tplv-k3u1fbpfcp-zoom-1.image#alt=%E5%9C%A8%E8%BF%99%E9%87%8C%E6%8F%92%E5%85%A5%E5%9B%BE%E7%89%87%E6%8F%8F%E8%BF%B0)

当在实例化的对象中访问一个属性时，首先会在该对象内部寻找，如找不到，则会向其`__proto__`指向的原型中寻找，如仍找不到，则继续向原型中`__proto__`指向的上级原型中寻找，直至找到或`Object.prototype`为止，这种链状过程即为原型链。


### 5、谈谈你对AMD、CMD的理解

**1、** `CommonJS`是服务器端模块的规范，`Node.js`采用了这个规范。`CommonJS`规范加载模块是同步的，也就是说，只有加载完成，才能执行后面的操作。`AMD`规范则是非同步加载模块，允许指定回调函数

**2、** `AMD`推荐的风格通过返回一个对象做为模块对象，`CommonJS`的风格通过对`module.exports`或`exports`的属性赋值来达到暴露模块对象的目的


### 6、什么是默认参数？

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


### 7、web开发中会话跟踪的方法有哪些

**1、** `cookie`

**2、** `session`

**3、** `url`重写

**4、** 隐藏`input`

**5、** `ip`地址


### 8、谈谈你对ES6的理解

**1、** 新增模板字符串（为`JavaScript`提供了简单的字符串插值功能）

**2、** 箭头函数

**3、** `for-of`（用来遍历数据—例如数组中的值。）

**4、** `arguments`对象可被不定参数和默认参数完美代替。

**5、** `ES6`将p`romise`对象纳入规范，提供了原生的`Promise`对象。

**6、** 增加了`let`和`const`命令，用来声明变量。

**7、** 增加了块级作用域。

**8、** `let`命令实际上就增加了块级作用域。

**9、** 还有就是引入`module`模块的概念



### 9、ajax请求方式有几种（8种）？

1）$$.get(url,\[data\],\[callback\])  
2）$$.getJSON(url,[data],[callback])

3）$$.post(url,\[data\],\[callback\],\[type\])  
4）$$.ajax(opiton)

5）$.getScript( url, [callback] )

6）jquery对象.load( url, [data], [callback] )

7）serialize() 与 serializeArray()


### 10、eval是做什么的？

**1、** 它的功能是把对应的字符串解析成`JS`代码并运行

**2、** 应该避免使用`eval`，不安全，非常耗性能（`2`次，一次解析成`js`语句，一次执行）

**3、** 由`JSON`字符串转换为JSON对象的时候可以用`eval，var obj =eval('('+ str +')')`


### 11、什么是类？
### 12、jsonp原理？ 缺点?
### 13、`in` 运算符和 `Object.hasOwnProperty` 方法有什么区别？
### 14、为什么在调用这个函数时，代码中的`b`会变成一个全局变量?
### 15、**
### 16、如何判断值是否为数组？
### 17、EventLoop事件循环是什么？
### 18、&& 运算符能做什么
### 19、展开(spread )运算符和 剩余(Rest) 运算符有什么区别？
### 20、为什么函数被称为一等公民？
### 21、DOM 是什么？
### 22、arguments 的对象是什么？
### 23、说说你对promise的了解
### 24、如何合并两个数组？数组删除一个元素?
### 25、常见web安全及防护原理
### 26、Function.prototype.bind 的用途是什么？
### 27、如何在不使用`%`模运算符的情况下检查一个数字是否是偶数？
### 28、什么是事件冒泡？
### 29、$$('div+.ab')和$$('.ab+div') 哪个效率高？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
