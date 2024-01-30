package com.preOrder.api.service;


import com.preOrder.api.domain.Member;
import com.preOrder.api.repository.MemberRepository;
import com.preOrder.api.utils.Hash;
import lombok.RequiredArgsConstructor;
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
        }
        return true;
    }

    public boolean changeDescription(long id, String desc){
        try {
            var member= memberRepository.findById(id).orElseThrow();
            member.setMember_description(desc);
            memberRepository.save(member);
        }catch (Exception e){
            System.err.println(e + "can't set desc");
        }
        return true;
    }

    //    비밀번호를 업데이트 할 수 있다.
    public boolean changePassword(long id, String pw){
        try {
            var member= memberRepository.findById(id).orElseThrow();
            var hashed_pw= Hash.generateSHA256(pw);
            member.setHashed_pw(hashed_pw);
            memberRepository.save(member);
        }catch (Exception e){
            System.err.println(e + "can't set password");
        }
        return true;
    }
}
