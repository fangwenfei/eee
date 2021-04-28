# React最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、你能用HOC做什么？

**HOC可用于许多任务，例如：**

**1、** 代码重用，逻辑和引导抽象

**2、** 渲染劫持

**3、** 状态抽象和控制

**4、** Props 控制


### 2、什么是控制组件？

在 HTML 中，表单元素通常维护自己的状态，并根据用户输入进行更新。当用户提交表单时，来自上述元素的值将随表单一起发送。 而 React 的工作方式则不同。包含表单的组件将跟踪其状态中的输入值，并在每次回调函数(例如onChange)触发时重新渲染组件，因为状态被更新。以这种方式由 React 控制其值的输入表单元素称为受控组件。


### 3、什么是Redux？

Redux 是当今最热门的前端开发库之一。它是 JavaScript 程序的可预测状态容器，用于整个应用的状态管理。使用 Redux 开发的应用易于测试，可以在不同环境中运行，并显示一致的行为。


### 4、Redux与Flux有何不同？
| Flux | Redux |
| --- | --- |
| 1、Store 包含状态和更改逻辑 | 1、Store 和更改逻辑是分开的 |
| 2、有多个 Store | 2、只有一个 Store |
| 3、所有 Store 都互不影响且是平级的 | 3、带有分层 reducer 的单一 Store |
| 4、有单一调度器 | 4、没有调度器的概念 |
| 5、React 组件订阅 store | 5、容器组件是有联系的 |
| 6、状态是可变的 | 6、状态是不可改变的 |



### 5、React的请求应该放在哪个生命周期中?

React的异步请求到底应该放在哪个生命周期里,有人认为在`componentWillMount`中可以提前进行异步请求,避免白屏,其实这个观点是有问题的.

由于JavaScript中异步事件的性质，当您启动API调用时，浏览器会在此期间返回执行其他工作。当React渲染一个组件时，它不会等待componentWillMount它完成任何事情 - React继续前进并继续render,没有办法“暂停”渲染以等待数据到达。

而且在`componentWillMount`请求会有一系列潜在的问题,首先,在服务器渲染时,如果在 componentWillMount 里获取数据，fetch data会执行两次，一次在服务端一次在客户端，这造成了多余的请求,其次,在React 16进行React Fiber重写后,`componentWillMount`可能在一次渲染中多次调用.

目前官方推荐的异步请求是在`componentDidmount`中进行.

如果有特殊需求需要提前请求,也可以在特殊情况下在`constructor`中请求:

> react 17之后`componentWillMount`会被废弃,仅仅保留`UNSAFE_componentWillMount`



### 6、React实现的移动应用中如果出现卡顿有哪些可以考虑的优化方案

**1、** 增加`shouldComponentUpdate`钩子对新旧`props`进行比较如果值相同则阻止更新避免不必要的渲染或者使用`PureReactComponent`替代`Component`其内部已经封装了`shouldComponentUpdate`的浅比较逻辑

**2、** 对于列表或其他结构相同的节点为其中的每一项增加唯一`key`属性以方便`React`的`diff`算法中对该节点的复用减少节点的创建和删除操作

render函数中减少类似

```
onClick={() => {
    doSomething()
}}
```

的写法每次调用`render`函数时均会创建一个新的函数即使内容没有发生任何变化也会导致节点没必要的重渲染建议将函数保存在组件的成员对象中这样只会创建一次

**1、** 组件的props如果需要经过一系列运算后才能拿到最终结果则可以考虑使用`reselect`库对结果进行缓存如果props值未发生变化则结果直接从缓存中拿避免高昂的运算代价

**2、** webpack-bundle-analyzer分析当前页面的依赖包是否存在不合理性如果存在找到优化点并进行优化


### 7、在合成事件 和 生命周期钩子(除 componentDidUpdate) 中setState是"异步"的

**原因: 因为在`setState`的实现中有一个判断: 当更新策略正在事务流的执行中时该组件更新会被推入`dirtyComponents`队列中等待执行否则开始执行`batchedUpdates`队列更新**

在生命周期钩子调用中更新策略都处于更新之前组件仍处于事务流中而`componentDidUpdate`是在更新之后此时组件已经不在事务流中了因此则会同步执行

在合成事件中React 是基于 事务流完成的事件委托机制 实现也是处于事务流中

**问题: 无法在setState后马上从this.state上获取更新后的值。**

解决: 如果需要马上同步去获取新值`setState`其实是可以传入第二个参数的。`setState(updater, callback)`在回调中即可获取最新值#

在 原生事件 和 `setTimeout` 中`setState`是同步的可以马上获取更新后的值

原因: 原生事件是浏览器本身的实现与事务流无关自然是同步而`setTimeout`是放置于定时器线程中延后执行此时事务流已结束因此也是同步#

批量更新: 在 合成事件 和 生命周期钩子 中`setState`更新队列时存储的是 合并状态`(Object.assign)`。因此前面设置的 `key` 值会被后面所覆盖最终只会执行一次更新

函数式: 由于 Fiber 及 合并 的问题官方推荐可以传入 函数 的形式。`setState(fn)`在fn中返回新的state对象即可例如

```
this.setState((state, props) => newState)
```

使用函数式可以用于避免setState的批量更新的逻辑传入的函数将会被 顺序调用

**注意事项:**

**1、** `setState` 合并在 合成事件 和 生命周期钩子 中多次连续调用会被优化为一次

**2、** 当组件已被销毁如果再次调用 `setStateReact` 会报错警告通常有两种解决办法

**3、** 将数据挂载到外部通过 props 传入如放到 Redux 或 父级中

**4、** 在组件内部维护一个状态量 ( `isUnmounted`) `componentWillUnmount`中标记为 `true`在 `setState`前进行判断


### 8、你对 React 的 refs 有什么了解？

Refs 是 React 中引用的简写。它是一个有助于存储对特定的 React 元素或组件的引用的属性，它将由组件渲染配置函数返回。用于对 render() 返回的特定元素或组件的引用。当需要进行 DOM 测量或向组件添加方法时，它们会派上用场。

```
class ReferenceDemo extends React.Component{
     display() {
         const name = this.inputDemo.value;
         document.getElementById('disp').innerHTML = name;
     }
render() {
    return(
          <div>
            Name: <input type="text" ref={input => this.inputDemo = input} />
            <button name="Click" onClick={this.display}>Click</button>
            <h2>Hello <span id="disp"></span> !!!</h2>
          </div>
    );
   }
 }
```


### 9、redux的工作流程?

首先，我们看下几个核心概念：

**1、** Store：保存数据的地方，你可以把它看成一个容器，整个应用只能有一个Store。

**2、** State：Store对象包含所有数据，如果想得到某个时点的数据，就要对Store生成快照，这种时点的数据集合，就叫做State。

**3、** Action：State的变化，会导致View的变化。但是，用户接触不到State，只能接触到View。所以，State的变化必须是View导致的。Action就是View发出的通知，表示State应该要发生变化了。

**4、** Action Creator：View要发送多少种消息，就会有多少种Action。如果都手写，会很麻烦，所以我们定义一个函数来生成Action，这个函数就叫Action Creator。

**5、** Reducer：Store收到Action以后，必须给出一个新的State，这样View才会发生变化。这种State的计算过程就叫做Reducer。Reducer是一个函数，它接受Action和当前State作为参数，返回一个新的State。

**6、** dispatch：是View发出Action的唯一方法。

**然后我们过下整个工作流程：**

**1、** 首先，用户（通过View）发出Action，发出方式就用到了dispatch方法。

**2、** 然后，Store自动调用Reducer，并且传入两个参数：当前State和收到的Action，Reducer会返回新的State

**3、** State一旦有变化，Store就会调用监听函数，来更新View。

到这儿为止，一次用户交互流程结束。可以看到，在整个流程中数据都是单向流动的，这种方式保证了流程的清晰。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_11.png#alt=97%5C_11.png)


### 10、什么是React？

**1、** React 是 Facebook 在 2011 年开发的前端 JavaScript 库。

**2、** 它遵循基于组件的方法，有助于构建可重用的UI组件。

**3、** 它用于开发复杂和交互式的 Web 和移动 UI。

**4、** 尽管它仅在 2015 年开源，但有一个很大的支持社区。


### 11、React Portal 有哪些使用场景
### 12、我现在有一个button要用react在上面绑定点击事件要怎么做
### 13、为什么需要 React 中的路由？
### 14、虚拟DOM的优劣如何?
### 15、pureComponent和FunctionComponent区别
### 16、MVC框架的主要问题是什么？
### 17、Redux遵循的三个原则是什么？
### 18、那你能讲一讲MVVM吗？
### 19、React中的合成事件是什么？
### 20、与 ES5 相比，React 的 ES6 语法有何不同？
### 21、说一下v-if和v-show的区别
### 22、diff算法?
### 23、你理解“在React中，一切都是组件”这句话。
### 24、redux的工作流程?
### 25、Store 在 Redux 中的意义是什么？
### 26、setState到底是异步还是同步?
### 27、Vue中组件生命周期调用顺序说一下
### 28、为什么虚拟dom会提高性能




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
