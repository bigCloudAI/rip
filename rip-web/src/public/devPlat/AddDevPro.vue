<template>
  <div class="iaas">
    <div style="padding:20px">
      <el-form ref="form" :model="form" label-width="100px" :size="ripsize">
        <el-form-item
          label="项目名称:"
          prop="proName"
          :rules="[{required: true, message: '项目名称不能为空', trigger:'blur'}]" >
          <el-input v-model="form.proName" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item label="项目描述"  prop="proDesc"
        :rules="[{required: true, message: '项目描述不能为空', trigger:'blur'}]"
        >
          <el-input :rows="8"  type="textarea" v-model="form.proDesc"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addPro()">提交</el-button>
          <el-button @click="resetForm()">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import store from "@/store";

import { addDevPro } from "@/api/requestManage.js";
export default {
  name: "AddDevPro",
  data() {
    return {
      form: {
        proName: "",
        proDesc: ""
      }
    };
  },
  methods: {
    closeWin() {
      store.commit("delWin", { key: 41 });
    },
    addPro() {
      let _that = this;
      this.$refs.form.validate(valid => {
        if (valid) {
          addDevPro(_that.form).then(res => {
            if (!res) {
              _that.$message.error(" 添加开发项目失败 ");
              return;
            } else {
              _that.updateDevProPage();
              _that.closeWin();
              _that.$message.info(" 添加开发项目成功 ");
            }
          });
        } else {
          return false;
        }
      })
    },
    updateDevProPage(){//触发主窗口更新
      let _that = this;
      let mdevPlat = _that.$store.state.mdevPlat;
      mdevPlat.addDevProCount = mdevPlat.addDevProCount + 1;
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