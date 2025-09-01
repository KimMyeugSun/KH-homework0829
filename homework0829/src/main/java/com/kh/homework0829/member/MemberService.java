package com.kh.homework0829.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public Long join(MemberDto dto) {
        MemberEntity entity = new MemberEntity();
        repository.join(MemberEntity.from(dto));
        return entity.getNo();
    }

    public MemberDto login(MemberDto dto) {
        MemberEntity entity = repository.login(dto);
        return MemberDto.from(entity);
    }
}
