<template>
  <div id="app" >
    <router-view style="position:absolute; width: 100%;z-index:10;height:100%"></router-view>
    <el-image :src="backgroundsrc" style="position: absolute;z-index:0;width: 100%;height:100%" :fit="fit"></el-image>
  </div>
</template>

<script>
export default {
  name: 'App',
  data(){
    return{
      backgroundsrc:require('./assets/background.png')
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
