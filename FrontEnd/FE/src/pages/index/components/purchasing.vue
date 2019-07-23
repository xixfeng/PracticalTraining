<template>
  <div style="width: 600px;height: 500px;overflow: scroll;margin:20px">
    <h1 v-if="this.isComfirming">订单详情</h1>
    <h1 v-else>车次详情</h1>
    <div v-if="this.isComfirming">
      <el-row gutter="4" class="rows">
        <el-col span="5">车次</el-col>
        <el-col span="8">{{this.orderdata.trainId}}</el-col>
      </el-row>
      <el-row gutter="4" class="rows">
        <el-col span="5">车辆类型</el-col>
        <el-col span="8">{{this.orderdata.type}}</el-col>
      </el-row>
      <el-row gutter="4" class="rows">
        <el-col span="5">始发地</el-col>
        <el-col span="8">{{this.orderdata.orgin }}</el-col>
      </el-row>
      <el-row gutter="4" class="rows">
        <el-col span="5">目的地</el-col>
        <el-col span="8">{{this.orderdata.destination }}</el-col>
      </el-row>
      <el-row gutter="4" class="rows">
        <el-col span="5">座位等级</el-col>
        <el-col span="8">{{this.orderdata.seat}}</el-col>
      </el-row>
      <el-row gutter="4" class="rows">
        <el-col span="5">票价</el-col>
        <el-col span="8">{{this.orderdata.fee}}</el-col>
      </el-row>
      <el-row gutter="4" class="rows">
        <el-col span="5">折扣</el-col>
        <el-col span="8">{{this.orderdata.discount}}</el-col>
      </el-row>
      <el-row gutter="7" class="rows">
        <el-col span="12">
          <el-button @click="comfirming()" style="width: 100%" type="danger" v-bind:loading="isloading3">确认</el-button>
        </el-col>
        <el-col span="12">
          <el-button @click="cancel()" style="width: 100%" type="warning" >取消</el-button>
        </el-col>
      </el-row>
    </div>
    <div v-else>
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
            isComfirming:false,
            orderdata:[],
            isloading3:false,
          }
        },
      methods:{
        purchasing(level){
          if(level === 'firstclass') {
          this.isloading1 = true;
            var url = 'http://120.78.87.173:8080/trainorder/judgeydaccount';
          }
          else{
            this.isloading2 = true;
            var url = 'http://120.78.87.173:8080/trainorder/judgeedaccount';
          }
            console.log(this.$parent.$parent.selectedticket);

            this.axios.post(url,{
              "phone":this.$parent.$parent.phone,
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
                this.isComfirming = true;
                this.$message({
                  message:'请确认订单',
                  type:'success'
                });
                this.orderdata = res.data.data;
              }
            }).catch(e =>{
              console.log(e);
            })
        },
        comfirming(){
          console.log(this.orderdata);
          this.isloading3 = true;
          this.axios.post('http://120.78.87.173:8080/trainorder/buyticket',this.orderdata).then(res => {
            console.log(res);
            if(res.data.status === 200){
              this.$message({
                message:"购买成功",
                type:'success'
              });
              this.$router.push({path:'/ticketsearching'});
            }
          }).catch(e => {
            console.log(e);
          })
        },
        cancel(){
          this.isComfirming = false;
          this.isloading1 = false;
          this.isloading2 = false;
        }
      },
      mounted() {
        document.getElementById("wrapper").style.marginLeft = "25%";
        document.getElementById("wrapper").style.marginTop = "5%";
      }
    }
</script>

<style scoped>
.rows{
  width: 500px;padding:10px;background-color: #e5e9f2;border-radius: 13px;margin: 10px
}
</style>
