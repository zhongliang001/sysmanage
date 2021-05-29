<template>
    <div>
        <zl-query-table column="2" re="menu" method="post" :url="url" :fileds="fileds" :titles="titles">
            <zl-button type="button" name="add"  @click.native="add"></zl-button>
        </zl-query-table>

    </div>
</template>

<script>
    export default {
        name: "Menu",
        data:function () {
            return {
                fileds:[{
                    type: "text",
                    cnName: "菜单名",
                    name: "name"
                }],
                titles:[
                    '菜单编号','菜单名','菜单路径','菜单文件','父菜单编号'
                ],
                url : this.zlService.baseUrl +'/menu/select'
            }
        },
        methods: {
            add: function () {
                alert("hi")
            }
        }
    }
</script>

<style scoped>

</style>
