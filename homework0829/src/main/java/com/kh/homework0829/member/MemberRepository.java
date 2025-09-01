package com.kh.homework0829.member;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor

public class MemberRepository {

    private final EntityManager manager;

    public void join(MemberEntity entity) {
        manager.persist(entity);
    }

    public MemberEntity login(MemberDto dto) {
        String jpql = "select m from MemberEntity m where m.userId = :userId and m.userPwd = :userPwd and m.delYn = 'N'";
        return manager.createQuery(jpql, MemberEntity.class)
                .setParameter("userId", dto.getUserId())
                .setParameter("userPwd", dto.getUserPwd())
                .getSingleResult();
    }


    public MemberEntity findByNo(Long no) {
        return manager.find(MemberEntity.class, no);
    }
}
