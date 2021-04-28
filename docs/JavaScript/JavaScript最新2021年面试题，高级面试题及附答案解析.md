# JavaScript最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是作用域和作用域链？

作用域可以理解为一个独立的地盘，可以理解为标识符所能生效的范围。作用域最大的用处就是隔离变量，不同作用域下同名变量不会有冲突。ES6中有全局作用域、函数作用域和块级作用域三层概念。

当一个变量在当前块级作用域中未被定义时，会向父级作用域(创建该函数的那个父级作用域)寻找。如果父级仍未找到，就会再一层一层向上寻找，直到找到全局作用域为止。这种一层一层的关系，就是作用域链 。


### 2、谁是c的构造函数?

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


### 3、Jq中如何将一个jq对象转化为dom对象？

**方法一：**

jQuery对象是一个数据对象，可以通过[index]的方法，来得到相应的DOM对象。

如：var $$v =$$("#v") ; //jQuery对象

var v=$v[0]; //DOM对象

alert(v.checked) //检测这个checkbox是否被选中

**方法二：**

jQuery本身提供，通过.get(index)方法，得到相应的DOM对象

如：var $$v=$$("#v"); //jQuery对象

var v=$v.get(0); //DOM对象

alert(v.checked) //检测这个checkbox是否被选中


### 4、自执行函数?用于什么场景？好处?

**自执行函数:**

**1、** 声明一个匿名函数

**2、** 马上调用这个匿名函数。

作用：创建一个独立的作用域。

**好处：**

防止变量弥散到全局，以免各种js库冲突。隔离作用域避免污染，或者截断作用域链，避免闭包造成引用变量无法释放。利用立即执行特性，返回需要的业务函数或对象，避免每次通过条件判断来处理

场景：一般用于框架、插件等场景


### 5、谈谈你对webpack的看法

**1、** `WebPack` 是一个模块打包工具，你可以使用`WebPack`管理你的模块依赖，并编绎输出模块们所需的静态文件。它能够很好地管理、打包`Web`开发中所用到的`HTML`、`Javascript`、`CSS`以及各种静态文件（图片、字体等），让开发过程更加高效。对于不同类型的资源，`webpack`有对应的模块加载器。`webpack`模块打包器会分析模块间的依赖关系，最后 生成了优化且合并后的静态资源


### 6、调用函数，可以使用哪些方法？

在 JS 中有4种方法可以调用函数。

**作为函数调用**——如果一个函数没有作为方法、构造函数、`apply`、`call` 调用时，此时 `this` 指向的是 `window` 对象（非严格模式）

```
//Global Scope

function add(a,b){
  console.log(this);
  return a + b;
}  

add(1,5); // 打印 "window" 对象和 6

const o = {
  method(callback){
    callback();
  }
}

o.method(function (){
    console.log(this); // 打印 "window" 对象
});
```

**作为方法调用**——如果一个对象的属性有一个函数的值，我们就称它为**方法**。调用该方法时，该方法的`this`值指向该对象。

```
const details = {
  name : "Marko",
  getName(){
    return this.name;
  }
}

details.getName(); // Marko
```

**作为构造函数的调用**-如果在函数之前使用`new`关键字调用了函数，则该函数称为`构造函数`。构造函数里面会默认创建一个空对象，并将`this`指向该对象。

```
function Employee(name, position, yearHired) {
  // 创建一个空对象 {}
  // 然后将空对象分配给“this”关键字
  // this = {};
  this.name = name;
  this.position = position;
  this.yearHired = yearHired;
  // 如果没有指定 return ,这里会默认返回 this
};

const emp = new Employee("Marko Polo", "Software Developer", 2017);
```

**使用`apply`和`call`方法调用**——如果我们想显式地指定一个函数的`this`值，我们可以使用这些方法，这些方法对所有函数都可用。

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

    reduceAdd.apply(obj1, [1, 2, 3, 4, 5]);  // reduceAdd 函数中的 this 对象将是 obj1
    reduceAdd.call(obj2, 1, 2, 3, 4, 5); // reduceAdd 函数中的 this 对象将是 obj2
```


### 7、arguments 的对象是什么？

`arguments`对象是函数中传递的参数值的集合。它是一个类似数组的对象，因为它有一个length属性，我们可以使用数组索引表示法`arguments[1]`来访问单个值，但它没有数组中的内置方法，如：`forEach`、`reduce`、`filter`和`map`。

我们可以使用`Array.prototype.slice`将`arguments`对象转换成一个数组。

```
function one() {
  return Array.prototype.slice.call(arguments);
}
```

**注意:箭头函数中没有`arguments`对象。**

```
function one() {
  return arguments;
}
const two = function () {
  return arguments;
}
const three = function three() {
  return arguments;
}

const four = () => arguments;

four(); // Throws an error  - arguments is not defined
```

当我们调用函数`four`时，它会抛出一个`ReferenceError: arguments is not defined error`。使用`rest`语法，可以解决这个问题。

`const four = (...args) => args;`

这会自动将所有参数值放入数组中。


### 8、jQuery与jQuery UI 有啥区别？

jQuery是一个js库，主要提供的功能是选择器，属性修改和事件绑定等等。

jQuery UI则是在jQuery的基础上，利用jQuery的扩展性，设计的插件。提供了一些常用的界面元素，诸如对话框、拖动行为、改变大小行为等等。


### 9、简述下你理解的面向对象？

万物皆对象，把一个对象抽象成类,具体上就是把一个对象的静态特征和动态特征抽象成属性和方法,也就是把一类事物的算法和数据结构封装在一个类之中,程序就是多个对象和互相之间的通信组成的、

面向对象具有封装性,继承性,多态性。

封装:隐蔽了对象内部不需要暴露的细节,使得内部细节的变动跟外界脱离,只依靠接口进行通信.封装性降低了编程的复杂性、通过继承,使得新建一个类变得容易,一个类从派生类那里获得其非私有的方法和公用属性的繁琐工作交给了编译器、而继承和实现接口和运行时的类型绑定机制 所产生的多态,使得不同的类所产生的对象能够对相同的消息作出不同的反应,极大地提高了代码的通用性、

总之,面向对象的特性提高了大型程序的重用性和可维护性.


### 10、实现继承的方法有哪些？？？

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


### 11、undefined 和 null 有什么区别？
### 12、如何知道是否在元素中使用了`event.preventDefault()`方法？
### 13、EventLoop事件循环是什么？
### 14、如何解决跨域问题?
### 15、JavaScript 中 `this` 值是什么？
### 16、defer和async
### 17、手动实现`Array.prototype.filter`方法
### 18、== 和 === 有什么区别？
### 19、你有哪些性能优化的方法？
### 20、常见web安全及防护原理
### 21、如何创建一个没有 prototype(原型)的对象？
### 22、如何通过原生js 判断一个元素当前是显示还是隐藏状态?
### 23、Node的应用场景
### 24、说说你对作用域链的理解
### 25、Jq绑定事件的几种方式？on bind ?
### 26、什么是闭包？
### 27、disabled readyonly?
### 28、javascript创建对象的几种方式？
### 29、如何对登录的账号密码进行加密?
### 30、什么是高阶函数？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
