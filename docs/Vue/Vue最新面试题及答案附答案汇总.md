# Vue最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、v-model是什么？怎么使用？ vue中标签怎么绑定事件？

可以实现双向绑定，指令（v-class、v-for、v-if、v-show、v-on）。vue的model层的data属性。绑定事件：`<input @click=doLog()/>`


### 2、嵌套路由怎么定义？

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


### 3、Vue中组件生命周期调用顺序说一下

组件的调用顺序都是`先父后子`,渲染完成的顺序是`先子后父`。

组件的销毁操作是`先父后子`，销毁完成的顺序是`先子后父`。


### 4、vue-router实现路由懒加载（ 动态加载路由 ）

**三种方式**

**1、** vue异步组件技术 ==== 异步加载，vue-router配置路由 , 使用vue的异步组件技术 , 可以实现按需加载 .但是,这种情况下一个组件生成一个js文件。

**2、** 路由懒加载(使用import)。

**3、** webpack提供的require.ensure()，vue-router配置路由，使用webpack的require.ensure技术，也可以实现按需加载。这种情况下，多个路由指定相同的chunkName，会合并打包成一个js文件。


### 5、$nextTick的使用？

在vue中理解修改数据后，对应的dom需要一定的时间进行更新，因此为了能够准确的后去更新后的dom，可以采用延迟回调的方法进行更新dom的获取，所以出现了$nextTick来进行延迟回调。即：在下次 DOM 更新循环结束之后执行延迟回调。在修改数据之后立即使用这个方法，获取更新后的 DOM。


### 6、vuex是什么？怎么使用？哪种功能场景使用它？

vue框架中状态管理。在main.js引入store，注入。新建了一个目录store，….、export 。场景有：单页应用中，组件之间的状态。音乐播放、登录状态、加入购物车


### 7、说出至少4种vue当中的指令和它的用法？

v-if：判断是否隐藏；v-for：数据循环出来；v-bind:class：绑定一个属性；v-model：实现双向绑定


### 8、如何将文件的所有导出作为一个对象？

import * as objectname from ‘./file.js’用于将所有导出的成员导入为对象。 可以使用对象的点（.）运算符来访问导出的变量或方法，如：

```
objectname.member1;
objectname.member2;
objectname.memberfunc();
```


### 9、怎么定义 vue-router 的动态路由? 怎么获取传过来的值？

在router目录下的index.js文件中，对path属性加上/:id。 使用router对象的params.id。


### 10、解释 JS 中的函数提升

JS允许将声明移动到顶部的默认行为称为提升。JS中创建函数的两种方法是函数声明和函数表达式。

**函数声明**

具有特定参数的函数称为函数声明，在JS中创建变量称为声明。如：

```
hoisted(); // logs "foo"

function hoisted() {
  console.log('foo');
}
```

**函数表达式**

当使用表达式创建函数时，称为函数表达式。如：

```
notHoisted(); // TypeError: notHoisted is not a function

var notHoisted = function() {
   console.log('bar');
};
```


### 11、如何在现有函数中添加新属性
### 12、说一下v-if和v-show的区别
### 13、用户体验
### 14、vue修改打包后静态资源路径的修改
### 15、父组件更新过程
### 16、什么是插槽（slot）？
### 17、为什么使用key?
### 18、请讲述下VUE的MVVM的理解？
### 19、module.exports 和 exports 之间有什么区别？
### 20、Vue2.x组件通信有哪些方式？
### 21、JS的作用域链是什么及其作用
### 22、vue中transition的理解？
### 23、vue的两个核心点
### 24、vue的自定义指令？
### 25、如何获取dom?
### 26、第一次页面加载会触发哪几个钩子？
### 27、vue的solt的用法？
### 28、路由跳转和location.href的区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
