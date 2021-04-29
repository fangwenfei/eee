# JavaScript最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是跨域？怎么解决跨域问题？

跨域问题实际是由同源策略衍生出的一个问题，当传输协议、域名、端口任一部分不一致时，便会产生跨域问题，从而拒绝请求，但`<img src=XXX> <link href=XXX><script src=XXX>`;天然允许跨域加载资源。解决方案有：

**JSONP**

**1、** 原理：利用`<script>`;标签没有跨域限制的漏洞，使得网页可以得到从其他来源动态产生的JSON数据（前提是服务器支持）。

**2、** 优点：实现简单，兼容性好。

**3、** 缺点：仅支持get方法，容易受到XSS攻击。

**CORS**

**1、** 原理：服务器端设`置Access-Control-Allow-Origin`以开启CORS。该属性表示哪些域名可以访问资源，如设置通配符则表示所有网站均可访问。

**2、** 实现实例（express)：

```
//app.js中设置
var app = express();
//CORS跨域-------------------------------------------------------------------------------------
// CORS：设置允许跨域中间件
var allowCrossDomain = function(req, res, next) {
    // 设置允许跨域访问的 URL(* 表示允许任意 URL 访问)
    res.header("Access-Control-Allow-Origin", "*");
    // 设置允许跨域访问的请求头
    res.header("Access-Control-Allow-Headers", "X-Requested-With,Origin,Content-Type,Accept,Authorization");
    // 设置允许跨域访问的请求类型
    res.header("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
    // 设置允许服务器接收 cookie
    res.header('Access-Control-Allow-Credentials', 'true');
    next();
};
app.use(allowCrossDomain);
//------------------------------------------------------------------------------------
```

**Node中间件代理**

原理：同源策略仅是浏览器需要遵循的策略，故搭建中间件服务器转发请求与响应，达到跨域目的。

```
/* server1.js 代理服务器(http://localhost:3000)*/
const http = require('http')
// 第一步：接受客户端请求
const server = http.createServer((request, response) = > {
    // 代理服务器，直接和浏览器直接交互，需要设置CORS 的首部字段
    response.writeHead(200, {
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods': '*',
        'Access-Control-Allow-Headers': 'Content-Type'
    })
    // 第二步：将请求转发给服务器
    const proxyRequest = http.request({
        host: '127.0.0.1',
        port: 4000,
        url: '/',
        method: request.method,
        headers: request.headers
    }, serverResponse = > {
        // 第三步：收到服务器的响应
        var body = ''
        serverResponse.on('data', chunk = > {
            body += chunk
        })
        serverResponse.on('end', () = > {
            console.log('The data is ' + body)
            // 第四步：将响应结果转发给浏览器
            response.end(body)
        })
    }).end()
})
server.listen(3000, () = > {
    console.log('中间件服务器地址： http://localhost:3000')
})
// server2.js(http://localhost:4000)
const http = require("http");
const data = {
    title: "fontend",
    password: "123456"
};
const server = http.createServer((request, response) = > {
    if (request.url === "/") {
        response.end(JSON.stringify(data));
    }
});
server.listen(4000, () = > {
    console.log("The server is running at http://localhost:4000");
});
```

**nginx反向代理**

**1、** 原理：类似Node中间件服务器，通过nginx代理服务器实现。

**2、** 实现方法：下载安装nginx，修改配置。


### 2、有哪些数据类型？

根据 JavaScript 中的变量类型传递方式，分为基本数据类型和引用数据类型两大类七种。

基本数据类型包括Undefined、Null、Boolean、Number、String、Symbol (ES6新增)六种。 引用数据类型只有Object一种，主要包括对象、数组和函数。

**判断数据类型采用`typeof`操作符，有两种语法：**

```
typeof 123;//语法一

const FG = 123;
typeof FG;//语法二

typeof(null) //返回 object;
null == undefined //返回true，因为undefined派生自null;
null === undefined //返回false。
```


### 3、函数fn1 函数fn2 函数fn3，如果想在三个函数都执行完成后执行某一个事件应该如何实现?

```
//1、设置事件监听。
//2、回调函数：
function fn1(){
       console.log("执行fn1");
       fn2();
}
function fn2(){
       console.log("执行fn2");
       fn3();
}
function fn3(){
       console.log("执行fn3");
       mou();
}
function mou(){
       console.log("执行某个函数");
}
fn1();
```


### 4、如何理解同步和异步？

同步：按照代码书写顺序一一执行处理指令的一种模式，上一段代码执行完才能执行下一段代码。

异步：可以理解为一种并行处理的方式，不必等待一个程序执行完，可以执行其它的任务。

JS之所以需要异步的原因在于JS是单线程运行的。常用的异步场景有：定时器、ajax请求、事件绑定。


### 5、'use strict' 是干嘛用的？

`"use strict"` 是 **ES5** 特性，它使我们的代码在函数或整个脚本中处于**严格模式**。**严格模式**帮助我们在代码的早期避免 bug，并为其添加限制。

**严格模式**的一些限制：

**1、** 变量必须声明后再使用

**2、** 函数的参数不能有同名属性，否则报错

**3、** 不能使用`with`语句

**4、** 不能对只读属性赋值，否则报错

**5、** 不能使用前缀 0 表示八进制数，否则报错

**6、** 不能删除不可删除的属性，否则报错

**7、** 不能删除变量`delete prop`，会报错，只能删除属性`delete global[prop]`

**8、** `eval`不能在它的外层作用域引入变量

**9、** `eval`和`arguments`不能被重新赋值

**10、** `arguments`不会自动反映函数参数的变化

**11、** 不能使用`arguments.callee`

**12、** 不能使用`arguments.caller`

**13、** 禁止`this`指向全局对象

**14、** 不能使用`fn.caller`和`fn.arguments`获取函数调用的堆栈

**15、** 增加了保留字（比如`protected`、`static`和`interface`）

设立”严格模式”的目的，主要有以下几个：

**1、** 消除Javascript语法的一些不合理、不严谨之处，减少一些怪异行为;

**2、** 消除代码运行的一些不安全之处，保证代码运行的安全；

**3、** 提高编译器效率，增加运行速度；

**4、** 为未来新版本的Javascript做好铺垫。


### 6、如何检查值是否虚值？

使用 `Boolean` 函数或者 `!!` 运算符。


### 7、同步和异步的区别?

javascript同步表示sync，指：代码依次执行 javascript异步表示async，指：代码执行不按顺序，‘跳过’执行，待其他某些代码执行完后再来执行，成为异步。


### 8、Node的应用场景
### 9、javascript有哪些方法定义对象
### 10、js延迟加载的方式有哪些？
### 11、什么是NaN？以及如何检查值是否为NaN？
### 12、ajax的缺点
### 13、this指向的各种情况都有什么？
### 14、["1", "2", "3"].map(parseInt) 答案是多少？
### 15、如何确保ajax或连接不走缓存路径
### 16、在jq中 mouseover mouseenter mouseout mouseleave 和 hover有什么关联?
### 17、disabled readyonly?
### 18、展开(spread )运算符和 剩余(Rest) 运算符有什么区别？
### 19、编写一个 getElementsByClassName 封装函数?
### 20、基本数据类型和引用数据类型有什么区别？
### 21、闭包
### 22、如何在不使用`%`模运算符的情况下检查一个数字是否是偶数？
### 23、sass和less有什么区别?
### 24、简述下工作流程###
### 25、什么是执行上下文和执行栈？
### 26、|| 运算符能做什么
### 27、一般使用什么版本控制工具?svn如何对文件加锁###
### 28、为什么函数被称为一等公民？
### 29、Jq中get和eq有什么区别？
### 30、说说你对promise的了解




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
