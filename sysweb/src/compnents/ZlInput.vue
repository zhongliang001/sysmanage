<template>
    <div >
        <template v-if="field.type.toLowerCase() == 'select'">
        </template>
        <template v-else-if="field.type.toLowerCase() == 'textarea'">
        </template>
        <template v-else="field.type.toLowerCase() != 'select' &&field.type.toLowerCase() != 'textarea'">
            <input  :type="field.type" v-model="value" :name="field.name" @input="inputData" :reqData="reqData">
            <div :class="{error:isActive}">
                {{msg}}
            </div>
        </template>
    </div>
</template>

<script>
    export default {
        name: "ZlInput",
        props:['field', 'reqData'],
        data: function () {
            return {
                msg: '',
                isActive: true,
                value:''
            }
        },
        mounted: function() {
            this.value = this.field.defaultValue;
            this.reqData[this.field.name] = this.value
        },
        methods:{
            inputData: function () {
                if(this.field.dataType == 'Number' || this.field.dataType == 'Currency'){
                    if(isNaN(this.value)){
                        this.msg = '请输入数字'
                        this.value = ''
                        this.isActive = true
                        return
                    }else {
                        this.msg = ''
                        this.isActive = false

                    }
                }
                this.reqData[this.field.name] = this.value
            },
            validate: function () {
                console.log(this.field.name)
            }
        }

    }
</script>

<style>

</style>
