# JavaScript最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、说说你对promise的了解

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


### 2、Ajax原理

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


### 3、jsonp原理？ 缺点?

工作原理：使用script标签实现跨域访问，可在url中指定回调函数，获取JSON数据并在指定的回调函数中执行jquery实现jsop。

缺点：只支持GET方式的jsonp实现，是一种脚本注入行为存在一定的安全隐患。如果返回的数据格式有问题或者返回失败了，并不会报错。


### 4、Promise 是什么？

**Promise** 是异步编程的一种解决方案：从语法上讲，`promise`是一个对象，从它可以获取异步操作的消息；从本意上讲，它是承诺，承诺它过一段时间会给你一个结果。`promise`有三种状态：`pending(等待态)`，`fulfiled(成功态)`，`rejected(失败态)`；状态一旦改变，就不会再变。创造`promise`实例后，它会立即执行。

```
fs.readFile('somefile.txt', function (e, data) {
  if (e) {
    console.log(e);
  }
  console.log(data);
});
```

如果我们在回调内部有另一个异步操作，则此方法存在问题。我们将有一个混乱且不可读的代码。此代码称为 **『回调地狱』**。

```
// 回调地狱
fs.readFile('somefile.txt', function (e, data) {
  //your code here
  fs.readdir('directory', function (e, files) {
    //your code here
    fs.mkdir('directory', function (e) {
      //your code here
    })
  })
})
```

如果我们在这段代码中使用`promise`，它将更易于阅读、理解和维护。

`promReadFile('file/path') .then(data => { return promReaddir('directory'); }) .then(data => { return promMkdir('directory'); }) .catch(e => { console.log(e); })`

`promise`有三种不同的状态：

**1、** pending：初始状态，完成或失败状态的前一个状态

**2、** fulfilled：操作成功完成

**3、** rejected：操作失败

`pending` 状态的 `Promise` 对象会触发 `fulfilled/rejected` 状态，在其状态处理方法中可以传入参数/失败信息。当操作成功完成时，**Promise** 对象的 `then` 方法就会被调用；否则就会触发 `catch`。如：

```
const myFirstPromise = new Promise((resolve, reject) => {
  setTimeout(function(){
      resolve("成功!"); 
  }, 250);
});

myFirstPromise.then((data) => {
  console.log("Yay! " + data);
}).catch((e) => {...});
```


### 5、|| 运算符能做什么

`||`也叫或`逻辑或`，在其操作数中找到第一个真值表达式并返回它。这也使用了短路来防止不必要的工作。在支持 ES6 默认函数参数之前，它用于初始化函数中的默认参数值。

```
console.log(null || 1 || undefined); // 1

function logName(name) {
  var n = name || "Mark";
  console.log(n);
}

logName(); // "Mark"
```


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


### 7、XML和JSON的区别？

**数据体积方面**

`JSON`相对`于XML`来讲，数据的体积小，传递的速度更快些。

**数据交互方面**

`JSON`与`JavaScript`的交互更加方便，更容易解析处理，更好的数据交互

**数据描述方面**

`JSON`对数据的描述性比`XML`较差

**传输速度方面**

`JSON`的速度要远远快于`XML`


### 8、$$('div+.ab')和$$('.ab+div') 哪个效率高？

$('div+.ab')效率高


### 9、Jq中如何将一个jq对象转化为dom对象？

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


### 10、对象的 prototype(原型) 是什么？

简单地说，原型就是对象的蓝图。如果它存在当前对象中，则将其用作属性和方法的回退。它是在对象之间共享属性和功能的方法，这也是JavaScript实现继承的核心。

`const o = {}; console.log(o.toString()); // logs [object Object]`

即使`o`对象中不存在`o.toString`方法，它也不会引发错误，而是返回字符串`[object Object]`。当对象中不存在属性时，它将查看其原型，如果仍然不存在，则将其查找到原型的原型，依此类推，直到在原型链中找到具有相同属性的属性为止。原型链的末尾是`Object.prototype`。

`console.log(o.toString === Object.prototype.toString); // logs true`


### 11、如何知道是否在元素中使用了`event.preventDefault()`方法？
### 12、什么是NaN？以及如何检查值是否为NaN？
### 13、有哪些数据类型？
### 14、!! 运算符能做什么？
### 15、什么是高阶函数？
### 16、判断数据类型的方法有哪些？
### 17、请解释什么是事件代理
### 18、eval是做什么的？
### 19、介绍js的基本数据类型
### 20、几种基本数据类型?复杂数据类型?值类型和引用数据类型?堆栈数据结构
### 21、使用 + 或一元加运算符是将字符串转换为数字的最快方法吗？
### 22、Function.prototype.bind 的用途是什么？
### 23、Jq中get和eq有什么区别？
### 24、异步加载JS的方式有哪些？
### 25、实现继承的方法有哪些？？？
### 26、手动实现`Array.prototype.reduce`方法
### 27、如何确保ajax或连接不走缓存路径
### 28、一个页面从输入 URL 到页面加载显示完成，这个过程中都发生了什么？（流程说的越详细越好）
### 29、DOM事件模型和事件流？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
