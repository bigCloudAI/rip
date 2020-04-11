<template>
  <div  style="text-align: center;padding-top:20px;height:100%; position:relative;">
    <el-avatar shape="circle" :size="160" fit="fill" src="/backwell/lion.png"></el-avatar>
    <h3 >钟金凯</h3>
    <h5> JAVA架构师/前后端高级开发<br/>产品经理/项目经理</h5>
    <div style="padding:15px;text-align: left">
      <p style="text-indent: 20px;"> ● 能够管理小规模团队，根据成员特征合理安排日常研发任务并跟踪执行；</p>
      <p style="text-indent: 20px;"> ● 根据任务完成质量和日常绩效内容及成员意愿制定中短期能力培养目标和职业规划；</p>
      <p style="text-indent: 20px;"> ● 能够有效协调团队资源，理清任务主次和轻重缓急；</p>
      <p style="text-indent: 20px;"> ● 能够给成员提供指导性有效建议，合理估算任务难易和紧要程度决策资源组合；</p>
      <p style="text-indent: 20px;"> ● 积极有效与服务主体及领导进行沟通，对项目或产品做各方面调整。</p>
    </div>
    <div style="color:green;position:absolute;bottom:70px;width:100%;text-align: center;">
      <i style="margin-right:20px" class="fa-2x fa fa-qq hoverclick"></i> 
      <i class="fa-2x fa fa-weixin hoverclick"></i> 
    </div>
  </div>
</template>

<script>

export default {
  name: 'authorBase'
}
</script>
<style scoped>
.l{
  position:absolute;
}
.hoverclick:hover{
   color: aquamarine;
   cursor: pointer;
}
.hoverclick:active { color: #F0F; }
</style>
