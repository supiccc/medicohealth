<!--住院病历-->
<!--门诊病历-->
<template>
  <div class="cantainer" style="margin:20px 10px 0 10px;" >
    <el-table
      :data= "tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
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
            <el-form-item label="住院号">
              <span> {{ props.row.inpatient }} </span>
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
          <el-button size="mini">新增</el-button>
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
            date: '2017-02-11',
            username: '陈生生',
            hospitalname: '广州南方医院',
            sectionname: '皮肤科',
            complaint: '手术部位瘙痒。',
            diagnose: '术后恢复期正常现象。',
            handle: '注意术后防晒，擦青霉素，不要沾水。',
            doctor: '林生',
            inpatient: '10-123'
          },         
        ],
        search: ''
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