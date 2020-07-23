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
                <h3>{{this.blog.blogTitle}}</h3>
                <el-divider></el-divider>
                <p>{{this.blog.blogContent}}</p>
              </div>
            </el-col>
            <el-col :span="6">
              <div class="grid-content">
                <Right></Right>
              </div>
            </el-col>
          </el-row>
        </div>
        <Footer></Footer>
    </div>
</template>
<script>
import Left from '../home/Left'
import Right from '../home/Right'
import Header from '../common/Header'
import Footer from '../common/Footer'
import Blog from '../common/Blog'
export default {
  name: 'BlogDetails',
  components: {Left,Right,Header,Footer,Blog},
  data() {
      return {
        blog: {
          blogTitle: '',
          blogImage: '',
          blogContent: '',
          blogType: '',
          blogRemark: ''
        }
      }
    },
  methods: {
      getBlog() {
        console.log(this.$route)
        const blogId = this.$route.params.blogId
        const _this = this
        this.$axios.get('/blog/' + blogId).then((res) => {
          console.log(res)
          console.log(res.data.data)
          _this.blog = res.data.data
          //var MarkdownIt = require('markdown-it'),
          //md = new MarkdownIt();
          //var result = md.render(_this.blog.content);
          //_this.blog.content = result          
        });
      }
    },
  created() {
      this.getBlog()
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