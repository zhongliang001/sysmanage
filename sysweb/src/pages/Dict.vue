<template>
  <div style="width: 100%">
    <zl-page :viewPage="viewPage" page="query">
      <zl-query-table ref="dict" method="post" :fileds="fileds" :url="url" :titles="titles">
        <zl-button type="button" name="新增" @click.native="add"></zl-button>
        <zl-button type="button" name="修改" @click.native="update"></zl-button>
        <zl-button type="button" name="删除" @click.native="del"></zl-button>
        <zl-button type="button" name="查看" @click.native="view"></zl-button>
        <zl-button type="button" name="重载缓存" @click.native="reload"></zl-button>
      </zl-query-table>
    </zl-page>
    <zl-page :viewPage="viewPage" page="detail">
      <zl-f-table ref="fTable" :column="2" :req-data="reqData">
        <zl-item type="text" field-name="数据字典类型" name="dictType"/>
        <zl-item type="text" field-name="数据字典描述" name="dictDesc"/>
      </zl-f-table>
      <zl-query-table :isShow="isShow" ref="dictDetail" method="post" :titles="detailTitles" :url="detailUrl">
      </zl-query-table>
      <div  class="d-grid gap-2 d-md-flex justify-content-md-center">
        <zl-button type="button" name="返回" @click.native="toQuery"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="update" :url="updateUrl">
      <zl-form ref="updateTable" :url="url" :column="2" method="post">
        <zl-item type="text" field-name="数据字典类型" name="dictType" required="true" readOnly="true"/>
        <zl-item ref="dictDesc" type="text" field-name="数据字典描述" name="dictDesc" required="true"/>
      </zl-form>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <zl-button type="button" name="保存" @click.native="saveUpdate"></zl-button>
        <zl-button type="button" name="返回" @click.native="toQuery"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="add" :url="addQueryUrl">
      <zl-form ref="isExists" :url="url" :column="2" method="post">
        <zl-item type="text" field-name="数据字典类型" name="dictType" required="true"/>
        <zl-item ref="dictDesc" type="text" field-name="数据字典描述" name="dictDesc" readOnly="true" required="true"/>
      </zl-form>
      <div  class="d-grid gap-2 d-md-flex justify-content-md-center">
        <zl-button type="button" name="查询" @click.native="query"></zl-button>
        <zl-button type="button" name="下一步" @click.native="next"></zl-button>
        <zl-button type="button" name="返回" @click.native="toQuery"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="nextPage">
      <zl-f-table ref="nextPageTable" :column="2" :req-data="reqData2">
        <zl-item type="text" field-name="数据字典类型" name="dictType"/>
        <zl-item type="text" field-name="数据字典描述" name="dictDesc"/>
      </zl-f-table>
      <zl-query-table :isShow="isShow" ref="dictNextDetail" method="post" :titles="detailTitles" :url="detailUrl">
        <zl-button type="button" name="新增" @click.native="addDict"></zl-button>
        <zl-button type="button" name="修改" @click.native="updateDict"></zl-button>
        <zl-button type="button" name="删除" @click.native="delDict"></zl-button>
      </zl-query-table>
      <div  class="d-grid gap-2 d-md-flex justify-content-md-center">
        <zl-button type="button" name="返回" @click.native="toAddPage"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="addDict">
      <zl-form ref="addDict" :url="addUrl" :column="2" method="post">
        <zl-item type="text" field-name="数据字典类型" name="dictType" readOnly="true"/>
        <zl-item type="text" field-name="数据字典描述" name="dictDesc" readOnly="true"/>
        <zl-item type="text" field-name="字典码" name="enName" required="true"/>
        <zl-item type="text" field-name="中文名" name="cnName" required="true"/>
      </zl-form>
      <div  class="d-grid gap-2 d-md-flex justify-content-md-center">
        <zl-button type="button" name="保存" @click.native="save"></zl-button>
        <zl-button type="button" name="返回" @click.native="toNextPage"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="updateDict">
      <zl-form ref="updateDict" :url="updateDictUrl" :column="2" method="post">
        <zl-item type="text" field-name="数据字典类型" name="dictType" readOnly="true"/>
        <zl-item type="text" field-name="数据字典描述" name="dictDesc" readOnly="true"/>
        <zl-item type="text" field-name="字典码" name="enName" required="true"/>
        <zl-item type="text" field-name="中文名" name="cnName" required="true"/>
      </zl-form>
      <div  class="d-grid gap-2 d-md-flex justify-content-md-center">
        <zl-button type="button" name="保存" @click.native="saveUpdateDict"></zl-button>
        <zl-button type="button" name="返回" @click.native="toNextPage"></zl-button>
      </div>
    </zl-page>

  </div>
</template>

<script>
import Vue from "vue";
export default {
  name: 'Dict',
  data: function () {
    return {
      viewPage: "query",
      fileds: [
        {
          type: 'text',
          cnName: "数据字典类型",
          name:"dictType"
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
      url: this.zlService.baseUrl + '/dict/selectGroups',
      detailUrl: this.zlService.baseUrl + '/dict/select',
      addUrl: this.zlService.baseUrl + '/dict/save',
      addQueryUrl: this.zlService.baseUrl + '/dict/selectGroup',
      delDictUrl: this.zlService.baseUrl + '/dict/delDict',
      delUrl: this.zlService.baseUrl + '/dict/delete',
      updateUrl: this.zlService.baseUrl + '/dict/update',
      updateDictUrl: this.zlService.baseUrl + '/dict/updateDict',
      reloadUrl: this.zlService.baseUrl + '/dict/reloadRedisDict',
      reqData: {},
      reqData2: {},
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
    },
    add: function () {
      this.viewPage = 'add'
    },
    del: function (){
      let _this = this
      let table = _this.common.getComponent(this, 'dict')
      let sel = table.selData
      if(sel){
        this.zlaxios.request({
          url:_this.delUrl,
          method: 'POST',
          config:{
            params:{
              dictType: sel.dictType
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
    },
    reload:function (){
      let _this = this
      this.zlaxios.request({
        url:_this.reloadUrl,
        method: 'POST',
        success: function (response) {
          alert("重载数据字典缓存成功")
          Vue.prototype.dictData = response.data
        },
        error: function (error) {
          console.log(error)
        }
      })
    },
    update: function () {
      let _this = this
      let table = _this.common.getComponent(this, 'dict')
      if(JSON.stringify(table.selData)==='{}'){
        alert("请选择一条记录");
        debugger
        return
      }
      this.viewPage = 'update'
      let updateTable = _this.common.getComponent(this, 'updateTable')
      updateTable.setReqData( table.selData)
    },
    saveUpdate: function (){
      let _this = this
      let updateTable = _this.common.getComponent(this, 'updateTable')
      this.zlaxios.request({
        url: _this.updateUrl,
        method: updateTable.method,
        data: updateTable.reqData,
        success: function () {
            _this.toQuery();
            let table = _this.common.getComponent(this, 'dict')
            table.query()
        },
        error: function (error) {
          console.log(error)
        }
      })
    },
    query: function () {
      let _this = this
      let isExists = _this.common.getComponent(this, 'isExists')
      let reqData = isExists.reqData
      this.zlaxios.request({
        url: _this.addQueryUrl,
        method: isExists.method,
        data: reqData,
        success: function (response) {
          if (response.data[0]) {
            isExists.reqData = response.data[0]
            isExists.setData('dictDesc', response.data[0].dictDesc)
            isExists.changeReadOnly('dictDesc', true)
          } else {
            isExists.changeReadOnly('dictDesc', false)
          }
        },
        error: function (error) {
          console.log(error)
        }
      })
    },
    next: function () {
      let _this = this
      let isExists = _this.common.getComponent(this, 'isExists')
      let checkAll = isExists.checkAll()
      if (checkAll) {
        let reqData = isExists.reqData
        this.zlaxios.request({
          url: _this.addQueryUrl,
          method: isExists.method,
          data: reqData,
          success: function (response) {
            if (response.data[0] && !(isExists.reqData.dictType === response.data[0].dictType && isExists.reqData.dictDesc === response.data[0].dictDesc)) {
                alert('新增的数据字典类型已经存在，但与你录入的数据字典类型与数据字典类型描述不一致, 请重新查询后再进行下一步!')
            } else {
              _this.toNext(isExists.reqData)
            }

          },
          error: function (error) {
            console.log(error)
          }
        })
      }
    },
    toNext: function (reqData) {
      let _this = this
      this.reqData2 = reqData
      let dictNextDetail = this.common.getComponent(_this, 'dictNextDetail')
      dictNextDetail.setReqData(this.reqData2)
      dictNextDetail.query()
      _this.viewPage = 'nextPage'
    },
    addDict: function () {
      let _this = this
      let addDict = this.common.getComponent(_this,'addDict')
      let isExists = _this.common.getComponent(this, 'isExists')
      addDict.setData('dictType', isExists.reqData.dictType)
      addDict.setData('dictDesc', isExists.reqData.dictDesc)
      _this.viewPage = 'addDict'
    },
    save: function () {
      let _this = this
      let form = _this.common.getComponent(this,'addDict')
      let reqData = form.reqData
      this.zlaxios.request({
        url: this.addUrl,
        method: form.method,
        data: reqData,
        success: function () {
          _this.toNextPage()
        },
        error: function (error) {
          console.log(error)
        }
      })
    },
    updateDict:function(){
      let _this = this
      let dictNextDetail = this.common.getComponent(_this,'dictNextDetail')
      let updateDict = this.common.getComponent(_this,'updateDict')
      updateDict.setReqData(dictNextDetail.selData)
      this.viewPage = 'updateDict'
    },
    saveUpdateDict: function (){
      let _this = this
      let updateDict = this.common.getComponent(_this,'updateDict')
      this.zlaxios.request({
        url: this.addUrl,
        method: updateDict.method,
        data: updateDict.reqData,
        success: function () {
          _this.toNextPage()
        },
        error: function (error) {
          console.log(error)
        }
      })
    },
    delDict: function (){
      let _this = this
      let nextPageTable = this.common.getComponent(_this,'dictNextDetail')
      let sel = nextPageTable.selData
      if(sel){
        this.zlaxios.request({
          url:_this.delDictUrl,
          method: 'POST',
          config:{
            params:{
              id: sel.id
            }
          },
          success: function () {
            alert("删除成功")
            nextPageTable.query()
            nextPageTable.selNum = -1
          },
          error: function (error) {
            console.log(error)
          }
        })
      }
    },
    toQuery: function (){
      this.viewPage = 'query'
    },
    toAddPage: function (){
      this.viewPage = 'add'
    },
    toNextPage: function (){
      this.viewPage = 'nextPage'
    }
  }
}
</script>

<style scoped>

</style>
