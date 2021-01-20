package com.ligki.reviewdalat.model.requesttype;

import com.ligki.reviewdalat.annotation.validation.MemberOf;
import lombok.Data;

@Data
public class CommentReact {
    String author;
    String context;
    @MemberOf(accepted = {"like", "dislike", "comment", "report"})
    String type;
}
