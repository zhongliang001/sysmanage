<template>
    <div>
        <h1>登录</h1>
        <zl-form ref="login" column="1" :method="method" :url="url">
            <zl-item type="text" field-name="用户名" name="username"/>
            <zl-item type="password" field-name="密码" name="password"/>
        </zl-form>
        <zl-button type="submit"  name="登录" @click.native="onclick"></zl-button>
        <zl-button type="submit"  name="注册" @click.native="onRegister"></zl-button>

    </div>
</template>
<script>

    export default {
        name: 'Login',
        data: function () {
            return {
                url: '/suser/login',
                method: 'post'
            }
        },
        methods:{
            onclick: function () {
                let _this = this
                let form = _this.common.getForm(this,'login')
                let reqData = form.reqData
                this.zlaxios.request({
                    url: this.zlService.baseUrl + _this.url,
                    data: reqData,
                    method: _this.method,
                    success: function (response) {
                        _this.$router.push({name:"Welcome"})
                    },
                    error: function (error) {
                        console.log(error)
                    }
                })
            },
            onRegister: function () {
                this.$router.push({name:"Register"})
            }
        }
    }
</script>
