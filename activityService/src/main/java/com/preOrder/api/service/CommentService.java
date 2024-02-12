package com.preOrder.api.service;

import com.preOrder.api.domain.Comment;
import com.preOrder.api.dto.response.CommentsOnMemberResponseDto;
import com.preOrder.api.dto.response.CommentsResponseDto;
import com.preOrder.api.repository.CommentRepository;
import com.preOrder.api.utils.Err;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public ArrayList<CommentsOnMemberResponseDto> getCommentsOnMember(String memberId){
        ArrayList<CommentsOnMemberResponseDto> commentResDto= new ArrayList<>();
        try {
            var commentsOnMember= commentRepository.findAllByMemberId(Long.parseLong(memberId)).orElseThrow();
            for (var comment : commentsOnMember){
                commentResDto.add(new CommentsOnMemberResponseDto(comment.getMemberId(), comment.getBody()));
            }
            return commentResDto;
        }catch (Exception e){
            System.err.println(e + Err.GET_ERR);
        }
        return null;
    }

    public ArrayList<Comment> getComments(String postId){
        try {
            return commentRepository.findAllByPostId(Long.parseLong(postId)).orElseThrow();
        }catch (Exception e){
            System.err.println(e + "find all by author id");
        }
        return null;
    }

    public ArrayList<CommentsResponseDto> getAllCommentsOnPost(String postId){
        ArrayList<CommentsResponseDto> commentsDtoList= new ArrayList<>();
        try {
            var comments= commentRepository.findAllByPostId(Long.parseLong(postId)).orElseThrow();
            for (var comment : comments){
                commentsDtoList.add(new CommentsResponseDto(comment.getBody()));
            }
            return commentsDtoList;
        }catch (Exception e){
            System.err.println(e + Err.GET_ERR);
        }
        return null;
    }


    public boolean createComment(String postId, String memberId, String body){
        Comment comment= new Comment(Long.parseLong(postId), Long.parseLong(memberId), body);
        try {
            commentRepository.save(comment);
        }catch (Exception e){
            System.err.println(e + Err.CREATE_ERR);
            return false;
        }
        return true;
    }

    public boolean deleteComment(String commentId){
        try {
            commentRepository.deleteById(Long.parseLong(commentId));
        }catch (Exception e){
            System.err.println(e + Err.DEL_ERR);
            return false;
        }
        return true;
    }

    public boolean updateComment(String commentId, String title, String body){
        Comment comment;
        try {
            var oldComment= commentRepository.findById(Long.parseLong(commentId))
                            .orElseThrow();
            var postID= oldComment.getPostId();
            var memberId= oldComment.getMemberId();

            commentRepository.delete(oldComment);

            comment= new Comment(postID, memberId, body);

            commentRepository.save(comment);
        }catch (Exception e){
            System.err.println(e + Err.UPDATE_ERR);
            return false;
        }
        return true;
    }
}
