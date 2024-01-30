package com.preOrder.api.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "email")
    String email;
    @Column(name = "address")
    String address;
    @Column(name = "profile_img_url")
    String profile_img_url;
    @Column(name = "member_description")
    String member_description;

    public Member(String name, String hashed_pw) {
        this.name = name;
        this.hashed_pw = hashed_pw;
    }
}
