package hello.hellospring.domain;
// 멤버의 정보에 대해서 담아놓은 것
public class Member {
    private  Long id;
    private  String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
