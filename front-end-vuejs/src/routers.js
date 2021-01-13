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
      component: () => import("./components/HomePage"),
    },
    {
      path: "/:review_object_type/:id",
      name: "ReviewDetail",
      component: () => import("./components/ReviewDetailPage"),
    },
  ],
});

export default router;
