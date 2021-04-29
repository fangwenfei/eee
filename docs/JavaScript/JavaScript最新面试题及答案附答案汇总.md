# JavaScript最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、简述下工作流程###

我在之前的公司工作流程大概是这样的：公司定稿会结束以后，会进行简单的技术研讨，然后我们前端会进行先期的技术准备。前端切图人员会进行psd设计稿切图，并且将css文件进行整合。我们主要编写JS部分，其中包括搭建前端框架（大项目），编写js业务和数据持久化操作，我们也会编写js插件并且进行封装方便使用，还有就是编写JS前端组建和JS测试单元，最后将完成的JS部分与切图人员提供的HTML页面进行整合。最后对完成的页面进行功能测试、页面兼容、产品还原。然后对产品进行封存，提交测试。如果出现BUG会返回给我们开发人员进行修改，再提交测试，最后测试成功，进行版本封存。等到程序全部上线的时候进行线上测试。


### 2、JSON 的了解？

JSON(JavaScript Object Notation) 是一种轻量级的数据交换格式。 它是基于JavaScript的一个子集。数据格式简单, 易于读写, 占用带宽小。


### 3、什么是回调函数？

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


### 4、25.Jq如何判断元素显示隐藏？

```
//第一种：使用CSS属性 
var display =$('#id').css('display'); 
if(display == 'none'){    alert("我是隐藏的！"); }
//第二种：使用jquery内置选择器 
<div id="test"<p>仅仅是测试所用</p</div>
if($("#test").is(":hidden")){        $("#test").show();    //如果元素为隐藏,则将它显现 }else{       $("#test").hide();     //如果元素为显现,则将其隐藏 }
//第三种：jQuery判断元素是否显示 是否隐藏
var node=$('#id');
if(node.is(':hidden')){　　//如果node是隐藏的则显示node元素，否则隐藏
　　node.show();　
}else{
　　node.hide();
}
```


### 5、简述一下你理解的面向对象？

面向对象是基于万物皆对象这个哲学观点、把一个对象抽象成类,具体上就是把一个对象的静态特征和动态特征抽象成属性和方法,也就是把一类事物的算法和数据结构封装在一个类之中,程序就是多个对象和互相之间的通信组成的、

面向对象具有封装性,继承性,多态性。

封装:隐蔽了对象内部不需要暴露的细节,使得内部细节的变动跟外界脱离,只依靠接口进行通信.封装性降低了编程的复杂性、通过继承,使得新建一个类变得容易,一个类从派生类那里获得其非私有的方法和公用属性的繁琐工作交给了编译器、而 继承和实现接口和运行时的类型绑定机制 所产生的多态,使得不同的类所产生的对象能够对相同的消息作出不同的反应,极大地提高了代码的通用性、

总之,面向对象的特性提高了大型程序的重用性和可维护性.


### 6、常见web安全及防护原理

**`sql`注入原理**

就是通过把`SQL`命令插入到`Web`表单递交或输入域名或页面请求的查询字符串，最终达到欺骗服务器执行恶意的SQL命令

**总的来说有以下几点**

永远不要信任用户的输入，要对用户的输入进行校验，可以通过正则表达式，或限制长度，对单引号和双`"-"`进行转换等

**1、** 永远不要使用动态拼装SQL，可以使用参数化的`SQL`或者直接使用存储过程进行数据查询存取

**2、** 永远不要使用管理员权限的数据库连接，为每个应用使用单独的权限有限的数据库连接

**3、** 不要把机密信息明文存放，请加密或者`hash`掉密码和敏感的信息

**XSS原理及防范**

`Xss(cross-site scripting)`攻击指的是攻击者往`Web`页面里插入恶意`html`标签或者`javascript`代码。

**比如：**

攻击者在论坛中放一个看似安全的链接，骗取用户点击后，窃取`cookie`中的用户私密信息；或者攻击者在论坛中加一个恶意表单，当用户提交表单的时候，却把信息传送到攻击者的服务器中，而不是用户原本以为的信任站点

**XSS防范方法**

首先代码里对用户输入的地方和变量都需要仔细检查长度和对`”<”,”>”,”;”,”’”`等字符做过滤；其次任何内容写到页面之前都必须加以encode，避免不小心把`html tag` 弄出来。这一个层面做好，至少可以堵住超过一半的XSS 攻击

**XSS与CSRF有什么区别吗？**

**1、** `XSS`是获取信息，不需要提前知道其他用户页面的代码和数据包。`CSRF`是代替用户完成指定的动作，需要知道其他用户页面的代码和数据包。要完成一次`CSRF`攻击，受害者必须依次完成两个步骤

**2、** 登录受信任网站`A`，并在本地生成`Cookie`

**3、** 在不登出`A`的情况下，访问危险网站`B`

**CSRF的防御**

服务端的`CSRF`方式方法很多样，但总的思想都是一致的，就是在客户端页面增加伪随机数

通过验证码的方法


### 7、如何检查对象中是否存在某个属性？

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


### 8、ES6或ECMAScript 2015有哪些新特性？

**1、** 箭头函数

2、类

**3、** 模板字符串

**4、** 加强的对象字面量

**5、** 对象解构

**6、** Promise

**7、** 生成器

8、模块

**9、** Symbol

**10、** 代理

**11、** Set

**12、** 函数默认参数

**13、** rest 和展开

**14、** 块作用域


### 9、什么是默认参数？

默认参数是在 JS 中定义默认变量的一种新方法，它在ES6或ECMAScript 2015版本中可用。

```
//ES5 Version
function add(a,b){
  a = a || 0;
  b = b || 0;
  return a + b;
}

//ES6 Version
function add(a = 0, b = 0){
  return a + b;
}
add(1); // returns 1
```

我们还可以在默认参数中使用解构。

```
function getFirst([first, ...rest] = [0, 1]) {
  return first;
}

getFirst();  // 0
getFirst([10,20,30]);  // 10

function getArr({ nums } = { nums: [1, 2, 3, 4] }){
    return nums;
}

getArr(); // [1, 2, 3, 4]
getArr({nums:[5,4,3,2,1]}); // [5,4,3,2,1]
```

我们还可以使用先定义的参数再定义它们之后的参数。

```
function doSomethingWithValue(value = "Hello World", callback = () => { console.log(value) }) {
  callback();
}
doSomethingWithValue(); //"Hello World"
```


### 10、slice() splice()?

slice() 方法可从已有的数组中返回选定的元素。

splice() 方法向/从数组中添加/删除项目，然后返回被删除的项目。


### 11、开发时如何对项目进行管理?gulp?
### 12、DOM 是什么？
### 13、`var`,`let`和`const`的区别是什么？
### 14、如何判断值是否为数组？
### 15、常见兼容性问题？
### 16、null，undefined 的区别？
### 17、`in` 运算符和 `Object.hasOwnProperty` 方法有什么区别？
### 18、为什么在 JS 中比较两个相似的对象时返回 false？
### 19、Jq中如何实现多库并存?
### 20、简述ajax执行流程
### 21、web开发中会话跟踪的方法有哪些
### 22、JavaScript提供了哪几种“异步模式”？
### 23、如何合并两个数组？数组删除一个元素?
### 24、什么是原型、原型链？
### 25、&& 运算符能做什么
### 26、js的几种继承方式？
### 27、ajax的缺点
### 28、JavaScript原型，原型链 ? 有什么特点？
### 29、与深拷贝有何区别？如何实现？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
