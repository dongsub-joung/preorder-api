package com.preOrder.api.service;

import com.preOrder.api.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    public boolean createPostLike(String postId) {
        return true;
    }

    public boolean createCommentLike(String commentId) {
        return true;
    }

    public boolean createUserLike(String userId) {
        return true;
    }

    public boolean deleteUserLike(String userLikeNumber) {
        return true;
    }

    public boolean deletePostLike(String userPostNumber) {
        return true;
    }

    public boolean deleteCommentLike(String userCommentNumber) {
        return true;
    }
}
