<template >
  <div style="text-align:center;width:1000px;margin-left: 280px;" >
    <el-header style="height: 100px;white-space: nowrap;  /*强制span不换行*/
      display: inline-block;  /*将span当做块级元素对待*/
      width: 32px;  /*限制宽度*/
      overflow: hidden;  /*超出宽度部分隐藏*/
      text-overflow: ellipsis;  /*超出部分以点号代替*/
      line-height: 0.9;  /*数字与之前的文字对齐*/">
      <div style="height: 50px;">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item style="font-size:20px">管理员账号列表</el-breadcrumb-item>
        </el-breadcrumb>
      </div>

        <el-input style="width: 250px;"
          placeholder="输入关键字"
          prefix-icon="el-icon-search"
          v-model="inputLike">
        </el-input>
        <el-button plain @click="clickKeywordSerach">关键字搜索</el-button>
    </el-header>
    <el-main style="height: 640px;">
        <el-table :data="tableData" style="width: 100%" height="600px">
            <el-table-column prop="aId" label="管理员账号" width="240">
            </el-table-column>
            <el-table-column prop="aPassword" label="管理员账号密码" width="240">
            </el-table-column>
            <el-table-column prop="aAuthority" label="管理员级别" width="240">
            </el-table-column>
            <el-table-column
              fixed="right"
              label="操作"
              width="220">
              <template slot-scope="scope">
                <el-button @click="updateClick(scope.row)" type="text" size="big">修改密码</el-button>
                <el-button v-show="scope.row.aAuthority=='普通管理员'" @click="deleteClick(scope.row)" type="text" size="big">删除账号</el-button>
              </template>
            </el-table-column>
        </el-table>
    </el-main>
    <el-footer style="text-align: center;">
              <Pagination :total="total" :currentPage=currentPage @SizeChange="clickChangeSize" @CurrentChange="clickChangeCurrent"></Pagination> 
    </el-footer>

    <el-dialog title="更改账号密码" :visible.sync="UpdateVisible" style="text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="登录密码" prop="inputPass">
          <el-input type="password" style="width: 400px;"
          placeholder="请输入登录密码"
          v-model="ruleForm.inputPass">
        </el-input>
        </el-form-item>
        <div></div>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置密码</el-button>
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
        total:null,    //定义总条数
        currentPage:1,//定义默认页码
        pageSize:this.Global.pageSize,  //定义默认显示条数
        inputLike:'',//定义默认关键字

        aId:'',
        aPassword:'',
        aAuthority:'',

        UpdateVisible:false,

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
    created(){
        this.currentPage=1; //置当前页为1
        this.inputLike=null;
        this.clickKeywordSerach(); //相对于清空关键字的关键字搜索
    },
    methods: {
      clickChangeSize(pageSize){
        this.pageSize=pageSize;
        this.keywordSerach(); 
      },
      clickChangeCurrent(currentPage){
        this.currentPage=currentPage;
        this.keywordSerach(); 
      },
      clickKeywordSerach(){
        this.currentPage=1; //置当前页为1 
        this.inputName=null;
        this.inputPhone=null;
        this.searchStates=1;//1纪录当前为关键字查询
        this.keywordSerach();//调用关键字查询方法
      },
      clickConditionDelete(){ //
          this.currentPage=1; //置当前页为1
          this.inputLike=null;
          this.clickKeywordSerach(); //相对于清空关键字的关键字搜索
      },
      keywordSerach(){
        this.axios.post(this.Global.basePath+'getAdministratorsListByInputLike',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          inputLike:this.inputLike
        })
          .then((res) => {
            this.tableData = res.data.administratorsList
            this.total = res.data.totalCount
          })
      },
      updateClick(row) {  //更新按钮的触发事件
        this.aId =row.aId,
        this.ruleForm.inputPass=row.aPassword,
        this.UpdateVisible = true
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.axios.post(this.Global.basePath+'updateAdministrator',{
              aId:this.aId,
              aPassword:this.ruleForm.inputPass,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$alert('恭喜你，更改成功！', '更改密码', {
                    confirmButtonText: '确定',
                  });
                  this.clickChangeSize(this.pageSize);//强行调用分页按钮触发事件来刷新页面
                } else {
                  this.$alert('更改失败', '更改密码', {
                    confirmButtonText: '确定',
                  });
                }
              })
          } else {
            return false;
          }
        });
      },
      deleteClick(row) {  //删除按钮的触发事件
        this.$confirm('此操作将删除该管理员账号, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'deleteAdministrator',{
              aId:row.aId,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$message({
                    type: 'success',
                    message: '删除成功!'
                  });
                  this.clickChangeSize(this.pageSize);//强行调用分页按钮触发事件来刷新页面
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
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
    },
    components:{
        Pagination
    },
  }
</script>
