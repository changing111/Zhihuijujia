<template>
<div style="text-align:center;width:1000px;margin-left: 280px;">
  <el-header style="height: 100px;white-space: nowrap;  /*强制span不换行*/
      display: inline-block;  /*将span当做块级元素对待*/
      width: 32px;  /*限制宽度*/
      overflow: hidden;  /*超出宽度部分隐藏*/
      text-overflow: ellipsis;  /*超出部分以点号代替*/
      line-height: 0.9;  /*数字与之前的文字对齐*/">
      <div>
        <span style="font-size:30px">服务币充值</span>&nbsp;&nbsp;&nbsp;&nbsp;
      </div>

    </el-header>
      <el-main style="height: 640px;">
        <el-transfer
        style="text-align: left; display: inline-block ;"
        filterable
        :filter-method="filterMethod"
        filter-placeholder="请输入姓名"
        :titles="['选择长者', '待充值列表']"
        v-model="value"
        :data="arrayElder">
      </el-transfer>
      <div style="text-align:center;height:60px;margin-left: 280px;"></div>
      <el-form  :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="充值类型" prop="valueInvest">
          <el-select v-model="ruleForm.valueInvest" placeholder="请选择充值类型">
          <el-option
            v-for="item in this.Global.Invest"
            :key="item.valueInvest"
            :label="item.label"
            :value="item.valueInvest">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
          </el-select>
        </el-form-item>  
        <div></div> 
        <el-form-item label="充值数量" prop="valueNum">
          <el-input-number style="width:217px;" v-model="ruleForm.valueNum" @change="NumberChange" :step="100" :min="100" :max="10000" label="充值数量"></el-input-number> 
        </el-form-item>
        <div></div>
        <el-form-item>
          <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <el-button type="primary" style="width:270px;" @click="submitForm('ruleForm')">进行充值</el-button>
        </el-form-item>
      </el-form>
    </el-main>
  

</div>
</template>

<script>
  export default {
    data() {
      return {
        value: [],
        elders: [],
        arrayElder:[],
        ruleForm: {
          valueInvest:'',
          valueNum:100,
        },
        rules: {
          valueInvest: [
            { required: true, message: '请选择充值类型', trigger: 'change' },
          ],
          valueNum: [
            { type: 'number', message: '年龄必须为数字值'}//无效
          ],
        }

      };
    },
    created(){
      this.axios.post(this.Global.basePath+'getEldersList')
          .then((res) => {
            this.elders = res.data;
            for(var i=0;i<this.elders.length;i++){
                  this.arrayElder.push({
                  label: res.data[i].eName,
                  key: i,
              });
            }
          })
    },
    methods:{
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            if (this.value.length==0) {
              this.$alert('请先选择长者！', '提示', {
                confirmButtonText: '确定',
              });
            } else {
              for(var i=0;i<this.value.length;i++){
                this.axios.post(this.Global.basePath+'Invest',{
                    bName:this.elders[this.value[i]].eName,
                    bPhoneNum:this.elders[this.value[i]].ePhoneNum,
                    bReason:this.ruleForm.valueInvest,
                    bBeforeBal:this.elders[this.value[i]].eBalance,
                    bAfterBal:this.elders[this.value[i]].eBalance+this.ruleForm.valueNum,
                })
                  .then((res) => {
                  })
              };
              this.$alert('充值成功！', '充值', {
                confirmButtonText: '确定',
              });
              this.value = [];                  //充值完成后把可选数据清空
              this.ruleForm.valueNum = 100;
              this.resetForm('ruleForm');
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
  }
</script>