<template>
<m-navbar :theme="this.theme.theme.headerTheme">
  <m-navbar-brand class='left'>
    <i class="side-switch"
      :class="{
        'el-icon-more': !mini,
        'el-icon-more-outline': mini
      }"
      @click="handleSwitchSide"
      ></i>
  </m-navbar-brand>
  <m-nav align="left">
    <!--
    <m-nav-item ><router-link to="/"><a target="_blank" class='acolor'>主页</a></router-link></m-nav-item>
    -->
    <!--
    <m-nav-item v-if="this.getRole == 'admin'"><router-link to="/login"><a target="_blank" class='acolor'>资料管理</a></router-link></m-nav-item>
    <m-nav-item v-if="this.getRole == 'admin'"><router-link to="/login"><a target="_blank" class='acolor'>系统统计</a></router-link></m-nav-item>
    <m-nav-item v-if="this.getRole == 'elder'"><router-link to="/login"><a target="_blank" class='acolor'>健康监测</a></router-link></m-nav-item>
    <m-nav-item v-if="this.getRole == 'elder'"><router-link to="/login"><a target="_blank" class='acolor'>健康日志</a></router-link></m-nav-item>
    <m-nav-item v-if="this.getRole == 'elder'"><router-link to="/login"><a target="_blank" class='acolor'>健康档案</a></router-link></m-nav-item>
    <m-nav-item v-if="this.getRole == 'elder'"><router-link to="/login"><a target="_blank" class='acolor'>亲人关怀</a></router-link></m-nav-item>
    <m-nav-item v-if="this.getRole == 'doctor'"><router-link to="/login"><a target="_blank" class='acolor'>预警处理</a></router-link></m-nav-item>
    <m-nav-item v-if="this.getRole == 'doctor'"><router-link to="/login"><a target="_blank" class='acolor'>查看健康档案</a></router-link></m-nav-item>
    -->
  </m-nav>
  <m-nav align="right">
    <!--
    <m-nav-item padding="0">
      <a href="https://github.com/mengdu/vue-element-admin-tpl" target="_blank"><i class="fa fa-github" style="font-size: 26px;vertical-align: middle;"></i>&nbsp;Github</a>
    </m-nav-item>
    -->
    <m-nav-item padding="0">
      <m-dropdown align="right" v-if="this.getUser" padding="0 10px">
        <a href="#" style="display: inline-block; padding: 0px; color: inherit">
          <img src="../assets/user.jpg" alt="" style="border-radius: 3px;vertical-align: middle;">
          <span> {{ "欢迎您，" + this.getUser }}</span> 
          <span class="caret"></span>
        </a>
        <m-dropdown-panel>
          <m-dropdown-item>用户信息</m-dropdown-item>
          <m-dropdown-item>修改密码</m-dropdown-item>
          <m-dropdown-item>注销</m-dropdown-item>
          <div class="test-line"></div>
          <m-dropdown-item name="login">退出账号</m-dropdown-item>
        </m-dropdown-panel>
      </m-dropdown>
    </m-nav-item>
    <m-nav-item padding="0 5px">
      <a href="#" @click.stop.prevent="handleSwitchScreen">
        <i 
          class="fa" 
          :class="isFullScreen ? 'fa-compress' : 'fa-expand'"
          ></i>
      </a>
    </m-nav-item>
    <!--
    <m-nav-item padding="0">
      <m-dropdown align="right" padding="0 10px">
        <a href="#"  style="padding:0 0px; color: inherit">
          <i class="fa fa-gears"></i>
        </a>
        <m-dropdown-panel style="width: 200px; min-height: 100px;">
          <el-form>
            <el-form-item label="侧边栏">
              <el-switch v-model="showAside" @change="handleSwitchHideSide" />
            </el-form-item>
            <el-form-item label="主题">
              <el-select v-model="themeType" style="width: 100px">
                <el-option
                  v-for="theme in themes"
                  :key="theme.label"
                  :label="theme.label"
                  :value="theme.name"
                  ></el-option>
              </el-select>
            </el-form-item>
          </el-form>
        </m-dropdown-panel>
      </m-dropdown>
    </m-nav-item>
    -->
  </m-nav>
</m-navbar>
</template>
<script type="text/javascript">
import {mapGetters} from 'vuex'
import {
  requestFullScreen,
  exitFullscreen
} from '@/utils'
import themes from './theme'
export default {
  name: 'app-header',
  data () {
    return {
      mini: false,
      isFullScreen: false,
      themes,
      themeType: '',
      showAside: true,
      theme: {theme: {headerTheme: 'info'}}
    }
  },
  computed: {
      ...mapGetters(['getUser', 'getRole'])
  },
  watch: {
    themeType (val) {
      this.theme = this.themes.find(e => e.name === val) || {}
      this.$emit('set-theme', this.theme)
      localStorage.setItem('theme', val)
    }
  },
  methods: {
    // ...mapActions(['getLoginUser', 'logout']),
    handleSwitchSide () {
      this.mini = !this.mini
      this.$emit('switch', this.mini)
    },
    handleSwitchScreen () {
      if (this.isFullScreen) {
        exitFullscreen()
        this.isFullScreen = false
      } else {
        requestFullScreen()
        this.isFullScreen = true
      }
    },
    handleSwitchHideSide () {
      console.log('change')
      this.$emit('hide-side')
    }
  },
  created () {
    // this.getLoginUser()
    var theme = 'white'
    this.themeType = theme
  }
}
</script>
<style type="text/css">
  .side-switch{
    display: inline-block;
    font-size: 32px;
    cursor: pointer;
    color: inherit;
    margin-top: 10px;
  }
  .side-switch:hover{
    color: #fff;
  }
  .m-navbar-brand.left {
    float: left;
  }
  .m-nav.left {
    float: left;
  }
  .acolor {
    color: inherit;
  }
</style>
