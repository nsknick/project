<template>
<!--  <div>-->
<!--        <div class="container">-->
<!--      <div class="login-form">-->
<!--        <h1 class="h1">校园志愿者管理系统注册</h1>-->
<!--		<el-form ref="rgsForm" class="rgs-form" :model="rgsForm">-->
<!--			&lt;!&ndash; <div v-if="tableName=='volunteer'" class="input-group">-->
<!--			   <div class="label">学号</div>-->
<!--			   <div class="input-container">-->
<!--			     <input v-model="ruleForm.studentid" class="input" type="text" placeholder="学号">-->
<!--			   </div>-->
<!--			 </div> &ndash;&gt;-->
<!--			<el-form-item label="学号" class="input" v-if="tableName=='volunteer'">-->
<!--			  <el-input v-model="ruleForm.studentid" autocomplete="off" placeholder="学号"  />-->
<!--			</el-form-item>-->
<!--			&lt;!&ndash; <div v-if="tableName=='volunteer'" class="input-group">-->
<!--			   <div class="label">密码</div>-->
<!--			   <div class="input-container">-->
<!--			     <input v-model="ruleForm.password" class="input" type="text" placeholder="密码">-->
<!--			   </div>-->
<!--			 </div> &ndash;&gt;-->
<!--			<el-form-item label="密码" class="input" v-if="tableName=='volunteer'">-->
<!--			  <el-input v-model="ruleForm.password" autocomplete="off" placeholder="密码" type="password"#elsetype="text" />-->
<!--			</el-form-item>-->
<!--			<el-form-item label="确认密码" class="input" v-if="tableName=='volunteer'">-->
<!--			  <el-input v-model="ruleForm.password2" autocomplete="off" placeholder="确认密码" type="password"/>-->
<!--			</el-form-item>-->

<!--			&lt;!&ndash; <div v-if="tableName=='volunteer'" class="input-group">-->
<!--			   <div class="label">姓名</div>-->
<!--			   <div class="input-container">-->
<!--			     <input v-model="ruleForm.name" class="input" type="text" placeholder="姓名">-->
<!--			   </div>-->
<!--			 </div> &ndash;&gt;-->
<!--			<el-form-item label="姓名" class="input" v-if="tableName=='volunteer'">-->
<!--			  <el-input v-model="ruleForm.name" autocomplete="off" placeholder="姓名"  />-->
<!--			</el-form-item>-->
<!--			&lt;!&ndash; <div v-if="tableName=='volunteer'" class="input-group">-->
<!--			   <div class="label">年龄</div>-->
<!--			   <div class="input-container">-->
<!--			     <input v-model="ruleForm.age" class="input" type="text" placeholder="年龄">-->
<!--			   </div>-->
<!--			 </div> &ndash;&gt;-->
<!--			<el-form-item label="年龄" class="input" v-if="tableName=='volunteer'">-->
<!--			  <el-input v-model="ruleForm.age" autocomplete="off" placeholder="年龄"  />-->
<!--			</el-form-item>-->
<!--			&lt;!&ndash; <div v-if="tableName=='volunteer'" class="input-group">-->
<!--			   <div class="label">班级</div>-->
<!--			   <div class="input-container">-->
<!--			     <input v-model="ruleForm.classes" class="input" type="text" placeholder="班级">-->
<!--			   </div>-->
<!--			 </div> &ndash;&gt;-->
<!--			<el-form-item label="班级" class="input" v-if="tableName=='volunteer'">-->
<!--			  <el-input v-model="ruleForm.classes" autocomplete="off" placeholder="班级"  />-->
<!--			</el-form-item>-->
<!--			&lt;!&ndash; <div v-if="tableName=='volunteer'" class="input-group">-->
<!--			   <div class="label">邮箱</div>-->
<!--			   <div class="input-container">-->
<!--			     <input v-model="ruleForm.email" class="input" type="text" placeholder="邮箱">-->
<!--			   </div>-->
<!--			 </div> &ndash;&gt;-->
<!--			<el-form-item label="邮箱" class="input" v-if="tableName=='volunteer'">-->
<!--			  <el-input v-model="ruleForm.email" autocomplete="off" placeholder="邮箱"  />-->
<!--			</el-form-item>-->
<!--			&lt;!&ndash; <div v-if="tableName=='volunteer'" class="input-group">-->
<!--			   <div class="label">手机</div>-->
<!--			   <div class="input-container">-->
<!--			     <input v-model="ruleForm.phonenumber" class="input" type="text" placeholder="手机">-->
<!--			   </div>-->
<!--			 </div> &ndash;&gt;-->
<!--			<el-form-item label="手机" class="input" v-if="tableName=='volunteer'">-->
<!--			  <el-input v-model="ruleForm.phonenumber" autocomplete="off" placeholder="手机"  />-->
<!--			</el-form-item>-->
<!--			<div style="display: flex;flex-wrap: wrap;width: 100%;justify-content: center;">-->
<!--				<el-button class="btn" type="primary" @click="login()">注册</el-button>-->
<!--				<el-button class="btn close" type="primary" @click="close()">取消</el-button>-->
<!--			</div>-->
<!--		</el-form>-->
<!--      </div>-->
<!--      &lt;!&ndash; <div class="nk-navigation">-->
<!--        <a href="#">-->
<!--          <div @click="login()">注册</div>-->
<!--        </a>-->
<!--      </div> &ndash;&gt;-->
<!--    </div>-->
<!--  </div>-->
  <div>
    <div class="container">
      <div class="login-form">
        <h1 class="h1">校园志愿者管理系统注册</h1>
        <el-form ref="rgsForm" class="rgs-form" :model="rgsForm">
          <el-form-item label="学号" class="input" v-if="tableName=='volunteer'">
            <el-input v-model="ruleForm.studentid" autocomplete="off" placeholder="学号" />
          </el-form-item>
          <el-form-item label="密码" class="input" v-if="tableName=='volunteer'">
            <el-input v-model="ruleForm.password" type="password" autocomplete="off" placeholder="密码" />
          </el-form-item>
          <el-form-item label="确认密码" class="input" v-if="tableName=='volunteer'">
            <el-input v-model="ruleForm.password2" type="password" autocomplete="off" placeholder="确认密码" />
          </el-form-item>
          <el-form-item label="姓名" class="input" v-if="tableName=='volunteer'">
            <el-input v-model="ruleForm.name" autocomplete="off" placeholder="姓名" />
          </el-form-item>
          <el-form-item label="年龄" class="input" v-if="tableName=='volunteer'">
            <el-input v-model="ruleForm.age" autocomplete="off" placeholder="年龄" />
          </el-form-item>
          <el-form-item label="班级" class="input" v-if="tableName=='volunteer'">
            <el-input v-model="ruleForm.classes" autocomplete="off" placeholder="班级" />
          </el-form-item>
          <el-form-item label="邮箱" class="input" v-if="tableName=='volunteer'">
            <el-input v-model="ruleForm.email" autocomplete="off" placeholder="邮箱" />
          </el-form-item>
          <el-form-item label="手机" class="input" v-if="tableName=='volunteer'">
            <el-input v-model="ruleForm.phonenumber" autocomplete="off" placeholder="手机" />
          </el-form-item>
          <div style="display: flex; justify-content: center; width: 100%;">
            <el-button class="btn" type="primary" @click="login()">注册</el-button>
            <el-button class="btn close" type="primary" @click="close()">取消</el-button>
          </div>
        </el-form>
      </div>
    </div>
  </div>

</template>
<script>


export default {
  data() {
    return {
      ruleForm: {
      },
      tableName:"",
      rules: {},
    };
  },
  mounted(){
    let table = this.$storage.get("loginTable");
    this.tableName = table;
      },
  created() {
    
  },
  methods: {
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    close(){
	this.$router.push({ path: "/login" });
    },
    // 注册
    login() {
	var url=this.tableName+"/register";
      if((!this.ruleForm.studentid) && `volunteer` == this.tableName){
        this.$message.error(`学号不能为空`);
        return
      }
      if(this.ruleForm.studentid && (this.ruleForm.studentid.length<8) && `volunteer` == this.tableName){
        this.$message.error(`学号长度不能小于8`);
        return
      }
      if((!this.ruleForm.password) && `volunteer` == this.tableName){
        this.$message.error(`密码不能为空`);
        return
      }
      if((this.ruleForm.password!=this.ruleForm.password2) && `volunteer` == this.tableName){
	    this.$message.error(`两次密码输入不一致`);
	    return
      }
      if((!this.ruleForm.name) && `volunteer` == this.tableName){
        this.$message.error(`姓名不能为空`);
        return
      }
      if((!this.ruleForm.email) && `volunteer` == this.tableName){
        this.$message.error(`邮箱不能为空`);
        return
      }
      if(`volunteer` == this.tableName && this.ruleForm.email&&(!this.$validate.isEmail(this.ruleForm.email))){
        this.$message.error(`邮箱应输入邮件格式`);
        return
      }
      if((!this.ruleForm.phonenumber) && `volunteer` == this.tableName){
        this.$message.error(`手机不能为空`);
        return
      }
      if(`volunteer` == this.tableName && this.ruleForm.phonenumber&&(!this.$validate.isMobile(this.ruleForm.phonenumber))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
      this.$http({
        url: url,
        method: "post",
        data:this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "注册成功",
            type: "success",
            duration: 1500,
            onClose: () => {
              this.$router.replace({ path: "/login" });
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
/* 单选框内部选中状态的样式 */
.el-radio__input.is-checked .el-radio__inner {
  border-color: #FF9F43; /* 暖橙色边框 */
  background: #FF9F43;  /* 暖橙色背景 */
}

/* 单选框标签选中状态的样式 */
.el-radio__input.is-checked + .el-radio__label {
  color: #FF9F43; /* 暖橙色文字 */
}

/* 标题样式 */
.h1 {
  margin-top: 10px;
  color: #FFC107; /* 暖黄色 */
}

/* 页面基本样式 */
body {
  padding: 0;
  margin: 0;
  background-color: #FFF3E0; /* 暖色调的背景色 */
  color: #795548; /* 棕色字体色 */
}

/* 导航样式 */
.nk-navigation {
  margin-top: 15px;

  a {
    display: inline-block;
    color: #FFF;
    background: #FFB74D; /* 暖橙色背景 */
    width: 100px;
    height: 50px;
    border-radius: 30px;
    text-align: center;
    display: flex;
    align-items: center;
    margin: 0 auto;
    justify-content: center;
    padding: 0 20px;
  }

  .icon {
    margin-left: 10px;
    width: 30px;
    height: 30px;
  }
}
.register-container {
  margin-top: 10px; /* 保留上边距为组件间隔 */

  a {
    display: flex; /* 使用 flexbox 来实现水平居中和垂直居中 */
    align-items: center; /* 垂直居中 */
    justify-content: center; /* 水平居中 */
    padding: 0 20px; /* 内边距 */
    color: #fff; /* 字体颜色 */
    max-width: 500px; /* 最大宽度 */
    height: 50px; /* 高度 */
    border-radius: 30px; /* 圆角 */
    margin: 0 auto; /* 水平居中 */
    text-align: center; /* 文本居中，对内部的非 flex 子元素有效 */

    div {
      margin-left: 10px; /* 子元素左边距 */
    }
  }
}

.container {
  height: 100vh;
  background-position: center center;
  background-size: cover;
  background-repeat: no-repeat;
  background-image: url('/volunteermanagement/upload/women.jpg');

  .login-form {
    right: 50%;
    top: 50%;
    transform: translate3d(50%, -50%, 0);
    background-color: rgba(255, 245, 223, 0.8); /* 调整为淡橙色半透明背景 */
    font-size: 14px;
    font-weight: 500;
    box-sizing: border-box;
    width: 420px;
    padding: 15px;
    margin: 0 auto; /* 修正水平居中 */
    border-radius: 30px; /* 统一圆角风格 */
    box-shadow: 0 0 8px rgba(242, 143, 78, 0.5); /* 调整为橙色阴影 */

    .h1 {
      color: rgba(242, 143, 78, 1); /* 调整标题为暖橙色 */
      font-size: 28px;
      margin: 15px auto;
      text-align: center;
    }

    .rgs-form {
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;

      .el-form-item {
        width: 100%;
      }

      .input, .send-code {
        color: #BA7A48; /* 暖棕色文字 */
        background-color: #FFF8E7; /* 淡橙色背景 */

        .el-input__inner, .register-code {
          border-color: #BA7A48; /* 暖棕色边框 */
          background-color: #FFF8E7; /* 淡橙色背景 */
        }

        .register-code {
          background-color: #F48FB1; /* 淡粉色按钮背景 */
        }
      }

      .btn, .close {
        background-color: #F9A825; /* 暖黄色按钮 */
        border-color: #F9A825;
        color: #fff;

        &:hover {
          background-color: #FBC02D; /* 淡黄色按钮悬停 */
          border-color: #FBC02D;
        }
      }

      .close {
        background-color: #fff;
        color: #F57C00; /* 橙色文字 */
        border-color: #F57C00; /* 橙色边框 */
      }
    }
  }
}

</style>
