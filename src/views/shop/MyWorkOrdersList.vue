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
            <el-breadcrumb-item style="font-size:20px">{{this.sName}}-工单列表</el-breadcrumb-item>
        </el-breadcrumb>
        <div style="height: 20px;"></div>
        <span>&nbsp;&nbsp;工单状态:</span>
        <el-select v-model="valueState" placeholder="请选择工单状态">
          <el-option
            v-for="item in this.Global.workOrderStates"
            :key="item.valueState"
            :label="item.label"
            :value="item.valueState">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>
        <span>&nbsp;&nbsp;长者姓名:</span>
        <el-input style="width: 217px;"
          placeholder="请输入长者姓名"
          prefix-icon="el-icon-search"
          v-model="inputEName">
        </el-input>
        <span>&nbsp;&nbsp;服务内容:</span>
        <el-input style="width: 202px;"
          placeholder="请输入服务内容"
          prefix-icon="el-icon-search"
          v-model="inputContent">
        </el-input>
        <el-button plain @click="clickConditionSerach">查找</el-button>
        <el-button plain @click="clickConditionDelete">清空条件</el-button>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <el-input style="width: 250px;"
          placeholder="输入关键字"
          prefix-icon="el-icon-search"
          v-model="inputLike">
        </el-input>
        <el-button plain @click="clickKeywordSerach">关键字搜索</el-button>
      </div>
    </el-header>
    <el-main style="height: 650px;">
        <el-table :data="tableData" height="500px">
            <el-table-column prop="wId" label="单号" width="130" sortable>
              </el-table-column>
              <el-table-column prop="wEName" label="长者名字" width="180" >
              </el-table-column>
              <el-table-column prop="wSgContent" label="服务内容" width="200">
              </el-table-column>
              <el-table-column prop="wAmount" label="订单数量" width="150" >
              </el-table-column>
              <el-table-column prop="wSpend" label="花费服务币数" width="200" >
              </el-table-column>
              <el-table-column prop="wState" label="订单状态" width="180" >
              </el-table-column>
              <el-table-column prop="wServiceTime" label="下单时间" width="200" >
              </el-table-column>
              <el-table-column prop="wEAddress" label="长者地址" width="200">
              </el-table-column>
              <el-table-column
              fixed="right"
              label="操作"
              width="170">
              <template slot-scope="scope">
                <el-button disabled v-show="scope.row.wState=='已完成'" type="text" size="big">&nbsp;&nbsp;&nbsp;&nbsp;订单已完成</el-button>
                <el-button disabled v-show="scope.row.wState=='已取消'" type="text" size="big">&nbsp;&nbsp;订单已取消</el-button>
                <el-button v-show="scope.row.wState=='已下单'" @click="updateState1Click(scope.row)" type="text" size="big">完成订单</el-button>
                <el-button v-show="scope.row.wState=='已下单'" @click="updateState2Click(scope.row)" type="text" size="big">取消订单</el-button>
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
        sName:sessionStorage.getItem("sName"),
        sId:sessionStorage.getItem("sId"),
        total:null,    //定义总条数
        currentPage:1,//定义默认页码
        pageSize:this.Global.pageSize,  //定义默认显示条数
        searchStates:1,//纪录当前查询类别，条件查询是0，关键字查询是1，默认1(方便判断点击分页操作后进行哪种查询)
        inputLike:null,//定义默认关键字为空
        inputEName:'',
        valueState:'',
        inputContent:'',
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
        this.inputName=null;;
        this.inputPhone=null;
        this.searchStates=1;//1纪录当前为关键字查询
        this.keywordSerach();//调用关键字查询方法
      },
      clickConditionDelete(){ //
          this.currentPage=1; //置当前页为1
          this.inputLike=null;
          this.inputEName=null;
          this.inputContent=null;
          this.valueState=null;
          this.clickKeywordSerach(); //相对于清空关键字的关键字搜索
      },
      conditionSerach(){
        this.axios.post(this.Global.basePath+'getWorkOrdersListBySPhoneAndCondition',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          workOrder:{ 
            wSPhoneNum:sessionStorage.getItem("uId"),
            wEName:this.inputEName,
            wSgContent:this.inputContent,
            wState:this.valueState,
          }
        })
          .then((res) => {
            this.tableData = res.data.workOrdersList
            this.total = res.data.totalCount
          })
      },
      keywordSerach(){
        this.axios.post(this.Global.basePath+'getWorkOrdersListBySPhoneAndInputLike',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          workOrder:{ 
            wSPhoneNum:sessionStorage.getItem("uId"),
            wEName:this.inputLike,
          }
        })
          .then((res) => {
            this.tableData = res.data.workOrdersList
            this.total = res.data.totalCount
          })
      },
      updateState1Click(row) {  
        this.$confirm('将完成该服务工单, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'updateWorkOrderState1',{
              wId:row.wId,
              wSPhoneNum:sessionStorage.getItem("uId"),
              wSgPrice:row.wSgPrice,
              wSName:sessionStorage.getItem("sName"),
              wAmount:row.wAmount
            })
              .then((res) => {
                if (res.data==1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功!'
                  });
                  this.clickChangeSize(this.pageSize);//强行调用分页按钮触发事件来刷新页面
                } else {
                  this.$message({
                    type: 'info',
                    message: '修改失败！'
                  }); 
                }
              })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消修改'
          });          
        });
      },
      updateState2Click(row) {  
        this.$confirm('将取消该服务工单, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'updateWorkOrderState2',{
              wId:row.wId,
              wEPhoneNum:row.wEPhoneNum,
              wSgPrice:row.wSgPrice,
              wEName:row.wEName,
              wAmount:row.wAmount
            })
              .then((res) => {
                if (res.data==1) {
                  this.$message({
                    type: 'success',
                    message: '取消成功!'
                  });
                  this.clickChangeSize(this.pageSize);//强行调用分页按钮触发事件来刷新页面
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
      },
    },
    components:{
        Pagination
    },
  }
</script>