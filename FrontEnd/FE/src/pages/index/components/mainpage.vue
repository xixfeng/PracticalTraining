<template>
  <div >
    <el-row style="background-color: white;color:black;padding:20px;border-radius: 0 0 40px 40px">
      <el-col span="2" offset="6">
        <el-image :src="imgsrc.idView" style="height: 50px; width: 50px;padding-top:7px"></el-image>
      </el-col>
      <el-col span="10">
        <h2>线上铁路订票系统</h2>
      </el-col>
      <el-col span="4">
        <h2 >欢迎您{{this.phone}}</h2>
      </el-col>
      <el-col span="2" style="padding-top:18px">
        <el-button type="danger" @click="logout()">注销</el-button>
      </el-col>
    </el-row>
    <el-menu :default-active="activetab"  mode="horizontal" router="true"
             background-color="#409EFF"
             text-color="white"
             active-text-color="white" style="border-radius: 40px 0 0 20px">
      <el-menu-item index="/ticketsearching" style="margin-left:350px;width:200px;">车票信息查询</el-menu-item>
      <el-menu-item index="/profile" style="margin-left:200px;width:200px;">个人信息</el-menu-item>
    </el-menu>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'mainpage',
  data () {
    return {
      imgsrc:{idView: require('../assets/5.png')},
      msg: '当前是index页面',
      phone:'',
      activetab:'/ticketsearching',
      ticketdata:[],
      selectedticket:''
    }
  },
  mounted() {
    var url = window.location.href;
    var param = url.substring(url.lastIndexOf("=") + 1,url.lastIndexOf("#"));
    this.phone = param;
  },
  methods:{
    logout(){

    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
