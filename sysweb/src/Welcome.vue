<template>
    <zl-menu></zl-menu>
</template>

<script>
    export default {
        name: "Welcome",
        data: function (){
            return {
                url: '/sysmenu/selectSysMenu',
                method: 'post'
            }
        },
        created: function () {
            let _this = this
            this.zlaxios.request({
                url: _this.zlService.baseUrl + _this.url,
                method: _this.method,
                success: function (response) {
                    _this.$router.push({name:"Welcome"})
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
