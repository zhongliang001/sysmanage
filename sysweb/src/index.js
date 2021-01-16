/*jslint es6, white, browser */
import Vue from 'vue'
import App from './App.vue'
import common from './lib/common.js'
import zlaxios from "./lib/zlaxios"
import zolui from 'zolui'
import VueRouter from "vue-router";
import routes  from './lib/routers'


// import Login from "./Login";
// import Register from "./Register";

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


if(typeof(Vue)=="function"){
    Vue.prototype.common=common
    // axios.request('/sdict/sdictTree').then(result =>{
    //     let dictData = result.data
    //     if(dictData){
    //         Vue.prototype.dictData = dictData
    //     }
    //     new Vue({
    //         render: h => h(Login)
    //     }).$mount('#app')
    //
    // })
    zlaxios.request({
        url: '/sdict/sdictTree',
        success: function (response) {
            let dictData = response.data
                if(dictData){
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

    Vue.prototype.zlaxios = zlaxios
}
