<template>
  <div>
    <backwell :title="backwellTitle" @contextenable="contextenable" @contextdisable="contextdisable"></backwell>
    <menuwidget :title="menuWidgetTitle" ref="menuwidget"></menuwidget>
    <winwidget :title="winWidgetTitle"></winwidget>
    <taskwidget :title="taskWidgetTitle"></taskwidget>
    <context :context="context" @sortMenu="sortMenu"></context>
  </div>
</template>
<script>
import BackWell from '@/components/back/BackWell.vue'
import MenuWidget from '@/components/menu/MenuWidget.vue'
import WinWidget from '@/components/win/WinWidget.vue'
import TaskWidget from '@/components/task/TaskWidget.vue'
import Context from '@/components/Context.vue'

  export default {
    name: 'Ripweb',
    data(){
      return{
        backwellTitle:'背景',
        menuWidgetTitle:'菜单',
        winWidgetTitle:'窗口',
        taskWidgetTitle:'任务',
        context:{
          contextable:false,
          left:0,
          top:0
        }
        
      }
    },
    methods:{
      contextenable(event){
        this.context.contextable=true;
        this.context.left=event.offsetX;
        this.context.top=event.offsetY;
      },
      contextdisable(){
        this.context.contextable=false;
        this.$refs.menuwidget.allreMenuIcons();//释放选择
      },
      sortMenu(){
        console.log("排序");
        this.$refs.menuwidget.initMenuIcons();
        this.context.contextable=false;
      }
    },
    components: {
      'backwell':BackWell,
      'menuwidget':MenuWidget,
      'winwidget':WinWidget,
      'taskwidget':TaskWidget,
      'context':Context,
    }
  }
</script>
<style lang="scss">
body {
  margin: 0px;
  -webkit-user-select:none;
  -moz-user-select:none;
  -ms-user-select:none;
  user-select:none;
}

$w : 0px;
#app {
  border:$w solid #000;
  overflow-x: hidden; 
  overflow-y: hidden; 
  width: 100%;
  height: 100%;
  position:absolute;
}
</style>
