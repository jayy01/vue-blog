<template>
  <div class="content">
     <router-link :to="{name: 'BlogDetail',params: {blogId: this.blog.blogId}}">
          <div class="title"><el-link :underline="false" ><h3>{{ this.blog.blogTitle }}</h3></el-link></div>
      </router-link>
     <div class="clear"></div>
     <el-divider></el-divider>
     <p>{{ this.blog.blogContent }}</p>
  </div>
</template>
<script>
export default {
  name: "Blog",
  props:{
　　　blog:{
　　　　type:Object,
　　　　default(){
　　　　　return {}
       }
      }
  },
  data(){
    return {
    }  
  }  
} 
</script>
<style>
  .content {
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    width: 100%;
    height: 200px;
    padding: 2px 10px;
  }
  .buttons {
    float: right;
    height: 11%;
  }
  .title {
    float: left;
    height: 11%;
  }
  .clear {
    clear: both;
  }
  .button {
    padding: 5px;
  }
  .el-button.is-circle {
    border-radius: 50%;
    padding: 4px;
    margin-top: 16px;
    margin-right: 10px;
 }
</style>