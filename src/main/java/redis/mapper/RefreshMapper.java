package redis.mapper;

import redis.domain.RefreshToken;

public interface RefreshMapper {

    void save(RefreshToken token);

    RefreshToken findByKey(String key);

    void updateToken(RefreshToken token);
}
