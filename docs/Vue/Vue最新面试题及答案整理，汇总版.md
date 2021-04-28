# Vue最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、Vue-router跳转和location.href有什么区别

**1、** 使用location.href='/url'来跳转，简单方便，但是刷新了页面；

**2、** 使用history.pushState('/url')，无刷新页面，静态跳转；

**3、** 引进router，然后使用router.push('/url')来跳转，使用了diff算法，实现了按需加载，减少了dom的消耗。

**4、** 其实使用router跳转和使用history.pushState()没什么差别的，因为vue-router就是用了history.pushState()，尤其是在history模式下。


### 2、简单说一下Vue2.x响应式数据原理

Vue在初始化数据时，会使用`Object.defineProperty`重新定义data中的所有属性，当页面使用对应属性时，首先会进行依赖收集(收集当前组件的`watcher`)如果属性发生变化会通知相关依赖进行更新操作(`发布订阅`)。


### 3、VUE的生命周期及理解？

**1、** 总共分为8个阶段，具体为：创建前/后，载入前/后，更新前/后，销毁前/后。

**2、** 创建前/后： 在beforeCreated阶段：ue实例的挂载元素$$el和数据对象data都为undefined，还未初始化；在created阶段，vue实例的数据对象data有了，$$el还没有。

**3、** 载入前/后：在beforeMount阶段，vue实例的$el和data都初始化了，但还是挂载之前为虚拟的dom节点，data.message还未替换；在mounted阶段，vue实例挂载完成，data.message成功渲染。

**4、** 更新前/后：当data变化时，会触发beforeUpdate和updated方法。

**5、** 销毁前/后：在执行destroy方法后，对data的改变不会再触发周期函数，说明此时vue实例已经解除了事件监听以及和dom的绑定，但是dom结构依然存在。

**6、** 具体讲解及应用

**beforeCreate：**在new一个vue实例后，只有一些默认的生命周期钩子和默认事件，其他的东西都还没创建，data和methods中的数据都还没有初始化。不能在这个阶段使用data中的数据和methods中的方法

**create：**data 和 methods都已经被初始化好了，如果要调用 methods 中的方法，或者操作 data 中的数据，最早可以在这个阶段中操作

**beforeMount：**执行到这个钩子的时候，在内存中已经编译好了模板了，但是还没有挂载到页面中，此时，页面还是旧的，不能直接操作页面的dom和获取dom对象

**mounted：**执行到这个钩子的时候，就表示Vue实例已经初始化完成了。此时组件脱离了创建阶段，进入到了运行阶段。如果我们想要通过插件操作页面上的DOM节点，最早可以在和这个阶段中进行

**beforeUpdate：** 当执行这个钩子时，页面中的显示的数据还是旧的，data中的数据是更新后的，页面还没有和最新的数据保持同步

**updated：**页面显示的数据和data中的数据已经保持同步了，都是最新的

**beforeDestory：**Vue实例从运行阶段进入到了销毁阶段，这个时候上所有的data和 methods、指令、过滤器 ……都是处于可用状态。还没有真正被销毁

**destroyed：** 这个时候上所有的data和methods、指令、过滤器 ……都是处于不可用状态。组件已经被销毁了。


### 4、axios及安装?

请求后台资源的模块。npm install axios --save装好，

js中使用import进来，然后.get或.post。返回在.then函数中如果成功，失败则是在.catch函数中。


### 5、vue-router 是什么?它有哪些组件

vue用来写路由一个插件。router-link、router-view


### 6、如何在JS中克隆对象

Object.assign() 方法用于在JS中克隆对象。如：

```
var x = {myProp: "value"};
var y = Object.assign({}, x);
```


### 7、说一下v-if和v-show的区别

当条件不成立时，`v-if`不会渲染DOM元素，`v-show`操作的是样式(display)，切换当前DOM的显示和隐藏。


### 8、$route 和 $router 的区别

$$router是VueRouter的实例，在script标签中想要导航到不同的URL,使用$$router.push方法。返回上一个历史history用$$router.to(-1)
$$route为当前router跳转对象。里面可以获取当前路由的name,path,query,parmas等。


### 9、子组件像父组件传递事件？

$emit方法


### 10、Vue模版编译原理知道吗，能简单说一下吗？

简单说，Vue的编译过程就是将`template`转化为`render`函数的过程。会经历以下阶段：

**1、** 生成AST树

2、优化

**3、** codegen

首先解析模版，生成`AST语法树`(一种用JavaScript对象的形式来描述整个模板)。 使用大量的正则表达式对模板进行解析，遇到标签、文本的时候都会执行对应的钩子进行相关处理。

Vue的数据是响应式的，但其实模板中并不是所有的数据都是响应式的。有一些数据首次渲染后就不会再变化，对应的DOM也不会变化。那么优化过程就是深度遍历AST树，按照相关条件对树节点进行标记。这些被标记的节点(静态节点)我们就可以`跳过对它们的比对`，对运行时的模板起到很大的优化作用。

编译的最后一步是`将优化后的AST树转换为可执行的代码`。


### 11、解释 JS 中的函数提升
### 12、说一下v-model的原理
### 13、import 和 exports 是什么？
### 14、vuejs与angularjs以及react的区别，与AngularJS的区别
### 15、iframe的优缺点？
### 16、什么是 vue 生命周期？有什么作用？
### 17、绑定 HTML 类时，该如何连接类？假设存在一个元素：Process。我们只希望使用名为 “isActive” 的数据属性动态地切换 btnActive 类。
### 18、vue的solt的用法？
### 19、vue-router的两种模式
### 20、如何将 JS 日期转换为ISO标准
### 21、如何将文件的所有导出作为一个对象？
### 22、vue单页面和传统的多页面区别？
### 23、vue中template编译的理解？
### 24、什么是插槽（slot）？
### 25、vue更新数组时触发视图更新的方法
### 26、如何确保在单文件组件中定义的 CSS 样式仅应用于该组件，而不被用于其他组件？
### 27、vuex是什么？怎么使用？哪种功能场景使用它？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
