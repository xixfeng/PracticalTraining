<template>
  <div>
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
</template>

<script>
    export default {
        name: "formpane"
    }
</script>

<style scoped>
  .tabs{
    margin-top: 30px;
  }
</style>
