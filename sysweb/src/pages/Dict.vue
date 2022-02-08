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
      <div class="form-buttons">
        <zl-button type="button" name="返回" @click.native="toQuery"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="update" :url="updateUrl">
      <zl-form ref="updateTable" :url="url" :column="2" method="post">
        <zl-item type="text" field-name="数据字典类型" name="dictType" required="true" :readOnly="true"/>
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
        <zl-item ref="dictDesc" type="text" field-name="数据字典描述" name="dictDesc" :readOnly="true" required="true"/>
      </zl-form>
      <div class="form-buttons">
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
      <div class="form-buttons">
        <zl-button type="button" name="返回" @click.native="toAddPage"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="addDict">
      <zl-form ref="addDict" :url="addUrl" :column="2" method="post">
        <zl-item type="text" field-name="数据字典类型" name="dictType" :readOnly="true"/>
        <zl-item type="text" field-name="数据字典描述" name="dictDesc" :readOnly="true"/>
        <zl-item type="text" field-name="字典码" name="enName" required="true"/>
        <zl-item type="text" field-name="中文名" name="cnName" required="true"/>
      </zl-form>
      <div class="form-buttons">
        <zl-button type="button" name="保存" @click.native="save"></zl-button>
        <zl-button type="button" name="返回" @click.native="toNextPage"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="updateDict">
      <zl-form ref="updateDict" :url="updateDictUrl" :column="2" method="post">
        <zl-item type="text" field-name="数据字典类型" name="dictType" :readOnly="true"/>
        <zl-item type="text" field-name="数据字典描述" name="dictDesc" :readOnly="true"/>
        <zl-item type="text" field-name="字典码" name="enName" required="true"/>
        <zl-item type="text" field-name="中文名" name="cnName" required="true"/>
      </zl-form>
      <div class="form-buttons">
        <zl-button type="button" name="保存" @click.native="saveUpdateDict"></zl-button>
        <zl-button type="button" name="返回" @click.native="toNextPage"></zl-button>
      </div>
    </zl-page>

  </div>
</template>

<script>
import Vue from 'vue'

export default {
  name: 'Dict',
  data () {
    return {
      viewPage: 'query',
      fileds: [
        {
          type: 'text',
          cnName: '数据字典类型',
          name: 'dictType'
        }
      ],
      titles: [
        {
          cnName: '数据字典类型',
          name: 'dictType'
        },
        {
          cnName: '数据字典描述',
          name: 'dictDesc'
        }
      ],
      detailTitles: [
        {
          cnName: '编号',
          name: 'id'
        },
        {
          cnName: '字典码',
          name: 'enName'
        },
        {
          cnName: '中文名',
          name: 'cnName'
        },
        {
          cnName: '数据字典类型',
          name: 'dictType'
        },
        {
          cnName: '数据字典描述',
          name: 'dictDesc'
        }
      ],
      url: `${this.zlService.baseUrl}/dict/selectGroups`,
      detailUrl: `${this.zlService.baseUrl}/dict/select`,
      addUrl: `${this.zlService.baseUrl}/dict/save`,
      addQueryUrl: `${this.zlService.baseUrl}/dict/selectGroup`,
      delDictUrl: `${this.zlService.baseUrl}/dict/delDict`,
      delUrl: `${this.zlService.baseUrl}/dict/delete`,
      updateUrl: `${this.zlService.baseUrl}/dict/update`,
      updateDictUrl: `${this.zlService.baseUrl}/dict/updateDict`,
      reloadUrl: `${this.zlService.baseUrl}/dict/reloadRedisDict`,
      reqData: {},
      reqData2: {},
      isShow: false
    }
  },
  methods: {
    view () {
      const _this = this
      const table = _this.common.getComponent(
        this,
        'dict'
      )
      this.reqData = table.selData
      this.viewPage = 'detail'
      const detailTable = _this.common.getComponent(
        this,
        'dictDetail'
      )
      detailTable.setReqData(this.reqData)
      detailTable.query()
    },
    add () {
      this.viewPage = 'add'
    },
    del () {
      const _this = this
      const table = _this.common.getComponent(
        this,
        'dict'
      )
      const sel = table.selData
      if (sel) {
        this.zlaxios.request({
          url: _this.delUrl,
          method: 'POST',
          config: {
            params: {
              dictType: sel.dictType
            }
          },
          success () {
            alert('删除成功')
            table.query()
            table.selNum = -1
          },
          error (error) {
            alert(error)
          }
        })
      }
    },
    reload () {
      const _this = this
      this.zlaxios.request({
        url: _this.reloadUrl,
        method: 'POST',
        success (response) {
          alert('重载数据字典缓存成功')
          Vue.prototype.dictData = response.data
        },
        error (error) {
          alert(error)
        }
      })
    },
    update () {
      const _this = this
      const table = _this.common.getComponent(
        this,
        'dict'
      )
      if (JSON.stringify(table.selData) === '{}') {
        alert('请选择一条记录')
        return
      }
      this.viewPage = 'update'
      const updateTable = _this.common.getComponent(
        this,
        'updateTable'
      )
      updateTable.setReqData(table.selData)
    },
    saveUpdate () {
      const _this = this
      const updateTable = _this.common.getComponent(
        this,
        'updateTable'
      )
      this.zlaxios.request({
        url: _this.updateUrl,
        method: updateTable.method,
        data: updateTable.reqData,
        success () {
          _this.toQuery()
          const table = _this.common.getComponent(
            this,
            'dict'
          )
          table.query()
        },
        error (error) {
          alert(error)
        }
      })
    },
    query () {
      const _this = this
      const isExists = _this.common.getComponent(
        this,
        'isExists'
      )
      const { reqData } = isExists
      this.zlaxios.request({
        url: _this.addQueryUrl,
        method: isExists.method,
        data: reqData,
        success (response) {
          const zero = 0
          if (response.data[zero]) {
            isExists.reqData = response.data[zero]
            isExists.setData(
              'dictDesc',
              response.data[zero].dictDesc
            )
            isExists.changeReadOnly(
              'dictDesc',
              true
            )
          } else {
            isExists.changeReadOnly(
              'dictDesc',
              false
            )
          }
        },
        error (error) {
          alert(error)
        }
      })
    },
    next () {
      const _this = this
      const isExists = _this.common.getComponent(
        this,
        'isExists'
      )
      const checkAll = isExists.checkAll()
      if (checkAll) {
        const { reqData } = isExists
        this.zlaxios.request({
          url: _this.addQueryUrl,
          method: isExists.method,
          data: reqData,
          success (response) {
            const zero = 0
            if (response.data[zero] && !(isExists.reqData.dictType === response.data[zero].dictType && isExists.reqData.dictDesc === response.data[zero].dictDesc)) {
              alert('新增的数据字典类型已经存在，但与你录入的数据字典类型与数据字典类型描述不一致, 请重新查询后再进行下一步!')
            } else {
              _this.toNext(isExists.reqData)
            }
          },
          error (error) {
            alert(error)
          }
        })
      }
    },
    toNext (reqData) {
      const _this = this
      this.reqData2 = reqData
      const dictNextDetail = this.common.getComponent(
        _this,
        'dictNextDetail'
      )
      dictNextDetail.setReqData(this.reqData2)
      dictNextDetail.query()
      _this.viewPage = 'nextPage'
    },
    addDict () {
      const _this = this
      const addDict = this.common.getComponent(
        _this,
        'addDict'
      )
      const isExists = _this.common.getComponent(
        this,
        'isExists'
      )
      addDict.setData(
        'dictType',
        isExists.reqData.dictType
      )
      addDict.setData(
        'dictDesc',
        isExists.reqData.dictDesc
      )
      _this.viewPage = 'addDict'
    },
    save () {
      const _this = this
      const form = _this.common.getComponent(
        this,
        'addDict'
      )
      const { reqData } = form
      this.zlaxios.request({
        url: this.addUrl,
        method: form.method,
        data: reqData,
        success () {
          _this.toNextPage()
        },
        error (error) {
          alert(error)
        }
      })
    },
    updateDict () {
      const _this = this
      const dictNextDetail = this.common.getComponent(
        _this,
        'dictNextDetail'
      )
      const updateDict = this.common.getComponent(
        _this,
        'updateDict'
      )
      updateDict.setReqData(dictNextDetail.selData)
      this.viewPage = 'updateDict'
    },
    saveUpdateDict () {
      const _this = this
      const updateDict = this.common.getComponent(
        _this,
        'updateDict'
      )
      this.zlaxios.request({
        url: this.addUrl,
        method: updateDict.method,
        data: updateDict.reqData,
        success () {
          _this.toNextPage()
        },
        error (error) {
          alert(error)
        }
      })
    },
    delDict () {
      const _this = this
      const nextPageTable = this.common.getComponent(
        _this,
        'dictNextDetail'
      )
      const sel = nextPageTable.selData
      if (sel) {
        this.zlaxios.request({
          url: _this.delDictUrl,
          method: 'POST',
          config: {
            params: {
              id: sel.id
            }
          },
          success () {
            alert('删除成功')
            nextPageTable.query()
            nextPageTable.selNum = -1
          },
          error (error) {
            alert(error)
          }
        })
      }
    },
    toQuery () {
      this.viewPage = 'query'
    },
    toAddPage () {
      this.viewPage = 'add'
    },
    toNextPage () {
      this.viewPage = 'nextPage'
    }
  }
}
</script>

<style scoped>

</style>
