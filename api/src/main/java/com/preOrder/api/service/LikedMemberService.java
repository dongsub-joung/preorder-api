package com.preOrder.api.service;

import com.preOrder.api.domain.LikeMember;
import com.preOrder.api.dto.response.LikeUserDto;
import com.preOrder.api.repository.LikeMemberRepository;
import com.preOrder.api.utils.Err;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class LikedMemberService {
    private final LikeMemberRepository likeMemberRepository;
    public boolean createMemberLike(String authorMemberId, String memberId) {
        try {
            likeMemberRepository.save(new LikeMember(Long.parseLong(authorMemberId), Long.parseLong(memberId)));
        }catch (Exception e){
            System.err.println(e + Err.CREATE_ERR);
            return false;
        }
        return true;
    }

    public boolean deleteMemberLike(String userLikeNumber, String likedMemberId) {
        try {
            var like= likeMemberRepository.findByUserLikeNumber(Long.parseLong(userLikeNumber)).orElseThrow();
            likeCommentRepository.delete(like);
        }
        return true;
    }

    //    @todo gets
    public LikeUserDto getLikeOneMember(String memberId) {
        return null;
    }


}
