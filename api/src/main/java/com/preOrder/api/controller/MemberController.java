package com.preOrder.api.controller;

import com.preOrder.api.dto.ResponseDto;
import com.preOrder.api.service.MemberService;
import com.preOrder.api.utils.Err;
import com.preOrder.api.utils.Hash;
import com.preOrder.api.utils.PassResponse;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping(value = "/api/member/join")
    public ResponseDto<?> createMember(@RequestParam String name
            , @RequestParam String hashed_pw
            , @RequestParam String hashed_ph
            , @RequestParam String email
            , @RequestParam String address
            , @RequestParam String profile_img_url
            , @RequestParam String description){
        boolean flag= memberService.createMember(name,hashed_pw,hashed_ph, email, address, profile_img_url, description);

        if (flag)
            return ResponseDto.success(PassResponse.CREATE_DONE);
        return ResponseDto.fail(Err.CREATE_ERR, Err.ERR_MSG);
    }

    @PostMapping(value = "/api/member/login")
    public ResponseDto<?> login(@RequestParam String _id , @RequestParam String _pw
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        boolean flag= memberService

        if (flag)
            return ResponseDto.success("Done- login");
        return ResponseDto.fail("login err", Err.ERR_MSG);
    }


    //    이름, 프로필 이미지, 인사말을 업데이트 할 수 있다.
    @PostMapping(value = "/api/member/update/name")
    public ResponseDto<?> changeName(@RequestParam String name,
                                     HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        boolean flag= false;

        var id= httpServletRequest.getRequestId();
        flag= memberService.changeName(Integer.parseInt(id), name);

        if (flag)
            return ResponseDto.success(PassResponse.UPDATE_DONE + "name");
        return ResponseDto.fail("name service", Err.ERR_MSG);
    }

    @PostMapping(value = "/api/member/update/img")
    public ResponseDto<?> changeProfileImg(@RequestParam String img_url,
                                           HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        boolean flag= false;

        var id= httpServletRequest.getRequestId();
        flag= memberService.changeProfileImg(Integer.parseInt(id), img_url);

        if (flag)
            return ResponseDto.success(PassResponse.UPDATE_DONE + "img save");
        return ResponseDto.fail("img service", Err.ERR_MSG);
    }

    @PostMapping(value = "/api/member/update/desc")
    public ResponseDto<?> changeDescription(@RequestParam String desc,
                                            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        boolean flag= false;

        var id= httpServletRequest.getRequestId();
        flag= memberService.changeDescription(Integer.parseInt(id), desc);

        if (flag)
            return ResponseDto.success(PassResponse.UPDATE_DONE + "description save");
        return ResponseDto.fail("Description service", Err.ERR_MSG);
    }


    //    비밀번호를 업데이트 할 수 있다.
    @PostMapping(value = "/api/member/update/password")
    public ResponseDto<?> changePassword(@RequestParam String pw,
                                         HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        boolean flag= false;

        var id= httpServletRequest.getRequestId();
        flag= memberService.changePassword(Integer.parseInt(id), pw);

        if (flag)
            return ResponseDto.success(PassResponse.UPDATE_DONE + "password save");
        return ResponseDto.fail("password service", Err.ERR_MSG);
    }
}
