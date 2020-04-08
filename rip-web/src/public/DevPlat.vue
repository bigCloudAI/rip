<template>
  <div class="devplat">
    <template v-if="!showDevpro">
      <el-row style="margin-top:8px">
        <el-form :inline="true" :model="formInline" :size="ripsize">
          <el-form-item label="项目名">
            <el-input v-model="formInline.proName" placeholder="项目名"></el-input>
          </el-form-item>
          <el-form-item style="margin-left:10px;padding-top:2px">
            <el-button type="primary" @click="nodo">查询</el-button>
          </el-form-item>
        </el-form>
      </el-row>
      <el-row>
        <el-col :span="4" :key="i" v-for="(devPro,i) in devPros" style="padding:3px">
          <el-card :body-style="{ padding: '4px',height:'200px' }" shadow="hover">
            <div style="padding: 14px;">
              <span>{{devPro.proName}}</span>
              <div>{{devPro.proDesc}}</div>
              <div class="bottom clearfix">
                <br />
                <el-button type="text" class="button" @click="devProInfo(devPro)">详情</el-button>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
      <el-row style="margin-top:10px">
        <el-col :span="10">
          <el-button type="primary" :size="ripsize" @click="addProView">增加</el-button>
          <div v-show="false">{{addDevProCount}}</div>
        </el-col>
        <el-col :span="14">
          <el-pagination
            :size="ripsize"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="[12, 18, 24]"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total"
          ></el-pagination>
        </el-col>
      </el-row>
    </template>
    <template v-if="showDevpro">
      <el-row>
        <el-col :span="24" style="text-align:right">
          <el-link :size="ripsize" type="primary" @click="showDevpro=false" >返回</el-link>
        </el-col>
         <div v-show="false">{{devProPageCount}}</div>
      </el-row>
      
      <dev-pro :devsteps="devsteps"></dev-pro>
    </template>
  </div>
</template>

<script>
import { mapState } from "vuex";
import store from '@/store'
import DevPro from "./devPlat/DevPro";

import { devProPage,devProInfo } from "@/api/requestManage.js";

export default {
  name: "DevPlat",
  components: {
      'dev-pro':DevPro,
  },
  data() {
    return {
      devPros:[],
      currentDate: new Date(),
      currentPage: 0,
      pageSize: 12,
      total: 0,
      formInline: {},
      showDevpro:false,
      devsteps:[],
      addProMenu: 
      {key:41,name:"添加开发运维项目",
      comp:"devPlat/AddDevPro.vue",icon:"fa-github",width:500,height:400,isSelect:false,
          left:0,top:0,oToMany:false,iffocus:false,winleft:500,wintop:250,onlyExitBtn:true,
          disresize:true},
      curDevPro: null
    };
  },
  methods: {
    devProInfo(devPro){
      this.showDevpro = true;
      let _that = this;
      let data = devPro;
      this.$store.state.curDevPro = devPro;
      devProInfo (data).then( res => {
        if(!res||res.code!=200){
            _that.$message.error(" 获取数据失败 ");
            return;
        }else{
            console.log(res);
            this.devsteps=res.content;
        }
      })

    },
    nodo() {
      console.log("nodo!");
    },
    addProView(){
      console.log("弹出增加项目界面")
       this.addProMenu.isSelect=false;
       store.commit("addWin", this.addProMenu)
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageSize = val;
      this.page();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.currentPage = val;
      this.page();
    },
    page() {
      let _that = this;
      let data={
        size: this.pageSize,
        page: this.currentPage-1
      };
      devProPage (data).then( res => {
        if(!res||res.code!=200){
            _that.$message.error(" 获取数据失败 ");
            return;
        }else{
            console.log(res);
            _that.devPros = res.content.content;
            _that.total = res.content.totalElements;
        }
      })
    }
    
  },
  computed: {
    ...mapState(["ripsize"]),
    addDevProCount(){
      this.page();
      return this.$store.state.mdevPlat.addDevProCount;
    },
    devProPageCount(){
      this.devProInfo(this.$store.state.curDevPro);
      return this.$store.state.mdevPlat.devProPageCount;
    }
  },
  created(){
    //this.page();
  },
};
</script>

<style scoped lang="scss">
.devplat {
  margin: 0;
  height: 100%;
  // background-color: rgb(221, 218, 218);
  padding: 6px;
  padding-left: 28px;
  padding-right: 28px;
}
.el-pagination {
  text-align: right;
}
</style>
