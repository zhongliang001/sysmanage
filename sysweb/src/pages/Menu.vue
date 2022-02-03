<template>
  <div>
    <zl-page :viewPage="viewPage" page="query">
      <zl-query-table ref="table" :column="2" re="menu" method="post" :url="url" :fileds="fileds" :titles="titles">
        <zl-button type="button" name="新增" @click.native="add" oper="add"></zl-button>
        <zl-button type="button" name="修改" @click.native="update"></zl-button>
        <zl-button type="button" name="查看" @click.native="view"></zl-button>
        <zl-button type="button" name="删除" @click.native="delData"></zl-button>
        <zl-button type="button" name="菜单操作配置" @click.native="actionConfig"></zl-button>
      </zl-query-table>
    </zl-page>
    <zl-page :viewPage="viewPage" page="detail">
      <zl-f-table ref="fTable" :column="2" :req-data="reqData">
        <zl-item type="text" field-name="菜单编号" name="id"/>
        <zl-item type="text" field-name="菜单名" name="name"/>
        <zl-item type="text" field-name="父菜单编号" name="parentId"/>
        <zl-item type="text" field-name="菜单路径" name="path"/>
        <zl-item type="text" field-name="菜单文件" name="filePath"/>
      </zl-f-table>
      <div class="form-buttons">
        <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="add">
      <div style="display:block; float:left; width:200px; height: 100%">
        <zl-tree :tree="tree" :sel="sel"/>
      </div>
      <div style="width:80%;  float:left;">
        <zl-form ref="addMenu" :column="2" method="post" url="/menu/save">
          <zl-item type="text" field-name="父菜单编号" name="parentId"/>
          <zl-item type="text" field-name="菜单名" name="name"/>
          <zl-item type="text" field-name="菜单路径" name="path"/>
          <zl-item type="text" field-name="菜单文件" name="filePath"/>
        </zl-form>
        <div class="form-buttons">
          <zl-button type="button" name="保存" @click.native="save"></zl-button>
          <zl-button type="button" name="返回" @click.native="toBack"></zl-button>
        </div>
      </div>
    </zl-page>
    <zl-page :viewPage="viewPage" page="update">
      <zl-form ref="updateMenu" :column="2" method="post" url="/menu/update">
        <zl-item type="text" field-name="菜单编号" name="id" :readOnly="true"/>
        <zl-item type="text" field-name="父菜单编号" name="parentId"/>
        <zl-item type="text" field-name="菜单名" name="name"/>
        <zl-item type="text" field-name="菜单路径" name="path"/>
        <zl-item type="text" field-name="菜单文件" name="filePath"/>
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
  name: "Menu",
  data () {
    return {
      fileds: [
        {
          type: "text",
          cnName: "菜单名",
          name: "name"
        },
        {
          type: "text",
          cnName: "菜单编号",
          name: "id"
        },
        {
          type: "text",
          cnName: "菜单路径",
          name: "path"
        }
      ],
      titles: [
        {
          cnName: "菜单编号",
          name: "id"
        },
        {
          cnName: "菜单名",
          name: "name"
        },
        {
          cnName: "菜单路径",
          name: "path"
        },
        {
          cnName: "菜单文件",
          name: "filePath"
        },
        {
          cnName: "父菜单编号",
          name: "parentId"
        }
      ],
      url: `${this.zlService.baseUrl}/menu/select`,
      reqData: {},
      viewPage: "query",
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
        const addMenu = _this.common.getComponent(
          this,
          "addMenu"
        )
        addMenu.setData(
          "parentId",
          newVal.data.id
        )
      },
      deep: true
    }
  },
  methods: {
    add () {
      this.viewPage = "add"
      const _this = this
      this.zlaxios.request({
        url: `${_this.zlService.baseUrl}/menu/selectMenu`,
        method: "POST",
        success (response) {
          const zero = 0
          _this.tree = response.data[zero]
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
        "table"
      )
      this.reqData = table.selData
      this.viewPage = "detail"
      // FTable.resetData(form.selData)
    },
    update () {
      const table = this.common.getComponent(
        this,
        "table"
      )
      const updateMenu = this.common.getComponent(
        this,
        "updateMenu"
      )
      updateMenu.setReqData(table.selData)
      this.viewPage = "update"
    },
    toBack () {
      this.viewPage = "query"
    },
    save () {
      const _this = this
      const form = _this.common.getComponent(
        this,
        "addMenu"
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
      const form = _this.common.getComponent(
        this,
        "updateMenu"
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
    delData () {
      const table = this.common.getComponent(
        this,
        "table"
      )
      this.zlaxios.request({
        url: `${this.zlService.baseUrl}/menu/delete`,
        method: "POST",
        config: {
          params: {
            id: table.selData.id
          }
        },
        success () {
          alert("删除成功")
          table.query()
          table.selNum = -1
        },
        error (error) {
          alert(error)
        }
      })
    },
    actionConfig () {
      const table = this.common.getComponent(
        this,
        "table"
      )
      const { selData } = table
      if (selData) {
        this.$router.push({
          path: "Action",
          query: table.selData
        })
      } else {
        alert("请选择一条记录")
      }
    }
  }
}
</script>

<style scoped>

</style>
