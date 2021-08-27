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
            <el-breadcrumb-item style="font-size:20px">{{this.vVsName}}-义工列表</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
        
        <span>&nbsp;&nbsp;性别:</span>
        <el-select v-model="valueGender" placeholder="请选择性别">
          <el-option
            v-for="item in this.Global.genders"
            :key="item.valueGender"
            :label="item.label"
            :value="item.valueGender">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>
        <span>&nbsp;&nbsp;义工姓名:</span>
        <el-input style="width: 217px;"
          placeholder="请输入义工姓名"
          prefix-icon="el-icon-search"
          v-model="inputName">
        </el-input>
        <el-button plain @click="clickConditionSerach">查找</el-button>
        <el-button plain @click="clickConditionDelete">清空条件</el-button>
        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <el-input style="width: 250px;"
          placeholder="输入关键字"
          prefix-icon="el-icon-search"
          v-model="inputLike">
        </el-input>
        <el-button plain @click="clickKeywordSerach">关键字搜索</el-button>
    </el-header>
    <el-main style="height: 640px;">
        <el-table :data="tableData" style="width: 100%" height="600px">
            <el-table-column prop="vName" label="义工姓名" width="230">
            </el-table-column>
            <el-table-column prop="vPhone" label="手机号" width="200">
            </el-table-column>
            <el-table-column prop="vGender" label="性别" width="180">
            </el-table-column>
            <el-table-column prop="vPassword" label="登录密码" width="200">
            </el-table-column>
            <el-table-column prop="vJob" label="职业" width="200">
            </el-table-column>
            <el-table-column prop="vHour" label="义工时" width="250">
            </el-table-column>
            <el-table-column
              fixed="right"
              label="操作"
              width="300">
              <template slot-scope="scope">
                <el-button @click="routeToVolBookByVId(scope.row)" type="text" size="big">查看活动纪录</el-button>
                <el-button @click="updateClick(scope.row)" type="text" size="big">修改资料</el-button>
                <el-button @click="deleteClick(scope.row)" type="text" size="big">删除义工</el-button>
              </template>
            </el-table-column>
        </el-table>
    </el-main>
    <el-footer style="text-align: center;">
              <Pagination :total="total" :currentPage=currentPage @SizeChange="clickChangeSize" @CurrentChange="clickChangeCurrent"></Pagination> 
    </el-footer>
    <el-dialog title="更新资料" :visible.sync="UpdateVisible" style="text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="义工姓名" prop="inputName">
          <el-input style="width: 217px;"
          placeholder="请输入义工义工姓名"
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
        <el-form-item label="义工时" prop="inputHour">
          <el-input style="width: 217px;"
          placeholder="请输入义工时"
          v-model="ruleForm.inputHour">
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
        uAuthor:sessionStorage.getItem('uAuthor'),
        vVsName:sessionStorage.getItem("vsName"),
        vVsId:sessionStorage.getItem("vsId"),
        tableData: [],//定义表格数据
        total:null,    //定义总条数
        currentPage:1,//定义默认页码
        pageSize:this.Global.pageSize,  //定义默认显示条数
        searchStates:1,//纪录当前查询类别，条件查询是0，关键字查询是1，默认1(方便判断点击分页操作后进行哪种查询)
        inputLike:null,//定义默认关键字为空

        valueGender:'',
        inputName:'', 

        UpdateVisible:false,
        ruleForm: {
          inputName: '',
          inputJob: null,
          inputHour: '',
          inputPhone: '',
          inputPass: '',
          valueGender: '',
          vVsId:'',
          vId:'',
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
          inputJob: [
            { required: true, message: '请输入职业', trigger: 'blur' }
          ],
          inputHour: [
            { type: 'number',required: true, message: '请输入义工时', trigger: 'blur' }
          ],
          valueGender: [
            { required: true, message: '请选择性别', trigger: 'change' }
          ],
        }     
      }
    },
    created(){
        this.clickKeywordSerach(); //相对于清空关键字的关键字搜索
    },
    methods: {
      clickChangeSize(pageSize){
        this.pageSize=pageSize;
        if (this.searchStates==0) {//判断当前是条件查询还是关键字查询
          this.conditionSerach();
        } else {
          this.keywordSerach();
        }
      },
      clickChangeCurrent(currentPage){
        this.currentPage=currentPage;
        if (this.searchStates==0) {//判断当前是条件查询还是关键字查询
          this.conditionSerach();
        } else {
          this.keywordSerach();
        }
      },
      clickConditionSerach(){
        this.currentPage=1; //置当前页为1
        this.inputLike=null; //把关键字搜索置空
        this.searchStates=0;//0纪录当前为条件查询
        this.conditionSerach();//调用条件查询方法
      },
      clickKeywordSerach(){
        this.currentPage=1; //置当前页为1
        this.valueGender=null;  //把条件搜索置空
        this.inputName=null;
        this.searchStates=1;//1纪录当前为关键字查询
        this.keywordSerach();//调用关键字查询方法
      },
      clickConditionDelete(){ //
          this.currentPage=1; //置当前页为1
          this.inputLike=null;
          this.clickKeywordSerach(); //相对于清空关键字的关键字搜索
      },
      conditionSerach(){
        this.axios.post(this.Global.basePath+'getVolunteersListByVsId',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          volunteer:{ 
            vVsId:this.vVsId,
            vGender:this.valueGender,
            vName:this.inputName,
          }
        })
          .then((res) => {
            this.tableData = res.data.volunteersList
            this.total = res.data.totalCount
          })
      },
      keywordSerach(){
        this.axios.post(this.Global.basePath+'getVolunteersListByVsIdAndLike',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          volunteer:{ 
            vVsId:this.vVsId,
            vJob:this.inputLike,//把关键字放在vjob中
          }
        })
          .then((res) => {
            this.tableData = res.data.volunteersList
            this.total = res.data.totalCount
          })
      },
      updateClick(row) {  //更新按钮的触发事件
        this.ruleForm.valueGender=row.vGender,
        this.ruleForm.inputName=row.vName,
        this.ruleForm.inputPhone=row.vPhone,
        this.ruleForm.inputPass=row.vPassword,
        this.ruleForm.inputJob=row.vJob,
        this.ruleForm.inputHour=row.vHour,
        this.ruleForm.vsId=row.vsId,
        this.ruleForm.vId =row.vId,
        this.UpdateVisible = true
      },
      deleteClick(row) {  //删除按钮的触发事件
        this.$confirm('此操作将删除该义工及其报名纪录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'deleteVolunteer',{
              vPhone:row.vPhone,
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
                  this.clickChangeSize(this.pageSize);//强行调用分页按钮触发事件来刷新页面
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
      routeToVolBookByVId(row){
        sessionStorage.setItem("vName",row.vName);
        sessionStorage.setItem("vPhoneNum",row.vPhone);
        this.$router.push({path:'/vsBookByVId'})
      },
      
    }, 
    components:{
        Pagination
    },
  }
</script>