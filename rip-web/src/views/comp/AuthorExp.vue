<template>
  <div class="backwell">
    <el-row style="padding:10px;">
    </el-row>
    <el-row>
      <el-col :span="24" style="line-height: 38px;font-size: 22px;padding-left: 12px">
        工作经历
        <el-divider></el-divider>
        <div class="test test-1">
          <h3>云计算项目产品研发（2015/5-2020/1）</h3>
<p style="text-indent: 20px;"><b>产品概要：</b>容器云管理平台供给应用开发、测试、部署、运维的各项服务和软件工具，加速软件工程高度自动化、智能化实现。始终坚持以容器为技术核心，致力解决用户运维、运营痛点为产品使命。综并百家产品所长，不断突破创新，寻求最节俭高效的方式打造国创容器云产品</p>
<p style="text-indent: 20px;"><b>技术架构概要：</b>前端springboot加vue，后端springboot对接ansible操作单元、数据存储单元、后端集群接口以及周边系统接口，数据库主备同步mysql，研发全流水线容器化部署</p>
<p style="text-indent: 20px;"><b>职责岗位：</b>研发产品经理。负责产品管理，负责市场调查并根据产品、市场及用户等的需求，确定开发何种产品，选择何种业务模式、商业模式。推动相应产品的开发组织，根据产品的生命周期，协调研发、营销、运营等，确定和组织实施相应的产品策略，以及其他一系列相关的产品管理活动</p>
<p style="text-indent: 20px;"><b>参与实际支撑合同项目：</b></p>
<p style="text-indent: 20px;">● 安徽电信自动化运维容器管理一二三四期</p>
<p style="text-indent: 20px;">概要：项目运营从2016年至2020年，先后迭代4个版本。主要是基于安徽自动化运维项目延伸的容器管理模块功能，主要演进了4个阶段
（1）容器性能和虚机对比测试阶段，坚实客户容器化建设信心
（2）容器管理软件研发阶段，坚实容器云平台建设技术基础
（3）基于swarm的小型容器云管理平台研发阶段，快速研发推进容器化进程
（4）2018年基于kubenetes的容器云平台整体解决方案的快速转型阶段。至此安徽容器云管理平台项目进入平稳需求研发，创新频现的阶段。</p>
<p style="text-indent: 20px;">项目特点：产品从无到有的重要合作项目，产品和项目互通有无，产品支撑项目完成技术性任务，反之为项目输入又完成了产品塑性。为产品技术选型和未来发展方向以及技术积累蓄力满满</p>

<p style="text-indent: 20px;">● 重庆移动物联网K8S技术支撑订单2019</p>
<p style="text-indent: 20px;">概要：重庆物联网框架合同订单，主要内容
（1）支配人力支撑客户完成现springcloud微服务框架的k8s容器化微服务升级方案制定和实施。
（2）完成研发到生产发布的基于容器的cdci流水线建设，多套k8s环境有机合成，生产环境200台规模
（3）容器化技术培训，完成客户研发组容器化和k8s的知识普及，先后完成3轮理论和实操培训</p>
<p style="text-indent: 20px;">项目特点：项目极多工作倾注在集群升级、集群认证、集群性能和配置优化内容，高质量集群是平台建设的重要内容之一</p>

<p style="text-indent: 20px;">● 宁夏移动综合网管支撑容器管理平台2019</p>
<p style="text-indent: 20px;">概要：平台加k8s资源池建设二合一，依赖安徽和重庆的项目经验和产品积累，快速复制实施。平台部署及资源池建设实施周期缩短到2周。
  平台系统功能实现支持：多租户，访问安全，容器管理，运维监控，服务编排，日志管理，平滑升级以及服务的弹性伸缩，
  支撑起宁夏移动综合网管类项目的容器化改造、实施、部署、运维等内容。</p>
          <div class="scrollbar">
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>

export default {
  name: 'authorAbout'
}
</script>
<style scoped>
.test{
    width: calc(100% - 13px);
    max-height: 625px;
    overflow: auto;
    float: left;
    margin: 5px;
    border: none;
    /* background-color: beige; */
    line-height: 34px;
    font-size:18px
}
.scrollbar{
    width: 30px;
    height: 400px;
    margin: 0 auto;
  
}
.test-1::-webkit-scrollbar {/*滚动条整体样式*/
        width: 10px;     /*高宽分别对应横竖滚动条的尺寸*/
        height: 1px;
    }
.test-1::-webkit-scrollbar-thumb {/*滚动条里面小方块*/
        border-radius: 10px;
         -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
        background: #535353;
    }
.test-1::-webkit-scrollbar-track {/*滚动条里面轨道*/
        -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
        border-radius: 10px;
        background: #EDEDED;
    }
</style>
