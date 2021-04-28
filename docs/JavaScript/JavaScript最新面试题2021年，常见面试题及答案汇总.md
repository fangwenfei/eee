# JavaScript最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、什么是 `async/await` 及其如何工作？

`async/await`是 JS 中编写异步或非阻塞代码的新方法。它建立在**Promises**之上，让异步代码的可读性和简洁度都更高。

`async/await`是 JS 中编写异步或非阻塞代码的新方法。它建立在`Promises`之上，相对于 Promise 和回调，它的可读性和简洁度都更高。但是，在使用此功能之前，我们必须先学习`Promises`的基础知识，因为正如我之前所说，它是基于`Promise`构建的，这意味着幕后使用仍然是**Promise**。

**使用 Promise**

```
function callApi() {
  return fetch("url/to/api/endpoint")
    .then(resp => resp.json())
    .then(data => {
      //do something with "data"
    }).catch(err => {
      //do something with "err"
    });
}
```

**使用async/await**

在`async/await`，我们使用 tru/catch 语法来捕获异常。

```
async function callApi() {
 try {
   const resp = await fetch("url/to/api/endpoint");
   const data = await resp.json();
   //do something with "data"
 } catch (e) {
   //do something with "err"
 }
}
```

**注意**:使用 `async`关键声明函数会隐式返回一个**Promise**。

```
const giveMeOne = async () => 1;
giveMeOne()
  .then((num) => {
    console.log(num); // logs 1
  });
```

**注意:**`await`关键字只能在`async function`中使用。在任何非**async function**的函数中使用`await`关键字都会抛出错误。`await`关键字在执行下一行代码之前等待右侧表达式(可能是一个**Promise**)返回。

```
const giveMeOne = async () => 1;

function getOne() {
  try {
    const num = await giveMeOne();
    console.log(num);
  } catch (e) {
    console.log(e);
  }
}

// Uncaught SyntaxError: await is only valid in async function

async function getTwo() {
  try {
    const num1 = await giveMeOne(); // 这行会等待右侧表达式执行完成
    const num2 = await giveMeOne(); 
    return num1 + num2;
  } catch (e) {
    console.log(e);
  }
}

await getTwo(); // 2
```


### 2、ECMAScript 是什么？

ECMAScript 是编写脚本语言的标准，这意味着JavaScript遵循ECMAScript标准中的规范变化，因为它是JavaScript的蓝图。

ECMAScript 和 Javascript，本质上都跟一门语言有关，一个是语言本身的名字，一个是语言的约束条件 只不过发明JavaScript的那个人（Netscape公司），把东西交给了ECMA（European Computer Manufacturers Association），这个人规定一下他的标准，因为当时有java语言了，又想强调这个东西是让ECMA这个人定的规则，所以就这样一个神奇的东西诞生了，这个东西的名称就叫做ECMAScript。

javaScript = ECMAScript + DOM + BOM（自认为是一种广义的JavaScript）

ECMAScript说什么JavaScript就得做什么！

JavaScript（狭义的JavaScript）做什么都要问问ECMAScript我能不能这样干！如果不能我就错了！能我就是对的！

——突然感觉JavaScript好没有尊严，为啥要搞个人出来约束自己，

那个人被创造出来也好委屈，自己被创造出来完全是因为要约束JavaScript。


### 3、手动实现`Array.prototype.filter`方法

`filter()` 方法创建一个新数组, 其包含通过所提供函数实现的测试的所有元素。

```
function filter(arr, filterCallback) {
  // 首先，检查传递的参数是否正确。
  if (!Array.isArray(arr) || !arr.length || typeof filterCallback !== 'function') 
  {
    return [];
  } else {
    let result = [];
     // 每次调用此函数时，我们都会创建一个 result 数组
     // 因为我们不想改变原始数组。
    for (let i = 0, len = arr.length; i < len; i++) {
      // 检查 filterCallback 的返回值是否是真值
      if (filterCallback(arr[i], i, arr)) { 
      // 如果条件为真，则将数组元素 push 到 result 中
        result.push(arr[i]);
      }
    }
    return result; // return the result array
  }
}
```


### 4、介绍js有哪些内置对象？

**1、** `Object` 是 `JavaScript` 中所有对象的父对象

**2、** 数据封装类对象：`Object`、`Array`、`Boolean`、`Number` 和 `String`

**3、** 其他对象：`Function`、`Arguments`、`Math`、`Date`、`RegExp`、`Error`


### 5、手动实现缓存方法

```
function memoize(fn) {
  const cache = {};
  return function (param) {
    if (cache[param]) {
      console.log('cached');
      return cache[param];
    } else {
      let result = fn(param);
      cache[param] = result;
      console.log(`not cached`);
      return result;
    }
  }
}

const toUpper = (str ="")=> str.toUpperCase();

const toUpperMemoized = memoize(toUpper);

toUpperMemoized("abcdef");
toUpperMemoized("abcdef");
```

这个缓存函数适用于接受一个参数。我们需要改变下，让它接受多个参数。

```
const slice = Array.prototype.slice;
function memoize(fn) {
  const cache = {};
  return (...args) => {
    const params = slice.call(args);
    console.log(params);
    if (cache[params]) {
      console.log('cached');
      return cache[params];
    } else {
      let result = fn(...args);
      cache[params] = result;
      console.log(`not cached`);
      return result;
    }
  }
}
const makeFullName = (fName, lName) => `${fName} ${lName}`;
const reduceAdd = (numbers, startingValue = 0) => numbers.reduce((total, cur) => total + cur, startingValue);

const memoizedMakeFullName = memoize(makeFullName);
const memoizedReduceAdd = memoize(reduceAdd);

memoizedMakeFullName("Marko", "Polo");
memoizedMakeFullName("Marko", "Polo");

memoizedReduceAdd([1, 2, 3, 4, 5], 5);
memoizedReduceAdd([1, 2, 3, 4, 5], 5);
```


### 6、作用域和执行上下文的区别是什么？

**1、** 函数的执行上下文只在函数被调用时生成，而其作用域在创建时已经生成；

**2、** 函数的作用域会包含若干个执行上下文(有可能是零个，当函数未被调用时)。


### 7、ajax请求方式有几种（8种）？

1）$$.get(url,\[data\],\[callback\])  
2）$$.getJSON(url,[data],[callback])

3）$$.post(url,\[data\],\[callback\],\[type\])  
4）$$.ajax(opiton)

5）$.getScript( url, [callback] )

6）jquery对象.load( url, [data], [callback] )

7）serialize() 与 serializeArray()


### 8、为什么函数被称为一等公民？

在JavaScript中，函数不仅拥有一切传统函数的使用方式（声明和调用），而且可以做到像简单值一样赋值`（var func = function(){}）`、传参`(function func(x,callback){callback();})`、返回`(function(){return function(){}})`，这样的函数也称之为**第一级函数（First-class Function）**。不仅如此，JavaScript中的函数还充当了类的构造函数的作用，同时又是一个`Function`类的实例(instance)。这样的多重身份让JavaScript的函数变得非常重要。


### 9、什么是跨域？怎么解决跨域问题？

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


### 10、一般使用什么版本控制工具?svn如何对文件加锁###

svn加锁目的：为了避免多个人同一时间对同一个文件改动的相互覆盖，版本控制系统就必须有一套冲突处理机制。

svn加锁两种策略：乐观加锁：所有签出的文件都是可读写的，对文件的修改不必获得文件的锁，当你修改完文件签入时，会首先要求你更新本地文件，版本控制系统不会覆盖你的本地修改，而是会让你自己合并冲突后签入。

严格加锁：所有签出的文件都是只读的，任何对文件的修改必须要获得文件的锁，如果其他人没有拥有该文件的锁，那么版本控制系统就会授权给你文件的锁，并将文件设置为可编辑的。

svn两种加锁步骤：乐观加锁：选择你想要获取锁定的文件，然后右键菜单点击TortoiseSVN 选取获取锁定。

严格加锁：在想要采取严格加锁的文件或目录上点击右键，使用TortoiseSVN 属性菜单，点击新建属性，选择需要锁定。


### 11、`Function.prototype.call` 方法的用途是什么？
### 12、同步和异步的区别?
### 13、jQuery与jQuery UI 有啥区别？
### 14、什么是模板字符串？
### 15、压缩合并目的？http请求的优化方式？
### 16、什么是默认参数？
### 17、DOM事件模型和事件流？
### 18、除了jsonp 还有什么跨域方式###
### 19、EventLoop事件循环是什么？
### 20、JSON 的了解？**
### 21、有哪些方法可以处理 JS 中的异步代码？
### 22、简述一下你理解的面向对象？
### 23、Node的应用场景
### 24、说出几个http协议状态码?
### 25、为什么在调用这个函数时，代码中的`b`会变成一个全局变量?
### 26、你觉得jQuery源码有哪些写的好的地方
### 27、判断数据类型
### 28、git 和 svn的区别?
### 29、ajax 和 jsonp ？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
