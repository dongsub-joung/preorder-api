package com.preOrder.api.service;

import com.preOrder.api.domain.Post;
import com.preOrder.api.repository.PostRepository;
import com.preOrder.api.utils.Err;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostSerivce {
    private final PostRepository postRepository;

    public List<Post> listUpPosts(){
        try {
            return postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        }catch (Exception e){
            System.err.println(e + Err.POST_GET);
        }
        return null;
    }

    public ArrayList<Post> getPosts(String author_id){
        try {
            return postRepository.findAllByAuthorId(Long.parseLong(author_id)).orElseThrow();
        }catch (Exception e){
            System.err.println(e + "find all by author id");
        }
        return null;
    }

    public Post getPost(String post_id){
        try {
            return postRepository.findById(Long.parseLong(post_id)).orElseThrow();
        }catch (Exception e){
            System.err.println(e + Err.POST_GET);
        }
        return null;
    }


    public boolean createPost(String title, String body, String author_id){
        Post post= new Post(title, body, Long.parseLong(author_id));
        try {
            postRepository.save(post);
        }catch (Exception e){
            System.err.println(e + Err.POST_CREATE);
            return false;
        }
        return true;
    }

    public boolean deletePost(String post_id){
        try {
            postRepository.deleteById(Long.parseLong(post_id));
        }catch (Exception e){
            System.err.println(e + Err.POST_DEL);
            return false;
        }
        return true;
    }

    public boolean updatePost(Post oldPost, Post newPost){
        try {
            postRepository.deleteById(oldPost.getId());
            postRepository.save(newPost);
        }catch (Exception e){
            System.err.println(e + Err.POST_UPDATE);
            return false;
        }
        return true;
    }
}
