<template >
  <div >
    <el-header style="height: 100px;white-space: nowrap;  /*强制span不换行*/
      display: inline-block;  /*将span当做块级元素对待*/
      width: 32px;  /*限制宽度*/
      overflow: hidden;  /*超出宽度部分隐藏*/
      text-overflow: ellipsis;  /*超出部分以点号代替*/
      line-height: 0.9;  /*数字与之前的文字对齐*/">
      <div style="height: 50px;">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item style="font-size:20px">商户列表</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
        
        <span>&nbsp;&nbsp;所在城市:</span>
        <el-select v-model="valueCity" placeholder="请选择所在城市">
          <el-option
            v-for="item in this.Global.cities"
            :key="item.valueCity"
            :label="item.label"
            :value="item.valueCity">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>
        
        <span>&nbsp;&nbsp;商户名称:</span>
        <el-input style="width: 217px;"
          placeholder="请输入商户名称"
          prefix-icon="el-icon-search"
          v-model="inputName">
        </el-input>
        <span>&nbsp;&nbsp;手机号:</span>
        <el-input style="width: 202px;"
          placeholder="请输入手机号"
          prefix-icon="el-icon-search"
          v-model="inputPhone">
        </el-input>
        <el-button plain @click="clickConditionSerach">查找</el-button>
        <el-button plain @click="clickConditionDelete">清空条件</el-button>
        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <el-input style="width: 250px;"
          placeholder="输入关键字"
          prefix-icon="el-icon-search"
          v-model="inputLike">
        </el-input>
        <el-button plain @click="clickKeywordSerach">关键字搜索</el-button>
    </el-header>
    <el-main style="height: 640px;">
        <el-table :data="tableData" style="width: 100%" height="600px">
            <el-table-column prop="sId" label="商户Id" width="220">
            </el-table-column>
            <el-table-column prop="sName" label="商户名称" width="220">
            </el-table-column>
            <el-table-column prop="sHostName" label="店主姓名" width="220">
            </el-table-column>
            <el-table-column prop="sPhoneNum" label="店家手机号" width="200">
            </el-table-column>
            <el-table-column prop="sCity" label="所在城市" width="130">
            </el-table-column>
            <el-table-column prop="sAddress" label="地址" width="300">
            </el-table-column>
            <el-table-column
              fixed="right"
              label="操作"
              width="280">
              <template slot-scope="scope">
                <el-button @click="getShopGoodsClick(scope.row)" type="text" size="big">&nbsp;&nbsp;查看服务</el-button>
              </template>
            </el-table-column>
        </el-table>
    </el-main>
    <el-footer style="text-align: center;">
              <Pagination :total="total" :currentPage=currentPage @SizeChange="clickChangeSize" @CurrentChange="clickChangeCurrent"></Pagination> 
    </el-footer>

    <el-dialog title="填写下单信息" :visible.sync="choiceTimeVisible" style="text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
            <el-form-item label="服务时间" required prop="valueTime">
            <el-date-picker
            value-format="yyyy-MM-dd HH:mm:ss"
            v-model="ruleForm.valueTime"
            type="datetime"
            placeholder="选择日期时间"
            align="right"
            :picker-options="pickerOptions">
            </el-date-picker>
        </el-form-item>
            <el-form-item label="下单数量" prop="valueNum">
                <el-input-number style="width:217px;" v-model="ruleForm.valueNum" @change="NumberChange" :step="1" :min="1" :max="1000" label="当天总号数"></el-input-number> 
            </el-form-item>
        <div></div>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置信息</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <el-dialog title="该商户所提供的服务" :visible.sync="ShopGoodsVisible" style="text-align:center">
      <el-table :data="ShopGoodsData" height="500px" :row-class-name="tableRowClassName">
            <el-table-column prop="sgId" label="服务ID" width="200" >
            </el-table-column>
            <el-table-column prop="sgContent" label="服务内容" width="300" >
            </el-table-column>
            <el-table-column prop="sgPrice" label="服务价格(每次/时)" width="200" sortable>
            </el-table-column>
            <el-table-column
              fixed="right"
              label="操作"
              width="180">
              <template slot-scope="scope">
                <el-button @click="choiceTimeClick(scope.row)" type="text" size="big">下单该服务</el-button>
              </template>
            </el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>
<style>

</style>
<script>
  import Pagination from '../../components/Pagination'
  export default {
    created(){
        this.valueCity=sessionStorage.getItem('eCity');
        this.clickConditionSerach(); //相对于清空关键字的关键字搜索
    },
    data() {
     return {
        tableData: [],//定义表格数据
        total:null,    //定义总条数
        currentPage:1,//定义默认页码
        pageSize:this.Global.pageSize,  //定义默认显示条数
        searchStates:1,//纪录当前查询类别，条件查询是0，关键字查询是1，默认1(方便判断点击分页操作后进行哪种查询)
        inputLike:'',//定义默认关键字为空
        
        valueCity:sessionStorage.getItem('eCity'),
        inputName:'',
        inputPhone:'',
        wSgPrice:'',
        wSgContent:'',
        sPhoneNum:'',
        sName:'',
        sCity:'',
        ruleForm: {
          valueTime: '',
          valueNum: 1,
        },
        rules: {
          valueTime: [
            { required: true, message: '请选择服务时间', trigger: 'change' }
          ],
          valueNum: [
            { type:'number',required: true, message: '请输入数量', trigger: 'change' }
          ],
        },

        ShopGoodsData: [],
        ShopGoodsVisible: false,
        choiceTimeVisible:false,
        
      }
    },
    methods: {
      clickChangeSize(pageSize){
        this.pageSize=pageSize;
        if (this.searchStates==0) {//判断当前是条件查询还是关键字查询
          this.conditionSerach();
        } else {
          this.keywordSerach();
        }
      },
      clickChangeCurrent(currentPage){
        this.currentPage=currentPage;
        if (this.searchStates==0) {//判断当前是条件查询还是关键字查询
          this.conditionSerach();
        } else {
          this.keywordSerach();
        }
      },
      clickConditionSerach(){
        this.currentPage=1; //置当前页为1
        this.inputLike=null; //把关键字搜索置空
        this.searchStates=0;//0纪录当前为条件查询
        this.conditionSerach();//调用条件查询方法
      },
      clickKeywordSerach(){
        this.currentPage=1; //置当前页为1
        this.valueCity=null;  //把条件搜索置空
        this.inputName=null;;
        this.inputPhone=null;
        this.searchStates=1;//1纪录当前为关键字查询
        this.keywordSerach();//调用关键字查询方法
      },
      clickConditionDelete(){ //
          this.currentPage=1; //置当前页为1
          this.inputLike=null;
          this.clickKeywordSerach(); //相对于清空关键字的关键字搜索
      },
      conditionSerach(){
        this.axios.post(this.Global.basePath+'getShopsListByCondition',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          shop:{ 
            sCity:this.valueCity,
            sName:this.inputName,
            sPhoneNum:this.inputPhone
          }
        })
          .then((res) => {
            this.tableData = res.data.shopsList
            this.total = res.data.totalCount
          })
      },
      keywordSerach(){
        this.axios.post(this.Global.basePath+'getShopsListByInputLike',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          inputLike:this.inputLike
        })
          .then((res) => {
            this.tableData = res.data.shopsList
            this.total = res.data.totalCount
          })
      },
      getShopGoodsClick(row) {  //查询服务商品按钮的触发事件
          this.sPhoneNum = row.sPhoneNum;
          this.sCity = row.sCity;
          this.sName = row.sName;
          this.axios.post(this.Global.basePath+'getShopGoodsListBySId',{
            sId:row.sId,
          })
            .then((res) => {
              this.ShopGoodsData = res.data
            })
          this.ShopGoodsVisible = true
      },
      choiceTimeClick(row) {  //查询服务商品按钮的触发事件
          this.choiceTimeVisible = true,
          this.wSgContent =row.sgContent,
          this.wSgPrice =row.sgPrice
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.axios.post(this.Global.basePath+'addWorkOrder',{
              wEName:sessionStorage.getItem('eName'),
              wEPhoneNum:sessionStorage.getItem('uId'),
              wEAddress:sessionStorage.getItem('eAddress'),
              wSgContent:this.wSgContent,
              wSgPrice:this.wSgPrice,
              wSName:this.sName,
              wSPhoneNum:this.sPhoneNum,
              wSCity:this.sCity,
              wServiceTime:this.ruleForm.valueTime,
              wAmount:this.ruleForm.valueNum,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$alert('恭喜你，下单成功！', '下单服务', {
                    confirmButtonText: '确定',
                  });
                  this.resetForm('ruleForm');
                } else {
                  this.$alert('下单失败！', '下单服务', {
                    confirmButtonText: '确定',
                  });
                }
              })
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      tableRowClassName ({row, rowIndex}) {
      // 把每一行的索引放进row
      row.index = rowIndex;
      }
      
    },
    components:{
        Pagination
    },
  }
</script>