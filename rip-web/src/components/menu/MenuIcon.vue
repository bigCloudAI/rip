<template>
  <div class="menuicon" @dblclick="openWin" :class="menuIcon.isSelect?'menuiconselect':''" 
  :style="{ 'position': 'absolute', 'left': menuIcon.left+'px','top':menuIcon.top + 'px'}">
      <!-- <i class="el-icon-s-custom"></i>
      <span>用户管理</span>  -->
      <div style="color: #fff;font-size: 11px;line-height: 1.3;padding: 6px 1px 6px;width: 80px;">
         <div style="margin-bottom: 8px;"><i class="fa-4x fa" :class="menuIcon.icon"></i></div>
         <span style="font-size: 12px;">{{menuIcon.name}}</span>
      </div>
  </div>
</template>

<script>
import "font-awesome/css/font-awesome.min.css";
import store from '@/store'
export default {
  name: 'menuicon',
   props: {
     menuIcon:Object
  },
  methods:{
    openWin(){
      this.menuIcon.isSelect=false;
        store.commit("addWin", this.menuIcon)
    }
  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.menuicon{
  cursor:pointer;
  text-align:center;
}

.menuiconselect{
  background-color:darkgrey;
  border: 1px black solid;
   border-radius: 3px;
}

.menuicon:hover{
  background-color:rgb(202, 199, 199);
  border: 1px black solid;
  border-radius: 3px;
}

</style>
