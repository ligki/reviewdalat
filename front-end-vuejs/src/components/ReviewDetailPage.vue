<template>
  <div>
    <Header />
    <div class="container">
      <!-- Home link -->
      <div class="row">
        <div class="header-link">
          <i class="fas fa-home text-primary"></i>
          <span class="text-primary"><a href="/">Trang chủ</a></span>
          <span>/</span>
          <span>{{review.name}}</span>
        </div>
      </div>

      <!-- Detail info -->
      <div class="element row border">
        <div class="element-avatar">
          <img
            class="rounded-circle z-depth-2"
            alt="100x100"
            v-bind:src="review.image_icon"
            data-holder-rendered="true"
          />
        </div>
        <div class="element-detail">
          <div class="element-detail_line">
            <span class="element-name text-primary">
              {{review.name}}
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

        <div class="write-review">
          <button
            type="button"
            class="btn btn-success"
            data-toggle="modal"
            data-target="#write-review-modal"
          >
            Viết Review
          </button>
        </div>
      </div>

      <!-- Reviews -->
      <div class="row border border-primary review">
        <!-- Review Header -->
        <div class="reviewer my-1">
          <span class="font-weight-bold">Người review 1</span>
          <span class="element-rating">
            <i class="fas fa-star text-warning"></i>
            <i class="fas fa-star text-warning"></i>
            <i class="fas fa-star text-warning"></i>
            <i class="fas fa-star-half-alt text-warning"></i>
          </span>
          <span class="review-time font-italic"> 1 giờ trước </span>
        </div>

        <!-- Review Content -->
        <div class="review-content border px-3">
          <div class="review-content_content py-3">
            I've been having trouble finding this one. I have a div that is \n
            centered in the body margin: 0 auto; \n . It contains multiple divs.
            I want it to expand to the width of it's widest child width: auto;
            The problem is I want to have one of the child div's aligned on the
            right, however this expands my paren t to 100%. How would I
            accomplish this without a fixed width for the parent?
          </div>

          <div
            class="review-react row text-center border font-weight-bold my-3"
          >
            <div class="col-md-3 border text-primary">
              <i class="fas fa-comments pr-1"></i>Comment
            </div>
            <div class="col-md-3 border text-success">
              <i class="fas fa-thumbs-up pr-1"></i>Like
            </div>
            <div class="col-md-3 border text-danger">
              <i class="fas fa-thumbs-down pr-1"></i>Dislike
            </div>
            <div class="col-md-3 border text-warning">
              <i class="fas fa-comment-slash pr-1"></i>Report
            </div>
          </div>
        </div>

        <!-- Review Comment -->
        <div class="review-comment px-3 py-3 border-bottom">
          <div class="review-comment_title pb-2">
            <span class="font-weight-bold">Ẩn danh</span>
            <span><i class="fas fa-thumbs-up px-1 text-success"></i></span>
            <span class="font-italic">1 giờ trước</span>
          </div>
          <p>
            I have a div that is centered in the body margin: 0 auto;. It
            contains multiple divs. I want it to expand to the width of it's
            widest child width: auto; The problem is I want to have one of the
            child div's aligned on the right, however this expands my parent to
            100%. How would I accomplish this without a fixed width for the
            parent?
          </p>
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
    </div>
    <Footer />
    <!-- Modal -->
    <!-- The Modal -->
    <form action="">
      <div class="modal fade" id="write-review-modal">
        <div class="modal-dialog">
          <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
              <h4 class="modal-title text-center">Viết review Quảng Trường</h4>
              <button type="button" class="close" data-dismiss="modal">
                &times;
              </button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
              <div class="form-group">
                <label for="name" class="font-weight-bold">Tên bạn</label>
                <input
                  type="text"
                  class="form-control"
                  name="reviewName"
                  placeholder="Người Rì viu có tâm"
                />
              </div>

              <div class="form-group">
                <label for="content" class="font-weight-bold"
                  >Nội dung review<span
                    class="text-danger ml-1 font-weight-bold"
                    >(Bắt buộc)</span
                  ></label
                >
                <textarea
                  name=""
                  class="form-control"
                  id=""
                  cols="30"
                  rows="10"
                  placeholder="Nhớ viết dài hơn 20 kí tự nhé"
                ></textarea>
              </div>

              <div class="form-group">
                <label for="rate" class="font-weight-bold">Chấm điểm</label>
                <select class="form-control">
                  <option value="1">
                    1 Điểm - Không chấp nhận được, cực kì tồi tệ
                  </option>
                  <option value="2">2 Điểm - Dở òm, chả có gì</option>
                  <option value="3">
                    3 Điểm - Bình thường, không mong đợi lắm
                  </option>
                  <option value="4">4 Điểm - Ngon lành cành đào</option>
                  <option value="5">
                    5 Điểm - Siêu xịn xò, đi bao nhiêu lần cũng không chán
                  </option>
                </select>
              </div>

              <div class="form-check">
                <input
                  class="form-check-input"
                  type="checkbox"
                  value=""
                  id="defaultCheck1"
                />
                <label
                  class="form-check-label font-weight-bold"
                  for="defaultCheck1"
                >
                  Tôi đảm bảo những điều trên là thật, review hoàn toàn khách
                  quan và công tâm
                </label>
              </div>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
              <button
                type="button"
                class="btn btn-success"
                data-dismiss="modal"
              >
                Đăng luôn
              </button>
              <button type="button" class="btn btn-danger" data-dismiss="modal">
                Close
              </button>
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import Header from "./common/Header";
import Footer from "./common/Footer";
import ReviewService from "../service/ReviewService";

export default {
  name: "ReviewDetailPage",
  head: {
    title: "Review Dalat",
    link: [{ rel: "icon", href: "/favicon.png" }],
    script: [
      {
        type: "text/javascript",
        src: "https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js",
      },
      {
        type: "text/javascript",
        src:
          "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js",
      },
      {
        type: "text/javascript",
        src:
          "https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js",
      },
    ],
  },
  data() {
    return {
      reviewId: "",
      reviewType: "",
      review: '',
    };
  },
  methods: {
    refreshDetail() {
      ReviewService.retrieveDetail(this.reviewType, this.reviewId).then(
        (response) => {
          this.review = response.data;
        }
      );
    },

    // Example: 4.5 return 4
    getFullStarsRating(floatValue) {
      if (!floatValue) return 0;
      return parseInt(floatValue.toString().split('.')[0]);
    },

    // Example: 4.5 return 5
    getHalfStarsRating(floatValue) {
      if (!floatValue) return 0;
      return floatValue.toString().split('.')[1];
    }
  },
  components: {
    Header,
    Footer
  },
  created() {
    this.reviewId = this.$route.params.id;
    this.reviewType = this.$route.params.review_object_type;
    this.refreshDetail();
  },
};
</script>

<style scoped>
</style>