# JavaScript最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、event.preventDefault() 和 event.stopPropagation()方法之间有什么区别？

`event.preventDefault()` 方法可防止元素的默认行为。如果在表单元素中使用，它将阻止其提交。如果在锚元素中使用，它将阻止其导航。如果在上下文菜单中使用，它将阻止其显示或显示。`event.stopPropagation()`方法用于阻止捕获和冒泡阶段中当前事件的进一步传播。


### 2、如何清除一个定时器?

window.clearInterval();

window.clearTimeout();


### 3、说说你对promise的了解

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


### 4、手动实现`Array.prototype.reduce`方法

`reduce()` 方法对数组中的每个元素执行一个由您提供的`reducer`函数(升序执行)，将其结果汇总为单个返回值。

```
function reduce(arr, reduceCallback, initialValue) {
  // 首先，检查传递的参数是否正确。
  if (!Array.isArray(arr) || !arr.length || typeof reduceCallback !== 'function') 
  {
    return [];
  } else {
    // 如果没有将initialValue传递给该函数，我们将使用第一个数组项作为initialValue
    let hasInitialValue = initialValue !== undefined;
    let value = hasInitialValue ? initialValue : arr[0];
   、

    // 如果有传递 initialValue，则索引从 1 开始，否则从 0 开始
    for (let i = hasInitialValue ? 0 : 1, len = arr.length; i < len; i++) {
      value = reduceCallback(value, arr[i], i, arr); 
    }
    return value;
  }
}
```


### 5、什么是包装对象（wrapper object）？

我们现在复习一下JS的数据类型，JS数据类型被分为两大类，**基本类型**和**引用类型**。

基本类型：`Undefined`,`Null`,`Boolean`,`Number`,`String`,`Symbol`,`BigInt`

引用类型：`Object`,`Array`,`Date`,`RegExp`等，说白了就是对象。

其中引用类型有方法和属性，但是基本类型是没有的，但我们经常会看到下面的代码：

```
let name = "marko";

console.log(typeof name); // "string"
console.log(name.toUpperCase()); // "MARKO"
```

`name`类型是 `string`，属于基本类型，所以它没有属性和方法，但是在这个例子中，我们调用了一个`toUpperCase()`方法，它不会抛出错误，还返回了对象的变量值。

原因是基本类型的值被临时转换或强制转换为**对象**，因此`name`变量的行为类似于**对象**。除`null`和`undefined`之外的每个基本类型都有自己**包装对象**。也就是：`String`，`Number`，`Boolean`，`Symbol`和`BigInt`。在这种情况下，`name.toUpperCase()`在幕后看起来如下：

`console.log(new String(name).toUpperCase()); // "MARKO"`

在完成访问属性或调用方法之后，新创建的对象将立即被丢弃。


### 6、Ajax原理

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


### 7、JavaScript提供了哪几种“异步模式”？

**1、** 回调函数（callbacks）

**2、** 事件监听

**3、** Promise对象


### 8、什么是 event.currentTarget？？

`event.currentTarget`是我们在其上显式附加事件处理程序的元素。

假设有如下的 HTML 结构：

```
<div onclick="clickFunc(event)" style="text-align: center;margin:15px;
border:1px solid red;border-radius:3px;">
  <div style="margin: 25px; border:1px solid royalblue;border-radius:3px;">
      <div style="margin:25px;border:1px solid skyblue;border-radius:3px;">
        <button style="margin:10px">
           Button
        </button>
      </div>
  </div>
</div>
```

JS 代码如下：

```
function clickFunc(event) {
  console.log(event.currentTarget);
}
```

如果单击 `button`，即使我们单击该 `button`，它也会打印最外面的`div`标签。在此示例中，我们可以得出结论，`event.currentTarget`是附加事件处理程序的元素。


### 9、arguments 的对象是什么？

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


### 10、介绍js的基本数据类型

`Undefined`、`Null`、`Boolean`、`Number`、`String`


### 11、什么是执行上下文和执行栈？
### 12、git 和 svn的区别?
### 13、手动实现 `Array.prototype.map 方法`
### 14、基本数据类型和引用数据类型有什么区别？
### 15、为什么在调用这个函数时，代码中的`b`会变成一个全局变量?
### 16、null，undefined 的区别？
### 17、数组的排序方法（sort）？排序？汉字排序？
### 18、slice() splice()?
### 19、如何添加一个dom对象到body中?innerHTML和innerText区别?
### 20、eval是做什么的？
### 21、JSON 的了解？**
### 22、JavaScript原型，原型链 ? 有什么特点？
### 23、Node的应用场景
### 24、如何创建一个没有 prototype(原型)的对象？
### 25、判断数据类型的方法有哪些？
### 26、attribute和property的区别是什么？
### 27、自执行函数?用于什么场景？好处?
### 28、ECMAScript 是什么？
### 29、js延迟加载的方式有哪些？
### 30、如何改变this指针的指向？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
