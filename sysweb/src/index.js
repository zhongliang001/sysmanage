/*jslint es6, white, browser */
import Vue from 'vue'
import App from './App.vue'
import common from './lib/common.js'
import axios from "./lib/zlaxios"
import zolui from 'zolui'
Vue.config.devtools = true
Vue.use(zolui)
if(typeof(Vue)=="function"){
    Vue.prototype.common=common
    axios.request('/sdict/sdictTree').then(result =>{
        let dictData = result.data
        Vue.prototype.dictData = dictData
        new Vue({
            render: h => h(App)
        }).$mount('#app')

    })

    Vue.prototype.axios = axios
}
