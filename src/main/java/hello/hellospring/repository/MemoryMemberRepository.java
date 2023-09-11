package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        // 회원의 ID를 증가시키고, 저장소에 회원을 추가합니다.
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member; // 저장된 회원 객체를 반환합니다.
    }

    @Override
    public Optional<Member> findById(Long id) {
        // 주어진 ID를 가진 회원을 찾아 Optional로 반환합니다.
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 저장소에서 이름이 주어진 이름과 일치하는 회원을 찾아 Optional로 반환합니다.
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 하나라도 찾으면 반환합니다.
    }

    @Override
    public List<Member> findAll() {
        // 저장소에 있는 모든 회원을 리스트로 반환합니다.
        return new ArrayList<>(store.values());
    }
}
