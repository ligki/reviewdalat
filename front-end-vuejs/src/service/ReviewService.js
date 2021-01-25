import axios from "axios";
import UrlCommon from "../constant/UrlCommon.js";

class ReviewService {
  // reviewType in: place, coffee-shop, hotel, food
  retrieveNewest(reviewType, page) {
    return axios.get(UrlCommon.API + "/reviews/" + reviewType + "/newest?page=" + page);
  }

  retrieveBest(reviewType, page) {
    return axios.get(UrlCommon.API + "/reviews/" + reviewType + "/best?page=" + page);
  }

  retrieveWorst(reviewType, page) {
    return axios.get(UrlCommon.API + "/reviews/" + reviewType + "/worst?page=" + page);
  }

  retrieveDetail(reviewType, id) {
    return axios.get(UrlCommon.API + "/reviews/" + reviewType + "/" + id);
  }
  searchReviews(query) {
    return axios.get(UrlCommon.API + "/reviews/search?query=" + query);
  }
  retrieveAllPageReviews(reviewType) {
    return axios.get(UrlCommon.API + "/reviews/" + reviewType + "/all-pages");
  }
}

export default new ReviewService();
