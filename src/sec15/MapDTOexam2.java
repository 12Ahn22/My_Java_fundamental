package sec15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// DTO를 클래스 대신, map을 사용하는 경우도 있다.
public class MapDTOexam2 {
    // 각각 사람의 객체를 Map으로 생성해 관리하고, 해당 Map을 List에 추가해서 관리
    private List<Map<String,String>> array = new ArrayList<>(); // 각각 사람을 관리하는 array

    // 아래 코드는
    // Class로 DTO를 관리했을 때와 다르게 id를 내가 직접 넣어준다(직접관리)
    public void addStudent(String id, String name, String age){
        Map<String, String> student = new HashMap<>();
        student.put("id", id);
        student.put("name", name);
        student.put("age", age);

        // 생성한 사람을 리스트에 추가
        array.add(student);
    }

    public void out(){
        for(var student: array){
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
//        array에 사람 추가하기
        MapDTOexam2 exam = new MapDTOexam2();
        exam.addStudent("1","홍길동","40");
        exam.addStudent("2","홍길동2","25");

        exam.out();
    }
}
