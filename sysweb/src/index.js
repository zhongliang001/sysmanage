/*jslint es6, white, browser */
import Vue from 'vue'
// import App from './App.vue'
import common from './lib/common.js'
import zlaxios from "./lib/zlaxios"
import zolui from 'zolui'

import Login from "./Login";

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
                    render: h => h(Login)
                }).$mount('#app')
        },
        error: function (error) {
            new Vue({
                render: h => h(Login)
            }).$mount('#app')
        }
    })

    Vue.prototype.zlaxios = zlaxios
}
