# React最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、React如何进行组件/逻辑复用?

抛开已经被官方弃用的Mixin,组件抽象的技术目前有三种比较主流:

**高阶组件:**

**1、** 属性代理

**2、** 反向继承

**3、** 渲染属性

**4、** react-hooks


### 2、React中的状态是什么？它是如何使用的？

状态是 React 组件的核心，是数据的来源，必须尽可能简单。基本上状态是确定组件呈现和行为的对象。与props 不同，它们是可变的，并创建动态和交互式组件。可以通过 `this.state()` 访问它们。


### 3、React中的事件是什么？

在 React 中，事件是对鼠标悬停、鼠标单击、按键等特定操作的触发反应。处理这些事件类似于处理 DOM 元素中的事件。但是有一些语法差异，如：

**1、**  用驼峰命名法对事件命名而不是仅使用小写字母。

**2、**  事件作为函数而不是字符串传递。

事件参数重包含一组特定于事件的属性。每个事件类型都包含自己的属性和行为，只能通过其事件处理程序访问。


### 4、区分Real DOM和Virtual DOM
| Real DOM | Virtual DOM |
| --- | --- |
| 1、更新缓慢。 | 1、更新更快。 |
| 2、可以直接更新 HTML。 | 2、无法直接更新 HTML。 |
| 3、如果元素更新，则创建新DOM。 | 3、如果元素更新，则更新 JSX 。 |
| 4、DOM操作代价很高。 | 4、DOM 操作非常简单。 |
| 5、消耗的内存较多。 | 5、很少的内存消耗。 |



### 5、说一下v-model的原理

`v-model`本质就是一个语法糖，可以看成是`value + input`方法的语法糖。 可以通过model属性的`prop`和`event`属性来进行自定义。原生的v-model，会根据标签的不同生成不同的事件和属性。


### 6、你都做过哪些Vue的性能优化？

**编码阶段**

**1、** 尽量减少data中的数据，data中的数据都会增加getter和setter，会收集对应的watcher

**2、** v-if和v-for不能连用

**3、** 如果需要使用v-for给每项元素绑定事件时使用事件代理

**4、** SPA 页面采用keep-alive缓存组件

**5、** 在更多的情况下，使用v-if替代v-show

**6、** key保证唯一

**7、** 使用路由懒加载、异步组件

**8、** 防抖、节流

**9、** 第三方模块按需导入

**10、** 长列表滚动到可视区域动态加载

**11、** 图片懒加载

**SEO优化**

**1、** 预渲染

**2、** 服务端渲染SSR

**打包优化**

**1、** 压缩代码

**2、** Tree Shaking/Scope Hoisting

**3、** 使用cdn加载第三方模块

**4、** 多线程打包happypack

**5、** splitChunks抽离公共文件

**6、** sourceMap优化

**用户体验**

**1、** 骨架屏

**2、** PWA

还可以使用缓存(客户端缓存、服务端缓存)优化、服务端开启gzip压缩等。

(优化是个大工程，会涉及很多方面，这里申请另开一个专栏)


### 7、Vue2.x和Vue3.x渲染器的diff算法分别说一下

**简单来说，diff算法有以下过程**

**1、** 同级比较，再比较子节点

**2、** 先判断一方有子节点一方没有子节点的情况(如果新的children没有子节点，将旧的子节点移除)

**3、** 比较都有子节点的情况(核心diff)

**4、** 递归比较子节点

正常Diff两个树的时间复杂度是`O(n^3)`，但实际情况下我们很少会进行`跨层级的移动DOM`，所以Vue将Diff进行了优化，从`O(n^3) -> O(n)`，只有当新旧children都为多个子节点时才需要用核心的Diff算法进行同层级比较。

Vue2的核心Diff算法采用了`双端比较`的算法，同时从新旧children的两端开始进行比较，借助key值找到可复用的节点，再进行相关操作。相比React的Diff算法，同样情况下可以减少移动节点次数，减少不必要的性能损耗，更加的优雅。

Vue3.x借鉴了 [ivi](https://github.com/localvoid/ivi)算法和 [inferno](https://github.com/infernojs/inferno)算法

在创建VNode时就确定其类型，以及在`mount/patch`的过程中采用`位运算`来判断一个VNode的类型，在这个基础之上再配合核心的Diff算法，使得性能上较Vue2.x有了提升。(实际的实现可以结合Vue3.x源码看。)

该算法中还运用了`动态规划`的思想求解最长递归子序列。

(看到这你还会发现，框架内无处不蕴藏着数据结构和算法的魅力)

**面试官：(可以可以，看来是个苗子，不过自我介绍属实有些无聊，下一题)**


### 8、与 ES5 相比，React 的 ES6 语法有何不同？

以下语法是 ES5 与 ES6 中的区别：

**1、**  require 与 import

```
// ES5
var React = require('react');

// ES6
import React from 'react';
```

**1、**  export 与 exports

```
// ES5
module.exports = Component;

// ES6
export default Component;
```

**1、**  component 和 function

```
// ES5
var MyComponent = React.createClass({
    render: function() {
        return
            <h3>Hello Edureka!</h3>;
    }
});

// ES6
class MyComponent extends React.Component {
    render() {
        return
            <h3>Hello Edureka!</h3>;
    }
}
```

**1、**  props

```
// ES5
var App = React.createClass({
    propTypes: { name: React.PropTypes.string },
    render: function() {
        return
            <h3>Hello, {this.props.name}!</h3>;
    }
});

// ES6
class App extends React.Component {
    render() {
        return
            <h3>Hello, {this.props.name}!</h3>;
    }
}
```

**1、**  state

```
// ES5
var App = React.createClass({
    getInitialState: function() {
        return { name: 'world' };
    },
    render: function() {
        return
            <h3>Hello, {this.state.name}!</h3>;
    }
});

// ES6
class App extends React.Component {
    constructor() {
        super();
        this.state = { name: 'world' };
    }
    render() {
        return
            <h3>Hello, {this.state.name}!</h3>;
    }
}
```


### 9、React有什么特点？

**React的主要功能如下：**

**1、** 它使用虚拟DOM 而不是真正的DOM。

**2、** 它可以用服务器端渲染。

**3、** 它遵循单向数据流或数据绑定。


### 10、为什么选择使用框架而不是原生?

**框架的好处:**

**1、** 组件化: 其中以 React 的组件化最为彻底,甚至可以到函数级别的原子组件,高度的组件化可以是我们的工程易于维护、易于组合拓展

**2、** 天然分层: JQuery 时代的代码大部分情况下是面条代码,耦合严重,现代框架不管是 MVC、MVP还是MVVM 模式都能帮助我们进行分层，代码解耦更易于读写。

**3、** 生态: 现在主流前端框架都自带生态,不管是数据流管理架构还是 UI 库都有成熟的解决方案。

**4、** 开发效率: 现代前端框架都默认自动更新DOM,而非我们手动操作,解放了开发者的手动DOM成本,提高开发效率,从根本上解决了UI 与状态同步问题.


### 11、你对受控组件和非受控组件了解多少？
### 12、解释 React 中 render() 的目的。
### 13、如何告诉 React 它应该编译生产环境版
### 14、组件中的data为什么是一个函数？
### 15、HOC(高阶组件)
### 16、虚拟DOM实现原理?
### 17、什么是 Props?
### 18、React与Angular有何不同？
### 19、react 的渲染过程中兄弟节点之间是怎么处理的也就是key值不一样的时候
### 20、你对 React 的 refs 有什么了解？
### 21、react性能优化是哪个周期函数
### 22、Vue中组件生命周期调用顺序说一下
### 23、Redux三大原则
### 24、mixin、hoc、render props、react-hooks的优劣如何？
### 25、什么是高阶组件（HOC）？
### 26、那你能讲一讲MVVM吗？
### 27、setState到底是异步还是同步?
### 28、React与Vue的相似之处




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
