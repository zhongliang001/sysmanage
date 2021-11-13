<template>
  <div class="card m-auto login-form col-lg-4 col-lg-offset-4  col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2" style="width: 27%">
    <h4 class="card-title text-center bg-primary">
      密码登录
    </h4>
    <div class="card-body ">
      <zl-form custom-class="form-horizontal" ref="login" :column="1" :method="method" :url="url">
        <zl-item type="text" field-name="用户名" name="username" :rules="rules.username"/>
        <zl-item type="password" field-name="密　码" name="password" :rules="rules.password"/>
        <zl-item type="text" field-name="授权方式" name="grant_type" default-value="password" hidden="true"/>
      </zl-form>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
            <zl-button custom-class="me-md-2" type="submit" name="登录"
                       @click.native="onclick"></zl-button>
            <zl-button type="submit" name="注册"
                       @click.native="onRegister"></zl-button>
        </div>
    </div>
  </div>
</template>
<script>

export default {
  name: 'Login',
  data: function () {
    return {
      url: '/oauth/token',
      method: 'post',
      rules:{
        username: {
          ruleName: ['isRequired']
        },
        password:{
          ruleName:  ['isRequired']
        }
      }
    }
  },
  methods: {
    onclick: function () {
      let _this = this
      debugger
      let form = _this.common.getComponent(this, 'login')
      if(form.checkAll()) {
        let reqData = form.reqData
        this.zlaxios.request({
          url: this.zlService.oauthUrl + _this.url,
          method: _this.method,
          config: {
            auth: {
              username: 'app',
              password: '123456'
            },
            params: reqData
          },
          success: function () {
            _this.$router.push({name: "Welcome"})
          },
          failed: function (error) {
            alert(error.response.data.error_description)
          }
        })
      }
    },
    onRegister: function () {
      this.$router.push({name: "Register"})
    }
  }
}
</script>

<style scoped>
.login-form {
  position: absolute;
  top: 50%;
  -webkit-transform: translateY(-50%);
  -moz-transform: translateY(-50%);
  -ms-transform: translateY(-50%);
  -o-transform: translateY(-50%);
  transform: translateY(-50%);
  min-height: 300px;
  height: auto;
  left: 33%;
}
</style>
