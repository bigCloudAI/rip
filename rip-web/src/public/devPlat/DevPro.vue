<template>
  <div class="devpro">
   <el-row>
      <el-col :span="6" :key="index" v-for="(devstep,index) in devsteps" style="padding:3px">
        <el-card :body-style="{ padding: '4px',height:'670px' }" shadow="hover">
          <div style="padding: 14px;">
            <h4>{{devstep.name}}</h4>
             <el-card :key="indexc" v-for="(item,indexc) in devstep.items" 
              :class="item.link.select?'bred':''"
             :body-style="{ padding: '4px',height:'80px'}"   style="margin-top:10px;" shadow="hover" >
                <div style="padding: 3px;" @click="selStepItem(devstep,item)">
                  <!-- <i class="el-icon-share"></i> -->
                  <span style="margin-left:10px">{{item.link.name}}  </span>
                  
                  <br/>
                  <span style="margin-left:10px">{{item.link.value}}</span>
                  <br/>
                  <el-tag v-for="val in item.tags" size="mini" style="margin-right:5px" :key="val">{{val}}</el-tag>
                  <br/>                  
                </div>
             </el-card>
            <el-col :span="24" style="margin-top:10px;text-align: right;"> 
               <el-link icon="el-icon-circle-plus" size="small" type="primary" style="margin-right:10px" @click="addDevStepItem(devstep)">添加</el-link>
            </el-col>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { mapState } from "vuex";
import store from '@/store'

export default {
  name: "Devpro",
  props:["devsteps"],
  data() {
    return {
      // devsteps:[
      //   {name:"代码仓库",index:0,items:[
      //     {name:"bigcloud代码仓库1",value:"http://192.168.7.65:3679/bigcloud/pro",type:"svn",select:false,
      //      user:"zjk",password:"123456",link:{self:"coderepo1"}},
      //     {name:"bigcloud代码仓库2",value:"http://192.168.7.65:3679/bigcloud/pro",type:"svn",select:false,
      //      user:"zjk",password:"123456",link:{self:"coderepo2"}},
      //     {name:"bigcloud代码仓库3",value:"http://192.168.7.65:3679/bigcloud/pro",type:"svn",select:false,
      //      user:"zjk",password:"123456",link:{self:"coderepo3"}}
      //   ]},
      //   {name:"软件包",index:1,items:[
      //     {name:"前端模块",value:"dist.zip",type:"zip",historycount:3,history:[],create:"2020/3/29 22:46:32",select:false,
      //     link:{self:"software1",head:"coderepo1"}},
      //     {name:"后端模块",value:"backend.jar",type:"jar",historycount:3,history:[],create:"2020/3/29 22:46:32",select:false,
      //     link:{self:"software2",head:"coderepo1"}},
      //   ]},
      //   {name:"镜像包",index:2,items:[
      //     {name:"前端模块镜像",value:"dist:latest",type:"docker",historycount:3,history:[],create:"2020/3/29 22:46:32",select:false,
      //     link:{self:"image1",head:"software1"}},
      //     {name:"后端模块",value:"backend:latest",type:"docker",historycount:3,history:[],create:"2020/3/29 22:46:32",select:false,
      //      link:{self:"image2",head:"software2"}},
      //     {name:"后端精简版",value:"backend-mini:latest",type:"docker",historycount:3,history:[],create:"2020/3/29 22:46:32",select:false,
      //      link:{self:"image3",head:"software2"}},
      //   ]},
      //   {name:"运行环境",index:3,items:[
      //      {name:"开发环境前端",value:"192.168.80.1",type:"dev",tags:["前端","dev","bigdev"],select:false,
      //     link:{self:"release1",head:"image1"}},
      //      {name:"测试环境前端",value:"192.168.90.1",type:"test",tags:["前端","test","bigtest"],select:false,
      //     link:{self:"release2",head:"image1"}},
      //      {name:"生产环境前端",value:"192.168.100.1",type:"prod",tags:["前端","prod","bigprod"],select:false,
      //     link:{self:"release3",head:"image1"}},
      //      {name:"开发环境后端",value:"192.168.80.1",type:"dev",tags:["后端","dev","bigdev"],select:false,
      //     link:{self:"release4",head:"image2"}},
      //      {name:"测试环境后端",value:"192.168.90.1",type:"test",tags:["后端","test","bigtest"],select:false,
      //     link:{self:"release5",head:"image2"}},
      //      {name:"生产环境后端",value:"192.168.100.1",type:"prod",tags:["后端","prod","bigprod"],select:false,
      //     link:{self:"release6",head:"image2"}},
      //   ]}
      // ],
      code:"",
      software:"",
      image:"",
      release:"",
      step:"",
      showlink: false,
      addCodeRepoMenu: 
        {key:412,name:"添加项目代码仓库",
        comp:"devPlat/AddProCodeRepo.vue",icon:"fa-github",width:500,height:400,isSelect:false,
            left:0,top:0,oToMany:false,iffocus:false,winleft:500,wintop:250,onlyExitBtn:true,
            disresize:true},
      addSoftwareMenu: 
        {key:413,name:"添加项目代码软件包生成逻辑",
        comp:"devPlat/AddProSoftware.vue",icon:"fa-github",width:500,height:520,isSelect:false,
            left:0,top:0,oToMany:false,iffocus:false,winleft:500,wintop:220,onlyExitBtn:true,
            disresize:true},
      addImageMenu: 
        {key:414,name:"添加项目软件包镜像生成逻辑",
        comp:"devPlat/AddProImage.vue",icon:"fa-github",width:500,height:520,isSelect:false,
            left:0,top:0,oToMany:false,iffocus:false,winleft:500,wintop:250,onlyExitBtn:true,
            disresize:true},
      addReleaseMenu: 
        {key:415,name:"添加镜像运行环境",
        comp:"devPlat/AddProRelease.vue",icon:"fa-github",width:500,height:440,isSelect:false,
            left:0,top:0,oToMany:false,iffocus:false,winleft:500,wintop:250,onlyExitBtn:true,
            disresize:true},
    }
  },
  methods: {
    selStepItem(step,item){
      this.cancleSel();
      item.link.select=true;
      console.log(step)
      this.headFindSel(step.index,item.link.head);
      this.selfFindSel(step.index,item.link.self);
    },
    headFindSel(index,head){
      if(index<=0){
        return;
      }
      let items = this.devsteps[index-1].items;
      for(let i=0;i<items.length;i++){
        if(items[i].link.self==head){
          items[i].link.select=true;
          this.headFindSel(index-1,items[i].link.head);
        }
      }
    },
    selfFindSel(index,self){
      if(index>=3){
        return;
      }
      let items = this.devsteps[index+1].items;
      for(let i=0;i<items.length;i++){
        if(items[i].link.head==self){
          items[i].link.select=true;
          this.selfFindSel(index+1,items[i].link.self);
        }
      }
    },
    cancleSel(){
      for(let i=0;i<4;i++){
        this.cancleStep(i);
      }
    },
    cancleStep(index){
      let items = this.devsteps[index].items;
      for(let i=0;i<items.length;i++){
        items[i].link.select = false;
      }
    },
    addDevStepItem(devstep){
      console.log(devstep);
      switch (devstep.index) {
        case 0:
          this.addCodeRepoMenu.isSelect = false;
          store.commit("addWin", this.addCodeRepoMenu)
          break;
        case 1:
          this.addSoftwareMenu.isSelect=false;
          store.commit("addWin", this.addSoftwareMenu)
          break;
        case 2:
          this.addImageMenu.isSelect=false;
          store.commit("addWin", this.addImageMenu)
          break;
        case 3:
          this.addReleaseMenu.isSelect=false;
          store.commit("addWin", this.addReleaseMenu)
          break;
        default:
          break;
      }
    }
  },
  computed: {
    ...mapState(["ripsize"])
  }
};
</script>

<style scoped lang="scss">
.bred{
  background-color:rgb(255, 251, 0)
}
.devpro {
  margin: 0;
  height: 100%;
}
.el-pagination {
  text-align: right;
}
.line {
  text-align: center;
}
</style>