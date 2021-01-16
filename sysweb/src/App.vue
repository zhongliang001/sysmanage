<template>
    <router-view></router-view>
</template>

<script>
    //import ZlForm from './compnents/ZlForm.vue'
    //import ZlItem from './compnents/ZlItem.vue'
    export default {
        name: 'App',
        mounted: function () {
			this.$router.push({name:"Login"})
        }
    }
</script>

<style>
</style>
