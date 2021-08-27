<template>  
    <div id="Login">
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="手机号" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pass">
            <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item el-form-item>
          <JcRange @successFun="onSuccessFun" />
        </el-form-item>
        <el-form-item>
            <el-button  v-if="this.status" type="primary"  @click="submitForm('ruleForm')">登录</el-button>
            <el-button  v-if="!this.status" type="primary" disabled  @click="submitForm('ruleForm')">登录</el-button>
            <el-button @click="resetForm('ruleForm')">清空</el-button>&nbsp;&nbsp;&nbsp;&nbsp;
        </el-form-item>
        
        </el-form>
    </div>
</template> 

<style>
@import "../css/style.css"
</style>

<script>
import JcRange from "../components/jcRange"
  export default {
    data() {    
      return {
        loading: false,
        status: false,
        ruleForm: {
          phone:'',
          pass: ''

        },
        rules: {
          pass: [
            { required: true, message: '请输入密码', trigger: 'blur'}
          ],
          phone: [
            { required: true, message: '请输入手机号', trigger: 'blur' },
            { min: 11, max: 11, message: '手机号格式不正确', trigger: 'blur' }
          ],

        }
      };
    },
    methods: {
      // 监听滑块成功事件
      onSuccessFun(e) {
        this.status = e;
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$emit("getRuleForm",this.ruleForm);
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    },
     components:{
      JcRange
    },
  }
</script>    
