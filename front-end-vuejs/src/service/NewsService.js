import axios from "axios";
import UrlCommon from "../constant/UrlCommon";
class NewsService {
  retrieveLastestNews() {
    return axios.get(UrlCommon.API + "/news/lastest");
  }
}

export default new NewsService();
