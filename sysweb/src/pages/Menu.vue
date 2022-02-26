<template>
  <div>
    <zl-page :viewPage="viewPage" page="query">
      <zl-query-table ref="table" :column="2" re="menu" method="post" :url="url" :fields="fields" :titles="titles">
        <zl-button type="button" name="新增" @click.native="add" oper="add"></zl-button>
        <zl-button type="button" name="修改" @click.native="update"></zl-button>
        <zl-button type="button" name="查看" @click.native="view"></zl-button>
        <zl-button type="button" name="删除" @click.native="delData"></zl-button>
        <zl-button type="button" name="菜单操作配置" @click.native="actionConfig"></zl-button>
      </zl-query-table>
    </zl-page>
    <zl-page :viewPage="viewPage" page="detail" ref="menuDetail">
      <zl-panel title="菜单详情" :column="2" :view="true">
        <zl-item type="text" field-name="菜单编号" name="menuId"/>
        <zl-item type="text" field-name="菜单名" name="menuName"/>
        <zl-item type="text" field-name="父菜单编号" name="parentId"/>
        <zl-item type="text" field-name="菜单路径" name="path"/>
        <zl-item type="text" field-name="菜单文件" name="filePath" :readOnly="true"/>
      </zl-panel>
      <div class="form-buttons">
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="add" ref="addPage">
      <div style="display:block; float:left; width:200px; height: 100%">
        <zl-tree :tree="tree" :sel="sel" branchName="menuName"/>
      </div>
      <div style="width:80%;  float:left;">
        <zl-form ref="addMenu" :column="2" method="post" url="/menu/save">
          <zl-panel title="菜单新增" :column="2">
            <zl-item type="text" field-name="父菜单编号" name="parentId"/>
            <zl-item type="text" field-name="菜单名" name="menuName"/>
            <zl-item type="text" field-name="菜单路径" name="path"/>
            <zl-item type="text" field-name="菜单文件" name="filePath"/>
          </zl-panel>
        </zl-form>
        <div class="form-buttons">
          <zl-button type="button" name="保存" @click.native="save"></zl-button>
          <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
        </div>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="update" ref="updateMenuPage">
      <zl-form ref="updateMenu" method="post" :url="updateUrl">
        <zl-panel title="菜单修改" :column="2">
          <zl-item type="text" field-name="菜单编号" name="menuId" :readOnly="true"/>
          <zl-item type="text" field-name="父菜单编号" name="parentId"/>
          <zl-item type="text" field-name="菜单名" name="menuName"/>
          <zl-item type="text" field-name="菜单路径" name="path"/>
          <zl-item type="text" field-name="菜单文件" name="filePath"/>
        </zl-panel>
      </zl-form>
      <div class="form-buttons">
        <zl-button type="button" name="保存" @click.native="updateData"></zl-button>
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
  </div>
</template>

<script>

export default {
  name: 'Menu',
  data () {
    return {
      fields: [
        {
          type: 'text',
          cnName: '菜单名',
          name: 'menuName'
        },
        {
          type: 'text',
          cnName: '菜单编号',
          name: 'menuId'
        },
        {
          type: 'text',
          cnName: '菜单路径',
          name: 'path'
        }
      ],
      titles: [
        {
          cnName: '菜单编号',
          name: 'menuId'
        },
        {
          cnName: '菜单名',
          name: 'menuName'
        },
        {
          cnName: '菜单路径',
          name: 'path'
        },
        {
          cnName: '菜单文件',
          name: 'filePath'
        },
        {
          cnName: '父菜单编号',
          name: 'parentId'
        }
      ],
      url: `${this.zlService.baseUrl}/menu/select`,
      updateUrl: `${this.zlService.baseUrl}/menu/update`,
      // reqData: {},
      viewPage: 'query',
      sel: {
        data: {}
      },
      tree: {}
    }
  },
  watch: {
    sel: {
      handler (newVal) {
        const _this = this
        const addPage = _this.commonUtil.getComponent(
          this,
          'addPage', true
        )
        addPage.data = newVal.data
      },
      deep: true
    }
  },
  methods: {
    add () {
      this.viewPage = 'add'
      const _this = this
      this.zlaxios.request({
        url: `${_this.zlService.baseUrl}/menu/selectMenu`,
        method: 'POST',
        success (response) {
          _this.tree = response.data[0]
        },
        error (error) {
          alert(error)
        }
      })
    },
    view () {
      const _this = this
      const table = _this.commonUtil.getComponent(
        this,
        'table',
        true
      )
      const reqData = table.selData
      const menuDetail = this.commonUtil.getComponent(
        this,
        'menuDetail',
        true
      )
      this.viewPage = 'detail'
      menuDetail.data = reqData
    },
    update () {
      const table = this.commonUtil.getComponent(
        this,
        'table', true
      )
      const updateMenuPage = this.commonUtil.getComponent(
        this,
        'updateMenuPage',
        true
      )
      this.viewPage = 'update'
      updateMenuPage.data = table.selData
    },
    toBack () {
      this.viewPage = 'query'
    },
    toBackAndQuery () {
      this.viewPage = 'query'
      const table = this.commonUtil.getComponent(
        this,
        'table',
        true
      )
      table.query()
    },
    save () {
      const _this = this
      const form = _this.commonUtil.getComponent(
        this,
        'addMenu'
      )
      const { reqData } = form
      this.zlaxios.request({
        url: this.zlService.baseUrl + form.url,
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
    updateData () {
      const _this = this
      const form = _this.commonUtil.getComponent(
        this,
        'updateMenu', true
      )
      form.submit(this.toBackAndQuery)
    },
    delData () {
      const table = this.commonUtil.getComponent(
        this,
        'table'
      )
      this.zlaxios.request({
        url: `${this.zlService.baseUrl}/menu/delete`,
        method: 'POST',
        config: {
          params: {
            menuId: table.selData.menuId
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
    },
    actionConfig () {
      const table = this.commonUtil.getComponent(
        this,
        'table', true
      )
      const { selData } = table
      console.log(selData)
      if (selData) {
        this.$router.push({
          path: 'Action',
          query: table.selData
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
