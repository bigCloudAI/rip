<template>
  <div class="backwell">
    <el-row style="padding:10px;">
      <!-- <el-col :span="24" style="line-height: 60px;font-size:38px;"><i class="el-icon-user-solid"></i>  我的简历
                        <el-divider></el-divider>
      </el-col>-->
    </el-row>
    <el-row>
      <el-col :span="24" style="line-height: 38px;font-size: 22px;padding-left: 12px">
        钟金凯
        <el-divider></el-divider>
        <div style="line-height: 34px;font-size:14px">
          <el-row>
            <el-col :span="10">
              <div style="margin-top:40px">姓名：钟金凯</div>
              <div>年龄：32</div>
              <div>地址：安徽合肥</div>
              <div>学历：本科毕业</div>
              <div>电话：180-9661-8162</div>
              <div>邮箱：766597324@qq.com</div>
              <div>专业：公共事业管理</div>
              <div>擅长：计算机信息、软件、产品</div>
            </el-col>
            <el-col :span="14" style="padding:8px">
              <el-image
                style="width: 100%; height: 100%;border-radius: 4px;"
                src="/backwell/lion.png"
                fit="fill"
              ></el-image>
            </el-col>
          </el-row>
          <!-- <div style="margin-top:20px"></div> -->
          <el-divider></el-divider>
          <div>分别担任过软件工程师、项目经理及产品经理等岗位职责。主要对接电信运营商网络管理业务系统的软件项目过程。后转向全职产品研发，云计算方向，主要研究和实现使用容器技术实现云资源和应用的高效使用和管理，以及实际行业业务的落云内容。</div>
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
