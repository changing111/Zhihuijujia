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
            <el-table-column prop="sHostName" label="店主姓名" width="120">
            </el-table-column>
            <el-table-column prop="sPhoneNum" label="手机号" width="200">
            </el-table-column>
            <el-table-column prop="sHostCard" label="店主银行卡号" width="250">
            </el-table-column>
            <el-table-column prop="sPassword" label="账户密码" width="200">
            </el-table-column>
            <el-table-column prop="sBalance" label="账户余额" width="140" sortable>
            </el-table-column>
            <el-table-column prop="sCity" label="所在城市" width="130">
            </el-table-column>
            <el-table-column prop="sAddress" label="地址" width="300">
            </el-table-column>
            <el-table-column
              fixed="right"
              label="操作"
              width="180">
              <template slot-scope="scope">
                <el-button @click="getShopGoodsClick(scope.row)" type="text" size="big">&nbsp;&nbsp;查看服务</el-button>
                <el-button @click="getWorkOrderClick(scope.row)" type="text" size="big">查看工单</el-button>
                <el-button @click="updateClick(scope.row)" type="text" size="big">修改资料</el-button>
                <el-button @click="deleteClick(scope.row)" type="text" size="big">删除账号</el-button>
              </template>
            </el-table-column>
        </el-table>
    </el-main>
    <el-footer style="text-align: center;">
              <Pagination :total="total" :currentPage=currentPage @SizeChange="clickChangeSize" @CurrentChange="clickChangeCurrent"></Pagination> 
    </el-footer>

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
                <el-button @click="deleteShopGoodsClick(scope.row)" type="text" size="big">下架该服务</el-button>
              </template>
            </el-table-column>
      </el-table>
    </el-dialog>
    <el-dialog title="该商户的工单列表" :visible.sync="WorkOrderVisible" style="text-align:center">
      <el-table :data="WorkOrderData" height="500px">
            <el-table-column prop="wId" label="单号" width="80" sortable>
              </el-table-column>
              <el-table-column prop="wEName" label="长者名字" width="100" >
              </el-table-column>
              <el-table-column prop="wSgContent" label="服务内容" width="130">
              </el-table-column>
              <el-table-column prop="wAmount" label="订单数量" width="100" >
              </el-table-column>
              <el-table-column prop="wSpend" label="花费服务币数" width="120" >
              </el-table-column>
              <el-table-column prop="wState" label="订单状态" width="120" >
              </el-table-column>
              <el-table-column prop="wServiceTime" label="下单时间" width="140" >
              </el-table-column>
              <el-table-column prop="wEAddress" label="长者地址" width="140">
              </el-table-column>
      </el-table>
    </el-dialog>
    <el-dialog title="更新资料" :visible.sync="UpdateVisible" style="text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="商户名称" prop="inputName">
          <el-input style="width: 217px;"
          placeholder="请输入商户名称"
          v-model="ruleForm.inputName">
        </el-input>
        </el-form-item>
        <el-form-item label="店主姓名" prop="inputHostName">
          <el-input style="width: 217px;"
          placeholder="请输入店主姓名"
          v-model="ruleForm.inputHostName">
        </el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="inputPhone">
          <el-input style="width: 217px;"
          disabled
          placeholder="请输入手机号"
          v-model="ruleForm.inputPhone">
        </el-input>
        </el-form-item>
        <el-form-item label="银行卡号码" prop="inputHostCard">
          <el-input style="width: 217px;"
          placeholder="请输入银行卡号码"
          v-model="ruleForm.inputHostCard">
        </el-input>
        </el-form-item>
        <el-form-item label="登录密码" prop="inputPass">
          <el-input type="password" style="width: 217px;"
          placeholder="请输入登录密码"
          v-model="ruleForm.inputPass">
        </el-input>
        </el-form-item>
        <el-form-item label="所处城市" prop="valueCity">
          <el-select v-model="ruleForm.valueCity" placeholder="请选择所处城市">
          <el-option
            v-for="item in this.Global.cities"
            :key="item.valueCity"
            :label="item.label"
            :value="item.valueCity">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
          </el-select>
        </el-form-item>       
        <el-form-item label="店铺地址" prop="inputAddress" >
          <el-input type="textarea" placeholder="请输入地址" style="width: 560px;" v-model="ruleForm.inputAddress"></el-input>
        </el-form-item>
        <div></div>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置信息</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>
<style>

</style>
<script>
  import Pagination from '../../components/Pagination'
  export default {
    data() {
     return {
        tableData: [],//定义表格数据
        total:null,    //定义总条数
        currentPage:1,//定义默认页码
        pageSize:this.Global.pageSize,  //定义默认显示条数
        searchStates:1,//纪录当前查询类别，条件查询是0，关键字查询是1，默认1(方便判断点击分页操作后进行哪种查询)
        inputLike:'',//定义默认关键字为空
        
        valueCity:'',
        inputName:'',
        inputPhone:'',

        WorkOrderData: [],
        ShopGoodsData: [],
        UpdateVisible: false,
        WorkOrderVisible: false,
        ShopGoodsVisible: false,

        ruleForm: {
          inputName: '',
          inputHostCard: '',
          inputHostName: '',
          inputPhone: '',
          inputPass: '',
          valueCity: '',
          inputAddress: '',
        },
        rules: {
          inputHostName: [
            { required: true, message: '请输入店主姓名', trigger: 'blur' },
            { min: 2, max: 4, message: '姓名长度在 2 到 4 个字符', trigger: 'blur' }
          ],
          inputHostCard: [
            { required: true, message: '请输入银行卡号码', trigger: 'blur' },
            { min: 16, max: 19, message: '银行卡号码格式不正确！', trigger: 'blur' }
          ],
          inputPhone: [
            { required: true, message: '请输入手机号', trigger: 'blur' },
            { min: 11, max: 11, message: '手机号格式不正确！', trigger: 'blur' }
          ],
          inputPass: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 3, max: 20, message: '密码长度在 3 到 20 个字符', trigger: 'blur' }
          ],
          inputName: [
            { required: true, message: '请输入店铺名称', trigger: 'blur' }
          ],
          inputAddress: [
            { required: true, message: '请输入地址', trigger: 'blur' }
          ],
          valueCity: [
            { required: true, message: '请选择所在城市', trigger: 'change' }
          ],
        }
        
      }
    },
    created(){
        this.clickKeywordSerach(); //相对于清空关键字的关键字搜索
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
          this.axios.post(this.Global.basePath+'getShopGoodsListBySId',{
            sId:row.sId,
          })
            .then((res) => {
              this.ShopGoodsData = res.data
            })
          this.ShopGoodsVisible = true
      },
      getWorkOrderClick(row) {  //查询服务工单按钮的触发事件
        this.axios.post(this.Global.basePath+'getWorkOrderBySPhoneNum',{
            wSPhoneNum:row.sPhoneNum,
          })
            .then((res) => {
              this.WorkOrderData = res.data
            })
          this.WorkOrderVisible = true
      },
      updateClick(row) {  //更新按钮的触发事件
        this.ruleForm.valueCity=row.sCity,
        this.ruleForm.inputName=row.sName,
        this.ruleForm.inputHostCard=row.sHostCard,
        this.ruleForm.inputPhone=row.sPhoneNum,
        this.ruleForm.inputPass=row.sPassword,
        this.ruleForm.inputAddress=row.sAddress,
        this.ruleForm.inputHostName=row.sHostName,
        this.UpdateVisible = true
      },
      deleteClick(row) {  //删除按钮的触发事件
        this.$confirm('此操作将永久删除该商户及其服务内容, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'deleteShop',{
              sPhoneNum:row.sPhoneNum,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$message({
                    type: 'success',
                    message: '删除成功!'
                  });
                  this.clickChangeSize(this.pageSize);//强行调用分页按钮触发事件来刷新页面
                } else {
                  this.$message({
                    type: 'info',
                    message: '删除失败！'
                  }); 
                }
              })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.axios.post(this.Global.basePath+'updateShop',{
              sCity:this.ruleForm.valueCity,
              sHostName:this.ruleForm.inputHostName,
              sName:this.ruleForm.inputName,
              sHostCard:this.ruleForm.inputHostCard,
              sPhoneNum:this.ruleForm.inputPhone,
              sPassword:this.ruleForm.inputPass,
              sAddress: this.ruleForm.inputAddress,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$alert('恭喜你，更新成功！', '更新资料', {
                    confirmButtonText: '确定',
                  });
                  this.clickChangeSize(this.pageSize);//强行调用分页按钮触发事件来刷新页面
                } else {
                  this.$alert('更新失败', '更新资料', {
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
      deleteShopGoodsClick(row) {  //删除某服务按钮的触发事件
        this.$confirm('将下架该商户的这项服务, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'deleteShopGoods',{
              sgId:row.sgId,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$message({
                    type: 'success',
                    message: '下架成功!'
                  });
                  this.clickChangeSize(this.pageSize);//强行调用分页按钮触发事件来刷新页面
                  this.ShopGoodsData.splice(row.index,1)      //后端删除该行但不更新对话框，所以也在前端删除该行数据
                } else {
                  this.$message({
                    type: 'info',
                    message: '下架失败！'
                  }); 
                }
              })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
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