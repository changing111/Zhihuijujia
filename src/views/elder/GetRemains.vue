<template >
  <div >
    <el-header style="height: 70px;">
      <div style="height: 50px;">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/GetHospitals' }" style="font-size:20px">医院列表</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/GetOffices' }" style="font-size:20px">{{this.hName}}-科室列表</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/GetDoctors' }" style="font-size:20px">{{this.oName}}-医生列表</el-breadcrumb-item>
            <el-breadcrumb-item style="font-size:20px">{{this.dName}}医生-余号表</el-breadcrumb-item>
        </el-breadcrumb>
        <div style="height: 20px;"></div>
      </div>
    </el-header>
    <el-main style="height: 650px;">
        <el-table :data="tableData" style="width: 100%" height="600px">
          <el-table-column prop="remDate" label="日期" width="200" sortable>
          </el-table-column>
          <el-table-column prop="remSum" label="总号数" width="160">
          </el-table-column>
          <el-table-column prop="remNum" label="余号数" width="240">
          </el-table-column>
            <el-table-column
              label="操作"
              width="200">
              <template slot-scope="scope">
                  <el-button v-if="new Date().getTime()>=new Date(scope.row.remDate).getTime()" disabled type="text" size="big">已过期</el-button>
                <el-button v-if="new Date().getTime()<new Date(scope.row.remDate).getTime()" @click="addRegisterClick(scope.row)" type="text" size="big">挂号</el-button>
              </template>
            </el-table-column>
        </el-table>
    </el-main>
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
        dName:sessionStorage.getItem("dName"),
        dPhoneNum:sessionStorage.getItem("dPhoneNum"),

      }
    },
    created(){
        this.Serach(); //相对于清空关键字的关键字搜索
    },
    methods: {
      Serach(){
        this.axios.post(this.Global.basePath+'getRemainsListByDPhoneNum',{
          remDPhoneNum:this.dPhoneNum
        })
          .then((res) => {
            this.tableData = res.data
          })
      },
      addRegisterClick(row) {  //挂号按钮的触发事件
        this.$confirm('将挂一个'+this.dName+'医生的号,日期是'+row.remDate+', 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'addRegister',{
              regDName:this.dName,
              regDate:row.remDate,
              regDPhoneNum:row.remDPhoneNum,
              regEName:sessionStorage.getItem("eName"),
              regEPhoneNum:sessionStorage.getItem("uId"),
            })
              .then((res) => {
                if (res.data==1) {
                  this.$message({
                    type: 'success',
                    message: '挂号成功!'
                  });
                  this.Serach();//刷新页面
                } else {
                  this.$alert('您已经挂过当天'+this.dName+'医生的号了，请勿重复挂号！', '挂号失败', {
                    confirmButtonText: '确定',
                  });
                }
              })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消挂号'
          });          
        });
      },     
    },
    components:{
        Pagination
    },
  }
</script>