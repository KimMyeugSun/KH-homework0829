package com.kh.homework0829.board;

import com.kh.homework0829.member.MemberEntity;
import com.kh.homework0829.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public Long insert(BoardDto dto) {
       MemberEntity memberEntity = memberRepository.findByNo(dto.getWriterNo());
       BoardEntity entity = BoardEntity.from(dto, memberEntity);
       boardRepository.insert(entity);
       return entity.getNo();
    }

    public BoardDto findBoardByNo(Long no) {
       BoardEntity entity = boardRepository.findBoardByNo(no);
       return BoardDto.from(entity);
    }

    public List<BoardDto> findBoardAll() {
        List<BoardEntity> boardEntityList = boardRepository.findBoardAll();
        return boardEntityList.stream().map(BoardDto::from).toList();
    }

    public void deleteBoardByNo(Long no, Long loginMemberNo) {
        BoardEntity entity = boardRepository.findBoardByNo(no);
        if (entity.getWriter().getNo() != loginMemberNo){
            throw new BoardException("잉 어떤걸 지우고싶은거야?");
        }
        entity.delect();
    }

    public void updateBoard(BoardDto dto, Long loginMemberNo) {
        BoardEntity entity = boardRepository.findBoardByNo(dto.getNo());
        if (entity.getWriter().getNo() != loginMemberNo){
            throw new BoardException("잉 어떤걸 수정하려구?");
        }
        entity.update(dto);
    }
}
