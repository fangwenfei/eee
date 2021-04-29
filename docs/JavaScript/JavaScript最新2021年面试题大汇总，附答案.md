# JavaScript最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、异步加载的方式有哪些？

(1) defer，只支持IE

(2) async：true

(3) 创建script，插入到DOM中，加载完毕后callBack


### 2、!! 运算符能做什么？

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


### 3、什么是原型、原型链？

原型：JS声明构造函数(用来实例化对象的函数)时，会在内存中创建一个对应的对象，这个对象就是原函数的原型。构造函数默认有一个prototype属性，`prototype`的值指向函数的原型。同时原型中也有一个`constructor`属性，`constructor`的值指向原函数。

通过构造函数实例化出来的对象，并不具有`prototype`属性，其默认有一个`__proto__`属性，`__proto__`的值指向构造函数的原型对象。在原型对象上添加或修改的属性，在所有实例化出的对象上都可共享。

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/49bad3cc378b4232a4b768bfe0ea67d7~tplv-k3u1fbpfcp-zoom-1.image#alt=%E5%9C%A8%E8%BF%99%E9%87%8C%E6%8F%92%E5%85%A5%E5%9B%BE%E7%89%87%E6%8F%8F%E8%BF%B0)

当在实例化的对象中访问一个属性时，首先会在该对象内部寻找，如找不到，则会向其`__proto__`指向的原型中寻找，如仍找不到，则继续向原型中`__proto__`指向的上级原型中寻找，直至找到或`Object.prototype`为止，这种链状过程即为原型链。


### 4、平时工作中怎么样进行数据交互?如果后台没有提供数据怎么样进行开发?

**mock数据与后台返回的格式不同意怎么办?**

由后台编写接口文档、提供数据接口实、前台通过ajax访问实现数据交互；

在没有数据的情况下寻找后台提供静态数据或者自己定义mock数据；

返回数据不统一时编写映射文件 对数据进行映射。


### 5、Function.prototype.bind 的用途是什么？

`bind()` 方法创建一个新的函数，在 `bind()` 被调用时，这个新函数的 `this` 被指定为 `bind()` 的第一个参数，而其余参数将作为新函数的参数，供调用时使用。

```
import React from 'react';
class MyComponent extends React.Component {
   constructor(props){
      super(props); 
      this.state = {
         value : ""
      }  
      this.handleChange = this.handleChange.bind(this); 
      // 将 “handleChange” 方法绑定到 “MyComponent” 组件
   }

   handleChange(e){
     //do something amazing here
   }

   render(){
    return (
      <>
        <input type={this.props.type}
                value={this.state.value}
             onChange={this.handleChange}                      
          />
      </>
    )
   }
}
```


### 6、说说严格模式的限制

**1、** 变量必须声明后再使用

**2、** 函数的参数不能有同名属性，否则报错

**3、** 不能使用`with`语句

**4、** 禁止`this`指向全局对象


### 7、new操作符具体干了什么呢?

**1、** 创建一个空对象，并且 `this` 变量引用该对象，同时还继承了该函数的原型

**2、** 属性和方法被加入到 `this` 引用的对象中

**3、** 新创建的对象由 `this` 所引用，并且最后隐式的返回 `this`


### 8、`require`/`import`之间的区别？

**1、** `require`是CommonJS语法，`import`是ES6语法；

**2、** `require`只在后端服务器支持，`import`在高版本浏览器及Node中都可以支持；

**3、** `require`引入的是原始导出值的复制，`import`则是导出值的引用；

**4、** `require`时运行时动态加载，`import`是静态编译；

**5、** `require`调用时默认不是严格模式，`import`则默认调用严格模式.

### 9、Function.prototype.apply 和 Function.prototype.call 之间有什么区别？

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


### 10、简述下工作流程###

我在之前的公司工作流程大概是这样的：公司定稿会结束以后，会进行简单的技术研讨，然后我们前端会进行先期的技术准备。前端切图人员会进行psd设计稿切图，并且将css文件进行整合。我们主要编写JS部分，其中包括搭建前端框架（大项目），编写js业务和数据持久化操作，我们也会编写js插件并且进行封装方便使用，还有就是编写JS前端组建和JS测试单元，最后将完成的JS部分与切图人员提供的HTML页面进行整合。最后对完成的页面进行功能测试、页面兼容、产品还原。然后对产品进行封存，提交测试。如果出现BUG会返回给我们开发人员进行修改，再提交测试，最后测试成功，进行版本封存。等到程序全部上线的时候进行线上测试。


### 11、window.onload ==? DOMContentLoaded ?
### 12、javascript创建对象的几种方式？
### 13、什么是闭包? 堆栈溢出有什么区别？ 内存泄漏? 那些操作会造成内存泄漏？怎么样防止内存泄漏？
### 14、实现继承的方法有哪些？？？
### 15、几种基本数据类型?复杂数据类型?值类型和引用数据类型?堆栈数据结构
### 16、隐式和显式转换有什么区别）？
### 17、什么是箭头函数？
### 18、除了jsonp 还有什么跨域方式###
### 19、$$('div+.ab')和$$('.ab+div') 哪个效率高？
### 20、什么是跨域？怎么解决跨域问题？
### 21、什么是作用域？
### 22、jsonp原理？ 缺点?
### 23、如何使用storage 对js文件进行缓存
### 24、如何检查对象中是否存在某个属性？
### 25、谈谈This对象的理解
### 26、this是什么 在不同场景中分别代表什么###
### 27、DOM 是什么？
### 28、javascript 代码中的"use strict";是什么意思 ? 使用它区别是什么？
### 29、谁是c的构造函数?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
