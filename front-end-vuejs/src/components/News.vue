<template>
    <div class="home-tip row border border-primary mb-3">
      <h2 class="col text-success"><i class="fas fa-check pr-1"></i>Tin tức và chia sẻ</h2>
      <div class="container">
        <a v-for="news in latestNews" v-bind:key="news.id" :href="'/news/' + news.id" class="row border-bottom px-4 py-1 tip">
          <img class="rounded float-left pr-1" width="100x100" v-bind:src="news.title_image" data-holder-rendered="true">
          <div>
            <div class="font-weight-bold"><i class="far fa-hand-point-right"></i>{{news.title}}</div>
            <div class="font-italic text-dark"><i class="fas fa-calendar-alt pr-1"></i>{{news.created}}</div>
          </div>
        </a>
        <a href="#" class="float-right py-2 pr-3">Xem tất cả</a>
      </div>
    </div>
</template>

<script>
import NewsService from '../service/NewsService';
export default {
    name: "News",
    data() {
      return {
        latestNews : []
      }
    },
    methods: {
      refreshNews() {
        NewsService.retrieveLatestNews()
          .then(response => {
            this.latestNews = response.data;
          });
      }
    },
    created() {
      this.refreshNews();
    },
}
</script>