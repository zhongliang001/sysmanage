/*jslint es6, white, browser */
import Vue from 'vue'
import App from './App.vue'
import common from './lib/common.js'
import './css/base.css'
Vue.config.devtools = true;
if(typeof(Vue)=="function")Vue.prototype.common=common;
new Vue({
　　render:h=>h(App)
}).$mount('#app')
