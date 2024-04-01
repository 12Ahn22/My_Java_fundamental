package 자바웹개발워크북.Enum;

import java.util.Arrays;
import java.util.List;

public enum CreditCard {
    // 매핑
    SHINHAN("신한", Arrays.asList("Mr.Life 카드", "Deep Dream 카드", "Deep Oil 카드")),
    KB("국민", Arrays.asList("톡톡D 카드", "티타늄 카드", "다담 카드")),
    NH("농협", Arrays.asList("올바른 FLEX 카드", "테이크 5 카드", "NH 올원 파이카드"));

    // 매핑할 때 넣어주는 값의 필드
    private final String Enterprise; // 카드사
    private final List<String> cards; // 카드들

    // 생성자 private
    CreditCard(String name, List<String> cards) {
        this.Enterprise = name;
        this.cards = cards;
    }

//    String getCard(String cardName) {
//        return Arrays.stream(CreditCard.values()) // 배열 흐름
//                .filter(creditCard -> creditCard.equals(cardName))
//                .findFirst()
//                .orElseThrow(Exception::new);
//    }

    void getCardTest1() {
        Arrays.stream(CreditCard.values()) // 배열 흐름
                .forEach(System.out::println); // SHINHAN, KB, NH
    }
    void getCardTest2(String cardName) {
        Arrays.stream(CreditCard.values()) // 배열 흐름
                .filter(creditCard -> creditCard.cards.contains(cardName))
                .forEach(System.out::println);
    }

    void getCardTest3(CreditCard enterprise) {
        Arrays.stream(CreditCard.values()) // 배열 흐름
                .filter(creditCard -> creditCard.equals(enterprise))
                .forEach(v -> System.out.println(v.cards));
    }
}
