<template>
  <div class="home">
    <div v-if="this.getRole == 'admin'">
      <img alt="Vue logo" src="../assets/logo.png">
      <HelloWorld msg="Welcome to Your Vue.js App" v-if='ifSeen'/>
      <p v-if='isLogin'>用户名：{{ this.getUser }}</p>
      <p v-if='isLogin'>信息：{{ this.getToken }}</p>
      <!-- <p>{{ this.$router.params.password }}</p> -->
      <!--<p>{{ this.$router.params.username }}</p>-->
    </div>
    <div v-if="this.getRole == 'elder'">
      <img alt="Vue logo" src="../assets/logo.png">
      <HelloWorld msg="Welcome to Your Vue.js App" v-if='ifSeen'/>
      <p v-if='isLogin'>用户名：{{ this.getUser }}</p>
      <p v-if='isLogin'>信息：{{ this.getToken }}</p>
      <!-- <p>{{ this.$router.params.password }}</p> -->
      <!--<p>{{ this.$router.params.username }}</p>-->
    </div>
    <div v-if="this.getRole == 'doctor'">
      <img alt="Vue logo" src="../assets/logo.png">
      <HelloWorld msg="Welcome to Your Vue.js App" v-if='ifSeen'/>
      <p v-if='isLogin'>用户名：{{ this.getUser }}</p>
      <p v-if='isLogin'>信息：{{ this.getToken }}</p>
      <!-- <p>{{ this.$router.params.password }}</p> -->
      <!--<p>{{ this.$router.params.username }}</p>-->
    </div>        
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import {mapGetters} from 'vuex'

export default {
  name: 'home',
  data() {
    return {
      ifSeen: true
    }
  },
  computed: {
    ...mapGetters(['getUser', 'isLogin', 'getRole', 'getToken'])
  },
  components: {
    HelloWorld
  },
  mounted() {
    this.ifSeen = !this.isLogin
  }
}
</script>
