package sec12;

import java.util.Objects;

public class Member {
    public String id;

    public Member(String id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 주소가 같으면 당연히 같은 객체다.
        if (o == null || getClass() != o.getClass()) return false; // null이거나 같은 클래스가 아니면 비교할 필요 없다.
        // 여기 까지 코드가 도달한다면, 같은 클래스인 경우이다.
        Member member = (Member) o; // 인자를 강제 타입 캐스팅
        return Objects.equals(id, member.id); // 특정(유일한) 속성을 비교(==)
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
