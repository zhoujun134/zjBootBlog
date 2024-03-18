<template>
  <el-container class="zj-container">
    <el-form :model="form" class="zj-login-form">
      <el-form-item label="用户名">
        <el-input v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input type="password" v-model="form.password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="handleLogin">登录</el-button>
        <router-link to="/register">注册</router-link>
      </el-form-item>
    </el-form>
    <p v-if="loginForm.loginId">loginId: {{ loginForm.loginId }}</p>
    <p v-if="loginForm.loginId">tokenName: {{ loginForm.tokenName }}</p>
    <p v-if="loginForm.loginId">tokenValue: {{ loginForm.tokenValue }}</p>
  </el-container>

</template>

<script setup lang="ts">

import {reactive, ref} from "vue";
import {login} from "@/api/userApi";
import type ILoginForm from "@/api/interface/user/ILoginForm";
import type IZjToken from "@/api/interface/token/Itoken";
import {ElMessage} from "element-plus";

let userToken: IZjToken = reactive({
  tokenName: "",
  tokenValue: "",
  tokenTimeout: 0,
  sessionTimeout: 0,
  loginId: ""
})

const loginForm = ref({
  tokenName: "",
  tokenValue: "",
  tokenTimeout: 0,
  sessionTimeout: 0,
  loginId: ""
} as IZjToken);

const form: ILoginForm = reactive({
  username: "",
  password: ""
})

const userRules = reactive({
  username: [
    {
      required: true,
      message: "请输入用户名",
      trigger: ["change", "blur"]
    },
    {
      pattern: /^[a-zA-Z][a-zA-Z0-9-]{3,31}$/,
      message: "用户名由英文字母开头的长度4-32位字母、_和-组成",
      trigger: ["change", "blur"],
    }
  ],
  password: {
    required: true,
    message: "请输入至少8个字符的密码",
    min: 8,
    trigger: ["change", "blur"]
  }
})

function handleLogin() {
  login(form).then(result => {
    if (result.code != "0") {
      const message = result.message ? result.message : "登录失败，请联系管理员处理！";
      // 弹出错误信息
      ElMessage.error({
        message: message,
        duration: 5 * 1000
      })
    }
    const zjToken: IZjToken = result.data
    // 更新变量值
    if (zjToken.tokenValue && zjToken.tokenName) {
      loginForm.value = zjToken
      // loginForm.value.tokenName = zjToken.tokenName
      // loginForm.value.tokenValue = zjToken.tokenValue
      // loginForm.value.tokenTimeout = zjToken.tokenTimeout
      // loginForm.value.sessionTimeout = zjToken.sessionTimeout
      // loginForm.value.loginId = zjToken.loginId
    }
    // 更新 token 信息
    const tokenValue = localStorage.getItem("zsUserToken")
    if (tokenValue) {
      localStorage.setItem("zsUserToken", JSON.stringify(zjToken))
      ElMessage.success({
        message: "欢迎登录当前系统",
        duration: 5 * 1000
      })
    }
  }).catch(error => {
    console.log("登录遇到异常了！" + error)
    let {message} = error
    ElMessage.error({
      message: message,
      duration: 5 * 1000
    })
  });
}

</script>


<style scoped>
.zj-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 80%;
  height: 100%;
  background-color: bisque;
}
.zj-login-form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100%;
}
</style>
