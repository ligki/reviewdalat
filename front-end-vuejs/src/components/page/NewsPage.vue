<template>
  <div>
    <Header />
    <div class="container">
      <!-- Home link -->
      <div class="row">
        <div class="header-link">
          <i class="fas fa-home text-primary"></i>
          <span class="text-primary"><a href="/">Trang chủ</a></span>
          <span class="mx-1">/</span>
          <span class="text-primary"><a href="/">Tin tức</a></span>
          <span class="mx-1">/</span>
          <span>{{ news.title }}</span>
        </div>
      </div>

      <div class="row slideshow-container">
        <div class="mySlides slideshow-fade">
          <div class="slideshow-numbertext">1 / 3</div>
          <img
            src="https://www.w3schools.com/howto/img_nature_wide.jpg"
            style="width: 100%"
          />
          <div class="slideshow-text">Caption Text</div>
        </div>

        <div class="mySlides slideshow-fade">
          <div class="slideshow-numbertext">2 / 3</div>
          <img
            src="https://www.w3schools.com/howto/img_nature_wide.jpg"
            style="width: 100%"
          />
          <div class="slideshow-text">Caption Two</div>
        </div>

        <div class="mySlides slideshow-fade">
          <div class="slideshow-numbertext">3 / 3</div>
          <img
            src="https://www.w3schools.com/howto/img_nature_wide.jpg"
            style="width: 100%"
          />
          <div class="slideshow-text">Caption Three</div>
        </div>

        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
        <a class="next" onclick="plusSlides(1)">&#10095;</a>

        <br />
      </div>
      <div style="text-align: center">
        <span class="slideshow-dot" onclick="currentSlide(1)"></span>
        <span class="slideshow-dot" onclick="currentSlide(2)"></span>
        <span class="slideshow-dot" onclick="currentSlide(3)"></span>
      </div>

      <div class="row news-content border px-3" v-html="news.html_content"></div>

      <div class="news-source text-right font-italic">
        Theo <span class="font-weight-bold">{{ news.source }}</span>
      </div>
    </div>
    <Footer />
  </div>
</template>

<script>
import Header from "../common/Header";
import Footer from "../common/Footer";
import NewsService from "../../service/NewsService";

export default {
  name: "NewsPage",
  data() {
    return {
      newsId: "",
      news: "",
    };
  },
  head: {
    script: [{ src: "/news/news-detail.js" }],
  },
  components: {
    Header,
    Footer,
  },
  methods: {
    refreshNewsDetail() {
      NewsService.retrieveNewsDetail(this.newsId).then((response) => {
        this.news = response.data;
        document.title = this.news.title;
      });
    },
  },
  created() {
    this.newsId = this.$route.params.id;
    this.refreshNewsDetail();
  },
};
</script>