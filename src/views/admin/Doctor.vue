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
            <el-breadcrumb-item :to="{ path: '/HospitalList' }" style="font-size:20px">医院列表</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/Office' }" style="font-size:20px">{{this.hName}}-科室列表</el-breadcrumb-item>
            <el-breadcrumb-item style="font-size:20px">{{this.oName}}-医生列表</el-breadcrumb-item>
        </el-breadcrumb>
        <div style="height: 20px;"></div>
        <el-button plain @click="addDoctor">添加医生</el-button>
      </div>
    </el-header>
    <el-main style="height: 650px;">
        <el-table :data="tableData" style="width: 100%" height="600px">
          <el-table-column prop="dName" label="医生姓名" width="200">
          </el-table-column>
          <el-table-column prop="dGender" label="性别" width="160">
          </el-table-column>
          <el-table-column prop="dContent" label="介绍" width="240">
          </el-table-column>
          <el-table-column prop="dPhoneNum" label="手机号码" width="240">
          </el-table-column>
            <el-table-column
              label="操作"
              width="200">
              <template slot-scope="scope">
                <el-button @click="routeToRemain(scope.row)" type="text" size="big">&nbsp;&nbsp;&nbsp;查看余号纪录</el-button>
                <el-button @click="deleteClick(scope.row)" type="text" size="big">&nbsp;&nbsp;&nbsp;删除</el-button>
              </template>
            </el-table-column>
        </el-table>
    </el-main>
    <el-dialog title="添加医生" :visible.sync="AddVisible" style="text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="医生姓名" prop="inputName">
          <el-input style="width: 217px;"
          placeholder="请输入医生姓名"
          v-model="ruleForm.inputName">
        </el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="inputPhone">
          <el-input style="width: 217px;"
          placeholder="请输入手机号"
          v-model="ruleForm.inputPhone">
        </el-input>
        </el-form-item>
        <el-form-item label="介绍" prop="inputContent">
          <el-input style="width: 217px;"
          placeholder="请输入介绍"
          v-model="ruleForm.inputContent">
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

        AddVisible: false,
        ruleForm: {
          inputName: '',
          inputPhone: '',
          inputContent: '',
          valueGender: '',
        },
        rules: {
          inputName: [
            { required: true, message: '请输入医生姓名', trigger: 'blur' }
          ],
          inputContent: [
            { required: true, message: '请输入介绍', trigger: 'blur' }
          ],
          inputPhone: [
            { required: true, message: '请输入手机号', trigger: 'blur' },
            { min: 11, max: 11, message: '手机号格式不正确！', trigger: 'blur' }
          ],
           valueGender: [
            { required: true, message: '请选择性别', trigger: 'change' }
          ],
        }
      }
    },
    created(){
        this.Serach(); //相对于清空关键字的关键字搜索
    },
    methods: {
      Serach(){
        this.axios.post(this.Global.basePath+'getDoctorsListByOId',{
          dOId:this.oId
        })
          .then((res) => {
            this.tableData = res.data
          })
      },
      deleteClick(row) {  //删除按钮的触发事件
        this.$confirm('此操作将删除该医生以及余号纪录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'deleteDoctor',{
              dId:row.dId,
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
      routeToRemain(row){
        sessionStorage.setItem("dName",row.dName);
        sessionStorage.setItem("dPhoneNum",row.dPhoneNum);
        this.$router.push({name:'Remain'})
      },
      addDoctor(){
          this.AddVisible = true
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.axios.post(this.Global.basePath+'addDoctor',{
              dName:this.ruleForm.inputName,
              dContent:this.ruleForm.inputContent,
              dPhoneNum:this.ruleForm.inputPhone,
              dGender:this.ruleForm.valueGender,
              dOId:this.oId,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$alert('恭喜你，添加成功！', '添加医生', {
                    confirmButtonText: '确定',
                  });
                  this.Serach();//刷新页面
                  this.resetForm(formName);
                } else {
                  this.$alert('添加失败', '添加医生', {
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