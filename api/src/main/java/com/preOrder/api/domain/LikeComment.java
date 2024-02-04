package com.preOrder.api.domain;

import jakarta.persistence.*;

import lombok.*;
@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikeComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "authorMemberId")
    long authorMemberId;
    @Column(name = "commentLikedId")
    long commentLikedId;

    public LikeComment(long authorMemberId, long commentLikedId) {
        this.authorMemberId = authorMemberId;
        this.commentLikedId = commentLikedId;
    }
}