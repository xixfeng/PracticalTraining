# TTBS

> 火车票订票系统前端

## 快速上手
>大家按照以下的步骤上手项目

``` bash
以下的步骤均在命令行中完成 建议使用jetbrains公司的webstorm
# 安装npm依赖
npm install

# 将项目实时运行在localhost8080
此时项目是热加载的，对于代码的更改可以实时的反应到浏览器端
npm run dev

# 项目打包，生成的文件会保存在dist文件夹下
clone下来的时候这个文件夹暂时没有，运行完下述代码之后会生成
npm run build


```

##增加页面的步骤
>1 在src/pages文件夹下新建一个文件夹名，为新建的页面名

>2 将之前任意一个页面文件夹下的所有内容复制进来，然后进行修改

>3 修改与App.vue同一级的html和js文件，名称与当前页面统一，并且修改router文件夹下的js文件，与页面名称统一，最后更改router文件夹下js文件
将其清空为如下：
```bash
import Vue from 'vue'
import Router from 'vue-router'


Vue.use(Router)

export default new Router({
  routes: [
    {
      
    }
  ]
})

```

详情点击-> [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).
