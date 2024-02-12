package com.preOrder.api.dto.response;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowingMemberResponseDto {
    ArrayList<FollowerResponseDto> Followers;
}
