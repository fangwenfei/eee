# JavaScript最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Ajax原理

**1、** `Ajax`的原理简单来说是在用户和服务器之间加了—个中间层(`AJAX`引擎)，通过`XmlHttpRequest`对象来向服务器发异步请求，从服务器获得数据，然后用`javascrip`t来操作`DOM`而更新页面。使用户操作与服务器响应异步化。这其中最关键的一步就是从服务器获得请求数据

**2、** `Ajax`的过程只涉及`JavaScript`、`XMLHttpRequest`和`DOM`。`XMLHttpRequest`是`aja`x的核心机制

```
 // 1、创建连接
    var xhr = null;
    xhr = new XMLHttpRequest()
    // 2、连接服务器
    xhr.open('get', url, true)
    // 3、发送请求
    xhr.send(null);
    // 4、接受请求
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                success(xhr.responseText);
            } else { // fail
                fail && fail(xhr.status);
            }
        }
    }
```


### 2、说说你对promise的了解

依照 `Promise/A+` 的定义，`Promise` 有四种状态：

**1、** `pending:` 初始状态, 非 `fulfilled` 或 `rejected.`

**2、** `fulfilled:` 成功的操作.

**3、** `rejected:` 失败的操作.

**4、** `settled: Promise`已被`fulfilled`或`rejected`，且不是`pending`

另外， `fulfilled`与 `rejected`一起合称 `settled`

`Promise` 对象用来进行延迟(`deferred`) 和异步(`asynchronous`) 计算

**Promise 的构造函数**

构造一个 `Promise`，最基本的用法如下：

```
var promise = new Promise(function(resolve, reject) {

        if (...) {  // succeed

            resolve(result);

        } else {   // fails

            reject(Error(errMessage));

        }
    });
```

`Promise` 实例拥有 `then` 方法（具有 `then` 方法的对象，通常被称为`thenable`）。它的使用方法如下：

```
promise.then(onFulfilled, onRejected)
```

接收两个函数作为参数，一个在 `fulfilled` 的时候被调用，一个在`rejected`的时候被调用，接收参数就是 `future`，`onFulfilled` 对应`resolve`, `onRejected`对应 `reject`


### 3、简述ajax执行流程

```
基本步骤：
var xhr =null;//创建对象 
if(window.XMLHttpRequest){
       xhr = new XMLHttpRequest();
}else{
       xhr = new ActiveXObject("Microsoft.XMLHTTP");
}
xhr.open(“方式”,”地址”,”标志位”);//初始化请求 
   xhr.setRequestHeader(“”,””);//设置http头信息 
xhr.onreadystatechange =function(){}//指定回调函数 
xhr.send();//发送请求
```


### 4、那些操作会造成内存泄漏？

内存泄漏指任何对象在您不再拥有或需要它之后仍然存在

`setTimeout` 的第一个参数使用字符串而非函数的话，会引发内存泄漏

闭包使用不当


### 5、实现异步的方式有哪些？

**1、** 回调函数模式：将需要异步执行的函数作为回调函数执行，其缺点在于处理复杂逻辑异步逻辑时，会造成回调地狱(回调嵌套层数太多，代码结构混乱)；

**2、** 事件监听模式：采用事件驱动的思想，当某一事件发生时触发执行异步函数，其缺点在于整个代码全部得变为事件驱动模式，难以分辨主流程；

**3、** 发布订阅模式：当异步任务执行完成时发布消息给信号中心，其他任务通过在信号中心中订阅消息来确定自己是否开始执行；

**4、** Promise(ES6)：`Promise`对象共有三种状态`pending`(初始化状态)、`fulfilled`(成功状态)、`rejected`(失败状态)。

**5、** async/await(ES7)：基于`Promise`实现的异步函数； （6）利用生成器实现。


### 6、实现继承的方法有哪些？？？

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


### 7、Function.prototype.bind 的用途是什么？

`bind()` 方法创建一个新的函数，在 `bind()` 被调用时，这个新函数的 `this` 被指定为 `bind()` 的第一个参数，而其余参数将作为新函数的参数，供调用时使用。

```
import React from 'react';
class MyComponent extends React.Component {
   constructor(props){
      super(props); 
      this.state = {
         value : ""
      }  
      this.handleChange = this.handleChange.bind(this); 
      // 将 “handleChange” 方法绑定到 “MyComponent” 组件
   }

   handleChange(e){
     //do something amazing here
   }

   render(){
    return (
      <>
        <input type={this.props.type}
                value={this.state.value}
             onChange={this.handleChange}                      
          />
      </>
    )
   }
}
```


### 8、那些操作会造成内存泄漏？

**1、** 内存泄漏指任何对象在您不再拥有或需要它之后仍然存在

**2、** `setTimeout` 的第一个参数使用字符串而非函数的话，会引发内存泄漏

**3、** 闭包、控制台日志、循环（在两个对象彼此引用且彼此保留时，就会产生一个循环）


### 9、Node的应用场景

**特点：**

**1、** 它是一个`Javascript`运行环境

**2、** 依赖于`Chrome V8`引擎进行代码解释

**3、** 事件驱动

**4、** 非阻塞`I/O`

**5、** 单进程，单线程

**优点：**

**1、** 高并发（最重要的优点）

**缺点：**

**1、** 只支持单`核CPU`，不能充分利用`CPU`

**2、** 可靠性低，一旦代码某个环节崩溃，整个系统都崩溃


### 10、上一个项目是什么？主要负责哪些？购物车流程?支付功能?

**主要负责哪些就讲主要做哪些功能模块：**

1）商品模块:

**1、** 商品列表：商品排序 商品筛选 商品过滤 商品查询 商品推荐

**2、** 商品详情:类型推荐 商品简介 商品详情 商品评价 售后维护

2)购物车模块：商品编号、数量、价格、总额、运费、运输选项、运费总计、从购物车删除选项、更新数量、结账、继续购物、商品描述、库存信息


### 11、如何改变this指针的指向？
### 12、数组的排序方法（sort）？排序？汉字排序？
### 13、JavaScript原型，原型链 ? 有什么特点？
### 14、函数表达式和函数声明之间有什么区别？
### 15、请解释什么是事件代理
### 16、什么是构造函数？与普通函数有什么区别?
### 17、`Function.prototype.call` 方法的用途是什么？
### 18、什么是类？
### 19、怎么理解宏任务，微任务？？？
### 20、什么是事件冒泡？
### 21、说几条写JavaScript的基本规范？
### 22、谈谈你对webpack的看法
### 23、EventLoop事件循环是什么？
### 24、回调函数?
### 25、Jq中如何将一个jq对象转化为dom对象？
### 26、offsetWidth/offsetHeight,clientWidth/clientHeight与scrollWidth/scrollHeight的区别
### 27、如何copy一个dom元素？
### 28、异步编程？
### 29、ES6或ECMAScript 2015有哪些新特性？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
