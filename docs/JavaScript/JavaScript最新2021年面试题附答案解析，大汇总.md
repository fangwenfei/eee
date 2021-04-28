# JavaScript最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、Promise 是什么？

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


### 2、自执行函数?用于什么场景？好处?

**自执行函数:**

**1、** 声明一个匿名函数

**2、** 马上调用这个匿名函数。

作用：创建一个独立的作用域。

**好处：**

防止变量弥散到全局，以免各种js库冲突。隔离作用域避免污染，或者截断作用域链，避免闭包造成引用变量无法释放。利用立即执行特性，返回需要的业务函数或对象，避免每次通过条件判断来处理

场景：一般用于框架、插件等场景


### 3、Function.prototype.apply 方法的用途是什么？

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


### 4、如何合并两个数组？数组删除一个元素?

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


### 5、如何在一行中计算多个表达式的值？

可以使用`逗号`运算符在一行中计算多个表达式。它从左到右求值，并返回右边最后一个项目或最后一个操作数的值。

```
let x = 5;

x = (x++ , x = addFive(x), x *= 2, x -= 5, x += 10);

function addFive(num) {
  return num + 5;
}
```

上面的结果最后得到`x`的值为`27`。首先，我们将`x`的值增加到`6`，然后调用函数`addFive(6)`并将`6`作为参数传递并将结果重新分配给`x`，此时`x`的值为`11`。之后，将`x`的当前值乘以`2`并将其分配给`x`，`x`的更新值为`22`。然后，将`x`的当前值减去`5`并将结果分配给`x` `x`更新后的值为`17`。最后，我们将`x`的值增加`10`，然后将更新的值分配给`x`，最终`x`的值为`27`。


### 6、说说严格模式的限制

**1、** 变量必须声明后再使用

**2、** 函数的参数不能有同名属性，否则报错

**3、** 不能使用`with`语句

**4、** 禁止`this`指向全局对象


### 7、什么是回调函数？

**回调函数**是一段可执行的代码段，它作为一个参数传递给其他的代码，其作用是在需要的时候方便调用这段（回调函数）代码。

在JavaScript中函数也是对象的一种，同样对象可以作为参数传递给函数，因此函数也可以作为参数传递给另外一个函数，这个作为参数的函数就是回调函数。

```
const btnAdd = document.getElementById('btnAdd');

btnAdd.addEventListener('click', function clickCallback(e) {
    // do something useless
});
```

在本例中，我们等待`id`为`btnAdd`的元素中的`click`事件，如果它被单击，则执行`clickCallback`函数。回调函数向某些数据或事件添加一些功能。

数组中的`reduce`、`filter`和`map`方法需要一个回调作为参数。回调的一个很好的类比是，当你打电话给某人，如果他们不接，你留下一条消息，你期待他们回调。调用某人或留下消息的行为是事件或数据，回调是你希望稍后发生的操作。


### 8、XML和JSON的区别？

**数据体积方面**

`JSON`相对`于XML`来讲，数据的体积小，传递的速度更快些。

**数据交互方面**

`JSON`与`JavaScript`的交互更加方便，更容易解析处理，更好的数据交互

**数据描述方面**

`JSON`对数据的描述性比`XML`较差

**传输速度方面**

`JSON`的速度要远远快于`XML`


### 9、call和apply 有什么好处？

用call和apply:实现更好的继承和扩展，更安全。


### 10、什么是缓存及它有什么作用？

缓存是建立一个函数的过程，这个函数能够记住之前计算的结果或值。使用缓存函数是为了避免在最后一次使用相同参数的计算中已经执行的函数的计算。这节省了时间，但也有不利的一面，即我们将消耗更多的内存来保存以前的结果。


### 11、说说你对AMD和Commonjs的理解
### 12、什么是移动端的300ms延迟？什么是点击穿透？解决方案?
### 13、null，undefined 的区别？
### 14、展开(spread )运算符和 剩余(Rest) 运算符有什么区别？
### 15、你对数据校验是怎么样处理的？jquery.validate？
### 16、如何在 JS 中创建对象？
### 17、25.Jq如何判断元素显示隐藏？
### 18、什么是原型、原型链？
### 19、什么是 ES6 模块？
### 20、什么是事件捕获？
### 21、如何清除一个定时器?
### 22、那些操作会造成内存泄漏？
### 23、什么是提升？
### 24、在jq中 mouseover mouseenter mouseout mouseleave 和 hover有什么关联?
### 25、ajax 是什么?
### 26、**
### 27、Jq中有几种选择器?分别是什么?
### 28、Object.seal 和 Object.freeze 方法之间有什么区别？
### 29、什么是箭头函数？
### 30、简述下工作流程###




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
