const menus = [
    {id: '0', label: '首页', path: '/', icon: 'fa fa-dashboard'},
    {
      id: '1', 
      label: '健康日志', 
      icon: 'fa fa-bar-chart',
      submenu: [
        {
          id: '9',
          label: '血压',
          path: '/log/bloodpressure'          
        },
        {
          id: '10',
          label: '血糖',
          path: '/log/bloodsugar'          
        },
        {
          id: '11',
          label: '血氧',
          path: '/log/bloodoxygen'          
        },
        {
          id: '12',
          label: 'BMI',
          path: '/log/heightWeight'          
        },
        {
          id: '13',
          label: '脂肪',
          path: '/log/fat'          
        },
        {
          id: '14',
          label: '胆固醇',
          path: '/log/cholesterol'          
        },
        {
          id: '15',
          label: '尿酸',
          path: '/log/uridAcid'          
        },                                                     
      ]
    },
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
  