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
            <el-breadcrumb-item style="font-size:20px">{{this.vsName}}-活动列表</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
        <span>&nbsp;&nbsp;活动状态:</span>
        <el-select v-model="valueState" placeholder="请选择活动状态">
          <el-option
            v-for="item in this.Global.VolActivityStates"
            :key="item.valueState"
            :label="item.label"
            :value="item.valueState">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>
        <span>&nbsp;&nbsp;被服务长者的姓名:</span>
        <el-input style="width: 217px;"
          placeholder="请输入长者姓名"
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
            <el-table-column prop="vaId" label="活动Id" width="160">
            </el-table-column>
            <el-table-column prop="vaName" label="活动内容" width="160">
            </el-table-column>
            <el-table-column prop="vaEName" label="服务长者的姓名" width="150">
            </el-table-column>
            <el-table-column prop="vaEPhoneNum" label="长者手机号" width="160">
            </el-table-column>
            <el-table-column prop="vaHourNum" label="服务时长/小时" width="140">
            </el-table-column>
            <el-table-column prop="vaRemSum" label="活动总需人数" width="140">
            </el-table-column>
            <el-table-column prop="vaRemNum" label="剩余可报人数" width="140">
            </el-table-column>
            <el-table-column prop="vaState" label="活动状态" width="130">
            </el-table-column>
            <el-table-column prop="vaTime" label="活动开始时间" width="160">
            </el-table-column>
            <el-table-column
              fixed="right"
              label="操作"
              width="200">
              <template slot-scope="scope">
                <el-button v-show="scope.row.vaState=='未结束'&&scope.row.vaRemNum>0" @click="addVolBook(scope.row)" type="text" size="big">报名活动</el-button>

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
        vsName:sessionStorage.getItem("vVsName"),
        vsId:sessionStorage.getItem("vVsId"),
        tableData: [],//定义表格数据
        total:null,    //定义总条数
        currentPage:1,//定义默认页码
        pageSize:this.Global.pageSize,  //定义默认显示条数
        searchStates:1,//纪录当前查询类别，条件查询是0，关键字查询是1，默认1(方便判断点击分页操作后进行哪种查询)
        inputLike:null,//定义默认关键字为空

        valueState:null,
        inputName:'', 
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
        this.axios.post(this.Global.basePath+'getVolActivitysListByCondition',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          volActivity:{ 
            vaVsId:this.vsId,
            vaState:this.valueState,
            vaEName:this.inputName,
          }
        })
          .then((res) => {
            this.tableData = res.data.volActivitysList
            this.total = res.data.totalCount
          })
      },
      keywordSerach(){
        this.axios.post(this.Global.basePath+'getVolActivitysListByInputLike',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          volActivity:{ 
            vaVsId:this.vsId,
            vaState:this.valueState,
            vaEName:this.inputName,
          }
        })
          .then((res) => {
            this.tableData = res.data.volActivitysList
            this.total = res.data.totalCount
          })
      },
      addVolBook(row) {  //报名按钮的触发事件
        this.$confirm('此操作将报名该活动, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'addVolBook',{
              vbVaId:row.vaId,
              vbVaName:row.vaName,
              vbVaTime:row.vaTime,
              vbVaHourNum:row.vaHourNum,
              vbEName:row.vaEName,
              vbEPhoneNum:row.vaEPhoneNum,
              vbVName:sessionStorage.getItem("vName"),
              vbVPhoneNum:sessionStorage.getItem("uId"),
            })
              .then((res) => {
                if (res.data==1) {
                  this.$message({
                    type: 'success',
                    message: '报名成功!'
                  });
                  this.clickChangeSize(this.pageSize);//强行调用分页按钮触发事件来刷新页面
                } else {
                  this.$alert('您已报名该活动，请勿重复报名！', '报名失败', {
                    confirmButtonText: '确定',
                  }); 
                }
              })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消操作'
          });          
        });
      },
    },
    components:{
        Pagination
    },
  }
</script>