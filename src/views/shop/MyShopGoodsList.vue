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
            <el-breadcrumb-item style="font-size:20px">{{this.sName}}-服务列表</el-breadcrumb-item>
        </el-breadcrumb>
        <div style="height: 20px;"></div>
        <el-button plain @click="addShopGoods">上架服务</el-button>
      </div>
    </el-header>
    <el-main style="height: 650px;">
        <el-table :data="tableData" height="500px" :row-class-name="tableRowClassName">
            <el-table-column prop="sgId" label="服务ID" width="200" >
            </el-table-column>
            <el-table-column prop="sgContent" label="服务内容" width="300" >
            </el-table-column>
            <el-table-column prop="sgPrice" label="服务价格(每次/时)" width="200" sortable>
            </el-table-column>
            <el-table-column
              label="操作"
              width="180">
              <template slot-scope="scope">
                <el-button @click="deleteClick(scope.row)" type="text" size="big">下架该服务</el-button>
              </template>
            </el-table-column>
      </el-table>
    </el-main>
    <el-dialog title="上架服务" :visible.sync="AddVisible" style="text-align:center">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-form-inline" size="big" :inline="true" >
        <el-form-item label="服务内容" prop="inputContent">
          <el-input style="width: 217px;"
          placeholder="请输入服务内容"
          v-model="ruleForm.inputContent">
        </el-input>
        </el-form-item>
        <el-form-item label="服务单价" prop="inputPrice">
          <el-input style="width: 217px;"
          placeholder="请输入服务单价"
          v-model.number="ruleForm.inputPrice">
        </el-input>
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
        sName:sessionStorage.getItem("sName"),
        sId:sessionStorage.getItem("sId"),

        AddVisible: false,
        ruleForm: {
          inputPrice: '',
          inputContent: '',
        },
        rules: {
          inputPrice: [
            {required: true, message: '请输入服务单价', trigger: 'blur' },
            { type: 'number', message: '单价必须为数字值'}
          ],
          inputContent: [
            { required: true, message: '请输入服务内容', trigger: 'blur' }
          ],
        }
      }
    },
    created(){
        this.Serach(); //相对于清空关键字的关键字搜索
    },
    methods: {
      Serach(){
        this.axios.post(this.Global.basePath+'getShopGoodsListBySId',{
            sId:sessionStorage.getItem("sId"),
            })
            .then((res) => {
                this.tableData = res.data
            })
      },
      deleteClick(row) {  //删除按钮的触发事件
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
                  this.Serach();//刷新页面
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
      addShopGoods(){
          this.AddVisible = true
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.axios.post(this.Global.basePath+'addShopGoods',{
              sId:this.sId,
              sgContent:this.ruleForm.inputContent,
              sgPrice:this.ruleForm.inputPrice,
            })
              .then((res) => {
                if (res.data==1) {
                  this.$alert('恭喜你，上架成功！', '上架服务', {
                    confirmButtonText: '确定',
                  });
                  this.Serach();//刷新页面
                  this.resetForm(formName);
                } else {
                  this.$alert('上架失败', '上架服务', {
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
    },
    components:{
        Pagination
    },
  }
</script>