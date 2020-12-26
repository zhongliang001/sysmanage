<template>
	<div>
		<h1>{{msg}}</h1>
		<zl-form column="2">
			<zl-item type="type"></zl-item>
			<zl-item type="text"></zl-item>
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
