<template>
    <td>
        <template v-if="field.type == null">
            {{field.fieldName}}
        </template>
        <template v-else>
            <zl-input :field="field" :reqData="reqData"/>
        </template>
    </td>

</template>

<script>
    import ZlInput from "./ZlInput.vue";
    export default {
        name: "ZlTd",
        props:['field','reqData'],
        components:{ZlInput},
        data: function () {
            return {

            }
        }

    }
</script>

<style scoped>

</style>
