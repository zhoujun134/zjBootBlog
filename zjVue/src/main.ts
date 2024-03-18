import {createApp} from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from "@/router/routers";

import 'highlight.js/lib/common'
import hljsVuePlugin from '@highlightjs/vue-plugin'
import 'highlight.js/styles/atom-one-dark.css' //样式

const app = createApp(App);

app.use(ElementPlus)
    .use(router)
    .use(hljsVuePlugin)
    .mount('#app')
