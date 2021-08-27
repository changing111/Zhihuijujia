const pageSize = 10  //每页默认显示条数
const basePath='http://localhost:9090/' //默认访问后端链接前缀
const cities = [{
        valueCity: '江门',
        label: '江门'
    }, {
        valueCity: '广州',
        label: '广州'
    }, {
        valueCity: '深圳',
        label: '深圳'
    }, {
        valueCity: '珠海',
        label: '珠海'
    }, {
        valueCity: '澳门',
        label: '澳门'
    }, {
        valueCity: '香港',
        label: '香港'
    }, {
        valueCity: '中山',
        label: '中山'
    }, {
        valueCity: '肇庆',
        label: '肇庆'
    }, {
        valueCity: '佛山',
        label: '佛山'
    }, {
        valueCity: '东莞',
        label: '东莞'
    }, {
        valueCity: '惠州',
        label: '惠州'
    }]
const genders = [{
        valueGender: '男',
        label: '男'
    }, {
        valueGender: '女',
        label: '女'
    }]
const marriages = [{
        valueMarriage: '已婚',
        label: '已婚'
    }, {
        valueMarriage: '未婚',
        label: '未婚'
    },{
        valueMarriage: '离婚',
        label: '离婚'
    }, {
        valueMarriage: '丧偶',
        label: '丧偶'
    }]
const disables = [{
        valueDisable: '轻度失能',
        label: '轻度失能'
    }, {
        valueDisable: '中度失能',
        label: '中度失能'
    },{
        valueDisable: '重度失能',
        label: '重度失能'
    }, {
        valueDisable: '能力完好',
        label: '能力完好'
    }]
const workOrderStates = [{
        valueState: '已取消',
        label: '已取消'
    }, {
        valueState: '已下单',
        label: '已下单'
    },{
        valueState: '已完成',
        label: '已完成'
    }]
const BalanceRecordStates = [{
        valueState: '未完成',
        label: '未完成'
    },{
        valueState: '已完成',
        label: '已完成'
    }]
const BalanceRecordReasons = [{
        valueReason: '充值',
        label: '充值'
    },{
        valueReason: '政府福利发放',
        label: '政府福利发放'
    },{
        valueReason: '慈善机构捐助',
        label: '慈善机构捐助'
    },{
        valueReason: '商户提现',
        label: '商户提现'
    },{
        valueReason: '扣款-下单服务',
        label: '扣款-下单服务'
    },{
        valueReason: '入账-完成订单',
        label: '入账-完成订单'
    },{
        valueReason: '退款-取消订单',
        label: '退款-取消订单'
    }]  
const ElderBalanceReasons= [{
        valueReason: '充值',
        label: '充值'
    },{
        valueReason: '政府福利发放',
        label: '政府福利发放'
    },{
        valueReason: '慈善机构捐助',
        label: '慈善机构捐助'
    },{
        valueReason: '扣款-下单服务',
        label: '扣款-下单服务'
    },{
        valueReason: '退款-取消订单',
        label: '退款-取消订单'
    }]  
const ShopBalanceReasons= [{
    valueReason: '商户提现',
    label: '商户提现'
},{
    valueReason: '入账-完成订单',
    label: '入账-完成订单'
}]  

const Invest= [{
    valueInvest: '充值',
    label: '充值'
},{
    valueInvest: '政府福利发放',
    label: '政府福利发放'
},{
    valueInvest: '慈善机构捐助',
    label: '慈善机构捐助'
}]
const VolActivityStates = [{
        valueState: '未结束',
        label: '未结束'
    },{
        valueState: '已结束',
        label: '已结束'
    }] 
const VolBookStates = [{
        valueState: '已报名',
        label: '已报名'
    },{
        valueState: '已完成',
        label: '已完成'
    }]
export default {
    basePath,pageSize,cities,genders,marriages,disables,workOrderStates,BalanceRecordStates,BalanceRecordReasons,Invest,VolActivityStates,VolBookStates,ShopBalanceReasons,ElderBalanceReasons

}