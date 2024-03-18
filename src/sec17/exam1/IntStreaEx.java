package sec17.exam1;

import java.util.stream.IntStream;

public class IntStreaEx {
    public static int sum = 0;

    public static void main(String[] args) {
        IntStream stream = IntStream.rangeClosed(1,100); // 100을 포함한다.
//        int sum = 0; // 구문 오류
        
        stream.forEach((i) -> sum += i); // sum이 그냥 지역변수라면 구문 오류발생
        // forEach 내부에 보낸 콜백함수(람다식) 내부에 있는 변수는 전부 final이다. => JS랑 같음.
        // 따라서, 접근 용도로만 사용 가능. 그래서 내부에 int sum을 선언하는게 아니라
        // 외부에 public static int sum을 선언해준다.
        // 전역 변수만이 람다 구문 내에서 접근이 가능하기 때문
        System.out.println(sum); // 5050
    }
}
