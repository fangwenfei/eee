# React最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、为什么要用redux

在`React`中数据在组件中是单向流动的数据从一个方向父组件流向子组件通过`props`,所以两个非父子组件之间通信就相对麻烦`redux`的出现就是为了解决`state`里面的数据问题


### 2、React 中的箭头函数是什么？怎么用？

箭头函数（=>）是用于编写函数表达式的简短语法。这些函数允许正确绑定组件的上下文，因为在 ES6 中默认下不能使用自动绑定。使用高阶函数时，箭头函数非常有用。

```
//General way
render() {
    return(
        <MyInput onChange = {this.handleChange.bind(this) } />
    );
}
//With Arrow Function
render() {
    return(
        <MyInput onChange = { (e)=>this.handleOnChange(e) } />
    );
}
```


### 3、nextTick知道吗，实现原理是什么？

在下次 DOM 更新循环结束之后执行延迟回调。nextTick主要使用了宏任务和微任务。根据执行环境分别尝试采用

**1、** Promise

**2、** MutationObserver

**3、** setImmediate

**4、** 如果以上都不行则采用setTimeout

定义了一个异步方法，多次调用nextTick会将方法存入队列中，通过这个异步方法清空当前队列。

（关于宏任务和微任务以及事件循环可以参考我的另两篇专栏）

(看到这你就会发现，其实问框架最终还是考验你的原生JavaScript功底)


### 4、说说你用react有什么坑点

**1、** JSX做表达式判断时候需要强转为boolean类型

如果不使用 !!b 进行强转数据类型会在页面里面输出 0。

```
render() {
  const b = 0;
  return <div>
    {
      !!b && <div>这是一段文本</div>
    }
  </div>
}
```

**1、** 尽量不要在 `componentWillReviceProps` 里使用 `setState`如果一定要使用那么需要判断结束条件不然会出现无限重渲染导致页面崩溃

**2、** 给组件添加ref时候尽量不要使用匿名函数因为当组件更新的时候匿名函数会被当做新的`prop`处理让`ref`属性接受到新函数的时候`react`内部会先清空`ref`也就是会以`null`为回调参数先执行一次`ref`这个`props`然后在以该组件的实例执行一次`ref`所以用匿名函数做ref的时候有的时候去`ref`赋值后的属性会取到`null`

**3、** 遍历子节点的时候不要用 index 作为组件的 key 进行传入


### 5、简述flux 思想

**1、** Flux 的最大特点就是数据的"单向流动"。

**2、** 用户访问 `View`

**3、** View发出用户的 `Action`

**4、** `Dispatcher` 收到Action要求 `Store` 进行相应的更新

**5、** `Store` 更新后发出一个"`change`"事件

**6、** `View` 收到"`change`"事件后更新页面


### 6、你是如何理解fiber的?

React Fiber 是一种基于浏览器的**单线程调度算法**.

React 16之前 ，`reconcilation` 算法实际上是递归，想要中断递归是很困难的，React 16 开始使用了循环来代替之前的递归.

`Fiber`：**一种将 `recocilation` （递归 diff），拆分成无数个小任务的算法；它随时能够停止，恢复。停止恢复的时机取决于当前的一帧（16ms）内，还有没有足够的时间允许计算。**


### 7、React有哪些限制？

**React的限制如下：**

**1、**  React 只是一个库，而不是一个完整的框架

**2、**  它的库非常庞大，需要时间来理解

**3、**  新手程序员可能很难理解

**4、**  编码变得复杂，因为它使用内联模板和 JSX


### 8、Redux三大原则

**唯一数据源**

整个应用的`state`都被存储到一个状态树里面并且这个状态树只存在于唯一的`store`中

**保持只读状态**

`state`是只读的唯一改变`state`的方法就是触发`actionaction`是一个用于描述以发生时间的普通对象

**数据改变只能通过纯函数来执行**

使用纯函数来执行修改为了描述`action`如何改变`state`的你需要编写`reducers`

Redux源码

```
let createStore = (reducer) => {
    let state;
    //获取状态对象
    //存放所有的监听函数
    let listeners = [];
    let getState = () => state;
    //提供一个方法供外部调用派发action
    let dispath = (action) => {
        //调用管理员reducer得到新的state
        state = reducer(state, action);
        //执行所有的监听函数
        listeners.forEach((l) => l())
    }
    //订阅状态变化事件当状态改变发生之后执行监听函数
    let subscribe = (listener) => {
        listeners.push(listener);
    }
    dispath();
    return {
        getState,
        dispath,
        subscribe
    }
}
let combineReducers=(renducers)=>{
    //传入一个renducers管理组返回的是一个renducer
    return function(state={},action={}){
        let newState={};
        for(var attr in renducers){
            newState[attr]=renducers[attr](state[attr],action)

        }
        return newState;
    }
}
export {createStore,combineReducers};
```


### 9、你对“单一事实来源”有什么理解？

Redux 使用 “Store” 将程序的整个状态存储在同一个地方。因此所有组件的状态都存储在 Store 中，并且它们从 Store 本身接收更新。单一状态树可以更容易地跟踪随时间的变化，并调试或检查程序。


### 10、React的请求应该放在哪个生命周期中?

React的异步请求到底应该放在哪个生命周期里,有人认为在`componentWillMount`中可以提前进行异步请求,避免白屏,其实这个观点是有问题的.

由于JavaScript中异步事件的性质，当您启动API调用时，浏览器会在此期间返回执行其他工作。当React渲染一个组件时，它不会等待componentWillMount它完成任何事情 - React继续前进并继续render,没有办法“暂停”渲染以等待数据到达。

而且在`componentWillMount`请求会有一系列潜在的问题,首先,在服务器渲染时,如果在 componentWillMount 里获取数据，fetch data会执行两次，一次在服务端一次在客户端，这造成了多余的请求,其次,在React 16进行React Fiber重写后,`componentWillMount`可能在一次渲染中多次调用.

目前官方推荐的异步请求是在`componentDidmount`中进行.

如果有特殊需求需要提前请求,也可以在特殊情况下在`constructor`中请求:

> react 17之后`componentWillMount`会被废弃,仅仅保留`UNSAFE_componentWillMount`



### 11、keep-alive了解吗
### 12、setState: React 中用于修改状态更新视图。它具有以下特点:
### 13、如何告诉 React 它应该编译生产环境版
### 14、redux中间件有哪些，做什么用？
### 15、connect原理
### 16、React与Vue的相似之处
### 17、什么是JSX？
### 18、再说一下虚拟Dom以及key属性的作用
### 19、react性能优化是哪个周期函数
### 20、Vue模版编译原理知道吗，能简单说一下吗？
### 21、react组件的划分业务组件技术组件
### 22、生命周期钩子 (useEffect):
### 23、列出React的一些主要优点。
### 24、Redux实现原理解析
### 25、Redux与Flux有何不同？
### 26、说一下v-model的原理
### 27、diff算法?
### 28、与 ES5 相比，React 的 ES6 语法有何不同？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
