<template>
  <div class="WarningHandler">
          <div class="cantainer" style="margin:20px 10px 0 10px;" >
            <el-table
                :data="userList.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                style="width: 100%" v-loading="this.loading">
                <el-table-column label="预警类型" prop="type" width="100"></el-table-column>
                <el-table-column label="预警内容" prop="content"></el-table-column>
                <el-table-column label="预警时间" prop="time" width="100"></el-table-column>   
                <el-table-column label="姓名" prop="name" width="100"></el-table-column>                     
                <el-table-column label="状态" prop="state" width="100"></el-table-column>                    
                <el-table-column align="right" width="180">
                    <template slot-scope="scope">
                        <el-button
                        size="mini"
                        @click="handleEdit(scope.$index, scope.row)">处理</el-button>
                        <!--
                        <el-button
                        size="mini"
                        type="danger"
                        @click="handleDelete(scope.$index, scope.row)">禁用</el-button>
                        -->
                    </template>
                </el-table-column>                                 
            </el-table>             
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="currentPage"
                    :page-sizes="[5, 10, 20, 40]"
                    :page-size="pagesize"        
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="this.userList.length" style="margin-top: 10px;">   
            </el-pagination>
            <el-dialog title="处理预警信息" :visible.sync="dialogFormVisible">
                <el-form :model="form" ref="form">
                    <el-form-item>
                        <p style="float: left">收件人：{{ this.form.name }}</p>
                    </el-form-item>   
                    <el-form-item label="处理意见" :label-width="formLabelWidth" prop="content">
                        <el-input type="textarea" autosize v-model="form.content" autocomplete="off" placeholder="必填"></el-input>
                    </el-form-item>                                    
                    <!--
                    <el-form-item label="活动区域" :label-width="formLabelWidth">
                    <el-select v-model="form.region" placeholder="请选择活动区域">
                        <el-option label="区域一" value="shanghai"></el-option>
                        <el-option label="区域二" value="beijing"></el-option>
                    </el-select>
                    </el-form-item>
                    -->
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogFormVisible = false">取 消</el-button>
                    <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
                </div>
            </el-dialog>              
          </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'
export default {
  name: 'WarningHandler',
  props: {
    msg: String
  },
  data() {
      return {
        currentPage: 1, //初始页
        pagesize: 10,    //    每页的数据
        userList: [],  
        loading: false,
        dialogTableVisible: false,
        dialogFormVisible: false,          
        form: {
            name: '',
            content: ''
        },              
      }
  },
  methods: {
    // 初始页currentPage、初始每页数据数pagesize和数据data
    handleSizeChange: function (size) {
            this.pagesize = size;
            console.log(this.pagesize)  //每页下拉显示数据
    },
    handleCurrentChange: function(currentPage){
            this.currentPage = currentPage;
            console.log(this.currentPage)  //点击第几页

    }, 
    handleEdit(index, row) {
        this.form = {
            name: row.name,              
        }
        this.dialogFormVisible = true;
    },           
  },
  mounted() {
        // this.$http.get('http://localhost:3000/userList').then(res => {  //这是从本地请求的数据接口，
        //     this.userList = res.body
        // })
        this.loading = true;
        this.$axios
        .get("http://localhost:8004/monitor/v1/get/warnings",
        {
            headers: {
                "token": sessionStorage.getItem('token')
            }
        })
        .then(response => {
            if(response.data.code == 0) {
                this.userList = response.data.data;
                for(let user in this.userList) {
                    // console.log(this.userList[user])
                    this.userList[user].name = "陈生"
                    this.userList[user].state = (this.userList[user].state == '0' ? "未处理" : "已处理")
                }               
                this.loading = false;
            } else if(response.data.code == 1) {
                this.$message.warning("服务器内部错误")
                this.$router.push({name: '/'})
            } else {
                this.$message.warning("未授权，请登陆授权后继续")
                this.$router.push({name: '/login'})
            }
        })      
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
