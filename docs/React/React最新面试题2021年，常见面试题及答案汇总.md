# React最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、react性能优化方案

**1、** 重写 `shouldComponentUpdate`来避免不必要的 `dom`操作

**2、** 使用 `production` 版本的 `react.js`

**3、** 使用 `key`来帮助 `React`识别列表中所有子组件的最小变化


### 2、React组件通信如何实现？

父组件向子组件通讯: 父组件可以向子组件通过传 props 的方式，向子组件进行通讯

子组件向父组件通讯: props+回调的方式,父组件向子组件传递props进行通讯，此props为作用域为父组件自身的函数，子组件调用该函数，将子组件想要传递的信息，作为参数，传递到父组件的作用域中

兄弟组件通信: 找到这两个兄弟节点共同的父节点,结合上面两种方式由父节点转发信息进行通信

跨层级通信:`Context`设计目的是为了共享那些对于一个组件树而言是“全局”的数据，例如当前认证的用户、主题或首选语言,对于跨越多层的全局数据通过`Context`通信再适合不过

发布订阅模式: 发布者发布事件，订阅者监听事件并做出反应,我们可以通过引入event模块进行通信 全局状态管理工具: 借助Redux或者Mobx等全局状态管理工具进行通信,这种工具会维护一个全局状态中心Store,并根据不同的事件产生新的状态


### 3、React Router与常规路由有何不同？
| 主题 | 常规路由 | React 路由 |
| --- | --- | --- |
| 参与的页面 | 每个视图对应一个新文件 | 只涉及单个HTML页面 |
| URL 更改 | HTTP 请求被发送到服务器并且接收相应的 HTML 页面 | 仅更改历史记录属性 |
| 体验 | 用户实际在每个视图的不同页面切换 | 用户认为自己正在不同的页面间切换 |


### 4、Redux设计理念

`Redux`是将整个应用状态存储到一个地方上称为`store`,里面保存着一个状态树`store` `tree`,组件可以派发(`dispatch`)行为(`action`)给`store`,而不是直接通知其他组件组件内部通过订阅`store`中的状态`state`来刷新自己的视图

![80_2.png][80_2.png]

image


### 5、React Portal 有哪些使用场景

在以前 `react` 中所有的组件都会位于 `#app` 下而使用 `Portals` 提供了一种脱离 `#app` 的组件因此 `Portals` 适合脱离文档流(`out of flow`) 的组件特别是 `position: absolute` 与 `position: fixed`的组件。比如模态框通知警告`goTop` 等。

以下是官方一个模态框的示例可以在以下地址中测试效果

```
<html>
  <body>
    <div id="app"></div>
    <div id="modal"></div>
    <div id="gotop"></div>
    <div id="alert"></div>
  </body>
</html>
```

```
const modalRoot = document.getElementById('modal');

class Modal extends React.Component {
  constructor(props) {
    super(props);
    this.el = document.createElement('div');
  }

  componentDidMount() {
    modalRoot.appendChild(this.el);
  }

  componentWillUnmount() {
    modalRoot.removeChild(this.el);
  }

  render() {
    return ReactDOM.createPortal(
      this.props.children,
      this.el,
    );
  }
}
```

`React Hooks`当中的`useEffect`是如何区分生命周期钩子的

`useEffect`可以看成是`componentDidMountcomponentDidUpdate`和`componentWillUnmount`三者的结合。`useEffect(callback, [source])`接收两个参数调用方式如下

```
 useEffect(() => {
   console.log('mounted');
   
   return () => {
       console.log('willUnmount');
   }
 }, [source]);
```

生命周期函数的调用主要是通过第二个参数[source]来进行控制有如下几种情况

**1、** [source]参数不传时则每次都会优先调用上次保存的函数中返回的那个函数然后再调用外部那个函数

**2、** [source]参数传[]时则外部的函数只会在初始化时调用一次返回的那个函数也只会最终在组件卸载时调用一次

**3、** [source]参数有值时则只会监听到数组中的值发生变化后才优先调用返回的那个函数再调用外部的函数。


### 6、setState到底是异步还是同步?

先给出答案: 有时表现出异步,有时表现出同步

**1、** `setState`只在合成事件和钩子函数中是“异步”的，在原生事件和`setTimeout` 中都是同步的

**2、** `setState` 的“异步”并不是说内部由异步代码实现，其实本身执行的过程和代码都是同步的，只是合成事件和钩子函数的调用顺序在更新之前，导致在合成事件和钩子函数中没法立马拿到更新后的值，形成了所谓的“异步”，当然可以通过第二个参数 `setState(partialState, callback)` 中的`callback`拿到更新后的结果

**3、** `setState` 的批量更新优化也是建立在“异步”（合成事件、钩子函数）之上的，在原生事件和setTimeout 中不会批量更新，在“异步”中如果对同一个值进行多次`setState`，`setState`的批量更新策略会对其进行覆盖，取最后一次的执行，如果是同时`setState`多个不同的值，在更新时会对其进行合并批量更新


### 7、你对 Time Slice的理解?

**时间分片**

**1、** React 在渲染render的时候不会阻塞现在的线程

**2、** 如果你的设备足够快你会感觉渲染是同步的

**3、** 如果你设备非常慢你会感觉还算是灵敏的

**4、** 虽然是异步渲染但是你将会看到完整的渲染而不是一个组件一行行的渲染出来

**5、** 同样书写组件的方式

**6、** 也就是说这是React背后在做的事情对于我们开发者来说是透明的具体是什么样的效果呢


### 8、react-redux是如何工作的?

**1、** Provider: Provider的作用是从最外部封装了整个应用，并向connect模块传递store

**2、** connect: 负责连接React和Redux

**1、** 获取state: connect通过context获取Provider中的store，通过store.getState()获取整个store tree 上所有state

**2、** 包装原组件: 将state和action通过props的方式传入到原组件内部wrapWithConnect返回一个ReactComponent对象Connect，Connect重新render外部传入的原组件WrappedComponent，并把connect中传入的mapStateToProps, mapDispatchToProps与组件上原有的props合并后，通过属性的方式传给WrappedComponent

**3、** 监听store tree变化: connect缓存了store tree中state的状态,通过当前state状态和变更前state状态进行比较,从而确定是否调用`this.setState()`方法触发Connect及其子组件的重新渲染

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_12.png#alt=97%5C_12.png)


### 9、你能用HOC做什么？

**HOC可用于许多任务，例如：**

**1、** 代码重用，逻辑和引导抽象

**2、** 渲染劫持

**3、** 状态抽象和控制

**4、** Props 控制


### 10、React的请求应该放在哪个生命周期中?

React的异步请求到底应该放在哪个生命周期里,有人认为在`componentWillMount`中可以提前进行异步请求,避免白屏,其实这个观点是有问题的.

由于JavaScript中异步事件的性质，当您启动API调用时，浏览器会在此期间返回执行其他工作。当React渲染一个组件时，它不会等待componentWillMount它完成任何事情 - React继续前进并继续render,没有办法“暂停”渲染以等待数据到达。

而且在`componentWillMount`请求会有一系列潜在的问题,首先,在服务器渲染时,如果在 componentWillMount 里获取数据，fetch data会执行两次，一次在服务端一次在客户端，这造成了多余的请求,其次,在React 16进行React Fiber重写后,`componentWillMount`可能在一次渲染中多次调用.

目前官方推荐的异步请求是在`componentDidmount`中进行.

如果有特殊需求需要提前请求,也可以在特殊情况下在`constructor`中请求:

> react 17之后`componentWillMount`会被废弃,仅仅保留`UNSAFE_componentWillMount`



### 11、为什么要用redux
### 12、什么是React 路由？
### 13、React有哪些优化性能是手段?
### 14、简单说一下Vue2.x响应式数据原理
### 15、什么是React？
### 16、hash路由和history路由实现原理说一下
### 17、diff算法?
### 18、再说一下vue2.x中如何监测数组变化
### 19、React实现的移动应用中如果出现卡顿有哪些可以考虑的优化方案
### 20、如何模块化 React 中的代码？
### 21、简述flux 思想
### 22、解释一下 Flux
### 23、React 中 refs 的作用是什么
### 24、redux的工作流程?
### 25、什么是高阶组件(HOC)
### 26、Vue事件绑定原理说一下
### 27、React组件通信如何实现?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
