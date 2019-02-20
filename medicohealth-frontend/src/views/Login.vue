<template>
<div class="fullscreen">
  <div class="login-box">
    <div style="text-align: center">
      <img src="../assets/health.png" alt="" class="logo">
    </div>
    <!--<p class="text-tips">你好，欢迎登录</p> -->
    <form action="" class="login-form">
      <div class="m-list-group">
        <div class="m-list-group-item">
          <input type="text" placeholder="用户名" class="m-input" v-model="username">
        </div>
        <div class="m-list-group-item">
          <input type="password" placeholder="密码" class="m-input" v-model="password">
        </div>   
      </div>
      <button class="m-btn sub select-none" @click.prevent="handleLogin" v-loading="isLoging">登录</button>
    </form>
    <div style="margin-top: 50px"></div>
    <p class="text-tips">
      <i class="fa fa-meetup" style="color: #29ABE2"></i>&nbsp;
      <span class="footer-text">医养结合信息服务系统 &nbsp;<el-tag size="mini">1.0.0</el-tag> <br>©make by <a href="https://www.github.com/supiccc" target="_blank">supiccc@gmail.com</a>
  </span>
    </p>
  </div>
</div>
</template>
<script>
import {mapMutations} from 'vuex'

export default {
  name: 'login',
  data () {
    return {
      username: null,
      password: null,
      isLoging: false,
      info: null
    }
  },
  methods: {
    ...mapMutations(['setUser', 'setIsLogin', 'setSession', 'setRole']),
    handleLogin () {
      if (!this.username || !this.password) {
        return this.$message.warning('用户名和密码不能为空')
      }    
      this.isLoging = true;  
      this.$axios
        .post('http://localhost:8004/auth/v2/login',
          {
            'username': this.username,
            'password': this.password
          }, 
          {
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
          },
          transformRequest: [function (data) {
            let ret = ''
            for (let it in data) {
              ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
            }
            return ret
          }]
        })
        .then(response => {
          if(response.data.code == 0) {
            this.$message.success('登录成功')
            this.setUser(response.data.data.username)
            this.setIsLogin(true)
            this.setRole(response.data.data.role)
            this.setSession(response.data.data.token)
            this.info = response.data.data.token
            this.$router.push({name: 'home', params: {user: this.username, information: this.info}})
          } else if(response.data.code == 1) {
            this.$message.warning("密码错误")
            this.isLoging = false;
          } else {
            this.$message.warning("用户名错误")
            this.isLoging = false;
          }
        })
        .catch(error => console.log(error))      
    }
  },
  mounted() {
    if(this.$route.params.message == '未授权，请登陆授权后继续') {
      this.$message.warning(this.$route.params.message)
    }
  }
}
</script>
<style type="text/css">
  .m-list-group{
    border-radius: 3px;
    padding: 0;
    margin: 0 0 0px;
  }
  .m-list-group .m-list-group-item{
    position: relative;
    display: block;
    padding: 6px 10px;
    margin-bottom: 16px;
    background-color: #fff;
    border: 1px solid #e7ecee;
  }
  .m-list-group .m-list-group-item:first-child{
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
  }
  .m-list-group .m-list-group-item:last-child{
    border-bottom-left-radius: 3px;
    border-bottom-right-radius: 3px;
  }
  .fullscreen{
    position: absolute;
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;

  }
  .login-box{
    position: relative;
    width: 30%;
    margin: 0 auto;
    padding: 0px 15px;
  }
  .login-box .logo{
    max-width: 40%;
    margin-bottom: 0px;
  }
  .login-box .text-tips{
    text-align: center;
    color: #909DB7;
  }
  .login-box .m-input{
    width: 100%;
    padding: 10px;
    border: none;
    outline: none;
    box-sizing: border-box;
  }
  .login-box .m-btn{
    font-size: 18px;
    width: 100%;
    color: #fff;
    background-color: #36c1fa;
    display: inline-block;
    padding: 10px 12px;
    margin-top: 25px;
    margin-bottom: 5px;
    line-height: 1.42857143;
    text-align: center;
    cursor: pointer;
    outline: none;
    border-radius: 2px;
    border: 1px solid #36c1fa;
    box-sizing: border-box;
    text-decoration: none;
  }
  .login-box .m-btn.m-btn-text{
    background: #fff;
    color: #36C1FA;
  }
  .login-box .m-btn:hover{
    background-color: #2DB7F5;
  }
  .login-box .m-btn.m-btn-text:hover{
    background-color: #F4F5F5;
  }
  .login-box .m-btn:active{
    opacity: 0.8;
  }
  @media (max-width: 768px) {
    .login-box{
      width: 90%;
    }
  }
</style>
