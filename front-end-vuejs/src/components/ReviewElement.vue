<template>
    <div class="home-main-element">
      <div class="element-header place text-success">
        <i class="fas element-header_icon" v-bind:class="reviewElementIcon"></i><span>{{reviewElementName}}</span>
        <div class="top-vote">
          <button type="button" class="btn btn-primary" v-on:click="refreshBestReview">
            <i class="fas fa-thumbs-up icon_like"></i>Top xịn
          </button>
          <button type="button" class="btn btn-danger" v-on:click="refreshWorstReview">
            <i class="fas fa-thumbs-down icon_dislike"></i>Top bựa
          </button>
        </div>
      </div>
      <div class="element-wrap">
        <!-- Each element -->
        <div class="element row border" v-for="review in newestReview" :key="review.id">
          <div class="element-avatar">
            <img class="rounded-circle z-depth-2" alt="100x100"
              v-bind:src="review.image_icon" data-holder-rendered="true" />
          </div>

          <div class="element-detail">
            <div class="element-detail_line">
              <span class="element-name text-primary">
                <a :href="'/' + reviewType +'/' + review.id">{{review.name}}</a>
              </span>
              <span class="element-rating" v-for="index in getFullStarsRating(review.average_rating)" :key="index">
                <i class="fas fa-star text-warning"></i>
              </span>
              <span v-if="getHalfStarsRating(review.average_rating) === '5'">
                <i class="fas fa-star-half-alt text-warning"></i>
              </span>
              <span class="element-votes"> ({{review.all_rates}}) </span>
            </div>

            <div class="element-detail_line element-address">
              <i class="fas fa-map-marker-alt icon_address"></i>
              {{review.location}}
            </div>

            <div v-if="review.phone" class="element-detail_line element-phone">
              <i class="fas fa-phone-volume icon_phone"></i>
              {{review.phone}}
            </div>

            <p class="element-quote">
              <i class="fas fa-quote-right icon-quote"></i><span class="element-quote_quote">{{review.description}}</span>
            </p>
          </div>

        </div>
      </div>

      <!-- Pagination -->
      <nav aria-label="...">
        <ul class="pagination">
          <li class="page-item" :class="(pages.current == 1) ? 'disabled' : ''" v-on:click="showReviewsPrevious(pages.current != 1)">
            <span class="page-link" >Previous</span>
          </li>
          <li class="page-item" v-if="pages.current != 1" v-on:click="showReviewsOnPage(1)">
            <span class="page-link">1</span>
          </li>
          <li class="page-item active">
            <span class="page-link">
              {{pages.current}}
              <span class="sr-only">(current)</span>
            </span>
          </li>
          <li>
            <span class="page-item">
              <form @submit="showReviewsOnInput">
                <input type="number" class="page-link page-input border border-warning rounded-circle mx-1" placeholder="..." v-model="pages.input" :min="1" :max="pages.allPages">
                <input type="submit" style="display: none;"/>
              </form>
            </span>
          </li>
          <li class="page-item" v-if="pages.current != pages.allPages" v-on:click="showReviewsOnPage(pages.allPages)">
            <span class="page-link">{{pages.allPages}}</span>
            </li>
          <li class="page-item" :class="(pages.current == pages.allPages) ? 'disabled' : ''" v-on:click="showReviewsNext(pages.current != pages.allPages)">
            <span class="page-link">Next</span>
          </li>
        </ul>
      </nav>
    </div>
</template>

<script>
import ReviewService from '../service/ReviewService';
import Review from '../constant/Review';
export default {
  props: {
    type: {
      type: String,
      validator: function (value) {
        return ['place', 'coffee-shop', 'hotel', 'food'].indexOf(value) !== -1;
      }
    }
  },
  data() {
    return {
      reviewType: this.type,
      reviewElementName: '',
      reviewElementIcon: '',
      newestReview:[],

      pages: {
        status: 'newest',
        allPages: 0,
        current: 1,
        input: 1
      }
    }
  },
  methods: {
    refreshNewestReview() {
      ReviewService.retrieveNewest(this.reviewType, this.pages.current)
        .then(response => {
          this.newestReview = response.data;
        });
    },

    refreshBestReview() {
      this.pages.status = 'best';
      ReviewService.retrieveBest(this.reviewType, this.pages.current)
      .then(response => {
        this.newestReview = response.data;
      })
    },

    refreshWorstReview() {
      this.pages.status = 'worst';
      ReviewService.retrieveWorst(this.reviewType, this.pages.current)
      .then(response => {
        this.newestReview = response.data;
      })
    },

    retrieveAllPages() {
      ReviewService.retrieveAllPageReviews(this.reviewType)
      .then(response => {
        this.pages.allPages = response.data.all_pages;
      })
    },

    refreshElementReview(value) {
      if (Review.PLACE === value) {
        this.reviewElementName = "Địa Danh";
        this.reviewElementIcon = 'fa-map-marked-alt';
      }
      if (Review.COFFEE_SHOP === value) {
        this.reviewElementName = "Quán Cafe";
        this.reviewElementIcon = 'fa-coffee';
      }
      if (Review.HOTEL === value) {
        this.reviewElementName = "Homestay, Khách sạn";
        this.reviewElementIcon = 'fa-hotel';
      }
      if (Review.FOOD === value) {
        this.reviewElementName = "Đồ Ăn";
        this.reviewElementIcon = 'fa-utensils';
      }
      
    },

    showReviewsOnInput(e) {
      e.preventDefault();
      this.pages.current = this.pages.input;
      if (this.pages.status == 'newest') {
        this.refreshNewestReview();
      }
      if (this.pages.status == 'best') {
        this.refreshBestReview();
      }
      if (this.pages.status == 'worst') {
        this.refreshWorstReview();
      }
    },

    showReviewsOnPage(value) {
      this.pages.current = value;
      if (this.pages.status == 'newest') {
        this.refreshNewestReview();
      }
      if (this.pages.status == 'best') {
        this.refreshBestReview();
      }
      if (this.pages.status == 'worst') {
        this.refreshWorstReview();
      }
    },

    showReviewsPrevious(condition) {
      if (!condition) {
        return;
      }
      this.pages.current = this.pages.current - 1;
      if (this.pages.status == 'newest') {
        this.refreshNewestReview();
      }
      if (this.pages.status == 'best') {
        this.refreshBestReview();
      }
      if (this.pages.status == 'worst') {
        this.refreshWorstReview();
      }
    },

    showReviewsNext(condition) {
      if (!condition) {
        return;
      }
      this.pages.current = this.pages.current + 1;
      if (this.pages.status == 'newest') {
        this.refreshNewestReview();
      }
      if (this.pages.status == 'best') {
        this.refreshBestReview();
      }
      if (this.pages.status == 'worst') {
        this.refreshWorstReview();
      }
    },

    // Example: 4.5 return 4
    getFullStarsRating(floatValue) {
      return parseInt(floatValue.toString().split('.')[0]);
    },

    // Example: 4.5 return 5
    getHalfStarsRating(floatValue) {
      return floatValue.toString().split('.')[1];
    },

    toInt(value) {
      return parseInt(value);
    }

  },
  created() {
    this.refreshElementReview(this.reviewType);
    this.refreshNewestReview();
    this.retrieveAllPages();
  }
}
</script>

<style scoped>
  @import url('../assets/css/home.css');
</style>