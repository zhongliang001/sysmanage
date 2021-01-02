<template>
</template>

<script>
	export default{
		name: 'ZlItem',
		props:{
			type:{
				type: String
			},
            fieldName:{
			    type: String
            },
            name:{
                type: String
            },
            dataType:{
                type: String
            },
            maxlength:{
			    type: Number
            },
            defaultValue:{},
            required:{
			    type: String
            },
            dictName:{
			    type: String
            }

		}
	}
</script>

<style>
</style>
