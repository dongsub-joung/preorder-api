package com.preOrder.api.dto.response;


import com.preOrder.api.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FollowerResponseDto {
    Long memberId;
    String name;

    public FollowerResponseDto(Member member) {
        this.memberId = member.getId();
        this.name = member.getName();
    }
}
