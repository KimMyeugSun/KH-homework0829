package com.kh.homework0829.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BoardDto {

    private Long no;
    private String title;
    private String content;
    private Long writerNo;
    private String writerNick;
    private String delYn;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public static BoardDto from(BoardEntity entity){
        BoardDto dto = new BoardDto();
        dto.no = entity.getNo();
        dto.title = entity.getTitle();
        dto.content = entity.getContent();
        dto.writerNo = entity.getWriter().getNo();
        dto.writerNick = entity.getWriter().getUserNick();
        dto.delYn = entity.getDelYn();
        dto.createAt = entity.getCreateAt();
        dto.updateAt = entity.getUpdateAt();
        return dto;
    }
}
