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
    @Column(name = "post_id")
    long post_id;
    @Column(name = "count")
    long count;
    @Column(name = "liked_user_id_list")
    long liked_user_id_list;
}
