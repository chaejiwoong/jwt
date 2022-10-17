package redis.domain;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member implements Serializable {

    private Long id;

    private String email;

    private String password;

    private String authority;

    @Builder
    public Member(String email, String password, String authority) {
        this.email = email;
        this.password = password;
        this.authority = authority;
    }
}
