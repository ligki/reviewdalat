import axios from "axios";
import UrlCommon from "../constant/UrlCommon";
class NewsService {
  retrieveLastestNews() {
    // return axios.get(UrlCommon.API + "/news/lastest");
    axios.get(UrlCommon.API + "/news/lastest");
    return "123"
  }
}

export default new NewsService();
