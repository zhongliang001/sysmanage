<template>
  <div>
    <zl-page :viewPage="viewPage" page="query">
      <zl-query-table ref="table" :column="2" method="post" init="true" :req-data="reqData" :fileds="fileds" :init="true" :url="url"
                      :titles="titles">
        <zl-button type="button" name="新增" @click.native="add"></zl-button>
        <zl-button type="button" name="修改" @click.native="update"></zl-button>
        <zl-button type="button" name="查看" @click.native="viewDetail"></zl-button>
        <zl-button type="button" name="删除" @click.native="delData"></zl-button>
      </zl-query-table>
    </zl-page>
    <zl-page :view-page="viewPage" page="add">
      <zl-form ref="add" :url="addUrl" :column="2" method="post">
        <zl-item type="text" field-name="菜单id" name="menuId" :default-value="menuId"
                 :read-only="menuId !== undefined&& menuId !== null && menuId !==''"/>
        <zl-item type="text" field-name="菜单名" name="menuName" :default-value="menuName"
                 :read-only="menuName !== undefined&& menuName !== null && menuName !==''"/>
        <zl-item type="text" field-name="操作名" name="name"/>
        <zl-item type="text" field-name="操作" name="oper"/>
      </zl-form>
      <div class="form-buttons">
        <zl-button type="button" name="保存" @click.native="save"/>
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
    <zl-page :view-page="viewPage" page="update">
      <zl-form ref="updateTable" :url="updateUrl" :column="2" method="post">
        <zl-item type="text" field-name="菜单名" name="menuName"
                 :read-only="true"/>
        <zl-item type="text" field-name="菜单id" name="menuId"
                 :read-only="true"/>
        <zl-item type="text" field-name="操作名" name="name"/>
        <zl-item type="text" field-name="操作" name="oper"/>
        <zl-item type="text" field-name="操作id" name="id" hidden="true"/>
      </zl-form>
      <div class="form-buttons">
        <zl-button type="button" name="保存" @click.native="saveUpData"/>
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
    <zl-page :view-page="viewPage" page="detail">
      <zl-f-table ref="fTable" :column="2" :view="true" :req-data="detail">
        <zl-item type="text" field-name="操作id" name="id"/>
        <zl-item type="text" field-name="菜单id" name="menuId" />
        <zl-item type="text" field-name="操作名" name="name"/>
        <zl-item type="text" field-name="操作" name="oper"/>
      </zl-f-table>
      <div class="form-buttons">
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
  </div>
</template>

<script>
import Dict from "./Dict";

export default {
  name: "Action",
  components: {Dict},
  data: function () {
    return {
      fileds: [
        {
          type: "text",
          cnName: '菜单id',
          name: 'menuId'
        },
        {
          type: "text",
          cnName: '菜单名',
          name: 'menuName'
        },
        {
          type: "text",
          cnName: '操作名',
          name: 'name'
        },
        {
          type: "text",
          cnName: '操作',
          name: 'oper'
        }
      ],
      titles: [
        {
          cnName: '菜单id',
          name: 'menuId'
        },
        {
          cnName: '操作名',
          name: 'name'
        },
        {
          cnName: '操作',
          name: 'oper'
        }
      ],
      menuId: '',
      menuName: '',
      reqData: {},
      viewPage: 'query',
      url: this.zlService.baseUrl + '/action/select',
      addUrl: this.zlService.baseUrl + '/action/add',
      updateUrl: this.zlService.baseUrl + '/action/update',
      delUrl: this.zlService.baseUrl + '/action/delete',
      detail: {}
    }
  },
  created: function () {
    let _this = this
    let query = this.$route.query
    if (query) {
      let fields = _this.fileds
      for (let i = 0; i < fields.length; i++) {
        debugger
        let item = fields[i]
        if (item.name !== 'menuId' && item.name !== 'menuName') {
          fields.splice(i, 1)
          i--
        }
      }
      Object.keys(query).forEach((key) => {
        for (let i = 0; i < fields.length; i++) {
          let filed = fields[i]
          if (filed.name === 'menuId' && key === 'id') {
            _this.menuId = query[key]
            _this.$set(filed, 'defaultValue', query[key])
            _this.$set(filed, 'readOnly', true)
            _this.reqData.menuId = query[key]
          }else if(filed.name === 'menuName' && key === 'name'){
            _this.menuName = query[key]
            _this.$set(filed, 'defaultValue', query[key])
            _this.$set(filed, 'readOnly', true)
            _this.reqData.menuName = query[key]
          }
        }
      })
    }
  },
  methods: {
    add: function () {
      this.viewPage = 'add'
    }
    ,
    save: function () {
      let _this = this
      let form = _this.common.getComponent(this, 'add')
      let reqData = form.reqData
      this.zlaxios.request({
        url: this.addUrl,
        method: form.method,
        data: reqData,
        success: function () {
          form.reset()
          _this.toBack()
        },
        error: function (error) {
          console.log(error)
        }
      })
    },
    toBack: function () {
      this.viewPage = 'query'
      let table = this.common.getComponent(this, 'table')
      table.query()
    },
    update: function (){
      let table = this.common.getComponent(this, 'table')
      let selData = table.selData
      if (selData) {
        let updateTable = this.common.getComponent(this, 'updateTable')
        updateTable.setReqData(selData)
        this.viewPage = 'update'
      }else{
        alert("请选择一条记录")
      }
    },
    saveUpData: function (){
      let _this = this
      let form = this.common.getComponent(this, 'updateTable')
      let reqData = form.reqData
      this.zlaxios.request({
        url: _this.updateUrl,
        method: form.method,
        data: reqData,
        success: function () {
          _this.toBack()
        },
        error: function (error) {
          console.log(error)
        }
      })
    },
    viewDetail: function (){
      let table = this.common.getComponent(this, 'table')
      let selData = table.selData
      if (selData) {
        this.detail = selData
        this.viewPage = 'detail'
      }else{
        alert("请选择一条记录")
      }
    },
    delData: function (){
      let _this = this
      let table = this.common.getComponent(this, 'table')
      let selData = table.selData
      if (selData) {
        this.zlaxios.request({
          url: _this.delUrl,
          method: 'POST',
          config: {
            params: {
              id: table.selData.id
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
      }else{
        alert("请选择一条记录")
      }
    }
  }

}
</script>

<style scoped>

</style>