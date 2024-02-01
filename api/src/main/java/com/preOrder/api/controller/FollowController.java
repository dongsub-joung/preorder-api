package com.preOrder.api.controller;

import com.preOrder.api.domain.Post;
import com.preOrder.api.dto.ResponseDto;
import com.preOrder.api.service.FollowService;
import com.preOrder.api.utils.Err;
import com.preOrder.api.utils.PassResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

public class FollowController {
    private static FollowService followService;

    //    Follow CRUD
    @PostMapping(value = "/api/follow/create/{memberId}/{followingUserId}")
    public ResponseDto<?> createFollow(
            @PathVariable String memberId
            , @PathVariable String followingUserId
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        boolean flag= false;

        try {
            flag= followService.createFollower(memberId, followingUserId);
        }catch (Exception e){
            System.err.println(e + Err.ERR_MSG);
        }

        if (flag)
            return ResponseDto.success(PassResponse.CREATE_DONE);
        return ResponseDto.fail(Err.CREATE_ERR, Err.CREATE_ERR);
    }

    @GetMapping("/api/post/{post_id}")
    public ResponseDto<?> deletePosts(@PathVariable String post_id,
                                      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var flag= postSerivce.deletePost(post_id);

        if (flag)
            return ResponseDto.success("Done - " + Err.DEL_ERR);
        return ResponseDto.fail("Getting post", Err.ERR_MSG);
    }

    @PutMapping("/api/post/update")
    public ResponseDto<?> updatePost(
            @RequestBody String id
            , @RequestBody String title
            , @RequestBody String body
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        Post oldPost= postSerivce.getPost(id);
        Post newPost= new Post(title, body);

        var flag= postSerivce.updatePost(oldPost, newPost);

        if (flag)
            return ResponseDto.success("Done - " + Err.UPDATE_ERR);
        return ResponseDto.fail("Update post", Err.ERR_MSG);
    }

    @GetMapping("/api/posts/{author_id}")
    public ResponseDto<?> getPosts(@PathVariable String author_id,
                                   HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var data= postSerivce.getPosts(author_id);

        if (!data.isEmpty())
            return ResponseDto.success(data);
        return ResponseDto.fail("Getting post", Err.ERR_MSG);
    }

    @GetMapping("/api/posts")
    public ResponseDto<?> listUpPosts(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var data= postSerivce.listUpPosts();

        if (!data.isEmpty())
            return ResponseDto.success(data);
        return ResponseDto.fail("ListUp post", Err.ERR_MSG);
    }
}
