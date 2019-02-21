const menus = [
    {id: '0', label: '控制面板', path: '/', icon: 'fa fa-dashboard'},
    {
        id: '1',
        icon: 'fa fa-file',
        label: '资料管理',
        submenu: [
          {
            id: '2',
            label: '医师管理',
            icon: 'fa fa-user-md'
          },
          {
            id: '3',
            label: '老人管理',
            icon: 'fa fa-wheelchair'
          },
          {
            id: '4',
            label: '机构管理',
            icon: 'fa fa-hospital-o'
          }
        ]
    },
    {
        id: '5',
        icon: 'fa fa-bar-chart',
        label: '统计',
        submenu: [
          {
            id: '6',
            label: '医师统计',
            icon: 'fa fa-pie-chart'
          },
          {
            id: '7',
            label: '老人统计',
            icon: 'fa fa-pie-chart'
          },
          {
            id: '8',
            label: '用户统计',
            icon: 'fa fa-line-chart'
          }
        ]
    }    
  ]
  export default menus
  