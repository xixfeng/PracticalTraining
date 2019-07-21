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
            if(this.startcity !== '' && this.arrivalcity !== '' && this.startday !== ''){
              this.isloading = true;
              this.$router.push({name:'resultpane'});
              this.axios.get('/query/searchticket',{startcity:this.startcity,arrivalcity:this.arrivalcity,startday:this.startday}).then(res =>{
                console.log(res);
                this.$parent.$parent.ticketdata = res;
              }).catch(function(e){
                console.log(e);
              })
            }
            else{
              this.$message("请输入完整的信息")
            }
          }
      }
    }
</script>

<style scoped>

</style>
