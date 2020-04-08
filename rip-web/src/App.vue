<template>
  <div id="app" >
    <router-view/> 
  </div>
</template>
<script>
  export default {
    name: 'App',
  }
</script>
<style lang="scss">
html { 
  height: 100%; overflow: auto; 
}
body {
  margin: 0px;
  -webkit-user-select:none;
  -moz-user-select:none;
  -ms-user-select:none;
  user-select:none;
  min-height: 100%;
}

$w : 0px;
#app {
  border:$w solid #000;
  overflow-x: hidden; 
  overflow-y: hidden; 
  width: 100%;
  height: 100%;
  position:absolute;
 // background:url(/backwell/2.jpg) center center / cover no-repeat fixed;
}
</style>
