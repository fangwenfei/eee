# React最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、React中的事件是什么？

在 React 中，事件是对鼠标悬停、鼠标单击、按键等特定操作的触发反应。处理这些事件类似于处理 DOM 元素中的事件。但是有一些语法差异，如：

**1、**  用驼峰命名法对事件命名而不是仅使用小写字母。

**2、**  事件作为函数而不是字符串传递。

事件参数重包含一组特定于事件的属性。每个事件类型都包含自己的属性和行为，只能通过其事件处理程序访问。


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


### 3、如何在 Redux 中定义 Action？

React 中的 Action 必须具有 type 属性，该属性指示正在执行的 ACTION 的类型。必须将它们定义为字符串常量，并且还可以向其添加更多的属性。在 Redux 中，action 被名为 Action Creators 的函数所创建。以下是 Action 和Action Creator 的示例：

```
function addTodo(text) {
       return {
                type: ADD_TODO,
                 text
    }
}
```


### 4、mixin、hoc、render props、react-hooks的优劣如何？

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


### 5、setState: React 中用于修改状态更新视图。它具有以下特点:

异步与同步: setState并不是单纯的异步或同步这其实与调用时的环境相关:


### 6、你是如何理解fiber的?

React Fiber 是一种基于浏览器的**单线程调度算法**.

React 16之前 ，`reconcilation` 算法实际上是递归，想要中断递归是很困难的，React 16 开始使用了循环来代替之前的递归.

`Fiber`：**一种将 `recocilation` （递归 diff），拆分成无数个小任务的算法；它随时能够停止，恢复。停止恢复的时机取决于当前的一帧（16ms）内，还有没有足够的时间允许计算。**


### 7、说一下Vue的生命周期

`beforeCreate`是new Vue()之后触发的第一个钩子，在当前阶段data、methods、computed以及watch上的数据和方法都不能被访问。

`created`在实例创建完成后发生，当前阶段已经完成了数据观测，也就是可以使用数据，更改数据，在这里更改数据不会触发updated函数。可以做一些初始数据的获取，在当前阶段无法与Dom进行交互，如果非要想，可以通过vm.$nextTick来访问Dom。

`beforeMount`发生在挂载之前，在这之前template模板已导入渲染函数编译。而当前阶段虚拟Dom已经创建完成，即将开始渲染。在此时也可以对数据进行更改，不会触发updated。

`mounted`在挂载完成后发生，在当前阶段，真实的Dom挂载完毕，数据完成双向绑定，可以访问到Dom节点，使用$refs属性对Dom进行操作。

`beforeUpdate`发生在更新之前，也就是响应式数据发生更新，虚拟dom重新渲染之前被触发，你可以在当前阶段进行更改数据，不会造成重渲染。

`updated`发生在更新完成之后，当前阶段组件Dom已完成更新。要注意的是避免在此期间更改数据，因为这可能会导致无限循环的更新。

`beforeDestroy`发生在实例销毁之前，在当前阶段实例完全可以被使用，我们可以在这时进行善后收尾工作，比如清除计时器。

`destroyed`发生在实例销毁之后，这个时候只剩下了dom空壳。组件已被拆解，数据绑定被卸除，监听被移出，子实例也统统被销毁。


### 8、Redux三大原则

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


### 9、React Portal 有哪些使用场景

在以前 `react` 中所有的组件都会位于 `#app` 下而使用 `Portals` 提供了一种脱离 `#app` 的组件因此 `Portals` 适合脱离文档流(`out of flow`) 的组件特别是 `position: absolute` 与 `position: fixed`的组件。比如模态框通知警告`goTop` 等。

以下是官方一个模态框的示例可以在以下地址中测试效果

```
<html>
  <body>
    <div id="app"></div>
    <div id="modal"></div>
    <div id="gotop"></div>
    <div id="alert"></div>
  </body>
</html>
```

```
const modalRoot = document.getElementById('modal');

class Modal extends React.Component {
  constructor(props) {
    super(props);
    this.el = document.createElement('div');
  }

  componentDidMount() {
    modalRoot.appendChild(this.el);
  }

  componentWillUnmount() {
    modalRoot.removeChild(this.el);
  }

  render() {
    return ReactDOM.createPortal(
      this.props.children,
      this.el,
    );
  }
}
```

`React Hooks`当中的`useEffect`是如何区分生命周期钩子的

`useEffect`可以看成是`componentDidMountcomponentDidUpdate`和`componentWillUnmount`三者的结合。`useEffect(callback, [source])`接收两个参数调用方式如下

```
 useEffect(() => {
   console.log('mounted');
   
   return () => {
       console.log('willUnmount');
   }
 }, [source]);
```

生命周期函数的调用主要是通过第二个参数[source]来进行控制有如下几种情况

**1、** [source]参数不传时则每次都会优先调用上次保存的函数中返回的那个函数然后再调用外部那个函数

**2、** [source]参数传[]时则外部的函数只会在初始化时调用一次返回的那个函数也只会最终在组件卸载时调用一次

**3、** [source]参数有值时则只会监听到数组中的值发生变化后才优先调用返回的那个函数再调用外部的函数。


### 10、如何将两个或多个组件嵌入到一个组件中？

可以通过以下方式将组件嵌入到一个组件中：

```
class MyComponent extends React.Component{
    render(){
        return(
            <div>
                <h1>Hello</h1>
                <Header/>
            </div>
        );
    }
}
class Header extends React.Component{
    render(){
        return
            <h1>Header Component</h1>
   };
}
ReactDOM.render(
    <MyComponent/>, document.getElementById('content')
);
```


### 11、你都做过哪些Vue的性能优化？
### 12、说一下v-if和v-show的区别
### 13、React Router与常规路由有何不同？
### 14、如何在React中创建一个事件？
### 15、什么是高阶组件(HOC)
### 16、再说一下虚拟Dom以及key属性的作用
### 17、redux中间件有哪些，做什么用？
### 18、列出一些应该使用 Refs 的情况。
### 19、生命周期钩子 (useEffect):
### 20、React组件通信如何实现?
### 21、redux异步中间件之间的优劣?
### 22、组件中的data为什么是一个函数？
### 23、react 的渲染过程中兄弟节点之间是怎么处理的也就是key值不一样的时候
### 24、setState到底是异步还是同步?
### 25、为什么需要 React 中的路由？
### 26、详细解释 React 组件的生命周期方法。
### 27、createElement 与 cloneElement 的区别是什么
### 28、你能用HOC做什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
