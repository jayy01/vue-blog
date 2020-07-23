<template>
    <div>
        <Header></Header>
        <div class="content">
          <h4>请编辑文档</h4>
          <el-form :model="blogForm" :rules="rules" ref="blogForm" label-width="100px" class="demo-ruleForm">
                  <el-form-item label="标题" prop="blogTitle">
                    <el-input v-model="blogForm.blogTitle"></el-input>
                  </el-form-item>
                  <el-form-item label="类型" prop="blogType" class="floatShow">
                    <el-select v-model="blogForm.blogType" placeholder="请选择文档类型">
                      <el-option label="类型一" value="1"></el-option>
                      <el-option label="类型二" value="2"></el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item label="图片"  prop="blogImage" class="floatShow image">
                    <el-upload
                      class="avatar-uploader"
                      action="https://jsonplaceholder.typicode.com/posts/"
                      :show-file-list="false"
                      :on-success="handleAvatarSuccess"
                      :before-upload="beforeAvatarUpload">
                      <img v-if="blogForm.blogImage" :src="blogForm.blogImage" class="avatar">
                      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                  </el-form-item>
                  <div class="clear"></div>
                  <el-form-item label="简介" prop="blogRemark">
                    <el-input type="textarea" v-model="blogForm.blogRemark"></el-input>
                  </el-form-item>
                  <el-form-item label="内容" prop="content">
                    <mavon-editor v-model="blogForm.content"/>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" @click="submitForm('blogForm')">立即创建</el-button>
                    <el-button @click="resetForm('blogForm')">重置</el-button>
                  </el-form-item>
                </el-form>
        </div>
        <Footer></Footer>
    </div>
</template>
<script>
import Header from '../common/Header'
import Footer from '../common/Footer'
export default {
  name: 'BlogEdit',
  components: {Header,Footer},
  data() {
      return {
        blogForm: {
          blogTitle: '',
          blogImage: '',
          blogContent: '',
          blogType: '',
          blogRemark: ''
        },
        rules: {
          blogTitle: [
            { required: true, message: '请输入标题', trigger: 'blur' },
            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          blogType: [
            { required: true, message: '请选择类型', trigger: 'blur' }
          ],
          blogRemark: [
            { required: true, message: '请填写文档简介', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      handleAvatarSuccess(res, file) {
        this.blogForm.blogImage = URL.createObjectURL(file.raw);
      },
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
}
</script>
<style>
  .content {
    width: 80%;
    margin: 50px auto;
    text-align: center;
  }
  .floatShow {
    float: left;
    margin-right: 200px;
  }
  .clear {
    clear: both;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 100px;
    height: 100px;
    line-height: 100px;
    text-align: center;
  }
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>