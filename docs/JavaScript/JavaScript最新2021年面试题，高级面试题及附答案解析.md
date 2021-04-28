# JavaScript最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、变量作用域?

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


### 2、事件委托？有什么好处?

利用冒泡的原理，把事件加到父级上，触发执行效果

好处：新添加的元素还会有之前的事件；提高性能。


### 3、渐进增强和优雅降级

**1、** 渐进增强 ：针对低版本浏览器进行构建页面，保证最基本的功能，然后再针对高级浏览器进行效果、交互等改进和追加功能达到更好的用户体验。

**2、** 优雅降级 ：一开始就构建完整的功能，然后再针对低版本浏览器进行兼容


### 4、手动实现`Array.prototype.reduce`方法

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


### 5、为什么要有同源限制？

**1、** 同源策略指的是：协议，域名，端口相同，同源策略是一种安全协议

**2、** 举例说明：比如一个黑客程序，他利用`Iframe`把真正的银行登录页面嵌到他的页面上，当你使用真实的用户名，密码登录时，他的页面就可以通过`Javascript`读取到你的表单中`input`中的内容，这样用户名，密码就轻松到手了。


### 6、如何通过原生js 判断一个元素当前是显示还是隐藏状态?

```
if( document.getElementById("div").css("display")==='none')
if( document.getElementById("div").css("display")==='block')
$("#div").is(":hidden"); // 判断是否隐藏
$("#div").is(":visible")
```


### 7、什么是预编译语音|预编译处理器?

Sass是一种CSS预处理器语言，通过编程方式生成CSS代码。因为可编程，所以操控灵活性自由度高，方便实现一些直接编写CSS代码较困难的代码。

同时，因为Sass是生成CSS的语言，所以写出来的Sass文件是不能直接用的，必须经过编译器编译成CSS文件才能使用。

CSS 预处理器是一种语言用来为 CSS 增加一些编程的的特性，无需考虑浏览器的兼容性问题，例如你可以在 CSS 中使用变量、简单的程序逻辑、函数等等在编程语言中的一些基本技巧，可以让你的 CSS 更见简洁，适应性更强，代码更直观等诸多好处。最常用的css预处理器有sass、less css、stylus。


### 8、用过哪些设计模式？

**工厂模式：**

**1、** 工厂模式解决了重复实例化的问题，但还有一个问题,那就是识别问题，因为根本无法

**2、** 主要好处就是可以消除对象间的耦合，通过使用工程方法而不是`new`关键字

**构造函数模式**

**1、** 使用构造函数的方法，即解决了重复实例化的问题，又解决了对象识别的问题，该模式与工厂模式的不同之处在于

**2、** 直接将属性和方法赋值给 `this`对象;


### 9、谁是c的构造函数?

```
function ab() {
         this.say = ""; } 
ab.constructor = {} ab.name = ''; 
var c = new ab(); 
//构造函数默认指向函数本身,ab是一个类,它的构造函数是它本身，
//然后ab.constructor={};ab的构造函数就指向{}了，c是ab的实例化对象，c的构造函数就是{}
//通过使用new的时候,创建对象发生了那些改变? 当使用new操作时，会马上开辟一个块内存，
//创建一个空对象，并将this指向这个对象。接着，执行构造函数ab()，对这个空对象进行构造
//（构造函数里有什么属性和方法都一一给这个空白对象装配上去，这就是为何它叫构造函数了）。
```


### 10、何为防抖和节流？如何实现？

**1、** 防抖和节流都是防止短时间内高频触发事件的方案。

**2、** 防抖的原理是：如果一定时间内多次执行了某事件，则只执行其中的最后一次。

**3、** 节流的原理是：要执行的事件每隔一段时间会被冷却，无法执行。

**4、** 应用场景有：搜索框实时搜索，滚动改变相关的事件。

```
//@fn: 要执行的函数
//@delay: 设定的时限
//防抖函数
function debunce(fn, delay) {
    let flag = null;
    return function() {
        if (flag) clearTimeout(flag)
        //利用apply改变函数指向，使得封装后的函数可以接收event本身
        flag = setTimeout(() = > fn.apply(this, arguments), delay)
    }
}
//节流函数
function throttle(fn, delay) {
    let flag = true;
    return function() {
        if (!flag) return false;
        flag = false;
        setTimeout(() = > {
            fn.apply(this, arguments)
            flag = true
        }, delay)
    }
}
```


### 11、事件模型
### 12、如何使用storage 对js文件进行缓存
### 13、DOM 是什么？
### 14、与深拷贝有何区别？如何实现？
### 15、new 关键字有什么作用？
### 16、什么是作用域和作用域链？
### 17、基本数据类型和引用数据类型有什么区别？
### 18、javascript 代码中的"use strict";是什么意思 ? 使用它区别是什么？
### 19、eval是做什么的？
### 20、什么是闭包？
### 21、编写一个 getElementsByClassName 封装函数?
### 22、promise###
### 23、JavaScript 中的虚值是什么？
### 24、$$.map和$$.each有什么区别###
### 25、如何创建一个对象？
### 26、谈谈你对AMD、CMD的理解
### 27、Jq中get和eq有什么区别？
### 28、js的几种继承方式？
### 29、Javascript如何实现继承？
### 30、为什么此代码 `obj.someprop.x` 会引发错误?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
