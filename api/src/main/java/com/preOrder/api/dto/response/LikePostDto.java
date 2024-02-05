package com.preOrder.api.dto.response;

import com.preOrder.api.domain.LikeMember;
import com.preOrder.api.domain.LikePost;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class LikePostDto {
    long authorMemberId;
    long postLikedId;
    ArrayList<Long> authorMemberIds;

    public LikePostDto(LikePost likePost) {
        this.authorMemberId = likePost.getAuthorMemberId();
        this.postLikedId = likePost.getPostLikedId();
    }

    public LikePostDto(ArrayList<LikePost> likePosts) {
        this.authorMemberIds= new ArrayList<>();
        for (var likePost : likePosts){
            this.authorMemberIds.add(likePost.getAuthorMemberId());
        }
    }
}
