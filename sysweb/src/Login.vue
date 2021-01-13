<template>
    <div>
        <h1>登录</h1>
        <zl-form column="1" :method="method" :url="url">
            <zl-item type="text" fieldName="用户名" name="username"/>
            <zl-item type="password" fieldName="密码" name="password"/>
        </zl-form>
        <zl-button type="submit" @click.native="onclick"></zl-button>
    </div>
</template>
<script>
    export default {
        name: 'Login',
        data: function () {
            return {
                url: '/sdict/sdictTree',
                method: 'post'
            }
        },
        methods:{
            onclick: function () {
                alert("b")
            }
        }
    }
</script>
