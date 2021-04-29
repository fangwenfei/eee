# React最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、react-redux是如何工作的?

**1、** Provider: Provider的作用是从最外部封装了整个应用，并向connect模块传递store

**2、** connect: 负责连接React和Redux

**1、** 获取state: connect通过context获取Provider中的store，通过store.getState()获取整个store tree 上所有state

**2、** 包装原组件: 将state和action通过props的方式传入到原组件内部wrapWithConnect返回一个ReactComponent对象Connect，Connect重新render外部传入的原组件WrappedComponent，并把connect中传入的mapStateToProps, mapDispatchToProps与组件上原有的props合并后，通过属性的方式传给WrappedComponent

**3、** 监听store tree变化: connect缓存了store tree中state的状态,通过当前state状态和变更前state状态进行比较,从而确定是否调用`this.setState()`方法触发Connect及其子组件的重新渲染

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_12.png#alt=97%5C_12.png)


### 2、列出 React Router 的优点。

**几个优点是：**

**1、**  就像 React 基于组件一样，在 React Router v4 中，API 是 _'All About Components'_。可以将 Router 可视化为单个根组件（`<BrowserRouter>`），其中我们将特定的子路由（`<route>`）包起来。

**2、**  无需手动设置历史值：在 React Router v4 中，我们要做的就是将路由包装在 `<BrowserRouter>` 组件中。

**3、**  包是分开的：共有三个包，分别用于 Web、Native 和 Core。这使我们应用更加紧凑。基于类似的编码风格很容易进行切换。


### 3、如何将两个或多个组件嵌入到一个组件中？

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


### 4、react和vue的区别

**相同点**

**1、** 数据驱动页面提供响应式的试图组件

**2、** 都有 `virtual DOM`,组件化的开发通过 `props`参数进行父子之间组件传递数据都实现了 `webComponents`规范

**3、** 数据流动单向都支持服务器的渲染SSR

**4、** 都有支持 `native`的方法 `react`有 `React native vue`有 `wexx`

**不同点**

**1、** 数据绑定 `Vue`实现了双向的数据绑定 `react`数据流动是单向的

**2、** 数据渲染大规模的数据渲染 `react`更快

**3、** 使用场景 `React`配合 `Redux`架构适合大规模多人协作复杂项目Vue适合小快的项目

**4、** 开发风格 `react`推荐做法 `jsx` + `inline style`把 `html`和 `css`都写在 `js`了

**5、** `vue`是采用 `webpack` + `vue-loader`单文件组件格式 `html`, `js`, `css`同一个文件


### 5、React有哪些优化性能是手段?

性能优化的手段很多时候是通用的详情见前端性能优化加载篇


### 6、diff算法?

把树形结构按照层级分解，只比较同级元素。

给列表结构的每个单元添加唯一的key属性，方便比较。

React 只会匹配相同 class 的 component（这里面的class指的是组件的名字）

合并操作，调用 component 的 setState 方法的时候, React 将其标记为 dirty.到每一个事件循环结束, React 检查所有标记 dirty 的 component 重新绘制

选择性子树渲染。开发人员可以重写shouldComponentUpdate提高diff的性能。



### 7、React与Angular有何不同？
| 主题 | React | Angular |
| --- | --- | --- |
| _1、体系结构_ | 只有 MVC 中的 View | 完整的 MVC |
| _2、渲染_ | 可以在服务器端渲染 | 客户端渲染 |
| _3、DOM_ | 使用 virtual DOM | 使用 real DOM |
| _4、数据绑定_ | 单向数据绑定 | 双向数据绑定 |
| _5、调试_ | 编译时调试 | 运行时调试 |
| _6、作者_ | Facebook | Google |



### 8、如何更新组件的状态？
### 9、React中的合成事件是什么？
### 10、你对 Time Slice的理解?
### 11、react性能优化方案
### 12、你对受控组件和非受控组件了解多少？
### 13、虚拟DOM的优劣如何?
### 14、redux的工作流程?
### 15、redux与mobx的区别?
### 16、diff算法?
### 17、SSR了解吗？
### 18、nextTick知道吗，实现原理是什么？
### 19、React中的事件是什么？
### 20、MVC框架的主要问题是什么？
### 21、Redux与Flux有何不同？
### 22、什么是控制组件？
### 23、你对 React 的 refs 有什么了解？
### 24、React 中的箭头函数是什么？怎么用？
### 25、React组件生命周期的阶段是什么？
### 26、React有什么特点？
### 27、shouldComponentUpdate 的作用




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
