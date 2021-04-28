# Vue最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、路由跳转和location.href的区别？

使用location.href='/url'来跳转，简单方便，但是刷新了页面；

使用路由方式跳转，无刷新页面，静态跳转；


### 2、说说你对angular脏检查理解？

在angular中你无法判断你的数据是否做了更改，所以它设置了一些条件，当你触发这些条件之后,它就执行一个检测来遍历所有的数据，对比你更改的地方，然后执行变化。

这个检查很不科学。而且效率不高，有很多多余的地方，所以官方称为 脏检查。


### 3、数组去重复的方法有哪些

1.使用 set

```
function uniquearray(array) {
 let unique_array= Array.from(set(array))
 return unique_array;
}
```

2.使用 filter

```
function unque_array (arr) {
  let unique_array = arr.filter(function(elem, index, self) {
    return index == self.indexOf(elem);
  })
  return unique_array;
}

 console.log(unique_array(array_with_duplicates));
```

3.使用 for 循环

```
Array dups_names = ['Ron', 'Pal', 'Fred', 'Rongo', 'Ron'];
function dups_array(dups_names) {
 let unique = {};
 names.forEach(function(i) {
    If (!unique[i]) {
      unique[i] = true;    }
  });
return Object.keys(unique);}   // Ron, Pal, Fred, Rongo
Dups_array(names);
```


### 4、vue-router有哪几种导航钩子？

**三种**

**1、** 第一种：是全局导航钩子：router.beforeEach(to,from,next)，作用：跳转前进行判断拦截。

**2、** 第二种：组件内的钩子

**3、** 第三种：单独路由独享组件


### 5、v-on可以监听多个方法吗？

可以，栗子：。


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


### 7、什么是过滤器？

过滤器是在 Vue 程序中实现自定义文本格式的一种非常简单的方法。它们就像可以在表达式中通过管道传递（使用管道字符）以取得结果的运算符。下面是一个可以反转文本字符串的过滤器示例：

**模板**

```
<div id="app">{{ title | reverseText }}</div>
App
new Vue({
    el: '#app',
    data: {
      title: 'This is a title'
    },
    filters: {
      reverseText(text) {
        return text.split('').reverse().join('');
      }
    }
});
```

**输出**

eltit a si sihT

在上面的例子中，我们创建了一个名为 reverseText 的过滤器，该过滤器反转文本字符串并返回。这是一个简单的函数，接受输入并返回处理后的输出。通过在过滤器下声明，它就可以成为可以在模板中使用的过滤器。

在模板中，我们只是将 reverseText 过滤器通过管道传递到了想要在 mustache 标签中显示的数据变量。这样可以将多个过滤器管道连接在一起。因此过滤器提供了一种非常优雅的方式来处理文本。


### 8、如何在JS中动态添加/删除对象的属性？

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


### 9、JS中如何将页面重定向到另一个页面？

使用 location.href：window.location.href

=“https://www.onlineinterviewquestions.com/” 使用 location.replace： window.location.replace(" [https://www.onlineinterviewquestions.com/;](https://www.onlineinterviewquestions.com/;)");


### 10、vue-router 有哪几种导航钩子?

三种

**1、** 是全局导航钩子：router.beforeEach(to,from,next)，作用：跳转前进行判断拦截。

**2、** 组件内的钩子

**3、** 单独路由独享组件


### 11、给出模板，描述 Vue 程序的输出。
### 12、vue首屏白屏如何解决？
### 13、如何动态地在元素上切换 CSS 类？
### 14、简述一下Sass、Less，且说明区别？
### 15、vue的diff算法理解？
### 16、使用 Vue 时调用 event.preventDefault() 的最佳方式是什么？
### 17、axios的特点有哪些
### 18、什么是插槽（slot）？
### 19、的作用是什么?
### 20、vue常用的修饰符
### 21、v-model是什么？怎么使用？ vue中标签怎么绑定事件？
### 22、第一次页面加载会触发哪几个钩子？
### 23、computed和watch的用法和区别？
### 24、再说一下虚拟Dom以及key属性的作用
### 25、vue常用的UI组件库
### 26、$$emit 、$$on 、$$once 、$$off理解？
### 27、Vue.js中ajax请求代码应该写在组件的methods中还是vuex的actions中？
### 28、vue的两个核心点




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
