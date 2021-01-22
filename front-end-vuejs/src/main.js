import Vue from 'vue'
import App from './App.vue'
import Router from './routers';
import VueHead from 'vue-head';
import VueRouter from 'vue-router';

import TitleMixin from './mixins/title';

Vue.config.productionTip = false
Vue.use(VueHead);
Vue.use(VueRouter)
Vue.mixin(TitleMixin)

new Vue({
  router : Router,
  render: h => h(App),
}).$mount('#app')
