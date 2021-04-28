# React最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是React 路由？

React 路由是一个构建在 React 之上的强大的路由库，它有助于向应用程序添加新的屏幕和流。这使 URL 与网页上显示的数据保持同步。它负责维护标准化的结构和行为，并用于开发单页 Web 应用。 React 路由有一个简单的API。


### 2、我现在有一个button要用react在上面绑定点击事件要怎么做

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


### 3、为什么选择使用框架而不是原生?

**框架的好处:**

**1、** 组件化: 其中以 React 的组件化最为彻底,甚至可以到函数级别的原子组件,高度的组件化可以是我们的工程易于维护、易于组合拓展

**2、** 天然分层: JQuery 时代的代码大部分情况下是面条代码,耦合严重,现代框架不管是 MVC、MVP还是MVVM 模式都能帮助我们进行分层，代码解耦更易于读写。

**3、** 生态: 现在主流前端框架都自带生态,不管是数据流管理架构还是 UI 库都有成熟的解决方案。

**4、** 开发效率: 现代前端框架都默认自动更新DOM,而非我们手动操作,解放了开发者的手动DOM成本,提高开发效率,从根本上解决了UI 与状态同步问题.


### 4、你对 React 的 refs 有什么了解？

Refs 是 React 中引用的简写。它是一个有助于存储对特定的 React 元素或组件的引用的属性，它将由组件渲染配置函数返回。用于对 render() 返回的特定元素或组件的引用。当需要进行 DOM 测量或向组件添加方法时，它们会派上用场。

```
class ReferenceDemo extends React.Component{
     display() {
         const name = this.inputDemo.value;
         document.getElementById('disp').innerHTML = name;
     }
render() {
    return(
          <div>
            Name: <input type="text" ref={input => this.inputDemo = input} />
            <button name="Click" onClick={this.display}>Click</button>
            <h2>Hello <span id="disp"></span> !!!</h2>
          </div>
    );
   }
 }
```


### 5、redux有什么缺点

一个组件所需要的数据必须由父组件传过来而不能像`flux`中直接从`store`取。当一个组件相关数据更新时即使父组件不需要用到这个组件父组件还是会重新`render`可能会有效率影响或者需要写复杂的`shouldComponentUpdate`进行判断。


### 6、你对 Time Slice的理解?

**时间分片**

**1、** React 在渲染（render）的时候，不会阻塞现在的线程

**2、** 如果你的设备足够快，你会感觉渲染是同步的

**3、** 如果你设备非常慢，你会感觉还算是灵敏的

**4、** 虽然是异步渲染，但是你将会看到完整的渲染，而不是一个组件一行行的渲染出来

**5、** 同样书写组件的方式

也就是说，这是React背后在做的事情，对于我们开发者来说，是透明的，具体是什么样的效果呢？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_3.png#alt=97%5C_3.png)![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_4.png#alt=97%5C_4.png)有图表三个图表，有一个输入框，以及上面的三种模式

**这个组件非常的巨大，而且在输入框**每次**输入东西的时候，就会进去一直在渲染。**为了更好的看到渲染的性能，Dan为我们做了一个表。

**我们先看看，同步模式：**

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_5.png#alt=97%5C_5.png)![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_6.png#alt=97%5C_6.png)

同步模式下，我们都知道，我们没输入一个字符，React就开始渲染，当React渲染一颗巨大的树的时候，是非常卡的，所以才会有shouldUpdate的出现，在这里Dan也展示了，这种卡！

**我们再来看看第二种（Debounced模式）：**

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_7.png#alt=97%5C_7.png)![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_8.png#alt=97%5C_8.png)

Debounced模式简单的来说，就是延迟渲染，比如，当你输入完成以后，再开始渲染所有的变化。

这么做的坏处就是，至少不会阻塞用户的输入了，但是依然有非常严重的卡顿。

**切换到异步模式：**

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_9.png#alt=97%5C_9.png)![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_10.png#alt=97%5C_10.png)

异步渲染模式就是不阻塞当前线程，继续跑。在视频里可以看到所有的输入，表上都会是原谅色的。

时间分片正是基于可随时打断、重启的Fiber架构,可打断当前任务,优先处理紧急且重要的任务,保证页面的流畅运行.


### 7、Vue2.x组件通信有哪些方式？

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


### 8、mixin、hoc、render props、react-hooks的优劣如何？

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


### 9、区分状态和 props
| 条件 | State | Props |
| --- | --- | --- |
| 1、从父组件中接收初始值 | Yes | Yes |
| 2、父组件可以改变值 | No | Yes |
| 3、在组件中设置默认值 | Yes | Yes |
| 4、在组件的内部变化 | Yes | No |
| 5、设置子组件的初始值 | Yes | Yes |
| 6、在子组件的内部更改 | No | Yes |



### 10、React 中 key 的重要性是什么？

key 用于识别唯一的 Virtual DOM 元素及其驱动 UI 的相应数据。它们通过回收 DOM 中当前所有的元素来帮助 React 优化渲染。这些 key 必须是唯一的数字或字符串，React 只是重新排序元素而不是重新渲染它们。这可以提高应用程序的性能。


### 11、你都做过哪些Vue的性能优化？
### 12、React 中 refs 的作用是什么
### 13、说一下Vue的生命周期
### 14、MVC框架的主要问题是什么？
### 15、虚拟DOM实现原理?
### 16、setState到底是异步还是同步?
### 17、React Portal 有哪些使用场景
### 18、Redux遵循的三个原则是什么？
### 19、列出 React Router 的优点。
### 20、pureComponent和FunctionComponent区别
### 21、redux与mobx的区别?
### 22、react-redux是如何工作的?
### 23、Vue中组件生命周期调用顺序说一下
### 24、React最新的生命周期是怎样的?
### 25、那你能讲一讲MVVM吗？
### 26、什么是高阶组件（HOC）？
### 27、redux异步中间件之间的优劣?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
