package com.preOrder.api.domain;

import jakarta.persistence.*;

import lombok.*;
@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikeFunction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "statusNumber")
    long statusNumber;
    @Column(name = "userLikeNumber")
    long userLikeNumber;
    @Column(name = "postLikeNumber")
    long postLikeNumber;
    @Column(name = "commentLikeNumber")
    long commentLikeNumber;

    public LikeFunction(long status, long id) {
        if (status == 0){
            this.userLikeNumber = id;
        } else if (status == 1) {
            this.postLikeNumber = id;
        } else if (status == 2) {
            this.commentLikeNumber =id;
        }
    }
}