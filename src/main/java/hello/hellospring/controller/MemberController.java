package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private MemberService memberService;

    // 생성자 주입으로 한다
    // spring이 생성자를 통해서 컨테이너에서 자동으로 연결해줌 (denpendency )
    @Autowired
    public MemberController(MemberService memberService)
    {
        this.memberService = memberService;
    }
    //form으로 연결을 해준다
    @GetMapping("/members/new")
    public String CreateForm()
    {
        return "members/createMemberForm";
    }
    //post하는 것을 매핑해주는데 이름을 정하고 이 멤버를 member service에 합쳐주고 다시 돌아간다
    @PostMapping("/members/new")
    public String create(MemberForm form)
    {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model)
    {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
