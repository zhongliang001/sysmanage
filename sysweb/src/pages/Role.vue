<template>
  <div>
    <zl-page :viewPage="viewPage" page="query">
      <zl-query-table ref="table" method="post" :column="2" :fields="fields" :url="url" :titles="titles">
        <zl-button type="button" name="新增" @click.native="add"></zl-button>
        <zl-button type="button" name="修改" @click.native="update"></zl-button>
        <zl-button type="button" name="删除" @click.native="del"></zl-button>
        <zl-button type="button" name="查看" @click.native="view"></zl-button>
        <zl-button type="button" name="角色权限配置" @click.native="right"></zl-button>
      </zl-query-table>
    </zl-page>
    <zl-page :viewPage="viewPage" page="add" ref="addPage">
      <zl-form ref="addForm" :url="addUrl" method="post">
        <zl-panel title="新增角色" :column="2">
          <zl-item type="text" field-name="角色名" name="name" :rules="rules.name"/>
          <zl-item type="text" field-name="角色描述" name="remark"/>
        </zl-panel>
        /
      </zl-form>
      <div class="form-buttons">
        <zl-button type="button" name="保存" @click.native="save"></zl-button>
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="update" ref="updatePage">
      <zl-form ref="updateForm" :column="2" method="post" :url="updateUrl">
        <zl-panel title="修改角色" :column="2">
          <zl-item type="text" field-name="角色id" name="id" :readOnly="true"/>
          <zl-item type="text" field-name="角色名" name="name" :rules="rules.name"/>
          <zl-item type="text" field-name="角色描述" name="remark"/>
        </zl-panel>
      </zl-form>
      <div class="form-buttons">
        <zl-button type="button" name="保存" @click.native="saveUpdate"></zl-button>
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="view" ref="detailPage">
      <zl-f-table ref="fTable" :column="2">
        <zl-item type="text" field-name="角色id" name="id"/>
        <zl-item type="text" field-name="角色名" name="name"/>
        <zl-item type="text" field-name="角色描述" name="remark"/>
      </zl-f-table>
      <div class="form-buttons">
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="right" ref="roleRight">
      <zl-panel title="角色权限配置" :column="2" :view="true">
        <zl-query-table ref="menuTable" :column="2" re="menu" method="post" :url="rightUrl" :pagination="false"
                        :titles="rightTitles">
          <template slot="condition">
            <zl-item type="text" field-name="角色id" name="id" :readOnly="true"/>
            <zl-item type="text" field-name="角色名" name="name" :readOnly="true"/>
          </template>
        </zl-query-table>
      </zl-panel>
      <div class="form-buttons">
        <zl-button type="button" name="保存" @click.native="saveRight"></zl-button>
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>

    </zl-page>
  </div>
</template>

<script>
export default {
  name: 'Role',
  data () {
    return {
      viewPage: 'query',
      fields: [
        {
          type: 'text',
          cnName: '角色id',
          name: 'id'
        },
        {
          type: 'text',
          cnName: '角色名',
          name: 'name'
        }
      ],
      rules: {
        name: {
          ruleName: ['isRequired']
        }
      },
      titles: [
        {
          cnName: '角色id',
          name: 'id'
        },
        {
          cnName: '角色名',
          name: 'name'
        },
        {
          cnName: '角色描述',
          name: 'remark'
        }
      ],
      rightTitles: [
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
        },
        {
          cnName: '操作',
          name: 'actionDtos',
          type: 'checkbox',
          checkCnName: 'name',
          checkName: 'menuId',
          value: 'oper',
          checkFlag: 'hasRight'
        }
      ],
      url: `${this.zlService.baseUrl}/role/select`,
      addUrl: `${this.zlService.baseUrl}/role/add`,
      updateUrl: `${this.zlService.baseUrl}/role/update`,
      delUrl: `${this.zlService.baseUrl}/role/delete`,
      rightUrl: `${this.zlService.baseUrl}/menu/selectByRole`,
      addRightUrl: `${this.zlService.baseUrl}/roleright/addRoleRight`
    }
  },
  methods: {
    add () {
      this.viewPage = 'add'
    },
    update () {
      const table = this.commonUtil.getComponent(
        this,
        'table', true
      )
      const updatePage = this.commonUtil.getComponent(
        this,
        'updatePage', true
      )
      this.viewPage = 'update'
      updatePage.data = table.selData
    },
    del () {
      const _this = this
      const table = _this.commonUtil.getComponent(
        this,
        'table'
      )
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
      const _this = this
      const table = _this.commonUtil.getComponent(
        this,
        'table', true
      )
      const detailPage = _this.commonUtil.getComponent(this, 'detailPage', true)
      if (JSON.stringify(table.selData) === '{}') {
        this.viewPage = 'view'
        detailPage.data = table.selData
      } else {
        alert('请选择一条记录')
      }
    },
    save () {
      const _this = this
      const form = _this.commonUtil.getComponent(
        this,
        'addForm', true
      )
      form.submit(_this.toBack)
    },
    saveUpdate () {
      const _this = this
      const form = _this.commonUtil.getComponent(
        this,
        'updateForm', true
      )
      form.submit(_this.toBack)
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
    },
    right () {
      const table = this.commonUtil.getComponent(
        this,
        'table', true
      )
      const menuTable = this.commonUtil.getComponent(
        this,
        'menuTable', true
      )
      const roleRight = this.commonUtil.getComponent(this, 'roleRight', true)
      this.viewPage = 'right'
      roleRight.data = table.selData
      menuTable.query(table.selData)
    },
    saveRight () {
      const menuTable = this.commonUtil.getComponent(
        this,
        'menuTable', true
      )
      const qTable = this.commonUtil.getComponent(
        menuTable,
        'qTable', true
      )
      const _this = this
      this.zlaxios.request({
        url: _this.addRightUrl,
        method: 'post',
        data: {
          menuRightDtos: menuTable.data,
          roleId: qTable.getReqData().id
        },
        success () {
          _this.toBack()
        },
        error (error) {
          alert(error)
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
