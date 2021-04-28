# React最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、区分有状态和无状态组件。
| 有状态组件 | 无状态组件 |
| --- | --- |
| 1、在内存中存储有关组件状态变化的信息 | 1、计算组件的内部的状态 |
| 2、有权改变状态 | 2、无权改变状态 |
| 3、包含过去、现在和未来可能的状态变化情况 | 3、不包含过去，现在和未来可能发生的状态变化情况 |
| 4、接受无状态组件状态变化要求的通知，然后将 props 发送给他们。 | 4.从有状态组件接收 props 并将其视为回调函数。 |



### 2、React组件通信如何实现？

父组件向子组件通讯: 父组件可以向子组件通过传 props 的方式，向子组件进行通讯

子组件向父组件通讯: props+回调的方式,父组件向子组件传递props进行通讯，此props为作用域为父组件自身的函数，子组件调用该函数，将子组件想要传递的信息，作为参数，传递到父组件的作用域中

兄弟组件通信: 找到这两个兄弟节点共同的父节点,结合上面两种方式由父节点转发信息进行通信

跨层级通信:`Context`设计目的是为了共享那些对于一个组件树而言是“全局”的数据，例如当前认证的用户、主题或首选语言,对于跨越多层的全局数据通过`Context`通信再适合不过

发布订阅模式: 发布者发布事件，订阅者监听事件并做出反应,我们可以通过引入event模块进行通信 全局状态管理工具: 借助Redux或者Mobx等全局状态管理工具进行通信,这种工具会维护一个全局状态中心Store,并根据不同的事件产生新的状态


### 3、说一下v-model的原理

`v-model`本质就是一个语法糖，可以看成是`value + input`方法的语法糖。 可以通过model属性的`prop`和`event`属性来进行自定义。原生的v-model，会根据标签的不同生成不同的事件和属性。


### 4、销毁阶段

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


### 5、React中的合成事件是什么？

合成事件是围绕浏览器原生事件充当跨浏览器包装器的对象。它们将不同浏览器的行为合并为一个 API。这样做是为了确保事件在不同浏览器中显示一致的属性。


### 6、为什么浏览器无法读取JSX？

浏览器只能处理 JavaScript 对象，而不能读取常规 JavaScript 对象中的 JSX。所以为了使浏览器能够读取 JSX，首先，需要用像 Babel 这样的 JSX 转换器将 JSX 文件转换为 JavaScript 对象，然后再将其传给浏览器。


### 7、diff算法?

把树形结构按照层级分解，只比较同级元素。

给列表结构的每个单元添加唯一的key属性，方便比较。

React 只会匹配相同 class 的 component（这里面的class指的是组件的名字）

合并操作，调用 component 的 setState 方法的时候, React 将其标记为 dirty.到每一个事件循环结束, React 检查所有标记 dirty 的 component 重新绘制

选择性子树渲染。开发人员可以重写shouldComponentUpdate提高diff的性能。



### 8、你对“单一事实来源”有什么理解？

Redux 使用 “Store” 将程序的整个状态存储在同一个地方。因此所有组件的状态都存储在 Store 中，并且它们从 Store 本身接收更新。单一状态树可以更容易地跟踪随时间的变化，并调试或检查程序。


### 9、为什么要用redux

在`React`中数据在组件中是单向流动的数据从一个方向父组件流向子组件通过`props`,所以两个非父子组件之间通信就相对麻烦`redux`的出现就是为了解决`state`里面的数据问题


### 10、说说你用react有什么坑点

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


### 11、再说一下Computed和Watch
### 12、传入 setState 函数的第二个参数的作用是什么
### 13、React 中 key 的重要性是什么？
### 14、setState
### 15、你对受控组件和非受控组件了解多少？
### 16、如何告诉 React 它应该编译生产环境版
### 17、那你知道Vue3.x响应式数据原理吗？
### 18、React组件生命周期的阶段是什么？
### 19、列出 React Router 的优点。
### 20、简单说一下Vue2.x响应式数据原理
### 21、pureComponent和FunctionComponent区别
### 22、什么是React？
### 23、为什么React Router v4中使用 switch 关键字 ？
### 24、react和vue的区别
### 25、Redux 有哪些优点？
### 26、Redux遵循的三个原则是什么？
### 27、为什么选择使用框架而不是原生?
### 28、shouldComponentUpdate 的作用




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
