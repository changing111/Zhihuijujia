<template>
<div style="text-align:center;width:1000px;margin-left: 280px;">
  <el-header style="height: 100px;white-space: nowrap;  /*强制span不换行*/
      display: inline-block;  /*将span当做块级元素对待*/
      width: 32px;  /*限制宽度*/
      overflow: hidden;  /*超出宽度部分隐藏*/
      text-overflow: ellipsis;  /*超出部分以点号代替*/
      line-height: 0.9;  /*数字与之前的文字对齐*/">
      <div>
        <div style="font-size:30px">充值服务币</div>&nbsp;&nbsp;&nbsp;&nbsp;
        <div style="font-size:20px">扫码付款并备注长者姓名</div>&nbsp;&nbsp;&nbsp;&nbsp;
      </div>

    </el-header>
      <el-main style="height: 640px;">
        
      <div style="text-align:center;height:60px;margin-left: 160px;">
          <div><img style="float:left;" src="@/assets/payCode1.jpg" height="460" width="320" ></div>
          <div style="float:left;" height="460" width="120">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>

          <div><img style="float:left;" src="@/assets/payCode2.png" height="460" width="320"></div>
      </div>
      
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