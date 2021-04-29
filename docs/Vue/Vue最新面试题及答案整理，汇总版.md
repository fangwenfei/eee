# Vue最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、说出几种vue当中的指令和它的用法？

v-model双向数据绑定；

v-for循环；

v-if v-show 显示与隐藏；

v-on事件；v-once: 只绑定一次。


### 2、渐进式框架的理解

主张最少；可以根据不同的需求选择不同的层级；


### 3、是否可以在JS中执行301重定向？

JS完全运行在客户端上。301是服务器作为响应发送的响应代码。因此，在JS中不可能执行301重定向。


### 4、vue开发遇到的问题？

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



### 5、说一下v-model的原理

`v-model`本质就是一个语法糖，可以看成是`value + input`方法的语法糖。 可以通过model属性的`prop`和`event`属性来进行自定义。原生的v-model，会根据标签的不同生成不同的事件和属性。


### 6、那你知道Vue3.x响应式数据原理吗？

(还好我有看，这个难不倒我)

Vue3.x改用`Proxy`替代Object.defineProperty。因为Proxy可以直接监听对象和数组的变化，并且有多达13种拦截方法。并且作为新标准将受到浏览器厂商重点持续的性能优化。

**Proxy只会代理对象的第一层，那么Vue3又是怎样处理这个问题的呢？**

（很简单啊）

判断当前Reflect.get的返回值是否为Object，如果是则再通过`reactive`方法做代理， 这样就实现了深度观测。

**监测数组的时候可能触发多次get/set，那么如何防止触发多次呢？**

我们可以判断key是否为当前被代理对象target自身属性，也可以判断旧值与新值是否相等，只有满足以上两个条件之一时，才有可能执行trigger。

面试官抬起了头。心里暗想

(这小子还行，比上两个强，应该是多多少少看过Vue3的源码了)


### 7、vuex的使用？

Vuex 是一个专为 Vue.js 应用程序开发的状态管理模式。它采用集中式存储管理应用的所有组件的状态，并以相应的规则保证状态以一种可预测的方式发生变化，具体包括：

**1、** state：Vuex 使用单一状态树,即每个应用将仅仅包含一个store 实例，但单一状态树和模块化并不冲突。存放的数据状态，不可以直接修改里面的数据。

**2、** getter：state的计算属性，类似vue的计算属性，主要用来过滤一些数据。

**3、** action：actions可以理解为通过将mutations里面处里数据的方法变成可异步的处理数据的方法，简单的说就是异步操作数据。view 层通过 store.dispath 来分发 action。可以异步函数调用

**4、** mutation：mutations定义的方法动态修改Vuex 的 store 中的状态或数据

**5、** modules：项目特别复杂的时候，可以让每一个模块拥有自己的state、mutation、action、getters,使得结构非常清晰，方便管理。


### 8、再说一下Computed和Watch

`Computed`本质是一个具备缓存的watcher，依赖的属性发生变化就会更新视图。 适用于计算比较消耗性能的计算场景。当表达式过于复杂时，在模板中放入过多逻辑会让模板难以维护，可以将复杂的逻辑放入计算属性中处理。

`Watch`没有缓存性，更多的是观察的作用，可以监听某些数据执行回调。当我们需要深度监听对象中的属性时，可以打开`deep：true`选项，这样便会对对象中的每一项进行监听。这样会带来性能问题，优化的话可以使用`字符串形式`监听，如果没有写到组件中，不要忘记使用`unWatch手动注销`哦。


### 9、import 和 exports 是什么？

import和exports 帮助咱们编写模块化的JS代码。使用import和exports，咱们可以将代码分割成多个文件。import只允许获取文件的某些特定变量或方法。可以导入模块导出的方法或变量。

```
 //index.js

 import name,age from './person';

 console.log(name);
 console.log(age);

 //person.js

 let name ='Sharad', occupation='developer', age =26;

 export { name, age};
```


### 10、解释JS中的事件冒泡和事件捕获

**事件捕获和冒泡:** 在HTML DOM API中，有两种事件传播方法，它们决定了接收事件的顺序。两种方法是事件冒泡和事件捕获。第一个方法事件冒泡将事件指向其预期的目标，第二个方法称为事件捕获，其中事件向下到达元素。

**事件捕获**

捕获过程很少被使用，但是当它被使用时，它被证明是非常有用的。这个过程也称为滴流模式。在这个过程中，事件首先由最外层的元素捕获，然后传播到最内部的元素。例如:

```
<div>
  <ul>
    <li></li>
  </ul>
</div>
```

从上面的示例中，假设单击事件发生在li元素中，在这种情况下，捕获事件将首先处理div，然后处理ul，最后命中目标元素li。

**事件冒泡**

冒泡的工作原理与冒泡类似，事件由最内部的元素处理，然后传播到外部元素。

```
<div>
  <ul>
    <li></li>
  </ul>
</div>
```

从上面的例子中，假设click事件确实发生在冒泡模型中的li元素中，该事件将首先由li处理，然后由ul处理，最后由div元素处理。


### 11、$$root、$$refs、$parent的使用？
### 12、单页面应用和多页面应用区别及优缺点
### 13、如何从子组件发出自定义事件？
### 14、分别简述computed和watch的使用场景
### 15、简单说一下Vue2.x响应式数据原理
### 16、说说你对angular脏检查理解？
### 17、你如何捕获元素上的点击事件？
### 18、说一下Vue的生命周期
### 19、v-for中的key的理解？
### 20、JS中的substr()和substring()函数有什么区别
### 21、vue.cli中怎样使用自定义的组件？有遇到过哪些问题吗？
### 22、解释一下JS的展开操作符？
### 23、Vue.js 中的指令是什么？
### 24、JS中的宿主对象与原生对象有何不同？
### 25、undefined，null 和 undeclared 有什么区别？
### 26、Vue.js 中的声明式渲染是什么？
### 27、请说下封装 vue 组件的过程？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
