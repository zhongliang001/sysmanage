<template>
	<div>
		<form>
			<zl-f-table :column="column">
				<slot></slot>
			</zl-f-table>
		</form>
		<button @click="slots">hi</button>
	</div>
</template>

<script>
	import ZlFTable from './ZlFTable.vue'
	export default {
		name: 'ZlForm',
		props:['column'],
		components:{ZlFTable},
		data: function(){
			return {
				tableInfo:{}
			}
		},
		methods:{
			slots: function(){


			}
		}
	}
</script>

<style>
</style>
