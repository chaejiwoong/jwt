package redis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.controller.dto.MemberResponseDto;
import redis.service.MemberService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/me")
    @ResponseBody
    public ResponseEntity<MemberResponseDto> getMyMemberInfo() {
        return ResponseEntity.ok(memberService.getMyInfo());
    }

//    @GetMapping("/{email:.+}")  // . 이하의 문자열 식별
//    public ResponseEntity<MemberResponseDto> getMemberInfo(@PathVariable String email) {
//        return ResponseEntity.ok(memberService.getMemberInfo(email));
//    }

    @GetMapping("/mypage")
    public String mypage() {
        return "mypage";
    }
}