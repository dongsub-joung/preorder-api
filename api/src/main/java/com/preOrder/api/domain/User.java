package com.preOrder.api.domain;

import java.util.ArrayList;

public class User {
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

//    https://stackoverflow.com/questions/287201/how-to-persist-a-property-of-type-liststring-in-jpa
    @Column(name = "member_description")
    String member_description;
    @Column(name = "post_ids")
    ArrayList<Long> post_ids;
}
