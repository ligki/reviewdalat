<template>
  <div>
    <Header />
    <div class="container">
      <News />
      <div class="home-main row">
        <div class="col-sm-8 border border-primary">
          <ReviewElement type="place" />
          <ReviewElement type="coffee-shop" />
          <ReviewElement type="hotel" />
          <ReviewElement type="food" />
        </div>
        <SideBar />
      </div>
    </div>
    <Footer />
  </div>
</template>

<script>
import Header from "./common/Header.vue";
import News from "./News.vue";
import ReviewElement from "./ReviewElement.vue";
import SideBar from "./SideBar";
import Footer from "./common/Footer";

export default {
  name: "HomePage",
  components: {
    Header,
    News,
    ReviewElement,
    SideBar,
    Footer,
  },
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
  }
};
</script>

<style scoped>
</style>