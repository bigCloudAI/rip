<template>
  <div class="winwidget">
{{this.wins}}
    <win v-bind:key="key" @focuswins="focuswins" @delwin="delwin"
     v-for=" (win,key) in this.wins" :win='win'></win>
  </div>
</template>

<script>
import {mapGetters,mapState} from 'vuex'
import store from '@/store'
import Win from './Win.vue'

export default {
  name: "winwidget",
  data(){
    return{
    }
  },
  methods:{
    focuswins(win){
      store.commit("focusWin", win)
    },
    delwin(win){
      store.commit("delWin", win)
    }
  },
  computed: {
    ...mapState(['userInfo']),
    ...mapGetters(['currUserInfo','wins'])
  },
  props: {
    title: String
  },
  components: {
      'win':Win
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.winwidget {
  z-index: 0;
  color:black;
  position: absolute !important;
  width: 100%;

}



</style>
