<template>
	<table>
		<tr v-for="i in rows">
			<zl-td v-for="(field, index) in fields[i - 1]" :key="index" :field="field" :reqData="reqData"/>
		</tr>
		<slot></slot>
	</table>
</template>

<script>
	import ZlTd from "./ZlTd.vue";
	export default{
		name: 'ZlTable',
		props:['column','reqData'],
		components: {ZlTd},
		data: function(){
			return {
				rows: 0,
				fields:[]
			}
		},
		mounted: function(){
			let children = this.$children
			if(!children){
				return
			}
			this.rows = Math.ceil(children.length / this.column)
			let i = 0
			for(let j = 0; j < this.rows; j ++){
				let n= 0
				for(; i< children.length; i++, n++){
					if(this.fields[j] === undefined){
						this.fields[j] =[]
					}
					let field ={}
					field.fieldName = this.$children[i].fieldName + ':'
					this.fields[j][n] = field
					n++
					let field2 ={}
					field2 = this.$children[i]
					this.fields[j][n] = field2
					if((i+1) % this.column === 0){
						i ++
						break
					}
				}
			}
			this.$forceUpdate()
		}
	}
</script>

<style>
</style>
