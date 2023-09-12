package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;


    // spring이 생성자를 통해서 컨테이너에서 자동으로 연결해줌 (denpendency )
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
