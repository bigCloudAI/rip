<template>
  <div class="taskwidget">
    <div id="bar_bottom" class="abs">
      <a id="show_desktop" title="显示桌面" class="float_left">
        <el-button type="success" size="mini" 
        style="margin-top:2px;margin-left:14px;margin-right:35px" icon="el-icon-star-off" 
        @click="$store.commit('switchStartMenu')"
        circle>
        </el-button>
        <el-button v-bind:key="win.key" @click="focuswins(win)" 
        size="mini" style="margin:2px;min-width:100px" :type="win.iffocus?'primary':'info'"  
        v-for="win in mwin.wins"><i :class="'fa '+ win.icon" style="margin-right:4px"></i>{{win.name}}</el-button>
      </a>
      
    </div>
  </div>
</template>

<script>
import store from '@/store'
import {mapGetters,mapState} from 'vuex'
export default {
  name: "taskwidget",
  props: {
    title: String
  },
  methods:{
    focuswins(win){
      if(win.winstat.size=='min'){
        win.winstat.size=win.winstat.oldSize;
        store.commit("focusWin", win)
      }else{
        if(win.iffocus){
          win.winstat.oldSize = win.winstat.size;
          win.winstat.size='min';
          win.iffocus=false;
        }else{
          store.commit("focusWin", win)
        }
        
      }
    }
  },
  computed: {
    ...mapState(['userInfo','mwin']),
    ...mapGetters(['currUserInfo'])
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.taskwidget{
    background-color: rgb(46, 46, 46);
    border-top: 0px solid #000;
    color: #000;
    font-size: 13px;
    line-height: 30px;
    opacity: 0.9;
    overflow: hidden;
    padding-top: 5px;
    padding-bottom: 5px;
    text-shadow: #000 0 1px 1px;
    height: 40px;
    bottom: 0px;
    position: absolute;
    width: 100%;
}
</style>
