<template >
  <div style="text-align:center;width:1000px;margin-left: 250px;">
    <el-header style="height: 60px;">
        <span style="font-size:30px">发布活动</span>&nbsp;&nbsp;&nbsp;&nbsp;
    </el-header>
    <el-main style="height: 700px;text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="服务长者" prop="inputName">
          <el-input style="width: 217px;"
          placeholder="请输入长者姓名"
          v-model="ruleForm.inputName">
        </el-input>
        </el-form-item>
        <el-form-item label="长者手机号" prop="inputPhone">
          <el-input style="width: 217px;"
          placeholder="请输入手机号"
          v-model="ruleForm.inputPhone">
        </el-input>
        </el-form-item>
        <el-form-item label="服务时间" required prop="valueTime">
            <el-date-picker
            value-format="yyyy-MM-dd HH:mm:ss"
            v-model="ruleForm.valueTime"
            type="datetime"
            placeholder="选择日期时间"
            align="right"
            :picker-options="pickerOptions">
            </el-date-picker>
        </el-form-item>
        <el-form-item label="服务时长/时" prop="valueHour">
                <el-input-number style="width:217px;" v-model="ruleForm.valueHour"  :step="1" :min="0" :max="1000" label="服务时长"></el-input-number> 
         </el-form-item>
         <el-form-item label="所需义工数" prop="valueNum">
                <el-input-number style="width:217px;" v-model="ruleForm.valueNum"  :step="1" :min="0" :max="1000" label="所需义工数"></el-input-number> 
         </el-form-item>
         <el-form-item label="所属义工站" prop="vVsName">
          <el-input style="width: 217px;"
          disabled
          placeholder="请输入所属义工站"
          v-model="ruleForm.vVsName">
        </el-input>
        </el-form-item>
        <div></div>
        <el-form-item  el-form-item label="服务内容" prop="inputContent" >
          <el-input type="textarea" placeholder="请输入服务内容" style="width: 550px;" v-model="ruleForm.inputContent"></el-input>
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
          inputName: this.$route.params.eName,
          inputPhone:this.$route.params.ePhoneNum,
          valueTime: '',
          inputContent: '',
          valueNum: 1,
          valueHour: 0,
          vVsName:sessionStorage.getItem("vsName"),
          vVsId:sessionStorage.getItem("vsId"),
        },
        rules: {
          inputName: [
            { required: true, message: '请输入长者姓名', trigger: 'blur' },
            { min: 2, max: 4, message: '姓名长度在 2 到 4 个字符', trigger: 'blur' }
          ],
          inputPhone: [
            { required: true, message: '请输入手机号', trigger: 'blur' },
            { min: 11, max: 11, message: '手机号格式不正确！', trigger: 'blur' }
          ],
          inputContent: [
            { required: true, message: '请输入内容', trigger: 'blur' },
          ],
          valueTime: [
            { required: true, message: '请选择服务时间', trigger: 'change' }
          ],
          valueNum: [
            { type:'number',required: true, message: '请输入人数', trigger: 'change' }
          ],
          valueHour: [
            { type:'number',required: true, message: '请输入服务时长', trigger: 'change' }
          ],
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.axios.post(this.Global.basePath+'addVolActivity',{
              vaTime:this.ruleForm.valueTime,
              vaEName:this.ruleForm.inputName,
              vaEPhoneNum:this.ruleForm.inputPhone,
              vaHourNum:this.ruleForm.valueHour,
              vaRemSum:this.ruleForm.valueNum,
              vaVsId:this.ruleForm.vVsId,
              vaVsName:this.ruleForm.vVsName,
              vaName:this.ruleForm.inputContent,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$alert('恭喜你，发布成功！', '发布活动', {
                    confirmButtonText: '确定',
                  });
                  this.resetForm('ruleForm');
                } else {
                  this.$alert('发布失败！', '发布活动', {
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


