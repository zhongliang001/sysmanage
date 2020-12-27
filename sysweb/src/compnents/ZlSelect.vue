<template>
    <div>
        <div>
            <div class="select">
                <span class="select">a</span><span class="selIcon" @click="pull"></span>
                <zl-input :field="hidfield" :reqData="reqData"/>
            </div>
            <div class="option">
                <ul>
                    <li>1</li>
                    <li>2</li>
                </ul>
            </div>
        </div>
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
                hidfield: {}
            }
        },
        created: function () {
           this.hidfield=JSON.parse(JSON.stringify(this.field._props));
           this.hidfield['hidden'] = true
           this.hidfield.type = 'text'
        },
        methods:{
            pull: function () {

            }
        }

    }
</script>
