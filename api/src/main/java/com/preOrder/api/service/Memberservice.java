package com.preOrder.api.service;


import com.preOrder.api.domain.Member;
import com.preOrder.api.repository.MemberRepository;
import com.preOrder.api.utils.Hash;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Memberservice {
    private final MemberRepository memberRepository;
    public boolean progressLogin(String _id, String _pw){

        Member member = memberRepository.findByMemberId(_id)
                .orElseThrow(() -> new NullPointerException("Member not found for ID: "));

        String sha256Hash = Hash.generateSHA256(_pw.trim());

        _id= _id.trim();
        if (member.getMemberId().equals(_id) && member.getHashedPw().equals(sha256Hash)){
            return true;
        }

        return false;
    }

    public String hashing(String pw){
        return Hash.generateSHA256(pw);
    }

    public boolean joining(String id, String hashedPw){
        var member= new Member(id, hashedPw);

        try{
            memberRepository.save(member);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
