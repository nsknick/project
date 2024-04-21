<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
	  style="background: transparent;"
    >  
     <el-row>
      <el-col :span="12">
        <el-form-item   v-if="flag=='volunteer'"  label="学号" prop="studentid">
          <el-input v-model="ruleForm.studentid" readonly              placeholder="学号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='volunteer'"  label="姓名" prop="name">
          <el-input v-model="ruleForm.name"               placeholder="姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='volunteer'"  label="性别" prop="gender">
          <el-select v-model="ruleForm.gender"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in volunteergenderOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="24">  
        <el-form-item v-if="flag=='volunteer'" label="头像" prop="profilepicture">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.profilepicture?ruleForm.profilepicture:''"
          @change="volunteerprofilepictureUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='volunteer'"  label="年龄" prop="age">
          <el-input v-model="ruleForm.age"               placeholder="年龄" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='volunteer'"  label="班级" prop="classes">
          <el-input v-model="ruleForm.classes"               placeholder="班级" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='volunteer'"  label="邮箱" prop="email">
          <el-input v-model="ruleForm.email"               placeholder="邮箱" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='volunteer'"  label="手机" prop="phonenumber">
          <el-input v-model="ruleForm.phonenumber"               placeholder="手机" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-form-item v-if="flag=='users'" label="用户名" prop="username">
        <el-input v-model="ruleForm.username" 
        placeholder="用户名"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
      </el-form-item>
      </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      volunteergenderOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.volunteergenderOptions = "男,女".split(',')
  },
  methods: {
    volunteerprofilepictureUploadChange(fileUrls) {
        this.ruleForm.profilepicture = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.studentid)&& 'volunteer'==this.flag){
        this.$message.error('学号不能为空');
        return
      }
      if((!this.ruleForm.password)&& 'volunteer'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.name)&& 'volunteer'==this.flag){
        this.$message.error('姓名不能为空');
        return
      }
        if(this.ruleForm.profilepicture!=null) {
                this.ruleForm.profilepicture = this.ruleForm.profilepicture.replace(new RegExp(this.$base.url,"g"),"");
        }
      if((!this.ruleForm.email)&& 'volunteer'==this.flag){
        this.$message.error('邮箱不能为空');
        return
      }
      if( 'volunteer' ==this.flag && this.ruleForm.email&&(!isEmail(this.ruleForm.email))){
        this.$message.error(`邮箱应输入邮箱格式`);
        return
      }
      if((!this.ruleForm.phonenumber)&& 'volunteer'==this.flag){
        this.$message.error('手机不能为空');
        return
      }
      if( 'volunteer' ==this.flag && this.ruleForm.phonenumber&&(!isMobile(this.ruleForm.phonenumber))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
