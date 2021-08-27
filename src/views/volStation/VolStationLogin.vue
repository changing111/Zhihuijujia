<template>  
    <el-container>
            <el-header id="header" style="height: 60px;width: 100%;display:flex;line-height: 60px;">
                <Title style="width: 1500px;display:flex;line-height: 60px;"></Title>
               <el-menu
               :default-active="'/VolStationLogin'"
               router
                id="header-right"
                class="el-menu-demo"
                mode="horizontal"
                text-color="#475669"
                active-text-color="#ff8342"
                style="height: 60px;width: 100%;float:right;display:flex;">
                    <el-menu-item index="/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;首页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</el-menu-item>
                    <el-menu-item index="/AdminLogin">&nbsp;平台管理员入口&nbsp;</el-menu-item>
                    <el-menu-item index="/ElderLogin">&nbsp;&nbsp;&nbsp;&nbsp;长者入口&nbsp;&nbsp;&nbsp;&nbsp;</el-menu-item>
                    <el-menu-item index="/ShopLogin">&nbsp;&nbsp;&nbsp;&nbsp;商户入口&nbsp;&nbsp;&nbsp;&nbsp;</el-menu-item>
                    <el-menu-item index="/HospitalLogin">&nbsp;医院管理者入口&nbsp;</el-menu-item>
                    <el-menu-item index="/VolStationLogin">志愿站负责人入口</el-menu-item>
                    <el-menu-item index="/VolunteerLogin">&nbsp;&nbsp;&nbsp;志愿者入口&nbsp;&nbsp;&nbsp;</el-menu-item>
                    
               </el-menu>
                 
            </el-header>
            <el-container >
            <el-container>
              <div id="LoginBackground">
                  <div style="height: 60px;"></div>
                  <div style="width: 430px;text-align: center;margin:0 auto;">
                  <h1 style="font-size: 30px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;志愿站负责人登录</h1>
                  <Login @getRuleForm="login"></Login>
                  </div>
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
import Login from '../../components/Login'
export default {
    data() {    
      return {
        
      };
    },
    methods: {
      login(data){
        this.axios.post(this.Global.basePath+'loginVolStation', {
            vsAdminPhone:data.phone,
            vsAdminPass:data.pass
          })
          .then((res) => {
            if (res.data==1) {
              alert("登录成功！");
              sessionStorage.setItem("uId",data.phone);
              sessionStorage.setItem("uAuthor",2);
              this.$router.push({name:'VolStationIndex'})
            } else {
              alert("手机号或密码错误！")
            }
          })
      }
    },
    components:{
        Login
    },
    created(){
      history.pushState(null, null, document.URL);
      window.addEventListener('popstate', function () {
      history.pushState(null, null, document.URL);
      });
    }

  }
</script>