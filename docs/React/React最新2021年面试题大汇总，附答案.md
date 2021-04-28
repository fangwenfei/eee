# React最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、如何更新组件的状态？

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


### 2、为什么要用redux

在`React`中数据在组件中是单向流动的数据从一个方向父组件流向子组件通过`props`,所以两个非父子组件之间通信就相对麻烦`redux`的出现就是为了解决`state`里面的数据问题


### 3、diff算法?

**1、** 把树形结构按照层级分解只比较同级元素。

**2、** 给列表结构的每个单元添加唯一的key属性方便比较。

**3、** `React` 只会匹配相同 `class` 的 `component`这里面的class指的是组件的名字

**4、** 合并操作调用 `component` 的 `setState` 方法的时候, React 将其标记为 - `dirty`.到每一个事件循环结束, `React` 检查所有标记 `dirty`的 `component`重新绘制.

**5、** 选择性子树渲染。开发人员可以重写 `shouldComponentUpdate`提高 `diff`的性能


### 4、React 中 refs 的作用是什么

`Refs` 是 `React` 提供给我们的安全访问 `DOM`元素或者某个组件实例的句柄可以为元素添加ref属性然后在回调函数中接受该元素在 `DOM` 树中的句柄该值会作为回调函数的第一个参数返回


### 5、setState到底是异步还是同步?

答案: 有时表现出异步,有时表现出同步

setState只在合成事件和钩子函数中是“异步”的，在原生事件和setTimeout 中都是同步的。

setState 的“异步”并不是说内部由异步代码实现，其实本身执行的过程和代码都是同步的，只是合成事件和钩子函数的调用顺序在更新之前，导致在合成事件和钩子函数中没法立马拿到更新后的值，形成了所谓的“异步”，当然可以通过第二个参数 setState(partialState, callback) 中的callback拿到更新后的结果。

setState 的批量更新优化也是建立在“异步”（合成事件、钩子函数）之上的，在原生事件和setTimeout 中不会批量更新，在“异步”中如果对同一个值进行多次setState，setState的批量更新策略会对其进行覆盖，取最后一次的执行，如果是同时setState多个不同的值，在更新时会对其进行合并批量更新。 #React组件通信


### 6、简述flux 思想

**1、** Flux 的最大特点就是数据的"单向流动"。

**2、** 用户访问 `View`

**3、** View发出用户的 `Action`

**4、** `Dispatcher` 收到Action要求 `Store` 进行相应的更新

**5、** `Store` 更新后发出一个"`change`"事件

**6、** `View` 收到"`change`"事件后更新页面


### 7、你对 Time Slice的理解?

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


### 8、Vue中组件生命周期调用顺序说一下

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


### 9、setState

在了解`setState`之前我们先来简单了解下 `React` 一个包装结构: `Transaction`:

**事务 (Transaction)**

是 `React` 中的一个调用结构用于包装一个方法结构为: `initialize` - `perform(method)` - `close`。通过事务可以统一管理一个方法的开始与结束处于事务流中表示进程正在执行一些操作


### 10、那你能讲一讲MVVM吗？

MVVM是`Model-View-ViewModel`缩写，也就是把`MVC`中的`Controller`演变成`ViewModel`。Model层代表数据模型，View代表UI组件，ViewModel是View和Model层的桥梁，数据会绑定到viewModel层并自动将数据渲染到页面中，视图变化的时候会通知viewModel层更新数据。


### 11、概述下 React 中的事件处理逻辑
### 12、你是如何理解fiber的?
### 13、react-redux是如何工作的?
### 14、React中的状态是什么？它是如何使用的？
### 15、Store 在 Redux 中的意义是什么？
### 16、React与Angular有何不同？
### 17、diff算法?
### 18、react 的虚拟dom是怎么实现的
### 19、什么是纯组件？
### 20、nextTick知道吗，实现原理是什么？
### 21、组件中的data为什么是一个函数？
### 22、redux的工作流程?
### 23、React最新的生命周期是怎样的?
### 24、为什么选择使用框架而不是原生?
### 25、你对“单一事实来源”有什么理解？
### 26、你对受控组件和非受控组件了解多少？
### 27、如何将两个或多个组件嵌入到一个组件中？
### 28、什么是React？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
