package com.preOrder.api.domain;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "name")
    String name;
    @Column(name = "hashed_pw")
    String hashed_pw;
    @Column(name = "hashed_ph")
    String hashed_ph;
    @Column(name = "hashed_email")
    String hashed_email;
    @Column(name = "address")
    String address;
    @Column(name = "profile_img_url")
    String profile_img_url;
    @Column(name = "member_description")
    String member_description;
    @Column(name = "post_ids")
    @ElementCollection
    ArrayList<Long> post_ids;
}
