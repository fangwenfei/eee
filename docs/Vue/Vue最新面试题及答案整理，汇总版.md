# Vue最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、v-modal的使用。

**1、** v-model用于表单数据的双向绑定，其实它就是一个语法糖，这个背后就做了两个操作：

**2、** v-bind绑定一个value属性；

**3、** v-on指令给当前元素绑定input事件。


### 2、你都做过哪些Vue的性能优化，编码阶段

**1、** 尽量减少data中的数据，data中的数据都会增加getter和setter，会收集对应的watcher

**2、** v-if和v-for不能连用

**3、** 如果需要使用v-for给每项元素绑定事件时使用事件代理

**4、** SPA 页面采用keep-alive缓存组件

**5、** 在更多的情况下，使用v-if替代v-show

**6、** key保证唯一

**7、** 使用路由懒加载、异步组件

**8、** 防抖、节流

**9、** 第三方模块按需导入

**10、** 长列表滚动到可视区域动态加载

**11、** 图片懒加载


### 3、渐进式框架的理解

主张最少；可以根据不同的需求选择不同的层级；


### 4、什么是 vue 生命周期？有什么作用？

每个 Vue 实例在被创建时都要经过一系列的初始化过程——例如，需要设置数据监听、编译模板、将实例挂载到 DOM 并在数据变化时更新 DOM 等。同时在这个过程中也会运行一些叫做 生命周期钩子 的函数，这给了用户在不同阶段添加自己的代码的机会。（ps：生命周期钩子就是生命周期函数）例如，如果要通过某些插件操作DOM节点，如想在页面渲染完后弹出广告窗， 那我们最早可在mounted 中进行。


### 5、vue-router有哪几种导航钩子？

**三种**

**1、** 第一种：是全局导航钩子：router.beforeEach(to,from,next)，作用：跳转前进行判断拦截。

**2、** 第二种：组件内的钩子

**3、** 第三种：单独路由独享组件


### 6、vue中的v-cloak的理解？

使用 v-cloak 指令设置样式，这些样式会在 Vue 实例编译结束时，从绑定的 HTML 元素上被移除。

一般用于解决网页闪屏的问题，在对一个的标签中使用v-cloak，然后在样式中设置[v-cloak]样式,[v-cloak]需写在 link 引入的css中，或者写一个内联css样式，写在import引入的css中不起作用。


### 7、为什么使用key?

需要使用key来给每个节点做一个唯一标识，Diff算法就可以正确的识别此节点。

作用主要是为了高效的更新虚拟DOM。


### 8、解释一下什么是 promise ？

promise是js中的一个对象，用于生成可能在将来产生结果的值。 值可以是已解析的值，也可以是说明为什么未解析该值的原因。

promise 可以有三种状态:

**1、** pending：初始状态，既不是成功也不是失败

**2、** fulfilled：意味着操作完全成功

**3、** rejected：意味着操作失败

一个等待状态的promise对象能够成功后返回一个值，也能失败后带回一个错误 当这两种情况发生的时候，处理函数会排队执行通过then方法会被调用。


### 9、vue-router是什么？它有哪些组件？

vue用来写路由一个插件。router-link、router-view


### 10、列出JS中的一些设计模式:

设计模式是软件设计中常见问题的通用可重用解决方案，以下是一些设计模式是： 创建模式：该模式抽象了对象实例化过程。

结构型模式：这些模式处理不同的类和对象以提供新功能。

行为模式：也称发布-订阅模式，定义了一个被观察者和多个观察者的、一对多的对象关系。

并行设计模式：这些模式处理多线程编程范例。 架构设计模式：这些模式用于处理架构设计


### 11、你用哪个指令遍历对象的属性？
### 12、解释JS中的高阶函数？
### 13、解释一下 "use strict" ? “
### 14、你是怎么认识vuex的？
### 15、v-for中的key的理解？
### 16、vue的自定义指令？
### 17、Vue2中注册在router-link上事件无效解决方法
### 18、说一下v-model的原理
### 19、import 和 exports 是什么？
### 20、数组去重复的方法有哪些
### 21、请说出vue.cli项目中src目录每个文件夹和文件的用法？
### 22、简单描述每个周期具体适合哪些场景？
### 23、vue-roter的钩子函数？
### 24、什么是vue生命周期？
### 25、什么是过滤器？
### 26、v-show 指令的用途是什么？
### 27、vue slot




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
