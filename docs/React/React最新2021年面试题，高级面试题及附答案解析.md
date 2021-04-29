# React最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Vue模版编译原理知道吗，能简单说一下吗？

简单说，Vue的编译过程就是将`template`转化为`render`函数的过程。会经历以下阶段：

**1、** 生成AST树

2、优化

**3、** codegen

首先解析模版，生成`AST语法树`(一种用JavaScript对象的形式来描述整个模板)。 使用大量的正则表达式对模板进行解析，遇到标签、文本的时候都会执行对应的钩子进行相关处理。

Vue的数据是响应式的，但其实模板中并不是所有的数据都是响应式的。有一些数据首次渲染后就不会再变化，对应的DOM也不会变化。那么优化过程就是深度遍历AST树，按照相关条件对树节点进行标记。这些被标记的节点(静态节点)我们就可以`跳过对它们的比对`，对运行时的模板起到很大的优化作用。

编译的最后一步是`将优化后的AST树转换为可执行的代码`。


### 2、详细解释 React 组件的生命周期方法。

**一些最重要的生命周期方法是：**

**1、**  _componentWillMount_() – 在渲染之前执行，在客户端和服务器端都会执行。

**2、**  _componentDidMount_() – 仅在第一次渲染后在客户端执行。

**3、**  _componentWillReceiveProps_() – 当从父类接收到 props 并且在调用另一个渲染器之前调用。

**4、**  _shouldComponentUpdate_() – 根据特定条件返回 true 或 false。如果你希望更新组件，请返回true 否则返回 false。默认情况下，它返回 false。

**5、**  _componentWillUpdate_() – 在 DOM 中进行渲染之前调用。

**6、**  _componentDidUpdate_() – 在渲染发生后立即调用。

**7、**  _componentWillUnmount_() – 从 DOM 卸载组件后调用。用于清理内存空间。


### 3、shouldComponentUpdate 的作用

`shouldComponentUpdate` 允许我们手动地判断是否要进行组件更新根据组件的应用场景设置函数的合理返回值能够帮我们避免不必要的更新


### 4、React 中 keys的作用是什么

`Keys`是 `React` 用于追踪哪些列表中元素被修改、被添加或者被移除的辅助标识

在开发过程中我们需要保证某个元素的 `key` 在其同级元素中具有唯一性。在 `React Diff` 算法中`React` 会借助元素的 `Key` 值来判断该元素是新近创建的还是被移动而来的元素从而减少不必要的元素重渲染。此外React 还需要借助 `Key` 值来判断元素与本地状态的关联关系因此我们绝不可忽视转换函数中 `Key` 的重要性


### 5、区分Real DOM和Virtual DOM
| Real DOM | Virtual DOM |
| --- | --- |
| 1、更新缓慢。 | 1、更新更快。 |
| 2、可以直接更新 HTML。 | 2、无法直接更新 HTML。 |
| 3、如果元素更新，则创建新DOM。 | 3、如果元素更新，则更新 JSX 。 |
| 4、DOM操作代价很高。 | 4、DOM 操作非常简单。 |
| 5、消耗的内存较多。 | 5、很少的内存消耗。 |



### 6、什么是控制组件？

在 HTML 中，表单元素通常维护自己的状态，并根据用户输入进行更新。当用户提交表单时，来自上述元素的值将随表单一起发送。 而 React 的工作方式则不同。包含表单的组件将跟踪其状态中的输入值，并在每次回调函数(例如onChange)触发时重新渲染组件，因为状态被更新。以这种方式由 React 控制其值的输入表单元素称为受控组件。


### 7、Redux与Flux有何不同？
| Flux | Redux |
| --- | --- |
| 1、Store 包含状态和更改逻辑 | 1、Store 和更改逻辑是分开的 |
| 2、有多个 Store | 2、只有一个 Store |
| 3、所有 Store 都互不影响且是平级的 | 3、带有分层 reducer 的单一 Store |
| 4、有单一调度器 | 4、没有调度器的概念 |
| 5、React 组件订阅 store | 5、容器组件是有联系的 |
| 6、状态是可变的 | 6、状态是不可改变的 |



### 8、setState: React 中用于修改状态更新视图。它具有以下特点:

异步与同步: setState并不是单纯的异步或同步这其实与调用时的环境相关:


### 9、redux与mobx的区别?

**两者对比:**

**1、** redux将数据保存在单一的store中，mobx将数据保存在分散的多个store中

**2、** redux使用plain object保存数据，需要手动处理变化后的操作；mobx适用observable保存数据，数据变化后自动处理响应的操作

**3、** redux使用不可变状态，这意味着状态是只读的，不能直接去修改它，而是应该返回一个新的状态，同时使用纯函数；mobx中的状态是可变的，可以直接对其进行修改

**4、** mobx相对来说比较简单，在其中有很多的抽象，mobx更多的使用面向对象的编程思维；redux会比较复杂，因为其中的函数式编程思想掌握起来不是那么容易，同时需要借助一系列的中间件来处理异步和副作用

**5、** mobx中有更多的抽象和封装，调试会比较困难，同时结果也难以预测；而redux提供能够进行时间回溯的开发工具，同时其纯函数以及更少的抽象，让调试变得更加的容易

**场景辨析:**

基于以上区别,我们可以简单得分析一下两者的不同使用场景.

mobx更适合数据不复杂的应用: mobx难以调试,很多状态无法回溯,面对复杂度高的应用时,往往力不从心.

redux适合有回溯需求的应用: 比如一个画板应用、一个表格应用，很多时候需要撤销、重做等操作，由于redux不可变的特性，天然支持这些操作.

mobx适合短平快的项目: mobx上手简单,样板代码少,可以很大程度上提高开发效率.

当然mobx和redux也并不一定是非此即彼的关系,你也可以在项目中用redux作为全局状态管理,用mobx作为组件局部状态管理器来用.


### 10、列出一些应该使用 Refs 的情况。

**以下是应该使用 refs 的情况：**

**1、** 需要管理焦点、选择文本或媒体播放时

**2、** 触发式动画

**3、** 与第三方 DOM 库集成


### 11、React Router与常规路由有何不同？
### 12、解释 Reducer 的作用。
### 13、再说一下vue2.x中如何监测数组变化
### 14、React有哪些优化性能是手段?
### 15、如何在 React 中创建表单
### 16、setState到底是异步还是同步?
### 17、如何更新组件的状态？
### 18、setState到底是异步还是同步?
### 19、说一下v-if和v-show的区别
### 20、你的接口请求一般放在哪个生命周期中？
### 21、Vue2.x和Vue3.x渲染器的diff算法分别说一下
### 22、什么是React 路由？
### 23、React 中的箭头函数是什么？怎么用？
### 24、列出 React Router 的优点。
### 25、diff算法?
### 26、你对 Time Slice的理解?
### 27、销毁阶段
### 28、React 中 key 的重要性是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
