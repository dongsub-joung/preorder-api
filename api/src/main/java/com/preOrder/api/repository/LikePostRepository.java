package com.preOrder.api.repository;

import com.preOrder.api.domain.LikePost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikePostRepository extends JpaRepository<LikePost, Long> {
    Optional<LikePost> findByAuthorMemberIdAndPostLikedId(long id, long liked);
}
