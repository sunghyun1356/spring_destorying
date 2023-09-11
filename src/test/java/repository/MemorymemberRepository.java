package repository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemorymemberRepository {
    MemberRepository repository = new MemoryMemberRepository();

        @AfterEach
        public void afterEach()
        {
            repository.clearStore();
        }

        @Test
        public void save()
        {
            Member member = new Member();
            member.setName("Spring");
            repository.save(member);
            Member result = repository.findById(member.getId()).get();
            Assertions.assertEquals(member, result);
        }
        @Test
        public void findByName()
        {
            Member member1 = new Member();
            member1.setName("spring1");
            repository.save(member1);

            Member member2 = new Member();
            member1.setName("spring2");
            repository.save(member1);

            Member result = repository.findByName("Spring1").get();
            assertThat(result).isEqualTo(member1);
            Member result2 = repository.findByName("Spring2").get();
            assertThat(result).isEqualTo(member2);
        }

        @Test
        public void findAll()
        {
            Member member1 = new Member();
            member1.setName("spring1");
            repository.save(member1);

            Member member2 = new Member();
            member1.setName("spring2");
            repository.save(member2);

            List<Member> result = repository.findAll();
            assertThat(result.size()).isEqualTo(2);
        }
}
