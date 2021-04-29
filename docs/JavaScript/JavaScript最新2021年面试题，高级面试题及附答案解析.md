# JavaScript最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是 event.target ？

简单来说，`event.target`是发生事件的元素或触发事件的元素。

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
  console.log(event.target);
}
```

如果单击 `button`，即使我们将事件附加在最外面的`div`上，它也将打印 `button` 标签，因此我们可以得出结论`event.target`是触发事件的元素。


### 2、如何在 JS 中创建对象？

**使用对象字面量：**

```
const o = {
  name: "kyle",
  greeting() {
    return `Hi, 我是${this.name}`;
  }
};

o.greeting(); // "Hi, 我是kyle"
```

**使用构造函数：**

```
function Person(name) {
   this.name = name;
}

Person.prototype.greeting = function () {
   return `Hi, 我是${this.name}`;
}

const mark = new Person("kyle");

mark.greeting(); // "Hi, 我是kyle"
```

**使用 Object.create 方法：**

```
const n = {
   greeting() {
      return `Hi, 我是${this.name}`;
   }
};

const o = Object.create(n); 
o.name = "kyle";
```


### 3、什么是执行上下文和执行栈？

变量或函数的执行上下文，决定了它们的行为以及可以访问哪些数据。每个上下文都有一个关联的变量对象，而这个上下文中定义的所有变量和函数都存在于这个对象上(如DOM中全局上下文关联的便是`window`对象)。

每个函数调用都有自己的上下文。当代码执行流进入函数时，函数的上下文被推到一个执行栈中。在函数执行完之后，执行栈会弹出该函数上下文，在其上的所有变量和函数都会被销毁，并将控制权返还给之前的执行上下文。 JS的执行流就是通过这个执行栈进行控制的。


### 4、call & apply 两者之间的区别###

call和apply都是改变this指向的方法，区别在于call可以写多个参数，而apply只能写两个参数，第二个参数是一个数组，用于存放要传的参数。


### 5、["1", "2", "3"].map(parseInt) 答案是多少？

`[1, NaN, NaN]`因为 `parseInt` 需要两个参数 `(val, radix)`，其中`radix` 表示解析时用的基数。

`map`传了 `3`个`(element, index, array)`，对应的 `radix` 不合法导致解析失败。


### 6、attribute和property的区别是什么？

**1、** `attribute`是`dom`元素在文档中作为`html`标签拥有的属性；

**2、** `property`就是`dom`元素在`js`中作为对象拥有的属性。

**3、** 对于`html`的标准属性来说，`attribute`和`property`是同步的，是会自动更新的

**4、** 但是对于自定义的属性来说，他们是不同步的


### 7、异步加载的方式有哪些？

(1) defer，只支持IE

(2) async：true

(3) 创建script，插入到DOM中，加载完毕后callBack


### 8、ajax 和 jsonp ？

**ajax和jsonp的区别：**

相同点：都是请求一个url

不同点：ajax的核心是通过xmlHttpRequest获取内容

jsonp的核心则是动态添加



### 9、什么是箭头函数？

箭头函数表达式的语法比函数表达式更简洁，并且没有自己的`this`，`arguments`，`super`或`new.target`。箭头函数表达式更适用于那些本来需要匿名函数的地方，并且它不能用作构造函数。

```
//ES5 Version
var getCurrentDate = function (){
  return new Date();
}

//ES6 Version
const getCurrentDate = () => new Date();
```

在本例中，ES5 版本中有`function(){}`声明和`return`关键字，这两个关键字分别是创建函数和返回值所需要的。在箭头函数版本中，我们只需要`()`括号，不需要 `return` 语句，因为如果我们只有一个表达式或值需要返回，箭头函数就会有一个隐式的返回。

```
//ES5 Version
function greet(name) {
  return 'Hello ' + name + '!';
}

//ES6 Version
const greet = (name) => `Hello ${name}`;
const greet2 = name => `Hello ${name}`;
```

我们还可以在箭头函数中使用与函数表达式和函数声明相同的参数。如果我们在一个箭头函数中有一个参数，则可以省略括号。

`const getArgs = () => arguments const getArgs2 = (...rest) => rest`

箭头函数不能访问`arguments`对象。所以调用第一个`getArgs`函数会抛出一个错误。相反，我们可以使用**rest**参数来获得在箭头函数中传递的所有参数。

```
const data = {
  result: 0,
  nums: [1, 2, 3, 4, 5],
  computeResult() {
    // 这里的“this”指的是“data”对象
    const addAll = () => {
      return this.nums.reduce((total, cur) => total + cur, 0)
    };
    this.result = addAll();
  }
};
```

箭头函数没有自己的`this`值。它捕获词法作用域函数的`this`值，在此示例中，`addAll`函数将复制`computeResult` 方法中的`this`值，如果我们在全局作用域声明箭头函数，则`this`值为 `window` 对象。


### 10、谁是c的构造函数?

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


### 11、`require`/`import`之间的区别？
### 12、ECMAScript 是什么？
### 13、函数fn1 函数fn2 函数fn3，如果想在三个函数都执行完成后执行某一个事件应该如何实现?
### 14、手动实现 `Array.prototype.map 方法`
### 15、new 关键字有什么作用？
### 16、在jq中 mouseover mouseenter mouseout mouseleave 和 hover有什么关联?
### 17、压缩合并目的？http请求的优化方式？
### 18、什么是AJAX？如何实现？
### 19、那些操作会造成内存泄漏？
### 20、什么是闭包？
### 21、offsetWidth/offsetHeight,clientWidth/clientHeight与scrollWidth/scrollHeight的区别
### 22、== 和 === 有什么区别？
### 23、如何理解同步和异步？
### 24、什么是对象解构？
### 25、谈谈你对webpack的看法
### 26、如何创建一个没有 prototype(原型)的对象？
### 27、call和apply 有什么好处？
### 28、ajax请求方式有几种（8种）？
### 29、Node的应用场景
### 30、调用函数，可以使用哪些方法？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
