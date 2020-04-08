<template>
    <div class="context" 
	v-bind:style="{ left: context.left + 'px',top:context.top + 'px' }"
	style="position:absolute;" v-show="context.contextable">
		<ul class="dropdown-menu" aria-labelledby="dropdownMenu4" style="display: block">
				<li class="dropdown-item"><a href="#">查看</a></li>
				<li @click="handleSortMenu"><a href="#">恢复排序</a></li>
				<li @click="handleSortMenu"><a href="#">刷新</a></li>
				<li role="separator" class="divider"></li>
				<li><a href="#">粘贴</a></li>
				<li><a href="#">粘贴快捷方式</a></li>
				<li><a href="#">撤销复制</a></li>
				<li role="separator" class="divider"></li>
				<li><a href="#">打开终端</a></li>
				<li role="separator" class="divider"></li> 
		</ul>
	</div>
</template>

<script>
import 'bootstrap3/dist/css/bootstrap.min.css'
export default {
  name: 'context',
  props:{
	context:Object
  },
  methods:{
	handleSortMenu(){
		this.$emit("sortMenu");
	}
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">

</style>
