<template>
  <div class="card m-auto login-form col-lg-4 col-lg-offset-4  col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2" style="width: 27%">
    <h4 class="card-title text-center bg-primary">
      注册
    </h4>
        <zl-form ref="register" :column="1" :method="method" :url="url" :validate="validate">
            <zl-item type="text" name="username" field-name="用户名" required="true" :rules="rules.username"/>
            <zl-item type="text" name="realName" field-name="真实姓名" required="true" :rules="rules.realName"/>
            <zl-item type="select" name="certType" field-name="证件类型" dict-name="CERT_TYPE" required="true"/>
            <zl-item type="text" name="certNo" field-name="证件号码" required="true"/>
            <zl-item type="select" name="sex" field-name="性别" dict-name="SEX" required="true"/>
            <zl-item type="text" name="phoneNo" field-name="手机号码" required="true"/>
            <zl-item type="password" name="password" field-name="密码" required="true"/>
            <zl-item type="password" name="repassword" field-name="再输一次密码" required="true"/>
        </zl-form>
    <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <zl-button  type="submit" @click.native="onclick" name="注册"></zl-button>
        <zl-button type="submit" name="登录" @click.native="onLogin"></zl-button>
    </div>
    </div>

</template>

<script>

    export default {
        name: "Register",
        data: function () {
            return {
                url: '/user/register',
                method: 'post',
                rules:{
                  username: {
                    ruleName: ['isRequired']
                  },
                  realName:{
                    ruleName:  ['isRequired']
                  }
                }
            }
        },
        methods:{
            onclick: function () {
                let _this = this
                let form = _this.common.getComponent(this,'register')
                if(form.checkAll()){
                    let reqData = form.reqData
                    this.zlaxios.request({
                        url: _this.zlService.baseUrl + _this.url,
                        data: reqData,
                        method: _this.method,
                        success: function (response) {
                            alert(response.msg)
                        },
                        failed: function (error) {
                            alert(error.msg)
                        }
                    })
                }
            },
            validate: function () {
                let form = this.common.getComponent(this,'register')
                let reqData = form.reqData
                let password = reqData.password
                let repassword = reqData.repassword
                if(password !== repassword){
                    alert('两次输入的密码不一样')
                    return false
                }else{
                    return true
                }
            },
            onLogin: function (){
              this.$router.push({name: "Login"})
            }
        }
    }
</script>

<style scoped>

</style>
