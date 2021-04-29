# React最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Store 在 Redux 中的意义是什么？

Store 是一个 JavaScript 对象，它可以保存程序的状态，并提供一些方法来访问状态、调度操作和注册侦听器。应用程序的整个状态/对象树保存在单一存储中。因此，Redux 非常简单且是可预测的。我们可以将中间件传递到 store 来处理数据，并记录改变存储状态的各种操作。所有操作都通过 reducer 返回一个新状态。


### 2、如何在 React 中创建表单

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


### 3、区分状态和 props
| 条件 | State | Props |
| --- | --- | --- |
| 1、从父组件中接收初始值 | Yes | Yes |
| 2、父组件可以改变值 | No | Yes |
| 3、在组件中设置默认值 | Yes | Yes |
| 4、在组件的内部变化 | Yes | No |
| 5、设置子组件的初始值 | Yes | Yes |
| 6、在子组件的内部更改 | No | Yes |



### 4、redux的工作流程?

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


### 5、React 中的箭头函数是什么？怎么用？

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


### 6、什么是JSX？

JSX 是J avaScript XML 的简写。是 React 使用的一种文件，它利用 JavaScript 的表现力和类似 HTML 的模板语法。这使得 HTML 文件非常容易理解。此文件能使应用非常可靠，并能够提高其性能。下面是JSX的一个例子：

```
render(){
    return(
        <div>
            <h1> Hello World from Edureka!!</h1>
        </div>
    );
}
```


### 7、详细解释 React 组件的生命周期方法。

**一些最重要的生命周期方法是：**

**1、**  _componentWillMount_() – 在渲染之前执行，在客户端和服务器端都会执行。

**2、**  _componentDidMount_() – 仅在第一次渲染后在客户端执行。

**3、**  _componentWillReceiveProps_() – 当从父类接收到 props 并且在调用另一个渲染器之前调用。

**4、**  _shouldComponentUpdate_() – 根据特定条件返回 true 或 false。如果你希望更新组件，请返回true 否则返回 false。默认情况下，它返回 false。

**5、**  _componentWillUpdate_() – 在 DOM 中进行渲染之前调用。

**6、**  _componentDidUpdate_() – 在渲染发生后立即调用。

**7、**  _componentWillUnmount_() – 从 DOM 卸载组件后调用。用于清理内存空间。


### 8、redux中间件

中间件提供第三方插件的模式自定义拦截 `action -> reducer` 的过程。变为 `action` -> `middlewares` -> `reducer`。这种机制可以让我们改变数据流实现如异步`action action` 过滤日志输出异常报告等功能

**1、** `redux-logger`提供日志输出

**2、** `redux-thunk`处理异步操作

**3、** `redux-promise`处理异步操作 `actionCreator`的返回值是 `promise`


### 9、connect原理

首先`connect`之所以会成功是因为`Provider`组件在原应用组件上包裹一层使原来整个应用成为`Provider`的子组件接收`Redux`的`store`作为`props`通过`context`对象传递给子孙组件上的`connect`connect做了些什么。它真正连接 `Redux`和 `React`它包在我们的容器组件的外一层它接收上面 `Provider` 提供的 `store` 里面的`state` 和 `dispatch`传给一个构造函数返回一个对象以属性形式传给我们的容器组件

`connect`是一个高阶函数首先传入mapStateToProps、mapDispatchToProps然后返回一个生产Component的函数(wrapWithConnect)然后再将真正的Component作为参数传入wrapWithConnect这样就生产出一个经过包裹的Connect组件该组件具有如下特点

通过`props.store`获取祖先`Component`的`store props`包括`stateProps`、`dispatchProps`、`parentProps`,合并在一起得到`nextState`作为`props`传给真正的`Component componentDidMount`时添加事件`this.store.subscribe(this.handleChange)`实现页面交互`shouldComponentUpdate`时判断是否有避免进行渲染提升页面性能并得到nextState componentWillUnmount时移除注册的事件`this.handleChange`

由于connect的源码过长我们只看主要逻辑

```
export default function connect(mapStateToProps, mapDispatchToProps, mergeProps, options = {}) {
  return function wrapWithConnect(WrappedComponent) {
    class Connect extends Component {
      constructor(props, context) {
        // 从祖先Component处获得store
        this.store = props.store || context.store
        this.stateProps = computeStateProps(this.store, props)
        this.dispatchProps = computeDispatchProps(this.store, props)
        this.state = { storeState: null }
        // 对stateProps、dispatchProps、parentProps进行合并
        this.updateState()
      }
      shouldComponentUpdate(nextProps, nextState) {
        // 进行判断当数据发生改变时Component重新渲染
        if (propsChanged 
        || mapStateProducedChange 
        || dispatchPropsChanged) {
          this.updateState(nextProps)
            return true
          }
        }
        componentDidMount() {
          // 改变Component的state
          this.store.subscribe(() = {
            this.setState({
              storeState: this.store.getState()
            })
          })
        }
        render() {
          // 生成包裹组件Connect
          return (
            <WrappedComponent {...this.nextState} />
          )
        }
      }
      Connect.contextTypes = {
        store: storeShape
      }
      return Connect;
    }
  }
```


### 10、setState

在了解`setState`之前我们先来简单了解下 `React` 一个包装结构: `Transaction`:

**事务 (Transaction)**

是 `React` 中的一个调用结构用于包装一个方法结构为: `initialize` - `perform(method)` - `close`。通过事务可以统一管理一个方法的开始与结束处于事务流中表示进程正在执行一些操作


### 11、react hooks它带来了那些便利
### 12、具体实现步骤如下
### 13、Vue模版编译原理知道吗，能简单说一下吗？
### 14、那你知道Vue3.x响应式数据原理吗？
### 15、React中的合成事件是什么？
### 16、你对 Time Slice的理解?
### 17、为什么React Router v4中使用 switch 关键字 ？
### 18、pureComponent和FunctionComponent区别
### 19、keep-alive了解吗
### 20、Redux实现原理解析
### 21、Vue2.x组件通信有哪些方式？
### 22、MVC框架的主要问题是什么？
### 23、如何更新组件的状态？
### 24、setState到底是异步还是同步?
### 25、解释 Reducer 的作用。
### 26、React的请求应该放在哪个生命周期中?
### 27、说说你用react有什么坑点
### 28、Redux与Flux有何不同？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
