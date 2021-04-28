# JavaScript最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、git 和 svn的区别?

SVN是集中式版本控制系统，版本库是集中放在中央服务器的，而干活的时候，用的都是自己的电脑，所以首先要从中央服务器哪里得到最新的版本，然后干活，干完后，需要把自己做完的活推送到中央服务器。集中式版本控制系统是必须联网才能工作，如果在局域网还可以，带宽够大，速度够快，如果在互联网下，如果网速慢的话，就纳闷了。

Git是分布式版本控制系统，那么它就没有中央服务器的，每个人的电脑就是一个完整的版本库，这样，工作的时候就不需要联网了，因为版本都是在自己的电脑上。既然每个人的电脑都有一个完整的版本库，那多个人如何协作呢？比如说自己在电脑上改了文件A，其他人也在电脑上改了文件A，这时，你们两之间只需把各自的修改推送给对方，就可以互相看到对方的修改了。


### 2、判断数据类型

**1、** typeof返回的类型都是字符串形式，可以判断function的类型；在判断除Object类型的对象时比较方便。

**2、** 判断已知对象类型的方法： instanceof，后面一定要是对象类型，并且大小写不能错，该方法适合一些条件选择或分支。


### 3、常见兼容性问题？

**1、** `png24`位的图片在iE6浏览器上出现背景，解决方案是做成`PNG8`

**2、** 浏览器默认的`margin`和`padding`不同。解决方案是加一个全局的`*{margin:0;padding:0;}`来统一,，但是全局效率很低，一般是如下这样解决：

```
body,ul,li,ol,dl,dt,dd,form,input,h1,h2,h3,h4,h5,h6,p{
    margin:0;
    padding:0;
}
```

`IE`下,`event`对象有`x`,`y`属性,但是没有`pageX`,`pageY`属性

`Firefox`下,`event`对象有`pageX`,`pageY`属性,但是没有`x,y`属性.


### 4、你有哪些性能优化的方法？

**1、** 减少http请求次数：CSS Sprites, JS、CSS源码压缩、图片大小控制合适；网页Gzip， CDN托管，data缓存 ，图片服务器。

**2、** 前端模板 JS+数据，减少由于HTML标签导致的带宽浪费，前端用变量保存AJAX请求结果，每次操作本地变量，不用请求，减少请求次数

**3、** 用innerHTML代替DOM操作，减少DOM操作次数，优化javascript性能。

**4、** 当需要设置的样式很多时设置className而不是直接操作style。

**5、** 少用全局变量、缓存DOM节点查找的结果。减少IO读取操作。

**6、** 避免使用CSS Expression（css表达式)又称Dynamic properties(动态属性)。

**7、** 图片预加载，将样式表放在顶部，将脚本放在底部 加上时间戳。

**8、** 避免在页面的主体布局中使用table，table要等其中的内容完全下载之后才会显示出来，显示比div+css布局慢。


### 5、Gc机制是什么？为什么闭包不会被回收变量和函数？

**1、** Gc垃圾回收机制;

**2、** 外部变量没释放，所以指向的大函数内的小函数也释放不了


### 6、什么是箭头函数？

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


### 7、基本数据类型和引用数据类型有什么区别？

**两者作为函数的参数进行传递时：**

**1、** 基本数据类型传入的是数据的副本，原数据的更改不会影响传入后的数据。

**2、** 引用数据类型传入的是数据的引用地址，原数据的更改会影响传入后的数据。

**两者在内存中的存储位置：**

**1、** 基本数据类型存储在栈中。

**2、** 引用数据类型在栈中存储了指针，该指针指向的数据实体存储在堆中。


### 8、同步异步?

**1、** 进程同步：就是在发出一个功能调用时，在没有得到结果之前，该调用就不返回。也就是必须一件一件事做,等前一件做完了才能做下一件事

**2、** 异步的概念和同步相对。当一个异步过程调用发出后，调用者不能立刻得到结果。实际处理这个调用的部件在完成后，通过状态、通知和回调来通知调用者。


### 9、与深拷贝有何区别？如何实现？

**浅拷贝只复制指向某个对象的指针，而不复制对象本身。浅拷贝的实现方式有：**

**1、** `Object.assign()`：需注意的是目标对象只有一层的时候，是深拷贝；

**2、** 扩展运算符；

**深拷贝就是在拷贝数据的时候，将数据的所有引用结构都拷贝一份。深拷贝的实现方式有：**

**1、** 手写遍历递归赋值；

**2、** 结合使用`JSON.parse()`和`JSON.stringify()`方法。


### 10、ajax 和 jsonp ？

**ajax和jsonp的区别：**

相同点：都是请求一个url

不同点：ajax的核心是通过xmlHttpRequest获取内容

jsonp的核心则是动态添加



### 11、事件模型
### 12、attribute和property的区别是什么？
### 13、说说你对AMD和Commonjs的理解
### 14、$$('div+.ab')和$$('.ab+div') 哪个效率高？
### 15、数据持久化技术(ajax)?简述ajax流程###
### 16、如何对登录的账号密码进行加密?
### 17、Javascript如何实现继承？
### 18、`var`,`let`和`const`的区别是什么？
### 19、promise###
### 20、什么是跨域？怎么解决跨域问题？
### 21、简述一下你理解的面向对象？
### 22、JS是如何实现异步的？
### 23、什么是默认参数？
### 24、你对数据校验是怎么样处理的？jquery.validate？
### 25、!! 运算符能做什么？
### 26、编写一个 getElementsByClassName 封装函数?
### 27、谁是c的构造函数?
### 28、谈谈你对AMD、CMD的理解
### 29、ajax请求方式有几种（8种）？
### 30、什么是 event.currentTarget？？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
