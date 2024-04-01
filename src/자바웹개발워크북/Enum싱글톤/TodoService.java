package 자바웹개발워크북.Enum싱글톤;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 책에서 본 예제
public enum TodoService{
    INSTANCE; // Enum 클래스에서 상수들은 모두 정적이다.

    // 그러나 메서드들은 static을 설정하지 않는다면 정적이지않다.
    public void register(TodoDTO todoDTO){
        System.out.println("DEBUG......." + todoDTO);
    }

    // 리스트를 만들어 반환하는 메서드
    public List<TodoDTO> getList() {

        return IntStream.range(0,10).mapToObj(i ->{
            TodoDTO dto = new TodoDTO();
            dto.setTno(i);
            dto.setTitle("Todo..."+i);
            return dto;
        }).collect(Collectors.toList());
    }
}