package com.preOrder.api.repository;

import com.preOrder.api.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<ArrayList<Like>> findAllByPostId(Long post_id);
}
