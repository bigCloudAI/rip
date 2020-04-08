<template>
  <div class="iaas">
    <div style="padding:20px">
      <el-form ref="form" :model="form" label-width="100px" :size="ripsize">
        <el-form-item
          label="IP地址:"
          prop="ipAddress"
          :rules="[{required: true,
         message: 'IP地址不能为空', trigger:'blur'},
         {validator:this.validcodeip,trigger:'blur'}]"
        >
          <el-input v-model="form.ipAddress" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item label="服务器类型:" prop="stype" :rules="{required: true, message: '请选择服务器类型'}">
          <el-select v-model="form.stype" placeholder="请选择服务器类型">
            <el-option label="centos" value="centos"></el-option>
            <el-option label="redhat" value="redhat"></el-option>
            <el-option label="ubuntu" value="ubuntu"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="用户名:" prop="userName" :rules="{required: true, message: '用户名不能为空'}">
          <el-input v-model="form.userName" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item label="密码:" prop="password" :rules="{required: true, message: '密码不能为空'}">
          <el-input v-model="form.password" type="password" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addServer()">提交</el-button>
          <el-button @click="resetForm()">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import store from "@/store";
import { addServer } from "@/api/requestManage.js";

export default {
  name: "AddServer",
  data() {
    return {
      form: {
        ipAddress: "",
        stype: "",
        userName: "",
        password: ""
      },
      validcodeip : (rule, value, callback) => {
        const reg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
        console.log("1")
        if (reg.test(value)) {
          callback();
        } else {
          return callback(new Error("输入的IP格式不合法！"));
        }
      }
    };
  },
  methods: {
    closeWin() {
      store.commit("delWin", { key: 61 });
    },
    addServer() {
      let _that = this;
      this.$refs.form.validate(valid => {
        if (valid) {
          addServer(_that.form).then(res => {
            if (!res) {
              _that.$message.error(" 添加服务器失败 ");
              return;
            } else {
              _that.updateServerPage();
              _that.closeWin();
              _that.$message.info(" 添加服务器成功 ");
            }
          });
        } else {
          return false;
        }
      });
    },
    updateServerPage(){
      let _that = this;
      let miaas = _that.$store.state.miaas;
      miaas.addServerCount=miaas.addServerCount+1;
    },
    resetForm() {
      this.$refs.form.resetFields();
    }
  },
  computed: {
    ...mapState(["ripsize"])
  }
};
</script>

<style scoped lang="scss">
.iaas {
  margin: 0;
  height: 100%;
  background-color: white;
}
.el-pagination {
  text-align: right;
}
.line {
  text-align: center;
}
</style>
// this.$message({
          //   message: '提交失败',
          //   type: 'error'
          // });
          // this.$notify({
          //   title: '系统提示',
          //   message: '提交失败',
          //   position: 'bottom-right',
          //   type: 'error'
          // });

          // this.$message({
          //   message: '添加服务器成功'+valid,
          //   type: 'success'
          // });