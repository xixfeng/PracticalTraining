<template>
  <div>
    <el-form label-width="90px">
      <el-form-item label="始发站">
        <el-input v-model="startcity" :placeholder="请输入始发站"></el-input>
      </el-form-item>
      <el-form-item label="终点站">
        <el-input v-model="arrivalcity" :placeholder="请输入终点站"></el-input>
      </el-form-item>
      <el-form-item label="出发日期">
        <el-col span="11">
         <el-date-picker
           v-model="startday"
           type="date"
           placeholder="选择日期" style="margin-left:0">
         </el-date-picker>
        </el-col>
      </el-form-item>
      <el-button type="warning" @click="submit()" style="width:100%" v-bind:loading="this.isloading">查询</el-button>
    </el-form>
  </div>
</template>

<script>
    export default {
        name: "singletrip",
      data(){
          return{
            startcity:'',
            arrivalcity:'',
            startday:'',
            isloading:false,
            phone:''
          }
      },
      methods:{
          submit(){
            console.log(this.$parent.$parent.$parent.$parent.$parent.ticketdata);
            if(this.startcity !== '' && this.arrivalcity !== '' && this.startday !== ''){
              this.isloading = true;
              this.axios.post('http://120.78.87.173:8080/trainroute/searchticket',{startcity:this.startcity,arrivalcity:this.arrivalcity,startday:this.startday}).then(res =>{
                console.log(res);
                //TODO 更改url测试
                this.$parent.$parent.$parent.$parent.$parent.ticketdata = res.data;
                this.$router.push({name:'resultpane'});
              }).catch(e =>{
                console.log(e);
              })
            }
            else{
              this.$message("请输入完整的信息")
            }
          }
      },
      mounted() {
        document.getElementById("wrapper").style.marginLeft = "330px";
        document.getElementById("wrapper").style.marginTop = "100px";
      }
    }
</script>

<style scoped>

</style>
