<template >
  <div style="text-align:center;width:1000px;margin-left: 250px;">
    <el-header style="height: 60px;">
        <span style="font-size:30px">更新账号资料</span>&nbsp;&nbsp;&nbsp;&nbsp;
    </el-header>
    <el-main style="height: 700px;text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="义工姓名" prop="inputName">
          <el-input style="width: 217px;"
          placeholder="请输入义工姓名"
          v-model="ruleForm.inputName">
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
        <el-form-item label="性别" prop="valueGender">
          <el-select v-model="ruleForm.valueGender" placeholder="请选择性别">
          <el-option
            v-for="item in this.Global.genders"
            :key="item.valueGender"
            :label="item.label"
            :value="item.valueGender">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="职业" prop="inputJob">
          <el-input style="width: 217px;"
          placeholder="请输入职业"
          v-model="ruleForm.inputJob">
        </el-input>
        </el-form-item>
        <el-form-item label="义工时" prop="valueNum">
                <el-input-number disabled style="width:217px;" v-model="ruleForm.valueNum"  :step="1" :min="0" :max="1000" label="义工时"></el-input-number> 
         </el-form-item>
        <div></div>
        <el-form-item label="所属义工站" prop="vVsName">
          <el-input style="width: 550px;"
          disabled
          placeholder="请输入所属义工站"
          v-model="ruleForm.vVsName">
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
          inputName: '',
          inputPhone: '',
          inputPass: '',
          valueGender: '',
          inputJob: '',
          valueNum: 0,
          vVsName:sessionStorage.getItem("vsName"),
          vVsId:sessionStorage.getItem("vsId"),
        },
        rules: {
          inputName: [
            { required: true, message: '请输入义工姓名', trigger: 'blur' },
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
          valueGender: [
            { required: true, message: '请选择性别', trigger: 'change' }
          ],
          valueNum: [
            { type:'number',required: true, message: '请输入数字', trigger: 'change' }
          ],
          inputJob: [
            { required: true, message: '请输入职业', trigger: 'blur' }
          ]
        }
      }
    },
    created(){
        this.axios.post(this.Global.basePath+'getVolunteerByVPhone',{
            vPhone:sessionStorage.getItem("uId"),
        })
          .then((res) => {
            this.ruleForm.valueGender=res.data.vGender;
            this.ruleForm.inputName=res.data.vName;
            this.ruleForm.inputPhone=res.data.vPhone;
            this.ruleForm.inputPass=res.data.vPassword;
            this.ruleForm.inputJob=res.data.vJob;
            this.ruleForm.inputHour=res.data.vHour;
            this.ruleForm.vVsName=res.data.vVsName;
            this.ruleForm.vId =res.data.vId;
          })
        
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.axios.post(this.Global.basePath+'updateVolunteer',{
              vGender:this.ruleForm.valueGender,
              vName:this.ruleForm.inputName,
              vPhone:this.ruleForm.inputPhone,
              vPassword:this.ruleForm.inputPass,
              vHour: this.ruleForm.inputHour,  
              vJob: this.ruleForm.inputJob,            
              vId:this.ruleForm.vId,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$alert('恭喜你，更新成功！', '义工资料更新', {
                    confirmButtonText: '确定',
                  });
                  //this.resetForm('ruleForm');注册时才清空
                 
                } else {
                  this.$alert('更新失败！', '义工资料更新', {
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


