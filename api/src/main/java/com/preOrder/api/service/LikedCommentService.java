package com.preOrder.api.service;

import com.preOrder.api.domain.LikeComment;
import com.preOrder.api.dto.response.LikeCommentDto;
import com.preOrder.api.repository.LikeCommentRepository;
import com.preOrder.api.utils.Err;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikedCommentService {
    private final LikeCommentRepository likeCommentRepository;

    public boolean createCommentLike(String authorMemberId, String commentId) {
        try {
            likeCommentRepository.save(new LikeComment(Long.parseLong(authorMemberId), Long.parseLong(commentId)));
        }catch (Exception e){
            System.err.println(e + Err.CREATE_ERR);
            return false;
        }
        return true;
    }
    public LikeCommentDto getLikeOneComment(String commentId) {
        return null;
    }
    public boolean deleteCommentLike(String userCommentNumber, String likedCommentId) {
        return true;
    }
}
