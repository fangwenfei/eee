# React最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、说说你用react有什么坑点

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


### 2、为什么需要 React 中的路由？

Router 用于定义多个路由，当用户定义特定的 URL 时，如果此 URL 与 Router 内定义的任何 “路由” 的路径匹配，则用户将重定向到该特定路由。所以基本上我们需要在自己的应用中添加一个 Router 库，允许创建多个路由，每个路由都会向我们提供一个独特的视图

```
<switch>
    <route exact path=’/’ component={Home}/>
    <route path=’/posts/:id’ component={Newpost}/>
    <route path=’/posts’   component={Post}/>
</switch>
```


### 3、列出 Redux 的组件。

Redux 由以下组件组成：

**1、**  Action – 这是一个用来描述发生了什么事情的对象。

**2、**  Reducer – 这是一个确定状态将如何变化的地方。

**3、**  Store – 整个程序的状态/对象树保存在Store中。

**4、**  View – 只显示 Store 提供的数据。


### 4、什么是高阶组件（HOC）？

高阶组件是重用组件逻辑的高级方法，是一种源于 React 的组件模式。 HOC 是自定义组件，在它之内包含另一个组件。它们可以接受子组件提供的任何动态，但不会修改或复制其输入组件中的任何行为。你可以认为 HOC 是“纯（Pure）”组件。


### 5、React实现的移动应用中如果出现卡顿有哪些可以考虑的优化方案

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


### 6、如何在 React 中创建表单

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


### 7、redux中间件

中间件提供第三方插件的模式自定义拦截 `action -> reducer` 的过程。变为 `action` -> `middlewares` -> `reducer`。这种机制可以让我们改变数据流实现如异步`action action` 过滤日志输出异常报告等功能

**1、** `redux-logger`提供日志输出

**2、** `redux-thunk`处理异步操作

**3、** `redux-promise`处理异步操作 `actionCreator`的返回值是 `promise`


### 8、销毁阶段

componentWillUnmount:组件即将销毁新版生命周期

在新版本中React 官方对生命周期有了新的 变动建议:

**1、** 使用getDerivedStateFromProps替换componentWillMount

**2、** 使用getSnapshotBeforeUpdate替换componentWillUpdate

**3、** 避免使用componentWillReceiveProps

其实该变动的原因正是由于上述提到的 `Fiber`。首先从上面我们知道 `React` 可以分成 `reconciliation` 与 `commit`两个阶段对应的生命周期如下:

**1、** reconciliation

**2、** componentWillMount

**3、** componentWillReceiveProps

**4、** shouldComponentUpdate

**5、** componentWillUpdate

**6、** commit

**7、** componentDidMoun

**8、** componentDidUpdate

**9、** componentWillUnmount

在 `Fiber` 中`reconciliation` 阶段进行了任务分割涉及到 暂停 和 重启因此可能会导致 `reconciliation` 中的生命周期函数在一次更新渲染循环中被 多次调用 的情况产生一些意外错误

新版的建议生命周期如下:

```
class Component extends React.Component {
  // 替换 `componentWillReceiveProps` 
  // 初始化和 update 时被调用
  // 静态函数无法使用 this
  static getDerivedStateFromProps(nextProps, prevState) {}
  
  // 判断是否需要更新组件
  // 可以用于组件性能优化
  shouldComponentUpdate(nextProps, nextState) {}
  
  // 组件被挂载后触发
  componentDidMount() {}
  
  // 替换 componentWillUpdate
  // 可以在更新之前获取最新 dom 数据
  getSnapshotBeforeUpdate() {}
  
  // 组件更新后调用
  componentDidUpdate() {}
  
  // 组件即将销毁
  componentWillUnmount() {}
  
  // 组件已销毁
  componentDidUnMount() {}
}
```

使用建议:

**1、** 在 `constructor`初始化 `state`

**2、** 在 `componentDidMount`中进行事件监听并在 `componentWillUnmount`中解绑事件

**3、** 在 `componentDidMount`中进行数据的请求而不是在 `componentWillMount`

**4、** 需要根据 `props` 更新 `state` 时使用 `getDerivedStateFromProps(nextProps, prevState)`

**5、** 旧 `props` 需要自己存储以便比较

```
public static getDerivedStateFromProps(nextProps, prevState) {
 // 当新 props 中的 data 发生变化时同步更新到 state 上
 if (nextProps.data !== prevState.data) {
  return {
   data: nextProps.data
  }
 } else {
  return null1
 }
}
```

可以在componentDidUpdate监听 props 或者 state 的变化例如:

```
componentDidUpdate(prevProps) {
 // 当 id 发生变化时重新获取数据
 if (this.props.id !== prevProps.id) {
  this.fetchData(this.props.id);
 }
}
```

在`componentDidUpdate使用`setState`时必须加条件否则将进入死循环

`shouldComponentUpdate`: 默认每次调用`setState`一定会最终走到 `diff` 阶段但可以通过`shouldComponentUpdate`的生命钩子返回false来直接阻止后面的逻辑执行通常是用于做条件渲染优化渲染的性能。


### 9、Redux三大原则

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


### 10、setState到底是异步还是同步?

先给出答案: 有时表现出异步,有时表现出同步

**1、** `setState`只在合成事件和钩子函数中是“异步”的在原生事件和`setTimeout` 中都是同步的

**2、** `setState` 的“异步”并不是说内部由异步代码实现其实本身执行的过程和代码都是同步的只是合成事件和钩子函数的调用顺序在更新之前导致在合成事件和钩子函数中没法立马拿到更新后的值形成了所谓的“异步”当然可以通过第二个参数`setState(partialState, callback)`中的`callback`拿到更新后的结果

**3、** `setState` 的批量更新优化也是建立在“异步”合成事件、钩子函数之上的在原生事件和`setTimeout` 中不会批量更新在“异步”中如果对同一个值进行多次`setState`的批量更新策略会对其进行覆盖取最后一次的执行如果是同时`setState`多个不同的值在更新时会对其进行合并批量更新


### 11、React的请求应该放在哪个生命周期中?
### 12、React组件通信如何实现？
### 13、pureComponent和FunctionComponent区别
### 14、hash路由和history路由实现原理说一下
### 15、Vue2.x组件通信有哪些方式？
### 16、redux有什么缺点
### 17、Redux遵循的三个原则是什么？
### 18、你理解“在React中，一切都是组件”这句话。
### 19、connect原理
### 20、React Router与常规路由有何不同？
### 21、如何告诉 React 它应该编译生产环境版
### 22、Vue事件绑定原理说一下
### 23、React如何进行组件/逻辑复用?
### 24、区分有状态和无状态组件。
### 25、React 中的箭头函数是什么？怎么用？
### 26、setState到底是异步还是同步?
### 27、keep-alive了解吗
### 28、我现在有一个button要用react在上面绑定点击事件要怎么做




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
