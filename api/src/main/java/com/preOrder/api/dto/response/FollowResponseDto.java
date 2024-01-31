package com.preOrder.api.dto.response;

import com.preOrder.api.domain.Follow;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FollowResponseDto {
    long memberId;
    long followingUser;

    public FollowResponseDto(Follow follow) {
        this.memberId = follow.getMemberId();
        this.followingUser = follow.getFollowingUser();
    }
}
