package com.preOrder.api.domain;

import com.preOrder.api.dto.request.MemberCreateReqDto;
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
    String hashedPw;
    @Column(name = "hashed_ph")
    String hashedPh;
    @Column(name = "email")
    String email;
    @Column(name = "address")
    String address;
    @Column(name = "profile_img_url")
    String profile_img_url;
    @Column(name = "member_description")
    String memberDescription;

    public Member(MemberCreateReqDto createReqDto) {
        this.name = createReqDto.getName();
        this.hashedPw = createReqDto.getHashedPw();
        this.hashedPh = createReqDto.getHashedPh();
        this.email = createReqDto.getEmail();
        this.address = createReqDto.getAddress();
        this.profile_img_url = createReqDto.getProfileImgUrl();
        this.memberDescription = createReqDto.getDescription();
    }
}
