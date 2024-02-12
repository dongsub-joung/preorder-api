package com.preOrder.api.dto.response;

import com.preOrder.api.domain.LikeMember;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class LikeMemberDto {
    long authorMemberId;
    long memberLikedId;
    ArrayList<Long> authorMemberIds;

    public LikeMemberDto(LikeMember likeMember) {
        this.authorMemberId = likeMember.getAuthorMemberId();
        this.memberLikedId = likeMember.getMemberLikedId();
    }

    public LikeMemberDto(ArrayList<LikeMember> likeMembers) {
        this.authorMemberIds= new ArrayList<>();
        for (var likeMember : likeMembers){
            this.authorMemberIds.add(likeMember.getAuthorMemberId());
        }
    }
}
