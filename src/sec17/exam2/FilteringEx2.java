package sec17.exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// filter 메서드 예제
public class FilteringEx2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("신용권");
        list.add("신용권");
        list.add("김자바");
        list.add("신민철");

        // 신으로 시작하는 문자열을 찾아 출력
        for (String name : list) {
            if (name.startsWith("신")) { // 시작 문자비교
                System.out.println(name);
            }
        }

        // 신으로 시작하는 문자열을 찾아 새로운 배열에 대입
        List<String> newArr = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("신")) {
                newArr.add(name);
            }
        }
        System.out.println(newArr);

        // 신으로 시작하는 요소만 필터링 (Predicate 클래스 사용)
        // filter 메서드는 인자로  java.util.function.Predicate 타입을 받음
        System.out.println("=클래스=");
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("신");
            }
        }).forEach(System.out::println);

        // 신으로 시작하는 요소만 필터링 후 출력 (람다식 사용)
        System.out.println("=람다=");
        list.stream() //
                .filter((name) -> name.startsWith("신")).forEach(System.out::println);

        // 중복 제거 후, 신으로 시작하는 요소 출력
        System.out.println("=중복 제거 후, 출력=");
        list.stream() //
                .distinct().filter((name) -> name.startsWith("신")).forEach(System.out::println);
    }
}
