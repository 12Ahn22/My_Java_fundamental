package 자바웹개발워크북.Enum;

import 자바웹개발워크북.Enum싱글톤.TodoDTO;
import 자바웹개발워크북.Enum싱글톤.TodoService;

import java.util.List;

public class EnumEx {
    // 요일들을 나타내는 상수
    private final static int MONDAY = 1;
    private final static int TUESDAY = 2;
    private final static int WEDNESDAY = 3;
    private final static int THURSDAY = 4;
    private final static int FRIDAY = 5;
    private final static int SATURDAY = 6;
    private final static int SUNDAY = 7;

    // 계절을 나타내는 상수
    private final static int SPRING = 1;
    private final static int SUMMER = 2;
    private final static int FALL = 3;
    private final static int WINTER = 4;

    public static void main(String[] args) {
        int day = SPRING; // 계절이 들어갔지만, 아래 코드는 작동한다..!
        switch (day){
            case MONDAY -> System.out.println("월요일");
            case TUESDAY -> System.out.println("화요일");
            case WEDNESDAY -> System.out.println("수요일");
            case THURSDAY -> System.out.println("목요일");
            case FRIDAY -> System.out.println("금요일");
            case SATURDAY -> System.out.println("토요일");
            case SUNDAY -> System.out.println("일요일");
        }
        Season s = Season.WINTER;
        System.out.println(s.name()); // 열거 객체명
        System.out.println(s.getSeason()); // 매핑된 열거 데이터 출력

        CreditCard cd = CreditCard.KB;
        cd.getCardTest1();
        System.out.println("========================");
        cd.getCardTest2("Deep Dream 카드");
        System.out.println("========================");
        cd.getCardTest3(CreditCard.SHINHAN);

        // List<TodoDTO> list = TodoService.getList(); // 왜 바로 getList가 안될까?
        List<TodoDTO> list = TodoService.INSTANCE.getList(); // 왜 바로 getList가 안될까?
    }
}
