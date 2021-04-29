# Vue最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、vue-router 是什么?它有哪些组件

vue用来写路由一个插件。router-link、router-view


### 2、delete和Vue.delete删除数组的区别

delete只是被删除的元素变成了 empty/undefined 其他的元素的键值还是不变。Vue.delete 直接删除了数组 改变了数组的键值。


### 3、axios+tp5进阶中，调用axios.post(‘api/user’)是进行的什么操作？axios.put(‘api/user/8′)呢？

跨域，添加用户操作，更新操作。


### 4、module.exports 和 exports 之间有什么区别？

module和exports是Node.js给每个js文件内置的两个对象。可以通过console.log(module)和console.log(exports)打印出来。如果你在main.js中写入下面两行，然后运行$ node main.js:

```
console.log(exports);//输出：{}
console.log(module);//输出：Module {..., exports: {}, ...} （注：...代表省略了其他一些属性）
```

从打印咱们可以看出，module.exports和exports一开始都是一个空对象{}，实际上，这两个对象指向同一块内存。这也就是说module.exports和exports是等价的（有个前提：不去改变它们指向的内存地址）。

例如：exports.age = 18和module.export.age = 18，这两种写法是一致的（都相当于给最初的空对象{}添加了一个属性，通过require得到的就是{age: 18}）。


### 5、那你能讲一讲MVVM吗？

MVVM是`Model-View-ViewModel`缩写，也就是把`MVC`中的`Controller`演变成`ViewModel`。Model层代表数据模型，View代表UI组件，ViewModel是View和Model层的桥梁，数据会绑定到viewModel层并自动将数据渲染到页面中，视图变化的时候会通知viewModel层更新数据。


### 6、Vue模版编译原理知道吗，能简单说一下吗？

简单说，Vue的编译过程就是将`template`转化为`render`函数的过程。会经历以下阶段：

**1、** 生成AST树

2、优化

**3、** codegen

首先解析模版，生成`AST语法树`(一种用JavaScript对象的形式来描述整个模板)。 使用大量的正则表达式对模板进行解析，遇到标签、文本的时候都会执行对应的钩子进行相关处理。

Vue的数据是响应式的，但其实模板中并不是所有的数据都是响应式的。有一些数据首次渲染后就不会再变化，对应的DOM也不会变化。那么优化过程就是深度遍历AST树，按照相关条件对树节点进行标记。这些被标记的节点(静态节点)我们就可以`跳过对它们的比对`，对运行时的模板起到很大的优化作用。

编译的最后一步是`将优化后的AST树转换为可执行的代码`。


### 7、为什么Vue被称为“渐进框架”？

使用渐进式框架的代价很小，从而使现有项目（使用其他技术构建的项目）更容易采用并迁移到新框架。 Vue.js 是一个渐进式框架，因为你可以逐步将其引入现有应用，而不必从头开始重写整个程序。

Vue 的最基本和核心的部分涉及“视图”层，因此可以通过逐步将 Vue 引入程序并替换“视图”实现来开始你的旅程。

由于其不断发展的性质，Vue 与其他库配合使用非常好，并且非常容易上手。这与 Angular.js 之类的框架相反，后者要求将现有程序完全重构并在该框架中实现。


### 8、请说下封装 vue 组件的过程？
### 9、解释 JS 中的函数提升
### 10、vue-router实现路由懒加载（ 动态加载路由 ）
### 11、vue组件中data为什么必须是一个函数？
### 12、说出几种vue当中的指令和它的用法？
### 13、什么是vue生命周期？
### 14、v-for中的key的理解？
### 15、请说出vue.cli项目中src目录每个文件夹和文件的用法？
### 16、简单描述每个周期具体适合哪些场景？
### 17、与React的区别
### 18、active-class 是哪个组件的属性？
### 19、打包优化
### 20、vue的diff算法理解？
### 21、导航钩子有哪些？它们有哪些参数？
### 22、如何封装一个vue组件？
### 23、vue的历史记录
### 24、列出一些单元测试框架
### 25、再说一下虚拟Dom以及key属性的作用
### 26、Vue2.x组件通信有哪些方式？
### 27、vue中template编译的理解？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
