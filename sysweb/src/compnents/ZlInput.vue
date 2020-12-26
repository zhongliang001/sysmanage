<template>
    <div>
        <template v-if="field.type.toLowerCase() == 'select'">
        </template>
        <template v-else-if="field.type.toLowerCase() == 'textarea'">
        </template>
        <template v-else="field.type.toLowerCase() != 'select' &&field.type.toLowerCase() != 'textarea'">
            <input :type="field.type" v-model="value" :name="field.name" @input="inputData">
            <div :class="{error:isActive}">
                {{msg}}
            </div>
        </template>
    </div>
</template>

<script>
    export default {
        name: "ZlInput",
        props:['field'],
        data: function () {
            return {
                msg: '',
                isActive: true,
                value:''
            }
        },
        methods:{
            inputData: function () {
                if(this.field.dataType == 'Number' || this.field.dataType == 'Currency'){
                    if(isNaN(this.value)){
                        this.msg = '请输入数字'
                        this.value = ''
                        this.isActive = true
                    }else {
                        this.msg = ''
                        this.isActive = false
                    }
                }
            }
        }

    }
</script>

<style>
    .error {
        background-color: red;
        position:absolute;
        top:10px;
        left:10px;
        z-index:1000;
    }
</style>
