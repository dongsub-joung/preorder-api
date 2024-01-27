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
    @Column(name = "post_id")
    long post_id;
    @Column(name = "member_id")
    long member_id;
    @Column(name = "body")
    String body;

}
