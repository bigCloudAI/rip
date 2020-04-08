<template>
  <div class="ripOs">
    <!-- <div class="riptooltip">工具栏</div> -->

      <el-container style="height:100%">
        <el-aside width="184px">
          <!-- 左侧菜单导航 -->
          <el-row>
            <el-col :span="24" class="os_menu spanmargin" >
              <div style="margin-top: 4px" >
                <el-link :underline="false" icon="fa fa-object-ungroup"> <span>网络</span></el-link>
              </div>
              <div>
                <el-link :underline="false" icon="fa fa-file-text-o"> <span>DNS</span></el-link>
              </div>
              <div>
                <el-link :underline="false" icon="fa fa-table"><span>仓库</span></el-link>
              </div>
              <div>
                <el-link :underline="false" icon="fa fa-area-chart"><span>性能</span></el-link>
              </div>
              <div>
                <el-link :underline="false" icon="fa fa-file-code-o"><span>日志</span></el-link>
              </div>
            </el-col>
          </el-row>
          <el-divider></el-divider>
          <el-row>
            <el-col :span="24" class="os_menu">
              <div>
                <el-link :underline="false" icon="el-icon-plus">所有节点</el-link>
              </div>
              <div>
                <el-link :underline="false" icon="el-icon-tickets">管理节点</el-link>
              </div>
              <div>
                <el-link :underline="false" icon="el-icon-picture-outline-round">工作节点</el-link>
              </div>
              <div>
                <el-link :underline="false" icon="el-icon-service">ETCD节点</el-link>
              </div>
            </el-col>
          </el-row>
          <el-divider></el-divider>
          <el-row>
            <el-col :span="24" class="os_menu ">
              <div>
                <el-link :underline="false" icon="fa fa-object-ungroup"><span>网络</span></el-link>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24" class="os_menu">
              <div>
                <el-link :underline="false" icon="fa fa-id-card"><span>认证信息</span></el-link>
              </div>
            </el-col>
          </el-row>
        </el-aside>
         <el-main>
        <!-- 右侧内容 -->
          <div style="width: 99%;">
              <h4 style="margin-bottom: 30px">默认应用</h4>
              <el-row> 
                <el-col :span="4">
                  <div style="width: 80%; text-align: center" class="bigIcon">
                    <i class="fa fa-object-ungroup fa-3x" aria-hidden="true"></i>
                    <div style="padding-top: 4px">网络</div>
                  </div>
                </el-col>
                <el-col :span="4">
                  <div style="width: 80%; text-align: center" class="bigIcon">
                    <i class="fa fa-file-text-o fa-3x" aria-hidden="true"></i>
                    <div style="padding-top: 4px">DNS</div>
                  </div>
                </el-col> 
                <el-col :span="4">
                  <div style="width: 80%; text-align: center" class="bigIcon">
                    <i class="fa fa-table fa-3x" aria-hidden="true"></i>
                    <div style="padding-top: 4px">仓库</div>
                  </div>
                </el-col> 
                <el-col :span="4">
                  <div style="width: 80%; text-align: center" class="bigIcon">
                    <i class="fa fa-area-chart fa-3x" aria-hidden="true"></i>
                    <div style="padding-top: 4px">性能</div>
                  </div>
                </el-col> 
                <el-col :span="4">
                  <div style="width: 80%; text-align: center" class="bigIcon">
                    <i class="fa fa-file-code-o fa-3x" aria-hidden="true"></i>
                    <div style="padding-top: 4px">日志</div>
                  </div>
                </el-col> 
              </el-row>
              <div style="height: 20px"></div>
              <h4 style="margin-bottom: 30px">节点</h4>
              <el-row style="margin-bottom:10px"> 
                <el-col :span="11"
                  class="bigIcon" style="padding:10px 10px 10px"> 
                  <el-row>
                    <div style="position: relative;">
                      <div style="width:62px;height:100%;"> 
                        <i class="fa fa-tasks fa-3x"
                        style="margin-left: 10px; color: #67C23A" aria-hidden="true"></i>
                      </div>
                      <div style=" position: absolute;top: 0; bottom: 0;left: 62px; padding-left: 12px;right: 0;">
                        <div style="margin-bottom: 5px">
                          321M / 5G
                          <el-progress :percentage="50" :show-text=false></el-progress>
                        </div>
                        <div style="margin-bottom: 5px">
                          1G / 5G
                          <el-progress :percentage="30" :show-text=false></el-progress>
                        </div>
                      </div>
                    </div>
                  </el-row>
                  <div style="padding-top: 4px">192.168.0.3</div>
                </el-col> 
                <el-col :span="11"
                  class="bigIcon" style="padding:10px 10px 10px"> 
                  <el-row>
                    <div style="position: relative;">
                      <div style="width:62px;height:100%;"> 
                        <i class="fa fa-tasks fa-3x"
                        style="margin-left: 10px; color: #67C23A" aria-hidden="true"></i>
                      </div>
                      <div style=" position: absolute;top: 0; bottom: 0;left: 62px; padding-left: 12px;right: 0;">
                        <div style="margin-bottom: 5px">
                          321M / 5G
                          <el-progress :percentage="50" :show-text=false></el-progress>
                        </div>
                        <div style="margin-bottom: 5px">
                          1G / 5G
                          <el-progress :percentage="30" :show-text=false></el-progress>
                        </div>
                      </div>
                    </div>
                  </el-row>
                  <div style="padding-top: 4px">192.168.0.3</div>
                </el-col> 
              </el-row>

              <el-row> 
                <el-col :span="11"
                  class="bigIcon" style="padding:10px 10px 10px"> 
                  <el-row>
                    <div style="position: relative;">
                      <div style="width:62px;height:100%;"> 
                        <i class="fa fa-tasks fa-3x"
                        style="margin-left: 10px; color: #67C23A" aria-hidden="true"></i>
                      </div>
                      <div style=" position: absolute;top: 0; bottom: 0;left: 62px; padding-left: 12px;right: 0;">
                        <div style="margin-bottom: 5px">
                          321M / 5G
                          <el-progress :percentage="50" :show-text=false></el-progress>
                        </div>
                        <div style="margin-bottom: 5px">
                          1G / 5G
                          <el-progress :percentage="30" :show-text=false></el-progress>
                        </div>
                      </div>
                    </div>
                  </el-row>
                  <div style="padding-top: 4px">192.168.0.3</div>
                </el-col> 
                <el-col :span="11"
                  class="bigIcon" style="padding:10px 10px 10px"> 
                  <el-row>
                    <div style="position: relative;">
                      <div style="width:62px;height:100%;"> 
                        <i class="fa fa-tasks fa-3x"
                        style="margin-left: 10px; color: #67C23A" aria-hidden="true"></i>
                      </div>
                      <div style=" position: absolute;top: 0; bottom: 0;left: 62px; padding-left: 12px;right: 0;">
                        <div style="margin-bottom: 5px">
                          321M / 5G
                          <el-progress :percentage="50" :show-text=false></el-progress>
                        </div>
                        <div style="margin-bottom: 5px">
                          1G / 5G
                          <el-progress :percentage="30" :show-text=false></el-progress>
                        </div>
                      </div>
                    </div>
                  </el-row>
                  <div style="padding-top: 4px">192.168.0.3</div>
                </el-col> 
              </el-row>
          </div>
         </el-main>
      </el-container>
  </div>
</template>

<script>
export default {
  name: "RipsOs"
};
</script>

<style scoped lang="scss">
.os_menu span {
  margin-left:4px
}
.ripOs {
  margin: 0;
  height: 100%;
  background-color: white;
  padding: 6px;
}
.riptooltip {
  height: 20px;
  width: 100%;
  // background-color: darkkhaki;
}

.os_menu  div{
	padding-top:7px;
	padding-bottom:7px;
	padding-left:20px;
	cursor:pointer
}

.os_menu div:hover{
	background-color: #EBEEF5;
	border-radius:5px;
}

.bigIcon{
	cursor:pointer;
	padding-top:10px;
	padding-bottom:3px;
}

.bigIconSelect {
	background-color: #E4E7ED;
	border-radius:5px;
}

.bigIcon:hover {
	background-color: #EBEEF5;
/* 	color: #FFFFFF; */
	border-radius:5px;
}
</style>
