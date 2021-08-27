<template >
  <div style="text-align:center;width:1000px;margin-left: 250px;">
    <el-header style="height: 60px;">
        <span style="font-size:30px">服务币提现</span>&nbsp;&nbsp;&nbsp;&nbsp;
    </el-header>
    <el-main style="height: 700px;text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="您的余额" prop="BeforeBalance">
          <el-input style="width: 217px;"
          disabled
          v-model="ruleForm.BeforeBalance">
        </el-input>
        </el-form-item>
        <el-form-item label="提现金额" prop="inputNum">
          <el-input style="width: 217px;"
          placeholder="请输入提现金额"
          v-model.number="ruleForm.inputNum">
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
          inputNum: '',
          BeforeBalance: '',
          inputName:'',
          inputHostCard:'',
          inputPhone:'',
          inputHostName:'',
          AfterBalance:'',

        },
        rules: {
          inputNum: [
            { required: true, message: '请输入金额', trigger: 'blur' },
            { type: 'number', message: '单价必须为数字值'}
          ],
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
              if (this.ruleForm.BeforeBalance>=this.ruleForm.inputNum) {
                this.ruleForm.AfterBalance=this.ruleForm.BeforeBalance-this.ruleForm.inputNum;
                this.axios.post(this.Global.basePath+'Withdraw',{
                    bBeforeBal:this.ruleForm.BeforeBalance,
                    bAfterBal:this.ruleForm.AfterBalance,
                    bCardName:this.ruleForm.inputHostName,
                    bName:this.ruleForm.inputName,
                    bCardNum:this.ruleForm.inputHostCard,
                    bPhoneNum:this.ruleForm.inputPhone,
                    })
                    .then((res) => {
                        if (res.data==1) {
                        this.$alert('恭喜你，申请提现'+this.ruleForm.inputNum+'服务币成功！,目前您的余额为'+this.ruleForm.AfterBalance, '提现申请', {
                            confirmButtonText: '确定',
                        });
                        this.ruleForm.BeforeBalance=this.ruleForm.AfterBalance;
                        this.ruleForm.inputNum=null;
                        } else {
                        this.$alert('申请失败', '提现申请', {
                            confirmButtonText: '确定',
                        });
                        }
                    })
              } else {
                  this.$alert('您的可提现余额不足，请重新输入！', '提现申请', {
                        confirmButtonText: '确定',
                    });
              }
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
    },
    created(){ 
        this.axios.post(this.Global.basePath+'getShopBySPhoneNum',{
            sPhoneNum:sessionStorage.getItem("uId"),
        })
          .then((res) => {
            
            this.ruleForm.inputName=res.data.sName,
            this.ruleForm.inputHostCard=res.data.sHostCard,
            this.ruleForm.inputPhone=res.data.sPhoneNum,
            this.ruleForm.inputHostName=res.data.sHostName,
            this.ruleForm.BeforeBalance=res.data.sBalance
          })
    
    },
  }
</script>


