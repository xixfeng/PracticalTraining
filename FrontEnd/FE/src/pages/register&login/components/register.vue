<template>
  <div>
    <div class="card-wrapper">
      <div class="inner-wrapper">
        <el-form label-width="80px">
          <el-form-item label="姓名">
            <el-input></el-input>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "register"
    }
</script>

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
</style>
