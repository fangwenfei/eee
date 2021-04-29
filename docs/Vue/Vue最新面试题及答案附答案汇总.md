# Vue最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、对于作为元素实现的注释框，我们希望使用户能够按下键盘上的Enter键，来将内容提交给名为 “storeComment” 的方法。在代码中对此进行演示。

可以在任何元素上使用 v-on 指令来实现事件侦听器。此外，v-on 还允许我们将按键修饰符用于 “enter”，“tab”，“esc”，“space” 等常见按键。这是一个例子：

**模板**

```
<textarea @keyup.enter="storeComment"></textarea>
```

**App**

```
new Vue({
  el: '#app',
  methods: {
    storeComment(event) {
      // access the value of the textarea box using event.target.value or use v-model to bind to a data property
    }
  }
});
```


### 2、第一次页面加载会触发哪几个钩子？

第一次页面加载时会触发 beforeCreate, created, beforeMount, mounted 这几个钩子


### 3、vue-router 有哪几种导航钩子?

三种

**1、** 是全局导航钩子：router.beforeEach(to,from,next)，作用：跳转前进行判断拦截。

**2、** 组件内的钩子

**3、** 单独路由独享组件


### 4、$nextTick的使用？

在vue中理解修改数据后，对应的dom需要一定的时间进行更新，因此为了能够准确的后去更新后的dom，可以采用延迟回调的方法进行更新dom的获取，所以出现了$nextTick来进行延迟回调。即：在下次 DOM 更新循环结束之后执行延迟回调。在修改数据之后立即使用这个方法，获取更新后的 DOM。


### 5、$$root、$$refs、$parent的使用？

**$root**

可以用来获取vue的根实例，比如在简单的项目中将公共数据放再vue根实例上(可以理解为一个全局 store ),因此可以代替vuex实现状态管理；

**$refs**

在子组件上使用ref特性后，this.属性可以直接访问该子组件。可以代替事件emit 和$on 的作用。

使用方式是通过ref特性为这个子组件赋予一个ID引用，再通过this.$refs.testId获取指定元素。

注意：$$refs只会在组件渲染完成之后生效，并且它们不是响应式的。这仅作为一个用于直接操作子组件的“逃生舱”——你应该避免在模板或计算属性中访问$$refs。

**$parent**

$parent属性可以用来从一个子组件访问父组件的实例，可以替代将数据以 prop 的方式传入子组件的方式；当变更父级组件的数据的时候，容易造成调试和理解难度增加；


### 6、什么是 vue 生命周期？有什么作用？

每个 Vue 实例在被创建时都要经过一系列的初始化过程——例如，需要设置数据监听、编译模板、将实例挂载到 DOM 并在数据变化时更新 DOM 等。同时在这个过程中也会运行一些叫做 生命周期钩子 的函数，这给了用户在不同阶段添加自己的代码的机会。（ps：生命周期钩子就是生命周期函数）例如，如果要通过某些插件操作DOM节点，如想在页面渲染完后弹出广告窗， 那我们最早可在mounted 中进行。


### 7、解释JS中的事件冒泡和事件捕获

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


### 8、$$emit 、$$on 、$$once 、$$off理解？
### 9、如何获取dom?
### 10、什么是组件？
### 11、那你知道Vue3.x响应式数据原理吗？
### 12、如何在现有函数中添加新属性
### 13、keep-alive了解吗
### 14、v-if和v-for的优先级
### 15、vue初始化页面闪动问题
### 16、vuex的使用？
### 17、如何将文件的所有导出作为一个对象？
### 18、undefined，null 和 undeclared 有什么区别？
### 19、BOM 和 DOM 的关系
### 20、自定义指令（v-check、v-focus）的方法有哪些？它有哪些钩子函数？还有哪些钩子函数参数？
### 21、加载渲染过程
### 22、如何在JS中克隆对象
### 23、computed和watch的用法和区别？
### 24、v-if和v-show的区别？
### 25、axios是什么？怎么使用？描述使用它实现登录功能的流程？
### 26、vuex是什么？怎么使用？哪种功能场景使用它？
### 27、v-model的理解？
### 28、第一次页面加载会触发哪几个钩子？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
