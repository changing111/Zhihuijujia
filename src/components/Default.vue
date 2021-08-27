<template >
<el-container>
            <el-header id="header" style="height: 60px;display:flex;line-height: 60px;">
                <Title style="width: 1500px;display:flex;line-height: 60px;"></Title>
               <el-menu
               :default-active="'/'"
               router
                id="header-right"
                class="el-menu-demo"
                mode="horizontal"
                text-color="#000"
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
              <div style="height: 800px;">
                  <el-carousel height="800px">
                    <el-carousel-item v-for="item in imagesbox" :key="item.id">
                      <img :src="item.idView" class="image" width="100%" height="100%">
                    </el-carousel-item>
                  </el-carousel>
              </div>
                
              <el-footer id="footer" style="height: 40px;text-align: center; font-size: 20px;line-height: 40px;">
                  <Copyright></Copyright>
              </el-footer>
            </el-container>
          </el-container>
</el-container>
</template>



<style>
@import "../css/style.css"
</style>
<script>
export default {
  name: 'Default',
  methods:{
    
  },
  data () {
    return {
      imagesbox:[{id:0,idView:require("@/assets/Index1.png")},      
                {id:1,idView:require("@/assets/Index2.png")},
                {id:2,idView:require("@/assets/logo.png")}]
      }
    }
  }

</script>
