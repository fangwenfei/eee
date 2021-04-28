# JavaScript最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Object.seal 和 Object.freeze 方法之间有什么区别？

**Object.freeze()**

`Object.freeze()` 方法可以冻结一个对象。一个被冻结的对象再也不能被修改；冻结了一个对象则不能向这个对象添加新的属性，不能删除已有属性，不能修改该对象已有属性的可枚举性、可配置性、可写性，以及不能修改已有属性的值。此外，冻结一个对象后该对象的原型也不能被修改`。freeze()` 返回和传入的参数相同的对象。

**Object.seal()**

```
Object.seal()方法封闭一个对象，阻止添加新属性并将所有现有属性标记为不可配置。当前属性的值只要可写就可以改变。
```

方法的相同点：

**1、** ES5新增。

**2、** 对象不可能扩展，也就是不能再添加新的属性或者方法。

**3、** 对象已有属性不允许被删除。

**4、** 对象属性特性不可以重新配置。

方法不同点：

- `Object.seal`方法生成的密封对象，如果属性是可写的，那么可以修改属性值。`* Object.freeze`方法生成的冻结对象，属性都是不可写的，也就是属性值无法更改。


### 2、this是什么 在不同场景中分别代表什么###

（1）function a(){ this ?} //This:指向windows

（2）function b(){ return function(){ this ?}}b()(); //This:指向windows

（3）function c(){ return {s:function(){this}}}c().s(); //This:指向object

由于其运行期绑定的特性，JavaScript 中的 this 含义要丰富得多，它可以是全局对象、当前对象或者任意对象，这完全取决于函数的调用方式。


### 3、如何理解同步和异步？

同步：按照代码书写顺序一一执行处理指令的一种模式，上一段代码执行完才能执行下一段代码。

异步：可以理解为一种并行处理的方式，不必等待一个程序执行完，可以执行其它的任务。

JS之所以需要异步的原因在于JS是单线程运行的。常用的异步场景有：定时器、ajax请求、事件绑定。


### 4、如何使用storage 对js文件进行缓存

由于sessionStorage - 针对一个 session 的数据存储，所以我们一般利用localStorage储存js文件，只有在第一次访问该页面的时候加载js文件，以后在访问的时候加载本地localStorage执行


### 5、javascript 代码中的"use strict";是什么意思 ? 使用它区别是什么？

`use strict`是一种`ECMAscript 5` 添加的（严格）运行模式,这种模式使得 Javascript 在更严格的条件下运行,使`JS`编码更加规范化的模式,消除`Javascript`语法的一些不合理、不严谨之处，减少一些怪异行为


### 6、25.Jq如何判断元素显示隐藏？

```
//第一种：使用CSS属性 
var display =$('#id').css('display'); 
if(display == 'none'){    alert("我是隐藏的！"); }
//第二种：使用jquery内置选择器 
<div id="test"<p>仅仅是测试所用</p</div>
if($("#test").is(":hidden")){        $("#test").show();    //如果元素为隐藏,则将它显现 }else{       $("#test").hide();     //如果元素为显现,则将其隐藏 }
//第三种：jQuery判断元素是否显示 是否隐藏
var node=$('#id');
if(node.is(':hidden')){　　//如果node是隐藏的则显示node元素，否则隐藏
　　node.show();　
}else{
　　node.hide();
}
```


### 7、如何添加一个dom对象到body中?innerHTML和innerText区别?

body.appendChild(dom元素)；

innerHTML:从对象的起始位置到终止位置的全部内容,包括Html标签。

innerText:从起始位置到终止位置的内容, 但它去除Html标签

分别简述五个window对象、属性

**成员对象**

**1、** window.event window.document window.history

**2、** window.screen window.navigator window.external

**3、** Window对象的属性如下：

**4、** window //窗户自身

**5、** window.self [//引用本窗户window=window.self](//%E5%BC%95%E7%94%A8%E6%9C%AC%E7%AA%97%E6%88%B7window=window.self)

**6、** window.name //为窗户命名

**7、** window.defaultStatus //设定窗户状态栏信息

**8、** window.location //URL地址,配备布置这个属性可以打开新的页面


### 8、ECMAScript 是什么？

ECMAScript 是编写脚本语言的标准，这意味着JavaScript遵循ECMAScript标准中的规范变化，因为它是JavaScript的蓝图。

ECMAScript 和 Javascript，本质上都跟一门语言有关，一个是语言本身的名字，一个是语言的约束条件 只不过发明JavaScript的那个人（Netscape公司），把东西交给了ECMA（European Computer Manufacturers Association），这个人规定一下他的标准，因为当时有java语言了，又想强调这个东西是让ECMA这个人定的规则，所以就这样一个神奇的东西诞生了，这个东西的名称就叫做ECMAScript。

javaScript = ECMAScript + DOM + BOM（自认为是一种广义的JavaScript）

ECMAScript说什么JavaScript就得做什么！

JavaScript（狭义的JavaScript）做什么都要问问ECMAScript我能不能这样干！如果不能我就错了！能我就是对的！

——突然感觉JavaScript好没有尊严，为啥要搞个人出来约束自己，

那个人被创造出来也好委屈，自己被创造出来完全是因为要约束JavaScript。


### 9、有哪些数据类型？

根据 JavaScript 中的变量类型传递方式，分为基本数据类型和引用数据类型两大类七种。

基本数据类型包括Undefined、Null、Boolean、Number、String、Symbol (ES6新增)六种。 引用数据类型只有Object一种，主要包括对象、数组和函数。

**判断数据类型采用`typeof`操作符，有两种语法：**

```
typeof 123;//语法一

const FG = 123;
typeof FG;//语法二

typeof(null) //返回 object;
null == undefined //返回true，因为undefined派生自null;
null === undefined //返回false。
```


### 10、'use strict' 是干嘛用的？

`"use strict"` 是 **ES5** 特性，它使我们的代码在函数或整个脚本中处于**严格模式**。**严格模式**帮助我们在代码的早期避免 bug，并为其添加限制。

**严格模式**的一些限制：

**1、** 变量必须声明后再使用

**2、** 函数的参数不能有同名属性，否则报错

**3、** 不能使用`with`语句

**4、** 不能对只读属性赋值，否则报错

**5、** 不能使用前缀 0 表示八进制数，否则报错

**6、** 不能删除不可删除的属性，否则报错

**7、** 不能删除变量`delete prop`，会报错，只能删除属性`delete global[prop]`

**8、** `eval`不能在它的外层作用域引入变量

**9、** `eval`和`arguments`不能被重新赋值

**10、** `arguments`不会自动反映函数参数的变化

**11、** 不能使用`arguments.callee`

**12、** 不能使用`arguments.caller`

**13、** 禁止`this`指向全局对象

**14、** 不能使用`fn.caller`和`fn.arguments`获取函数调用的堆栈

**15、** 增加了保留字（比如`protected`、`static`和`interface`）

设立”严格模式”的目的，主要有以下几个：

**1、** 消除Javascript语法的一些不合理、不严谨之处，减少一些怪异行为;

**2、** 消除代码运行的一些不安全之处，保证代码运行的安全；

**3、** 提高编译器效率，增加运行速度；

**4、** 为未来新版本的Javascript做好铺垫。


### 11、简述下工作流程###
### 12、bootstrap好处？
### 13、JSON 的了解？
### 14、说说严格模式的限制
### 15、什么是作用域和作用域链？
### 16、什么是函数式编程? JavaScript 的哪些特性使其成为函数式语言的候选语言？
### 17、JavaScript有几种类型的值？，你能画一下他们的内存图吗？
### 18、slice() splice()?
### 19、强制转换 显式转换 隐式转换?
### 20、什么是 event.target ？
### 21、通过new创建一个对象的时候，函数内部有哪些改变###
### 22、Jq绑定事件的几种方式？on bind ?
### 23、闭包
### 24、Jq中如何实现多库并存?
### 25、事件委托？有什么好处?
### 26、如何清除一个定时器?
### 27、自执行函数?用于什么场景？好处?
### 28、window.onload ==? DOMContentLoaded ?
### 29、eval是做什么的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
