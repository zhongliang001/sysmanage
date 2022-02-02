<template>
    <main style="height:1024px">
      <zl-menu :menu="menu" right-name="actionDtos"></zl-menu>
      <div class="main">
        <router-view></router-view>
      </div>
    </main>


</template>

<script>
    export default {
        name: "Welcome",
        data: function (){
            return {
                url: '/menu/selectMenu',
                method: 'post',
                menu: []
            }
        },
        created: function () {
          this.$nextTick(() => {
            let _this = this
            this.zlaxios.request({
              url: _this.zlService.baseUrl + _this.url,
              method: _this.method,
              success: function (response) {
                _this.menu = response.data
              },
              error: function (error) {
                console.log(error)
              }
            })
          })
        }
    }
</script>

<style scoped>

</style>
