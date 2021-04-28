# JavaScript最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、ES6或ECMAScript 2015有哪些新特性？

**1、** 箭头函数

2、类

**3、** 模板字符串

**4、** 加强的对象字面量

**5、** 对象解构

**6、** Promise

**7、** 生成器

8、模块

**9、** Symbol

**10、** 代理

**11、** Set

**12、** 函数默认参数

**13、** rest 和展开

**14、** 块作用域


### 2、什么是箭头函数？

箭头函数表达式的语法比函数表达式更简洁，并且没有自己的`this`，`arguments`，`super`或`new.target`。箭头函数表达式更适用于那些本来需要匿名函数的地方，并且它不能用作构造函数。

```
//ES5 Version
var getCurrentDate = function (){
  return new Date();
}

//ES6 Version
const getCurrentDate = () => new Date();
```

在本例中，ES5 版本中有`function(){}`声明和`return`关键字，这两个关键字分别是创建函数和返回值所需要的。在箭头函数版本中，我们只需要`()`括号，不需要 `return` 语句，因为如果我们只有一个表达式或值需要返回，箭头函数就会有一个隐式的返回。

```
//ES5 Version
function greet(name) {
  return 'Hello ' + name + '!';
}

//ES6 Version
const greet = (name) => `Hello ${name}`;
const greet2 = name => `Hello ${name}`;
```

我们还可以在箭头函数中使用与函数表达式和函数声明相同的参数。如果我们在一个箭头函数中有一个参数，则可以省略括号。

`const getArgs = () => arguments const getArgs2 = (...rest) => rest`

箭头函数不能访问`arguments`对象。所以调用第一个`getArgs`函数会抛出一个错误。相反，我们可以使用**rest**参数来获得在箭头函数中传递的所有参数。

```
const data = {
  result: 0,
  nums: [1, 2, 3, 4, 5],
  computeResult() {
    // 这里的“this”指的是“data”对象
    const addAll = () => {
      return this.nums.reduce((total, cur) => total + cur, 0)
    };
    this.result = addAll();
  }
};
```

箭头函数没有自己的`this`值。它捕获词法作用域函数的`this`值，在此示例中，`addAll`函数将复制`computeResult` 方法中的`this`值，如果我们在全局作用域声明箭头函数，则`this`值为 `window` 对象。


### 3、有哪些方法可以处理 JS 中的异步代码？

1、回调

**2、** Promise

**3、** async/await

**4、** 还有一些库：async.js, bluebird, q, co


### 4、什么是 event.currentTarget？？

`event.currentTarget`是我们在其上显式附加事件处理程序的元素。

假设有如下的 HTML 结构：

```
<div onclick="clickFunc(event)" style="text-align: center;margin:15px;
border:1px solid red;border-radius:3px;">
  <div style="margin: 25px; border:1px solid royalblue;border-radius:3px;">
      <div style="margin:25px;border:1px solid skyblue;border-radius:3px;">
        <button style="margin:10px">
           Button
        </button>
      </div>
  </div>
</div>
```

JS 代码如下：

```
function clickFunc(event) {
  console.log(event.currentTarget);
}
```

如果单击 `button`，即使我们单击该 `button`，它也会打印最外面的`div`标签。在此示例中，我们可以得出结论，`event.currentTarget`是附加事件处理程序的元素。


### 5、怎么理解Promise对象？

**`Promise`对象有如下两个特点：**

**1、** 对象的状态不受外界影响。`Promise`对象共有三种状态`pending`、`fulfilled`、`rejected`。状态值只会被异步结果决定，其他任何操作无法改变。

**2、** 状态一旦成型，就不会再变，且任何时候都可得到这个结果。状态值会由`pending`变为`fulfilled`或`rejected`，这时即为`resolved`。

**Promise的缺点有如下三个缺点：**

**1、** `Promise`一旦执行便无法被取消；

**2、** 不可设置回调函数，其内部发生的错误无法捕获；

**3、** 当处于`pending`状态时，无法得知其具体发展到了哪个阶段。

**`Pomise`中常用的方法有：**

**1、** `Promise.prototype.then()`：`Promise`实例的状态发生改变时，会调用`then`内部的回调函数。`then`方法接受两个参数（第一个为`resolved`状态时时执行的回调，第一个为`rejected`状态时时执行的回调）

**2、** `Promise.prototype.catch()`：`.then(null, rejection)`或`.then(undefined, rejection)`的别名，用于指定发生错误时的回调函数。


### 6、谈谈This对象的理解

**1、** `this`总是指向函数的直接调用者（而非间接调用者）

**2、** 如果有`new`关键字，`this`指向`new`出来的那个对象

**3、** 在事件中，`this`指向触发这个事件的对象，特殊的是，`IE`中的`attachEvent`中的`this`总是指向全局对象`Window`


### 7、如何理解同步和异步？

同步：按照代码书写顺序一一执行处理指令的一种模式，上一段代码执行完才能执行下一段代码。

异步：可以理解为一种并行处理的方式，不必等待一个程序执行完，可以执行其它的任务。

JS之所以需要异步的原因在于JS是单线程运行的。常用的异步场景有：定时器、ajax请求、事件绑定。


### 8、html和xhtml有什么区别?

HTML是一种基本的WEB网页设计语言，XHTML是一个基于XML的标记语言。

**1、** XHTML 元素必须被正确地嵌套。

**2、** XHTML 元素必须被关闭。

**3、** 标签名必须用小写字母。

**4、** 空标签也必须被关闭。

**5、** XHTML 文档必须拥有根元素。


### 9、["1", "2", "3"].map(parseInt) 答案是多少？

`[1, NaN, NaN]`因为 `parseInt` 需要两个参数 `(val, radix)`，其中`radix` 表示解析时用的基数。

`map`传了 `3`个`(element, index, array)`，对应的 `radix` 不合法导致解析失败。


### 10、开发时如何对项目进行管理?gulp?

本人开发时，利用gulp等前端工作流管理工具管理项目。 gulp是新一代的前端项目构建工具，你可以使用gulp及其插件对你的项目代码（less,sass）进行编译，还可以压缩你的js和css代码，甚至压缩你的图片，能够合并文件，压缩文件，语法检查，监听文件变化，测试，转换二进制，转换图片等一系列功能。gulp仅有少量的API，所以非常容易学习。实现良好的项目管理。


### 11、git 和 svn的区别?
### 12、'use strict' 是干嘛用的？
### 13、平时工作中怎么样进行数据交互?如果后台没有提供数据怎么样进行开发?
### 14、sass和less有什么区别?
### 15、ajax请求方式有几种（8种）？
### 16、call & apply 两者之间的区别###
### 17、说说严格模式的限制
### 18、什么是`Set`对象，它是如何工作的？
### 19、一般使用什么版本控制工具?svn如何对文件加锁###
### 20、event.preventDefault() 和 event.stopPropagation()方法之间有什么区别？
### 21、jquery和zepto有什么区别?
### 22、异步加载的方式有哪些？
### 23、ECMAScript 是什么？
### 24、如何检查值是否虚值？
### 25、谈谈你对ES6的理解
### 26、web开发中会话跟踪的方法有哪些
### 27、this指向的各种情况都有什么？
### 28、何为防抖和节流？如何实现？
### 29、|| 运算符能做什么




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
