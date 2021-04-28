# Vue最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、开发人员经常使用字母 “vm” 作为变量名来声明根 Vue 实例。例如 const vm = new Vue()。在这种情况下，“vm”指的是什么？

虽然这不是约定，但是开发人员经常使用变量名称 'vm' 来命名根 Vue 实例，该变量名称代表 'ViewModel'，因为 Vue 本质上负责视图层，并且部分受到了 MVVM 模式的启发（Model-View-View-Model）。但是，根本没有必要将根实例命名为 “vm”。


Vue吧，我很喜欢尤大，最近刚发布了Vue的首部纪录片，真的很好看。


### 2、active-class 是哪个组件的属性？

vue-router模块的router-link组件。children数组来定义子路由


### 3、简述每个周期具体适合哪些场景

**1、** beforeCreate：在new一个vue实例后，只有一些默认的生命周期钩子和默认事件，其他的东西都还没创建。在beforeCreate生命周期执行的时候，data和methods中的数据都还没有初始化。不能在这个阶段使用data中的数据和methods中的方法

**2、** create：data 和 methods都已经被初始化好了，如果要调用 methods 中的方法，或者操作 data 中的数据，最早可以在这个阶段中操作

**3、** beforeMount：执行到这个钩子的时候，在内存中已经编译好了模板了，但是还没有挂载到页面中，此时，页面还是旧的

**4、** mounted：执行到这个钩子的时候，就表示Vue实例已经初始化完成了。此时组件脱离了创建阶段，进入到了运行阶段。 如果我们想要通过插件操作页面上的DOM节点，最早可以在和这个阶段中进行

**5、** beforeUpdate： 当执行这个钩子时，页面中的显示的数据还是旧的，data中的数据是更新后的， 页面还没有和最新的数据保持同步

**6、** updated：页面显示的数据和data中的数据已经保持同步了，都是最新的

**7、** beforeDestory：Vue实例从运行阶段进入到了销毁阶段，这个时候上所有的 data 和 methods ， 指令， 过滤器 ……都是处于可用状态。还没有真正被销毁

**8、** destroyed： 这个时候上所有的 data 和 methods ， 指令， 过滤器 ……都是处于不可用状态。组件已经被销毁了。


### 4、JS中的匿名函数是什么？

匿名函数：就是没有函数名的函数，如：

```
(function(x, y){
    alert(x + y);
})(2, 3);
```

这里创建了一个匿名函数(在第一个括号内)，第二个括号用于调用该匿名函数，并传入参数。


### 5、vue-router实现懒加载的方式？

vue异步组件

vue异步组件技术 ==== 异步加载

vue-router配置路由 , 使用vue的异步组件技术 , 可以实现按需加载 。但是,这种情况下一个组件生成一个js文件

```
/* vue异步组件技术 */
{
  path: '/home',
  name: 'home',
  component: resolve => require(['@/components/home'],resolve)
},{
  path: '/index',
  name: 'Index',
  component: resolve => require(['@/components/index'],resolve)
},{
  path: '/about',
  name: 'about',
  component: resolve => require(['@/components/about'],resolve)
}
es提案的import()
```

路由懒加载(使用import)

```
// 下面2行代码，没有指定webpackChunkName，每个组件打包成一个js文件。
/* const Home = () => import('@/components/home')
const Index = () => import('@/components/index')
const About = () => import('@/components/about') */
// 下面2行代码，指定了相同的webpackChunkName，会合并打包成一个js文件。把组件按组分块
const Home =  () => import(/* webpackChunkName: 'ImportFuncDemo' */ '@/components/home')
const Index = () => import(/* webpackChunkName: 'ImportFuncDemo' */ '@/components/index')
const About = () => import(/* webpackChunkName: 'ImportFuncDemo' */ '@/components/about')
{
  path: '/about',
  component: About
}, {
  path: '/index',
  component: Index
}, {
  path: '/home',
  component: Home
}
webpack的require,ensure()
```

vue-router配置路由，使用webpack的require.ensure技术，也可以实现按需加载。这种情况下，多个路由指定相同的chunkName，会合并打包成一个js文件。

```
/* 组件懒加载方案三: webpack提供的require.ensure() */
{
  path: '/home',
  name: 'home',
  component: r => require.ensure([], () => r(require('@/components/home')), 'demo')
}, {
  path: '/index',
  name: 'Index',
  component: r => require.ensure([], () => r(require('@/components/index')), 'demo')
}, {
  path: '/about',
  name: 'about',
  component: r => require.ensure([], () => r(require('@/components/about')), 'demo-01')
}
```


### 6、vue-router有哪几种导航钩子？

**三种**

**1、** 第一种：是全局导航钩子：router.beforeEach(to,from,next)，作用：跳转前进行判断拦截。

**2、** 第二种：组件内的钩子

**3、** 第三种：单独路由独享组件


### 7、组件中的data为什么是一个函数？

一个组件被复用多次的话，也就会创建多个实例。本质上，`这些实例用的都是同一个构造函数`。如果data是对象的话，对象属于引用类型，会影响到所有的实例。所以为了保证组件不同的实例之间data不冲突，data必须是一个函数。


### 8、用纯JS编写一个程序来反转字符串

使用内置函数：内置函数reverse()直接反转字符串。

```
str="jQuery";
str = str.split("")
str = str.reverse()
str = str.join("")
alert(str);
```

首先将字符串拆分为数组，然后反转数组，最近将字符连接起来形成字符串。 使用循环:首先，计算字符串中的字符数，然后对原始字符串应用递减循环，该循环从最后一个字符开始，打印每个字符，直到count变为零。


### 9、嵌套路由怎么定义？

在实际项目中我们会碰到多层嵌套的组件组合而成，但是我们如何实现嵌套路由呢？因此我们需要在 VueRouter 的参数中使用 children 配置，这样就可以很好的实现路由嵌套。

index.html，只有一个路由出口

```
<div id="app">
    <!-- router-view 路由出口, 路由匹配到的组件将渲染在这里 -->
    <router-view></router-view>
</div>
```

main.js，路由的重定向，就会在页面一加载的时候，就会将home组件显示出来，因为重定向指向了home组件，redirect的指向与path的必须一致。children里面是子路由，当然子路由里面还可以继续嵌套子路由。

```
import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

//引入两个组件

import home from "./home.vue"
import game from "./game.vue"
//定义路由
const routes = [
    { path: "/", redirect: "/home" },//重定向,指向了home组件
    {
        path: "/home", component: home,
        children: [
            { path: "/home/game", component: game }
        ]
    }
]
//创建路由实例
const router = new VueRouter({routes})

new Vue({
    el: '#app',
    data: {
    },
    methods: {
    },
    router
})
```

home.vue，点击显示就会将子路由显示在出来，子路由的出口必须在父路由里面，否则子路由无法显示。

```
<template>
    <div>
        <h3>首页</h3>
        <router-link to="/home/game">
            <button>显示<tton>
        </router-link>
        <router-view></router-view>
    </div>
</template>
```

game.vue

```
 <template>
    <h3>游戏</h3>
</template>
```


### 10、vue开发遇到的问题？

**样式污染**

在编写样式中，如果需要防止样式的污染，可以使用两种方式，一种是在组件的根元素上增加一个唯一的class或者id，然后在编写组件的样式时候在根元素对应的class或者id下进行编写；另一种方式是在对应的style上添加scoped关键字，不过该关键字对引用的框架UI无效

**router-link在安卓上不起作用**

不起作用的原因是因为转码编译的问题，可以使用babel来进行处理，安装babel polypill插件解决

**初始化页面出现闪屏乱码的问题**

这是因为vue还没有解析的情况下会容易出现花屏现象，看到类似于{{data}}的字样，可以使用两种方式来进行处理，一种为：在设置index.html的根元素的元素的样式为display:none，然后在mounted中的$nextTick函数中display:block展示；另一种方式是使用vue的内置指令：v-cloak,并且在css中设置样式

```
[v-cloak] {
    display: none;
}
```

**router-link上事件无效解决方法**

使用@click.native来进行调用原生的js事件。原因：router-link会阻止click事件，.native指直接监听一个原生事件。



### 11、Vue的双向数据绑定原理是什么？
### 12、你用哪个指令遍历对象的属性？
### 13、route和router的区别？
### 14、vue中的v-cloak的理解？
### 15、vue的实现原理？
### 16、vue组件的通信（父子组件和非父子组件）？
### 17、第一次页面加载会触发哪几个钩子？
### 18、vuex有哪几种属性？
### 19、v-show和v-if指令的共同点和不同点？
### 20、SEO优化
### 21、undefined，null 和 undeclared 有什么区别？
### 22、解释一下什么是箭头函数？
### 23、axios+tp5进阶中，调用axios.post(‘api/user’)是进行的什么操作？axios.put(‘api/user/8′)呢？
### 24、vue生命周期总共有几个阶段？
### 25、axios的特点有哪些
### 26、简单描述每个周期具体适合哪些场景？
### 27、JS中的深拷贝与浅拷贝的区别？
### 28、的作用是什么?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
