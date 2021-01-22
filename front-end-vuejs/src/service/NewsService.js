import axios from "axios";
import UrlCommon from "../constant/UrlCommon.js";
class NewsService {
  retrieveLatestNews() {
    return axios.get(UrlCommon.API + "/news/latest");
  }

  retrieveNewsDetail(newsId) {
    return axios.get(UrlCommon.API + "/news/detail/" + newsId);
  }
}

export default new NewsService();
