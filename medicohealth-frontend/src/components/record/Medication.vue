<!--用药记录-->
<template>
  <div class="cantainer" style="margin:20px 10px 0 10px;" >
    <el-table
      :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
      style="width: 100%">
      <el-table-column
        label="时间"
        prop="time">
      </el-table-column>      
      <el-table-column
        label="用药记录"
        prop="record">
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
            time: "2019-02-11",
            record: '退烧药 5片；退烧贴 2张 外用；板蓝根 15 片；'
          },
          {
            time: '2018-04-15',
            record: '头孢 0.25；百多邦 1支 外用；'
          }
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