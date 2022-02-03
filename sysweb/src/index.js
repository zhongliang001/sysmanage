import Vue from "vue"
import App from "./App.vue"
import zolui from "zolui"
import VueRouter from "vue-router"
import zlService from "./lib/zlservice"
import routes from "./routers"
import "./scss/custom.scss"

Vue.use(VueRouter)
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (location) {
  return originalPush.call(
    this,
    location
  ).catch((err) => err)
}

Vue.config.devtools = true
Vue.use(zolui)

const router = new VueRouter({
  routes
})

let ok = false

Vue.prototype.zlaxios.request({
  url: `${zlService.baseUrl}/dict/dictTree`,
  success (response) {
    const dictData = response.data
    if (dictData) {
      Vue.prototype.dictData = dictData
    }
    ok = true
  },
  failed () {
    alert("查询数据字典失败")
  }
})
const timeout = 500
const st = setInterval(
  inintData,
  timeout
)

function inintData () {
  if (ok) {
    new Vue({
      router,
      render: (rh) => rh(App)
    }).$mount("#app")

    if (typeof (Vue) === "function") {
      Vue.prototype.zlService = zlService
    }
    clearInterval(st)
  }
}

/*
 * Vue.prototype.zlaxios.request({
 *         Url: zlService.baseUrl + '/smenu/selectMenu',
 *         Method: 'POST',
 *         Success: function (response) {
 *            Let menu = response.data
 *             Let routes = createRouter(menu)
 *
 *             Const router = new VueRouter({
 *                 Routes  // routes: routes 的简写
 *             })
 *
 *             // Vue.prototype.common=common
 *             Vue.prototype.zlaxios.request({
 *                 Url: zlService.baseUrl + '/sdict/sdictTree',
 *                 Success: function (response) {
 *                     Let dictData = response.data
 *                     If (dictData) {
 *                         Vue.prototype.dictData = dictData
 *                     }
 *                     New Vue({
 *                         Router,
 *                         Render: h => h(App)
 *                     }).$mount('#app')
 *                 },
 *                 Failed: function (error) {
 *                     New Vue({
 *                         Router,
 *                         Render: h => h(App)
 *                     }).$mount('#app')
 *                 }
 *             })
 *
 *         },
 *         Failed: function (error) {
 *             alert("查询菜单失败")
 *             Return ''
 *         }
 *     })
 */
