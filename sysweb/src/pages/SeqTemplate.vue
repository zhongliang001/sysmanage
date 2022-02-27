<template>
  <div>
    <zl-page :viewPage="viewPage" page="query">
      <zl-query-table ref="table" method="post" :column="2" :fields="fields" :url="url" :titles="titles">
        <zl-button type="button" name="新增" @click.native="add"></zl-button>
        <zl-button type="button" name="修改" @click.native="update"></zl-button>
        <zl-button type="button" name="删除" @click.native="del"></zl-button>
        <zl-button type="button" name="查看" @click.native="view"></zl-button>
      </zl-query-table>
    </zl-page>
  </div>
</template>

<script>
export default {
  name: 'SeqTemplate',
  data () {
    return {
      viewPage: 'query',
      fields: [
        {
          type: 'text',
          cnName: '模板id',
          name: 'id'
        },
        {
          type: 'text',
          cnName: '模板名',
          name: 'name'
        }
      ],
      titles: [
        {
          cnName: '模板id',
          name: 'id'
        },
        {
          cnName: '模板名',
          name: 'name'
        }
      ],
      url: `${this.zlService.seqUrl}/template/select`
    }
  },
  methods: {
    add () {

    },
    update () {

    },
    del () {

    },
    view () {

    }
  }
}
</script>

<style scoped>

</style>
