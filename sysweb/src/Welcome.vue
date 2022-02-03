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
  data () {
    return {
      url: "/menu/selectMenu",
      method: "post",
      menu: []
    }
  },
  created () {
    this.$nextTick(() => {
      const _this = this
      this.zlaxios.request({
        url: _this.zlService.baseUrl + _this.url,
        method: _this.method,
        success (response) {
          _this.menu = response.data
        },
        error (error) {
          alert(error)
        }
      })
    })
  }
}
</script>

<style scoped>

</style>
