package com.preOrder.api.service;

import com.preOrder.api.domain.Follow;
import com.preOrder.api.dto.response.FollowResponseDto;
import com.preOrder.api.dto.response.FollowerResponseDto;
import com.preOrder.api.dto.response.FollowingMemberResponseDto;
import com.preOrder.api.repository.FollowRepository;
import com.preOrder.api.repository.MemberRepository;
import com.preOrder.api.utils.Err;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository followRepository;
    private final MemberRepository memberRepository;

    public boolean createFollower(String memberId, String followingUserId){
        Follow follow= new Follow(Long.parseLong(memberId), Long.parseLong(followingUserId));
        try {
            followRepository.save(follow);
        }catch (Exception e){
            System.err.println(e + Err.CREATE_ERR);
            return false;
        }
        return true;
    }

    public boolean deleteFollower(String followId){
        try {
            followRepository.deleteById(Long.parseLong(followId));
        }catch (Exception e){
            System.err.println(e + Err.CREATE_ERR);
            return false;
        }
        return true;
    }

    public FollowingMemberResponseDto getMyFollowInfo(String memberId){
        try {
            var data= followRepository.findAllByMemberId(Long.parseLong(memberId))
                    .orElseThrow();
            ArrayList<FollowerResponseDto> followers= new ArrayList<>();
            for (var follower : data){
                try {
                    var member= memberRepository.findById(follower.getFollowingUser()).orElseThrow();
                    FollowerResponseDto followerResponseDto= new FollowerResponseDto(member);
                    followers.add(followerResponseDto);
                }catch (Exception e){
                    System.err.println(e + "can't get a following user id");
                    return null;
                }
            }

            return new FollowingMemberResponseDto(followers);
        }catch (Exception e){
            System.err.println(e + Err.GET_ERR);
        }

        return null;
    }
    public long getFollowSize(String memberId){
        try {
            return followRepository.findAllByMemberId(Long.parseLong(memberId))
                    .orElseThrow().size();
        }catch (Exception e){
            System.err.println(e + Err.GET_ERR);
        }
        return 0;
    }
    public FollowResponseDto getTheFollowInfo(String memberId, String followingUser){
        try {
            var data= followRepository.findAllByMemberIdAndFollowingUser
                            (Long.parseLong(memberId), Long.parseLong(followingUser))
                    .orElseThrow();
            return new FollowResponseDto(data);
        }catch (Exception e){
            System.err.println(e + Err.GET_ERR);
        }

        return null;
    }
}
