<template>
   <zl-page pageName="操作" :viewPage="viewPage" page="add">
      <zl-query-table ref="table" :column="2" re="action" method="post" :isShow="false" :url="url" :titles="titles">
        <zl-button type="button" name="新增"  @click.native="add"></zl-button>
        <zl-button type="button" name="修改"  @click.native="update"></zl-button>
        <zl-button type="button" name="查看"  @click.native="view"></zl-button>
        <zl-button type="button" name="删除"  @click.native="delData"></zl-button>
      </zl-query-table>
    </zl-page>
</template>

<script>
export default {
  name: "Action",
  data: function (){
    return {
      titles:[
        {
          cnName:'操作名',
          name: 'name'
        },
        {
          cnName:'操作',
          name: 'oper'
        }
      ],
      viewPage: 'add',
      url: ''
    }
  }
}
</script>

<style scoped>

</style>