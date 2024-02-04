package com.preOrder.api.repository;

import com.preOrder.api.domain.LikePost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikePostRepository extends JpaRepository<LikePost, Long> {
}
