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
    }
  },
  actions: {
    
  }
})
