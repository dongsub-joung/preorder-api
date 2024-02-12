package com.preOrder.api.service;

import com.preOrder.api.domain.LikeComment;
import com.preOrder.api.dto.response.LikeCommentDto;
import com.preOrder.api.dto.response.LikeMemberDto;
import com.preOrder.api.dto.response.LikePostDto;
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
    public boolean deleteCommentLike(String id, String likedCommentId) {
        try {
            var like= likeCommentRepository.findByAuthorMemberIdAndCommentLikedId
                    (Long.parseLong(id), Long.parseLong(likedCommentId)).orElseThrow();
            likeCommentRepository.delete(like);
        }catch (Exception e){
            System.err.println(e + Err.DEL_ERR);
            return false;
        }
        return true;
    }
    public LikeCommentDto getLikeOneComment(String id, String likedMemberId) {
        try {
            var like= likeCommentRepository.findByAuthorMemberIdAndCommentLikedId
                    (Long.parseLong(id), Long.parseLong(likedMemberId)).orElseThrow();
            return new LikeCommentDto(like);
        }catch (Exception e){
            System.err.println(e + Err.GET_ERR);
        }
        return null;
    }

    public LikeCommentDto getLikesOnComment(String id) {
        try {
            var like= likeCommentRepository.findAllByAuthorMemberId
                    (Long.parseLong(id)).orElseThrow();
            return new LikeCommentDto(like);
        }catch (Exception e){
            System.err.println(e + Err.GET_ERR);
        }
        return null;
    }
}
