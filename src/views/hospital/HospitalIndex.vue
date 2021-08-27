<template >
<el-container>
            <el-header id="header" style="height: 60px;width: 100%;display:flex;line-height: 60px;">
                <Title></Title>
               <el-menu
                router
                id="header-right"
                class="el-menu-demo"
                mode="horizontal"
                text-color="#000"
                active-text-color="#ffd04b"
                style="height: 60px;width: 100%;float:right;display:flex;">
                    <el-menu-item index="1" disabled>您好！{{hName}}</el-menu-item>
                    <el-submenu index="2" >
                        <template slot="title">个人中心</template>
                        <el-menu-item index="MyHospital">修改资料</el-menu-item>
                        <el-menu-item index="MyHospital">修改密码</el-menu-item>
                        </el-submenu>
                    <el-menu-item  @click="unLogin">退出账号</el-menu-item>
               </el-menu>
                 
            </el-header>
            <el-container >
            <el-aside id="left" width="220px" style="height: 845px;">
                <el-menu router :default-openeds="['1']"  >
                <el-submenu index="1">
                    <template slot="title"><i class="el-icon-menu"></i>我的医院</template>                  
                    <el-menu-item index="OfficesList">医院管理</el-menu-item> 
                    <el-menu-item index="RegistersListByHId">预约纪录</el-menu-item> 
                    <el-menu-item index="MyHospital">更新资料</el-menu-item>                             
                </el-submenu>

                </el-menu>
            </el-aside>
            <el-container>
              <div style="height: 15px;"></div>
              <div style="height: 790px;">
                  <router-view></router-view>
              </div>
                
              <el-footer id="footer" style="height: 40px;text-align: center; font-size: 20px;line-height: 40px;">
                  <Copyright></Copyright>
              </el-footer>
            </el-container>
          </el-container>
</el-container>
</template>
<style>
@import "../../css/style.css"
</style>

<script>
import DoctorsList from '@/views/hospital/DoctorsList';
import MyHospital from '@/views/hospital/MyHospital';
import OfficesList from '@/views/hospital/OfficesList';
import RegistersListByHId from '@/views/hospital/RegistersListByHId';
import RegisterByRemId from '@/views/hospital/RegisterByRemId';
import RemainsList from '@/views/hospital/RemainsList';

  export default {
    data() {
      return {
        uId:'',
        hId:'',
        hName:'',
      }     
    },
    methods:{
      unLogin(){
        sessionStorage.removeItem("uId"),
        this.$router.push('/HospitalLogin')
      }
    },
    components:{
       DoctorsList,MyHospital,OfficesList,RegistersListByHId,RegisterByRemId,RemainsList
    },
    created() {
        this.axios.post(this.Global.basePath+'getHospitalByHAdminPhone',{
            hAdminPhone:sessionStorage.getItem("uId"),
        })
          .then((res) => {
            sessionStorage.setItem("hId",res.data.hId);
            sessionStorage.setItem("hName",res.data.hName);
            this.uId=sessionStorage.getItem("hId");
            this.hName=sessionStorage.getItem("hName");
          });
        if (sessionStorage.getItem("uId")==null) {
            this.$router.push('/HospitalLogin')
        }
  
    },
  };
</script>