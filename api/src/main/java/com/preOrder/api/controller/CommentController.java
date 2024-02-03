package com.preOrder.api.controller;

import com.preOrder.api.domain.Comment;
import com.preOrder.api.dto.ResponseDto;
import com.preOrder.api.service.CommentService;
import com.preOrder.api.utils.Err;
import com.preOrder.api.utils.PassResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping(value = "/api/comment/create/{postId}/{memberId}")
    public ResponseDto<?> createComment(
            @PathVariable String postId
            , @PathVariable String memberId
            , @RequestBody String body
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        var flag= commentService.createComment(postId, memberId, body);
        if (flag) {
            return ResponseDto.success("Done" + PassResponse.CREATE_DONE);
        }
        return ResponseDto.fail(Err.CREATE_ERR, Err.ERR_MSG);
    }

    @GetMapping("/api/comment/{comment_id}")
    public ResponseDto<?> deleteComment(@PathVariable String comment_id,
                                      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var flag= commentService.deleteComment(comment_id);
        if (flag)
            return ResponseDto.success(PassResponse.DEL_DONE);
        return ResponseDto.fail(Err.DEL_ERR, Err.ERR_MSG);
    }

    @PutMapping("/api/comment/update/{id}")
    public ResponseDto<?> updateComment(
            @PathVariable String id
            , @RequestBody String title
            , @RequestBody String body
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        var flag= commentService.updateComment(id, title, body);

        if (flag)
            return ResponseDto.success("Done - " + Err.UPDATE_ERR);
        return ResponseDto.fail("Update post", Err.ERR_MSG);
    }

    @GetMapping("/api/comments/{postId}")
    public ResponseDto<?> getCommentsOnPost(@PathVariable String postId,
                                   HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var commentsBody= commentService.getAllCommentsOnPost(postId);

        if (commentsBody != null)
            return ResponseDto.success(commentsBody);
        return ResponseDto.fail(Err.GET_ERR, Err.ERR_MSG);
    }

    @GetMapping("/api/comments/{memberId}")
    public ResponseDto<?> getCommentsOnMember(@PathVariable String memberId
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var commentsOnMember= commentService.getCommentsOnMember(memberId);

        if (!commentsOnMember.isEmpty())
            return ResponseDto.success(commentsOnMember);
        return ResponseDto.fail("ListUp Err Comment on Member", Err.ERR_MSG);
    }
}
