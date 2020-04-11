import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import "font-awesome/css/font-awesome.min.css";
import WebSQL from './webSQL/webSQL.js'
//import ElementUI from 'element-ui'

import {
  Button as ElButton,
  Row,
  Col,
  Form,
  FormItem,
  Card,
  Input,
  Link,
  Divider,
  Container,
  Aside,
  Main,
  Progress,
  Tabs,
  TabPane,
  Table,
  TableColumn,
  Select,
  Option,
  Pagination,
  Dialog,
  Drawer,
  DatePicker,
  TimePicker,
  Message,
  Notification,
  Tag,
  Image,
  Avatar
} from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElButton)
Vue.use(Row)
Vue.use(Col)
Vue.use(Input)
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Card)
Vue.use(Link)
Vue.use(Divider)
Vue.use(Container)
Vue.use(Aside)
Vue.use(Main)
Vue.use(Progress)
Vue.use(Tabs)
Vue.use(TabPane)
Vue.use(Table)
Vue.use(TableColumn)
Vue.use(Select)
Vue.use(Option)
Vue.use(Pagination)
Vue.use(Dialog)
Vue.use(Drawer)
Vue.use(DatePicker)
Vue.use(TimePicker)
Vue.use(Tag)
Vue.use(Image)
Vue.use(Avatar)

// 在调用 Vue.use 前，给 Message 添加 install 方法
Message.install = function (Vue,) {
  Vue.prototype.$message = Message
}
Vue.use(Message)
Notification.install = function (Vue,) {
  Vue.prototype.$notify = Notification 
}
Vue.use(Notification)

Vue.use(WebSQL)
//WebSQL.install(Vue)

Vue.config.productionTip = false


// import RipOs from '@/public/RipOs'
// import MyApp from '@/public/MyApp'
// import Rbac from '@/public/Rbac'
// Vue.component("ripOs",RipOs)
// Vue.component("myApp",MyApp)
// Vue.component("rbax",Rbac)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
