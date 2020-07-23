<template>
    <div>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <el-calendar v-model="value"></el-calendar>
          </div>
        </el-card>
    </div>
</template>
<script>
export default {
  name: 'Left',
  data() {
    return {
      value: new Date()
    }
  }
}
</script>
<style>
.text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix{
    zoom: 0.3;
  }
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 300px;
  }
</style>