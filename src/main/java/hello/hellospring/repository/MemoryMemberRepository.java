package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
// 함수들을 선언해준다

//MemoryMemberRepository는 interface에 있는 MemberRepository를 사용한다
// @을 통해서 정의해준다는 느낌
@Repository
public class MemoryMemberRepository implements MemberRepository {

    //회원 정보를 저장하는 저장소이며 Long타입과 memeber를 가지는 hashmap이다
    private static Map<Long, Member> store = new HashMap<>();
    // 유저의 id값을 지정해주는 변수
    private static long sequence = 0L;

    @Override
    // setId로 Id를 설정해주고 추가한다
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
        // 만약에 해당 이름의 회원이 없으면 Optimal.empty()를 반환한다
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 저장소에서 이름이 주어진 이름과 일치하는 회원을 찾아 Optional로 반환합니다.
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 하나라도 찾으면 반환합니다.
        // 만약에 해당 이름의 회원이 없으면 Optimal.empty()를 반환한다

    }

    @Override
    public List<Member> findAll() {
        // 저장소에 있는 모든 회원을 리스트로 반환합니다.
        return new ArrayList<>(store.values());
    }
    public void clearStore()
    {
        store.clear();
    }
}
