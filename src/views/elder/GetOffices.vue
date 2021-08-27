<template >
  <div >
    <el-header style="height: 70px;">
      <div style="height: 70px;">
          <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/GetHospitals' }" style="font-size:20px">医院列表</el-breadcrumb-item>
            <el-breadcrumb-item style="font-size:20px">{{this.hName}}-科室列表</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
    </el-header>
    <el-main style="height: 650px;">
        <el-table :data="tableData" style="width: 100%" height="600px">
          <el-table-column prop="oName" label="科室名称" width="240">
          </el-table-column>
            <el-table-column
              label="操作"
              width="200">
              <template slot-scope="scope">
                <el-button @click="routeToDoctor(scope.row)" type="text" size="big">&nbsp;&nbsp;&nbsp;选择该科室</el-button>
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

      }
    },
    created(){
        this.Serach(); //相对于清空关键字的关键字搜索
    },
    methods: {
      Serach(){
        this.axios.post(this.Global.basePath+'getOfficesListByHId',{
          oHId:this.hId
        })
          .then((res) => {
            this.tableData = res.data
          })
      },
      routeToDoctor(row){
        sessionStorage.setItem("oId",row.oId);
        sessionStorage.setItem("oName",row.oName);
        this.$router.push({name:'GetDoctors'})
      },
    },
    components:{
        Pagination
    },
  }
</script>