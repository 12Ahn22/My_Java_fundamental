package sec17.exam1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//List를 스트림으로
public class StreamEx {
    public static void main(String[] args) {
        // List 컬렉션 생성
        List<Product> list = new ArrayList<>();
        for(int i = 1; i <=5; i++){
            Product product = new Product(i,"상품"+i,"good company", (int)(10000*Math.random()));
            list.add(product);
        }
        
        // stream() 메서드 사용해서 Stream얻기
        Stream<Product> stream = list.stream(); // List는 Collection을 구현했기 때문에 stream() 메서드 사용 가능
//        stream.forEach((i)-> System.out.println(i));
        stream.forEach(System.out::println); // method reference

    }
}
