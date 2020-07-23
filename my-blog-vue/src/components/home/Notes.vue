<template>
    <div>
        <Header>111</Header>
        <div class="all">
          <el-row :gutter="20">
            <el-col :span="6">
              <div class="grid-content">
                <Left></Left>
              </div>
            </el-col>
            <el-col :span="12">
              <div class="grid-content">
                <Blog v-for="blog in blogs" :blog='blog'></Blog>
                <!--分页-->
                <div class="paging">
                  <el-pagination
                    background
                    layout="prev, pager, next"
                    :current-page="currentPage"
                    :page-size="pageSize"
                    :total="total"
                    @current-change=pageQuery>
                  </el-pagination>
                </div>
              </div>
            </el-col>
            <el-col :span="6">
              <div class="grid-content">
                <Right :typeList='typeList'></Right>
              </div>
            </el-col>
          </el-row>
        </div>
        <Footer></Footer>
    </div>
</template>
<script>
import Left from './Left'
import Right from './Right'
import Header from '../common/Header'
import Footer from '../common/Footer'
import Blog from '../common/Blog'
export default {
  name: 'Notes',
  components: {Left,Right,Header,Footer,Blog},
  data() {
    return {
      blogs: {},
      typeList: {},
      currentPage: 1,
      total: 0,
      pageSize: 5,
      userId: ''
    }
  },
  methods: {
    pageQuery(currentPage) {
      const _this = this
      if(this.$store.getters.getUser){
        this.userId = this.$store.getters.getUser.userId
      }

      this.$axios
        .post('/myblogs',{
          currentPage: currentPage,
          size: this.pageSize,
          author: this.userId
        })
        .then((res)=>{
          _this.blogs = res.data.data.blog
          _this.currentPage = res.data.data.currentPage
          _this.pageSize = res.data.data.size
          _this.total = res.data.data.totalSize
        })
    },
    typeQuery(){
      const _this = this
      this.$axios
        .get('/types')
        .then((res) => {
          _this.typeList = res.data.data
        })
    }
  },
  mounted () {
    this.pageQuery(1)
    this.typeQuery()
  }
}
</script>
<style>
   .el-row {
    margin-bottom: 20px;
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
    margin: 0 10px;
  }
  .row-bg {
    padding: 10px 0;  
    background-color: #f9fafc;
  }
  .all {
    margin: 10px 5px;
  }
  .paging {
    margin: 5px auto;
    text-align: center;
  }
</style>