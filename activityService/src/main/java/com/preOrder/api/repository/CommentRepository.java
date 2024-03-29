package com.preOrder.api.repository;

import com.preOrder.api.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<ArrayList<Comment>> findAllByPostId(Long postId);
    Optional<ArrayList<Comment>> findAllByMemberId(Long memberId);
}
