<template>
    <div>
        <zl-form ref="register" column="1" :method="method" :url="url">
            <zl-item type="text" name="username" field-name="用户名"/>
            <zl-item type="text" name="realName" field-name="真实姓名"/>
            <zl-item type="select" name="certType" field-name="证件类型" dict-name="CERT_TYPE"/>
            <zl-item type="text" name="certNo" field-name="证件号码"/>
            <zl-item type="select" name="sex" field-name="性别" dict-name="SEX"/>
            <zl-item type="text" name="phoneNo" field-name="手机号码"/>
            <zl-item type="password" name="password" field-name="密码"/>
            <zl-item type="password" name="repassword" field-name="再输一次密码"/>
        </zl-form>
        <zl-button type="submit" @click.native="onclick" name="注册"></zl-button>
    </div>

</template>

<script>
    import zlaxios from "./lib/zlaxios";

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
                let reqData = form.reqData
                zlaxios.request({
                    url: _this.url,
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
        }
    }
</script>

<style scoped>

</style>
