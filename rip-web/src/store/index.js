import Vue from 'vue'
import Vuex from 'vuex'
import mwin from './mwin/wins.js'
import miaas from './miaas/iaas.js'
import mdevPlat from './mdevPlat/devPlat.js'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    env:"prod",
    userInfo:"",
    ifStartMenus:false,
    baseUrl:"http://127.0.0.1:8090",
    prodUrl:"http://122.51.80.248:8090",
    ripsize:"small",
    test:"===================="
  },
  mutations: {
    login(state,v){
      state.userInfo = v;
    },
    switchStartMenu (state,type) {
      if(type&&type==1){
        state.ifStartMenus=false;
      }else{
        state.ifStartMenus=!state.ifStartMenus;
      }
    }
  },
  getters:{
    currUserInfo(state){
      return state.userInfo;
    },
    wins(state){
      return state.mwin.wins;
    }
  },
  actions: {
  },
  modules: {
    mwin:mwin,
    miaas:miaas,
    mdevPlat:mdevPlat,
  }
})
