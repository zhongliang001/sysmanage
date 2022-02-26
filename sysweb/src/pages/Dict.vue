<template>
  <div style="width: 100%">
    <zl-page :viewPage="viewPage" page="query">
      <zl-query-table ref="dict" method="post" :fields="fields" :url="url" :titles="titles">
        <zl-button type="button" name="新增" @click.native="add"></zl-button>
        <zl-button type="button" name="修改" @click.native="update"></zl-button>
        <zl-button type="button" name="删除" @click.native="del"></zl-button>
        <zl-button type="button" name="查看" @click.native="view"></zl-button>
        <zl-button type="button" name="重载缓存" @click.native="reload"></zl-button>
      </zl-query-table>
    </zl-page>
    <zl-page :viewPage="viewPage" page="detail" ref="detail">
        <zl-query-table ref="dictDetail" method="post" :titles="detailTitles" :url="detailUrl">
          <template slot="condition">
            <zl-item type="text" field-name="数据字典类型" name="dictType"/>
            <zl-item type="text" field-name="数据字典描述" name="dictDesc"/>
          </template>
        </zl-query-table>
        <div class="form-buttons">
          <zl-button type="button" name="返回" @click.native="toQuery"></zl-button>
        </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="update" ref="update">
      <zl-form ref="updateForm" :url="updateUrl" :column="2" method="post">
        <zl-panel title="修改字典" :column="2" >
        <zl-item type="text" field-name="数据字典类型" name="dictType" required="true" :readOnly="true"/>
        <zl-item type="text" field-name="数据字典描述" name="dictDesc" required="true"/>
        </zl-panel>
      </zl-form>
      <div class="form-buttons">
        <zl-button type="button" name="保存" @click.native="saveUpdate"></zl-button>
        <zl-button type="button" name="返回" @click.native="toQuery"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="add" :url="addQueryUrl" ref="isExists">
      <zl-form ref="isExistsForm" :url="url" method="post">
        <zl-panel title="新增字典" :column="2">
          <zl-item type="text" field-name="数据字典类型" name="dictType" required="true"/>
          <zl-item type="text" field-name="数据字典描述" name="dictDesc" required="true"/>
        </zl-panel>
      </zl-form>
      <div class="form-buttons">
        <zl-button type="button" name="查询" @click.native="query"></zl-button>
        <zl-button type="button" name="下一步" @click.native="next"></zl-button>
        <zl-button type="button" name="返回" @click.native="toQuery"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="nextPage" ref="dictNext">
      <zl-query-table ref="dictNextDetail" method="post" :titles="detailTitles" :url="detailUrl">
        <template slot="condition">
          <zl-item type="text" field-name="数据字典类型" name="dictType"/>
          <zl-item type="text" field-name="数据字典描述" name="dictDesc"/>
        </template>
        <zl-button type="button" name="新增" @click.native="addDict"></zl-button>
        <zl-button type="button" name="修改" @click.native="updateDict"></zl-button>
        <zl-button type="button" name="删除" @click.native="delDict"></zl-button>
      </zl-query-table>
      <div class="form-buttons">
        <zl-button type="button" name="返回" @click.native="toAddPage"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="addDict" ref="addDict">
      <zl-form ref="addDictForm" :url="addUrl" :column="2" method="post">
        <zl-panel title="新增字典详情" :column="2" >
          <zl-item type="text" field-name="数据字典类型" name="dictType" :readOnly="true"/>
          <zl-item type="text" field-name="数据字典描述" name="dictDesc" :readOnly="true"/>
          <zl-item type="text" field-name="字典码" name="enName" required="true"/>
          <zl-item type="text" field-name="中文名" name="cnName" required="true"/>
        </zl-panel>
      </zl-form>
      <div class="form-buttons">
        <zl-button type="button" name="保存" @click.native="save"></zl-button>
        <zl-button type="button" name="返回" @click.native="toNextPage"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="updateDict" ref="updateDict">
      <zl-form ref="updateDictForm" :url="updateDictUrl" method="post">
        <zl-panel title="修改字典详情" :column="2" >
          <zl-item type="text" field-name="数据字典类型" name="dictType" :readOnly="true"/>
          <zl-item type="text" field-name="数据字典描述" name="dictDesc" :readOnly="true"/>
          <zl-item type="text" field-name="字典码" name="enName" required="true"/>
          <zl-item type="text" field-name="中文名" name="cnName" required="true"/>
          <zl-item type="text" field-name="数据字典id" name="id" :hidden="true"/>
        </zl-panel>
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
      fields: [
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
      isShow: false
    }
  },
  methods: {
    view () {
      const _this = this
      const table = _this.commonUtil.getComponent(
        this,
        'dict',
        true
      )
      this.viewPage = 'detail'
      const detail = _this.commonUtil.getComponent(
        this,
        'detail', true
      )
      detail.data = table.selData
      const dictDetail = _this.commonUtil.getComponent(
        this,
        'dictDetail', true
      )
      dictDetail.data = []
    },
    add () {
      this.viewPage = 'add'
    },
    del () {
      const _this = this
      const table = _this.commonUtil.getComponent(
        this,
        'dict',
        true
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
      const table = _this.commonUtil.getComponent(
        this,
        'dict', true
      )
      if (JSON.stringify(table.selData) === '{}') {
        alert('请选择一条记录')
        return
      }
      this.viewPage = 'update'
      const update = _this.commonUtil.getComponent(
        this,
        'update', true
      )
      update.data = table.selData
    },
    saveUpdate () {
      const _this = this
      const updateForm = _this.commonUtil.getComponent(
        this,
        'updateForm', true
      )
      // eslint-disable-next-line no-debugger
      debugger
      updateForm.submit(_this.toQuery)
    },
    query () {
      const _this = this
      const isExistsForm = _this.commonUtil.getComponent(
        this,
        'isExistsForm', true
      )
      const reqData = isExistsForm.getReqData()
      this.zlaxios.request({
        url: _this.addQueryUrl,
        method: isExistsForm.method,
        data: reqData,
        success (response) {
          const zero = 0
          if (response.data[zero]) {
            const isExists = _this.commonUtil.getComponent(
              _this,
              'isExists', true
            )
            isExists.data = response.data[zero]
          } else {
            isExistsForm.changeReadOnly(
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
      const isExistsForm = _this.commonUtil.getComponent(
        this,
        'isExistsForm', true
      )
      const checkAll = isExistsForm.checkAll()
      if (checkAll) {
        const reqData = isExistsForm.getReqData()
        this.zlaxios.request({
          url: _this.addQueryUrl,
          method: isExistsForm.method,
          data: reqData,
          success (response) {
            const zero = 0
            if (response.data[zero] && !(reqData.dictType === response.data[zero].dictType && reqData.dictDesc === response.data[zero].dictDesc)) {
              alert('新增的数据字典类型已经存在，但与你录入的数据字典类型与数据字典类型描述不一致, 请重新查询后再进行下一步!')
            } else {
              _this.toNext(reqData)
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
      // this.reqData2 = reqData
      const dictNext = this.commonUtil.getComponent(
        _this,
        'dictNext', true
      )
      dictNext.data = reqData
      const dictNextDetail = this.commonUtil.getComponent(
        _this,
        'dictNextDetail', true
      )
      dictNextDetail.data = []
      _this.viewPage = 'nextPage'
    },
    addDict () {
      const _this = this
      const addDict = this.commonUtil.getComponent(
        _this,
        'addDict', true
      )
      const isExistsForm = _this.commonUtil.getComponent(
        this,
        'isExistsForm', true
      )
      // eslint-disable-next-line no-debugger
      debugger
      addDict.data = isExistsForm.getReqData()
      _this.viewPage = 'addDict'
    },
    save () {
      const _this = this
      const form = _this.commonUtil.getComponent(
        this,
        'addDictForm', true
      )
      form.submit(this.next)
    },
    updateDict: function () {
      const _this = this
      const dictNextDetail = this.commonUtil.getComponent(
        _this,
        'dictNextDetail', true
      )
      const updateDict = this.commonUtil.getComponent(
        _this,
        'updateDict', true
      )
      // eslint-disable-next-line no-debugger
      debugger
      updateDict.data = dictNextDetail.selData
      this.viewPage = 'updateDict'
    },
    saveUpdateDict () {
      const _this = this
      const updateDictForm = this.commonUtil.getComponent(
        _this,
        'updateDictForm',
        true
      )
      updateDictForm.submit(this.next)
    },
    delDict () {
      const _this = this
      const nextPageTable = this.commonUtil.getComponent(
        _this,
        'dictNextDetail', true
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
