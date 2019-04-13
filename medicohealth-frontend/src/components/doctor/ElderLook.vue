<template>
    <div class="cantainer" style="margin:20px 10px 0 10px;" >
        <el-table
            :data="userList.filter(data => !search || data.hospitalName.toLowerCase()
            .includes(search.toLowerCase())).slice((currentPage-1)*pagesize,currentPage*pagesize)"
            style="width: 100%" v-loading="this.loading">
            <el-table-column label="#" prop="elderId" width="50"></el-table-column>
            <el-table-column label="姓名" prop="elderName" width="200"></el-table-column>
            <el-table-column label="省份" prop="elderAddressProvince" width="100"></el-table-column>
            <el-table-column label="城市" prop="elderAddressCity"></el-table-column>
            <el-table-column label="区/县" prop="elderAddressDistrict"></el-table-column>
            <el-table-column label="街道" prop="elderAddressStreet"></el-table-column>             
            <el-table-column label="联系方式" prop="elderPhone"></el-table-column>        
            <el-table-column align="right" width="180">
                <template slot="header" slot-scope="scope">
                <!--
                    <el-input
                    v-model="search"
                    size="mini"
                    placeholder="输入关键字搜索"/>
                    <el-button
                    size="mini"
                    @click="handleEdit(scope.$index, scope.row)">新增</el-button>                       
                    -->
                </template>
                <template slot-scope="scope">
                    <!--
                    <el-button
                    size="mini"
                    @click="handleEdit(scope.$index, scope.row)">修改</el-button>                        
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
        <el-dialog title="修改老人信息" :visible.sync="dialogFormVisible">
            <el-form :model="form" :rules="this.rules" ref="form">
                <el-form-item label="姓名" :label-width="formLabelWidth" prop="name">
                    <el-input v-model="form.name" autocomplete="off" placeholder="必填"></el-input>
                </el-form-item>
                <el-form-item label="省份" :label-width="formLabelWidth" prop="province">

                    <el-input v-model="form.province" autocomplete="off" placeholder="必填"></el-input>
                    <!--
                    <el-select v-model="province" @change="choseProvince" placeholder="省级地区">
                    -->
                </el-form-item>     
                <el-form-item label="城市" :label-width="formLabelWidth" prop="city">
                    <el-input v-model="form.city" autocomplete="off" placeholder="必填"></el-input>
                </el-form-item>      
                <el-form-item label="区/县" :label-width="formLabelWidth" prop="district">
                    <el-input v-model="form.district" autocomplete="off" placeholder="必填"></el-input>
                </el-form-item>                                                 
                <el-form-item label="街道" :label-width="formLabelWidth" prop="street">
                    <el-input v-model="form.street" autocomplete="off" placeholder="必填"></el-input>
                </el-form-item>        
                <el-form-item label="联系方式" :label-width="formLabelWidth" prop="phone">
                    <el-input v-model="form.phone" autocomplete="off" placeholder="必填"></el-input>
                </el-form-item>   
                <el-form-item label="所属医院" :label-width="formLabelWidth" prop="hospital">
                    <el-input v-model="form.hospital" autocomplete="off" placeholder="必填"></el-input>
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
                    name: '',
                    province: '',
                    city: '',
                    district: '',
                    street: '',
                    phone: '',
                    hospital: ''
                },
                formLabelWidth: '120px',
                // mapJson: '@/assets/map.json'
                rules: {
                    name: [
                        {required: true, message: '请输入姓名', trigger: 'blur'}
                    ],
                    province: [
                        {required: true, message: '请输入用户所在省份', trigger: 'blur'}
                    ],
                    city: [
                        {required: true, message: '请输入用户所在城市', trigger: 'blur'}
                    ],
                    district: [
                        {required: true, message: '请输入用户所在县/区', trigger: 'blur'}
                    ],
                    phone: [
                        {required: true, message: '请输入用户联系电话', trigger: 'blur'}
                    ],
                    hospital: [
                        {required: true, message: '请输入用户所属医院', trigger: 'blur'}
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
              "elderId": 1,
              "elderName": "陈生",
              "elderAddressProvince": "广东省",
              "elderAddressCity": '广州市',
              "elderAddressDistrict": "天河区",
              "elderAddressStreet": "五山街道",
              "elderPhone": "13789872332",
              "elderHospital": "南方医院"
            }
            this.userList.push(elder)
            console.log(this.userList)
        },
        handleEdit(index, row) {
            this.form = {
                name: row.elderName,
                province: row.elderAddressProvince,
                city: row.elderAddressCity,
                district: row.elderAddressDistrict,
                street: row.elderAddressStreet,
                phone: row.elderPhone,
                hospital: row.elderHospital                
            }
            this.dialogFormVisible = true;
        },
        handleDelete(index, row) {
            console.log(index, row);
        }        
    }
}
</script>