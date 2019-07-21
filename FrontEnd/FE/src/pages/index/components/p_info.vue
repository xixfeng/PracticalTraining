<template>
<div style="height:400px;">
  <el-form label-width="80px">
    <el-form-item label="手机号码:">
      <el-col span="13">
        <el-input v-model="this.$parent.$parent.$parent.$parent.phone" disabled="true"></el-input>
      </el-col>
    </el-form-item>
    <el-form-item label="用户名:">
      <el-row>
        <el-col span="13">
          <el-input v-model="user"></el-input>
        </el-col>
        <el-col span="8">
          <el-button @click="alterusername" v-bind:loading="isloading">更改用户名</el-button>
        </el-col>
      </el-row>
    </el-form-item>
    <el-form-item label="当前余额:">
      <el-col span="5" style="border-radius: 13px;background-color: #66b1ff;color:white;font-size: 30px;">{{this.balance}}</el-col>
      <el-col span="3">元</el-col>
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
            balance:'',
            avatar:'',
            date:'1999-9-8',
            password:'',
            role:'',
            isloading:false,
          }
      },
      mounted() {
          this.phone = this.$parent.$parent.$parent.$parent.phone;
          this.axios.post('http://120.78.87.173:8080/user/getUserInfo',{phone:this.phone}).then(res=>{
            console.log(res);
            if(res.data.status !== 200){
              this.$message("网络错误")
            }
            else{
              this.user = res.data.data.userName;
              if(res.data.data.balance === null){
                this.balance = '0';
              }
              else {
                this.balance = res.data.data.balance;
              }
              this.avatar = res.data.data.avatar;
              this.password = res.data.data.password;
            }
          }).catch(error=>{
            console.log(error)
          })
      },
      methods:{
        alterusername(){
          this.isloading = true;
          this.axios.post('http://120.78.87.173:8080/user/changeUserName',{phone:this.phone,name:this.user}).then(res =>{
            console.log(res);
            if(res.data.status === 200){
              this.$message({
                message: '修改成功',
                type: 'success'
              });
              this.isloading = false;
            }
          }).catch(e => {
            console.log(e);
          })
        }
      }
    }
</script>

<style scoped>

</style>
