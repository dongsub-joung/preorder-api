package com.preOrder.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommentsOnMemberResponseDto {
    long memberId;
    String body;
}
