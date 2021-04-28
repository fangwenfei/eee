# JavaScript最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、ajax的缺点

**1、** ajax不支持浏览器back按钮。

**2、** 安全问题 AJAX暴露了与服务器交互的细节。

**3、** 对搜索引擎的支持比较弱。

**4、** 破坏了程序的异常机制。

**5、** 不容易调试



### 2、== 和 === 有什么区别？

`==`用于一般比较，`===`用于严格比较，`==`在比较的时候可以转换数据类型`，===`严格比较，只要类型不匹配就返回`flase`。

先来看看 `==` 这兄弟：

强制是将值转换为另一种类型的过程。在这种情况下，`==`会执行隐式强制。在比较两个值之前，`==`需要执行一些规则。

假设我们要比较`x == y`的值。

**1、** 如果`x`和`y`的类型相同，则 JS 会换成`===`操作符进行比较。

**2、** 如果`x`为`null`, `y`为`undefined`，则返回`true`。

**3、** 如果`x`为`undefined`且`y`为`null`，则返回`true`。

**4、** 如果`x`的类型是`number`, `y`的类型是`string`，那么返回`x == toNumber(y)`。

**5、** 如果`x`的类型是`string`, `y`的类型是`number`，那么返回`toNumber(x) == y`。

**6、** 如果`x`为类型是`boolean`，则返回`toNumber(x)== y`。

**7、** 如果`y`为类型是`boolean`，则返回`x == toNumber(y)`。

**8、** 如果`x`是`string`、`symbol`或`number`，而`y`是`object`类型，则返回`x == toPrimitive(y)`。

**9、** 如果`x`是`object`，`y`是`string`，`symbol`则返回`toPrimitive(x) == y`。

**10、** 剩下的 返回 `false`


### 3、26.移动端上什么是点击穿透?

**点击穿透现象有3种：**

**点击穿透问题：**

点击蒙层（mask）上的关闭按钮，蒙层消失后发现触发了按钮下面元素的click事件跨页面点击穿透问题：如果按钮下面恰好是一个有href属性的a标签，那么页面就会发生跳转另一种跨页面点击穿透问题：这次没有mask了，直接点击页内按钮跳转至新页，然后发现新页面中对应位置元素的click事件被触发了

**解决方案：**

**1、** 只用touch

最简单的解决方案，完美解决点击穿透问题

把页面内所有click全部换成touch事件（ touchstart 、’touchend’、’tap’）

**2、** 只用click

下下策，因为会带来300ms延迟，页面内任何一个自定义交互都将增加300毫秒延迟

**3、** tap后延迟350ms再隐藏mask

改动最小，缺点是隐藏mask变慢了，350ms还是能感觉到慢的

**4、** pointer-events

比较麻烦且有缺陷， 不建议使用mask隐藏后，给按钮下面元素添上 pointer-events: none; 样式，让click穿过去，350ms后去掉这个样式，恢复响应缺陷是mask消失后的的350ms内，用户可以看到按钮下面的元素点着没反应，如果用户手速很快的话一定会发现


### 4、XML和JSON的区别？

**数据体积方面**

`JSON`相对`于XML`来讲，数据的体积小，传递的速度更快些。

**数据交互方面**

`JSON`与`JavaScript`的交互更加方便，更容易解析处理，更好的数据交互

**数据描述方面**

`JSON`对数据的描述性比`XML`较差

**传输速度方面**

`JSON`的速度要远远快于`XML`


### 5、如何通过原生js 判断一个元素当前是显示还是隐藏状态?

```
if( document.getElementById("div").css("display")==='none')
if( document.getElementById("div").css("display")==='block')
$("#div").is(":hidden"); // 判断是否隐藏
$("#div").is(":visible")
```


### 6、sessionStorage和localstroage与cookie之间有什么关联, cookie最大存放多少字节

**三者共同点：**

都是保存在浏览器端，且同源的。

区别:

**1、** cookie在浏览器和服务器间来回传递。而sessionStorage和localStorage不会自动把数据发给服务器，仅在本地保存

**2、** 存储大小限制也不同，cookie数据不能超过4k，sessionStorage和localStorage 但比cookie大得多，可以达到5M

**3、** 数据有效期不同，sessionStorage：仅在当前浏览器窗口关闭前有效，自然也就不可能持久保持；localStorage：始终有效，窗口或浏览器关闭也一直保存，因此用作持久数据；cookie只在设置的cookie过期时间之前一直有效，即使窗口或浏览器关闭

**4、** 作用域不同，sessionStorage不在不同的浏览器窗口中共享，即使是同一个页面(即数据不共享)；localStorage 在所有同源窗口中都是共享的；cookie也是在所有同源窗口中都是共享的( 即数据共享 )。


### 7、简述下你理解的面向对象？

万物皆对象，把一个对象抽象成类,具体上就是把一个对象的静态特征和动态特征抽象成属性和方法,也就是把一类事物的算法和数据结构封装在一个类之中,程序就是多个对象和互相之间的通信组成的、

面向对象具有封装性,继承性,多态性。

封装:隐蔽了对象内部不需要暴露的细节,使得内部细节的变动跟外界脱离,只依靠接口进行通信.封装性降低了编程的复杂性、通过继承,使得新建一个类变得容易,一个类从派生类那里获得其非私有的方法和公用属性的繁琐工作交给了编译器、而继承和实现接口和运行时的类型绑定机制 所产生的多态,使得不同的类所产生的对象能够对相同的消息作出不同的反应,极大地提高了代码的通用性、

总之,面向对象的特性提高了大型程序的重用性和可维护性.


### 8、开发时如何对项目进行管理?gulp?

本人开发时，利用gulp等前端工作流管理工具管理项目。 gulp是新一代的前端项目构建工具，你可以使用gulp及其插件对你的项目代码（less,sass）进行编译，还可以压缩你的js和css代码，甚至压缩你的图片，能够合并文件，压缩文件，语法检查，监听文件变化，测试，转换二进制，转换图片等一系列功能。gulp仅有少量的API，所以非常容易学习。实现良好的项目管理。


### 9、JSON 的了解？**

`JSON(JavaScript Object Notation)` 是一种轻量级的数据交换格式

它是基于`JavaScript`的一个子集。数据格式简单, 易于读写, 占用带宽小

`JSON`字符串转换为JSON对象:

```
var obj =eval('('+ str +')');
var obj = str.parseJSON();
var obj = JSON.parse(str);
```

`JSON`对象转换为JSON字符串：

```
var last=obj.toJSONString();
var last=JSON.stringify(obj);
```


### 10、如何检查对象中是否存在某个属性？

检查对象中是否存在属性有三种方法。

第一种使用 `in` 操作符号：

```
const o = { 
  "prop" : "bwahahah",
  "prop2" : "hweasa"
};

console.log("prop" in o); // true
console.log("prop1" in o); // false
```

第二种使用 `hasOwnProperty` 方法，`hasOwnProperty()` 方法会返回一个布尔值，指示对象自身属性中是否具有指定的属性（也就是，是否有指定的键）。

```
console.log(o.hasOwnProperty("prop2")); // true
console.log(o.hasOwnProperty("prop1")); // false
```

第三种使用括号符号`obj["prop"]`。如果属性存在，它将返回该属性的值，否则将返回`undefined`。

`console.log(o["prop"]); // "bwahahah" console.log(o["prop1"]); // undefined`


### 11、如何创建一个对象？
### 12、如何创建一个没有 prototype(原型)的对象？
### 13、变量作用域?
### 14、为什么要有同源限制？
### 15、如何在一行中计算多个表达式的值？
### 16、对象的 prototype(原型) 是什么？
### 17、Jq中有几种选择器?分别是什么?
### 18、什么是事件捕获？
### 19、Promise 是什么？
### 20、介绍js的基本数据类型
### 21、你觉得jQuery源码有哪些写的好的地方
### 22、什么是 ES6 模块？
### 23、commonjs?requirejs?AMD|CMD|UMD?
### 24、什么是闭包？
### 25、为什么此代码 `obj.someprop.x` 会引发错误?
### 26、ajax中 get 和 post 有什么区别?
### 27、如何判断值是否为数组？
### 28、平时工作中怎么样进行数据交互?如果后台没有提供数据怎么样进行开发?
### 29、`in` 运算符和 `Object.hasOwnProperty` 方法有什么区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
