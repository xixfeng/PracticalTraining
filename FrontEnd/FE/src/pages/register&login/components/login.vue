<template>
  <div >
    <div class="card-wrapper">
      <div class="inner-wrapper">
      <el-form label-width="80px">
        <el-form-item>
          <h1>欢迎登陆</h1>
        </el-form-item>
        <el-form-item label="手机号">
          <el-input v-model="phone"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="key" type="password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-row gutter="5">
          <el-col span="12">
            <el-button @click="check()" style="width: 100%" type="warning" v-bind:loading=this.isloading>登陆</el-button>
          </el-col>
          <el-col span="12">
            <el-button style="width: 100%" type="warning"@click="toregister()">
              注册
            </el-button>
          </el-col>
          </el-row>
        </el-form-item>
        <el-form-item>
          <router-link to="/register/false" >找回密码</router-link>
        </el-form-item>
      </el-form>
      </div>
    </div>
  </div>
</template>

<script>
export default {

  name: 'login',
  data () {
    return {
      phone:'',
      key:'',
      usertype:'',
      isValid:0,
      isloading:false
    }
  },
  methods:{
    check(){
      // if(this.phone !== '' && this.key !== '') {
      //   this.isloading = true;
      //   this.axios.get("/user/login", {phone: this.phone, key: this.key}).then(res => {
      //     console.log(res);
      //     this.usertype = res.usertype;
      //     this.isValid = res.status;
      //     if (this.isValid === 400) {
      //       alert("用户名或密码错误");
      //       this.isloading = false;
      //       return;
      //     }
      //     //TODO 跳转到管理员页面所在的html
      //     // if (this.usertype === "admin") {
      //     //   window.location.href = "xxx.html?phone=" + this.phone;
      //     // }
      //     if (this.usertype === 'users') {
      //       window.location.href = "index.html?phone=" + this.phone;
      //     }
      //   }).catch(function (e) {
      //     console.log(e)
      //   });
      // }
      // else{
      //   this.$message.error("请填写完整的信息");
      // }
      window.location.href = "index.html?phone=" + this.phone;
    },
    toregister(){
      this.$router.push('/register/true');
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  @import "../assets/wrapper_styles.css";
</style>
