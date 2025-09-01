package com.kh.homework0829.member;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/member")
public class MemberApiController {

    private final MemberService service;

    @PostMapping("join")
    public Long join(@RequestBody MemberDto dto){
        return service.join(dto);
    }

    @PostMapping("login")
    public MemberDto login(@RequestBody MemberDto dto, HttpSession session){
        MemberDto loginMemberDto = service.login(dto);
        session.setAttribute("loginMemberDto", loginMemberDto);
        System.out.println("login > loginMemberDto = " + loginMemberDto);
        return loginMemberDto;
    }
}
