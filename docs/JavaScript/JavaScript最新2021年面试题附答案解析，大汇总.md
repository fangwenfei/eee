# JavaScript最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、实现异步的方式有哪些？

**1、** 回调函数模式：将需要异步执行的函数作为回调函数执行，其缺点在于处理复杂逻辑异步逻辑时，会造成回调地狱(回调嵌套层数太多，代码结构混乱)；

**2、** 事件监听模式：采用事件驱动的思想，当某一事件发生时触发执行异步函数，其缺点在于整个代码全部得变为事件驱动模式，难以分辨主流程；

**3、** 发布订阅模式：当异步任务执行完成时发布消息给信号中心，其他任务通过在信号中心中订阅消息来确定自己是否开始执行；

**4、** Promise(ES6)：`Promise`对象共有三种状态`pending`(初始化状态)、`fulfilled`(成功状态)、`rejected`(失败状态)。

**5、** async/await(ES7)：基于`Promise`实现的异步函数； （6）利用生成器实现。


### 2、判断数据类型的方法有哪些？

**1、** 利用`typeof`可以判断数据的类型；

**2、** `A instanceof` B可以用来判断A是否为B的实例，但它不能检测 null 和 undefined；

**3、** `B.constructor == A`可以判断A是否为B的原型，但constructor检测 Object与instanceof不一样，还可以处理基本数据类型的检测。

不过函数的 constructor 是不稳定的，这个主要体现在把类的原型进行重写，在重写的过程中很有可能出现把之前的constructor给覆盖了，这样检测出来的结果就是不准确的。

**4、** `Object.prototype.toString.call()`

`Object.prototype.toString.call()` 是最准确最常用的方式。


### 3、为什么要有同源限制？

**1、** 同源策略指的是：协议，域名，端口相同，同源策略是一种安全协议

**2、** 举例说明：比如一个黑客程序，他利用`Iframe`把真正的银行登录页面嵌到他的页面上，当你使用真实的用户名，密码登录时，他的页面就可以通过`Javascript`读取到你的表单中`input`中的内容，这样用户名，密码就轻松到手了。


### 4、有哪些数据类型？

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


### 5、什么是跨域？怎么解决跨域问题？

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


### 6、同步和异步的区别?

**1、** 同步：浏览器访问服务器请求，用户看得到页面刷新，重新发请求,等请求完，页面刷新，新内容出现，用户看到新内容,进行下一步操作

**2、** 异步：浏览器访问服务器请求，用户正常操作，浏览器后端进行请求。等请求完，页面不刷新，新内容也会出现，用户看到新内容


### 7、什么是 ES6 模块？

**模块**使我们能够将代码基础分割成多个文件，以获得更高的可维护性，并且避免将所有代码放在一个大文件中。在 ES6 支持模块之前，有两个流行的模块。

-
**CommonJS-Node.js**

-
AMD（异步模块定义）-**浏览器**


基本上，使用模块的方式很简单，`import`用于从另一个文件中获取功能或几个功能或值，同时`export`用于从文件中公开功能或几个功能或值。

**导出**

使用 ES5 (CommonJS)

```
// 使用 ES5 CommonJS - helpers.js
exports.isNull = function (val) {
  return val === null;
}

exports.isUndefined = function (val) {
  return val === undefined;
}

exports.isNullOrUndefined = function (val) {
  return exports.isNull(val) || exports.isUndefined(val);
}
```

使用 ES6 模块

```
使用 ES6 Modules - helpers.js
export function isNull(val){
  return val === null;
}

export function isUndefined(val) {
  return val === undefined;
}

export function isNullOrUndefined(val) {
  return isNull(val) || isUndefined(val);
}
```

在另一个文件中导入函数

```
// 使用 ES5 (CommonJS) - index.js
const helpers = require('./helpers.js'); // helpers is an object
const isNull = helpers.isNull;
const isUndefined = helpers.isUndefined;
const isNullOrUndefined = helpers.isNullOrUndefined;

// or if your environment supports Destructuring
const { isNull, isUndefined, isNullOrUndefined } = require('./helpers.js');
-------------------------------------------------------

// ES6 Modules - index.js
import * as helpers from './helpers.js'; // helpers is an object

// or 

import { isNull, isUndefined, isNullOrUndefined as isValid } from './helpers.js';

// using "as" for renaming named exports
```

**在文件中导出单个功能或默认导出**

使用 ES5 (CommonJS)

```
// 使用 ES5 (CommonJS) - index.js
class Helpers {
  static isNull(val) {
    return val === null;
  }

  static isUndefined(val) {
    return val === undefined;
  }

  static isNullOrUndefined(val) {
    return this.isNull(val) || this.isUndefined(val);
  }
}

module.exports = Helpers;
```

使用ES6 Modules

```
// 使用 ES6 Modules - helpers.js
class Helpers {
  static isNull(val) {
    return val === null;
  }

  static isUndefined(val) {
    return val === undefined;
  }

  static isNullOrUndefined(val) {
    return this.isNull(val) || this.isUndefined(val);
  }
}

export default Helpers
```

从另一个文件导入单个功能

使用ES5 (CommonJS)

`// 使用 ES5 (CommonJS) - index.js const Helpers = require('./helpers.js'); console.log(Helpers.isNull(null));`

使用 ES6 Modules

`import Helpers from '.helpers.js' console.log(Helpers.isNull(null));`


### 8、如何合并两个数组？数组删除一个元素?

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


### 9、JavaScript原型，原型链 ? 有什么特点？

在JavaScript中,一共有两种类型的值,原始值和对象值.每个对象都有一个内部属性[[prototype]],我们通常称之为原型.原型的值可以是一个对象,也可以是null.如果它的值是一个对象,则这个对象也一定有自己的原型.这样就形成了一条线性的链,我们称之为原型链、

访问一个对象的原型可以使用ES5中的Object.getPrototypeOf方法,或者ES6中的__proto__属性、原型链的作用是用来实现继承,比如我们新建一个数组,数组的方法就是从数组的原型上继承而来的。


### 10、简述一下你理解的面向对象？

面向对象是基于万物皆对象这个哲学观点、把一个对象抽象成类,具体上就是把一个对象的静态特征和动态特征抽象成属性和方法,也就是把一类事物的算法和数据结构封装在一个类之中,程序就是多个对象和互相之间的通信组成的、

面向对象具有封装性,继承性,多态性。

封装:隐蔽了对象内部不需要暴露的细节,使得内部细节的变动跟外界脱离,只依靠接口进行通信.封装性降低了编程的复杂性、通过继承,使得新建一个类变得容易,一个类从派生类那里获得其非私有的方法和公用属性的繁琐工作交给了编译器、而 继承和实现接口和运行时的类型绑定机制 所产生的多态,使得不同的类所产生的对象能够对相同的消息作出不同的反应,极大地提高了代码的通用性、

总之,面向对象的特性提高了大型程序的重用性和可维护性.


### 11、说几条写JavaScript的基本规范？
### 12、怎么理解宏任务，微任务？？？
### 13、Function.prototype.bind 的用途是什么？
### 14、什么是移动端的300ms延迟？什么是点击穿透？解决方案?
### 15、javascript有哪些方法定义对象
### 16、call和apply 有什么好处？
### 17、使用 + 或一元加运算符是将字符串转换为数字的最快方法吗？
### 18、什么是原型、原型链？
### 19、简述ajax执行流程
### 20、对象的 prototype(原型) 是什么？
### 21、new操作符具体干了什么呢?
### 22、this是什么 在不同场景中分别代表什么###
### 23、什么是 IIFE，它的用途是什么？
### 24、如何解决跨域问题?
### 25、介绍js有哪些内置对象？
### 26、split() join()?
### 27、ajax 和 jsonp ？
### 28、事件委托？有什么好处?
### 29、window.onload ==? DOMContentLoaded ?
### 30、vue、react、angular




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
