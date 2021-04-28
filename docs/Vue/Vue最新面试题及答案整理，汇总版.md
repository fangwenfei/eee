# Vue最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是vue生命周期？

Vue 实例从创建到销毁的过程，就是生命周期。也就是从开始创建、初始化数据、编译模板、挂载Dom→渲染、更新→渲染、卸载等一系列过程，我们称这是 Vue 的生命周期。


### 2、Vue2.x和Vue3.x渲染器的diff算法分别说一下

简单来说，diff算法有以下过程

**1、** 同级比较，再比较子节点

**2、** 先判断一方有子节点一方没有子节点的情况(如果新的children没有子节点，将旧的子节点移除)

**3、** 比较都有子节点的情况(核心diff)

**4、** 递归比较子节点

正常Diff两个树的时间复杂度是`O(n^3)`，但实际情况下我们很少会进行`跨层级的移动DOM`，所以Vue将Diff进行了优化，从`O(n^3) -> O(n)`，只有当新旧children都为多个子节点时才需要用核心的Diff算法进行同层级比较。

Vue2的核心Diff算法采用了`双端比较`的算法，同时从新旧children的两端开始进行比较，借助key值找到可复用的节点，再进行相关操作。相比React的Diff算法，同样情况下可以减少移动节点次数，减少不必要的性能损耗，更加的优雅。

Vue3.x借鉴了 [ivi](https://github.com/localvoid/ivi)算法和 [inferno](https://github.com/infernojs/inferno)算法

在创建VNode时就确定其类型，以及在`mount/patch`的过程中采用`位运算`来判断一个VNode的类型，在这个基础之上再配合核心的Diff算法，使得性能上较Vue2.x有了提升。(实际的实现可以结合Vue3.x源码看。)

该算法中还运用了`动态规划`的思想求解最长递归子序列。

(看到这你还会发现，框架内无处不蕴藏着数据结构和算法的魅力)


### 3、给出模板，描述 Vue 程序的输出。

模板：

```
{{title}}
```

App:

```
new Vue({
    el: '#app',
    data: {
        title: 'Vue.js'
    }
})
```

上面的代码将在 div 中输出字符串 `<h1 style="color: green;">Vue.js</h1>`。之所以将整个标签渲染为字符串，是因为 mustache 模板标签 `{{title}}`将传入的数据视为字符串，而不将其解析为可执行代码。这也有助于缓解把恶意代码注入到页面的 XSS 相关的问题 。这类似于在 JavaScript 中使用 `elementSelector.innerText = text` 语句。


### 4、再说一下vue2.x中如何监测数组变化

使用了函数劫持的方式，重写了数组的方法，Vue将data中的数组进行了原型链重写，指向了自己定义的数组原型方法。这样当调用数组api时，可以通知依赖更新。如果数组中包含着引用类型，会对数组中的引用类型再次递归遍历进行监控。这样就实现了监测数组变化。

（能问到这的面试官都比较注重深度，这些常规操作要记牢）


### 5、请详细说下你对vue生命周期的理解？

总共分为8个阶段创建前/后，载入前/后，更新前/后，销毁前/后。

**1、** 创建前/后： 在beforeCreated阶段，vue实例的挂载元素$$el和数据对象data都为undefined，还未初始化。在created阶段，vue实例的数据对象data有了，$$el还没有。

**2、** 载入前/后：在beforeMount阶段，vue实例的$el和data都初始化了，但还是挂载之前为虚拟的dom节点，data.message还未替换。在mounted阶段，vue实例挂载完成，data.message成功渲染。

**3、** 更新前/后：当data变化时，会触发beforeUpdate和updated方法。

**4、** 销毁前/后：在执行destroy方法后，对data的改变不会再触发周期函数，说明此时vue实例已经解除了事件监听以及和dom的绑定，但是dom结构依然存在。


### 6、说出几种vue当中的指令和它的用法？

v-model双向数据绑定；

v-for循环；

v-if v-show 显示与隐藏；

v-on事件；v-once: 只绑定一次。


### 7、解释一下什么是 promise ？

promise是js中的一个对象，用于生成可能在将来产生结果的值。 值可以是已解析的值，也可以是说明为什么未解析该值的原因。

promise 可以有三种状态:

**1、** pending：初始状态，既不是成功也不是失败

**2、** fulfilled：意味着操作完全成功

**3、** rejected：意味着操作失败

一个等待状态的promise对象能够成功后返回一个值，也能失败后带回一个错误 当这两种情况发生的时候，处理函数会排队执行通过then方法会被调用。


### 8、computed和watch的用法和区别？

**computed**

**1、** 变量不在 data中定义，而是定义在computed中，写法跟写方法一样，有返回值。函数名直接在页面模板中渲染，不加小括号 。

**2、** 根据传入的变量的变化 进行结果的更新。

**3、** 计算属性基于响应式依赖进行缓存。如其中的任意一个值未发生变化，它调用的就是上一次计算缓存的数据，因此提高了程序的性能。而methods中每调用一次就会重新计算一次，为了进行不必要的资源消耗，选择用计算属性。

**watch**

计算属性的时候 初始化的时候就可以被监听到并且计算 但是watch是发生改变的时候才会触发。

当有一些数据需要随着其它数据变动而变动时，或者当需要在数据变化时执行异步或开销较大的操作时，使用 watch。

**总结：**

**1、** 计算属性变量在computed中定义，属性监听在data中定义。

**2、** 计算属性是声明式的描述一个值依赖了其他值，依赖的值改变后重新计算结果更新DOM。属性监听的是定义的变量，当定义的值发生变化时，执行相对应的函数。


### 9、如何在JS中动态添加/删除对象的属性？

咱们可以使用object.property_name = value向对象添加属性，delete object.property_name 用于删除属性。 例如：

```
let user = new Object();
// adding a property
user.name='Anil';
user.age  =25;
console.log(user);
delete user.age;
console.log(user);
```


### 10、vue更新数组时触发视图更新的方法

答:push()；pop()；shift()；unshift()；splice()； sort()；reverse()


### 11、简单说一下Vue2.x响应式数据原理
### 12、解释 JS 事件委托模型？
### 13、Vue模版编译原理知道吗，能简单说一下吗？
### 14、route和router的区别？
### 15、v-show和v-if指令的共同点和不同点？
### 16、请讲述下VUE的MVVM的理解？
### 17、active-class是哪个组件的属性？
### 18、JS的作用域链是什么及其作用
### 19、请详细说下你对vue生命周期的理解？
### 20、DOM 渲染在 哪个周期中就已经完成？
### 21、vue与react、angular的比较？
### 22、的作用是什么?
### 23、Vue2.x组件通信有哪些方式？
### 24、nextTick知道吗，实现原理是什么？
### 25、vue常用的修饰符
### 26、vue的两个核心点
### 27、vue的历史记录




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
