package com.preOrder.api.dto.response;

import com.preOrder.api.domain.LikeMember;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LikeMemberDto {
    long authorMemberId;
    long memberLikedId;

    public LikeMemberDto(LikeMember likeMember) {
        this.authorMemberId = likeMember.getAuthorMemberId();
        this.memberLikedId = likeMember.getMemberLikedId();
    }
}
