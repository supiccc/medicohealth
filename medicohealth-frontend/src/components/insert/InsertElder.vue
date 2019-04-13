<template>
    <div style="margin: 20px;">
        <el-collapse v-model="activeNames">
            <el-collapse-item title="机密信息" name="3">
                <div class="container">
                    <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">    
                        <el-form-item label="用户">
                            <el-input v-model="formLabelAlign.region"></el-input>
                        </el-form-item>
                        <el-form-item label="密码">
                            <el-input v-model="formLabelAlign.region"></el-input>
                        </el-form-item>                        
                        <el-form-item label="确认密码">
                            <el-input v-model="formLabelAlign.type"></el-input>
                        </el-form-item>               
                    </el-form>                 
                </div>     
            </el-collapse-item>           
            <el-collapse-item title="基本信息" name="1">
            <div class="container">
                <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">
                    <el-form-item label="头像">
                        <el-upload
                        class="avatar-uploader"
                        action="https://jsonplaceholder.typicode.com/posts/"
                        :show-file-list="false"
                        :on-success="handleAvatarSuccess"
                        :before-upload="beforeAvatarUpload">
                        <img v-if="imageUrl" :src="imageUrl" class="avatar">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                        </el-upload>
                    </el-form-item>
                    <el-form-item label="姓名">
                        <el-input v-model="formLabelAlign.name"></el-input>
                    </el-form-item>
                    <el-form-item label="联系方式">
                        <el-input v-model="formLabelAlign.phone"></el-input>
                    </el-form-item>                
                    <el-form-item label="国家">
                        <el-input v-model="formLabelAlign.name"></el-input>
                    </el-form-item>
                    <el-form-item label="省份">
                        <el-input v-model="formLabelAlign.name"></el-input>
                    </el-form-item>     
                    <el-form-item label="城市">
                        <el-input v-model="formLabelAlign.name"></el-input>
                    </el-form-item> 
                    <el-form-item label="地区">
                        <el-input v-model="formLabelAlign.name"></el-input>
                    </el-form-item>  
                    <el-form-item label="街道">
                        <el-input v-model="formLabelAlign.name"></el-input>
                    </el-form-item> 
                    <el-form-item label="门牌">
                        <el-input v-model="formLabelAlign.name"></el-input>
                    </el-form-item>
                    <el-form-item label="所属医院">
                        <el-select v-model="value" placeholder="请选择" style="width:100%;">
                            <el-option
                            v-for="item in options"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                            </el-option>
                        </el-select>                        
                    </el-form-item>                                   
                </el-form>             
            </div>
              
            </el-collapse-item>
            <el-collapse-item title="紧急联系人信息" name="2">
                <div class="container">
                    <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">    
                        <el-form-item label="姓名">
                            <el-input v-model="formLabelAlign.region"></el-input>
                        </el-form-item>
                        <el-form-item label="联系方式">
                            <el-input v-model="formLabelAlign.region"></el-input>
                        </el-form-item>                        
                        <el-form-item label="邮箱">
                            <el-input v-model="formLabelAlign.type"></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary">提交</el-button>
                        </el-form-item>                   
                    </el-form>                 
                </div>     
            </el-collapse-item>                       
        </el-collapse>
    </div>
</template>

<script>
// @ is an alias to /src
import {mapGetters} from 'vuex'

export default {
  data() {
    return {
        labelPosition: 'right',
        formLabelAlign: {
          name: '',
          region: '',
          type: ''
        },
        activeNames: ['3'],
        imageUrl: '',
        options: [{
          value: '选项1',
          label: '黄金糕'
        }, {
          value: '选项2',
          label: '双皮奶'
        }, {
          value: '选项3',
          label: '蚵仔煎'
        }, {
          value: '选项4',
          label: '龙须面'
        }, {
          value: '选项5',
          label: '北京烤鸭'
        }],
        value: ''        
    }
  },
  computed: {
    ...mapGetters(['getUser', 'isLogin', 'getRole', 'getToken', 'getUserId'])
  },
  components: {

  },
  mounted() {

  },
  methods: {
    handleAvatarSuccess(res, file) {
    this.imageUrl = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload(file) {
    const isJPG = file.type === 'image/jpeg';
    const isLt2M = file.size / 1024 / 1024 < 2;

    if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
    }
    if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
    }
    return isJPG && isLt2M;
    }      
  },
}
</script>

<style>
  .text {
    font-size: 14px;
  }

  .time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .pie-chart-holder, .line-chart-holder {
    height: 30vh;
  }

  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }  

  .container {
    width: 40%;
    margin: 0 auto;
  }
</style>