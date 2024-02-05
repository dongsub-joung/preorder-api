package com.preOrder.api.service;

import com.preOrder.api.domain.LikeMember;
import com.preOrder.api.dto.response.LikeMemberDto;
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

    public boolean deleteMemberLike(String id, String likedMemberId) {
        try {
            var like= likeMemberRepository.findByAuthorMemberIdAndMemberLikedId
                    (Long.parseLong(id), Long.parseLong(likedMemberId)).orElseThrow();
            likeMemberRepository.delete(like);
        }catch (Exception e){
            System.err.println(e + Err.DEL_ERR);
            return false;
        }
        return true;
    }

    //    @todo id token
    public LikeMemberDto getLikeOneMember(String id, String likedMemberId) {
        try {
            var like= likeMemberRepository.findByAuthorMemberIdAndMemberLikedId
                    (Long.parseLong(id), Long.parseLong(likedMemberId)).orElseThrow();
            return new LikeMemberDto(like);
        }catch (Exception e){
            System.err.println(e + Err.GET_ERR);
        }
        return null;
    }

    public LikeMemberDto getLikesOneMember(String id) {
        try {
            var like= likeMemberRepository.findAllByAuthorMemberId
                    (Long.parseLong(id)).orElseThrow();
            return new LikeMemberDto(like);
        }catch (Exception e){
            System.err.println(e + Err.GET_ERR);
        }
        return null;
    }
}
