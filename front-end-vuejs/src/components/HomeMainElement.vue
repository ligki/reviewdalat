<template>
    <div class="home-main-element">
          <div class="element-header place text-success">
            <i class="fas fa-map-marked-alt element-header_icon"></i><span>Địa danh</span>
            <div class="top-vote">
              <button type="button" class="btn btn-primary">
                <i class="fas fa-thumbs-up icon_like"></i>Top xịn
              </button>
              <button type="button" class="btn btn-danger">
                <i class="fas fa-thumbs-down icon_dislike"></i>Top bựa
              </button>
            </div>
          </div>
          <div class="element-wrap">
            <!-- Each element -->
            <div class="element row border">
              <div class="element-avatar">
                <img class="rounded-circle z-depth-2" alt="100x100"
                  src="https://mdbootstrap.com/img/Photos/Avatars/img%20(31).jpg" data-holder-rendered="true" />
              </div>

              <div class="element-detail">
                <div class="element-detail_line">
                  <span class="element-name text-primary">
                    <a href="#">Quảng trường</a>
                  </span>
                  <span class="element-rating">
                    <i class="fas fa-star text-warning"></i>
                    <i class="fas fa-star text-warning"></i>
                    <i class="fas fa-star text-warning"></i>
                    <i class="fas fa-star-half-alt text-warning"></i>
                  </span>
                  <span class="element-votes"> (100) </span>
                </div>

                <div class="element-detail_line element-address">
                  <i class="fas fa-map-marker-alt icon_address"></i>
                  Bà Huyện Thanh Quan, Phường 1, Thành phố Đà Lạt, Lâm Đồng
                </div>

                <p class="element-quote">
                  <i class="fas fa-quote-right icon-quote"></i><span class="element-quote_quote">Lorem ipsum dolor sit
                    amet, consectetur adipisicing
                    elit...</span>
                </p>
              </div>

            </div>

            <div class="element row border">
              <div class="element-avatar">
                <img class="rounded-circle z-depth-2" alt="100x100"
                  src="https://mdbootstrap.com/img/Photos/Avatars/img%20(31).jpg" data-holder-rendered="true" />
              </div>
              <div class="element-detail">
                <div class="element-detail_line">
                  <span class="element-name text-primary">
                    <a href="#">Quảng trường</a>
                  </span>
                  <span class="element-rating">
                    <i class="fas fa-star text-warning"></i>
                    <i class="fas fa-star text-warning"></i>
                    <i class="fas fa-star text-warning"></i>
                    <i class="fas fa-star-half-alt text-warning"></i>
                  </span>
                  <span class="element-votes"> (100) </span>
                </div>

                <div class="element-detail_line element-address">
                  <i class="fas fa-map-marker-alt icon_address"></i>
                  Bà Huyện Thanh Quan, Phường 1, Thành phố Đà Lạt, Lâm Đồng
                </div>

                <p class="element-quote">
                  <i class="fas fa-quote-right icon-quote"></i><span class="element-quote_quote">Lorem ipsum dolor sit
                    amet, consectetur adipisicing
                    elit...</span>
                </p>
              </div>
            </div>

            <div class="element row border">
              <div class="element-avatar">
                <img class="rounded-circle z-depth-2" alt="100x100"
                  src="https://mdbootstrap.com/img/Photos/Avatars/img%20(31).jpg" data-holder-rendered="true" />
              </div>
              <div class="element-detail">
                <div class="element-detail_line">
                  <span class="element-name text-primary">
                    <a href="#">Quảng trường</a>
                  </span>
                  <span class="element-rating">
                    <i class="fas fa-star text-warning"></i>
                    <i class="fas fa-star text-warning"></i>
                    <i class="fas fa-star text-warning"></i>
                    <i class="fas fa-star-half-alt text-warning"></i>
                  </span>
                  <span class="element-votes"> (100) </span>
                </div>

                <div class="element-detail_line element-address">
                  <i class="fas fa-map-marker-alt icon_address"></i>
                  Bà Huyện Thanh Quan, Phường 1, Thành phố Đà Lạt, Lâm Đồng
                </div>

                <p class="element-quote">
                  <i class="fas fa-quote-right icon-quote"></i><span class="element-quote_quote">Lorem ipsum dolor sit
                    amet, consectetur adipisicing
                    elit...</span>
                </p>
              </div>
            </div>

          </div>

          <!-- Pagination -->
          <nav aria-label="...">
            <ul class="pagination">
              <li class="page-item disabled">
                <span class="page-link">Previous</span>
              </li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item active">
                <span class="page-link">
                  2
                  <span class="sr-only">(current)</span>
                </span>
              </li>
              <li class="page-item">
                <span class="page-link"> ... </span>
              </li>
              <li class="page-item"><a class="page-link" href="#">99</a></li>
              <li class="page-item">
                <a class="page-link" href="#">Next</a>
              </li>
            </ul>
          </nav>
        </div>
</template>

<script>
import ReviewService from "../service/ReviewService";
export default {
  name: "HomeMainElement",
  props: ['element-name', 'element-icon'], // element name - element icon: Place - fa-map-marked-alt, 
  data() {
    newestPlaceReview:[]
  },
  methods: {
    refreshNewestPlaceReview() {
      ReviewService.retrieveNewestPlace()
        .then(response => {
          this.newestPlaceReview = response.data;
        });
    }
  },
  created() {
    this.refreshNewestPlaceReview();
  },
}
</script>

<style scoped>

</style>