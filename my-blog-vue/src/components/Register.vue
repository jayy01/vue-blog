<template>
    <el-form class="login-container" :model="registerForm" :rules="rules" ref="registerForm"  label-width="80px">
        <h3 class="login_title">账户注册</h3>
        <el-form-item label="用户名" prop="username">
            <el-input type="text" v-model="registerForm.username"  placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input  type="password" v-model="registerForm.password" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="passwordConfirm"> 
            <el-input  type="password" v-model="registerForm.passwordConfirm" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item label="昵称"  prop="nickname">
            <el-input type="text" v-model="registerForm.nickname"  placeholder="请输入昵称"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
            <el-input type="text" v-model="registerForm.name"  placeholder="请输入姓名"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
            <el-select v-model="registerForm.sex" placeholder="请选择性别">
                <el-option label="男" value="1"></el-option>
                <el-option label="女" value="0"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="电话" prop="phone">
            <el-input  type="text" v-model="registerForm.phone" placeholder="请输入电话"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
            <el-input type="text" v-model="registerForm.email"  placeholder="请输入邮箱"></el-input>
        </el-form-item>
        <el-button type="primary" @click="register('registerForm')" class="color-primary regiter-button" >注册</el-button>
        <br>
        <el-button type="primary" @click="resetForm('registerForm')" class="color-primary regiter-button">重置</el-button>
        <br>
        <el-button type="primary" @click="login" class="color-primary regiter-button" >登录</el-button>
    </el-form>

</template>

<script>
export default {
    name: 'Register',
    data() {
        var validatePass = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请再次输入密码'));
            } else if (value !== this.registerForm.password) {
                callback(new Error('两次输入密码不一致!'));
            } else {
                callback();
            }
        };
        var checkEmail = (rule, value, callback) => {
            const EmailRegex = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
            if (!value) {
                callback(new Error('邮箱不能为空'));
            }
            if(!EmailRegex.test(value)){
                callback(new Error('邮箱格式不正确'));
            }
            callback();
        };
        return {
            registerForm: {
                username: '',
                password: '',
                passwordConfirm: '',
                name: '',
                nickname: '',
                sex: '1',
                phone: '',
                email:''
            },
            rules: {
                username: [
                    { required: true, message: '请输入用户名', trigger: 'blur' },
                    { min: 3, message: '长度至少3个字符', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { min: 3, message: '长度至少3个字符', trigger: 'blur' }
                ],
                passwordConfirm: [
                    { required: true, validator: validatePass, trigger: 'blur' }
                ],
                name: [
                    { required: true, message: '请输入姓名', trigger: 'blur' }
                ],
                nickname: [
                    { required: true, message: '请输入昵称', trigger: 'blur' }
                ],
                sex: [
                    { required: true, message: '请选择性别', trigger: 'blur' }
                ],
                email: [
                    { required: true,validator: checkEmail, trigger: 'blur' }
                ],
            }
        }
    },
    methods: {
        register(formName){            
            this.$refs[formName].validate((valid) => {
                if (valid) {        
                    this.$axios
                        .post("/register",{
                            username: this.registerForm.username,
                            password: this.registerForm.password,
                            nickname: this.registerForm.nickname,
                            name: this.registerForm.name,
                            sex: this.registerForm.sex,
                            phone: this.registerForm.phone,
                            email:this.registerForm.email
                        })
                        .then(successResponse => {
                            if(successResponse.status === 200){
                                this.$router.replace({path: '/login'})
                            }else{
                                ElementUI.Message({
                                    message: successResponse.data.message,
                                    type: 'error',
                                    duration: 2 * 1000
                                })
                            }
                        } )
                } else {
                    return false;
                }
            }
            );
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        },
        login(){
            this.$router.replace({path: '/login'})
        }
    }
    
}
</script>

<style>
    .login-container {
        border-radius: 15px;
        background-clip: padding-box;
        margin: 20px auto;
        width: 350px;
        padding: 35px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
    }
    .login_title {
        margin: 0px auto 20px auto;
        text-align: center;
        color: #505458;
    }
    .regiter-button{
        width:100%;
        margin: 1px auto;
    }
</style>
