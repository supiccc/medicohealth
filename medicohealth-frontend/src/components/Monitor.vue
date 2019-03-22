<template>
    <div>
      <el-tabs v-model="activeName">
        <el-tab-pane label="健康状态" name="first">
          <el-row>
            <el-col :span="8">
              <el-card class="box-card">
                <div slot="header" class="clearfix">
                  <span>血压(mmHg)</span>
                  <el-button style="float: right; padding: 3px 0" type="text">更新</el-button>
                </div>
                <div class="text item">
                  {{'时间: ' + this.LastestBloodPressure.bloodPressureCreateTime}}
                </div>
                <div class="text item">
                  {{'舒张压: ' + this.LastestBloodPressure.diastolic }}
                </div>
                <div class="text item">
                  {{'收缩压: ' + this.LastestBloodPressure.shrink }}
                </div>
                <div class="text item">
                  {{'脉搏: ' + this.LastestBloodPressure.pulse }}
                </div>                                      
              </el-card>          
            </el-col>
            <el-col :span="8">
              <el-card class="box-card">
                <div slot="header" class="clearfix">
                  <span>血糖(mmol/L)</span>
                  <el-button style="float: right; padding: 3px 0" type="text">更新</el-button>
                </div>
                <div class="text item">
                  {{'时间: ' + this.LastestBloodSugar.bloodSugarCreateTime}}
                </div>
                <div class="text item">
                  {{'血糖值: ' + this.LastestBloodSugar.sugar}}
                </div>
              </el-card>          
            </el-col>
            <el-col :span="8">
              <el-card class="box-card">
                <div slot="header" class="clearfix">
                  <span>血氧</span>
                  <el-button style="float: right; padding: 3px 0" type="text">更新</el-button>
                </div>
                <div class="text item">
                  {{'时间: ' + this.LastestBloodOxygen.bloodOxygenCreateTime}}
                </div> 
                <div class="text item">
                  {{'血氧值: ' + this.LastestBloodOxygen.oxygen}}
                </div>             
              </el-card>          
            </el-col>        
          </el-row>   
          <el-row>
            <el-col :span="8">
              <el-card class="box-card">
                <div slot="header" class="clearfix">
                  <span>身高体重</span>
                  <el-button style="float: right; padding: 3px 0" type="text">更新</el-button>
                </div>
                <div class="text item">
                  {{'时间: ' + this.LastestHeightWeight.heightWeightCreateTime}}
                </div>
                <div class="text item">
                  {{'身高: ' + this.LastestHeightWeight.height}}
                </div>
                <div class="text item">
                  {{'体重: ' + this.LastestHeightWeight.weight}}
                </div>
                <div class="text item">
                  {{'BMI: ' + this.LastestHeightWeight.BMI}}
                </div>                                      
              </el-card>          
            </el-col>
            <el-col :span="8">
              <el-card class="box-card">
                <div slot="header" class="clearfix">
                  <span>脂肪</span>
                  <el-button style="float: right; padding: 3px 0" type="text">更新</el-button>
                </div>
                <div class="text item">
                  {{'时间: ' + this.LastestFat.fatCreateTime}}
                </div>
                <div class="text item">
                  {{'脂肪: ' + this.LastestFat.fat}}
                </div>
                <div class="text item">
                  {{'基础代谢率: ' + this.LastestFat.metabolicRate}}
                </div>
                <div class="text item">
                  {{'水分含量: ' + this.LastestFat.moistureContent}}
                </div>  
              </el-card>          
            </el-col>
            <el-col :span="8">
              <el-card class="box-card">
                <div slot="header" class="clearfix">
                  <span>胆固醇</span>
                  <el-button style="float: right; padding: 3px 0" type="text">更新</el-button>
                </div>
                <div class="text item">
                  {{'时间: ' + this.LastestCholesterol.cholesterolCreateTime}}
                </div>
                <div class="text item">
                  {{'胆固醇值: ' + this.LastestCholesterol.cholesterol}}
                </div>            
              </el-card>          
            </el-col>        
          </el-row>   
          <el-row>
            <el-col :span="8">
              <el-card class="box-card">
                <div slot="header" class="clearfix">
                  <span>尿酸</span>
                  <el-button style="float: right; padding: 3px 0" type="text">更新</el-button>
                </div>
                <div class="text item">
                  {{'时间: ' + this.LastestUridAcid.uridAcidCreateTime}}
                </div>
                <div class="text item">
                  {{'尿酸值: ' + this.LastestUridAcid.uridAcid}}
                </div>                                     
              </el-card>          
            </el-col>     
          </el-row>            
        </el-tab-pane>
        <el-tab-pane label="预警信息" name="second">

          <div class="cantainer" style="margin:20px 10px 0 10px;" >
              <el-table
                  :data="userList.filter(data => !search || data.hospitalName.toLowerCase()
                  .includes(search.toLowerCase())).slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  style="width: 100%" v-loading="this.loading">
                  <el-table-column label="#" prop="hospitalId" width="50"></el-table-column>
                  <el-table-column label="名称" prop="hospitalName" width="200"></el-table-column>
                  <el-table-column label="省份" prop="hospitalAddressProvince" width="100"></el-table-column>
                  <el-table-column label="城市" prop="hospitalAddressCity"></el-table-column>
                  <el-table-column label="区/县" prop="hospitalAddressDistrict"></el-table-column>
                  <el-table-column label="街道" prop="hospitalAddressStreet"></el-table-column>             
                  <el-table-column label="联系方式" prop="hospitalPhone"></el-table-column> 
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
        </el-tab-pane>
      </el-tabs>          
    </div>
</template>

<script>
import {mapGetters} from 'vuex'
export default {
  name: 'Monitor',
  props: {
    msg: String
  },
  data() {
    return {
      activeName: 'first',
      LastestBloodPressure: {
        bloodPressureId: "正在加载数据",
        diastolic: "正在加载数据",
        shrink: "正在加载数据",
        pulse: "正在加载数据",
        bloodPressureCreateTime: "正在加载数据"
      },
      LastestBloodOxygen: {
        bloodOxygenId: "正在加载数据",
        oxygen: "正在加载数据",
        bloodOxygenCreateTime: "正在加载数据"
      },
      LastestBloodSugar: {
        bloodSugarId: "正在加载数据",
        sugar: "正在加载数据",
        bloodSugarCreateTime: "正在加载数据"
      },
      //胆固醇
      LastestCholesterol: {
        cholesterolId: "正在加载数据",
        cholesterol: "正在加载数据",
        cholesterolCreateTime: "正在加载数据"
      },
      //脂肪
      LastestFat: {
        fatId: "正在加载数据",
        fat: "正在加载数据",
        //代谢率
        metabolicRate: "正在加载数据",
        //水分
        moistureContent: "正在加载数据",
        fatCreateTime: "正在加载数据"
      },
      LastestHeightWeight: {
        heightWeightId: "正在加载数据",
        height: "正在加载数据",
        weight: "正在加载数据",
        heightWeightCreateTime: "正在加载数据",
        BMI: "正在加载数据"
      },
      //尿酸
      LastestUridAcid: {
        uridAcidId: "正在加载数据",
        uridAcid: "正在加载数据",
        uridAcidCreateTime: "正在加载数据"
      },
      currentPage: 1, //初始页
      pagesize: 10,    //    每页的数据
      userList: [],
      search: '',
      loading: false,
      form: {
          name: '',
          province: '',
          city: '',
          district: '',
          street: '',
          phone: ''
      },
      formLabelWidth: '120px',
      // mapJson: '@/assets/map.json'    
    }
  },
  computed: {
    ...mapGetters(['getToken', 'getUserId'])
  },  
  mounted() {
      this.$axios
        .get('http://localhost:8004/monitor/v1/LastestBloodPressure',
          {
            params: {
              'id': this.getUserId,
            }
          }, 
          {
            headers: {
              'token': this.getToken
            }
        })
        .then(response => {
          if(response.data.code == 0  && response.data.data != null) {
            this.LastestBloodPressure.bloodPressureId = response.data.data.bloodPressureId
            this.LastestBloodPressure.diastolic = response.data.data.diastolic
            this.LastestBloodPressure.shrink = response.data.data.shrink
            this.LastestBloodPressure.pulse = response.data.data.pulse
            this.LastestBloodPressure.bloodPressureCreateTime = response.data.data.bloodPressureCreateTime
          } else {
            this.LastestBloodPressure.bloodPressureId = "暂无最新数据"
            this.LastestBloodPressure.diastolic = "暂无最新数据"
            this.LastestBloodPressure.shrink = "暂无最新数据"
            this.LastestBloodPressure.pulse = "暂无最新数据"
            this.LastestBloodPressure.bloodPressureCreateTime = "暂无最新数据"
          }
        })
        .catch(error => console.log(error)) 

      this.$axios
        .get('http://localhost:8004/monitor/v1/LastestBloodOxygen',
          {
            params: {
              'id': this.getUserId,
            }
          }, 
          {
            headers: {
              'token': this.getToken
            }
        })
        .then(response => {
          if(response.data.code == 0  && response.data.data != null) {
            this.LastestBloodOxygen.bloodOxygenId = response.data.data.bloodOxygenId
            this.LastestBloodOxygen.oxygen = response.data.data.bloodOxygenValue
            this.LastestBloodOxygen.bloodOxygenCreateTime = response.data.data.bloodOxygenCreateTime

          } else {
            this.LastestBloodOxygen.bloodOxygenId = "暂无最新数据"
            this.LastestBloodOxygen.oxygen = "暂无最新数据"
            this.LastestBloodOxygen.bloodOxygenCreateTime = "暂无最新数据"
          }
        })
        .catch(error => console.log(error)) 

        this.$axios
        .get('http://localhost:8004/monitor/v1/LatestBloodSugar',
          {
            params: {
              'id': this.getUserId,
            }
          }, 
          {
            headers: {
              'token': this.getToken
            }
        })
        .then(response => {
          if(response.data.code == 0 && response.data.data != null) {
            // console.log(response.data.data)
            this.LastestBloodSugar.bloodSugarId = response.data.data.bloodSugarId
            this.LastestBloodSugar.sugar = response.data.data.bloodSugarvalue
            this.LastestBloodSugar.bloodSugarCreateTime = response.data.data.bloodSugarCreateTime              
          } else {
            this.LastestBloodSugar.bloodSugarId = "暂无最新数据"
            this.LastestBloodSugar.sugar = "暂无最新数据"
            this.LastestBloodSugar.bloodSugarCreateTime = "暂无最新数据"
          }
        })
        .catch(error => console.log(error))         

        this.$axios
        .get('http://localhost:8004/monitor/v1/LatestFat',
          {
            params: {
              'id': this.getUserId,
            }
          }, 
          {
            headers: {
              'token': this.getToken
            }
        })
        .then(response => {
          if(response.data.code == 0 && response.data.data != null) {
            this.LastestFat.fatId = response.data.data.fatId
            this.LastestFat.fat = response.data.data.fatValue
            this.LastestFat.fatCreateTime = response.data.data.fatCreateTime
            this.LastestFat.moistureContent = response.data.data.fatMoistureContent
            this.LastestFat.metabolicRate = response.data.data.fatMetabolicRate
          } else {
            this.LastestFat.fatId = "暂无最新数据"
            this.LastestFat.fat = "暂无最新数据"
            this.LastestFat.fatCreateTime = "暂无最新数据"
            this.LastestFat.moistureContent = "暂无最新数据"
            this.LastestFat.metabolicRate = "暂无最新数据"            
          }
        })
        .catch(error => console.log(error))         

        this.$axios
        .get('http://localhost:8004/monitor/v1/LatestHeightWeight',
          {
            params: {
              'id': this.getUserId,
            }
          }, 
          {
            headers: {
              'token': this.getToken
            }
        })
        .then(response => {
          if(response.data.code == 0 && response.data.data != null) {
            this.LastestHeightWeight.heightWeightId = response.data.data.heightWeightId
            this.LastestHeightWeight.height = response.data.data.height
            this.LastestHeightWeight.weight = response.data.data.weight
            this.LastestHeightWeight.heightWeightCreateTime = response.data.data.heightWeightCreateTime
            this.LastestHeightWeight.BMI = (response.data.data.weight / (response.data.data.height/100 * response.data.data.height/100)).toFixed(2)

          } else {
            this.LastestHeightWeight.heightWeightId = "暂无最新数据"
            this.LastestHeightWeight.height = "暂无最新数据"
            this.LastestHeightWeight.weight = "暂无最新数据"
            this.LastestHeightWeight.heightWeightCreateTime = "暂无最新数据"    
            this.LastestHeightWeight.BMI = "暂无最新数据"     
          }
        })
        .catch(error => console.log(error))         

        this.$axios
        .get('http://localhost:8004/monitor/v1/LatestUricAcid',
          {
            params: {
              'id': this.getUserId,
            }
          }, 
          {
            headers: {
              'token': this.getToken
            }
        })
        .then(response => {
          if(response.data.code == 0 && response.data.data != null) {
            this.LastestUridAcid.uridAcidId = response.data.data.uricAcidId
            this.LastestUridAcid.uridAcid = response.data.data.uricAcidValue
            this.LastestUridAcid.uridAcidCreateTime = response.data.data.uricAcidCreateTime

          } else {
            this.LastestUridAcid.uridAcidId = "暂无最新数据"
            this.LastestUridAcid.uridAcid = "暂无最新数据"
            this.LastestUridAcid.uridAcidCreateTime = "暂无最新数据"
          }
        })
        .catch(error => console.log(error))         
        
        this.$axios
        .get('http://localhost:8004/monitor/v1/LatestCholesterol',
          {
            params: {
              'id': this.getUserId,
            }
          }, 
          {
            headers: {
              'token': this.getToken
            }
        })
        .then(response => {
          if(response.data.code == 0 && response.data.data != null) {
            this.LastestCholesterol.cholesterolId = response.data.data.cholesterolId
            this.LastestCholesterol.cholesterol = response.data.data.cholesterolValue
            this.LastestCholesterol.cholesterolCreateTime = response.data.data.cholesterolCreateTime

          } else {
            this.LastestCholesterol.cholesterolId = "暂无最新数据"
            this.LastestCholesterol.cholesterol = "暂无最新数据"
            this.LastestCholesterol.cholesterolCreateTime = "暂无最新数据"
          }
        })
        .catch(error => console.log(error))            
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
  .text {
    font-size: 14px;
  }

  .item {
    margin: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    margin: 10px 10px 10px 10px;
  }

  .el-tabs__nav-scroll {
    margin-left: 15px;
  }
</style>