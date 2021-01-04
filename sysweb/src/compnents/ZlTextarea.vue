<template>
    <textarea :name="field.name" :reqData="reqData" v-model="value" @input="inputData" >

    </textarea>
</template>

<script>
    export default {
        name: "ZlTextarea",
        props:['field', 'reqData'],
        data: function () {
            return {
                msg: '',
                value:''
            }
        },
        mounted: function() {
            this.value = this.field.defaultValue;
            this.reqData[this.field.name] = this.value
        },
        methods:{
            inputData: function () {
                this.reqData[this.field.name] = this.value
            }
        }
    }
</script>

<style scoped>

</style>
