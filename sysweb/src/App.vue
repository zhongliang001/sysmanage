<template>
	<div>
		<h1>{{msg}}</h1>
		<zl-form column="2">
			<zl-item type="password" fieldName="t1" name="test1"></zl-item>
			<zl-item type="text" fieldName="t2" name="test2"></zl-item>
			<zl-item type="password" fieldName="t3" name="test3"></zl-item>
			<zl-item type="text" fieldName="t4" name="test4"></zl-item>
			<zl-item type="password" fieldName="t5"  name="test5"></zl-item>
			<zl-item type="text" fieldName="t6" dataType="Number"  name="test6"></zl-item>
		</zl-form>
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
		}
	}
</script>

<style>
</style>
