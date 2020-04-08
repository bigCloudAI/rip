<template>
  <div class="backwell" @contextmenu.prevent="contextenable" @click="contextdisable">
  
   <!-- @contextmenu.prevent="contextenable" @click="contextdisable" -->
    
  </div>
</template>

<script>
export default {
  name: 'backwell',
  props: {
    title: String
  },
  methods:{
    contextenable(e){this.$store.commit('switchStartMenu',1);this.$emit("contextenable",e)},
    contextdisable(e){this.$store.commit('switchStartMenu',1);this.$emit("contextdisable",e)}
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.backwell{
    background:url(/backwell/2.jpg) center center / cover no-repeat fixed;
    border:2px solid #000;
    width: 100%;
    height: 100%;
    position: absolute !important;
    top: auto;
    left: auto;
    right: auto;
    bottom: auto;
    z-index:0;
}

</style>
