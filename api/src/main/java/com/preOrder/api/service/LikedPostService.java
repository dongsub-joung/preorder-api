package com.preOrder.api.service;

import com.preOrder.api.domain.LikePost;
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
    public boolean deletePostLike(String userPostNumber, String likedPostId) {
        return true;
    }
    public LikePostDto getLikeOnPost(String postId) {
        return null;
    }
}
