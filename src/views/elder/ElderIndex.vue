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
                    <el-menu-item index="1" disabled>您好！长者：{{eName}}</el-menu-item>
                    <el-submenu index="2" >
                        <template slot="title">个人中心</template>
                        <el-menu-item index="MyElder">修改资料</el-menu-item>
                        <el-menu-item index="MyElder">修改密码</el-menu-item>
                        </el-submenu>
                    <el-menu-item  @click="unLogin">退出账号</el-menu-item>
               </el-menu>
                 
            </el-header>
            <el-container >
            <el-aside id="left" width="220px" style="height: 845px;">
                <el-menu router :default-openeds="['1','2','3','4']"  >
                <el-submenu index="1">
                    <template slot="title"><i class="el-icon-menu"></i>有偿服务</template>                  
                    <el-menu-item index="GetShops">下单服务</el-menu-item> 
                    <el-menu-item index="GetMyWorkOrders">历史工单</el-menu-item>                             
                </el-submenu>
                <el-submenu index="2">
                    <template slot="title"><i class="el-icon-menu"></i>志愿服务</template>                  
                    <el-menu-item index="GetVolStation">申请志愿服务</el-menu-item> 
                    <el-menu-item index="GetMyVolActivitys">历史志愿服务</el-menu-item>                             
                </el-submenu>
                <el-submenu index="3">
                    <template slot="title"><i class="el-icon-menu"></i>挂号服务</template>                  
                    <el-menu-item index="GetHospitals">预约挂号</el-menu-item> 
                    <el-menu-item index="GetMyRegisters">历史挂号纪录</el-menu-item>                             
                </el-submenu>
                <el-submenu index="4">
                    <template slot="title"><i class="el-icon-menu"></i>个人中心</template>                  
                    <el-menu-item index="GetMyBalanceRecords">服务币交易纪录</el-menu-item> 
                    <el-menu-item index="Invest">充值服务币</el-menu-item>      
                    <el-menu-item index="MyElder">修改个人资料</el-menu-item>                         
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
import GetHospitals from '@/views/elder/GetHospitals';
import GetDoctors from '@/views/elder/GetDoctors';
import GetMyBalanceRecords from '@/views/elder/GetMyBalanceRecords';
import GetMyRegisters from '@/views/elder/GetMyRegisters';
import GetMyVolActivitys from '@/views/elder/GetMyVolActivitys';
import GetMyWorkOrders from '@/views/elder/GetMyWorkOrders';
import GetOffices from '@/views/elder/GetOffices';
import GetRemains from '@/views/elder/GetRemains';
import GetShopGoods from '@/views/elder/GetShopGoods';
import GetShops from '@/views/elder/GetShops';
import GetVolStation from '@/views/elder/GetVolStation';
import Invest from '@/views/elder/Invest';
import MyElder from '@/views/elder/MyElder';

  export default {
    data() {
      return {
        uId:'',
        eId:'',
        eName:'',
      }     
    },
    methods:{
      unLogin(){
        sessionStorage.removeItem("uId"),
        this.$router.push('/ElderLogin')
      }
    },
    components:{
       GetHospitals,GetDoctors,GetMyBalanceRecords,GetMyRegisters,GetMyVolActivitys,GetMyWorkOrders,GetOffices,GetRemains,GetShopGoods
       ,GetShops,GetVolStation,Invest,MyElder
    },
    created() {
        this.axios.post(this.Global.basePath+'getElderByEPhoneNum',{
            ePhoneNum:sessionStorage.getItem("uId"),
        })
          .then((res) => {
            sessionStorage.setItem("eId",res.data.eId);
            sessionStorage.setItem("eName",res.data.eName);
            sessionStorage.setItem("eCity",res.data.eCity);
            sessionStorage.setItem("eAddress",res.data.eAddress);
            this.eName=sessionStorage.getItem("eName");
          });
        if (sessionStorage.getItem("uId")==null) {
            this.$router.push('/ElderLogin')
        }
  
    },
  };
</script>