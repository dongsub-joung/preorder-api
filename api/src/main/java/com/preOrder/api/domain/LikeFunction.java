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
    @Column(name = "postNumber")
    long postNumber;
    @Column(name = "likedUser")
    long likedUser;
}
