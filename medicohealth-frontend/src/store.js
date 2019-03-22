import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: null,
    isLogin: false,
    role: null,
    token: null
  },
  mutations: {
    setUser(state, user) {
      state.user = user
      sessionStorage.setItem('user', user);
    },
    setIsLogin(state, isLogin) {
      state.isLogin = isLogin
      sessionStorage.setItem('isLogin', isLogin)
    },
    setSession(state, token) {
      if (token) {
        sessionStorage.setItem('token', token)
        state.token = token
      } else {
        sessionStorage.removeItem('token')
        state.token = null
      }
    },
    setRole(state, role) {
      state.role = role;
      sessionStorage.setItem('role', role);
    },
    logout(state) {
      state.user = null
      state.isLogin = false
      state.role = null
      state.token = null
      sessionStorage.removeItem('token')
      sessionStorage.removeItem('user')
      sessionStorage.removeItem('role')
      sessionStorage.removeItem('isLogin')  
      sessionStorage.removeItem('userid')    
    },
    setUserId(state, id) {
      state.id = id;
      sessionStorage.setItem('userid', id);
    }
  },
  getters: {
    getUser: state => {
      return sessionStorage.getItem('user')
    },
    isLogin: state => {
      return sessionStorage.getItem('isLogin')
    },
    getRole: state => {
      return sessionStorage.getItem('role')
    },
    getToken: state => {
      return sessionStorage.getItem('token')
    },
    getUserId: state => {
      return sessionStorage.getItem('userid')
    }    
  },
  actions: {
  }
})
