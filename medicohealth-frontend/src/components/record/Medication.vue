<!--用药记录-->
<template>
  <div class="cantainer" style="margin:20px 10px 0 10px;" >
    <el-table
      :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
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
  </div>

</template>
<script>
export default {
    data() {
      return {
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