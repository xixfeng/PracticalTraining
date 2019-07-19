<template>
  <div>
    <div class="card-wrapper">
      <div class="inner-wrapper">
        <el-form label-width="100px">
          <el-form-item>
            <h3 v-if="this.$route.params.isregister === 'true'">注册新用户</h3>
            <h3 v-else>找回密码</h3>
          </el-form-item>
          <el-form-item label="用户名" v-if="this.$route.params.isregister === 'true'">
            <el-input v-model="user"></el-input>
          </el-form-item>
          <el-form-item label="手机号">
            <el-row>
                <el-input v-model="phone" ></el-input>
            </el-row>
          </el-form-item>
          <el-form-item label="设置密码">
            <el-row>
                <el-input @blur="sanitycheck()" v-model="key" type="password"></el-input>
            </el-row>
          </el-form-item>
          <el-form-item label="再次输入密码">
            <el-input @blur="sanitycheck()" type="password" v-model="verification"></el-input>
          </el-form-item>
          <el-form-item label="验证码">
            <el-row gutter="5">
              <el-col span="10">
                <el-input v-model="code"></el-input>
              </el-col>
              <el-col span="5">
                <el-button @click="getcode()" name="the_btn" :disabled="btn_msg === '验证码已发送'">{{btn_msg}}</el-button>
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item>
            <el-button @click="submit()" style="width:100%;" type="warning" v-bind:loading=isloading>提交</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>

    export default {
        name: "register",
      data(){
          return{
            user:'',
            key:'',
            phone:'',
            code:'',
            verification:'',
            btn_msg:'获取验证码',
            isloading:false,
          }
      },
      methods:{
          sanitycheck(){
            if(this.key !== this.verification && this.key !== ''){
                this.$message.error('两次密码输入不匹配');
            }
            else{
              this.$message({
                message: '两次密码输入匹配',
                type: 'success'
              })
            }
          },
        getcode(){
            if(this.phone !== ''){
              this.axios.post('/user/getCode',{phone:this.phone}).then(res =>{});
              this.btn_msg = '验证码已发送';
            }
            else{
              alert("请先输入电话号码")
            }
        },
        submit(){
           // 如果是注册新的用户则提交用户名
          if(this.$route.params.isregister === 'true'){
            if(  this.phone !== '' && this.code !== '' && this.key !== '' && this.user !== '' && !(this.key !== this.verification && this.key !== '')){
              this.isloading = true;
              this.axios.post('/user/register',{user:this.user, key:this.key, phone:this.phone, code:this.code}.then(response => {
                console.log(response);
                if(response.status === 400){
                  alert("验证码错误");
                  this.btn_msg = '获取验证码';
                  this.isloading = false;
                }
                if(response.status === 401){
                  alert("手机号已经被注册");
                  this.btn_msg = '获取验证码';
                  this.isloading = false;
                }
                else{
                  alert("注册成功");
                  this.btn_msg = '获取验证码';
                  this.isloading = false;
                  this.$router.back();
                }
              }));
            }
            else{
              alert("信息尚未填写完整");
            }
          }
          else{
            if(  this.phone !== '' && this.code !== '' && this.key !== '' && !(this.key !== this.verification && this.key !== '')){
              //this.isloading = true;
              this.axios.post('/user/retrievePassword',{ key:this.key, phone:this.phone, code:this.code}.then(response => {
                console.log(response);
                if(response.status === 400){
                  alert("验证码错误");
                  this.btn_msg = '获取验证码';
                  this.isloading = false;
                }
                if(response.status === 401){
                  alert("用户不存在");
                  this.btn_msg = '获取验证码';
                  this.isloading = false;
                }
                else{
                  alert("重设密码成功");
                  this.btn_msg = '获取验证码';
                  this.isloading = false;
                  this.$router.back();
                }
              }));
            }
            else{
              alert("信息尚未填写完整");
            }
          }

        }


      }
    }
</script>

<style scoped>
  @import "../assets/wrapper_styles.css";
</style>
