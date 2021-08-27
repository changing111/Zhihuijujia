<template >
  <div >
    <el-header style="height: 100px;white-space: nowrap;  /*强制span不换行*/
      display: inline-block;  /*将span当做块级元素对待*/
      width: 32px;  /*限制宽度*/
      overflow: hidden;  /*超出宽度部分隐藏*/
      text-overflow: ellipsis;  /*超出部分以点号代替*/
      line-height: 0.9;  /*数字与之前的文字对齐*/white-space: nowrap;  /*强制span不换行*/
      display: inline-block;  /*将span当做块级元素对待*/
      width: 32px;  /*限制宽度*/
      overflow: hidden;  /*超出宽度部分隐藏*/
      text-overflow: ellipsis;  /*超出部分以点号代替*/
      line-height: 0.9;  /*数字与之前的文字对齐*/">
        <span style="font-size:20px">长者列表</span>&nbsp;&nbsp;&nbsp;&nbsp;
        <span>&nbsp;&nbsp;户籍城市:</span>
        <el-select v-model="valueCity" placeholder="请选择户籍城市">
          <el-option
            v-for="item in this.Global.cities"
            :key="item.valueCity"
            :label="item.label"
            :value="item.valueCity">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>
        <span>&nbsp;&nbsp;居住城市:</span>
        <el-select v-model="valueResidence" placeholder="请选择居住城市">
          <el-option
            v-for="item in this.Global.cities"
            :key="item.valueCity"
            :label="item.label"
            :value="item.valueCity">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>
        <span>&nbsp;&nbsp;性别:</span>
        <el-select v-model="valueGender" placeholder="请选择性别">
          <el-option
            v-for="item in this.Global.genders"
            :key="item.valueGender"
            :label="item.label"
            :value="item.valueGender">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>
        <span>&nbsp;&nbsp;婚姻状况:</span>
        <el-select v-model="valueMarriage" placeholder="请选择婚姻状况">
          <el-option
            v-for="item in this.Global.marriages"
            :key="item.valueMarriage"
            :label="item.label"
            :value="item.valueMarriage">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>
        <span>&nbsp;&nbsp;失能情况:</span>
        <el-select v-model="valueDisable" placeholder="请选择失能情况">
          <el-option
            v-for="item in this.Global.disables"
            :key="item.valueDisable"
            :label="item.label"
            :value="item.valueDisable">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>     
        <div style="height: 20px;"></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span>&nbsp;&nbsp;长者姓名:</span>
        <el-input style="width: 217px;"
          placeholder="请输入长者姓名"
          prefix-icon="el-icon-search"
          v-model="inputName">
        </el-input>
        <span>&nbsp;&nbsp;身份证号:</span>
        <el-input style="width: 217px;"
          placeholder="请输入身份证号"
          prefix-icon="el-icon-search"
          v-model="inputIdCard">
        </el-input>
        <span>&nbsp;&nbsp;手机号:</span>
        <el-input style="width: 202px;"
          placeholder="请输入手机号"
          prefix-icon="el-icon-search"
          v-model="inputPhone">
        </el-input>
        <el-button plain @click="clickConditionSerach">查找</el-button>
        <el-button plain @click="clickConditionDelete">清空条件</el-button>
        <span>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <el-input style="width: 250px;"
          placeholder="输入关键字"
          prefix-icon="el-icon-search"
          v-model="inputLike">
        </el-input>
        <el-button plain @click="clickKeywordSerach">关键字搜索</el-button>
    </el-header>
    <el-main style="height: 640px;">
        <el-table :data="tableData" style="width: 100%" height="600px" :row-class-name="tableRow">
            <el-table-column prop="eName" label="长者姓名" width="140">
            </el-table-column>
            <el-table-column prop="ePhoneNum" label="手机号" width="140">
            </el-table-column>
            <el-table-column v-if="this.uAuthor==1" prop="ePassword" label="密码" width="140">
            </el-table-column>
            <el-table-column prop="eCity" label="户籍城市" width="140">
            </el-table-column>
            <el-table-column prop="eResidence" label="居住城市" width="140">
            </el-table-column>
            <el-table-column prop="eGender" label="性别" width="140">
            </el-table-column>
            <el-table-column prop="eBirth" label="生日" width="140" sortable>
            </el-table-column>
            <el-table-column prop="eAge" label="年龄" width="140" sortable>
            </el-table-column>
            <el-table-column v-if="this.uAuthor==1" prop="eBalance" label="服务币余额" width="140" sortable>
            </el-table-column>
            <el-table-column prop="eIncome" label="月收入" width="140" sortable>
            </el-table-column>
            <el-table-column prop="eMarriage" label="婚姻状况" width="140">
            </el-table-column>
            <el-table-column prop="eFamilyName" label="家属名字" width="140">
            </el-table-column>
            <el-table-column prop="eFamilyPhone" label="家属电话" width="140">
            </el-table-column>
            <el-table-column prop="eFamilyRelation" label="家属与长者关系" width="140">
            </el-table-column>
            <el-table-column prop="eBloodType" label="血型" width="140">
            </el-table-column>
            <el-table-column prop="eDisable" label="失能情况" width="140">
            </el-table-column>
            <el-table-column prop="eIdCard" label="身份证号" width="140">
            </el-table-column>
            <el-table-column 
              fixed="right"
              label="操作"
              width="220">
              <template slot-scope="scope">
                <el-dropdown @command="showDialog">
                  <span class="el-dropdown-link">
                    <el-button @click="SetEPhoneNumClick(scope.row)" type="text" size="big">查看更多</el-button>
                    <i class="el-icon-arrow-down el-icon--right"></i>
                  </span>
                  <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item command=0>历史服务工单</el-dropdown-item>
                    <el-dropdown-item command=1>志愿活动纪录</el-dropdown-item>
                    <el-dropdown-item command=2>预约挂号纪录</el-dropdown-item>
                    <el-dropdown-item command=3>服务币变更纪录</el-dropdown-item>
                  </el-dropdown-menu>
                </el-dropdown>
                <el-button @click="updateClick(scope.row)" type="text" size="big">&nbsp;&nbsp;修改资料</el-button>
                <el-button @click="deleteClick(scope.row)" type="text" size="big">删除</el-button>
              </template>
            </el-table-column>
        </el-table>
    </el-main>
    <el-footer style="text-align: center;">
              <Pagination :total="total" :currentPage=currentPage @SizeChange="clickChangeSize" @CurrentChange="clickChangeCurrent"></Pagination> 
    </el-footer>

    <el-dialog title="商户服务工单" :visible.sync="WorkOrderVisible" >
      <el-table :data="WorkOrderData" height="500px">
            <el-table-column prop="wId" label="单号" width="80" sortable>
            </el-table-column>
            <el-table-column prop="wSName" label="商户名称" width="150" >
            </el-table-column>
            <el-table-column prop="wSPhoneNum" label="商户手机号" width="140" >
            </el-table-column>
            <el-table-column prop="wSgContent" label="服务内容" width="150">
            </el-table-column>
            <el-table-column prop="wSgPrice" label="每次/小时价格" width="140" sortable>
            </el-table-column>
            <el-table-column prop="wAmount" label="订单数量" width="120" sortable>
            </el-table-column>
            <el-table-column prop="wSpend" label="花费服务币数" width="140" sortable>
            </el-table-column>
            <el-table-column prop="wState" label="订单状态" width="120" sortable>
            </el-table-column>
            <el-table-column prop="wServiceTime" label="下单时间" width="140" sortable>
            </el-table-column>
      </el-table>
    </el-dialog>
    <el-dialog title="义工服务纪录" :visible.sync="VolActivityVisible" style="text-align:center">
      <el-table :data="VolActivityData" height="500px" >
            <el-table-column prop="vaName" label="上门活动内容" width="150" >
            </el-table-column>
            <el-table-column prop="vaTime" label="活动时间" width="140" >
            </el-table-column>
            <el-table-column prop="vaState" label="活动状态" width="120" sortable>
            </el-table-column>
            <el-table-column prop="vaVsName" label="服务志愿站" width="150">
            </el-table-column>
            <el-table-column prop="vaHourNum" label="服务时长" width="140" sortable>
            </el-table-column>
            <el-table-column prop="vaRemSum" label="需求义工数" width="120" sortable>
            </el-table-column>
            <el-table-column prop="vaRemNum" label="已报名义工数" width="140" sortable>
            </el-table-column>
      </el-table>
    </el-dialog>
    <el-dialog title="预约挂号纪录" :visible.sync="RegisterVisible" style="text-align:center">
      <el-table :data="RegisterData" height="500px">
            <el-table-column prop="regId" label="预约单号" width="200" sortable>
            </el-table-column>
            <el-table-column prop="regDName" label="医生姓名" width="150" >
            </el-table-column>
            <el-table-column prop="regDPhoneNum" label="医生手机号" width="200" >
            </el-table-column>
            <el-table-column prop="regDate" label="预约日期" width="220" sortable>
            </el-table-column>
      </el-table>
    </el-dialog>
    <el-dialog title="服务币变更纪录" :visible.sync="BalanceRecordVisible" style="text-align:center">
      <el-table :data="BalanceRecordData" height="500px">
            <el-table-column prop="bId" label="单号" width="200" sortable>
            </el-table-column>
            <el-table-column prop="bReason" label="变更原因" width="200" >
            </el-table-column>
            <el-table-column prop="bBeforeBal" label="变更前余额" width="140" >
            </el-table-column>
            <el-table-column prop="bAfterBal" label="变更后余额" width="150">
            </el-table-column>
            <el-table-column prop="bTime" label="变更时间" width="220" sortable>
            </el-table-column>
      </el-table>
    </el-dialog>
    <el-dialog title="更新资料" :visible.sync="UpdateVisible" style="text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="长者姓名" prop="inputName">
          <el-input style="width: 217px;"
          placeholder="请输入长者姓名"
          v-model="ruleForm.inputName">
        </el-input>
        </el-form-item>
        <el-form-item label="身份证号" prop="inputIdCard">
          <el-input style="width: 217px;"
          placeholder="请输入身份证号"
          v-model="ruleForm.inputIdCard">
        </el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="inputPhone">
          <el-input style="width: 217px;"
          readonly="readonly"
          disabled="disabled"
          placeholder="请输入手机号"
          v-model="ruleForm.inputPhone">
        </el-input>
        </el-form-item>
        <el-form-item label="登录密码" prop="inputPass">
          <el-input type="password" style="width: 217px;"
          placeholder="请输入登录密码"
          v-model="ruleForm.inputPass">
        </el-input>
        </el-form-item>
        <el-form-item label="户籍城市" prop="valueCity">
          <el-select v-model="ruleForm.valueCity" placeholder="请选择户籍城市">
          <el-option
            v-for="item in this.Global.cities"
            :key="item.valueCity"
            :label="item.label"
            :value="item.valueCity">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="居住城市" prop="valueResidence">
          <el-select v-model="ruleForm.valueResidence" placeholder="请选择居住城市">
          <el-option
            v-for="item in this.Global.cities"
            :key="item.valueCity"
            :label="item.label"
            :value="item.valueCity">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>
        </el-form-item>
        <el-form-item label="性别" prop="valueGender">
          <el-select v-model="ruleForm.valueGender" placeholder="请选择性别">
          <el-option
            v-for="item in this.Global.genders"
            :key="item.valueGender"
            :label="item.label"
            :value="item.valueGender">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="婚姻状况" prop="valueMarriage">
          <el-select v-model="ruleForm.valueMarriage" placeholder="请选择婚姻状况">
          <el-option
            v-for="item in this.Global.marriages"
            :key="item.valueMarriage"
            :label="item.label"
            :value="item.valueMarriage">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>
        </el-form-item>
        <el-form-item label="失能情况" prop="valueDisable">
          <el-select v-model="ruleForm.valueDisable" placeholder="请选择失能情况">
          <el-option
            v-for="item in this.Global.disables"
            :key="item.valueDisable"
            :label="item.label"
            :value="item.valueDisable">
            <span style="float: left">{{ item.label }}</span>
          </el-option>
        </el-select>
        </el-form-item>
        <el-form-item label="月收入" prop="inputIncome">
          <el-input style="width: 217px;"
          placeholder="请输入月收入"
          v-model="ruleForm.inputIncome">
        </el-input>
        </el-form-item>
        <el-form-item label="家属姓名" prop="inputFamilyName">
          <el-input style="width: 217px;"
          placeholder="请输入家属姓名"
          v-model="ruleForm.inputFamilyName">
        </el-input>
        </el-form-item>
        <el-form-item label="家属电话" prop="inputFamilyPhone">
          <el-input style="width: 217px;"
          placeholder="请输入家属电话"
          v-model="ruleForm.inputFamilyPhone">
        </el-input>
        </el-form-item>
        <el-form-item label="该家属关系" prop="inputFamilyRelation">
          <el-input style="width: 217px;"
          placeholder="请输入关系"
          v-model="ruleForm.inputFamilyRelation">
        </el-input>
        </el-form-item>
        <el-form-item label="血型" prop="inputBlood">
          <el-input style="width: 217px;"
          placeholder="请输入血型"
          v-model="ruleForm.inputBlood">
        </el-input>
        </el-form-item>
        <el-form-item label="出生日期" required>
            <el-form-item prop="inputBirth">
              <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.inputBirth" @change="setInputAge()"></el-date-picker>
            </el-form-item>
        </el-form-item>
        <el-form-item label="年龄" prop="inputAge">
          <el-input style="width: 210px;"
          readonly="readonly"
          disabled="disabled"
          v-model="ruleForm.inputAge">
        </el-input>
        </el-form-item>
        <el-form-item label="居住地址" prop="inputAddress" >
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
  .el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }
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
        valueResidence:'',
        valueGender:'',
        valueMarriage:'',
        valueDisable:'',
        inputName:'',
        inputIdCard:'',
        inputPhone:'',

        ePhoneNum:'',
        WorkOrderData: [],
        RegisterData: [],
        VolActivityData: [],
        BalanceRecordData: [],
        WorkOrderVisible: false,
        RegisterVisible: false,
        VolActivityVisible: false,
        BalanceRecordVisible: false,
        UpdateVisible: false,

        ruleForm: {
          inputName: '',
          inputIdCard: '',
          inputPhone: '',
          inputPass: '',
          valueCity: '',
          valueResidence: '',
          valueGender: '',
          valueMarriage: '',
          valueDisable: '',
          inputIncome: '',
          inputFamilyName: '',
          inputFamilyPhone: '',
          inputFamilyRelation: '',
          inputBlood: '',
          inputBirth: '',
          inputAddress: '',
          inputAge:'',
        },
        rules: {
          inputName: [
            { required: true, message: '请输入长者姓名', trigger: 'blur' },
            { min: 2, max: 4, message: '姓名长度在 2 到 4 个字符', trigger: 'blur' }
          ],
          inputIdCard: [
            { required: true, message: '请输入身份证号码', trigger: 'blur' },
            { min: 8, max: 18, message: '身份证号码格式不正确！', trigger: 'blur' }
          ],
          inputPhone: [
            { required: true, message: '请输入手机号', trigger: 'blur' },
            { min: 11, max: 11, message: '手机号格式不正确！', trigger: 'blur' }
          ],
          inputPass: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 3, max: 20, message: '密码长度在 3 到 20 个字符', trigger: 'blur' }
          ],
          inputFamilyName: [
            { required: true, message: '请输入亲属名字', trigger: 'blur' },
            { min: 2, max: 4, message: '姓名长度在 2 到 4 个字符', trigger: 'blur' }
          ],
          inputFamilyPhone: [
            { required: true, message: '请输入亲属手机号', trigger: 'blur' },
            { min: 11, max: 11, message: '手机号格式不正确！', trigger: 'blur' }
          ],
          inputFamilyRelation: [
            { required: true, message: '请输入关系', trigger: 'blur' }
          ],
          inputAddress: [
            { required: true, message: '请输入地址', trigger: 'blur' }
          ],
          valueCity: [
            { required: true, message: '请选择户籍城市', trigger: 'change' }
          ],
          valueResidence: [
            { required: true, message: '请选择居住城市', trigger: 'change' }
          ],
          valueGender: [
            { required: true, message: '请选择性别', trigger: 'change' }
          ],
          valueMarriage: [
            { required: true, message: '请选择婚姻状况', trigger: 'change' }
          ],
          valueDisable: [
            { required: true, message: '请选择失能情况', trigger: 'change' }
          ],
          inputBirth: [
            {  required: true, message: '请选择出生日期', trigger: 'change' }
          ]
        }
      }
    },
    created(){
        this.clickConditionSerach(); //相对于条件搜索
    },
    methods: {
      clickChangeSize(pageSize){  //改变每页显示数按钮的触发事件
        this.pageSize=pageSize;
        if (this.searchStates==0) {//判断当前是条件查询还是关键字查询
          this.conditionSerach();
        } else {
          this.keywordSerach();
        }
      },
      clickChangeCurrent(currentPage){  //改变当前页按钮的触发事件
        this.currentPage=currentPage;
        if (this.searchStates==0) {//判断当前是条件查询还是关键字查询
          this.conditionSerach();
        } else {
          this.keywordSerach();
        }
      },
      clickConditionSerach(){  //条件查询按钮的触发事件
        this.currentPage=1; //置当前页为1
        this.inputLike=null; //把关键字搜索置空
        this.searchStates=0;//0纪录当前为条件查询
        this.conditionSerach();//调用条件查询方法
      },
      clickKeywordSerach(){   //关键字查询按钮的触发事件
        this.currentPage=1; //置当前页为1
        this.valueCity=null;  //把条件搜索置空
        this.valueResidence=null;
        this.valueGender=null;
        this.valueMarriage=null;
        this.valueDisable=null;
        this.inputName=null;
        this.inputIdCard=null;
        this.inputPhone=null;
        this.searchStates=1;//1纪录当前为关键字查询
        this.keywordSerach();//调用关键字查询请求
      },
      clickConditionDelete(){  //清空条件搜索按钮的触发事件
          this.currentPage=1; 
          this.inputLike=null;
          this.clickKeywordSerach(); //相对于清空关键字的关键字搜索
      },
      conditionSerach(){ //条件搜索的请求
        this.axios.post(this.Global.basePath+'getEldersListByCondition',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          elder:{ 
            eCity:this.valueCity,
            eResidence:this.valueResidence,
            eGender:this.valueGender,
            eMarriage:this.valueMarriage,
            eDisable:this.valueDisable,
            eName:this.inputName,
            eIdCard:this.inputIdCard,
            ePhoneNum:this.inputPhone
          }
        })
          .then((res) => {
            this.tableData = res.data.eldersList
            this.total = res.data.totalCount
          })
      },
      keywordSerach(){  //关键字搜索的请求
        this.axios.post(this.Global.basePath+'getEldersListByInputLike',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          inputLike:this.inputLike
        })
          .then((res) => {
            this.tableData = res.data.eldersList
            this.total = res.data.totalCount
          })
      },
      showDialog(command){ //下拉查看按钮的触发事件
        if (command==0) {
          this.axios.post(this.Global.basePath+'getWorkOrderByEPhoneNum',{
            wEPhoneNum:this.ePhoneNum,
          })
            .then((res) => {
              this.WorkOrderData = res.data
            })
          this.WorkOrderVisible = true
        }else if(command==1){
          this.axios.post(this.Global.basePath+'getVolActivitysListByVaEPhoneNum',{
            vaEPhoneNum:this.ePhoneNum,
          })
            .then((res) => {
              this.VolActivityData = res.data
            })
          this.VolActivityVisible = true
        }else if(command==2){
          this.axios.post(this.Global.basePath+'getRegistersListByEPhoneNum',{
            regEPhoneNum:this.ePhoneNum,
          })
            .then((res) => {
              this.RegisterData = res.data
            })
          this.RegisterVisible = true
        }else if(command==3){
          this.axios.post(this.Global.basePath+'getElderBalanceRecord',{
            bPhoneNum:this.ePhoneNum,
          })
            .then((res) => {
              this.BalanceRecordData = res.data
            })
          this.BalanceRecordVisible = true
        }else{
        }
      },
      showActivityClick(row){
        this.SetEPhoneNumClick(row);
        this.axios.post(this.Global.basePath+'getVolActivitysListByVaEPhoneNum',{
            vaEPhoneNum:this.ePhoneNum,
          })
            .then((res) => {
              this.VolActivityData = res.data
            })
          this.VolActivityVisible = true

      },
      SetEPhoneNumClick(row){
        this.ePhoneNum = row.ePhoneNum
      },
      updateClick(row) {  //更新按钮的触发事件
        this.ruleForm.valueCity=row.eCity,
        this.ruleForm.valueResidence=row.eResidence,
        this.ruleForm.valueGender=row.eGender,
        this.ruleForm.valueMarriage=row.eMarriage,
        this.ruleForm.valueDisable=row.eDisable,
        this.ruleForm.inputName=row.eName,
        this.ruleForm.inputIdCard=row.eIdCard,
        this.ruleForm.inputPhone=row.ePhoneNum,
        this.ruleForm.inputPass=row.ePassword,
        this.ruleForm.inputIncome=row.eIncome,
        this.ruleForm.inputFamilyName=row.eFamilyName,
        this.ruleForm.inputFamilyPhone=row.eFamilyPhone,
        this.ruleForm.inputFamilyRelation=row.eFamilyRelation,
        this.ruleForm.inputBlood=row.eBlood,
        this.ruleForm.inputBirth=row.eBirth,
        this.ruleForm.inputAddress=row.eAddress,
        this.ruleForm.inputAge=row.eAge,
        this.UpdateVisible = true
      },
      deleteClick(row) {  //删除按钮的触发事件
        this.$confirm('此操作将永久删除该长者资料, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post(this.Global.basePath+'deleteElder',{
              ePhoneNum:row.ePhoneNum,
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
      routeToAddActivity(row){
        this.$router.push({name:'VolActivityAdd',params: {eName:row.eName,ePhoneNum:row.ePhoneNum}})
      },
      submitForm(formName) { //更新页面中的提交按钮触发事件
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.axios.post(this.Global.basePath+'updateElder',{
              eCity:this.ruleForm.valueCity,
              eResidence:this.ruleForm.valueResidence,
              eGender:this.ruleForm.valueGender,
              eMarriage:this.ruleForm.valueMarriage,
              eDisable:this.ruleForm.valueDisable,
              eName:this.ruleForm.inputName,
              eIdCard:this.ruleForm.inputIdCard,
              ePhoneNum:this.ruleForm.inputPhone,
              ePassword:this.ruleForm.inputPass,
              eIncome:this.ruleForm.inputIncome,
              eFamilyName:this.ruleForm.inputFamilyName,
              eFamilyPhone:this.ruleForm.inputFamilyPhone,
              eFamilyRelation:this.ruleForm.inputFamilyRelation,
              eBlood:this.ruleForm.inputBlood,
              eBirth:this.ruleForm.inputBirth,
              eAddress: this.ruleForm.inputAddress,
              eAge: this.ruleForm.inputAge,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$alert('恭喜你，更改成功！', '更新资料', {
                    confirmButtonText: '确定',
                  });
                  this.clickChangeSize(this.pageSize);//强行调用分页按钮触发事件来刷新页面
                } else {
                  this.$alert('很抱歉，更改失败', '更新资料', {
                    confirmButtonText: '确定',
                  });
                }
              })
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {  //更新页面中重置按钮的触发事件
        this.$refs[formName].resetFields();
      },
      setInputAge(){ //计算年龄方法
      let birthdays = new Date(this.ruleForm.inputBirth.toString().replace(/-/g, "-或者/，根据日期格式选择"));
      let d = new Date();
      let age = d.getFullYear() - birthdays.getFullYear() - (d.getMonth() < birthdays.getMonth() || (d.getMonth() == birthdays.getMonth() && d.getDate() < birthdays.getDate()) ? 1 : 0);
          this.ruleForm.inputAge=age;
      },
    },
    components:{
        Pagination
    },
  }
</script>