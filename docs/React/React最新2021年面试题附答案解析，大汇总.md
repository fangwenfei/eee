# React最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、React组件生命周期的阶段是什么？

React 组件的生命周期有三个不同的阶段：

**1、** 初始渲染阶段：这是组件即将开始其生命之旅并进入 DOM 的阶段。

**2、** 更新阶段：一旦组件被添加到 DOM，它只有在 prop 或状态发生变化时才可能更新和重新渲染。这些只发生在这个阶段。

**3、** 卸载阶段：这是组件生命周期的最后阶段，组件被销毁并从 DOM 中删除。


### 2、为什么要用redux

在`React`中数据在组件中是单向流动的数据从一个方向父组件流向子组件通过`props`,所以两个非父子组件之间通信就相对麻烦`redux`的出现就是为了解决`state`里面的数据问题


### 3、区分有状态和无状态组件。
| 有状态组件 | 无状态组件 |
| --- | --- |
| 1、在内存中存储有关组件状态变化的信息 | 1、计算组件的内部的状态 |
| 2、有权改变状态 | 2、无权改变状态 |
| 3、包含过去、现在和未来可能的状态变化情况 | 3、不包含过去，现在和未来可能发生的状态变化情况 |
| 4、接受无状态组件状态变化要求的通知，然后将 props 发送给他们。 | 4.从有状态组件接收 props 并将其视为回调函数。 |



### 4、React中的状态是什么？它是如何使用的？

状态是 React 组件的核心，是数据的来源，必须尽可能简单。基本上状态是确定组件呈现和行为的对象。与props 不同，它们是可变的，并创建动态和交互式组件。可以通过 `this.state()` 访问它们。


### 5、Redux设计理念

`Redux`是将整个应用状态存储到一个地方上称为`store`,里面保存着一个状态树`store` `tree`,组件可以派发(`dispatch`)行为(`action`)给`store`,而不是直接通知其他组件组件内部通过订阅`store`中的状态`state`来刷新自己的视图

![80_2.png][80_2.png]

image


### 6、解释一下 Flux

Flux 是一种强制单向数据流的架构模式。它控制派生数据，并使用具有所有数据权限的中心 store 实现多个组件之间的通信。整个应用中的数据更新必须只能在此处进行。 Flux 为应用提供稳定性并减少运行时的错误。


### 7、react性能优化方案

**1、** 重写 `shouldComponentUpdate`来避免不必要的 `dom`操作

**2、** 使用 `production` 版本的 `react.js`

**3、** 使用 `key`来帮助 `React`识别列表中所有子组件的最小变化


### 8、React 中 refs 的作用是什么

`Refs` 是 `React` 提供给我们的安全访问 `DOM`元素或者某个组件实例的句柄可以为元素添加ref属性然后在回调函数中接受该元素在 `DOM` 树中的句柄该值会作为回调函数的第一个参数返回


### 9、pureComponent和FunctionComponent区别

`PureComponent`和`Component`完全相同但是在`shouldComponentUpdate`实现中`PureComponent`使用了`props`和`state`的浅比较。主要作用是用来提高某些特定场景的性能


### 10、Redux实现原理解析


### 11、React与Vue的相似之处
### 12、如何将两个或多个组件嵌入到一个组件中？
### 13、createElement 与 cloneElement 的区别是什么
### 14、react-router里的标签和`<a>`标签有什么区别
### 15、列出 Redux 的组件。
### 16、React如何进行组件/逻辑复用?
### 17、如何在 Redux 中定义 Action？
### 18、redux的工作流程?
### 19、React有哪些限制？
### 20、你能用HOC做什么？
### 21、React Portal 有哪些使用场景
### 22、如何在React中创建一个事件？
### 23、什么是JSX？
### 24、你理解“在React中，一切都是组件”这句话。
### 25、什么是Redux？
### 26、你对“单一事实来源”有什么理解？
### 27、你对 React 的 refs 有什么了解？
### 28、React与Angular有何不同？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
