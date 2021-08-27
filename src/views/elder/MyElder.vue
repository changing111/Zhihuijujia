<template >
  <div style="text-align:center;width:1000px;margin-left: 250px;">
    <el-header style="height: 60px;">
        <span style="font-size:30px">更新资料</span>&nbsp;&nbsp;&nbsp;&nbsp;
    </el-header>
    <el-main style="height: 700px;text-align:center">
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
    </el-main>
    <el-footer style="text-align: center;">
              
    </el-footer>
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
<script >
  export default {
    created(){
        this.axios.post(this.Global.basePath+'getElderByEPhoneNum',{
            ePhoneNum:sessionStorage.getItem("uId"),
        })
          .then((res) => {
            this.ruleForm.valueCity=res.data.eCity,
            this.ruleForm.valueResidence=res.data.eResidence,
            this.ruleForm.valueGender=res.data.eGender,
            this.ruleForm.valueMarriage=res.data.eMarriage,
            this.ruleForm.valueDisable=res.data.eDisable,
            this.ruleForm.inputName=res.data.eName,
            this.ruleForm.inputIdCard=res.data.eIdCard,
            this.ruleForm.inputPhone=res.data.ePhoneNum,
            this.ruleForm.inputPass=res.data.ePassword,
            this.ruleForm.inputIncome=res.data.eIncome,
            this.ruleForm.inputFamilyName=res.data.eFamilyName,
            this.ruleForm.inputFamilyPhone=res.data.eFamilyPhone,
            this.ruleForm.inputFamilyRelation=res.data.eFamilyRelation,
            this.ruleForm.inputBlood=res.data.eBlood,
            this.ruleForm.inputBirth=res.data.eBirth,
            this.ruleForm.inputAddress=res.data.eAddress,
            this.ruleForm.inputAge=res.data.eAge
          });
    },
    data() {
     return {
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
            { required: true, message: '请选择出生日期', trigger: 'change' }
          ]
        }
      }
    },
    methods: {
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
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      setInputAge(){
      let birthdays = new Date(this.ruleForm.inputBirth.toString().replace(/-/g, "-或者/，根据日期格式选择"));
      let d = new Date();
      let age = d.getFullYear() - birthdays.getFullYear() - (d.getMonth() < birthdays.getMonth() || (d.getMonth() == birthdays.getMonth() && d.getDate() < birthdays.getDate()) ? 1 : 0);
          this.ruleForm.inputAge=age;
          
      },
    },
  }
</script>


