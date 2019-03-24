const menus = [
    {id: '0', label: '首页', path: '/', icon: 'fa fa-dashboard'},
    {id: '1', label: '健康日志', path: '/', icon: 'fa fa-bar-chart'},
    {
      id: '2', 
      label: '健康档案', 
      icon: 'fa fa-medkit',
      submenu: [
        {
          id: '3',
          label: '门诊病历',
          path: '/record/clinic'
        },
        {
          id: '4',
          label: '住院病历',
          path: '/record/medical'
        },
        {
          id: '8',
          label: '手术记录',
          path: '/record/operation'
        },        
        {
          id: '5',
          label: '既往观察病史',
          path: '/record/medicalHistory'
        },
        {
          id: '6',
          label: '用药记录',
          path: '/record/medication'
        },
        {
          id: '7',
          label: '药物过敏',
          path: '/record/allergy'
        },
      ]
    }
  ]
  export default menus
  