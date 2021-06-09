<template>
    <div>
        <zl-page :viewPage="viewPage" page="query">
            <zl-query-table re="dict" method="post" column="1" :fileds="fileds" :url="url" :titles="titles">

            </zl-query-table>
        </zl-page>
    </div>
</template>

<script>
    export default {
        name: 'Dict',
        data: function () {
            return {
                viewPage: "query",
                fileds: [
                    {
                        type: 'text',
                        cnName: "数据字典描述",
                        name: "dictDesc"
                    }
                ],
                titles: [
                    {
                        cnName: "数据字典类型",
                        name: "dictType"
                    },
                    {
                        cnName: "数据字典描述",
                        name: "dictDesc"
                    }
                ],
                url: this.zlService.baseUrl + '/dict/selectGroup',
                reqData:{}
            }
        }
    }
</script>

<style scoped>

</style>
