<template>
  <div class="login-form">
    <div class="login-container">
      <div class="card-title">
        <h4 class="title">
          密码登录
        </h4>
        <zl-form custom-class="form-horizontal" ref="login"  :method="method" :url="url">
          <zl-panel :column="1">
            <zl-item type="text" field-name="用户名" name="username" :rules="rules.username"/>
            <zl-item type="password" field-name="密 码" name="password" :rules="rules.password"/>
            <zl-item type="text" field-name="授权方式" name="grant_type" default-value="password" :hidden="true"/>
          </zl-panel>
        </zl-form>
        <div >
          <zl-button type="submit" name="登录"
                     @click.native="onclick"></zl-button>
          <zl-button type="submit" name="注册"
                     @click.native="onRegister"></zl-button>
        </div>
      </div>
      <div class="card-body ">

      </div>
    </div>
  </div>
</template>
<script>

export default {
  name: 'Login',
  data () {
    return {
      url: '/oauth/token',
      method: 'post',
      rules: {
        username: {
          ruleName: ['isRequired']
        },
        password: {
          ruleName: ['isRequired']
        }
      }
    }
  },
  methods: {
    onclick () {
      const _this = this
      const form = _this.commonUtil.getComponent(
        this,
        'login',
        true
      )
      if (form.checkAll()) {
        const reqData = form.getReqData()
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
          success () {
            _this.$router.push({ name: 'Welcome' })
          },
          failed (error) {
            alert(error.response.data.error_description)
          }
        })
      }
    },
    onRegister () {
      this.$router.push({ name: 'Register' })
    }
  }
}
</script>

<style scoped>
/*.login-form {*/
/*  position: absolute;*/
/*  top: 50%;*/
/*  -webkit-transform: translateY(-50%);*/
/*  -moz-transform: translateY(-50%);*/
/*  -ms-transform: translateY(-50%);*/
/*  -o-transform: translateY(-50%);*/
/*  transform: translateY(-50%);*/
/*  min-height: 300px;*/
/*  height: auto;*/
/*  left: 33%;*/
/*}*/

</style>
