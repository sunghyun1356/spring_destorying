package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

// 실제 사용자들이 사용할 기능을 하도록 만들어주는것

public class MemberService {
    private  final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //final은 상수취급이 되어서 값을 변경 불가능하다
    public Long join(Member member)
    {
        //같은 이름이 있는 중복 회원 x
        // ctrl + alt + m 으로 추출해서 함수로 사용 가능
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }

    //전체 회원 조회
    public List<Member> findMembers()
    {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId)
    {
        return memberRepository.findById(memberId);
    }
}
