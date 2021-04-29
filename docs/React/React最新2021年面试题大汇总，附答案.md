# React最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、React 中 key 的重要性是什么？

key 用于识别唯一的 Virtual DOM 元素及其驱动 UI 的相应数据。它们通过回收 DOM 中当前所有的元素来帮助 React 优化渲染。这些 key 必须是唯一的数字或字符串，React 只是重新排序元素而不是重新渲染它们。这可以提高应用程序的性能。


### 2、react组件的划分业务组件技术组件

根据组件的职责通常把组件分为`UI`组件和容器组件。`UI` 组件负责 `UI` 的呈现容器组件负责管理数据和逻辑。两者通过`React-Redux` 提供`connect`方法联系起来


### 3、在合成事件 和 生命周期钩子(除 componentDidUpdate) 中setState是"异步"的

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


### 4、React如何进行组件/逻辑复用?

抛开已经被官方弃用的Mixin,组件抽象的技术目前有三种比较主流:

**1、** 高阶组件

**2、** 属性代理

**3、** 反向继承

**4、** 渲染属性

**5、** react-hooks


### 5、setState: React 中用于修改状态更新视图。它具有以下特点:

异步与同步: setState并不是单纯的异步或同步这其实与调用时的环境相关:


### 6、Redux 有哪些优点？

**Redux 的优点如下：**

**1、** 结果的可预测性 - 由于总是存在一个真实来源，即 store ，因此不存在如何将当前状态与动作和应用的其他部分同步的问题。

**2、** 可维护性 - 代码变得更容易维护，具有可预测的结果和严格的结构。

**3、** 服务器端渲染 - 你只需将服务器上创建的 store 传到客户端即可。这对初始渲染非常有用，并且可以优化应用性能，从而提供更好的用户体验。

**4、** 开发人员工具 - 从操作到状态更改，开发人员可以实时跟踪应用中发生的所有事情。

**5、** 社区和生态系统 - Redux 背后有一个巨大的社区，这使得它更加迷人。一个由才华横溢的人组成的大型社区为库的改进做出了贡献，并开发了各种应用。

**6、** 易于测试 - Redux 的代码主要是小巧、纯粹和独立的功能。这使代码可测试且独立。

**7、** 组织 - Redux 准确地说明了代码的组织方式，这使得代码在团队使用时更加一致和简单。


### 7、说一下v-if和v-show的区别

当条件不成立时，`v-if`不会渲染DOM元素，`v-show`操作的是样式(display)，切换当前DOM的显示和隐藏。


### 8、传入 setState 函数的第二个参数的作用是什么

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


### 9、如何在React中创建一个事件？

```
class Display extends React.Component({
    show(evt) {
        // code
    },
    render() {
        // Render the div with an onClick prop (value is a function)
        return (
            <div onClick={this.show}>Click Me!</div>
        );
    }
});
```


### 10、在生命周期中的哪一步你应该发起 AJAX 请求

我们应当将`AJAX` 请求放到 `componentDidMount` 函数中执行主要原因有下

`React` 下一代调和算法 `Fiber` 会通过开始或停止渲染的方式优化应用性能其会影响到 `componentWillMount` 的触发次数。对于 `componentWillMount` 这个生命周期函数的调用次数会变得不确定React 可能会多次频繁调用 `componentWillMount`。如果我们将 AJAX 请求放到 `componentWillMount` 函数中那么显而易见其会被触发多次自然也就不是好的选择。如果我们将AJAX 请求放置在生命周期的其他函数中我们并不能保证请求仅在组件挂载完毕后才会要求响应。如果我们的数据请求在组件挂载之前就完成并且调用了`setState`函数将数据添加到组件状态中对于未挂载的组件则会报错。而在 `componentDidMount` 函数中进行 `AJAX` 请求则能有效避免这个问题


### 11、如何在 Redux 中定义 Action？
### 12、react 的虚拟dom是怎么实现的
### 13、列出一些应该使用 Refs 的情况。
### 14、你是如何理解fiber的?
### 15、React组件生命周期的阶段是什么？
### 16、react旧版生命周期函数
### 17、我现在有一个button要用react在上面绑定点击事件要怎么做
### 18、redux中间件有哪些，做什么用？
### 19、redux中如何进行异步操作?
### 20、销毁阶段
### 21、生命周期钩子 (useEffect):
### 22、你对“单一事实来源”有什么理解？
### 23、diff算法?
### 24、nextTick知道吗，实现原理是什么？
### 25、redux与mobx的区别?
### 26、你理解“在React中，一切都是组件”这句话。
### 27、列出 Redux 的组件。
### 28、react-router里的标签和`<a>`标签有什么区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
