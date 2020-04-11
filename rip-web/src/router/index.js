import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Ripweb',
    component: () => import(/* webpackChunkName: "about" */ '../views/Ripweb.vue')
  },
  {
    path: '/about',
    name: 'About',
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/ripweb',
    name: 'Ripweb',
    component: () => import(/* webpackChunkName: "about" */ '../views/Ripweb.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/author',
    name: 'Author',
    component: () => import( '../views/Author.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
router.beforeEach((to,from,next) => {
  if(store.state.userInfo || to.path === "/login"|| to.path === "/author"||to.path ==="/about"){  
    next();
  }else{
    next({
      path:"/login"
    })
  }
})

export default router
