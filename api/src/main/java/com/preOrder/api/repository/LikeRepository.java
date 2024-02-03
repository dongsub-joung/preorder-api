package com.preOrder.api.repository;

import com.preOrder.api.domain.LikeFunction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<LikeFunction, Long> {
    Optional<ArrayList<LikeFunction>> findByUserLikeNumber(long userLikeNumber);
    Optional<ArrayList<LikeFunction>> findByPostLikeNumber(long postLikeNumber);
    Optional<ArrayList<LikeFunction>> findByCommentLikeNumber(long commentLikeNumber);
}
