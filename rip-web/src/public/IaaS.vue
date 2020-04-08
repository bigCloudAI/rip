<template>
  <div class="iaas">
    <el-tabs v-model="activeName" >
    <!-- <el-tab-pane label="虚拟机" name="vm">Virtual machine</el-tab-pane> -->
    <el-tab-pane label="服务器" name="server">
      <el-row>
        <el-form :inline="true" :model="formInline" :size="ripsize">
          <el-form-item label="服务器类型">
            <el-select v-model="formInline.stype" placeholder="服务器类型">
              <el-option label="centos" value="centos"></el-option>
              <el-option label="redhat" value="redhat"></el-option>
              <el-option label="ubuntu" value="ubuntu"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="IP地址">
            <el-input v-model="formInline.ipAddress" placeholder="IP地址"></el-input>
          </el-form-item>
          <el-form-item label="主机名">
            <el-input v-model="formInline.hostname" placeholder="主机名"></el-input>
          </el-form-item>
          <el-form-item style="margin-left:10px;padding-top:2px">
            <el-button type="primary"  @click="serverPage">查询</el-button>
          </el-form-item>
        </el-form>
      </el-row>
      <el-table
        ref="singleTable"
        :data="servers"
        highlight-current-row
        :size="ripsize"
        :header-cell-style="{'text-align':'center'}"
        :cell-style="{'text-align':'center'}"
        style="width: 100%">
        <el-table-column
          type="index"
          width="50">
        </el-table-column>
        <el-table-column
          property="ipAddress"
          label="IP地址"
          width="220">
        </el-table-column>
        <el-table-column
          property="hostName"
          label="主机名"
          width="180">
        </el-table-column>
        <el-table-column label="状态" width="120">
          <template property="status" slot-scope="scope">
            <el-tag type="success" v-if="scope.row.status==0">正常</el-tag>
            <el-tag type="error" v-if="scope.row.status==1">异常</el-tag>
          </template>
        </el-table-column>
         <el-table-column
          property="stype" width="240"
          label="服务器类型">
        </el-table-column>
        <el-table-column
          property="userName"
          label="登录用户"
          width="120">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
              <el-link icon="el-icon-edit" type="primary" style="margin-right:10px" @click="handleEdit(scope.$index, scope.row)">编辑</el-link>
              <el-link icon="el-icon-delete" type="primary" @click="handleDelete(scope.$index, scope.row)">删除</el-link>
          </template>
        </el-table-column>
      </el-table>
      <el-row style="margin-top:10px">
        <el-col :span="10">
           <el-button type="primary" :size="ripsize" @click="addDrawer">增加</el-button>
           <div v-show="false">{{addServerCount}}</div>
        </el-col>
        <el-col :span="14">
          <el-pagination  :size="ripsize"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[10, 20, 30, 40]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
          </el-pagination>
        </el-col>
      </el-row>
    </el-tab-pane>
    <el-tab-pane label="存储" name="storage">Storage</el-tab-pane>
    <el-tab-pane label="带宽" name="bandwidth">Network bandwidth</el-tab-pane>
    <el-tab-pane label="安全防护" name="sagepro">Safety Protection</el-tab-pane>
  </el-tabs>

  </div>
</template>

<script>
import { mapState } from 'vuex'
import store from '@/store'
import {serverPage,deleteServer} from "@/api/requestManage.js";
export default {
  name: "IaaS",
  data(){
    return{
      currentPage:0,
      pageSize:10,
      total:0,
      drawer:false,
      title:"添加服务器",
      dialogAddgsVisible:false,
      formLabelWidth:"100px",
      activeName:'server',
      addForm:{
        name:"2",
        sort:"1"
      },
      rules:{},
      addWinMenu: {key:61,name:"添加服务器",comp:"iaas/AddServer.vue",icon:"fa-cubes",width:500,height:400,isSelect:false,
          left:0,top:0,oToMany:false,iffocus:false,winleft:500,wintop:250,onlyExitBtn:true,disresize:true},
      formInline: {
          user: '',
          region: ''
        },
      servers:[
      ],
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!');
    },
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(row);
      let _that = this;
      let data={id:row.id}
      deleteServer (data).then( res => {
        if(!res||res.code!=200){
            _that.$message.error(" 删除失败 ");
            return;
        }else{
            _that.$message.info(" 删除完成 ");
             this.serverPage();
        }
      })
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageSize=val;
      this.serverPage();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
       this.currentPage=val;
      this.serverPage();
    },
    addDrawer(){
      this.addWinMenu.isSelect=false;
      store.commit("addWin", this.addWinMenu)
    },
  
    /**
     *关闭或取消模态框，清空值
      * @param
      */
    closeDialogAddgsVisible(){
      this.$refs.addForm.resetFields();//element封装的方法,清空模态框的值
      this.title="" //初始化title的值
      this.addForm={//初始化addForm中的值
        name:"",
        sort:"",
      }
    },

    /**
     *确定新增数据
      * @param
      */
    saveAddForm(aaa){
      this.$refs[aaa].validate( (valid) => {
        console.log(this.$refs[aaa])
        if(valid){
          let params={
              name:this.addForm.name,
              sort:this.addForm.sort
          }
          this.axios.post(`接口地址`,params).then( res =>{
            alert('新增成功'+res);
            this.dialogAddgsVisible = false;
            // this.$router.push({name:'categories'})
            this.init()
          })
        }
      })
    },
    serverPage(){
      let _that = this;
      let data={
        size: this.pageSize,
        page: this.currentPage-1
      };
      serverPage (data).then( res => {
        if(!res||res.code!=200){
            _that.$message.error(" 获取采集服务实例监控数据失败 ");
            return;
        }else{
            console.log(res);
            _that.servers = res.content.content;
            _that.total = res.content.totalElements;
            // _that.$message.info(" okok ");
        }
      })
    }
  },
  computed: {
    ...mapState(['ripsize']),
    addServerCount(){
      this.serverPage();
      return this.$store.state.miaas.addServerCount;
    }
  },
  created(){
    console.log(this.$db); 
    //this.serverPage();
  },
};
</script>

<style lang="css">
.tableRowCss{
  background-color: aqua;
  color:red;
  height:10px !important
}
</style>

<style scoped lang="scss">
.tableBox{
  th {
    padding:0 !important;
    height: 20px;
    line-height: 20px;
  }
  td {
    padding:0 !important;
    height: 30px;
    line-height: 30px;
  }
}
.iaas {
  margin: 0;
  height: 100%;
  // background-color: rgb(221, 218, 218);
  padding: 6px;
  padding-left: 28px;
  padding-right: 28px;
}
.el-pagination{
  text-align: right;
}

</style>
