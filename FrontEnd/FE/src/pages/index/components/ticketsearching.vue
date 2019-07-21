<template>
  <div style="width:100%">
    <div id="wrapper" style=" background-color:white;display:block;position: absolute; z-index: 10;margin-left:330px;margin-right:100px;margin-top:100px;border-style:solid; border-color:#EBEEF5;border-radius: 13px">
          <router-view/>
        </div>
    <el-carousel height="700px" style="position:absolute;width: 100%;z-index:0">
          <el-carousel-item v-for="item in imgList" key="item.id">
            <el-image :src="item.idView"></el-image>
          </el-carousel-item>
        </el-carousel>
  </div>
</template>

<script>
    export default {
        name: "ticketsearching",
      data(){
          return{
            tabPosition:'left',
            imgList: [
              {id: 0, idView: require('../assets/1.jpg')},
              {id: 1, idView: require('../assets/2.jpg')},
              {id: 2, idView: require('../assets/4.jpg')}
            ]
          }
      }
    }
</script>

<style scoped>

</style>
