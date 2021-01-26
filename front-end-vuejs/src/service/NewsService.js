import axios from "axios";
import UrlCommon from "../constant/UrlCommon.js";
class NewsService {
  retrieveLatestNews(page) {
    return axios.get(UrlCommon.API + "/news/latest?page=" + page);
  }

  retrieveNewsDetail(newsId) {
    return axios.get(UrlCommon.API + "/news/detail/" + newsId);
  }
}

export default new NewsService();
