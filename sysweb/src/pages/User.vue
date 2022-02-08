<template>
  <div>
    <zl-page :viewPage="viewPage" page="query">
      <zl-query-table ref="table" method="post" :column="2" :fileds="fileds" :url="url" :titles="titles">
        <zl-button type="button" name="新增" @click.native="add"></zl-button>
        <zl-button type="button" name="修改" @click.native="update"></zl-button>
        <zl-button type="button" name="删除" @click.native="del"></zl-button>
        <zl-button type="button" name="查看" @click.native="view"></zl-button>
        <zl-button type="button" name="配置角色" @click.native="toConfig"></zl-button>
      </zl-query-table>
    </zl-page>
    <zl-page :viewPage="viewPage" page="add">
      <zl-form ref="addTable" :column="2" :url="addUrl" method="post">
        <zl-item type="text" name="username" field-name="用户名" required="true" :rules="rules.username"/>
        <zl-item type="text" name="realName" field-name="真实姓名" required="true" :rules="rules.realName"/>
        <zl-item type="select" name="certType" field-name="证件类型" dict-name="CERT_TYPE" required="true"/>
        <zl-item type="text" name="certNo" field-name="证件号码" required="true"/>
        <zl-item type="select" name="sex" field-name="性别" dict-name="SEX" required="true"/>
        <zl-item type="text" name="phoneNo" field-name="手机号码" required="true"/>
      </zl-form>
      <div class="form-buttons">
        <zl-button type="submit" @click.native="save" name="保存"></zl-button>
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="update">
      <zl-form ref="updateTable" :column="2" :url="updateUrl" method="post">
        <zl-item type="text" name="username" field-name="用户名" required="true" :rules="rules.username" :readOnly="true"/>
        <zl-item type="text" name="realName" field-name="真实姓名" required="true" :rules="rules.realName"/>
        <zl-item type="select" name="certType" field-name="证件类型" dict-name="CERT_TYPE" required="true"/>
        <zl-item type="text" name="certNo" field-name="证件号码" required="true"/>
        <zl-item type="select" name="sex" field-name="性别" dict-name="SEX" required="true"/>
        <zl-item type="text" name="phoneNo" field-name="手机号码" required="true"/>
      </zl-form>
      <div class="form-buttons">
        <zl-button type="submit" @click.native="saveUpdate" name="保存"></zl-button>
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="view">
      <zl-f-table ref="fTable" view="true" :column="2" :req-data="reqData">
        <zl-item type="text" name="username" field-name="用户名"/>
        <zl-item type="text" name="realName" field-name="真实姓名"/>
        <zl-item type="select" name="certType" field-name="证件类型" dict-name="CERT_TYPE"/>
        <zl-item type="text" name="certNo" field-name="证件号码"/>
        <zl-item type="select" name="sex" field-name="性别" dict-name="SEX"/>
        <zl-item type="text" name="phoneNo" field-name="手机号码"/>
      </zl-f-table>
      <div class="form-buttons">
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="config">
      <zl-form ref="configTable" :column="2" :url="updateUrl" method="post">
        <zl-item type="text" name="id" field-name="用户id" hidden="true"></zl-item>
        <zl-choose slot="choose" :chooesedData="chooesedData" :unchooesedData="unchooesedData"></zl-choose>
      </zl-form>
      <div class="clear form-buttons">
        <zl-button type="button" name="保存" @click.native="configRole"></zl-button>
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
  </div>
</template>

<script>
export default {
  name: 'User',
  data () {
    return {
      viewPage: 'query',
      fileds: [
        {
          type: 'text',
          cnName: '用户id',
          name: 'id'
        },
        {
          type: 'text',
          cnName: '用户名',
          name: 'username'
        },
        {
          type: 'select',
          cnName: '证件类型',
          name: 'certType',
          dictName: 'CERT_TYPE'
        },
        {
          type: 'text',
          cnName: '证件号码',
          name: 'certNo'
        }
      ],
      titles: [
        {
          cnName: '用户id',
          name: 'id'
        },
        {
          cnName: '用户名',
          name: 'username'
        },
        {
          type: 'select',
          cnName: '证件类型',
          name: 'certType',
          dictName: 'CERT_TYPE'
        },
        {
          cnName: '证件号码',
          name: 'certNo'
        }
      ],
      rules: {
        username: {
          ruleName: ['isRequired']
        },
        realName: {
          ruleName: ['isRequired']
        }
      },
      url: `${this.zlService.baseUrl}/user/select`,
      addUrl: `${this.zlService.baseUrl}/user/add`,
      updateUrl: `${this.zlService.baseUrl}/user/update`,
      deleteUrl: `${this.zlService.baseUrl}/user/delete`,
      chooseUrl: `${this.zlService.baseUrl}/role/queryRoleForChoose`,
      configUrl: `${this.zlService.baseUrl}/userrole/config`,
      reqData: {},
      unchooesedData: [],
      chooesedData: []
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
        'addTable'
      )
      if (form.checkAll()) {
        const { reqData } = form
        this.zlaxios.request({
          url: _this.addUrl,
          method: form.method,
          data: reqData,
          success () {
            _this.toBack()
          },
          error (error) {
            alert(error)
          }
        })
      }
    },
    update () {
      const _this = this
      const table = _this.common.getComponent(
        this,
        'table'
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
      const form = _this.common.getComponent(
        this,
        'updateTable'
      )
      if (form.checkAll()) {
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
      }
    },
    del () {
      const _this = this
      const table = _this.common.getComponent(
        this,
        'table'
      )
      if (JSON.stringify(table.selData) === '{}') {
        alert('请选择一条记录')
        return
      }
      const sel = table.selData
      this.zlaxios.request({
        url: _this.deleteUrl,
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
    },
    view () {
      const _this = this
      const table = _this.common.getComponent(
        this,
        'table'
      )
      this.reqData = table.selData
      this.viewPage = 'view'
    },
    toBack () {
      this.viewPage = 'query'
      const _this = this
      const table = _this.common.getComponent(
        this,
        'table'
      )
      table.query()
      table.selNum = -1
    },
    toConfig () {
      const _this = this
      const table = _this.common.getComponent(
        this,
        'table'
      )
      this.reqData = table.selData
      if (JSON.stringify(table.selData) === '{}') {
        alert('请选择一条记录')
        return
      }
      const configTable = _this.common.getComponent(
        this,
        'configTable'
      )
      configTable.setReqData(table.selData)
      const sel = table.selData
      this.viewPage = 'config'
      this.zlaxios.request({
        url: _this.chooseUrl,
        method: 'POST',
        config: {
          params: {
            userId: sel.id
          }
        },
        success (response) {
          _this.chooesedData = response.data.chooesedData
          _this.unchooesedData = response.data.unchooesedData
        },
        error (error) {
          alert(error)
        }
      })
    },
    configRole () {
      const _this = this
      const form = _this.common.getComponent(
        this,
        'configTable'
      )
      const { reqData } = form
      reqData.list = this.chooesedData
      this.zlaxios.request({
        url: _this.configUrl,
        method: 'POST',
        data: reqData,
        success () {
          alert('新增成功')
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
