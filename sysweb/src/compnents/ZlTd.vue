<template>
    <td>
        <template v-if="field.type == null">
            {{field.fieldName}}
        </template>
        <template v-else>
            <zl-field :field="field" :reqData="reqData"/>
        </template>
    </td>

</template>

<script>
    import ZlField from "./ZlField.vue";
    export default {
        name: "ZlTd",
        props:['field','reqData'],
        components:{ZlField},
        data: function () {
            return {

            }
        }

    }
</script>

<style scoped>

</style>
