<script setup lang="ts">

import {ref} from "vue";
import {register} from "@/api/userApi";

const registerForm = ref({
  name: "",
  username: "",
  password: "",
  email: "",
  description: ""
});

function handleRegister() {
  console.log("registerForm before: = " + JSON.stringify(registerForm.value))
  const res = register(registerForm.value)
  console.log("handleRegister 注册结果为: " + JSON.stringify(res))
}

</script>

<template>
  <el-form :model="registerForm" class="zj-el-form">
    <el-form-item label="用户名称">
      <el-input v-model="registerForm.name"></el-input>
    </el-form-item>
    <el-form-item label="用户名">
      <el-input v-model="registerForm.username"></el-input>
    </el-form-item>
    <el-form-item label="邮箱">
      <el-input v-model="registerForm.email"></el-input>
    </el-form-item>
    <el-form-item label="描述">
      <el-input v-model="registerForm.description"></el-input>
    </el-form-item>
    <el-form-item label="密码">
      <el-input type="password" v-model="registerForm.password"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="handleRegister()">注册</el-button>
    </el-form-item>
  </el-form>
</template>

<style scoped>

</style>
