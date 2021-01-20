import axios from "axios";
import UrlCommon from "../constant/UrlCommon.js";

class CommentService {
  retrieveNewestCommentToHome() {
    return axios.get(UrlCommon.API + "/comments/newest");
  }
  retrieveDetailComment(reviewObjectId) {
    return axios.get(UrlCommon.API + "/comments/detail/" + reviewObjectId);
  }
  addComment(reviewObjectId, comment) {
    return axios.post(UrlCommon.API + "/comments/" + reviewObjectId, comment);
  }
  addCommentReact(commentId, commentReact) {
    return axios.post(UrlCommon.API + "/comments/react-comment/" + commentId, commentReact);
  }
}

export default new CommentService();
