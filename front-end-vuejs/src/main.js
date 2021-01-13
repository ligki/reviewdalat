import Vue from 'vue'
import App from './App.vue'
import Router from './routers';
import VueHead from 'vue-head';

Vue.config.productionTip = false
Vue.use(VueHead);

new Vue({
  router : Router,
  render: h => h(App),
}).$mount('#app')
