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
            <el-breadcrumb-item style="font-size:20px">{{this.sName}}-服务币变更纪录</el-breadcrumb-item>
        </el-breadcrumb>
        <div style="height: 20px;"></div>
      </div>
        <span>&nbsp;&nbsp;变更原因:</span>
        <el-select v-model="valueReason" placeholder="请选择变更原因">
          <el-option
            v-for="item in this.Global.ShopBalanceReasons"
            :key="item.valueReason"
            :label="item.label"
            :value="item.valueReason">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>
        <span>&nbsp;&nbsp;变更状态:</span>
        <el-select v-model="valueState" placeholder="请选择变更状态">
          <el-option
            v-for="item in this.Global.BalanceRecordStates"
            :key="item.valueState"
            :label="item.label"
            :value="item.valueState">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>
        <el-button plain @click="clickConditionSerach">查找</el-button>
        <el-button plain @click="clickConditionDelete">清空条件</el-button>
        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <el-input style="width: 250px;"
          placeholder="输入关键字"
          prefix-icon="el-icon-search"
          v-model="inputLike">
        </el-input>
        <el-button plain @click="clickKeywordSerach">关键字搜索</el-button>
    </el-header>
    <el-main style="height: 640px;">
        <el-table :data="tableData" style="width: 100%" height="600px">
            <el-table-column prop="bReason" label="变更原因" width="250">
            </el-table-column>
            <el-table-column prop="bBeforeBal" label="变更前余额" width="220" sortable>
            </el-table-column>
            <el-table-column prop="bAfterBal" label="变更后余额" width="220" sortable>
            </el-table-column>
            <el-table-column prop="bState" label="状态" width="200" sortable>
            </el-table-column>
            <el-table-column prop="bTime" label="交易时间" width="250" sortable>
            </el-table-column>
            <el-table-column prop="bCardNum" label="银行卡号" width="250" sortable>
            </el-table-column>
            <el-table-column prop="bCardName" label="持卡人姓名" width="250" sortable>
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
        sName:sessionStorage.getItem("sName"),

        valueState:'',
        valueReason:'',    
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
        this.valueReason=null;  //把条件搜索置空
        this.valueState=null;
        this.searchStates=1;//1纪录当前为关键字查询
        this.keywordSerach();//调用关键字查询方法
      },
      clickConditionDelete(){ //
          this.currentPage=1; //置当前页为1
          this.inputLike=null;
          this.clickKeywordSerach(); //相对于清空关键字的关键字搜索
      },
      conditionSerach(){
        this.axios.post(this.Global.basePath+'getBalanceRecordsListByPhoneAndCondition',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          balanceRecord:{ 
            bPhoneNum:sessionStorage.getItem("uId"),
            bReason:this.valueReason,
            bState:this.valueState,
          }
        })
          .then((res) => {
            this.tableData = res.data.balanceRecordsList
            this.total = res.data.totalCount
          })
      },
      keywordSerach(){
        this.axios.post(this.Global.basePath+'getBalanceRecordsListByPhoneAndInputLike',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          balanceRecord:{ 
            bPhoneNum:sessionStorage.getItem("uId"),
            bName:this.inputLike,
          }
        })
          .then((res) => {
            this.tableData = res.data.balanceRecordsList
            this.total = res.data.totalCount
          })
      },
    },
    components:{
        Pagination
    },
  }
</script> 