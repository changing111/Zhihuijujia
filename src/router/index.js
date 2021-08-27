import Vue from 'vue'
import Router from 'vue-router'
import Default from '@/components/Default'
import AdminIndex from '@/views/admin/AdminIndex'
import AdminLogin from '@/views/admin/AdminLogin'
import ElderLogin from '@/views/elder/ElderLogin'
import ShopLogin from '@/views/shop/ShopLogin'
import HospitalLogin from '@/views/hospital/HospitalLogin'
import VolStationLogin from '@/views/volStation/VolStationLogin'
import VolunteerLogin from '@/views/volunteer/VolunteerLogin'
import ElderList from '@/views/admin/ElderList'
import ElderAdd from '@/views/admin/ElderAdd'
import ElderAdds from '@/views/admin/ElderAdds'
import BalanceRecord from '@/views/admin/BalanceRecord'
import BalanceInvest from '@/views/admin/BalanceInvest'
import BalanceWithdraw from '@/views/admin/BalanceWithdraw'
import HospitalList from '@/views/admin/HospitalList'
import HospitalAdd from '@/views/admin/HospitalAdd'
import ManageAccount from '@/views/admin/ManageAccount'
import ManageAdd from '@/views/admin/ManageAdd'
import ShopAdd from '@/views/admin/ShopAdd'
import ShopList from '@/views/admin/ShopList'
import WorkOrdersList from '@/views/admin/WorkOrdersList'
import VolStationAdd from '@/views/admin/VolStationAdd'
import VolStationList from '@/views/admin/VolStationList'
import VolActivity from '@/views/admin/VolActivity';
import Volunteer from '@/views/admin/Volunteer';
import Office from '@/views/admin/Office';
import Doctor from '@/views/admin/Doctor';
import Register from '@/views/admin/Register';
import Remain from '@/views/admin/Remain';
import VolBookByVId from '@/views/admin/VolBookByVId';
import VolBookByVaId from '@/views/admin/VolBookByVaId';
import RegistersList from '@/views/admin/RegistersList';
import VolStationIndex from '@/views/volStation/VolStationIndex';
import MyVolStation from '@/views/volStation/MyVolStation';
import MyVolActivitysList from '@/views/volStation/MyVolActivitysList';
import MyVolunteersList from '@/views/volStation/MyVolunteersList';
import VolActivityAdd from '@/views/volStation/VolActivityAdd';
import VolunteerAdd from '@/views/volStation/VolunteerAdd';
import vsEldersList from '@/views/volStation/vsEldersList';
import vsChangePass from '@/views/volStation/vsChangePass';
import vsBookByVaId from '@/views/volStation/vsBookByVaId';
import vsBookByVId from '@/views/volStation/vsBookByVId';
import MyVolActivity from '@/views/volunteer/MyVolActivity';
import MyVolunteer from '@/views/volunteer/MyVolunteer';
import vChangePass from '@/views/volunteer/vChangePass';
import VolActivitysList from '@/views/volunteer/VolActivitysList';
import VolunteerIndex from '@/views/volunteer/VolunteerIndex';
import DoctorsList from '@/views/hospital/DoctorsList';
import MyHospital from '@/views/hospital/MyHospital';
import OfficesList from '@/views/hospital/OfficesList';
import RegistersListByHId from '@/views/hospital/RegistersListByHId';
import RegisterByRemId from '@/views/hospital/RegisterByRemId';
import RemainsList from '@/views/hospital/RemainsList';
import HospitalIndex from '@/views/hospital/HospitalIndex';
import MyBalanceRecordsList from '@/views/shop/MyBalanceRecordsList';
import MyShop from '@/views/shop/MyShop';
import MyShopGoodsList from '@/views/shop/MyShopGoodsList';
import MyWorkOrdersList from '@/views/shop/MyWorkOrdersList';
import Withdraw from '@/views/shop/Withdraw';
import ShopIndex from '@/views/shop/ShopIndex';
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
import ElderIndex from '@/views/elder/ElderIndex';

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Default',
      component: Default
    }
    ,
    {
      path: '/AdminLogin',
      name: 'AdminLogin',
      component: AdminLogin
    }
    ,
    {
      path: '/ElderLogin',
      name: 'ElderLogin',
      component: ElderLogin
    }
    ,
    {
      path: '/HospitalLogin',
      name: 'HospitalLogin',
      component: HospitalLogin
    }
    ,
    {
      path: '/ShopLogin',
      name: 'ShopLogin',
      component: ShopLogin
    }
    ,
    {
      path: '/VolStationLogin',
      name: 'VolStationLogin',
      component: VolStationLogin
    }
    ,
    {
      path: '/VolunteerLogin',
      name: 'VolunteerLogin',
      component: VolunteerLogin
    }
    ,
    {
      path: '/ElderIndex',
      name: 'ElderIndex',
      component: ElderIndex,
      children:[
        {
          path: '/GetHospitals',
          name: 'GetHospitals',
          component: GetHospitals,
        },
        {
          path: '/GetDoctors',
          name: 'GetDoctors',
          component: GetDoctors,
        },
        {
          path: '/GetMyBalanceRecords',
          name: 'GetMyBalanceRecords',
          component: GetMyBalanceRecords,
        },
        {
          path: '/GetMyRegisters',
          name: 'GetMyRegisters',
          component: GetMyRegisters,
        },
        {
          path: '/GetMyVolActivitys',
          name: 'GetMyVolActivitys',
          component: GetMyVolActivitys,
        },
        {
          path: '/GetMyWorkOrders',
          name: 'GetMyWorkOrders',
          component: GetMyWorkOrders,
        },
        {
          path: '/GetOffices',
          name: 'GetOffices',
          component: GetOffices,
        },
        {
          path: '/GetRemains',
          name: 'GetRemains',
          component: GetRemains,
        },
        {
          path: '/GetShopGoods',
          name: 'GetShopGoods',
          component: GetShopGoods,
        },
        {
          path: '/GetShops',
          name: 'GetShops',
          component: GetShops,
        },
        {
          path: '/GetVolStation',
          name: 'GetVolStation',
          component: GetVolStation,
        },
        {
          path: '/Invest',
          name: 'Invest',
          component: Invest,
        },
        {
          path: '/MyElder',
          name: 'MyElder',
          component: MyElder,
        },
      ]
    },
    {
      path: '/ShopIndex',
      name: 'ShopIndex',
      component: ShopIndex,
      children:[
        {
          path: '/MyBalanceRecordsList',
          name: 'MyBalanceRecordsList',
          component: MyBalanceRecordsList,
        },
        {
          path: '/MyShop',
          name: 'MyShop',
          component: MyShop,
        },
        {
          path: '/MyShopGoodsList',
          name: 'MyShopGoodsList',
          component: MyShopGoodsList,
        },
        {
          path: '/MyWorkOrdersList',
          name: 'MyWorkOrdersList',
          component: MyWorkOrdersList,
        },
        {
          path: '/Withdraw',
          name: 'Withdraw',
          component: Withdraw,
        },
      ]
    },
    {
      path: '/HospitalIndex',
      name: 'HospitalIndex',
      component: HospitalIndex,
      children:[
        {
          path: '/DoctorsList',
          name: 'DoctorsList',
          component: DoctorsList,
        },
        {
          path: '/MyHospital',
          name: 'MyHospital',
          component: MyHospital,
        },
        {
          path: '/OfficesList',
          name: 'OfficesList',
          component: OfficesList,
        },
        {
          path: '/RegistersListByHId',
          name: 'RegistersListByHId',
          component: RegistersListByHId,
        },
        {
          path: '/RegisterByRemId',
          name: 'RegisterByRemId',
          component: RegisterByRemId,
        },
        {
          path: '/RemainsList',
          name: 'RemainsList',
          component: RemainsList,
        },
      ]
    },
    {
      path: '/VolunteerIndex',
      name: 'VolunteerIndex',
      component: VolunteerIndex,
      children:[
        {
          path: '/MyVolunteer',
          name: 'MyVolunteer',
          component: MyVolunteer,
        },
        {
          path: '/MyVolActivity',
          name: 'MyVolActivity',
          component: MyVolActivity,
        },
        {
          path: '/vChangePass',
          name: 'vChangePass',
          component: vChangePass,
        },
        {
          path: '/VolActivitysList',
          name: 'VolActivitysList',
          component: VolActivitysList,
        },
      ]
    },
    {
      path: '/VolStationIndex',
      name: 'VolStationIndex',
      component: VolStationIndex,
      children:[
        {
          path: '/MyVolStation',
          name: 'MyVolStation',
          component: MyVolStation,
        },
        {
          path: '/MyVolActivitysList',
          name: 'MyVolActivitysList',
          component: MyVolActivitysList,
        },
        {
          path: '/MyVolunteersList',
          name: 'MyVolunteersList',
          component: MyVolunteersList,
        },
        {
          path: '/VolActivityAdd',
          name: 'VolActivityAdd',
          component: VolActivityAdd,
        },
        {
          path: '/VolunteerAdd',
          name: 'VolunteerAdd',
          component: VolunteerAdd,
        },
        {
          path: '/vsEldersList',
          name: 'vsEldersList',
          component: vsEldersList,
        },
        {
          path: '/vsChangePass',
          name: 'vsChangePass',
          component: vsChangePass,
        },
        {
          path: '/vsBookByVId',
          name: 'vsBookByVId',
          component: vsBookByVId,
        },
        {
          path: '/vsBookByVaId',
          name: 'vsBookByVaId',
          component: vsBookByVaId,
        },
      ]
    }
    ,
    {
      path: '/AdminIndex',
      name: 'AdminIndex',
      component: AdminIndex,
      children:[
        {
          path: '/ElderList',
          name: 'ElderList',
          component: ElderList,
        },
        {
          path: '/ElderAdd',
          name: 'ElderAdd',
          component: ElderAdd,
        },
        {
          path: '/ElderAdds',
          name: 'ElderAdds',
          component: ElderAdds,
        },
        {
          path: '/BalanceRecord',
          name: 'BalanceRecord',
          component: BalanceRecord,
        },
        {
          path: '/BalanceInvest',
          name: 'BalanceInvest',
          component: BalanceInvest,
        },
        {
          path: '/BalanceWithdraw',
          name: 'BalanceWithdraw',
          component: BalanceWithdraw,
        },
        {
          path: '/HospitalList',
          name: 'HospitalList',
          component: HospitalList,
        },
        {
          path: '/HospitalAdd',
          name: 'HospitalAdd',
          component: HospitalAdd,
        },
        {
          path: '/ManageAccount',
          name: 'ManageAccount',
          component: ManageAccount,
        },
        {
          path: '/ManageAdd',
          name: 'ManageAdd',
          component: ManageAdd,
        },
        {
          path: '/ShopAdd',
          name: 'ShopAdd',
          component: ShopAdd,
        },
        {
          path: '/ShopList',
          name: 'ShopList',
          component: ShopList,
        },
        {
          path: '/WorkOrdersList',
          name: 'WorkOrdersList',
          component: WorkOrdersList,
        },
        {
          path: '/VolStationAdd',
          name: 'VolStationAdd',
          component: VolStationAdd,
        },
        {
          path: '/VolStationList',
          name: 'VolStationList',
          component: VolStationList,
        },
        {
          path: '/VolActivity',
          name: 'VolActivity',
          component: VolActivity,
        },
        {
          path: '/Volunteer',
          name: 'Volunteer',
          component: Volunteer,
        },
        {
          path: '/Office',
          name: 'Office',
          component: Office,
        },
        {
          path: '/Doctor',
          name: 'Doctor',
          component: Doctor,
        },
        {
          path: '/Register',
          name: 'Register',
          component: Register,
        },
        {
          path: '/Remain',
          name: 'Remain',
          component: Remain,
        },
        {
          path: '/RegistersList',
          name: 'RegistersList',
          component: RegistersList,
        },
        {
          path: '/VolBookByVId',
          name: 'VolBookByVId',
          component: VolBookByVId,
        },
        {
          path: '/VolBookByVaId',
          name: 'VolBookByVaId',
          component: VolBookByVaId,
        },
      ]
    }

  ]
})
// Vue.component('login', Login)