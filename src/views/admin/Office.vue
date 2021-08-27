<template >
  <div >
    <el-header style="height: 100px;white-space: nowrap;  /*强制span不换行*/
      display: inline-block;  /*将span当做块级元素对待*/
      width: 32px;  /*限制宽度*/
      overflow: hidden;  /*超出宽度部分隐藏*/
      text-overflow: ellipsis;  /*超出部分以点号代替*/
      line-height: 0.9;  /*数字与之前的文字对齐*/">
      <div style="height: 70px;">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/HospitalList' }" style="font-size:20px">医院列表</el-breadcrumb-item>
            <el-breadcrumb-item style="font-size:20px">{{this.hName}}-科室列表</el-breadcrumb-item>
        </el-breadcrumb>
        <div style="height: 20px;"></div>
        <el-button plain @click="addOffice">添加科室</el-button>
      </div>
    </el-header>
    <el-main style="height: 650px;">
        <el-table :data="tableData" style="width: 100%" height="600px">
          <el-table-column prop="oName" label="科室名称" width="240">
          </el-table-column>
            <el-table-column
              label="操作"
              width="200">
              <template slot-scope="scope">
                <el-button @click="routeToDoctor(scope.row)" type="text" size="big">&nbsp;&nbsp;&nbsp;查看医生</el-button>
                <el-button @click="deleteClick(scope.row)" type="text" size="big">&nbsp;&nbsp;&nbsp;删除</el-button>
              </template>
            </el-table-column>
        </el-table>
    </el-main>
    <el-dialog title="添加科室" :visible.sync="AddVisible" style="text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="科室名称" prop="inputName">
          <el-input style="width: 217px;"
          placeholder="请输入科室名称"
          v-model="ruleForm.inputName">
        </el-input>
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

        AddVisible: false,
        ruleForm: {
          inputName: '',
        },
        rules: {
          inputName: [
            { required: true, message: '请输入科室名称', trigger: 'blur' }
          ],
        }
      }
    },
    created(){
        this.Serach(); //相对于清空关键字的关键字搜索
    },
    methods: {
      Serach(){
        this.axios.post(this.Global.basePath+'getOfficesListByHId',{
          oHId:this.hId
        })
          .then((res) => {
            this.tableData = res.data
          })
      },
      deleteClick(row) {  //删除按钮的触发事件
        this.$confirm('此操作将删除该科室及该科室医生, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'deleteOffice',{
              oId:row.oId,
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
      routeToDoctor(row){
        sessionStorage.setItem("oId",row.oId);
        sessionStorage.setItem("oName",row.oName);
        this.$router.push({name:'Doctor'})
      },
      addOffice(){
          this.AddVisible = true
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.axios.post(this.Global.basePath+'addOffice',{
              oName:this.ruleForm.inputName,
              oHId:this.hId,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$alert('恭喜你，添加成功！', '添加科室', {
                    confirmButtonText: '确定',
                  });
                  this.Serach();//刷新页面
                  this.resetForm(formName);
                } else {
                  this.$alert('添加失败', '添加科室', {
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