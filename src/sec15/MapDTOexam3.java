package sec15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// DTO를 클래스 대신, map을 사용하는 경우도 있다.
public class MapDTOexam3 {
    // 각각 사람의 객체를 Map으로 생성해 관리하고, 해당 Map을 다시 Map을 통해서 관리한다.
    // Map이기 때문에 Key가 필요하다.
    // 여기서 Key는 String 타입이고 외부에서 입력받을 id값을 사용하기로 결정
    private Map<String, Map<String, String>> array = new HashMap<>(); // 각각 사람을 관리하는 array

    // 아래 코드는
    // Class로 DTO를 관리했을 때와 다르게 id를 내가 직접 넣어준다(직접관리)
    public void addStudent(String id, String name, String age) {
        Map<String, String> student = new HashMap<>();
        student.put("id", id);
        student.put("name", name);
        student.put("age", age);

        // 생성한 사람을 리스트에 추가
        array.put(id, student);
    }

    public void out() {
        for (var student : array.entrySet()) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
//        array에 사람 추가하기
        MapDTOexam3 exam = new MapDTOexam3();
        exam.addStudent("1", "홍길동", "40");
        exam.addStudent("2", "홍길동2", "25");

        exam.out();
    }
}
