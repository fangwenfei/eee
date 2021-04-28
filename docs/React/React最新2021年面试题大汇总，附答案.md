# React最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、react性能优化方案

**1、** 重写 `shouldComponentUpdate`来避免不必要的 `dom`操作

**2、** 使用 `production` 版本的 `react.js`

**3、** 使用 `key`来帮助 `React`识别列表中所有子组件的最小变化


### 2、redux的工作流程?

首先，我们看下几个核心概念：

Store：保存数据的地方，你可以把它看成一个容器，整个应用只能有一个Store。

State：Store对象包含所有数据，如果想得到某个时点的数据，就要对Store生成快照，这种时点的数据集合，就叫做State。

Action：State的变化，会导致View的变化。但是，用户接触不到State，只能接触到View。所以，State的变化必须是View导致的。Action就是View发出的通知，表示State应该要发生变化了。

Action Creator：View要发送多少种消息，就会有多少种Action。如果都手写，会很麻烦，所以我们定义一个函数来生成Action，这个函数就叫Action Creator。

Reducer：Store收到Action以后，必须给出一个新的State，这样View才会发生变化。这种State的计算过程就叫做Reducer。Reducer是一个函数，它接受Action和当前State作为参数，返回一个新的State。

dispatch：是View发出Action的唯一方法。 然后我们过下整个工作流程：

首先，用户（通过View）发出Action，发出方式就用到了dispatch方法。

然后，Store自动调用Reducer，并且传入两个参数：当前State和收到的Action，Reducer会返回新的State

State一旦有变化，Store就会调用监听函数，来更新View。 到这儿为止，一次用户交互流程结束。可以看到，在整个流程中数据都是单向流动的，这种方式保证了流程的清晰。


### 3、你对 Time Slice的理解?

**时间分片**

**1、** React 在渲染render的时候不会阻塞现在的线程

**2、** 如果你的设备足够快你会感觉渲染是同步的

**3、** 如果你设备非常慢你会感觉还算是灵敏的

**4、** 虽然是异步渲染但是你将会看到完整的渲染而不是一个组件一行行的渲染出来

**5、** 同样书写组件的方式

**6、** 也就是说这是React背后在做的事情对于我们开发者来说是透明的具体是什么样的效果呢


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


### 5、React有哪些优化性能是手段?

性能优化的手段很多时候是通用的详情见前端性能优化加载篇


### 6、为什么需要 React 中的路由？

Router 用于定义多个路由，当用户定义特定的 URL 时，如果此 URL 与 Router 内定义的任何 “路由” 的路径匹配，则用户将重定向到该特定路由。所以基本上我们需要在自己的应用中添加一个 Router 库，允许创建多个路由，每个路由都会向我们提供一个独特的视图

```
<switch>
    <route exact path=’/’ component={Home}/>
    <route path=’/posts/:id’ component={Newpost}/>
    <route path=’/posts’   component={Post}/>
</switch>
```


### 7、Redux设计理念

`Redux`是将整个应用状态存储到一个地方上称为`store`,里面保存着一个状态树`store` `tree`,组件可以派发(`dispatch`)行为(`action`)给`store`,而不是直接通知其他组件组件内部通过订阅`store`中的状态`state`来刷新自己的视图

![80_2.png][80_2.png]

image


### 8、简单说一下Vue2.x响应式数据原理

Vue在初始化数据时，会使用`Object.defineProperty`重新定义data中的所有属性，当页面使用对应属性时，首先会进行依赖收集(收集当前组件的`watcher`)如果属性发生变化会通知相关依赖进行更新操作(`发布订阅`)。


### 9、概述下 React 中的事件处理逻辑

为了解决跨浏览器兼容性问题`React` 会将浏览器原生事件`Browser Native Event`封装为合成事件`SyntheticEvent`传入设置的事件处理器中。这里的合成事件提供了与原生事件相同的接口不过它们屏蔽了底层浏览器的细节差异保证了行为的一致性。另外有意思的是React 并没有直接将事件附着到子元素上而是以单一事件监听器的方式将所有的事件发送到顶层进行处理。这样 `React` 在更新 `DOM` 的时候就不需要考虑如何去处理附着在 `DOM` 上的事件监听器最终达到优化性能的目的


### 10、如何在React中创建一个事件？

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


### 11、shouldComponentUpdate 的作用
### 12、Redux 有哪些优点？
### 13、React如何进行组件/逻辑复用?
### 14、组件中的data为什么是一个函数？
### 15、Vue事件绑定原理说一下
### 16、你了解 Virtual DOM 吗？解释一下它的工作原理。
### 17、react旧版生命周期函数
### 18、你能用HOC做什么？
### 19、区分有状态和无状态组件。
### 20、React与Angular有何不同？
### 21、什么是控制组件？
### 22、React组件通信如何实现？
### 23、Vue2.x和Vue3.x渲染器的diff算法分别说一下
### 24、hash路由和history路由实现原理说一下
### 25、区分Real DOM和Virtual DOM
### 26、为什么React Router v4中使用 switch 关键字 ？
### 27、如何更新组件的状态？
### 28、React实现的移动应用中如果出现卡顿有哪些可以考虑的优化方案




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
