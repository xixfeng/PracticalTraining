<template>
  <div style="width: 600px;height: 400px;overflow: scroll;margin:20px">
    <h1>车次详情</h1>
    <el-row gutter="4" class="rows">
      <el-col span="5">序号</el-col>
      <el-col span="8">{{this.$parent.$parent.selectedticket.id}}</el-col>
    </el-row>
    <el-row gutter="4" class="rows">
      <el-col span="5">车次</el-col>
      <el-col span="8">{{this.$parent.$parent.selectedticket.trainId}}</el-col>
    </el-row>
    <el-row gutter="4" class="rows">
      <el-col span="5">始发站点</el-col>
      <el-col span="8">{{this.$parent.$parent.selectedticket.origin}}</el-col>
    </el-row>
    <el-row gutter="4" class="rows">
      <el-col span="5">目的地站点</el-col>
      <el-col span="8">{{this.$parent.$parent.selectedticket.destination}}</el-col>
    </el-row>
    <el-row gutter="4" class="rows">
      <el-col span="5">出发时间</el-col>
      <el-col span="8">{{this.$parent.$parent.selectedticket.startTime}}</el-col>
    </el-row>
    <el-row gutter="4" class="rows">
      <el-col span="5">结束时间</el-col>
      <el-col span="8">{{this.$parent.$parent.selectedticket.arriveTime}}</el-col>
    </el-row>
    <el-row gutter="4" class="rows">
      <el-col span="5">一等座余票</el-col>
      <el-col span="8">{{this.$parent.$parent.selectedticket.ydNum}}</el-col>
    </el-row>
    <el-row gutter="4" class="rows">
      <el-col span="5">一等座票价</el-col>
      <el-col span="8">{{this.$parent.$parent.selectedticket.ydPrice}}</el-col>
    </el-row>
    <el-row gutter="4" class="rows">
      <el-col span="5">二等座余票</el-col>
      <el-col span="8">{{this.$parent.$parent.selectedticket.edNum}}</el-col>
    </el-row>
    <el-row gutter="4" class="rows">
      <el-col span="5">二等票价</el-col>
      <el-col span="8">{{this.$parent.$parent.selectedticket.edPrice}}</el-col>
    </el-row>
    <el-row gutter="7" class="rows">
      <el-col span="12">
        <el-button @click="purchasing('firstclass')" style="width: 100%" type="warning" v-bind:loading="isloading1">购买一等座</el-button>
      </el-col>
      <el-col span="12">
        <el-button @click="purchasing('secclass')" style="width: 100%" type="warning" v-bind:loading="isloading2">购买二等座</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
    export default {
        name: "purchasing",
        thisid:'',
        data(){
          return{
            columns:["序号","车次","始发站","终点站","出发时间","到达时间","一等座","票价","二等座","票价"],
            isloading1:false,
            isloading2:false,
            isComfirming:false
          }
        },
      methods:{
        purchasing(level){
          if(level === 'firstclass'){
            // this.isloading1 = true;
            console.log(this.$parent.$parent.selectedticket);
            this.axios.post('http://192.168.43.130:8080/trainorder/judgeydaccount',{
              "id": this.$parent.$parent.selectedticket.id,
              "trainId": this.$parent.$parent.selectedticket.trainId,
              "origin": this.$parent.$parent.selectedticket.origin,
              "destination": this.$parent.$parent.selectedticket.destination,
              "startTime": this.$parent.$parent.selectedticket.startTime,
              "arriveTime": this.$parent.$parent.selectedticket.arriveTime,
              "ydNum": this.$parent.$parent.selectedticket.ydNum,
              "ydPrice": this.$parent.$parent.selectedticket.ydPrice,
              "edNum": this.$parent.$parent.selectedticket.edNum,
              "edPrice": this.$parent.$parent.selectedticket.edPrice
            }).then(res=>{
              console.log(res);
              if(res.data.status !== 200){
                this.$message.error("账户余额不足");
              }
              else{
                this.isComfirming = true
              }
            }).catch(e =>{
              console.log(e);
            })
          }
        }
      },
      mounted() {
        document.getElementById("wrapper").style.marginLeft = "330px";
        document.getElementById("wrapper").style.marginTop = "70px";
      }
    }
</script>

<style scoped>
.rows{
  width: 500px;padding:10px;background-color: #e5e9f2;border-radius: 13px;margin: 10px
}
</style>
