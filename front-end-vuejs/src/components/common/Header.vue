<template>
    <div class="jumbotron text-center text-white banner">
    <h1>
      <img class="logo rounded-circle" src="../../assets/img/logo.png" />Review Đà Lạt
    </h1>
    <p>
      Review về Đà Lạt, các địa danh, quán cafe, homestay, đồ ăn... cái gì
      cũng có!
    </p>
    <form class="search-wrap" @submit="setReviews">
      <i class="fas fa-search" aria-hidden="true"></i>
      <div class="ml-3 search-input">
        <input class="form-control form-control-sm" type="text" placeholder="Search" aria-label="Search" v-model="search" v-on:blur="resetReviews()"/>
        <div class="search-result form-control form-control-sm" v-if="reviews.length > 0">
          <div v-for="review in reviews" :key="review.id" class="border-bottom px-1 py-1 mx-1 my-1">
            <a :href="'/' + mapTypeToPathVariable(review.type) + '/' + review.id">
              <span class="search-icon mr-2"><img :src="review.image_icon"></span>
              <span class="search-name">{{review.name}}</span>
            </a>
          </div>
        </div>
      </div>
    </form>
    
  </div>
</template>

<script>
import ReviewService from "../../service/ReviewService";
import Review from '../../constant/Review';
export default {
    name: "Header",
    data() {
      return {
        search: '',
        reviews: []
      }
    },
    methods: {
      mapTypeToPathVariable(typeInt) {
        if (typeInt == '1') return Review.PLACE;
        if (typeInt == '2') return Review.COFFEE_SHOP;
        if (typeInt == '3') return Review.HOTEL;
        if (typeInt == '4') return Review.FOOD;
      },

      resetReviews() {
        this.reviews = [];
      },

      setReviews(e) {
        e.preventDefault();
        ReviewService.searchReviews(this.search).then((response) => {
          this.reviews = response.data;
        })
      }
    },

    watch: {
      search: function() {
        ReviewService.searchReviews(this.search).then((response) => {
          this.reviews = response.data;
        })
      }
    }

}
</script>