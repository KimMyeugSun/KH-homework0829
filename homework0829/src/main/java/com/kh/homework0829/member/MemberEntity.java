package com.kh.homework0829.member;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBER")
@Getter
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @Column(nullable = false, unique = true, length = 100)
    private String userId;
    @Column(nullable = false, length = 100)
    private String userPwd;
    @Column(nullable = false, length = 100)
    private String userNick;
    private String delYn;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public MemberEntity() {
        delYn = "N";
        createAt = LocalDateTime.now();
        updateAt = LocalDateTime.now();
    }

    public static MemberEntity from(MemberDto dto){
        MemberEntity entity = new MemberEntity();
        entity.userId = dto.getUserId();
        entity.userPwd = dto.getUserPwd();
        entity.userNick = dto.getUserNick();
        return entity;
    }
}
