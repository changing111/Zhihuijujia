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
            <el-breadcrumb-item :to="{ path: '/MyVolActivitysList' }" style="font-size:20px">{{this.vsName}}-活动列表</el-breadcrumb-item>
            <el-breadcrumb-item style="font-size:20px">{{this.vaName}}-报名列表</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
        <el-input style="width: 250px;"
          placeholder="输入关键字"
          prefix-icon="el-icon-search"
          v-model="inputLike">
        </el-input>
        <el-button plain @click="clickKeywordSerach">关键字搜索</el-button>
    </el-header>
    <el-main style="height: 640px;">
        <el-table :data="tableData" style="width: 100%" height="600px">
                        <el-table-column prop="vbVaId" label="已报名义工姓名" width="230">
            </el-table-column>
            <el-table-column prop="vbVName" label="已报名义工姓名" width="230">
            </el-table-column>
            <el-table-column prop="vbVPhoneNum" label="义工手机号" width="200">
            </el-table-column> 
        </el-table>
    </el-main>
    <el-footer style="text-align: center;">
              <Pagination :total="total" :currentPage=currentPage @SizeChange="clickChangeSize" @CurrentChange="clickChangeCurrent"></Pagination> 
    </el-footer>
  </div>
</template>
<style>

</style>
<script>
  import Pagination from '../../components/Pagination'
  export default {
    data() {
     return {
        vsName:sessionStorage.getItem("vsName"),
        vsId:sessionStorage.getItem("vsId"),
        vaName:sessionStorage.getItem("vaName"),
        vbVaId:sessionStorage.getItem("vaId"),
        tableData: [],//定义表格数据
        total:null,    //定义总条数
        currentPage:1,//定义默认页码
        pageSize:this.Global.pageSize,  //定义默认显示条数
        searchStates:1,//纪录当前查询类别，条件查询是0，关键字查询是1，默认1(方便判断点击分页操作后进行哪种查询)
        inputLike:null,//定义默认关键字为空
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
      clickKeywordSerach(){
        this.currentPage=1; //置当前页为1
        this.valueCity=null;  //把条件搜索置空
        this.inputName=null;
        this.searchStates=1;//1纪录当前为关键字查询
        this.keywordSerach();//调用关键字查询方法
      },
      keywordSerach(){
        this.axios.post(this.Global.basePath+'getVolBooksListByVaIdAndLike',{
          currentPage:this.currentPage,
          pageSize:this.pageSize,
          volBook:{ 
            vbVaId:this.vbVaId,
            vbState:this.inputLike,//把关键字放vbState中
          }
        })
          .then((res) => {
            this.tableData = res.data.volBooksList
            this.total = res.data.totalCount
          })
      },
    },
    components:{
        Pagination
    },
  }
</script>