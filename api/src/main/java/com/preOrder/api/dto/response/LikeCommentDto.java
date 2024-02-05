package com.preOrder.api.dto.response;

import com.preOrder.api.domain.LikeComment;
import com.preOrder.api.domain.LikePost;
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
    ArrayList<Long> authorMemberIds;

    public LikeCommentDto(LikeComment likeComment) {
        this.authorMemberId = likeComment.getAuthorMemberId();
        this.commentLikedId = likeComment.getCommentLikedId();
    }

    public LikeCommentDto(ArrayList<LikeComment> likeComments) {
        this.authorMemberIds= new ArrayList<>();
        for (var likeComment : likeComments){
            this.authorMemberIds.add(likeComment.getAuthorMemberId());
        }
    }
}
