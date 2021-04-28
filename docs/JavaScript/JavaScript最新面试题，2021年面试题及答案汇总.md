# JavaScript最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、平时工作中怎么样进行数据交互?如果后台没有提供数据怎么样进行开发?

**mock数据与后台返回的格式不同意怎么办?**

由后台编写接口文档、提供数据接口实、前台通过ajax访问实现数据交互；

在没有数据的情况下寻找后台提供静态数据或者自己定义mock数据；

返回数据不统一时编写映射文件 对数据进行映射。


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


### 3、disabled readyonly?

readonly只针对input(text / password)和textarea有效，而disabled对于所有的表单元素都有效，当表单元素在使用了disabled后，当我们将表单以POST或GET的方式提交的话，这个元素的值不会被传递出去，而readonly会将该值传递出去。


### 4、声明函数作用提升?声明变量和声明函数的提升有什么区别

**变量声明提升：**

**1、** 变量申明在进入执行上下文就完成了。

**2、** 只要变量在代码中进行了声明，无论它在哪个位置上进行声明， js引擎都会将它的声明放在范围作用域的顶部；

**函数声明提升
### 5、`require`/`import`之间的区别？

**1、** `require`是CommonJS语法，`import`是ES6语法；

**2、** `require`只在后端服务器支持，`import`在高版本浏览器及Node中都可以支持；

**3、** `require`引入的是原始导出值的复制，`import`则是导出值的引用；

**4、** `require`时运行时动态加载，`import`是静态编译；

**5、** `require`调用时默认不是严格模式，`import`则默认调用严格模式.

### 6、new 关键字有什么作用？

`new`关键字与构造函数一起使用以创建对象:

```
function Employee(name, position, yearHired) {
  this.name = name;
  this.position = position;
  this.yearHired = yearHired;
};

const emp = new Employee("Marko Polo", "Software Developer", 2017);
```

`new`关键字做了`4`件事:

**1、** 创建空对象 `{}`

**2、** 将空对象分配给 `this` 值

**3、** 将空对象的`__proto__`指向构造函数的`prototype`

**4、** 如果没有使用显式`return`语句，则返回`this`

看下面事例：

`function Person() { this.name = 'kyle' }`

根据上面描述的，`new Person()`做了：

**1、** 创建一个空对象：`var obj = {}`

**2、** 将空对象分配给 `this` 值：this = obj

**3、** 将空对象的`__proto__`指向构造函数的`prototype`:`this.__proto__ = Person().prototype`

**4、** 返回`this`:`return this`



### 7、如何在 JS 中创建对象？

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


### 8、异步编程？

**方法1：**

**1、** 回调函数，优点是简单、容易理解和部署，缺点是不利于代码的阅读和维护，各个部分之间高度耦合（Coupling），流程会很混乱，而且每个任务只能指定一个回调函数。

**方法2：**

**1、** 时间监听，可以绑定多个事件，每个事件可以指定多个回调函数，而且可以“去耦合”（Decoupling），有利于实现模块化。缺点是整个程序都要变成事件驱动型，运行流程会变得很不清晰。

**方法3：**

发布/订阅，性质与“事件监听”类似，但是明显优于后者。

**方法4：**

**1、** Promises对象，是CommonJS工作组提出的一种规范，目的是为异步编程提供统一接口。

**2、** 简单说，它的思想是，每一个异步任务返回一个Promise对象，该对象有一个then方法，允许指定回调函数。


### 9、上一个项目是什么？主要负责哪些？购物车流程?支付功能?

**主要负责哪些就讲主要做哪些功能模块：**

1）商品模块:

**1、** 商品列表：商品排序 商品筛选 商品过滤 商品查询 商品推荐

**2、** 商品详情:类型推荐 商品简介 商品详情 商品评价 售后维护

2)购物车模块：商品编号、数量、价格、总额、运费、运输选项、运费总计、从购物车删除选项、更新数量、结账、继续购物、商品描述、库存信息


### 10、promise###

Promise的构造函数接收一个参数，是函数，并且传入两个参数：resolve，reject，分别表示异步操作执行成功后的回调函数和异步操作执行失败后的回调函数。


### 11、常见兼容性问题？
### 12、sass和less有什么区别?
### 13、["1", "2", "3"].map(parseInt) 答案是多少？
### 14、什么是闭包? 堆栈溢出有什么区别？ 内存泄漏? 那些操作会造成内存泄漏？怎么样防止内存泄漏？
### 15、一般使用什么版本控制工具?svn如何对文件加锁###
### 16、用过哪些设计模式？
### 17、简述一下你理解的面向对象？
### 18、如何对登录的账号密码进行加密?
### 19、什么是移动端的300ms延迟？什么是点击穿透？解决方案?
### 20、简述下你理解的面向对象？
### 21、什么是AJAX？如何实现？
### 22、如何检查值是否虚值？
### 23、什么是预编译语音|预编译处理器?
### 24、什么是 `async/await` 及其如何工作？
### 25、defer和async
### 26、什么是执行上下文和执行栈？
### 27、26.移动端上什么是点击穿透?
### 28、什么是`Set`对象，它是如何工作的？
### 29、异步加载JS的方式有哪些？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
