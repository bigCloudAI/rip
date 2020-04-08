<template>
  <div class="iaas">
    <div style="padding:20px">
      <el-form ref="form" :model="form" label-width="100px" :size="ripsize">
        <el-form-item
          label="镜像中文名称:"
          prop="zhname"
          :rules="[{required: true, message: '项镜像中文名称不能为空', trigger:'blur'}]" >
          <el-input v-model="form.zhname" style="width:300px"></el-input>
        </el-form-item>

        <el-form-item label="镜像名称"  prop="imageName"
        :rules="[{required: true, message: '镜像名称', trigger:'blur'}]"
        >
          <el-input v-model="form.imageName" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item label="选取软件包:" prop="softwareName" 
         :rules="{required: true, message: '请选择软件包'}">
          <el-select v-model="form.softwareName" placeholder="请选取软件包">
            <el-option label="测试软件包" value="测试软件包"></el-option>
            <el-option label="测试软件包2" value="测试软件包2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Dockerfile"  prop="dockerfile"
        :rules="[{required: true, message: 'Dockerfile不能为空', trigger:'blur'}]">
          <el-input :rows="8"  type="textarea" v-model="form.dockerfile"></el-input>
        </el-form-item>
        <el-form-item label="版本管理方式:" prop="versionManageWay" 
         :rules="{required: true, message: '版本管理方式'}">
          <el-select v-model="form.versionManageWay" placeholder="版本管理方式">
            <el-option label="手动填写" value="manFill"></el-option>
            <el-option label="自动加一" value="autoaddOne"></el-option>
            <el-option label="时间" value="createTime"></el-option>
            <el-option label="自定义规则" value="diyRule"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="addProImage()">提交</el-button>
          <el-button @click="resetForm()">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import store from "@/store";

import { addProImage } from "@/api/requestManage.js";
export default {
  name: "AddServer",
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
      store.commit("delWin", { key: 414 });
    },
    addProImage() {
      let _that = this;
      _that.form.devProId = this.$store.state.curDevPro.id;
      this.$refs.form.validate(valid => {
        if (valid) {
          addProImage(_that.form).then(res => {
            if (!res) {
              _that.$message.error(" 添加镜像包生产逻辑失败 ");
              return;
            } else {
              _that.updatePage();
              _that.closeWin();
              _that.$message.info(" 添加镜像包生产逻辑成功 ");
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