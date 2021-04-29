# React最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、详细解释 React 组件的生命周期方法。

**一些最重要的生命周期方法是：**

**1、**  _componentWillMount_() – 在渲染之前执行，在客户端和服务器端都会执行。

**2、**  _componentDidMount_() – 仅在第一次渲染后在客户端执行。

**3、**  _componentWillReceiveProps_() – 当从父类接收到 props 并且在调用另一个渲染器之前调用。

**4、**  _shouldComponentUpdate_() – 根据特定条件返回 true 或 false。如果你希望更新组件，请返回true 否则返回 false。默认情况下，它返回 false。

**5、**  _componentWillUpdate_() – 在 DOM 中进行渲染之前调用。

**6、**  _componentDidUpdate_() – 在渲染发生后立即调用。

**7、**  _componentWillUnmount_() – 从 DOM 卸载组件后调用。用于清理内存空间。


### 2、你对 Time Slice的理解?

**时间分片**

**1、** React 在渲染render的时候不会阻塞现在的线程

**2、** 如果你的设备足够快你会感觉渲染是同步的

**3、** 如果你设备非常慢你会感觉还算是灵敏的

**4、** 虽然是异步渲染但是你将会看到完整的渲染而不是一个组件一行行的渲染出来

**5、** 同样书写组件的方式

**6、** 也就是说这是React背后在做的事情对于我们开发者来说是透明的具体是什么样的效果呢


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


### 4、Redux实现原理解析


### 5、keep-alive了解吗

**1、** `keep-alive`可以实现组件缓存，当组件切换时不会对当前组件进行卸载。

**2、** 常用的两个属性`include/exclude`，允许组件有条件的进行缓存。

**3、** 两个生命周期`activated/deactivated`，用来得知当前组件是否处于活跃状态。

**4、** keep-alive的中还运用了`LRU(Least Recently Used)`算法。

**5、** （又是数据结构与算法，原来算法在前端也有这么多的应用）


### 6、在生命周期中的哪一步你应该发起 AJAX 请求

我们应当将`AJAX` 请求放到 `componentDidMount` 函数中执行主要原因有下

`React` 下一代调和算法 `Fiber` 会通过开始或停止渲染的方式优化应用性能其会影响到 `componentWillMount` 的触发次数。对于 `componentWillMount` 这个生命周期函数的调用次数会变得不确定React 可能会多次频繁调用 `componentWillMount`。如果我们将 AJAX 请求放到 `componentWillMount` 函数中那么显而易见其会被触发多次自然也就不是好的选择。如果我们将AJAX 请求放置在生命周期的其他函数中我们并不能保证请求仅在组件挂载完毕后才会要求响应。如果我们的数据请求在组件挂载之前就完成并且调用了`setState`函数将数据添加到组件状态中对于未挂载的组件则会报错。而在 `componentDidMount` 函数中进行 `AJAX` 请求则能有效避免这个问题


### 7、那你能讲一讲MVVM吗？

MVVM是`Model-View-ViewModel`缩写，也就是把`MVC`中的`Controller`演变成`ViewModel`。Model层代表数据模型，View代表UI组件，ViewModel是View和Model层的桥梁，数据会绑定到viewModel层并自动将数据渲染到页面中，视图变化的时候会通知viewModel层更新数据。


### 8、redux中如何进行异步操作?
### 9、什么是JSX？
### 10、Redux 有哪些优点？
### 11、pureComponent和FunctionComponent区别
### 12、react-router里的标签和`<a>`标签有什么区别
### 13、你都做过哪些Vue的性能优化？
### 14、那你知道Vue3.x响应式数据原理吗？
### 15、与 ES5 相比，React 的 ES6 语法有何不同？
### 16、React Router与常规路由有何不同？
### 17、简述flux 思想
### 18、列出React的一些主要优点。
### 19、React 中 refs 的作用是什么
### 20、hash路由和history路由实现原理说一下
### 21、React的请求应该放在哪个生命周期中?
### 22、什么是纯组件？
### 23、react 的渲染过程中兄弟节点之间是怎么处理的也就是key值不一样的时候
### 24、Vue2.x和Vue3.x渲染器的diff算法分别说一下
### 25、什么是高阶组件（HOC）？
### 26、什么是Redux？
### 27、什么是高阶组件(HOC)




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
