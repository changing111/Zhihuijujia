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
            <el-breadcrumb-item style="font-size:20px">您的预约挂号纪录</el-breadcrumb-item>
        </el-breadcrumb>
        <div style="height: 20px;"></div>
        <span>&nbsp;&nbsp;医生名称:</span>
        <el-input style="width: 217px;"
          placeholder="请输入医生名称"
          prefix-icon="el-icon-search"
          v-model="inputDName">
        </el-input>
        <span>&nbsp;&nbsp;挂号日期:</span>
        <el-date-picker type="date" placeholder="选择日期" v-model="inputDate"></el-date-picker>
        <el-button plain @click="clickConditionSerach">查找</el-button>
        <el-button plain @click="clickConditionDelete">清空条件</el-button>
        <span>
 
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <el-input style="width: 250px;"
          placeholder="输入关键字"
          prefix-icon="el-icon-search"
          v-model="inputLike">
        </el-input>
        <el-button plain @click="clickKeywordSerach">关键字搜索</el-button>

      </div>
    </el-header>
    <el-main style="height: 650px;">
        <el-table :data="tableData" style="width: 100%" height="600px">
          <el-table-column prop="regId" label="预约号" width="240">
          </el-table-column>
          <el-table-column prop="regDName" label="医生姓名" width="240">
          </el-table-column>
          <el-table-column prop="regDPhoneNum" label="医生手机号" width="240">
          </el-table-column>
          <el-table-column prop="regDate" label="挂号日期" width="240">
          </el-table-column>  
          <el-table-column
              label="操作"
              width="200">
              <template slot-scope="scope">
                <el-button v-if="new Date().getTime()>=new Date(scope.row.regDate).getTime()" disabled type="text" size="big">已完成</el-button>
                <el-button v-if="new Date().getTime()<new Date(scope.row.regDate).getTime()" @click="deleteRegisterClick(scope.row)" type="text" size="big">取消挂号</el-button>
              </template>
            </el-table-column>         
        </el-table>
    </el-main>
    <el-footer style="text-align: center;">
              <Pagination :total="total" :currentPage=currentPage @SizeChange="clickChangeSize" @CurrentChange="clickChangeCurrent"></Pagination> 
    </el-footer>
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
        inputLike:null,//定义默认关键字为空
        inputDName:'',
        inputDate:'',

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
        this.inputDate=null;  //把条件搜索置空
        this.inputDName=null;;
        this.searchStates=1;//1纪录当前为关键字查询
        this.keywordSerach();//调用关键字查询方法
      },
      clickConditionDelete(){ //
          this.currentPage=1; //置当前页为1
          this.inputLike=null;
          this.clickKeywordSerach(); //相对于清空关键字的关键字搜索
      },
      conditionSerach(){
        this.axios.post(this.Global.basePath+'getRegistersListByEPhoneAndCondition',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          register:{ 
            regDName:this.inputDName,
            regEPhoneNum:sessionStorage.getItem("uId"),
            regDate:this.inputDate,
          }
        })
          .then((res) => {
            this.tableData = res.data.registersList
            this.total = res.data.totalCount
          })
      },
      keywordSerach(){
        this.axios.post(this.Global.basePath+'getRegistersListByEPhoneAndInputLike',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          register:{ 
            regEName:this.inputLike,
            regEPhoneNum:sessionStorage.getItem("uId"),
          }
        })
          .then((res) => {
            this.tableData = res.data.registersList
            this.total = res.data.totalCount
          })
      },
      deleteRegisterClick(row){
          this.$confirm('此操作将取消该次挂号, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'deleteRegister',{
              regId:row.regId,
              regDPhoneNum:row.regDPhoneNum,
              regDate:row.regDate,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$message({
                    type: 'success',
                    message: '取消成功!'
                  });
                  this.clickKeywordSerach(); //相对于清空关键字的关键字搜索
                } else {
                  this.$message({
                    type: 'info',
                    message: '取消失败！'
                  }); 
                }
              })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消操作'
          });          
        });
      }
    },
    components:{
        Pagination
    },
  }
</script>