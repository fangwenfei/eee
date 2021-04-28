# React最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、概述下 React 中的事件处理逻辑

为了解决跨浏览器兼容性问题`React` 会将浏览器原生事件`Browser Native Event`封装为合成事件`SyntheticEvent`传入设置的事件处理器中。这里的合成事件提供了与原生事件相同的接口不过它们屏蔽了底层浏览器的细节差异保证了行为的一致性。另外有意思的是React 并没有直接将事件附着到子元素上而是以单一事件监听器的方式将所有的事件发送到顶层进行处理。这样 `React` 在更新 `DOM` 的时候就不需要考虑如何去处理附着在 `DOM` 上的事件监听器最终达到优化性能的目的


### 2、详细解释 React 组件的生命周期方法。

**一些最重要的生命周期方法是：**

**1、**  _componentWillMount_() – 在渲染之前执行，在客户端和服务器端都会执行。

**2、**  _componentDidMount_() – 仅在第一次渲染后在客户端执行。

**3、**  _componentWillReceiveProps_() – 当从父类接收到 props 并且在调用另一个渲染器之前调用。

**4、**  _shouldComponentUpdate_() – 根据特定条件返回 true 或 false。如果你希望更新组件，请返回true 否则返回 false。默认情况下，它返回 false。

**5、**  _componentWillUpdate_() – 在 DOM 中进行渲染之前调用。

**6、**  _componentDidUpdate_() – 在渲染发生后立即调用。

**7、**  _componentWillUnmount_() – 从 DOM 卸载组件后调用。用于清理内存空间。


### 3、Redux设计理念

`Redux`是将整个应用状态存储到一个地方上称为`store`,里面保存着一个状态树`store` `tree`,组件可以派发(`dispatch`)行为(`action`)给`store`,而不是直接通知其他组件组件内部通过订阅`store`中的状态`state`来刷新自己的视图

![80_2.png][80_2.png]

image


### 4、react 的渲染过程中兄弟节点之间是怎么处理的也就是key值不一样的时候

通常我们输出节点的时候都是`map`一个数组然后返回一个`ReactNode`为了方便`react`内部进行优化我们必须给每一个`reactNode`添加`key`这个`key prop`在设计值处不是给开发者用的而是给react用的大概的作用就是给每一个reactNode添加一个身份标识方便react进行识别在重渲染过程中如果key一样若组件属性有所变化则`react`只更新组件对应的属性没有变化则不更新如果`key`不一样则`react`先销毁该组件然后重新创建该组件


### 5、如何更新组件的状态？

可以用 `this.setState()`更新组件的状态。

```
class MyComponent extends React.Component {
    constructor() {
        super();
        this.state = {
            name: 'Maxx',
            id: '101'
        }
    }
    render()
        {
            setTimeout(()=>{this.setState({name:'Jaeha', id:'222'})},2000)
            return (
                <div>
                    <h1>Hello {this.state.name}</h1>
                    <h2>Your Id is {this.state.id}</h2>
                </div>
            );
        }
    }
ReactDOM.render(
    <MyComponent/>, document.getElementById('content')
);
```


### 6、React组件通信如何实现？

父组件向子组件通讯: 父组件可以向子组件通过传 props 的方式，向子组件进行通讯

子组件向父组件通讯: props+回调的方式,父组件向子组件传递props进行通讯，此props为作用域为父组件自身的函数，子组件调用该函数，将子组件想要传递的信息，作为参数，传递到父组件的作用域中

兄弟组件通信: 找到这两个兄弟节点共同的父节点,结合上面两种方式由父节点转发信息进行通信

跨层级通信:`Context`设计目的是为了共享那些对于一个组件树而言是“全局”的数据，例如当前认证的用户、主题或首选语言,对于跨越多层的全局数据通过`Context`通信再适合不过

发布订阅模式: 发布者发布事件，订阅者监听事件并做出反应,我们可以通过引入event模块进行通信 全局状态管理工具: 借助Redux或者Mobx等全局状态管理工具进行通信,这种工具会维护一个全局状态中心Store,并根据不同的事件产生新的状态


### 7、什么是 Props?

Props 是 React 中属性的简写。它们是只读组件，必须保持纯，即不可变。它们总是在整个应用中从父组件传递到子组件。子组件永远不能将 prop 送回父组件。这有助于维护单向数据流，通常用于呈现动态生成的数据。


### 8、你是如何理解fiber的?

React Fiber 是一种基于浏览器的**单线程调度算法**.

React 16之前 ，`reconcilation` 算法实际上是递归，想要中断递归是很困难的，React 16 开始使用了循环来代替之前的递归.

`Fiber`：**一种将 `recocilation` （递归 diff），拆分成无数个小任务的算法；它随时能够停止，恢复。停止恢复的时机取决于当前的一帧（16ms）内，还有没有足够的时间允许计算。**


### 9、列出 React Router 的优点。

**几个优点是：**

**1、**  就像 React 基于组件一样，在 React Router v4 中，API 是 _'All About Components'_。可以将 Router 可视化为单个根组件（`<BrowserRouter>`），其中我们将特定的子路由（`<route>`）包起来。

**2、**  无需手动设置历史值：在 React Router v4 中，我们要做的就是将路由包装在 `<BrowserRouter>` 组件中。

**3、**  包是分开的：共有三个包，分别用于 Web、Native 和 Core。这使我们应用更加紧凑。基于类似的编码风格很容易进行切换。


### 10、你的接口请求一般放在哪个生命周期中？

接口请求一般放在`mounted`中，但需要注意的是服务端渲染时不支持mounted，需要放到`created`中。


### 11、react性能优化是哪个周期函数
### 12、列出 Redux 的组件。
### 13、React中的事件是什么？
### 14、简述flux 思想
### 15、什么是React 路由？
### 16、什么是JSX？
### 17、react-redux是如何工作的?
### 18、再说一下虚拟Dom以及key属性的作用
### 19、为什么选择使用框架而不是原生?
### 20、Vue2.x组件通信有哪些方式？
### 21、redux与mobx的区别?
### 22、Redux三大原则
### 23、SSR了解吗？
### 24、React组件生命周期的阶段是什么？
### 25、React如何进行组件/逻辑复用?
### 26、connect原理
### 27、createElement 与 cloneElement 的区别是什么
### 28、生命周期钩子 (useEffect):




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
