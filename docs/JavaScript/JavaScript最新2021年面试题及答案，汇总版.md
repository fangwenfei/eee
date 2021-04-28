# JavaScript最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、异步加载的方式有哪些？

(1) defer，只支持IE

(2) async：true

(3) 创建script，插入到DOM中，加载完毕后callBack


### 2、如何改变this指针的指向？

可以使用`apply`、`call`、`bind`方法改变`this`指向(并不会改变函数的作用域)。比较如下：

**1、** 三者第一个参数都是`this`要指向的对象，也就是想指定的上下文，上下文就是指调用函数的那个对象(没有就指向全局window)；

**2、** `bind`和`call`的第二个参数都是数组，`apply`接收多个参数并用逗号隔开；

**3、** `apply`和`call`只对原函数做改动，`bind`会返回新的函数(要生效还得再调用一次)。


### 3、Function.prototype.apply 和 Function.prototype.call 之间有什么区别？

`apply()`方法可以在使用一个指定的 `this` 值和一个参数数组（或类数组对象）的前提下调用某个函数或方法。`call()`方法类似于`apply()`，不同之处仅仅是`call()`接受的参数是参数列表。

```
const obj1 = {
result:0
};

const obj2 = {
result:0
};

function reduceAdd(){
  let result = 0;
  for(let i = 0, len = arguments.length; i < len; i++){
    result += arguments[i];
  }
  this.result = result;
}

reduceAdd.apply(obj1, [1, 2, 3, 4, 5]); // 15
reduceAdd.call(obj2, 1, 2, 3, 4, 5); // 15
```


### 4、null，undefined 的区别？

**1、** `undefined` 表示不存在这个值。

**2、** `undefined` :是一个表示"无"的原始值或者说表示"缺少值"，就是此处应该有一个值，但是还没有定义。当尝试读取时会返回 `undefined`

**3、** 例如变量被声明了，但没有赋值时，就等于`undefined`

**4、** `null` 表示一个对象被定义了，值为“空值”

**5、** `null` : 是一个对象(空对象, 没有任何属性和方法)

**6、** 例如作为函数的参数，表示该函数的参数不是对象；

**7、** 在验证`null`时，一定要使用　`===` ，因为 `==`无法分别`null` 和　`undefined`


### 5、为什么要有同源限制？

**1、** 同源策略指的是：协议，域名，端口相同，同源策略是一种安全协议

**2、** 举例说明：比如一个黑客程序，他利用`Iframe`把真正的银行登录页面嵌到他的页面上，当你使用真实的用户名，密码登录时，他的页面就可以通过`Javascript`读取到你的表单中`input`中的内容，这样用户名，密码就轻松到手了。


### 6、模块化开发怎么做？

立即执行函数,不暴露私有成员

```
var module1 = (function(){
　　　　var _count = 0;
　　　　var m1 = function(){
　　　　　　//...
　　　　};
　　　　var m2 = function(){
　　　　　　//...
　　　　};
　　　　return {
　　　　　　m1 : m1,
　　　　　　m2 : m2
　　　　};
　　})();
```


### 7、你对数据校验是怎么样处理的？jquery.validate？

通俗的说，就是为保证数据的完整性，用一种指定的算法对原始数据计算出的一个校验值。接收方用同样的算法计算一次校验值，如果和随数据提供的校验值一样，就说明数据是完整的。

用正则表达式来处理;

jquery.validate：为表单验证插件


### 8、实现继承的方法有哪些？？？

实现继承的方法有：

**class+extends继承（ES6）**

```
//类模板
class Animal {
    constructor(name) {
        this.name = name
    }
}
//继承类
class Cat extends Animal { //重点。extends方法，内部用constructor+super
    constructor(name) {
        super(name);
        //super作为函数调用时，代表父类的构造函数
    } //constructor可省略
    eat() {
        console.log("eating")
    }
}
```

**原型继承**

```
//类模板
function Animal(name) {
    this.name = name;
}
//添加原型方法
Animal.prototype.eat = function() {
    console.log("eating")
}

function Cat(furColor) {
    this.color = color;
};
//继承类
Cat.prototype = new Animal() //重点：子实例的原型等于父类的实例
```

**借用构造函数继承**

```
function Animal(name){
    this.name = name
}
function Cat(){
    Animal.call(this,"CatName")//重点，调用父类的call方法
}
```

**寄生组合式继承（重点）**


### 9、通过new创建一个对象的时候，函数内部有哪些改变###

```
function Person(){}
Person.prototype.friend = [];
Person.prototype.name = '';
// var a = new Person();
// a.friend[0] = '王琦';
// a.name = '程娇';
// var b = new Person();
// b.friend？
// b.name?
```

**1、** 创建一个空对象，并且 this 变量引用该对象，同时还继承了该函数的原型。

**2、** 属性和方法被加入到 this 引用的对象中。

**3、** 新创建的对象由 this 所引用，并且最后隐式的返回 this 。


### 10、你觉得jQuery源码有哪些写的好的地方

**1、** `jquery`源码封装在一个匿名函数的自执行环境中，有助于防止变量的全局污染，然后通过传入`window`对象参数，可以使`window`对象作为局部变量使用，好处是当`jquery`中访问`window`对象的时候，就不用将作用域链退回到顶层作用域了，从而可以更快的访问window对象。同样，传入`undefined`参数，可以缩短查找`undefined`时的作用域链

**2、** `jquery`将一些原型属性和方法封装在了`jquery.prototype`中，为了缩短名称，又赋值给了`jquery.fn`，这是很形象的写法

**3、** 有一些数组或对象的方法经常能使用到，`jQuery`将其保存为局部变量以提高访问速度

**4、** `jquery`实现的链式调用可以节约代码，所返回的都是同一个对象，可以提高代码效率


### 11、JavaScript原型，原型链 ? 有什么特点？
### 12、什么是包装对象（wrapper object）？
### 13、javascript创建对象的几种方式？
### 14、事件流?事件捕获？事件冒泡？
### 15、JSON 的了解？**
### 16、Jq中如何将一个jq对象转化为dom对象？
### 17、什么是 IIFE，它的用途是什么？
### 18、编写一个 getElementsByClassName 封装函数?
### 19、对象的 prototype(原型) 是什么？
### 20、调用函数，可以使用哪些方法？
### 21、$$.map和$$.each有什么区别###
### 22、如何知道是否在元素中使用了`event.preventDefault()`方法？
### 23、DOM事件模型和事件流？
### 24、this是什么 在不同场景中分别代表什么###
### 25、什么是 ES6 模块？
### 26、为什么typeof null 返回 object？如何检查一个值是否为 null？
### 27、JavaScript 中 `this` 值是什么？
### 28、回调函数?
### 29、JSON 的了解？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
