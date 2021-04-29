# React最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、React 中 keys的作用是什么

`Keys`是 `React` 用于追踪哪些列表中元素被修改、被添加或者被移除的辅助标识

在开发过程中我们需要保证某个元素的 `key` 在其同级元素中具有唯一性。在 `React Diff` 算法中`React` 会借助元素的 `Key` 值来判断该元素是新近创建的还是被移动而来的元素从而减少不必要的元素重渲染。此外React 还需要借助 `Key` 值来判断元素与本地状态的关联关系因此我们绝不可忽视转换函数中 `Key` 的重要性


### 2、createElement 与 cloneElement 的区别是什么

`createElement` 函数是 JSX 编译之后使用的创建 `React Element`的函数而 cloneElement 则是用于复制某个元素并传入新的 `Props`


### 3、简单说一下Vue2.x响应式数据原理

Vue在初始化数据时，会使用`Object.defineProperty`重新定义data中的所有属性，当页面使用对应属性时，首先会进行依赖收集(收集当前组件的`watcher`)如果属性发生变化会通知相关依赖进行更新操作(`发布订阅`)。


### 4、解释一下 Flux

Flux 是一种强制单向数据流的架构模式。它控制派生数据，并使用具有所有数据权限的中心 store 实现多个组件之间的通信。整个应用中的数据更新必须只能在此处进行。 Flux 为应用提供稳定性并减少运行时的错误。


### 5、在合成事件 和 生命周期钩子(除 componentDidUpdate) 中setState是"异步"的

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


### 6、组件中的data为什么是一个函数？

一个组件被复用多次的话，也就会创建多个实例。本质上，`这些实例用的都是同一个构造函数`。如果data是对象的话，对象属于引用类型，会影响到所有的实例。所以为了保证组件不同的实例之间data不冲突，data必须是一个函数。


### 7、我现在有一个button要用react在上面绑定点击事件要怎么做

```
class Demo {
  render() {
    return <button onClick={(e) => {
      alert('我点击了按钮')
    }}>
      按钮
    </button>
  }
}
```

你觉得你这样设置点击事件会有什么问题吗

由于`onClick`使用的是匿名函数所有每次重渲染的时候会把该`onClick`当做一个新的prop来处理会将内部缓存的`onClick`事件进行重新赋值所以相对直接使用函数来说可能有一点的性能下降

修改

```
class Demo {

  onClick = (e) => {
    alert('我点击了按钮')
  }

  render() {
    return <button onClick={this.onClick}>
      按钮
    </button>
  }
```


### 8、什么是 Props?
### 9、setState: React 中用于修改状态更新视图。它具有以下特点:
### 10、具体实现步骤如下
### 11、Redux设计理念
### 12、解释 Reducer 的作用。
### 13、setState到底是异步还是同步?
### 14、你对“单一事实来源”有什么理解？
### 15、HOC(高阶组件)
### 16、为什么需要 React 中的路由？
### 17、如何在React中创建一个事件？
### 18、connect原理
### 19、传入 setState 函数的第二个参数的作用是什么
### 20、区分状态和 props
### 21、你了解 Virtual DOM 吗？解释一下它的工作原理。
### 22、虚拟DOM实现原理?
### 23、你的接口请求一般放在哪个生命周期中？
### 24、setState到底是异步还是同步?
### 25、列出一些应该使用 Refs 的情况。
### 26、React有哪些限制？
### 27、React的请求应该放在哪个生命周期中?
### 28、为什么虚拟dom会提高性能




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
