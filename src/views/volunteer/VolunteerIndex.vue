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
                    <el-menu-item index="1" disabled>您好！志愿者：{{vName}}</el-menu-item>
                    <el-submenu index="2" >
                        <template slot="title">个人中心</template>
                        <el-menu-item index="MyVolunteer">修改资料</el-menu-item>
                        <el-menu-item index="vChangePass">修改密码</el-menu-item>
                        </el-submenu>
                    <el-menu-item  @click="unLogin">退出账号</el-menu-item>
               </el-menu>
                 
            </el-header>
            <el-container >
            <el-aside id="left" width="220px" style="height: 845px;">
                <el-menu router :default-openeds="['1','2']"  >
                <el-submenu index="1">
                    <template slot="title"><i class="el-icon-menu"></i>志愿活动</template>                  
                    <el-menu-item index="VolActivitysList">志愿活动列表</el-menu-item> 
                    <el-menu-item index="MyVolActivity">我的志愿活动</el-menu-item>    
                </el-submenu>
                <el-submenu index="2">
                    <template slot="title"><i class="el-icon-menu"></i>个人中心</template>
                    <el-menu-item index="MyVolunteer">修改资料</el-menu-item>
                    <el-menu-item index="vChangePass">修改密码</el-menu-item>
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
import MyVolunteer from '@/views/volunteer/MyVolunteer';
import MyVolActivity from '@/views/volunteer/MyVolActivity';
import vChangePass from '@/views/volunteer/vChangePass';
import VolActivitysList from '@/views/volunteer/VolActivitysList';


  export default {
    data() {
      return {
        uId:'',
        vVsId:'',
        vName:'',
        vVsName:'',
        vId:'',
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
       MyVolunteer,MyVolActivity,vChangePass,VolActivitysList
    },
    created() {
        this.axios.post(this.Global.basePath+'getVolunteerByVPhone',{
            vPhone:sessionStorage.getItem("uId"),
        })
          .then((res) => {
            sessionStorage.setItem("vVsId",res.data.vVsId);
            sessionStorage.setItem("vId",res.data.vId);
            sessionStorage.setItem("vName",res.data.vName);
            sessionStorage.setItem("vVsName",res.data.vVsName);
            this.uId=sessionStorage.getItem("uId");
            this.vVsId=sessionStorage.getItem("vVsId");
            this.vId=sessionStorage.getItem("vId");
            this.vName=sessionStorage.getItem("vName");
          })
      if (sessionStorage.getItem("uId")==null) {
        this.$router.push('/VolunteerLogin')
      }
    },
  };
</script>