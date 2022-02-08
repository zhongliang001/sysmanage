<template>
  <div>
    <zl-page :viewPage="viewPage" page="query">
      <zl-query-table ref="table" :column="2" method="post" :init="true" :req-data="reqData" :fileds="fileds" :url="url"
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
                 :read-only="menuName !== undefined && menuName !== null && menuName !==''"/>
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
        <zl-item type="text" field-name="菜单id" name="menuId"/>
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

export default {
  name: 'Action',
  data () {
    return {
      fileds: [
        {
          type: 'text',
          cnName: '菜单id',
          name: 'menuId'
        },
        {
          type: 'text',
          cnName: '菜单名',
          name: 'menuName'
        },
        {
          type: 'text',
          cnName: '操作名',
          name: 'name'
        },
        {
          type: 'text',
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
      url: `${this.zlService.baseUrl}/action/select`,
      addUrl: `${this.zlService.baseUrl}/action/add`,
      updateUrl: `${this.zlService.baseUrl}/action/update`,
      delUrl: `${this.zlService.baseUrl}/action/delete`,
      detail: {}
    }
  },
  // eslint-disable-next-line max-statements
  created () {
    const _this = this
    const { query } = this.$route
    const addNum = 1
    if (query) {
      const fields = _this.fileds
      for (let len = 0; len < fields.length; len += addNum) {
        const item = fields[len]
        if (item.name !== 'menuId' && item.name !== 'menuName') {
          fields.splice(
            len,
            addNum
          )
          len -= addNum
        }
      }
      Object.keys(query)
        .forEach((key) => {
          const one = 1
          for (let number = 0; number < fields.length; number += one) {
            const filed = fields[number]
            if (filed.name === 'menuId' && key === 'id') {
              _this.menuId = query[key]
              _this.$set(
                filed,
                'defaultValue',
                query[key]
              )
              _this.$set(
                filed,
                'readOnly',
                true
              )
              _this.reqData.menuId = query[key]
            } else if (filed.name === 'menuName' && key === 'name') {
              _this.menuName = query[key]
              _this.$set(
                filed,
                'defaultValue',
                query[key]
              )
              _this.$set(
                filed,
                'readOnly',
                true
              )
              _this.reqData.menuName = query[key]
            }
          }
        })
    }
  },
  methods: {
    add () {
      this.viewPage = 'add'
    },
    save () {
      const _this = this
      const form = _this.common.getComponent(
        this,
        'add'
      )
      const { reqData } = form
      this.zlaxios.request({
        url: this.addUrl,
        method: form.method,
        data: reqData,
        success () {
          form.reset()
          _this.toBack()
        }
      })
    },
    toBack () {
      this.viewPage = 'query'
      const table = this.common.getComponent(
        this,
        'table'
      )
      table.query()
    },
    update () {
      const table = this.common.getComponent(
        this,
        'table'
      )
      const { selData } = table
      if (selData) {
        const updateTable = this.common.getComponent(
          this,
          'updateTable'
        )
        updateTable.setReqData(selData)
        this.viewPage = 'update'
      } else {
        alert('请选择一条记录')
      }
    },
    saveUpData () {
      const _this = this
      const form = this.common.getComponent(
        this,
        'updateTable'
      )
      const { reqData } = form
      this.zlaxios.request({
        url: _this.updateUrl,
        method: form.method,
        data: reqData,
        success () {
          _this.toBack()
        },
        error (error) {
          alert(error)
        }
      })
    },
    viewDetail () {
      const table = this.common.getComponent(
        this,
        'table'
      )
      const { selData } = table
      if (selData) {
        this.detail = selData
        this.viewPage = 'detail'
      } else {
        alert('请选择一条记录')
      }
    },
    delData () {
      const _this = this
      const table = this.common.getComponent(
        this,
        'table'
      )
      const { selData } = table
      if (selData) {
        this.zlaxios.request({
          url: _this.delUrl,
          method: 'POST',
          config: {
            params: {
              id: table.selData.id
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
      } else {
        alert('请选择一条记录')
      }
    }
  }

}
</script>

<style scoped>

</style>
