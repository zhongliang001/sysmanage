<template>
    <div>
        <zl-page :viewPage="viewPage" page="query">
            <zl-query-table ref="table" :column="2" re="menu" method="post" :url="url" :fileds="fileds" :titles="titles">
                <zl-button type="button" name="新增"  @click.native="add"></zl-button>
                <zl-button type="button" name="修改"  @click.native="update"></zl-button>
                <zl-button type="button" name="查看"  @click.native="view"></zl-button>
                <zl-button type="button" name="删除"  @click.native="delData"></zl-button>
            </zl-query-table>
        </zl-page>
        <zl-page :viewPage="viewPage" page="detail">
            <zl-f-table ref="fTable"  :column="2" :req-data="reqData">
                <zl-item type="text" field-name="菜单编号" name="id"/>
                <zl-item type="text" field-name="菜单名"  name="name"/>
                <zl-item type="text" field-name="父菜单编号" name="parentId"/>
                <zl-item type="text" field-name="菜单路径" name="path"/>
                <zl-item type="text" field-name="菜单文件" name="filePath"/>
            </zl-f-table>
            <zl-button type="button" name="返回"  @click.native="toBack"></zl-button>
        </zl-page>
        <zl-page :viewPage="viewPage" page="add">
            <span style="display:block; float:left; width:150px;">
                <zl-tree :tree="tree" :sel="sel"/>
            </span>
            <span style="width:80%;" >
                <zl-form ref="addMenu" :column="2" method="post" url="/menu/save">
                    <zl-item type="text" field-name="父菜单编号" name="parentId"/>
                    <zl-item type="text" field-name="菜单名"  name="name"/>
                    <zl-item type="text" field-name="菜单路径" name="path"/>
                    <zl-item type="text" field-name="菜单文件" name="filePath"/>
                </zl-form>
                 <div style="align-content: center; margin:0 auto;width:300px; ">
                    <zl-button type="button" name="保存"  @click.native="save"></zl-button>
                    <zl-button type="button" name="返回"  @click.native="toBack"></zl-button>
                 </div>
            </span>
        </zl-page>
        <zl-page :viewPage="viewPage" page="update">
            <zl-form ref="updateMenu" :column="2" method="post" url="/menu/update">
                <zl-item type="text" field-name="菜单编号" name="id"/>
                <zl-item type="text" field-name="父菜单编号" name="parentId"/>
                <zl-item type="text" field-name="菜单名"  name="name"/>
                <zl-item type="text" field-name="菜单路径" name="path"/>
                <zl-item type="text" field-name="菜单文件" name="filePath"/>
            </zl-form>
            <div style="align-content: center; margin:0 auto;width:300px; ">
                <zl-button type="button" name="保存"  @click.native="updateData"></zl-button>
                <zl-button type="button" name="返回"  @click.native="toBack"></zl-button>
            </div>
        </zl-page>
    </div>
</template>

<script>
    export default {
        name: "Menu",
        data:function () {
            return {
                fileds:[{
                    type: "text",
                    cnName: "菜单名",
                    name: "name"
                }],
                titles:[
                    {
                        cnName:'菜单编号',
                        name: 'id'
                    },
                    {
                        cnName:'菜单名',
                        name: 'name'
                    },
                    {
                        cnName:'菜单路径',
                        name: 'path'
                    },
                    {
                        cnName:'菜单文件',
                        name: 'filePath'
                    },
                    {
                        cnName: '父菜单编号',
                        name: 'parentId'
                    }
                ],
                url : this.zlService.baseUrl +'/menu/select',
                reqData:{},
                viewPage: 'query',
                sel: {
                  data: {}
                },
                tree: {}
            }
        },
        watch: {
            sel: {
                handler: function (newVal) {
                    let _this = this
                    let addMenu = _this.common.getComponent(this,'addMenu')
                    addMenu.setData('parentId', newVal.data.id)
                },
                deep: true
            }
        },
        methods: {
            add: function () {
                this.viewPage = 'add'
                let _this = this
                this.zlaxios.request({
                    url: _this.zlService.baseUrl + '/menu/selectMenu',
                    method: 'POST',
                    success: function (response) {
                        _this.tree = response.data[0]
                    },
                    error: function (error) {
                        console.log(error)
                    }
                })
            },
            view: function () {
                let _this = this
                let table = _this.common.getComponent(this,'table')
                this.reqData  = table.selData
                this.viewPage = 'detail'
                // fTable.resetData(form.selData)
            },
            update: function(){
                let table = this.common.getComponent(this,'table')
                let updateMenu = this.common.getComponent(this,'updateMenu')
                updateMenu.setReqData(table.selData)
                this.viewPage = 'update'
            },
            toBack: function () {
                this.viewPage = 'query'
            },
            save: function(){
                let _this = this
                let form = _this.common.getComponent(this,'addMenu')
                let reqData = form.reqData
                this.zlaxios.request({
                    url: this.zlService.baseUrl + form.url,
                    method: form.method,
                    data: reqData,
                    success: function (response) {
                        _this.toBack()
                    },
                    error: function (error) {
                        console.log(error)
                    }
                })
            },
            updateData: function () {
                let _this = this
                let form = _this.common.getComponent(this,'updateMenu')
                let reqData = form.reqData
                this.zlaxios.request({
                    url: this.zlService.baseUrl + form.url,
                    method: form.method,
                    data: reqData,
                    success: function (response) {
                        _this.toBack()
                    },
                    error: function (error) {
                        console.log(error)
                    }
                })
            },
            delData: function () {
                let table = this.common.getComponent(this,'table')
                this.zlaxios.request({
                    url: this.zlService.baseUrl + "/menu/delete",
                    method: 'POST',
                    config:{
                        params:{
                            id:table.selData.id
                        }
                    },
                    success: function (response) {
                        alert("删除成功")
                        table.query()
                        table.selNum = -1
                    },
                    error: function (error) {
                        console.log(error)
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>
