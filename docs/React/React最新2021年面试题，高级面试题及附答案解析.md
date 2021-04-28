# React最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、为什么React Router v4中使用 switch 关键字 ？

虽然 `<div>`  用于封装 Router 中的多个路由，当你想要仅显示要在多个定义的路线中呈现的单个路线时，可以使用 “switch” 关键字。使用时，`<switch>` 标记会按顺序将已定义的 URL 与已定义的路由进行匹配。找到第一个匹配项后，它将渲染指定的路径。从而绕过其它路线。


### 2、React的请求应该放在哪个生命周期中?

React的异步请求到底应该放在哪个生命周期里,有人认为在`componentWillMount`中可以提前进行异步请求,避免白屏,其实这个观点是有问题的.

由于JavaScript中异步事件的性质，当您启动API调用时，浏览器会在此期间返回执行其他工作。当React渲染一个组件时，它不会等待componentWillMount它完成任何事情 - React继续前进并继续render,没有办法“暂停”渲染以等待数据到达。

而且在`componentWillMount`请求会有一系列潜在的问题,首先,在服务器渲染时,如果在 componentWillMount 里获取数据，fetch data会执行两次，一次在服务端一次在客户端，这造成了多余的请求,其次,在React 16进行React Fiber重写后,`componentWillMount`可能在一次渲染中多次调用.

目前官方推荐的异步请求是在`componentDidmount`中进行.

如果有特殊需求需要提前请求,也可以在特殊情况下在`constructor`中请求:

> react 17之后`componentWillMount`会被废弃,仅仅保留`UNSAFE_componentWillMount`



### 3、那你知道Vue3.x响应式数据原理吗？

(还好我有看，这个难不倒我)

Vue3.x改用`Proxy`替代Object.defineProperty。因为Proxy可以直接监听对象和数组的变化，并且有多达13种拦截方法。并且作为新标准将受到浏览器厂商重点持续的性能优化。

**Proxy只会代理对象的第一层，那么Vue3又是怎样处理这个问题的呢？**

判断当前Reflect.get的返回值是否为Object，如果是则再通过`reactive`方法做代理， 这样就实现了深度观测。

**监测数组的时候可能触发多次get/set，那么如何防止触发多次呢？**

我们可以判断key是否为当前被代理对象target自身属性，也可以判断旧值与新值是否相等，只有满足以上两个条件之一时，才有可能执行trigger。

面试官抬起了头。心里暗想

(这小子还行，比上两个强，应该是多多少少看过Vue3的源码了)


### 4、HOC(高阶组件)

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


### 5、react组件的划分业务组件技术组件

根据组件的职责通常把组件分为`UI`组件和容器组件。`UI` 组件负责 `UI` 的呈现容器组件负责管理数据和逻辑。两者通过`React-Redux` 提供`connect`方法联系起来


### 6、Vue模版编译原理知道吗，能简单说一下吗？

简单说，Vue的编译过程就是将`template`转化为`render`函数的过程。会经历以下阶段：

**1、** 生成AST树

2、优化

**3、** codegen

首先解析模版，生成`AST语法树`(一种用JavaScript对象的形式来描述整个模板)。 使用大量的正则表达式对模板进行解析，遇到标签、文本的时候都会执行对应的钩子进行相关处理。

Vue的数据是响应式的，但其实模板中并不是所有的数据都是响应式的。有一些数据首次渲染后就不会再变化，对应的DOM也不会变化。那么优化过程就是深度遍历AST树，按照相关条件对树节点进行标记。这些被标记的节点(静态节点)我们就可以`跳过对它们的比对`，对运行时的模板起到很大的优化作用。

编译的最后一步是`将优化后的AST树转换为可执行的代码`。


### 7、说一下v-if和v-show的区别

当条件不成立时，`v-if`不会渲染DOM元素，`v-show`操作的是样式(display)，切换当前DOM的显示和隐藏。


### 8、解释一下 Flux

Flux 是一种强制单向数据流的架构模式。它控制派生数据，并使用具有所有数据权限的中心 store 实现多个组件之间的通信。整个应用中的数据更新必须只能在此处进行。 Flux 为应用提供稳定性并减少运行时的错误。


### 9、Vue2.x和Vue3.x渲染器的diff算法分别说一下

**简单来说，diff算法有以下过程**

**1、** 同级比较，再比较子节点

**2、** 先判断一方有子节点一方没有子节点的情况(如果新的children没有子节点，将旧的子节点移除)

**3、** 比较都有子节点的情况(核心diff)

**4、** 递归比较子节点

正常Diff两个树的时间复杂度是`O(n^3)`，但实际情况下我们很少会进行`跨层级的移动DOM`，所以Vue将Diff进行了优化，从`O(n^3) -> O(n)`，只有当新旧children都为多个子节点时才需要用核心的Diff算法进行同层级比较。

Vue2的核心Diff算法采用了`双端比较`的算法，同时从新旧children的两端开始进行比较，借助key值找到可复用的节点，再进行相关操作。相比React的Diff算法，同样情况下可以减少移动节点次数，减少不必要的性能损耗，更加的优雅。

Vue3.x借鉴了 [ivi](https://github.com/localvoid/ivi)算法和 [inferno](https://github.com/infernojs/inferno)算法

在创建VNode时就确定其类型，以及在`mount/patch`的过程中采用`位运算`来判断一个VNode的类型，在这个基础之上再配合核心的Diff算法，使得性能上较Vue2.x有了提升。(实际的实现可以结合Vue3.x源码看。)

该算法中还运用了`动态规划`的思想求解最长递归子序列。

(看到这你还会发现，框架内无处不蕴藏着数据结构和算法的魅力)

**面试官：(可以可以，看来是个苗子，不过自我介绍属实有些无聊，下一题)**


### 10、React 中 key 的重要性是什么？

key 用于识别唯一的 Virtual DOM 元素及其驱动 UI 的相应数据。它们通过回收 DOM 中当前所有的元素来帮助 React 优化渲染。这些 key 必须是唯一的数字或字符串，React 只是重新排序元素而不是重新渲染它们。这可以提高应用程序的性能。


### 11、react性能优化方案
### 12、你能用HOC做什么？
### 13、React有什么特点？
### 14、什么是 Props?
### 15、setState: React 中用于修改状态更新视图。它具有以下特点:
### 16、你对 React 的 refs 有什么了解？
### 17、redux与mobx的区别?
### 18、react旧版生命周期函数
### 19、虚拟DOM实现原理?
### 20、React Portal 有哪些使用场景
### 21、React中的合成事件是什么？
### 22、react-router里的标签和`<a>`标签有什么区别
### 23、React组件通信如何实现?
### 24、区分状态和 props
### 25、react性能优化是哪个周期函数
### 26、createElement 与 cloneElement 的区别是什么
### 27、列出React的一些主要优点。
### 28、SSR了解吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
