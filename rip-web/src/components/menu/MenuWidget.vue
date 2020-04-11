<template>
  <div class="menuwidget">
     <!-- <menuIcon style="position: absolute; left: 50px;top:50px" v-drag :select="isSelect"></menuIcon>
     <menuIcon style="position: absolute; left: 50px;top:150px" v-drag></menuIcon>
     <menuIcon style="position: absolute; left: 50px;top:250px" v-drag></menuIcon> -->
    
     <!-- <button @click="coM">123123</button> -->
     <menuIcon v-bind:key="key"
     v-for=" (menuIcon,key) in menuIcons" :menuIcon="menuIcon" 
     v-drag.stop="{menuIcon:menuIcon,key:key,selectMenu:selectMenu}" ></menuIcon>

     <div v-show="$store.state.ifStartMenus"
     style="z-index:1;height:600px;min-width:500px;bottom: 40px;position: absolute;background-color:#2e2e2e;
     border-radius: 0px;">
        <div style="width:180px;height:100%;background-color:white;padding-top:15px">
            <div style="width:140px;height:140px;background-color:gray;margin:0px auto"></div>


            <div style="width:140px;position:absolute;
           bottom:0px;margin:20px;padding-bottom:5px">

              <div v-bind:key="key"  v-for=" (menuIcon,key) in menuIcons" 
                style="padding-left: 2px;margin-top:13px">
                   <el-link :underline="false" style="font-size:15px;">
                     <i :class="'fa '+menuIcon.icon" style="width:28px"></i> <span>{{menuIcon.name}}</span>
                   </el-link>
              </div>  
              <div style="background-color:gray;height:1px;margin-top:13px"></div>
              <div style="padding-left: 2px;margin-top:13px">
                  <el-link :underline="false" style="font-size:15px;">
                    <router-link to="/author"><i class="fa fa-address-book" style="width:28px"></i><span>作者</span></router-link> 
                  </el-link>
              </div>  
              <div style="padding-left: 2px;margin-top:13px">
                   <el-link :underline="false" style="font-size:15px;">
                     <i class="fa fa-cogs" style="width:28px"></i><span>系统设置</span>
                   </el-link>
              </div>   
              <div style="padding-left: 2px;margin-top:13px">
                   <el-link :underline="false" style="font-size:15px;">
                     <i class="fa fa-power-off" style="width:28px"></i><span>退出</span>
                   </el-link>
              </div>         
            </div> 
        </div>
      </div>
  </div>
</template>

<script>
import MenuIcon from './MenuIcon.vue'
export default {
  name: 'menuwidget',
  data(){
    return{
        menuIcons:[
          {key:6,name:"基础设施",comp:"IaaS.vue",icon:"fa-cubes",width:1350,height:750,isSelect:false,
          left:0,top:0,oToMany:false,iffocus:false,winleft:240,wintop:80},
          {key:1,name:"云平台",comp:"RipOs.vue",icon:"fa-mixcloud",width:1026,height:567,isSelect:false,
          left:0,top:0,oToMany:false,iffocus:false,winleft:240,wintop:100},
          {key:2,name:"我的应用",comp:"MyApp.vue",icon:"fa-modx",isSelect:false,left:0,top:0,oToMany:false,iffocus:false},
          {key:3,name:"应用市场",comp:"AppMarket",icon:"fa-hospital-o",isSelect:false,left:0,top:0,oToMany:false,iffocus:false},
          {key:4,name:"开发者平台",comp:"DevPlat",icon:"fa-github",width:1350,height:750,isSelect:false,
          left:0,top:0,oToMany:false,iffocus:false,winleft:260,wintop:100},
          {key:5,name:"权限管理",comp:"Rbac",icon:"fa-drivers-license-o",isSelect:false,left:0,top:0,oToMany:false,iffocus:false}
        ],
        isSelect:true,
        
    }
  },
  props: {
    title: String
  },
  components: {
      'menuIcon':MenuIcon,
  },
  methods:{
        move(){
          console.log(11);
        },
        initMenuIcons(){
          let left0=50;
          let top0=50;
          for (let i = 0; i < this.menuIcons.length; i++) { 
              this.menuIcons[i].left=left0;
              this.menuIcons[i].top=top0+i*100;
          }
        },
        selectMenu(key){
           for (let i = 0; i < this.menuIcons.length; i++) { 
              this.menuIcons[i].isSelect=false;
              if(i ==key ){
                 this.menuIcons[i].isSelect=true;
              }
          }
        },
        allreMenuIcons(){
           for (let i = 0; i < this.menuIcons.length; i++) { 
              this.menuIcons[i].isSelect=false;
          }
        },
        coM(){
          console.log( this.menuIcons);
        }
  },
  created(){
    this.initMenuIcons();
  },
  directives: {
        drag: {
           bind: function (el,bindings) {
                el.onmousedown = (e) => {
                    let disX = e.clientX - el.offsetLeft;
                    let disY = e.clientY - el.offsetTop;
                     document.onmousemove = (e)=>{
                        //用鼠标的位置减去鼠标相对元素的位置，得到元素的位置
                        let left = e.clientX - disX;    
                        let top = e.clientY - disY;
                        //绑定元素位置到positionX和positionY上面
                        //移动当前元素
                        el.style.left = left + 'px';
                        el.style.top = top + 'px';
                        bindings.value.menuIcon.left = left;
                        bindings.value.menuIcon.top = top;
                    };
                    document.onmouseup = () => {
                        document.onmousemove = null;
                        document.onmouseup = null;
                        bindings.value.menuIcon.isSelect=true;
                        bindings.value.selectMenu(bindings.value.key);
                       
                    };
                };
              }
        }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">

</style>
