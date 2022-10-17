package redis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.controller.dto.MemberResponseDto;
import redis.domain.Member;
import redis.mapper.MemberMapper;
import redis.util.SecurityUtil;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper mapper;

    @Transactional(readOnly = true)
    public MemberResponseDto getMemberInfo(String email) {
        System.out.println("email = " + email);
        if (mapper.findByEmail(email) == null) {
            throw new RuntimeException("유저 정보가 없습니다.");
        }

        Member member = mapper.findByEmail(email);

        System.out.println("member = " + member);
        return MemberResponseDto.of(member);
    }

    // 현재 SecurityContext 에 있는 유저 정보 가져오기
    @Transactional(readOnly = true)
    public MemberResponseDto getMyInfo() {
        if (mapper.findById(SecurityUtil.getCurrentMemberId()) == null) {
            throw new RuntimeException("로그인 유저 정보가 없습니다.");
        }
        return MemberResponseDto.of(mapper.findById(SecurityUtil.getCurrentMemberId()));
    }
}