# JavaScript最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是事件传播?

当**事件**发生在**DOM**元素上时，该**事件**并不完全发生在那个元素上。在**“冒泡阶段”**中，事件冒泡或向上传播至父级，祖父母，祖父母或父级，直到到达`window`为止；而在**“捕获阶段”**中，事件从`window`开始向下触发元素 事件或`event.target`。

**事件传播有三个阶段：**

**1、** 捕获阶段 事件从 `window` 开始，然后向下到每个元素，直到到达目标元素。

**2、** 目标阶段 事件已达到目标元素。

**3、** 冒泡阶段 事件从目标元素冒泡，然后上升到每个元素，直到到达 `window`。


### 2、简述下你理解的面向对象？

万物皆对象，把一个对象抽象成类,具体上就是把一个对象的静态特征和动态特征抽象成属性和方法,也就是把一类事物的算法和数据结构封装在一个类之中,程序就是多个对象和互相之间的通信组成的、

面向对象具有封装性,继承性,多态性。

封装:隐蔽了对象内部不需要暴露的细节,使得内部细节的变动跟外界脱离,只依靠接口进行通信.封装性降低了编程的复杂性、通过继承,使得新建一个类变得容易,一个类从派生类那里获得其非私有的方法和公用属性的繁琐工作交给了编译器、而继承和实现接口和运行时的类型绑定机制 所产生的多态,使得不同的类所产生的对象能够对相同的消息作出不同的反应,极大地提高了代码的通用性、

总之,面向对象的特性提高了大型程序的重用性和可维护性.


### 3、什么是作用域和作用域链？

作用域可以理解为一个独立的地盘，可以理解为标识符所能生效的范围。作用域最大的用处就是隔离变量，不同作用域下同名变量不会有冲突。ES6中有全局作用域、函数作用域和块级作用域三层概念。

当一个变量在当前块级作用域中未被定义时，会向父级作用域(创建该函数的那个父级作用域)寻找。如果父级仍未找到，就会再一层一层向上寻找，直到找到全局作用域为止。这种一层一层的关系，就是作用域链 。


### 4、如何知道是否在元素中使用了`event.preventDefault()`方法？

我们可以在事件对象中使用`event.defaultPrevented`属性。它返回一个布尔值用来表明是否在特定元素中调用了`event.preventDefault()`。


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


### 6、异步加载JS的方式有哪些？

defer，只支持`IE`

`async`：

创建`script`，插入到`DOM`中，加载完毕后`callBack`


### 7、eval是做什么的？

它的功能是把对应的字符串解析成JS代码并运行； 应该避免使用eval，不安全，非常耗性能（2次，一次解析成js语句，一次执行）。


### 8、sass和less有什么区别?

**1、** 编译环境不一样 Sass的安装需要Ruby环境，是在服务端处理的，而Less是需要引入less.js来处理Less代码输出css到浏览器，也可以在开发环节使用Less，然后编译成css文件，直接放到项目中。

**2、** 变量符不一相，less是@，而scss是$,而且它们的作用域也不一样，less是块级作用域

**3、** 输出设置，Less没有输出设置，sass提供4种输出选项，nested,compact,compressed和expanded nested：嵌套缩进的css代码(默认) expanded：展开的多行css代码 compact：简洁格式的css代码 compressed：压缩后的css代码

**4、** sass支持条件语句，可以使用if{}else{},for{}循环等等，而less不行

**5、** 引用外部css文件，sass引用外部文件必须以_开头，文件名如果以下划线_形状，sass会认为该文件是一个引用文件，不会将其编译为css文件。less引用外部文件和css中的@import没什么差异。

**6、** sass和less的工具库不同。sass有工具库Compass, 简单说，sass和Compass的关系有点像Javascript和jQuery的关系,Compass是sass的工具库。在它的基础上，封装了一系列有用的模块和模板，补充强化了sass的功能。less有UI组件库Bootstrap,Bootstrap是web前端开发中一个比较有名的前端UI组件库，Bootstrap的样式文件部分源码就是采用less语法编写。

总结：不管是sass，还是less，都可以视为一种基于CSS之上的高级语言，其目的是使得CSS开发更灵活和更强大，sass的功能比less强大,基本可以说是一种真正的编程语言了，less则相对清晰明了,易于上手,对编译环境要求比较宽松。考虑到编译sass要安装Ruby,而Ruby官网在国内访问不了,个人在实际开发中更倾向于选择less。


### 9、Function.prototype.apply 方法的用途是什么？

`apply()` 方法调用一个具有给定this值的函数，以及作为一个数组（或类似数组对象）提供的参数。

```
const details = {
  message: 'Hello World!'
};

function getMessage(){
  return this.message;
}

getMessage.apply(details); // 'Hello World!'
```

> `call()`方法的作用和 `apply()` 方法类似，区别就是`call()`方法接受的是参数列表，而`apply()`方法接受的是一个参数数组。


```
const person = {
  name: "Marko Polo"
};

function greeting(greetingMessage) {
  return `${greetingMessage} ${this.name}`;
}

greeting.apply(person, ['Hello']); // "Hello Marko Polo!"
```


### 10、如何在一行中计算多个表达式的值？

可以使用`逗号`运算符在一行中计算多个表达式。它从左到右求值，并返回右边最后一个项目或最后一个操作数的值。

```
let x = 5;

x = (x++ , x = addFive(x), x *= 2, x -= 5, x += 10);

function addFive(num) {
  return num + 5;
}
```

上面的结果最后得到`x`的值为`27`。首先，我们将`x`的值增加到`6`，然后调用函数`addFive(6)`并将`6`作为参数传递并将结果重新分配给`x`，此时`x`的值为`11`。之后，将`x`的当前值乘以`2`并将其分配给`x`，`x`的更新值为`22`。然后，将`x`的当前值减去`5`并将结果分配给`x` `x`更新后的值为`17`。最后，我们将`x`的值增加`10`，然后将更新的值分配给`x`，最终`x`的值为`27`。


### 11、为什么typeof null 返回 object？如何检查一个值是否为 null？
### 12、== 和 === 有什么区别？
### 13、谈谈你对webpack的看法
### 14、offsetWidth/offsetHeight,clientWidth/clientHeight与scrollWidth/scrollHeight的区别
### 15、什么是事件捕获？
### 16、简述ajax执行流程
### 17、disabled readyonly?
### 18、this指向的各种情况都有什么？
### 19、什么是缓存及它有什么作用？
### 20、如何copy一个dom元素？
### 21、什么是类？
### 22、ES6或ECMAScript 2015有哪些新特性？
### 23、Javascript如何实现继承？
### 24、上一个项目是什么？主要负责哪些？购物车流程?支付功能?
### 25、$(function(){})和window.onload 和 $(document).ready(function(){})
### 26、Jq中如何将一个jq对象转化为dom对象？
### 27、如何通过原生js 判断一个元素当前是显示还是隐藏状态?
### 28、使用 + 或一元加运算符是将字符串转换为数字的最快方法吗？
### 29、如何确保ajax或连接不走缓存路径




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
