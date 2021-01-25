<template>
    <div>
        <zl-form ref="register" column="1" :method="method" :url="url" :validate="validate">
            <zl-item type="text" name="username" field-name="用户名" required="true"/>
            <zl-item type="text" name="realName" field-name="真实姓名" required="true"/>
            <zl-item type="select" name="certType" field-name="证件类型" dict-name="CERT_TYPE" required="true"/>
            <zl-item type="text" name="certNo" field-name="证件号码" required="true"/>
            <zl-item type="select" name="sex" field-name="性别" dict-name="SEX" required="true"/>
            <zl-item type="text" name="phoneNo" field-name="手机号码" required="true"/>
            <zl-item type="password" name="password" field-name="密码" required="true"/>
            <zl-item type="password" name="repassword" field-name="再输一次密码" required="true"/>
        </zl-form>
        <zl-button type="submit" @click.native="onclick" name="注册"></zl-button>
    </div>

</template>

<script>

    export default {
        name: "Register",
        data: function () {
            return {
                url: '/suser/register',
                method: 'post'
            }
        },
        methods:{
            onclick: function () {
                let _this = this
                let form = _this.common.getForm(this,'register')
                if(form.checkAll()){
                    let reqData = form.reqData
                    this.zlaxios.request({
                        url: _this.zlService.baseUrl + _this.url,
                        data: reqData,
                        method: _this.method,
                        success: function (response) {
                            alert(response.msg)
                        },
                        error: function (error) {
                            alert(error.msg)
                        }
                    })
                }
            },
            validate: function () {
                let form = this.common.getForm(this,'register')
                let reqData = form.reqData
                let password = reqData.password
                let repassword = reqData.repassword
                if(password !== repassword){
                    alert('两次输入的密码不一样')
                    return false
                }else{
                    return true
                }
            }
        }
    }
</script>

<style scoped>

</style>
