# JavaScript最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、异步加载JS的方式有哪些？

defer，只支持`IE`

`async`：

创建`script`，插入到`DOM`中，加载完毕后`callBack`


### 2、什么是箭头函数？

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


### 3、Gc机制是什么？为什么闭包不会被回收变量和函数？

**1、** Gc垃圾回收机制;

**2、** 外部变量没释放，所以指向的大函数内的小函数也释放不了


### 4、JavaScript有几种类型的值？，你能画一下他们的内存图吗？

**1、** 栈：原始数据类型（`Undefined`，`Null`，`Boolean`，`Numbe`r、`String`）

**2、** 堆：引用数据类型（对象、数组和函数）

**3、** 两种类型的区别是：存储位置不同；

**4、** 原始数据类型直接存储在栈(`stack`)中的简单数据段，占据空间小、大小固定，属于被频繁使用数据，所以放入栈中存储；

**5、** 引用数据类型存储在堆(`heap`)中的对象,占据空间大、大小不固定,如果存储在栈中，将会影响程序运行的性能；引用数据类型在栈中存储了指针，该指针指向堆中该实体的起始地址。当解释器寻找引用值时，会首先检索其

**6、** 在栈中的地址，取得地址后从堆中获得实体

![33_1.png][33_1.png]


### 5、!! 运算符能做什么？

`!!`运算符可以将右侧的值强制转换为布尔值，这也是将值转换为布尔值的一种简单方法。

```
console.log(!!null); // false
console.log(!!undefined); // false
console.log(!!''); // false
console.log(!!0); // false
console.log(!!NaN); // false
console.log(!!' '); // true
console.log(!!{}); // true
console.log(!![]); // true
console.log(!!1); // true
console.log(!![].length); // false
```


### 6、简述下你理解的面向对象？

万物皆对象，把一个对象抽象成类,具体上就是把一个对象的静态特征和动态特征抽象成属性和方法,也就是把一类事物的算法和数据结构封装在一个类之中,程序就是多个对象和互相之间的通信组成的、

面向对象具有封装性,继承性,多态性。

封装:隐蔽了对象内部不需要暴露的细节,使得内部细节的变动跟外界脱离,只依靠接口进行通信.封装性降低了编程的复杂性、通过继承,使得新建一个类变得容易,一个类从派生类那里获得其非私有的方法和公用属性的繁琐工作交给了编译器、而继承和实现接口和运行时的类型绑定机制 所产生的多态,使得不同的类所产生的对象能够对相同的消息作出不同的反应,极大地提高了代码的通用性、

总之,面向对象的特性提高了大型程序的重用性和可维护性.


### 7、如何合并两个数组？数组删除一个元素?

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


### 8、为什么要有同源限制？
### 9、除了jsonp 还有什么跨域方式###
### 10、什么是闭包? 堆栈溢出有什么区别？ 内存泄漏? 那些操作会造成内存泄漏？怎么样防止内存泄漏？
### 11、DOM事件模型和事件流？
### 12、常见兼容性问题？
### 13、用过哪些设计模式？
### 14、ajax 和 jsonp ？
### 15、作用域和执行上下文的区别是什么？
### 16、何为防抖和节流？如何实现？
### 17、js延迟加载的方式有哪些？
### 18、谈谈你对AMD、CMD的理解
### 19、jsonp原理？ 缺点?
### 20、this是什么 在不同场景中分别代表什么###
### 21、如何创建一个对象？
### 22、为什么在 JS 中比较两个相似的对象时返回 false？
### 23、attribute和property的区别是什么？
### 24、如何添加一个dom对象到body中?innerHTML和innerText区别?
### 25、什么是闭包？
### 26、什么是 `async/await` 及其如何工作？
### 27、异步加载的方式有哪些？
### 28、手动实现缓存方法
### 29、简述ajax执行流程




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
