<template>
<div style="background-color: white;height:580px;overflow: scroll;border-radius: 13px">
  <h1>查询结果</h1>
  <el-row class="rows">
    <el-col span="2" v-for="cols in columns" style="border-radius: 20px;padding:10px;font-size: 12px">{{cols}}</el-col>
  </el-row>
  <el-row v-for="tickets in this.$parent.$parent.ticketdata" style="width: 1000px;padding:10px;background-color: #e5e9f2;border-radius: 13px;margin: 14px" gutter="7">
    <el-col span="2" v-for="item in tickets" style="border-radius: 20px;padding:10px">{{item}}</el-col>
    <el-col span="4">
      <el-button @click="purchase(tickets.id)">购买</el-button>
    </el-col>
  </el-row>
</div>
</template>

<script>
    export default {
        name: "resultpane",
      data(){
          return{
            columns:["序号","车次","始发站","终点站","出发时间","到达时间","一等座余票","票价","二等座余票","票价"]
          }
      },
      methods:{
        purchase(id) {
          this.$message("点击的是" + id);
        }
      },
      mounted() {
          document.getElementById("wrapper").style.marginLeft = "170px";
          document.getElementById("wrapper").style.marginTop = "50px";
      }
    }
</script>

<style scoped>
.rows{
  width: 1000px;padding:10px;background-color: #e5e9f2;border-radius: 13px;margin: 10px
}
</style>
