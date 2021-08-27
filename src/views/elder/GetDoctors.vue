<template >
  <div >
    <el-header style="height: 70px;">
      <div style="height: 50px;">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/GetHospitals' }" style="font-size:20px">医院列表</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/GetOffices' }" style="font-size:20px">{{this.hName}}-科室列表</el-breadcrumb-item>
            <el-breadcrumb-item style="font-size:20px">{{this.oName}}-医生列表</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
    </el-header>
    <el-main style="height: 650px;">
        <el-table :data="tableData" style="width: 100%" height="600px">
          <el-table-column prop="dName" label="医生姓名" width="200">
          </el-table-column>
          <el-table-column prop="dGender" label="性别" width="160">
          </el-table-column>
          <el-table-column prop="dContent" label="介绍" width="240">
          </el-table-column>
          <el-table-column prop="dPhoneNum" label="手机号码" width="240">
          </el-table-column>
            <el-table-column
              label="操作"
              width="200">
              <template slot-scope="scope">
                <el-button @click="routeToRemain(scope.row)" type="text" size="big">&nbsp;&nbsp;&nbsp;选择该医生</el-button>
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
      }
    },
    created(){
        this.Serach(); //相对于清空关键字的关键字搜索
    },
    methods: {
      Serach(){
        this.axios.post(this.Global.basePath+'getDoctorsListByOId',{
          dOId:this.oId
        })
          .then((res) => {
            this.tableData = res.data
          })
      },     
      routeToRemain(row){
        sessionStorage.setItem("dName",row.dName);
        sessionStorage.setItem("dPhoneNum",row.dPhoneNum);
        this.$router.push({name:'GetRemains'})
      }
    },
    components:{
        Pagination
    },
  }
</script>