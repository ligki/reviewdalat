import Vue from "vue";
import Router from "vue-router";
import VueMeta from "vue-meta";

Vue.use(Router);
Vue.use(VueMeta, {
  keyName: "head",
});

const router = new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "Home",
      component: () => import("./components/page/HomePage"),
    },
    {
      path: "/:review_object_type(place|coffee-shop|hotel|food)/:id",
      name: "ReviewDetail",
      component: () => import("./components/page/ReviewDetailPage"),
    },
    {
      path: "/news/:id",
      name: "NewsDetail",
      component: () => import("./components/page/NewsPage"),
    },
    {
      path: "*",
      name: 'Not Found',
      component: () => import('./components/page/NotFound')
    }
  ],
});

export default router;
