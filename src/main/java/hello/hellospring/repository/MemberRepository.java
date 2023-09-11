package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.List;
import java.util.Optional;

// 코드를 재사용하고 용이도를 높이기 위해서 interface를 사용한다.
// 일단 구현해야하는 함수들을 미리 선언한다고 생각
// Optional은 값이 존재 하지 않을 상황에서 사용가능하다
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

    void clearStore();
}
