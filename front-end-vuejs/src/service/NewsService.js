import axios from "axios";
import UrlCommon from "../constant/UrlCommon.js";
class NewsService {
  retrieveLatestNews() {
    return axios.get(UrlCommon.API + "/news/latest");
  }
}

export default new NewsService();
