<template>
    <div >
        <template v-if="field.type.toLowerCase() === 'select'">
            <zl-select  :field="field" :reqData="reqData"/>
        </template>
        <template v-else-if="field.type.toLowerCase() === 'textarea'">
        </template>
        <template v-else="field.type.toLowerCase() != 'select' &&field.type.toLowerCase() != 'textarea'">
            <zl-input :field="field" :reqData="reqData"/>
        </template>
    </div>
</template>

<script>
    import ZlSelect from "./ZlSelect.vue";
    import ZlInput from "./ZlInput.vue";
    export default {
        name: "ZlField",
        props:['field','reqData'],
        components: {ZlSelect,ZlInput},


    }
</script>

<style>

</style>
