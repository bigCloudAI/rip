<template>
    <div class="win" v-show="this.win.winstat.size!='min'"  @mousedown="focusWin" 
    :style="{ 'z-index': (win.iffocus?1:0),'position': 'absolute',
    'width': winW +'px',
    'height':winH +'px',
    'min-width':'300px',
    'min-height':'400px',
     'left':((this.win.winstat.size=='max')?0: win.left)+'px',
     'top':((this.win.winstat.size=='max')?0: win.top) + 'px'}">
        <div v-show="!win.disresize" 
        v-th_drag.stop="{win:getwin}" style="width:100%;height:2px;cursor:n-resize;background-color: rgb(255, 255, 255,0.6);"></div>
        
       <div class="wincon">
           <div  style="width:100%;height:35px;"></div>
           <div style="width:100%;height:calc(100% - 40px);overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">
               <component :is="win.comp"></component>
           </div>
           <div v-show="!win.disresize" v-lw_drag.stop="{win:getwin}" style="position: absolute;top:0px;width:6px;height:100%;cursor:e-resize;left:-3px"></div>
           <div v-show="!win.disresize" v-rw_drag.stop="{win:getwin}" style="position: absolute;top:0px;width:6px;height:100%;cursor:e-resize;right:-3px"></div>
        </div>
        <div class="wintop" v-drag="{win:getwin,updateXY:updateXY}"
         :style="{'background-color': win.iffocus?'rgb(233, 236, 236)':'rgb(233, 236, 236,0.4)'}">
           <i :class="'fa '+ win.icon" :style="{'color':(win.iffocus?'#409EFF':'')}"></i>
           <span style="margin-left:3px">{{win.name}}</span>
           
           <el-button style="position: absolute;right:65px;top:3px" 
            @click.stop="minWin" v-show="!this.win.onlyExitBtn"
            icon="el-icon-minus" type="success" circle size="mini"></el-button>  
            <!-- 最小化 -->

           <el-button style="position: absolute;right:35px;top:3px"
             @click.stop="maxWin" v-if="this.win.winstat.size=='normal'"
             v-show="!this.win.onlyExitBtn"
             icon="el-icon-plus" type="warning" circle size="mini"></el-button> 
             <!-- 最大化 -->

           <el-button style="position: absolute;right:35px;top:3px"
             @click.stop="normalWin" v-else-if="this.win.winstat.size=='max'"
             v-show="!this.win.onlyExitBtn"
             icon="el-icon-copy-document" type="warning" circle size="mini"></el-button> 
             <!-- 还原 -->

           <el-button style="position: absolute;right:5px;top:3px" 
           @click.stop="delWin" icon="el-icon-close" type="danger" circle size="mini"></el-button> 
           <!-- 关闭 -->

       </div>
       <div class="winbottom" v-show="!win.disresize">
           <div v-bh_drag.stop="{win:getwin}" style="width:100%;height:6px;cursor:n-resize"></div>
           <div v-bhlw_drag.stop="{win:getwin}"  style="position: absolute;left:0px;top:0px;width:10px;height:6px;cursor:sw-resize"></div>
           <div v-bhrw_drag.stop="{win:getwin}"  style="position: absolute;right:0px;top:0px;width:10px;height:6px;cursor:se-resize"></div>
       </div>
    </div> 
</template>

<script>
export default {
    name: "win",
    props: {
        title: String,
        win:Object
    },
    data(){
        return {
        }
    }, 
    watch:{
    },
    computed:{
        winW(){
            if(this.win.winstat.size=='max'){
                 return document.body.clientWidth;
            }else if(this.win.winstat.size=='min'){
                return 0;
            }else{
                return this.win.width;
            }
        },
        winH(){
            if(this.win.winstat.size=='max'){
                 return document.body.clientHeight;
            }else if(this.win.winstat.size=='min'){
                return 0;
            }else{
                return this.win.height;
            }
        }
    },
    mounted(){
       
    },
    created: function(){
        this.init();
    },
    methods:{
        updateXY(left,top){
            this.win.left=left;
            this.win.top=top;
        },
        getwin(){
            return this.win;
        },
        focusWin(){
            if(!this.win.iffocus){
                this.$emit('focuswins',this.win);
                this.win.iffocus=true;
            }            
        },
        delWin(){
             this.$emit('delwin',this.win);
        },
        maxWin(){
            this.win.winstat.size="max";
        },
        normalWin(){
            this.win.winstat.size="normal";
        },
        minWin(){
            this.win.winstat.oldSize = this.win.winstat.size;
            this.win.winstat.size="min";
            this.win.iffocus=false;
        },
        loadertpl(){    
            let modelpath = this.win.comp;
            this.win.comp = ()=>import("@/public/"+modelpath);            
        },
        init(){
            let _that = this;
            console.log("load---"+this.win.comp);
            if(this.win.comp==""){
                this.win.comp = ()=>import('@/public/DefaultComp.vue');
            }else{
                _that.loadertpl();
            }             
        }
    },
    directives: {
        drag: {
           bind: function (el,bindings) {
                el.onmousedown = (e) => {
                     let disX = e.clientX - bindings.value.win().left;
                     let disY = e.clientY - bindings.value.win().top;
                    // console.log("disX"+disX);
                     document.onmousemove = (e)=>{
                        //用鼠标的位置减去鼠标相对元素的位置，得到元素的位置
                        let left = e.clientX - disX;    
                        let top = e.clientY - disY;
                        //绑定元素位置到positionX和positionY上面
                        //移动当前元素
                       // el.style.left = left + 'px';
                        //el.style.top = top + 'px'; 
                        bindings.value.updateXY(left,top);
                    };
                    document.onmouseup = () => {
                        document.onmousemove = null;
                        document.onmouseup = null;  
                                             
                    };
                };
            }
        },
        th_drag: {
           bind: function (el,bindings) {
                el.onmousedown = (e) => {
                     let disY = e.clientY - bindings.value.win().top;
                     let oldH = bindings.value.win().height;
                     let oldT = bindings.value.win().top;
                     document.onmousemove = (e)=>{
                        bindings.value.win().top = e.clientY - disY; 
                        bindings.value.win().height = oldH -(e.clientY - oldT) ;
                        console.log(bindings.value.win().height);
                    };
                    document.onmouseup = () => {
                        document.onmousemove = null;
                        document.onmouseup = null;  
                                             
                    };
                };
            }
        },
        bh_drag: {
           bind: function (el,bindings) {
                el.onmousedown = () => {
                     let oldT = bindings.value.win().top;
                     document.onmousemove = (e)=>{
                        bindings.value.win().height =  (e.clientY - oldT) ;
                    };
                    document.onmouseup = () => {
                        document.onmousemove = null;
                        document.onmouseup = null;                     
                    };
                };
            }
        },
        lw_drag: {
             bind: function (el,bindings) {
                el.onmousedown = (e) => {
                     let disX = e.clientX - bindings.value.win().left;
                     let oldW = bindings.value.win().width;
                     let oldL = bindings.value.win().left;
                     document.onmousemove = (e)=>{
                        bindings.value.win().left = e.clientX - disX; 
                        bindings.value.win().width = oldW -(e.clientX - oldL) ;
                    };
                    document.onmouseup = () => {
                        document.onmousemove = null;
                        document.onmouseup = null;  
                                             
                    };
                };
            }
        },
        rw_drag: {
             bind: function (el,bindings) {
                el.onmousedown = () => {
                     
                     let oldL = bindings.value.win().left;
                     document.onmousemove = (e)=>{
                        bindings.value.win().width = e.clientX - oldL ;
                    };
                    document.onmouseup = () => {
                        document.onmousemove = null;
                        document.onmouseup = null;  
                                             
                    };
                };
            }
        },
        bhlw_drag:{
            bind: function (el,bindings) {
                el.onmousedown = (e) => {
                     let oldT = bindings.value.win().top;
                     let disX = e.clientX - bindings.value.win().left;
                     let oldW = bindings.value.win().width;
                     let oldL = bindings.value.win().left;
                     document.onmousemove = (e)=>{
                        bindings.value.win().height =  (e.clientY - oldT) ;
                        bindings.value.win().left = e.clientX - disX; 
                        bindings.value.win().width = oldW -(e.clientX - oldL) ;
                    };
                    document.onmouseup = () => {
                        document.onmousemove = null;
                        document.onmouseup = null;                     
                    };
                };
            }
        },
        bhrw_drag:{
             bind: function (el,bindings) {
                el.onmousedown = () => {
                     let oldT = bindings.value.win().top;
                     let oldL = bindings.value.win().left;
                     document.onmousemove = (e)=>{
                        bindings.value.win().height =  e.clientY - oldT ;
                        bindings.value.win().width = e.clientX - oldL ;
                    };
                    document.onmouseup = () => {
                        document.onmousemove = null;
                        document.onmouseup = null;                     
                    };
                };
            }
        }


  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.win {
  top: 20px;
  left: 350px;
  position: absolute !important;
  background-color:rgba(240,248,255,1);
  border-radius: 4px;
  border: 1px solid rgb(165, 163, 163);
}

.wintop {
//   cursor:move;
  width: 100%;
  height: 35px;
  position: absolute !important;
  background-color: rgb(233, 236, 236);
  border-top-left-radius: 5px;border-top-right-radius: 5px;
  padding-left: 7px;
  line-height: 35px
}
.wincon{
  position: absolute !important;
  height:100%;
  width:100%;
  
}
.winbottom{
    position: absolute !important;
    width: 100%;
    bottom:0px
}

</style>
