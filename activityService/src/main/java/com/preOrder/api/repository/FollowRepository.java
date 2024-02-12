package com.preOrder.api.repository;

import com.preOrder.api.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<ArrayList<Follow>> findAllByMemberId(long memberId);
    Optional<Follow> findAllByMemberIdAndFollowingUser(long memberId, long followingUser);
}
