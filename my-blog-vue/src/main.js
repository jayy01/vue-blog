import Vue from 'vue'
import App from './App'
import router from './router'
import Vuex from 'vuex'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store/index.js'

import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import axios from 'axios'

axios.defaults.baseURL='http://localhost:8084'
Vue.prototype.$axios = axios
Vue.use(ElementUI)
Vue.use(Vuex)
Vue.use(mavonEditor)

Vue.config.productionTip = false

//axios 配置
//前置拦截
axios.interceptors.request.use(config => {
  //统一为所有需要权限的请求装配上header的token信息 
  let token = localStorage.getItem("token")
  if (token) {
    config.headers['Authorization'] = token
  }
  return config
})
//后置拦截 处理请求返回以后的业务
axios.interceptors.response.use(response => {
  //console.log('后置拦截');
  //console.log(response);
  const res = response.data
  //处理返回200 与 非200
  if(res.code === 200){
    return response
  }else{
    ElementUI.Message({
      message: res.msg,
      type: 'error',
      duration: 2 * 1000
    })
  }
  return Promise.reject(res.msg)
},
error => {
  //请求报错时
  //console.log('后置拦截');
  //console.log(error.response.data);
  //错误消息读取
  if(error.response.data){
    error.message = error.response.data.msg
  }
  // 401 需要登录
  if(error.response.status === 401){
    store.commit('REMOVE_INFO')
    router.push({path: '/login'})
    error.message = '请登录'
  }
  //403 权限不足
  if(error.response.status === 403){
    error.message = '权限不足，无法访问'
  }
  //弹窗提示
  ElementUI.Message({
    message: error.message,
    type: 'error',
    duration: 2 * 1000
  })
  //
  return Promise.reject(error)
})
//router配置
router.beforeEach((to,from,next) => {
  
  if(to.matched.some(record => record.meta.requireAuth)){
    const token = localStorage.getItem("token")
    if(token){
      if(to.path === '/login'){

      }else{
        next()
      }
    }else{
      next({path:'/login'})
    }
  }else{
    next()
  }
})

new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>',
  mode: 'history',
})
