import { createRouter, createWebHistory } from 'vue-router'
import Home from "@/views/Home.vue";

export const constantRoutes = [
//重定向--一般设置为首页
    {
        path: '/',
        component: Home
    },
    {
        path: "/login",
        component: () => import("@/components/LoginForm.vue")
    },
    {
        path: "/register",
        component: () => import("@/components/RegisterForm.vue")
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes: [...constantRoutes]
})

export default router;


