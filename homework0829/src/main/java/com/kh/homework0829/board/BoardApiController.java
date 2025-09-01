package com.kh.homework0829.board;

import com.kh.homework0829.member.MemberDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/board")
public class BoardApiController {

    private final BoardService service;

    @PostMapping
    public Long insert(@RequestBody BoardDto dto, HttpSession session){
        MemberDto loginMemberDto = (MemberDto) session.getAttribute("loginMemberDto");
        System.out.println("board insert > loginMemberDto = " + loginMemberDto);
        dto.setWriterNo(loginMemberDto.getNo());
        return service.insert(dto);
    }
    @GetMapping("{no}")
    public BoardDto findBoardByNo(@PathVariable Long no){
        return service.findBoardByNo(no);
    }
    @GetMapping
    public List<BoardDto> findBoardAll(){
        return service.findBoardAll();
    }
    @DeleteMapping("{no}")
    public void deleteBoardByNo(@PathVariable Long no, HttpSession session){
        MemberDto loginMemberDto = (MemberDto) session.getAttribute("loginMemberDto");
        Long writerNo = loginMemberDto.getNo();
        service.deleteBoardByNo(no, writerNo);
    }
    @PutMapping
    public void updateBoard(@RequestBody BoardDto dto, HttpSession session){
        MemberDto loginMemberDto = (MemberDto) session.getAttribute("loginMemberDto");
        Long writerNo = loginMemberDto.getNo();
        service.updateBoard(dto, writerNo);
    }

}
