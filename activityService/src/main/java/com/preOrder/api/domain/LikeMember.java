package com.preOrder.api.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikeMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "authorMemberId")
    long authorMemberId;
    @Column(name = "memberLikedId")
    long memberLikedId;

    public LikeMember(long authorMemberId, long memberLikedId) {
        this.authorMemberId = authorMemberId;
        this.memberLikedId = memberLikedId;
    }
}
