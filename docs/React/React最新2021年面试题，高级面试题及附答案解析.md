# React最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、解释 React 中 render() 的目的。

每个React组件强制要求必须有一个 render()。它返回一个 React 元素，是原生 DOM 组件的表示。如果需要渲染多个 HTML 元素，则必须将它们组合在一个封闭标记内，例如 `<form>`、`<group>`、`<div>` 等。此函数必须保持纯净，即必须每次调用时都返回相同的结果。


### 2、虚拟DOM的优劣如何?

**优点:**

**1、** 保证性能下限: 虚拟DOM可以经过diff找出最小差异,然后批量进行patch,这种操作虽然比不上手动优化,但是比起粗暴的DOM操作性能要好很多,因此虚拟DOM可以保证性能下限

**2、** 无需手动操作DOM: 虚拟DOM的diff和patch都是在一次更新中自动进行的,我们无需手动操作DOM,极大提高开发效率

**3、** 跨平台: 虚拟DOM本质上是JavaScript对象,而DOM与平台强相关,相比之下虚拟DOM可以进行更方便地跨平台操作,例如服务器渲染、移动端开发等等

**缺点:**

无法进行极致优化: 在一些性能要求极高的应用中虚拟DOM无法进行针对性的极致优化,比如VScode采用直接手动操作DOM的方式进行极端的性能优化


### 3、react 的虚拟dom是怎么实现的

首先说说为什么要使用`Virturl DOM`因为操作真实`DOM`的耗费的性能代价太高所以`react`内部使用`js`实现了一套`dom`结构在每次操作在和真实`dom`之前使用实现好的`diff`算法对虚拟`dom`进行比较递归找出有变化的dom节点然后对其进行更新操作。为了实现虚拟`DOM`我们需要把每一种节点类型抽象成对象每一种节点类型有自己的属性也就是`prop`每次进行`diff`的时候`react`会先比较该节点类型假如节点类型不一样那么`react`会直接删除该节点然后直接创建新的节点插入到其中假如节点类型一样那么会比较`prop`是否有更新假如有`prop`不一样那么`react`会判定该节点有更新那么重渲染该节点然后在对其子节点进行比较一层一层往下直到没有子节点


### 4、react 的渲染过程中兄弟节点之间是怎么处理的也就是key值不一样的时候

通常我们输出节点的时候都是`map`一个数组然后返回一个`ReactNode`为了方便`react`内部进行优化我们必须给每一个`reactNode`添加`key`这个`key prop`在设计值处不是给开发者用的而是给react用的大概的作用就是给每一个reactNode添加一个身份标识方便react进行识别在重渲染过程中如果key一样若组件属性有所变化则`react`只更新组件对应的属性没有变化则不更新如果`key`不一样则`react`先销毁该组件然后重新创建该组件


### 5、在生命周期中的哪一步你应该发起 AJAX 请求

我们应当将`AJAX` 请求放到 `componentDidMount` 函数中执行主要原因有下

`React` 下一代调和算法 `Fiber` 会通过开始或停止渲染的方式优化应用性能其会影响到 `componentWillMount` 的触发次数。对于 `componentWillMount` 这个生命周期函数的调用次数会变得不确定React 可能会多次频繁调用 `componentWillMount`。如果我们将 AJAX 请求放到 `componentWillMount` 函数中那么显而易见其会被触发多次自然也就不是好的选择。如果我们将AJAX 请求放置在生命周期的其他函数中我们并不能保证请求仅在组件挂载完毕后才会要求响应。如果我们的数据请求在组件挂载之前就完成并且调用了`setState`函数将数据添加到组件状态中对于未挂载的组件则会报错。而在 `componentDidMount` 函数中进行 `AJAX` 请求则能有效避免这个问题


### 6、在合成事件 和 生命周期钩子(除 componentDidUpdate) 中setState是"异步"的

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


### 7、redux中间件

中间件提供第三方插件的模式自定义拦截 `action -> reducer` 的过程。变为 `action` -> `middlewares` -> `reducer`。这种机制可以让我们改变数据流实现如异步`action action` 过滤日志输出异常报告等功能

**1、** `redux-logger`提供日志输出

**2、** `redux-thunk`处理异步操作

**3、** `redux-promise`处理异步操作 `actionCreator`的返回值是 `promise`


### 8、React有什么特点？

**React的主要功能如下：**

**1、** 它使用虚拟DOM 而不是真正的DOM。

**2、** 它可以用服务器端渲染。

**3、** 它遵循单向数据流或数据绑定。


### 9、如何在 Redux 中定义 Action？

React 中的 Action 必须具有 type 属性，该属性指示正在执行的 ACTION 的类型。必须将它们定义为字符串常量，并且还可以向其添加更多的属性。在 Redux 中，action 被名为 Action Creators 的函数所创建。以下是 Action 和Action Creator 的示例：

```
function addTodo(text) {
       return {
                type: ADD_TODO,
                 text
    }
}
```


### 10、解释 Reducer 的作用。

Reducers 是纯函数，它规定应用程序的状态怎样因响应 ACTION 而改变。Reducers 通过接受先前的状态和 action 来工作，然后它返回一个新的状态。它根据操作的类型确定需要执行哪种更新，然后返回新的值。如果不需要完成任务，它会返回原来的状态。


### 11、React 中 keys的作用是什么
### 12、Store 在 Redux 中的意义是什么？
### 13、传入 setState 函数的第二个参数的作用是什么
### 14、React中的事件是什么？
### 15、React组件生命周期的阶段是什么？
### 16、具体实现步骤如下
### 17、你的接口请求一般放在哪个生命周期中？
### 18、React如何进行组件/逻辑复用?
### 19、HOC(高阶组件)
### 20、详细解释 React 组件的生命周期方法。
### 21、react和vue的区别
### 22、再说一下vue2.x中如何监测数组变化
### 23、SSR了解吗？
### 24、diff算法?
### 25、销毁阶段
### 26、setState到底是异步还是同步?
### 27、redux的工作流程?
### 28、解释一下 Flux




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
