<!--药物过敏-->
<template>
  <div class="cantainer" style="margin:20px 10px 0 10px;" >
    <el-table
      :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
      style="width: 100%">
      <el-table-column
        label="过敏药物"
        prop="name">
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
            name: '青霉素'
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