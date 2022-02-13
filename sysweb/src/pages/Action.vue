<template>
  <div>
    <zl-page :viewPage="viewPage" page="query" ref="queryPage">
      <zl-query-table ref="table" :column="2" method="post" :init="true" :req-data="reqData" :fields="fields" :url="url"
                      :titles="titles">
        <zl-button type="button" name="新增" @click.native="add"></zl-button>
        <zl-button type="button" name="修改" @click.native="update"></zl-button>
        <zl-button type="button" name="查看" @click.native="viewDetail"></zl-button>
        <zl-button type="button" name="删除" @click.native="delData"></zl-button>
      </zl-query-table>
    </zl-page>
    <zl-page :view-page="viewPage" page="add" ref="addPage">
      <zl-form ref="add" :url="addUrl" :column="2" method="post">
        <zl-item type="text" field-name="菜单id" name="menuId" :default-value="query.menuId"
                 :read-only="query.menuId !== undefined&& query.menuId !== null && menuId !==''"/>
        <zl-item type="text" field-name="菜单名" name="menuName" :default-value="query.menuName"
                 :read-only="query.menuName !== undefined && query.menuName !== null && query.menuName !==''"/>
        <zl-item type="text" field-name="操作名" name="name"/>
        <zl-item type="text" field-name="操作" name="oper"/>
      </zl-form>
      <div class="form-buttons">
        <zl-button type="button" name="保存" @click.native="save"/>
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
    <zl-page :view-page="viewPage" page="update" ref="updatePage">
      <zl-form ref="updateTable" :url="updateUrl" method="post">
        <zl-panel title="操作修改" :column="2">
        <zl-item type="text" field-name="菜单名" name="menuName"
                 :read-only="true"/>
        <zl-item type="text" field-name="菜单id" name="menuId"
                 :read-only="true"/>
        <zl-item type="text" field-name="操作名" name="name"/>
        <zl-item type="text" field-name="操作" name="oper"/>
        <zl-item type="text" field-name="操作id" name="id" hidden="true"/>
        </zl-panel>
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
      fields: [
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
          name: 'actionName'
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
      detail: {},
      query: {}
    }
  },
  mounted: function () {
    const { query } = this.$route
    const _this = this
    this.$nextTick(() => {
      const queryPage = _this.commonUtil.getComponent(_this, 'queryPage', true)
      queryPage.data = query
      _this.query = query
    })
  },
  methods: {
    add () {
      this.viewPage = 'add'
    },
    save () {
      const _this = this
      const form = _this.commonUtil.getComponent(
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
      const table = this.commonUtil.getComponent(
        this,
        'table'
      )
      table.query()
    },
    update () {
      const table = this.commonUtil.getComponent(
        this,
        'table', true
      )
      const { selData } = table
      if (selData) {
        const updatePage = this.commonUtil.getComponent(
          this,
          'updatePage', true
        )
        updatePage.data = selData
        this.viewPage = 'update'
      } else {
        alert('请选择一条记录')
      }
    },
    saveUpData () {
      const updateTable = this.commonUtil.getComponent(
        this,
        'updateTable', true
      )
      updateTable.submit(this.toBack)
    },
    viewDetail () {
      const table = this.commonUtil.getComponent(
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
      const table = this.commonUtil.getComponent(
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
