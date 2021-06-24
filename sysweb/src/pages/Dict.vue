<template>
  <div>
    <zl-page :viewPage="viewPage" page="query">
      <zl-query-table ref="dict" method="post" :fileds="fileds" :url="url" :titles="titles">
        <zl-button type="button" name="新增" @click.native="add"></zl-button>
        <zl-button type="button" name="查看" @click.native="view"></zl-button>
      </zl-query-table>
    </zl-page>
    <zl-page :viewPage="viewPage" page="detail">
      <zl-f-table ref="fTable" :column="2" :req-data="reqData">
        <zl-item type="text" field-name="数据字典类型" name="dictType"/>
        <zl-item type="text" field-name="数据字典描述" name="dictDesc"/>
      </zl-f-table>
      <zl-query-table :isShow="isShow" ref="dictDetail" method="post" :titles="detailTitles" :url="url1">
      </zl-query-table>
    </zl-page>
    <zl-page :viewPage="viewPage" page="add">

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
      detailTitles: [
        {
          cnName: "编号",
          name: "id"
        }, {
          cnName: "字典码",
          name: "enName"
        }, {
          cnName: "中文名",
          name: "cnName"
        },
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
      url1: this.zlService.baseUrl + '/dict/select',
      reqData: {},
      isShow: false
    }
  },
  methods: {
    view: function () {
      let _this = this
      let table = _this.common.getComponent(this, 'dict')
      this.reqData = table.selData
      this.viewPage = 'detail'
      let detailTable = _this.common.getComponent(this, 'dictDetail')
      detailTable.setReqData(this.reqData)
      detailTable.query()
    }
  }
}
</script>

<style scoped>

</style>
