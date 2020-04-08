<template>
  <div class="iaas">
    <div style="padding:20px">
      <el-form ref="form" :model="form" label-width="100px" :size="ripsize">
        <el-form-item
          label="仓库名称:"
          prop="name"
          :rules="[{required: true, message: '仓库名称不能为空', trigger:'blur'}]" >
          <el-input v-model="form.name" style="width:300px"></el-input>
        </el-form-item>

        <el-form-item label="仓库地址"  prop="repourl"
        :rules="[{required: true, message: '仓库地址不能为空', trigger:'blur'}]"
        >
          <el-input  v-model="form.repourl"></el-input>
        </el-form-item>

        <el-form-item label="仓库类型:" prop="type" :rules="{required: true, message: '请选择服务器类型'}">
          <el-select v-model="form.type" placeholder="请选择仓库类型">
            <el-option label="git" value="git"></el-option>
            <el-option label="svn" value="svn"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="登录用户"  prop="username"
        :rules="[{required: true, message: '登录用户不能为空', trigger:'blur'}]">
          <el-input v-model="form.username" style="width:250px"></el-input>
        </el-form-item>
        <el-form-item label="密码:" prop="password" :rules="{required: true, message: '密码不能为空'}">
          <el-input v-model="form.password" type="password" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addProCodeRepo()">提交</el-button>
          <el-button @click="resetForm()">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import store from "@/store";

import { addProCodeRepo } from "@/api/requestManage.js";
export default {
  name: "AddProCodeRepo",
  data() {
    return {
      form: {
        name: "",
        repourl: "",
        type: "",
        username: "",
        password: ""
      }
    };
  },
  methods: {
    closeWin() {
      store.commit("delWin", { key: 412 });
    },
    addProCodeRepo() {
      let _that = this;
      _that.form.devProId = this.$store.state.curDevPro.id;
      this.$refs.form.validate(valid => {
        if (valid) {
          addProCodeRepo(_that.form).then(res => {
            if (!res) {
              _that.$message.error(" 添加代码仓库失败 ");
              return;
            } else {
              _that.updatePage();
              _that.closeWin();
              _that.$message.info(" 添加代码仓库成功 ");
            }
          });
        } else {
           return false;
        }
      })
    },
    updatePage(){//触发主窗口更新
      let _that = this;
      let mdevPlat = _that.$store.state.mdevPlat;
      mdevPlat.devProPageCount=mdevPlat.devProPageCount+1;
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