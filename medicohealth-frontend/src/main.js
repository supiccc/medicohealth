import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import NProgress from 'nprogress'
import axios from 'axios'
import 'babel-polyfill'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/font-awesome-4.7.0/css/font-awesome.min.css'
import './assets/css/main.css'
import './assets/css/scrollbar.css'
import './assets/css/reset.css'
import 'nprogress/nprogress.css'
import 'animate.css'

import DropdownPlugin from './m/dropdown'
import NavbarPlugin from './m/navbar'
import ContextMenuPlugin from './m/context-menu'
import MButton from '@/m/button'
import MSwitch from '@/m/switch'
import MAlert from '@/m/alert'
import MCheckbox from '@/m/checkbox'
import MInput from '@/m/input'
import MLoading from '@/m/loading'
import Mkeyboard from '@/m/keyboard'
import MNumberkeyboard from '@/m/number-keyboard'
import MBox from '@/m/box'
import MBackTop from '@/m/back-top'
import MLoader from '@/m/loader'
import MContainer from '@/m/container'

Vue.use(ElementUI)
Vue.use(DropdownPlugin)
Vue.use(NavbarPlugin)
Vue.use(ContextMenuPlugin)
Vue.use(MButton)
Vue.use(MSwitch)
Vue.use(MAlert)
Vue.use(MCheckbox)
Vue.use(MInput)
Vue.use(MLoading)
Vue.use(Mkeyboard)
Vue.use(MNumberkeyboard)
Vue.use(MBox)
Vue.use(MBackTop)
Vue.use(MLoader)
Vue.use(MContainer)

//将axios POST方法默认头部Content-Type修改，后端才能读取到信息
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
//将axios挂载在Vue原型链上，在其他组件中可以直接调用this.$axios
Vue.prototype.$axios = axios
// 设置请求token
axios.interceptors.request.use(config => {
  var token = sessionStorage.getItem('token')
  config.headers['token'] = token
  // console.log(config)
  return config
})

Vue.config.productionTip = false

var whiteList = ['login', 'about']
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
