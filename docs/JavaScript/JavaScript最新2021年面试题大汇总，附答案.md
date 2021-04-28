# JavaScript最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是事件传播?

当**事件**发生在**DOM**元素上时，该**事件**并不完全发生在那个元素上。在**“冒泡阶段”**中，事件冒泡或向上传播至父级，祖父母，祖父母或父级，直到到达`window`为止；而在**“捕获阶段”**中，事件从`window`开始向下触发元素 事件或`event.target`。

**事件传播有三个阶段：**

**1、** 捕获阶段 事件从 `window` 开始，然后向下到每个元素，直到到达目标元素。

**2、** 目标阶段 事件已达到目标元素。

**3、** 冒泡阶段 事件从目标元素冒泡，然后上升到每个元素，直到到达 `window`。


### 2、渐进增强和优雅降级

**1、** 渐进增强 ：针对低版本浏览器进行构建页面，保证最基本的功能，然后再针对高级浏览器进行效果、交互等改进和追加功能达到更好的用户体验。

**2、** 优雅降级 ：一开始就构建完整的功能，然后再针对低版本浏览器进行兼容


### 3、XML和JSON的区别？

**数据体积方面**

`JSON`相对`于XML`来讲，数据的体积小，传递的速度更快些。

**数据交互方面**

`JSON`与`JavaScript`的交互更加方便，更容易解析处理，更好的数据交互

**数据描述方面**

`JSON`对数据的描述性比`XML`较差

**传输速度方面**

`JSON`的速度要远远快于`XML`


### 4、|| 运算符能做什么

`||`也叫或`逻辑或`，在其操作数中找到第一个真值表达式并返回它。这也使用了短路来防止不必要的工作。在支持 ES6 默认函数参数之前，它用于初始化函数中的默认参数值。

```
console.log(null || 1 || undefined); // 1

function logName(name) {
  var n = name || "Mark";
  console.log(n);
}

logName(); // "Mark"
```


### 5、sessionStorage和localstroage与cookie之间有什么关联, cookie最大存放多少字节

**三者共同点：**

都是保存在浏览器端，且同源的。

区别:

**1、** cookie在浏览器和服务器间来回传递。而sessionStorage和localStorage不会自动把数据发给服务器，仅在本地保存

**2、** 存储大小限制也不同，cookie数据不能超过4k，sessionStorage和localStorage 但比cookie大得多，可以达到5M

**3、** 数据有效期不同，sessionStorage：仅在当前浏览器窗口关闭前有效，自然也就不可能持久保持；localStorage：始终有效，窗口或浏览器关闭也一直保存，因此用作持久数据；cookie只在设置的cookie过期时间之前一直有效，即使窗口或浏览器关闭

**4、** 作用域不同，sessionStorage不在不同的浏览器窗口中共享，即使是同一个页面(即数据不共享)；localStorage 在所有同源窗口中都是共享的；cookie也是在所有同源窗口中都是共享的( 即数据共享 )。


### 6、如何解决跨域问题?

`jsonp`、 `iframe`、`window.name`、`window.postMessage`、服务器上设置代理页面


### 7、Gc机制是什么？为什么闭包不会被回收变量和函数？

**1、** Gc垃圾回收机制;

**2、** 外部变量没释放，所以指向的大函数内的小函数也释放不了


### 8、ajax 是什么?

异步javascript和XML，是指一种创建交互式网页应用的网页开发技术。通过后台与服务器进行少量数据交换，AJAX可以使网页实现异步更新。这意味着可以在不重新加载整个网页的情况下，对网页的某部分进行更新。


### 9、如何通过原生js 判断一个元素当前是显示还是隐藏状态?

```
if( document.getElementById("div").css("display")==='none')
if( document.getElementById("div").css("display")==='block')
$("#div").is(":hidden"); // 判断是否隐藏
$("#div").is(":visible")
```


### 10、bootstrap好处？

自适应和响应式布局，12栅格系统，统一的界面风格和css样式有利于团队开发。编写灵活、稳定、高质量的 HTML 和 CSS 代码的规范。


### 11、判断数据类型
### 12、如何清除一个定时器?
### 13、说出几个http协议状态码?
### 14、实现异步的方式有哪些？
### 15、$(function(){})和window.onload 和 $(document).ready(function(){})
### 16、介绍js有哪些内置对象？
### 17、Object.seal 和 Object.freeze 方法之间有什么区别？
### 18、jQuery与jQuery UI 有啥区别？
### 19、开发时如何对项目进行管理?gulp?
### 20、说说你对AMD和Commonjs的理解
### 21、Function.prototype.apply 方法的用途是什么？
### 22、什么是高阶函数？
### 23、手动实现`Array.prototype.filter`方法
### 24、event.preventDefault() 和 event.stopPropagation()方法之间有什么区别？
### 25、如何创建一个没有 prototype(原型)的对象？
### 26、数组的排序方法（sort）？排序？汉字排序？
### 27、什么是闭包？
### 28、什么是作用域？
### 29、有哪些方法可以处理 JS 中的异步代码？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
