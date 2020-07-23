<template>
  <div class="footer">
      <el-row>
        <el-col :span="8"><div class="links">友情链接</div></el-col>
        <el-col :span="8"><div class="links">友情链接</div></el-col>
        <el-col :span="8"><div class="links">友情链接</div></el-col>
      </el-row>
      <p>Copyright © 2020 by jayy</p>
  </div>
</template>
<script>
export default {
  name: "Footer"
}
</script>
<style>
  .footer{
    margin-top: 2%;
    padding: 20px 10px;
    text-align: center;
    background: silver;
    height: 120px;
  }
  
</style>