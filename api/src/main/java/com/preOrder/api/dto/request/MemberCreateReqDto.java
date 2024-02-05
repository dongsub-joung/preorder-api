package com.preOrder.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberCreateReqDto {
    String name;
    String hashedPw;
    String hashedPh;
    String email;
    String address;
    String profileImgUrl;
    String description;
}
