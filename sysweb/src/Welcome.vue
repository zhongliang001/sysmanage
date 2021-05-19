<template>
    <zl-menu :menu="menu"></zl-menu>
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
        }
    }
</script>

<style scoped>

</style>
