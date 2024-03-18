package sec17.exam2;

import java.util.ArrayList;
import java.util.List;

// 필터링 메서드들 예제
public class FilteringEx {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            productList.add(new Product(i, "상품" + i, "멋진회사", (int) (10000 * Math.random())));
        }
        productList.add(new Product(1, "상품1", "멋진회사", 1000)); // 중복 요소 추가
//        productList.stream().forEach((System.out::println));
        productList.forEach((System.out::println)); // 중복된 pno=1가 출력된다.

        System.out.println("==========");
//        단, pid를 기준으로 중복 제거를 위해서 Product클래스에 hashCode와 equals 메서드를 재정의해야한다.
        productList.stream().distinct().forEach(System.out::println); // 중복 제거
    }
}
