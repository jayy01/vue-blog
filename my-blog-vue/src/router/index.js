import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/home/Home'
import Login from '@/components/Login'
import Register from '@/components/Register'
import Header from '@/components/common/Header'
import BlogDetail from '@/components/blog/BlogDetail'
import BlogEdit from '@/components/blog/BlogEdit'
import Notes from '@/components/home/Notes'
import Blogs from '@/components/blog/Blogs'
import Center from '@/components/personal/Center'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/header',
      name: 'Header',
      component: Header
    },
    {
      path: '/detail/:blogId',
      name: 'BlogDetail',
      component: BlogDetail
    },
    {
      path: '/edit',
      name: 'BlogEdit',
      meta: {
        requireAuth: true
      },
      component: BlogEdit
    }
    ,
    {
      path: '/notes',
      name: 'Notes',
      meta: {
        requireAuth: true
      },
      component: Notes
    },
    {
      path: '/typeBlogs/:typeId',
      name: 'Blogs',
      component: Blogs
    },
    {
      path: '/personal',
      name: 'Center',
      component: Center
    }
  ]
})
