package com.preOrder.api.service;

import com.preOrder.api.domain.LikePost;
import com.preOrder.api.dto.response.LikeMemberDto;
import com.preOrder.api.dto.response.LikePostDto;
import com.preOrder.api.repository.LikePostRepository;
import com.preOrder.api.utils.Err;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikedPostService {
    private final LikePostRepository likePostRepository;

    public boolean createPostLike(String authorMemberId, String postId) {
        try {
            likePostRepository.save(new LikePost(Long.parseLong(authorMemberId), Long.parseLong(postId)));
        }catch (Exception e){
            System.err.println(e + Err.CREATE_ERR);
            return false;
        }
        return true;
    }
    public boolean deletePostLike(String id, String likedPostId) {
        try {
            var like= likePostRepository.findByAuthorMemberIdAndPostLikedId
                    (Long.parseLong(id), Long.parseLong(likedPostId)).orElseThrow();
            likePostRepository.delete(like);
        }catch (Exception e){
            System.err.println(e + Err.DEL_ERR);
            return false;
        }
        return true;
    }
    public LikePostDto getLikeOnPost( String id, String likedMemberId) {
        try {
            var like= likePostRepository.findByAuthorMemberIdAndPostLikedId
                    (Long.parseLong(id), Long.parseLong(likedMemberId)).orElseThrow();
            return new LikePostDto(like);
        }catch (Exception e){
            System.err.println(e + Err.GET_ERR);
        }
        return null;
    }
}
