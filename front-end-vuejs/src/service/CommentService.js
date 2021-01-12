import axios from "axios";
import UrlCommon from "../constant/UrlCommon.js";

class CommentService {
  retrieveNewestCommentToHome() {
    return axios.get(UrlCommon.API + "/comments/newest");
  }
}

export default new CommentService();
