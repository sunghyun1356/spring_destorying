package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService()
    {
        return new MemberService(memberRepository());
    }
    // 서로 연결을 해준다는 거랑 똑같다
    @Bean
    public MemberRepository memberRepository()
    {
        return new MemoryMemberRepository();
    }
}
