<!--门诊病历-->
<template>
  <div class="cantainer" style="margin:20px 10px 0 10px;" >
    <el-table
      :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
      style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="患者姓名">
              <span> {{ props.row.username }} </span>
            </el-form-item>
            <el-form-item label="医院">
              <span> {{ props.row.hospitalname }} </span>
            </el-form-item>     
            <el-form-item label="科室">
              <span> {{ props.row.sectionname }} </span>
            </el-form-item>              
            <el-form-item label="主诉">
              <span> {{ props.row.complaint }} </span>
            </el-form-item> 
            <el-form-item label="初步诊断">
              <span> {{ props.row.diagnose }} </span>
            </el-form-item>                         
            <el-form-item label="处理意见">
              <span> {{ props.row.handle }} </span>
            </el-form-item>                  
            <el-form-item label="诊断医师">
              <span> {{ props.row.doctor }} </span>
            </el-form-item>                    
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        label="时间"
        prop="date">
      </el-table-column>      
      <el-table-column
        align="right">
        <template slot="header" slot-scope="scope">      
          <el-button @click="dialogFormVisible = true" size="mini">新增</el-button>
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
            :total="this.tableData.length" style="margin-top: 10px;">   
    </el-pagination>
        <el-dialog title="新增病历信息" :visible.sync="dialogFormVisible">
            <el-form :model="form" :rules="this.rules" ref="form">
                <el-form-item label="患者姓名" :label-width="formLabelWidth" prop="name">
                    <el-input v-model="form.name" autocomplete="off" placeholder="必填"></el-input>
                </el-form-item>
                <el-form-item label="医院" :label-width="formLabelWidth" prop="province">

                    <el-input v-model="form.province" autocomplete="off" placeholder="必填"></el-input>
                    <!--
                    <el-select v-model="province" @change="choseProvince" placeholder="省级地区">
                    -->
                </el-form-item>     
                <el-form-item label="科室" :label-width="formLabelWidth" prop="city">
                    <el-input v-model="form.city" autocomplete="off" placeholder="必填"></el-input>
                </el-form-item>                                               
                <el-form-item label="主诉" :label-width="formLabelWidth" prop="street">
                    <el-input type="textarea" autosize v-model="form.street" autocomplete="off" placeholder="必填"></el-input>
                </el-form-item>        
                <el-form-item label="初步诊断" :label-width="formLabelWidth" prop="phone">
                    <el-input type="textarea" autosize v-model="form.phone" autocomplete="off" placeholder="必填"></el-input>
                </el-form-item>   
                <el-form-item label="处理意见" :label-width="formLabelWidth" prop="hospital">
                    <el-input type="textarea" autosize v-model="form.hospital" autocomplete="off" placeholder="必填"></el-input>
                </el-form-item> 
                <el-form-item label="药品" :label-width="formLabelWidth" prop="hospital">
                    <el-input type="textarea" autosize v-model="form.hospital" autocomplete="off" placeholder="必填"></el-input>
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
        tableData: [
          {
            date: '2019-02-11',
            username: '陈生生',
            hospitalname: '广州南方医院',
            sectionname: '全科',
            complaint: '流鼻涕三到五天，伴头晕，恶心等症状，无不良饮食，一周前曾有剧烈的户外活动。',
            diagnose: '因暴晒引起的中暑症状，发烧。',
            handle: '注意防晒，先吃发烧药，如反复，可进行物理降温。',
            doctor: '方世玉'
          },
          {
            date: '2018-04-15',
            username: '陈生生',
            hospitalname: '广州南方医院',
            sectionname: '全科',
            complaint: '头晕，流鼻涕2天，今晨起因挤痘痘后出现眼前发黑，晕厥，持续几秒后自行缓解。',
            diagnose: '人浮肿，神经系统检查未发现异常，血糖偏低。',
            handle: '起床后血糖偏低，小心剧烈运动',
            doctor: '方世玉'
          }          
        ],
        search: '',
        dialogFormVisible: false,
        form: {

        }
      }
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      }
    },    
}
</script>
<style>
  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>