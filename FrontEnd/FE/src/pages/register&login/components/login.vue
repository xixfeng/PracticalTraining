<template>
  <div >
    <div class="card-wrapper">
      <div class="inner-wrapper">
      <el-form label-width="80px">
        <el-form-item>
          <h1>欢迎登陆</h1>
        </el-form-item>
        <el-form-item label="用户名">
          <el-input v-model="username"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="pwd" type="password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-row gutter="5">
          <el-col span="12">
            <el-button @click="check()" style="width: 100%" type="warning">登陆</el-button>
          </el-col>
          <el-col span="12">
            <el-button style="width: 100%" type="warning"@click="toregister()">
              注册
            </el-button>
          </el-col>
          </el-row>
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
      username:'',
      pwd:'',
      usertype:'admin',
      isValid:true
    }
  },
  methods:{
    check(){
      this.axios.get("/uservarification",{username:this.username,pwd:this.username}).then(res => {
        this.usertype = res.usertype;
        this.isValid = res.isValid;
      });

      if(!this.isValid){
        alert("用户名或密码错误");
        return;
      }
      if(this.usertype === "admin"){
        window.location.href="index.html?usertype=admin";
      }
      if(this.usertype === 'users'){
        window.location.href="index.html?usertype=user";
      }
    },
    toregister(){
      this.$router.push('/register');
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .card-wrapper{
    display:block;
    margin-top:100px;
    margin-left:400px;
    margin-right:400px;
    background-color: azure;
    border-radius: 10px;
    box-shadow: 5px 5px 20px grey;
  }
  .inner-wrapper{
    padding:30px;
  }
  router-link:link{
    color:white;
    font-style:italic;
  }
  router-link:active{
    color:white;
  }
  router-link:

</style>
