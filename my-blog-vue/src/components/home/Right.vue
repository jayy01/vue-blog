<template>
    <div>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>分类</span>
          </div>
          <div>
            <el-tag class="categroy" v-for="type in typeList">
              <router-link :to="{name: 'Blogs',params: {typeId: type.typeId}}">
                {{type.typeName}}
              </router-link>
            </el-tag>
          </div>
        </el-card>
    </div>
</template>
<script>
export default {
    name: "Right",
    props: {
      typeList: {
        type: Object,
        default(){
          return {}
        }
      }
    },
    data(){
      return{}
    },
    methods: {
      
    }
}
</script>
<style>
    .categroy{
        margin-bottom: 4px;
        margin-right: 3px;
    }

</style>