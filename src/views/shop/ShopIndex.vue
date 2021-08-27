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
                    <el-menu-item index="1" disabled>您好！{{sName}}</el-menu-item>
                    <el-submenu index="2" >
                        <template slot="title">个人中心</template>
                        <el-menu-item index="MyShop">修改资料</el-menu-item>
                        <el-menu-item index="MyShop">修改密码</el-menu-item>
                        </el-submenu>
                    <el-menu-item  @click="unLogin">退出账号</el-menu-item>
               </el-menu>
                 
            </el-header>
            <el-container >
            <el-aside id="left" width="220px" style="height: 845px;">
                <el-menu router :default-openeds="['1']"  >
                <el-submenu index="1">
                    <template slot="title"><i class="el-icon-menu"></i>我的店铺</template>                  
                    <el-menu-item index="MyShopGoodsList">已上架的服务</el-menu-item> 
                    <el-menu-item index="MyWorkOrdersList">工单纪录</el-menu-item>     
                    <el-menu-item index="Withdraw">我的服务币</el-menu-item>  
                    <el-menu-item index="MyBalanceRecordsList">交易纪录</el-menu-item>  
                    <el-menu-item index="MyShop">更新资料</el-menu-item>                          
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
import MyBalanceRecordsList from '@/views/shop/MyBalanceRecordsList';
import MyShop from '@/views/shop/MyShop';
import MyShopGoodsList from '@/views/shop/MyShopGoodsList';
import MyWorkOrdersList from '@/views/shop/MyWorkOrdersList';
import Withdraw from '@/views/shop/Withdraw';

  export default {
    data() {
      return {
        uId:'',
        sId:'',
        sName:'',
      }     
    },
    methods:{
      unLogin(){
        sessionStorage.removeItem("uId"),
        this.$router.push('/ShopLogin')
      }
    },
    components:{
       MyBalanceRecordsList,MyShop,MyShopGoodsList,MyWorkOrdersList,Withdraw
    },
    created() {
        this.axios.post(this.Global.basePath+'getShopBySPhoneNum',{
            sPhoneNum:sessionStorage.getItem("uId"),
        })
          .then((res) => {
            sessionStorage.setItem("sId",res.data.sId);
            sessionStorage.setItem("sName",res.data.sName);
            this.uId=sessionStorage.getItem("sId");
            this.sName=sessionStorage.getItem("sName");
          });
        if (sessionStorage.getItem("uId")==null) {
            this.$router.push('/ShopLogin')
        }
  
    },
  };
</script>