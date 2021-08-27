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
                    <el-menu-item index="1" disabled>您好！{{vsName}}</el-menu-item>
                    <el-submenu index="2" >
                        <template slot="title">个人中心</template>
                        <el-menu-item index="MyVolStation">修改资料</el-menu-item>
                        <el-menu-item index="vsChangePass">修改密码</el-menu-item>
                        </el-submenu>
                    <el-menu-item  @click="unLogin">退出账号</el-menu-item>
               </el-menu>
                 
            </el-header>
            <el-container >
            <el-aside id="left" width="220px" style="height: 845px;">
                <el-menu router :default-openeds="['1','2']"  >
                <el-submenu index="1">
                    <template slot="title"><i class="el-icon-menu"></i>我的志愿站</template>                  
                    <el-menu-item index="MyVolunteersList">义工列表</el-menu-item> 
                    <el-menu-item index="MyVolActivitysList">活动列表</el-menu-item> 
                    <el-menu-item index="vsEldersList">长者列表</el-menu-item>                  
                    <el-menu-item index="VolActivityAdd">发布活动</el-menu-item>
                    <el-menu-item index="VolunteerAdd">新增义工</el-menu-item>
                    
                </el-submenu>
                <el-submenu index="2">
                    <template slot="title"><i class="el-icon-menu"></i>个人中心</template>
                    <el-menu-item index="MyVolStation">修改资料</el-menu-item>
                    <el-menu-item index="vsChangePass">修改密码</el-menu-item>
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
import vsEldersList from '@/views/volStation/vsEldersList';
import MyVolStation from '@/views/volStation/MyVolStation';
import VolunteerAdd from '@/views/volStation/VolunteerAdd';
import VolActivityAdd from '@/views/volStation/VolActivityAdd';
import MyVolunteersList from '@/views/volStation/MyVolunteersList';
import vsChangePass from '@/views/volStation/vsChangePass';
import MyVolActivitysList from '@/views/volStation/MyVolActivitysList';
import vsBookByVaId from '@/views/volStation/vsBookByVaId';
import vsBookByVId from '@/views/volStation/vsBookByVId';


  export default {
    data() {
      return {
        uId:'',
        vsId:'',
        vsName:'',
        vsAdminName:'',
        vsCity:'',
      }     
    },
    methods:{
      unLogin(){
        sessionStorage.removeItem("uId"),
        sessionStorage.removeItem("uAuthor"),  
        this.$router.push('/VolStationLogin')
      }
    },
    components:{
       vsEldersList,MyVolStation,VolunteerAdd,VolActivityAdd,MyVolunteersList,vsChangePass,MyVolActivitysList,vsBookByVId,vsBookByVaId
    },
    created() {
        this.axios.post(this.Global.basePath+'getVolStationByVsAdminPhone',{
            vsAdminPhone:sessionStorage.getItem("uId"),
        })
          .then((res) => {
            sessionStorage.setItem("vsId",res.data.vsId);
            sessionStorage.setItem("vsName",res.data.vsName);
            sessionStorage.setItem("vsAdminName",res.data.vsAdminName);
            sessionStorage.setItem("vsCity",res.data.vsCity);
            this.uId=sessionStorage.getItem("uId");
            this.vsId=sessionStorage.getItem("vsId");
            this.vsName=sessionStorage.getItem("vsName");
            this.vsAdminName=sessionStorage.getItem("vsAdminName");
            this.vsCity=sessionStorage.getItem("vsCity");
          })
      if (sessionStorage.getItem("uId")==null) {
        this.$router.push('/VolStationLogin')
      }
    },
  };
</script>