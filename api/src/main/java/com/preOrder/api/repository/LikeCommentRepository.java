package com.preOrder.api.repository;

import com.preOrder.api.domain.LikeComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface LikeCommentRepository extends JpaRepository<LikeComment, Long> {
    Optional<LikeComment> findByAuthorMemberIdAndCommentLikedId(long id, long liked);
}
