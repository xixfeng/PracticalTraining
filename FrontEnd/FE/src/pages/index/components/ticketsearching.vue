<template>
  <div style="width:100%">
    <div style="display:block;position: absolute; z-index: 10;margin-left:330px;margin-right:100px;margin-top:100px;border-style:solid; border-color:#EBEEF5;border-radius: 13px">
          <el-container style="height:300px;">
            <el-aside style="width:200px">
              <el-menu router="true" style="height:300px;border-radius: 9px 0 0 9px" default-active="singletrip">
                <el-menu-item index="singletrip" class="tabs">单程</el-menu-item>
                <el-menu-item index="twowaytrip" class="tabs">往返</el-menu-item>
                <el-menu-item index="trains" class="tabs">车次信息</el-menu-item>
              </el-menu>
            </el-aside>
            <el-main style="width: 500px;overflow: scroll;background-color: white;border-radius:0 9px 9px 0">
              <router-view/>
            </el-main>
          </el-container>
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
  .tabs{
    margin-top: 30px;
  }
</style>
