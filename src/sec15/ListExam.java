package sec15;

// 동물 클래스들이 상속받을 애완동물 추상 클래스
// 추상 클래스는 객체를 생성할 수 없다(상속용)
// 롬복을 사용한다.

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor // 모든 필드를 사용해서 생성자 만들기
@Getter // 필드에 대한 getter들 추가
abstract class 애완동물 {
    private String name;

    abstract public void 울다();
}

class 고양이 extends 애완동물{
    public 고양이(String name) {
        super(name);
    }

    @Override
    public void 울다() {
        System.out.println(getName() + "이가 야옹하고 웁니다.");
    }
}

class 강아지 extends 애완동물{
    public 강아지(String name) {
        super(name);
    }

    @Override
    public void 울다() {
        System.out.println(getName() + "이가 멍멍하고 웁니다.");
    }
}


public class ListExam {
    private List<애완동물> array = new ArrayList<>();

    public void createInstance(){
        array.add(new 강아지("여름"));
        array.add(new 고양이("삼색"));
        array.add(new 고양이("치즈"));
    }

    public void action(){
        for(애완동물 animal : array){
            animal.울다();
        }
    }

    public static void main(String[] args) {
        //		아래 코드는 강아지랑 고양이에 의존하고 있음
//		List<강아지> array1 = new ArrayList<>();
//		List<고양이> array2 = new ArrayList<>();
//
//		// 등록
//		array1.add(new 강아지("여름"));
//		array1.add(new 강아지("루키"));
//
//		array2.add(new 고양이("셜록"));
//		array2.add(new 고양이("치즈"));
//		array2.add(new 고양이("빵떡"));
//
//		for (강아지 dog : array1) {
//			dog.강아지울다();
//		}
//		for (고양이 cat : array2) {
//			cat.고양이울다();
//		}

//        그러나 애완동물 클래스를 상속받도록 강아지, 고양이 클래스를 수정한다면,
//        의존성을 제거할 수 있다.
        ListExam exam = new ListExam();
        exam.createInstance();
        exam.action();
    }
}
