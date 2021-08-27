<template >
  <div >
    <el-header style="height: 50px;">
      <div style="height: 50px;">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/OfficesList' }" style="font-size:20px">{{this.hName}}-科室列表</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/DoctorsList' }" style="font-size:20px">{{this.oName}}-医生列表</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/RemainsList' }" style="font-size:20px">{{this.dName}}医生-余号表</el-breadcrumb-item>
            <el-breadcrumb-item style="font-size:20px">{{this.regDate}}-挂号记录</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
    </el-header>
    <el-main style="height: 690px;">
        <el-table :data="tableData" style="width: 100%" height="650px">
          <el-table-column prop="regId" label="预约单号" width="200">
          </el-table-column>
          <el-table-column prop="regEName" label="长者姓名" width="160">
          </el-table-column>
          <el-table-column prop="regEPhoneNum" label="长者手机号" width="240">
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
        regDate:sessionStorage.getItem("regDate"),
        regDPhoneNum:sessionStorage.getItem("regDPhoneNum"),
      }
    },
    created(){
        this.Serach(); //相对于清空关键字的关键字搜索
    },
    methods: {
      Serach(){
        this.axios.post(this.Global.basePath+'getRegistersListByDPhoneAndDate',{
          regDPhoneNum:this.regDPhoneNum,
          regDate:this.regDate,
        })
          .then((res) => {
            this.tableData = res.data
          })
      },
      deleteClick(row) {  //删除按钮的触发事件
        this.$confirm('此操作将删除该预约纪录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'deleteRemain',{
              remId:row.remId,
              remDate:row.remDate,
              remDPhoneNum:row.remDPhoneNum,
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
      
    },
    components:{
        Pagination
    },
  }
</script>