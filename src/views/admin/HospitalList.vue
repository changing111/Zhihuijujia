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
            <el-breadcrumb-item style="font-size:20px">医院列表</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
        
        <span>&nbsp;&nbsp;所在城市:</span>
        <el-select v-model="valueCity" placeholder="请选择所在城市">
          <el-option
            v-for="item in this.Global.cities"
            :key="item.valueCity"
            :label="item.label"
            :value="item.valueCity">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>
        <span>&nbsp;&nbsp;医院名称:</span>
        <el-input style="width: 217px;"
          placeholder="请输入医院名称"
          prefix-icon="el-icon-search"
          v-model="inputName">
        </el-input>
        <el-button plain @click="clickConditionSerach">查找</el-button>
        <el-button plain @click="clickConditionDelete">清空条件</el-button>
        <span>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
          <el-table-column prop="hName" label="医院名称" width="140">
          </el-table-column>
          <el-table-column prop="hCity" label="所属城市" width="140">
          </el-table-column>
          <el-table-column prop="hAddress" label="医院地址" width="140">
          </el-table-column>
          <el-table-column prop="hPhoneNum" label="医院咨询电话" width="140">
          </el-table-column>
          <el-table-column prop="hAdminPhone" label="该院管理员账号" width="150" >
          </el-table-column>
          <el-table-column prop="hAdminPassword" label="该院管理员密码" width="150" >
            </el-table-column>
          <el-table-column prop="hBus" label="公交路线" width="400">
          </el-table-column>
          <el-table-column prop="hContent" label="医院特色项目" width="400">
          </el-table-column>
            <el-table-column
              fixed="right"
              label="操作"
              width="150">
              <template slot-scope="scope">
                <el-button @click="routeToOffice(scope.row)" type="text" size="big">&nbsp;&nbsp;&nbsp;查看科室列表</el-button>
                <el-button @click="routeToRegistersList(scope.row)" type="text" size="big">查看预约纪录</el-button>
                <el-button @click="updateClick(scope.row)" type="text" size="big">修改资料</el-button>
                <el-button @click="deleteClick(scope.row)" type="text" size="big">删除</el-button>
              </template>
            </el-table-column>
        </el-table>
    </el-main>
    <el-footer style="text-align: center;">
              <Pagination :total="total" :currentPage=currentPage @SizeChange="clickChangeSize" @CurrentChange="clickChangeCurrent"></Pagination> 
    </el-footer>
    <el-dialog title="更新资料" :visible.sync="UpdateVisible" style="text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="医院名称" prop="inputName">
          <el-input style="width: 217px;"
          placeholder="请输入医院名称"
          v-model="ruleForm.inputName">
        </el-input>
        </el-form-item>
        <el-form-item label="医院电话" prop="inputPhone">
          <el-input style="width: 217px;"
          placeholder="请输入医院电话"
          v-model="ruleForm.inputPhone">
        </el-input>
        </el-form-item>
        <el-form-item label="管理者账号" prop="inputAdminPhone">
          <el-input style="width: 217px;"
          placeholder="请输入管理者手机号"
          v-model="ruleForm.inputAdminPhone">
        </el-input>
        </el-form-item>
        <el-form-item label="登录密码" prop="inputPass">
          <el-input type="password" style="width: 217px;"
          placeholder="请输入登录密码"
          v-model="ruleForm.inputPass">
        </el-input>
        </el-form-item>
        <el-form-item label="所处城市" prop="valueCity" >
          <el-select v-model="ruleForm.valueCity" placeholder="请选择所处城市" style="width: 550px;">
          <el-option
            v-for="item in this.Global.cities"
            :key="item.valueCity"
            :label="item.label"
            :value="item.valueCity">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
          </el-select>
        </el-form-item>  
        <el-form-item label="公交路线" prop="inputBus" >
          <el-input type="textarea" placeholder="请输入公交路线" style="width: 550px;" v-model="ruleForm.inputBus"></el-input>
        </el-form-item>
        <el-form-item label="医院特色" prop="inputContent" >
          <el-input type="textarea" placeholder="请输入医院特色" style="width: 550px;" v-model="ruleForm.inputContent"></el-input>
        </el-form-item>     
        <el-form-item label="医院地址" prop="inputAddress" >
          <el-input type="textarea" placeholder="请输入医院地址" style="width: 550px;" v-model="ruleForm.inputAddress"></el-input>
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
        total:null,    //定义总条数
        currentPage:1,//定义默认页码
        pageSize:this.Global.pageSize,  //定义默认显示条数
        searchStates:1,//纪录当前查询类别，条件查询是0，关键字查询是1，默认1(方便判断点击分页操作后进行哪种查询)
        inputLike:'',//定义默认关键字为空

        valueCity:'',
        inputName:'',
        
        UpdateVisible:false,
        ruleForm: {
          inputName: '',
          inputAdminPhone: '',
          inputPhone: '',
          inputPass: '',
          valueCity: '',
          inputAddress: '',
          inputBus: '',
          inputContent: '',
          hId:'',
        },
        rules: {
          inputAdminPhone: [
            { required: true, message: '请输入管理者手机号', trigger: 'blur' },
            { min: 11, max: 11, message: '手机号格式不正确！', trigger: 'blur' }
          ],
          inputPhone: [
            { required: true, message: '请输入医院电话', trigger: 'blur' },
            { min: 7, max: 12, message: '医院电话格式不正确！', trigger: 'blur' }
          ],
          inputPass: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 3, max: 20, message: '密码长度在 3 到 20 个字符', trigger: 'blur' }
          ],
          inputName: [
            { required: true, message: '请输入医院名称', trigger: 'blur' }
          ],
          inputAddress: [
            { required: true, message: '请输入地址', trigger: 'blur' }
          ],
          inputBus: [
            { required: true, message: '请输入公交路线', trigger: 'blur' }
          ],
          inputContent: [
            { required: true, message: '请输入医院特色', trigger: 'blur' }
          ],
          valueCity: [
            { required: true, message: '请选择所处城市', trigger: 'change' }
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
        this.valueCity=null;  //把条件搜索置空
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
        this.axios.post(this.Global.basePath+'getHospitalsListByCondition',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          hospital:{ 
            hCity:this.valueCity,
            hName:this.inputName,
          }
        })
          .then((res) => {
            this.tableData = res.data.hospitalsList
            this.total = res.data.totalCount
          })
      },
      keywordSerach(){
        this.axios.post(this.Global.basePath+'getHospitalsListByInputLike',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          inputLike:this.inputLike
        })
          .then((res) => {
            this.tableData = res.data.hospitalsList
            this.total = res.data.totalCount
          })
      },
      updateClick(row) {  //更新按钮的触发事件
        this.ruleForm.valueCity=row.hCity,
        this.ruleForm.inputName=row.hName,
        this.ruleForm.inputAdminPhone=row.hAdminPhone,
        this.ruleForm.inputPhone=row.hPhoneNum,
        this.ruleForm.inputPass=row.hAdminPassword,
        this.ruleForm.inputAddress=row.hAddress,
        this.ruleForm.inputBus=row.hBus,
        this.ruleForm.inputContent=row.hContent,
        this.ruleForm.hId=row.hId,
        this.UpdateVisible = true
      },
      deleteClick(row) {  //删除按钮的触发事件
        this.$confirm('此操作将永久删除该商户及其服务内容, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'deleteHospital',{
              hId:row.hId,
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
            this.axios.post(this.Global.basePath+'updateHospital',{
              hCity:this.ruleForm.valueCity,
              hAdminPhone:this.ruleForm.inputAdminPhone,
              hName:this.ruleForm.inputName,
              hPhoneNum:this.ruleForm.inputPhone,
              hAdminPassword:this.ruleForm.inputPass,
              hAddress: this.ruleForm.inputAddress,
              hBus:this.ruleForm.inputBus,
              hContent:this.ruleForm.inputContent,
              hId:this.ruleForm.hId,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$alert('恭喜你，更新成功！', '更新资料', {
                    confirmButtonText: '确定',
                  });
                  this.clickChangeSize(this.pageSize);//强行调用分页按钮触发事件来刷新页面
                } else {
                  this.$alert('更新失败！', '更新资料', {
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
      routeToOffice(row){
        sessionStorage.setItem("hName",row.hName);
        sessionStorage.setItem("hId",row.hId);
        this.$router.push({name:'Office'})
      },
      routeToRegistersList(row){
        sessionStorage.setItem("hName",row.hName);
        sessionStorage.setItem("hId",row.hId);
        this.$router.push({name:'RegistersList'})
      },
    },
    components:{
        Pagination
    },
  }
</script>