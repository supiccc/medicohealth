import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import NProgress from 'nprogress'
import axios from 'axios'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/font-awesome-4.7.0/css/font-awesome.min.css'
import './assets/css/main.css'
import './assets/css/scrollbar.css'
import './assets/css/reset.css'
import 'nprogress/nprogress.css'
import 'animate.css'

Vue.use(ElementUI)

//将axios挂载在Vue原型链上，在其他组件中可以直接调用this.$axios
Vue.prototype.$axios = axios

Vue.config.productionTip = false

var whiteList = ['login', 'home', 'about']
router.beforeEach((to, from, next) => {
  /* 路由发生变化修改页面title */
  if (to.meta.title) {
    document.title = to.meta.title;
  }
  NProgress.start()
  var token = sessionStorage.getItem('token')
  console.log(token)
  if (!token && whiteList.indexOf(to.name) === -1) {
    // app && app.$message.warning('未授权，请登陆授权后继续')
    // Vue.$message.warning('')
    // return next({name: 'login'})
    return router.push({name: 'login', params: { message: '未授权，请登陆授权后继续' }})
  }
  return next()
})

router.afterEach(transition => {
  setTimeout(() => {
    NProgress.done()
  })
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
