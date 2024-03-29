package com.preOrder.api.domain;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "postId")
    long postId;
    @Column(name = "memberId")
    long memberId;
    @Column(name = "body")
    String body;

    public Comment(long postId, long memberId, String body) {
        this.postId = postId;
        this.memberId = memberId;
        this.body = body;
    }
}
