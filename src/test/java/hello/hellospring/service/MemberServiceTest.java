package hello.hellospring.service;
// ctrl + shift + t 로 테스트 파일 생성가능

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService = new MemberService();

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //When
        Long saveId = memberService.join(member);
        //Then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    public void duplicated_join_excpet()
    {
        Member member1 = new Member();
        member1.setName(("spring"));

        Member member2 = new Member();
        member1.setName(("spring"));

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}