<template>
	<div>
		<zl-form ref="test" column="2" method="post" url="sub.do">
			<zl-item type="select" fieldName="t1" name="test1" required="true" dict-name="sex"/>
			<zl-item type="textarea" fieldName="t2" name="test2"/>
			<zl-item type="text" fieldName="t3" name="test3"/>
			<zl-item type="text" fieldName="t4" name="test4"/>
			<zl-item type="text" fieldName="t5" name="test5"/>
			<zl-item type="text" fieldName="t6" dataType="Number" name="test6" defaultValue="6"/>
		</zl-form>
		<button @click="submit">submit</button>
	</div>
</template>

<script>
	import ZlForm from './compnents/ZlForm.vue'
	import ZlItem from './compnents/ZlItem.vue'
	export default {
		name: 'App',
		components:{ZlForm,ZlItem},
		data: function(){
			return {
				msg: 'hi'
			}
		},
		methods:{
			submit: function () {
				let form = this.common.getForm(this,'test')
				let reqData = form.reqData
				this.$children[0].checkAll()
				this.zlaxios.request(this.url)
			}
		}
	}
</script>

<style>
</style>
