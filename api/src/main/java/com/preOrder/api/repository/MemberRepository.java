package com.preOrder.api.repository;

import com.preOrder.api.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(long id );
    Optional<Member> findByName(String member_name);
}
