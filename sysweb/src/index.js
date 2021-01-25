/*jslint es6, white, browser */
import Vue from 'vue'
import App from './App.vue'
import zolui from 'zolui'
import VueRouter from "vue-router";
import routes from './lib/routers'
import zlService from "./lib/zlservice";

Vue.use(VueRouter);
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}
const router = new VueRouter({
    routes  // routes: routes 的简写
})

Vue.config.devtools = true
Vue.use(zolui)

if (typeof (Vue) == "function") {
    Vue.prototype.zlService = zlService
}

// Vue.prototype.common=common
Vue.prototype.zlaxios.request({
    url: zlService.baseUrl + '/sdict/sdictTree',
    success: function (response) {
        let dictData = response.data
        if (dictData) {
            Vue.prototype.dictData = dictData
        }
        new Vue({
            router,
            render: h => h(App)
        }).$mount('#app')
    },
    error: function (error) {
        new Vue({
            router,
            render: h => h(App)
        }).$mount('#app')
    }
})

