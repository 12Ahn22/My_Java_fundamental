package sec17.exam3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class FlatMappingEx {
    public static void main(String[] args) {
        // 문자열을 공백으로 잘라서 배열로 만드는 작업
        List<String> list1 = new ArrayList<>();
        list1.add("this is java");
        list1.add("i am a best developer");

        // StringTokenizer를 사용해 문자열을 배열에 저장하기
        List<String> newArr = new ArrayList<>();
        for (var str : list1) {
            StringTokenizer token = new StringTokenizer(str, " "); // 공백을 기준으로 문자를 자름
            while (token.hasMoreTokens()) {
                newArr.add(token.nextToken());
            }
        }
        System.out.println(newArr);

        // Stream의 flatMap을 이용하기
        System.out.println("=flatMap=");
        list1.stream() // 스트림 요소 얻기
                .flatMap((data) -> Arrays.stream(data.split(" "))) // 문자열을 배열의 split을 이용해 자름
                .forEach(System.out::println);

        System.out.println("=문자열 숫자를 숫자 스트림으로 변환=");
        List<String> listInt = List.of("10,20,30,40,50"); // array를 list로 변환(인자가 하나라서 of 사용)
//        List<String> listInt = Arrays.asList("10,20,30,40,50"); // array를 list로 변환
        listInt.stream() //
                // 하나의 요소마다가 아니라 전체 스트림을 내가 보낸 로직으로
                // 변환해서 새로운 스트림을 만들어 내는 것인데,
                // flatMapTo자료형 메서드에서 해당 자료형에 맞는 타입의 Stream을
                // 반환해줘야한다.
                .flatMapToInt(data -> {
                    // Returns an IntStream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element
                    String[] strArr = data.split(","); // ,를 기준으로 split
                    int[] intArr = new int[strArr.length]; // 배열 정의
                    for (int i = 0; i < strArr.length; i++) {
                        // int 배열에 하나씩 parseInt로 Int로 변경해서 옮기기
                        intArr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    return Arrays.stream(intArr);
                }).forEach(System.out::println);

        // 향상된 for loop를 사용해 변경하기
        System.out.println("==향상된 for loop==");
        listInt.stream() //
                .flatMapToInt((data) -> {
                    String[] strArr = data.split(",");
                    List<Integer> intList = new ArrayList<>();
                    for (String num : strArr) {
                        intList.add(Integer.parseInt(num.trim()));
                    }
                    // IntStream을 반환해야하기 때문에
                    // mapTo자료형 메서드는 요소를 해당 자료형으로 변환한 스트림을 반환한다.
                    return intList.stream().mapToInt((o) -> o);
//                    return intList.stream().mapToInt((o)->o.intValue());
                }).forEach(System.out::println);

        // 전부 스트림 메서드만 사용해서 변경하기
        System.out.println("==스트림 메서드만 사용하기==");
        listInt.stream() //
                .flatMap((data) -> Arrays.stream(data.split(","))) // 배열을 stream으로
                .mapToInt((ch) -> Integer.parseInt(ch.trim())) // 각 요소를 IntStream
                .forEach(System.out::println);
        System.out.println("==스트림 메서드만 사용하기2==");
        listInt.stream() //
                .flatMapToInt((data) -> {
                    return Arrays.stream(data.split(","))
                            .mapToInt(ch -> Integer.parseInt(ch.trim()));
                }).forEach(System.out::println);

        System.out.println("==스트림 메서드만 사용하기3==");
        // map과 flatMap을 사용했다. -> 타입이 확실하지않거나 객체인 경우 사용한다고 한다.
        listInt.stream() //
                .flatMap((data)->{
                    return Arrays.stream(data.split(","))
                            .map((ch)->Integer.parseInt(ch.trim()));
                })
                .forEach(System.out::println);
    }
}
