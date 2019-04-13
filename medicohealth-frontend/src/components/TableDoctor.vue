<template>
    <div class="cantainer" style="margin:20px 10px 0 10px;" >
        <el-table
            :data="userList.filter(data => !search || data.hospitalName.toLowerCase()
            .includes(search.toLowerCase())).slice((currentPage-1)*pagesize,currentPage*pagesize)"
            style="width: 100%" v-loading="this.loading">
            <el-table-column label="#" prop="doctorId" width="50"></el-table-column>
            <el-table-column label="姓名" prop="doctorName" width="200"></el-table-column>        
            <el-table-column label="联系方式" prop="doctorPhone"></el-table-column> 
            <el-table-column label="所属医院" prop="doctorHospital"></el-table-column>
            <el-table-column label="所属科室" prop="doctorSection"></el-table-column>             
            <el-table-column align="right" width="180">
                <template slot="header" slot-scope="scope">
                <!--
                    <el-input
                    v-model="search"
                    size="mini"
                    placeholder="输入关键字搜索"/>
                    -->
                    <el-button
                    size="mini"
                    @click="handleInsert()">新增</el-button>                        
                </template>
                <template slot-scope="scope">
                    <el-button
                    size="mini"
                    @click="handleEdit(scope.$index, scope.row)">修改</el-button>
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
        <el-dialog title="修改用户信息" :visible.sync="dialogFormVisible">
            <el-form :model="form" :rules="this.rules" ref="form">
                <el-form-item label="姓名" :label-width="formLabelWidth" prop="doctorName">
                    <el-input v-model="form.doctorName" autocomplete="off" placeholder="必填"></el-input>
                </el-form-item>
                <el-form-item label="联系方式" :label-width="formLabelWidth" prop="doctorPhone">
                    <el-input v-model="form.doctorPhone" autocomplete="off" placeholder="必填"></el-input>
                </el-form-item>    
                <el-form-item label="所属医院" :label-width="formLabelWidth" prop="doctorHospital">
                    <el-input v-model="form.doctorHospital" autocomplete="off" placeholder="必填"></el-input>
                </el-form-item>  
                <el-form-item label="所属科室" :label-width="formLabelWidth" prop="doctorSection">
                    <el-input v-model="form.doctorSection" autocomplete="off" placeholder="必填"></el-input>
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
</template>  
<script>
    export default {
    data() {
        return {
                currentPage: 1, //初始页
                pagesize: 10,    //    每页的数据
                userList: [],
                search: '',
                loading: false,
                dialogTableVisible: false,
                dialogFormVisible: false,
                form: {
                    doctorName: '',
                    doctorPhone: '',
                    doctorHospital: '',
                    doctorSection: '',
                },
                formLabelWidth: '120px',
                // mapJson: '@/assets/map.json'
                rules: {
                    name: [
                        {required: true, message: '请输入医院名称', trigger: 'blur'}
                    ],
                    province: [
                        {required: true, message: '请输入医院所在省份', trigger: 'blur'}
                    ],
                    city: [
                        {required: true, message: '请输入医院所在城市', trigger: 'blur'}
                    ],
                    district: [
                        {required: true, message: '请输入医院所在县/区', trigger: 'blur'}
                    ],
                    phone: [
                        {required: true, message: '请输入医院联系电话', trigger: 'blur'}
                    ]
                }                
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
            // this.loading = true;
            let elder = {
              "doctorId": 1,
              "doctorName": "赵启平",
              "doctorPhone": "13678783453",
              "doctorHospital": "南方医院",
              "doctorSection": '全科'
            }
            let elder1 = {
              "doctorId": 2,
              "doctorName": "徐梦摇",
              "doctorPhone": "13680802313",
              "doctorHospital": "南方医院",
              "doctorSection": '全科'
            }            
            this.userList.push(elder)
            this.userList.push(elder1)
            console.log(this.userList)
        },
        handleEdit(index, row) {
            this.form = {
                doctorName: row.doctorName,
                doctorPhone: row.doctorPhone,
                doctorHospital: row.doctorHospital,
                doctorSection: row.doctorSection,        
            }
            this.dialogFormVisible = true;
        },
        handleDelete(index, row) {
            console.log(index, row);
        },
        handleInsert() {
          this.$router.push({name: 'InsertDoctor'})
        }        
    }
}
</script>