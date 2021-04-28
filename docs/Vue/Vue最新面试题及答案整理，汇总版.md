# Vue最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、自定义指令（v-check、v-focus）的方法有哪些？它有哪些钩子函数？还有哪些钩子函数参数？

**1、** 全局定义指令：在vue对象的directive方法里面有两个参数，一个是指令名称，另外一个是函数。组件内定义指令：directives

**2、** 钩子函数：bind（绑定事件触发）、inserted(节点插入的时候触发)、update（组件内相关更新）

**3、** 钩子函数参数：el、binding


### 2、module.exports 和 exports 之间有什么区别？

module和exports是Node.js给每个js文件内置的两个对象。可以通过console.log(module)和console.log(exports)打印出来。如果你在main.js中写入下面两行，然后运行$ node main.js:

```
console.log(exports);//输出：{}
console.log(module);//输出：Module {..., exports: {}, ...} （注：...代表省略了其他一些属性）
```

从打印咱们可以看出，module.exports和exports一开始都是一个空对象{}，实际上，这两个对象指向同一块内存。这也就是说module.exports和exports是等价的（有个前提：不去改变它们指向的内存地址）。

例如：exports.age = 18和module.export.age = 18，这两种写法是一致的（都相当于给最初的空对象{}添加了一个属性，通过require得到的就是{age: 18}）。


### 3、如何在JS中克隆对象

Object.assign() 方法用于在JS中克隆对象。如：

```
var x = {myProp: "value"};
var y = Object.assign({}, x);
```


### 4、请说出vue.cli项目中src目录每个文件夹和文件的用法？

assets文件夹是放静态资源；components是放组件；router是定义路由相关的配置; app.vue是一个应用主组件；main.js是入口文件。


### 5、vue slot

简单来说，假如父组件需要在子组件内放一些DOM，那么这些DOM是显示、不显示、在哪个地方显示、如何显示，就是slot分发负责的活。


### 6、你都做过哪些Vue的性能优化，编码阶段

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


### 7、嵌套路由怎么定义？

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


### 8、vue单页面和传统的多页面区别？

**单页面应用（SPA）**

通俗一点说就是指只有一个主页面的应用，浏览器一开始要加载所有必须的 html, js, css。所有的页面内容都包含在这个所谓的主页面中。但在写的时候，还是会分开写（页面片段），然后在交互的时候由路由程序动态载入，单页面的页面跳转，仅刷新局部资源。多应用于pc端。

**多页面（MPA）**

指一个应用中有多个页面，页面跳转时是整页刷新

**单页面的优点：**

用户体验好，快，内容的改变不需要重新加载整个页面，基于这一点spa对服务器压力较小；前后端分离；页面效果会比较炫酷（比如切换页面内容时的专场动画）。

**单页面缺点：**

不利于seo；导航不可用，如果一定要导航需要自行实现前进、后退。（由于是单页面不能用浏览器的前进后退功能，所以需要自己建立堆栈管理）；初次加载时耗时多；页面复杂度提高很多。


### 9、v-model的理解？

v-model用于表单数据的双向绑定，其实它就是一个语法糖，这个背后就做了两个操作：

**1、** v-bind绑定一个value属性；

**2、** v-on指令给当前元素绑定input事件


### 10、data为什么是一个函数？

这是有JavaScript的特性所导致，在component中，data必须以函数的形式存在，不可以是对象。

组建中的data写成一个函数，数据以函数返回值的形式定义，这样每次复用组件的时候，都会返回一份新的data，相当于每个组件实例都有自己私有的数据空间，它们只负责各自维护的数据，不会造成混乱。而单纯的写成对象形式，就是所有的组件实例共用了一个data，这样改一个全都改了。


### 11、JS中的匿名函数是什么？
### 12、如何动态地在元素上切换 CSS 类？
### 13、import 和 exports 是什么？
### 14、delete和Vue.delete删除数组的区别
### 15、vue常用的UI组件库
### 16、delete和Vue.delete删除数组的区别？
### 17、mint-ui是什么？怎么使用？说出至少三个组件使用方法？
### 18、vuex的使用？
### 19、子组件像父组件传递事件？
### 20、iframe的优缺点？
### 21、再说一下vue2.x中如何监测数组变化
### 22、与React的区别
### 23、解释JS中的事件冒泡和事件捕获
### 24、created和mounted的区别
### 25、请讲述下VUE的MVVM的理解？
### 26、JS中的substr()和substring()函数有什么区别
### 27、Vue中双向数据绑定是如何实现的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
