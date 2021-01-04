<template>
	<div>
		<form :action="url" :method="method">
			<zl-f-table :column="column" :reqData="reqData">
				<slot></slot>
			</zl-f-table>
		</form>

	</div>
</template>

<script>
	import ZlFTable from './ZlFTable.vue'
	export default {
		name: 'ZlForm',
		props:['column','url', 'method'],
		components:{ZlFTable},
		data: function(){
			return {
				reqData: {}
			}
		},
		methods:{
			getData: function(name){
				return this.reqData[name]
			},
			setData: function (name,val) {
				this.reqData[name] = val
			},
			checkAll: function () {
				let children = this.$children
				if(children){
					let result = this.check(children)
					console.log(result)
					return result
				}

			},
			check: function (obs) {
				let flag = true
				if(obs.length === 0){
					return flag
				}
				for(let i = 0; i < obs.length; i ++){
					let ob = obs[i]
					if(ob){
						if(ob.validate){
							let result = ob.validate()
							if(!result){
								flag = result
							}
						}
						let children = ob.$children
						if(children){
							let result = this.check(children)
							if(!result){
								flag = result
							}
						}
					}
				}
				return flag

			}
		}
	}
</script>

<style>
</style>
