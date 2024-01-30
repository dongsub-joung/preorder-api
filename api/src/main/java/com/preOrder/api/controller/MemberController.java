package com.preOrder.api.controller;

import com.preOrder.api.dto.ResponseDto;
import com.preOrder.api.service.MemberService;
import com.preOrder.api.utils.Err;
import com.preOrder.api.utils.Hash;
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

//    Loing - Join
//    @PostMapping(value = "/api/login/")
//    public ResponseDto<?> login(@RequestBody String _id , @RequestBody String _pw
//            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        return ResponseDto.success("Done- login");
//    }
//
//    @PostMapping(value = "/api/join/")
//    public ResponseDto<?> join(@RequestBody String _id, @RequestBody String _pw
//            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ) {
//
//        return ResponseDto.success("Done- Join");
//    }


//    이름, 프로필 이미지, 인사말을 업데이트 할 수 있다.
    @GetMapping(value = "/api/member/name")
    public ResponseDto<?> changeName(@RequestBody String name,
                                            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        boolean flag= false;

        var id= httpServletRequest.getRequestId();
        flag= memberService.changeName(Integer.parseInt(id), name);

        if (flag)
            return ResponseDto.success("Done- name save");
        return ResponseDto.fail("name service", Err.ERR_MSG);
    }

    @GetMapping(value = "/api/member/img")
    public ResponseDto<?> changeProfileImg(@RequestBody String img_url,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        boolean flag= false;

        var id= httpServletRequest.getRequestId();
        flag= memberService.changeProfileImg(Integer.parseInt(id), img_url);

        if (flag)
            return ResponseDto.success("Done- img save");
        return ResponseDto.fail("img service", Err.ERR_MSG);
    }

    @GetMapping(value = "/api/member/desc")
    public ResponseDto<?> changeDescription(@RequestBody String desc,
                                           HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        boolean flag= false;

        var id= httpServletRequest.getRequestId();
        flag= memberService.changeDescription(Integer.parseInt(id), desc);

        if (flag)
            return ResponseDto.success("Done- description save");
        return ResponseDto.fail("Description service", Err.ERR_MSG);
    }


    //    비밀번호를 업데이트 할 수 있다.
    @GetMapping(value = "/api/member/password")
    public ResponseDto<?> changePassword(@RequestBody String pw,
                                            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        boolean flag= false;

        var id= httpServletRequest.getRequestId();
        flag= memberService.changePassword(Integer.parseInt(id), pw);

        if (flag)
            return ResponseDto.success("Done- password save");
        return ResponseDto.fail("password service", Err.ERR_MSG);
    }
}
