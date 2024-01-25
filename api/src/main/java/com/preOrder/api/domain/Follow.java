package com.preOrder.api.domain;

public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "member_id")
    String member_id;
    @Column(name = "count")
    String count;
}
