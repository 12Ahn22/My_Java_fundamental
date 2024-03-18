package sec15;

import java.util.HashMap;
import java.util.Map;

// DTO를 클래스 대신, map을 사용하는 경우도 있다.
public class MapDTOexam {
    // 한 사람의 객체를 map으로 관리하는 방법
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        // map으로 한 사람의 정보를 관리
        map.put("id", "1");
        map.put("name", "홍길동");
        map.put("age","24");

        System.out.println(map);
    }
}
