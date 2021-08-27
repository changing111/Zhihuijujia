<template >
  <div >
    <el-header style="height: 100px;white-space: nowrap;  /*强制span不换行*/
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
              width="180">
              <template slot-scope="scope">
                <el-button @click="showActivityClick(scope.row)" type="text" size="big">&nbsp;&nbsp;志愿服务纪录</el-button>
                <el-button @click="routeToAddActivity(scope.row)" type="text" size="big">给该长者发布活动</el-button>
              </template>
            </el-table-column>
        </el-table>
    </el-main>
    <el-footer style="text-align: center;">
              <Pagination :total="total" :currentPage=currentPage @SizeChange="clickChangeSize" @CurrentChange="clickChangeCurrent"></Pagination> 
    </el-footer>

    
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
        valueResidence:sessionStorage.getItem('vsCity'),
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
        VolActivityVisible: false,
      }
    },
    created(){
        this.uAuthor =sessionStorage.getItem('uAuthor');
        
        
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
      routeToAddActivity(row){
        this.$router.push({name:'VolActivityAdd',params: {eName:row.eName,ePhoneNum:row.ePhoneNum}})
      },
    },
    components:{
        Pagination
    },
  }
</script>