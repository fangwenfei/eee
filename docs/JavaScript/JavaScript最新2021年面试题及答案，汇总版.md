# JavaScript最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、简述一下你理解的面向对象？

面向对象是基于万物皆对象这个哲学观点、把一个对象抽象成类,具体上就是把一个对象的静态特征和动态特征抽象成属性和方法,也就是把一类事物的算法和数据结构封装在一个类之中,程序就是多个对象和互相之间的通信组成的、

面向对象具有封装性,继承性,多态性。

封装:隐蔽了对象内部不需要暴露的细节,使得内部细节的变动跟外界脱离,只依靠接口进行通信.封装性降低了编程的复杂性、通过继承,使得新建一个类变得容易,一个类从派生类那里获得其非私有的方法和公用属性的繁琐工作交给了编译器、而 继承和实现接口和运行时的类型绑定机制 所产生的多态,使得不同的类所产生的对象能够对相同的消息作出不同的反应,极大地提高了代码的通用性、

总之,面向对象的特性提高了大型程序的重用性和可维护性.


### 2、与深拷贝有何区别？如何实现？

**浅拷贝只复制指向某个对象的指针，而不复制对象本身。浅拷贝的实现方式有：**

**1、** `Object.assign()`：需注意的是目标对象只有一层的时候，是深拷贝；

**2、** 扩展运算符；

**深拷贝就是在拷贝数据的时候，将数据的所有引用结构都拷贝一份。深拷贝的实现方式有：**

**1、** 手写遍历递归赋值；

**2、** 结合使用`JSON.parse()`和`JSON.stringify()`方法。


### 3、Jq中有几种选择器?分别是什么?

层叠选择器、基本过滤选择器、内容过滤选择器、可视化过滤选择器、属性过滤选择器、子元素过滤选择器、表单元素选择器、表单元素过滤选择器


### 4、jquery和zepto有什么区别?

**1、** 针对移动端程序，Zepto有一些基本的触摸事件可以用来做触摸屏交互（tap事件、swipe事件），Zepto是不支持IE浏览器的，这不是Zepto的开发者Thomas Fucks在跨浏览器问题上犯了迷糊，而是经过了认真考虑后为了降低文件尺寸而做出的决定，就像jQuery的团队在2.0版中不再支持旧版的IE（6 7 8）一样。因为Zepto使用jQuery句法，所以它在文档中建议把jQuery作为IE上的后备库。那样程序仍能在IE中，而其他浏览器则能享受到Zepto在文件大小上的优势，然而它们两个的API不是完全兼容的，所以使用这种方法时一定要小心，并要做充分的测试。

**2、** Dom操作的区别：添加id时jQuery不会生效而Zepto会生效。

**3、** zepto主要用在移动设备上，只支持较新的浏览器，好处是代码量比较小，性能也较好。

jquery主要是兼容性好，可以跑在各种pc，移动上，好处是兼容各种浏览器，缺点是代码量大，同时考虑兼容，性能也不够好。


### 5、如何知道是否在元素中使用了`event.preventDefault()`方法？

我们可以在事件对象中使用`event.defaultPrevented`属性。它返回一个布尔值用来表明是否在特定元素中调用了`event.preventDefault()`。


### 6、new 关键字有什么作用？

`new`关键字与构造函数一起使用以创建对象:

```
function Employee(name, position, yearHired) {
  this.name = name;
  this.position = position;
  this.yearHired = yearHired;
};

const emp = new Employee("Marko Polo", "Software Developer", 2017);
```

`new`关键字做了`4`件事:

**1、** 创建空对象 `{}`

**2、** 将空对象分配给 `this` 值

**3、** 将空对象的`__proto__`指向构造函数的`prototype`

**4、** 如果没有使用显式`return`语句，则返回`this`

看下面事例：

`function Person() { this.name = 'kyle' }`

根据上面描述的，`new Person()`做了：

**1、** 创建一个空对象：`var obj = {}`

**2、** 将空对象分配给 `this` 值：this = obj

**3、** 将空对象的`__proto__`指向构造函数的`prototype`:`this.__proto__ = Person().prototype`

**4、** 返回`this`:`return this`



### 7、渐进增强和优雅降级

**1、** 渐进增强 ：针对低版本浏览器进行构建页面，保证最基本的功能，然后再针对高级浏览器进行效果、交互等改进和追加功能达到更好的用户体验。

**2、** 优雅降级 ：一开始就构建完整的功能，然后再针对低版本浏览器进行兼容


### 8、什么是作用域和作用域链？
### 9、一个页面从输入 URL 到页面加载显示完成，这个过程中都发生了什么？（流程说的越详细越好）
### 10、AJAX 是什么？
### 11、如何对登录的账号密码进行加密?
### 12、**
### 13、事件模型
### 14、JavaScript 中的虚值是什么？
### 15、如何判断值是否为数组？
### 16、说说你对AMD和Commonjs的理解
### 17、js的几种继承方式？
### 18、bootstrap好处？
### 19、Promise 是什么？
### 20、判断数据类型
### 21、平时工作中怎么样进行数据交互?如果后台没有提供数据怎么样进行开发?
### 22、offsetWidth/offsetHeight,clientWidth/clientHeight与scrollWidth/scrollHeight的区别
### 23、什么是对象解构？
### 24、同步异步?
### 25、ajax中 get 和 post 有什么区别?
### 26、XML和JSON的区别？
### 27、defer和async
### 28、说说你对作用域链的理解
### 29、如何在 JS 中创建对象？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
