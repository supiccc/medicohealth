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
          path: '/elder',
          name: 'elder',
          meta: {
            title: '老人管理'
          },
          component: () => import('@/components/TableElder.vue')
        },        
        {
          path: '/doctor',
          name: 'doctor',
          meta: {
            title: '医师管理'
          },
          component: () => import('@/components/TableDoctor.vue')
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
        {
          path: '/log/bloodpressure',
          name: 'BloodPressureLog',
          meta: {
            title: '血压记录',
          },
          component: () => import('@/components/healthlog/BloodPressure.vue')
        },        
        {
          path: '/log/bloodsugar',
          name: 'BloodSugarLog',
          meta: {
            title: '血糖记录',
          },
          component: () => import('@/components/healthlog/BloodSugar.vue')
        }, 
        {
          path: '/log/bloodoxygen',
          name: 'BloodOxygenLog',
          meta: {
            title: '血氧记录',
          },
          component: () => import('@/components/healthlog/BloodOxygen.vue')
        }, 
        {
          path: '/log/heightWeight',
          name: 'HeightWeightLog',
          meta: {
            title: 'BMI记录',
          },
          component: () => import('@/components/healthlog/HeightWeight.vue')
        }, 
        {
          path: '/log/fat',
          name: 'FatLog',
          meta: {
            title: '脂肪记录',
          },
          component: () => import('@/components/healthlog/Fat.vue')
        }, 
        {
          path: '/log/cholesterol',
          name: 'CholesterolLog',
          meta: {
            title: '胆固醇记录',
          },
          component: () => import('@/components/healthlog/Cholesterol.vue')
        }, 
        {
          path: '/log/uridAcid',
          name: 'UridAcidLog',
          meta: {
            title: '尿酸记录',
          },
          component: () => import('@/components/healthlog/UridAcid.vue')
        },   
        {
          path: '/info/elder',
          name: 'ElderInfo',
          meta: {
            title: '修改资料',
          },
          component: () => import('@/components/user/ElderInfo.vue')
        },
        {
          path: '/info/doctor',
          name: 'DoctorInfo',
          meta: {
            title: '修改资料',
          },
          component: () => import('@/components/user/DoctorInfo.vue')
        },
        {
          path: '/doctor/pie/doctor',
          name: 'DoctorPieDoctor',
          meta: {
            title: '职工统计',
          },
          component: () => import('@/components/doctor/PieDoctor.vue')
        },
        {
          path: '/doctor/pie/elder',
          name: 'DoctorPieElder',
          meta: {
            title: '居民统计',
          },
          component: () => import('@/components/doctor/PieElder.vue')          
        },
        {
          path: '/doctor/elder/look',
          name: 'ElderLook',
          meta: {
            title: '居民管理',
          },
          component: () => import('@/components/doctor/ElderLook.vue')   
        },
        {
          path: '/insert/elder',
          name: 'InsertElder',
          meta: {
            title: '新增居民'
          },
          component: () => import('@/components/insert/InsertElder.vue')   
        },
        {
          path: '/insert/doctor',
          name: 'InsertDoctor',
          meta: {
            title: '新增医师'
          },
          component: () => import('@/components/insert/InsertDoctor.vue')   
        },
        {
          path: '/insert/hospital',
          name: 'InsertHospital',
          meta: {
            title: '新增医院'
          },
          component: () => import('@/components/insert/InsertHospital.vue')   
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
