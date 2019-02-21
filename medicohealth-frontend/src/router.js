import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '',
      component: () => import('./views/AppView.vue'),
      children: [
        {
          path: '/', 
          name:'home', 
          meta: {
            title: '首页'
          },
          component: Home
        }
      ]
    },
    {
      path: '/about',
      name: 'about',
      meta: {
        title: '关于'
      },
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    },
    {
      path: '/login',
      name: 'login',
      meta: {
        title: '登录'
      },
      component: () => import('@/views/Login')
    }
  ]
})
