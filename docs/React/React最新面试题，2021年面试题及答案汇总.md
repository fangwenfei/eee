# React最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、shouldComponentUpdate 的作用

`shouldComponentUpdate` 允许我们手动地判断是否要进行组件更新根据组件的应用场景设置函数的合理返回值能够帮我们避免不必要的更新


### 2、什么是控制组件？

在 HTML 中，表单元素通常维护自己的状态，并根据用户输入进行更新。当用户提交表单时，来自上述元素的值将随表单一起发送。 而 React 的工作方式则不同。包含表单的组件将跟踪其状态中的输入值，并在每次回调函数(例如onChange)触发时重新渲染组件，因为状态被更新。以这种方式由 React 控制其值的输入表单元素称为受控组件。


### 3、React 中 keys的作用是什么

`Keys`是 `React` 用于追踪哪些列表中元素被修改、被添加或者被移除的辅助标识

在开发过程中我们需要保证某个元素的 `key` 在其同级元素中具有唯一性。在 `React Diff` 算法中`React` 会借助元素的 `Key` 值来判断该元素是新近创建的还是被移动而来的元素从而减少不必要的元素重渲染。此外React 还需要借助 `Key` 值来判断元素与本地状态的关联关系因此我们绝不可忽视转换函数中 `Key` 的重要性


### 4、列出 React Router 的优点。

**几个优点是：**

**1、**  就像 React 基于组件一样，在 React Router v4 中，API 是 _'All About Components'_。可以将 Router 可视化为单个根组件（`<BrowserRouter>`），其中我们将特定的子路由（`<route>`）包起来。

**2、**  无需手动设置历史值：在 React Router v4 中，我们要做的就是将路由包装在 `<BrowserRouter>` 组件中。

**3、**  包是分开的：共有三个包，分别用于 Web、Native 和 Core。这使我们应用更加紧凑。基于类似的编码风格很容易进行切换。


### 5、再说一下虚拟Dom以及key属性的作用

由于在浏览器中操作DOM是很昂贵的。频繁的操作DOM，会产生一定的性能问题。这就是虚拟Dom的`产生原因`。

Vue2的Virtual DOM借鉴了开源库`snabbdom`的实现。

`Virtual DOM本质就是用一个原生的JS对象去描述一个DOM节点。是对真实DOM的一层抽象。`(也就是源码中的VNode类，它定义在src/core/vdom/vnode.js中。)

VirtualDOM映射到真实DOM要经历VNode的create、diff、patch等阶段。

**「key的作用是尽可能的复用 DOM 元素。」**

新旧 children 中的节点只有顺序是不同的时候，最佳的操作应该是通过移动元素的位置来达到更新的目的。

需要在新旧 children 的节点中保存映射关系，以便能够在旧 children 的节点中找到可复用的节点。key也就是children中节点的唯一标识。


### 6、React有哪些限制？

**React的限制如下：**

**1、**  React 只是一个库，而不是一个完整的框架

**2、**  它的库非常庞大，需要时间来理解

**3、**  新手程序员可能很难理解

**4、**  编码变得复杂，因为它使用内联模板和 JSX


### 7、Redux遵循的三个原则是什么？

**1、**  单一事实来源：整个应用的状态存储在单个 store 中的对象/状态树里。单一状态树可以更容易地跟踪随时间的变化，并调试或检查应用程序。

**2、**  状态是只读的：改变状态的唯一方法是去触发一个动作。动作是描述变化的普通 JS 对象。就像 state 是数据的最小表示一样，该操作是对数据更改的最小表示。

**3、**  使用纯函数进行更改：为了指定状态树如何通过操作进行转换，你需要纯函数。纯函数是那些返回值仅取决于其参数值的函数。


### 8、列出React的一些主要优点。

React的一些主要优点是：

**1、**  它提高了应用的性能

**2、**  可以方便地在客户端和服务器端使用

**3、**  由于 JSX，代码的可读性很好

**4、**  React 很容易与 Meteor，Angular 等其他框架集成

**5、**  使用React，编写UI测试用例变得非常容易


### 9、说一下Vue的生命周期

`beforeCreate`是new Vue()之后触发的第一个钩子，在当前阶段data、methods、computed以及watch上的数据和方法都不能被访问。

`created`在实例创建完成后发生，当前阶段已经完成了数据观测，也就是可以使用数据，更改数据，在这里更改数据不会触发updated函数。可以做一些初始数据的获取，在当前阶段无法与Dom进行交互，如果非要想，可以通过vm.$nextTick来访问Dom。

`beforeMount`发生在挂载之前，在这之前template模板已导入渲染函数编译。而当前阶段虚拟Dom已经创建完成，即将开始渲染。在此时也可以对数据进行更改，不会触发updated。

`mounted`在挂载完成后发生，在当前阶段，真实的Dom挂载完毕，数据完成双向绑定，可以访问到Dom节点，使用$refs属性对Dom进行操作。

`beforeUpdate`发生在更新之前，也就是响应式数据发生更新，虚拟dom重新渲染之前被触发，你可以在当前阶段进行更改数据，不会造成重渲染。

`updated`发生在更新完成之后，当前阶段组件Dom已完成更新。要注意的是避免在此期间更改数据，因为这可能会导致无限循环的更新。

`beforeDestroy`发生在实例销毁之前，在当前阶段实例完全可以被使用，我们可以在这时进行善后收尾工作，比如清除计时器。

`destroyed`发生在实例销毁之后，这个时候只剩下了dom空壳。组件已被拆解，数据绑定被卸除，监听被移出，子实例也统统被销毁。


### 10、为什么虚拟dom会提高性能

虚拟dom相当于在js和真实dom中间加了一个缓存利用dom diff算法避免了没有必要的dom操作从而提高性能


### 11、你了解 Virtual DOM 吗？解释一下它的工作原理。
### 12、如何将两个或多个组件嵌入到一个组件中？
### 13、虚拟DOM的优劣如何?
### 14、什么是Redux？
### 15、区分有状态和无状态组件。
### 16、createElement 与 cloneElement 的区别是什么
### 17、react和vue的区别
### 18、SSR了解吗？
### 19、再说一下Computed和Watch
### 20、概述下 React 中的事件处理逻辑
### 21、redux异步中间件之间的优劣?
### 22、你的接口请求一般放在哪个生命周期中？
### 23、为什么浏览器无法读取JSX？
### 24、React最新的生命周期是怎样的?
### 25、为什么需要 React 中的路由？
### 26、redux有什么缺点
### 27、什么是纯组件？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
