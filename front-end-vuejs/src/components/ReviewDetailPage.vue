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
      <div class="row border border-primary review" v-for="comment in comments" :key="comment">
        <!-- Review Header -->
        <div class="reviewer my-1">
          <span class="font-weight-bold">{{comment.author}}</span>
          <span class="element-rating" v-for="index in Number(comment.point)" :key="index" v-bind:index="index">
            <i class="fas fa-star text-warning"></i>
          </span>
          <span class="review-time font-italic">{{comment.last_time}}</span>
        </div>

        <!-- Review Content -->
        <div class="review-content border px-3">
          <div class="review-content_content py-3">
            {{comment.context}}
          </div>

          <div
            class="review-react row text-center border font-weight-bold my-3"
          >
            <div class="col-md-3 border text-primary" data-toggle="modal" data-target="#modal-write-comment" @click="setModalWriteCommentData(comment.id, 'comment')">
              <i class="fas fa-comments pr-1"></i>Comment
            </div>
            <div class="col-md-3 border text-success" data-toggle="modal" data-target="#modal-write-comment" @click="setModalWriteCommentData(comment.id, 'like')">
              <i class="fas fa-thumbs-up pr-1"></i>Like
            </div>
            <div class="col-md-3 border text-danger" data-toggle="modal" data-target="#modal-write-comment" @click="setModalWriteCommentData(comment.id, 'dislike')">
              <i class="fas fa-thumbs-down pr-1"></i>Dislike
            </div>
            <div class="col-md-3 border text-warning" data-toggle="modal" data-target="#modal-write-comment" @click="setModalWriteCommentData(comment.id, 'report')">
              <i class="fas fa-comment-slash pr-1"></i>Report
            </div>
          </div>
        </div>

        <!-- Review Comment -->
        <div class="review-comment px-3 py-3 border-bottom" v-for="subComment in comment.comments" :key="subComment">
          <div class="review-comment_title pb-2">
            <span class="font-weight-bold">{{subComment.author}}</span>
            <span><i class="fas px-1" v-bind:class="bindIconClass(subComment.react)"></i></span>
            <span class="font-italic">{{subComment.last_time}}</span>
          </div>
          <p>
            {{subComment.context}}
          </p>
        </div>

      </div>
    </div>
    <Footer />
    <!-- Modal Write Review -->
    <form @submit="validateAndSubmit">
      <div class="modal fade" id="write-review-modal">
        <div class="modal-dialog">
          <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
              <h4 class="modal-title text-center">Viết review {{review.name}}</h4>
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
                  placeholder="Người Rì viu có tâm"
                  v-model="reviewName"
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
                  v-model="reviewContext"
                ></textarea>
              </div>

              <div class="form-group">
                <label for="rate" class="font-weight-bold">Chấm điểm</label>
                <select class="form-control" v-model="reviewPoint">
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
                  v-model="reviewConfirm"
                  true-value="yes"
                  false-value="no"
                />
                <label
                  class="form-check-label font-weight-bold"
                  for="defaultCheck1"
                >
                  Tôi đảm bảo những điều trên là thật, review hoàn toàn khách
                  quan và công tâm
                </label>
              </div>
              <div v-if="errors.length">
                <div class="alert alert-warning" v-bind:key="index" v-for="(error, index) in errors">
                  {{error}}
                </div>
              </div>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
              <button
                type="submit"
                class="btn btn-success"
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

    <!-- Modal Write Comment -->
    <form @submit="validateAndSubmitComment">
      <div class="modal fade" id="modal-write-comment" role="dialog">
        <div class="modal-dialog">
        
          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title">Viết comment về review này</h4>
              <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
              <div class="form-group">
                <label for="name" class="font-weight-bold">Tên bạn</label>
                <input
                  type="text"
                  class="form-control"
                  placeholder="Người nhận xét có tâm"
                  v-model="commentName"
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
                  v-model="commentContext"
                ></textarea>
              </div>

              <div class="form-check">
                <input
                  class="form-check-input"
                  type="checkbox"
                  value=""
                  v-model="commentConfirm"
                  true-value="yes"
                  false-value="no"
                />
                <label
                  class="form-check-label font-weight-bold"
                  for="defaultCheck1"
                >
                  Xác nhận
                </label>
              </div>
              <div v-if="errorsComment.length">
                <div class="alert alert-warning" v-bind:key="index" v-for="(error, index) in errorsComment">
                  {{error}}
                </div>
              </div>
            </div>
            <div class="modal-footer">
              <button
                type="submit"
                class="btn btn-success"
              >
                Đăng luôn
              </button>
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
import CommentService from '../service/CommentService';

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
      reviewContext: '',
      reviewPoint: '',
      reviewConfirm: 'no',
      reviewName: '',
      review: '',

      commentName: '',
      commentContext: '',
      commentConfirm: 'no',
      comments: [],
      modalComment: {
        id: '',
        type: ''
      },
      errors: [],
      errorsComment: []
    };
  },
  methods: {
    refreshDetail() {
      ReviewService.retrieveDetail(this.reviewType, this.reviewId).then(
        (response) => {
          this.review = response.data;
        }
      );
      CommentService.retrieveDetailComment(this.reviewId).then(
        response => {
          this.comments = response.data;
        }
      )
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
    },
    bindIconClass(react) {
      if (react == 'comment') {
        return 'fa-comments text-primary';
      }

      if (react == 'like') {
        return 'fa-thumbs-up text-success';
      }

      if (react == 'dislike') {
        return 'fa-thumbs-down text-danger';
      }

      if (react == 'report') {
        return 'fa-comment-slash text-warning';
      }
    },

    setModalWriteCommentData(commentId, type) {
      if (['comment', 'like', 'dislike', 'report'].indexOf(type) == -1) {
        this.errors.push("Nghi vấn hack");
      }
      this.modalComment.id = commentId;
      this.modalComment.type = type;
    },

    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
      if (!this.reviewName) {
        this.errors.push("Hãy nhập tên bạn")
      }
      if (this.reviewContext.length < 20) {
        this.errors.push("Nội dung phải hơn 20 kí tự bạn ơi")
      }
      if (['1', '2', '3', '4', '5'].indexOf(this.reviewPoint) == -1) {
        this.errors.push("Chưa chấm điểm à bạn")
      }
      if (this.reviewConfirm != "yes") {
        this.errors.push("Xin hãy xác nhận lại")
      }
      if (this.errors.length === 0) {
        CommentService.addComment(this.reviewId, {
          author: this.reviewName,
          point: this.reviewPoint,
          context: this.reviewContext,
        })
        .then( () => {
          window.location.reload();
        });
      }
    },

    validateAndSubmitComment(e) {
      e.preventDefault();
      this.errorsComment = [];
      if (!this.commentName) {
        this.errorsComment.push('Hãy nhập tên bạn')
      }
      if (this.commentContext.length < 20) {
        this.errorsComment.push('Nhập trên 20 kí tự bạn ơi');
      }
      if (this.commentConfirm != 'yes') {
        this.errorsComment.push('Chưa xác nhận kìa bạn');
      }

      if (this.errorsComment.length === 0) {
        CommentService.addCommentReact(this.modalComment.id, {
          author: this.commentName,
          context: this.commentContext,
          type: this.modalComment.type
        })
        .then( () => {
          window.location.reload();
        })
      }
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