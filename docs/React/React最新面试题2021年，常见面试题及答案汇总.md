# React最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、React与Angular有何不同？
| 主题 | React | Angular |
| --- | --- | --- |
| _1、体系结构_ | 只有 MVC 中的 View | 完整的 MVC |
| _2、渲染_ | 可以在服务器端渲染 | 客户端渲染 |
| _3、DOM_ | 使用 virtual DOM | 使用 real DOM |
| _4、数据绑定_ | 单向数据绑定 | 双向数据绑定 |
| _5、调试_ | 编译时调试 | 运行时调试 |
| _6、作者_ | Facebook | Google |



### 2、Store 在 Redux 中的意义是什么？

Store 是一个 JavaScript 对象，它可以保存程序的状态，并提供一些方法来访问状态、调度操作和注册侦听器。应用程序的整个状态/对象树保存在单一存储中。因此，Redux 非常简单且是可预测的。我们可以将中间件传递到 store 来处理数据，并记录改变存储状态的各种操作。所有操作都通过 reducer 返回一个新状态。


### 3、解释一下 Flux

Flux 是一种强制单向数据流的架构模式。它控制派生数据，并使用具有所有数据权限的中心 store 实现多个组件之间的通信。整个应用中的数据更新必须只能在此处进行。 Flux 为应用提供稳定性并减少运行时的错误。


### 4、如何模块化 React 中的代码？

可以使用 export 和 import 属性来模块化代码。它们有助于在不同的文件中单独编写组件。

```
//ChildComponent.jsx
export default class ChildComponent extends React.Component {
    render() {
        return(
              <div>
                  <h1>This is a child component</h1>
              </div>
        );
    }
}

//ParentComponent.jsx
import ChildComponent from './childcomponent.js';
class ParentComponent extends React.Component {
    render() {
        return(
             <div>
                <App />
             </div>
        );
    }
}
```


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


### 6、react-router里的标签和`<a>`标签有什么区别

对比`<a>`,`Link`组件避免了不必要的重渲染


### 7、列出React的一些主要优点。

React的一些主要优点是：

**1、**  它提高了应用的性能

**2、**  可以方便地在客户端和服务器端使用

**3、**  由于 JSX，代码的可读性很好

**4、**  React 很容易与 Meteor，Angular 等其他框架集成

**5、**  使用React，编写UI测试用例变得非常容易


### 8、React的请求应该放在哪个生命周期中?

React的异步请求到底应该放在哪个生命周期里,有人认为在`componentWillMount`中可以提前进行异步请求,避免白屏,其实这个观点是有问题的.

由于JavaScript中异步事件的性质，当您启动API调用时，浏览器会在此期间返回执行其他工作。当React渲染一个组件时，它不会等待componentWillMount它完成任何事情 - React继续前进并继续render,没有办法“暂停”渲染以等待数据到达。

而且在`componentWillMount`请求会有一系列潜在的问题,首先,在服务器渲染时,如果在 componentWillMount 里获取数据，fetch data会执行两次，一次在服务端一次在客户端，这造成了多余的请求,其次,在React 16进行React Fiber重写后,`componentWillMount`可能在一次渲染中多次调用.

目前官方推荐的异步请求是在`componentDidmount`中进行.

如果有特殊需求需要提前请求,也可以在特殊情况下在`constructor`中请求:

> react 17之后`componentWillMount`会被废弃,仅仅保留`UNSAFE_componentWillMount`



### 9、HOC(高阶组件)

`HOC(Higher Order Componennt)` 是在 `React` 机制下社区形成的一种组件模式在很多第三方开源库中表现强大。

简述:

**1、** 高阶组件不是组件是 增强函数可以输入一个元组件返回出一个新的增强组件

**2、** 高阶组件的主要作用是 代码复用操作 状态和参数用法:

属性代理 (Props Proxy): 返回出一个组件它基于被包裹组件进行 功能增强默认参数: 可以为组件包裹一层默认参数

```
function proxyHoc(Comp) {
 return class extends React.Component {
  render() {
   const newProps = {
    name: 'tayde',
    age: 1,
   }
   return <Comp {...this.props} {...newProps} />
  }
 }
}
```

提取状态: 可以通过 `props` 将被包裹组件中的 `state` 依赖外层例如用于转换受控组件:

```
function withOnChange(Comp) {
 return class extends React.Component {
  constructor(props) {
   super(props)
   this.state = {
    name: '',
   }
  }
  onChangeName = () => {
   this.setState({
    name: 'dongdong',
   })
  }
  render() {
   const newProps = {
    value: this.state.name,
    onChange: this.onChangeName,
   }
   return <Comp {...this.props} {...newProps} />
  }
 }
}
```

使用姿势如下这样就能非常快速的将一个 `Input` 组件转化成受控组件。

```
const NameInput = props => (<input name="name" {...props} />)
export default withOnChange(NameInput)
```

包裹组件: 可以为被包裹元素进行一层包装

```
function withMask(Comp) {
  return class extends React.Component {
   render() {
   return (
     <div>
     <Comp {...this.props}/>
     <div style={{
       width: '100%',
       height: '100%',
       backgroundColor: 'rgba(0, 0, 0, .6)',
     }} 
    </div>
   )
   }
  }
}
```

反向继承 (`Inheritance Inversion`): 返回出一个组件继承于被包裹组件常用于以下操作

```
function IIHoc(Comp) {
    return class extends Comp {
        render() {
            return super.render();
        }
    };
}
```

渲染劫持 (Render Highjacking)

条件渲染: 根据条件渲染不同的组件

```
function withLoading(Comp) {
  return class extends Comp {
    render() {
      if(this.props.isLoading) {
          return <Loading />
      } else {
          return super.render()
      }
    }
  };
}
```

可以直接修改被包裹组件渲染出的 React 元素树

操作状态 (`Operate State`): 可以直接通过 `this.state` 获取到被包裹组件的状态并进行操作。但这样的操作容易使 `state` 变得难以追踪不易维护谨慎使用。

应用场景:

权限控制通过抽象逻辑统一对页面进行权限判断按不同的条件进行页面渲染:

```
function withAdminAuth(WrappedComponent) {
  return class extends React.Component {
   constructor(props){
    super(props)
    this.state = {
        isAdmin: false,
    }
   } 
   async componentWillMount() {
     const currentRole = await getCurrentUserRole();
     this.setState({
         isAdmin: currentRole === 'Admin',
     });
   }
   render() {
     if (this.state.isAdmin) {
       return <Comp {...this.props} />;
     } else {
       return (<div>您没有权限查看该页面请联系管理员</div>);
     }
   }
  };
}
```

性能监控包裹组件的生命周期进行统一埋点:

```
function withTiming(Comp) {
    return class extends Comp {
        constructor(props) {
            super(props);
            this.start = Date.now();
            this.end = 0;
        }
        componentDidMount() {
            super.componentDidMount && super.componentDidMount();
            this.end = Date.now();
            console.log(`${WrappedComponent.name} 组件渲染时间为 ${this.end - this.start} ms`);
        }
        render() {
            return super.render();
        }
    };
}
```

代码复用可以将重复的逻辑进行抽象。

**使用注意:**

**1、** 纯函数: 增强函数应为纯函数避免侵入修改元组件

**2、** 避免用法污染: 理想状态下应透传元组件的无关参数与事件尽量保证用法不变

**3、** 命名空间: 为 `HOC`增加特异性的组件名称这样能便于开发调试和查找问题

**4、** 引用传递: 如果需要传递元组件的 `refs` 引用可以使用 `React.forwardRef`

**5、** 静态方法: 元组件上的静态方法并无法被自动传出会导致业务层无法调用解决:

**6、** 函数导出

**7、** 静态方法赋值

**8、** 重新渲染: 由于增强函数每次调用是返回一个新组件因此如果在 `Render`中使用增强函数就会导致每次都重新渲染整个 `HOC`而且之前的状态会丢失


### 10、你理解“在React中，一切都是组件”这句话。

组件是 React 应用 UI 的构建块。这些组件将整个 UI 分成小的独立并可重用的部分。每个组件彼此独立，而不会影响 UI 的其余部分。


### 11、hash路由和history路由实现原理说一下
### 12、React有什么特点？
### 13、你对 Time Slice的理解?
### 14、keep-alive了解吗
### 15、redux的工作流程?
### 16、概述下 React 中的事件处理逻辑
### 17、React实现的移动应用中如果出现卡顿有哪些可以考虑的优化方案
### 18、React 中 refs 的作用是什么
### 19、redux与mobx的区别?
### 20、Vue事件绑定原理说一下
### 21、nextTick知道吗，实现原理是什么？
### 22、如何在 React 中创建表单
### 23、React最新的生命周期是怎样的?
### 24、什么是React 路由？
### 25、解释 React 中 render() 的目的。
### 26、那你能讲一讲MVVM吗？
### 27、redux有什么缺点




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
