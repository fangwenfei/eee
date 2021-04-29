# React最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、React最新的生命周期是怎样的?

React 16之后有三个生命周期被废弃(但并未删除)

**1、** componentWillMount

**2、** componentWillReceiveProps

**3、** componentWillUpdate

官方计划在17版本完全删除这三个函数，只保留UNSAVE_前缀的三个函数，目的是为了向下兼容，但是对于开发者而言应该尽量避免使用他们，而是使用新增的生命周期函数替代它们

目前React 16.8 +的生命周期分为三个阶段,分别是挂载阶段、更新阶段、卸载阶段

**挂载阶段:**

**1、** constructor: 构造函数，最先被执行,我们通常在构造函数里初始化state对象或者给自定义方法绑定this

**2、** getDerivedStateFromProps: `static getDerivedStateFromProps(nextProps, prevState)`,这是个静态方法,当我们接收到新的属性想去修改我们state，可以使用getDerivedStateFromProps

**3、** render: render函数是纯函数，只返回需要渲染的东西，不应该包含其它的业务逻辑,可以返回原生的DOM、React组件、Fragment、Portals、字符串和数字、Boolean和null等内容

**4、** componentDidMount: 组件装载之后调用，此时我们可以获取到DOM节点并操作，比如对canvas，svg的操作，服务器请求，订阅都可以写在这个里面，但是记得在componentWillUnmount中取消订阅

**更新阶段:**

**1、** getDerivedStateFromProps: 此方法在更新个挂载阶段都可能会调用

**2、** shouldComponentUpdate: `shouldComponentUpdate(nextProps, nextState)`,有两个参数nextProps和nextState，表示新的属性和变化之后的state，返回一个布尔值，true表示会触发重新渲染，false表示不会触发重新渲染，默认返回true,我们通常利用此生命周期来优化React程序性能

**3、** render: 更新阶段也会触发此生命周期

**4、** getSnapshotBeforeUpdate: `getSnapshotBeforeUpdate(prevProps, prevState)`,这个方法在render之后，componentDidUpdate之前调用，有两个参数prevProps和prevState，表示之前的属性和之前的state，这个函数有一个返回值，会作为第三个参数传给componentDidUpdate，如果你不想要返回值，可以返回null，此生命周期必须与componentDidUpdate搭配使用

**5、** componentDidUpdate: `componentDidUpdate(prevProps, prevState, snapshot)`,该方法在getSnapshotBeforeUpdate方法之后被调用，有三个参数prevProps，prevState，snapshot，表示之前的props，之前的state，和snapshot。第三个参数是getSnapshotBeforeUpdate返回的,如果触发某些回调函数时需要用到 DOM 元素的状态，则将对比或计算的过程迁移至 getSnapshotBeforeUpdate，然后在 componentDidUpdate 中统一触发回调或更新状态。

**卸载阶段:**

componentWillUnmount: 当我们的组件被卸载或者销毁了就会调用，我们可以在这个函数里去清除一些定时器，取消网络请求，清理无效的DOM元素等垃圾清理工作

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_1.png#alt=97%5C_1.png)


### 2、React的请求应该放在哪个生命周期中?

React的异步请求到底应该放在哪个生命周期里,有人认为在`componentWillMount`中可以提前进行异步请求,避免白屏,其实这个观点是有问题的.

由于JavaScript中异步事件的性质，当您启动API调用时，浏览器会在此期间返回执行其他工作。当React渲染一个组件时，它不会等待componentWillMount它完成任何事情 - React继续前进并继续render,没有办法“暂停”渲染以等待数据到达。

而且在`componentWillMount`请求会有一系列潜在的问题,首先,在服务器渲染时,如果在 componentWillMount 里获取数据，fetch data会执行两次，一次在服务端一次在客户端，这造成了多余的请求,其次,在React 16进行React Fiber重写后,`componentWillMount`可能在一次渲染中多次调用.

目前官方推荐的异步请求是在`componentDidmount`中进行.

如果有特殊需求需要提前请求,也可以在特殊情况下在`constructor`中请求:

> react 17之后`componentWillMount`会被废弃,仅仅保留`UNSAFE_componentWillMount`



### 3、React中的合成事件是什么？

合成事件是围绕浏览器原生事件充当跨浏览器包装器的对象。它们将不同浏览器的行为合并为一个 API。这样做是为了确保事件在不同浏览器中显示一致的属性。


### 4、简述flux 思想

**1、** Flux 的最大特点就是数据的"单向流动"。

**2、** 用户访问 `View`

**3、** View发出用户的 `Action`

**4、** `Dispatcher` 收到Action要求 `Store` 进行相应的更新

**5、** `Store` 更新后发出一个"`change`"事件

**6、** `View` 收到"`change`"事件后更新页面


### 5、React组件通信如何实现？

父组件向子组件通讯: 父组件可以向子组件通过传 props 的方式，向子组件进行通讯

子组件向父组件通讯: props+回调的方式,父组件向子组件传递props进行通讯，此props为作用域为父组件自身的函数，子组件调用该函数，将子组件想要传递的信息，作为参数，传递到父组件的作用域中

兄弟组件通信: 找到这两个兄弟节点共同的父节点,结合上面两种方式由父节点转发信息进行通信

跨层级通信:`Context`设计目的是为了共享那些对于一个组件树而言是“全局”的数据，例如当前认证的用户、主题或首选语言,对于跨越多层的全局数据通过`Context`通信再适合不过

发布订阅模式: 发布者发布事件，订阅者监听事件并做出反应,我们可以通过引入event模块进行通信 全局状态管理工具: 借助Redux或者Mobx等全局状态管理工具进行通信,这种工具会维护一个全局状态中心Store,并根据不同的事件产生新的状态


### 6、为什么需要 React 中的路由？

Router 用于定义多个路由，当用户定义特定的 URL 时，如果此 URL 与 Router 内定义的任何 “路由” 的路径匹配，则用户将重定向到该特定路由。所以基本上我们需要在自己的应用中添加一个 Router 库，允许创建多个路由，每个路由都会向我们提供一个独特的视图

```
<switch>
    <route exact path=’/’ component={Home}/>
    <route path=’/posts/:id’ component={Newpost}/>
    <route path=’/posts’   component={Post}/>
</switch>
```


### 7、mixin、hoc、render props、react-hooks的优劣如何？

**Mixin的缺陷：**

**1、** 组件与 Mixin 之间存在隐式依赖（Mixin 经常依赖组件的特定方法，但在定义组件时并不知道这种依赖关系）

**2、** 多个 Mixin 之间可能产生冲突（比如定义了相同的state字段）

**3、** Mixin 倾向于增加更多状态，这降低了应用的可预测性（The more state in your application, the harder it is to reason about it.），导致复杂度剧增

**4、** 隐式依赖导致依赖关系不透明，维护成本和理解成本迅速攀升：

**5、** 难以快速理解组件行为，需要全盘了解所有依赖 Mixin 的扩展行为，及其之间的相互影响

**6、** 组价自身的方法和state字段不敢轻易删改，因为难以确定有没有 Mixin 依赖它

**7、** Mixin 也难以维护，因为 Mixin 逻辑最后会被打平合并到一起，很难搞清楚一个 Mixin 的输入输出

**HOC相比Mixin的优势:**

HOC通过外层组件通过 Props 影响内层组件的状态，而不是直接改变其 State不存在冲突和互相干扰,这就降低了耦合度

不同于 Mixin 的打平+合并，HOC 具有天然的层级结构（组件树结构），这又降低了复杂度

**HOC的缺陷:**

**1、** 扩展性限制: HOC 无法从外部访问子组件的 State因此无法通过shouldComponentUpdate滤掉不必要的更新,React 在支持 ES6 Class 之后提供了React.PureComponent来解决这个问题

**2、** Ref 传递问题: Ref 被隔断,后来的React.forwardRef 来解决这个问题

**3、** Wrapper Hell: HOC可能出现多层包裹组件的情况,多层抽象同样增加了复杂度和理解成本

**4、** 命名冲突: 如果高阶组件多次嵌套,没有使用命名空间的话会产生冲突,然后覆盖老属性

**5、** 不可见性: HOC相当于在原有组件外层再包装一个组件,你压根不知道外层的包装是啥,对于你是黑盒

**Render Props优点:**

上述HOC的缺点Render Props都可以解决

**Render Props缺陷:**

使用繁琐: HOC使用只需要借助装饰器语法通常一行代码就可以进行复用,Render Props无法做到如此简单

嵌套过深: Render Props虽然摆脱了组件多层嵌套的问题,但是转化为了函数回调的嵌套

**React Hooks优点:**

**1、** 简洁: React Hooks解决了HOC和Render Props的嵌套问题,更加简洁

**2、** 解耦: React Hooks可以更方便地把 UI 和状态分离,做到更彻底的解耦

**3、** 组合: Hooks 中可以引用另外的 Hooks形成新的Hooks,组合变化万千

**4、** 函数友好: React Hooks为函数组件而生,从而解决了类组件的几大问题:

**1、** this 指向容易错误

**2、** 分割在不同声明周期中的逻辑使得代码难以理解和维护

**3、** 代码复用成本高（高阶组件容易使代码量剧增）

**React Hooks缺陷:**

**1、** 额外的学习成本（Functional Component 与 Class Component 之间的困惑）

**2、** 写法上有限制（不能出现在条件、循环中），并且写法限制增加了重构成本

**3、** 破坏了PureComponent、React.memo浅比较的性能优化效果（为了取最新的props和state，每次render()都要重新创建事件处函数）

**4、** 在闭包场景可能会引用到旧的state、props值

**5、** 内部实现上不直观（依赖一份可变的全局状态，不再那么“纯”）

**6、** React.memo并不能完全替代shouldComponentUpdate（因为拿不到 state change，只针对 props change）


### 8、React组件通信如何实现?

**React组件间通信方式:**

**1、** 父组件向子组件通讯: 父组件可以向子组件通过传 props 的方式，向子组件进行通讯

**2、** 子组件向父组件通讯: props+回调的方式,父组件向子组件传递props进行通讯，此props为作用域为父组件自身的函数，子组件调用该函数，将子组件想要传递的信息，作为参数，传递到父组件的作用域中

**3、** 兄弟组件通信: 找到这两个兄弟节点共同的父节点,结合上面两种方式由父节点转发信息进行通信

**4、** 跨层级通信: `Context`设计目的是为了共享那些对于一个组件树而言是“全局”的数据，例如当前认证的用户、主题或首选语言,对于跨越多层的全局数据通过`Context`通信再适合不过

**5、** 发布订阅模式: 发布者发布事件，订阅者监听事件并做出反应,我们可以通过引入event模块进行通信

**6、** 全局状态管理工具: 借助Redux或者Mobx等全局状态管理工具进行通信,这种工具会维护一个全局状态中心Store,并根据不同的事件产生新的状态

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_2.png#alt=97%5C_2.png)


### 9、生命周期钩子 (useEffect):

类定义中有许多生命周期函数而在 `React Hooks` 中也提供了一个相应的函数 (`useEffect`)这里可以看做`componentDidMount`、`componentDidUpdate`和`componentWillUnmount`的结合。

**1、** `useEffect(callback, [source])`接受两个参数

**2、** `callback`: 钩子回调函数

**3、** `source`: 设置触发条件仅当 `source` 发生改变时才会触发

**4、** `useEffect`钩子在没有传入[source]参数时默认在每次 `render` 时都会优先调用上次保存的回调中返回的函数后再重新调用回调

```
useEffect(() => {
 // 组件挂载后执行事件绑定
 console.log('on')
 addEventListener()
 // 组件 update 时会执行事件解绑
 return () => {
  console.log('off')
  removeEventListener()
 }
}, [source]);


// 每次 source 发生改变时执行结果(以类定义的生命周期便于大家理解):
// --- DidMount ---
// 'on'
// --- DidUpdate ---
// 'off'
// 'on'
// --- DidUpdate ---
// 'off'
// 'on'
// --- WillUnmount --- 
// 'off'
```

通过第二个参数我们便可模拟出几个常用的生命周期:

**1、** `componentDidMount`: 传入[]时就只会在初始化时调用一次

**2、** `const useMount = (fn) => useEffect(fn, [])`

**3、** `componentWillUnmount`: 传入[]回调中的返回的函数也只会被最终执行一次

**4、** `const useUnmount = (fn) => useEffect(() => fn, [])`

**5、** `mounted`: 可以使用 useState 封装成一个高度可复用的 `mounted` 状态

```
const useMounted = () => {
    const [mounted, setMounted] = useState(false);
    useEffect(() => {
        !mounted && setMounted(true);
        return () => setMounted(false);
    }, []);
    return mounted;
}
componentDidUpdate: useEffect每次均会执行其实就是排除了 DidMount 后即可
const mounted = useMounted() 
useEffect(() => {
    mounted && fn()
})
```

**其它内置钩子:**

**1、** `useContext`: 获取 `context` 对象

**2、** `useReducer`: 类似于 `Redux` 思想的实现但其并不足以替代 Redux可以理解成一个组件内部的 `redux`:并不是持久化存储会随着组件被销毁而销毁

**3、** 属于组件内部各个组件是相互隔离的单纯用它并无法共享数据

**4、** 配合 `useContext`的全局性可以完成一个轻量级的 `Redux`( `easy-peasy`)

**5、** `useCallback`: 缓存回调函数避免传入的回调每次都是新的函数实例而导致依赖组件重新渲染具有性能优化的效果

**6、** `useMemo`: 用于缓存传入的 `props`避免依赖的组件每次都重新渲染

**7、** `useRef`: 获取组件的真实节点

**8、** `useLayoutEffect`

**9、** DOM更新同步钩子。用法与useEffect类似只是区别于执行时间点的不同

**10、** useEffect属于异步执行并不会等待 DOM 真正渲染后执行而 `useLayoutEffect`则会真正渲染后才触发

**11、** 可以获取更新后的 `state`

**12、** 自定义钩子( `useXxxxx`): 基于 `Hooks` 可以引用其它 `Hooks` 这个特性我们可以编写自定义钩子如上面的 `useMounted`。又例如我们需要每个页面自定义标题:

```
function useTitle(title) {
  useEffect(
    () => {
      document.title = title;
    });
}

// 使用:
function Home() {
 const title = '我是首页'
 useTitle(title)
 
 return (
  <div>{title}</div>
 )
}
```


### 10、react性能优化是哪个周期函数

`shouldComponentUpdate` 这个方法用来判断是否需要调用`render`方法重新描绘`dom`。因为dom的描绘非常消耗性能如果我们能在

`shouldComponentUpdate`方法中能够写出更优化的`dom diff`算法可以极大的提高性能


### 11、diff算法?
### 12、redux有什么缺点
### 13、说说你用react有什么坑点
### 14、概述下 React 中的事件处理逻辑
### 15、HOC(高阶组件)
### 16、redux中间件有哪些，做什么用？
### 17、为什么浏览器无法读取JSX？
### 18、什么是高阶组件（HOC）？
### 19、redux异步中间件之间的优劣?
### 20、为什么虚拟dom会提高性能
### 21、再说一下Computed和Watch
### 22、react hooks它带来了那些便利
### 23、nextTick知道吗，实现原理是什么？
### 24、你对受控组件和非受控组件了解多少？
### 25、redux中间件
### 26、react 的渲染过程中兄弟节点之间是怎么处理的也就是key值不一样的时候
### 27、列出React的一些主要优点。




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
