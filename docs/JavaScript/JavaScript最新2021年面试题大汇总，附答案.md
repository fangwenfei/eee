# JavaScript最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、事件模型

**1、** 冒泡型事件：当你使用事件冒泡时，子级元素先触发，父级元素后触发

**2、** 捕获型事件：当你使用事件捕获时，父级元素先触发，子级元素后触发

**3、** `DOM`事件流：同时支持两种事件模型：捕获型事件和冒泡型事件

**4、** 阻止冒泡：在`W3c`中，使用`stopPropagation（）`方法；在IE下设置`cancelBubble = true`

**5、** 阻止捕获：阻止事件的默认行为，例如`click - <a>`后的跳转。在`W3c`中，使用`preventDefault（）`方法，在`IE`下设置`window.event.returnValue = false`


### 2、typeof？typeof [ ]返回数据类型是？

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


### 3、Javascript如何实现继承？

**1、** 构造继承

**2、** 原型继承

**3、** 实例继承

**4、** 拷贝继承

原型`prototype`机制或`apply`和`call`方法去实现较简单，建议使用构造函数与原型混合方式

```
 function Parent(){
        this.name = 'wang';
    }

    function Child(){
        this.age = 28;
    }
    Child.prototype = new Parent();//继承了Parent，通过原型

    var demo = new Child();
    alert(demo.age);
    alert(demo.name);//得到被继承的属性
  }
```


### 4、AJAX 是什么？

即异步的 **JavaScript 和 XML**，是一种用于创建快速动态网页的技术，传统的网页（不使用 AJAX）如果需要更新内容，必需重载整个网页面。使用**AJAX**则不需要加载更新整个网页，实现部分内容更新

用到AJAX的技术：

**HTML** - 网页结构

**CSS** - 网页的样式

**JavaScript** - 操作网页的行为和更新DOM

**XMLHttpRequest API** - 用于从服务器发送和获取数据

**PHP，Python，Nodejs** - 某些服务器端语言


### 5、如何使用storage 对js文件进行缓存

由于sessionStorage - 针对一个 session 的数据存储，所以我们一般利用localStorage储存js文件，只有在第一次访问该页面的时候加载js文件，以后在访问的时候加载本地localStorage执行


### 6、你对数据校验是怎么样处理的？jquery.validate？

通俗的说，就是为保证数据的完整性，用一种指定的算法对原始数据计算出的一个校验值。接收方用同样的算法计算一次校验值，如果和随数据提供的校验值一样，就说明数据是完整的。

用正则表达式来处理;

jquery.validate：为表单验证插件


### 7、promise###

Promise的构造函数接收一个参数，是函数，并且传入两个参数：resolve，reject，分别表示异步操作执行成功后的回调函数和异步操作执行失败后的回调函数。


### 8、闭包

闭包是指有权访问另一个函数作用域中变量的函数，创建闭包的最常见的方式就是在一个函数内创建另一个函数，通过另一个函数访问这个函数的局部变量,利用闭包可以突破作用链域

**闭包的特性：**

**1、** 函数内再嵌套函数

**2、** 内部函数可以引用外层的参数和变量

**3、** 参数和变量不会被垃圾回收机制回收

**说说你对闭包的理解**

使用闭包主要是为了设计私有的方法和变量。闭包的优点是可以避免全局变量的污染，缺点是闭包会常驻内存，会增大内存使用量，使用不当很容易造成内存泄露。在js中，函数即闭包，只有函数才会产生作用域的概念


### 9、节点类型?判断当前节点类型?

**1、** 元素节点

**2、** 属性节点

**3、** 文本节点

**8、** 注释节点

**9、** 文档节点

通过nodeObject.nodeType判断节点类型：其中，nodeObject 为DOM节点（节点对象）。该属性返回以数字表示的节点类型，例如，元素节点返回 1，属性节点返回 2 。


### 10、什么是闭包? 堆栈溢出有什么区别？ 内存泄漏? 那些操作会造成内存泄漏？怎么样防止内存泄漏？

**闭包：**

**1、** 就是能够读取其他函数内部变量的函数。

**2、** 堆栈溢出：就是不顾堆栈中分配的局部数据块大小，向该数据块写入了过多的数据，导致数据越界，结果覆盖了别的数据。经常会在递归中发生。

**3、** 内存泄露是指：用动态存储分配函数内存空间，在使用完毕后未释放，导致一直占据该内存单元。直到程序结束。指任何对象在您不再拥有或需要它之后仍然存在。

**造成内存泄漏：**

setTimeout 的第一个参数使用字符串而非函数的话，会引发内存泄漏。

闭包、控制台日志、循环（在两个对象彼此引用且彼此保留时，就会产生一个循环）

防止内存泄露：

**1、** 不要动态绑定事件；

**2、** 不要在动态添加，或者会被动态移除的dom上绑事件，用事件冒泡在父容器监听事件；

**3、** 如果要违反上面的原则，必须提供destroy方法，保证移除dom后事件也被移除，这点可以参考Backbone的源代码，做的比较好；

**4、** 单例化，少创建dom，少绑事件。


### 11、什么是包装对象（wrapper object）？
### 12、说说你对作用域链的理解
### 13、有哪些方法可以处理 JS 中的异步代码？
### 14、作用域和执行上下文的区别是什么？
### 15、JavaScript有几种类型的值？，你能画一下他们的内存图吗？
### 16、JavaScript原型，原型链 ? 有什么特点？
### 17、展开(spread )运算符和 剩余(Rest) 运算符有什么区别？
### 18、Object.seal 和 Object.freeze 方法之间有什么区别？
### 19、说出几个http协议状态码?
### 20、disabled readyonly?
### 21、实现异步的方式有哪些？
### 22、事件流?事件捕获？事件冒泡？
### 23、this指向的各种情况都有什么？
### 24、'use strict' 是干嘛用的？
### 25、javascript创建对象的几种方式？
### 26、谈谈你对AMD、CMD的理解
### 27、如何对登录的账号密码进行加密?
### 28、如何解决跨域问题?
### 29、何为防抖和节流？如何实现？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
