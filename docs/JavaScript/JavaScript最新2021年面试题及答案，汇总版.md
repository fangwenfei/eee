# JavaScript最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、$$.map和$$.each有什么区别###

map()方法主要用来遍历操作数组和对象，会返回一个新的数组。$.map()方法适用于将数组或对象每个项目新阵列映射到一个新数组的函数；

each()主要用于遍历jquery对象，返回的是原来的数组，并不会新创建一个数组。


### 2、Jq中get和eq有什么区别？

get() :取得其中一个匹配的元素。num表示取得第几个匹配的元素，get多针对集合元素，返回的是DOM对象组成的数组 eq():获取第N个元素，下标都是从0开始，返回的是一个JQuery对象


### 3、什么是 event.target ？

简单来说，`event.target`是发生事件的元素或触发事件的元素。

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
  console.log(event.target);
}
```

如果单击 `button`，即使我们将事件附加在最外面的`div`上，它也将打印 `button` 标签，因此我们可以得出结论`event.target`是触发事件的元素。


### 4、attribute和property的区别是什么？

**1、** `attribute`是`dom`元素在文档中作为`html`标签拥有的属性；

**2、** `property`就是`dom`元素在`js`中作为对象拥有的属性。

**3、** 对于`html`的标准属性来说，`attribute`和`property`是同步的，是会自动更新的

**4、** 但是对于自定义的属性来说，他们是不同步的


### 5、Jq中如何实现多库并存?

Noconfict 多库共存就是“$ ”符号的冲突。

**方法一**：

利用jQuery的实用函数$$.noConflict();这个函数归还$$的名称控制权给另一个库，因此可以在页面上使用其他库。这时，我们可以用"jQuery "这个名称调用jQuery的功能。 $.noConflict();

```
jQuery('\#id').hide();
.....
//或者给jQuery一个别名
var $j=jQuery
$j('\#id').hide();
```

**方法二**： `(function($)\{\})(jQuery)`

**方法三**： `jQuery(function($)\{\})`

通过传递一个函数作为jQuery的参数，因此把这个函数声明为就绪函数。 我们声明$为就绪函数的参数，因为jQuery总是吧jQuery对象的引用作为第一个参数传递，所以就保证了函数的执行。


### 6、slice() splice()?

slice() 方法可从已有的数组中返回选定的元素。

splice() 方法向/从数组中添加/删除项目，然后返回被删除的项目。


### 7、ajax中 get 和 post 有什么区别?

get和post都是数据提交的方式。

get的数据是通过网址问号后边拼接的字符串进行传递的。post是通过一个HTTP包体进行传递数据的。

get的传输量是有限制的，post是没有限制的。

get的安全性可能没有post高，所以我们一般用get来获取数据，post一般用来修改数据。


### 8、javascript 代码中的"use strict";是什么意思 ? 使用它区别是什么？

`use strict`是一种`ECMAscript 5` 添加的（严格）运行模式,这种模式使得 Javascript 在更严格的条件下运行,使`JS`编码更加规范化的模式,消除`Javascript`语法的一些不合理、不严谨之处，减少一些怪异行为


### 9、你对数据校验是怎么样处理的？jquery.validate？

通俗的说，就是为保证数据的完整性，用一种指定的算法对原始数据计算出的一个校验值。接收方用同样的算法计算一次校验值，如果和随数据提供的校验值一样，就说明数据是完整的。

用正则表达式来处理;

jquery.validate：为表单验证插件


### 10、JavaScript有几种类型的值？，你能画一下他们的内存图吗？

**1、** 栈：原始数据类型（`Undefined`，`Null`，`Boolean`，`Numbe`r、`String`）

**2、** 堆：引用数据类型（对象、数组和函数）

**3、** 两种类型的区别是：存储位置不同；

**4、** 原始数据类型直接存储在栈(`stack`)中的简单数据段，占据空间小、大小固定，属于被频繁使用数据，所以放入栈中存储；

**5、** 引用数据类型存储在堆(`heap`)中的对象,占据空间大、大小不固定,如果存储在栈中，将会影响程序运行的性能；引用数据类型在栈中存储了指针，该指针指向堆中该实体的起始地址。当解释器寻找引用值时，会首先检索其

**6、** 在栈中的地址，取得地址后从堆中获得实体

![33_1.png][33_1.png]


### 11、异步加载JS的方式有哪些？
### 12、如何在一行中计算多个表达式的值？
### 13、展开(spread )运算符和 剩余(Rest) 运算符有什么区别？
### 14、基本数据类型和引用数据类型有什么区别？
### 15、说说你对promise的了解
### 16、&& 运算符能做什么
### 17、什么是闭包? 堆栈溢出有什么区别？ 内存泄漏? 那些操作会造成内存泄漏？怎么样防止内存泄漏？
### 18、常见兼容性问题？
### 19、jsonp原理？ 缺点?
### 20、什么是默认参数？
### 21、函数fn1 函数fn2 函数fn3，如果想在三个函数都执行完成后执行某一个事件应该如何实现?
### 22、Javascript如何实现继承？
### 23、手动实现 `Array.prototype.map 方法`
### 24、null，undefined 的区别？
### 25、简述下 this 和定义属性和方法的时候有什么区别?Prototype？
### 26、Promise 是什么？
### 27、ajax的缺点
### 28、commonjs?requirejs?AMD|CMD|UMD?
### 29、30.Jq中怎么样编写插件?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
