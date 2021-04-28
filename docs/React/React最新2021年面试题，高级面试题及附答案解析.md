# React最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何在 React 中创建表单

React 表单类似于 HTML 表单。但是在 React 中，状态包含在组件的 state 属性中，并且只能通过 `setState()` 更新。因此元素不能直接更新它们的状态，它们的提交是由 JavaScript 函数处理的。此函数可以完全访问用户输入到表单的数据。

```
handleSubmit(event) {
    alert('A name was submitted: ' + this.state.value);
    event.preventDefault();
}

render() {
    return (
        <form onSubmit={this.handleSubmit}>
            <label>
                Name:
                <input type="text" value={this.state.value} onChange={this.handleSubmit} />
            </label>
            <input type="submit" value="Submit" />
        </form>
    );
}
```


### 2、区分状态和 props
| 条件 | State | Props |
| --- | --- | --- |
| 1、从父组件中接收初始值 | Yes | Yes |
| 2、父组件可以改变值 | No | Yes |
| 3、在组件中设置默认值 | Yes | Yes |
| 4、在组件的内部变化 | Yes | No |
| 5、设置子组件的初始值 | Yes | Yes |
| 6、在子组件的内部更改 | No | Yes |



### 3、keep-alive了解吗

**1、** `keep-alive`可以实现组件缓存，当组件切换时不会对当前组件进行卸载。

**2、** 常用的两个属性`include/exclude`，允许组件有条件的进行缓存。

**3、** 两个生命周期`activated/deactivated`，用来得知当前组件是否处于活跃状态。

**4、** keep-alive的中还运用了`LRU(Least Recently Used)`算法。

**5、** （又是数据结构与算法，原来算法在前端也有这么多的应用）


### 4、redux异步中间件之间的优劣?

**redux-thunk优点:**

**1、** 体积小: redux-thunk的实现方式很简单,只有不到20行代码

**2、** 使用简单: redux-thunk没有引入像redux-saga或者redux-observable额外的范式,上手简单

**redux-thunk缺陷:**

**1、** 样板代码过多: 与redux本身一样,通常一个请求需要大量的代码,而且很多都是重复性质的

**2、** 耦合严重: 异步操作与redux的action偶合在一起,不方便管理

**3、** 功能孱弱: 有一些实际开发中常用的功能需要自己进行封装

**redux-saga优点:**

**1、** 异步解耦: 异步操作被被转移到单独 saga.js 中，不再是掺杂在 action.js 或 component.js 中

**2、** action摆脱thunk function: dispatch 的参数依然是一个纯粹的 action (FSA)，而不是充满 “黑魔法” thunk function

**3、** 异常处理: 受益于 generator function 的 saga 实现，代码异常/请求失败 都可以直接通过 try/catch 语法直接捕获处理

**4、** 功能强大: redux-saga提供了大量的Saga 辅助函数和Effect 创建器供开发者使用,开发者无须封装或者简单封装即可使用

**5、** 灵活: redux-saga可以将多个Saga可以串行/并行组合起来,形成一个非常实用的异步flow

**6、** 易测试，提供了各种case的测试方案，包括mock task，分支覆盖等等

**redux-saga缺陷:**

**1、** 额外的学习成本: redux-saga不仅在使用难以理解的 generator function,而且有数十个API,学习成本远超redux-thunk,最重要的是你的额外学习成本是只服务于这个库的,与redux-observable不同,redux-observable虽然也有额外学习成本但是背后是rxjs和一整套思想

**2、** 体积庞大: 体积略大,代码近2000行，min版25KB左右

**3、** 功能过剩: 实际上并发控制等功能很难用到,但是我们依然需要引入这些代码

**4、** ts支持不友好: yield无法返回TS类型

**redux-observable优点:**

**1、** 功能最强: 由于背靠rxjs这个强大的响应式编程的库,借助rxjs的操作符,你可以几乎做任何你能想到的异步处理

**2、** 背靠rxjs: 由于有rxjs的加持,如果你已经学习了rxjs,redux-observable的学习成本并不高,而且随着rxjs的升级redux-observable也会变得更强大

**redux-observable缺陷:**

学习成本奇高: 如果你不会rxjs,则需要额外学习两个复杂的库

社区一般: redux-observable的下载量只有redux-saga的1/5,社区也不够活跃,在复杂异步流中间件这个层面redux-saga仍处于领导地位



### 5、React的请求应该放在哪个生命周期中?

React的异步请求到底应该放在哪个生命周期里,有人认为在`componentWillMount`中可以提前进行异步请求,避免白屏,其实这个观点是有问题的.

由于`JavaScript`中异步事件的性质，当您启动API调用时，浏览器会在此期间返回执行其他工作。当React渲染一个组件时，它不会等待`componentWillMount`它完成任何事情 - React继续前进并继续render,没有办法“暂停”渲染以等待数据到达。

而且在`componentWillMount`请求会有一系列潜在的问题,首先,在服务器渲染时,如果在`componentWillMount` 里获取数据，fetch data会执行两次，一次在服务端一次在客户端，这造成了多余的请求,其次,在React 16进行`React Fiber`重写后,`componentWillMount`可能在一次渲染中多次调用.

目前官方推荐的异步请求是在`componentDidmount`中进行.

如果有特殊需求需要提前请求,也可以在特殊情况下在constructor中请求


### 6、React最新的生命周期是怎样的?

React 16之后有三个生命周期被废弃(但并未删除)

**1、** componentWillMount

**2、** componentWillReceiveProps

**3、** componentWillUpdate

官方计划在17版本完全删除这三个函数，只保留UNSAVE_前缀的三个函数，目的是为了向下兼容，但是对于开发者而言应该尽量避免使用他们，而是使用新增的生命周期函数替代它们

目前React 16.8 +的生命周期分为三个阶段,分别是挂载阶段、更新阶段、卸载阶段

**挂载阶段:**

**1、** constructor: 构造函数，最先被执行,我们通常在构造函数里初始化state对象或者给自定义方法绑定this

**2、** getDerivedStateFromProps: `static getDerivedStateFromProps(nextProps, prevState)`,这是个静态方法,当我们接收到新的属性想去修改我们state，可以使用getDerivedStateFromProps

**3、** render: render函数是纯函数，只返回需要渲染的东西，不应该包含其它的业务逻辑,可以返回原生的DOM、React组件、Fragment、Portals、字符串和数字、Boolean和null等内容

**4、** componentDidMount: 组件装载之后调用，此时我们可以获取到DOM节点并操作，比如对canvas，svg的操作，服务器请求，订阅都可以写在这个里面，但是记得在componentWillUnmount中取消订阅

**更新阶段:**

**1、** getDerivedStateFromProps: 此方法在更新个挂载阶段都可能会调用

**2、** shouldComponentUpdate: `shouldComponentUpdate(nextProps, nextState)`,有两个参数nextProps和nextState，表示新的属性和变化之后的state，返回一个布尔值，true表示会触发重新渲染，false表示不会触发重新渲染，默认返回true,我们通常利用此生命周期来优化React程序性能

**3、** render: 更新阶段也会触发此生命周期

**4、** getSnapshotBeforeUpdate: `getSnapshotBeforeUpdate(prevProps, prevState)`,这个方法在render之后，componentDidUpdate之前调用，有两个参数prevProps和prevState，表示之前的属性和之前的state，这个函数有一个返回值，会作为第三个参数传给componentDidUpdate，如果你不想要返回值，可以返回null，此生命周期必须与componentDidUpdate搭配使用

**5、** componentDidUpdate: `componentDidUpdate(prevProps, prevState, snapshot)`,该方法在getSnapshotBeforeUpdate方法之后被调用，有三个参数prevProps，prevState，snapshot，表示之前的props，之前的state，和snapshot。第三个参数是getSnapshotBeforeUpdate返回的,如果触发某些回调函数时需要用到 DOM 元素的状态，则将对比或计算的过程迁移至 getSnapshotBeforeUpdate，然后在 componentDidUpdate 中统一触发回调或更新状态。

**卸载阶段:**

componentWillUnmount: 当我们的组件被卸载或者销毁了就会调用，我们可以在这个函数里去清除一些定时器，取消网络请求，清理无效的DOM元素等垃圾清理工作

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_1.png#alt=97%5C_1.png)


### 7、shouldComponentUpdate 的作用

`shouldComponentUpdate` 允许我们手动地判断是否要进行组件更新根据组件的应用场景设置函数的合理返回值能够帮我们避免不必要的更新


### 8、React Router与常规路由有何不同？
| 主题 | 常规路由 | React 路由 |
| --- | --- | --- |
| 参与的页面 | 每个视图对应一个新文件 | 只涉及单个HTML页面 |
| URL 更改 | HTTP 请求被发送到服务器并且接收相应的 HTML 页面 | 仅更改历史记录属性 |
| 体验 | 用户实际在每个视图的不同页面切换 | 用户认为自己正在不同的页面间切换 |


### 9、Vue事件绑定原理说一下

原生事件绑定是通过`addEventListener`绑定给真实元素的，组件事件绑定是通过Vue自定义的`$on`实现的。

**面试官：(这小子基础还可以，接下来我得上上难度了)**


### 10、React中的状态是什么？它是如何使用的？

状态是 React 组件的核心，是数据的来源，必须尽可能简单。基本上状态是确定组件呈现和行为的对象。与props 不同，它们是可变的，并创建动态和交互式组件。可以通过 `this.state()` 访问它们。


### 11、你都做过哪些Vue的性能优化？
### 12、如何告诉 React 它应该编译生产环境版
### 13、react-router里的标签和`<a>`标签有什么区别
### 14、区分Real DOM和Virtual DOM
### 15、nextTick知道吗，实现原理是什么？
### 16、React组件通信如何实现?
### 17、redux有什么缺点
### 18、那你知道Vue3.x响应式数据原理吗？
### 19、React 中的箭头函数是什么？怎么用？
### 20、React 中 key 的重要性是什么？
### 21、react性能优化方案
### 22、如何模块化 React 中的代码？
### 23、为什么要用redux
### 24、Redux 有哪些优点？
### 25、Vue模版编译原理知道吗，能简单说一下吗？
### 26、react组件的划分业务组件技术组件
### 27、React有什么特点？
### 28、redux中间件




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
