# React最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、React有哪些限制？

**React的限制如下：**

**1、**  React 只是一个库，而不是一个完整的框架

**2、**  它的库非常庞大，需要时间来理解

**3、**  新手程序员可能很难理解

**4、**  编码变得复杂，因为它使用内联模板和 JSX


### 2、Vue2.x和Vue3.x渲染器的diff算法分别说一下

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


### 3、react 的虚拟dom是怎么实现的

首先说说为什么要使用`Virturl DOM`因为操作真实`DOM`的耗费的性能代价太高所以`react`内部使用`js`实现了一套`dom`结构在每次操作在和真实`dom`之前使用实现好的`diff`算法对虚拟`dom`进行比较递归找出有变化的dom节点然后对其进行更新操作。为了实现虚拟`DOM`我们需要把每一种节点类型抽象成对象每一种节点类型有自己的属性也就是`prop`每次进行`diff`的时候`react`会先比较该节点类型假如节点类型不一样那么`react`会直接删除该节点然后直接创建新的节点插入到其中假如节点类型一样那么会比较`prop`是否有更新假如有`prop`不一样那么`react`会判定该节点有更新那么重渲染该节点然后在对其子节点进行比较一层一层往下直到没有子节点


### 4、react组件的划分业务组件技术组件

根据组件的职责通常把组件分为`UI`组件和容器组件。`UI` 组件负责 `UI` 的呈现容器组件负责管理数据和逻辑。两者通过`React-Redux` 提供`connect`方法联系起来


### 5、React 中 keys的作用是什么

`Keys`是 `React` 用于追踪哪些列表中元素被修改、被添加或者被移除的辅助标识

在开发过程中我们需要保证某个元素的 `key` 在其同级元素中具有唯一性。在 `React Diff` 算法中`React` 会借助元素的 `Key` 值来判断该元素是新近创建的还是被移动而来的元素从而减少不必要的元素重渲染。此外React 还需要借助 `Key` 值来判断元素与本地状态的关联关系因此我们绝不可忽视转换函数中 `Key` 的重要性


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


### 7、React 中的箭头函数是什么？怎么用？

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


### 8、React与Vue的相似之处

都使用 Virtual DOM

提供了响应式 (Reactive) 和组件化 (Composable) 的视图组件。

将注意力集中保持在核心库，而将其他功能如路由和全局状态管理交给相关的库。


### 9、redux中间件

中间件提供第三方插件的模式自定义拦截 `action -> reducer` 的过程。变为 `action` -> `middlewares` -> `reducer`。这种机制可以让我们改变数据流实现如异步`action action` 过滤日志输出异常报告等功能

**1、** `redux-logger`提供日志输出

**2、** `redux-thunk`处理异步操作

**3、** `redux-promise`处理异步操作 `actionCreator`的返回值是 `promise`


### 10、如何更新组件的状态？

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


### 11、Redux与Flux有何不同？
### 12、redux中如何进行异步操作?
### 13、connect原理
### 14、React如何进行组件/逻辑复用?
### 15、虚拟DOM的优劣如何?
### 16、你的接口请求一般放在哪个生命周期中？
### 17、Redux设计理念
### 18、解释 Reducer 的作用。
### 19、列出 Redux 的组件。
### 20、什么是 Props?
### 21、什么是纯组件？
### 22、什么是高阶组件（HOC）？
### 23、区分Real DOM和Virtual DOM
### 24、Redux实现原理解析
### 25、setState到底是异步还是同步?
### 26、你了解 Virtual DOM 吗？解释一下它的工作原理。
### 27、你对 Time Slice的理解?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
