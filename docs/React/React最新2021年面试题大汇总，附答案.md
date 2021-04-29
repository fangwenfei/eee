# React最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Redux 有哪些优点？

**Redux 的优点如下：**

**1、** 结果的可预测性 - 由于总是存在一个真实来源，即 store ，因此不存在如何将当前状态与动作和应用的其他部分同步的问题。

**2、** 可维护性 - 代码变得更容易维护，具有可预测的结果和严格的结构。

**3、** 服务器端渲染 - 你只需将服务器上创建的 store 传到客户端即可。这对初始渲染非常有用，并且可以优化应用性能，从而提供更好的用户体验。

**4、** 开发人员工具 - 从操作到状态更改，开发人员可以实时跟踪应用中发生的所有事情。

**5、** 社区和生态系统 - Redux 背后有一个巨大的社区，这使得它更加迷人。一个由才华横溢的人组成的大型社区为库的改进做出了贡献，并开发了各种应用。

**6、** 易于测试 - Redux 的代码主要是小巧、纯粹和独立的功能。这使代码可测试且独立。

**7、** 组织 - Redux 准确地说明了代码的组织方式，这使得代码在团队使用时更加一致和简单。


### 2、redux中如何进行异步操作?

当然,我们可以在`componentDidmount`中直接进行请求无须借助redux.

但是在一定规模的项目中,上述方法很难进行异步流的管理,通常情况下我们会借助redux的异步中间件进行异步处理.

redux异步流中间件其实有很多,但是当下主流的异步中间件只有两种redux-thunk、redux-saga，当然redux-observable可能也有资格占据一席之地,其余的异步中间件不管是社区活跃度还是npm下载量都比较差了.


### 3、什么是高阶组件(HOC)

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


### 4、connect原理

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


### 5、我现在有一个button要用react在上面绑定点击事件要怎么做

```
class Demo {
  render() {
    return <button onClick={(e) => {
      alert('我点击了按钮')
    }}>
      按钮
    </button>
  }
}
```

你觉得你这样设置点击事件会有什么问题吗

由于`onClick`使用的是匿名函数所有每次重渲染的时候会把该`onClick`当做一个新的prop来处理会将内部缓存的`onClick`事件进行重新赋值所以相对直接使用函数来说可能有一点的性能下降

修改

```
class Demo {

  onClick = (e) => {
    alert('我点击了按钮')
  }

  render() {
    return <button onClick={this.onClick}>
      按钮
    </button>
  }
```


### 6、区分状态和 props
| 条件 | State | Props |
| --- | --- | --- |
| 1、从父组件中接收初始值 | Yes | Yes |
| 2、父组件可以改变值 | No | Yes |
| 3、在组件中设置默认值 | Yes | Yes |
| 4、在组件的内部变化 | Yes | No |
| 5、设置子组件的初始值 | Yes | Yes |
| 6、在子组件的内部更改 | No | Yes |



### 7、Vue中组件生命周期调用顺序说一下

**1、** 组件的调用顺序都是`先父后子`,渲染完成的顺序是`先子后父`。

**2、** 组件的销毁操作是`先父后子`，销毁完成的顺序是`先子后父`。

**加载渲染过程**

`父beforeCreate->父created->父beforeMount->子beforeCreate->子created->子beforeMount- >子mounted->父mounted`

**子组件更新过程**

`父beforeUpdate->子beforeUpdate->子updated->父updated`

**父组件更新过程**

`父 beforeUpdate -> 父 updated`

**销毁过程**

`父beforeDestroy->子beforeDestroy->子destroyed->父destroyed`


### 8、你了解 Virtual DOM 吗？解释一下它的工作原理。

Virtual DOM 是一个轻量级的 JavaScript 对象，它最初只是 real DOM 的副本。它是一个节点树，它将元素、它们的属性和内容作为对象及其属性。 React 的渲染函数从 React 组件中创建一个节点树。然后它响应数据模型中的变化来更新该树，该变化是由用户或系统完成的各种动作引起的。

**Virtual DOM 工作过程有三个简单的步骤**

**1、** 每当底层数据发生改变时，整个 UI 都将在 Virtual DOM 描述中重新渲染。

**2、**  然后计算之前 DOM 表示与新表示的之间的差异。

**3、**  完成计算后，将只用实际更改的内容更新 real DOM。


### 9、Vue2.x组件通信有哪些方式？

**父子组件通信**

**1、** 父->子`props`，子->父 `$on、$emit`

**2、** 获取父子组件实例 `$parent、$children`

**3、** `Ref` 获取实例的方式调用组件的属性或者方法

**4、** `Provide、inject` 官方不推荐使用，但是写组件库时很常用

**兄弟组件通信**

**1、** `Event Bus` 实现跨组件通信 `Vue.prototype.$bus = new Vue`

**2、** `Vuex`

**跨级组件通信**

**1、** `Vuex`

**2、** `$attrs、$listeners`

**3、** `Provide、inject`


### 10、什么是 Props?

Props 是 React 中属性的简写。它们是只读组件，必须保持纯，即不可变。它们总是在整个应用中从父组件传递到子组件。子组件永远不能将 prop 送回父组件。这有助于维护单向数据流，通常用于呈现动态生成的数据。


### 11、什么是纯组件？
### 12、你对 Time Slice的理解?
### 13、keep-alive了解吗
### 14、说一下v-model的原理
### 15、React有什么特点？
### 16、虚拟DOM的优劣如何?
### 17、那你能讲一讲MVVM吗？
### 18、hash路由和history路由实现原理说一下
### 19、React实现的移动应用中如果出现卡顿有哪些可以考虑的优化方案
### 20、Store 在 Redux 中的意义是什么？
### 21、具体实现步骤如下
### 22、react-redux是如何工作的?
### 23、在合成事件 和 生命周期钩子(除 componentDidUpdate) 中setState是"异步"的
### 24、如何告诉 React 它应该编译生产环境版
### 25、再说一下虚拟Dom以及key属性的作用
### 26、redux的工作流程?
### 27、虚拟DOM实现原理?
### 28、与 ES5 相比，React 的 ES6 语法有何不同？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
