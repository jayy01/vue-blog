<template>
    <el-form class="login-container"  label-width="0px">
        <h3 class="login_title">系统登录</h3>
        <el-form-item >
            <el-input type="text" v-model="loginForm.userName"  placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item >
            <el-input  type="password" v-model="loginForm.password" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="login" class="color-primary" style="width:100%">登录</el-button>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="register" class="color-primary" style="width:100%">注册</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
export default {
    name: 'Login',
    data() {
        return {
            loginForm: {
                userName: 'zhangsan',
                password: '111111'
            },
            responseResult: []
        }
    },
    methods: {
        login(){
            const _this = this
            this.$axios
                .post('/login',{
                    username: this.loginForm.userName,
                    password: this.loginForm.password
                })
                .then(successResponse => {
                    //将返回的信息使用store管理
                    const token = successResponse.headers['authorization']
                    _this.$store.commit('SET_TOKEN',token)
                    _this.$store.commit('SET_USERINFO',successResponse.data.data)
                    _this.$router.push({path:'/'})
                })
        },
        register(){
            this.$router.push({path: '/register'})
        }
    }
    
}
</script>

<style>
    .login-container {
        border-radius: 15px;
        background-clip: padding-box;
        margin: 90px auto;
        width: 350px;
        padding: 35px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
    }
    .login_title {
        margin: 0px auto 40px auto;
        text-align: center;
        color: #505458;
    }
</style>
