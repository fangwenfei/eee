# React最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、MVC框架的主要问题是什么？

**以下是MVC框架的一些主要问题：**

**1、** 对 DOM 操作的代价非常高

**2、** 程序运行缓慢且效率低下

**3、** 内存浪费严重

**4、** 由于循环依赖性，组件模型需要围绕 models 和 views 进行创建


### 2、React的请求应该放在哪个生命周期中?

React的异步请求到底应该放在哪个生命周期里,有人认为在`componentWillMount`中可以提前进行异步请求,避免白屏,其实这个观点是有问题的.

由于`JavaScript`中异步事件的性质，当您启动API调用时，浏览器会在此期间返回执行其他工作。当React渲染一个组件时，它不会等待`componentWillMount`它完成任何事情 - React继续前进并继续render,没有办法“暂停”渲染以等待数据到达。

而且在`componentWillMount`请求会有一系列潜在的问题,首先,在服务器渲染时,如果在`componentWillMount` 里获取数据，fetch data会执行两次，一次在服务端一次在客户端，这造成了多余的请求,其次,在React 16进行`React Fiber`重写后,`componentWillMount`可能在一次渲染中多次调用.

目前官方推荐的异步请求是在`componentDidmount`中进行.

如果有特殊需求需要提前请求,也可以在特殊情况下在constructor中请求


### 3、Vue2.x组件通信有哪些方式？

**父子组件通信**

**1、** 父->子`props`，子->父 `$on、$emit`

**2、** 获取父子组件实例 `$parent、$children`

**3、** `Ref` 获取实例的方式调用组件的属性或者方法

**4、** `Provide、inject` 官方不推荐使用，但是写组件库时很常用

**兄弟组件通信**

**1、** `Event Bus` 实现跨组件通信 `Vue.prototype.$bus = new Vue`

**2、** `Vuex`

**跨级组件通信**

**1、** `Vuex`

**2、** `$attrs、$listeners`

**3、** `Provide、inject`


### 4、react性能优化方案

**1、** 重写 `shouldComponentUpdate`来避免不必要的 `dom`操作

**2、** 使用 `production` 版本的 `react.js`

**3、** 使用 `key`来帮助 `React`识别列表中所有子组件的最小变化


### 5、setState到底是异步还是同步?

答案: 有时表现出异步,有时表现出同步

setState只在合成事件和钩子函数中是“异步”的，在原生事件和setTimeout 中都是同步的。

setState 的“异步”并不是说内部由异步代码实现，其实本身执行的过程和代码都是同步的，只是合成事件和钩子函数的调用顺序在更新之前，导致在合成事件和钩子函数中没法立马拿到更新后的值，形成了所谓的“异步”，当然可以通过第二个参数 setState(partialState, callback) 中的callback拿到更新后的结果。

setState 的批量更新优化也是建立在“异步”（合成事件、钩子函数）之上的，在原生事件和setTimeout 中不会批量更新，在“异步”中如果对同一个值进行多次setState，setState的批量更新策略会对其进行覆盖，取最后一次的执行，如果是同时setState多个不同的值，在更新时会对其进行合并批量更新。 #React组件通信


### 6、Vue中组件生命周期调用顺序说一下

**1、** 组件的调用顺序都是`先父后子`,渲染完成的顺序是`先子后父`。

**2、** 组件的销毁操作是`先父后子`，销毁完成的顺序是`先子后父`。

**加载渲染过程**

`父beforeCreate->父created->父beforeMount->子beforeCreate->子created->子beforeMount- >子mounted->父mounted`

**子组件更新过程**

`父beforeUpdate->子beforeUpdate->子updated->父updated`

**父组件更新过程**

`父 beforeUpdate -> 父 updated`

**销毁过程**

`父beforeDestroy->子beforeDestroy->子destroyed->父destroyed`


### 7、什么是控制组件？

在 HTML 中，表单元素通常维护自己的状态，并根据用户输入进行更新。当用户提交表单时，来自上述元素的值将随表单一起发送。 而 React 的工作方式则不同。包含表单的组件将跟踪其状态中的输入值，并在每次回调函数(例如onChange)触发时重新渲染组件，因为状态被更新。以这种方式由 React 控制其值的输入表单元素称为受控组件。


### 8、简述flux 思想

**1、** Flux 的最大特点就是数据的"单向流动"。

**2、** 用户访问 `View`

**3、** View发出用户的 `Action`

**4、** `Dispatcher` 收到Action要求 `Store` 进行相应的更新

**5、** `Store` 更新后发出一个"`change`"事件

**6、** `View` 收到"`change`"事件后更新页面


### 9、redux的工作流程?

首先，我们看下几个核心概念：

Store：保存数据的地方，你可以把它看成一个容器，整个应用只能有一个Store。

State：Store对象包含所有数据，如果想得到某个时点的数据，就要对Store生成快照，这种时点的数据集合，就叫做State。

Action：State的变化，会导致View的变化。但是，用户接触不到State，只能接触到View。所以，State的变化必须是View导致的。Action就是View发出的通知，表示State应该要发生变化了。

Action Creator：View要发送多少种消息，就会有多少种Action。如果都手写，会很麻烦，所以我们定义一个函数来生成Action，这个函数就叫Action Creator。

Reducer：Store收到Action以后，必须给出一个新的State，这样View才会发生变化。这种State的计算过程就叫做Reducer。Reducer是一个函数，它接受Action和当前State作为参数，返回一个新的State。

dispatch：是View发出Action的唯一方法。 然后我们过下整个工作流程：

首先，用户（通过View）发出Action，发出方式就用到了dispatch方法。

然后，Store自动调用Reducer，并且传入两个参数：当前State和收到的Action，Reducer会返回新的State

State一旦有变化，Store就会调用监听函数，来更新View。 到这儿为止，一次用户交互流程结束。可以看到，在整个流程中数据都是单向流动的，这种方式保证了流程的清晰。


### 10、Vue模版编译原理知道吗，能简单说一下吗？

简单说，Vue的编译过程就是将`template`转化为`render`函数的过程。会经历以下阶段：

**1、** 生成AST树

2、优化

**3、** codegen

首先解析模版，生成`AST语法树`(一种用JavaScript对象的形式来描述整个模板)。 使用大量的正则表达式对模板进行解析，遇到标签、文本的时候都会执行对应的钩子进行相关处理。

Vue的数据是响应式的，但其实模板中并不是所有的数据都是响应式的。有一些数据首次渲染后就不会再变化，对应的DOM也不会变化。那么优化过程就是深度遍历AST树，按照相关条件对树节点进行标记。这些被标记的节点(静态节点)我们就可以`跳过对它们的比对`，对运行时的模板起到很大的优化作用。

编译的最后一步是`将优化后的AST树转换为可执行的代码`。


### 11、react性能优化是哪个周期函数
### 12、你对 React 的 refs 有什么了解？
### 13、在生命周期中的哪一步你应该发起 AJAX 请求
### 14、react-redux是如何工作的?
### 15、与 ES5 相比，React 的 ES6 语法有何不同？
### 16、React中的状态是什么？它是如何使用的？
### 17、React如何进行组件/逻辑复用?
### 18、为什么虚拟dom会提高性能
### 19、React有哪些优化性能是手段?
### 20、SSR了解吗？
### 21、什么是JSX？
### 22、再说一下vue2.x中如何监测数组变化
### 23、具体实现步骤如下
### 24、虚拟DOM实现原理?
### 25、我现在有一个button要用react在上面绑定点击事件要怎么做
### 26、区分状态和 props
### 27、什么是Redux？
### 28、diff算法?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
