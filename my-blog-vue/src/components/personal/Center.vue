<template>
    <div>
        <el-container>
            <el-header><Header></Header></el-header>
            <el-container id="content">
                <el-aside width="200px">
                    <el-row class="tac">
                        <el-col >
                            <el-menu
                            default-active="2"
                            class="el-menu-vertical-demo"
                            @open="handleOpen"
                            @close="handleClose"
                            background-color="#545c64"
                            text-color="#fff"
                            active-text-color="#ffd04b">
                            <el-menu-item index="2">
                                <i class="el-icon-document"></i>
                                <span slot="title" @click="showPersonalInfo">个人信息</span>
                            </el-menu-item>
                            <el-menu-item index="3">
                                <i class="el-icon-document"></i>
                                <span slot="title">文章管理</span>
                            </el-menu-item>
                            <el-menu-item index="4">
                                <i class="el-icon-setting"></i>
                                <span slot="title">导航四</span>
                            </el-menu-item>
                            </el-menu>
                        </el-col>
                    </el-row>
                </el-aside>
                <el-main>
                    <UserInfo :userInfo=userInfo></UserInfo>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>
<script>
import Header from '../common/Header'
import UserInfo from '../personal/UserInfo'
export default {
    name: 'Center',
    components: {Header},
    data() {
        return{
            userInfo:{}
        }
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      showPersonalInfo(){
          const _this = this
          const id = JSON.parse(localStorage.getItem('userInfo')).userId
          console.log(id);
          
          this.$axios.get('/info/'+userId)
            .then((res) => {
                _this.userInfo = res.data.data
            })
      }
    }
}
</script>
<style>
    #content {
        margin: 20px;
    }
</style>