<template>
    <div>
      <el-table
        :data="this.tabledata"
        height="580"
        border
        style="width: 100%;border-radius: 13px">
        <el-table-column
          prop="orderId"
          label="订单编号"
          fixed="left"></el-table-column>
        <el-table-column
          prop="trainId"
          label="列车车次"></el-table-column>
        <el-table-column
          prop="fee"
          label="票价"></el-table-column>
        <el-table-column
          prop="discount"
          label="折扣"></el-table-column>
        <el-table-column
          prop="orgin"
          label="始发地"></el-table-column>
        <el-table-column
          prop="destination"
          label="目的地"></el-table-column>
        <el-table-column
          prop="type"
          label="车票类型"></el-table-column>
        <el-table-column
          prop="seat"
          label="座位"></el-table-column>
      </el-table>
    </div>
</template>

<script>
    export default {
        name: "p_orders",
        data(){
          return{
            tabledata:[]
          }
        },
      mounted() {
          this.axios.post('http://120.78.87.173:8080/trainorder/querytransation',{phone:this.$parent.$parent.$parent.$parent.phone}).then( res=> {
            console.log(this.$parent.$parent.$parent.$parent.phone);
            console.log(res);
            this.tabledata = res.data.data;
          }).catch(error => {
            console.log(error)
          })
      }
    }
</script>

<style scoped>

</style>
