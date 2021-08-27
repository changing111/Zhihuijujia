<template >
  <div style="text-align:center;width:1000px;margin-left: 250px;">
    <el-header style="height: 60px;">
        <span style="font-size:30px">注册义工站账号</span>&nbsp;&nbsp;&nbsp;&nbsp;
    </el-header>
    <el-main style="height: 700px;text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="义工站名称" prop="inputName">
          <el-input style="width: 217px;"
          placeholder="请输入义工站名称"
          v-model="ruleForm.inputName">
        </el-input>
        </el-form-item>
        <el-form-item label="负责人姓名" prop="inputHostName">
          <el-input style="width: 217px;"
          placeholder="请输入负责人姓名"
          v-model="ruleForm.inputHostName">
        </el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="inputPhone">
          <el-input style="width: 217px;"
          placeholder="请输入手机号"
          v-model="ruleForm.inputPhone">
        </el-input>
        </el-form-item>
        <el-form-item label="登录密码" prop="inputPass">
          <el-input type="password" style="width: 217px;"
          placeholder="请输入登录密码"
          v-model="ruleForm.inputPass">
        </el-input>
        </el-form-item>
        <el-form-item label="所处城市" prop="valueCity" >
          <el-select v-model="ruleForm.valueCity" placeholder="请选择所处城市" style="width: 560px;">
          <el-option
            v-for="item in this.Global.cities"
            :key="item.valueCity"
            :label="item.label"
            :value="item.valueCity">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
          </el-select>
        </el-form-item>       
        <el-form-item label="义工站地址" prop="inputAddress" >
          <el-input type="textarea" placeholder="请输入地址" style="width: 560px;" v-model="ruleForm.inputAddress"></el-input>
        </el-form-item>
        <div></div>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置信息</el-button>
        </el-form-item>
      </el-form>
    </el-main>
    <el-footer style="text-align: center;">
              
    </el-footer>
  </div>
</template>
<style>
  .el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }
</style>
<script >
  export default {
    data() {
     return {
        ruleForm: {
          inputName: '',
          inputHostCard: '',
          inputHostName: '',
          inputPhone: '',
          inputPass: '',
          valueCity: '',
          inputAddress: '',
        },
        rules: {
          inputHostName: [
            { required: true, message: '请输入负责人姓名', trigger: 'blur' },
            { min: 2, max: 4, message: '姓名长度在 2 到 4 个字符', trigger: 'blur' }
          ],
          inputPhone: [
            { required: true, message: '请输入手机号', trigger: 'blur' },
            { min: 11, max: 11, message: '手机号格式不正确！', trigger: 'blur' }
          ],
          inputPass: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 3, max: 20, message: '密码长度在 3 到 20 个字符', trigger: 'blur' }
          ],
          inputName: [
            { required: true, message: '请输入义工站名称', trigger: 'blur' }
          ],
          inputAddress: [
            { required: true, message: '请输入地址', trigger: 'blur' }
          ],
          valueCity: [
            { required: true, message: '请选择所处城市', trigger: 'change' }
          ],
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.axios.post(this.Global.basePath+'addVolStation',{
              vsCity:this.ruleForm.valueCity,
              vsAdminName:this.ruleForm.inputHostName,
              vsName:this.ruleForm.inputName,
              vsAdminPhone:this.ruleForm.inputPhone,
              vsAdminPass:this.ruleForm.inputPass,
              vsAddress: this.ruleForm.inputAddress,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$alert('恭喜你，注册成功！', '义工站账号注册', {
                    confirmButtonText: '确定',
                  });
                  this.resetForm('ruleForm');
                } else {
                  this.$alert('该义工站名称已存在，请重新提交！', '义工站账号注册', {
                    confirmButtonText: '确定',
                  });
                }
              })
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
    },
  }
</script>


