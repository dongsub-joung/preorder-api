package com.preOrder.api.dto.response;

import com.preOrder.api.domain.LikeComment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class LikeCommentDto {
    long authorMemberId;
    long commentLikedId;

    public LikeCommentDto(LikeComment likeComment) {
        this.authorMemberId = likeComment.getAuthorMemberId();
        this.commentLikedId = likeComment.getCommentLikedId();
    }
}
