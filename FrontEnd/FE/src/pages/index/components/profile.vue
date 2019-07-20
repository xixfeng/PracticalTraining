<template>
  <div class="outter_wrapper">
    <el-row style="padding:10px">
      <el-col span="6" style="border-radius: 20px;border-style: solid ;border-color: #E4E7ED;border-width: 1px;">
        <el-menu router="true" style="height:600px;border-radius: 20px">
          <el-menu-item index="/p_info" style="margin-top: 20px">个人信息管理</el-menu-item>
          <el-submenu index="/orders">
            <template slot="title">
              <i class="el-icon-s-order"></i>
              <span >我的订单</span>
            </template>
            <el-menu-item index="/p_orders/histroy">历史订单</el-menu-item>
            <el-menu-item index="/p_orders/tobedone">待出行</el-menu-item>
          </el-submenu>
          <el-menu-item index="/suggestion">产品建议</el-menu-item>
        </el-menu>
      </el-col>
      <el-col span="18">
        <div style="padding:20px">
          <router-view/>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
    export default {
        name: "profile"
    }
</script>

<style scoped>
.outter_wrapper{
  background-color:white;margin:20px;border-style: solid ;border-color: #EBEEF5;border-width: 1px;border-radius: 20px;

}
</style>
