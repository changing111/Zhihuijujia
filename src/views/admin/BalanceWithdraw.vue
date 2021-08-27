<template >
  <div >
    <el-header style="height: 50px;">
        <div style="height: 50px;">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item style="font-size:20px">提现申请列表</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
    </el-header>
    <el-main style="height: 690px;">
        <el-table :data="tableData" style="width: 100%" height="600px">
            <el-table-column prop="bName" label="店铺名称" width="200">
            </el-table-column>
            <el-table-column prop="bPhoneNum" label="店主手机号" width="160">
            </el-table-column>
            <el-table-column prop="bCardName" label="店主名字" width="160" >
            </el-table-column> 
            <el-table-column prop="bCardNum" label="店主银行卡号" width="220" >
            </el-table-column>
            <el-table-column prop="bBeforeBal" label="变更前余额" width="150" sortable>
            </el-table-column>
            <el-table-column prop="bAfterBal" label="变更后余额" width="150" sortable>
            </el-table-column>
            <el-table-column prop="bTime" label="申请时间" width="250" sortable>
            </el-table-column>
            <el-table-column prop="bState" label="状态" width="150" sortable>
            </el-table-column>
            <el-table-column
              fixed="right"
              label="提现处理"
              width="180">
              <template slot-scope="scope" >
                <el-button @click="WithdrawClick(scope.row) " v-show="scope.row.bState=='未完成'" type="text" size="big">给该笔申请提现</el-button>
                <el-button disabled v-show="scope.row.bState=='已完成'" type="text" size="big">提现完成</el-button>
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
   
      }
    },
    created(){
        this.Serach(); 
    },
    methods: {
      clickChangeSize(pageSize){
        this.pageSize=pageSize;
        this.Serach();
 
      },
      clickChangeCurrent(currentPage){
        this.currentPage=currentPage;
        this.Serach();
        
      },
      Serach(){
        this.axios.post(this.Global.basePath+'getBalanceRecordsListByCondition',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          balanceRecord:{ 
            bReason:"商户提现",
          }
        })
          .then((res) => {
            this.tableData = res.data.balanceRecordsList
            this.total = res.data.totalCount
          })
      },
      WithdrawClick(row) {  //删除某服务按钮的触发事件
        this.$confirm('将修改为提现完成, 是否已完成操作?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'updateWithdrawState',{
              bId:row.bId,
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
    },
    components:{
        Pagination
    },
  }
</script> 