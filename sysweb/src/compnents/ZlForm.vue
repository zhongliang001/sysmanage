<template>
	<div>
		<form>
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
		props:['column'],
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
					this.check(children)
				}

			},
			check: function (obs) {
				for(let i = 0; i < obs.length; i ++){
					let ob = obs[i]
					if(ob){
						if(ob.validate){
							ob.validate()
						}
						let children = ob.$children
						if(children){
							this.check(children)
						}
					}
				}


			}
		}
	}
</script>

<style>
</style>
