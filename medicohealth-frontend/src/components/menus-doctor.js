const menus = [
    {id: '0', label: '控制面板', path: '/', icon: 'fa fa-dashboard'},
    {id: '1', label: '预警信息', path: '/', icon: 'fa fa-dashboard'},
    {id: '2', label: '档案信息', path: '/', icon: 'fa fa-dashboard'},
    {
        id: '3',
        icon: 'fa fa-file',
        label: '资料管理',
        submenu: [
          {
            id: '4',
            label: '医师管理',
            icon: 'fa fa-user-md'
          },
          {
            id: '5',
            label: '老人管理',
            icon: 'fa fa-wheelchair'
          }
        ]
    },
    {id: '6', label: '统计', path: '/', icon: 'fa fa-pie-chart'}   
  ]
  export default menus
  