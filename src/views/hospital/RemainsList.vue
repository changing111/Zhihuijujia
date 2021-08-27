<template >
  <div >
    <el-header style="height: 100px;white-space: nowrap;  /*强制span不换行*/
      display: inline-block;  /*将span当做块级元素对待*/
      width: 32px;  /*限制宽度*/
      overflow: hidden;  /*超出宽度部分隐藏*/
      text-overflow: ellipsis;  /*超出部分以点号代替*/
      line-height: 0.9;  /*数字与之前的文字对齐*/">
      <div style="height: 50px;">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/OfficesList' }" style="font-size:20px">{{this.hName}}-科室列表</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/DoctorsList' }" style="font-size:20px">{{this.oName}}-医生列表</el-breadcrumb-item>
            <el-breadcrumb-item style="font-size:20px">{{this.dName}}医生-余号表</el-breadcrumb-item>
        </el-breadcrumb>
        <div style="height: 20px;"></div>
        <el-button plain @click="addRemain()">添加余号</el-button>
      </div>
    </el-header>
    <el-main style="height: 650px;">
        <el-table :data="tableData" style="width: 100%" height="600px">
          <el-table-column prop="remDate" label="日期" width="200" sortable>
          </el-table-column>
          <el-table-column prop="remSum" label="总号数" width="160">
          </el-table-column>
          <el-table-column prop="remNum" label="余号数" width="240">
          </el-table-column>
            <el-table-column
              label="操作"
              width="200">
              <template slot-scope="scope">
                <el-button @click="routeToRegister(scope.row)" type="text" size="big">查看当天挂号纪录</el-button>
                <el-button @click="deleteClick(scope.row)" type="text" size="big">&nbsp;&nbsp;&nbsp;删除</el-button>
              </template>
            </el-table-column>
        </el-table>
    </el-main>
    <el-dialog title="添加余号" :visible.sync="AddVisible" style="text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="日期" required>
            <el-form-item prop="inputDate">
              <el-date-picker value-format="yyyy-MM-dd" type="date" placeholder="选择日期" v-model="ruleForm.inputDate"></el-date-picker>
            </el-form-item>
            <el-form-item label="当天总号数" prop="valueNum">
                <el-input-number style="width:217px;" v-model="ruleForm.valueNum" @change="NumberChange" :step="1" :min="1" :max="1000" label="当天总号数"></el-input-number> 
            </el-form-item>
        </el-form-item>
        <div></div>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置信息</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>
<style>

</style>
<script>
  import Pagination from '../../components/Pagination'
  export default {
    data() {
     return {
        tableData: [],//定义表格数据
        hName:sessionStorage.getItem("hName"),
        hId:sessionStorage.getItem("hId"),
        oName:sessionStorage.getItem("oName"),
        oId:sessionStorage.getItem("oId"),
        dName:sessionStorage.getItem("dName"),
        dPhoneNum:sessionStorage.getItem("dPhoneNum"),

        AddVisible: false,
        ruleForm: {
          inputDate: '',
          valueNum: 10,
        },
        rules: {
          inputDate: [
            { required: true, message: '请输入日期', trigger: 'blur' }
          ],
        }

      }
    },
    created(){
        this.Serach(); //相对于清空关键字的关键字搜索
    },
    methods: {
      Serach(){
        this.axios.post(this.Global.basePath+'getRemainsListByDPhoneNum',{
          remDPhoneNum:this.dPhoneNum
        })
          .then((res) => {
            this.tableData = res.data
          })
      },
      deleteClick(row) {  //删除按钮的触发事件
        this.$confirm('此操作将删除该纪录以及相关预约纪录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'deleteRemain',{
              remId:row.remId,
              remDate:row.remDate,
              remDPhoneNum:row.remDPhoneNum,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$message({
                    type: 'success',
                    message: '删除成功!'
                  });
                  this.Serach();//刷新页面
                } else {
                  this.$message({
                    type: 'info',
                    message: '删除失败！'
                  }); 
                }
              })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
      },
      routeToRegister(row){
        sessionStorage.setItem("regDPhoneNum",row.remDPhoneNum);
        sessionStorage.setItem("regDate",row.remDate);
        this.$router.push({name:'RegisterByRemId'})
      },
      addRemain(){
          this.AddVisible = true
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.axios.post(this.Global.basePath+'addRemain',{
              remDate:this.ruleForm.inputDate,
              remSum:this.ruleForm.valueNum,
              remNum:this.ruleForm.valueNum,
              remDPhoneNum:this.dPhoneNum,
              remDName:this.dName,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$alert('恭喜你，添加成功！', '添加余号', {
                    confirmButtonText: '确定',
                  });
                  this.Serach();//刷新页面
                  this.resetForm(formName);
                } else {
                  this.$alert('该日期已有余号纪录，请重新选择日期', '添加余号', {
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
    components:{
        Pagination
    },
  }
</script>