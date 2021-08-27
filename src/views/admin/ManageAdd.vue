<template >
  <div style="text-align:center;width:1000px;margin-left: 250px;">
    <el-header style="height: 60px;">
        <span style="font-size:30px">添加管理员账号</span>&nbsp;&nbsp;&nbsp;&nbsp;
    </el-header>
    <el-main style="height: 700px;text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="手机号" prop="inputPhone">
          <el-input style="width: 400px;"
          placeholder="请输入手机号"
          v-model="ruleForm.inputPhone">
        </el-input>
        </el-form-item>
        <el-form-item label="登录密码" prop="inputPass">
          <el-input type="password" style="width: 400px;"
          placeholder="请输入登录密码"
          v-model="ruleForm.inputPass">
        </el-input>
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
          inputPhone: '',
          inputPass: '',
        },
        rules: {
          inputPhone: [
            { required: true, message: '请输入手机号', trigger: 'blur' },
            { min: 11, max: 11, message: '手机号格式不正确！', trigger: 'blur' }
          ],
          inputPass: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 3, max: 20, message: '密码长度在 3 到 20 个字符', trigger: 'blur' }
          ],
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.axios.post(this.Global.basePath+'addAdministrator',{
              aId:this.ruleForm.inputPhone,
              aPassword:this.ruleForm.inputPass,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$alert('恭喜你，添加成功！', '添加管理员账号', {
                    confirmButtonText: '确定',
                  });
                  this.resetForm('ruleForm');
                } else {
                  this.$alert('该手机号已存在，请重新提交！', '添加管理员账号', {
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


