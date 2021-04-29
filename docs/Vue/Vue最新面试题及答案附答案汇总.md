# Vue最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、简述每个周期具体适合哪些场景

**1、** beforeCreate：在new一个vue实例后，只有一些默认的生命周期钩子和默认事件，其他的东西都还没创建。在beforeCreate生命周期执行的时候，data和methods中的数据都还没有初始化。不能在这个阶段使用data中的数据和methods中的方法

**2、** create：data 和 methods都已经被初始化好了，如果要调用 methods 中的方法，或者操作 data 中的数据，最早可以在这个阶段中操作

**3、** beforeMount：执行到这个钩子的时候，在内存中已经编译好了模板了，但是还没有挂载到页面中，此时，页面还是旧的

**4、** mounted：执行到这个钩子的时候，就表示Vue实例已经初始化完成了。此时组件脱离了创建阶段，进入到了运行阶段。 如果我们想要通过插件操作页面上的DOM节点，最早可以在和这个阶段中进行

**5、** beforeUpdate： 当执行这个钩子时，页面中的显示的数据还是旧的，data中的数据是更新后的， 页面还没有和最新的数据保持同步

**6、** updated：页面显示的数据和data中的数据已经保持同步了，都是最新的

**7、** beforeDestory：Vue实例从运行阶段进入到了销毁阶段，这个时候上所有的 data 和 methods ， 指令， 过滤器 ……都是处于可用状态。还没有真正被销毁

**8、** destroyed： 这个时候上所有的 data 和 methods ， 指令， 过滤器 ……都是处于不可用状态。组件已经被销毁了。


### 2、打包优化

**1、** 压缩代码

**2、** Tree Shaking/Scope Hoisting

**3、** 使用cdn加载第三方模块

**4、** 多线程打包happypack

**5、** splitChunks抽离公共文件

**6、** sourceMap优化


### 3、Vue中组件生命周期调用顺序说一下

组件的调用顺序都是`先父后子`,渲染完成的顺序是`先子后父`。

组件的销毁操作是`先父后子`，销毁完成的顺序是`先子后父`。


### 4、vue与react、angular的比较？

**Vue**

轻量级框架：只关注视图层，是一个构建数据的视图集合，大小只有几十kb；

简单易学：国人开发，中文文档，不存在语言障碍 ，易于理解和学习；

双向数据绑定：保留了angular的特点，在数据操作方面更为简单；

组件化：保留了react的优点，实现了html的封装和重用，在构建单页面应用方面有着独特的优势；

视图，数据，结构分离：使数据的更改更为简单，不需要进行逻辑代码的修改，只需要操作数据就能完成相关操作；

虚拟DOM：dom操作是非常耗费性能的， 不再使用原生的dom操作节点，极大解放dom操作，但具体操作的还是dom不过是换了另一种方式；

运行速度更快:相比较与react而言，同样是操作虚拟dom，就性能而言，vue存在很大的优势。

**React**

**相同点：**

React采用特殊的JSX语法，Vue.js在组件开发中也推崇编写.vue特殊文件格式，对文件内容都有一些约定，两者都需要编译后使用；中心思想相同：一切都是组件，组件实例之间可以嵌套；都提供合理的钩子函数，可以让开发者定制化地去处理需求；都不内置列数AJAX，Route等功能到核心包，而是以插件的方式加载；在组件开发中都支持mixins的特性。

**不同点：**

React采用的Virtual DOM会对渲染出来的结果做脏检查；Vue.js在模板中提供了指令，过滤器等，可以非常方便，快捷地操作Virtual DOM。

**Angular**

**相同点：**

都支持指令：内置指令和自定义指令；都支持过滤器：内置过滤器和自定义过滤器；都支持双向数据绑定；都不支持低端浏览器。

**不同点：**

AngularJS的学习成本高，比如增加了Dependency Injection特性，而Vue.js本身提供的API都比较简单、直观；在性能上，AngularJS依赖对数据做脏检查，所以Watcher越多越慢；Vue.js使用基于依赖追踪的观察并且使用异步队列更新，所有的数据都是独立触发的。


### 5、JS中的宿主对象与原生对象有何不同？

宿主对象:这些是运行环境提供的对象。这意味着它们在不同的环境下是不同的。例如，浏览器包含像windows这样的对象，但是Node.js环境提供像Node List这样的对象。

原生对象:这些是JS中的内置对象。它们也被称为全局对象，因为如果使用JS，内置对象不受是运行环境影响。


### 6、再说一下vue2.x中如何监测数组变化

使用了函数劫持的方式，重写了数组的方法，Vue将data中的数组进行了原型链重写，指向了自己定义的数组原型方法。这样当调用数组api时，可以通知依赖更新。如果数组中包含着引用类型，会对数组中的引用类型再次递归遍历进行监控。这样就实现了监测数组变化。

（能问到这的面试官都比较注重深度，这些常规操作要记牢）


### 7、active-class 是哪个组件的属性？

vue-router模块的router-link组件。children数组来定义子路由


### 8、说一下v-if和v-show的区别

当条件不成立时，`v-if`不会渲染DOM元素，`v-show`操作的是样式(display)，切换当前DOM的显示和隐藏。


### 9、vue常用的修饰符

**1、** .stop：等同于JavaScript中的event.stopPropagation()，防止事件冒泡；

**2、** .prevent：等同于JavaScript中的event.preventDefault()，防止执行预设的行为（如果事件可取消，则取消该事件，而不停止事件的进一步传播）；

**3、** .capture：与事件冒泡的方向相反，事件捕获由外到内；

**4、** .self：只会触发自己范围内的事件，不包含子元素；

**5、** .once：只会触发一次。


### 10、JS 中 == 和 === 区别是什么？

**对于string,number等基础类型，和=有区别**

不同类型间比较，==之比较“转化成同一类型后的值”看“值”是否相等，===如果类型不同，其结果就是不等。

同类型比较，直接进行“值”比较，两者结果一样。

**对于Array,Object等高级类型，和=没有区别 进行“指针地址”比较。**

**基础类型与高级类型，和=有区别**

对于==，将高级转化为基础类型，进行“值”比较。

因为类型不同，===结果为false。


### 11、什么是组件？
### 12、created和mounted的区别
### 13、vue和jQuery的区别
### 14、delete和Vue.delete删除数组的区别？
### 15、vue父组件向子组件传递数据？
### 16、assets和static的区别
### 17、vue的两个核心点
### 18、v-model的理解？
### 19、Vue-router跳转和location.href有什么区别
### 20、什么是插槽（slot）？
### 21、给出模板，描述 Vue 程序的输出。
### 22、再说一下Computed和Watch
### 23、请说下封装 vue 组件的过程？
### 24、Vue模版编译原理知道吗，能简单说一下吗？
### 25、聊聊你对Vue.js的template编译的理解？
### 26、解释一下什么是箭头函数？
### 27、子组件像父组件传递事件？
### 28、JS中的匿名函数是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
