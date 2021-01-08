import axios from "axios";
import UrlCommon from "../constant/UrlCommon.js";

class ReviewService {
    retrieveNewestPlace() {
        return axios.get(UrlCommon.API + "/reviews/place/newest");
    }
}

export default new ReviewService();