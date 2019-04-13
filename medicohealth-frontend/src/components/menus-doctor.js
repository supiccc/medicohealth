const menus = [
    {id: '1', label: '预警信息处理', path: '/', icon: 'fa fa-dashboard'},
    {
        id: '2',
        icon: 'fa fa-wheelchair',
        label: '居民管理',
        path: '/doctor/elder/look'
    },
    {
        id: '3', 
        label: '统计', 
        icon: 'fa fa-pie-chart',
        submenu: [
            {
                path: '/doctor/pie/elder',
                id: '4',
                label: '居民统计'
            },
            {
                path: '/doctor/pie/doctor',
                id: '5',
                label: '职工统计'
            }
        ]

    }   
  ]
  export default menus
  