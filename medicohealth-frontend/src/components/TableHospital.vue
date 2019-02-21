<template>
    <div class="cantainer" style="margin:20px 10px 0 10px;" >
        <el-table
            :data="userList.slice((currentPage-1)*pagesize,currentPage*pagesize) || userList.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
            style="width: 100%" v-loading="this.loading">
            <el-table-column label="#" prop="hospitalId" width="50"></el-table-column>
            <el-table-column label="名称" prop="hospitalName" width="200"></el-table-column>
            <el-table-column label="省份" prop="hospitalAddressProvince" width="100"></el-table-column>
            <el-table-column label="城市" prop="hospitalAddressCity"></el-table-column>
            <el-table-column label="区/县" prop="hospitalAddressDistrict"></el-table-column>
            <el-table-column label="街道" prop="hospitalAddressStreet"></el-table-column>             
            <el-table-column label="联系方式" prop="hospitalPhone"></el-table-column> 
            <el-table-column align="right" width="180">
                <template slot="header" slot-scope="scope">
                    <el-input
                    v-model="search"
                    size="mini"
                    placeholder="输入关键字搜索"/>
                </template>
                <template slot-scope="scope">
                    <el-button
                    size="mini"
                    @click="handleEdit(scope.$index, scope.row)">修改</el-button>
                    <el-button
                    size="mini"
                    type="danger"
                    @click="handleDelete(scope.$index, scope.row)">删除</el-button>
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
    </div>
</template>  
<script>
    export default {
    data() {
        return {
                currentPage: 1, //初始页
                pagesize: 10,    //    每页的数据
                userList: [],
                search: '',
                loading: false
            }
    },
    components: {
        
    },
    created() {
        this.handleUserList();
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
        handleUserList() {
            // this.$http.get('http://localhost:3000/userList').then(res => {  //这是从本地请求的数据接口，
            //     this.userList = res.body
            // })
            this.loading = true;
            this.$axios
            .get("http://localhost:8004/hospital/v1/all",
            {
                headers: {
                    "token": sessionStorage.getItem('token')
                }
            })
            .then(response => {
                if(response.data.code == 0) {
                    this.userList = response.data.data;
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
        handleEdit(index, row) {
            this.$prompt('请输入邮箱', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
            inputErrorMessage: '邮箱格式不正确'
            }).then(({ value }) => {
            this.$message({
                type: 'success',
                message: '你的邮箱是: ' + value
            });
            }).catch(() => {
            this.$message({
                type: 'info',
                message: '取消输入'
            });       
            });            
            console.log(index, row);
        },
        handleDelete(index, row) {
            console.log(index, row);
        }        
    }
}
</script>