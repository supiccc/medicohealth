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
        },
        {
          path: '/pie',
          name: 'pie',
          meta: {
            title: '统计'
          },
          component: () => import('@/components/PieCustom.vue')
        },
        {
          path: '/pie/elder',
          name: 'pieElder',
          meta: {
            title: '统计'
          },
          component: () => import('@/components/PieElder.vue')
        },
        {
          path: '/line',
          name: 'lineUser',
          meta: {
            title: '统计'
          },
          component: () => import('@/components/LineUser.vue')
        },
        {
          path: '/hospital',
          name: 'hospital',
          meta: {
            title: '机构管理'
          },
          component: () => import('@/components/TableHospital.vue')
        },
        {
          path: '/monitor',
          name: 'monitor',
          meta: {
            title: '健康监测'
          },
          component: () => import('@/components/Monitor.vue')
        },
        {
          path: '/record/allergy',
          name: 'allergy',
          meta: {
            title: '药物过敏'
          },
          component: () => import('@/components/record/Allergy.vue')
        },
        {
          path: '/record/clinic',
          name: 'clinic',
          meta: {
            title: '门诊病历'
          },
          component: () => import('@/components/record/Clinic.vue')
        },
        {
          path: '/record/medicalHistory',
          name: 'medicalHistory',
          meta: {
            title: '既往观察病史'
          },
          component: () => import('@/components/record/MedicalHistory.vue')
        },
        {
          path: '/record/medical',
          name: 'medical',
          meta: {
            title: '住院病历'
          },
          component: () => import('@/components/record/Medical.vue')
        },                      
        {
          path: '/record/medication',
          name: 'Medication',
          meta: {
            title: '用药记录'
          },
          component: () => import('@/components/record/Medication.vue')
        },      
        {
          path: '/record/operation',
          name: 'Operation',
          meta: {
            title: '手术记录'
          },
          component: () => import('@/components/record/Operation.vue')
        },               
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
