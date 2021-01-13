import axios from "axios";
import UrlCommon from "../constant/UrlCommon.js";

class ReviewService {
  // reviewType in: place, coffee-shop, hotel, food
  retrieveNewest(reviewType) {
    return axios.get(UrlCommon.API + "/reviews/" + reviewType + "/newest");
  }

  retrieveBest(reviewType) {
    return axios.get(UrlCommon.API + "/reviews/" + reviewType + "/best");
  }

  retrieveWorst(reviewType) {
    return axios.get(UrlCommon.API + "/reviews/" + reviewType + "/worst");
  }

  retrieveDetail(reviewType, id) {
    return axios.get(UrlCommon.API + "/reviews/" + reviewType + "/" + id);
  }
}

export default new ReviewService();
