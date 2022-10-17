package redis.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@ToString
public class RefreshToken implements Serializable {

    private String key;

    private String token;

    @Builder
    public RefreshToken(String key, String value) {
        this.key = key;
        this.token = value;
    }

    public RefreshToken updateValue(String token) {
        this.token = token;
        return this;
    }
}
