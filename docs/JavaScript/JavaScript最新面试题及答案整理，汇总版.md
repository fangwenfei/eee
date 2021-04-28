# JavaScript最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、一般使用什么版本控制工具?svn如何对文件加锁###

svn加锁目的：为了避免多个人同一时间对同一个文件改动的相互覆盖，版本控制系统就必须有一套冲突处理机制。

svn加锁两种策略：乐观加锁：所有签出的文件都是可读写的，对文件的修改不必获得文件的锁，当你修改完文件签入时，会首先要求你更新本地文件，版本控制系统不会覆盖你的本地修改，而是会让你自己合并冲突后签入。

严格加锁：所有签出的文件都是只读的，任何对文件的修改必须要获得文件的锁，如果其他人没有拥有该文件的锁，那么版本控制系统就会授权给你文件的锁，并将文件设置为可编辑的。

svn两种加锁步骤：乐观加锁：选择你想要获取锁定的文件，然后右键菜单点击TortoiseSVN 选取获取锁定。

严格加锁：在想要采取严格加锁的文件或目录上点击右键，使用TortoiseSVN 属性菜单，点击新建属性，选择需要锁定。


### 2、javascript创建对象的几种方式？

`javascript`创建对象简单的说,无非就是使用内置对象或各种自定义对象，当然还可以用`JSON`；但写法有很多种，也能混合使用

对象字面量的方式

```
person={firstname:"Mark",lastname:"Yun",age:25,eyecolor:"black"};
```

用`function`来模拟无参的构造函数

```
 function Person(){}
    var person=new Person();//定义一个function，如果使用new"实例化",该function可以看作是一个Class
        person.name="Mark";
        person.age="25";
        person.work=function(){
        alert(person.name+" hello...");
    }
person.work();
```

用`function`来模拟参构造函数来实现（用`this`关键字定义构造的上下文属性）

```
function Pet(name,age,hobby){
       this.name=name;//this作用域：当前对象
       this.age=age;
       this.hobby=hobby;
       this.eat=function(){
          alert("我叫"+this.name+",我喜欢"+this.hobby+",是个程序员");
       }
    }
    var maidou =new Pet("麦兜",25,"coding");//实例化、创建对象
    maidou.eat();//调用eat方法
```

用工厂方式来创建（内置对象）

```
var wcDog =new Object();
     wcDog.name="旺财";
     wcDog.age=3;
     wcDog.work=function(){
       alert("我是"+wcDog.name+",汪汪汪......");
     }
     wcDog.work();
```

用原型方式来创建

```
function Dog(){

     }
     Dog.prototype.name="旺财";
     Dog.prototype.eat=function(){
     alert(this.name+"是个吃货");
     }
     var wangcai =new Dog();
     wangcai.eat();
```

用混合方式来创建

```
 function Car(name,price){
      this.name=name;
      this.price=price; 
    }
     Car.prototype.sell=function(){
       alert("我是"+this.name+"，我现在卖"+this.price+"万元");
      }
    var camry =new Car("凯美瑞",27);
    camry.sell();
```


### 3、判断数据类型的方法有哪些？

**1、** 利用`typeof`可以判断数据的类型；

**2、** `A instanceof` B可以用来判断A是否为B的实例，但它不能检测 null 和 undefined；

**3、** `B.constructor == A`可以判断A是否为B的原型，但constructor检测 Object与instanceof不一样，还可以处理基本数据类型的检测。

不过函数的 constructor 是不稳定的，这个主要体现在把类的原型进行重写，在重写的过程中很有可能出现把之前的constructor给覆盖了，这样检测出来的结果就是不准确的。

**4、** `Object.prototype.toString.call()`

`Object.prototype.toString.call()` 是最准确最常用的方式。


### 4、js延迟加载的方式有哪些？

`defer`和`async`、动态创建`DOM`方式（用得最多）、按需异步载入`js`


### 5、有哪些方法可以处理 JS 中的异步代码？

1、回调

**2、** Promise

**3、** async/await

**4、** 还有一些库：async.js, bluebird, q, co


### 6、手动实现 `Array.prototype.map 方法`

`map()` 方法创建一个新数组，其结果是该数组中的每个元素都调用一个提供的函数后返回的结果。

```
function map(arr, mapCallback) {
  // 首先，检查传递的参数是否正确。
  if (!Array.isArray(arr) || !arr.length || typeof mapCallback !== 'function') { 
    return [];
  } else {
    let result = [];
    // 每次调用此函数时，我们都会创建一个 result 数组
    // 因为我们不想改变原始数组。
    for (let i = 0, len = arr.length; i < len; i++) {
      result.push(mapCallback(arr[i], i, arr)); 
      // 将 mapCallback 返回的结果 push 到 result 数组中
    }
    return result;
  }
}
```


### 7、call和apply 有什么好处？

用call和apply:实现更好的继承和扩展，更安全。


### 8、用过哪些设计模式？

**工厂模式：**

**1、** 工厂模式解决了重复实例化的问题，但还有一个问题,那就是识别问题，因为根本无法

**2、** 主要好处就是可以消除对象间的耦合，通过使用工程方法而不是`new`关键字

**构造函数模式**

**1、** 使用构造函数的方法，即解决了重复实例化的问题，又解决了对象识别的问题，该模式与工厂模式的不同之处在于

**2、** 直接将属性和方法赋值给 `this`对象;


### 9、为什么函数被称为一等公民？

在JavaScript中，函数不仅拥有一切传统函数的使用方式（声明和调用），而且可以做到像简单值一样赋值`（var func = function(){}）`、传参`(function func(x,callback){callback();})`、返回`(function(){return function(){}})`，这样的函数也称之为**第一级函数（First-class Function）**。不仅如此，JavaScript中的函数还充当了类的构造函数的作用，同时又是一个`Function`类的实例(instance)。这样的多重身份让JavaScript的函数变得非常重要。


### 10、30.Jq中怎么样编写插件?

```
//第一种是类级别的插件开发：
//1.1 添加一个新的全局函数 添加一个全局函数，我们只需如下定义： 
jQuery.foo = function() {
     alert('This is a test、This is only a test.');  };   

//1.2 增加多个全局函数 添加多个全局函数，可采用如下定义： 
jQuery.foo = function() {
       alert('This is a test、This is only a test.');  };  
jQuery.bar = function(param) {
      alert('This function takes a parameter, which is "' + param + '".');  };   调用时和一个函数的一样的:jQuery.foo();jQuery.bar();或者$.foo();$.bar('bar');
//1.3 使用jQuery.extend(object);　 
jQuery.extend({
      foo: function() {
          alert('This is a test、This is only a test.');
        },
      bar: function(param) {
          alert('This function takes a parameter, which is "' + param +'".');
        }
     }); 
//1.4 使用命名空间
// 虽然在jQuery命名空间中，我们禁止使用了大量的javaScript函数名和变量名。
// 但是仍然不可避免某些函数或变量名将于其他jQuery插件冲突，因此我们习惯将一些方法
// 封装到另一个自定义的命名空间。
jQuery.myPlugin = {         
foo:function() {         
  alert('This is a test、This is only a test.');         
 },         
 bar:function(param) {         
  alert('This function takes a parameter, which is "' + param + '".');   
 }        
}; 
//采用命名空间的函数仍然是全局函数，调用时采用的方法： 
$.myPlugin.foo();        
$.myPlugin.bar('baz');
//通过这个技巧（使用独立的插件名），我们可以避免命名空间内函数的冲突。

//第二种是对象级别的插件开发
//形式1： 
(function($){    
  $.fn.extend({    
   pluginName:function(opt,callback){    
             // Our plugin implementation code goes here、     
   }    
  })    
})(jQuery);  

//形式2：
(function($) {      
   $.fn.pluginName = function() {    
        // Our plugin implementation code goes here、   
   };     
})(jQuery);
//形参是$，函数定义完成之后,把jQuery这个实参传递进去.立即调用执行。
//这样的好处是,我们在写jQuery插件时,也可以使用$这个别名,而不会与prototype引起冲突
```


### 11、异步加载的方式有哪些？
### 12、什么是高阶函数？
### 13、$$.map和$$.each有什么区别###
### 14、如何解决跨域问题?
### 15、jquery和zepto有什么区别?
### 16、html和xhtml有什么区别?
### 17、vue、react、angular
### 18、谈谈This对象的理解
### 19、jQuery与jQuery UI 有啥区别？
### 20、什么是 IIFE，它的用途是什么？
### 21、defer和async
### 22、压缩合并目的？http请求的优化方式？
### 23、调用函数，可以使用哪些方法？
### 24、函数fn1 函数fn2 函数fn3，如果想在三个函数都执行完成后执行某一个事件应该如何实现?
### 25、["1", "2", "3"].map(parseInt) 答案是多少？
### 26、手动实现缓存方法
### 27、作用域和执行上下文的区别是什么？
### 28、AJAX 是什么？
### 29、如何知道是否在元素中使用了`event.preventDefault()`方法？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
