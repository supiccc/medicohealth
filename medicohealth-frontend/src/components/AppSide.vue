<template>
<div>
<v-menu class="side-menu"
  v-if="this.getRole == 'admin'"
  :collapse="collapse"
  :default-active="defaultActive"
  :menus="menus_admin"
  router
  :background-color="theme.backgroundColor"
  :text-color="theme.textColor"
  :active-text-color="theme.activeTextColor"
  ></v-menu>
  <v-menu class="side-menu"
  v-if="this.getRole == 'doctor'"
  :collapse="collapse"
  :default-active="defaultActive"
  :menus="menus_doctor"
  router
  :background-color="theme.backgroundColor"
  :text-color="theme.textColor"
  :active-text-color="theme.activeTextColor"
  ></v-menu>
  <v-menu class="side-menu"
  v-if="this.getRole == 'elder'"
  :collapse="collapse"
  :default-active="defaultActive"
  :menus="menus_elder"
  router
  :background-color="theme.backgroundColor"
  :text-color="theme.textColor"
  :active-text-color="theme.activeTextColor"
  ></v-menu>  
</div>

</template>
<script type="text/javascript">
import VMenu from './vmenu'
import menus from './menus'
import menus_admin from './menus-admin'
import menus_doctor from './menus-doctor'
import menus_elder from './menus-elder'
import {mapGetters} from 'vuex'
export default {
  props: {
    collapse: Boolean,
    theme: Object
  },
  components: {
    VMenu
  },
  data () {
    return {
      menus,
      menus_admin,
      menus_doctor,
      menus_elder,
      defaultActive: 'home',
      // test: 'asdfasdf'
    }
  },
  watch: {
    $route () {
      this.setCurrentRoute()
    }
  },
  methods: {
    setCurrentRoute () {
      // console.log(this.$route)
      this.defaultActive = this.$route.name
    }
  },
  computed: {
    ...mapGetters(['getUser', 'getRole'])
  },
  created () {
    this.setCurrentRoute()
  }
}
</script>
<style type="text/css">
  .el-menu.side-menu{
    border-right: none;
  }
  .el-menu .fa{
    font-size: 18px;
    margin-right: 7px;
    display: inline-block;
    width: 23px;
    text-align: center;
  }
  .el-menu.side-menu .el-menu-item.is-active {
    color: #409EFF;
    border-right: solid 2px #36c1fa;
    background: #eef3f5;
  }
  .el-menu, .el-submenu {
    text-align: left;
  }
</style>
