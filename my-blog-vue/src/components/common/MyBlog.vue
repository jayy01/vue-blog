<template>
  <div class="content">
     <div class="title"><h3>标题</h3></div>
     <div class="buttons">
       <el-button type="primary" icon="el-icon-edit" circle class="button"></el-button>
       <el-button type="warning" icon="el-icon-star-off" circle class="button"></el-button>
       <el-button type="danger" icon="el-icon-delete" circle class="button"></el-button>
     </div>
     <div class="clear"></div>
     <el-divider></el-divider>
     <p>简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介</p>
  </div>
</template>
<script>
export default {
  name: "Blog"
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