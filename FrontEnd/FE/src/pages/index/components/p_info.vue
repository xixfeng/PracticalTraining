<template>
<div>
  <el-form label-width="80px">
    <el-form-item label="用户名">
      <el-row>
        <el-col span="15">
          <el-input v-model="user"></el-input>
        </el-col>
        <el-col span="8">
          <el-button @click="alterusername">更改用户名</el-button>
        </el-col>
      </el-row>
    </el-form-item>
    <el-form-item label="手机号码">
      <el-input v-model="phone"></el-input>
    </el-form-item>
    <el-form-item label="当前密码">
      <el-input v-model="key" type="password"></el-input>
    </el-form-item>
  </el-form>
</div>
</template>

<script>
    export default {
        name: "p_info",
      data(){
          return{
            user:'',
            phone:'',
            key:''
          }
      }
    }
</script>

<style scoped>

</style>
