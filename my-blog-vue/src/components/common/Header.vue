<template>
  <div >
    <div class="menu">
        <el-menu
          :default-active="activeIndex"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
          <el-menu-item index="homePage" >首页</el-menu-item>
          <el-menu-item index="personalNotes" >个人笔记</el-menu-item>
          <el-submenu  index="info" style="float:right">
            <template index="avatar" slot="title">
              <el-avatar :size="30" :src="user.header"></el-avatar>
            </template>
            <template index="spacing" slot="title">
              <span class="spacing"/>
            </template>
            <template index="userInfo" slot="title" >{{ user.username }}</template>
            <el-menu-item v-if="loginFlag" index="personalCenter">个人中心</el-menu-item>
            <el-menu-item v-if="!loginFlag" index="login">登录</el-menu-item>
            <el-menu-item index="logout">注销</el-menu-item>
          </el-submenu>
        </el-menu>
      </div>
  </div>

</template>
<script>
export default {
  name: 'Header',
  data() {
      return {
        activeIndex: 'homePage',
        user: {
          username: '请登录',
          header: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
        },
        loginFlag: false
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        this.$parent.contentShow(key,keyPath);
      }
    },
    created() {
      //获取登录的用户
      if(this.$store.getters.getUser) {
        this.loginFlag = true
        this.user.username = this.$store.getters.getUser.username
        this.user.header = this.$store.getters.getUser.header
        this.hasLogin = true
      }
    }
  }
</script>
<style>
  .menu{
    margin-top: 1%;
  }
  .spacing {
    margin-left: 5px;
  }
</style>