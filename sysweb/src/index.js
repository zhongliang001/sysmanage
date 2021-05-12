/*jslint es6, white, browser */
import Vue from 'vue'
import App from './App.vue'
import zolui from 'zolui'
import VueRouter from "vue-router";
import zlService from "./lib/zlservice";
import routes from "./routers";

Vue.use(VueRouter);
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}

// 根据list 生成 router
function createRouter(r){
    r.forEach(t =>{
        if(t.filePath){
            let component = () => import(`@/${t.filePath}`)
            t.component = component
            if(t.children && t.children.length > 0){
                createRouter(t.children)
            }
        }
    })
    return r
}

Vue.config.devtools = true
Vue.use(zolui)


const router = new VueRouter({
    routes  // routes: routes 的简写
})

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')

if (typeof (Vue) == "function") {
    Vue.prototype.zlService = zlService
}

Vue.prototype.zlaxios.request({
    url: zlService.baseUrl + '/dict/dictTree',
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
    failed: function (error) {
        new Vue({
            router,
            render: h => h(App)
        }).$mount('#app')
    }
})



// Vue.prototype.zlaxios.request({
//         url: zlService.baseUrl + '/smenu/selectMenu',
//         method: 'POST',
//         success: function (response) {
//            let menu = response.data
//             let routes = createRouter(menu)
//
//             const router = new VueRouter({
//                 routes  // routes: routes 的简写
//             })
//
//             // Vue.prototype.common=common
//             Vue.prototype.zlaxios.request({
//                 url: zlService.baseUrl + '/sdict/sdictTree',
//                 success: function (response) {
//                     let dictData = response.data
//                     if (dictData) {
//                         Vue.prototype.dictData = dictData
//                     }
//                     new Vue({
//                         router,
//                         render: h => h(App)
//                     }).$mount('#app')
//                 },
//                 failed: function (error) {
//                     new Vue({
//                         router,
//                         render: h => h(App)
//                     }).$mount('#app')
//                 }
//             })
//
//         },
//         failed: function (error) {
//             console.log("查询菜单失败")
//             return ''
//         }
//     })


