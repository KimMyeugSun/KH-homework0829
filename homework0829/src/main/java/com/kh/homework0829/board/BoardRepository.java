package com.kh.homework0829.board;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager manager;

    public void insert(BoardEntity entity) {
        manager.persist(entity);
    }

    public BoardEntity findBoardByNo(Long no) {
        return manager.find(BoardEntity.class, no);
    }

    public List<BoardEntity> findBoardAll() {
        String jpql = """
                select b from BoardEntity b where b.delYn = 'N' order by b.no desc"
                """;
        return manager.createQuery(jpql, BoardEntity.class).getResultList();
    }

}
