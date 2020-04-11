<template>
  <div class="author">
    <el-row :gutter="10" class="pagerow">
      <el-col :span="5"></el-col>
      <el-col :span="14">
          <el-row :gutter="5" class="pagerow">
            <el-col :span="18" class="bg-purple-conb">
                <el-row :gutter="5" style="height: 120px;margin-top: 8px;">
                  <el-col :span="6" >
                    <div class="menu-a" @click="page='about'">
                      <i class="el-icon-user-solid" style="font-size:68px"></i>
                    </div>
                  </el-col>
                  <el-col :span="6" >
                    <div class="menu-b"  @click="page='exp'">
                      <i class="el-icon-s-order" style="font-size:68px"></i>
                    </div>
                  </el-col>
                  <el-col :span="6" >
                    <div class="menu-a"  @click="page='work'">
                      <i class="el-icon-s-flag" style="font-size:68px"></i>
                    </div>
                  </el-col>
                  <el-col :span="6" >
                    <div class="menu-b"  @click="page='contact'"> 
                      <i class="el-icon-phone" style="font-size:68px"></i>
                    </div>
                  </el-col>
                </el-row>
                
                <div style="height:calc(100% - 140px);margin-top:5px" class="bg-purple-white">
                  <template v-if="page=='about'">
                    <authorAbout></authorAbout>
                  </template>
                  <template v-if="page=='exp'">
                    <authorExp></authorExp>
                  </template>
                  <template v-if="page=='work'">
                    <el-row style="padding:10px;">作品</el-row>
                  </template>
                  <template v-if="page=='contact'">
                    <el-row style="padding:10px;">联系</el-row>
                  </template>
                </div>

            </el-col>
            <el-col :span="6" class="bg-purple-conb">
               <div style="height:calc(100% - 13px);margin-top:8px" class="bg-purple-white">
                <authorBase></authorBase>
               </div>
            </el-col>
          </el-row>
      </el-col>
      <el-col :span="5" ></el-col>
    </el-row>
  </div>
</template>

<script>
import authorExp from './comp/AuthorExp.vue'
import authorAbout from './comp/AuthorAbout.vue'
import authorBase from './comp/AuthorBase.vue'
export default {
   data(){
        return {
          page:"about"
        }
    },
  components: {
      'authorExp':authorExp,
      'authorAbout':authorAbout,
      'authorBase':authorBase,
  },
}
</script>

<style scoped lang="scss">
.el-divider{
  margin-top:2px !important;
  margin-bottom:2px !important;
}
.author{
  background-color: aliceblue;
  height: 100%;
}
.pagerow{
  height: 98%;
}
.el-col{
  height: 100%;
  border-radius: 4px;
}
.menu-a{
  cursor: pointer;
  height: 100%;
  background-color:white;
  border-radius: 0px;
  text-align: center;
  line-height: 140px;
}
.menu-a:hover{
  background-color:lightcyan;
  i {
    position: relative;
    color: red;
    animation:mymove 1s;
		-webkit-animation:mymove 1s;
  }

}
.menu-b{
  cursor: pointer;
  height: 100%;
  background-color:ghostwhite;
  border-radius: 0px;
  text-align: center;
  line-height: 140px;
}
.menu-b:hover{
  background-color:lightcyan;
    i {
    position: relative;
    color: red;
    animation:mymove 1s;
		-webkit-animation:mymove 1s;
  }
}

.bg-purple-flag{
  background-color:darkorange;
}

.bg-purple{
  height: 100%;
  background-color: red;
  border-radius: 0px;
  text-align: center;
  line-height: 140px;
}
.bg-purple-conb{
  height: 100%;
  border-radius: 0px;
}
.bg-purple-light{
  height: 100%;
  background-color: aqua;
  border-radius: 0px;
}
.bg-purple-white{
  height: 100%;
  background-color: white;
  border-radius: 0px;
}
@keyframes mymove
	{
	from {color:blue;top:-20px}
	to {color:red;top:0px}
}

/*Safari 和 Chrome:*/
@-webkit-keyframes mymove
{
	from {color:blue;top:-20px}
	to {color:red;top:0px}
}
</style>
