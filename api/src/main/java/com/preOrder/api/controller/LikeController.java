package com.preOrder.api.controller;

import com.preOrder.api.domain.LikeFunction;
import com.preOrder.api.dto.ResponseDto;
import com.preOrder.api.service.LikeService;
import com.preOrder.api.utils.Err;
import com.preOrder.api.utils.PassResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @PostMapping(value = "/api/like/user/create")
    public ResponseDto<?> createUserLike(@RequestParam String userId
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        var flag= likeService.createUserLike(userId);
        if (flag)
            return ResponseDto.success(PassResponse.CREATE_DONE);
        return ResponseDto.fail(Err.CREATE_ERR, Err.ERR_MSG);
    }
    @PostMapping(value = "/api/like/post/create")
    public ResponseDto<?> createPostLike(@RequestParam String postId
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        var flag= likeService.createPostLike(postId);
        if (flag)
            return ResponseDto.success(PassResponse.CREATE_DONE);
        return ResponseDto.fail(Err.CREATE_ERR, Err.ERR_MSG);
    }
    @PostMapping(value = "/api/like/comment/create")
    public ResponseDto<?> createCommentLike(@RequestParam String commentId
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        var flag= likeService.createCommentLike(commentId);
        if (flag)
            return ResponseDto.success(PassResponse.CREATE_DONE);
        return ResponseDto.fail(Err.CREATE_ERR, Err.ERR_MSG);
    }

    @GetMapping("/api/like/{userLikeNumber}")
    public ResponseDto<?> deleteUserLike(@PathVariable String userLikeNumber,
                                      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var flag= likeService.deleteUserLike(userLikeNumber);

        if (flag)
            return ResponseDto.success("Done - " + Err.DEL_ERR);
        return ResponseDto.fail("Getting post", Err.ERR_MSG);
    }
    @GetMapping("/api/like/{userPostNumber}")
    public ResponseDto<?> deletePostLike(@PathVariable String userPostNumber,
                                         HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var flag= likeService.deletePostLike(userPostNumber);

        if (flag)
            return ResponseDto.success("Done - " + Err.DEL_ERR);
        return ResponseDto.fail("Getting post", Err.ERR_MSG);
    }
    @GetMapping("/api/like/{userLikeNumber}")
    public ResponseDto<?> deleteCommentLike(@PathVariable String userCommentNumber,
                                         HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var flag= likeService.deleteCommentLike(userCommentNumber);

        if (flag)
            return ResponseDto.success("Done - " + Err.DEL_ERR);
        return ResponseDto.fail("Getting post", Err.ERR_MSG);
    }

    @GetMapping("/api/posts/{author_id}")
    public ResponseDto<?> getPosts(@PathVariable String author_id,
                                   HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var data= .getPosts(author_id);

        if (!data.isEmpty())
            return ResponseDto.success(data);
        return ResponseDto.fail("Getting post", Err.ERR_MSG);
    }
}
