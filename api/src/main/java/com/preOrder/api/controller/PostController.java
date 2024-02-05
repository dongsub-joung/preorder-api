package com.preOrder.api.controller;

import com.preOrder.api.domain.Post;
import com.preOrder.api.dto.ResponseDto;
import com.preOrder.api.service.PostService;
import com.preOrder.api.utils.Err;
import com.preOrder.api.utils.PassResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

//    Post CRUD
    @PostMapping(value = "/api/post/{author_id}/create/{title}")
    public ResponseDto<?> createPost(@PathVariable String author_id
            , @PathVariable String title
            , @RequestParam String body
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

//        var author_id= httpServletRequest.getRequestId();
        var flag= postService.createPost(title, body, author_id);
        if (flag)
            return ResponseDto.success(PassResponse.CREATE_DONE);
        return ResponseDto.fail(Err.CREATE_ERR, Err.ERR_MSG);
    }

    @GetMapping("/api/post/{post_id}")
    public ResponseDto<?> deletePosts(@PathVariable String post_id,
                                   HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var flag= postService.deletePost(post_id);

        if (flag)
            return ResponseDto.success(PassResponse.DEL_DONE);
        return ResponseDto.fail(Err.DEL_ERR, Err.ERR_MSG);
    }

    @PutMapping("/api/post/{author_id}/update")
    public ResponseDto<?> updatePost(
            @PathVariable String author_id
            , @RequestParam String title
            , @RequestParam String body
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        Post oldPost= postService.getPost(author_id);
        Post newPost= new Post(title, body);

        var flag= postService.updatePost(oldPost, newPost);

        if (flag)
            return ResponseDto.success(PassResponse.UPDATE_DONE);
        return ResponseDto.fail(Err.UPDATE_ERR, Err.ERR_MSG);
    }

    @GetMapping("/api/posts/{author_id}")
    public ResponseDto<?> getPosts(@PathVariable String author_id,
                                   HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var data= postService.getPosts(author_id);

        if (!data.isEmpty())
            return ResponseDto.success(data);
        return ResponseDto.fail(Err.GET_ERR, Err.ERR_MSG);
    }

    @GetMapping("/api/posts")
    public ResponseDto<?> listUpPosts(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        var data= postService.listUpPosts();

        if (!data.isEmpty())
            return ResponseDto.success(data);
        return ResponseDto.fail(Err.GET_ERR, Err.ERR_MSG);
    }
}
