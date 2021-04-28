# JavaScript最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、js的几种继承方式？

**1、** 使用对象冒充实现继承

**2、** 采用call、Apply方法改变函数上下文实现继承

**3、** 原型链方式继承


### 2、什么是移动端的300ms延迟？什么是点击穿透？解决方案?

移动端300ms延迟：假定这么一个场景。用户在 浏览器里边点击了一个链接。由于用户可以进行双击缩放或者双击滚动的操作，当用户一次点击屏幕之后，浏览器并不能立刻判断用户是确实要打开这个链接，还是想要进行双击操作。因此，浏览器 就等待 300 毫秒，以判断用户是否再次点击了屏幕。也就是说，当我们点击页面的时候移动端浏览器并不是立即作出反应，而是会等上一小会儿才会出现点击的效果。

点击穿透：假如页面上有两个元素A和B。B元素在A元素之上。我们在B元素的touchstart事件上注册了一个回调函数，该回调函数的作用是隐藏B元素。我们发现，当我们点击B元素，B元素被隐藏了，随后，A元素触发了click事件。这是因为在移动端浏览器，事件执行的顺序是touchstart touchend click。而click事件有300ms的延迟，当touchstart事件把B元素隐藏之后，隔了300ms，浏览器触发了click事件，但是此时B元素不见了，所以该事件被派发到了A元素身上。如果A元素是一个链接，那此时页面就会意外地跳转。

300ms延迟解决方案：

(1) 禁用缩放，在html文档头部加meta标签如下：




(4) FastClick为解决移动端浏览器300毫秒延迟开发的一个轻量级的库

点击穿透解决方案：

（1）只用touch

（2）只用click

（3）tap后延迟350ms再隐藏mask

（4）pointer-events


### 3、何为防抖和节流？如何实现？

**1、** 防抖和节流都是防止短时间内高频触发事件的方案。

**2、** 防抖的原理是：如果一定时间内多次执行了某事件，则只执行其中的最后一次。

**3、** 节流的原理是：要执行的事件每隔一段时间会被冷却，无法执行。

**4、** 应用场景有：搜索框实时搜索，滚动改变相关的事件。

```
//@fn: 要执行的函数
//@delay: 设定的时限
//防抖函数
function debunce(fn, delay) {
    let flag = null;
    return function() {
        if (flag) clearTimeout(flag)
        //利用apply改变函数指向，使得封装后的函数可以接收event本身
        flag = setTimeout(() = > fn.apply(this, arguments), delay)
    }
}
//节流函数
function throttle(fn, delay) {
    let flag = true;
    return function() {
        if (!flag) return false;
        flag = false;
        setTimeout(() = > {
            fn.apply(this, arguments)
            flag = true
        }, delay)
    }
}
```


### 4、Jq中 attr 和 prop 有什么区别###

对于HTML元素本身就带有的固有属性，在处理时，使用prop方法。

对于HTML元素我们自己自定义的DOM属性，在处理时，使用attr方法。


### 5、如何合并两个数组？数组删除一个元素?

```
//三种方法。

（1）var arr1=[1,2,3];
        var arr2=[4,5,6];
        arr1 = arr1.concat(arr2);
        console.log(arr1); 
        
（2）var arr1=[1,2,3];
        var arr2=[4,5,6];
        Array.prototype.push.apply(arr1,arr2);
        console.log(arr1);
        
（3）var arr1=[1,2,3];
    var arr2=[4,5,6];
    for (var i=0; i < arr2.length; i++) {
    arr1.push( arr2[i] );
    }
    console.log(arr1);
```


### 6、call & apply 两者之间的区别###

call和apply都是改变this指向的方法，区别在于call可以写多个参数，而apply只能写两个参数，第二个参数是一个数组，用于存放要传的参数。


### 7、Function.prototype.apply 和 Function.prototype.call 之间有什么区别？

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


### 8、split() join()?

前者是切割成数组的形式，

后者是将数组转换成字符串


### 9、`require`/`import`之间的区别？

**1、** `require`是CommonJS语法，`import`是ES6语法；

**2、** `require`只在后端服务器支持，`import`在高版本浏览器及Node中都可以支持；

**3、** `require`引入的是原始导出值的复制，`import`则是导出值的引用；

**4、** `require`时运行时动态加载，`import`是静态编译；

**5、** `require`调用时默认不是严格模式，`import`则默认调用严格模式.

### 10、Function.prototype.apply 方法的用途是什么？

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


### 11、eval是做什么的？
### 12、DOM 是什么？
### 13、为什么在调用这个函数时，代码中的`b`会变成一个全局变量?
### 14、模块化开发怎么做？
### 15、说说你对作用域链的理解
### 16、JavaScript提供了哪几种“异步模式”？
### 17、什么是预编译语音|预编译处理器?
### 18、new 关键字有什么作用？
### 19、谈谈你对ES6的理解
### 20、什么是执行上下文和执行栈？
### 21、什么是模板字符串？
### 22、介绍js有哪些内置对象？
### 23、使用 + 或一元加运算符是将字符串转换为数字的最快方法吗？
### 24、同步和异步的区别?
### 25、怎么理解Promise对象？
### 26、什么是对象解构？
### 27、undefined 和 null 有什么区别？
### 28、如何确保ajax或连接不走缓存路径
### 29、声明函数作用提升?声明变量和声明函数的提升有什么区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
