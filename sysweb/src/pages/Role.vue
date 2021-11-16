<template>
  <div>
    <zl-page :viewPage="viewPage" page="query">
      <zl-query-table ref="table" method="post" :column="2" :fileds="fileds" :url="url" :titles="titles">
        <zl-button type="button" name="新增" @click.native="add"></zl-button>
        <zl-button type="button" name="修改" @click.native="update"></zl-button>
        <zl-button type="button" name="删除" @click.native="del"></zl-button>
        <zl-button type="button" name="查看" @click.native="view"></zl-button>
      </zl-query-table>
    </zl-page>
    <zl-page :viewPage="viewPage" page="add">
      <zl-form ref="addTable" :column="2" :url="addUrl" method="post">
        <zl-item type="text" field-name="角色名" name="name" :rules="rules.name"/>
        <zl-item type="text" field-name="角色描述" name="remark"/>
      </zl-form>
      <div  class="d-grid gap-2 d-md-flex justify-content-md-center">
        <zl-button type="button" name="保存" @click.native="save"></zl-button>
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="update">
        <zl-form ref="updateTable" :column="2" method="post" :url="updateUrl">
          <zl-item type="text" field-name="角色id" name="id" readOnly="true"/>
          <zl-item type="text" field-name="角色名" name="name" :rules="rules.name"/>
          <zl-item type="text" field-name="角色描述" name="remark"/>
        </zl-form>
        <div  class="d-grid gap-2 d-md-flex justify-content-md-center">
          <zl-button type="button" name="保存" @click.native="saveUpdate"></zl-button>
          <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
        </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="view">
      <zl-f-table ref="fTable"  :column="2" :req-data="reqData">
        <zl-item type="text" field-name="角色id" name="id"/>
        <zl-item type="text" field-name="角色名" name="name" />
        <zl-item type="text" field-name="角色描述" name="remark"/>
      </zl-f-table>
      <div  class="d-grid gap-2 d-md-flex justify-content-md-center">
        <zl-button type="button" name="返回"  @click.native="toBack"></zl-button>
      </div>
    </zl-page>
  </div>
</template>

<script>
export default {
  name: "Role",
  data: function () {
    return {
      viewPage: 'query',
      fileds: [
        {
          type: 'text',
          cnName: "角色id",
          name: "id"
        }, {
          type: 'text',
          cnName: "角色名",
          name: "name"
        }
      ],
      rules:{
        name: {
          ruleName: ['isRequired']
        }
      },
      titles: [
        {
          cnName: "角色id",
          name: "id"
        },
        {
          cnName: "角色名",
          name: "name"
        }, {
          cnName: '角色描述',
          name: 'remark'
        }
      ],
      url: this.zlService.baseUrl + '/role/select',
      addUrl: this.zlService.baseUrl + '/role/add',
      updateUrl: this.zlService.baseUrl + '/role/update',
      delUrl: this.zlService.baseUrl + '/role/delete'
    }
  },
  methods:{
    add: function (){
      this.viewPage = 'add'
    },
    update: function(){
      let table = this.common.getComponent(this,'table')
      let updateTable = this.common.getComponent(this,'updateTable')
      updateTable.setReqData(table.selData)
      this.viewPage = 'update'
    },
    del: function (){
      let _this = this
      let table = _this.common.getComponent(this, 'table')
      let sel = table.selData
      if(sel){
        this.zlaxios.request({
          url:_this.delUrl,
          method: 'POST',
          config:{
            params:{
              id: sel.id
            }
          },
          success: function () {
            alert("删除成功")
            table.query()
            table.selNum = -1
          },
          error: function (error) {
            console.log(error)
          }
        })
      }
    },view: function () {
      let _this = this
      let table = _this.common.getComponent(this,'table')
      this.reqData  = table.selData
      this.viewPage = 'view'
    },
    save: function (){
      let _this = this
      let form = _this.common.getComponent(this,'addTable')
      if(form.checkAll()) {
        let reqData = form.reqData
        this.zlaxios.request({
          url: _this.url,
          method: form.method,
          data: reqData,
          success: function () {
            _this.toBack()
          },
          error: function (error) {
            console.log(error)
          }
        })
      }
    },
    saveUpdate: function (){
      let _this = this
      let form = _this.common.getComponent(this,'updateTable')
      if(form.checkAll()) {
        let reqData = form.reqData
        this.zlaxios.request({
          url: this.addUrl,
          method: form.method,
          data: reqData,
          success: function () {
            _this.toBack()
          },
          error: function (error) {
            console.log(error)
          }
        })
      }
    },
    toBack: function (){
      this.viewPage = 'query'
      let _this = this
      let table = _this.common.getComponent(this, 'table')
      table.query()
      table.selNum = -1
    }
  }


}
</script>

<style scoped>

</style>