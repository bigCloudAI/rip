<template>
  <div class="iaas">
    <div style="padding:20px">
      <el-form ref="form" :model="form" label-width="100px" :size="ripsize">
        <el-form-item
          label="名称:"
          prop="name"
          :rules="[{required: true, message: '名称不能为空', trigger:'blur'}]" >
          <el-input v-model="form.name" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item
          label="选择部署镜像:"
          prop="image"
          :rules="[{required: true, message: '部署镜像不能为空', trigger:'blur'}]" >
           <el-select v-model="form.image" placeholder="选择部署镜像">
            <el-option label="test" value="test"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item
          label="选择部署方式:"
          prop="deployWay"
          :rules="[{required: true, message: '部署方式不能为空', trigger:'blur'}]" >
           <el-select v-model="form.deployWay" placeholder="选择部署方式">
            <el-option label="主机容器" value="hostDocker"></el-option>
            <el-option label="云平台接口" value="cloudApi"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item
          label="选择环境:"
          prop="env"
          :rules="[{required: true, message: '环境不能为空', trigger:'blur'}]" >
          <el-select v-model="form.env" placeholder="选择环境">
            <el-option label="192.168.0.1" value="1"></el-option>
            <el-option label="192.168.0.2" value="2"></el-option>
            <el-option label="k8scloud1" value="k8scloud1"></el-option>
            <el-option label="k8scloud2" value="k8scloud2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item
          label="选择环境分类:"
          prop="envType"
          :rules="[{required: true, message: '环境分类不能为空', trigger:'blur'}]" >
          <el-select v-model="form.envType" placeholder="选择环境分类">
            <el-option label="开发" value="dev"></el-option>
            <el-option label="测试" value="test"></el-option>
            <el-option label="生产" value="prod"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="自定义标签"  prop="diyTag">
          <el-input v-model="form.diyTag"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addProRelease()">提交</el-button>
          <el-button @click="resetForm()">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import store from "@/store";
import { addProRelease } from "@/api/requestManage.js";
export default {
  name: "AddServer",
  data() {
    return {
      form: {
        name: "",
        image: "",
        deployWay: "",
        env: "",
        envType: "",
        diyTag: ""
      }
    };
  },
  methods: {
    closeWin() {
      store.commit("delWin", { key: 415 });
    },
    addProRelease() {
      let _that = this;
      _that.form.devProId = this.$store.state.curDevPro.id;
      this.$refs.form.validate(valid => {
        if (valid) {
          addProRelease(_that.form).then(res => {
            if (!res) {
              _that.$message.error(" 添加运行逻辑失败 ");
              return;
            } else {
              _that.updatePage();
              _that.closeWin();
              _that.$message.info(" 添加运行逻辑成功 ");
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