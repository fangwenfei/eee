# JavaScript最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、ECMAScript 是什么？

ECMAScript 是编写脚本语言的标准，这意味着JavaScript遵循ECMAScript标准中的规范变化，因为它是JavaScript的蓝图。

ECMAScript 和 Javascript，本质上都跟一门语言有关，一个是语言本身的名字，一个是语言的约束条件 只不过发明JavaScript的那个人（Netscape公司），把东西交给了ECMA（European Computer Manufacturers Association），这个人规定一下他的标准，因为当时有java语言了，又想强调这个东西是让ECMA这个人定的规则，所以就这样一个神奇的东西诞生了，这个东西的名称就叫做ECMAScript。

javaScript = ECMAScript + DOM + BOM（自认为是一种广义的JavaScript）

ECMAScript说什么JavaScript就得做什么！

JavaScript（狭义的JavaScript）做什么都要问问ECMAScript我能不能这样干！如果不能我就错了！能我就是对的！

——突然感觉JavaScript好没有尊严，为啥要搞个人出来约束自己，

那个人被创造出来也好委屈，自己被创造出来完全是因为要约束JavaScript。


### 2、什么是回调函数？

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


### 3、如何检查对象中是否存在某个属性？

检查对象中是否存在属性有三种方法。

第一种使用 `in` 操作符号：

```
const o = { 
  "prop" : "bwahahah",
  "prop2" : "hweasa"
};

console.log("prop" in o); // true
console.log("prop1" in o); // false
```

第二种使用 `hasOwnProperty` 方法，`hasOwnProperty()` 方法会返回一个布尔值，指示对象自身属性中是否具有指定的属性（也就是，是否有指定的键）。

```
console.log(o.hasOwnProperty("prop2")); // true
console.log(o.hasOwnProperty("prop1")); // false
```

第三种使用括号符号`obj["prop"]`。如果属性存在，它将返回该属性的值，否则将返回`undefined`。

`console.log(o["prop"]); // "bwahahah" console.log(o["prop1"]); // undefined`


### 4、什么是模板字符串？

模板字符串是在 JS 中创建字符串的一种新方法。我们可以通过使用反引号使模板字符串化。

```
//ES5 Version
var greet = 'Hi I\'m Mark';

//ES6 Version
let greet = `Hi I'm Mark`;
```

在 ES5 中我们需要使用一些转义字符来达到多行的效果，在模板字符串不需要这么麻烦：

```
//ES5 Version
var lastWords = '\n'
  + '   I  \n'
  + '   Am  \n'
  + 'Iron Man \n';

//ES6 Version
let lastWords = `
    I
    Am
  Iron Man   
`;
```

在ES5版本中，我们需要添加`\n`以在字符串中添加新行。在模板字符串中，我们不需要这样做。

```
//ES5 Version
function greet(name) {
  return 'Hello ' + name + '!';
}

//ES6 Version
function greet(name) {
  return `Hello ${name} !`;
}
```

在 ES5 版本中，如果需要在字符串中添加表达式或值，则需要使用`+`运算符。在模板字符串s中，我们可以使用`${expr}`嵌入一个表达式，这使其比 ES5 版本更整洁。


### 5、Function.prototype.apply 和 Function.prototype.call 之间有什么区别？

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


### 6、说几条写JavaScript的基本规范？

**1、** 不要在同一行声明多个变量

**2、** 请使用`===/!==`来比较`true/false`或者数值

**3、** 使用对象字面量替代`new Array`这种形式

**4、** 不要使用全局函数

**5、** `Switch`语句必须带有`default`分支

**6、** `If`语句必须使用大括号

**7、** `for-in`循环中的变量 应该使用`var`关键字明确限定作用域，从而避免作用域污


### 7、Jq绑定事件的几种方式？on bind ?

**1、** jQuery中提供了四种事件监听方式，分别是bind、live、delegate、on，对应的解除监听的函数分别是unbind、die、undelegate、off

**2、** Bind( )是使用频率较高的一种，作用就是在选择到的元素上绑定特定事件类型的监听函数;

**3、** Live( )可以对后生成的元素也可以绑定相应的事件,处理机制就是把事件绑定在DOM树的根节点上，而不是直接绑定在某个元素上;

**4、** Delegate( )采用了事件委托的概念，不是直接为子元素绑定事件，而是为其父元素（或祖先元素也可）绑定事件，当在div内任意元素上点击时，事件会一层层从event target向上冒泡，直至到达你为其绑定事件的元素；

**5、** on( )方法可以绑定动态添加到页面元素的事件，on()方法绑定事件可以提升效率；


### 8、26.移动端上什么是点击穿透?
### 9、如何解决跨域问题?
### 10、开发时如何对项目进行管理?gulp?
### 11、什么是 event.currentTarget？？
### 12、ajax 是什么?
### 13、为什么此代码 `obj.someprop.x` 会引发错误?
### 14、节点类型?判断当前节点类型?
### 15、jQuery与jQuery UI 有啥区别？
### 16、压缩合并目的？http请求的优化方式？
### 17、JS是如何实现异步的？
### 18、你有哪些性能优化的方法？
### 19、null，undefined 的区别？
### 20、那些操作会造成内存泄漏？
### 21、说说严格模式的限制
### 22、什么是构造函数？与普通函数有什么区别?
### 23、怎么理解宏任务，微任务？？？
### 24、如何在一行中计算多个表达式的值？
### 25、说出几个http协议状态码?
### 26、EventLoop事件循环是什么？
### 27、什么是预编译语音|预编译处理器?
### 28、调用函数，可以使用哪些方法？
### 29、什么是作用域？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
