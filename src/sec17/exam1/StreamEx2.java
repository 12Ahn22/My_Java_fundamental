package sec17.exam1;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 배열을 Stream으로
public class StreamEx2 {
    public static void main(String[] args) {
        String[] arr = {"홍길동", "신용권", "김미나"};
        Stream<String> stream = Arrays.stream(arr);
        stream.forEach((item) -> System.out.print(item + ",")); // 매개변수가 달라서 method ref 불가능

        System.out.println();

        int[] arr2 = {1, 2, 3, 4, 5};
        IntStream stream2 = Arrays.stream(arr2);
        stream2.forEach((item) -> System.out.print(item + ",")); // 매개변수가 달라서 method ref 불가능
    }
}
