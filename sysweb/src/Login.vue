<template>
    <div style="height: 50%; width: 50%; margin:0 auto; top:20%; left: 20%; position: absolute; ">
        <h2>密码登录</h2>
        <zl-form ref="login" :column="1" :method="method" :url="url">
            <zl-item cstclass="user" type="text" field-name="用户名" name="username" required="true"/>
            <zl-item cstclass="password" type="password" field-name="密　码" name="password" required="true"/>
            <zl-item type="text" field-name="授权方式" name="grant_type" default-value="password" hidden="true"/>
        </zl-form>
        <span class="btns">
            <zl-button type="submit"  name="登录" @click.native="onclick"></zl-button>
            <zl-button type="submit"  name="注册" @click.native="onRegister"></zl-button>
        </span>
    </div>
</template>
<script>

    export default {
        name: 'Login',
        data: function () {
            return {
                url: '/oauth/token',
                method: 'post'
            }
        },
        methods:{
            onclick: function () {
                let _this = this
                let form = _this.common.getComponent(this,'login')
                let reqData = form.reqData
                this.zlaxios.request({
                    url: this.zlService.oauthUrl + _this.url,
                    method: _this.method,
                    config:{
                        auth:{
                            username: 'app',
                            password: '123456'
                        },
                        params:reqData
                    },
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

<style scoped>
    h2{
        text-align: center;
    }

    .btns{
        margin-left: 42%;
    }
</style>
