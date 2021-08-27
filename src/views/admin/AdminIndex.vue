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
                active-text-color="#ff8342"
                style="height: 60px;width: 100%;float:right;display:flex;">
                    <el-menu-item index="1" disabled >您好！{{uString}}:{{uId}}</el-menu-item>
                    <el-submenu index="2">
                        <template slot="title">个人中心</template>
                        <el-menu-item index="2-1" disabled>修改资料</el-menu-item>
                        <el-menu-item index="ManageAccount">修改密码</el-menu-item>
                        </el-submenu>
                    <el-menu-item  @click="unLogin">退出账号</el-menu-item>
               </el-menu>
                 
            </el-header>
            <el-container >
            <el-aside id="left" width="220px" style="height: 845px;">
                <el-menu router :default-openeds="['1','2','3','4','5','6']">
                <el-submenu index="1">
                    <template slot="title"><i class="el-icon-menu"></i>长者管理</template>                  
                    <el-menu-item index="ElderList">长者列表</el-menu-item>
                    <el-menu-item index="ElderAdd">新增长者</el-menu-item>
                </el-submenu>
                <el-submenu index="2">
                    <template slot="title"><i class="el-icon-menu"></i>交易管理</template>
                    <el-menu-item index="BalanceRecord">服务币变更纪录</el-menu-item>
                    <el-menu-item index="BalanceInvest">充值处理</el-menu-item>
                    <el-menu-item index="BalanceWithdraw">提现处理</el-menu-item>
                </el-submenu>
                <el-submenu index="3">
                    <template slot="title"><i class="el-icon-menu"></i>商户系统管理</template>
                    <el-menu-item index="ShopList">商户列表</el-menu-item>
                    <el-menu-item index="WorkOrdersList">服务工单列表</el-menu-item>
                    <el-menu-item index="ShopAdd">新增商户</el-menu-item>
                </el-submenu>
                <el-submenu index="4">
                    <template slot="title"><i class="el-icon-menu"></i>挂号系统管理</template>
                    <el-menu-item index="HospitalList">医院列表</el-menu-item>
                    <el-menu-item index="HospitalAdd">新增医院</el-menu-item>
                </el-submenu>
                <el-submenu index="5">
                    <template slot="title"><i class="el-icon-menu"></i>义工系统管理</template>
                    <el-menu-item index="VolStationList">义工机构列表</el-menu-item>
                    <el-menu-item index="VolStationAdd">新增义工机构</el-menu-item>
                </el-submenu>
                <el-submenu index="6">
                    <template slot="title"><i class="el-icon-menu"></i>管理员账号管理</template>
                    <el-menu-item index="ManageAccount">管理员账号列表</el-menu-item>
                    <el-menu-item index="ManageAdd">新增管理员</el-menu-item>
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
import ElderList from '@/views/admin/ElderList';
import ElderAdd from '@/views/admin/ElderAdd';
import ElderAdds from '@/views/admin/ElderAdds';
import ShopList from '@/views/admin/ShopList';
import WorkOrdersList from '@/views/admin/WorkOrdersList';
import ShopAdd from '@/views/admin/ShopAdd';
import BalanceRecord from '@/views/admin/BalanceRecord';
import BalanceInvest from '@/views/admin/BalanceInvest';
import BalanceWithdraw from '@/views/admin/BalanceWithdraw';
import ManageAccount from '@/views/admin/ManageAccount';
import ManageAdd from '@/views/admin/ManageAdd';
import VolStationList from '@/views/admin/VolStationList';
import VolStationAdd from '@/views/admin/VolStationAdd';
import VolActivity from '@/views/admin/VolActivity';
import Volunteer from '@/views/admin/Volunteer';
import Office from '@/views/admin/Office';
import Doctor from '@/views/admin/Doctor';
import Register from '@/views/admin/Register';
import Remain from '@/views/admin/Remain';
import VolBookByVId from '@/views/admin/VolBookByVId';
import VolBookByVaId from '@/views/admin/VolBookByVaId';
import RegistersList from '@/views/admin/RegistersList';
  export default {
    data() {
      return {
        uId:sessionStorage.getItem("uId"),
        uString:"管理员", 
      }     
    },
    methods:{
      unLogin(){
        sessionStorage.removeItem("uId"),
        sessionStorage.removeItem("uAuthor"),  
        this.$router.push('/AdminLogin')
      }
    },
    components:{
        ElderAdd,ElderList,ElderAdds,ShopList,WorkOrdersList,ShopAdd,BalanceRecord,BalanceInvest,BalanceWithdraw,ManageAccount,ManageAdd,VolStationList,VolStationAdd
        ,VolActivity,Volunteer,Office,Doctor,Register,Remain,RegistersList,VolBookByVId,VolBookByVaId
    },
    created() {
      if (sessionStorage.getItem("uId")==null) {
        this.$router.push('/AdminLogin')
      }
    },
  };
</script>