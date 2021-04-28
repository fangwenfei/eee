# Vue最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、vue获取数据在哪个周期函数

一般 created/beforeMount/mounted 皆可.

比如如果你要操作 DOM , 那肯定 mounted 时候才能操作.


### 2、说一下v-model的原理

`v-model`本质就是一个语法糖，可以看成是`value + input`方法的语法糖。 可以通过model属性的`prop`和`event`属性来进行自定义。原生的v-model，会根据标签的不同生成不同的事件和属性。


### 3、列出JS中的一些设计模式:

设计模式是软件设计中常见问题的通用可重用解决方案，以下是一些设计模式是： 创建模式：该模式抽象了对象实例化过程。

结构型模式：这些模式处理不同的类和对象以提供新功能。

行为模式：也称发布-订阅模式，定义了一个被观察者和多个观察者的、一对多的对象关系。

并行设计模式：这些模式处理多线程编程范例。 架构设计模式：这些模式用于处理架构设计


### 4、vuex有哪几种属性？

有五种，分别是 State、 Getter、Mutation 、Action、 Module

**1、** state => 基本数据(数据源存放地)

**2、** getters => 从基本数据派生出来的数据

**3、** mutations => 提交更改数据的方法，同步！

**4、** actions => 像一个装饰器，包裹mutations，使之可以异步。

**5、** modules => 模块化Vuex


### 5、什么是观察者？

观察者允许我们观察更改的特定属性，并执行定义为函数的自定义操作。尽管它们的用例与计算的属性相交叉，但是当某些数据属性发生改变时，有时需要观察者执行自定义操作或运行代价昂贵的操作。


### 6、vue更新数组时触发视图更新的方法？

push()；pop()；shift()；unshift()；splice()；sort()；reverse()


### 7、如何将数据从父组件传递到子组件？

可以用作为组件中单向入口的 prop 把数据向下传递到子组件。这是一个例子：

```
<template>
    <div>
      <contact-list-item v-for=”contact in contacts” :contact=”contact” />
   </div>
</template>
<script>
    import ContactListItem from ‘./ContactListItem’;
    export default {
name: ‘address-book’,
data: function() {
return {
contacts: [.....]
}
},
components: {
ContactListItem
}
}
</script>
```

`contact-list-item` 上绑定的 prop “contact” 是一个入口，用于从用作子项的父组件接收数据。在 `contact-list-item` 组件中：

```
<template>
    <div>
        <span>{{ contact.name }}</span>
        <span>{{ contact.email }}</span>
   </div>
</template>

<script>
    export default {
     name: ‘contact-list-item’,
props: [‘contact’]
    }
</script>
```

在这里声明了一个名为 “contact” 的 prop 引入数据，然后可以直接在模板部分中显示。


### 8、vue父组件向子组件传递数据？

通过props


### 9、聊聊你对Vue.js的template编译的理解？

简而言之，就是先转化成AST树，再得到的render函数返回VNode（Vue的虚拟DOM节点）

**详情步骤：**

**1、** 首先，通过compile编译器把template编译成AST语法树（abstract syntax tree 即 源代码的抽象语法结构的树状表现形式），compile是createCompiler的返回值，createCompiler是用以创建编译器的。另外compile还负责合并option。

**2、** 然后，AST会经过generate（将AST语法树转化成render funtion字符串的过程）得到render函数，render的返回值是VNode，VNode是Vue的虚拟DOM节点，里面有（标签名、子节点、文本等等）


### 10、如何在输入框和数据属性之间实现双向数据绑定？

要实现双向数据绑定，可以使用 v-model 指令。 v-model 指令主要是语法糖：

```
<input type="text" :value="nameInput" @keyup="nameInput = $event.target.value">
```

在上面的语句中，每当观察到 “keyup” 事件时，就会将名为 “nameInput” 的数据属性设置为输入框的值。同时，将输入框的 value 属性绑定到 “nameInput” 数据属性。这样在表单字段和数据属性之间建立了双向数据关系。

v-model 可以做到这一点，并且比手动设置更有效地。要使用 v-model 复制上述效果，请再次在同一输入框中输入以下内容：

```
<input type="text" v-model="nameInput">
```

需要注意的是，当实现双向数据绑定时，使用的数据属性被认为是事实上的来源。在 data 属性上所做的任何更改都将优先于 form 字段上的用户输入事件。


### 11、什么是组件？
### 12、第一次页面加载会触发哪几个钩子？
### 13、v-if和v-show的区别？
### 14、解释JS中的MUL函数
### 15、使用 Vue 时调用 event.preventDefault() 的最佳方式是什么？
### 16、vue修改打包后静态资源路径的修改
### 17、请说下封装 vue 组件的过程？
### 18、父组件更新过程
### 19、简述每个周期具体适合哪些场景
### 20、JS中let和const有什么用？
### 21、说说你对angular脏检查理解？
### 22、vue中transition的理解？
### 23、引进组件的步骤
### 24、vue的实现原理？
### 25、什么是插槽（slot）？
### 26、说一下Vue的生命周期
### 27、v-on可以监听多个方法吗？
### 28、说一下v-if和v-show的区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
