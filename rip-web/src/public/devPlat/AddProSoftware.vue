<template>
  <div class="iaas">
    <div style="padding:20px">
      <el-form ref="form" :model="form" label-width="100px" :size="ripsize">
        <el-form-item
          label="名称:"
          prop="zhname"
          :rules="[{required: true, message: '名称不能为空', trigger:'blur'}]" >
          <el-input v-model="form.zhname" style="width:300px"></el-input>
        </el-form-item>
         <el-form-item label="选取仓库:" prop="codeRepoName" 
         :rules="{required: true, message: '请选择仓库'}">
          <el-select v-model="form.codeRepoName" placeholder="请选择仓库">
            <el-option label="测试仓库" value="测试仓库"></el-option>
            <el-option label="测试仓库2" value="测试仓库2"></el-option>
          </el-select>
        </el-form-item>
         <el-form-item label="构建工具:" prop="buildTool" 
         :rules="{required: true, message: '请选择构建工具'}">
          <el-select v-model="form.buildTool" placeholder="请选择构建工具">
            <el-option label="maven" value="maven"></el-option>
            <el-option label="nodejs" value="nodejs"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item
          label="构建指令:"
          prop="buildCmd"
          :rules="[{required: true, message: '构建指令不能为空', trigger:'blur'}]" >
          <el-input v-model="form.buildCmd" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item
          label="输出路径:"
          prop="buildTargetPath"
          :rules="[{required: true, message: '输出路径不能为空', trigger:'blur'}]" >
          <el-input v-model="form.buildTargetPath" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item
          label="软件包名称:"
          prop="softwareName"
          :rules="[{required: true, message: '软件包名称不能为空', trigger:'blur'}]" >
          <el-input v-model="form.softwareName" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item label="软件包格式:" prop="targetType" 
         :rules="{required: true, message: '请选择软件包格式'}">
          <el-select v-model="form.targetType" placeholder="请选择软件包格式" style="width:150px">
            <el-option label="jar" value="jar"></el-option>
            <el-option label="war" value="war"></el-option>
            <el-option label="dir" value="dir"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addProSoftware()">提交</el-button>
          <el-button @click="resetForm()">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import store from "@/store";
import { addProSoftware } from "@/api/requestManage.js";

export default {
  name: "AddServer",
  data() {
    return {
      form: {
        zhname: "",
        codeRepoName: "",
        buildTool: "",
        buildCmd: "",
        buildTargetPath: "",
        softwareName: "",
        targetType: ""
      }
    };
  },
  methods: {
    closeWin() {
      store.commit("delWin", { key: 413 });
    },
    addProSoftware() {
      let _that = this;
      _that.form.devProId = this.$store.state.curDevPro.id;
      this.$refs.form.validate(valid => {
        if (valid) {
         addProSoftware(_that.form).then(res => {
            if (!res) {
              _that.$message.error(" 添加软件包构建失败 ");
              return;
            } else {
              _that.updatePage();
              _that.closeWin();
              _that.$message.info(" 添加软件包构建成功 ");
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