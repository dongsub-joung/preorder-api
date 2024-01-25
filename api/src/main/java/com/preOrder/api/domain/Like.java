package com.preOrder.api.domain;

import jakarta.persistence.*;

import java.util.ArrayList;

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
