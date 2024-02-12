package com.preOrder.api.controller;

import com.preOrder.api.dto.ResponseDto;
import com.preOrder.api.jwt.JwtUtil;
import com.preOrder.api.service.FollowService;
import com.preOrder.api.utils.Err;
import com.preOrder.api.utils.PassResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

public class FollowController {
    private static FollowService followService;

    //    Follow CRUD
    @PostMapping(value = "/api/follow/create/{memberId}/{followingUserId}")
    public ResponseDto<?> createFollow(@PathVariable String followingUserId
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        boolean flag= false;
        JwtUtil jwtUtil= new JwtUtil();
        var claims= jwtUtil.getUserInfoFromToken("token");
        var memberId= claims.getId();

        try {
            flag= followService.createFollower(memberId, followingUserId);
        }catch (Exception e){
            System.err.println(e + Err.ERR_MSG);
        }

        if (flag)
            return ResponseDto.success(PassResponse.CREATE_DONE);
        return ResponseDto.fail(Err.CREATE_ERR, Err.CREATE_ERR);
    }

    @PostMapping(value = "/api/follow/delete/{followId}")
    public ResponseDto<?> deleteFollow(@PathVariable String followId
            , HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        boolean flag= false;

        try {
            flag= followService.deleteFollower(followId);
        }catch (Exception e){
            System.err.println(e + Err.ERR_MSG);
        }

        if (flag)
            return ResponseDto.success(PassResponse.DEL_DONE);
        return ResponseDto.fail(Err.ERR_MSG, Err.DEL_ERR);
    }

    @GetMapping("/api/follow/size/{memberId}")
    public ResponseDto<?> getFollowers(@PathVariable String memberId,
                                      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        long followerSize= 0;

        try {
            followerSize= followService.getFollowSize(memberId);
        }catch (Exception e){
            System.err.println(e + Err.GET_ERR);
            return ResponseDto.fail("Getting follower Size", Err.GET_ERR);
        }

        return ResponseDto.success(followerSize);
    }

    @GetMapping("/api/followers/{memberId}")
    public ResponseDto<?> listUpFollowers(@PathVariable String memberId
            ,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        try {
            var data= followService.getMyFollowInfo(memberId);
            return ResponseDto.success(data);
        }catch (Exception e){
            System.err.println(e + Err.GET_ERR);
            return ResponseDto.fail("ListUp followers", Err.ERR_MSG);
        }
    }

    @GetMapping("/api/followers/{memberId}/{followingUserId}")
    public ResponseDto<?> getFollowerInfo(@PathVariable String memberId
            , @PathVariable String followingUserId
            ,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        try {
            var data= followService.getTheFollowInfo(memberId, followingUserId);
            return ResponseDto.success(data);
        }catch (Exception e){
            System.err.println(e + Err.GET_ERR);
            return ResponseDto.fail("Getting post", Err.ERR_MSG);
        }
    }
}
