package com.preOrder.api.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "authorMemberId")
    long authorMemberId;
    @Column(name = "postLikedId")
    long postLikedId;

    public LikePost(long authorMemberId, long postLikedId) {
        this.authorMemberId = authorMemberId;
        this.postLikedId = postLikedId;
    }
}
