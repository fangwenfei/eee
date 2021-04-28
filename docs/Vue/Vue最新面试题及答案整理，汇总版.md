# Vue最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、简述每个周期具体适合哪些场景

**1、** beforeCreate：在new一个vue实例后，只有一些默认的生命周期钩子和默认事件，其他的东西都还没创建。在beforeCreate生命周期执行的时候，data和methods中的数据都还没有初始化。不能在这个阶段使用data中的数据和methods中的方法

**2、** create：data 和 methods都已经被初始化好了，如果要调用 methods 中的方法，或者操作 data 中的数据，最早可以在这个阶段中操作

**3、** beforeMount：执行到这个钩子的时候，在内存中已经编译好了模板了，但是还没有挂载到页面中，此时，页面还是旧的

**4、** mounted：执行到这个钩子的时候，就表示Vue实例已经初始化完成了。此时组件脱离了创建阶段，进入到了运行阶段。 如果我们想要通过插件操作页面上的DOM节点，最早可以在和这个阶段中进行

**5、** beforeUpdate： 当执行这个钩子时，页面中的显示的数据还是旧的，data中的数据是更新后的， 页面还没有和最新的数据保持同步

**6、** updated：页面显示的数据和data中的数据已经保持同步了，都是最新的

**7、** beforeDestory：Vue实例从运行阶段进入到了销毁阶段，这个时候上所有的 data 和 methods ， 指令， 过滤器 ……都是处于可用状态。还没有真正被销毁

**8、** destroyed： 这个时候上所有的 data 和 methods ， 指令， 过滤器 ……都是处于不可用状态。组件已经被销毁了。


### 2、vue修改打包后静态资源路径的修改

cli2版本：将 config/index.js 里的 assetsPublicPath 的值改为 './' 。

build: {

...

assetsPublicPath: './',

...

}

cli3版本：在根目录下新建vue.config.js 文件，然后加上以下内容：（如果已经有此文件就直接修改）

module.exports = {

publicPath: '', // 相对于 HTML 页面（目录相同） }


### 3、再说一下Computed和Watch

`Computed`本质是一个具备缓存的watcher，依赖的属性发生变化就会更新视图。 适用于计算比较消耗性能的计算场景。当表达式过于复杂时，在模板中放入过多逻辑会让模板难以维护，可以将复杂的逻辑放入计算属性中处理。

`Watch`没有缓存性，更多的是观察的作用，可以监听某些数据执行回调。当我们需要深度监听对象中的属性时，可以打开`deep：true`选项，这样便会对对象中的每一项进行监听。这样会带来性能问题，优化的话可以使用`字符串形式`监听，如果没有写到组件中，不要忘记使用`unWatch手动注销`哦。


### 4、你用哪个指令遍历对象的属性？

要遍历对象或数组，可以使用 **v-for** 指令。下面是一个例子：

**Template**

```
<div id="app">
    <ul>
      <li v-for="(value, key) in card">{{ key }} - {{ value }}</li>    </ul>
 </div>
```

**App**

```
new Vue({
  el: '#app',
  data: {
    card: {
      name: 'John Doe',
      age: 25,
      city: 'New York',
      country: 'US'
    }
  }
});
```

**输出**

1. name - John Doe
2. age - 25
3. city - New York
4. country - US


### 5、vue开发遇到的问题？

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



### 6、axios是什么？怎么使用？描述使用它实现登录功能的流程？

请求后台资源的模块。npm install axios -S装好，然后发送的是跨域，需在配置文件中config/index.js进行设置。后台如果是Tp5则定义一个资源路由。js中使用import进来，然后.get或.post。返回在.then函数中如果成功，失败则是在.catch函数中


### 7、mvvm 框架是什么？

vue是实现了双向数据绑定的mvvm框架，当视图改变更新模型层，当模型层改变更新视图层。在vue中，使用了双向绑定技术，就是View的变化能实时让Model发生变化，而Model的变化也能实时更新到View。


### 8、vue父组件向子组件传递数据？

通过props


### 9、keep-alive了解吗

`keep-alive`可以实现组件缓存，当组件切换时不会对当前组件进行卸载。

常用的两个属性`include/exclude`，允许组件有条件的进行缓存。

两个生命周期`activated/deactivated`，用来得知当前组件是否处于活跃状态。

keep-alive的中还运用了`LRU(Least Recently Used)`算法。

（又是数据结构与算法，原来算法在前端也有这么多的应用）


### 10、vue优点？

**1、** 轻量级框架：只关注视图层，是一个构建数据的视图集合，大小只有几十kb；

**2、** 简单易学：国人开发，中文文档，不存在语言障碍 ，易于理解和学习；

**3、** 双向数据绑定：保留了angular的特点，在数据操作方面更为简单；

**4、** 组件化：保留了react的优点，实现了html的封装和重用，在构建单页面应用方面有着独特的优势；

**5、** 视图，数据，结构分离：使数据的更改更为简单，不需要进行逻辑代码的修改，只需要操作数据就能完成相关操作；

**6、** 虚拟DOM：dom操作是非常耗费性能的， 不再使用原生的dom操作节点，极大解放dom操作，但具体操作的还是dom不过是换了另一种方式；

**7、** 运行速度更快:相比较与react而言，同样是操作虚拟dom，就性能而言，vue存在很大的优势。


### 11、如何让CSS只在当前组件中起作用？
### 12、vue组件的通信（父子组件和非父子组件）？
### 13、说出至少4种vue当中的指令和它的用法？
### 14、是否可以在JS中执行301重定向？
### 15、子组件更新过程
### 16、vue的filter的理解与用法？
### 17、用纯JS编写一个程序来反转字符串
### 18、v-show 指令的用途是什么？
### 19、如何获取dom?
### 20、vue-roter的钩子函数？
### 21、vue与angular的区别?
### 22、说一下Vue的生命周期
### 23、vue生命周期的作用是什么？
### 24、Vue.js 中的指令是什么？
### 25、请说出vue.cli项目中src目录每个文件夹和文件的用法？
### 26、对于作为元素实现的注释框，我们希望使用户能够按下键盘上的Enter键，来将内容提交给名为 “storeComment” 的方法。在代码中对此进行演示。
### 27、父组件更新过程




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
