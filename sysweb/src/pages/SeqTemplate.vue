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
    <zl-page :viewPage="viewPage" page="add" ref="addPage">
      <zl-form ref="addForm" method="post" :url="addUrl">
        <zl-panel title="新增流水号模板" :column="2">
          <zl-item type="text" name="name" field-name="模板名" />
          <zl-item type="text" name="temp" field-name="模板" />
        </zl-panel>
      </zl-form>
      <div class="form-buttons">
        <zl-button type="button" name="保存" @click.native="save"></zl-button>
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="update" ref="updatePage">
      <zl-form ref="updateForm" method="post" :url="updateUrl">
        <zl-panel title="修改流水号模板" :column="2">
          <zl-item type="text" name="id" field-name="模板id" :read-only="true" />
          <zl-item type="text" name="name" field-name="模板名" />
          <zl-item type="text" name="temp" field-name="模板" />
        </zl-panel>
      </zl-form>
      <div class="form-buttons">
        <zl-button type="button" name="保存" @click.native="saveUpdate"></zl-button>
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="view" ref="detailPage">
      <zl-f-table ref="fTable" :column="2" :view="true">
        <zl-item type="text" name="id" field-name="模板id" />
        <zl-item type="text" name="name" field-name="模板名" />
        <zl-item type="text" name="temp" field-name="模板" />
      </zl-f-table>
      <div class="form-buttons">
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
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
      url: `${this.zlService.seqUrl}/template/select`,
      addUrl: `${this.zlService.seqUrl}/template/add`,
      updateUrl: `${this.zlService.seqUrl}/template/update`,
      delUrl: `${this.zlService.seqUrl}/template/delete`
    }
  },
  methods: {
    add () {
      this.viewPage = 'add'
    },
    save () {
      const form = this.commonUtil.getComponent(this, 'addForm', true)
      form.submit(this.toBack)
    },
    update () {
      const table = this.commonUtil.getComponent(this, 'table', this)
      const page = this.commonUtil.getComponent(this, 'updatePage', true)
      page.data = table.selData
      this.viewPage = 'update'
    },
    saveUpdate () {
      const form = this.commonUtil.getComponent(this, 'updateForm', true)
      form.submit(this.toBack)
    },
    del () {
      const _this = this
      const table = this.commonUtil.getComponent(this, 'table', true)
      const sel = table.selData
      if (sel) {
        this.zlaxios.request({
          url: _this.delUrl,
          method: 'POST',
          config: {
            params: {
              id: sel.id
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
    view () {
      const table = this.commonUtil.getComponent(this, 'table', this)
      const page = this.commonUtil.getComponent(this, 'detailPage', true)
      page.data = table.selData
      this.viewPage = 'view'
    },
    toBack () {
      this.viewPage = 'query'
      const _this = this
      const table = _this.commonUtil.getComponent(
        this,
        'table', true
      )
      table.query()
      table.selNum = -1
    }
  }
}
</script>

<style scoped>

</style>
