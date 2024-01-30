package com.preOrder.api.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import lombok.*;
@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "postId")
    long postId;
    @Column(name = "likedUserIdList")
    long likedUserIdList;
}
