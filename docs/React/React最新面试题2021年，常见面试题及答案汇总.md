# React最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、再说一下vue2.x中如何监测数组变化

使用了函数劫持的方式，重写了数组的方法，Vue将data中的数组进行了原型链重写，指向了自己定义的数组原型方法。这样当调用数组api时，可以通知依赖更新。如果数组中包含着引用类型，会对数组中的引用类型再次递归遍历进行监控。这样就实现了监测数组变化。

（能问到这的面试官都比较注重深度，这些常规操作要记牢）


### 2、销毁阶段

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


### 3、React如何进行组件/逻辑复用?

抛开已经被官方弃用的Mixin,组件抽象的技术目前有三种比较主流:

**高阶组件:**

**1、** 属性代理

**2、** 反向继承

**3、** 渲染属性

**4、** react-hooks


### 4、React有哪些限制？

**React的限制如下：**

**1、**  React 只是一个库，而不是一个完整的框架

**2、**  它的库非常庞大，需要时间来理解

**3、**  新手程序员可能很难理解

**4、**  编码变得复杂，因为它使用内联模板和 JSX


### 5、具体实现步骤如下

**1、** 用 `JavaScript`对象结构表示 DOM 树的结构然后用这个树构建一个真正的 `DOM` 树插到文档当中

**2、** 当状态变更的时候重新构造一棵新的对象树。然后用新的树和旧的树进行比较记录两棵树差异

**3、** 把2所记录的差异应用到步骤1所构建的真正的 `DOM`树上视图就更新


### 6、什么是高阶组件(HOC)

高阶组件(Higher Order Componennt)本身其实不是组件而是一个函数这个函数接收一个元组件作为参数然后返回一个新的增强组件高阶组件的出现本身也是为了逻辑复用举个例子

```
function withLoginAuth(WrappedComponent) {
  return class extends React.Component {
      
      constructor(props) {
          super(props);
          this.state = {
            isLogin: false
          };
      }
      
      async componentDidMount() {
          const isLogin = await getLoginStatus();
          this.setState({ isLogin });
      }
      
      render() {
        if (this.state.isLogin) {
            return <WrappedComponent {...this.props} />;
        }
        
        return (<div>您还未登录...</div>);
      }
  }
}
```


### 7、如何在React中创建一个事件？

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


### 8、虚拟DOM实现原理?

**1、** 虚拟DOM本质上是JavaScript对象,是对真实DOM的抽象

**2、** 状态变更时，记录新树和旧树的差异

**3、** 最后把差异更新到真正的dom中

> [虚拟DOM原理](https://github.com/xiaomuzhu/front-end-interview/blob/master/docs/guide/virtualDom.md)



### 9、React与Angular有何不同？
| 主题 | React | Angular |
| --- | --- | --- |
| _1、体系结构_ | 只有 MVC 中的 View | 完整的 MVC |
| _2、渲染_ | 可以在服务器端渲染 | 客户端渲染 |
| _3、DOM_ | 使用 virtual DOM | 使用 real DOM |
| _4、数据绑定_ | 单向数据绑定 | 双向数据绑定 |
| _5、调试_ | 编译时调试 | 运行时调试 |
| _6、作者_ | Facebook | Google |



### 10、你了解 Virtual DOM 吗？解释一下它的工作原理。

Virtual DOM 是一个轻量级的 JavaScript 对象，它最初只是 real DOM 的副本。它是一个节点树，它将元素、它们的属性和内容作为对象及其属性。 React 的渲染函数从 React 组件中创建一个节点树。然后它响应数据模型中的变化来更新该树，该变化是由用户或系统完成的各种动作引起的。

**Virtual DOM 工作过程有三个简单的步骤**

**1、** 每当底层数据发生改变时，整个 UI 都将在 Virtual DOM 描述中重新渲染。

**2、**  然后计算之前 DOM 表示与新表示的之间的差异。

**3、**  完成计算后，将只用实际更改的内容更新 real DOM。


### 11、setState: React 中用于修改状态更新视图。它具有以下特点:
### 12、列出一些应该使用 Refs 的情况。
### 13、你对 Time Slice的理解?
### 14、react 的虚拟dom是怎么实现的
### 15、为什么浏览器无法读取JSX？
### 16、react hooks它带来了那些便利
### 17、setState到底是异步还是同步?
### 18、React与Vue的相似之处
### 19、setState到底是异步还是同步?
### 20、组件中的data为什么是一个函数？
### 21、hash路由和history路由实现原理说一下
### 22、diff算法?
### 23、再说一下Computed和Watch
### 24、你对受控组件和非受控组件了解多少？
### 25、什么是纯组件？
### 26、简单说一下Vue2.x响应式数据原理
### 27、解释一下 Flux




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
