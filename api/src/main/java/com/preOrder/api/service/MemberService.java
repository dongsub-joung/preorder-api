package com.preOrder.api.service;


import com.preOrder.api.domain.Member;
import com.preOrder.api.dto.request.MemberCreateReqDto;
import com.preOrder.api.repository.MemberRepository;
import com.preOrder.api.security.UserDetailsImpl;
import com.preOrder.api.utils.Err;
import com.preOrder.api.utils.Hash;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    //    이름, 프로필 이미지, 인사말을 업데이트 할 수 있다.
    public boolean changeName(long id, String name){
        try {
            var member= memberRepository.findById(id).orElseThrow();
            member.setName(name);
            memberRepository.save(member);
        }catch (Exception e){
            System.err.println(e + "can't set name");
            return false;
        }
        return true;
    }

    public boolean changeProfileImg(long id, String url){
        try {
            var member= memberRepository.findById(id).orElseThrow();
            member.setProfile_img_url(url);
            memberRepository.save(member);
        }catch (Exception e){
            System.err.println(e + "can't set image");
            return false;
        }
        return true;
    }

    public boolean changeDescription(long id, String desc){
        try {
            var member= memberRepository.findById(id).orElseThrow();
            member.setMemberDescription(desc);
            memberRepository.save(member);
        }catch (Exception e){
            System.err.println(e + "can't set desc");
            return false;
        }
        return true;
    }

    //    비밀번호를 업데이트 할 수 있다.
    public boolean changePassword(long id, String pw){
        try {
            var member= memberRepository.findById(id).orElseThrow();
            var hashed_pw= Hash.generateSHA256(pw);
            member.setHashedPw(hashed_pw);
            memberRepository.save(member);
        }catch (Exception e){
            System.err.println(e + "can't set password");
            return false;
        }
        return true;
    }

    public boolean createMember(String name, String hashedPw, String hashedPh, String email, String address, String profileImgUrl, String description) {
        try {
            memberRepository.save(new Member(new MemberCreateReqDto(name, hashedPw,hashedPh,email,address, profileImgUrl, description)));
        }catch (Exception e){
            System.err.println(e + Err.CREATE_ERR);
            return false;
        }
        return true;
    }
}
