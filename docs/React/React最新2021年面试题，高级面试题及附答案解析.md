# React最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、说一下Vue的生命周期

`beforeCreate`是new Vue()之后触发的第一个钩子，在当前阶段data、methods、computed以及watch上的数据和方法都不能被访问。

`created`在实例创建完成后发生，当前阶段已经完成了数据观测，也就是可以使用数据，更改数据，在这里更改数据不会触发updated函数。可以做一些初始数据的获取，在当前阶段无法与Dom进行交互，如果非要想，可以通过vm.$nextTick来访问Dom。

`beforeMount`发生在挂载之前，在这之前template模板已导入渲染函数编译。而当前阶段虚拟Dom已经创建完成，即将开始渲染。在此时也可以对数据进行更改，不会触发updated。

`mounted`在挂载完成后发生，在当前阶段，真实的Dom挂载完毕，数据完成双向绑定，可以访问到Dom节点，使用$refs属性对Dom进行操作。

`beforeUpdate`发生在更新之前，也就是响应式数据发生更新，虚拟dom重新渲染之前被触发，你可以在当前阶段进行更改数据，不会造成重渲染。

`updated`发生在更新完成之后，当前阶段组件Dom已完成更新。要注意的是避免在此期间更改数据，因为这可能会导致无限循环的更新。

`beforeDestroy`发生在实例销毁之前，在当前阶段实例完全可以被使用，我们可以在这时进行善后收尾工作，比如清除计时器。

`destroyed`发生在实例销毁之后，这个时候只剩下了dom空壳。组件已被拆解，数据绑定被卸除，监听被移出，子实例也统统被销毁。


### 2、react hooks它带来了那些便利

**1、** 代码逻辑聚合逻辑复用

**2、** `HOC`嵌套地狱

**3、** 代替 `class`

**4、** `React` 中通常使用 类定义 或者 函数定义 创建组件:

在类定义中我们可以使用到许多 `React` 特性例如 `state`、 各种组件生命周期钩子等但是在函数定义中我们却无能为力因此 `React 16.8` 版本推出了一个新功能 (`React Hooks`)通过它可以更好的在函数定义组件中使用 `React` 特性。

**好处:**

**1、** 跨组件复用: 其实 `render` `props` / `HOC` 也是为了复用相比于它们Hooks 作为官方的底层 `API`最为轻量而且改造成本小不会影响原来的* 组件层次结构和传说中的嵌套地狱

**2、** 类定义更为复杂

**3、** 不同的生命周期会使逻辑变得分散且混乱不易维护和管理

**4、** 时刻需要关注 `this`的指向问题

**5、** 代码复用代价高高阶组件的使用经常会使整个组件树变得臃肿

**6、** 状态与UI隔离: 正是由于 `Hooks` 的特性状态逻辑会变成更小的粒度并且极容易被抽象成一个自定义 `Hooks`组件中的状态和 `UI` 变得更为清晰和隔离。

注意:

避免在 循环/条件判断/嵌套函数 中调用 `hooks`保证调用顺序的稳定只有 函数定义组件 和 `hooks` 可以调用 `hooks`避免在 类组件 或者 普通函数 中调用不能在`useEffect`中使用`useStateReact` 会报错提示类组件不会被替换或废弃不需要强制改造类组件两种方式能并存重要钩子

状态钩子 (`useState`): 用于定义组件的`State`其到类定义中`this.state`的功能

```
// useState 只接受一个参数: 初始状态
// 返回的是组件名和更改该组件对应的函数
const [flag, setFlag] = useState(true);
// 修改状态
setFlag(false)
 
// 上面的代码映射到类定义中:
this.state = {
 flag: true 
}
const flag = this.state.flag
const setFlag = (bool) => {
    this.setState({
        flag: bool,
    })
}
```


### 3、解释 React 中 render() 的目的。

每个React组件强制要求必须有一个 render()。它返回一个 React 元素，是原生 DOM 组件的表示。如果需要渲染多个 HTML 元素，则必须将它们组合在一个封闭标记内，例如 `<form>`、`<group>`、`<div>` 等。此函数必须保持纯净，即必须每次调用时都返回相同的结果。


### 4、redux异步中间件之间的优劣?

**redux-thunk优点:**

**1、** 体积小: redux-thunk的实现方式很简单,只有不到20行代码

**2、** 使用简单: redux-thunk没有引入像redux-saga或者redux-observable额外的范式,上手简单

**redux-thunk缺陷:**

**1、** 样板代码过多: 与redux本身一样,通常一个请求需要大量的代码,而且很多都是重复性质的

**2、** 耦合严重: 异步操作与redux的action偶合在一起,不方便管理

**3、** 功能孱弱: 有一些实际开发中常用的功能需要自己进行封装

**redux-saga优点:**

**1、** 异步解耦: 异步操作被被转移到单独 saga.js 中，不再是掺杂在 action.js 或 component.js 中

**2、** action摆脱thunk function: dispatch 的参数依然是一个纯粹的 action (FSA)，而不是充满 “黑魔法” thunk function

**3、** 异常处理: 受益于 generator function 的 saga 实现，代码异常/请求失败 都可以直接通过 try/catch 语法直接捕获处理

**4、** 功能强大: redux-saga提供了大量的Saga 辅助函数和Effect 创建器供开发者使用,开发者无须封装或者简单封装即可使用

**5、** 灵活: redux-saga可以将多个Saga可以串行/并行组合起来,形成一个非常实用的异步flow

**6、** 易测试，提供了各种case的测试方案，包括mock task，分支覆盖等等

**redux-saga缺陷:**

**1、** 额外的学习成本: redux-saga不仅在使用难以理解的 generator function,而且有数十个API,学习成本远超redux-thunk,最重要的是你的额外学习成本是只服务于这个库的,与redux-observable不同,redux-observable虽然也有额外学习成本但是背后是rxjs和一整套思想

**2、** 体积庞大: 体积略大,代码近2000行，min版25KB左右

**3、** 功能过剩: 实际上并发控制等功能很难用到,但是我们依然需要引入这些代码

**4、** ts支持不友好: yield无法返回TS类型

**redux-observable优点:**

**1、** 功能最强: 由于背靠rxjs这个强大的响应式编程的库,借助rxjs的操作符,你可以几乎做任何你能想到的异步处理

**2、** 背靠rxjs: 由于有rxjs的加持,如果你已经学习了rxjs,redux-observable的学习成本并不高,而且随着rxjs的升级redux-observable也会变得更强大

**redux-observable缺陷:**

学习成本奇高: 如果你不会rxjs,则需要额外学习两个复杂的库

社区一般: redux-observable的下载量只有redux-saga的1/5,社区也不够活跃,在复杂异步流中间件这个层面redux-saga仍处于领导地位



### 5、你能用HOC做什么？

**HOC可用于许多任务，例如：**

**1、** 代码重用，逻辑和引导抽象

**2、** 渲染劫持

**3、** 状态抽象和控制

**4、** Props 控制


### 6、再说一下虚拟Dom以及key属性的作用

由于在浏览器中操作DOM是很昂贵的。频繁的操作DOM，会产生一定的性能问题。这就是虚拟Dom的`产生原因`。

Vue2的Virtual DOM借鉴了开源库`snabbdom`的实现。

`Virtual DOM本质就是用一个原生的JS对象去描述一个DOM节点。是对真实DOM的一层抽象。`(也就是源码中的VNode类，它定义在src/core/vdom/vnode.js中。)

VirtualDOM映射到真实DOM要经历VNode的create、diff、patch等阶段。

**「key的作用是尽可能的复用 DOM 元素。」**

新旧 children 中的节点只有顺序是不同的时候，最佳的操作应该是通过移动元素的位置来达到更新的目的。

需要在新旧 children 的节点中保存映射关系，以便能够在旧 children 的节点中找到可复用的节点。key也就是children中节点的唯一标识。


### 7、生命周期钩子 (useEffect):

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


### 8、再说一下vue2.x中如何监测数组变化
### 9、销毁阶段
### 10、setState到底是异步还是同步?
### 11、React与Vue的相似之处
### 12、你是如何理解fiber的?
### 13、区分Real DOM和Virtual DOM
### 14、为什么要用redux
### 15、说一下v-if和v-show的区别
### 16、如何告诉 React 它应该编译生产环境版
### 17、react 的虚拟dom是怎么实现的
### 18、react性能优化是哪个周期函数
### 19、React如何进行组件/逻辑复用?
### 20、Redux三大原则
### 21、Vue事件绑定原理说一下
### 22、如何在 React 中创建表单
### 23、Vue模版编译原理知道吗，能简单说一下吗？
### 24、mixin、hoc、render props、react-hooks的优劣如何？
### 25、Vue中组件生命周期调用顺序说一下
### 26、React Portal 有哪些使用场景
### 27、列出 Redux 的组件。
### 28、react组件的划分业务组件技术组件




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
