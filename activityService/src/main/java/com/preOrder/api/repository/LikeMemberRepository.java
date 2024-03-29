package com.preOrder.api.repository;

import com.preOrder.api.domain.LikeMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface LikeMemberRepository extends JpaRepository<LikeMember, Long> {
    Optional<LikeMember> findByAuthorMemberIdAndMemberLikedId(long id, long liked);
    Optional<ArrayList<LikeMember>> findAllByAuthorMemberId(long id);
}
