// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'
import globalVariable from './global_variable'
import Copyright from './components/Copyright.vue'
import Title from './components/Title.vue'
Vue.prototype.axios = axios;
Vue.prototype.Global =  globalVariable;
// Vue.config.productionTip = false
Vue.component('Copyright',Copyright)
Vue.component('Title',Title)
Vue.use(ElementUI);
new Vue({
  el: '#app',
  router,
  axios,
  components: { App },
  template: '<App/>'
})
