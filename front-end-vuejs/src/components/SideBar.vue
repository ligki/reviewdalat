<template>
  <div class="side-bar col-sm-4 border border-primary">
    <h3>Review mới</h3>

    <!-- new review -->
    <div class="new-review" v-for="comment in newestComments" :key="comment.author">
      <div class="new-review_header">
        <span>{{comment.author}}</span>
        <span> đã review </span>
        <span><a :href="'/' + mapTypeToPathVariable(comment.review_object_type) + '/' + comment.review_object_id">{{comment.review_object_name}}</a></span>
      </div>

      <div class="new-review_rate">
        <span>{{comment.last_time}}</span>
        <span v-for="i in parseInt(comment.point)" :key="i">
          <i class="fas fa-star text-warning"></i>
        </span>
      </div>
      <div class="new-review_content font-italic">
        {{comment.context.substring(0,500)}} ...
      </div>
    </div>

  </div>
</template>

<script>
import Review from '../constant/Review';
import CommentService from "../service/CommentService";

export default {
  name: "SideBar",
  data() {
    return {
      newestComments: [],
    };
  },
  methods: {
    refreshNewestComments() {
      CommentService.retrieveNewestCommentToHome()
        .then(response => {
          this.newestComments = response.data;
        })
    },
    mapTypeToPathVariable(typeInt) {
      if (typeInt == '1') return Review.PLACE;
      if (typeInt == '2') return Review.COFFEE_SHOP;
      if (typeInt == '3') return Review.HOTEL;
      if (typeInt == '4') return Review.FOOD;
    }
  },
  created() {
    this.refreshNewestComments();
  },
};
</script>