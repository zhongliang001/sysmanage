<template>
	<table>
		<tr>
			<td>bi</td>
		</tr>
		<slot></slot>
	</table>
</template>

<script>
	export default{
		name: 'ZlTable',
		props:['tableInfo'],
		data: function(){
			return {
				rows: 0
			}
		},
		mounted: function(){
			let children = this.$children
			for(let i = 0; i< children.length; i++){
				console.log(this.$children[i].type)
			}
			this.$forceUpdate() 
		}
	}
</script>

<style>
</style>
