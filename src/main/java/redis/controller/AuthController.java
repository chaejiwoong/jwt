package redis.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.controller.dto.MemberRequestDto;
import redis.controller.dto.MemberResponseDto;
import redis.controller.dto.TokenDto;
import redis.controller.dto.TokenRequestDto;
import redis.service.AuthService;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;


    @GetMapping("/main")
    public String main() {
        return "main";
    }

    // 테스트 회원가입 폼
    @GetMapping("/signup")
    public String joinForm() {
        return "join";
    }

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
        log.info("/auth/signup........");
        log.info("dto : " + memberRequestDto);
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }

    // 테스트 로그인 폼
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.login(memberRequestDto));
    }

    @PostMapping("/reissue")
    @ResponseBody
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}

