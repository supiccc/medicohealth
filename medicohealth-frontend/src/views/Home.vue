<template>
  <div class="home">
    <div v-if="this.getRole == 'admin'">
      <el-row>
        <el-col :span="12" v-for="o in this.options" :key="o">
          <el-card style="margin: 20px 20px 0px 30px;">
            <div slot="header" class="clearfix" :key="o">
              <span class="text">{{ o }}</span>
            </div>
            <!--
            <div v-for="z in 4" :key="z" class="text item">
              {{'列表内容 ' + z }}
            </div>
            -->
            <div class="pie-chart-holder" v-if="o == '云端老人统计'">
              <PieElder></PieElder>
            </div>
            <div class="pie-chart-holder" v-if="o == '云端医师统计'">
              <PieCustom></PieCustom>
            </div>
          </el-card>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <el-card style="margin: 20px 20px 10px 30px;">
            <div slot="header" class="clearfix">
              <span class="text">云端用户统计</span>
            </div>
            <div class="line-chart-holder">
              <LineUser></LineUser>
            </div>            
          </el-card>
        </el-col>      
      </el-row>
    </div>

    <div v-if="this.getRole == 'elder'">
      <!--
      <img alt="Vue logo" src="../assets/logo.png">        
      <HelloWorld msg="Welcome to Your Vue.js App" v-if='ifSeen'/>
      <p v-if='isLogin'>用户名：{{ this.getUser }}</p>
      <p v-if='isLogin'>信息：{{ this.getToken }}</p>
      <p v-if='isLogin'>信息：{{ this.getUserId }}</p>
      -->
      <Monitor></Monitor>
      <!-- <p>{{ this.$router.params.password }}</p> -->
      <!--<p>{{ this.$router.params.username }}</p>-->
    </div>
    <div v-if="this.getRole == 'doctor'">
      <!--
      <img alt="Vue logo" src="../assets/logo.png">
      <HelloWorld msg="Welcome to Your Vue.js App" v-if='ifSeen'/>
      <p v-if='isLogin'>用户名：{{ this.getUser }}</p>
      <p v-if='isLogin'>信息：{{ this.getToken }}</p>
      <p v-if='isLogin'>信息：{{ this.getUserId }}</p>
      -->
      <WarningHandler></WarningHandler>
      <!-- <p>{{ this.$router.params.password }}</p> -->
      <!--<p>{{ this.$router.params.username }}</p>-->
    </div>        
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import PieCustom from '@/components/PieCustom.vue'
import PieElder from '@/components/PieElder.vue'
import LineUser from '@/components/LineUser.vue'
import Monitor from '@/components/Monitor.vue'
import WarningHandler from '@/components/doctor/WarningHandler.vue'
import {mapGetters} from 'vuex'

export default {
  name: 'home',
  data() {
    return {
      ifSeen: true,
      options: ["云端医师统计", "云端老人统计"]
    }
  },
  computed: {
    ...mapGetters(['getUser', 'isLogin', 'getRole', 'getToken', 'getUserId'])
  },
  components: {
    HelloWorld,
    PieCustom,
    PieElder,
    LineUser,
    Monitor,
    WarningHandler
  },
  mounted() {
    this.ifSeen = !this.isLogin
  }
}
</script>

<style>
  .text {
    font-size: 14px;
  }

  .time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .pie-chart-holder, .line-chart-holder {
    height: 30vh;
  }
</style>