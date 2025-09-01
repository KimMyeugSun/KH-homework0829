package com.kh.homework0829.board;

import com.kh.homework0829.member.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOARD")
@Getter
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writerNo", nullable = false)
    private MemberEntity writer;
    private String delYn;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public BoardEntity() {
        delYn = "N";
        createAt = LocalDateTime.now();
        updateAt = LocalDateTime.now();
    }

    public static BoardEntity from(BoardDto dto, MemberEntity writer){
        BoardEntity entity = new BoardEntity();
        entity.title = dto.getTitle();
        entity.content = dto.getContent();
        entity.writer = writer;
        return entity;
    }

    public void delect() {
        this.delYn = "Y";
        this.updateAt = LocalDateTime.now();
    }

    public void update(BoardDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.updateAt = LocalDateTime.now();
    }
}
