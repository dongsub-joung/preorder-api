package com.preOrder.api.controller;

import com.preOrder.api.dto.ResponseDto;
import com.preOrder.api.service.LikedCommentService;
import com.preOrder.api.service.LikedMemberService;
import com.preOrder.api.service.LikedPostService;
import com.preOrder.api.utils.Err;
import com.preOrder.api.utils.PassResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LikeController {
    private final LikedMemberService likedMemberService;
    private final LikedPostService likedPostService;
    private final LikedCommentService likedCommentService;

//    @todo) pathVariable -> get id from token
    @PostMapping(value = "/api/like/user/create/{id}")
    public ResponseDto<?> createUserLike(@PathVariable String id
            , @RequestParam String userId
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        var flag= likedMemberService.createMemberLike(id, userId);
        if (flag)
            return ResponseDto.success(PassResponse.CREATE_DONE);
        return ResponseDto.fail(Err.CREATE_ERR, Err.ERR_MSG);
    }
    @PostMapping(value = "/api/like/post/create/{id]")
    public ResponseDto<?> createPostLike(@PathVariable String id
            , @RequestParam String postId
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        var flag= likedPostService.createPostLike(id, postId);
        if (flag)
            return ResponseDto.success(PassResponse.CREATE_DONE);
        return ResponseDto.fail(Err.CREATE_ERR, Err.ERR_MSG);
    }
    @PostMapping(value = "/api/like/comment/create/{id}")
    public ResponseDto<?> createCommentLike(@PathVariable String id
            , @RequestParam String commentId
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        var flag= likedCommentService.createCommentLike(id, commentId);
        if (flag)
            return ResponseDto.success(PassResponse.CREATE_DONE);
        return ResponseDto.fail(Err.CREATE_ERR, Err.ERR_MSG);
    }


//    @todo deleting id -> token id
    @GetMapping("/api/like/{id}/{likedMemberId}")
    public ResponseDto<?> deleteMemberLike(@PathVariable String id
            , @PathVariable String likedMemberId
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var flag= likedMemberService.deleteMemberLike(id, likedMemberId);

        if (flag)
            return ResponseDto.success("Done - " + Err.DEL_ERR);
        return ResponseDto.fail(Err.DEL_ERR, Err.ERR_MSG);
    }
    @GetMapping("/api/like/{id}/{likedPostId}")
    public ResponseDto<?> deletePostLike(@PathVariable String id
            , @PathVariable String likedPostId
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var flag= likedPostService.deletePostLike(id, likedPostId);

        if (flag)
            return ResponseDto.success("Done - " + Err.DEL_ERR);
        return ResponseDto.fail(Err.DEL_ERR, Err.ERR_MSG);
    }
    @GetMapping("/api/like/{userLikeNumber}")
    public ResponseDto<?> deleteCommentLike(@PathVariable String id
            , @PathVariable String likedCommentId
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var flag= likedCommentService.deleteCommentLike(id, likedCommentId);

        if (flag)
            return ResponseDto.success("Done - " + Err.DEL_ERR);
        return ResponseDto.fail(Err.DEL_ERR, Err.ERR_MSG);
    }


//    @todo getting
    @GetMapping("/api/likes/member/{memberId}")
    public ResponseDto<?> getLikesOnMember(@PathVariable String memberId,
                                   HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var likes= likeService.getLikeOneMember(memberId);

        if (likes != null)
            return ResponseDto.success(likes);
        return ResponseDto.fail(Err.GET_ERR, Err.ERR_MSG);
    }
    @GetMapping("/api/likes/post/{postId}")
    public ResponseDto<?> getLikesOnPost(@PathVariable String postId,
                                         HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var likes= likeService.getLikeOnPost(postId);

        if (likes != null)
            return ResponseDto.success(likes);
        return ResponseDto.fail(Err.GET_ERR, Err.ERR_MSG);
    }
    @GetMapping("/api/likes/comments/{commentId}")
    public ResponseDto<?> getLikesOnComment(@PathVariable String commentId,
                                         HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var likes= likeService.getLikeOneComment(commentId);

        if (likes != null)
            return ResponseDto.success(likes);
        return ResponseDto.fail(Err.GET_ERR, Err.ERR_MSG);
    }
}
