package redis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import redis.domain.Member;

public interface MemberMapper {

    Member findByEmail(String email);

    Boolean existsByEmail(String email);

    Member findById(Long id);

    void save(Member member);
}

