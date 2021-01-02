<template>
    <div>
        <select :name="field.name"  @change="change" v-model="value">
            <option v-for="(cname, ename) in options" :value="ename">{{cname}}</option>
        </select>
    </div>
</template>

<script>
   import ZlInput from "./ZlInput.vue";
    export default {
        name: "ZlSelect",
       components:{ZlInput},
        props:['field','reqData'],
        data: function () {
            return {
                options:{},
                value:''
            }
        },
        mounted: function () {
            Object.assign(this.options,{'':"请选择一个选项"}, this.dictData[this.field.dictName])
            this.reqData[this.field.name] = this.value
            this.$forceUpdate()
            this.value = ''
        },
        methods:{
            change: function () {
                this.reqData[this.field.name] = this.value
            }
        }

    }
</script>
