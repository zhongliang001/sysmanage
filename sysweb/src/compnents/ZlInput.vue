<template>
    <div>
        <input  :type="field.type" v-model="value" :name="field.name" @input="inputData" :reqData="reqData" :hidden="field.hidden">
        <div :class="{error:isActive}">
            {{msg}}
        </div>
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
                if(this.field.dataType === 'Number' || this.field.dataType === 'Currency'){
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
                if((this.field.required === 'true' || this.field.required === 'required')&& !this.value){
                    this.msg = this.field.fieldName + '不能为空'
                    this.isActive = true
                    return false
                }
            }
        }
    }
</script>
