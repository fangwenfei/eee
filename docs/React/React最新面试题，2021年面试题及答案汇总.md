# React最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、react和vue的区别

**相同点**

**1、** 数据驱动页面提供响应式的试图组件

**2、** 都有 `virtual DOM`,组件化的开发通过 `props`参数进行父子之间组件传递数据都实现了 `webComponents`规范

**3、** 数据流动单向都支持服务器的渲染SSR

**4、** 都有支持 `native`的方法 `react`有 `React native vue`有 `wexx`

**不同点**

**1、** 数据绑定 `Vue`实现了双向的数据绑定 `react`数据流动是单向的

**2、** 数据渲染大规模的数据渲染 `react`更快

**3、** 使用场景 `React`配合 `Redux`架构适合大规模多人协作复杂项目Vue适合小快的项目

**4、** 开发风格 `react`推荐做法 `jsx` + `inline style`把 `html`和 `css`都写在 `js`了

**5、** `vue`是采用 `webpack` + `vue-loader`单文件组件格式 `html`, `js`, `css`同一个文件


### 2、react组件的划分业务组件技术组件

根据组件的职责通常把组件分为`UI`组件和容器组件。`UI` 组件负责 `UI` 的呈现容器组件负责管理数据和逻辑。两者通过`React-Redux` 提供`connect`方法联系起来


### 3、react 的虚拟dom是怎么实现的

首先说说为什么要使用`Virturl DOM`因为操作真实`DOM`的耗费的性能代价太高所以`react`内部使用`js`实现了一套`dom`结构在每次操作在和真实`dom`之前使用实现好的`diff`算法对虚拟`dom`进行比较递归找出有变化的dom节点然后对其进行更新操作。为了实现虚拟`DOM`我们需要把每一种节点类型抽象成对象每一种节点类型有自己的属性也就是`prop`每次进行`diff`的时候`react`会先比较该节点类型假如节点类型不一样那么`react`会直接删除该节点然后直接创建新的节点插入到其中假如节点类型一样那么会比较`prop`是否有更新假如有`prop`不一样那么`react`会判定该节点有更新那么重渲染该节点然后在对其子节点进行比较一层一层往下直到没有子节点


### 4、说一下Vue的生命周期

`beforeCreate`是new Vue()之后触发的第一个钩子，在当前阶段data、methods、computed以及watch上的数据和方法都不能被访问。

`created`在实例创建完成后发生，当前阶段已经完成了数据观测，也就是可以使用数据，更改数据，在这里更改数据不会触发updated函数。可以做一些初始数据的获取，在当前阶段无法与Dom进行交互，如果非要想，可以通过vm.$nextTick来访问Dom。

`beforeMount`发生在挂载之前，在这之前template模板已导入渲染函数编译。而当前阶段虚拟Dom已经创建完成，即将开始渲染。在此时也可以对数据进行更改，不会触发updated。

`mounted`在挂载完成后发生，在当前阶段，真实的Dom挂载完毕，数据完成双向绑定，可以访问到Dom节点，使用$refs属性对Dom进行操作。

`beforeUpdate`发生在更新之前，也就是响应式数据发生更新，虚拟dom重新渲染之前被触发，你可以在当前阶段进行更改数据，不会造成重渲染。

`updated`发生在更新完成之后，当前阶段组件Dom已完成更新。要注意的是避免在此期间更改数据，因为这可能会导致无限循环的更新。

`beforeDestroy`发生在实例销毁之前，在当前阶段实例完全可以被使用，我们可以在这时进行善后收尾工作，比如清除计时器。

`destroyed`发生在实例销毁之后，这个时候只剩下了dom空壳。组件已被拆解，数据绑定被卸除，监听被移出，子实例也统统被销毁。


### 5、setState到底是异步还是同步?

答案: 有时表现出异步,有时表现出同步

setState只在合成事件和钩子函数中是“异步”的，在原生事件和setTimeout 中都是同步的。

setState 的“异步”并不是说内部由异步代码实现，其实本身执行的过程和代码都是同步的，只是合成事件和钩子函数的调用顺序在更新之前，导致在合成事件和钩子函数中没法立马拿到更新后的值，形成了所谓的“异步”，当然可以通过第二个参数 setState(partialState, callback) 中的callback拿到更新后的结果。

setState 的批量更新优化也是建立在“异步”（合成事件、钩子函数）之上的，在原生事件和setTimeout 中不会批量更新，在“异步”中如果对同一个值进行多次setState，setState的批量更新策略会对其进行覆盖，取最后一次的执行，如果是同时setState多个不同的值，在更新时会对其进行合并批量更新。 #React组件通信


### 6、react旧版生命周期函数

初始化阶段

**1、** `getDefaultProps`:获取实例的默认属性

**2、** `getInitialState`:获取每个实例的初始化状态

**3、** `componentWillMount`组件即将被装载、渲染到页面上

**4、** `render`:组件在这里生成虚拟的DOM节点

**5、** `componentDidMount`:组件真正在被装载之后

运行中状态

**1、** `componentWillReceiveProps`:组件将要接收到属性的时候调用

**2、** `shouldComponentUpdate`:组件接受到新属性或者新状态的时候可以返回 `false`接收数据后不更新阻止 `render`调用后面的函数不会被继续执行了

**3、** `componentWillUpdate`:组件即将更新不能修改属性和状态

**4、** `render`:组件重新描绘

**5、** `componentDidUpdate`:组件已经更新


### 7、在生命周期中的哪一步你应该发起 AJAX 请求

我们应当将`AJAX` 请求放到 `componentDidMount` 函数中执行主要原因有下

`React` 下一代调和算法 `Fiber` 会通过开始或停止渲染的方式优化应用性能其会影响到 `componentWillMount` 的触发次数。对于 `componentWillMount` 这个生命周期函数的调用次数会变得不确定React 可能会多次频繁调用 `componentWillMount`。如果我们将 AJAX 请求放到 `componentWillMount` 函数中那么显而易见其会被触发多次自然也就不是好的选择。如果我们将AJAX 请求放置在生命周期的其他函数中我们并不能保证请求仅在组件挂载完毕后才会要求响应。如果我们的数据请求在组件挂载之前就完成并且调用了`setState`函数将数据添加到组件状态中对于未挂载的组件则会报错。而在 `componentDidMount` 函数中进行 `AJAX` 请求则能有效避免这个问题


### 8、React如何进行组件/逻辑复用?

抛开已经被官方弃用的Mixin,组件抽象的技术目前有三种比较主流:

**高阶组件:**

**1、** 属性代理

**2、** 反向继承

**3、** 渲染属性

**4、** react-hooks


### 9、传入 setState 函数的第二个参数的作用是什么

该函数会在 setState 函数调用完成并且组件开始重渲染的时候被调用我们可以用该函数来监听渲染是否完成

```
this.setState(
  { username: 'tylermcginnis33' },
  () => console.log('setState has finished and the component has re-rendered.')
)
this.setState((prevState, props) => {
  return {
    streak: prevState.streak + props.count
  }
})
```


### 10、你是如何理解fiber的?

React Fiber 是一种基于浏览器的**单线程调度算法**.

React 16之前 ，`reconcilation` 算法实际上是递归，想要中断递归是很困难的，React 16 开始使用了循环来代替之前的递归.

`Fiber`：**一种将 `recocilation` （递归 diff），拆分成无数个小任务的算法；它随时能够停止，恢复。停止恢复的时机取决于当前的一帧（16ms）内，还有没有足够的时间允许计算。**


### 11、你都做过哪些Vue的性能优化？
### 12、Vue事件绑定原理说一下
### 13、为什么选择使用框架而不是原生?
### 14、简单说一下Vue2.x响应式数据原理
### 15、解释 React 中 render() 的目的。
### 16、为什么React Router v4中使用 switch 关键字 ？
### 17、组件中的data为什么是一个函数？
### 18、SSR了解吗？
### 19、什么是React？
### 20、Redux遵循的三个原则是什么？
### 21、MVC框架的主要问题是什么？
### 22、React中的事件是什么？
### 23、setState
### 24、如何模块化 React 中的代码？
### 25、那你知道Vue3.x响应式数据原理吗？
### 26、React的请求应该放在哪个生命周期中?
### 27、Redux三大原则




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
