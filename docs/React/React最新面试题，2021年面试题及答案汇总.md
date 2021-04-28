# React最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、redux中间件有哪些，做什么用？

中间件提供第三方插件的模式，自定义拦截 action -> reducer 的过程。变为 action -> middlewares -> reducer 。这种机制可以让我们改变数据流，实现如异步 action ，action 过滤，日志输出，异常报告等功能。 常见的中间件：

redux-logger：提供日志输出

redux-thunk：处理异步操作

redux-promise：处理异步操作，actionCreator的返回值是promise


### 2、解释 React 中 render() 的目的。

每个React组件强制要求必须有一个 render()。它返回一个 React 元素，是原生 DOM 组件的表示。如果需要渲染多个 HTML 元素，则必须将它们组合在一个封闭标记内，例如 `<form>`、`<group>`、`<div>` 等。此函数必须保持纯净，即必须每次调用时都返回相同的结果。


### 3、解释 Reducer 的作用。

Reducers 是纯函数，它规定应用程序的状态怎样因响应 ACTION 而改变。Reducers 通过接受先前的状态和 action 来工作，然后它返回一个新的状态。它根据操作的类型确定需要执行哪种更新，然后返回新的值。如果不需要完成任务，它会返回原来的状态。


### 4、如何将两个或多个组件嵌入到一个组件中？

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


### 5、说说你用react有什么坑点

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


### 6、react旧版生命周期函数

初始化阶段

**1、** `getDefaultProps`:获取实例的默认属性

**2、** `getInitialState`:获取每个实例的初始化状态

**3、** `componentWillMount`组件即将被装载、渲染到页面上

**4、** `render`:组件在这里生成虚拟的DOM节点

**5、** `componentDidMount`:组件真正在被装载之后

运行中状态

**1、** `componentWillReceiveProps`:组件将要接收到属性的时候调用

**2、** `shouldComponentUpdate`:组件接受到新属性或者新状态的时候可以返回 `false`接收数据后不更新阻止 `render`调用后面的函数不会被继续执行了

**3、** `componentWillUpdate`:组件即将更新不能修改属性和状态

**4、** `render`:组件重新描绘

**5、** `componentDidUpdate`:组件已经更新


### 7、Vue2.x和Vue3.x渲染器的diff算法分别说一下

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


### 8、React有哪些优化性能是手段?

性能优化的手段很多时候是通用的详情见前端性能优化加载篇


### 9、说一下Vue的生命周期

`beforeCreate`是new Vue()之后触发的第一个钩子，在当前阶段data、methods、computed以及watch上的数据和方法都不能被访问。

`created`在实例创建完成后发生，当前阶段已经完成了数据观测，也就是可以使用数据，更改数据，在这里更改数据不会触发updated函数。可以做一些初始数据的获取，在当前阶段无法与Dom进行交互，如果非要想，可以通过vm.$nextTick来访问Dom。

`beforeMount`发生在挂载之前，在这之前template模板已导入渲染函数编译。而当前阶段虚拟Dom已经创建完成，即将开始渲染。在此时也可以对数据进行更改，不会触发updated。

`mounted`在挂载完成后发生，在当前阶段，真实的Dom挂载完毕，数据完成双向绑定，可以访问到Dom节点，使用$refs属性对Dom进行操作。

`beforeUpdate`发生在更新之前，也就是响应式数据发生更新，虚拟dom重新渲染之前被触发，你可以在当前阶段进行更改数据，不会造成重渲染。

`updated`发生在更新完成之后，当前阶段组件Dom已完成更新。要注意的是避免在此期间更改数据，因为这可能会导致无限循环的更新。

`beforeDestroy`发生在实例销毁之前，在当前阶段实例完全可以被使用，我们可以在这时进行善后收尾工作，比如清除计时器。

`destroyed`发生在实例销毁之后，这个时候只剩下了dom空壳。组件已被拆解，数据绑定被卸除，监听被移出，子实例也统统被销毁。


### 10、区分有状态和无状态组件。
| 有状态组件 | 无状态组件 |
| --- | --- |
| 1、在内存中存储有关组件状态变化的信息 | 1、计算组件的内部的状态 |
| 2、有权改变状态 | 2、无权改变状态 |
| 3、包含过去、现在和未来可能的状态变化情况 | 3、不包含过去，现在和未来可能发生的状态变化情况 |
| 4、接受无状态组件状态变化要求的通知，然后将 props 发送给他们。 | 4.从有状态组件接收 props 并将其视为回调函数。 |



### 11、你对 Time Slice的理解?
### 12、传入 setState 函数的第二个参数的作用是什么
### 13、什么是高阶组件（HOC）？
### 14、为什么React Router v4中使用 switch 关键字 ？
### 15、setState
### 16、列出React的一些主要优点。
### 17、Redux实现原理解析
### 18、redux中如何进行异步操作?
### 19、如何在 Redux 中定义 Action？
### 20、mixin、hoc、render props、react-hooks的优劣如何？
### 21、React 中 keys的作用是什么
### 22、react和vue的区别
### 23、在生命周期中的哪一步你应该发起 AJAX 请求
### 24、React 中 refs 的作用是什么
### 25、说一下v-model的原理
### 26、你对“单一事实来源”有什么理解？
### 27、HOC(高阶组件)




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
