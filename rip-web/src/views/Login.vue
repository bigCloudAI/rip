<template>
  <div class="login">
    <el-card style="width: 400px;">
      <el-form ref="form" :model="form" style label-width="100px">
        <el-row>
          <el-col :span="24">
            <el-form-item label-width="70px">
              <span>
                <font size="4">欢迎使用Rip桌面 <router-link to="/author">作者</router-link> </font>
              </span>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="20">
            <el-form-item label="账户：" prop="name">
              <el-input v-model="form.name" size="small"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="20">
            <el-form-item label="密码：" prop="password">
              <el-input type="password" v-model="form.password" size="small"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="20">
            <el-form-item>
              <el-button type="primary" @click="submit">登录</el-button>
              <el-button @click="register">注册</el-button>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row v-show="loginMsg">
          <el-col :span="24">
            <el-form-item label-width="70px">
              <span>
                <font size="4" color="red">请填写用户和密码</font>
              </span>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </el-card>
  </div>
</template>

<script>
// @ is an alias to /src
import store from '@/store'
export default {
  name: "Login",
  components: {},
  data() {
    return {
      form: {
        name: "",
        password: ""
      },
      loginMsg: false
    };
  },
  methods: {
    /*提交进行判断的函数 */
    submit: function() {
      if (!this.form.name || !this.form.password) {
        this.loginMsg = true;
        return false;
      }
      this.loginMsg = false;
      let _that = this;
      setTimeout(() => {
        store.commit("login", {
          name: _that.form.name,
          password: _that.form.password
        });
        _that.$router.push("./");
      }, 500);
    },
    register: function() {}
  }
};
</script>
<style lang="scss" scoped>
.login {
  display: flex;
  justify-content: center;
  margin-top: 260px;
  
}
.el-form-item {
  margin-bottom: 10px;
}
</style>
