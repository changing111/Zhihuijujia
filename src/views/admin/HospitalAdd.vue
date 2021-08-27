<template >
  <div style="text-align:center;width:1000px;margin-left: 250px;">
    <el-header style="height: 60px;">
        <span style="font-size:30px">注册医院账号</span>&nbsp;&nbsp;&nbsp;&nbsp;
    </el-header>
    <el-main style="height: 700px;text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="医院名称" prop="inputName">
          <el-input style="width: 217px;"
          placeholder="请输入医院名称"
          v-model="ruleForm.inputName">
        </el-input>
        </el-form-item>
        <el-form-item label="医院电话" prop="inputPhone">
          <el-input style="width: 217px;"
          placeholder="请输入医院电话"
          v-model="ruleForm.inputPhone">
        </el-input>
        </el-form-item>
        <el-form-item label="管理者账号" prop="inputAdminPhone">
          <el-input style="width: 217px;"
          placeholder="请输入管理者手机号"
          v-model="ruleForm.inputAdminPhone">
        </el-input>
        </el-form-item>
        <el-form-item label="登录密码" prop="inputPass">
          <el-input type="password" style="width: 217px;"
          placeholder="请输入登录密码"
          v-model="ruleForm.inputPass">
        </el-input>
        </el-form-item>
        <el-form-item label="所处城市" prop="valueCity" >
          <el-select v-model="ruleForm.valueCity" placeholder="请选择所处城市" style="width: 550px;">
          <el-option
            v-for="item in this.Global.cities"
            :key="item.valueCity"
            :label="item.label"
            :value="item.valueCity">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
          </el-select>
        </el-form-item>  
        <el-form-item label="公交路线" prop="inputBus" >
          <el-input type="textarea" placeholder="请输入公交路线" style="width: 550px;" v-model="ruleForm.inputBus"></el-input>
        </el-form-item>
        <el-form-item label="医院特色" prop="inputContent" >
          <el-input type="textarea" placeholder="请输入医院特色" style="width: 550px;" v-model="ruleForm.inputContent"></el-input>
        </el-form-item>     
        <el-form-item label="医院地址" prop="inputAddress" >
          <el-input type="textarea" placeholder="请输入医院地址" style="width: 550px;" v-model="ruleForm.inputAddress"></el-input>
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
          inputAdminPhone: '',
          inputPhone: '',
          inputPass: '',
          valueCity: '',
          inputAddress: '',
          inputBus: '',
          inputContent: '',
        },
        rules: {
          inputAdminPhone: [
            { required: true, message: '请输入管理者手机号', trigger: 'blur' },
            { min: 11, max: 11, message: '手机号格式不正确！', trigger: 'blur' }
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
            { required: true, message: '请输入医院名称', trigger: 'blur' }
          ],
          inputAddress: [
            { required: true, message: '请输入地址', trigger: 'blur' }
          ],
          inputBus: [
            { required: true, message: '请输入公交路线', trigger: 'blur' }
          ],
          inputContent: [
            { required: true, message: '请输入医院特色', trigger: 'blur' }
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
            this.axios.post(this.Global.basePath+'addHospital',{
              hCity:this.ruleForm.valueCity,
              hAdminPhone:this.ruleForm.inputAdminPhone,
              hName:this.ruleForm.inputName,
              hPhoneNum:this.ruleForm.inputPhone,
              hAdminPassword:this.ruleForm.inputPass,
              hAddress: this.ruleForm.inputAddress,
              hBus:this.ruleForm.inputBus,
              hContent:this.ruleForm.inputContent,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$alert('恭喜你，注册成功！', '医院账号注册', {
                    confirmButtonText: '确定',
                  });
                  this.resetForm('ruleForm');
                } else {
                  this.$alert('该医院名称已存在，请重新提交！', '医院账号注册', {
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


