# JavaScript最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Gc机制是什么？为什么闭包不会被回收变量和函数？

**1、** Gc垃圾回收机制;

**2、** 外部变量没释放，所以指向的大函数内的小函数也释放不了


### 2、null，undefined 的区别？

**1、** `undefined` 表示不存在这个值。

**2、** `undefined` :是一个表示"无"的原始值或者说表示"缺少值"，就是此处应该有一个值，但是还没有定义。当尝试读取时会返回 `undefined`

**3、** 例如变量被声明了，但没有赋值时，就等于`undefined`

**4、** `null` 表示一个对象被定义了，值为“空值”

**5、** `null` : 是一个对象(空对象, 没有任何属性和方法)

**6、** 例如作为函数的参数，表示该函数的参数不是对象；

**7、** 在验证`null`时，一定要使用　`===` ，因为 `==`无法分别`null` 和　`undefined`


### 3、什么是提升？

**提升**是用来描述变量和函数移动到其(全局或函数)作用域顶部的术语。

为了理解提升，需要来了解一下**执行上下文**。**执行上下文**是当前正在执行的**“代码环境”**。执行上下文有两个阶段:`编译`和`执行`。

**编译**-在此阶段，JS 引荐获取所有**函数声明**并将其**提升**到其作用域的顶部，以便我们稍后可以引用它们并获取所有变量声明（使用`var`关键字进行声明），还会为它们提供默认值：`undefined`。

**执行**——在这个阶段中，它将值赋给之前提升的变量，并执行或调用函数(对象中的方法)。

**注意:** 只有使用`var`声明的变量，或者函数声明才会被提升，相反，函数表达式或箭头函数，`let`和`const`声明的变量，这些都不会被提升。

假设在全局使用域，有如下的代码：

```
console.log(y);
y = 1;
console.log(y);
console.log(greet("Mark"));

function greet(name){
  return 'Hello ' + name + '!';
}

var y;
```

上面分别打印：`undefined`,`1`, `Hello Mark!`。

上面代码在编译阶段其实是这样的：

```
function greet(name) {
  return 'Hello ' + name + '!';
}

var y; // 默认值 undefined

// 等待“编译”阶段完成，然后开始“执行”阶段

/*
console.log(y);
y = 1;
console.log(y);
console.log(greet("Mark"));
*/
```

编译阶段完成后，它将启动执行阶段调用方法，并将值分配给变量。

```
function greet(name) {
  return 'Hello ' + name + '!';
}

var y;

//start "execution" phase

console.log(y);
y = 1;
console.log(y);
console.log(greet("Mark"));
```


### 4、bootstrap好处？

自适应和响应式布局，12栅格系统，统一的界面风格和css样式有利于团队开发。编写灵活、稳定、高质量的 HTML 和 CSS 代码的规范。


### 5、$$.map和$$.each有什么区别###

map()方法主要用来遍历操作数组和对象，会返回一个新的数组。$.map()方法适用于将数组或对象每个项目新阵列映射到一个新数组的函数；

each()主要用于遍历jquery对象，返回的是原来的数组，并不会新创建一个数组。


### 6、js延迟加载的方式有哪些？

`defer`和`async`、动态创建`DOM`方式（用得最多）、按需异步载入`js`


### 7、介绍js有哪些内置对象？

**1、** `Object` 是 `JavaScript` 中所有对象的父对象

**2、** 数据封装类对象：`Object`、`Array`、`Boolean`、`Number` 和 `String`

**3、** 其他对象：`Function`、`Arguments`、`Math`、`Date`、`RegExp`、`Error`


### 8、如何检查值是否虚值？

使用 `Boolean` 函数或者 `!!` 运算符。


### 9、什么是模板字符串？

模板字符串是在 JS 中创建字符串的一种新方法。我们可以通过使用反引号使模板字符串化。

```
//ES5 Version
var greet = 'Hi I\'m Mark';

//ES6 Version
let greet = `Hi I'm Mark`;
```

在 ES5 中我们需要使用一些转义字符来达到多行的效果，在模板字符串不需要这么麻烦：

```
//ES5 Version
var lastWords = '\n'
  + '   I  \n'
  + '   Am  \n'
  + 'Iron Man \n';

//ES6 Version
let lastWords = `
    I
    Am
  Iron Man   
`;
```

在ES5版本中，我们需要添加`\n`以在字符串中添加新行。在模板字符串中，我们不需要这样做。

```
//ES5 Version
function greet(name) {
  return 'Hello ' + name + '!';
}

//ES6 Version
function greet(name) {
  return `Hello ${name} !`;
}
```

在 ES5 版本中，如果需要在字符串中添加表达式或值，则需要使用`+`运算符。在模板字符串s中，我们可以使用`${expr}`嵌入一个表达式，这使其比 ES5 版本更整洁。


### 10、编写一个 getElementsByClassName 封装函数?

```
<body  
<input type="submit" id = "sub" class="ss confirm btn" value="提交"/  
<scriptwindow.onload = function(){ 
//方法一         
    var Opt = document.getElementById('sub');
    var getClass = function(className,tagName){
        if(document.getElementsByTagName){
            var Inp = document.getElementsByTagName(tagName);
            for(var i=0; i<Inp.length; i++){
                if((new RegExp('(\\s|^)' +className +'(\\s|$)')).test(Inp[i].className)){
                      return Inp[i];
                    }
                }
            }else if(document.getElementsByClassName){
                return document.getElementsByClassName(className);
        }
    }                 
//方法二
    var aa = getClass("confirm", "input");
        function getClass(className, targetName){
            var ele = [];
            var all = document.getElementsByTagName(targetName || "*");
            for(var i=0; i<all.length; i++){
                if(all[i].className.match(new RegExp('(\\s|^)'+confirm+'(\\s|$)'))){    
                    ele[ele.length] = all[i];
                }
            }
            return ele;
        }
//方法三
    function getObjsByClass(tagName, className){
           if(document.getElementsByClassName){
               alert("document.getElementsByClassName");
               return document.getElementsByClassName(className);
           }else{
               var el = [];
               var _el = document.getElementsByTagName(tagName);
               for(var i=0; i<_el.length; i++){
                   if(_el[i].className.indexOf(className) -1){
                       alert(_el[i]);
                       el[_el.length] = _el[i];
                   }
               }
               alert(el);
               return el;
           }
       }
   }
 </script>
</body>
```


### 11、手动实现`Array.prototype.filter`方法
### 12、`Function.prototype.call` 方法的用途是什么？
### 13、什么是 event.currentTarget？？
### 14、如何改变this指针的指向？
### 15、什么是作用域和作用域链？
### 16、为什么函数被称为一等公民？
### 17、什么是预编译语音|预编译处理器?
### 18、this是什么 在不同场景中分别代表什么###
### 19、**
### 20、window.onload ==? DOMContentLoaded ?
### 21、undefined 和 null 有什么区别？
### 22、什么是构造函数？与普通函数有什么区别?
### 23、什么是作用域？
### 24、数组的排序方法（sort）？排序？汉字排序？
### 25、声明函数作用提升?声明变量和声明函数的提升有什么区别
### 26、异步编程？
### 27、readystate 0~4
### 28、Jq中有几种选择器?分别是什么?
### 29、什么是事件冒泡？
### 30、为什么此代码 `obj.someprop.x` 会引发错误?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
